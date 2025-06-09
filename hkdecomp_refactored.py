#!/usr/bin/env python3
"""
HK89 Dial Decompressor - Python Version (Refactored)
Extracts dial information and images from HK89 smartwatch .bin files
Compatible with original hkdecomp v1.8

Based on reverse engineering analysis from Ghidra disassembly.
Refactored for better maintainability and readability.
"""

import os
import sys
import struct
from pathlib import Path
from PIL import Image
import argparse
import numpy as np

# Constants
MAX_MEMORY_SIZE = 0x12C000
MAX_TEXT_SIZE = 0x8000

class DialBlock:
    """Structure representing a dial block from the binary file"""
    def __init__(self, data):
        unpacked = struct.unpack('<I2B4H6B', data)
        self.picture_address = unpacked[0]
        self.picidx = unpacked[1]
        self.valami2 = unpacked[2]
        self.sx = unpacked[3]
        self.sy = unpacked[4]
        self.posX = unpacked[5]
        self.posY = unpacked[6]
        self.parts = unpacked[7]
        self.blocktype = unpacked[8]
        self.align = unpacked[9]
        self.compr = unpacked[10]
        self.centX = unpacked[11]
        self.centY = unpacked[12]

class BlockTypeManager:
    """Handles block type definitions and naming"""
    
    TYPE_NAMES = {
        0x01: "Preview", 0x02: "Background", 0x07: "Month", 0x08: "Day",
        0x09: "Hours", 0x0A: "Minutes", 0x0D: "DayOfWeek", 0x0E: "Steps",
        0x0F: "Pulse", 0x10: "Calory", 0x18: "BatteryStrip", 0x81: "Preview",
        0x82: "Background", 0x83: "ArmHour", 0x84: "ArmMin", 0x86: "Year",
        0x87: "Month", 0x88: "Day", 0x8A: "Minutes", 0x8B: "Battery",
        0x8C: "AMPM", 0x8D: "DayOfWeek", 0x8E: "Steps", 0x98: "BatteryStrip"
    }
    
    SHORT_NAMES = {
        0x01: "preview", 0x02: "background", 0x07: "month", 0x08: "day",
        0x09: "hours", 0x0A: "minutes", 0x0D: "dayofweek", 0x0E: "steps",
        0x0F: "pulse", 0x10: "calory", 0x18: "batterystrip", 0x81: "preview",
        0x82: "background", 0x83: "arm_hour", 0x84: "arm_minute", 0x86: "year",
        0x87: "month", 0x88: "day", 0x8A: "minutes", 0x8B: "battery",
        0x8C: "ampm", 0x8D: "dayofweek", 0x8E: "steps", 0x98: "batterystrip",
        0x13: "colon", 0x14: "dot", 0x15: "comma"
    }
    
    RGBA_TYPES = {0x81, 0x89, 0x8A, 0x8B, 0x8C, 0x8D, 0x82, 0x86, 0x87, 0x88, 0x8E, 0x98}
    
    DIGIT_TYPES = [
        0x09, 0x0A, 0x07, 0x08, 0x0D, 0x0E, 0x0F, 0x10, 0x18,
        0x8A, 0x8B, 0x8C, 0x87, 0x8E, 0x98, 0x8D, 0x88, 0x86
    ]
    
    SYMBOL_TYPES = {0x13: "colon", 0x14: "dot", 0x15: "comma"}
    
    TYPE_PREFIXES = {
        0x09: "hours", 0x0A: "minutes", 0x07: "month", 0x08: "day",
        0x0D: "dayofweek", 0x0E: "steps", 0x0F: "pulse", 0x10: "calory",
        0x18: "batterystrip", 0x8A: "minutes", 0x8B: "battery", 0x8C: "ampm",
        0x87: "month", 0x8E: "steps", 0x98: "batterystrip", 0x8D: "dayofweek",
        0x88: "day", 0x86: "year"
    }
    
    @classmethod
    def get_type_name(cls, block_type):
        return cls.TYPE_NAMES.get(block_type, "Unknown")
    
    @classmethod
    def get_short_name(cls, block_type, block_index):
        if block_type == 0x82:
            return f"background{block_index}"
        name = cls.SHORT_NAMES.get(block_type)
        return name if name else f"unknown_{block_index}"
    
    @classmethod
    def get_format(cls, block_type):
        return "RGBA" if block_type in cls.RGBA_TYPES else " RGB"
    
    @classmethod
    def is_digit_type(cls, block_type):
        return block_type in cls.DIGIT_TYPES
    
    @classmethod
    def is_symbol_type(cls, block_type):
        return block_type in cls.SYMBOL_TYPES
    
    @classmethod
    def get_type_prefix(cls, block_type):
        return cls.TYPE_PREFIXES.get(block_type, "unknown")

class ImageDecompressor:
    """Handles image decompression algorithms"""
    
    @staticmethod
    def decompress_hk89_rle(compressed_data, width, height, has_alpha=False):
        """Decompress HK89 RLE compressed image data"""
        if not compressed_data or len(compressed_data) < 4:
            return None
            
        expected_pixels = width * height
        bytes_per_pixel = 4 if has_alpha else 3
        output = bytearray(expected_pixels * bytes_per_pixel)
        
        input_pos = struct.unpack('<H', compressed_data[0:2])[0] if len(compressed_data) >= 2 else 2
        if input_pos >= len(compressed_data):
            input_pos = 2
            
        output_pos = 0
        pixels_written = 0
        
        try:
            for row in range(height):
                pixels_in_row = 0
                while pixels_in_row < width and pixels_written < expected_pixels:
                    if input_pos >= len(compressed_data):
                        ImageDecompressor._fill_remaining_pixels(
                            output, output_pos, width - pixels_in_row, 
                            expected_pixels - pixels_written, has_alpha
                        )
                        break
                        
                    count_byte = compressed_data[input_pos]
                    input_pos += 1
                    
                    if count_byte == 0:
                        # Single pixel
                        input_pos, output_pos, pixels_written, pixels_in_row = \
                            ImageDecompressor._process_single_pixel(
                                compressed_data, input_pos, output, output_pos,
                                pixels_written, pixels_in_row, has_alpha
                            )
                    elif count_byte & 0x80:
                        # RLE compressed
                        input_pos, output_pos, pixels_written, pixels_in_row = \
                            ImageDecompressor._process_rle_pixels(
                                compressed_data, input_pos, output, output_pos,
                                pixels_written, pixels_in_row, count_byte & 0x7F,
                                width, expected_pixels, has_alpha
                            )
                    else:
                        # Literal pixels
                        input_pos, output_pos, pixels_written, pixels_in_row = \
                            ImageDecompressor._process_literal_pixels(
                                compressed_data, input_pos, output, output_pos,
                                pixels_written, pixels_in_row, count_byte,
                                width, expected_pixels, has_alpha
                            )
            
            if pixels_written != expected_pixels:
                print(f"✗ Pixel count mismatch: {pixels_written}/{expected_pixels}")
                return None
                
            return bytes(output[:output_pos])
            
        except (IndexError, struct.error) as e:
            print(f"Decompression error: {e}")
            return None
    
    @staticmethod
    def _process_single_pixel(compressed_data, input_pos, output, output_pos, 
                             pixels_written, pixels_in_row, has_alpha):
        """Process a single pixel"""
        alpha = 255
        if has_alpha and input_pos < len(compressed_data):
            alpha = compressed_data[input_pos]
            input_pos += 1
        
        if input_pos + 1 >= len(compressed_data):
            return input_pos, output_pos, pixels_written, pixels_in_row
            
        r, g, b = ImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
        input_pos += 2
        
        output_pos = ImageDecompressor._write_pixel(output, output_pos, r, g, b, alpha, has_alpha)
        return input_pos, output_pos, pixels_written + 1, pixels_in_row + 1
    
    @staticmethod
    def _process_rle_pixels(compressed_data, input_pos, output, output_pos,
                           pixels_written, pixels_in_row, count, width, 
                           expected_pixels, has_alpha):
        """Process RLE compressed pixels"""
        if count == 0:
            return input_pos, output_pos, pixels_written, pixels_in_row
            
        alpha = 255
        if has_alpha and input_pos < len(compressed_data):
            alpha = compressed_data[input_pos]
            input_pos += 1
        
        if input_pos + 1 >= len(compressed_data):
            return input_pos, output_pos, pixels_written, pixels_in_row
            
        r, g, b = ImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
        input_pos += 2
        
        for _ in range(count):
            if pixels_in_row >= width or pixels_written >= expected_pixels:
                break
            output_pos = ImageDecompressor._write_pixel(output, output_pos, r, g, b, alpha, has_alpha)
            pixels_written += 1
            pixels_in_row += 1
            
        return input_pos, output_pos, pixels_written, pixels_in_row
    
    @staticmethod
    def _process_literal_pixels(compressed_data, input_pos, output, output_pos,
                               pixels_written, pixels_in_row, count, width,
                               expected_pixels, has_alpha):
        """Process literal pixels"""
        for _ in range(count):
            if pixels_in_row >= width or pixels_written >= expected_pixels:
                break
            alpha = 255
            if has_alpha and input_pos < len(compressed_data):
                alpha = compressed_data[input_pos]
                input_pos += 1
                
            if input_pos + 1 >= len(compressed_data):
                break
                
            r, g, b = ImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
            input_pos += 2
            
            output_pos = ImageDecompressor._write_pixel(output, output_pos, r, g, b, alpha, has_alpha)
            pixels_written += 1
            pixels_in_row += 1
            
        return input_pos, output_pos, pixels_written, pixels_in_row
    
    @staticmethod
    def _read_rgb565_pixel(compressed_data, input_pos):
        """Read and convert RGB565 pixel to RGB888"""
        high_byte = compressed_data[input_pos]
        low_byte = compressed_data[input_pos + 1]
        rgb565 = (high_byte << 8) | low_byte
        
        r = high_byte & 0xf8
        g = (rgb565 >> 3) & 0xfc
        b = (rgb565 << 3) & 0xff
        
        return r, g, b
    
    @staticmethod
    def _write_pixel(output, output_pos, r, g, b, alpha, has_alpha):
        """Write pixel to output buffer"""
        bytes_per_pixel = 4 if has_alpha else 3
        if output_pos + bytes_per_pixel <= len(output):
            output[output_pos] = r
            output[output_pos + 1] = g
            output[output_pos + 2] = b
            if has_alpha:
                output[output_pos + 3] = alpha
                return output_pos + 4
            else:
                return output_pos + 3
        return output_pos
    
    @staticmethod
    def _fill_remaining_pixels(output, output_pos, pixels_to_fill, max_pixels, has_alpha):
        """Fill remaining pixels with transparent black"""
        bytes_per_pixel = 4 if has_alpha else 3
        filled = 0
        while filled < pixels_to_fill and filled < max_pixels:
            if output_pos + bytes_per_pixel <= len(output):
                output[output_pos:output_pos + 3] = [0, 0, 0]
                if has_alpha:
                    output[output_pos + 3] = 0
                    output_pos += 4
                else:
                    output_pos += 3
                filled += 1
            else:
                break
    
    @staticmethod
    def decompress_raw_aligned(compressed_data, width, height, has_alpha):
        """Decompress RAW aligned image data for arm_hour and arm_minute"""
        bytes_per_pixel = 3 if has_alpha else 2
        row_bytes = width * bytes_per_pixel
        aligned_row_bytes = (row_bytes + 3) & ~3
        dst = np.zeros((height, width, 4 if has_alpha else 3), np.uint8)
        
        for row in range(height):
            row_start = row * aligned_row_bytes
            for col in range(width):
                base = row_start + col * bytes_per_pixel
                if has_alpha:
                    a = compressed_data[base]
                    b1 = compressed_data[base + 1]
                    b2 = compressed_data[base + 2]
                else:
                    b1 = compressed_data[base]
                    b2 = compressed_data[base + 1]
                    a = 255
                
                rgb565 = b1 | (b2 << 8)
                r = ((rgb565 >> 11) & 0x1F) * 255 // 31
                g = ((rgb565 >> 5) & 0x3F) * 255 // 63
                b = (rgb565 & 0x1F) * 255 // 31
                
                if has_alpha:
                    dst[row, col] = (r, g, b, a)
                else:
                    dst[row, col] = (r, g, b)
        
        return dst.tobytes()

class ImageWriter:
    """Handles PNG file writing"""
    
    @staticmethod
    def write_png(filename, image_data, width, height):
        """Write PNG file using PIL"""
        try:
            bytes_per_pixel = len(image_data) // (width * height)
            
            if bytes_per_pixel == 4:
                img = Image.frombytes('RGBA', (width, height), image_data[:width * height * 4])
            elif bytes_per_pixel == 3:
                rgba_data = bytearray()
                for i in range(0, len(image_data), 3):
                    if i + 2 < len(image_data):
                        rgba_data.extend([image_data[i], image_data[i+1], image_data[i+2], 255])
                img = Image.frombytes('RGBA', (width, height), bytes(rgba_data))
            else:
                print(f"Unsupported pixel format: {bytes_per_pixel} bytes per pixel")
                return False
                
            img.save(filename)
            print(f"✓ Saved: {filename} ({width}x{height})")
            return True
        except Exception as e:
            print(f"✗ Error saving PNG {filename}: {e}")
            return False
    
    @staticmethod
    def write_raw_backup(filename, data):
        """Write raw data as backup"""
        try:
            with open(f"{filename}.bin", 'wb') as f:
                f.write(data)
            print(f"⚠ Wrote raw data: {filename}.bin")
        except Exception as e:
            print(f"✗ Error writing raw file: {e}")

class HKDecompressor:
    """Main decompressor class"""
    
    def __init__(self):
        self.main_buffer = None
        self.filename = None
        self.block_count = 0
        self.file_size = 0
        self.picture_sizes = [0] * 256
        self.blocks = []
        
    def load_file(self, filename):
        """Load and validate binary file"""
        self.filename = filename
        
        if not os.path.exists(filename):
            print(f"No such file! ({filename})")
            return False
        
        self.file_size = os.path.getsize(filename)
        if self.file_size > MAX_MEMORY_SIZE:
            print("File too large")
            return False
        
        try:
            with open(filename, 'rb') as f:
                self.main_buffer = f.read()
        except Exception as e:
            print(f"Error reading file: {e}")
            return False
        
        if len(self.main_buffer) < 3:
            print("File too small")
            return False
        
        self.block_count = self.main_buffer[2]
        return True
    
    def parse_blocks(self):
        """Parse all blocks from the binary file"""
        self.blocks = []
        for i in range(self.block_count):
            block_data = self.main_buffer[4 + (i * 20):4 + ((i + 1) * 20)]
            block = DialBlock(block_data)
            self.blocks.append(block)
    
    def calculate_picture_sizes(self):
        """Calculate the size of each picture based on addresses"""
        self.picture_sizes = [0] * 256
        
        for block in self.blocks:
            start_addr = block.picture_address
            end_addr = self.file_size
            
            for other_block in self.blocks:
                if start_addr < other_block.picture_address < end_addr:
                    end_addr = other_block.picture_address
            
            self.picture_sizes[block.picidx] = end_addr - start_addr
    
    def extract_single_image(self, block, output_dir, filename_override=None):
        """Extract a single image from a block"""
        block_index = self.blocks.index(block) + 1
        filename = filename_override or BlockTypeManager.get_short_name(block.blocktype, block_index)
        has_alpha = (block.blocktype & 0x80) != 0 or block.blocktype == 0x8C
        
        # Handle RAW format for arm images
        if block.blocktype in (0x83, 0x84) and block.compr == 0:
            compressed_data = self.main_buffer[
                block.picture_address:block.picture_address + self.picture_sizes[block.picidx]
            ]
            image_data = ImageDecompressor.decompress_raw_aligned(
                compressed_data, block.sx, block.sy, has_alpha
            )
            return ImageWriter.write_png(f"{output_dir}/{filename}.png", image_data, block.sx, block.sy)
        
        # Handle compressed images
        if self.picture_sizes[block.picidx] > 0:
            compressed_data = self.main_buffer[
                block.picture_address:block.picture_address + self.picture_sizes[block.picidx]
            ]
            decompressed_data = ImageDecompressor.decompress_hk89_rle(
                compressed_data, block.sx, block.sy, has_alpha
            )
            
            if decompressed_data and ImageWriter.write_png(f"{output_dir}/{filename}.png", 
                                                          decompressed_data, block.sx, block.sy):
                return True
            else:
                ImageWriter.write_raw_backup(f"{output_dir}/{filename}", compressed_data)
                return False
        
        return False
    
    def extract_multi_part_images(self, block, output_dir):
        """Extract multi-part images (digits and symbols)"""
        type_prefix = BlockTypeManager.get_type_prefix(block.blocktype)
        has_alpha = (block.blocktype & 0x80) != 0 or block.blocktype == 0x8C
        current_offset = 0
        
        for i in range(block.parts):
            # Generate filename based on part index
            if i < 10:
                filename = f"{output_dir}/chr_{type_prefix}_{i}.png"
            elif i == 10:
                filename = f"{output_dir}/chr_{type_prefix}_colon.png"
            elif i == 11:
                filename = f"{output_dir}/chr_{type_prefix}_dot.png"
            elif i == 12:
                filename = f"{output_dir}/chr_{type_prefix}_comma.png"
            else:
                filename = f"{output_dir}/chr_{type_prefix}_extra{i}.png"
              # Extract image data
            start_pos = block.picture_address + current_offset
            available_data = self.picture_sizes[block.picidx] - current_offset
            compressed_data = self.main_buffer[start_pos:start_pos + available_data]
            
            result, bytes_consumed = self._decompress_until_pixels(
                compressed_data, block.sx, block.sy, has_alpha
            )
            
            if result is None:
                print(f"✗ Error: Failed to decompress part {i} of {type_prefix}")
                continue
            
            ImageWriter.write_png(filename, result, block.sx, block.sy)
            current_offset += bytes_consumed
            
            # Align to 4 bytes and skip filler
            current_offset = self._align_and_skip_filler(block.picture_address, current_offset, block.picidx)
    
    def _decompress_until_pixels(self, compressed_data, width, height, has_alpha=False):
        """Decompress until exact pixel count is reached"""
        expected_pixels = width * height
        bytes_per_pixel = 4 if has_alpha else 3
        output = bytearray(expected_pixels * bytes_per_pixel)
        
        input_pos = struct.unpack('<H', compressed_data[0:2])[0] if len(compressed_data) >= 2 else 2
        if input_pos >= len(compressed_data):
            input_pos = 2
        
        output_pos = 0
        pixels_written = 0
        
        try:
            for row in range(height):
                pixels_in_row = 0
                while pixels_in_row < width and pixels_written < expected_pixels:
                    if input_pos >= len(compressed_data):
                        break
                    
                    count_byte = compressed_data[input_pos]
                    input_pos += 1
                    
                    if count_byte == 0:
                        input_pos, output_pos, pixels_written, pixels_in_row = \
                            self._process_single_pixel_until(
                                compressed_data, input_pos, output, output_pos,
                                pixels_written, pixels_in_row, has_alpha
                            )
                    elif count_byte & 0x80:
                        input_pos, output_pos, pixels_written, pixels_in_row = \
                            self._process_rle_pixels_until(
                                compressed_data, input_pos, output, output_pos,
                                pixels_written, pixels_in_row, count_byte & 0x7F,
                                width, expected_pixels, has_alpha
                            )
                    else:
                        input_pos, output_pos, pixels_written, pixels_in_row = \
                            self._process_literal_pixels_until(
                                compressed_data, input_pos, output, output_pos,
                                pixels_written, pixels_in_row, count_byte,
                                width, expected_pixels, has_alpha
                            )
            
            if pixels_written != expected_pixels:
                return None, input_pos
            
            return bytes(output[:output_pos]), input_pos
            
        except Exception as e:
            print(f"Error in _decompress_until_pixels: {e}")
            return None, input_pos
    
    def _process_single_pixel_until(self, compressed_data, input_pos, output, output_pos, 
                                   pixels_written, pixels_in_row, has_alpha):
        """Helper for single pixel processing in until_pixels"""
        alpha = 255
        if has_alpha and input_pos < len(compressed_data):
            alpha = compressed_data[input_pos]
            input_pos += 1
        
        if input_pos + 1 >= len(compressed_data):
            return input_pos, output_pos, pixels_written, pixels_in_row
        
        r, g, b = ImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
        input_pos += 2
        
        output_pos = ImageDecompressor._write_pixel(output, output_pos, r, g, b, alpha, has_alpha)
        return input_pos, output_pos, pixels_written + 1, pixels_in_row + 1
    
    def _process_rle_pixels_until(self, compressed_data, input_pos, output, output_pos,
                                 pixels_written, pixels_in_row, count, width, 
                                 expected_pixels, has_alpha):
        """Helper for RLE pixel processing in until_pixels"""
        if count == 0:
            return input_pos, output_pos, pixels_written, pixels_in_row
        
        alpha = 255
        if has_alpha and input_pos < len(compressed_data):
            alpha = compressed_data[input_pos]
            input_pos += 1
        
        if input_pos + 1 >= len(compressed_data):
            return input_pos, output_pos, pixels_written, pixels_in_row
        
        r, g, b = ImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
        input_pos += 2
        
        for _ in range(count):
            if pixels_in_row >= width or pixels_written >= expected_pixels:
                break
            output_pos = ImageDecompressor._write_pixel(output, output_pos, r, g, b, alpha, has_alpha)
            pixels_written += 1
            pixels_in_row += 1
        
        return input_pos, output_pos, pixels_written, pixels_in_row
    
    def _process_literal_pixels_until(self, compressed_data, input_pos, output, output_pos,
                                     pixels_written, pixels_in_row, count, width,
                                     expected_pixels, has_alpha):
        """Helper for literal pixel processing in until_pixels"""
        for _ in range(count):
            if pixels_in_row >= width or pixels_written >= expected_pixels:
                break
            
            alpha = 255
            if has_alpha and input_pos < len(compressed_data):
                alpha = compressed_data[input_pos]
                input_pos += 1
            
            if input_pos + 1 >= len(compressed_data):
                break
            
            r, g, b = ImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
            input_pos += 2
            
            output_pos = ImageDecompressor._write_pixel(output, output_pos, r, g, b, alpha, has_alpha)
            pixels_written += 1
            pixels_in_row += 1
        
        return input_pos, output_pos, pixels_written, pixels_in_row

    def _align_and_skip_filler(self, base_address, current_offset, picidx):
        """Align to 4 bytes and skip filler bytes"""
        if current_offset % 4 != 0:
            current_offset += 4 - (current_offset % 4)
        
        # Bounds check for picidx
        if picidx < 0 or picidx >= len(self.picture_sizes):
            return current_offset
            
        picture_size = self.picture_sizes[picidx]
        while (current_offset < picture_size and 
               base_address + current_offset < len(self.main_buffer)):
            b = self.main_buffer[base_address + current_offset]
            if b not in (0x00, 0xFF):
                break
            current_offset += 1
        
        return current_offset
    
    def extract_all_images(self, output_dir):
        """Extract all images from the binary file"""
        processed_multi_part_addresses = set()
        
        for i, block in enumerate(self.blocks):
            block_index = i + 1
            
            # Handle symbol blocks
            if BlockTypeManager.is_symbol_type(block.blocktype):
                symbol_name = BlockTypeManager.SYMBOL_TYPES[block.blocktype]
                self.extract_single_image(block, output_dir, symbol_name)
                continue
            
            # Handle multi-part blocks (digits)
            if block.parts > 1:
                key = (block.picture_address, block.sx, block.sy, block.parts)
                
                if key in processed_multi_part_addresses:
                    continue
                
                if BlockTypeManager.is_digit_type(block.blocktype):
                    processed_multi_part_addresses.add(key)
                    self.extract_multi_part_images(block, output_dir)
                else:
                    # Check for duplicates with known digit types
                    has_digit_duplicate = any(
                        BlockTypeManager.is_digit_type(other.blocktype) and
                        (other.picture_address, other.sx, other.sy, other.parts) == key
                        for other in self.blocks[i+1:]
                    )
                    
                    if not has_digit_duplicate:
                        self.extract_single_image(block, output_dir)
                continue
            
            # Handle single images
            short_name = BlockTypeManager.get_short_name(block.blocktype, block_index)
            if (block.parts == 1 and short_name.startswith("unknown") and 
                block.sx <= 32 and block.sy <= 40):
                short_name = f"symbol_{block_index}"
            
            self.extract_single_image(block, output_dir, short_name)
    
    def print_block_info(self):
        """Print detailed information about all blocks"""
        for i, block in enumerate(self.blocks):
            block_index = i + 1
            print(f"Block {block_index:2d}.")
            print(f"    0x{block.blocktype:02X} type: {BlockTypeManager.get_type_name(block.blocktype)} "
                  f"{BlockTypeManager.get_format(block.blocktype)} "
                  f"({BlockTypeManager.get_short_name(block.blocktype, block_index)})")
            print(f"    0x{block.picture_address:08X}    ({block.picture_address:7d}) picture address")
            print(f"    0x{block.picidx:02X},0x{block.valami2:02X}     "
                  f"({block.picidx:3d},{block.valami2:3d}) picidx,valami2")
            print(f"    0x{block.sx:04X},0x{block.sy:04X} ({block.sx:3d},{block.sy:3d}) sx,sy")
            print(f"    0x{block.posX:04X},0x{block.posY:04X} ({block.posX:3d},{block.posY:3d}) posX,posY")
            print(f"    0x{block.parts:02X},0x{block.blocktype:02X}     "
                  f"({block.parts:3d},{block.blocktype:3d}) parts,blocktype")
            print(f"    0x{block.align:02X},0x{block.compr:02X},0x{block.centX:02X},0x{block.centY:02X} "
                  f"({block.align:3d},{block.compr:3d},{block.centX:3d},{block.centY:3d}) align,compr,centX,centY")
    
    def save_block_info(self, output_dir):
        """Save detailed block information to file"""
        output_file = f"{output_dir}/block_all.txt"
        
        try:
            with open(output_file, 'w') as f:
                f.write(f"Number of block = {self.block_count} , (0x{self.block_count:04X})\n")
                
                block_table_size = struct.unpack('<H', self.main_buffer[0:2])[0]
                f.write(f"Size of pltable = {block_table_size} , (0x{block_table_size:04X})\n\n")
                
                # Write picture sizes
                total_bytes = 0
                for i in range(0, 79, 8):
                    for j in range(8):
                        if i + j < 79:
                            size = self.picture_sizes[i + j] if self.picture_sizes[i + j] > 0 else 0
                            f.write(f"{i+j:2d}.={size:5d} byte, ")
                            total_bytes += size
                    f.write("\n")
                f.write(f"summa={total_bytes} byte\n\n")
                
                # Write hex sizes
                for i in range(0, 79, 8):
                    for j in range(8):
                        if i + j < 79:
                            f.write(f"{i+j:2d}.={self.picture_sizes[i+j]:08X}, ")
                    f.write("\n")
                f.write(f"summa=0x{total_bytes:X} byte\n")
                
                # Write block information
                for i, block in enumerate(self.blocks):
                    block_index = i + 1
                    f.write(f"Block {block_index:2d}.\n")
                    f.write(f"    0x{block.blocktype:02X} type: {BlockTypeManager.get_type_name(block.blocktype)} "
                           f"{BlockTypeManager.get_format(block.blocktype)} "
                           f"({BlockTypeManager.get_short_name(block.blocktype, block_index)})\n")
                    f.write(f"    0x{block.picture_address:08X}    ({block.picture_address:7d}) picture address\n")
                    f.write(f"    0x{block.picidx:02X},0x{block.valami2:02X}     "
                           f"({block.picidx:3d},{block.valami2:3d}) picidx,valami2\n")
                    f.write(f"    0x{block.sx:04X},0x{block.sy:04X} ({block.sx:3d},{block.sy:3d}) sx,sy\n")
                    f.write(f"    0x{block.posX:04X},0x{block.posY:04X} ({block.posX:3d},{block.posY:3d}) posX,posY\n")
                    f.write(f"    0x{block.parts:02X},0x{block.blocktype:02X}     "
                           f"({block.parts:3d},{block.blocktype:3d}) parts,blocktype\n")
                    f.write(f"    0x{block.align:02X},0x{block.compr:02X},0x{block.centX:02X},0x{block.centY:02X} "
                           f"({block.align:3d},{block.compr:3d},{block.centX:3d},{block.centY:3d}) align,compr,centX,centY\n")
        except Exception as e:
            print(f"Error writing output file: {e}")
    
    def process(self, filename):
        """Main processing function"""
        print("HK89 dial decompressor v1.8 (Python - Refactored)")
        
        base_filename = Path(filename).name
        print(f"----------- {base_filename} -----------")
        
        if not self.load_file(filename):
            return False
        
        self.parse_blocks()
        
        print(f"Number of block = {self.block_count} , (0x{self.block_count:04X})")
        block_table_size = struct.unpack('<H', self.main_buffer[0:2])[0]
        print(f"Size of pltable = {block_table_size} , (0x{block_table_size:04X})")
        
        self.calculate_picture_sizes()
        
        # Create output directory
        basename = Path(filename).stem
        output_dir = f"_{basename}"
        os.makedirs(output_dir, exist_ok=True)
        
        # Extract images
        self.extract_all_images(output_dir)
        
        # Print and save block information
        self.print_block_info()
        self.save_block_info(output_dir)
        
        return True

def main():
    """Main function"""
    parser = argparse.ArgumentParser(description='HK89 Dial Decompressor - Python Version (Refactored)')
    parser.add_argument('filename', help='.bin file to decompress')
    
    args = parser.parse_args()
    
    decompressor = HKDecompressor()
    if not decompressor.process(args.filename):
        sys.exit(1)

if __name__ == "__main__":
    main()

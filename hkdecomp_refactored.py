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
        # Basic types
        0x01: "Preview", 0x02: "Background", 0x03: "ArmHour", 0x04: "ArmMinute",
        0x05: "ArmSecond", 0x06: "Year", 0x07: "Month", 0x08: "Day",
        0x09: "Hours", 0x0A: "Minutes", 0x0B: "Seconds", 0x0C: "AMPM",
        0x0D: "DayOfWeek", 0x0E: "Steps", 0x0F: "Pulse", 0x10: "Calory",
        0x11: "Distance", 0x12: "BatteryNumber", 0x13: "Colon", 0x14: "Dot",
        0x15: "Comma", 0x16: "Berry", 0x17: "Animation", 0x18: "BatteryStrip",
        0x19: "Weather", 0x1A: "Temperature", 0x1B: "Unknown1B", 0x1C: "Unknown1C",
        0x1D: "Unknown1D", 0x1E: "Unknown1E", 0x1F: "Unknown1F",
        # HK26/HK89 specific
        0x27: "HourHigh", 0x28: "HourLow", 0x29: "MinuteHigh", 0x2A: "MinuteLow",
        # Extended types (0x80+)
        0x81: "Preview", 0x82: "Background", 0x83: "ArmHour", 0x84: "ArmMin", 
        0x85: "ArmSecond", 0x86: "Year", 0x87: "Month", 0x88: "Day",
        0x89: "Hours", 0x8A: "Minutes", 0x8B: "Battery", 0x8C: "AMPM",
        0x8D: "DayOfWeek", 0x8E: "Steps", 0x8F: "Pulse", 0x90: "Calory",
        0x91: "Distance", 0x92: "BatteryNumber", 0x96: "Berry", 0x97: "Animation",
        0x98: "BatteryStrip", 0x99: "Weather", 0x9A: "Temperature"
    }
    SHORT_NAMES = {
        # Basic types
        0x01: "preview", 0x02: "background", 0x03: "arm_hour", 0x04: "arm_minute", 
        0x05: "arm_second", 0x06: "year", 0x07: "month", 0x08: "day",
        0x09: "hours", 0x0A: "minutes", 0x0B: "seconds", 0x0C: "ampm",
        0x0D: "dayofweek", 0x0E: "steps", 0x0F: "pulse", 0x10: "calory",
        0x11: "distance", 0x12: "battery_number", 0x13: "colon", 0x14: "dot",
        0x15: "comma", 0x16: "berry", 0x17: "animation", 0x18: "batterystrip",
        0x19: "weather", 0x1A: "temperature",
        # HK26/HK89 specific
        0x27: "hour_high", 0x28: "hour_low", 0x29: "minute_high", 0x2A: "minute_low",
        # Extended types (0x80+)
        0x81: "preview", 0x82: "background", 0x83: "arm_hour", 0x84: "arm_minute", 
        0x85: "arm_second", 0x86: "year", 0x87: "month", 0x88: "day",
        0x89: "hours", 0x8A: "minutes", 0x8B: "battery", 0x8C: "ampm",
        0x8D: "dayofweek", 0x8E: "steps", 0x8F: "pulse", 0x90: "calory",
        0x91: "distance", 0x92: "battery_number", 0x96: "berry", 0x97: "animation",
        0x98: "batterystrip", 0x99: "weather", 0x9A: "temperature"
    }
    
    RGBA_TYPES = {
        0x81, 0x82, 0x83, 0x84, 0x85, 0x86, 0x87, 0x88, 0x89, 0x8A, 0x8B, 0x8C, 
        0x8D, 0x8E, 0x8F, 0x90, 0x91, 0x92, 0x96, 0x97, 0x98, 0x99, 0x9A
    }
    DIGIT_TYPES = [
        # Basic digit types
        0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0E, 0x0F, 
        0x10, 0x11, 0x12, 0x18, 0x19, 0x1A, 0x27, 0x28, 0x29, 0x2A,
        # Extended digit types (0x80+)
        0x83, 0x84, 0x85, 0x86, 0x87, 0x88, 0x89, 0x8A, 0x8B, 0x8C, 0x8D, 0x8E, 
        0x8F, 0x90, 0x91, 0x92, 0x98, 0x99, 0x9A
    ]
    
    SYMBOL_TYPES = {
        0x13: "colon", 0x14: "dot", 0x15: "comma", 0x16: "berry", 0x17: "animation",
        0x96: "berry", 0x97: "animation"
    }
    TYPE_PREFIXES = {
        # Basic types
        0x03: "arm_hour", 0x04: "arm_minute", 0x05: "arm_second", 0x06: "year",
        0x07: "month", 0x08: "day", 0x09: "hours", 0x0A: "minutes", 0x0B: "seconds",
        0x0C: "ampm", 0x0E: "steps", 0x0F: "pulse", 0x10: "calory", 0x11: "distance",
        0x12: "battery_number", 0x18: "batterystrip", 0x19: "weather", 0x1A: "temperature",
        0x27: "hour_high", 0x28: "hour_low", 0x29: "minute_high", 0x2A: "minute_low",
        # Extended types
        0x83: "arm_hour", 0x84: "arm_minute", 0x85: "arm_second", 0x86: "year",
        0x87: "month", 0x88: "day", 0x89: "hours", 0x8A: "minutes", 0x8B: "battery",
        0x8C: "ampm", 0x8D: "dayofweek", 0x8E: "steps", 0x8F: "pulse", 0x90: "calory",
        0x91: "distance", 0x92: "battery_number", 0x98: "batterystrip", 0x99: "weather",
        0x9A: "temperature"
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
        
        # Create sorted list of unique addresses
        addresses = []
        for block in self.blocks:
            if block.picture_address < self.file_size:
                addresses.append((block.picture_address, block.picidx))
        
        addresses.sort()
        
        # Calculate sizes based on next address
        for i, (start_addr, picidx) in enumerate(addresses):
            if i + 1 < len(addresses):
                end_addr = addresses[i + 1][0]
            else:
                end_addr = self.file_size
            
            self.picture_sizes[picidx] = end_addr - start_addr
    
    def detect_animations(self):
        """Detect animation sequences based on similar blocks"""
        animations = []
        processed_blocks = set()
        
        for i, block in enumerate(self.blocks):
            if i in processed_blocks:
                continue
                
            # Look for animation blocks (type 0x17 or 0x97)
            if block.blocktype in (0x17, 0x97):
                animation_sequence = [i]
                processed_blocks.add(i)
                
                # Look for similar blocks that might be part of same animation
                for j, other_block in enumerate(self.blocks[i+1:], i+1):
                    if (other_block.blocktype == block.blocktype and
                        other_block.sx == block.sx and
                        other_block.sy == block.sy and
                        abs(other_block.posX - block.posX) <= 5 and
                        abs(other_block.posY - block.posY) <= 5):
                        animation_sequence.append(j)
                        processed_blocks.add(j)
                
                if len(animation_sequence) > 1:
                    animations.append({
                        'type': 'explicit_animation',
                        'blocks': animation_sequence,
                        'size': (block.sx, block.sy),
                        'position': (block.posX, block.posY)
                    })
            
            # Look for sequential similar blocks (potential animations)
            elif block.blocktype not in (0x01, 0x02):  # Skip preview and background
                similar_sequence = [i]
                
                for j in range(i+1, min(i+10, len(self.blocks))):  # Look ahead max 10 blocks
                    other_block = self.blocks[j]
                    
                    if (other_block.blocktype == block.blocktype and
                        other_block.sx == block.sx and
                        other_block.sy == block.sy and
                        abs(other_block.posX - block.posX) <= 2 and
                        abs(other_block.posY - block.posY) <= 2):
                        similar_sequence.append(j)
                        processed_blocks.add(j)
                    else:
                        break
                
                if len(similar_sequence) >= 3:  # At least 3 frames for animation
                    animations.append({
                        'type': 'sequential_animation',
                        'blocks': similar_sequence,
                        'size': (block.sx, block.sy),
                        'position': (block.posX, block.posY),
                        'block_type': block.blocktype
                    })
                    for idx in similar_sequence:
                        processed_blocks.add(idx)
        
        return animations
    def extract_single_image(self, block, output_dir, filename_override=None):
        """Extract a single image from a block"""
        block_index = self.blocks.index(block) + 1
        filename = filename_override or BlockTypeManager.get_short_name(block.blocktype, block_index)
        has_alpha = (block.blocktype & 0x80) != 0 or block.blocktype == 0x8C
        
        # Validate block data
        if block.picture_address >= self.file_size:
            print(f"⚠ Block {block_index}: Picture address 0x{block.picture_address:08X} beyond file size")
            return False
        
        if self.picture_sizes[block.picidx] <= 0:
            print(f"⚠ Block {block_index}: Invalid picture size {self.picture_sizes[block.picidx]}")
            return False
        
        # Ensure we don't read beyond file bounds
        available_bytes = self.file_size - block.picture_address
        actual_size = min(self.picture_sizes[block.picidx], available_bytes)
        
        if actual_size <= 0:
            print(f"⚠ Block {block_index}: No data available at address 0x{block.picture_address:08X}")
            return False
        
        # Handle RAW format for arm images
        if block.blocktype in (0x83, 0x84) and block.compr == 0:
            compressed_data = self.main_buffer[block.picture_address:block.picture_address + actual_size]
            image_data = ImageDecompressor.decompress_raw_aligned(
                compressed_data, block.sx, block.sy, has_alpha
            )
            return ImageWriter.write_png(f"{output_dir}/{filename}.png", image_data, block.sx, block.sy)
        
        # Handle compressed images
        compressed_data = self.main_buffer[block.picture_address:block.picture_address + actual_size]
        decompressed_data = ImageDecompressor.decompress_hk89_rle(
            compressed_data, block.sx, block.sy, has_alpha
        )
        
        if decompressed_data and ImageWriter.write_png(f"{output_dir}/{filename}.png", 
                                                      decompressed_data, block.sx, block.sy):
            return True
        else:
            ImageWriter.write_raw_backup(f"{output_dir}/{filename}", compressed_data)
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
    
    def extract_animations(self, output_dir):
        """Extract detected animation sequences"""
        animations = self.detect_animations()
        
        if not animations:
            print("No animations detected")
            return
        
        print(f"\n=== EXTRACTING {len(animations)} ANIMATION SEQUENCES ===")
        
        animations_dir = f"{output_dir}/animations"
        os.makedirs(animations_dir, exist_ok=True)
        
        for anim_idx, animation in enumerate(animations):
            anim_name = f"animation_{anim_idx + 1}"
            anim_type = animation['type']
            blocks = animation['blocks']
            size = animation['size']
            position = animation['position']
            
            print(f"\nAnimation {anim_idx + 1}: {anim_type}")
            print(f"  Blocks: {blocks}")
            print(f"  Size: {size[0]}x{size[1]} at position ({position[0]}, {position[1]})")
            
            # Create subdirectory for this animation
            anim_subdir = f"{animations_dir}/{anim_name}"
            os.makedirs(anim_subdir, exist_ok=True)
            
            # Extract each frame
            for frame_idx, block_idx in enumerate(blocks):
                block = self.blocks[block_idx]
                frame_name = f"frame_{frame_idx:03d}"
                
                if self.extract_single_image(block, anim_subdir, frame_name):
                    print(f"  ✓ Extracted frame {frame_idx + 1}/{len(blocks)}: {frame_name}.png")
                else:
                    print(f"  ✗ Failed to extract frame {frame_idx + 1}: {frame_name}")
            
            # Save animation metadata
            metadata = {
                'name': anim_name,
                'type': anim_type,
                'frames': len(blocks),
                'size': {'width': size[0], 'height': size[1]},
                'position': {'x': position[0], 'y': position[1]},
                'blocks': blocks
            }
            
            if 'block_type' in animation:
                metadata['block_type'] = f"0x{animation['block_type']:02X}"
            
            try:
                import json
                with open(f"{anim_subdir}/animation_info.json", 'w') as f:
                    json.dump(metadata, f, indent=2)
            except Exception as e:
                print(f"  ⚠ Failed to save animation metadata: {e}")

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
        print("\n=== EXTRACTING INDIVIDUAL IMAGES ===")
        self.extract_all_images(output_dir)
        
        # Detect and extract animations
        print("\n=== DETECTING AND EXTRACTING ANIMATIONS ===")
        self.extract_animations(output_dir)
        
        # Realizar análisis profundo para encontrar datos adicionales
        print("\n" + "="*60)
        print("INICIANDO ANÁLISIS PROFUNDO DEL ARCHIVO")
        print("="*60)
        
        try:
            # Analizar estructura completa del archivo
            self.analyze_file_structure(output_dir)
            
            # Extraer datos adicionales encontrados
            self.extract_additional_data(output_dir)
            
        except Exception as e:
            print(f"⚠ Error durante análisis profundo: {e}")
            print("Continuando con extracción normal...")
        
        print("\n" + "="*60)
        print("ANÁLISIS PROFUNDO COMPLETADO")
        print("="*60)
        
        # Print and save block information
        self.print_block_info()
        self.save_block_info(output_dir)
        
        return True

    def analyze_file_structure(self, output_dir):
        """Analyze the complete file structure to find potential missed blocks"""
        print("\n=== ANÁLISIS PROFUNDO DE ESTRUCTURA ===")
        
        # Analizar el header completo
        self._analyze_header()
        
        # Buscar bloques adicionales más allá del count oficial
        self._find_additional_blocks()
        
        # Analizar espacios no utilizados
        self._analyze_unused_space()
        
        # Buscar patrones de imágenes potenciales
        self._find_potential_images()
        
        # Buscar datos de texto/configuración
        self._find_text_data()
        
        # Generar mapa de memoria
        self._generate_memory_map(output_dir)
    
    def _analyze_header(self):
        """Analyze the file header in detail"""
        print("\n--- ANÁLISIS DE HEADER ---")
        if len(self.main_buffer) < 16:
            print("Header demasiado pequeño")
            return
            
        # Mostrar los primeros 32 bytes en hexadecimal
        print("Primeros 32 bytes:")
        for i in range(0, min(32, len(self.main_buffer)), 16):
            hex_part = " ".join(f"{b:02X}" for b in self.main_buffer[i:i+16])
            ascii_part = "".join(chr(b) if 32 <= b <= 126 else "." for b in self.main_buffer[i:i+16])
            print(f"{i:04X}: {hex_part:<48} {ascii_part}")
        
        # Analizar valores del header
        if len(self.main_buffer) >= 4:
            table_size = struct.unpack('<H', self.main_buffer[0:2])[0]
            print(f"Tamaño de tabla: {table_size} (0x{table_size:04X})")
            print(f"Número de bloques oficial: {self.block_count}")
            
            # Verificar si hay más bloques de los reportados
            expected_table_end = 4 + (self.block_count * 20)
            print(f"Fin esperado de tabla: 0x{expected_table_end:04X}")
            
            if table_size != expected_table_end - 4:
                print(f"⚠ ADVERTENCIA: Tamaño de tabla no coincide con número de bloques")
                print(f"  Esperado: {expected_table_end - 4}, Encontrado: {table_size}")
    
    def _find_additional_blocks(self):
        """Look for additional blocks beyond the official count"""
        print("\n--- BÚSQUEDA DE BLOQUES ADICIONALES ---")
        
        # Calcular donde debería terminar la tabla oficial
        official_table_end = 4 + (self.block_count * 20)
        
        # Buscar patrones de bloques después del final oficial
        potential_blocks = []
        search_start = official_table_end
        search_end = min(official_table_end + 1000, len(self.main_buffer))  # Buscar en los próximos 1KB
        
        for offset in range(search_start, search_end - 20, 4):  # Alineado a 4 bytes
            try:
                # Intentar parsear como bloque
                block_data = self.main_buffer[offset:offset + 20]
                if len(block_data) == 20:
                    # Verificar si parece un bloque válido
                    blocktype = block_data[0]
                    picture_address = struct.unpack('<I', block_data[1:5])[0]
                    sx = struct.unpack('<H', block_data[7:9])[0]
                    sy = struct.unpack('<H', block_data[9:11])[0]
                    
                    # Criterios para considerar un bloque válido
                    if (0 < blocktype < 256 and 
                        1000 < picture_address < self.file_size and
                        1 <= sx <= 1000 and 1 <= sy <= 1000):
                        potential_blocks.append((offset, blocktype, picture_address, sx, sy))
                        
            except (struct.error, IndexError):
                continue
        
        if potential_blocks:
            print(f"Encontrados {len(potential_blocks)} bloques potenciales adicionales:")
            for offset, blocktype, addr, sx, sy in potential_blocks:
                print(f"  Offset 0x{offset:04X}: Tipo 0x{blocktype:02X}, Addr 0x{addr:08X}, Size {sx}x{sy}")
        else:
            print("No se encontraron bloques adicionales obvios")
    
    def _analyze_unused_space(self):
        """Analyze unused space in the file"""
        print("\n--- ANÁLISIS DE ESPACIOS NO UTILIZADOS ---")
        
        # Crear mapa de uso de memoria
        used_ranges = []
        
        # Agregar tabla de bloques
        table_end = 4 + (self.block_count * 20)
        used_ranges.append((0, table_end, "Block Table"))
        
        # Agregar rangos de imágenes
        for i, block in enumerate(self.blocks):
            if self.picture_sizes[block.picidx] > 0:
                start = block.picture_address
                end = start + self.picture_sizes[block.picidx]
                used_ranges.append((start, end, f"Block {i+1} (Type 0x{block.blocktype:02X})"))
        
        # Ordenar por dirección
        used_ranges.sort()
        
        # Encontrar espacios no utilizados
        gaps = []
        for i in range(len(used_ranges) - 1):
            current_end = used_ranges[i][1]
            next_start = used_ranges[i + 1][0]
            if current_end < next_start:
                gap_size = next_start - current_end
                if gap_size > 16:  # Solo reportar gaps significativos
                    gaps.append((current_end, next_start, gap_size))
        
        # Verificar espacio al final
        if used_ranges:
            last_used = max(used_ranges, key=lambda x: x[1])[1]
            if last_used < self.file_size:
                gap_size = self.file_size - last_used
                gaps.append((last_used, self.file_size, gap_size))
        
        if gaps:
            print("Espacios no utilizados encontrados:")
            for start, end, size in gaps:
                print(f"  0x{start:08X} - 0x{end:08X} ({size} bytes)")
                # Mostrar una muestra del contenido
                sample_size = min(32, size)
                sample = self.main_buffer[start:start + sample_size]
                hex_sample = " ".join(f"{b:02X}" for b in sample)
                print(f"    Muestra: {hex_sample}")
        else:
            print("No se encontraron espacios no utilizados significativos")
    
    def _find_potential_images(self):
        """Search for potential image data patterns"""
        print("\n--- BÚSQUEDA DE IMÁGENES POTENCIALES ---")
          # Buscar patrones típicos de headers de imagen
        patterns = [
            (b'\x89PNG', "PNG"),
            (b'JFIF', "JPEG"),
            (b'BM', "BMP"),
            (b'GIF8', "GIF"),
            (b'\xFF\xD8\xFF', "JPEG_ALT"),  # JPEG alternativo
            (b'RIFF', "RIFF"),              # Could be WAV, AVI, etc.
        ]
        
        found_images = []
        for pattern, format_name in patterns:
            offset = 0
            while True:
                pos = self.main_buffer.find(pattern, offset)
                if pos == -1:
                    break
                found_images.append((pos, format_name))
                print(f"  Encontrado {format_name} en offset 0x{pos:08X}")
                offset = pos + 1
        
        if found_images:
            print(f"Total de imágenes estándar encontradas: {len(found_images)}")
        
        # Buscar patrones de compresión HK89 adicionales
        self._find_hk89_compressed_patterns()
          # Buscar patrones de datos RGB565 (común en displays pequeños)
        self._find_rgb565_patterns()
    
    def _find_rgb565_patterns(self):
        """Search for RGB565 image patterns with better validation"""
        print("\n--- BÚSQUEDA DE PATRONES RGB565 ---")
        
        # Only look for RGB565 patterns in unused spaces or after known blocks
        self.found_rgb565_images = []
        
        # More conservative approach - only check specific locations
        # that might contain additional image data
        potential_locations = []
        
        # Check gaps between blocks
        for i in range(len(self.blocks) - 1):
            current_end = self.blocks[i].picture_address + self.picture_sizes[self.blocks[i].picidx]
            next_start = self.blocks[i + 1].picture_address
            
            # If there's a significant gap, it might contain additional data
            if next_start - current_end > 512:  # At least 512 bytes gap
                potential_locations.append((current_end, next_start - current_end))
          # Check end of file after last block
        if self.blocks:
            last_block = max(self.blocks, key=lambda b: b.picture_address + self.picture_sizes[b.picidx])
            last_end = last_block.picture_address + self.picture_sizes[last_block.picidx]
            if self.file_size - last_end > 512:
                potential_locations.append((last_end, self.file_size - last_end))
        
        # Only search in these specific locations
        if potential_locations:
            print(f"Buscando patrones RGB565 en {len(potential_locations)} ubicaciones específicas...")
            # Conservative search - disabled for now to avoid false positives
            print("Búsqueda RGB565 deshabilitada para evitar falsos positivos")
        else:
            print("No se encontraron ubicaciones candidatas para patrones RGB565")
    
    def _find_hk89_compressed_patterns(self):
        """Search for HK89 compressed image patterns"""
        print("\n--- BÚSQUEDA DE PATRONES HK89 COMPRIMIDOS ---")
        
        # Buscar patrones típicos de compresión HK89
        hk89_patterns = []
        
        for offset in range(0, len(self.main_buffer) - 10):
            # Verificar si podría ser el inicio de datos comprimidos HK89
            if offset + 6 < len(self.main_buffer):
                # Leer los primeros bytes como posible header
                try:
                    header_offset = struct.unpack('<H', self.main_buffer[offset:offset+2])[0]
                    
                    # Los datos HK89 suelen tener un offset inicial pequeño (2-50)
                    if 2 <= header_offset <= 50:
                        # Verificar si hay patrones de RLE típicos después del header
                        data_start = offset + header_offset
                        if data_start < len(self.main_buffer):
                            rle_score = self._calculate_rle_likelihood(self.main_buffer[data_start:data_start+100])
                            if rle_score > 0.3:  # Umbral para considerar probable RLE
                                hk89_patterns.append((offset, header_offset, rle_score))
                                
                except struct.error:
                    continue
        
        # Filtrar patrones muy cercanos (posibles duplicados)
        filtered_patterns = []
        for offset, header_offset, score in hk89_patterns:
            is_duplicate = any(abs(offset - other_offset) < 20 for other_offset, _, _ in filtered_patterns)
            if not is_duplicate:
                filtered_patterns.append((offset, header_offset, score))
        
        if filtered_patterns:
            print("Posibles patrones HK89 encontrados:")
            for offset, header_offset, score in filtered_patterns[:10]:  # Mostrar solo los primeros 10
                print(f"  0x{offset:08X}: Header offset {header_offset}, RLE score {score:.2f}")
        else:
            print("No se encontraron patrones HK89 adicionales obvios")
    
    def _calculate_rle_likelihood(self, data):
        """Calculate likelihood that data is RLE compressed"""
        if len(data) < 10:
            return 0
        
        rle_indicators = 0
        total_bytes = 0
        
        for i, byte in enumerate(data):
            total_bytes += 1
              # Buscar patrones típicos de RLE
            if byte == 0:  # Posible indicador de pixel único
                rle_indicators += 1
            elif byte & 0x80:  # Posible RLE comprimido (bit alto activo)
                count = byte & 0x7F
                if 1 <= count <= 127:  # Rango válido para RLE
                    rle_indicators += 2
            elif 1 <= byte <= 127:  # Posible literal count
                rle_indicators += 1
        
        return rle_indicators / total_bytes if total_bytes > 0 else 0
    
    def _is_meaningful_text(self, text):
        """Check if a text string appears to be meaningful rather than random binary data"""
        if len(text) < 6:  # Require longer strings
            return False
        
        # Count different character types
        letters = sum(1 for c in text if c.isalpha())
        digits = sum(1 for c in text if c.isdigit())
        spaces = sum(1 for c in text if c.isspace())
        symbols = len(text) - letters - digits - spaces
        
        # Filter out strings that are mostly symbols or have weird patterns
        if symbols > len(text) * 0.5:  # More than 50% symbols
            return False
        
        # Look for common meaningless patterns
        meaningless_patterns = [
            # Patterns that appear in binary data interpreted as ASCII
            r'^[`\$@#%&\*\+\-=\|\\\[\]{};<>?/~]+$',  # Only symbols
            r'^[0-9`\$@#%&\*\+\-=\|\\\[\]{};<>?/~\s]+$',  # Only digits and symbols
            r'.*[`@#%&\*\+=\|\\\[\]{};<>?/~]{3,}.*',  # 3+ consecutive symbols
        ]
        
        import re
        for pattern in meaningless_patterns:
            if re.match(pattern, text):
                return False
        
        # Check for reasonable letter-to-total ratio (at least 30% letters for meaningful text)
        if letters / len(text) < 0.3:
            return False
        
        return True
    
    def _find_text_data(self):
        """Search for text data or configuration with improved validation"""
        print("\n--- BÚSQUEDA DE DATOS DE TEXTO ---")
        
        # Only search in gap areas between blocks to avoid false positives
        gaps = self._find_gap_areas()
        if not gaps:
            print("No se encontraron áreas de búsqueda válidas para texto")
            return
        
        text_regions = []
        
        for gap_start, gap_size in gaps:
            if gap_size < 100:  # Skip small gaps
                continue
                
            print(f"Buscando texto en gap: 0x{gap_start:08X} - 0x{gap_start + gap_size:08X}")
            
            current_text = ""
            current_start = 0
            
            # Search within this gap
            gap_end = min(gap_start + gap_size, len(self.main_buffer))
            for i in range(gap_start, gap_end):
                byte = self.main_buffer[i]
                
                if 32 <= byte <= 126:  # ASCII printable
                    if not current_text:
                        current_start = i
                    current_text += chr(byte)
                else:
                    if len(current_text) >= 6:  # Require longer strings
                        if self._is_meaningful_text(current_text):
                            text_regions.append((current_start, current_text))
                    current_text = ""
            
            # Check the last string in this gap
            if len(current_text) >= 6 and self._is_meaningful_text(current_text):
                text_regions.append((current_start, current_text))
        
        if text_regions:
            print(f"Strings de texto significativos encontrados: {len(text_regions)}")
            for offset, text in text_regions[:10]:  # Show only first 10
                print(f"  0x{offset:08X}: '{text[:50]}{'...' if len(text) > 50 else ''}'")
        else:
            print("No se encontraron strings de texto significativos")
    
    def _find_gap_areas(self):
        """Find gap areas between blocks that might contain additional data"""
        used_ranges = []
        table_end = 4 + (self.block_count * 20)
        used_ranges.append((0, table_end))
        
        for block in self.blocks:
            if self.picture_sizes[block.picidx] > 0:
                start = block.picture_address
                end = start + self.picture_sizes[block.picidx]
                used_ranges.append((start, end))
        
        used_ranges.sort()
        
        # Find gaps between used ranges
        gaps = []
        for i in range(len(used_ranges) - 1):
            current_end = used_ranges[i][1]
            next_start = used_ranges[i + 1][0]
            if current_end < next_start:
                gap_size = next_start - current_end
                if gap_size > 512:  # Only return significant gaps
                    gaps.append((current_end, gap_size))
        
        # Check final space
        if used_ranges:
            last_used = max(used_ranges, key=lambda x: x[1])[1]
            if last_used < self.file_size:
                gap_size = self.file_size - last_used
                if gap_size > 512:
                    gaps.append((last_used, gap_size))
        
        return gaps

    def _generate_memory_map(self, output_dir):
        """Generate a detailed memory map"""
        print("\n--- GENERANDO MAPA DE MEMORIA ---")
        
        map_file = f"{output_dir}/memory_map.txt"
        try:
            with open(map_file, 'w', encoding='utf-8') as f:
                f.write("MAPA DE MEMORIA DEL ARCHIVO\n")
                f.write("=" * 50 + "\n\n")
                
                f.write(f"Tamaño total del archivo: {self.file_size} bytes (0x{self.file_size:08X})\n\n")
                
                # Header
                f.write("HEADER:\n")
                f.write(f"0x00000000 - 0x00000003: Header (4 bytes)\n")
                
                # Tabla de bloques
                table_end = 4 + (self.block_count * 20)
                f.write(f"0x00000004 - 0x{table_end-1:08X}: Tabla de bloques ({self.block_count} bloques, {table_end-4} bytes)\n\n")
                
                # Datos de imágenes
                f.write("DATOS DE IMÁGENES:\n")
                for i, block in enumerate(self.blocks):
                    if self.picture_sizes[block.picidx] > 0:
                        start = block.picture_address
                        end = start + self.picture_sizes[block.picidx] - 1
                        f.write(f"0x{start:08X} - 0x{end:08X}: Bloque {i+1} "
                               f"(Tipo 0x{block.blocktype:02X}, {block.sx}x{block.sy}, {self.picture_sizes[block.picidx]} bytes)\n")
                
                # Espacios no utilizados
                f.write("\nESPACIOS NO UTILIZADOS:\n")
                used_ranges = [(0, table_end)]
                for block in self.blocks:
                    if self.picture_sizes[block.picidx] > 0:
                        start = block.picture_address
                        end = start + self.picture_sizes[block.picidx]
                        used_ranges.append((start, end))
                
                used_ranges.sort()
                for i in range(len(used_ranges) - 1):
                    current_end = used_ranges[i][1]
                    next_start = used_ranges[i + 1][0]
                    if current_end < next_start:
                        gap_size = next_start - current_end
                        f.write(f"0x{current_end:08X} - 0x{next_start-1:08X}: Espacio no utilizado ({gap_size} bytes)\n")
                
                # Espacio final
                if used_ranges:
                    last_used = max(used_ranges, key=lambda x: x[1])[1]
                    if last_used < self.file_size:
                        f.write(f"0x{last_used:08X} - 0x{self.file_size-1:08X}: Espacio final ({self.file_size - last_used} bytes)\n")
            
            print(f"✓ Mapa de memoria guardado en: {map_file}")
            
        except Exception as e:
            print(f"✗ Error generando mapa de memoria: {e}")

    def extract_additional_data(self, output_dir):
        """Extract additional data found during analysis"""
        print("\n=== EXTRACCIÓN DE DATOS ADICIONALES ===")
        
        # Extraer espacios no utilizados que podrían contener datos
        self._extract_unused_spaces(output_dir)
        
        # Extraer posibles imágenes RGB565
        self._extract_potential_rgb565_images(output_dir)
        
        # Extraer datos de texto
        self._extract_text_data(output_dir)
          # Intentar decodificar bloques adicionales encontrados
        self._extract_additional_blocks(output_dir)
    
    def _extract_unused_spaces(self, output_dir):
        """Extract unused spaces that might contain hidden data - DISABLED to prevent false positives"""
        print("\n--- EXTRACCIÓN DE ESPACIOS NO UTILIZADOS ---")
        print("Extracción de espacios no utilizados deshabilitada para evitar falsos positivos")
        print("Los espacios no utilizados generalmente contienen datos basura sin significado")
        
        # Keep the analysis for informational purposes but don't extract files
        used_ranges = []
        table_end = 4 + (self.block_count * 20)
        used_ranges.append((0, table_end))
        
        for block in self.blocks:
            if self.picture_sizes[block.picidx] > 0:
                start = block.picture_address
                end = start + self.picture_sizes[block.picidx]
                used_ranges.append((start, end))
        
        used_ranges.sort()
        
        # Just report gaps without extracting
        gap_count = 0
        total_gap_size = 0
        for i in range(len(used_ranges) - 1):
            current_end = used_ranges[i][1]
            next_start = used_ranges[i + 1][0]
            if current_end < next_start:
                gap_size = next_start - current_end
                if gap_size > 32:
                    gap_count += 1
                    total_gap_size += gap_size
                    print(f"  Gap detectado: 0x{current_end:08X} - 0x{next_start:08X} ({gap_size} bytes)")
        
        # Check final space
        if used_ranges:
            last_used = max(used_ranges, key=lambda x: x[1])[1]
            if last_used < self.file_size:
                gap_size = self.file_size - last_used
                if gap_size > 32:
                    gap_count += 1
                    total_gap_size += gap_size
                    print(f"  Espacio final: 0x{last_used:08X} - 0x{self.file_size:08X} ({gap_size} bytes)")
        
        if gap_count > 0:
            print(f"Total: {gap_count} gaps, {total_gap_size} bytes no utilizados")
        else:
            print("No se encontraron espacios no utilizados significativos")
    
    def _analyze_extracted_data(self, data, offset, output_dir):
        """Analyze extracted data to determine its type - DISABLED to prevent false positives"""
        # Disabled to prevent false positive extraction of images and text from binary data
        print(f"  → Análisis de datos deshabilitado para offset 0x{offset:08X} (prevención de falsos positivos)")
        return
    
    def _could_be_image_data(self, data):
        """Check if data could be image data"""
        if len(data) < 100:
            return False
        
        # Verificar varianza en los datos (imágenes tienden a tener variación)
        unique_bytes = len(set(data[:100]))
        if unique_bytes < 10:  # Muy pocos valores únicos
            return False
        
        # Verificar si no es todo ceros o 0xFF
        zero_ratio = data.count(0) / len(data)
        ff_ratio = data.count(0xFF) / len(data)
        if zero_ratio > 0.9 or ff_ratio > 0.9:
            return False
        
        return True
    
    def _try_extract_as_image(self, data, offset, output_dir):
        """Try to extract data as an image with various dimensions - DISABLED to prevent false positives"""
        # Disabled to prevent false positive image extraction from binary data
        # The legitimate watch face images are already extracted from the proper HK89 blocks
        print(f"  ✓ Extracción de imagen deshabilitada para offset 0x{offset:08X} (prevención de falsos positivos)")
        return
    
    def _try_save_as_rgb565(self, data, width, height, offset, output_dir):
        """Try to save data as RGB565 image"""
        try:
            # Convertir RGB565 a RGB888
            rgb_data = bytearray(width * height * 3)
            for i in range(0, len(data), 2):
                if i + 1 < len(data):
                    high_byte = data[i]
                    low_byte = data[i + 1]
                    rgb565 = (high_byte << 8) | low_byte
                    
                    r = high_byte & 0xf8
                    g = (rgb565 >> 3) & 0xfc
                    b = (rgb565 << 3) & 0xff
                    
                    pixel_idx = i // 2
                    rgb_data[pixel_idx * 3] = r
                    rgb_data[pixel_idx * 3 + 1] = g
                    rgb_data[pixel_idx * 3 + 2] = b
            
            filename = f"{output_dir}/extracted_rgb565_{offset:08X}_{width}x{height}.png"
            img = Image.frombytes('RGB', (width, height), bytes(rgb_data))
            img.save(filename)
            print(f"  ✓ Guardada como RGB565: {filename}")
            return True
            
        except Exception as e:
            return False
    
    def _try_save_as_rgb888(self, data, width, height, offset, output_dir):
        """Try to save data as RGB888 image"""
        try:
            filename = f"{output_dir}/extracted_rgb888_{offset:08X}_{width}x{height}.png"
            img = Image.frombytes('RGB', (width, height), bytes(data))
            img.save(filename)
            print(f"  ✓ Guardada como RGB888: {filename}")
            return True
        except Exception as e:
            return False
    
    def _try_save_as_rgba(self, data, width, height, offset, output_dir):
        """Try to save data as RGBA image"""
        try:
            filename = f"{output_dir}/extracted_rgba_{offset:08X}_{width}x{height}.png"
            img = Image.frombytes('RGBA', (width, height), bytes(data))
            img.save(filename)
            print(f"  ✓ Guardada como RGBA: {filename}")
            return True
        except Exception as e:
            return False
    
    def _extract_potential_rgb565_images(self, output_dir):
        """Extract potential RGB565 images found in analysis"""
        print("\n--- EXTRACCIÓN DE IMÁGENES RGB565 POTENCIALES ---")
        
        # Disabled to prevent false positives - RGB565 extraction generates
        # corrupted images from random binary data
        print("Extracción RGB565 deshabilitada para evitar falsos positivos")
        print("Las imágenes RGB565 legítimas ya fueron extraídas con los bloques principales")
        return
    
    def _extract_text_data(self, output_dir):
        """Extract text data found in the file"""
        print("\n--- EXTRACCIÓN DE DATOS DE TEXTO ---")
        
        text_file = f"{output_dir}/extracted_text.txt"
        try:
            with open(text_file, 'w', encoding='utf-8') as f:
                f.write("TEXTO EXTRAÍDO DEL ARCHIVO BINARIO\n")
                f.write("=" * 40 + "\n\n")
                
                # Buscar strings
                current_text = ""
                current_start = 0
                
                for i, byte in enumerate(self.main_buffer):
                    if 32 <= byte <= 126:  # ASCII imprimible
                        if not current_text:
                            current_start = i
                        current_text += chr(byte)
                    else:
                        if len(current_text) >= 4:
                            f.write(f"0x{current_start:08X}: {current_text}\n")
                        current_text = ""
                
                if len(current_text) >= 4:
                    f.write(f"0x{current_start:08X}: {current_text}\n")
            
            print(f"✓ Texto extraído guardado en: {text_file}")
            
        except Exception as e:
            print(f"✗ Error extrayendo texto: {e}")
    
    def _extract_text_from_data(self, data, offset, output_dir):
        """Extract text from specific data chunk"""
        text = ""
        for byte in data:
            if 32 <= byte <= 126:
                text += chr(byte)
            else:
                text += "."
        
        filename = f"{output_dir}/text_data_{offset:08X}.txt"
        try:
            with open(filename, 'w', encoding='utf-8') as f:
                f.write(f"Texto extraído del offset 0x{offset:08X}:\n\n")
                f.write(text)
            print(f"  ✓ Texto guardado: {filename}")
        except Exception as e:
            print(f"  ✗ Error guardando texto: {e}")
    
    def _extract_additional_blocks(self, output_dir):
        """Extract additional blocks found during analysis"""
        print("\n--- EXTRACCIÓN DE BLOQUES ADICIONALES ---")
        
        # Re-ejecutar búsqueda de bloques adicionales
        official_table_end = 4 + (self.block_count * 20)
        search_start = official_table_end
        search_end = min(official_table_end + 1000, len(self.main_buffer))
        
        additional_blocks = []
        for offset in range(search_start, search_end - 20, 4):
            try:
                block_data = self.main_buffer[offset:offset + 20]
                if len(block_data) == 20:
                    blocktype = block_data[0]
                    picture_address = struct.unpack('<I', block_data[1:5])[0]
                    sx = struct.unpack('<H', block_data[7:9])[0]
                    sy = struct.unpack('<H', block_data[9:11])[0]
                    
                    if (0 < blocktype < 256 and 
                        1000 < picture_address < self.file_size and
                        1 <= sx <= 1000 and 1 <= sy <= 1000):
                        additional_blocks.append((offset, DialBlock(block_data)))
                        
            except (struct.error, IndexError):
                continue
        
        # Intentar extraer imágenes de bloques adicionales
        for offset, block in additional_blocks:
            print(f"Intentando extraer bloque adicional en offset 0x{offset:08X}")
            try:
                filename = f"additional_block_{offset:08X}_type_{block.blocktype:02X}"
                self.extract_single_image(block, output_dir, filename)
            except Exception as e:
                print(f"  ✗ Error extrayendo bloque adicional: {e}")

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

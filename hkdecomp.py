#!/usr/bin/env python3
"""
HK89 Dial Decompressor - Python Version
Extracts dial information and images from HK89 smartwatch .bin files
Compatible with original hkdecomp v1.8
"""

import os
import sys
import struct
from pathlib import Path
from PIL import Image
import argparse

# Constants
MAX_MEMORY_SIZE = 0x12C000
MAX_TEXT_SIZE = 0x8000

class DialBlock:
    """Structure representing a dial block from the binary file"""
    def __init__(self, data):
        # Unpack the 20-byte structure (little-endian)
        # Format: I=4bytes, 2B=2bytes, 4H=8bytes, 6B=6bytes = 20bytes total
        unpacked = struct.unpack('<I2B4H6B', data)
        self.picture_address = unpacked[0]  # 0x00-0x03
        self.picidx = unpacked[1]          # 0x04
        self.valami2 = unpacked[2]         # 0x05
        self.sx = unpacked[3]              # 0x06-0x07
        self.sy = unpacked[4]              # 0x08-0x09
        self.posX = unpacked[5]            # 0x0A-0x0B
        self.posY = unpacked[6]            # 0x0C-0x0D
        self.parts = unpacked[7]           # 0x0E
        self.blocktype = unpacked[8]       # 0x0F
        self.align = unpacked[9]           # 0x10
        self.compr = unpacked[10]          # 0x11
        self.centX = unpacked[11]          # 0x12
        self.centY = unpacked[12]          # 0x13

class HKDecompressor:
    def __init__(self):
        self.main_buffer = None
        self.filename = None
        self.block_count = 0
        self.file_size = 0
        self.picture_sizes = [0] * 256
        
    def get_block_type_name(self, block_type):
        """Return human-readable name for block type"""
        type_names = {
            0x81: "Preview image",
            0x89: "Hours",
            0x8A: "Minutes", 
            0x8B: "Battery",
            0x8C: "Month",
            0x8D: "Day of week",
            0x02: "Background image",
            0x06: "Arm hour",
            0x07: "Arm minute",
            0x82: "Background image",
            0x86: "Year",
            0x87: "Month",
            0x88: "Day",
            0x8E: "Steps",
            0x98: "Battery strip"
        }
        return type_names.get(block_type, "Unknown")
    
    def get_block_type_format(self, block_type):
        """Return image format for block type"""
        rgba_types = {0x81, 0x89, 0x8A, 0x8B, 0x8C, 0x8D, 0x82, 0x86, 0x87, 0x88, 0x8E, 0x98}
        return "RGBA" if block_type in rgba_types else " RGB"
    
    def get_block_type_short_name(self, block_type, block_index):
        """Return short filename for block type"""
        short_names = {
            0x81: "prev",
            0x89: "hours",
            0x8A: "minutes",
            0x8B: "battery",
            0x8C: "Month",
            0x8D: "",
            0x02: "background2",
            0x06: "arm_hour",
            0x07: "arm_minute",
            0x86: "",
            0x87: "Month",
            0x88: "",
            0x8E: "steps",
            0x98: "battery"
        }
        
        if block_type == 0x82:
            return f"background{block_index}"
        
        return short_names.get(block_type, "unknown")
    
    def create_output_directory(self, filename):
        """Create output directory based on filename"""
        basename = Path(filename).stem
        dirname = f"_{basename}"
        os.makedirs(dirname, exist_ok=True)
        return dirname
    
    def calculate_picture_sizes(self):
        """Calculate the size of each picture based on addresses"""
        # Reset picture sizes
        self.picture_sizes = [0] * 256
        
        # Parse blocks from buffer
        blocks = []
        for i in range(self.block_count):
            block_data = self.main_buffer[4 + (i * 20):4 + ((i + 1) * 20)]
            block = DialBlock(block_data)
            blocks.append(block)
        
        # Calculate sizes by finding next address
        for block in blocks:
            start_addr = block.picture_address
            end_addr = self.file_size
            
            # Find next picture address to calculate size
            for other_block in blocks:
                if other_block.picture_address > start_addr and other_block.picture_address < end_addr:
                    end_addr = other_block.picture_address
            
            self.picture_sizes[block.picidx] = end_addr - start_addr
    
    def print_picture_summary(self):
        """Print summary of picture information"""
        print(f"Number of block = {self.block_count} , (0x{self.block_count:04X})")
        
        block_table_size = struct.unpack('<H', self.main_buffer[0:2])[0]
        print(f"Size of pltable = {block_table_size} , (0x{block_table_size:04X})")
        print()
        
        # Print byte sizes in rows of 8
        total_bytes = 0
        for i in range(0, 79, 8):
            for j in range(8):
                if i + j < 79:
                    size = self.picture_sizes[i + j] if self.picture_sizes[i + j] > 0 else 0
                    print(f"{i+j:2d}.={size:5d} byte, ", end="")
                    total_bytes += size
            print()
        print(f"summa={total_bytes} byte\n")
        
        # Print hex sizes in rows of 8
        for i in range(0, 79, 8):
            for j in range(8):
                if i + j < 79:
                    print(f"{i+j:2d}.={self.picture_sizes[i+j]:08X}, ", end="")
            print()
        print(f"summa=0x{total_bytes:X} byte")
    
    def extract_block_info(self, block, block_index):
        """Print detailed information about a block"""
        print(f"Block {block_index:2d}.")
        print(f"    0x{block.blocktype:02X} type: {self.get_block_type_name(block.blocktype)} "
              f"{self.get_block_type_format(block.blocktype)} "
              f"({self.get_block_type_short_name(block.blocktype, block_index)})")
        print(f"    0x{block.picture_address:08X}    ({block.picture_address:7d}) picture address")
        print(f"    0x{block.picidx:02X},0x{block.valami2:02X}     "
              f"({block.picidx:3d},{block.valami2:3d}) picidx,valami2")
        print(f"    0x{block.sx:04X},0x{block.sy:04X} ({block.sx:3d},{block.sy:3d}) sx,sy")
        print(f"    0x{block.posX:04X},0x{block.posY:04X} ({block.posX:3d},{block.posY:3d}) posX,posY")
        print(f"    0x{block.parts:02X},0x{block.blocktype:02X}     "
              f"({block.parts:3d},{block.blocktype:3d}) parts,blocktype")
        print(f"    0x{block.align:02X},0x{block.compr:02X},0x{block.centX:02X},0x{block.centY:02X} "
              f"({block.align:3d},{block.compr:3d},{block.centX:3d},{block.centY:3d}) align,compr,centX,centY")
    
    def decompress_image_data(self, compressed_data, width, height, has_alpha=False):
        """Decompress image data using the exact HK89 algorithm from reverse engineering"""
        if len(compressed_data) == 0:
            return None
            
        print(f"\nDecompressing {width}x{height} image from {len(compressed_data)} bytes (alpha={has_alpha})")
        
        # Use the exact algorithm from the reverse-engineered binary (sub_4016B0)
        result = self.decompress_hk89_rle(compressed_data, width, height, has_alpha)
        if result:
            print("✓ Successfully used HK89 RLE decompression")
            return result
            
        print("✗ HK89 decompression failed")
        return None
    
    def rgb565_to_rgb888(self, rgb565):
        """Convert RGB565 to RGB888 format with proper bit scaling"""
        r = (rgb565 >> 11) & 0x1F
        g = (rgb565 >> 5) & 0x3F
        b = rgb565 & 0x1F
        return (
            (r << 3) | (r >> 2),  # 5-bit to 8-bit
            (g << 2) | (g >> 4),  # 6-bit to 8-bit
            (b << 3) | (b >> 2),  # 5-bit to 8-bit
        )

    def decompress_hk89_rle(self, compressed_data, width, height, has_alpha=False):
        """
        Decompress HK89 RLE format based on reverse engineering of sub_4016B0
        Improved version with better error handling and pixel validation
        """
        input_pos = 2  # skip 2-byte header
        output = bytearray()
        pixels_expected = width * height
        pixels_written = 0
        
        print(f"Starting HK89 RLE decompression: {width}x{height}, alpha={has_alpha}")
        
        try:
            while input_pos < len(compressed_data) and pixels_written < pixels_expected:
                count_byte = compressed_data[input_pos]
                input_pos += 1
                
                if count_byte == 0:
                    count_byte = 1
                
                if count_byte & 0x80:
                    # RLE: repeat pixel (count & 0x7F) times
                    repeat_count = count_byte & 0x7F
                    if repeat_count == 0:
                        continue
                        
                    # Read alpha if present
                    alpha_val = 255
                    if has_alpha:
                        if input_pos >= len(compressed_data):
                            break
                        alpha_val = compressed_data[input_pos]
                        input_pos += 1
                    
                    # Read RGB565 pixel (2 bytes)
                    if input_pos + 1 >= len(compressed_data):
                        break
                        
                    rgb565 = struct.unpack('<H', compressed_data[input_pos:input_pos+2])[0]
                    input_pos += 2
                    rgb = self.rgb565_to_rgb888(rgb565)
                    
                    # Write repeated pixels
                    for _ in range(repeat_count):
                        if pixels_written >= pixels_expected:
                            break
                        output += bytes((*rgb, alpha_val) if has_alpha else rgb)
                        pixels_written += 1
                        
                else:
                    # Unique pixels: read count_byte individual pixels
                    for _ in range(count_byte):
                        if pixels_written >= pixels_expected or input_pos >= len(compressed_data):
                            break
                            
                        # Read alpha if present
                        alpha_val = 255
                        if has_alpha:
                            if input_pos >= len(compressed_data):
                                break
                            alpha_val = compressed_data[input_pos]
                            input_pos += 1
                        
                        # Read RGB565 pixel (2 bytes)
                        if input_pos + 1 >= len(compressed_data):
                            break
                            
                        rgb565 = struct.unpack('<H', compressed_data[input_pos:input_pos+2])[0]
                        input_pos += 2
                        rgb = self.rgb565_to_rgb888(rgb565)
                        
                        output += bytes((*rgb, alpha_val) if has_alpha else rgb)
                        pixels_written += 1
            
            # Strict validation: must have exact pixel count
            if pixels_written != pixels_expected:
                print(f"⚠ Error: Expected {pixels_expected}, got {pixels_written} pixels")
                return None
                
            print(f"✅ Successfully decompressed {pixels_written} pixels using HK89 RLE")
            return bytes(output)
                
        except Exception as e:
            print(f"❌ Exception during HK89 RLE decompression: {e}")
            return None
    
    def write_png_file(self, filename, image_data, width, height):
        """Write PNG file using PIL"""
        try:
            # Determine format based on data length
            bytes_per_pixel = len(image_data) // (width * height)
            
            if bytes_per_pixel == 4:
                # RGBA format
                img = Image.frombytes('RGBA', (width, height), image_data[:width * height * 4])
            elif bytes_per_pixel == 3:
                # RGB format - convert to RGBA
                rgba_data = bytearray()
                for i in range(0, len(image_data), 3):
                    if i + 2 < len(image_data):
                        rgba_data.extend([image_data[i], image_data[i+1], image_data[i+2], 255])
                img = Image.frombytes('RGBA', (width, height), bytes(rgba_data))
            else:
                print(f"Unsupported pixel format: {bytes_per_pixel} bytes per pixel")
                return False
                
            img.save(filename)
            print(f"Saved: {filename} ({width}x{height})")
            return True
        except Exception as e:
            print(f"Error saving PNG {filename}: {e}")
            return False
    
    def extract_image_data(self, block_index, block, output_dir):
        """Extract and save image data from a block"""
        short_name = self.get_block_type_short_name(block.blocktype, block_index)
        
        # Determine if this block type uses alpha channel based on reverse engineering
        # From the original code: blocktype >= 0x80 uses RGBA, else RGB
        has_alpha = (block.blocktype & 0x80) != 0
        
        # Generate appropriate filename based on block type
        if block.blocktype == 0x81:  # Preview
            filename = f"{output_dir}/prev.png"
        elif block.blocktype == 0x02:  # Background
            filename = f"{output_dir}/background2.png"
        elif block.blocktype == 0x82:  # Background with index
            filename = f"{output_dir}/background{block_index}.png"
        elif block.blocktype in [0x89, 0x8A, 0x8B, 0x8C, 0x87, 0x8E, 0x98]:
            # Multi-part images (digits)
            type_prefixes = {
                0x89: "hours",
                0x8A: "minutes",
                0x8B: "battery",
                0x8C: "Month",
                0x87: "Month",
                0x8E: "steps",
                0x98: "battery"
            }
            type_prefix = type_prefixes.get(block.blocktype, "unknown")
            
            # Extract individual digit images based on parts count
            for i in range(block.parts):
                if i < 10:
                    filename = f"{output_dir}/chr_{type_prefix}_{i}.png"
                elif i == 10:
                    filename = f"{output_dir}/chr_{type_prefix}_:.png"
                elif i == 11:
                    filename = f"{output_dir}/chr_{type_prefix}_;.png"
                else:
                    continue
                
                # Calculate offset for this digit
                digit_size = self.picture_sizes[block.picidx] // block.parts
                offset = i * digit_size
                
                # Extract compressed data
                start_pos = block.picture_address + offset
                compressed_data = self.main_buffer[start_pos:start_pos + digit_size]
                
                # Try to decompress and save
                decompressed_data = self.decompress_image_data(compressed_data, block.sx, block.sy, has_alpha)
                
                if decompressed_data and self.write_png_file(filename, decompressed_data, block.sx, block.sy):
                    pass  # Success
                else:
                    # Fallback: write raw data with .bin extension
                    raw_filename = f"{filename}.bin"
                    try:
                        with open(raw_filename, 'wb') as f:
                            f.write(compressed_data)
                    except Exception as e:
                        print(f"Error writing raw file {raw_filename}: {e}")
            return  # Don't create single file for multi-part images
        else:
            # Only create file if short_name is not empty
            if short_name:
                filename = f"{output_dir}/{short_name}.png"
            else:
                return  # Skip blocks with empty short names
        
        # Extract single image
        if self.picture_sizes[block.picidx] > 0:
            compressed_data = self.main_buffer[block.picture_address:
                                             block.picture_address + self.picture_sizes[block.picidx]]
            
            decompressed_data = self.decompress_image_data(compressed_data, block.sx, block.sy, has_alpha)
            
            if decompressed_data and self.write_png_file(filename, decompressed_data, block.sx, block.sy):
                pass  # Success
            else:
                # Fallback: write raw data with .bin extension
                raw_filename = f"{filename}.bin"
                try:
                    with open(raw_filename, 'wb') as f:
                        f.write(compressed_data)
                except Exception as e:
                    print(f"Error writing raw file {raw_filename}: {e}")
    
    def save_output_to_file(self, output_dir):
        """Save detailed output information to file"""
        output_file = f"{output_dir}/block_all.txt"
        
        try:
            with open(output_file, 'w') as f:
                # Write picture summary to file
                f.write(f"Number of block = {self.block_count} , (0x{self.block_count:04X})\n")
                
                block_table_size = struct.unpack('<H', self.main_buffer[0:2])[0]
                f.write(f"Size of pltable = {block_table_size} , (0x{block_table_size:04X})\n\n")
                
                # Print byte sizes in rows of 8
                total_bytes = 0
                for i in range(0, 79, 8):
                    for j in range(8):
                        if i + j < 79:
                            size = self.picture_sizes[i + j] if self.picture_sizes[i + j] > 0 else 0
                            f.write(f"{i+j:2d}.={size:5d} byte, ")
                            total_bytes += size
                    f.write("\n")
                f.write(f"summa={total_bytes} byte\n\n")
                
                # Print hex sizes in rows of 8
                for i in range(0, 79, 8):
                    for j in range(8):
                        if i + j < 79:
                            f.write(f"{i+j:2d}.={self.picture_sizes[i+j]:08X}, ")
                    f.write("\n")
                f.write(f"summa=0x{total_bytes:X} byte\n")
                
                # Write block information
                for i in range(self.block_count):
                    block_data = self.main_buffer[4 + (i * 20):4 + ((i + 1) * 20)]
                    block = DialBlock(block_data)
                    
                    f.write(f"Block {i+1:2d}.\n")
                    f.write(f"    0x{block.blocktype:02X} type: {self.get_block_type_name(block.blocktype)} "
                           f"{self.get_block_type_format(block.blocktype)} "
                           f"({self.get_block_type_short_name(block.blocktype, i+1)})\n")
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
    
    def process_dial_data(self):
        """Main processing function"""
        print("HK89 dial decompressor v1.8")
        
        # Extract just the filename from the full path
        base_filename = Path(self.filename).name
        print(f"----------- {base_filename} -----------")
        
        print(f"Number of block = {self.block_count} , (0x{self.block_count:04X})")
        block_table_size = struct.unpack('<H', self.main_buffer[0:2])[0]
        print(f"Size of pltable = {block_table_size} , (0x{block_table_size:04X})")
        
        self.calculate_picture_sizes()
        
        # Create output directory
        output_dir = self.create_output_directory(self.filename)
        
        # Extract images first
        for i in range(self.block_count):
            block_data = self.main_buffer[4 + (i * 20):4 + ((i + 1) * 20)]
            block = DialBlock(block_data)
            self.extract_image_data(i + 1, block, output_dir)
        
        # Print block information
        for i in range(self.block_count):
            block_data = self.main_buffer[4 + (i * 20):4 + ((i + 1) * 20)]
            block = DialBlock(block_data)
            self.extract_block_info(block, i + 1)
        
        self.save_output_to_file(output_dir)
    
    def decompress_file(self, filename):
        """Main entry point to decompress a file"""
        self.filename = filename
        
        # Check if file exists
        if not os.path.exists(filename):
            print(f"No such file! ({filename})")
            return False
        
        # Get file size
        self.file_size = os.path.getsize(filename)
        if self.file_size > MAX_MEMORY_SIZE:
            print("File too large")
            return False
        
        # Read file into buffer
        try:
            with open(filename, 'rb') as f:
                self.main_buffer = f.read()
        except Exception as e:
            print(f"Error reading file: {e}")
            return False
        
        # Get block count from offset 2
        if len(self.main_buffer) < 3:
            print("File too small")
            return False
        
        self.block_count = self.main_buffer[2]
        
        # Process the dial data
        self.process_dial_data()
        return True

def main():
    """Main function"""
    parser = argparse.ArgumentParser(description='HK89 Dial Decompressor - Python Version')
    parser.add_argument('filename', help='.bin file to decompress')
    
    args = parser.parse_args()
    
    decompressor = HKDecompressor()
    if not decompressor.decompress_file(args.filename):
        sys.exit(1)

if __name__ == "__main__":
    main()

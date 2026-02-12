#!/usr/bin/env python3

"""
Enhanced HK89 Watch Dial Composer  
Based on analysis of Jieli AC79 SDK

Key features:
1. Support for Jieli image_file structure format
2. Multiple pixel formats (RGB565, RGB888, ARGB8888, etc.)
3. RLE compression support
4. CRC validation
5. Multiple output formats (HK traditional, Jieli-style)
6. Enhanced metadata handling
"""

import struct
import os
import json
import argparse
from PIL import Image
import sys
import zlib

# Pixel format constants from SDK
PIXEL_FORMAT_MAP = {
    "ARGB8888": 0,
    "RGB888": 1, 
    "RGB565": 2,
    "L8": 3,
    "AL88": 4,
    "AL44": 5,
    "A8": 6,
    "L1": 7,
    "ARGB8565": 8,
    "OSD16": 9,
    "SOLID": 10,
    "JPEG": 11,
    "UNKNOWN": 12
}

COMPRESS_TYPE_MAP = {
    "none": 0,
    "rle": 1,
    "lz77": 2,
    "jpeg": 3
}

class HKDialComposerEnhanced:
    def __init__(self):
        self.blocks = []
        self.header_info = {}
        self.output_format = "auto"  # auto, hk_traditional, jieli_standard
        
    def load_json_config(self, json_path):
        """Load configuration from JSON file"""
        try:
            with open(json_path, 'r', encoding='utf-8') as f:
                data = json.load(f)
                
            self.header_info = data.get('header', {})
            self.blocks = data.get('blocks', [])
            
            # Detect output format preference
            source_format = data.get('source_format')
            if source_format:
                if 'jieli' in source_format:
                    self.output_format = "jieli_standard"
                elif 'hk' in source_format:
                    self.output_format = "hk_traditional"
                    
            print(f"Loaded {len(self.blocks)} blocks from {json_path}")
            print(f"Detected source format: {source_format}")
            
            return True
            
        except Exception as e:
            print(f"Error loading JSON config: {e}")
            return False
            
    def load_image_data(self, image_path, target_format="RGB565"):
        """Load and convert image to target format"""
        try:
            img = Image.open(image_path)
            
            # Convert to RGB if needed
            if img.mode != 'RGB':
                img = img.convert('RGB')
                
            width, height = img.size
            pixels = list(img.getdata())
            
            if target_format == "RGB565":
                # Convert to RGB565 format
                data = bytearray()
                for r, g, b in pixels:
                    # Convert 8-bit RGB to 5-6-5 format
                    r5 = (r >> 3) & 0x1F
                    g6 = (g >> 2) & 0x3F  
                    b5 = (b >> 3) & 0x1F
                    
                    pixel565 = (r5 << 11) | (g6 << 5) | b5
                    data.extend(struct.pack('<H', pixel565))
                    
                return bytes(data)
                
            elif target_format == "RGB888":
                data = bytearray()
                for r, g, b in pixels:
                    data.extend([r, g, b])
                return bytes(data)
                
            elif target_format == "ARGB8888":
                data = bytearray()
                for r, g, b in pixels:
                    data.extend([255, r, g, b])  # Full alpha
                return bytes(data)
                
            else:
                print(f"Unsupported target format: {target_format}")
                return None
                
        except Exception as e:
            print(f"Error loading image {image_path}: {e}")
            return None
            
    def rle_compress(self, data):
        """Simple RLE compression"""
        if not data:
            return data
            
        compressed = bytearray()
        i = 0
        
        while i < len(data):
            current = data[i]
            count = 1
            
            # Count consecutive identical bytes
            while i + count < len(data) and data[i + count] == current and count < 255:
                count += 1
                
            if count > 2:  # Worth compressing
                compressed.append(count)
                compressed.append(current)
            else:
                # Raw data mode - find run of non-repeating data
                raw_start = i
                while (i < len(data) and 
                       (i + 1 >= len(data) or data[i] != data[i + 1]) and
                       i - raw_start < 255):
                    i += 1
                    
                raw_len = i - raw_start
                if raw_len > 0:
                    compressed.append(0)  # Raw mode marker
                    compressed.append(raw_len)
                    compressed.extend(data[raw_start:raw_start + raw_len])
                continue
                
            i += count
            
        return bytes(compressed)
        
    def calculate_crc16(self, data):
        """Calculate CRC16 for data validation"""
        return zlib.crc32(data) & 0xFFFF
        
    def build_jieli_header(self, blocks):
        """Build Jieli-style binary with image_file structures"""
        binary_data = bytearray()
        
        # Calculate header size (16 bytes per block)
        header_size = len(blocks) * 16
        current_offset = header_size
        
        # Build image_file structures
        for block in blocks:
            format_code = PIXEL_FORMAT_MAP.get(block.get('format', 'RGB565'), 2)
            compress_code = COMPRESS_TYPE_MAP.get(block.get('compression', 'none'), 0)
            
            # Load and process image data
            image_path = block.get('image_file')
            if not image_path or not os.path.exists(image_path):
                print(f"Warning: Image file not found for block {block.get('picidx')}")
                continue
                
            image_data = self.load_image_data(image_path, block.get('format', 'RGB565'))
            if not image_data:
                continue
                
            # Apply compression if requested
            if block.get('compression') == 'rle':
                image_data = self.rle_compress(image_data)
                
            # Calculate CRC
            data_crc = self.calculate_crc16(image_data)
            
            # Build image_file structure
            img_file_struct = struct.pack('<BBHHIII',
                format_code,           # format
                compress_code,         # compress  
                data_crc,             # data_crc
                block['w'],           # width
                block['h'],           # height
                current_offset,       # offset
                len(image_data)       # len
            )
            
            binary_data.extend(img_file_struct)
            
            # Store image data for later
            block['_image_data'] = image_data
            block['_data_offset'] = current_offset
            current_offset += len(image_data)
            
        # Append all image data
        for block in blocks:
            if '_image_data' in block:
                binary_data.extend(block['_image_data'])
                
        return bytes(binary_data)
        
    def build_hk_traditional_header(self, blocks):
        """Build traditional HK-style binary"""
        binary_data = bytearray()
        
        # Sort blocks by picidx
        sorted_blocks = sorted(blocks, key=lambda x: x.get('picidx', 0))
        
        for block in sorted_blocks:
            # Load image data
            image_path = block.get('image_file')
            if not image_path or not os.path.exists(image_path):
                continue
                
            image_data = self.load_image_data(image_path, 'RGB565')
            if not image_data:
                continue
                
            # Build block header: width, height, picidx
            block_header = struct.pack('<III',
                block['w'],
                block['h'], 
                block.get('picidx', 0)
            )
            
            binary_data.extend(block_header)
            binary_data.extend(image_data)
            
        return bytes(binary_data)
        
    def build_jieli_magic_header(self, blocks):
        """Build Jieli-style binary with magic number header"""
        binary_data = bytearray()
        
        # Magic header: magic, version, count
        magic = 0x4C454A  # "JEL" 
        version = 1
        count = len(blocks)
        
        binary_data.extend(struct.pack('<III', magic, version, count))
        
        # Add image_file structures and data
        jieli_data = self.build_jieli_header(blocks)
        binary_data.extend(jieli_data)
        
        return bytes(binary_data)
        
    def compile_dial(self, json_path, output_path, format_override=None):
        """Main compilation function"""
        if not self.load_json_config(json_path):
            return False
            
        if not self.blocks:
            print("No blocks to compile")
            return False
            
        # Determine output format
        output_fmt = format_override or self.output_format
        
        print(f"Compiling {len(self.blocks)} blocks in {output_fmt} format...")
        
        # Build binary based on format
        if output_fmt == "jieli_standard":
            binary_data = self.build_jieli_header(self.blocks)
        elif output_fmt == "jieli_magic":
            binary_data = self.build_jieli_magic_header(self.blocks)
        elif output_fmt == "hk_traditional":
            binary_data = self.build_hk_traditional_header(self.blocks)
        else:
            # Auto-detect based on source
            source_format = self.header_info.get('format', '')
            if 'jieli' in source_format:
                binary_data = self.build_jieli_header(self.blocks)
            else:
                binary_data = self.build_hk_traditional_header(self.blocks)
                
        # Write output file
        try:
            with open(output_path, 'wb') as f:
                f.write(binary_data)
                
            print(f"Successfully compiled dial: {output_path}")
            print(f"Output size: {len(binary_data)} bytes")
            return True
            
        except Exception as e:
            print(f"Error writing output file: {e}")
            return False
            
    def create_sample_config(self, output_path):
        """Create a sample configuration file"""
        sample_config = {
            "format_version": "2.0",
            "source_format": "jieli_standard", 
            "metadata": {
                "total_blocks": 2,
                "description": "Sample enhanced dial configuration"
            },
            "header": {
                "format": "jieli_standard"
            },
            "blocks": [
                {
                    "picidx": 0,
                    "blocktype": 0,
                    "x": 0,
                    "y": 0,
                    "w": 240,
                    "h": 240,
                    "format": "RGB565",
                    "compression": "none",
                    "image_file": "background.png"
                },
                {
                    "picidx": 1, 
                    "blocktype": 1,
                    "x": 100,
                    "y": 100,
                    "w": 40,
                    "h": 40,
                    "format": "RGB565",
                    "compression": "rle",
                    "image_file": "icon.png"
                }
            ]
        }
        
        with open(output_path, 'w', encoding='utf-8') as f:
            json.dump(sample_config, f, indent=2, ensure_ascii=False)
            
        print(f"Sample configuration created: {output_path}")

def main():
    parser = argparse.ArgumentParser(description='Enhanced HK89 Watch Dial Composer (Jieli SDK-aware)')
    parser.add_argument('action', choices=['compile', 'sample'], 
                        help='Action to perform')
    parser.add_argument('-i', '--input', help='Input JSON configuration file')
    parser.add_argument('-o', '--output', help='Output file path')
    parser.add_argument('-f', '--format', 
                        choices=['hk_traditional', 'jieli_standard', 'jieli_magic'],
                        help='Force specific output format')
    parser.add_argument('-v', '--verbose', action='store_true', help='Verbose output')
    
    args = parser.parse_args()
    
    composer = HKDialComposerEnhanced()
    
    if args.action == 'sample':
        output_path = args.output or 'sample_enhanced_config.json'
        composer.create_sample_config(output_path)
        
    elif args.action == 'compile':
        if not args.input:
            print("Error: Input JSON file required for compile action")
            sys.exit(1)
            
        if not os.path.exists(args.input):
            print(f"Error: Input file '{args.input}' not found")
            sys.exit(1)
            
        output_path = args.output or 'dial_enhanced.bin'
        
        if composer.compile_dial(args.input, output_path, args.format):
            print("Compilation successful!")
        else:
            print("Compilation failed!")
            sys.exit(1)

if __name__ == '__main__':
    main()

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
        """Build traditional HK-style binary compatible with comp_decomp.compile_dial.

        This implementation produces the following layout:
        - Header (4 bytes): pltable_size (uint16 LE), num_blocks (1), format (1)
        - Block descriptors (num_blocks * 20 bytes)
        - Picture lookup table (pltable_size * 4 bytes)
        - Image data (concatenated frames)
        """
        # --- Helper functions (local) ---
        def _rgb888_to_rgb565_int(r, g, b):
            r5 = (r >> 3) & 0x1F
            g6 = (g >> 2) & 0x3F
            b5 = (b >> 3) & 0x1F
            return (r5 << 11) | (g6 << 5) | b5

        def _compress_raw_rgb_aligned_pil(img):
            if img.mode != 'RGB':
                img = img.convert('RGB')
            width, height = img.size
            pixels = list(img.getdata())
            bytes_per_pixel = 2
            row_bytes = width * bytes_per_pixel
            aligned_row_bytes = (row_bytes + 3) & ~3
            padding = aligned_row_bytes - row_bytes
            res = bytearray()
            idx = 0
            for y in range(height):
                for x in range(width):
                    r, g, b = pixels[idx]
                    idx += 1
                    rgb565 = _rgb888_to_rgb565_int(r, g, b)
                    res.append((rgb565 >> 8) & 0xFF)
                    res.append(rgb565 & 0xFF)
                if padding:
                    res.extend(b'\x00' * padding)
            return bytes(res)

        def _compress_raw_rgba_aligned_pil(img):
            if img.mode != 'RGBA':
                img = img.convert('RGBA')
            width, height = img.size
            pixels = list(img.getdata())
            bytes_per_pixel = 3
            row_bytes = width * bytes_per_pixel
            aligned_row_bytes = (row_bytes + 3) & ~3
            padding = aligned_row_bytes - row_bytes
            res = bytearray()
            idx = 0
            for y in range(height):
                for x in range(width):
                    r, g, b, a = pixels[idx]
                    idx += 1
                    rgb565 = _rgb888_to_rgb565_int(r, g, b)
                    res.append(a & 0xFF)
                    res.append((rgb565 >> 8) & 0xFF)
                    res.append(rgb565 & 0xFF)
                if padding:
                    res.extend(b'\x00' * padding)
            return bytes(res)

        def _compress_rle_row_lookahead(pixels, width):
            result = bytearray()
            i = 0
            generated_pixels = 0
            max_lookahead = width * 2
            total = len(pixels)
            while generated_pixels < width and i < total:
                current = pixels[i]
                run_length = 1
                max_run = min(127, max_lookahead - i, total - i)
                while run_length < max_run and pixels[i + run_length] == current:
                    run_length += 1
                if run_length >= 3:
                    result.append(0x80 | run_length)
                    result.append((current >> 8) & 0xFF)
                    result.append(current & 0xFF)
                    i += run_length
                    generated_pixels += run_length
                else:
                    remaining_in_row = width - generated_pixels
                    unique = []
                    max_unique = min(127, remaining_in_row)
                    while len(unique) < max_unique and i < total and i < max_lookahead:
                        run_ahead = 1
                        curr = pixels[i]
                        while i + run_ahead < total and i + run_ahead < max_lookahead and pixels[i + run_ahead] == curr and run_ahead < 3:
                            run_ahead += 1
                        if run_ahead >= 3:
                            break
                        unique.append(curr)
                        i += 1
                    if unique:
                        result.append(len(unique))
                        for px in unique:
                            result.append((px >> 8) & 0xFF)
                            result.append(px & 0xFF)
                        generated_pixels += len(unique)
            return bytes(result)

        def _compress_rle_rgba_row_lookahead(pixels, width):
            result = bytearray()
            i = 0
            generated_pixels = 0
            total = len(pixels)
            while generated_pixels < width and i < total:
                current = pixels[i]
                remaining_in_row = width - generated_pixels
                run_length = 1
                while i + run_length < total and pixels[i + run_length] == current and run_length < 127:
                    run_length += 1
                run_length = min(run_length, remaining_in_row)
                if run_length >= 3:
                    result.append(0x80 | run_length)
                    result.append(current[0] & 0xFF)
                    result.append((current[1] >> 8) & 0xFF)
                    result.append(current[1] & 0xFF)
                    i += run_length
                    generated_pixels += run_length
                else:
                    unique = []
                    max_unique = min(127, remaining_in_row)
                    while len(unique) < max_unique and i < total:
                        run_ahead = 1
                        curr = pixels[i]
                        while i + run_ahead < total and pixels[i + run_ahead] == curr and run_ahead < 3:
                            run_ahead += 1
                        if run_ahead >= 3:
                            break
                        unique.append(curr)
                        i += 1
                    if unique:
                        result.append(len(unique))
                        for px in unique:
                            result.append(px[0] & 0xFF)
                            result.append((px[1] >> 8) & 0xFF)
                            result.append(px[1] & 0xFF)
                        generated_pixels += len(unique)
            return bytes(result)

        def _compress_rle_rgb_with_header_pil(img):
            if img.mode != 'RGB':
                img = img.convert('RGB')
            width, height = img.size
            all_pixels = []
            for y in range(height):
                for x in range(width):
                    r, g, b = img.getpixel((x, y))
                    all_pixels.append(_rgb888_to_rgb565_int(r, g, b))
            all_pixels.extend([0] * (width * 2))
            scanline_data = []
            for y in range(height):
                start_idx = y * width
                row_data = _compress_rle_row_lookahead(all_pixels[start_idx:start_idx + width], width)
                scanline_data.append(row_data)
            skip_offset = height * 4
            lookup_table = bytearray()
            cumulative = skip_offset
            for row_data in scanline_data:
                row_bytes = len(row_data)
                cumulative += row_bytes
                low = (row_bytes * 32) & 0xFFFF
                high = cumulative & 0xFFFF
                lookup_table.extend(struct.pack('<HH', low, high))
            result = bytearray()
            result.extend(struct.pack('<H', skip_offset))
            table_bytes = len(lookup_table)
            needed_bytes = skip_offset - 2
            if table_bytes >= needed_bytes:
                result.extend(lookup_table[:needed_bytes])
            else:
                result.extend(lookup_table)
                result.extend(b'\x00' * (needed_bytes - table_bytes))
            for row_data in scanline_data:
                result.extend(row_data)
            return bytes(result)

        def _compress_rle_rgba_with_header_pil(img):
            if img.mode != 'RGBA':
                img = img.convert('RGBA')
            width, height = img.size
            all_pixels = []
            for y in range(height):
                for x in range(width):
                    r, g, b, a = img.getpixel((x, y))
                    all_pixels.append((a & 0xFF, _rgb888_to_rgb565_int(r, g, b)))
            all_pixels.extend([(0, 0)] * (width * 2))
            scanline_data = []
            for y in range(height):
                start_idx = y * width
                row_data = _compress_rle_rgba_row_lookahead(all_pixels[start_idx:start_idx + width], width)
                scanline_data.append(row_data)
            skip_offset = height * 4
            lookup_table = bytearray()
            cumulative = skip_offset
            for row_data in scanline_data:
                row_bytes = len(row_data)
                cumulative += row_bytes
                low = (row_bytes * 32) & 0xFFFF
                high = cumulative & 0xFFFF
                lookup_table.extend(struct.pack('<HH', low, high))
            result = bytearray()
            result.extend(struct.pack('<H', skip_offset))
            table_bytes = len(lookup_table)
            needed_bytes = skip_offset - 2
            if table_bytes >= needed_bytes:
                result.extend(lookup_table[:needed_bytes])
            else:
                result.extend(lookup_table)
                result.extend(b'\x00' * (needed_bytes - table_bytes))
            for row_data in scanline_data:
                result.extend(row_data)
            return bytes(result)

        # --- End helpers ---

        processed_blocks = []
        pltable = []

        for b in blocks:
            image_path = b.get('image_file')
            if not image_path or not os.path.exists(image_path):
                print(f"Warning: image file missing for block: {b}")
                continue
            try:
                img = Image.open(image_path)
            except Exception as e:
                print(f"Warning: cannot open image {image_path}: {e}")
                continue
            frame_h = int(b.get('h', img.size[1]))
            total_h = img.size[1]
            frames = max(1, total_h // frame_h) if frame_h > 0 else 1
            is_rgba = (img.mode == 'RGBA' or 'A' in img.getbands())
            comp_mode = b.get('compression', 'rle')
            compression_code = 4 if comp_mode == 'rle' else 0
            pic_idx = int(b.get('picidx', 0))
            frame_datas = []
            for fi in range(frames):
                y0 = fi * frame_h
                y1 = y0 + frame_h
                frame_img = img.crop((0, y0, img.size[0], y1))
                if compression_code == 0:
                    if is_rgba:
                        compressed = _compress_raw_rgba_aligned_pil(frame_img)
                    else:
                        compressed = _compress_raw_rgb_aligned_pil(frame_img)
                else:
                    if is_rgba:
                        compressed = _compress_rle_rgba_with_header_pil(frame_img)
                    else:
                        compressed = _compress_rle_rgb_with_header_pil(frame_img)
                pad = (4 - (len(compressed) % 4)) % 4
                if pad:
                    compressed = compressed + (b'\x00' * pad)
                pltable.append(len(compressed))
                frame_datas.append(compressed)
            # Set RGBA bit on block type if image contains alpha
            block_type = int(b.get('blocktype', 0))
            if is_rgba:
                block_type |= 0x80

            processed_blocks.append({
                'pic_idx': pic_idx,
                'width': int(b.get('w', img.size[0])),
                'height': int(frame_h),
                'pos_x': int(b.get('x', 0)),
                'pos_y': int(b.get('y', 0)),
                'parts': frames,
                'block_type': block_type,
                'align': int(b.get('align', 9)),
                'compression': compression_code,
                'cent_x': int(b.get('cent_x', 0)),
                'cent_y': int(b.get('cent_y', 0)),
                'frame_data': frame_datas
            })

        pltable_size = len(pltable)
        num_blocks = len(processed_blocks)
        header_size = 4
        blocks_size = num_blocks * 20
        pltable_bytes = pltable_size * 4
        images_start = header_size + blocks_size + pltable_bytes
        image_data = bytearray()
        current_offset = images_start
        for blk in processed_blocks:
            blk['image_offset'] = current_offset
            for fd in blk['frame_data']:
                image_data.extend(fd)
                current_offset += len(fd)
        out = bytearray()
        h = bytearray(4)
        struct.pack_into('<H', h, 0, pltable_size)
        h[2] = num_blocks & 0xFF
        h[3] = 0x02
        out.extend(h)
        for blk in processed_blocks:
            desc = bytearray(20)
            struct.pack_into('<I', desc, 0, blk['image_offset'])
            desc[4] = blk['pic_idx'] & 0xFF
            desc[5] = 0
            struct.pack_into('<H', desc, 6, blk['width'])
            struct.pack_into('<H', desc, 8, blk['height'])
            struct.pack_into('<H', desc, 10, blk['pos_x'])
            struct.pack_into('<H', desc, 12, blk['pos_y'])
            desc[14] = blk['parts'] & 0xFF
            desc[15] = blk['block_type'] & 0xFF
            desc[16] = blk['align'] & 0xFF
            desc[17] = blk['compression'] & 0xFF
            desc[18] = blk['cent_x'] & 0xFF
            desc[19] = blk['cent_y'] & 0xFF
            out.extend(desc)
        for size in pltable:
            out.extend(struct.pack('<I', size))
        out.extend(image_data)
        return bytes(out)
        
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

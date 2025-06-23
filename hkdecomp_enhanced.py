#!/usr/bin/env python3

"""
Enhanced HK89 Watch Dial Decompiler
Based on analysis of Jieli AC79 SDK

Key findings from SDK analysis:
1. struct image_file contains: format, compress, data_crc, width, height, offset, len
2. Pixel formats: ARGB8888, RGB888, RGB565, L8, AL88, AL44, A8, L1, ARGB8565, OSD16, SOLID, JPEG
3. Compression types: RLE compression is used (rle.h with struct rle_header/rle_line)
4. Resource files use id-based addressing with page support
5. Images can be compressed using RLE encoding

This enhanced decompiler attempts to extract more metadata and handle different
compression types found in the SDK. Uses the proven ImageDecompressor from the original.
"""

import struct
import os
import json
import argparse
from PIL import Image
import sys

# Import the working ImageDecompressor from the original hkdecomp.py
import importlib.util
spec = importlib.util.spec_from_file_location("hkdecomp", "/home/miguel/Documents/software/smart_watch/hkdecomp.py")
hkdecomp = importlib.util.module_from_spec(spec)
spec.loader.exec_module(hkdecomp)

# Pixel format constants from SDK
PIXEL_FORMAT_MAP = {
    0: "ARGB8888",
    1: "RGB888", 
    2: "RGB565",
    3: "L8",
    4: "AL88",
    5: "AL44",
    6: "A8",
    7: "L1",
    8: "ARGB8565",
    9: "OSD16",
    10: "SOLID",
    11: "JPEG",
    12: "UNKNOWN"
}

# Compression type constants
COMPRESS_TYPE_MAP = {
    0: "none",
    1: "rle",
    2: "lz77",
    3: "jpeg"
}

class ImageDecompressor:
    """Image decompressor for HK89 format (from original working decompiler)"""
    
    @staticmethod
    def decompress_hk89_rle(compressed_data: bytes, width: int, height: int, has_alpha: bool = False):
        """Decompress HK89 RLE format"""
        if not compressed_data or len(compressed_data) < 4:
            return None
            
        expected_pixels = width * height
        bytes_per_pixel = 4 if has_alpha else 3
        output = bytearray(expected_pixels * bytes_per_pixel)
        
        # Read header to get data start position
        try:
            header_value = struct.unpack('<H', compressed_data[0:2])[0]
            input_pos = header_value if header_value < len(compressed_data) and header_value >= 2 else 2
        except struct.error:
            input_pos = 2
            
        output_pos = 0
        pixels_written = 0
        
        try:
            while pixels_written < expected_pixels and input_pos < len(compressed_data):
                if input_pos >= len(compressed_data):
                    break
                    
                count_byte = compressed_data[input_pos]
                input_pos += 1
                
                if count_byte == 0:
                    # Single pixel mode
                    alpha = 255
                    if has_alpha and input_pos < len(compressed_data):
                        alpha = compressed_data[input_pos]
                        input_pos += 1
                    
                    if input_pos + 1 >= len(compressed_data):
                        break
                        
                    r, g, b = ImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
                    input_pos += 2
                    
                    if output_pos + bytes_per_pixel <= len(output):
                        output[output_pos] = r
                        output[output_pos + 1] = g
                        output[output_pos + 2] = b
                        if has_alpha:
                            output[output_pos + 3] = alpha
                            output_pos += 4
                        else:
                            output_pos += 3
                        pixels_written += 1
                
                elif count_byte & 0x80:
                    # RLE mode
                    rle_count = count_byte & 0x7F
                    alpha = 255
                    if has_alpha and input_pos < len(compressed_data):
                        alpha = compressed_data[input_pos]
                        input_pos += 1
                    
                    if input_pos + 1 >= len(compressed_data):
                        break
                        
                    r, g, b = ImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
                    input_pos += 2
                    
                    for _ in range(rle_count):
                        if pixels_written >= expected_pixels or output_pos + bytes_per_pixel > len(output):
                            break
                            
                        output[output_pos] = r
                        output[output_pos + 1] = g
                        output[output_pos + 2] = b
                        if has_alpha:
                            output[output_pos + 3] = alpha
                            output_pos += 4
                        else:
                            output_pos += 3
                        pixels_written += 1
                
                else:
                    # Literal mode
                    for _ in range(count_byte):
                        if pixels_written >= expected_pixels or output_pos + bytes_per_pixel > len(output):
                            break
                            
                        alpha = 255
                        if has_alpha and input_pos < len(compressed_data):
                            alpha = compressed_data[input_pos]
                            input_pos += 1
                            
                        if input_pos + 1 >= len(compressed_data):
                            break
                            
                        r, g, b = ImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
                        input_pos += 2
                        
                        output[output_pos] = r
                        output[output_pos + 1] = g
                        output[output_pos + 2] = b
                        if has_alpha:
                            output[output_pos + 3] = alpha
                            output_pos += 4
                        else:
                            output_pos += 3
                        pixels_written += 1
            
            # Fill remaining pixels with black if needed
            while pixels_written < expected_pixels:
                if output_pos + bytes_per_pixel <= len(output):
                    output[output_pos:output_pos + 3] = [0, 0, 0]
                    if has_alpha:
                        output[output_pos + 3] = 0
                        output_pos += 4
                    else:
                        output_pos += 3
                    pixels_written += 1
                else:
                    break
                    
            return bytes(output[:output_pos])
            
        except Exception as e:
            print(f"Decompression error: {e}")
            return None
    
    @staticmethod
    def _read_rgb565_pixel(compressed_data: bytes, input_pos: int):
        """Read and convert RGB565 pixel to RGB888"""
        high_byte = compressed_data[input_pos]
        low_byte = compressed_data[input_pos + 1]
        rgb565 = (high_byte << 8) | low_byte
        
        r = high_byte & 0xf8
        g = (rgb565 >> 3) & 0xfc
        b = (rgb565 << 3) & 0xff
        
        return r, g, b
    
    @staticmethod
    def decompress_raw_aligned(compressed_data: bytes, width: int, height: int, has_alpha: bool):
        """Decompress RAW aligned format for needle elements"""
        bytes_per_pixel = 3 if has_alpha else 2
        row_bytes = width * bytes_per_pixel
        aligned_row_bytes = (row_bytes + 3) & ~3  # Align to 4 bytes
        
        expected_size = height * aligned_row_bytes
        
        if len(compressed_data) < expected_size:
            compressed_data = compressed_data + b'\x00' * (expected_size - len(compressed_data))
        
        output = bytearray(width * height * 4)  # Always output RGBA
        output_pos = 0
        
        try:
            for row in range(height):
                row_start = row * aligned_row_bytes
                for col in range(width):
                    base = row_start + col * bytes_per_pixel
                    
                    if base + bytes_per_pixel > len(compressed_data):
                        output[output_pos:output_pos + 4] = [0, 0, 0, 0]
                        output_pos += 4
                        continue
                    
                    if has_alpha:
                        a = compressed_data[base]
                        b1 = compressed_data[base + 1]
                        b2 = compressed_data[base + 2]
                        
                        rgb565 = (b1 << 8) | b2
                        r = b1 & 0xf8
                        g = (rgb565 >> 3) & 0xfc
                        b = (rgb565 << 3) & 0xff
                        
                        output[output_pos:output_pos + 4] = [r, g, b, a]
                    else:
                        rgb565 = (compressed_data[base] << 8) | compressed_data[base + 1]
                        r = compressed_data[base] & 0xf8
                        g = (rgb565 >> 3) & 0xfc
                        b = (rgb565 << 3) & 0xff
                        
                        output[output_pos:output_pos + 4] = [r, g, b, 255]
                    
                    output_pos += 4
                    
            return bytes(output)
            
        except Exception as e:
            print(f"Raw decompression error: {e}")
            return None
    
    @staticmethod
    def decompress_with_tracking(data, width, height, has_alpha, compr, part_idx=0):
        """Decompress image data and return (decompressed_data, bytes_consumed)"""
        if not data or len(data) < 4:
            return None, 0
        
        expected_pixels = width * height
        bytes_per_pixel = 4 if has_alpha else 3
        original_size = len(data)
        
        try:
            if compr == 0:
                # RAW format - calculate exact consumption
                bytes_per_pixel_raw = 3 if has_alpha else 2
                row_bytes = width * bytes_per_pixel_raw
                aligned_row_bytes = (row_bytes + 3) & ~3
                expected_consumption = height * aligned_row_bytes
                
                result = ImageDecompressor.decompress_raw_aligned(data, width, height, has_alpha)
                
                if result:
                    actual_consumed = min(expected_consumption, original_size)
                    return result, actual_consumed
            else:
                # RLE format - estimate consumption by parsing
                result = ImageDecompressor.decompress_hk89_rle(data, width, height, has_alpha)
                
                if result and len(result) >= expected_pixels * bytes_per_pixel:
                    # Estimate bytes consumed by simulating RLE parsing
                    consumed = ImageDecompressor._estimate_rle_consumption(data, expected_pixels, has_alpha)
                    return result, min(consumed, original_size)
        
        except Exception as e:
            print(f"Decompression failed for part {part_idx}: {e}")
        
        return None, 0
    
    @staticmethod
    def _estimate_rle_consumption(compressed_data, expected_pixels, has_alpha):
        """Estimate bytes consumed by RLE decompression"""
        if len(compressed_data) < 4:
            return len(compressed_data)
        
        # Read header to get start position
        try:
            header_value = struct.unpack('<H', compressed_data[0:2])[0]
            input_pos = header_value if header_value < len(compressed_data) and header_value >= 2 else 2
        except:
            input_pos = 2
        
        pixels_processed = 0
        
        try:
            while pixels_processed < expected_pixels and input_pos < len(compressed_data):
                if input_pos >= len(compressed_data):
                    break
                
                command = compressed_data[input_pos]
                input_pos += 1
                
                if command & 0x80:  # High bit set - repeat
                    count = command & 0x7F
                    pixels_processed += count
                    if has_alpha:
                        input_pos += 4  # RGBA
                    else:
                        input_pos += 2  # RGB565
                else:  # Raw data
                    count = command
                    pixels_processed += count
                    if has_alpha:
                        input_pos += count * 4  # RGBA
                    else:
                        input_pos += count * 2  # RGB565
                        
        except:
            pass
            
        return input_pos

class HKDialDecompilerEnhanced:
    def __init__(self, filename):
        self.filename = filename
        self.data = None
        self.header_info = {}
        self.blocks = []
        self.output_dir = None
        
    def load_binary(self):
        """Load and validate binary file"""
        try:
            with open(self.filename, 'rb') as f:
                self.data = f.read()
            print(f"Loaded {len(self.data)} bytes from {self.filename}")
            return True
        except Exception as e:
            print(f"Error loading file: {e}")
            return False
            
    def detect_header_format(self):
        """Detect if this uses standard header or Jieli-style format"""
        if len(self.data) < 16:
            return False
            
        # Check for potential magic numbers
        first_4 = struct.unpack('<I', self.data[0:4])[0]
        
        # Look for patterns that might indicate Jieli format
        if first_4 == 0x4C454A:  # "JEL" in little endian
            return "jieli_magic"
        
        # Check for HK format by examining the header structure
        # HK format: 2-byte picture table size + 1-byte block count + 1-byte padding
        try:
            picture_table_size = struct.unpack('<H', self.data[0:2])[0]
            block_count = self.data[2]
            
            # Validate reasonable values for HK format
            if (0 < picture_table_size < 65536 and 
                0 < block_count < 100 and
                len(self.data) >= 4 + (block_count * 20)):
                return "hk_standard"
                
        except:
            pass
        
        # Check if first bytes could be image_file struct
        if first_4 & 0xFF000000 == 0:  # First byte is 0, possible format type
            return "image_file_struct"
        
        # Default to HK format if nothing else matches
        return "hk_standard"
        
    def parse_jieli_image_file(self, offset):
        """Parse a Jieli-style image_file structure"""
        if offset + 16 > len(self.data):
            return None
            
        # struct image_file from SDK
        format_type, compress, data_crc, width, height, data_offset, data_len = struct.unpack('<BBHHIII', self.data[offset:offset+16])
        
        return {
            'format': PIXEL_FORMAT_MAP.get(format_type, f"unknown_{format_type}"),
            'compress': COMPRESS_TYPE_MAP.get(compress, f"unknown_{compress}"),
            'data_crc': data_crc,
            'width': width,
            'height': height,
            'offset': data_offset,
            'len': data_len,
            'header_offset': offset
        }
        
    def parse_header(self):
        """Parse file header based on detected format"""
        header_format = self.detect_header_format()
        print(f"Detected header format: {header_format}")
        
        if header_format == "jieli_magic":
            return self.parse_jieli_header()
        elif header_format == "image_file_struct":
            return self.parse_image_file_header()
        else:
            return self.parse_hk_header()
            
    def parse_jieli_header(self):
        """Parse Jieli-style header with magic number"""
        if len(self.data) < 12:
            return False
            
        magic, version, count = struct.unpack('<III', self.data[0:12])
        
        self.header_info = {
            'magic': hex(magic),
            'version': version,
            'count': count,
            'format': 'jieli'
        }
        
        # Parse image file entries
        offset = 12
        for i in range(count):
            img_info = self.parse_jieli_image_file(offset)
            if img_info:
                img_info['id'] = i
                self.blocks.append(img_info)
                offset += 16
            else:
                break
                
        return True
        
    def parse_image_file_header(self):
        """Parse header as sequence of image_file structures"""
        self.header_info = {'format': 'image_file_sequence'}
        
        offset = 0
        block_id = 0
        
        while offset + 16 <= len(self.data):
            img_info = self.parse_jieli_image_file(offset)
            
            if not img_info or img_info['width'] == 0 or img_info['height'] == 0:
                break
                
            # Validate that data_offset points to reasonable location
            if img_info['offset'] >= len(self.data):
                break
                
            img_info['id'] = block_id
            self.blocks.append(img_info)
            
            offset += 16
            block_id += 1
            
        return len(self.blocks) > 0
        
    def parse_hk_header(self):
        """Parse traditional HK89 header format"""
        if len(self.data) < 8:
            return False
            
        # Try to detect block count by scanning for reasonable image dimensions
        possible_blocks = []
        
        # Scan first 1KB for potential block headers
        for offset in range(0, min(1024, len(self.data) - 20), 4):
            try:
                # Try different header formats
                values = struct.unpack('<IIIII', self.data[offset:offset+20])
                
                # Look for reasonable width/height values
                for i in range(len(values) - 1):
                    w, h = values[i], values[i+1]
                    if 10 <= w <= 400 and 10 <= h <= 400:
                        possible_blocks.append({
                            'offset': offset + i*4,
                            'width': w,
                            'height': h,
                            'confidence': min(w, h)  # Smaller dimension as confidence
                        })
            except:
                continue
                
        if not possible_blocks:
            return False
            
        # Use most confident block structure
        possible_blocks.sort(key=lambda x: x['confidence'], reverse=True)
        
        # Assume traditional format with width, height, picidx pattern
        self.header_info = {'format': 'hk_traditional'}
        return self.parse_traditional_blocks()
        
    def parse_traditional_blocks(self):
        """Parse traditional HK block format based on working hkdecomp.py"""
        if len(self.data) < 4:
            return False
            
        try:
            # Read the actual HK header structure
            picture_table_size = struct.unpack('<H', self.data[0:2])[0]
            block_count = self.data[2]
            
            print(f"Picture table size: {picture_table_size}")
            print(f"Block count: {block_count}")
            
            self.header_info.update({
                'picture_table_size': picture_table_size,
                'block_count': block_count
            })
            
            # Parse blocks using the correct structure (20 bytes per block)
            for i in range(block_count):
                block_start = 4 + (i * 20)  # Header is 4 bytes + 20 bytes per block
                block_end = block_start + 20
                
                if block_end > len(self.data):
                    print(f"Warning: Block {i+1} extends beyond file size")
                    break
                    
                block_data = self.data[block_start:block_end]
                
                # Parse block structure: <I2B4H6B (from original DialBlock)
                unpacked = struct.unpack('<I2B4H6B', block_data)
                
                picture_address = unpacked[0] 
                picidx = unpacked[1]
                valami2 = unpacked[2]
                width = unpacked[3]   # sx
                height = unpacked[4]  # sy
                posX = unpacked[5]
                posY = unpacked[6]
                parts = unpacked[7]
                blocktype = unpacked[8]
                align = unpacked[9]
                compr = unpacked[10]
                centX = unpacked[11]
                centY = unpacked[12]
                
                block_info = {
                    'id': i,
                    'picidx': picidx,
                    'width': width,
                    'height': height,
                    'offset': picture_address,
                    'len': 0,  # Will be calculated later
                    'x': posX,
                    'y': posY,
                    'parts': parts,
                    'blocktype': blocktype,
                    'align': align,
                    'compress': 'rle' if compr != 0 else 'none',
                    'format': 'RGB565',
                    'center_x': centX,
                    'center_y': centY,
                    'header_offset': block_start,
                    'compression_type': compr,
                    'has_alpha': (blocktype & 0x80) or blocktype == 0x8C
                }
                
                self.blocks.append(block_info)
            
            # Calculate actual picture sizes using the original method
            self.calculate_picture_sizes()
                
            return len(self.blocks) > 0
            
        except Exception as e:
            print(f"Error parsing traditional blocks: {e}")
            return False
            
    def calculate_picture_sizes(self):
        """Calculate actual picture sizes based on block addresses (from original decompiler)"""
        picture_sizes = [0] * 256
        
        # Create sorted list of addresses
        address_map = []
        for i, block in enumerate(self.blocks):
            if 0 <= block['offset'] < len(self.data):
                address_map.append((block['offset'], block['picidx'], i))
        
        address_map.sort()
        
        # Calculate sizes
        for i, (start_addr, picidx, block_idx) in enumerate(address_map):
            if i + 1 < len(address_map):
                end_addr = address_map[i + 1][0]
            else:
                end_addr = len(self.data)
            
            size = max(0, end_addr - start_addr)
            if 0 <= picidx < 256:
                picture_sizes[picidx] = size
                # Update the block with actual size
                self.blocks[block_idx]['len'] = size
                
        print(f"Calculated sizes for {len([s for s in picture_sizes if s > 0])} pictures")
        
    def decode_rle_data(self, data, width, height):
        """Decode RLE compressed image data based on SDK rle.h"""
        try:
            # Basic RLE decoding - this needs to be enhanced based on actual RLE format
            decoded = bytearray()
            i = 0
            
            while i < len(data) and len(decoded) < width * height * 2:
                if i + 1 >= len(data):
                    break
                    
                count = data[i]
                value = data[i + 1]
                
                if count == 0:
                    # Raw data mode
                    if i + 2 >= len(data):
                        break
                    raw_len = data[i + 1]
                    if i + 2 + raw_len > len(data):
                        break
                    decoded.extend(data[i + 2:i + 2 + raw_len])
                    i += 2 + raw_len
                else:
                    # Repeat mode
                    decoded.extend([value] * count)
                    i += 2
                    
            return bytes(decoded)
        except:
            return data  # Return original if decode fails
            
    def extract_image_data(self, block):
        """Extract and decode image data from block using correct decompression"""
        data_start = block['offset']
        data_end = data_start + block['len']
        
        if data_start >= len(self.data):
            print(f"Warning: Block {block['id']} picture address beyond file size")
            return None
            
        if block['len'] <= 0:
            print(f"Warning: Block {block['id']} has invalid picture size")
            return None
            
        if data_end > len(self.data):
            print(f"Warning: Block {block['id']} data extends beyond file")
            data_end = len(self.data)
            
        compressed_data = self.data[data_start:data_end]
        
        if not compressed_data:
            return None
            
        # Choose decompression method based on compression type
        width = block['width']
        height = block['height']
        has_alpha = block.get('has_alpha', False)
        compression_type = block.get('compression_type', 0)
        
        if compression_type == 0:
            # Raw aligned format
            image_data = ImageDecompressor.decompress_raw_aligned(
                compressed_data, width, height, has_alpha
            )
        else:
            # RLE compressed format
            image_data = ImageDecompressor.decompress_hk89_rle(
                compressed_data, width, height, has_alpha
            )
        
        return image_data
        
    def save_block_image(self, block, image_data):
        """Save block as image file, handling multi-part images"""
        try:
            width, height = block['width'], block['height']
            parts = block.get('parts', 1)
            
            if parts > 1:
                return self.save_multipart_images(block, image_data)
            else:
                return self.save_single_image(block, image_data)
                
        except Exception as e:
            print(f"Error saving block {block['id']}: {e}")
            
        return None
        
    def save_single_image(self, block, image_data):
        """Save a single image using decompressed RGB data"""
        if not image_data:
            return None
            
        try:
            width, height = block['width'], block['height']
            
            # The decompressed data is already in RGB or RGBA format
            if len(image_data) == width * height * 3:
                # RGB format
                pixels = []
                for i in range(0, len(image_data), 3):
                    r = image_data[i]
                    g = image_data[i + 1]
                    b = image_data[i + 2]
                    pixels.append((r, g, b))
                    
                img = Image.new('RGB', (width, height))
                img.putdata(pixels)
                
            elif len(image_data) == width * height * 4:
                # RGBA format
                pixels = []
                for i in range(0, len(image_data), 4):
                    r = image_data[i]
                    g = image_data[i + 1]
                    b = image_data[i + 2]
                    a = image_data[i + 3]
                    pixels.append((r, g, b, a))
                    
                img = Image.new('RGBA', (width, height))
                img.putdata(pixels)
                
            else:
                print(f"Warning: Unexpected image data size for block {block['id']}: "
                      f"{len(image_data)} bytes for {width}x{height}")
                return None
                
            filename = f"block_{block['id']:03d}_{block.get('picidx', 0):03d}_{width}x{height}.png"
            filepath = os.path.join(self.output_dir, filename)
            img.save(filepath)
            
            return filename
            
        except Exception as e:
            print(f"Error saving single image for block {block['id']}: {e}")
            return None
            
    def save_multipart_images(self, block, compressed_data):
        """Save multiple images from a single compressed block"""
        try:
            width, height = block['width'], block['height']
            parts = block['parts']
            has_alpha = (block.get('blocktype', 0) & 0x80) or block.get('blocktype', 0) == 0x8C
            compr = block.get('compr', 0)
            
            print(f"  -> Extracting {parts} parts for block {block['id']}")
            
            success_count = 0
            all_images = []
            current_offset = 0
            total_size = len(compressed_data)
            
            # Extract each part
            for part_idx in range(parts):
                remaining_data = total_size - current_offset
                if remaining_data <= 0:
                    print(f"  No data remaining for part {part_idx}")
                    break
                
                # For the last part, use all remaining data
                if part_idx == parts - 1:
                    part_data_size = remaining_data
                else:
                    # Estimate part size based on compression type
                    if compr == 0:
                        # RAW format - calculate exact size per part
                        bytes_per_pixel = 3 if has_alpha else 2
                        row_bytes = width * bytes_per_pixel
                        aligned_row_bytes = (row_bytes + 3) & ~3
                        estimated_size = height * aligned_row_bytes
                    else:
                        # RLE format - estimate based on compression ratio
                        uncompressed_size = width * height * (4 if has_alpha else 3)
                        estimated_size = int(uncompressed_size * 0.65)
                    
                    # Align to 4 bytes
                    estimated_size = (estimated_size + 3) & ~3
                    part_data_size = min(estimated_size, remaining_data)
                
                if part_data_size <= 0:
                    print(f"  Invalid data size for part {part_idx}")
                    break
                
                # Extract part data
                part_data = compressed_data[current_offset:current_offset + part_data_size]
                
                # Decompress part
                image_data, actual_consumed = ImageDecompressor.decompress_with_tracking(
                    part_data, width, height, has_alpha, compr, part_idx
                )
                
                if image_data:
                    # Save individual part
                    bytes_per_pixel = len(image_data) // (width * height)
                    
                    if bytes_per_pixel == 4:
                        pixels = []
                        for i in range(0, len(image_data), 4):
                            r = image_data[i]
                            g = image_data[i + 1]
                            b = image_data[i + 2]
                            a = image_data[i + 3]
                            pixels.append((r, g, b, a))
                        img = Image.new('RGBA', (width, height))
                        img.putdata(pixels)
                    elif bytes_per_pixel == 3:
                        pixels = []
                        for i in range(0, len(image_data), 3):
                            r = image_data[i]
                            g = image_data[i + 1]
                            b = image_data[i + 2]
                            pixels.append((r, g, b))
                        img = Image.new('RGB', (width, height))
                        img.putdata(pixels)
                    else:
                        print(f"  Unsupported bytes per pixel: {bytes_per_pixel}")
                        current_offset += part_data_size
                        continue
                        
                    part_filename = f"block_{block['id']:03d}_{block.get('picidx', 0):03d}_{part_idx}.png"
                    part_filepath = os.path.join(self.output_dir, part_filename)
                    img.save(part_filepath)
                    
                    success_count += 1
                    all_images.append(image_data)
                    print(f"  ✓ {part_filename} (consumed {actual_consumed} bytes)")
                    current_offset += actual_consumed
                else:
                    print(f"  Failed to decompress part {part_idx}")
                    current_offset += part_data_size
                
                # Align to 4 bytes
                while current_offset % 4 != 0:
                    current_offset += 1
            
            # Create combined strip image
            if all_images:
                combined_filename = f"block_{block['id']:03d}_{block.get('picidx', 0):03d}_combined.png"
                self.create_combined_strip(all_images, width, height, combined_filename, has_alpha)
                
            print(f"  -> Successfully extracted {success_count}/{parts} parts")
            
            # Return the combined filename or the first part filename
            if success_count > 0:
                return f"block_{block['id']:03d}_{block.get('picidx', 0):03d}_combined.png"
            else:
                return None
                
        except Exception as e:
            print(f"Error saving multipart images for block {block['id']}: {e}")
            return None
            
    def create_combined_strip(self, all_images, width, height, filename, has_alpha=False):
        """Create a horizontal strip combining all parts"""
        try:
            if not all_images:
                return
                
            # Determine bytes per pixel from first image
            bytes_per_pixel = len(all_images[0]) // (width * height)
            
            # Create combined image (horizontal strip)
            combined_width = width * len(all_images)
            combined_height = height
            
            if bytes_per_pixel == 4 or has_alpha:
                combined_img = Image.new('RGBA', (combined_width, combined_height))
                mode = 'RGBA'
            else:
                combined_img = Image.new('RGB', (combined_width, combined_height))
                mode = 'RGB'
            
            for i, image_data in enumerate(all_images):
                if bytes_per_pixel == 4:
                    pixels = []
                    for j in range(0, len(image_data), 4):
                        r = image_data[j]
                        g = image_data[j + 1]
                        b = image_data[j + 2]
                        a = image_data[j + 3]
                        pixels.append((r, g, b, a))
                    part_img = Image.new('RGBA', (width, height))
                    part_img.putdata(pixels)
                else:
                    pixels = []
                    for j in range(0, len(image_data), 3):
                        r = image_data[j]
                        g = image_data[j + 1]
                        b = image_data[j + 2]
                        pixels.append((r, g, b))
                    part_img = Image.new('RGB', (width, height))
                    part_img.putdata(pixels)
                
                combined_img.paste(part_img, (i * width, 0))
            
            filepath = os.path.join(self.output_dir, filename)
            combined_img.save(filepath)
            print(f"  ✓ Created combined strip: {filename}")
            
        except Exception as e:
            print(f"Error creating combined strip: {e}")
        
    def create_zzuler_json(self):
        """Create zzuler-compatible JSON structure"""
        zzuler_data = {
            "format_version": "2.0",
            "source_format": self.header_info.get('format', 'unknown'),
            "metadata": {
                "total_blocks": len(self.blocks),
                "source_file": self.filename,
                "source_size": len(self.data)
            },
            "blocks": []
        }
        
        # Add header info if available
        if self.header_info:
            zzuler_data["header"] = self.header_info
            
        for block in self.blocks:
            block_data = {
                "picidx": block.get('picidx', block['id']),
                "blocktype": 0,  # Default type
                "x": 0,
                "y": 0, 
                "w": block['width'],
                "h": block['height'],
                "format": block.get('format', 'RGB565'),
                "compression": block.get('compress', 'none'),
                "data_crc": block.get('data_crc', 0),
                "data_length": block['len'],
                "data_offset": block['offset']
            }
            
            # Add SDK-specific fields
            if 'header_offset' in block:
                block_data['header_offset'] = block['header_offset']
                
            zzuler_data["blocks"].append(block_data)
            
        return zzuler_data
        
    def decompile(self, output_dir):
        """Main decompilation function"""
        self.output_dir = output_dir
        
        if not self.load_binary():
            return False
            
        if not self.parse_header():
            print("Failed to parse header")
            return False
            
        print(f"Found {len(self.blocks)} blocks using {self.header_info.get('format')} format")
        
        # Create output directory
        os.makedirs(output_dir, exist_ok=True)
        
        # Extract images
        for block in self.blocks:
            print(f"Extracting block {block['id']}: {block['width']}x{block['height']} "
                  f"format={block.get('format', 'unknown')} "
                  f"compress={block.get('compress', 'none')}")
                  
            image_data = self.extract_image_data(block)
            filename = self.save_block_image(block, image_data)
            
            if filename:
                block['image_file'] = filename
            else:
                # Save just the raw data if image conversion failed
                block['image_file'] = f"block_{block['id']:03d}_raw.bin"
                raw_path = os.path.join(self.output_dir, block['image_file'])
                with open(raw_path, 'wb') as f:
                    f.write(image_data)
                
        # Save JSON metadata
        json_data = self.create_zzuler_json()
        json_path = os.path.join(output_dir, 'dial_enhanced.json')
        
        with open(json_path, 'w', encoding='utf-8') as f:
            json.dump(json_data, f, indent=2, ensure_ascii=False)
            
        print(f"Enhanced decompilation complete: {len(self.blocks)} blocks extracted")
        print(f"JSON metadata saved to: {json_path}")
        
        return True

def main():
    parser = argparse.ArgumentParser(description='Enhanced HK89 Watch Dial Decompiler (Jieli SDK-aware)')
    parser.add_argument('input_file', help='Input .bin file to decompile')
    parser.add_argument('-o', '--output', default='output_enhanced', help='Output directory')
    parser.add_argument('-v', '--verbose', action='store_true', help='Verbose output')
    
    args = parser.parse_args()
    
    if not os.path.exists(args.input_file):
        print(f"Error: Input file '{args.input_file}' not found")
        sys.exit(1)
        
    decompiler = HKDialDecompilerEnhanced(args.input_file)
    
    if decompiler.decompile(args.output):
        print("Decompilation successful!")
    else:
        print("Decompilation failed!")
        sys.exit(1)

if __name__ == '__main__':
    main()

#!/usr/bin/env python3
"""
HK89 Dial Decompressor - Simple Reconstruction Version
Extracts dial information and images from HK89 smartwatch .bin files
Generates simple configuration for reconstruction
"""
import os
import sys
import struct
import json
import argparse
import logging
import time
from pathlib import Path
from PIL import Image
from typing import List, Dict, Optional, Tuple, Any

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

# Constants
MAX_MEMORY_SIZE = 0x12C000  # 1.2MB limit

class DialBlock:
    """Simple structure representing a dial block for reconstruction"""
    
    def __init__(self, data: bytes):
        unpacked = struct.unpack('<I2B4H6B', data)
        self.picture_address = unpacked[0]
        self.picidx = unpacked[1]
        self.valami2 = unpacked[2]
        self.sx = unpacked[3]  # width
        self.sy = unpacked[4]  # height
        self.posX = unpacked[5]
        self.posY = unpacked[6]
        self.parts = unpacked[7]
        self.blocktype = unpacked[8]
        self.align = unpacked[9]
        self.compr = unpacked[10]
        self.centX = unpacked[11]
        self.centY = unpacked[12]
        
        # Determine if block supports alpha
        self.has_alpha = (self.blocktype & 0x80) or self.blocktype == 0x8C
    
    def get_short_name(self, block_index: int) -> str:
        """Get short filename for this block"""
        short_names = {
            # Basic types (según definiciones exactas del C header)
            0x01: "preview", 0x02: "background", 0x03: "arm_hour", 0x04: "arm_minute",
            0x05: "arm_second", 0x06: "year", 0x07: "month", 0x08: "day",
            0x09: "digital_hour", 0x0A: "digital_minute", 0x0B: "digital_second", 0x0C: "digital_ampm",
            0x0D: "digital_weekday", 0x0E: "digital_steps", 0x0F: "digital_heart", 0x10: "digital_calorie",
            0x11: "digital_distance", 0x12: "digital_battery_number", 0x13: "unknown13", 0x14: "unknown14",
            0x15: "unknown15", 0x16: "berry", 0x17: "animation", 0x18: "digital_battery_strip",
            0x19: "digital_weather", 0x1A: "digital_temperature", 0x1B: "unknown1B", 0x1C: "unknown1C",
            0x1D: "unknown1D", 0x1E: "unknown1E", 0x1F: "unknown1F",
            # HK26/HK89 specific
            0x27: "hour_high", 0x28: "hour_low", 0x29: "minute_high", 0x2A: "minute_low",
            # Extended types (0x80+) - versiones RGBA de los tipos básicos
            0x81: "preview", 0x82: "background", 0x83: "arm_hour", 0x84: "arm_minute", 
            0x85: "arm_second", 0x86: "year", 0x87: "month", 0x88: "day",
            0x89: "digital_hour", 0x8A: "digital_minute", 0x8B: "digital_second", 0x8C: "digital_ampm",
            0x8D: "digital_weekday", 0x8E: "digital_steps", 0x8F: "digital_heart", 0x90: "digital_calorie",
            0x91: "digital_distance", 0x92: "digital_battery_number", 0x96: "berry", 0x97: "animation",
            0x98: "digital_battery_strip", 0x99: "digital_weather", 0x9A: "digital_temperature",
            # Additional battery types
            0x9E: "batterystrip_ext"
        }
        
        if self.blocktype == 0x82:
            return f"background_{block_index}"
        return short_names.get(self.blocktype, f"unknown_{self.blocktype:02x}_{block_index}")

class ImageDecompressor:
    """Simple image decompressor for HK89 format"""
    
    @staticmethod
    def decompress_hk89_rle(compressed_data: bytes, width: int, height: int, has_alpha: bool = False) -> Optional[bytes]:
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
            logger.error(f"Decompression error: {e}")
            return None
    
    @staticmethod
    def _read_rgb565_pixel(compressed_data: bytes, input_pos: int) -> Tuple[int, int, int]:
        """Read and convert RGB565 pixel to RGB888"""
        high_byte = compressed_data[input_pos]
        low_byte = compressed_data[input_pos + 1]
        rgb565 = (high_byte << 8) | low_byte
        
        r = high_byte & 0xf8
        g = (rgb565 >> 3) & 0xfc
        b = (rgb565 << 3) & 0xff
        
        return r, g, b
    
    @staticmethod
    def decompress_raw_aligned(compressed_data: bytes, width: int, height: int, has_alpha: bool) -> Optional[bytes]:
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
                    else:
                        b1 = compressed_data[base]
                        b2 = compressed_data[base + 1]
                        a = 255
                    
                    # Convert RGB565 to RGB888
                    rgb565 = b2 | (b1 << 8)
                    r = ((rgb565 >> 11) & 0x1F) * 255 // 31
                    g = ((rgb565 >> 5) & 0x3F) * 255 // 63
                    b = (rgb565 & 0x1F) * 255 // 31
                    
                    output[output_pos:output_pos + 4] = [r, g, b, a]
                    output_pos += 4
            
            return bytes(output)
            
        except Exception as e:
            logger.error(f"RAW decompression error: {e}")
            return None

class SimpleHKDecompressor:
    """Simple HK decompressor for reconstruction"""
    
    def __init__(self):
        self.main_buffer: Optional[bytes] = None
        self.filename: str = ""
        self.block_count: int = 0
        self.file_size: int = 0
        self.picture_sizes: List[int] = [0] * 256
        self.blocks: List[DialBlock] = []
        
    def load_file(self, filename: str) -> bool:
        """Load binary file"""
        self.filename = filename
        
        if not os.path.exists(filename):
            logger.error(f"File not found: {filename}")
            return False
        
        self.file_size = os.path.getsize(filename)
        if self.file_size > MAX_MEMORY_SIZE:
            logger.error(f"File too large: {self.file_size} > {MAX_MEMORY_SIZE}")
            return False
        
        try:
            with open(filename, 'rb') as f:
                self.main_buffer = f.read()
        except Exception as e:
            logger.error(f"Error reading file: {e}")
            return False
        
        if len(self.main_buffer) < 4:
            logger.error("File too small")
            return False
        
        # Read basic header info
        picture_table_size = struct.unpack('<H', self.main_buffer[0:2])[0]
        self.block_count = self.main_buffer[2]
        
        logger.info(f"Picture table size: {picture_table_size}")
        logger.info(f"Block count: {self.block_count}")
        
        return True
        
    def parse_blocks(self):
        """Parse all blocks"""
        self.blocks = []
        
        for i in range(self.block_count):
            block_start = 4 + (i * 20)  # Header is 4 bytes + 20 bytes per block
            block_end = block_start + 20
            
            if block_end > len(self.main_buffer):
                logger.warning(f"Block {i+1} extends beyond file size")
                break
                
            block_data = self.main_buffer[block_start:block_end]
            block = DialBlock(block_data)
            self.blocks.append(block)
            
        logger.info(f"Parsed {len(self.blocks)} blocks")
    
    def calculate_picture_sizes(self):
        """Calculate picture sizes"""
        self.picture_sizes = [0] * 256
        
        # Create sorted list of addresses
        address_map = []
        for i, block in enumerate(self.blocks):
            if 0 <= block.picture_address < self.file_size:
                address_map.append((block.picture_address, block.picidx, i))
        
        address_map.sort()
        
        # Calculate sizes
        for i, (start_addr, picidx, block_idx) in enumerate(address_map):
            if i + 1 < len(address_map):
                end_addr = address_map[i + 1][0]
            else:
                end_addr = self.file_size
            
            size = max(0, end_addr - start_addr)
            if 0 <= picidx < 256:
                self.picture_sizes[picidx] = size
                
        logger.debug(f"Calculated sizes for {len([s for s in self.picture_sizes if s > 0])} pictures")
    
    def extract_image(self, block: DialBlock, output_dir: str, filename: str) -> bool:
        """Extract image(s) - handles both single and multi-part images"""
        # Validate block data
        if block.picture_address >= self.file_size:
            logger.warning(f"Picture address beyond file size")
            return False
        
        if self.picture_sizes[block.picidx] <= 0:
            logger.warning(f"Invalid picture size")
            return False
        
        # Get compressed data
        available_bytes = self.file_size - block.picture_address
        actual_size = min(self.picture_sizes[block.picidx], available_bytes)
        
        if actual_size <= 0:
            return False
        
        compressed_data = self.main_buffer[block.picture_address:block.picture_address + actual_size]
        
        # Handle multi-part images (like digits 0-9)
        if block.parts > 1:
            return self._extract_multipart_image(block, compressed_data, output_dir, filename)
        else:
            return self._extract_single_image(block, compressed_data, output_dir, filename)
    
    def _extract_single_image(self, block: DialBlock, compressed_data: bytes, output_dir: str, filename: str) -> bool:
        """Extract a single image"""
        # Choose decompression method
        if block.compr == 0:
            image_data = ImageDecompressor.decompress_raw_aligned(
                compressed_data, block.sx, block.sy, block.has_alpha
            )
        else:
            image_data = ImageDecompressor.decompress_hk89_rle(
                compressed_data, block.sx, block.sy, block.has_alpha
            )
        
        if image_data:
            return self._write_png(f"{output_dir}/{filename}.png", image_data, block.sx, block.sy)
        
        return False
    
    def _extract_multipart_image(self, block: DialBlock, compressed_data: bytes, output_dir: str, filename: str) -> bool:
        """Extract multiple parts from a single compressed block using enhanced method"""
        logger.info(f"  -> Extracting {block.parts} parts for {filename}")
        
        success_count = 0
        all_images = []
        current_offset = 0
        total_size = len(compressed_data)
        
        # Extract each part using dynamic offset based on actual consumption
        for part_idx in range(block.parts):
            # Check if we have remaining data
            remaining_data = total_size - current_offset
            if remaining_data <= 0:
                logger.warning(f"  No data remaining for part {part_idx}")
                break
            
            # For the last part, use all remaining data
            if part_idx == block.parts - 1:
                part_data_size = remaining_data
            else:
                # Estimate part size based on compression type
                if block.compr == 0:
                    # RAW format - calculate exact size per part
                    bytes_per_pixel = 3 if block.has_alpha else 2
                    row_bytes = block.sx * bytes_per_pixel
                    aligned_row_bytes = (row_bytes + 3) & ~3
                    estimated_size = block.sy * aligned_row_bytes
                else:
                    # RLE format - estimate based on compression ratio (~65%)
                    uncompressed_size = block.sx * block.sy * (4 if block.has_alpha else 3)
                    estimated_size = int(uncompressed_size * 0.65)
                
                # Align to 4 bytes
                estimated_size = (estimated_size + 3) & ~3
                part_data_size = min(estimated_size, remaining_data)
            
            if part_data_size <= 0:
                logger.warning(f"  Invalid data size for part {part_idx}")
                break
            
            # Extract part data
            part_data = compressed_data[current_offset:current_offset + part_data_size]
            
            # Decompress part and track actual consumption
            image_data, actual_consumed = self._decompress_single_part_with_tracking(
                part_data, block.sx, block.sy, block.has_alpha, block.compr, part_idx
            )
            
            if image_data:
                # Save individual part
                part_filename = f"{output_dir}/{filename}_{part_idx}.png"
                if self._write_png(part_filename, image_data, block.sx, block.sy):
                    success_count += 1
                    all_images.append((image_data, block.sx, block.sy))
                    logger.debug(f"  ✓ {filename}_{part_idx}.png (consumed {actual_consumed} bytes)")
                    current_offset += actual_consumed
                else:
                    logger.warning(f"  Failed to save {filename}_{part_idx}.png")
                    current_offset += part_data_size
            else:
                logger.warning(f"  Failed to decompress part {part_idx}")
                current_offset += part_data_size
            
            # Align to 4 bytes as per compiler requirements
            while current_offset % 4 != 0:
                current_offset += 1
        
        # Create combined strip image (horizontal layout)
        if all_images:
            self._create_combined_image(all_images, f"{output_dir}/{filename}_combined.png")
        
        logger.info(f"  -> Successfully extracted {success_count}/{block.parts} parts")
        return success_count > 0
    
    def _write_png(self, filepath: str, image_data: bytes, width: int, height: int) -> bool:
        """Write PNG file"""
        try:
            bytes_per_pixel = len(image_data) // (width * height)
            
            if bytes_per_pixel == 4:
                img = Image.frombytes('RGBA', (width, height), image_data)
            elif bytes_per_pixel == 3:
                # Convert RGB to RGBA
                rgba_data = bytearray()
                for i in range(0, len(image_data), 3):
                    if i + 2 < len(image_data):
                        rgba_data.extend([image_data[i], image_data[i+1], image_data[i+2], 255])
                img = Image.frombytes('RGBA', (width, height), bytes(rgba_data))
            else:
                logger.error(f"Unsupported pixel format: {bytes_per_pixel} bytes per pixel")
                return False
                
            img.save(filepath)
            return True
            
        except Exception as e:
            logger.error(f"Error saving PNG {filepath}: {e}")
            return False
    
    def _create_combined_image(self, images: List[Tuple[bytes, int, int]], output_path: str) -> bool:
        """Create a combined vertical strip image from multiple parts"""
        if not images:
            return False
        
        try:
            # Get dimensions for VERTICAL layout
            max_width = max(width for _, width, _ in images)
            total_height = sum(height for _, _, height in images)
            
            # Create combined image with vertical layout
            combined = Image.new('RGBA', (max_width, total_height), (0, 0, 0, 0))
            
            y_offset = 0
            for image_data, width, height in images:
                # Convert to PIL Image
                bytes_per_pixel = len(image_data) // (width * height)
                
                if bytes_per_pixel == 4:
                    img = Image.frombytes('RGBA', (width, height), image_data)
                elif bytes_per_pixel == 3:
                    # Convert RGB to RGBA
                    rgba_data = bytearray()
                    for i in range(0, len(image_data), 3):
                        if i + 2 < len(image_data):
                            rgba_data.extend([image_data[i], image_data[i+1], image_data[i+2], 255])
                    img = Image.frombytes('RGBA', (width, height), bytes(rgba_data))
                else:
                    continue
                
                # Paste into combined image using VERTICAL layout
                combined.paste(img, (0, y_offset), img if img.mode == 'RGBA' else None)
                y_offset += height
            
            combined.save(output_path)
            logger.debug(f"Created combined vertical image: {output_path}")
            return True
            
        except Exception as e:
            logger.error(f"Error creating combined image: {e}")
            return False
    
    def _decompress_single_part_with_tracking(self, compressed_data: bytes, width: int, height: int, 
                                            has_alpha: bool, compr: int, part_index: int) -> Tuple[Optional[bytes], int]:
        """Decompress single part and track actual bytes consumed"""
        if not compressed_data or len(compressed_data) < 4:
            return None, 0
        
        expected_pixels = width * height
        bytes_per_pixel = 4 if has_alpha else 3
        original_size = len(compressed_data)
        
        try:
            if compr == 0:
                # RAW format - calculate exact consumption
                bytes_per_pixel_raw = 3 if has_alpha else 2
                row_bytes = width * bytes_per_pixel_raw
                aligned_row_bytes = (row_bytes + 3) & ~3
                expected_consumption = height * aligned_row_bytes
                
                result = ImageDecompressor.decompress_raw_aligned(
                    compressed_data, width, height, has_alpha
                )
                
                if result:
                    actual_consumed = min(expected_consumption, original_size)
                    return result, actual_consumed
            else:
                # RLE format - estimate consumption by parsing
                result = ImageDecompressor.decompress_hk89_rle(
                    compressed_data, width, height, has_alpha
                )
                
                if result and len(result) >= expected_pixels * bytes_per_pixel:
                    # Estimate bytes consumed by simulating RLE parsing
                    consumed = self._estimate_rle_consumption(
                        compressed_data, expected_pixels, has_alpha
                    )
                    return result, min(consumed, original_size)
        
        except Exception as e:
            logger.debug(f"  Decompression failed for part {part_index}: {e}")
        
        return None, 0
    
    def _estimate_rle_consumption(self, compressed_data: bytes, expected_pixels: int, has_alpha: bool) -> int:
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
                
                count_byte = compressed_data[input_pos]
                input_pos += 1
                
                if count_byte == 0:
                    # Single pixel
                    if has_alpha and input_pos < len(compressed_data):
                        input_pos += 1  # Alpha
                    if input_pos + 1 < len(compressed_data):
                        input_pos += 2  # RGB565
                    pixels_processed += 1
                elif count_byte & 0x80:
                    # RLE mode
                    rle_count = count_byte & 0x7F
                    if has_alpha and input_pos < len(compressed_data):
                        input_pos += 1  # Alpha
                    if input_pos + 1 < len(compressed_data):
                        input_pos += 2  # RGB565
                    pixels_processed += rle_count
                else:
                    # Literal mode
                    literal_count = count_byte
                    for _ in range(literal_count):
                        if has_alpha and input_pos < len(compressed_data):
                            input_pos += 1  # Alpha
                        if input_pos + 1 < len(compressed_data):
                            input_pos += 2  # RGB565
                        pixels_processed += 1
                        if input_pos >= len(compressed_data):
                            break
            
            # Align to 4 bytes
            while input_pos % 4 != 0 and input_pos < len(compressed_data):
                input_pos += 1
            
            return min(input_pos, len(compressed_data))
            
        except Exception:
            # Conservative estimate if parsing fails
            return min(expected_pixels * 2 + 50, len(compressed_data))
    
    def extract_all_images(self, output_dir: str):
        """Extract all images"""
        logger.info("=== EXTRACTING IMAGES ===")
        
        for block in self.blocks:
            block_index = self.blocks.index(block) + 1
            filename = block.get_short_name(block_index)
            
            logger.info(f"Extracting {filename}")
            self.extract_image(block, output_dir, filename)
    
    def save_config(self, output_dir: str):
        """Save simple configuration for reconstruction"""
        # Detect resolution from background or preview blocks
        resolution = {'width': 240, 'height': 240}  # Default
        for block in self.blocks:
            if block.blocktype in {0x02, 0x82, 0x01, 0x81}:  # Background or preview
                resolution = {'width': block.sx, 'height': block.sy}
                break
        
        # Create blocks array with all necessary data for reconstruction
        blocks = []
        for block in self.blocks:
            block_index = self.blocks.index(block) + 1
            filename = block.get_short_name(block_index)
            
            # Determine image filename based on parts
            if block.parts > 1:
                # For multi-part blocks, reference the combined image
                image_filename = f"{filename}_combined.png"
                # Also store individual part filenames
                part_filenames = [f"{filename}_{i}.png" for i in range(block.parts)]
            else:
                image_filename = f"{filename}.png"
                part_filenames = []
            
            block_data = {
                'fname': image_filename,
                'blocktype': block.blocktype,
                'sx': block.sx,
                'sy': block.sy,
                'posX': block.posX,
                'posY': block.posY,
                'parts': block.parts,
                'align': block.align,
                'compr': block.compr,
                'centX': block.centX,
                'centY': block.centY,
                'picidx': block.picidx
            }
            
            # Add part filenames if multi-part
            if part_filenames:
                block_data['part_filenames'] = part_filenames
            
            blocks.append(block_data)
        
        # Simple configuration structure
        config = {
            'resolution': resolution,
            'blocks': blocks
        }
        
        output_file = f"{output_dir}/config.json"
        try:
            with open(output_file, 'w', encoding='utf-8') as f:
                json.dump(config, f, indent=2, ensure_ascii=False)
            logger.info(f"✓ Saved reconstruction config: {output_file}")
        except Exception as e:
            logger.error(f"Error saving config: {e}")
    
    def process(self, filename: str) -> bool:
        """Main processing function"""
        start_time = time.time()
        logger.info("="*50)
        logger.info("HK89 DIAL DECOMPRESSOR - SIMPLE RECONSTRUCTION")
        logger.info("="*50)
        
        base_filename = Path(filename).name
        logger.info(f"Processing: {base_filename}")
        
        # Load and parse
        if not self.load_file(filename):
            return False
        
        self.parse_blocks()
        self.calculate_picture_sizes()
        
        # Create output directory
        basename = Path(filename).stem
        output_dir = f"_{basename}"
        os.makedirs(output_dir, exist_ok=True)
        
        # Extract images
        self.extract_all_images(output_dir)
        
        # Save configuration
        self.save_config(output_dir)
        
        # Complete
        elapsed = time.time() - start_time
        logger.info("="*50)
        logger.info(f"✅ COMPLETED in {elapsed:.2f}s")
        logger.info(f"Output directory: {output_dir}")
        logger.info("="*50)
        
        return True

def main():
    """Main function"""
    parser = argparse.ArgumentParser(
        description='HK89 Dial Decompressor - Simple Reconstruction Version'
    )
    
    parser.add_argument('filename', help='HK89 .bin file to decompress')
    parser.add_argument('--verbose', '-v', action='store_true', 
                       help='Enable verbose debug logging')
    
    args = parser.parse_args()
    
    # Set logging level
    if args.verbose:
        logging.getLogger().setLevel(logging.DEBUG)
    
    # Process file
    decompressor = SimpleHKDecompressor()
    success = decompressor.process(args.filename)
    
    sys.exit(0 if success else 1)

if __name__ == "__main__":
    main()

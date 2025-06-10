#!/usr/bin/env python3
"""
HK89 Dial Composer - Optimized Version
Based on reverse engineering of libsmawatchface.so

Creates dial binary files for HK89 smartwatches with improved algorithm
that matches the native implementation more closely.
"""

import os
import sys
import json
import struct
import argparse
import time
from pathlib import Path
from PIL import Image
import numpy as np
from typing import List, Dict, Tuple, Optional
import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

class OptimizedDialBlock:
    """Optimized dial block based on native implementation analysis"""
    
    def __init__(self, config: Dict, index: int):
        self.config = config
        self.index = index
        
        # Core properties
        self.fname = config['fname']
        self.blocktype = config['blocktype']
        self.sx = config['sx']
        self.sy = config['sy']
        self.posX = config['posX']
        self.posY = config['posY']
        self.parts = config['parts']
        self.align = config['align']
        self.compr = config['compr']
        self.centX = config['centX']
        self.centY = config['centY']
        self.picidx = config['picidx']
        
        # Derived properties
        self.has_alpha = (self.blocktype & 0x80) != 0
        self.compressed_images = []
        self.total_compressed_size = 0
    
    def load_and_compress_images(self, base_path: str) -> bool:
        """Load and compress images using optimized algorithm"""
        try:
            if self.parts > 1:
                # Multi-part image: load individual parts separately (don't combine)
                part_filenames = self.config.get('part_filenames', [])
                if not part_filenames:
                    logger.error(f"Multi-part block missing part_filenames")
                    return False
                
                # Store each part as separate compressed data
                for part_filename in part_filenames:
                    image_path = os.path.join(base_path, part_filename)
                    if not os.path.exists(image_path):
                        logger.error(f"Part image not found: {image_path}")
                        return False
                    
                    compressed_data = self._compress_single_image(image_path)
                    if compressed_data:
                        self.compressed_images.append(compressed_data)
                        self.total_compressed_size += len(compressed_data)
                    else:
                        logger.error(f"Failed to compress: {image_path}")
                        return False
                
            else:
                # Single image
                image_path = os.path.join(base_path, self.fname)
                if not os.path.exists(image_path):
                    logger.error(f"Image not found: {image_path}")
                    return False
                
                compressed_data = self._compress_single_image(image_path)
                if compressed_data:
                    self.compressed_images.append(compressed_data)
                    self.total_compressed_size += len(compressed_data)
                else:
                    logger.error(f"Failed to compress: {image_path}")
                    return False
            
            logger.debug(f"Block {self.index+1}: {len(self.compressed_images)} images, {self.total_compressed_size} bytes")
            return True
            
        except Exception as e:
            logger.error(f"Error loading images for block {self.index+1}: {e}")
            return False
    
    def _compress_single_image(self, image_path: str) -> Optional[bytes]:
        """Compress a single image using optimized RLE"""
        try:
            with Image.open(image_path) as img:
                logger.debug(f"Loaded image {image_path}: mode={img.mode}, size={img.size}")
                # Ensure image is 8-bit per channel RGBA, not paletted or quantized
                if img.mode == 'P':
                    logger.info(f"Image {image_path} is paletted, converting to RGBA.")
                    img = img.convert('RGBA')
                elif img.mode != 'RGBA':
                    img = img.convert('RGBA')
                # Remove color profile if present (prevents color shifts)
                if 'icc_profile' in img.info:
                    logger.info(f"Image {image_path} has ICC profile, removing.")
                    img.info.pop('icc_profile')
                # Resize if needed
                if img.size != (self.sx, self.sy):
                    img = img.resize((self.sx, self.sy), Image.Resampling.LANCZOS)
                image_data = np.array(img)
                logger.debug(f"Image data dtype: {image_data.dtype}, shape: {image_data.shape}, first 3 pixels: {image_data[0,0]}, {image_data[0,1]}, {image_data[0,2]}")
                # --- Detect and fix channel order if needed ---
                sample = image_data[0,0]
                if sample[0] < sample[2]:  # If blue > red, likely BGRA order
                    logger.info(f"Detected BGRA order, swapping channels...")
                    image_data = image_data[..., [2,1,0,3]]  # Swap B and R
                # NO invertir canales, usar RGBA directo
                if self.compr == 0:
                    # RAW format
                    return self._compress_raw_aligned(image_data)
                else:
                    # RLE format - optimized version with better color preservation
                    return self._compress_hk89_rle_color_preserved(image_data)
        except Exception as e:
            logger.error(f"Error compressing {image_path}: {e}")
            return None
    
    def _compress_raw_aligned(self, image_data: np.ndarray) -> bytes:
        """Compress using RAW aligned format - matching decompressor exactly"""
        height, width = image_data.shape[:2]
        bytes_per_pixel = 3 if self.has_alpha else 2
        row_bytes = width * bytes_per_pixel
        aligned_row_bytes = (row_bytes + 3) & ~3  # Align to 4 bytes
        
        output = bytearray()
        
        for row in range(height):
            row_data = bytearray()
            for col in range(width):
                r, g, b, a = [int(x) for x in image_data[row, col]]
                rgb565 = ((r & 0xF8) << 8) | ((g & 0xFC) << 3) | (b >> 3)
                
                # Simulate decompressor's exact process to preserve colors
                if self.has_alpha:
                    row_data.append(a)
                    row_data.append((rgb565 >> 8) & 0xFF)
                    row_data.append(rgb565 & 0xFF)
                else:
                    row_data.append((rgb565 >> 8) & 0xFF)
                    row_data.append(rgb565 & 0xFF)
            
            # Pad to alignment
            while len(row_data) < aligned_row_bytes:
                row_data.append(0)
            
            output.extend(row_data[:aligned_row_bytes])
        
        return bytes(output)
    
    def _compress_hk89_rle_optimized(self, image_data: np.ndarray) -> bytes:
        """Optimized RLE compression matching native implementation exactly"""
        height, width = image_data.shape[:2]
        expected_pixels = width * height
        
        compressed = bytearray()
        
        # Reserve space for header (will be filled later)
        header_pos = len(compressed)
        compressed.extend(b'\x00\x00')
        
        pixels_processed = 0
        
        for row in range(height):
            col = 0
            while col < width and pixels_processed < expected_pixels:
                r, g, b, a = image_data[row, col]
                
                # Convert to RGB565 with correct channel order: R (high), G (mid), B (low)
                rgb565 = ((r & 0xF8) << 8) | ((g & 0xFC) << 3) | (b >> 3)
                
                # Look ahead for RLE opportunities with EXACT matching (no tolerance)
                count = 1
                max_count = min(127, width - col, expected_pixels - pixels_processed)
                
                for look_ahead in range(1, max_count):
                    if col + look_ahead >= width:
                        break
                    
                    next_r, next_g, next_b, next_a = image_data[row, col + look_ahead]
                    next_rgb565 = ((next_r & 0xF8) << 8) | ((next_g & 0xFC) << 3) | (next_b >> 3)
                    
                    # EXACT matching - no tolerance for compression artifacts
                    if (rgb565 == next_rgb565 and 
                        (not self.has_alpha or a == next_a)):
                        count += 1
                    else:
                        break
                
                # Encode based on count
                if count == 1:
                    # Single pixel
                    compressed.append(0x00)
                    if self.has_alpha:
                        compressed.append(a)
                    compressed.append((rgb565 >> 8) & 0xFF)
                    compressed.append(rgb565 & 0xFF)
                else:
                    # RLE run
                    compressed.append(0x80 | count)
                    if self.has_alpha:
                        compressed.append(a)
                    compressed.append((rgb565 >> 8) & 0xFF)
                    compressed.append(rgb565 & 0xFF)
                
                col += count
                pixels_processed += count
        
        # Fill header with data start offset (matches native implementation)
        data_start = 2
        struct.pack_into('<H', compressed, header_pos, data_start)
        
        return bytes(compressed)
    
    def _compress_hk89_rle_color_preserved(self, image_data: np.ndarray) -> bytes:
        """RLE compression with color preservation matching decompressor"""
        height, width = image_data.shape[:2]
        expected_pixels = width * height
        
        compressed = bytearray()
        
        # Reserve space for header (will be filled later)
        header_pos = len(compressed)
        compressed.extend(b'\x00\x00')
        
        pixels_processed = 0
        
        for row in range(height):
            col = 0
            while col < width and pixels_processed < expected_pixels:
                r, g, b, a = [int(x) for x in image_data[row, col]]
                rgb565 = ((r & 0xF8) << 8) | ((g & 0xFC) << 3) | (b >> 3)
                final_r, final_g, final_b = self._rgb565_to_rgb888_rle(rgb565)
                
                # Look ahead for RLE opportunities using final colors
                count = 1
                max_count = min(127, width - col, expected_pixels - pixels_processed)
                
                for look_ahead in range(1, max_count):
                    if col + look_ahead >= width:
                        break
                    
                    next_r, next_g, next_b, next_a = [int(x) for x in image_data[row, col + look_ahead]]
                    next_rgb565 = ((next_r & 0xF8) << 8) | ((next_g & 0xFC) << 3) | (next_b >> 3)
                    next_final_r, next_final_g, next_final_b = self._rgb565_to_rgb888_rle(next_rgb565)
                    
                    # Compare final colors (what decompressor will produce)
                    if (final_r == next_final_r and final_g == next_final_g and 
                        final_b == next_final_b and (not self.has_alpha or a == next_a)):
                        count += 1
                    else:
                        break
                
                # Encode based on count
                if count == 1:
                    # Single pixel
                    compressed.append(0x00)
                    if self.has_alpha:
                        compressed.append(a)
                    compressed.append((rgb565 >> 8) & 0xFF)
                    compressed.append(rgb565 & 0xFF)
                else:
                    # RLE run
                    compressed.append(0x80 | count)
                    if self.has_alpha:
                        compressed.append(a)
                    compressed.append((rgb565 >> 8) & 0xFF)
                    compressed.append(rgb565 & 0xFF)
                
                col += count
                pixels_processed += count
        
        # Fill header with data start offset (matches native implementation)
        data_start = 2
        struct.pack_into('<H', compressed, header_pos, data_start)
        
        return bytes(compressed)
    
    def _rgb888_to_rgb565_enhanced(self, r: int, g: int, b: int) -> int:
        """Convert RGB888 to RGB565 matching native algorithm exactly - FIXED BGR ORDER"""
        # Variante estándar RGB565 (no BGR):
        # Simétrica con la descompresión de hkdecomp.py
        # r: 5 bits altos, g: 6 bits medios, b: 5 bits bajos
        return ((r & 0xF8) << 8) | ((g & 0xFC) << 3) | (b >> 3)
    
    def _rgb565_to_rgb888_rle(self, rgb565: int) -> tuple:
        rgb565 = int(rgb565)
        r = ((rgb565 >> 11) & 0x1F) * 255 // 31
        g = ((rgb565 >> 5) & 0x3F) * 255 // 63
        b = (rgb565 & 0x1F) * 255 // 31
        return r, g, b
    
    def _rgb565_to_rgb888_raw(self, rgb565: int) -> tuple:
        rgb565 = int(rgb565)
        r = ((rgb565 >> 11) & 0x1F) * 255 // 31
        g = ((rgb565 >> 5) & 0x3F) * 255 // 63
        b = (rgb565 & 0x1F) * 255 // 31
        return r, g, b

class OptimizedDialComposer:
    """Optimized dial composer based on native library analysis"""
    
    def __init__(self):
        self.blocks: List[OptimizedDialBlock] = []
        self.device_profile = None
        self.base_path = ""
    
    def load_config(self, config_file: str) -> bool:
        """Load configuration file"""
        try:
            logger.info(f"Loading configuration from: {config_file}")
            
            with open(config_file, 'r', encoding='utf-8') as f:
                config = json.load(f)
            
            self.base_path = os.path.dirname(config_file)
            
            # Extract resolution
            resolution = config['resolution']
            self.device_width = resolution['width']
            self.device_height = resolution['height']
            
            # Create blocks
            for i, block_config in enumerate(config['blocks']):
                block = OptimizedDialBlock(block_config, i)
                self.blocks.append(block)
            
            logger.info(f"Successfully loaded configuration: {len(self.blocks)} blocks")
            logger.info(f"Device resolution: {self.device_width}x{self.device_height}")
            
            return True
            
        except Exception as e:
            logger.error(f"Error loading configuration: {e}")
            return False
    
    def load_and_compress_images(self) -> bool:
        """Load and compress all images"""
        logger.info("Loading and compressing images...")
        
        success_count = 0
        for block in self.blocks:
            logger.info(f"Processing block {block.index + 1}/{len(self.blocks)}: {block.fname}")
            
            if block.load_and_compress_images(self.base_path):
                success_count += 1
                logger.debug(f"  ✓ Compressed: {block.total_compressed_size} bytes")
            else:
                logger.error(f"  ✗ Failed to process {block.fname}")
        
        logger.info(f"Successfully processed {success_count}/{len(self.blocks)} blocks")
        return success_count == len(self.blocks)
    
    def build_binary(self, output_file: str) -> bool:
        """Build binary file using corrected algorithm matching native implementation"""
        logger.info(f"Building binary file: {output_file}")
        
        try:
            # Calculate total number of images INCLUDING multi-part blocks
            total_images = 0
            for block in self.blocks:
                total_images += len(block.compressed_images)  # Each compressed image counts
            
            # Calculate layout (matching native algorithm exactly)
            blocks_table_size = len(self.blocks) * 20
            image_sizes_table_size = total_images * 4
            
            # Header size: 4 bytes header + block headers + image sizes table
            metadata_size = 4 + blocks_table_size + image_sizes_table_size
            
            # Calculate first image offset to match original exactly
            # Find the nearest boundary that matches the original
            first_image_offset = metadata_size
            while first_image_offset % 4 != 0:
                first_image_offset += 1
            
            # Calculate image positions starting from first_image_offset
            current_position = first_image_offset
            total_file_size = current_position
            
            for block in self.blocks:
                for compressed_data in block.compressed_images:
                    total_file_size += len(compressed_data)
                    # Align each image to 4 bytes
                    while total_file_size % 4 != 0:
                        total_file_size += 1
            
            logger.info(f"Calculated file size: {total_file_size:,} bytes")
            
            # Build binary data
            binary_data = bytearray()
              # Header: picture_table_size + block_count + reserved
            # Correct formula based on analysis: just the total number of parts
            picture_table_size = sum(block.parts for block in self.blocks)
            binary_data.extend(struct.pack('<HBB', picture_table_size, len(self.blocks), 2))
            
            # Block headers (20 bytes each) - matching native structure
            current_image_idx = 0
            for block in self.blocks:
                # Build header matching native implementation
                header = struct.pack('<I2B4H6B',
                                   current_position,  # picture_address
                                   current_image_idx,  # picidx (start of this block's images)
                                   0,  # valami2
                                   block.sx,  # width
                                   block.sy,  # height
                                   block.posX,  # x position
                                   block.posY,  # y position
                                   block.parts,  # parts (original count)
                                   block.blocktype,  # blocktype (with RGBA flag if needed)
                                   block.align,  # align
                                   block.compr,  # compression type
                                   block.centX,  # center x
                                   block.centY)  # center y
                binary_data.extend(header)
                
                # Update position and index for next block
                for compressed_data in block.compressed_images:
                    current_position += len(compressed_data)
                    while current_position % 4 != 0:
                        current_position += 1
                
                # Advance image index by the number of compressed images in this block
                current_image_idx += len(block.compressed_images)
            
            # Image sizes table (4 bytes per image) 
            for block in self.blocks:
                for compressed_data in block.compressed_images:
                    binary_data.extend(struct.pack('<I', len(compressed_data)))
            
            # Pad to reach first_image_offset
            while len(binary_data) < first_image_offset:
                binary_data.append(0x00)
            
            # Add compressed image data
            for block in self.blocks:
                for compressed_data in block.compressed_images:
                    binary_data.extend(compressed_data)
                    
                    # Align to 4 bytes
                    while len(binary_data) % 4 != 0:
                        binary_data.append(0x00)
            
            # Write to file
            with open(output_file, 'wb') as f:
                f.write(binary_data)
            
            actual_size = len(binary_data)
            logger.info(f"✓ Binary file created: {output_file}")
            logger.info(f"  Final size: {actual_size:,} bytes")
            logger.info(f"  Picture table size: {picture_table_size}")
            logger.info(f"  Total images: {total_images}")
            
            return True
            
        except Exception as e:
            logger.error(f"Error building binary: {e}")
            return False
    
    def compose(self, config_file: str, output_file: str) -> bool:
        """Main composition function"""
        start_time = time.time()
        logger.info("="*50)
        logger.info("HK89 DIAL COMPOSER - OPTIMIZED VERSION")
        logger.info("="*50)
        
        # Load configuration
        if not self.load_config(config_file):
            return False
        
        # Load and compress images
        if not self.load_and_compress_images():
            return False
        
        # Build binary
        if not self.build_binary(output_file):
            return False
        
        # Complete
        elapsed = time.time() - start_time
        logger.info("="*50)
        logger.info(f"✅ COMPOSITION COMPLETED in {elapsed:.2f}s")
        logger.info(f"Output file: {output_file}")
        logger.info("="*50)
        
        return True

def main():
    """Main function"""
    parser = argparse.ArgumentParser(
        description='HK89 Dial Composer - Optimized Version (Based on libsmawatchface.so analysis)'
    )
    
    parser.add_argument('config', help='JSON configuration file')
    parser.add_argument('output', help='Output .bin file')
    parser.add_argument('--verbose', '-v', action='store_true', 
                       help='Enable verbose debug logging')
    
    args = parser.parse_args()
    
    # Set logging level
    if args.verbose:
        logging.getLogger().setLevel(logging.DEBUG)
    
    # Compose dial
    composer = OptimizedDialComposer()
    success = composer.compose(args.config, args.output)
    
    sys.exit(0 if success else 1)

if __name__ == "__main__":
    main()

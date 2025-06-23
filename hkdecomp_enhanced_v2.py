#!/usr/bin/env python3

"""
Enhanced HK89 Watch Dial Decompiler - SDK-Aware Version
Uses the proven decompression logic from the original decompiler
but adds enhanced metadata extraction based on Jieli SDK analysis.
"""

import struct
import os
import json
import argparse
from PIL import Image
import sys

# Import the working components from the original hkdecomp.py
from hkdecomp import SimpleHKDecompressor, DialBlock, ImageDecompressor

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

class HKDialDecompilerEnhanced:
    def __init__(self, filename):
        self.filename = filename
        self.output_dir = None
        # Use the proven decompressor from the original
        self.decompressor = SimpleHKDecompressor()
        
    def decompile_with_metadata(self, output_dir):
        """Enhanced decompilation with SDK-style metadata"""
        self.output_dir = output_dir
        
        # Load and parse using the proven original logic
        if not self.decompressor.load_file(self.filename):
            return False
            
        self.decompressor.parse_blocks()
        self.decompressor.calculate_picture_sizes()
        
        # Create output directory
        os.makedirs(output_dir, exist_ok=True)
        
        # Extract images using the proven original method
        self.decompressor.extract_all_images(output_dir)
        
        # Create enhanced JSON metadata
        self.create_enhanced_json(output_dir)
        
        print(f"Enhanced decompilation complete: {len(self.decompressor.blocks)} blocks extracted")
        return True
        
    def create_enhanced_json(self, output_dir):
        """Create enhanced JSON with SDK-style metadata"""
        enhanced_data = {
            "format_version": "2.0",
            "source_format": "hk_traditional_enhanced",
            "metadata": {
                "total_blocks": len(self.decompressor.blocks),
                "source_file": self.filename,
                "source_size": len(self.decompressor.main_buffer),
                "picture_table_size": struct.unpack('<H', self.decompressor.main_buffer[0:2])[0],
                "block_count": self.decompressor.main_buffer[2]
            },
            "header": {
                "format": "hk_traditional",
                "sdk_enhanced": True
            },
            "blocks": []
        }
        
        # Convert each DialBlock to enhanced format
        for i, block in enumerate(self.decompressor.blocks):
            # Get the short name for this block type
            short_name = block.get_short_name(i)
            
            # Determine format based on alpha support
            pixel_format = "ARGB8565" if block.has_alpha else "RGB565"
            
            # Determine compression type
            compression = COMPRESS_TYPE_MAP.get(block.compr, "unknown")
            
            block_data = {
                "picidx": block.picidx,
                "blocktype": block.blocktype,
                "x": block.posX,
                "y": block.posY,
                "w": block.sx,
                "h": block.sy,
                "parts": block.parts,
                "align": block.align,
                "center_x": block.centX,
                "center_y": block.centY,
                "format": pixel_format,
                "compression": compression,
                "has_alpha": block.has_alpha,
                "data_offset": block.picture_address,
                "data_length": self.decompressor.picture_sizes[i] if i < len(self.decompressor.picture_sizes) else 0,
                "header_offset": 4 + (i * 20),
                "short_name": short_name,
                "sdk_metadata": {
                    "original_compr": block.compr,
                    "original_valami2": block.valami2,
                    "estimated_pixel_format": PIXEL_FORMAT_MAP.get(2, "RGB565"),  # Default to RGB565
                    "jieli_compatible": True
                }
            }
            
            # Add image file references based on parts
            if block.parts > 1:
                # Multi-part images
                block_data["image_files"] = {
                    "individual_parts": [f"{short_name}_{j}.png" for j in range(block.parts)],
                    "combined_strip": f"{short_name}_combined.png"
                }
                block_data["primary_image"] = f"{short_name}_combined.png"
            else:
                # Single image
                block_data["image_file"] = f"{short_name}.png"
                block_data["primary_image"] = f"{short_name}.png"
                
            enhanced_data["blocks"].append(block_data)
            
        # Save enhanced JSON
        json_path = os.path.join(output_dir, 'dial_enhanced.json')
        with open(json_path, 'w', encoding='utf-8') as f:
            json.dump(enhanced_data, f, indent=2, ensure_ascii=False)
            
        print(f"Enhanced JSON metadata saved to: {json_path}")
        
        # Also save zzuler-style JSON for compatibility
        self.create_zzuler_json(output_dir, enhanced_data)
        
    def create_zzuler_json(self, output_dir, enhanced_data):
        """Create zzuler-compatible JSON"""
        zzuler_data = {
            "blocks": []
        }
        
        for block in enhanced_data["blocks"]:
            zzuler_block = {
                "picidx": block["picidx"],
                "blocktype": block["blocktype"],
                "x": block["x"],
                "y": block["y"],
                "w": block["w"],
                "h": block["h"],
                "image_file": block["primary_image"]
            }
            zzuler_data["blocks"].append(zzuler_block)
            
        # Save zzuler JSON
        zzuler_path = os.path.join(output_dir, 'dialzz_style.json')
        with open(zzuler_path, 'w', encoding='utf-8') as f:
            json.dump(zzuler_data, f, indent=2, ensure_ascii=False)
            
        print(f"Zzuler-style JSON saved to: {zzuler_path}")

def main():
    parser = argparse.ArgumentParser(description='Enhanced HK89 Watch Dial Decompiler (SDK-Aware)')
    parser.add_argument('input_file', help='Input .bin file to decompile')
    parser.add_argument('-o', '--output', default='output_enhanced', help='Output directory')
    parser.add_argument('-v', '--verbose', action='store_true', help='Verbose output')
    
    args = parser.parse_args()
    
    if not os.path.exists(args.input_file):
        print(f"Error: Input file '{args.input_file}' not found")
        sys.exit(1)
        
    decompiler = HKDialDecompilerEnhanced(args.input_file)
    
    if decompiler.decompile_with_metadata(args.output):
        print("Enhanced decompilation successful!")
    else:
        print("Enhanced decompilation failed!")
        sys.exit(1)

if __name__ == '__main__':
    main()

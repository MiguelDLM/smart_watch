#!/usr/bin/env python3

"""
Enhanced HK89 Watch Dial Composer v2
Recompiles dial binaries from enhanced JSON metadata and extracted images.
Uses the original composer logic for proven compatibility.
"""

import struct
import os
import json
import argparse
from PIL import Image
import sys

# Import the working composer from the original
from hkcomposer import OptimizedDialComposer

class HKDialComposerEnhanced:
    def __init__(self):
        self.enhanced_data = None
        self.output_dir = None
        
    def load_enhanced_json(self, json_path):
        """Load enhanced JSON configuration"""
        try:
            with open(json_path, 'r', encoding='utf-8') as f:
                self.enhanced_data = json.load(f)
                
            self.output_dir = os.path.dirname(json_path)
            
            print(f"Loaded enhanced configuration with {len(self.enhanced_data['blocks'])} blocks")
            return True
            
        except Exception as e:
            print(f"Error loading enhanced JSON: {e}")
            return False
            
    def convert_to_simple_config(self):
        """Convert enhanced JSON to simple zzuler-style config for the original composer"""
        simple_config = {
            "dial_name": "kronos_recompiled",
            "blocks": []
        }
        
        # Map block types from enhanced to zzuler format
        blocktype_to_type = {
            1: "BLK_PREVI",   # Preview
            2: "BLK_BGIMG",   # Background
            10: "BLK_HOUR",   # Digital hour
            11: "BLK_MIN",    # Digital minute
            20: "BLK_MON",    # Month
            21: "BLK_DAY",    # Day
            22: "BLK_AMPM",   # AM/PM
            23: "BLK_WEEK",   # Weekday
            30: "BLK_BAT",    # Battery
            40: "BLK_STP",    # Steps
            50: "BLK_HR",     # Heart rate
            60: "BLK_CAL",    # Calories
            80: "BLK_ARMH",   # Analog hour hand
            81: "BLK_ARMM"    # Analog minute hand
        }
        
        for block in self.enhanced_data["blocks"]:
            # Map enhanced format back to zzuler format
            block_type = blocktype_to_type.get(block["blocktype"], "BLK_BGIMG")
            
            # Determine frames count and image file
            parts = block.get("parts", 1)
            if parts > 1:
                # Multi-part image - use combined strip
                primary_image = block.get("primary_image", "")
                if "_combined.png" in primary_image:
                    fname = primary_image
                else:
                    fname = primary_image.replace(".png", "_combined.png")
                frms = parts
            else:
                # Single image
                fname = block.get("primary_image", block.get("image_file", ""))
                frms = 1
            
            simple_block = {
                "type": block_type,
                "frms": frms,
                "fname": fname,
                "reuse": False,
                "colsp": "RGB",
                "width": block["w"],
                "height": block["h"],
                "posx": block["x"],
                "posy": block["y"],
                "alnx": block.get("align", 0),
                "ctx": block.get("center_x", 0),
                "cty": block.get("center_y", 0),
                "picidx": block["picidx"]
            }
            
            simple_config["blocks"].append(simple_block)
            
        return simple_config
        
    def compile_dial(self, output_path):
        """Compile dial binary from enhanced configuration"""
        if not self.enhanced_data:
            print("No configuration loaded")
            return False
            
        # Convert to simple config format
        simple_config = self.convert_to_simple_config()
        
        # Create a temporary JSON file for the original composer
        temp_json_path = os.path.join(self.output_dir, "temp_config.json")
        
        try:
            with open(temp_json_path, 'w', encoding='utf-8') as f:
                json.dump(simple_config, f, indent=2)
                
            # Debug: Print the temporary config for verification
            print(f"Generated temporary config for {len(simple_config['blocks'])} blocks")
            for i, block in enumerate(simple_config['blocks'][:3]):  # Show first 3 blocks
                print(f"  Block {i}: {block['type']}, frms={block['frms']}, fname={block['fname']}")
                
            # Use the original proven composer
            composer = OptimizedDialComposer()
            
            # Set the working directory to where the images are
            original_cwd = os.getcwd()
            os.chdir(self.output_dir)
            
            try:
                success = composer.compose("temp_config.json", output_path)
                
                if success:
                    print(f"Successfully compiled dial: {output_path}")
                    
                    # Copy the output to the original directory if compiled in subdirectory
                    if not os.path.isabs(output_path):
                        final_output = os.path.join(original_cwd, output_path)
                        if os.path.exists(output_path):
                            import shutil
                            shutil.copy2(output_path, final_output)
                            print(f"Output copied to: {final_output}")
                else:
                    print("Compilation failed")
                    
            finally:
                os.chdir(original_cwd)
                
                # Clean up temp file
                if os.path.exists(temp_json_path):
                    os.remove(temp_json_path)
                    
            return success
            
        except Exception as e:
            print(f"Error during compilation: {e}")
            return False
            
    def verify_images_exist(self):
        """Verify that all referenced image files exist"""
        missing_files = []
        
        for block in self.enhanced_data["blocks"]:
            image_file = block.get("primary_image") or block.get("image_file")
            if image_file:
                image_path = os.path.join(self.output_dir, image_file)
                if not os.path.exists(image_path):
                    missing_files.append(image_file)
                    
        if missing_files:
            print(f"Missing image files: {missing_files}")
            return False
            
        print("All referenced image files found")
        return True
        
    def create_test_config(self, output_path):
        """Create a test configuration for validation"""
        test_config = {
            "format_version": "2.0",
            "source_format": "test_enhanced",
            "blocks": [
                {
                    "picidx": 0,
                    "blocktype": 1,
                    "x": 0,
                    "y": 0,
                    "w": 240,
                    "h": 240,
                    "primary_image": "background.png"
                }
            ]
        }
        
        with open(output_path, 'w', encoding='utf-8') as f:
            json.dump(test_config, f, indent=2)
            
        print(f"Test configuration created: {output_path}")

def main():
    parser = argparse.ArgumentParser(description='Enhanced HK89 Watch Dial Composer v2')
    parser.add_argument('action', choices=['compile', 'test', 'verify'], 
                        help='Action to perform')
    parser.add_argument('-i', '--input', help='Input enhanced JSON configuration file')
    parser.add_argument('-o', '--output', help='Output binary file path')
    parser.add_argument('-v', '--verbose', action='store_true', help='Verbose output')
    
    args = parser.parse_args()
    
    composer = HKDialComposerEnhanced()
    
    if args.action == 'test':
        output_path = args.output or 'test_enhanced_config.json'
        composer.create_test_config(output_path)
        
    elif args.action == 'verify':
        if not args.input:
            print("Error: Input JSON file required for verify action")
            sys.exit(1)
            
        if composer.load_enhanced_json(args.input):
            if composer.verify_images_exist():
                print("✓ All images verified successfully")
            else:
                print("✗ Some images are missing")
                sys.exit(1)
                
    elif args.action == 'compile':
        if not args.input:
            print("Error: Input JSON file required for compile action")
            sys.exit(1)
            
        if not os.path.exists(args.input):
            print(f"Error: Input file '{args.input}' not found")
            sys.exit(1)
            
        output_path = args.output or 'dial_recompiled.bin'
        
        if composer.load_enhanced_json(args.input):
            if composer.verify_images_exist():
                if composer.compile_dial(output_path):
                    print("✓ Compilation successful!")
                else:
                    print("✗ Compilation failed!")
                    sys.exit(1)
            else:
                print("✗ Cannot compile: missing image files")
                sys.exit(1)

if __name__ == '__main__':
    main()

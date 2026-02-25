import os
import sys
import shutil
import json
import logging
from comp_decomp import extract_dial, BLOCK_TYPE_NAMES

logging.basicConfig(level=logging.INFO, format='%(levelname)s: %(message)s')

def extract_all(dials_dir, assets_dir):
    dial_files = [f for f in os.listdir(dials_dir) if f.endswith('.bin')]
    
    dial_count = 100 # start numbering from 100 for extracted presets
    for dial_file in dial_files:
        bin_path = os.path.join(dials_dir, dial_file)
        dial_name = os.path.splitext(dial_file)[0]
        
        # Temp dir for extraction
        temp_dir = os.path.join(dials_dir, f"temp_{dial_name}")
        if os.path.exists(temp_dir):
            shutil.rmtree(temp_dir)
            
        try:
            extract_dial(bin_path, temp_dir)
            logging.info(f"Successfully decompiled {dial_file}")
            
            # Read JSON to classify blocks
            json_path = os.path.join(temp_dir, "dial_desc.json")
            if not os.path.exists(json_path):
                continue
                
            with open(json_path, 'r') as f:
                desc = json.load(f)
                
            custom_dir = os.path.join(assets_dir, f"dial_customize_{dial_count}")
            os.makedirs(custom_dir, exist_ok=True)
            dial_count += 1
            
            blocks = desc.get('blocks', [])
            for block in blocks:
                btype = block.get('type')
                fname = block.get('fname')
                if not fname: continue
                
                # Check directory inside temp containing images
                img_dir = os.path.join(temp_dir, fname)
                if not os.path.isdir(img_dir): continue
                
                # Copy images to corresponding paths
                images = sorted([i for i in os.listdir(img_dir) if i.endswith('.png')])
                if not images: continue
                
                target_path = None
                if btype == 'BLK_HOUR':
                    target_path = os.path.join(custom_dir, "time", "digital", "1", "hour_minute")
                elif btype == 'BLK_MIN':
                    target_path = os.path.join(custom_dir, "time", "digital", "1", "hour_minute")
                elif btype == 'BLK_SEC':
                    target_path = os.path.join(custom_dir, "time", "digital", "1", "second")
                elif btype == 'BLK_ARM_HOUR' or btype == 'BLK_ARMH':
                    target_path = os.path.join(custom_dir, "time", "pointer", "pointer", "hour")
                elif btype == 'BLK_ARM_MIN' or btype == 'BLK_ARMM':
                    target_path = os.path.join(custom_dir, "time", "pointer", "pointer", "minute")
                elif btype == 'BLK_ARM_SEC' or btype == 'BLK_ARMS':
                    target_path = os.path.join(custom_dir, "time", "pointer", "pointer", "second")
                elif btype == 'BLK_WEEKD':
                    target_path = os.path.join(custom_dir, "time", "digital", "1", "weekday")
                elif btype == 'BLK_MONTH':
                    target_path = os.path.join(custom_dir, "time", "digital", "1", "month")
                elif btype == 'BLK_DAY':
                    target_path = os.path.join(custom_dir, "time", "digital", "1", "day")
                elif btype == 'BLK_YEAR':
                    target_path = os.path.join(custom_dir, "time", "digital", "1", "year")
                elif btype == 'BLK_PULS':
                    target_path = os.path.join(custom_dir, "control", "heart_rate")
                elif btype == 'BLK_STEPS':
                    target_path = os.path.join(custom_dir, "control", "step")
                elif btype == 'BLK_CALOR':
                    target_path = os.path.join(custom_dir, "control", "calories")
                elif btype == 'BLK_BATTN':
                    target_path = os.path.join(custom_dir, "control", "battery")
                elif btype == 'BLK_DISTANCE' or btype == 'BLK_DIST':
                    target_path = os.path.join(custom_dir, "control", "distance")
                
                if target_path:
                    os.makedirs(target_path, exist_ok=True)
                    # For hands (single image), some systems expect 1.png or something, but we'll copy the images.
                    for img in images:
                        src = os.path.join(img_dir, img)
                        dst = os.path.join(target_path, img)
                        shutil.copy2(src, dst)
                        
        except Exception as e:
            logging.error(f"Failed to decompile {dial_file}: {e}")
            
        finally:
            if os.path.exists(temp_dir):
                shutil.rmtree(temp_dir)

if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("Usage: extract_presets.py <dials_dir> <assets_dir>")
        sys.exit(1)
        
    extract_all(sys.argv[1], sys.argv[2])

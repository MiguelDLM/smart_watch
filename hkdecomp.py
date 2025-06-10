#!/usr/bin/env python3
"""
HK89 Dial Decompressor - Enhanced Python Version
Extracts dial information and images from HK89 smartwatch .bin files
Enhanced with CO-FIT analysis and improved accuracy

Based on reverse engineering analysis from:
- Original hkdecomp
- CO-FIT APK decompilation (com.szabh.smable3.watchface.*)
- WatchFaceBuilder and Element structure analysis
- Enhanced compression algorithm understanding

Version: 2.0 Enhanced
"""

import os
import sys
import struct
import json
import time
from pathlib import Path
from PIL import Image
import argparse
import numpy as np
from typing import List, Dict, Optional, Tuple, Any
import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

# Constants from CO-FIT analysis
MAX_MEMORY_SIZE = 0x12C000  # 1.2MB limit
MAX_TEXT_SIZE = 0x8000

# Element types from CO-FIT WatchFaceBuilder
COFIT_ELEMENT_TYPES = {
    1: "PREVIEW",
    2: "BACKGROUND", 
    3: "NEEDLE_HOUR",
    4: "NEEDLE_MIN",
    5: "NEEDLE_SEC",
    6: "DIGITAL_YEAR",
    7: "DIGITAL_MONTH", 
    8: "DIGITAL_DAY",
    9: "DIGITAL_HOUR",
    10: "DIGITAL_MIN",
    11: "DIGITAL_SEC",
    12: "DIGITAL_AMPM",
    13: "DIGITAL_WEEKDAY",
    14: "DIGITAL_STEP",
    15: "DIGITAL_HEART",
    16: "DIGITAL_CALORIE",
    17: "DIGITAL_DISTANCE",
    18: "DIGITAL_BAT",
    19: "DIGITAL_BT",
    20: "DIGITAL_DIV_HOUR",
    21: "DIGITAL_DIV_MONTH",
    22: "DIGITAL_ICON",
    23: "BG_DYNAMIC",
    44: "BG_IMAGE_ARRAY"
}

# Gravity constants from CO-FIT
COFIT_GRAVITY = {
    1: "GRAVITY_X_LEFT",
    2: "GRAVITY_X_RIGHT", 
    4: "GRAVITY_X_CENTER",
    8: "GRAVITY_Y_TOP",
    16: "GRAVITY_Y_BOTTOM",
    32: "GRAVITY_Y_CENTER"
}

class EnhancedDialBlock:
    """Enhanced structure representing a dial block with CO-FIT compatibility"""
    
    def __init__(self, data: bytes):
        unpacked = struct.unpack('<I2B4H6B', data)
        # Original fields
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
        
        # Enhanced analysis
        self.has_alpha = self._determine_alpha_support()
        self.cofit_element_type = self._map_to_cofit_type()
        self.compression_type = self._analyze_compression()
        self.gravity_flags = self._analyze_gravity()
        
    def _determine_alpha_support(self) -> bool:
        """Determine if block supports alpha based on type and format"""
        # RGBA types (0x80+ variants)
        if self.blocktype & 0x80:
            return True
        # Special cases that always have alpha
        if self.blocktype == 0x8C:  # AMPM special case
            return True
        return False
    
    def _map_to_cofit_type(self) -> int:
        """Map HK block type to CO-FIT Element type"""
        base_type = self.blocktype & 0x7F  # Remove RGBA flag
        
        mapping = {
            0x01: 1,   # Preview -> PREVIEW
            0x02: 2,   # Background -> BACKGROUND
            0x03: 3,   # ArmHour -> NEEDLE_HOUR
            0x04: 4,   # ArmMinute -> NEEDLE_MIN
            0x05: 5,   # ArmSecond -> NEEDLE_SEC
            0x06: 6,   # Year -> DIGITAL_YEAR
            0x07: 7,   # Month -> DIGITAL_MONTH
            0x08: 8,   # Day -> DIGITAL_DAY
            0x09: 9,   # Hours -> DIGITAL_HOUR
            0x0A: 10,  # Minutes -> DIGITAL_MIN
            0x0B: 11,  # Seconds -> DIGITAL_SEC
            0x0C: 12,  # AMPM -> DIGITAL_AMPM
            0x0D: 13,  # DayOfWeek -> DIGITAL_WEEKDAY
            0x0E: 14,  # Steps -> DIGITAL_STEP
            0x0F: 15,  # Pulse -> DIGITAL_HEART
            0x10: 16,  # Calory -> DIGITAL_CALORIE
            0x11: 17,  # Distance -> DIGITAL_DISTANCE
            0x12: 18,  # BatteryNumber -> DIGITAL_BAT
            0x16: 19,  # Berry -> DIGITAL_BT
            0x17: 23,  # Animation -> BG_DYNAMIC
            0x18: 18,  # BatteryStrip -> DIGITAL_BAT
        }
        
        return mapping.get(base_type, 22)  # Default to DIGITAL_ICON
    
    def _analyze_compression(self) -> str:
        """Analyze compression type based on block properties"""
        if self.compr == 0:
            return "RAW_ALIGNED"  # Used for ARM blocks
        elif self.compr == 4:
            return "HK89_RLE"     # Standard compression
        else:
            return f"UNKNOWN_{self.compr}"
    
    def _analyze_gravity(self) -> Dict[str, Any]:
        """Analyze gravity/alignment flags"""
        gravity_info = {
            'raw_value': self.align,
            'x_alignment': 'CENTER',  # Default
            'y_alignment': 'CENTER'   # Default
        }
        
        # Map alignment values to CO-FIT gravity
        if self.align == 1:
            gravity_info['x_alignment'] = 'LEFT'
        elif self.align == 2:
            gravity_info['x_alignment'] = 'RIGHT'
        elif self.align == 4:
            gravity_info['x_alignment'] = 'CENTER'
        elif self.align == 9:  # 8 + 1
            gravity_info['x_alignment'] = 'LEFT'
            gravity_info['y_alignment'] = 'TOP'
        
        return gravity_info
    
    def to_cofit_element(self) -> Dict[str, Any]:
        """Convert to CO-FIT Element structure"""
        return {
            'type': self.cofit_element_type,
            'hasAlpha': 1 if self.has_alpha else 0,
            'w': self.sx,
            'h': self.sy,
            'gravity': self.align,
            'ignoreBlack': 4,  # Default from CO-FIT analysis
            'x': self.posX,
            'y': self.posY,
            'playInterval': 0,  # Animation interval
            'bottomOffset': self.centY,
            'leftOffset': self.centX,
            'imageBuffers': [],  # Will be filled with compressed data
            'metadata': {
                'blocktype': f"0x{self.blocktype:02X}",
                'compression': self.compression_type,
                'parts': self.parts,
                'picidx': self.picidx,
                'gravity_info': self.gravity_flags
            }
        }
    
    def __str__(self) -> str:
        return (f"Block(0x{self.blocktype:02X}, {self.sx}x{self.sy} at ({self.posX},{self.posY}), "
                f"parts={self.parts}, alpha={self.has_alpha}, {self.compression_type})")

class EnhancedBlockTypeManager:
    """Enhanced block type manager with CO-FIT integration"""
    
    # Updated type names based on CO-FIT analysis
    TYPE_NAMES = {
        # Basic types
        0x01: "Preview", 0x02: "Background", 0x03: "NeedleHour", 0x04: "NeedleMinute",
        0x05: "NeedleSecond", 0x06: "DigitalYear", 0x07: "DigitalMonth", 0x08: "DigitalDay",
        0x09: "DigitalHour", 0x0A: "DigitalMinute", 0x0B: "DigitalSecond", 0x0C: "DigitalAMPM",
        0x0D: "DigitalWeekday", 0x0E: "DigitalSteps", 0x0F: "DigitalHeart", 0x10: "DigitalCalorie",
        0x11: "DigitalDistance", 0x12: "DigitalBattery", 0x13: "DigitalDivHour", 0x14: "DigitalDivMonth",
        0x15: "Unknown15", 0x16: "DigitalBluetooth", 0x17: "BackgroundDynamic", 0x18: "DigitalBatteryStrip",
        0x19: "DigitalWeather", 0x1A: "DigitalTemperature", 0x1B: "Unknown1B", 0x1C: "DigitalIcon",
        0x1D: "Unknown1D", 0x1E: "Unknown1E", 0x1F: "Unknown1F",
        # HK26/HK89 specific
        0x27: "DigitalHourHigh", 0x28: "DigitalHourLow", 0x29: "DigitalMinuteHigh", 0x2A: "DigitalMinuteLow",
        # RGBA versions (0x80+)
        0x81: "Preview_RGBA", 0x82: "Background_RGBA", 0x83: "NeedleHour_RGBA", 0x84: "NeedleMinute_RGBA",
        0x85: "NeedleSecond_RGBA", 0x86: "DigitalYear_RGBA", 0x87: "DigitalMonth_RGBA", 0x88: "DigitalDay_RGBA",
        0x89: "DigitalHour_RGBA", 0x8A: "DigitalMinute_RGBA", 0x8B: "DigitalSecond_RGBA", 0x8C: "DigitalAMPM_RGBA",
        0x8D: "DigitalWeekday_RGBA", 0x8E: "DigitalSteps_RGBA", 0x8F: "DigitalHeart_RGBA", 0x90: "DigitalCalorie_RGBA",
        0x91: "DigitalDistance_RGBA", 0x92: "DigitalBattery_RGBA", 0x96: "DigitalBluetooth_RGBA", 0x97: "BackgroundDynamic_RGBA",
        0x98: "DigitalBatteryStrip_RGBA", 0x99: "DigitalWeather_RGBA", 0x9A: "DigitalTemperature_RGBA",
        0x9E: "DigitalBatteryExtended_RGBA"
    }
    
    SHORT_NAMES = {
        # Basic types
        0x01: "preview", 0x02: "background", 0x03: "needle_hour", 0x04: "needle_minute", 
        0x05: "needle_second", 0x06: "digital_year", 0x07: "digital_month", 0x08: "digital_day",
        0x09: "digital_hour", 0x0A: "digital_minute", 0x0B: "digital_second", 0x0C: "digital_ampm",
        0x0D: "digital_weekday", 0x0E: "digital_steps", 0x0F: "digital_heart", 0x10: "digital_calorie",
        0x11: "digital_distance", 0x12: "digital_battery", 0x13: "digital_div_hour", 0x14: "digital_div_month",
        0x15: "unknown15", 0x16: "digital_bluetooth", 0x17: "bg_dynamic", 0x18: "digital_battery_strip",
        0x19: "digital_weather", 0x1A: "digital_temperature",
        # HK26/HK89 specific
        0x27: "digital_hour_high", 0x28: "digital_hour_low", 0x29: "digital_minute_high", 0x2A: "digital_minute_low",
        # RGBA versions (0x80+)
        0x81: "preview", 0x82: "background", 0x83: "needle_hour", 0x84: "needle_minute", 
        0x85: "needle_second", 0x86: "digital_year", 0x87: "digital_month", 0x88: "digital_day",
        0x89: "digital_hour", 0x8A: "digital_minute", 0x8B: "digital_second", 0x8C: "digital_ampm",
        0x8D: "digital_weekday", 0x8E: "digital_steps", 0x8F: "digital_heart", 0x90: "digital_calorie",
        0x91: "digital_distance", 0x92: "digital_battery", 0x96: "digital_bluetooth", 0x97: "bg_dynamic",
        0x98: "digital_battery_strip", 0x99: "digital_weather", 0x9A: "digital_temperature",
        0x9E: "digital_battery_extended"
    }
    
    # Enhanced categorization
    NEEDLE_TYPES = {0x03, 0x04, 0x05, 0x83, 0x84, 0x85}  # Hour, minute, second hands
    DIGITAL_TYPES = {0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x10, 0x11, 0x12, 0x18, 0x19, 0x1A, 0x27, 0x28, 0x29, 0x2A,
                     0x86, 0x87, 0x88, 0x89, 0x8A, 0x8B, 0x8C, 0x8D, 0x8E, 0x8F, 0x90, 0x91, 0x92, 0x98, 0x99, 0x9A}  # Include RGBA versions
    ANIMATION_TYPES = {0x17, 0x97}  # Animation blocks
    BACKGROUND_TYPES = {0x02, 0x82}  # Background blocks
    PREVIEW_TYPES = {0x01, 0x81}  # Preview blocks
    
    @classmethod
    def get_type_category(cls, block_type: int) -> str:
        """Get the category of a block type"""
        if block_type in cls.NEEDLE_TYPES:
            return "NEEDLE"
        elif block_type in cls.DIGITAL_TYPES:
            return "DIGITAL"
        elif block_type in cls.ANIMATION_TYPES:
            return "ANIMATION"
        elif block_type in cls.BACKGROUND_TYPES:
            return "BACKGROUND"
        elif block_type in cls.PREVIEW_TYPES:
            return "PREVIEW"
        else:
            return "UNKNOWN"
    
    @classmethod
    def get_type_name(cls, block_type: int) -> str:
        return cls.TYPE_NAMES.get(block_type, f"Unknown_0x{block_type:02X}")
    
    @classmethod
    def get_short_name(cls, block_type: int, block_index: int) -> str:
        if block_type == 0x82:
            return f"background_{block_index}"
        name = cls.SHORT_NAMES.get(block_type)
        return name if name else f"unknown_{block_type:02x}_{block_index}"
    
    @classmethod
    def get_format(cls, block_type: int) -> str:
        return "RGBA" if (block_type & 0x80) or block_type == 0x8C else " RGB"
    
    @classmethod
    def is_multipart_type(cls, block_type: int) -> bool:
        """Check if this type typically has multiple parts (digits)"""
        return block_type in cls.DIGITAL_TYPES or block_type in {0x86, 0x87, 0x88, 0x89, 0x8A, 0x8B, 0x8C, 0x8D, 0x8E, 0x8F, 0x90, 0x91, 0x92, 0x98, 0x99, 0x9A}

class EnhancedImageDecompressor:
    """Enhanced image decompressor with improved accuracy and CO-FIT compatibility"""
    
    @staticmethod
    def decompress_hk89_rle(compressed_data: bytes, width: int, height: int, has_alpha: bool = False) -> Optional[bytes]:
        """Enhanced HK89 RLE decompression with better error handling"""
        if not compressed_data or len(compressed_data) < 4:
            logger.warning(f"Insufficient data for decompression: {len(compressed_data) if compressed_data else 0} bytes")
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
        
        logger.debug(f"Decompressing {width}x{height}, alpha={has_alpha}, data_start=0x{input_pos:04X}")
        
        try:
            while pixels_written < expected_pixels and input_pos < len(compressed_data):
                # Read control byte
                if input_pos >= len(compressed_data):
                    break
                    
                count_byte = compressed_data[input_pos]
                input_pos += 1
                
                if count_byte == 0:
                    # Single pixel mode
                    input_pos, output_pos, pixels_written = EnhancedImageDecompressor._process_single_pixel(
                        compressed_data, input_pos, output, output_pos, pixels_written, has_alpha
                    )
                elif count_byte & 0x80:
                    # RLE mode (count is in lower 7 bits)
                    rle_count = count_byte & 0x7F
                    input_pos, output_pos, pixels_written = EnhancedImageDecompressor._process_rle_pixels(
                        compressed_data, input_pos, output, output_pos, pixels_written, 
                        rle_count, expected_pixels, has_alpha
                    )
                else:
                    # Literal mode
                    input_pos, output_pos, pixels_written = EnhancedImageDecompressor._process_literal_pixels(
                        compressed_data, input_pos, output, output_pos, pixels_written,
                        count_byte, expected_pixels, has_alpha
                    )
            
            # Fill remaining pixels if needed
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
            
            if pixels_written != expected_pixels:
                logger.warning(f"Pixel count mismatch: {pixels_written}/{expected_pixels}")
                
            return bytes(output[:output_pos])
            
        except Exception as e:
            logger.error(f"Decompression error: {e}")
            return None
    
    @staticmethod
    def _process_single_pixel(compressed_data: bytes, input_pos: int, output: bytearray, 
                             output_pos: int, pixels_written: int, has_alpha: bool) -> Tuple[int, int, int]:
        """Process a single pixel with enhanced error checking"""
        alpha = 255
        
        # Read alpha if needed
        if has_alpha and input_pos < len(compressed_data):
            alpha = compressed_data[input_pos]
            input_pos += 1
        
        # Read RGB565 pixel
        if input_pos + 1 >= len(compressed_data):
            return input_pos, output_pos, pixels_written
            
        r, g, b = EnhancedImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
        input_pos += 2
        
        # Write pixel
        if output_pos + (4 if has_alpha else 3) <= len(output):
            output[output_pos] = r
            output[output_pos + 1] = g
            output[output_pos + 2] = b
            if has_alpha:
                output[output_pos + 3] = alpha
                output_pos += 4
            else:
                output_pos += 3
            pixels_written += 1
            
        return input_pos, output_pos, pixels_written
    
    @staticmethod 
    def _process_rle_pixels(compressed_data: bytes, input_pos: int, output: bytearray,
                           output_pos: int, pixels_written: int, count: int,
                           max_pixels: int, has_alpha: bool) -> Tuple[int, int, int]:
        """Process RLE compressed pixels with bounds checking"""
        if count == 0:
            return input_pos, output_pos, pixels_written
            
        alpha = 255
        if has_alpha and input_pos < len(compressed_data):
            alpha = compressed_data[input_pos]
            input_pos += 1
        
        if input_pos + 1 >= len(compressed_data):
            return input_pos, output_pos, pixels_written
            
        r, g, b = EnhancedImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
        input_pos += 2
        
        # Write repeated pixels
        bytes_per_pixel = 4 if has_alpha else 3
        for _ in range(count):
            if pixels_written >= max_pixels or output_pos + bytes_per_pixel > len(output):
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
            
        return input_pos, output_pos, pixels_written
    
    @staticmethod
    def _process_literal_pixels(compressed_data: bytes, input_pos: int, output: bytearray,
                               output_pos: int, pixels_written: int, count: int,
                               max_pixels: int, has_alpha: bool) -> Tuple[int, int, int]:
        """Process literal pixels with bounds checking"""
        bytes_per_pixel = 4 if has_alpha else 3
        
        for _ in range(count):
            if pixels_written >= max_pixels or output_pos + bytes_per_pixel > len(output):
                break
                
            alpha = 255
            if has_alpha and input_pos < len(compressed_data):
                alpha = compressed_data[input_pos]
                input_pos += 1
                
            if input_pos + 1 >= len(compressed_data):
                break
                
            r, g, b = EnhancedImageDecompressor._read_rgb565_pixel(compressed_data, input_pos)
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
            
        return input_pos, output_pos, pixels_written
    
    @staticmethod
    def _read_rgb565_pixel(compressed_data: bytes, input_pos: int) -> Tuple[int, int, int]:
        """Read and convert RGB565 pixel to RGB888 - FIXED to match original algorithm"""
        high_byte = compressed_data[input_pos]
        low_byte = compressed_data[input_pos + 1]
        rgb565 = (high_byte << 8) | low_byte
        
        # Use original RGB565 to RGB888 conversion method
        r = high_byte & 0xf8
        g = (rgb565 >> 3) & 0xfc
        b = (rgb565 << 3) & 0xff
        
        return r, g, b
    
    @staticmethod
    def decompress_raw_aligned(compressed_data: bytes, width: int, height: int, has_alpha: bool) -> Optional[bytes]:
        """Enhanced RAW aligned decompression for needle elements"""
        bytes_per_pixel = 3 if has_alpha else 2
        row_bytes = width * bytes_per_pixel
        aligned_row_bytes = (row_bytes + 3) & ~3  # Align to 4 bytes
        
        expected_size = height * aligned_row_bytes
        
        if len(compressed_data) < expected_size:
            logger.warning(f"RAW data too small: {len(compressed_data)} < {expected_size}")
            # Pad with zeros if needed
            compressed_data = compressed_data + b'\x00' * (expected_size - len(compressed_data))
        
        output = bytearray(width * height * 4)  # Always output RGBA
        output_pos = 0
        
        try:
            for row in range(height):
                row_start = row * aligned_row_bytes
                for col in range(width):
                    base = row_start + col * bytes_per_pixel
                    
                    if base + bytes_per_pixel > len(compressed_data):
                        # Fill with transparent pixels
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
                    
                    # Convert RGB565 to RGB888 - CORRECTED byte order for RAW format
                    rgb565 = b2 | (b1 << 8)  # Swap byte order for RAW format
                    r = ((rgb565 >> 11) & 0x1F) * 255 // 31
                    g = ((rgb565 >> 5) & 0x3F) * 255 // 63
                    b = (rgb565 & 0x1F) * 255 // 31
                    
                    output[output_pos:output_pos + 4] = [r, g, b, a]
                    output_pos += 4
            
            return bytes(output)
            
        except Exception as e:
            logger.error(f"RAW decompression error: {e}")
            return None

class EnhancedHKDecompressor:
    """Enhanced HK decompressor with CO-FIT integration and compiler insights"""
    
    def __init__(self):
        self.main_buffer: Optional[bytes] = None
        self.filename: str = ""
        self.block_count: int = 0
        self.file_size: int = 0
        self.picture_sizes: List[int] = [0] * 256
        self.blocks: List[EnhancedDialBlock] = []
        self.binary_format_info: Dict[str, Any] = {}
        self.cofit_elements: List[Dict[str, Any]] = []
        
        # Enhanced analysis from compiler knowledge
        self.supported_resolutions = {
            (240, 240): "HK89_240",
            (240, 280): "HK89_240_280", 
            (240, 283): "HK89_240_283",
            (240, 286): "HK89_240_286",
            (240, 296): "HK89_240_296",
            (320, 320): "HK89_320",
            (320, 386): "HK89_320_386",
            (336, 480): "HK89_336_480",
            (360, 400): "HK89_360_400",
            (368, 448): "HK89_368_448",
            (390, 390): "HK89_390",
            (390, 450): "HK89_390_450",
            (410, 502): "HK89_410_502",
            (412, 412): "HK89_412",
            (466, 466): "HK89_466"
        }
        
        # Digital element part mapping for better extraction
        self.digital_part_mappings = {
            'DIGITAL_HOUR': ['h0', 'h1', 'h2', 'h3', 'h4', 'h5', 'h6', 'h7', 'h8', 'h9'],
            'DIGITAL_MIN': ['m0', 'm1', 'm2', 'm3', 'm4', 'm5', 'm6', 'm7', 'm8', 'm9'],
            'DIGITAL_SEC': ['s0', 's1', 's2', 's3', 's4', 's5', 's6', 's7', 's8', 's9'],
            'DIGITAL_DAY': ['d0', 'd1', 'd2', 'd3', 'd4', 'd5', 'd6', 'd7', 'd8', 'd9'],
            'DIGITAL_MONTH': ['mo0', 'mo1', 'mo2', 'mo3', 'mo4', 'mo5', 'mo6', 'mo7', 'mo8', 'mo9'],
            'DIGITAL_YEAR': ['y0', 'y1', 'y2', 'y3', 'y4', 'y5', 'y6', 'y7', 'y8', 'y9'],
            'DIGITAL_WEEKDAY': ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN'],
            'DIGITAL_AMPM': ['AM', 'PM'],
            'DIGITAL_STEP': ['st0', 'st1', 'st2', 'st3', 'st4', 'st5', 'st6', 'st7', 'st8', 'st9'],
            'DIGITAL_BAT': ['b0', 'b1', 'b2', 'b3', 'b4', 'b5', 'b6', 'b7', 'b8', 'b9', 'bat_low', 'bat_mid', 'bat_high']
        }
        
        # Compiler-based compression ratios for estimation
        self.compression_ratios = {
            'HK89_RLE': 0.65,      # Average compression ratio
            'RAW_ALIGNED': 1.0      # No compression
        }
        
    def load_file(self, filename: str) -> bool:
        """Load and validate binary file with enhanced header analysis"""
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
            logger.error("File too small (need at least 4 bytes for header)")
            return False
        
        # Analyze binary format header
        self._analyze_header()
        return True
    
    def _analyze_header(self):
        """Enhanced binary header analysis with compiler insights"""
        if len(self.main_buffer) < 4:
            return
            
        # Read header components
        picture_table_size = struct.unpack('<H', self.main_buffer[0:2])[0]
        self.block_count = self.main_buffer[2]
        reserved_byte = self.main_buffer[3]
        
        # Enhanced format detection based on compiler knowledge
        format_version = "UNKNOWN"
        magic_validation = "INVALID"
        
        if reserved_byte == 0x02:
            format_version = "HK89_V2"
        elif reserved_byte == 0x00:
            format_version = "HK89_V1"
        elif reserved_byte == 0x01:
            format_version = "HK89_V1_ALT"
        else:
            format_version = f"UNKNOWN_0x{reserved_byte:02X}"
        
        # Validate magic number (should be 79*4 = 316 or just 79)
        if picture_table_size == 79 * 4:  # 316 bytes
            magic_validation = "VALID_316"
        elif picture_table_size == 79:     # 79 entries
            magic_validation = "VALID_79"  
        else:
            magic_validation = f"INVALID_{picture_table_size}"
        
        # Calculate expected file structure
        header_size = 4
        blocks_size = self.block_count * 20
        picture_table_bytes = 79 * 4  # Always 79 entries of 4 bytes each
        header_section_size = header_size + blocks_size + picture_table_bytes
        
        # Validate file structure
        structure_valid = self.file_size >= header_section_size
        
        self.binary_format_info = {
            'picture_table_size': picture_table_size,
            'block_count': self.block_count,
            'reserved_byte': reserved_byte,
            'file_size': self.file_size,
            'header_format': format_version,
            'magic_validation': magic_validation,
            'structure_valid': structure_valid,
            'header_section_size': header_section_size,
            'data_section_size': self.file_size - header_section_size,
            'compiler_compatibility': self._check_compiler_compatibility()
        }
        
        logger.info(f"Binary format: {format_version} ({magic_validation})")
        logger.info(f"Structure valid: {structure_valid}")
        logger.info(f"Header section: {header_section_size} bytes")
        logger.info(f"Data section: {self.file_size - header_section_size} bytes")
        
    def _check_compiler_compatibility(self) -> Dict[str, Any]:
        """Check compatibility with known compiler patterns"""
        compatibility = {
            'hkcomposer_v1_9_6': False,
            'cofit_generated': False,
            'memory_limit_ok': False,
            'block_count_ok': False
        }
        
        # Check memory limit (from compiler MAX_MEMORY_SIZE)
        compatibility['memory_limit_ok'] = self.file_size <= MAX_MEMORY_SIZE
        
        # Check block count (from compiler MAX_BLOCKS)
        compatibility['block_count_ok'] = self.block_count <= 256
        
        # Check for hkcomposer patterns
        if (self.binary_format_info.get('reserved_byte') == 0x02 and 
            self.binary_format_info.get('picture_table_size') == 79 * 4):
            compatibility['hkcomposer_v1_9_6'] = True
        
        # Check for CO-FIT patterns (similar structure but may have different markers)
        if self.block_count > 0 and self.file_size < MAX_MEMORY_SIZE:
            compatibility['cofit_generated'] = True
            
        return compatibility
        
    def parse_blocks(self):
        """Parse all blocks with enhanced analysis"""
        self.blocks = []
        self.cofit_elements = []
        
        for i in range(self.block_count):
            block_start = 4 + (i * 20)  # Header is 4 bytes + 20 bytes per block
            block_end = block_start + 20
            
            if block_end > len(self.main_buffer):
                logger.warning(f"Block {i+1} extends beyond file size")
                break
                
            block_data = self.main_buffer[block_start:block_end]
            block = EnhancedDialBlock(block_data)
            self.blocks.append(block)
            
            # Convert to CO-FIT element
            cofit_element = block.to_cofit_element()
            self.cofit_elements.append(cofit_element)
            
        logger.info(f"Parsed {len(self.blocks)} blocks")
    
    def calculate_picture_sizes(self):
        """Calculate picture sizes with enhanced validation"""
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
    
    def extract_single_image(self, block: EnhancedDialBlock, output_dir: str, 
                           filename_override: Optional[str] = None) -> bool:
        """Extract single image with enhanced processing"""
        block_index = self.blocks.index(block) + 1
        filename = filename_override or EnhancedBlockTypeManager.get_short_name(block.blocktype, block_index)
        
        # Validate block data
        if block.picture_address >= self.file_size:
            logger.warning(f"Block {block_index}: Picture address 0x{block.picture_address:08X} beyond file size")
            return False
        
        if self.picture_sizes[block.picidx] <= 0:
            logger.warning(f"Block {block_index}: Invalid picture size {self.picture_sizes[block.picidx]}")
            return False
        
        # Get actual data size
        available_bytes = self.file_size - block.picture_address
        actual_size = min(self.picture_sizes[block.picidx], available_bytes)
        
        if actual_size <= 0:
            logger.warning(f"Block {block_index}: No data available")
            return False
        
        compressed_data = self.main_buffer[block.picture_address:block.picture_address + actual_size]
        
        logger.debug(f"Extracting {filename}: {block}")
        
        # Choose decompression method based on compression type
        if block.compression_type == "RAW_ALIGNED":
            image_data = EnhancedImageDecompressor.decompress_raw_aligned(
                compressed_data, block.sx, block.sy, block.has_alpha
            )
        else:  # HK89_RLE
            image_data = EnhancedImageDecompressor.decompress_hk89_rle(
                compressed_data, block.sx, block.sy, block.has_alpha
            )
        
        if image_data:
            success = self._write_png(f"{output_dir}/{filename}.png", image_data, block.sx, block.sy)
            if success:
                # Store compressed data in CO-FIT element (convert to hex string for JSON)
                element_idx = self.blocks.index(block)
                if element_idx < len(self.cofit_elements):
                    self.cofit_elements[element_idx]['imageBuffers'] = [compressed_data.hex()]
                logger.info(f"✓ Extracted: {filename}.png ({block.sx}x{block.sy})")
                return True
        
        # Fallback: save raw data
        self._write_raw_backup(f"{output_dir}/{filename}", compressed_data)
        logger.warning(f"⚠ Saved raw data: {filename}.bin")
        return False
    
    def _write_png(self, filepath: str, image_data: bytes, width: int, height: int) -> bool:
        """Write PNG with enhanced error handling"""
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
    
    def _write_raw_backup(self, filename: str, data: bytes):
        """Write raw data backup"""
        try:
            with open(f"{filename}.bin", 'wb') as f:
                f.write(data)
        except Exception as e:
            logger.error(f"Error writing raw file: {e}")
    
    def extract_all_images(self, output_dir: str):
        """Extract all images with enhanced categorization"""
        logger.info("=== EXTRACTING IMAGES ===")
        
        # Group blocks by category
        categories = {
            'NEEDLE': [],
            'DIGITAL': [],
            'BACKGROUND': [],
            'PREVIEW': [],
            'ANIMATION': [],
            'UNKNOWN': []
        }
        
        for block in self.blocks:
            category = EnhancedBlockTypeManager.get_type_category(block.blocktype)
            categories[category].append(block)
        
        # Extract by category
        for category, blocks in categories.items():
            if not blocks:
                continue
                
            logger.info(f"\n{category} blocks ({len(blocks)}):")
            category_dir = f"{output_dir}/{category.lower()}"
            os.makedirs(category_dir, exist_ok=True)
            
            for block in blocks:
                block_index = self.blocks.index(block) + 1
                short_name = EnhancedBlockTypeManager.get_short_name(block.blocktype, block_index)
                
                if block.parts > 1 and category == 'DIGITAL':
                    self._extract_multipart_digital(block, category_dir)
                else:
                    self.extract_single_image(block, category_dir, short_name)
    
    def _extract_multipart_digital(self, block: EnhancedDialBlock, output_dir: str):
        """Extract multi-part digital elements with enhanced accuracy"""
        base_name = EnhancedBlockTypeManager.get_short_name(block.blocktype, 0)
        type_name = COFIT_ELEMENT_TYPES.get(block.cofit_element_type, "UNKNOWN").replace("DIGITAL_", "")
        
        logger.debug(f"Extracting {block.parts} parts for {base_name} ({type_name})")
        
        # Get part names from mapping
        part_names = self.digital_part_mappings.get(f"DIGITAL_{type_name}", 
                                                   [f"part_{i}" for i in range(block.parts)])
        
        # Calculate individual part sizes based on compiler knowledge
        total_compressed_size = self.picture_sizes[block.picidx]
        uncompressed_part_size = block.sx * block.sy * (4 if block.has_alpha else 3)
        estimated_part_size = int(uncompressed_part_size * self.compression_ratios[block.compression_type])
        
        # Align to 4 bytes as per compiler
        aligned_part_size = (estimated_part_size + 3) & ~3
        
        current_offset = 0
        successful_extractions = 0
        
        for part_idx in range(min(block.parts, len(part_names))):
            part_name = f"{base_name}_{part_names[part_idx]}"
            
            # Calculate this part's data boundaries
            start_pos = block.picture_address + current_offset
            
            # Use estimated size but don't exceed available data
            remaining_data = total_compressed_size - current_offset
            if remaining_data <= 0:
                logger.warning(f"  No data remaining for part {part_idx}")
                break
            
            # For the last part, use all remaining data
            if part_idx == block.parts - 1:
                part_data_size = remaining_data
            else:
                part_data_size = min(aligned_part_size, remaining_data)
            
            if part_data_size <= 0:
                logger.warning(f"  Invalid data size for part {part_idx}")
                break
                
            compressed_part = self.main_buffer[start_pos:start_pos + part_data_size]
            
            # Decompress this part with enhanced method
            result, actual_consumed = self._decompress_single_part_enhanced(
                compressed_part, block.sx, block.sy, block.has_alpha, part_idx
            )
            
            if result:
                success = self._write_png(f"{output_dir}/{part_name}.png", result, block.sx, block.sy)
                if success:
                    logger.debug(f"  ✓ {part_name}.png (consumed {actual_consumed} bytes)")
                    successful_extractions += 1
                    current_offset += actual_consumed
                else:
                    logger.warning(f"  Failed to save {part_name}.png")
                    current_offset += part_data_size
            else:
                logger.warning(f"  Failed to decompress part {part_idx}")
                current_offset += part_data_size
            
            # Align to 4 bytes as per compiler requirements
            while current_offset % 4 != 0:
                current_offset += 1
        
        logger.info(f"  Successfully extracted {successful_extractions}/{block.parts} parts")
    
    def _decompress_single_part_enhanced(self, compressed_data: bytes, width: int, height: int, 
                                       has_alpha: bool, part_index: int) -> Tuple[Optional[bytes], int]:
        """Enhanced single part decompression with better size estimation"""
        if not compressed_data or len(compressed_data) < 4:
            return None, 0
        
        expected_pixels = width * height
        bytes_per_pixel = 4 if has_alpha else 3
        
        # Track original data size
        original_size = len(compressed_data)
        
        # Try to decompress with the enhanced decompressor
        try:
            # Use HK89 RLE for most digital elements
            result = EnhancedImageDecompressor.decompress_hk89_rle(
                compressed_data, width, height, has_alpha
            )
            
            if result and len(result) >= expected_pixels * bytes_per_pixel:
                # Estimate bytes consumed based on decompression success
                # This is a heuristic based on typical RLE patterns
                estimated_consumed = self._estimate_rle_bytes_consumed(
                    compressed_data, expected_pixels, has_alpha
                )
                return result, min(estimated_consumed, original_size)
            
        except Exception as e:
            logger.debug(f"  RLE decompression failed for part {part_index}: {e}")
        
        # Fallback: try RAW decompression
        try:
            result = EnhancedImageDecompressor.decompress_raw_aligned(
                compressed_data, width, height, has_alpha
            )
            
            if result:
                # RAW uses all data
                raw_size = width * height * (3 if has_alpha else 2)
                aligned_size = (raw_size + 3) & ~3
                return result, min(aligned_size, original_size)
                
        except Exception as e:
            logger.debug(f"  RAW decompression failed for part {part_index}: {e}")
        
        return None, 0
    
    def _estimate_rle_bytes_consumed(self, compressed_data: bytes, expected_pixels: int, 
                                   has_alpha: bool) -> int:
        """Estimate bytes consumed by RLE decompression based on compiler knowledge"""
        if len(compressed_data) < 4:
            return len(compressed_data)
        
        # Read header to get start position
        try:
            header_value = struct.unpack('<H', compressed_data[0:2])[0]
            data_start = header_value if header_value < len(compressed_data) and header_value >= 2 else 2
        except:
            data_start = 2
        
        # Simulate RLE parsing to count consumed bytes
        input_pos = data_start
        pixels_processed = 0
        
        try:
            while pixels_processed < expected_pixels and input_pos < len(compressed_data):
                if input_pos >= len(compressed_data):
                    break
                    
                count_byte = compressed_data[input_pos]
                input_pos += 1
                
                if count_byte == 0:
                    # Single pixel
                    if has_alpha:
                        input_pos += 1  # Alpha
                    input_pos += 2  # RGB565
                    pixels_processed += 1
                elif count_byte & 0x80:
                    # RLE mode
                    rle_count = count_byte & 0x7F
                    if has_alpha:
                        input_pos += 1  # Alpha
                    input_pos += 2  # RGB565
                    pixels_processed += rle_count
                else:
                    # Literal mode
                    literal_count = count_byte
                    for _ in range(literal_count):
                        if has_alpha:
                            input_pos += 1  # Alpha
                        input_pos += 2  # RGB565
                        pixels_processed += 1
                        if input_pos >= len(compressed_data):
                            break
            
            # Align to 4 bytes
            while input_pos % 4 != 0:
                input_pos += 1
                
            return min(input_pos, len(compressed_data))
            
        except Exception:
            # If parsing fails, use conservative estimate
            return min(expected_pixels * 2 + 50, len(compressed_data))
    
    def save_cofit_json(self, output_dir: str):
        """Save CO-FIT compatible JSON configuration"""
        config = {
            'metadata': {
                'format_version': '2.0',
                'generator': 'hkdecomp_enhanced.py',
                'timestamp': time.strftime('%Y-%m-%d %H:%M:%S'),
                'source_file': os.path.basename(self.filename),
                'binary_info': self.binary_format_info
            },
            'device_profile': {
                'resolution': self._detect_resolution(),
                'format': 'HK89',
                'compression_support': ['HK89_RLE', 'RAW_ALIGNED']
            },
            'elements': self.cofit_elements,
            'statistics': {
                'total_elements': len(self.cofit_elements),
                'file_size': self.file_size,
                'categories': self._get_category_stats()
            }
        }
        
        output_file = f"{output_dir}/cofit_config.json"
        try:
            with open(output_file, 'w', encoding='utf-8') as f:
                json.dump(config, f, indent=2, ensure_ascii=False)
            logger.info(f"✓ Saved CO-FIT config: {output_file}")
        except Exception as e:
            logger.error(f"Error saving CO-FIT config: {e}")
    
    def _detect_resolution(self) -> Dict[str, int]:
        """Enhanced resolution detection with compiler knowledge"""
        detected_resolution = None
        device_profile = "UNKNOWN"
        
        # Primary: Check background elements (most reliable)
        for block in self.blocks:
            if block.blocktype in {0x02, 0x82}:  # Background types
                width, height = block.sx, block.sy
                detected_resolution = (width, height)
                break
        
        # Secondary: Check preview elements  
        if not detected_resolution:
            for block in self.blocks:
                if block.blocktype in {0x01, 0x81}:  # Preview types
                    width, height = block.sx, block.sy
                    detected_resolution = (width, height)
                    break
        
        # Tertiary: Analyze all elements to find maximum bounds
        if not detected_resolution:
            max_x = max_y = 0
            for block in self.blocks:
                max_x = max(max_x, block.posX + block.sx)
                max_y = max(max_y, block.posY + block.sy)
            
            # Round to nearest supported resolution
            for (w, h), profile in self.supported_resolutions.items():
                if max_x <= w and max_y <= h:
                    detected_resolution = (w, h)
                    device_profile = profile
                    break
        
        # Validate against supported resolutions
        if detected_resolution:
            width, height = detected_resolution
            device_profile = self.supported_resolutions.get(detected_resolution, "CUSTOM")
            
            logger.info(f"Detected resolution: {width}x{height} ({device_profile})")
            
            return {
                'width': width, 
                'height': height,
                'profile': device_profile,
                'is_supported': device_profile != "CUSTOM"
            }
        
        # Ultimate fallback
        logger.warning("Could not detect resolution, using default 240x240")
        return {
            'width': 240, 
            'height': 240,
            'profile': 'HK89_240',
            'is_supported': True
        }
    
    def _get_category_stats(self) -> Dict[str, int]:
        """Get statistics by element category"""
        stats = {
            'NEEDLE': 0,
            'DIGITAL': 0,
            'BACKGROUND': 0,
            'PREVIEW': 0,
            'ANIMATION': 0,
            'UNKNOWN': 0
        }
        
        for block in self.blocks:
            category = EnhancedBlockTypeManager.get_type_category(block.blocktype)
            stats[category] += 1
            
        return stats
    
    def print_enhanced_analysis(self):
        """Print enhanced analysis of the binary file"""
        logger.info("="*60)
        logger.info("ENHANCED BINARY ANALYSIS")
        logger.info("="*60)
        
        # Binary format info
        logger.info(f"Format: {self.binary_format_info.get('header_format', 'UNKNOWN')}")
        logger.info(f"File size: {self.file_size:,} bytes ({self.file_size/1024:.1f} KB)")
        logger.info(f"Blocks: {self.block_count}")
        
        # CO-FIT element mapping
        logger.info(f"\nCO-FIT Element Mapping:")
        for i, (block, element) in enumerate(zip(self.blocks, self.cofit_elements)):
            cofit_type = COFIT_ELEMENT_TYPES.get(element['type'], 'UNKNOWN')
            category = EnhancedBlockTypeManager.get_type_category(block.blocktype)
            logger.info(f"  {i+1:2d}. 0x{block.blocktype:02X} -> {cofit_type} ({category})")
        
        # Category statistics
        stats = self._get_category_stats()
        logger.info(f"\nCategory Distribution:")
        for category, count in stats.items():
            if count > 0:
                logger.info(f"  {category}: {count}")
    
    def process(self, filename: str) -> bool:
        """Enhanced main processing function"""
        start_time = time.time()
        logger.info("="*60)
        logger.info("HK89 DIAL DECOMPRESSOR - ENHANCED VERSION")
        logger.info("="*60)
        
        base_filename = Path(filename).name
        logger.info(f"Processing: {base_filename}")
        
        # Load and parse
        if not self.load_file(filename):
            return False
        
        self.parse_blocks()
        self.calculate_picture_sizes()
        
        # Create output directory
        basename = Path(filename).stem
        output_dir = f"_enhanced_{basename}"
        os.makedirs(output_dir, exist_ok=True)
        
        # Print analysis
        self.print_enhanced_analysis()
        
        # Extract images
        self.extract_all_images(output_dir)
        
        # Save CO-FIT configuration
        self.save_cofit_json(output_dir)
        
        # Processing complete
        elapsed = time.time() - start_time
        logger.info("="*60)
        logger.info(f"✅ PROCESSING COMPLETED in {elapsed:.2f}s")
        logger.info(f"Output directory: {output_dir}")
        logger.info("="*60)
        
        return True

def main():
    """Enhanced main function"""
    parser = argparse.ArgumentParser(
        description='HK89 Dial Decompressor - Enhanced Version with CO-FIT Integration',
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Features:
  * Enhanced image decompression with better accuracy
  * CO-FIT Element structure analysis and export
  * Categorized output (needles, digital, backgrounds, etc.)
  * JSON configuration export for recompilation
  * Improved error handling and logging
  * Binary format analysis and validation

Examples:
  %(prog)s dial.bin                    # Basic decompression
  %(prog)s dial.bin --verbose          # Enable debug logging
        """
    )
    
    parser.add_argument('filename', help='HK89 .bin file to decompress')
    parser.add_argument('--verbose', '-v', action='store_true', 
                       help='Enable verbose debug logging')
    
    args = parser.parse_args()
    
    # Set logging level
    if args.verbose:
        logging.getLogger().setLevel(logging.DEBUG)
    
    # Process file
    decompressor = EnhancedHKDecompressor()
    success = decompressor.process(args.filename)
    
    sys.exit(0 if success else 1)

if __name__ == "__main__":
    main()

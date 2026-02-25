#!/usr/bin/env python3
"""
HK89 Dial Decompiler/Compiler Tool
Reverse engineered from hk89comp_decomp tools by zzuler (XDA)

This tool can:
- Decompress .bin dial files to extract images and metadata
- Compress images back into .bin dial files

The format uses RLE compression with RGB565 (3 bytes) or RGBA5658 (4 bytes) pixel format.
"""

import struct
import sys
import os
import json
from pathlib import Path
from typing import List, Dict, Tuple, Optional, BinaryIO
from dataclasses import dataclass, asdict
from enum import IntEnum

try:
    from PIL import Image
    import numpy as np
except ImportError:
    print("Error: PIL and numpy are required. Install with: pip install Pillow numpy")
    sys.exit(1)


VERSION = "1.0.0"


class BlockType(IntEnum):
    """
    Block types identified from reverse engineering the decompj binary.
    The block type switch table is at 0x4036d8 in the binary.
    
    RGBA variants have bit 0x80 set (e.g., 0x89 = Hours RGBA)
    """
    BLK_UNKNOWN = 0x00    # Unknown / unused
    BLK_PREVI = 0x01      # Preview image
    BLK_BGIMG = 0x02      # Background image
    BLK_ARMH = 0x03       # Arm hour (analog clock hand)
    BLK_ARMM = 0x04       # Arm minute (analog clock hand)
    BLK_ARMS = 0x05       # Arm second (analog clock hand)
    BLK_YEAR = 0x06       # Year
    BLK_MONTH = 0x07      # Month
    BLK_DAY = 0x08        # Day
    BLK_HOUR = 0x09       # Hours
    BLK_MIN = 0x0A        # Minutes
    BLK_SEC = 0x0B        # Seconds
    BLK_AMPM = 0x0C       # AM/PM
    BLK_WEEKD = 0x0D      # Day of week
    BLK_STEPS = 0x0E      # Steps
    BLK_PULS = 0x0F       # Pulse/Heart rate
    BLK_CALOR = 0x10      # Calory
    BLK_DIST = 0x11       # Distance
    BLK_BATTN = 0x12      # Battery
    BLK_CONN = 0x13       # Connection
    BLK_BERRY = 0x16      # Axle pawl / Berry (separator/decoration)
    BLK_ANIM = 0x17       # Animation
    BLK_BATTS = 0x18      # Battery strip
    BLK_WEAT = 0x19       # Weather
    BLK_TEMP = 0x1A       # Temperature
    BLK_PROG2 = 0x1E      # Progress bar 2
    BLK_PROG1 = 0x20      # Progress bar 1
    BLK_LABEL = 0x25      # Label
    BLK_HOURL = 0x27      # Hours low digit
    BLK_HOURH = 0x28      # Hours high digit
    BLK_MINH = 0x29       # Minutes high digit
    BLK_MINL = 0x2A       # Minutes low digit
    

# Block type name mapping - base types only (RGBA variants strip 0x80 bit)
# Format: type_code: (short_name, description)
BLOCK_TYPE_NAMES = {
    0x00: ("unknown", "Unknown"),
    0x01: ("prev", "Preview image"),
    0x02: ("background", "Background image"),
    0x03: ("arm_hour", "Arm hour"),
    0x04: ("arm_minute", "Arm minute"),
    0x05: ("arm_second", "Arm second"),
    0x06: ("year", "Year"),
    0x07: ("month", "Month"),
    0x08: ("day", "Day"),
    0x09: ("hours", "Hours"),
    0x0A: ("minutes", "Minutes"),
    0x0B: ("seconds", "Seconds"),
    0x0C: ("ampm", "AM/PM"),
    0x0D: ("weekd", "Day of week"),
    0x0E: ("steps", "Steps"),
    0x0F: ("pulse", "Pulse"),
    0x10: ("calor", "Calory"),
    0x11: ("dist", "Distance"),
    0x12: ("battery", "Battery"),
    0x13: ("connect", "Connection"),
    0x16: ("bigyo", "Axle pawl"),
    0x17: ("animpart", "Animation"),
    0x18: ("battery_strip", "Battery strip"),
    0x19: ("weather", "Weather"),
    0x1A: ("temp", "Temperature"),
    0x1E: ("progress2", "Progress bar 2"),
    0x20: ("progress1", "Progress bar 1"),
    0x25: ("label", "Label"),
    0x27: ("hour_lo", "Hours low digit"),
    0x28: ("hour_hi", "Hours high digit"),
    0x29: ("minute_hi", "Minutes high digit"),
    0x2A: ("minute_lo", "Minutes low digit"),
}


@dataclass
class BlockInfo:
    """Information about a dial block/element"""
    image_offset: int
    pic_idx: int
    valami2: int
    width: int
    height: int
    pos_x: int
    pos_y: int
    parts: int  # Number of frames
    block_type: int
    align: int
    compression: int
    cent_x: int
    cent_y: int
    
    @property
    def is_rgba(self) -> bool:
        """Check if this block uses RGBA (4 bytes per pixel)"""
        return (self.block_type & 0x80) != 0
    
    @property
    def base_type(self) -> int:
        """Get base block type (strips RGBA bit)"""
        return self.block_type & 0x7F
    
    @property
    def type_name(self) -> str:
        """Get human-readable type name (used for filenames)"""
        bt = self.base_type
        if bt in BLOCK_TYPE_NAMES:
            return BLOCK_TYPE_NAMES[bt][0]
        return f"unknown_{self.block_type:02x}"
    
    @property
    def type_description(self) -> str:
        """Get human-readable type description"""
        bt = self.base_type
        rgba = "RGBA" if self.is_rgba else "RGB"
        if bt in BLOCK_TYPE_NAMES:
            return f"{BLOCK_TYPE_NAMES[bt][1]} {rgba}"
        return f"Unknown block 0x{self.block_type:02X} {rgba}"


def rgb565_to_rgb888(data: bytes, width: int, height: int) -> np.ndarray:
    """Convert RGB565 data to RGB888 numpy array"""
    pixels = np.zeros((height, width, 3), dtype=np.uint8)
    offset = 0
    for y in range(height):
        for x in range(width):
            if offset + 1 < len(data):
                # Big endian RGB565 (first byte << 8 | second byte)
                val = (data[offset] << 8) | data[offset + 1]
                r = ((val >> 11) & 0x1F) << 3
                g = ((val >> 5) & 0x3F) << 2
                b = (val & 0x1F) << 3
                pixels[y, x] = [r, g, b]
            offset += 2
    return pixels


def rgb888_to_rgb565(r: int, g: int, b: int) -> int:
    """Convert RGB888 to RGB565"""
    r5 = (r >> 3) & 0x1F
    g6 = (g >> 2) & 0x3F
    b5 = (b >> 3) & 0x1F
    return (r5 << 11) | (g6 << 5) | b5


def decode_raw_rgb(data: bytes, width: int, height: int) -> np.ndarray:
    """
    Decode raw (uncompressed) RGB565 data with 4-byte row alignment.
    Each pixel is 2 bytes in big-endian format (first byte << 8 | second byte).
    Rows are aligned to 4-byte boundaries.
    """
    pixels = np.zeros((height, width, 3), dtype=np.uint8)
    bytes_per_pixel = 2
    row_bytes = width * bytes_per_pixel
    aligned_row_bytes = (row_bytes + 3) & ~3  # Align to 4 bytes
    
    offset = 0
    for y in range(height):
        for x in range(width):
            if offset + 1 < len(data):
                val = (data[offset] << 8) | data[offset + 1]
                r = ((val >> 11) & 0x1F) << 3
                g = ((val >> 5) & 0x3F) << 2
                b = (val & 0x1F) << 3
                pixels[y, x] = [r, g, b]
            offset += 2
        # Skip padding bytes at end of row
        offset += (aligned_row_bytes - row_bytes)
    return pixels


def decode_raw_rgba(data: bytes, width: int, height: int) -> np.ndarray:
    """
    Decode raw (uncompressed) RGBA5658 data with 4-byte row alignment.
    Each pixel is 3 bytes: alpha (1 byte) + RGB565 (2 bytes BE).
    Rows are aligned to 4-byte boundaries.
    """
    pixels = np.zeros((height, width, 4), dtype=np.uint8)
    bytes_per_pixel = 3
    row_bytes = width * bytes_per_pixel
    aligned_row_bytes = (row_bytes + 3) & ~3  # Align to 4 bytes
    
    offset = 0
    for y in range(height):
        for x in range(width):
            if offset + 2 < len(data):
                a = data[offset]
                val = (data[offset + 1] << 8) | data[offset + 2]
                r = ((val >> 11) & 0x1F) << 3
                g = ((val >> 5) & 0x3F) << 2
                b = (val & 0x1F) << 3
                pixels[y, x] = [r, g, b, a]
            offset += 3
        # Skip padding bytes at end of row
        offset += (aligned_row_bytes - row_bytes)
    return pixels


def decompress_rle_rgb_single_frame(data: bytes, width: int, height: int) -> np.ndarray:
    """
    Decompress a single frame of RLE compressed RGB565 data
    
    The compressed data format:
    - First 2 bytes: offset to RLE commands (little endian)
    - Bytes 2..offset: lookup table (unused for decompression)
    - Bytes from offset onwards: RLE stream
    
    RLE format:
    - If count byte is 0: single unique pixel follows (2 bytes)
    - If count byte has bit 7 set (0x80): repeat pixel (count & 0x7F) times
    - Otherwise: count unique pixels follow (count * 2 bytes)
    
    Each pixel is 2 bytes (RGB565 big-endian)
    """
    pixels = np.zeros((height, width, 3), dtype=np.uint8)
    
    if len(data) < 2:
        return pixels
    
    # DEBUG
    if len(data) == 188:
        print(f"DEBUG FRAME 10: First bytes: {data[:4].hex()}")

    skip_offset = data[0] | (data[1] << 8)
    
    # DEBUG
    if skip_offset >= len(data):
        print(f"DEBUG RGB: skip_offset ({skip_offset}) >= len(data) ({len(data)}). Returning blank frame.")
    
    offset = skip_offset
    px_idx = 0
    total_pixels = width * height
    
    while px_idx < total_pixels and offset < len(data):
        count = data[offset]
        offset += 1
        
        if count == 0:
            # Single unique pixel
            if offset + 1 < len(data):
                val = (data[offset] << 8) | data[offset + 1]
                r = ((val >> 11) & 0x1F) << 3
                g = ((val >> 5) & 0x3F) << 2
                b = (val & 0x1F) << 3
                y = px_idx // width
                x = px_idx % width
                pixels[y, x] = [r, g, b]
                px_idx += 1
            offset += 2
        elif count & 0x80:
            # RLE: repeat pixel (count & 0x7F) times
            repeat = count & 0x7F
            if offset + 1 < len(data):
                val = (data[offset] << 8) | data[offset + 1]
                r = ((val >> 11) & 0x1F) << 3
                g = ((val >> 5) & 0x3F) << 2
                b = (val & 0x1F) << 3
                for _ in range(repeat):
                    if px_idx < total_pixels:
                        y = px_idx // width
                        x = px_idx % width
                        pixels[y, x] = [r, g, b]
                        px_idx += 1
            offset += 2
        else:
            # count unique pixels follow
            for _ in range(count):
                if offset + 1 < len(data) and px_idx < total_pixels:
                    val = (data[offset] << 8) | data[offset + 1]
                    r = ((val >> 11) & 0x1F) << 3
                    g = ((val >> 5) & 0x3F) << 2
                    b = (val & 0x1F) << 3
                    y = px_idx // width
                    x = px_idx % width
                    pixels[y, x] = [r, g, b]
                    px_idx += 1
                offset += 2
    
    return pixels


def decompress_rle_rgb(data: bytes, width: int, height: int, num_frames: int = 1, frame_sizes: Optional[List[int]] = None) -> np.ndarray:
    """
    Decompress RLE compressed RGB565 data with multiple frames.
    
    Each frame has its own compressed data block with its own skip_offset header.
    frame_sizes contains the byte size of each frame's compressed data.
    """
    total_height = height * num_frames
    pixels = np.zeros((total_height, width, 3), dtype=np.uint8)
    
    if frame_sizes is None:
        # Fallback: assume single continuous stream (old behavior)
        return decompress_rle_rgb_single_frame(data, width, total_height)
    
    frame_offset = 0
    for frame_idx in range(num_frames):
        if frame_idx >= len(frame_sizes):
            break
        frame_size = frame_sizes[frame_idx]
        frame_data = data[frame_offset:frame_offset + frame_size]
        
        frame_pixels = decompress_rle_rgb_single_frame(frame_data, width, height)
        
        y_start = frame_idx * height
        pixels[y_start:y_start + height, :, :] = frame_pixels
        
        frame_offset += frame_size
    
    return pixels


def decompress_rle_rgba_single_frame(data: bytes, width: int, height: int) -> np.ndarray:
    """
    Decompress a single frame of RLE compressed RGBA5658 data
    
    Each pixel is 3 bytes: alpha (1 byte) + RGB565 (2 bytes BE)
    """
    pixels = np.zeros((height, width, 4), dtype=np.uint8)
    
    if len(data) < 2:
        return pixels
    skip_offset = data[0] | (data[1] << 8)
    
    offset = skip_offset
    px_idx = 0
    total_pixels = width * height
    
    while px_idx < total_pixels and offset < len(data):
        count = data[offset]
        offset += 1
        
        if count == 0:
            # Single unique pixel: alpha (1 byte) + RGB565 (2 bytes BE)
            if offset + 2 < len(data):
                a = data[offset]
                val = (data[offset + 1] << 8) | data[offset + 2]
                r = ((val >> 11) & 0x1F) << 3
                g = ((val >> 5) & 0x3F) << 2
                b = (val & 0x1F) << 3
                y = px_idx // width
                x = px_idx % width
                pixels[y, x] = [r, g, b, a]
                px_idx += 1
            offset += 3
        elif count & 0x80:
            # RLE: repeat pixel (count & 0x7F) times
            repeat = count & 0x7F
            if offset + 2 < len(data):
                a = data[offset]
                val = (data[offset + 1] << 8) | data[offset + 2]
                r = ((val >> 11) & 0x1F) << 3
                g = ((val >> 5) & 0x3F) << 2
                b = (val & 0x1F) << 3
                for _ in range(repeat):
                    if px_idx < total_pixels:
                        y = px_idx // width
                        x = px_idx % width
                        pixels[y, x] = [r, g, b, a]
                        px_idx += 1
            offset += 3
        else:
            # count unique pixels follow
            for _ in range(count):
                if offset + 2 < len(data) and px_idx < total_pixels:
                    a = data[offset]
                    val = (data[offset + 1] << 8) | data[offset + 2]
                    r = ((val >> 11) & 0x1F) << 3
                    g = ((val >> 5) & 0x3F) << 2
                    b = (val & 0x1F) << 3
                    y = px_idx // width
                    x = px_idx % width
                    pixels[y, x] = [r, g, b, a]
                    px_idx += 1
                offset += 3
    
    return pixels


def decompress_rle_rgba(data: bytes, width: int, height: int, num_frames: int = 1, frame_sizes: Optional[List[int]] = None) -> np.ndarray:
    """
    Decompress RLE compressed RGBA5658 data with multiple frames.
    
    Each frame has its own compressed data block with its own skip_offset header.
    frame_sizes contains the byte size of each frame's compressed data.
    """
    total_height = height * num_frames
    pixels = np.zeros((total_height, width, 4), dtype=np.uint8)
    
    if frame_sizes is None:
        # Fallback: assume single continuous stream (old behavior)
        return decompress_rle_rgba_single_frame(data, width, total_height)
    
    frame_offset = 0
    for frame_idx in range(num_frames):
        if frame_idx >= len(frame_sizes):
            break
        frame_size = frame_sizes[frame_idx]
        frame_data = data[frame_offset:frame_offset + frame_size]
        
        frame_pixels = decompress_rle_rgba_single_frame(frame_data, width, height)
        
        y_start = frame_idx * height
        pixels[y_start:y_start + height, :, :] = frame_pixels
        
        frame_offset += frame_size
    
    return pixels


def compress_raw_rgb_aligned(pixels: np.ndarray) -> bytes:
    """
    Compress RGB image data to raw (uncompressed) RGB565 format with 4-byte row alignment.
    Each pixel is 2 bytes in big-endian format.
    Rows are aligned to 4-byte boundaries.
    """
    height, width = pixels.shape[:2]
    result = bytearray()
    
    bytes_per_pixel = 2
    row_bytes = width * bytes_per_pixel
    aligned_row_bytes = (row_bytes + 3) & ~3
    padding = aligned_row_bytes - row_bytes
    
    for y in range(height):
        for x in range(width):
            r, g, b = pixels[y, x, :3]
            rgb565 = rgb888_to_rgb565(r, g, b)
            # Big endian
            result.append((rgb565 >> 8) & 0xFF)
            result.append(rgb565 & 0xFF)
        
        # Add padding
        result.extend(b'\x00' * padding)
            
    return bytes(result)


def compress_raw_rgba_aligned(pixels: np.ndarray) -> bytes:
    """
    Compress RGBA image data to raw (uncompressed) RGBA5658 format with 4-byte row alignment.
    Each pixel is 3 bytes: alpha (1 byte) + RGB565 (2 bytes BE).
    Rows are aligned to 4-byte boundaries.
    """
    height, width = pixels.shape[:2]
    result = bytearray()
    
    bytes_per_pixel = 3
    row_bytes = width * bytes_per_pixel
    aligned_row_bytes = (row_bytes + 3) & ~3
    padding = aligned_row_bytes - row_bytes
    
    for y in range(height):
        for x in range(width):
            if pixels.shape[2] >= 4:
                r, g, b, a = pixels[y, x, :4]
            else:
                r, g, b = pixels[y, x, :3]
                a = 255
            rgb565 = rgb888_to_rgb565(r, g, b)
            
            result.append(a)
            result.append((rgb565 >> 8) & 0xFF)
            result.append(rgb565 & 0xFF)
        
        # Add padding
        result.extend(b'\x00' * padding)
            
    return bytes(result)


def compress_rle_rgb_continuous(pixels: np.ndarray) -> Tuple[bytes, List[int]]:
    """
    Compress RGB image data to RLE RGB565 format as a continuous stream.
    Returns (rle_data, cmd_offsets).
    """
    height, width = pixels.shape[:2]
    
    # Flatten pixels to list of integers
    flat_pixels = []
    for y in range(height):
        for x in range(width):
            r, g, b = pixels[y, x, :3]
            rgb565 = rgb888_to_rgb565(r, g, b)
            flat_pixels.append(rgb565)
            
    # Compress
    cmd_offsets = []
    rle_data = bytearray()
    
    i = 0
    while i < len(flat_pixels):
        current_offset = len(rle_data)
        cmd_offsets.append(current_offset)
        
        current = flat_pixels[i]
        
        # Count runs
        run_length = 1
        while i + run_length < len(flat_pixels) and flat_pixels[i + run_length] == current and run_length < 127:
            run_length += 1
            
        if run_length >= 3:
            # Emit run
            rle_data.append(0x80 | run_length)
            rle_data.append((current >> 8) & 0xFF)
            rle_data.append(current & 0xFF)
            i += run_length
        else:
            # Emit uniques
            unique = []
            while i < len(flat_pixels) and len(unique) < 127:
                # Check for run ahead
                run_ahead = 1
                if i < len(flat_pixels):
                    curr = flat_pixels[i]
                    while i + run_ahead < len(flat_pixels) and flat_pixels[i + run_ahead] == curr and run_ahead < 3:
                        run_ahead += 1
                    if run_ahead >= 3:
                        break
                
                unique.append(flat_pixels[i])
                i += 1
                
                # Check again if we just added a pixel that starts a run
                if len(unique) >= 1 and i < len(flat_pixels):
                    curr = flat_pixels[i]
                    run_ahead = 1
                    while i + run_ahead < len(flat_pixels) and flat_pixels[i + run_ahead] == curr and run_ahead < 3:
                        run_ahead += 1
                    if run_ahead >= 3:
                        break
            
            # Emit unique
            rle_data.append(len(unique))
            for px in unique:
                rle_data.append((px >> 8) & 0xFF)
                rle_data.append(px & 0xFF)
                
    return bytes(rle_data), cmd_offsets


def compress_rle_rgba_continuous(pixels: np.ndarray) -> Tuple[bytes, List[int]]:
    """
    Compress RGBA image data to RLE RGBA5658 format as a continuous stream.
    Returns (rle_data, cmd_offsets).
    """
    height, width = pixels.shape[:2]
    
    # Flatten pixels
    flat_pixels = []
    for y in range(height):
        for x in range(width):
            if pixels.shape[2] >= 4:
                r, g, b, a = pixels[y, x, :4]
            else:
                r, g, b = pixels[y, x, :3]
                a = 255
            rgb565 = rgb888_to_rgb565(r, g, b)
            flat_pixels.append((a, rgb565))
            
    # Compress
    cmd_offsets = []
    rle_data = bytearray()
    
    i = 0
    while i < len(flat_pixels):
        current_offset = len(rle_data)
        cmd_offsets.append(current_offset)
        
        current = flat_pixels[i]
        
        # Count runs
        run_length = 1
        while i + run_length < len(flat_pixels) and flat_pixels[i + run_length] == current and run_length < 127:
            run_length += 1
            
        if run_length >= 3:
            # Emit run
            rle_data.append(0x80 | run_length)
            rle_data.append(current[0])  # alpha
            rle_data.append((current[1] >> 8) & 0xFF)
            rle_data.append(current[1] & 0xFF)
            i += run_length
        else:
            # Emit uniques
            unique = []
            while i < len(flat_pixels) and len(unique) < 127:
                # Check for run ahead
                run_ahead = 1
                if i < len(flat_pixels):
                    curr = flat_pixels[i]
                    while i + run_ahead < len(flat_pixels) and flat_pixels[i + run_ahead] == curr and run_ahead < 3:
                        run_ahead += 1
                    if run_ahead >= 3:
                        break
                
                unique.append(flat_pixels[i])
                i += 1
                
                # Check again if we just added a pixel that starts a run
                if len(unique) >= 1 and i < len(flat_pixels):
                    curr = flat_pixels[i]
                    run_ahead = 1
                    while i + run_ahead < len(flat_pixels) and flat_pixels[i + run_ahead] == curr and run_ahead < 3:
                        run_ahead += 1
                    if run_ahead >= 3:
                        break
            
            # Emit unique
            rle_data.append(len(unique))
            for px in unique:
                rle_data.append(px[0]) # alpha
                rle_data.append((px[1] >> 8) & 0xFF)
                rle_data.append(px[1] & 0xFF)

    return bytes(rle_data), cmd_offsets


def compress_rle_rgb_scanline(pixels_row: List[int]) -> bytes:
    """
    Compress a single scanline of RGB565 pixels to RLE format.
    
    Matches original encoder behavior:
    - Never use 0x00 command (always use 0x01+ for unique sequences)
    - Minimum run length is 3 (not 2)
    - Maximum run/unique length is 127
    
    Returns compressed bytes for this scanline.
    """
    result = bytearray()
    i = 0
    
    while i < len(pixels_row):
        current = pixels_row[i]
        
        # Count consecutive same pixels
        run_length = 1
        while i + run_length < len(pixels_row) and pixels_row[i + run_length] == current and run_length < 127:
            run_length += 1
        
        # Use RLE only for runs of 3+ (matches original behavior)
        if run_length >= 3:
            result.append(0x80 | run_length)
            result.append((current >> 8) & 0xFF)
            result.append(current & 0xFF)
            i += run_length
        else:
            # Collect unique pixels (never use 0x00, always 0x01+)
            unique = []
            
            while i < len(pixels_row) and len(unique) < 127:
                # Check if next 3+ pixels are a run
                run_ahead = 1
                if i < len(pixels_row):
                    curr = pixels_row[i]
                    while i + run_ahead < len(pixels_row) and pixels_row[i + run_ahead] == curr and run_ahead < 3:
                        run_ahead += 1
                    if run_ahead >= 3:
                        break  # Stop collecting uniques, next is a run
                
                unique.append(pixels_row[i])
                i += 1
                
                # Also check if the pixel we just added starts a run of 3+
                if len(unique) >= 1 and i < len(pixels_row):
                    curr = pixels_row[i]
                    run_ahead = 1
                    while i + run_ahead < len(pixels_row) and pixels_row[i + run_ahead] == curr and run_ahead < 3:
                        run_ahead += 1
                    if run_ahead >= 3:
                        break
            
            # Emit unique sequence (always use count, never 0x00)
            result.append(len(unique))
            for px in unique:
                result.append((px >> 8) & 0xFF)
                result.append(px & 0xFF)
    
    return bytes(result)


def compress_rle_rgb(pixels: np.ndarray) -> bytes:
    """
    Compress RGB image data to RLE RGB565 format
    
    Returns compressed bytes (RLE data only, without skip_offset header)
    """
    height, width = pixels.shape[:2]
    result = bytearray()
    
    # Process each scanline separately
    for y in range(height):
        row_pixels = []
        for x in range(width):
            r, g, b = pixels[y, x, :3]
            rgb565 = rgb888_to_rgb565(r, g, b)
            row_pixels.append(rgb565)
        
        row_data = compress_rle_rgb_scanline(row_pixels)
        result.extend(row_data)
    
    return bytes(result)


def compress_rle_rgba_scanline(pixels_row: List[Tuple[int, int]]) -> bytes:
    """
    Compress a single scanline of RGBA5658 pixels to RLE format.
    
    Each pixel is (alpha, rgb565) tuple.
    
    Matches original encoder behavior:
    - Never use 0x00 command (always use 0x01+ for unique sequences)
    - Minimum run length is 3 (not 2)
    - Maximum run/unique length is 127
    
    Returns compressed bytes for this scanline.
    """
    result = bytearray()
    i = 0
    
    while i < len(pixels_row):
        current = pixels_row[i]
        
        # Count consecutive same pixels
        run_length = 1
        while i + run_length < len(pixels_row) and pixels_row[i + run_length] == current and run_length < 127:
            run_length += 1
        
        # Use RLE only for runs of 3+ (matches original behavior)
        if run_length >= 3:
            result.append(0x80 | run_length)
            result.append(current[0])  # alpha
            result.append((current[1] >> 8) & 0xFF)  # RGB565 high
            result.append(current[1] & 0xFF)  # RGB565 low
            i += run_length
        else:
            # Collect unique pixels (never use 0x00, always 0x01+)
            unique = []
            
            while i < len(pixels_row) and len(unique) < 127:
                # Check if next 3+ pixels are a run
                run_ahead = 1
                if i < len(pixels_row):
                    curr = pixels_row[i]
                    while i + run_ahead < len(pixels_row) and pixels_row[i + run_ahead] == curr and run_ahead < 3:
                        run_ahead += 1
                    if run_ahead >= 3:
                        break
                
                unique.append(pixels_row[i])
                i += 1
                
                # Also check if next starts a run of 3+
                if len(unique) >= 1 and i < len(pixels_row):
                    curr = pixels_row[i]
                    run_ahead = 1
                    while i + run_ahead < len(pixels_row) and pixels_row[i + run_ahead] == curr and run_ahead < 3:
                        run_ahead += 1
                    if run_ahead >= 3:
                        break
            
            # Emit unique sequence (always use count, never 0x00)
            result.append(len(unique))
            for px in unique:
                result.append(px[0])  # alpha
                result.append((px[1] >> 8) & 0xFF)  # RGB565 high
                result.append(px[1] & 0xFF)  # RGB565 low
    
    return bytes(result)


def compress_rle_rgba(pixels: np.ndarray) -> bytes:
    """
    Compress RGBA image data to RLE RGBA5658 format
    
    Format: alpha (1 byte) + RGB565 (2 bytes big-endian)
    
    Returns compressed bytes (RLE data only, without skip_offset header)
    """
    height, width = pixels.shape[:2]
    result = bytearray()
    
    # Process each scanline separately
    for y in range(height):
        row_pixels = []
        for x in range(width):
            if pixels.shape[2] >= 4:
                r, g, b, a = pixels[y, x, :4]
            else:
                r, g, b = pixels[y, x, :3]
                a = 255
            rgb565 = rgb888_to_rgb565(r, g, b)
            row_pixels.append((a, rgb565))
        
        row_data = compress_rle_rgba_scanline(row_pixels)
        result.extend(row_data)
    
    return bytes(result)











def compress_rle_row_lookahead(pixels: List[int], width: int) -> bytes:
    """
    Compress 'width' pixels worth of RLE commands from a flattened pixel array.
    
    CRITICAL: The original Chinese encoder uses a lookahead of 2*width pixels.
    This means RLE runs can be at most 2*width (or 127, whichever is smaller).
    
    Each row's commands can emit MORE than 'width' pixels (greedy lookahead).
    
    - pixels: All pixels starting from the current row position
    - width: Width of one row
    
    Returns the RLE data for this row's command(s).
    """
    result = bytearray()
    i = 0
    generated_pixels = 0
    
    # Lookahead limit: 2 rows worth of pixels
    max_lookahead = width * 2
    
    while generated_pixels < width:
        if i >= len(pixels):
            break
            
        current = pixels[i]
        
        # Count consecutive same pixels, limited by lookahead and max RLE (127)
        run_length = 1
        max_run = min(127, max_lookahead - i, len(pixels) - i)
        while run_length < max_run and pixels[i + run_length] == current:
            run_length += 1
            
        # Use RLE for runs of 3+ pixels
        if run_length >= 3:
            result.append(0x80 | run_length)
            result.append((current >> 8) & 0xFF)
            result.append(current & 0xFF)
            i += run_length
            generated_pixels += run_length
        else:
            # Collect unique pixels 
            remaining_in_row = width - generated_pixels
            unique = []
            max_unique = min(127, remaining_in_row)
            
            while len(unique) < max_unique and i < len(pixels) and i < max_lookahead:
                # Check if next 3+ pixels form a run
                run_ahead = 1
                curr = pixels[i]
                while i + run_ahead < len(pixels) and i + run_ahead < max_lookahead and pixels[i + run_ahead] == curr and run_ahead < 3:
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


def compress_rle_rgba_row_lookahead(pixels: List[Tuple[int, int]], width: int) -> bytes:
    """
    Compress exactly 'width' RGBA pixels from a flattened pixel array.
    
    CRITICAL: Generates RLE commands that emit EXACTLY 'width' pixels per row.
    
    - pixels: All pixels starting from the current row position
    - width: Number of pixels to emit for this row
    
    Returns the RLE data for this row's command(s).
    """
    result = bytearray()
    i = 0
    generated_pixels = 0
    
    while generated_pixels < width:
        if i >= len(pixels):
            break
            
        current = pixels[i]
        remaining_in_row = width - generated_pixels
        
        # Count consecutive same pixels
        run_length = 1
        while i + run_length < len(pixels) and pixels[i + run_length] == current and run_length < 127:
            run_length += 1
        
        # Cap to remaining
        run_length = min(run_length, remaining_in_row)
            
        if run_length >= 3:
            result.append(0x80 | run_length)
            result.append(current[0])  # alpha
            result.append((current[1] >> 8) & 0xFF)  # RGB565 high
            result.append(current[1] & 0xFF)  # RGB565 low
            i += run_length
            generated_pixels += run_length
        else:
            unique = []
            max_unique = min(127, remaining_in_row)
            
            while len(unique) < max_unique and i < len(pixels):
                run_ahead = 1
                curr = pixels[i]
                while i + run_ahead < len(pixels) and pixels[i + run_ahead] == curr and run_ahead < 3:
                    run_ahead += 1
                if run_ahead >= 3:
                    break
                
                unique.append(curr)
                i += 1
            
            if unique:
                result.append(len(unique))
                for px in unique:
                    result.append(px[0])  # alpha
                    result.append((px[1] >> 8) & 0xFF)  # RGB565 high
                    result.append(px[1] & 0xFF)  # RGB565 low
                generated_pixels += len(unique)
                
    return bytes(result)


def compress_rle_rgb_stream(all_pixels: List[int], width: int, max_lookahead: Optional[int] = None) -> bytes:
    """
    Compress a stream of RGB565 pixels to RLE format.
    
    Uses greedy RLE with optional lookahead limit.
    
    Args:
        all_pixels: Flat list of RGB565 pixel values
        width: Width of image (used for lookahead calculation)
        max_lookahead: Maximum run length (default: 2*width or 127, whichever is smaller)
    
    Returns:
        RLE compressed data bytes
    """
    if max_lookahead is None:
        max_lookahead = min(127, width * 2)
    
    result = bytearray()
    i = 0
    total = len(all_pixels)
    
    while i < total:
        current = all_pixels[i]
        
        # Count consecutive same pixels
        run_length = 1
        max_run = min(max_lookahead, total - i)
        while run_length < max_run and all_pixels[i + run_length] == current:
            run_length += 1
        
        # Use RLE for runs of 3+ pixels
        if run_length >= 3:
            result.append(0x80 | run_length)
            result.append((current >> 8) & 0xFF)
            result.append(current & 0xFF)
            i += run_length
        else:
            # Collect unique pixels until we hit a run of 3+
            unique = []
            while len(unique) < 127 and i < total:
                # Check if next 3+ pixels form a run
                curr = all_pixels[i]
                run_ahead = 1
                while i + run_ahead < total and run_ahead < 3 and all_pixels[i + run_ahead] == curr:
                    run_ahead += 1
                
                if run_ahead >= 3:
                    break
                
                unique.append(curr)
                i += 1
            
            if unique:
                if len(unique) == 1:
                    # Single pixel command
                    result.append(0x00)
                    result.append((unique[0] >> 8) & 0xFF)
                    result.append(unique[0] & 0xFF)
                else:
                    # Multiple literals
                    result.append(len(unique))
                    for px in unique:
                        result.append((px >> 8) & 0xFF)
                        result.append(px & 0xFF)
    
    return bytes(result)


def compress_rle_rgb_with_header(pixels: np.ndarray) -> bytes:
    """
    Compress RGB image data to RLE RGB565 format with skip_offset header and lookup table.
    
    Restored "Per-Row" logic:
    - Compresses each row independently (with lookahead)
    - Generates separate commands for each row, even if they overlap
    - This creates the structure expected by the watch (which decodes line-by-line)
    """
    height, width = pixels.shape[:2]
    
    # Flatten all pixels once
    all_pixels = []
    for y in range(height):
        for x in range(width):
            r, g, b = pixels[y, x, :3]
            rgb565 = rgb888_to_rgb565(r, g, b)
            all_pixels.append(rgb565)
            
    # Padding to allow lookahead past the last row
    all_pixels.extend([0] * width * 2)
            
    # Compress each row with lookahead into subsequent rows
    scanline_data = []
    for y in range(height):
        start_idx = y * width
        # Pass all remaining pixels for greedy lookahead
        # This will generate "redundant" data for subsequent rows, 
        # but this is REQUIRED because the decoder resets for each row.
        # UPDATE: Restricting to 'width' to prevent spanning rows, matching AM05 behavior.
        # This is safer for compatibility.
        row_data = compress_rle_row_lookahead(all_pixels[start_idx : start_idx + width], width)
        scanline_data.append(row_data)
    
    # Build lookup table
    skip_offset = height * 4
    lookup_table = bytearray()
    
    # RLE data starts at 'skip_offset' relative to frame start
    cumulative = skip_offset
    
    for row_data in scanline_data:
        row_bytes = len(row_data)
        
        # Table entry: low (size * 32), high (cumulative end offset)
        cumulative += row_bytes
        
        low = (row_bytes * 32) & 0xFFFF
        high = cumulative & 0xFFFF
        
        lookup_table.extend(struct.pack('<HH', low, high))
            
    # Combine
    result = bytearray()
    result.extend(struct.pack('<H', skip_offset))
    
    # We need (skip_offset - 2) bytes of table.
    table_bytes = len(lookup_table)
    needed_bytes = skip_offset - 2
    
    if table_bytes >= needed_bytes:
        result.extend(lookup_table[:needed_bytes])
    else:
        result.extend(lookup_table)
        result.extend(b'\x00' * (needed_bytes - table_bytes))
        
    # Append all row data
    for row_data in scanline_data:
        result.extend(row_data)
    
    return bytes(result)


def compress_rle_rgba_with_header(pixels: np.ndarray) -> bytes:
    """
    Compress RGBA image data to RLE RGBA5658 format with skip_offset header and lookup table.
    
    CRITICAL: Replicates original Chinese encoder behavior with greedy RLE.
    """
    height, width = pixels.shape[:2]
    
    # Flatten all pixels once
    all_pixels = []
    for y in range(height):
        for x in range(width):
            if pixels.shape[2] >= 4:
                r, g, b, a = pixels[y, x, :4]
            else:
                r, g, b = pixels[y, x, :3]
                a = 255
            rgb565 = rgb888_to_rgb565(r, g, b)
            all_pixels.append((a, rgb565))
            
    # Padding for lookahead
    all_pixels.extend([(0, 0)] * width * 2)
            
    # Compress each row with lookahead
    scanline_data = []
    for y in range(height):
        start_idx = y * width
        # Restrict to exact row width (no lookahead across rows) to match AM05 behavior
        row_data = compress_rle_rgba_row_lookahead(all_pixels[start_idx : start_idx + width], width)
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






class HK89Dial:
    """Class to handle HK89 dial files"""
    
    def __init__(self):
        self.blocks: List[BlockInfo] = []
        self.raw_data: bytes = b''
        self.num_blocks: int = 0
        self.pltable_size: int = 0
        self.header_byte2: int = 0
        
    def load(self, filepath: str) -> bool:
        """Load a .bin dial file"""
        with open(filepath, 'rb') as f:
            self.raw_data = f.read()
        
        if len(self.raw_data) < 4:
            print(f"Error: File too small")
            return False
        
        # Parse header
        # Bytes 0-1: size of picture lookup table (pltable_size)
        # Byte 2: number of blocks  
        # Byte 3: format type (usually 0x02)
        self.pltable_size = struct.unpack_from('<H', self.raw_data, 0)[0]
        self.num_blocks = self.raw_data[2]
        self.header_byte2 = self.raw_data[3]
        
        print(f"HK89 dial loader v{VERSION}")
        print(f"----------- {filepath} -----------")
        print(f"Number of blocks = {self.num_blocks} , (0x{self.num_blocks:04X})")
        print(f"Size of pltable = {self.pltable_size} , (0x{self.pltable_size:04X})")
        
        # Parse block descriptors - each block is 20 bytes (0x14)
        # Block descriptors start after header (appears to be at offset 0x04 or calculated)
        block_start_offset = 4  # After the 4-byte header
        
        self.blocks = []
        for i in range(self.num_blocks):
            offset = block_start_offset + i * 20
            if offset + 20 > len(self.raw_data):
                print(f"Warning: Not enough data for block {i+1}")
                break
            
            # Parse block structure (20 bytes):
            # 0-3: image offset (little endian 32-bit)
            # 4: pic_idx
            # 5: valami2
            # 6-7: width (sx)
            # 8-9: height (sy) 
            # 10-11: posX
            # 12-13: posY
            # 14: parts (number of frames)
            # 15: block_type
            # 16: align
            # 17: compression
            # 18: centX
            # 19: centY
            
            img_offset = struct.unpack_from('<I', self.raw_data, offset)[0]
            pic_idx = self.raw_data[offset + 4]
            valami2 = self.raw_data[offset + 5]
            width = struct.unpack_from('<H', self.raw_data, offset + 6)[0]
            height = struct.unpack_from('<H', self.raw_data, offset + 8)[0]
            pos_x = struct.unpack_from('<H', self.raw_data, offset + 10)[0]
            pos_y = struct.unpack_from('<H', self.raw_data, offset + 12)[0]
            parts = self.raw_data[offset + 14]
            block_type = self.raw_data[offset + 15]
            align = self.raw_data[offset + 16]
            compression = self.raw_data[offset + 17]
            cent_x = self.raw_data[offset + 18]
            cent_y = self.raw_data[offset + 19]
            
            block = BlockInfo(
                image_offset=img_offset,
                pic_idx=pic_idx,
                valami2=valami2,
                width=width,
                height=height,
                pos_x=pos_x,
                pos_y=pos_y,
                parts=parts,
                block_type=block_type,
                align=align,
                compression=compression,
                cent_x=cent_x,
                cent_y=cent_y
            )
            self.blocks.append(block)
        
        return True
    
    def print_info(self):
        """Print information about all blocks"""
        for i, block in enumerate(self.blocks):
            print(f"Block {i+1:2d}.")
            rgba = "RGBA" if block.is_rgba else "RGB"
            print(f"    0x{block.block_type:02X} type: {block.type_description} ({block.type_name})")
            print(f"    0x{block.image_offset:08X}    ({block.image_offset:7d}) picture address")
            print(f"    0x{block.pic_idx:02X},0x{block.valami2:02X}     ({block.pic_idx:3d},{block.valami2:3d}) picidx,valami2")
            print(f"    0x{block.width:04X},0x{block.height:04X} ({block.width:3d},{block.height:3d}) sx,sy")
            print(f"    0x{block.pos_x:04X},0x{block.pos_y:04X} ({block.pos_x:3d},{block.pos_y:3d}) posX,posY")
            print(f"    0x{block.parts:02X},0x{block.block_type:02X}     ({block.parts:3d},{block.block_type:3d}) parts,block_type")
            print(f"    0x{block.align:02X},0x{block.compression:02X},0x{block.cent_x:02X},0x{block.cent_y:02X} ({block.align:3d},{block.compression:3d},{block.cent_x:3d},{block.cent_y:3d}) align,compr,centX,centY")
    
    def get_pltable_offset(self) -> int:
        """Get the offset to the picture lookup table"""
        # Header (4 bytes) + block descriptors (num_blocks * 20 bytes)
        return 4 + self.num_blocks * 20
    
    def get_frame_sizes(self, pic_idx: int, num_frames: int) -> List[int]:
        """Get the compressed sizes for each frame from the pltable"""
        pltable_offset = self.get_pltable_offset()
        frame_sizes = []
        for i in range(num_frames):
            entry_offset = pltable_offset + (pic_idx + i) * 4
            if entry_offset + 4 <= len(self.raw_data):
                size = struct.unpack_from('<I', self.raw_data, entry_offset)[0]
                frame_sizes.append(size)
        return frame_sizes
    
    def get_frame_raw_data(self, pic_idx: int, frame_idx: int) -> Optional[bytes]:
        """Get the raw compressed data for a specific frame"""
        pltable_offset = self.get_pltable_offset()
        
        # Calculate offset to start of this frame's data
        # Sum sizes of all frames before this one
        cumulative_offset = 0
        for i in range(pic_idx + frame_idx):
            entry_offset = pltable_offset + i * 4
            if entry_offset + 4 <= len(self.raw_data):
                size = struct.unpack_from('<I', self.raw_data, entry_offset)[0]
                cumulative_offset += size
                
        # Get size of this frame
        entry_offset = pltable_offset + (pic_idx + frame_idx) * 4
        if entry_offset + 4 > len(self.raw_data):
            return None
        frame_size = struct.unpack_from('<I', self.raw_data, entry_offset)[0]
        
        # Image data starts after PL table
        # PL table size is in header (first 2 bytes)
        # Wait, pltable_size is number of entries?
        # Header (4) + Blocks (num_blocks * 20) + PL Table (pltable_size * 4)
        img_data_start = pltable_offset + self.pltable_size * 4
        
        start_pos = img_data_start + cumulative_offset
        if start_pos + frame_size > len(self.raw_data):
            return None
            
        return self.raw_data[start_pos : start_pos + frame_size]

    def extract_images(self, output_dir: str) -> Dict:
        """Extract all images to output directory and return metadata"""
        os.makedirs(output_dir, exist_ok=True)
        
        # Save original raw data for bit-exact rebuilding
        with open(os.path.join(output_dir, "source.bin"), "wb") as f:
            f.write(self.raw_data)
        
        metadata = {
            "dial_name": os.path.basename(output_dir),
            "blocks": []
        }
        
        used_names = {}
        
        for i, block in enumerate(self.blocks):
            if block.image_offset == 0 or block.image_offset >= len(self.raw_data):
                print(f"Warning: Block {i+1} has invalid image offset")
                continue
            
            # Generate unique filename
            base_name = block.type_name
            if base_name in used_names:
                used_names[base_name] += 1
                filename = f"{base_name}{used_names[base_name]}.png"
            else:
                used_names[base_name] = 1
                filename = f"{base_name}.png"
            
            # Calculate total height for multi-frame images
            total_height = block.height * block.parts
            
            # Get frame sizes from pltable
            frame_sizes = self.get_frame_sizes(block.pic_idx, block.parts)
            
            if block.type_name == "pulse":
                print(f"DEBUG PULSE SIZES: {frame_sizes}")
                print(f"DEBUG PULSE OFFSET: {block.image_offset}")
            
            # Extract and decompress image data
            try:
                img_data = self.raw_data[block.image_offset:]
                
                if block.compression == 4:
                    # RLE Compressed
                    if block.is_rgba:
                        pixels = decompress_rle_rgba(img_data, block.width, block.height, block.parts, frame_sizes)
                        mode = 'RGBA'
                    else:
                        pixels = decompress_rle_rgb(img_data, block.width, block.height, block.parts, frame_sizes)
                        mode = 'RGB'
                else:
                    # Uncompressed - raw RGB565 or RGBA5658
                    if block.is_rgba:
                        pixels = decode_raw_rgba(img_data, block.width, total_height)
                        mode = 'RGBA'
                    else:
                        pixels = decode_raw_rgb(img_data, block.width, total_height)
                        mode = 'RGB'
                
                # Save image
                img = Image.fromarray(pixels, mode)
                img_path = os.path.join(output_dir, filename)
                img.save(img_path)
                print(f"    Extracted: {filename} ({block.width}x{total_height})")
                
            except Exception as e:
                print(f"    Error extracting block {i+1}: {e}")
                filename = None
            
            # Add to metadata
            block_meta = {
                "type": f"BLK_{block.type_name.upper()}",
                "frms": block.parts,
                "fname": filename,
                "reuse": False,
                "colsp": "RGBA" if block.is_rgba else "RGB",
                "width": block.width,
                "height": block.height,
                "posx": block.pos_x,
                "posy": block.pos_y,
                "alnx": block.align,
                "comp": block.compression,
                "ctx": block.cent_x,
                "cty": block.cent_y
            }
            metadata["blocks"].append(block_meta)
        
        # Save metadata
        json_path = os.path.join(output_dir, "dial_desc.json")
        with open(json_path, 'w') as f:
            json.dump(metadata, f, indent='\t')
        print(f"    Saved metadata to: dial_desc.json")
        

        return metadata

def extract_dial(bin_path: str, output_dir: str) -> bool:
    """
    Extract a full .bin dial file to a directory containing dial_desc.json and PNGs.
    Returns True on success, False on failure.
    """
    try:
        dial = HK89Dial()
        if not dial.load(bin_path):
            return False
            
        dial.extract_images(output_dir)
        return True
    except Exception as e:
        print(f"extract_dial error: {e}")
        return False


def extract_preview_png(bin_path: str, output_png: str) -> str:
    """
    Extract the preview image from a .bin dial file and save as PNG.
    Returns the output path on success, empty string on failure.
    
    The preview block has base_type 0x01 (BLK_PREV).
    """
    try:
        dial = HK89Dial()
        if not dial.load(bin_path):
            return ""

        for block in dial.blocks:
            base_type = block.block_type & 0x7F
            if base_type != 0x01:
                continue

            # Found preview block, decompress it
            img_data = dial.raw_data[block.image_offset:]
            frame_sizes = dial.get_frame_sizes(block.pic_idx, 1)

            if block.compression == 4:
                if block.is_rgba:
                    pixels = decompress_rle_rgba(img_data, block.width, block.height, 1, frame_sizes)
                    mode = 'RGBA'
                else:
                    pixels = decompress_rle_rgb(img_data, block.width, block.height, 1, frame_sizes)
                    mode = 'RGB'
            else:
                if block.is_rgba:
                    pixels = decode_raw_rgba(img_data, block.width, block.height)
                    mode = 'RGBA'
                else:
                    pixels = decode_raw_rgb(img_data, block.width, block.height)
                    mode = 'RGB'

            img = Image.fromarray(pixels, mode)
            img.save(output_png)
            return output_png

        return ""
    except Exception as e:
        print(f"extract_preview_png error: {e}")
        return ""


def compile_dial(input_dir: str, output_file: Optional[str] = None) -> bool:
    """
    Compile images from a directory into a .bin dial file
    
    Reads dial_desc.json for metadata and compiles all referenced images.
    
    File format:
    - Header (4 bytes): pltable_size (2) + num_blocks (1) + format (1)
    - Block descriptors (num_blocks * 20 bytes)
    - Picture lookup table (pltable_size * 4 bytes): compressed size per frame
    - Image data: RLE compressed frames
    """
    json_path = os.path.join(input_dir, "dial_desc.json")
    if not os.path.exists(json_path):
        print(f"Error: dial_desc.json not found in {input_dir}")
        return False
    
    with open(json_path, 'r') as f:
        metadata = json.load(f)
    
    if output_file is None:
        output_file = "recompiled.bin"
    
    print(f"--------------- HK89 compiler v{VERSION} ---------------")
    print(f"input file size={os.path.getsize(json_path)} Bytes")
    print(f"Number of input json blocks={len(metadata['blocks'])}")
    
    # Extended block type mapping (supports both formats)
    # Maps JSON type strings to base block type codes
    TYPE_MAP = {
        # Preview/Background
        'BLK_PREV': 0x01, 'BLK_PREVI': 0x01,
        'BLK_BGIMG': 0x02, 'BLK_BACKGROUND': 0x02, 'BLK_BACKGROUND2': 0x02,
        # Analog clock hands
        'BLK_ARMH': 0x03, 'BLK_ARM_HOUR': 0x03,
        'BLK_ARMM': 0x04, 'BLK_ARM_MINUTE': 0x04,
        'BLK_ARMS': 0x05, 'BLK_ARM_SECOND': 0x05,
        # Date/Time
        'BLK_YEAR': 0x06,
        'BLK_MONTH': 0x07,
        'BLK_DAY': 0x08,
        'BLK_HOUR': 0x09, 'BLK_HOURS': 0x09,
        'BLK_MIN': 0x0A, 'BLK_MINUTES': 0x0A,
        'BLK_SEC': 0x0B, 'BLK_SECONDS': 0x0B,
        'BLK_AMPM': 0x0C,
        'BLK_WEEKD': 0x0D,
        # Health/Activity
        'BLK_STEPS': 0x0E,
        'BLK_PULS': 0x0F, 'BLK_PULSE': 0x0F,
        'BLK_CALOR': 0x10,
        'BLK_DIST': 0x11,
        # Status
        'BLK_BATTN': 0x12, 'BLK_BATTERY': 0x12,
        'BLK_CONN': 0x13, 'BLK_CONNECT': 0x13,
        # Decorations
        'BLK_BERRY': 0x16, 'BLK_BIGYO': 0x16,
        'BLK_ANIM': 0x17, 'BLK_ANIMPART': 0x17,
        'BLK_BATTS': 0x18, 'BLK_BATTERY_STRIP': 0x18,
        'BLK_WEAT': 0x19, 'BLK_WEATHER': 0x19,
        'BLK_TEMP': 0x1A,
        # Progress bars
        'BLK_PROG2': 0x1E, 'BLK_PROGRESS2': 0x1E,
        'BLK_PROG1': 0x20, 'BLK_PROGRESS1': 0x20,
        # Labels and digit splits
        'BLK_LABEL': 0x25,
        'BLK_HOURL': 0x27, 'BLK_HOUR_LO': 0x27,
        'BLK_HOURH': 0x28, 'BLK_HOUR_HI': 0x28,
        'BLK_MINH': 0x29, 'BLK_MINUTE_HI': 0x29,
        'BLK_MINL': 0x2A, 'BLK_MINUTE_LO': 0x2A,
        # Unknown types (empty in XDA tool - now identified as progress bars)
        'BLK_UNKNOWN': 0x1E,
        'BLK_UNKNOWN2': 0x20,
        'BLK_': 0x1E,  # XDA tool outputs this for unknown types
    }
    
    num_blocks = len(metadata['blocks'])
    
    # First pass: load images and compress per-frame to build pltable
    print("Compilation of images...")
    
    blocks_info = []  # Block metadata
    pltable = []  # Per-frame compressed sizes
    all_frame_data = []  # Compressed data for each frame
    
    for block_idx, block_meta in enumerate(metadata['blocks']):
        fname = block_meta.get('fname')
        if not fname:
            continue
        
        img_path = os.path.join(input_dir, fname)
        if not os.path.exists(img_path):
            print(f"Warning: Image not found: {fname}")
            continue
        
        # Load image
        img = Image.open(img_path)
<<<<<<< HEAD
        frms = max(1, int(block_meta.get('frms', 1)))

        # Determine color space from metadata FIRST
        is_rgba = block_meta.get('colsp', 'RGB') == 'RGBA'
        
        # Convert image to the correct mode based on metadata colsp
        # This is CRITICAL for JPEG support - JPEGs must be kept as RGB for background blocks
        target_mode = 'RGBA' if is_rgba else 'RGB'
        original_mode = img.mode
        if img.mode != target_mode:
            img = img.convert(target_mode)
            print(f"        Converting {fname} from {original_mode} to {target_mode}")
        
        # Respect dial metadata dimensions so replacement backgrounds keep valid geometry.
        target_width = int(block_meta.get('width', img.width))
        target_total_height = int(block_meta.get('height', img.height // frms)) * frms
        if img.width != target_width or img.height != target_total_height:
            img = img.resize((target_width, target_total_height), Image.LANCZOS)
=======
        if img.mode != 'RGBA':
            img = img.convert('RGBA')
            
>>>>>>> e26b9a638 (fixed connection again)
        width, height = img.size
        
        # Determine color space and block type
        is_rgba = block_meta.get('colsp', 'RGB') == 'RGBA'
        type_str = block_meta.get('type', 'BLK_PREV').upper()
        
        # Get base block type from map
        block_type = TYPE_MAP.get(type_str, 0x01)
        
        # Set RGBA bit if needed (bit 7)
        if is_rgba:
            block_type |= 0x80
        
        pixels = np.array(img)
        
        # Number of frames
        frame_height = height // frms if frms > 0 else height
        
        print(f"    read_from {input_dir}/{fname}, uncompressed size:{pixels.nbytes}, ({width}x{height})")
        
        # pic_idx is the starting index in pltable for this block's frames
        pic_idx = len(pltable)
        
        # Default compression to 6 to match hkcomposer behavior
        compression_type = block_meta.get('comp', 6)
        
        # Compress each frame separately
        frame_compressed_data = []
        for frame_idx in range(frms):
            y_start = frame_idx * frame_height
            y_end = y_start + frame_height
            frame_pixels = pixels[y_start:y_end, :, :]
            
            if compression_type == 0:
                # Raw compression
                if is_rgba:
                    compressed = compress_raw_rgba_aligned(frame_pixels)
                else:
                    compressed = compress_raw_rgb_aligned(frame_pixels)
            else:
                # RLE compression
                if is_rgba:
                    compressed = compress_rle_rgba_with_header(frame_pixels)
                else:
                    compressed = compress_rle_rgb_with_header(frame_pixels)
            
            # Add 4-byte alignment padding (original encoder pads frames to 4-byte boundary)
            padding_needed = (4 - (len(compressed) % 4)) % 4
            if padding_needed > 0:
                compressed = compressed + b'\x00' * padding_needed
            
            pltable.append(len(compressed))
            frame_compressed_data.append(compressed)
        
        all_frame_data.append(frame_compressed_data)
        
        blocks_info.append({
            'pic_idx': pic_idx,
            'valami2': 0,
            'width': width,
            'height': frame_height,
            'pos_x': block_meta.get('posx', 0),
            'pos_y': block_meta.get('posy', 0),
            'parts': frms,
            'block_type': block_type,
            'align': block_meta.get('alnx', 9),
            'compression': compression_type,
            'cent_x': block_meta.get('ctx', 0),
            'cent_y': block_meta.get('cty', 0),
            'frame_data': frame_compressed_data,
        })
    
    # Calculate offsets
    # Header: 4 bytes + block descriptors + pltable
    pltable_size = len(pltable)
    header_size = 4
    actual_num_blocks = len(blocks_info)  # Use actual count, not JSON count
    blocks_size = actual_num_blocks * 20
    pltable_bytes = pltable_size * 4
    images_start = header_size + blocks_size + pltable_bytes
    
    print(f"Compilation of blocks... (pl_num={pltable_size})")
    
    # Build image data and calculate per-block offsets
    image_data = bytearray()
    current_offset = images_start
    
    for i, block in enumerate(blocks_info):
        block['image_offset'] = current_offset
        
        # Concatenate all frames for this block
        for frame_data in block['frame_data']:
            image_data.extend(frame_data)
            current_offset += len(frame_data)
        
        is_rgba = (block['block_type'] & 0x80) != 0
        rgba_str = "RGBA" if is_rgba else "RGB"
        print(f" {i}. blokk: type=0x{block['block_type']:02X}, {rgba_str}  px={block['pos_x']:3d}, py={block['pos_y']:3d}, "
              f"sx={block['width']:3d}, sy={block['height']:3d}, pic offs=0x{block['image_offset']:04X}")
    
    # Build the output file
    output = bytearray()
    
    # Header (4 bytes)
    struct.pack_into('<H', (header := bytearray(4)), 0, pltable_size)
    header[2] = actual_num_blocks  # Use actual count
    header[3] = 0x02  # Format type
    output.extend(header)
    
    # Block descriptors (20 bytes each)
    for block in blocks_info:
        desc = bytearray(20)
        struct.pack_into('<I', desc, 0, block['image_offset'])
        desc[4] = block['pic_idx']
        desc[5] = block['valami2']
        struct.pack_into('<H', desc, 6, block['width'])
        struct.pack_into('<H', desc, 8, block['height'])
        struct.pack_into('<H', desc, 10, block['pos_x'])
        struct.pack_into('<H', desc, 12, block['pos_y'])
        desc[14] = block['parts']
        desc[15] = block['block_type']
        desc[16] = block['align']
        desc[17] = block['compression']
        desc[18] = block['cent_x']
        desc[19] = block['cent_y']
        output.extend(desc)
    
    # Picture lookup table (4 bytes per frame)
    for frame_size in pltable:
        output.extend(struct.pack('<I', frame_size))
    
    # Image data
    output.extend(image_data)
    
    # Write output file
    with open(output_file, 'wb') as f:
        f.write(output)
    
    print(f"Done. Output: {output_file} ({os.path.getsize(output_file)} bytes)")
    return True


def main():
    if len(sys.argv) < 2:
        print(f"HK89 Dial Tool v{VERSION}")
        print(f"Usage:")
        print(f"  {sys.argv[0]} <input.bin> [output_dir]  - Decompress dial")
        print(f"  {sys.argv[0]} -c <input_dir> [output.bin]  - Compile dial")
        return 1
    
    if sys.argv[1] == '-c':
        # Compile mode
        if len(sys.argv) < 3:
            print("Error: Input directory required")
            return 1
        input_dir = sys.argv[2]
        output_file = sys.argv[3] if len(sys.argv) > 3 else "recompiled.bin"
        success = compile_dial(input_dir, output_file)
        return 0 if success else 1
    else:
        # Decompress mode
        input_file = sys.argv[1]
        if not os.path.exists(input_file):
            print(f"Error: File not found: {input_file}")
            return 1
        
        output_dir = sys.argv[2] if len(sys.argv) > 2 else os.path.splitext(input_file)[0] + "_extracted"
        
        dial = HK89Dial()
        if not dial.load(input_file):
            return 1
        
        dial.print_info()
        dial.extract_images(output_dir)
        return 0


if __name__ == '__main__':
    sys.exit(main())

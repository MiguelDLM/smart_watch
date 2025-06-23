import struct
import json
from pathlib import Path
from PIL import Image

def pack_rgb565(r, g, b):
    """Convert 8-bit RGB to RGB565 (5-6-5)"""
    r5 = (r * 31) // 255
    g6 = (g * 63) // 255
    b5 = (b * 31) // 255
    return struct.pack('<H', (r5 << 11) | (g6 << 5) | b5)

def compress_raw_aligned(rgba, width, height, has_alpha):
    """Raw aligned: per-row pixel data (A+RGB565 or RGB565), padded to 4-byte rows"""
    bytes_per_pixel = 3 if has_alpha else 2
    row_bytes = width * bytes_per_pixel
    aligned = bytearray()
    idx = 0
    for y in range(height):
        row = rgba[idx:idx + width*4]
        idx += width*4
        # build row data
        row_data = bytearray()
        for px in range(width):
            r, g, b, a = row[px*4:px*4+4]
            if has_alpha:
                row_data.append(a)
            row_data.extend(pack_rgb565(r, g, b))
        # pad to 4-byte alignment
        padding = (-len(row_data)) % 4
        row_data.extend(b'\x00' * padding)
        aligned.extend(row_data)
    return aligned

def compress_hk89_rle(rgba, width, height, has_alpha):
    """HK89 RLE: header (2 bytes = 2), then count-based RLE"""
    # Helper to read pixel tuple
    pixels = [tuple(rgba[i:i+4]) for i in range(0, len(rgba), 4)]
    out = bytearray()
    # header: offset to data start = 2
    out.extend(struct.pack('<H', 2))
    i = 0
    total = len(pixels)
    while i < total:
        # run detection
        run_len = 1
        while (i + run_len < total and run_len < 127 and
               pixels[i+run_len] == pixels[i]):
            run_len += 1
        if run_len > 1:
            # RLE mode
            count_byte = 0x80 | run_len
            out.append(count_byte)
            r, g, b, a = pixels[i]
            if has_alpha:
                out.append(a)
            out.extend(pack_rgb565(r, g, b))
            i += run_len
        else:
            # literal mode: gather until next run or max 127
            lit_start = i
            literal = []
            while (i < total and len(literal) < 127):
                # peek ahead for a run of 2+
                if (i + 1 < total and pixels[i] == pixels[i+1]):
                    break
                literal.append(pixels[i])
                i += 1
            out.append(len(literal))
            for r, g, b, a in literal:
                if has_alpha:
                    out.append(a)
                out.extend(pack_rgb565(r, g, b))
    return out

def generate_trailer(pattern=b'\xFF\x00\xFF\xFF', repeat=16):
    """Generate trailer: repeats a 4-byte pattern (default FF 00 FF FF)"""
    return pattern * repeat

def build_bin(config_path, output_path):
    """
    config.json example:
    {
      "blocks": [
        {
          "image": "bg.png",
          "picidx": 0,
          "valami2": 1,
          "sx": 240, "sy": 240,
          "posX": 0, "posY": 0,
          "parts": 1,
          "blocktype": 0x01,
          "align": 0,
          "compr": 1,
          "centX": 120, "centY": 120
        },
        ...
      ]
    }
    """
    cfg = json.load(open(config_path))
    blocks = cfg["blocks"]
    # Load images and compute RGBA buffers
    for blk in blocks:
        img = Image.open(blk["image"]).convert("RGBA")
        blk["width"], blk["height"] = img.size
        blk["rgba"] = img.tobytes()
        blk["has_alpha"] = any(blk["rgba"][i+3] != 255 for i in range(0, len(blk["rgba"]), 4))
    # Compute header sizes and offsets
    block_count = len(blocks)
    picture_table_size = 4 + block_count * 20
    offset = picture_table_size
    for blk in blocks:
        blk["picture_address"] = offset
        # select compression
        if blk["compr"] == 0:
            data = compress_raw_aligned(blk["rgba"], blk["width"], blk["height"], blk["has_alpha"])
        else:
            data = compress_hk89_rle(blk["rgba"], blk["width"], blk["height"], blk["has_alpha"])
        blk["data"] = data
        offset += len(data)
    # Build binary
    with open(output_path, "wb") as f:
        # header
        f.write(struct.pack('<H', picture_table_size))
        f.write(struct.pack('B', block_count))
        f.write(b'\x00')  # reserved
        # block entries
        for blk in blocks:
            entry = struct.pack(
                '<I2B4H6B',
                blk["picture_address"],
                blk["picidx"],
                blk["valami2"],
                blk["width"], blk["height"],
                blk["posX"], blk["posY"],
                blk["parts"],
                blk["blocktype"],
                blk["align"],
                blk["compr"],
                blk["centX"], blk["centY"]
            )
            f.write(entry)
        # image data
        for blk in blocks:
            f.write(blk["data"])
        # trailer
        f.write(generate_trailer())
    print(f"Built {output_path} successfully.")

if __name__ == "__main__":
    import argparse
    p = argparse.ArgumentParser(description="Python HKComposer replica")
    p.add_argument("--config", required=True, help="Path to JSON config")
    p.add_argument("--output", required=True, help="Output .bin file")
    args = p.parse_args()
    build_bin(args.config, args.output)

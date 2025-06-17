#!/usr/bin/env python3
"""Compare two HK dial binaries and report structural differences."""
import sys
import struct
from hkdecomp import SimpleHKDecompressor


def load_info(path):
    d = SimpleHKDecompressor()
    if not d.load_file(path):
        raise RuntimeError(f"Failed to load {path}")
    d.parse_blocks()
    d.calculate_picture_sizes()
    return d


def compare(original, rebuilt):
    a = load_info(original)
    b = load_info(rebuilt)
    diffs = []
    if a.block_count != b.block_count:
        diffs.append(f"Block count: {a.block_count} vs {b.block_count}")
    if a.picture_table_size != b.picture_table_size:
        diffs.append(
            f"Picture table size: {a.picture_table_size} vs {b.picture_table_size}"
        )
    for i, (ba, bb) in enumerate(zip(a.blocks, b.blocks), 1):
        if ba.picture_address != bb.picture_address:
            diffs.append(
                f"Block {i} address: {ba.picture_address} vs {bb.picture_address}"
            )
        if ba.parts != bb.parts:
            diffs.append(f"Block {i} parts: {ba.parts} vs {bb.parts}")
        if ba.compr != bb.compr:
            diffs.append(f"Block {i} compr: {ba.compr} vs {bb.compr}")

    # Compare picture size table entries
    max_entries = min(a.picture_table_size, b.picture_table_size)
    for i in range(max_entries):
        sa = a.picture_sizes[i]
        sb = b.picture_sizes[i]
        if sa != sb:
            diffs.append(f"Pic size[{i}] {sa} vs {sb}")
            break
    if not diffs:
        print("Structures match")
    else:
        print("Differences:")
        for d in diffs:
            print("-", d)

    # Find first differing byte
    with open(original, "rb") as fa, open(rebuilt, "rb") as fb:
        pos = 0
        while True:
            ba = fa.read(4096)
            bb = fb.read(4096)
            if not ba and not bb:
                print("Files are identical")
                break
            minlen = min(len(ba), len(bb))
            for i in range(minlen):
                if ba[i] != bb[i]:
                    print(f"First byte difference at offset {pos+i}")
                    return
            if len(ba) != len(bb):
                print(f"Files differ in length at offset {pos+minlen}")
                return
            pos += minlen


if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: bincompare.py original.bin rebuilt.bin")
        sys.exit(1)
    compare(sys.argv[1], sys.argv[2])

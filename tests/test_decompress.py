import os
import sys
import types

# Provide stub PIL module if Pillow is missing
try:
    from PIL import Image  # noqa: F401
except Exception:
    pil = types.ModuleType('PIL')
    image = types.ModuleType('PIL.Image')
    pil.Image = image
    sys.modules['PIL'] = pil
    sys.modules['PIL.Image'] = image

# Ensure repository root is on sys.path
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from hkdecomp import ImageDecompressor


def test_decompress_hk89_rle_basic():
    compressed = bytes([
        0x02, 0x00,  # header: data starts at byte 2
        0x00, 0xF8, 0x00,  # red pixel
        0x00, 0xF8, 0x00,  # red pixel
        0x00, 0x00, 0x1F,  # blue pixel
        0x00, 0x00, 0x1F   # blue pixel
    ])
    data = ImageDecompressor.decompress_hk89_rle(compressed, 2, 2, False)
    assert data is not None
    assert len(data) == 12  # 4 pixels * 3 bytes each

    # Verify pixel colors: two red followed by two blue
    expected = bytes([
        0xF8, 0x00, 0x00,
        0xF8, 0x00, 0x00,
        0x00, 0x00, 0xF8,
        0x00, 0x00, 0xF8,
    ])
    assert data == expected

import pytest


def test_kronos_roundtrip(tmp_path):
    # Skip if Pillow or numpy are missing
    try:
        import PIL.Image  # noqa: F401
        import numpy  # noqa: F401
    except Exception:
        pytest.skip("Required libraries not installed")

    from hkdecomp import SimpleHKDecompressor
    from hkcomposer import OptimizedDialComposer

    bin_path = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'kronos.bin'))

    dec = SimpleHKDecompressor()
    assert dec.process(bin_path)

    output_dir = "_kronos"
    config_file = os.path.join(output_dir, 'config.json')
    rebuilt = tmp_path / 'kronos_rebuild.bin'

    comp = OptimizedDialComposer()
    assert comp.compose(config_file, str(rebuilt))

    assert rebuilt.exists() and rebuilt.stat().st_size > 0

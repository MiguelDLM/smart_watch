# Watch Faces for Smartwatches

This repository contains experiments and findings related to creating custom watch faces for a wide range of smartwatches.

## Overview

The goal of this project is to understand and document the process of designing and deploying custom watch faces on various smartwatch models. The repository includes reverse engineering efforts, code samples, and extracted resources.

## hkdecomp.py

The `hkdecomp.py` file was generated using reverse engineering tools and AI, based on binaries published by the user zzuler on the XDA forums. **Note:** The code is incomplete and the decompilation is imperfect. PNG files extracted from the binaries may not be correctly decoded.

## Supported Devices

A comprehensive list of supported devices is available in the [`devices_supported.csv`](devices_supported.csv) file. This CSV contains the names of all smartwatch models known to be compatible with the file formats and methods explored in this repository.

## How to Use

1. **Explore the Code:**
   Review `hkdecomp.py` and other scripts to understand the extraction and decoding process.
2. **Check Device Compatibility:**
   Refer to `devices_supported.csv` to see if your smartwatch is supported.
3. **Contribute:**
   Pull requests and issues are welcome! If you have additional information about file formats or device compatibility, please contribute.

## Compare Binaries

Use `bincompare.py` to analyze structural differences between an original dial
binary and a rebuilt version. This script reports mismatched block addresses,
picture sizes, and the first differing byte offset.

```bash
./bincompare.py original.bin rebuilt.bin
```

## Disclaimer

This project is for educational and research purposes only. Reverse engineering firmware or binaries may violate the terms of service of your device. Use at your own risk.


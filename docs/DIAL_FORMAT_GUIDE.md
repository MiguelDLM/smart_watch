# Smartwatch Dial (.bin) File Format & Builder Guide

This document compiles everything we have reverse-engineered and discovered about the dial binary format used by **HK89**, **JL/AM05**, and compatible smartwatches. It is derived from analysis of over 10 decompiled AM05 Kronos Thunder dials.

---

## 1. Binary File Structure Overview

Each smartwatch dial is compiled into a single `.bin` file containing:
1. **Header**: Declares the number of block layers and sizes.
2. **PLTable (Picture Length Table)**: Contains length indices mapping to compressed frame offsets.
3. **Metadata Blocks**: An array of structure configurations defining layer types, coordinates, widths, heights, frame counts (`frms`), align flags (`alnx`), compression formats (`comp`), and rotation pivots (`ctx`, `cty`).
4. **Compressed Image Streams**: Packed RLE-compressed graphics corresponding to each metadata layer.

The decompression and compilation are handled by the script [`comp_decomp.py`](file:///home/miguel/Documentos/development/smart_watch/smart_watch/comp_decomp.py).

---

## 2. Image Compression Specs

Smartwatch screens require fast drawing speeds with minimal memory footprint. The binary utilizes a custom Run-Length Encoding (RLE) system with two primary color formats:
* **RGB565** (16-bit color, decompressed to RGB 24-bit): Primarily used for solid backgrounds, preview images, and digits.
* **RGBA5658** (24-bit, 16-bit color + 8-bit Alpha channel): Used for hands, overlays, center caps, and elements requiring transparency.

### Compression Modes (`comp`):
* **Mode 4**: Standard compression mode. Highly compatible with watch firmware. All compiled custom dials **must** enforce `comp = 4` to prevent dial corruption on upload.
* **Mode 0**: Used exclusively for analog hand layers (`BLK_ARM_HOUR`, `BLK_ARM_MINUTE`, `BLK_ARM_SECOND`). These blocks use a rotation-based render (no frame strips needed; always `frms = 1`).
* **Mode 6**: Alternate compression mode found on some OEM dials. Decompression supports both Mode 4 and Mode 6.

---

## 3. Metadata Block Types Reference

The block types represent individual visual widgets. High-bit variants (value `+ 0x80`) indicate the layer utilizes **RGBA** with transparency instead of solid **RGB**.

| Type Code (Hex) | Name in Builder | JSON Type | Description | Frames | comp |
| :--- | :--- | :--- | :--- | :--- | :--- |
| `0x01` | Preview Image | `BLK_PREV` | Small thumbnail image for watch menus (280×280 px). | 1 | 4 |
| `0x02` | Background Image | `BLK_BACKGROUND` | Watchface wallpaper. Must be exactly 466×466 px. | 1 | 4 |
| `0x83` | Hour Hand | `BLK_ARM_HOUR` | Analog hour clock hand. Rotates around `ctx`/`cty` pivot. | 1 | 0 |
| `0x84` | Minute Hand | `BLK_ARM_MINUTE` | Analog minute clock hand. Rotates around `ctx`/`cty` pivot. | 1 | 0 |
| `0x85` | Second Hand | `BLK_ARM_SECOND` | Analog second clock hand. Rotates around `ctx`/`cty` pivot. | 1 | 0 |
| `0x06` | Year digits | `BLK_YEAR` | Typographic numbers representing current year. | 10 | 4 |
| `0x07` | Month digits | `BLK_MONTH` | Month numbers (10 frames) or month names (12 frames). | 10–12 | 4 |
| `0x08` | Day digits | `BLK_DAY` | Current date day numbers. | 10 | 4 |
| `0x09` | Hours digits | `BLK_HOURS` | Standard digital hours. | 10 | 4 |
| `0x0A` | Minutes digits | `BLK_MINUTES` | Standard digital minutes. | 10 | 4 |
| `0x0B` | Seconds digits | `BLK_SECONDS` | Standard digital seconds. | 10 | 4 |
| `0x0C` | AM/PM | `BLK_AMPM` | AM/PM indicator. Frame 0: AM, Frame 1: PM. | 2 | 4 |
| `0x0D` | Day of Week | `BLK_WEEKD` | Weekday abbreviations. Starts on Sunday (0=SUN). | 7 | 4 |
| `0x0E` | Steps digits | `BLK_STEPS` | Digital representation of steps count. | 10 | 4 |
| `0x0F` | Heart Rate | `BLK_PULSE` | Digital display of pulse BPM. | 10 | 4 |
| `0x10` | Calories | `BLK_CALOR` | Digital display of burned calories. | 10 | 4 |
| `0x11` | Distance | `BLK_DIST` | Digital display of walked distance. | 11 (0–9 + decimal) | 4 |
| `0x12` | Battery digits | `BLK_BATTERY` | Digital display of battery percentage. | 10 | 4 |
| `0x13` | Connection status | `BLK_CONNECT` | Bluetooth state. Frame 0: Disconnected, Frame 1: Connected. | 2 | 4 |
| `0x96` | Center Cap | `BLK_BIGYO` | Pivot center axle decoration for analog hands. | 1 | 4 |
| `0x17` | Animation | `BLK_ANIMPART` | Looping animation. Frames cycle via time-based trigger. | Variable (5–15) | 4 |
| `0x18` | Battery Strip | `BLK_BATTERY_STRIP` | Multi-stage visual battery gauge. | 6 | 4 |
| `0x19` | Weather Status | `BLK_WEATHER` | Weather condition icons. | 12 | 4 |
| `0x1A` | Temperature | `BLK_TEMP` | Digital temperature display. | 10–12 (+ sign frames) | 4 |
| `0x1E` | Arc Progress 2 | `BLK_PROGRESS2` | Circular analog progress bar (e.g., activity rings). | 11 | 4 |
| `0x20` | Arc Progress 1 | `BLK_PROGRESS1` | Circular analog progress bar (e.g., steps arc). | 11 | 4 |
| `0xA1` | **UNKNOWN_A1** | `BLK_UNKNOWN_A1` | Observed in multiple dials. Appears similar to `BLK_BATTERY_STRIP` or animated gauge. May be a secondary gauge type. | 5–6 | 4 |

> **Note on `BLK_UNKNOWN_A1`**: This block type appears in at least 4 dials (2945, 2860, 3033, 3086). Its rendered images look like animated gauge arcs or combined battery+activity overlays. It uses 5–6 frames just like `BLK_BATTERY_STRIP`. Possibly type code `0xA1` (RGBA variant of code `0x21`).

---

## 4. Key Design Constraints & Rules

### A. Screen Resolutions
The screen resolution must be strictly respected. For standard AM05/HK89 models:
* Target diameter/resolution is **466×466 pixels** (circular display).
* Background (`BLK_BACKGROUND`) must be exactly **466×466 px** and set to `posx=0, posy=0`.
* Preview thumbnail (`BLK_PREV`) must be exactly **280×280 px**.

### B. Frame-Based Vertical Strips
To represent multiple states (digits `0-9`, weekdays `Mon-Sun`, animation loops), the format uses a **single PNG file where all frames are stacked vertically** (a "sprite sheet").

* If a block has width `W`, height `H` per frame, and `F` total frames, the uploaded PNG image must have dimensions:
  - **Width** = `W`
  - **Height** = `H × F`
* **Crucial Rule**: The image height must be perfectly divisible by the frame count (`F`). The compilation tool will abort if a layer's image height is not divisible by `frms`.

### C. Watch Memory Limitations
Smartwatches run on highly restricted RAM (often less than 1MB is allocated for active watch face assets). If the total asset size exceeds memory limits, the watch will crash, freeze, or reject the dial as corrupt.

* **Avoid Full-Screen Animations**: An animation of 466×466 px with 10 frames requires over 4MB of raw frame buffer, which will crash the watch.
* **Keep Animation Dimensions Small**: `BLK_ANIMPART` blocks should be kept cropped to local, small regions (e.g., 100×100 px or smaller).
* **Fewer Frames**: Extract only 5 to 12 frames for animations. Use the built-in **Animation Slicer** to crop and downsample video/GIF uploads.

### D. Typographic Digits Mapping
Numeric layers (hours, minutes, seconds, calories, etc.) expect exactly **10 frames** representing characters in standard order:

```
Frame index:  0   1   2   3   4   5   6   7   8   9
Digit:        0   1   2   3   4   5   6   7   8   9
```

* **Distance digits**: Requires an 11th frame representing a decimal point (`.`) or space.
* **Weekday frames**: Map from `0 = Sunday` to `6 = Saturday` matching the standard JavaScript `getDay()` format.
* **Month names**: If `BLK_MONTH` uses 12 frames (not 10), each frame is a full month name text image (JAN, FEB, ... DEC).

### E. Analog Hands (ARM) Rules
Analog hands are special blocks that are **not** drawn as sprite strips. They are rendered by the firmware through rotation math:
* Always `frms = 1` (single source image).
* Always `comp = 0` (no RLE compression — raw RGBA).
* The image is typically a **tall vertical strip** where the top portion is the "tip" pointing to 12 o'clock, and the bottom portion is the tail.
* `ctx` and `cty` define the **rotation pivot point** measured in pixels from the **top-left corner** of the image:
  - `ctx`: pixel offset along X (horizontal distance from left edge to pivot).
  - `cty`: pixel offset along Y (vertical distance from top edge to pivot — usually the center or lower-center of the arm).
* `posx` / `posy` define where the **pivot point** is placed on the screen (not the top-left of the image).
* All three hands (`ARM_HOUR`, `ARM_MINUTE`, `ARM_SECOND`) share the same center coordinates (`posx=233, posy=233` on a 466×466 screen).

### F. Layer Render Order
Blocks are rendered in the order listed in `dial_desc.json`. Correct ordering is:
1. `BLK_BACKGROUND` — painted first (bottom layer).
2. Gauge/strip overlays and digit blocks (middle layers).
3. `BLK_ARM_HOUR`, `BLK_ARM_MINUTE` — above digits.
4. `BLK_ARM_SECOND` — above other hands.
5. `BLK_BIGYO` (center cap) — topmost layer.

### G. Animation Block (`BLK_ANIMPART`) Details
* The `ctx` field controls the **animation cycle behavior** (timing or trigger type):
  - `ctx = 10`: Time-based looping (common for decorative animations).
  - `ctx = 0`: May indicate a static or state-triggered animation.
* Recommended maximum for embedded animations: **~150×150 px**, **8–12 frames**.
* The block MUST be positioned within the 466×466 screen boundary.

---

## 5. Battery Strip Frame Layout (`BLK_BATTERY_STRIP`)

The battery strip uses **6 frames** representing battery level ranges:

| Frame | Level Range | Description |
| :--- | :--- | :--- |
| 0 | 0–5% | Critical / empty |
| 1 | 6–20% | Very low |
| 2 | 21–40% | Low |
| 3 | 41–60% | Medium |
| 4 | 61–80% | High |
| 5 | 81–100% | Full |

The visual can be any graphic: classic battery bars, segmented arcs, gauge needles, radial fills, etc. The firmware always selects the correct frame based on the current battery percentage at render time.

---

## 6. Weather Block Frame Layout (`BLK_WEATHER`)

The weather block uses **12 frames** mapping to standard weather condition codes:

| Frame | Condition |
| :--- | :--- |
| 0 | Sunny / Clear |
| 1 | Partly Cloudy |
| 2 | Cloudy |
| 3 | Overcast |
| 4 | Light Rain |
| 5 | Rain |
| 6 | Heavy Rain |
| 7 | Thunderstorm |
| 8 | Snow |
| 9 | Foggy / Mist |
| 10 | Hail / Sleet |
| 11 | Windy |

---

## 7. Observed Dial Inventory

Summary of all analyzed dials with their block types and special features:

| Dial ID | Style | Hands | Digits | Animation | Special Blocks |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **2945** | Colorful gradient | No | Yes | No | `BLK_UNKNOWN_A1` (5f 122×104), `BLK_PROGRESS1` |
| **2860** | Dark/minimal side-split | No | Yes | No | `BLK_UNKNOWN_A1` (6f 130×130), `BLK_WEATHER`, `BLK_BATTERY_STRIP` |
| **2930** | Classic analog | Yes | No | No | `BLK_ARM_HOUR/MIN/SEC`, `BLK_BIGYO` |
| **2989** | Analog + fitness info | Yes | Partial | No | `BLK_ARM_HOUR/MIN/SEC`, `BLK_BIGYO`, `BLK_PROGRESS2` |
| **3033** | Analog dark split | Yes | No | No | `BLK_UNKNOWN_A1` (6f 162×352), `BLK_ARM_HOUR/MIN/SEC`, `BLK_PROGRESS2`, `BLK_BATTERY_STRIP` |
| **3086** | Analog + weather | Yes | Yes | No | `BLK_ARM_HOUR/MIN/SEC`, `BLK_HOURS/MINUTES`, `BLK_WEATHER`, `BLK_AMPM` |
| **3111** | Analog gauges | Yes | Partial | No | `BLK_BATTERY_STRIP` (86×86), `BLK_UNKNOWN_A1` (6f 44×142), `BLK_PROGRESS2` |
| **3256** | Hybrid analog+anim | Yes | Partial | **Yes** | `BLK_ANIMPART` (7f 86×27), `BLK_ARM_HOUR/MIN/SEC`, `BLK_BIGYO`, `BLK_BATTERY_STRIP` |
| **3257** | Full-featured mixed | Yes | Yes | **Yes** | `BLK_ANIMPART` (11f 160×37), `BLK_ARM_HOUR/MIN/SEC`, `BLK_WEATHER`, all metrics |
| **3259** | Analog + anim | Yes | No | **Yes** | `BLK_ANIMPART` (9f 152×152), `BLK_ARM_HOUR/MIN/SEC`, `BLK_WEATHER`, `BLK_BIGYO` |
| **3271** | Digital + large anim | No | Yes | **Yes** | `BLK_ANIMPART` (6f **300×274**), `BLK_BIGYO` separator, no background block |
| **3274** | Analog + animated BG | Yes | Yes | **Yes** | `BLK_ANIMPART` (4f **466×466** full-screen), no `BLK_BACKGROUND`, all sensors |
| **7068** | Analog gauges | Yes | Yes | No | `BLK_BATTERY_STRIP` (66×66), `BLK_UNKNOWN_A1` (6f 120×120), `BLK_PROGRESS1/2`, multi `BLK_BIGYO` |
| **7235** | Analog + animated BG | Yes | Yes | **Yes** | `BLK_ANIMPART` (6f **466×466** full-screen), multi `BLK_BIGYO` (separators) |
| **10044** | Analog + animated BG | Yes | Yes | **Yes** | `BLK_ANIMPART` (4f **466×466** full-screen), no `BLK_BACKGROUND`, all sensors |
| **10048** | Hybrid full-featured | Yes | Yes | **Yes** | `BLK_ANIMPART` (7f 86×27), `BLK_ARM_HOUR/MIN/SEC`, `BLK_BIGYO`, all sensors |

---

## 8. Generator Tools Inside the Designer

To help developers quickly configure dials without manual graphic design, the Watchface Designer provides four helper modals in the sidebar:
1. **Font Generator**: Creates typographic number sheets (`0–9`) with custom fonts, colors, borders, and shadows.
2. **Weather Generator**: Creates standard weather icon strips (12 frames) mapped to weather condition codes.
3. **Battery Generator**: Creates battery gauge icons/strips of customizable levels and styles (6 frames). Supports: bar gauges, segmented arcs, circular fills, icons.
4. **Animation Slicer**: Allows uploading `.gif` or video files (`.mp4`, `.webm`, `.mov`), crops them to a square viewport, extracts a lightweight frame sequence, and compiles them into a vertical strip PNG with synchronized metadata.

---

## 9. Asset Presets Reference

The builder includes built-in preset assets users can import and customize:

### Battery Strip Presets
Pre-designed gauge styles for `BLK_BATTERY_STRIP` (6-frame vertical strips):
- **Classic Horizontal Bar** — Standard fill bar going left-to-right with border.
- **Vertical Bar** — Fill bar going bottom-to-top.
- **Segmented Segments** — 5 discrete segment blocks, progressively filled.
- **Radial Arc** — Circular arc gauge.
- **Battery Icon** — Standard battery icon shape with fill levels.
- **Circular Gauge** — Full circle fill gauge with percentage text overlay.

### Weather Icon Presets
Pre-designed icon sets for `BLK_WEATHER` (12-frame vertical strips):
- **Flat Color Icons** — Simple flat weather symbols in vibrant colors.
- **Outlined Monochrome** — Line-art weather icons in white/light color.
- **Emoji Style** — Rounded playful symbols.

### Weekday Presets
Pre-designed text strips for `BLK_WEEKD` (7-frame vertical strips, SUN–SAT):
- **Short Uppercase** — "SUN", "MON", "TUE" etc.
- **Single Letter** — "S", "M", "T" etc.
- **Full Name** — "SUNDAY", "MONDAY" etc.

---

## 10. Notes on `BLK_BGIMG` vs `BLK_BACKGROUND`

The compiler uses two different names for the background layer depending on context:
- `BLK_BACKGROUND` — Name used in the decompiled `dial_desc.json`.
- `BLK_BGIMG` — Legacy name used internally by the compiler code for the same block type.

Both names map to type code `0x02`. The builder internally treats them as interchangeable. If a project is missing this layer, the builder will **auto-create a default black 466×466 background** to prevent compile errors.

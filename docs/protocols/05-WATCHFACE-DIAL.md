# 05 — Watch Face Compilation and Transfer Protocol

**Scope:** End-to-end process for compiling a custom watch face from assets and transferring
the resulting binary to an HK89-family smartwatch over BLE.

**Source files referenced:**
- `decompiled_apk/sources/com/szabh/smable3/watchface/WatchFaceBuilder.java`
- `decompiled_apk/sources/com/szabh/smable3/watchface/Element.java`
- `decompiled_apk/sources/com/szabh/smable3/entity/BleStreamPacket.java`
- `README_DIAL_FORMAT.md` (repo root)
- `dial-sender/app/src/main/java/com/example/dialsender/MainActivity.java`
- `dial-sender/app/src/main/java/com/example/dialsender/DialCompiler.java`

---

## 1. Architecture Overview

```
  [ Asset Images ]
        |
        v
  [ Element[]  ]  — Java objects describing each UI component
        |
        v
  [ WatchFaceBuilder.build() ]  — JNI call into libsmawatchface.so
        |
        v
  [ HK89 Binary Blob ]  — pltable + block descriptors + RLE image data
        |
        v
  [ BLE Transfer State Machine ]
        |
        v
  [ Watch Device ]
```

---

## 2. Watch Face Element Model

### 2.1 Element Type Codes

Each `Element` object describes one visual layer of the watch face.
The type field determines how the watch firmware interprets and renders it.

| Code | Constant             | Description                          |
|------|----------------------|--------------------------------------|
|  1   | PREVIEW              | Preview thumbnail shown in companion app |
|  2   | BACKGROUND           | Static watch face background         |
|  3   | NEEDLE_HOUR          | Analog hour hand needle              |
|  4   | NEEDLE_MIN           | Analog minute hand needle            |
|  5   | NEEDLE_SEC           | Analog second hand needle            |
|  6   | DIGITAL_YEAR         | Digital year display                 |
|  7   | DIGITAL_MONTH        | Digital month display                |
|  8   | DIGITAL_DAY          | Digital day display                  |
|  9   | DIGITAL_WEEKDAY      | Digital weekday display              |
| 10   | DIGITAL_HOUR         | Digital hour display                 |
| 11   | DIGITAL_MIN          | Digital minute display               |
| 12   | DIGITAL_SEC          | Digital second display               |
| 13   | DIGITAL_AMPM         | AM/PM indicator                      |
| 14   | DIGITAL_STEP         | Step counter                         |
| 15   | DIGITAL_HEART        | Heart rate display                   |
| 16   | DIGITAL_CALORIE      | Calorie display                      |
| 17   | DIGITAL_DISTANCE     | Distance display                     |
| 18   | DIGITAL_BATTERY      | Battery level                        |
| 19   | DIGITAL_WEATHER      | Weather display                      |
| 20   | DIGITAL_SLEEP        | Sleep data display                   |
| 21   | DIGITAL_BLOOD_OXYGEN | SpO2 / blood oxygen display          |
| 22   | DIGITAL_ICON         | Static icon (non-interactive)        |
| 23   | BG_DYNAMIC           | Animated / dynamic background        |
| 44   | BG_IMAGE_ARRAY       | Array of background images           |

### 2.2 Element Properties

| Field        | Type       | Description                                                   |
|--------------|------------|---------------------------------------------------------------|
| `type`       | int        | Element type code (see table above)                           |
| `x`          | int        | X position on the watch display (pixels from left)            |
| `y`          | int        | Y position on the watch display (pixels from top)             |
| `width`      | int        | Element bounding width in pixels                              |
| `height`     | int        | Element bounding height in pixels                             |
| `gravity`    | int        | Alignment flags (bitfield: LEFT, CENTER, RIGHT, TOP, BOTTOM)  |
| `imageArray` | byte[][]   | Array of raw image buffers (e.g. digit glyphs 0-9 for clocks) |

### 2.3 Image Formats

| Code | Constant      | Description                         |
|------|---------------|-------------------------------------|
|  1   | PNG_ARGB_8888 | Full-color PNG with alpha channel   |
|  2   | BMP_565       | 16-bit RGB565 bitmap (no alpha)     |

`BMP_565` is the preferred on-device format due to the watch display's 16-bit color depth.
`PNG_ARGB_8888` images are typically down-converted to RGB565 by the native compiler.

---

## 3. Watch Face Compilation

### 3.1 WatchFaceBuilder API

```java
// Native method — implemented in libsmawatchface.so
byte[] build(Element[] elements, int flags);
```

The Java-side call passes the element array to the native library, which:
1. Converts each element's image data from the declared format to RGB565 (if needed).
2. Palette-compresses repeated colors where beneficial.
3. RLE-encodes each image block.
4. Assembles the HK89 binary format (header + block table + palette + image data).

The returned `byte[]` is the complete binary file ready for transmission.

### 3.2 DialCompiler (dial-sender)

`DialCompiler.java` in the `dial-sender` sample project demonstrates constructing the
`Element[]` array manually before calling `WatchFaceBuilder.build()`. The compiler maps
design-tool exports (PNG files) to element types and populates position/size metadata.

---

## 4. HK89 Binary Dial Format

### 4.1 File Layout

```
+------------------+
|   Header          |  4 bytes
+------------------+
|   Block Table     |  20 bytes x num_blocks
+------------------+
|   Palette Table   |  pltable_size bytes
+------------------+
|   Image Data      |  variable (RLE-compressed)
+------------------+
```

### 4.2 Header (4 bytes)

| Offset | Size | Type       | Field        | Description                        |
|--------|------|------------|--------------|------------------------------------|
| 0      | 2    | uint16_le  | pltable_size | Byte length of the palette table   |
| 2      | 1    | uint8      | num_blocks   | Number of image block descriptors  |
| 3      | 1    | uint8      | format_ver   | Format version identifier          |

### 4.3 Block Descriptor (20 bytes, repeated `num_blocks` times)

| Offset | Size | Type       | Field  | Description                                            |
|--------|------|------------|--------|--------------------------------------------------------|
| 0      | 2    | uint16_le  | x      | X position on watch display (pixels)                   |
| 2      | 2    | uint16_le  | y      | Y position on watch display (pixels)                   |
| 4      | 2    | uint16_le  | width  | Image width in pixels                                  |
| 6      | 2    | uint16_le  | height | Image height in pixels                                 |
| 8      | 4    | uint32_le  | offset | Byte offset into Image Data section (from section start) |
| 12     | 4    | uint32_le  | size   | Compressed size of this block's image data (bytes)     |
| 16     | 2    | uint16_le  | frames | Number of animation frames (1 for static images)       |
| 18     | 2    | uint16_le  | flags  | Block flags (encoding type, transparency, etc.)        |

### 4.4 Palette Table

- Size: `pltable_size` bytes (from header).
- Each entry: `uint32_le` — RGBA color value (4 bytes each).
- Total entries: `pltable_size / 4`.
- Used only for palette-indexed image blocks; absent if `pltable_size == 0`.

### 4.5 Image Data

- Follows immediately after the palette table.
- Each block's data starts at `block.offset` bytes from the beginning of the Image Data section.
- Pixel format: RGB565 big-endian OR palette-indexed RGBA (determined by block flags).
- Compression: run-length encoding (RLE) with escape sequences.

#### RLE Encoding Notes

- A run byte encodes the count; the following pixel value is repeated that many times.
- Escape sequences handle literal (non-repeating) pixel runs.
- Decoders must handle both RGB565 big-endian 2-byte pixels and 1-byte palette indices.

---

## 5. BLE Transfer Protocol

### 5.1 State Machine

```
        +--------+
        |  IDLE  |
        +--------+
             |
             | BLE connect
             v
       +------------+
       | HANDSHAKE  |  Discover GATT services; enable notifications on RX characteristic
       +------------+
             |
             | Services discovered
             v
         +------+
         |  BIND |  Send IDENTITY with BleKeyFlag.CREATE + random int32
         +------+
             |
             | Identity acknowledged
             v
         +-------+
         |  LOGIN |  Authenticate + time sync
         +-------+
             |
             | Auth OK
             v
      +---------------+
      | PRE_TRANSFER  |  Query device capabilities, current watch face slot
      +---------------+
             |
             | Capabilities received
             v
         +-------+
         |  SETUP |  Send watch face metadata: slot number + total binary size
         +-------+   BleKey.WATCH_FACE (0x0701) with BleKeyFlag.CREATE
             |
             | Metadata acknowledged
             v
       +-----------+
       | STREAMING |  Transfer binary in chunks; each chunk acknowledged before next
       +-----------+
             |
             | All bytes transferred
             v
         +------+
         |  DONE |  Transfer complete; watch applies new face
         +------+
```

### 5.2 GATT Structure

| Role           | Description                                          |
|----------------|------------------------------------------------------|
| TX Characteristic | App writes protocol packets to this characteristic |
| RX Characteristic | App subscribes (notifications); device sends ACKs  |

MTU negotiation: The app requests MTU = 512. The negotiated MTU determines the maximum
single BLE write payload:

```
usable_payload = negotiated_mtu - 3          (ATT overhead)
max_chunk_size = usable_payload - 9 - proto  (stream header + protocol framing)
```

Where `proto` is the overhead of the `0xAB` wrapper packet (see Section 5.4).

### 5.3 Stream Packet Format (BleStreamPacket)

Each binary chunk is wrapped in a `BleStreamPacket` before protocol framing:

| Byte(s) | Field    | Type     | Description                                    |
|---------|----------|----------|------------------------------------------------|
| 0       | mType    | uint8    | Slot or stream type identifier                 |
| 1-4     | mSize    | uint32   | Total file size (bytes)                        |
| 5-8     | mIndex   | uint32   | Current byte offset within the file            |
| 9+      | mPacket  | byte[]   | Chunk payload (up to BUFFER_MAX_SIZE = 480 B)  |

Total stream packet overhead: **9 bytes** (before payload).

### 5.4 Protocol Packet Framing (0xAB Wrapper)

The `createMessageWithHeader` method wraps every stream packet in a link-layer frame:

```
+------+---------+------+------+------+------+-----+-----+---------+-------------------+
| 0xAB | header  | lenH | lenL | crcH | crcL | cmd | key | keyFlag | stream_packet_data |
+------+---------+------+------+------+------+-----+-----+---------+-------------------+
```

| Field              | Size   | Description                                       |
|--------------------|--------|---------------------------------------------------|
| 0xAB               | 1 byte | Start-of-frame magic byte                         |
| header             | 1 byte | Frame header / sequence info                      |
| lenH, lenL         | 2 bytes| Big-endian length of payload after CRC field      |
| crcH, crcL         | 2 bytes| CRC16 of payload                                  |
| cmd                | 1 byte | Command byte                                      |
| key                | 1 byte | BLE key (e.g., 0x07 for watch face)               |
| keyFlag            | 1 byte | Key flag (e.g., CREATE, UPDATE)                   |
| stream_packet_data | variable | Serialized BleStreamPacket                      |

`BleKey.WATCH_FACE` = `0x0701`  
`BleKeyFlag.CREATE` is used for initiating a new watch face write.

### 5.5 Chunk Flow

```
App                                        Watch
 |                                            |
 |--- SETUP (slot, totalSize) -------------> |
 |<-- ACK ---------------------------------- |
 |                                            |
 |--- STREAM chunk 0 (offset=0) -----------> |
 |<-- ACK (offset confirmed) ---------------- |
 |                                            |
 |--- STREAM chunk 1 (offset=480) ---------> |
 |<-- ACK ---------------------------------- |
 |        ...                                 |
 |--- STREAM chunk N (offset=end) ---------> |
 |<-- ACK ---------------------------------- |
 |                                            |
 |   [watch applies watch face internally]    |
 |<-- DONE notification --------------------- |
```

Each acknowledgment must be received before the next chunk is sent.
The `mIndex` field in each stream packet allows the device to detect gaps or re-sends.

---

## 6. Key Constants

| Constant                  | Value  | Description                         |
|---------------------------|--------|-------------------------------------|
| `BleKey.WATCH_FACE`       | 0x0701 | BLE key for watch face operations   |
| `BleKeyFlag.CREATE`       | --     | Flag: create/write new resource     |
| `BUFFER_MAX_SIZE`         | 480    | Maximum payload per stream packet   |
| Start-of-frame magic      | 0xAB   | Protocol frame synchronization byte |
| Requested MTU             | 512    | App-requested ATT MTU               |

---

## 7. Implementation Notes

1. **Slot selection:** The PRE_TRANSFER phase queries which watch face slot is active.
   The SETUP phase specifies the target slot number along with the total binary size.

2. **Re-transfer / retry:** If the connection drops mid-transfer, the `mIndex` field allows
   resumption from the last acknowledged offset (device-dependent).

3. **Binary size limit:** Watch firmware imposes a maximum watch face binary size.
   This is queried during PRE_TRANSFER via device capability flags.

4. **Format version:** The `format_ver` byte in the HK89 header may gate firmware-side
   rendering features. Known value: `1` for standard RGB565 faces.

5. **Animation support:** Elements with `BG_DYNAMIC` (23) or multi-frame blocks
   (`frames > 1`) require the watch firmware to support animated watch faces.
   Frame data is packed sequentially in the Image Data section for the same block offset.

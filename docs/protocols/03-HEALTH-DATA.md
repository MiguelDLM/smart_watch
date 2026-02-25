# 03 - Health Data Entity Structures

**Scope:** Binary encoding of all health sensor data entities transmitted from
smartwatch to phone over BLE.

**Source package:** `com.szabh.smable3.entity`

---

## Table of Contents

1. [Overview](#1-overview)
2. [Common Conventions](#2-common-conventions)
3. [Data Retrieval Flow](#3-data-retrieval-flow)
4. [Entity Reference](#4-entity-reference)
   - [BleHeartRate](#41-bleheartrate)
   - [BleBloodOxygen](#42-blebloodoxygen)
   - [BleBloodPressure](#43-blebloodpressure)
   - [BleTemperature](#44-bletemperature)
   - [BleSleep](#45-blesleep)
   - [BleHrv](#46-blehrv)
   - [BleEcg](#47-bleecg)
   - [BleBloodGlucose](#48-blebloodglucose)
   - [BlePressure](#49-blepressure)
   - [BleActivity](#410-bleactivity)
   - [BleWorkout](#411-bleworkout)
5. [Enum Definitions](#5-enum-definitions)
   - [Sleep Mode](#51-sleep-mode)
   - [Sport Type](#52-sport-type)

---

## 1. Overview

Health data is retrieved from the watch as packed binary records. Each entity
type maps to a dedicated `BleKey` command code in the `0x05xx` range. A
response payload contains zero or more fixed-length records laid out
contiguously with no padding or separators between them.

Every entity has a constant `ITEM_LENGTH` value. The total payload length is
always a multiple of `ITEM_LENGTH`. The receiving side iterates over the
payload by advancing a `ByteBuffer` cursor by `ITEM_LENGTH` bytes per record.

---

## 2. Common Conventions

| Convention          | Detail                                                      |
|---------------------|-------------------------------------------------------------|
| Byte order          | Big-endian (network byte order) for all multi-byte fields   |
| Timestamp field     | `int32`, seconds since Unix epoch (1970-01-01T00:00:00Z)    |
| Payload layout      | N records × ITEM_LENGTH bytes, no framing between records   |
| Read method         | Sequential `ByteBuffer` reads (`getInt`, `get`, `getShort`) |
| Signed integers     | Java `byte` / `short` / `int` — sign-extended on read       |
| Unsigned bytes      | Mask with `0xFF` after reading as Java `byte`               |

---

## 3. Data Retrieval Flow

```
Phone                                  Watch
  |                                      |
  |-- BleKey(0x05xx, BleKeyFlag.READ) -->|
  |                                      |
  |<-- packed records (N × ITEM_LENGTH) -|
  |                                      |
  | [if more data available]             |
  |-- BleKey(0x05xx, READ_CONTINUE) --->|
  |<-- next batch of records ------------|
  |                                      |
  | [repeat until no more data]          |
```

1. Phone initiates with a `READ` flag for the target `BleKey`.
2. Watch responds with as many complete records as fit in one BLE packet.
3. If additional records remain, the phone immediately re-issues the same key
   with `BleKeyFlag.READ_CONTINUE`.
4. This loop continues until the watch signals completion (empty payload or
   end-of-data marker, protocol-specific).

---

## 4. Entity Reference

### 4.1 BleHeartRate

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleHeartRate.java`

| Attribute    | Value               |
|--------------|---------------------|
| BleKey       | `HEART_RATE 0x0503` |
| ITEM_LENGTH  | 6 bytes             |

#### Byte Layout

| Offset | Size | Type   | Field  | Description                                           |
|--------|------|--------|--------|-------------------------------------------------------|
| 0      | 4    | int32  | mTime  | Timestamp (seconds since Unix epoch)                  |
| 4      | 1    | uint8  | mBpm   | Heart rate in beats per minute                        |
| 5      | 1    | uint8  | mType  | Measurement type: `0` = manual, `1` = continuous auto |

#### Decode Pseudocode

```
mTime = buffer.getInt()          // signed 32-bit big-endian
mBpm  = buffer.get() & 0xFF      // unsigned byte
mType = buffer.get() & 0xFF      // unsigned byte
```

---

### 4.2 BleBloodOxygen

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleBloodOxygen.java`

| Attribute    | Value                  |
|--------------|------------------------|
| BleKey       | `BLOOD_OXYGEN 0x0509`  |
| ITEM_LENGTH  | 6 bytes                |

#### Byte Layout

| Offset | Size | Type  | Field   | Description                         |
|--------|------|-------|---------|-------------------------------------|
| 0      | 4    | int32 | mTime   | Timestamp (seconds since Unix epoch) |
| 4      | 1    | int8  | mValue  | SpO2 percentage (e.g., 98 = 98%)    |
| 5      | 1    | —     | —       | Padding byte (reserved, ignore)     |

#### Decode Pseudocode

```
mTime  = buffer.getInt()   // signed 32-bit big-endian
mValue = buffer.get()      // signed byte (int8)
buffer.get()               // discard padding
```

---

### 4.3 BleBloodPressure

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleBloodPressure.java`

| Attribute    | Value                    |
|--------------|--------------------------|
| BleKey       | `BLOOD_PRESSURE 0x0504`  |
| ITEM_LENGTH  | 6 bytes                  |

#### Byte Layout

| Offset | Size | Type  | Field      | Description                          |
|--------|------|-------|------------|--------------------------------------|
| 0      | 4    | int32 | mTime      | Timestamp (seconds since Unix epoch)  |
| 4      | 1    | uint8 | mSystolic  | Systolic blood pressure (mmHg)       |
| 5      | 1    | uint8 | mDiastolic | Diastolic blood pressure (mmHg)      |

#### Decode Pseudocode

```
mTime       = buffer.getInt()
mSystolic   = buffer.get() & 0xFF
mDiastolic  = buffer.get() & 0xFF
```

---

### 4.4 BleTemperature

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleTemperature.java`

| Attribute    | Value                   |
|--------------|-------------------------|
| BleKey       | `TEMPERATURE 0x0508`    |
| ITEM_LENGTH  | 6 bytes                 |

#### Byte Layout

| Offset | Size | Type  | Field        | Description                                              |
|--------|------|-------|--------------|----------------------------------------------------------|
| 0      | 4    | int32 | mTime        | Timestamp (seconds since Unix epoch)                     |
| 4      | 2    | int16 | mTemperature | Temperature value multiplied by 10 (e.g., 365 = 36.5 C) |

#### Decode Pseudocode

```
mTime        = buffer.getInt()
mTemperature = buffer.getShort()          // signed 16-bit big-endian
actualDegC   = mTemperature / 10.0
```

---

### 4.5 BleSleep

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleSleep.java`

| Attribute    | Value           |
|--------------|-----------------|
| BleKey       | `SLEEP 0x0505`  |
| ITEM_LENGTH  | 7 bytes         |

#### Byte Layout

| Offset | Size | Type  | Field   | Description                                           |
|--------|------|-------|---------|-------------------------------------------------------|
| 0      | 4    | int32 | mTime   | Timestamp (seconds since Unix epoch)                  |
| 4      | 1    | uint8 | mMode   | Sleep stage/mode code (see [Sleep Mode enum](#51-sleep-mode)) |
| 5      | 1    | uint8 | mSoft   | Light sleep duration in minutes for this interval     |
| 6      | 1    | uint8 | mStrong | Deep sleep duration in minutes for this interval      |

#### Decode Pseudocode

```
mTime   = buffer.getInt()
mMode   = buffer.get() & 0xFF
mSoft   = buffer.get() & 0xFF
mStrong = buffer.get() & 0xFF
```

#### Notes

- `START` (17) and `END` (34) records bracket a complete sleep session.
- `mSoft` and `mStrong` are only meaningful for `LIGHT` and `DEEP` records
  respectively; they may be zero for `AWAKE`, `REM`, `START`, and `END` records.

---

### 4.6 BleHrv

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleHrv.java`

| Attribute    | Value        |
|--------------|--------------|
| BleKey       | `HRV 0x050A` |
| ITEM_LENGTH  | 6 bytes      |

#### Byte Layout

| Offset | Size | Type | Field     | Description                          |
|--------|------|------|-----------|--------------------------------------|
| 0      | 4    | int32 | mTime    | Timestamp (seconds since Unix epoch) |
| 4      | 1    | int8  | mValue   | HRV value in milliseconds            |
| 5      | 1    | int8  | mAvgValue| Average HRV value in milliseconds    |

#### Decode Pseudocode

```
mTime     = buffer.getInt()
mValue    = buffer.get()     // signed byte
mAvgValue = buffer.get()     // signed byte
```

---

### 4.7 BleEcg

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleEcg.java`

| Attribute    | Value        |
|--------------|--------------|
| BleKey       | `ECG 0x050D` |
| ITEM_LENGTH  | 6 bytes      |

#### Byte Layout

| Offset | Size | Type  | Field  | Description                          |
|--------|------|-------|--------|--------------------------------------|
| 0      | 4    | int32 | mTime  | Timestamp (seconds since Unix epoch) |
| 4      | 1    | uint8 | mValue | ECG sample amplitude value           |
| 5      | 1    | —     | —      | Padding byte (reserved, ignore)      |

#### Decode Pseudocode

```
mTime  = buffer.getInt()
mValue = buffer.get() & 0xFF
buffer.get()                 // discard padding
```

---

### 4.8 BleBloodGlucose

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleBloodGlucose.java`

| Attribute    | Value                    |
|--------------|--------------------------|
| BleKey       | `BLOOD_GLUCOSE 0x050F`   |
| ITEM_LENGTH  | 6 bytes                  |

#### Byte Layout

| Offset | Size | Type  | Field  | Description                                                  |
|--------|------|-------|--------|--------------------------------------------------------------|
| 0      | 4    | int32 | mTime  | Timestamp (seconds since Unix epoch)                         |
| 4      | 2    | int16 | mValue | Blood glucose level (unit scaling is device-specific)        |

#### Decode Pseudocode

```
mTime  = buffer.getInt()
mValue = buffer.getShort()   // signed 16-bit big-endian
```

#### Notes

The unit and scaling factor for `mValue` (e.g., mg/dL vs mmol/L, raw vs
divided by 10) depends on the device firmware version. Verify with
device-specific calibration data.

---

### 4.9 BlePressure

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BlePressure.java`

| Attribute    | Value                |
|--------------|----------------------|
| BleKey       | `PRESSURE 0x050E`    |
| ITEM_LENGTH  | 6 bytes              |

Note: Despite the name "Pressure", this entity represents **stress level**, not
barometric pressure.

#### Byte Layout

| Offset | Size | Type  | Field  | Description                           |
|--------|------|-------|--------|---------------------------------------|
| 0      | 4    | int32 | mTime  | Timestamp (seconds since Unix epoch)  |
| 4      | 1    | uint8 | mValue | Stress level, range 0-100             |
| 5      | 1    | —     | —      | Padding byte (reserved, ignore)       |

#### Decode Pseudocode

```
mTime  = buffer.getInt()
mValue = buffer.get() & 0xFF
buffer.get()                 // discard padding
```

---

### 4.10 BleActivity

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleActivity.java`

| Attribute    | Value               |
|--------------|---------------------|
| BleKey       | `ACTIVITY 0x0502`   |
| ITEM_LENGTH  | 16 bytes            |

#### Byte Layout

| Offset | Size     | Type   | Field     | Description                                           |
|--------|----------|--------|-----------|-------------------------------------------------------|
| 0      | 4        | int32  | mTime     | Timestamp (seconds since Unix epoch)                  |
| 4      | 1        | uint8  | (packed)  | Packed byte: mMode in bits [4:0], mState in bits [7:5] |
| 5      | 3        | int24  | mStep     | Step count (3-byte big-endian unsigned integer)       |
| 8      | 4        | int32  | mCalorie  | Calories burned (cal)                                 |
| 12     | 4        | int32  | mDistance | Distance (device-specific units, typically cm)        |

#### Packed Byte Extraction (offset 4)

The single byte at offset 4 carries two sub-fields:

```
raw   = buffer.get() & 0xFF
mMode  = raw & 0x1F          // bits [4:0] — 5-bit sport type
mState = (raw >> 5) & 0x07   // bits [7:5] — 3-bit activity state
```

| Bits  | Mask   | Field  | Description                              |
|-------|--------|--------|------------------------------------------|
| [4:0] | 0x1F   | mMode  | Sport type (see [Sport Type enum](#52-sport-type)) |
| [7:5] | 0xE0   | mState | Activity state (device-specific meaning) |

#### int24 Decode (mStep, offset 5)

Three consecutive bytes form a 24-bit big-endian unsigned integer:

```
b0    = buffer.get() & 0xFF
b1    = buffer.get() & 0xFF
b2    = buffer.get() & 0xFF
mStep = (b0 << 16) | (b1 << 8) | b2
```

#### Decode Pseudocode (full record)

```
mTime     = buffer.getInt()
packed    = buffer.get() & 0xFF
mMode     = packed & 0x1F
mState    = (packed >> 5) & 0x07
b0        = buffer.get() & 0xFF
b1        = buffer.get() & 0xFF
b2        = buffer.get() & 0xFF
mStep     = (b0 << 16) | (b1 << 8) | b2
mCalorie  = buffer.getInt()
mDistance = buffer.getInt()
```

---

### 4.11 BleWorkout

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleWorkout.java`

| Attribute    | Value               |
|--------------|---------------------|
| BleKey       | `WORKOUT 0x0506`    |
| ITEM_LENGTH  | 48 bytes            |

#### Byte Layout

| Offset | Size | Type   | Field       | Description                                                    |
|--------|------|--------|-------------|----------------------------------------------------------------|
| 0      | 4    | int32  | mStart      | Workout start timestamp (seconds since Unix epoch)             |
| 4      | 4    | int32  | mEnd        | Workout end timestamp (seconds since Unix epoch)               |
| 8      | 2    | uint16 | mDuration   | Duration of workout in seconds                                 |
| 10     | 2    | int16  | mAltitude   | Altitude in meters (signed; negative = below sea level)        |
| 12     | 2    | uint16 | mAirPressure| Atmospheric pressure in hPa                                    |
| 14     | 1    | uint8  | mSpm        | Steps per minute (cadence)                                     |
| 15     | 1    | uint8  | mMode       | Sport type (see [Sport Type enum](#52-sport-type))             |
| 16     | 4    | int32  | mStep       | Total step count                                               |
| 20     | 4    | int32  | mDistance   | Total distance (device-specific units, typically cm)           |
| 24     | 4    | int32  | mCalorie    | Total calories burned (cal)                                    |
| 28     | 4    | int32  | mSpeed      | Speed (device-specific; likely cm/s or m/s multiplied by 100)  |
| 32     | 4    | int32  | mPace       | Pace in seconds per km                                         |
| 36     | 1    | uint8  | mAvgBpm     | Average heart rate during workout (BPM)                        |
| 37     | 1    | uint8  | mMaxBpm     | Maximum heart rate during workout (BPM)                        |
| 38     | 10   | —      | —           | Reserved / padding to reach 48-byte total (ignore on read)     |

#### Decode Pseudocode

```
mStart       = buffer.getInt()
mEnd         = buffer.getInt()
mDuration    = buffer.getShort() & 0xFFFF   // unsigned 16-bit
mAltitude    = buffer.getShort()             // signed 16-bit
mAirPressure = buffer.getShort() & 0xFFFF   // unsigned 16-bit
mSpm         = buffer.get() & 0xFF
mMode        = buffer.get() & 0xFF
mStep        = buffer.getInt()
mDistance    = buffer.getInt()
mCalorie     = buffer.getInt()
mSpeed       = buffer.getInt()
mPace        = buffer.getInt()
mAvgBpm      = buffer.get() & 0xFF
mMaxBpm      = buffer.get() & 0xFF
buffer.position(buffer.position() + 10)     // skip reserved bytes
```

---

## 5. Enum Definitions

### 5.1 Sleep Mode

Used by `BleSleep.mMode`.

| Name      | Value | Description                              |
|-----------|-------|------------------------------------------|
| DEEP      | 1     | Deep (slow-wave) sleep stage             |
| LIGHT     | 2     | Light sleep stage                        |
| AWAKE     | 3     | Awake or restless period during sleep    |
| PIECEMEAL | 8     | Fragmented / nap sleep                   |
| REM       | 9     | REM (rapid eye movement) sleep stage     |
| START     | 17    | Marker: beginning of a sleep session     |
| END       | 34    | Marker: end of a sleep session           |

A complete night's sleep is bracketed by `START` (17) and `END` (34) records.
All stage records between them belong to that session. Multiple sessions may
appear in a single payload if the wearer napped.

---

### 5.2 Sport Type

Used by `BleActivity.mMode` and `BleWorkout.mMode`.

| Name          | Value | Name            | Value |
|---------------|-------|-----------------|-------|
| NONE          | 0     | AEROBICS        | 35    |
| RUNNING       | 7     | STRENGTH        | 36    |
| CYCLING       | 10    | CRICKET         | 37    |
| SWIMMING      | 11    | JUMP_ROPE       | 15    |
| WALKING       | 12    | BASKETBALL      | 16    |
| CLIMBING      | 13    | FOOTBALL        | 17    |
| YOGA          | 14    | BADMINTON       | 18    |
| TABLE_TENNIS  | 19    | TENNIS          | 20    |
| ROWING        | 21    | ELLIPTICAL      | 22    |
| TREADMILL     | 23    | SIT_UP          | 24    |
| PUSH_UP       | 25    | DUMBBELL        | 26    |
| WEIGHT_LIFT   | 27    | BOXING          | 28    |
| SQUASH        | 29    | DANCE           | 30    |
| SKIING        | 31    | ICE_SKATING     | 32    |
| GOLF          | 33    | HIKING          | 34    |

The full enumeration contains 160+ sport type codes. The table above covers the
most common values. Unknown or unlisted values should be treated as
`NONE` / generic workout when displaying to the user.

---

*End of document.*

# 02 — Command Protocol

**Source files:**
- `decompiled_apk/sources/com/szabh/smable3/BleKey.java`
- `decompiled_apk/sources/com/szabh/smable3/BleCommand.java`
- `decompiled_apk/sources/com/szabh/smable3/BleKeyFlag.java`

---

## Table of Contents

1. [Overview](#1-overview)
2. [BleCommand — Command Categories](#2-blecommand--command-categories)
3. [BleKeyFlag — Operation Types](#3-blekeyflag--operation-types)
4. [BleKey — Encoding](#4-blekey--encoding)
5. [Packet Construction](#5-packet-construction)
6. [Complete Command Reference](#6-complete-command-reference)
   - [6.1 UPDATE (0x01) — OTA / Firmware](#61-update-0x01--ota--firmware)
   - [6.2 SET (0x02) — Device Settings](#62-set-0x02--device-settings)
   - [6.3 PUSH (0x04) — Phone to Watch Data](#63-push-0x04--phone-to-watch-data)
   - [6.4 DATA (0x05) — Health Data Retrieval](#64-data-0x05--health-data-retrieval)
   - [6.5 CONTROL (0x06) — Device Control](#65-control-0x06--device-control)
   - [6.6 IO (0x07) — File I/O](#66-io-0x07--file-io)
7. [Request / Response Patterns](#7-request--response-patterns)
8. [Connection Handshake Commands](#8-connection-handshake-commands)
9. [Quick-Lookup Index](#9-quick-lookup-index)

---

## 1. Overview

Every BLE message sent between the phone and the smartwatch encodes a **command** using three cooperating enumerations:

| Enum | Java Source | Purpose |
|------|-------------|---------|
| `BleCommand` | `BleCommand.java` | High-level category (SET, DATA, IO, …) |
| `BleKey` | `BleKey.java` | Specific operation within a category |
| `BleKeyFlag` | `BleKeyFlag.java` | Operation mode (read, write, create, delete, …) |

These three values are packed into three consecutive bytes of the packet frame:

```
Packet offset 6:  CMD   = BleCommand value  = mKey >>> 8
Packet offset 7:  KEY   = key index         = mKey & 0xFF
Packet offset 8:  FLAG  = BleKeyFlag value
```

`mKey` is a 16-bit integer defined on each `BleKey` enum constant. Its high byte carries the command category and its low byte carries the per-category index.

---

## 2. BleCommand — Command Categories

**Source:** `BleCommand.java`

```
Value   Hex    Name       Description
-----   ---    ----       -----------
  1     0x01   UPDATE     OTA firmware update commands
  2     0x02   SET        Read or write device settings
  3     0x03   CONNECT    Connection management (not widely used in key map)
  4     0x04   PUSH       Phone pushes live data to watch (notifications, weather, music)
  5     0x05   DATA       Retrieve stored health sensor data from watch
  6     0x06   CONTROL    Device control (camera shutter, call handling)
  7     0x07   IO         File transfer (watch faces, AGPS, fonts, contacts)
255     0xFF   NONE       Sentinel / no command
```

### Encoding in Packet

```
BleCommand occupies packet byte [6] (offset 6).

Examples:
  0x01 → UPDATE command group
  0x02 → SET command group
  0x05 → DATA command group
  0x07 → IO command group
```

---

## 3. BleKeyFlag — Operation Types

**Source:** `BleKeyFlag.java`

The flag byte controls how the receiving side interprets the command. It distinguishes between reading a value, writing it, paginating through records, or managing lifecycle (create/delete/reset).

```
Value   Hex    Name            Description
-----   ---    ----            -----------
  0     0x00   UPDATE          Write / update a value on the device
 16     0x10   READ            Request the current value of a field
 17     0x11   READ_CONTINUE   Continue a paginated read operation
 32     0x20   CREATE          Create or bind a new resource (e.g., IDENTITY binding)
 48     0x30   DELETE          Delete a resource (e.g., alarm, contact)
 64     0x40   RESET           Reset a setting to factory defaults
255     0xFF   NONE            No operation / sentinel
```

### Flag Usage Patterns

```
Read a setting:
  Phone sends:   FLAG = READ    (0x10), DATA = empty
  Watch replies: FLAG = READ    (0x10), DATA = current value   (HEADER bit4 set = REPLY)

Write a setting:
  Phone sends:   FLAG = UPDATE  (0x00), DATA = new value
  Watch replies: FLAG = UPDATE  (0x00), DATA = empty or echo   (HEADER bit4 set = REPLY)

Paginated data read:
  Phone sends:   FLAG = READ         (0x10), DATA = query params (e.g., date range)
  Watch replies: FLAG = READ         (0x10), DATA = first page
  Phone sends:   FLAG = READ_CONTINUE(0x11), DATA = continuation token
  Watch replies: FLAG = READ         (0x10), DATA = next page
  ... repeat until watch returns empty DATA or signals end

Create/bind:
  Phone sends:   FLAG = CREATE (0x20), DATA = resource data
  Watch replies: FLAG = CREATE (0x20), DATA = acknowledgement

Delete:
  Phone sends:   FLAG = DELETE (0x30), DATA = resource ID
  Watch replies: FLAG = DELETE (0x30), DATA = acknowledgement
```

---

## 4. BleKey — Encoding

**Source:** `BleKey.java`

Each `BleKey` enum constant stores a single 16-bit integer `mKey`. The two halves map directly to packet bytes:

```
mKey layout:
  Bits 15–8 (high byte):  BleCommand value
  Bits  7–0 (low byte):   per-command index

getMCommandRawValue() = mKey >>> 8    → packet byte [6]
getMKeyRawValue()     = mKey & 0xFF   → packet byte [7]
```

### Encoding Diagram

```
      mKey (uint16)
  +-------+-------+
  | CMD   | INDEX |
  | [15:8]| [7:0] |
  +-------+-------+
      |       |
      |       +---------> Packet byte [7]  (KEY)
      +-----------------> Packet byte [6]  (CMD)

Example: TIME = 0x0201
  High byte: 0x02 → BleCommand.SET
  Low  byte: 0x01 → index 1 within SET group
```

### Namespace Allocation

```
0x01xx  →  UPDATE group    (0x0101 – 0x01FF)
0x02xx  →  SET group       (0x0201 – 0x02FF)
0x03xx  →  CONNECT group   (0x0301 – 0x03FF)
0x04xx  →  PUSH group      (0x0401 – 0x04FF)
0x05xx  →  DATA group      (0x0501 – 0x05FF)
0x06xx  →  CONTROL group   (0x0601 – 0x06FF)
0x07xx  →  IO group        (0x0701 – 0x07FF)
0xFFFF  →  NONE
```

---

## 5. Packet Construction

### 5.1 Frame Reminder

```
 Byte:  [0]    [1]    [2][3]   [4][5]   [6]   [7]   [8]    [9+]
        MAGIC  HDR    LENGTH   CRC16    CMD   KEY   FLAG   DATA...
        0xAB   0x01   BE u16   BE u16
```

Full frame specification is in `01-BLE-COMMUNICATION.md`.

### 5.2 Construction Procedure

```
procedure buildPacket(bleKey, bleKeyFlag, data):
  cmd    = bleKey.mKey >>> 8
  key    = bleKey.mKey & 0xFF
  flag   = bleKeyFlag.value
  length = len(data) + 3          // +3 for cmd+key+flag bytes
  crc_input = [cmd, key, flag] + data
  crc16  = compute_crc16(crc_input)

  packet = [
    0xAB,                         // MAGIC
    0x01,                         // HEADER (VERSION bit set, no REPLY/NACK)
    (length >> 8) & 0xFF,         // LENGTH high byte
    length & 0xFF,                // LENGTH low byte
    (crc16 >> 8) & 0xFF,          // CRC16 high byte
    crc16 & 0xFF,                 // CRC16 low byte
    cmd,                          // CMD
    key,                          // KEY
    flag,                         // FLAG
  ] + data
  return packet
```

### 5.3 Worked Example — SET TIME

```
Goal: Set device time to Unix timestamp 1740398400 (0x67BB6E80)

BleKey   = TIME      → mKey = 0x0201
BleCommand           → cmd  = 0x0201 >>> 8 = 0x02
Key index            → key  = 0x0201 & 0xFF = 0x01
BleKeyFlag = UPDATE  → flag = 0x00
Data (4 bytes, BE):    67 BB 6E 80

CRC input: [02 01 00 67 BB 6E 80]
LENGTH:    4 + 3 = 7 = 0x0007
CRC16:     (compute per algorithm in 01-BLE-COMMUNICATION.md)

Final packet:
  AB 01 00 07 <CRC_H> <CRC_L> 02 01 00 67 BB 6E 80
```

### 5.4 Worked Example — READ FIRMWARE VERSION

```
Goal: Query firmware version string from device

BleKey   = FIRMWARE_VERSION → mKey = 0x0204
cmd = 0x02,  key = 0x04
BleKeyFlag = READ            → flag = 0x10
Data: empty (0 bytes)

LENGTH: 0 + 3 = 3 = 0x0003
CRC input: [02 04 10]

Final packet:
  AB 01 00 03 <CRC_H> <CRC_L> 02 04 10
```

### 5.5 Worked Example — READ HEART RATE DATA

```
Goal: Retrieve stored heart rate records (typically with date range payload)

BleKey   = HEART_RATE → mKey = 0x0503
cmd = 0x05,  key = 0x03
BleKeyFlag = READ      → flag = 0x10
Data: date range bytes (format defined in 03-HEALTH-DATA.md)

Final packet header:
  AB 01 00 <LEN_H> <LEN_L> <CRC_H> <CRC_L> 05 03 10 [date range...]
```

---

## 6. Complete Command Reference

### 6.1 UPDATE (0x01) — OTA / Firmware

**BleCommand value: `0x01`**

Used to initiate and transfer over-the-air firmware updates. See `06-OTA-FIRMWARE.md` for the full OTA procedure.

| Key Name | mKey (hex) | mKey (dec) | CMD byte | KEY byte | Description |
|----------|-----------|-----------|----------|----------|-------------|
| OTA | `0x0101` | 257 | `0x01` | `0x01` | Initiate standard OTA firmware update |
| XMODEM | `0x0102` | 258 | `0x01` | `0x02` | Initiate XMODEM-based firmware transfer |

### 6.2 SET (0x02) — Device Settings

**BleCommand value: `0x02`**

The largest command group. Used to read (`FLAG=READ`) or write (`FLAG=UPDATE`) device configuration. Most commands are bidirectional.

| Key Name | mKey (hex) | mKey (dec) | KEY byte | Description |
|----------|-----------|-----------|----------|-------------|
| TIME | `0x0201` | 513 | `0x01` | Unix timestamp sync |
| TIME_ZONE | `0x0202` | 514 | `0x02` | UTC offset in minutes |
| POWER | `0x0203` | 515 | `0x03` | Battery / power state |
| FIRMWARE_VERSION | `0x0204` | 516 | `0x04` | Firmware version string |
| BLE_ADDRESS | `0x0205` | 517 | `0x05` | Device BLE MAC address |
| USER_PROFILE | `0x0206` | 518 | `0x06` | User biometrics (age, height, weight, sex) |
| STEP_GOAL | `0x0207` | 519 | `0x07` | Daily step count goal |
| BACK_LIGHT | `0x0208` | 520 | `0x08` | Display backlight brightness / timeout |
| SEDENTARINESS | `0x0209` | 521 | `0x09` | Sedentary reminder settings |
| NO_DISTURB_RANGE | `0x020A` | 522 | `0x0A` | Do-not-disturb time range |
| VIBRATION | `0x020B` | 523 | `0x0B` | Vibration strength / pattern |
| GESTURE_WAKE | `0x020C` | 524 | `0x0C` | Wrist-raise wake gesture enable |
| HR_ASSIST_SLEEP | `0x020D` | 525 | `0x0D` | Use HR sensor to assist sleep detection |
| HOUR_SYSTEM | `0x020E` | 526 | `0x0E` | 12-hour vs 24-hour clock |
| LANGUAGE | `0x020F` | 527 | `0x0F` | Display language / locale |
| ALARM | `0x0210` | 528 | `0x10` | Alarm clock configuration |
| COACHING | `0x0211` | 529 | `0x11` | Exercise / coaching mode settings |
| FIND_PHONE | `0x0212` | 530 | `0x12` | Find-phone trigger |
| WORLD_CLOCK | `0x0213` | 531 | `0x13` | World clock city list |
| NO_DISTURB_GLOBAL | `0x0214` | 532 | `0x14` | Global do-not-disturb toggle |
| IDENTITY | `0x0215` | 533 | `0x15` | Device binding / identity (use FLAG=CREATE on first connect) |
| UNIT | `0x0216` | 534 | `0x16` | Measurement unit system (metric / imperial) |
| SLEEP_QUALITY | `0x0217` | 535 | `0x17` | Sleep quality feedback |
| NETWORK_FIRMWARE_VERSION | `0x0218` | 536 | `0x18` | Network/cloud firmware version |
| DRINKWATER | `0x0219` | 537 | `0x19` | Drink-water reminder settings |
| SHUTDOWN | `0x021A` | 538 | `0x1A` | Power off device |
| APP_SPORT_DATA | `0x021B` | 539 | `0x1B` | App-controlled sport session data |
| REAL_TIME_HEART_RATE | `0x021C` | 540 | `0x1C` | Start/stop real-time HR streaming |
| BLOOD_OXYGEN_SET | `0x021D` | 541 | `0x1D` | SpO2 monitoring settings |
| WASH_SET | `0x021E` | 542 | `0x1E` | Hand-wash reminder settings |
| TEMPERATURE_UNIT | `0x021F` | 543 | `0x1F` | Celsius vs Fahrenheit |
| DATE_FORMAT | `0x0220` | 544 | `0x20` | Date display format (DD/MM/YYYY, etc.) |
| WATCHFACE_SWITCH | `0x0221` | 545 | `0x21` | Switch active watch face |
| AGPS_PREREQUISITE | `0x0222` | 546 | `0x22` | AGPS prerequisites / handshake |
| DEVICE_INFO2 | `0x0223` | 547 | `0x23` | Extended device info block |
| DOUBLE_SCREEN | `0x0224` | 548 | `0x24` | Dual-screen configuration |
| GIRL_CARE | `0x0225` | 549 | `0x25` | Menstrual cycle tracking settings |
| RAW_SLEEP | `0x0226` | 550 | `0x26` | Raw sleep data mode |
| HR_WARNING | `0x0227` | 551 | `0x27` | Heart rate alert thresholds |
| MEDICATION_REMINDER | `0x0228` | 552 | `0x28` | Medication reminder configuration |
| CALORIES_GOAL | `0x0229` | 553 | `0x29` | Daily calorie burn goal |
| DISTANCE_GOAL | `0x022A` | 554 | `0x2A` | Daily distance goal |
| SLEEP_GOAL | `0x022B` | 555 | `0x2B` | Sleep duration goal |
| SPORT_DURATION_GOAL | `0x022C` | 556 | `0x2C` | Daily exercise duration goal |
| POWER_SAVE_MODE | `0x022D` | 557 | `0x2D` | Battery power-save mode |
| AEROBIC_EXERCISE_GOAL | `0x022E` | 558 | `0x2E` | Aerobic exercise minutes goal |
| NIGHT_MODE | `0x022F` | 559 | `0x2F` | Night mode / reduced brightness |
| GAME_SET | `0x0230` | 560 | `0x30` | Watch game settings |
| LOVE_TAP_USER | `0x0231` | 561 | `0x31` | Love-tap feature user config |
| ANTI_LOST | `0x0232` | 562 | `0x32` | Anti-lost alert settings |
| SOS | `0x0233` | 563 | `0x33` | SOS emergency alert configuration |
| CLASSIC_BLUETOOTH_STATE | `0x0234` | 564 | `0x34` | Classic Bluetooth (A2DP/HFP) state |
| SOS_CONTACTS | `0x0235` | 565 | `0x35` | SOS emergency contact list |
| BLOOD_PRESSURE_CALIBRATION | `0x0236` | 566 | `0x36` | Blood pressure calibration values |
| BLOOD_GLUCOSE_CALIBRATION | `0x0237` | 567 | `0x37` | Blood glucose calibration values |
| BREATH_TRAINING_QUIT | `0x0238` | 568 | `0x38` | Quit active breathing training session |
| NAVIGATION_INFO | `0x0239` | 569 | `0x39` | Navigation turn-by-turn info |
| WALK_REMINDER | `0x023A` | 570 | `0x3A` | Walk reminder interval settings |
| WEATHER_FORECAST | `0x023B` | 571 | `0x3B` | Weather forecast data (SET variant) |
| NEWS_FEED | `0x023C` | 572 | `0x3C` | News feed / headlines push |
| MATCH_RECORD | `0x023D` | 573 | `0x3D` | Sports match score record |
| SCHEDULE | `0x023E` | 574 | `0x3E` | Calendar schedule / event |
| DEVICE_SPORT_INFO | `0x023F` | 575 | `0x3F` | Device-side sport session info |
| WATCH_FACE_WIDGET | `0x0240` | 576 | `0x40` | Watch face widget layout configuration |
| STAND_SET | `0x0241` | 577 | `0x41` | Stand reminder settings |
| QRCODE | `0x0242` | 578 | `0x42` | QR code display on watch |
| LOV_TAP_WAY | `0x0243` | 579 | `0x43` | Love-tap interaction mode |
| LOV_TAP_SINGLE | `0x0244` | 580 | `0x44` | Single love-tap trigger |
| EARPHONE_SETTING | `0x0245` | 581 | `0x45` | Earphone general settings |
| EARPHONE_KEY_SETTING | `0x0246` | 582 | `0x46` | Earphone button mapping |
| EARPHONE_ANC_SETTING | `0x0247` | 583 | `0x47` | Active noise cancellation settings |
| EARPHONE_EQ_SETTING | `0x0248` | 584 | `0x48` | Earphone equaliser profile |
| EARPHONE_TRANSPARENCY_SETTING | `0x0249` | 585 | `0x49` | Earphone transparency mode |
| EARPHONE_HEARING_ASSIST | `0x024A` | 586 | `0x4A` | Hearing assistance settings |
| EARPHONE_LOW_LATENCY | `0x024B` | 587 | `0x4B` | Earphone low-latency gaming mode |
| EARPHONE_DOUBLE_CONNECT | `0x024C` | 588 | `0x4C` | Earphone dual-device connection |
| DAILY_RECORDS | `0x024D` | 589 | `0x4D` | Daily activity record summary |
| WATCH_FACE_OF_WATCH | `0x024E` | 590 | `0x4E` | Query currently active watch face ID |
| EDR_PAIRING | `0x024F` | 591 | `0x4F` | Enhanced Data Rate Bluetooth pairing |
| PREFERENCE_SET | `0x0250` | 592 | `0x50` | Miscellaneous user preferences |
| DEVICE_INFO3 | `0x0251` | 593 | `0x51` | Third extended device info block |
| REMINDER_EVENT | `0x0252` | 594 | `0x52` | Generic reminder event |
| EYE_PROTECTION_REMINDER | `0x0253` | 595 | `0x53` | Screen eye-protection reminder |

### 6.3 PUSH (0x04) — Phone to Watch Data

**BleCommand value: `0x04`**

One-way push from phone to watch. No persistent storage on device; data is displayed immediately.

| Key Name | mKey (hex) | mKey (dec) | KEY byte | Description |
|----------|-----------|-----------|----------|-------------|
| NOTIFICATION | `0x0401` | 1025 | `0x01` | Incoming notification (SMS, call, app alert) |
| MUSIC_CONTROL | `0x0402` | 1026 | `0x02` | Now-playing info and playback state |
| WEATHER_REALTIME | `0x0404` | 1028 | `0x04` | Current weather conditions |
| WEATHER_FORECAST_PUSH | `0x0405` | 1029 | `0x05` | Multi-day weather forecast |
| NOTIFICATION2 | `0x0407` | 1031 | `0x07` | Extended notification format (v2) |

**Notes:**
- `NOTIFICATION` and `NOTIFICATION2` differ in payload structure. See `04-NOTIFICATIONS.md` for format details.
- `MUSIC_CONTROL` carries track title, artist, album, and playback state flags.
- Weather commands require location and provider data; see `04-NOTIFICATIONS.md` / `05-WATCHFACE-DIAL.md`.

### 6.4 DATA (0x05) — Health Data Retrieval

**BleCommand value: `0x05`**

Used to pull stored sensor readings from the device. The typical flow is:
1. Phone sends `FLAG=READ` with a date-range query in DATA.
2. Watch replies with the first page of records.
3. Phone sends `FLAG=READ_CONTINUE` to request subsequent pages.
4. Repeat until watch returns an empty payload (end of records).

| Key Name | mKey (hex) | mKey (dec) | KEY byte | Sensor / Data Type |
|----------|-----------|-----------|----------|--------------------|
| STEP | `0x0501` | 1281 | `0x01` | Pedometer step count records |
| ACTIVITY | `0x0502` | 1282 | `0x02` | Activity / movement intensity records |
| HEART_RATE | `0x0503` | 1283 | `0x03` | Heart rate measurements |
| BLOOD_PRESSURE | `0x0504` | 1284 | `0x04` | Systolic and diastolic BP readings |
| SLEEP | `0x0505` | 1285 | `0x05` | Sleep stage records (light, deep, REM) |
| WORKOUT | `0x0506` | 1286 | `0x06` | Workout session records (v1) |
| LOCATION | `0x0507` | 1287 | `0x07` | GPS location track points |
| TEMPERATURE | `0x0508` | 1288 | `0x08` | Body / ambient temperature readings |
| BLOOD_OXYGEN | `0x0509` | 1289 | `0x09` | SpO2 (blood oxygen saturation) readings |
| HRV | `0x050A` | 1290 | `0x0A` | Heart rate variability measurements |
| LOG | `0x050B` | 1291 | `0x0B` | Device diagnostic log |
| SLEEP2 | `0x050C` | 1292 | `0x0C` | Extended sleep records (v2) |
| ECG | `0x050D` | 1293 | `0x0D` | Electrocardiogram waveform data |
| PRESSURE | `0x050E` | 1294 | `0x0E` | Mental stress / pressure index |
| BLOOD_GLUCOSE | `0x050F` | 1295 | `0x0F` | Blood glucose readings |
| BODY_STATUS | `0x0510` | 1296 | `0x10` | Body composition / status index |
| MIND_STATUS | `0x0511` | 1297 | `0x11` | Mental wellness / mood status |
| WORKOUT2 | `0x0512` | 1298 | `0x12` | Extended workout session records (v2) |

### 6.5 CONTROL (0x06) — Device Control

**BleCommand value: `0x06`**

Real-time control commands. These trigger immediate actions on the device.

| Key Name | mKey (hex) | mKey (dec) | KEY byte | Description |
|----------|-----------|-----------|----------|-------------|
| CAMERA | `0x0601` | 1537 | `0x01` | Remote camera shutter trigger |
| PHONE_GPSSPORT | `0x0602` | 1538 | `0x02` | Phone GPS-assisted sport session control |
| INCOMING_CALL | `0x0603` | 1539 | `0x03` | Incoming call accept / reject from watch |

### 6.6 IO (0x07) — File I/O

**BleCommand value: `0x07`**

Binary file transfer to and from the device. The transfer protocol uses chunked writes with `FLAG=UPDATE` for data segments and `FLAG=CREATE` / `FLAG=DELETE` for lifecycle management.

| Key Name | mKey (hex) | mKey (dec) | KEY byte | File Type |
|----------|-----------|-----------|----------|-----------|
| WATCH_FACE | `0x0701` | 1793 | `0x01` | Compiled watch face binary (.bin) |
| AGPS_FILE | `0x0702` | 1794 | `0x02` | Assisted GPS ephemeris data |
| FONT_FILE | `0x0703` | 1795 | `0x03` | Custom font file |
| CONTACT | `0x0704` | 1796 | `0x04` | Contact entry (name, phone number) |
| UI_FILE | `0x0705` | 1797 | `0x05` | UI resource file |
| LANGUAGE_FILE | `0x0706` | 1798 | `0x06` | Language / localisation string table |
| BRAND_INFO_FILE | `0x0707` | 1799 | `0x07` | OEM brand information file |
| MEDIA_FILE | `0x0708` | 1800 | `0x08` | Media file (image, audio clip) |

---

## 7. Request / Response Patterns

### 7.1 Simple Read / Write

```
Host  →  Watch:  [MAGIC][HDR=0x01][LEN][CRC][CMD][KEY][FLAG=0x10][query...]
Watch →  Host:   [MAGIC][HDR=0x11][LEN][CRC][CMD][KEY][FLAG=0x10][value...]
                                         ^
                                         HEADER bit4 set = REPLY
```

### 7.2 Paginated Data Read

```
Host  →  Watch:  CMD=0x05  KEY=0x03  FLAG=0x10  DATA=[date range]
                 (HEART_RATE READ)

Watch →  Host:   CMD=0x05  KEY=0x03  FLAG=0x10  DATA=[records page 1]

Host  →  Watch:  CMD=0x05  KEY=0x03  FLAG=0x11  DATA=[]
                 (READ_CONTINUE)

Watch →  Host:   CMD=0x05  KEY=0x03  FLAG=0x10  DATA=[records page 2]

... repeat ...

Watch →  Host:   CMD=0x05  KEY=0x03  FLAG=0x10  DATA=[]
                 (empty DATA = end of records)
```

### 7.3 File Transfer Write

```
Host  →  Watch:  CMD=0x07  KEY=0x01  FLAG=0x20  DATA=[file_size, file_id, ...]
                 (WATCH_FACE CREATE — initiate transfer)

Watch →  Host:   CMD=0x07  KEY=0x01  FLAG=0x20  DATA=[ack]

Host  →  Watch:  CMD=0x07  KEY=0x01  FLAG=0x00  DATA=[chunk_1]
                 (WATCH_FACE UPDATE — first chunk)

Host  →  Watch:  CMD=0x07  KEY=0x01  FLAG=0x00  DATA=[chunk_2]
... repeat for all chunks ...

Watch →  Host:   CMD=0x07  KEY=0x01  FLAG=0x00  DATA=[ack / crc_check]
                 (transfer complete)
```

### 7.4 NACK Handling

```
If the device cannot process a command it replies with HEADER bit5 set:

Watch →  Host:   [MAGIC][HDR=0x31][LEN][CRC][CMD][KEY][FLAG][error_code?]
                          ^
                          0x31 = REPLY(0x10) | NACK(0x20) | VERSION(0x01)

Host should:
  1. Log the error (with CMD/KEY for identification)
  2. Optionally retry once
  3. Surface error to application layer if retry fails
```

---

## 8. Connection Handshake Commands

The following commands are sent in sequence during every connection establishment (see `01-BLE-COMMUNICATION.md` Section 7 for the full connection lifecycle):

### Step 1 — IDENTITY (CREATE)

```
BleKey:     IDENTITY  (0x0215)
BleKeyFlag: CREATE    (0x20)
Data:       4 bytes — random int32 (binding nonce)

Purpose:    Binds the phone app to the watch. The nonce is stored by the device
            and used to authenticate subsequent sessions. On first pairing the
            watch accepts any nonce; on re-connection it may verify a known value.

Packet:
  AB 01 00 07 <CRC_H> <CRC_L> 02 15 20 <N0> <N1> <N2> <N3>
```

### Step 2 — TIME (UPDATE)

```
BleKey:     TIME    (0x0201)
BleKeyFlag: UPDATE  (0x00)
Data:       4 bytes — current Unix timestamp (big-endian int32)

Purpose:    Synchronises the device real-time clock to phone time.
```

### Step 3 — FIRMWARE_VERSION (READ)

```
BleKey:     FIRMWARE_VERSION  (0x0204)
BleKeyFlag: READ              (0x10)
Data:       empty

Purpose:    Queries device firmware version for capability detection.
            Response DATA contains a version string or structured version record.
```

---

## 9. Quick-Lookup Index

Full sorted index of all documented `BleKey` constants by hex value.

```
mKey    Hex     Name
------  ------  ----
  257   0x0101  OTA
  258   0x0102  XMODEM
  513   0x0201  TIME
  514   0x0202  TIME_ZONE
  515   0x0203  POWER
  516   0x0204  FIRMWARE_VERSION
  517   0x0205  BLE_ADDRESS
  518   0x0206  USER_PROFILE
  519   0x0207  STEP_GOAL
  520   0x0208  BACK_LIGHT
  521   0x0209  SEDENTARINESS
  522   0x020A  NO_DISTURB_RANGE
  523   0x020B  VIBRATION
  524   0x020C  GESTURE_WAKE
  525   0x020D  HR_ASSIST_SLEEP
  526   0x020E  HOUR_SYSTEM
  527   0x020F  LANGUAGE
  528   0x0210  ALARM
  529   0x0211  COACHING
  530   0x0212  FIND_PHONE
  531   0x0213  WORLD_CLOCK
  532   0x0214  NO_DISTURB_GLOBAL
  533   0x0215  IDENTITY
  534   0x0216  UNIT
  535   0x0217  SLEEP_QUALITY
  536   0x0218  NETWORK_FIRMWARE_VERSION
  537   0x0219  DRINKWATER
  538   0x021A  SHUTDOWN
  539   0x021B  APP_SPORT_DATA
  540   0x021C  REAL_TIME_HEART_RATE
  541   0x021D  BLOOD_OXYGEN_SET
  542   0x021E  WASH_SET
  543   0x021F  TEMPERATURE_UNIT
  544   0x0220  DATE_FORMAT
  545   0x0221  WATCHFACE_SWITCH
  546   0x0222  AGPS_PREREQUISITE
  547   0x0223  DEVICE_INFO2
  548   0x0224  DOUBLE_SCREEN
  549   0x0225  GIRL_CARE
  550   0x0226  RAW_SLEEP
  551   0x0227  HR_WARNING
  552   0x0228  MEDICATION_REMINDER
  553   0x0229  CALORIES_GOAL
  554   0x022A  DISTANCE_GOAL
  555   0x022B  SLEEP_GOAL
  556   0x022C  SPORT_DURATION_GOAL
  557   0x022D  POWER_SAVE_MODE
  558   0x022E  AEROBIC_EXERCISE_GOAL
  559   0x022F  NIGHT_MODE
  560   0x0230  GAME_SET
  561   0x0231  LOVE_TAP_USER
  562   0x0232  ANTI_LOST
  563   0x0233  SOS
  564   0x0234  CLASSIC_BLUETOOTH_STATE
  565   0x0235  SOS_CONTACTS
  566   0x0236  BLOOD_PRESSURE_CALIBRATION
  567   0x0237  BLOOD_GLUCOSE_CALIBRATION
  568   0x0238  BREATH_TRAINING_QUIT
  569   0x0239  NAVIGATION_INFO
  570   0x023A  WALK_REMINDER
  571   0x023B  WEATHER_FORECAST
  572   0x023C  NEWS_FEED
  573   0x023D  MATCH_RECORD
  574   0x023E  SCHEDULE
  575   0x023F  DEVICE_SPORT_INFO
  576   0x0240  WATCH_FACE_WIDGET
  577   0x0241  STAND_SET
  578   0x0242  QRCODE
  579   0x0243  LOV_TAP_WAY
  580   0x0244  LOV_TAP_SINGLE
  581   0x0245  EARPHONE_SETTING
  582   0x0246  EARPHONE_KEY_SETTING
  583   0x0247  EARPHONE_ANC_SETTING
  584   0x0248  EARPHONE_EQ_SETTING
  585   0x0249  EARPHONE_TRANSPARENCY_SETTING
  586   0x024A  EARPHONE_HEARING_ASSIST
  587   0x024B  EARPHONE_LOW_LATENCY
  588   0x024C  EARPHONE_DOUBLE_CONNECT
  589   0x024D  DAILY_RECORDS
  590   0x024E  WATCH_FACE_OF_WATCH
  591   0x024F  EDR_PAIRING
  592   0x0250  PREFERENCE_SET
  593   0x0251  DEVICE_INFO3
  594   0x0252  REMINDER_EVENT
  595   0x0253  EYE_PROTECTION_REMINDER
 1025   0x0401  NOTIFICATION
 1026   0x0402  MUSIC_CONTROL
 1028   0x0404  WEATHER_REALTIME
 1029   0x0405  WEATHER_FORECAST_PUSH
 1031   0x0407  NOTIFICATION2
 1281   0x0501  STEP
 1282   0x0502  ACTIVITY
 1283   0x0503  HEART_RATE
 1284   0x0504  BLOOD_PRESSURE
 1285   0x0505  SLEEP
 1286   0x0506  WORKOUT
 1287   0x0507  LOCATION
 1288   0x0508  TEMPERATURE
 1289   0x0509  BLOOD_OXYGEN
 1290   0x050A  HRV
 1291   0x050B  LOG
 1292   0x050C  SLEEP2
 1293   0x050D  ECG
 1294   0x050E  PRESSURE
 1295   0x050F  BLOOD_GLUCOSE
 1296   0x0510  BODY_STATUS
 1297   0x0511  MIND_STATUS
 1298   0x0512  WORKOUT2
 1537   0x0601  CAMERA
 1538   0x0602  PHONE_GPSSPORT
 1539   0x0603  INCOMING_CALL
 1793   0x0701  WATCH_FACE
 1794   0x0702  AGPS_FILE
 1795   0x0703  FONT_FILE
 1796   0x0704  CONTACT
 1797   0x0705  UI_FILE
 1798   0x0706  LANGUAGE_FILE
 1799   0x0707  BRAND_INFO_FILE
 1800   0x0708  MEDIA_FILE
65535   0xFFFF  NONE
```

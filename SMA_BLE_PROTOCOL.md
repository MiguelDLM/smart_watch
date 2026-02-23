# SMA BLE Protocol Specification

**Reverse-engineered from STF/CO-FIT v2.0.3.4 APK (`com.smart.stf`)**
**BLE SDK: `com.szabh.smable3` (SMA BLE SDK v3)**

> This is NOT Jieli RCSP protocol. The app uses SMA's proprietary protocol layer
> over Nordic UART Service. Jieli native libs are only used for crypto (auth/encryption)
> and audio codecs — all BLE protocol logic is in Java/Kotlin.

---

## Table of Contents

1. [BLE Transport Layer](#1-ble-transport-layer)
2. [Frame Format](#2-frame-format)
3. [CRC16 Calculation](#3-crc16-calculation)
4. [Command System](#4-command-system)
5. [Connection Lifecycle](#5-connection-lifecycle)
6. [Session & Identity](#6-session--identity)
7. [Sending Data](#7-sending-data)
8. [Receiving Data](#8-receiving-data)
9. [Health Data Entities](#9-health-data-entities)
10. [Workout Entities](#10-workout-entities)
11. [Settings & Configuration](#11-settings--configuration)
12. [Stream Transfer (Watchfaces)](#12-stream-transfer-watchfaces)
13. [Device Info](#13-device-info)
14. [Callbacks Reference](#14-callbacks-reference)
15. [Constants Reference](#15-constants-reference)
16. [Implementation Notes](#16-implementation-notes)

---

## 1. BLE Transport Layer

### UUIDs (Nordic UART Service)

| Role    | UUID                                     |
|---------|------------------------------------------|
| Service | `6e400001-b5a3-f393-e0a9-e50e24dcca9e`  |
| Write   | `6e400002-b5a3-f393-e0a9-e50e24dcca9e`  |
| Notify  | `6e400003-b5a3-f393-e0a9-e50e24dcca9e`  |

### MTU

- Default MTU requested: platform-dependent
- `mIOBufferSize` from `BleDeviceInfo` controls max stream packet size (default 480 bytes)
- Write characteristic uses `WRITE_TYPE_NO_RESPONSE` for throughput

### Connection Parameters

| Parameter              | Value   |
|------------------------|---------|
| Connect timeout        | 8000 ms |
| Reconnect base period  | 5 s     |
| Reconnect max period   | 40 s    |
| Reconnect strategy     | Alternates direct connect / scan-based |
| Transport              | 2 (dual-mode / LE preferred) |
| Keepalive/heartbeat    | **NONE** — relies on auto-reconnect |

---

## 2. Frame Format

Every BLE message uses this frame structure:

```
Offset  Size  Field         Description
─────────────────────────────────────────────────
  0      1    magic         Always 0xAB (decimal -85 as signed byte)
  1      1    header        flags | 0x01 (version=1)
                              bit 4 (0x10): isReply
                              bit 5 (0x20): isNack
  2      2    length        Big-endian uint16, = payload_length + 3
  4      2    crc16         Big-endian uint16, CRC over bytes[6..end]
  6      1    command       BleCommand value (1-7, or 255)
  7      1    key           BleKey raw key value (mKey & 0xFF)
  8      1    keyFlag       BleKeyFlag value
  9+     N    payload       Variable-length data
```

- **Minimum frame size**: 9 bytes (`LENGTH_BEFORE_DATA`)
- **Length field** at offset 2 = `len(payload) + 3` (covers command + key + keyFlag)
- **CRC16** at offset 4 is computed over everything from offset 6 onward (command + key + keyFlag + payload)

### Building a Frame (pseudocode)

```python
def build_frame(command, key, key_flag, payload=b'', is_reply=False):
    header = 0x01  # version = 1
    if is_reply:
        header |= 0x10
    
    length = len(payload) + 3  # +3 for cmd, key, keyFlag
    
    # CRC is over: [command, key, keyFlag, *payload]
    crc_data = bytes([command, key, key_flag]) + payload
    crc = crc16(crc_data)
    
    frame = bytes([
        0xAB,
        header,
        (length >> 8) & 0xFF, length & 0xFF,  # big-endian
        (crc >> 8) & 0xFF, crc & 0xFF,        # big-endian
        command,
        key,
        key_flag,
    ]) + payload
    
    return frame
```

### Parsing Incoming Frames (BleParser)

1. Check byte[0] == 0xAB, reject if not
2. Read length from bytes[2:4] as big-endian uint16
3. Total frame size = length + 6 (for magic + header + length_field + crc_field)
4. Accumulate BLE notification chunks until full frame received
5. Validate CRC16 of bytes[6..end] against bytes[4:6]
6. Extract: command=byte[6], key=byte[7], keyFlag=byte[8], payload=bytes[9..end]
7. Reconstruct BleKey from `(command << 8) | key`
8. Check header bit4 for isReply, bit5 for isNack

---

## 3. CRC16 Calculation

Table-based CRC16 (same as CRC-16/CCITT-FALSE / CRC-16/IBM variant):

```python
CRC16_TABLE = [
    0x0000, 0xC0C1, 0xC181, 0x0140, 0xC301, 0x03C0, 0x0280, 0xC241,
    0xC601, 0x06C0, 0x0780, 0xC741, 0x0500, 0xC5C1, 0xC481, 0x0440,
    0xCC01, 0x0CC0, 0x0D80, 0xCD41, 0x0F00, 0xCFC1, 0xCE81, 0x0E40,
    0x0A00, 0xCAC1, 0xCB81, 0x0B40, 0xC901, 0x09C0, 0x0880, 0xC841,
    0xD801, 0x18C0, 0x1980, 0xD941, 0x1B00, 0xDBC1, 0xDA81, 0x1A40,
    0x1E00, 0xDEC1, 0xDF81, 0x1F40, 0xDD01, 0x1DC0, 0x1C80, 0xDC41,
    0x1400, 0xD4C1, 0xD581, 0x1540, 0xD701, 0x17C0, 0x1680, 0xD641,
    0xD201, 0x12C0, 0x1380, 0xD341, 0x1100, 0xD1C1, 0xD081, 0x1040,
    0xF001, 0x30C0, 0x3180, 0xF141, 0x3300, 0xF3C1, 0xF281, 0x3240,
    0x3600, 0xF6C1, 0xF781, 0x3740, 0xF501, 0x35C0, 0x3480, 0xF441,
    0x3C00, 0xFCC1, 0xFD81, 0x3D40, 0xFF01, 0x3FC0, 0x3E80, 0xFE41,
    0xFA01, 0x3AC0, 0x3B80, 0xFB41, 0x3900, 0xF9C1, 0xF881, 0x3840,
    0x2800, 0xE8C1, 0xE981, 0x2940, 0xEB01, 0x2BC0, 0x2A80, 0xEA41,
    0xEE01, 0x2EC0, 0x2F80, 0xEF41, 0x2D00, 0xEDC1, 0xEC81, 0x2C40,
    0xE401, 0x24C0, 0x2580, 0xE541, 0x2700, 0xE7C1, 0xE681, 0x2640,
    0x2200, 0xE2C1, 0xE381, 0x2340, 0xE101, 0x21C0, 0x2080, 0xE041,
    0xA001, 0x60C0, 0x6180, 0xA141, 0x6300, 0xA3C1, 0xA281, 0x6240,
    0x6600, 0xA6C1, 0xA781, 0x6740, 0xA501, 0x65C0, 0x6480, 0xA441,
    0x6C00, 0xACC1, 0xAD81, 0x6D40, 0xAF01, 0x6FC0, 0x6E80, 0xAE41,
    0xAA01, 0x6AC0, 0x6B80, 0xAB41, 0x6900, 0xA9C1, 0xA881, 0x6840,
    0x7800, 0xB8C1, 0xB981, 0x7940, 0xBB01, 0x7BC0, 0x7A80, 0xBA41,
    0xBE01, 0x7EC0, 0x7F80, 0xBF41, 0x7D00, 0xBDC1, 0xBC81, 0x7C40,
    0xB401, 0x74C0, 0x7580, 0xB541, 0x7700, 0xB7C1, 0xB681, 0x7640,
    0x7200, 0xB2C1, 0xB381, 0x7340, 0xB101, 0x71C0, 0x7080, 0xB041,
    0x5000, 0x90C1, 0x9181, 0x5140, 0x9301, 0x53C0, 0x5280, 0x9241,
    0x9601, 0x56C0, 0x5780, 0x9741, 0x5500, 0x95C1, 0x9481, 0x5440,
    0x9C01, 0x5CC0, 0x5D80, 0x9D41, 0x5F00, 0x9FC1, 0x9E81, 0x5E40,
    0x5A00, 0x9AC1, 0x9B81, 0x5B40, 0x9901, 0x59C0, 0x5880, 0x9841,
    0x8801, 0x48C0, 0x4980, 0x8941, 0x4B00, 0x8BC1, 0x8A81, 0x4A40,
    0x4E00, 0x8EC1, 0x8F81, 0x4F40, 0x8D01, 0x4DC0, 0x4C80, 0x8C41,
    0x4400, 0x84C1, 0x8581, 0x4540, 0x8701, 0x47C0, 0x4680, 0x8641,
    0x8201, 0x42C0, 0x4380, 0x8341, 0x4100, 0x81C1, 0x8081, 0x4040,
]

def crc16(data: bytes) -> int:
    crc = 0
    for byte in data:
        crc = (crc >> 8) ^ CRC16_TABLE[(crc ^ byte) & 0xFF]
    return crc & 0xFFFF
```

This is **CRC-16/MODBUS** (polynomial 0xA001, init=0x0000).

---

## 4. Command System

### BleCommand Values

| Name     | Value | Description                    |
|----------|-------|--------------------------------|
| UPDATE   | 1     | Update settings on device      |
| SET      | 2     | Set configuration              |
| CONNECT  | 3     | Connection/identity management |
| PUSH     | 4     | Push notifications to device   |
| DATA     | 5     | Health data operations         |
| CONTROL  | 6     | Device control commands        |
| IO       | 7     | I/O operations (watchfaces)    |
| NONE     | 255   | No command / unset             |

### BleKeyFlag Values

| Name           | Value | Description                          |
|----------------|-------|--------------------------------------|
| UPDATE         | 0x00  | Update/write data                    |
| READ           | 0x10  | Read data (single)                   |
| READ_CONTINUE  | 0x11  | Read continuation (paginated data)   |
| CREATE         | 0x20  | Create new resource                  |
| DELETE         | 0x30  | Delete resource                      |
| RESET          | 0x40  | Reset/clear                          |
| NONE           | 0xFF  | No flag                              |

### BleKey Encoding

Each `BleKey` has an `mKey` integer: **command = mKey >>> 8**, **rawKey = mKey & 0xFF**.

Example: `HEART_RATE` has mKey=0x0503 → command=5 (DATA), rawKey=3.

### Key Health Data Keys (Command = 0x05 / DATA)

| BleKey              | mKey   | Cmd | Key  | Item Length | Description            |
|---------------------|--------|-----|------|-------------|------------------------|
| ACTIVITY_REALTIME   | 0x0501 |  5  |  1   | —           | Realtime activity push |
| ACTIVITY            | 0x0502 |  5  |  2   | 16 bytes    | Steps/calories/distance|
| HEART_RATE          | 0x0503 |  5  |  3   | 6 bytes     | Heart rate             |
| BLOOD_PRESSURE      | 0x0504 |  5  |  4   | 6 bytes     | Blood pressure         |
| SLEEP               | 0x0505 |  5  |  5   | 7 bytes     | Sleep data             |
| WORKOUT             | 0x0506 |  5  |  6   | 48 bytes    | Basic workout          |
| LOCATION            | 0x0507 |  5  |  7   | —           | GPS location           |
| TEMPERATURE         | 0x0508 |  5  |  8   | 6 bytes     | Body temperature       |
| BLOOD_OXYGEN        | 0x0509 |  5  |  9   | 6 bytes     | SpO2                   |
| HRV                 | 0x050A |  5  | 10   | 6 bytes     | Heart rate variability |
| LOG                 | 0x050B |  5  | 11   | —           | Device log             |
| SLEEP_RAW_DATA      | 0x050C |  5  | 12   | —           | Raw sleep sensor data  |
| PRESSURE            | 0x050D |  5  | 13   | 6 bytes     | Stress/mental pressure |
| WORKOUT2            | 0x050E |  5  | 14   | 128 bytes   | Extended workout       |
| DATA_ALL            | 0x05FF |  5  | 255  | —           | Read all health data   |

### Key Connection Keys (Command = 0x03 / CONNECT)

| BleKey     | mKey   | Cmd | Key | Description             |
|------------|--------|-----|-----|-------------------------|
| IDENTITY   | 0x0301 |  3  |  1  | Device binding          |
| SESSION    | 0x0302 |  3  |  2  | Session login/persistence |

### Key IO Keys (Command = 0x07 / IO)

| BleKey     | mKey   | Cmd | Key | Description             |
|------------|--------|-----|-----|-------------------------|
| WATCH_FACE | 0x0701 |  7  |  1  | Watchface transfer      |

---

## 5. Connection Lifecycle

### Initial Connection

```
1. App calls connectGatt(device, autoConnect=false, transport=2)
2. onConnectionStateChange(CONNECTED)
3. discoverServices()
4. onServicesDiscovered() → find Nordic UART service + characteristics
5. enableNotifications(notify_characteristic)
6. requestMtu(desired_mtu)
7. onMtuChanged(mtu) → triggers bind or login
```

### Auto-Reconnect

- On disconnect: waits `reconnectPeriod` (starts at 5s)
- Alternates between:
  - **Direct connect**: `connectGatt(device, autoConnect=false)`
  - **Scan-based**: starts BLE scan, connects when device found
- Period doubles on each failure, caps at 40s
- Resets to 5s on successful connection
- On Bluetooth OFF: resets internal state, notifies disconnect
- On Bluetooth ON (with autoReconnect enabled): triggers reconnection

### Device Cache Refresh

- Calls hidden `BluetoothGatt.refresh()` method via reflection
- Used to clear cached services after firmware update

---

## 6. Session & Identity

### First-Time Binding (Pairing)

```python
# Send IDENTITY with CREATE flag and a random 32-bit ID
random_id = random.randint(0, 2**31 - 1)
payload = random_id.to_bytes(4, 'little')
send(command=3, key=1, keyFlag=0x20, payload=payload)  # CONNECT/IDENTITY/CREATE
```

- Device responds with its own `mId` stored in `BleDeviceInfo`
- App persists `mId` locally for future sessions

### Session Login (Reconnection)

```python
# Send SESSION with CREATE flag and the stored device mId
payload = stored_mId.to_bytes(4, 'little')
send(command=3, key=2, keyFlag=0x20, payload=payload)  # CONNECT/SESSION/CREATE
```

- On `onMtuChanged`: if `DeviceInfo` exists → `login(mId)`, else → `bind()`
- Success triggers `onSessionStateChange(true)`
- Failure triggers `onSessionStateChange(false)`

### Session Flow

```
onMtuChanged()
  ├── DeviceInfo exists? → login(mId)
  │     ├── Success → onSessionStateChange(true) → onDeviceConnected
  │     └── Failure → onSessionStateChange(false) → disconnect
  └── No DeviceInfo? → bind()
        ├── Success → onIdentityCreate(status) → store mId
        └── Failure → onIdentityCreate(error)
```

**Key insight for session persistence**: The `mId` from `BleDeviceInfo` is the session token. Store it persistently and send it via SESSION/CREATE on every reconnection.

---

## 7. Sending Data

### Message Queue (BleMessenger)

- Messages queued and sent sequentially
- Each message has a timeout (default 8000ms)
- Retry up to `RETRY_MAX = 3` times on timeout
- MTU-based packet splitting: messages larger than (MTU - 3) are split into chunks
- Write uses `WRITE_TYPE_NO_RESPONSE` for throughput

### Reading Health Data

```python
# Read heart rate data
send(command=5, key=3, keyFlag=0x10)  # DATA/HEART_RATE/READ

# Read continued (paginated) heart rate data
send(command=5, key=3, keyFlag=0x11)  # DATA/HEART_RATE/READ_CONTINUE

# Read ALL health data types at once
send(command=5, key=0xFF, keyFlag=0x10)  # DATA/DATA_ALL/READ
```

### Acknowledging Received Data

When the device sends health data, the app must acknowledge:

```python
# Send reply with UPDATE flag and isReply=true
send(command=5, key=3, keyFlag=0x00, is_reply=True)  # ACK for heart rate data
```

The `is_reply` flag sets bit 4 (0x10) in the header byte.

---

## 8. Receiving Data

### Parser State Machine (BleParser)

```python
class BleParser:
    def __init__(self):
        self.buffer = bytearray()
        self.expected_length = 0
    
    def on_notification(self, data: bytes):
        self.buffer.extend(data)
        
        while len(self.buffer) >= 9:  # minimum frame size
            if self.buffer[0] != 0xAB:
                self.buffer.clear()
                return
            
            # Read total payload+cmd+key+flag length
            length = (self.buffer[2] << 8) | self.buffer[3]
            frame_size = length + 6  # +6 for magic+header+length(2)+crc(2)
            
            if len(self.buffer) < frame_size:
                return  # wait for more data
            
            frame = bytes(self.buffer[:frame_size])
            self.buffer = self.buffer[frame_size:]
            
            # Validate CRC
            expected_crc = (frame[4] << 8) | frame[5]
            actual_crc = crc16(frame[6:])
            if expected_crc != actual_crc:
                continue  # bad frame
            
            # Parse fields
            header = frame[1]
            is_reply = bool(header & 0x10)
            is_nack = bool(header & 0x20)
            command = frame[6]
            key = frame[7]
            key_flag = frame[8]
            payload = frame[9:]
            ble_key = (command << 8) | key
            
            self.handle_data(ble_key, key_flag, payload, is_reply)
```

### handleData() Dispatch

The response handler uses a massive switch on `BleKey` ordinal (175 cases). Pattern for each health data case:

1. Check `isReply` — if true, this is an ACK from device, process differently
2. If data response: instantiate entity class, set `mBytes = payload`, call `decode()`
3. Store decoded entity in `BleCache`
4. Invoke appropriate callback (e.g., `onReadHeartRate`)
5. Call `notifySyncState()` to advance sync progress
6. Send reply ACK back to device

---

## 9. Health Data Entities

### Time Encoding

All timestamps are **seconds since January 1, 2000 00:00:00 UTC** (`DATA_EPOCH = 946684800`).

```python
DATA_EPOCH = 946684800  # 2000-01-01T00:00:00Z in Unix time

def ble_time_to_unix(ble_time: int) -> int:
    return ble_time + DATA_EPOCH

def unix_to_ble_time(unix_time: int) -> int:
    return unix_time - DATA_EPOCH

def ble_time_to_datetime(ble_time: int, tz_offset_ms: int = 0) -> datetime:
    millis = (ble_time + DATA_EPOCH) * 1000 - tz_offset_ms
    return datetime.fromtimestamp(millis / 1000)
```

### Byte Order

All multi-byte integers are **little-endian** unless noted otherwise.

### BleHeartRate — 6 bytes per item

```
Offset  Size  Type    Field
  0      4    int32   time      (seconds since 2000-01-01)
  4      1    int8    bpm       (beats per minute)
  5      1    int8    type      (measurement type)
```

### BleActivity — 16 bytes per item

```
Offset  Size  Type    Field
  0      4    int32   time      (seconds since 2000-01-01)
  4      1    byte    mode(5b)|state(3b)  — mode = byte >>> 3, state = byte & 0x07
  5      3    int24   step      (step count, LE 3 bytes)
  8      4    int32   calorie   (calories in cal or 0.1 kcal units)
 12      4    int32   distance  (distance in meters)
```

### BleSleep — 7 bytes per item

```
Offset  Size  Type    Field
  0      4    int32   time      (seconds since 2000-01-01)
  4      1    int8    mode      (sleep mode, see table below)
  5      1    int8    soft      (light motion count)
  6      1    int8    strong    (strong motion count)
```

**Sleep Modes:**

| Value | Name       | Description        |
|-------|------------|--------------------|
|  1    | DEEP       | Deep sleep         |
|  2    | LIGHT      | Light sleep        |
|  3    | AWAKE      | Awake period       |
|  8    | PIECEMEAL  | Piecemeal/nap      |
|  9    | REM        | REM sleep          |
| 17    | START      | Sleep session start|
| 34    | END        | Sleep session end  |

### BleBloodPressure — 6 bytes per item

```
Offset  Size  Type    Field
  0      4    int32   time       (seconds since 2000-01-01)
  4      1    uint8   systolic   (mmHg)
  5      1    uint8   diastolic  (mmHg)
```

### BleBloodOxygen — 6 bytes per item

```
Offset  Size  Type    Field
  0      4    int32   time      (seconds since 2000-01-01)
  4      1    uint8   value     (SpO2 percentage)
  5      1    —       padding
```

### BleTemperature — 6 bytes per item

```
Offset  Size  Type    Field
  0      4    int32   time         (seconds since 2000-01-01)
  4      2    int16   temperature  (value in 0.01°C or 0.1°C units)
```

### BleBloodGlucose — 6 bytes per item

```
Offset  Size  Type    Field
  0      4    int32   time      (seconds since 2000-01-01)
  4      2    int16   value     (blood glucose)
```

### BleHrv — 6 bytes per item

```
Offset  Size  Type    Field
  0      4    int32   time      (seconds since 2000-01-01)
  4      1    uint8   value     (HRV value in ms)
  5      1    uint8   avgValue  (average HRV)
```

### BlePressure (Stress) — 6 bytes per item

```
Offset  Size  Type    Field
  0      4    int32   time      (seconds since 2000-01-01)
  4      1    uint8   value     (stress level 0-100)
  5      1    —       padding (read but unused)
```

### BleEcg — 6 bytes per item

```
Offset  Size  Type    Field
  0      4    int32   time      (seconds since 2000-01-01)
  4      1    uint8   value     (ECG value)
  5      1    —       padding (read but unused)
```

### Decoding a List of Items

Health data responses contain multiple items concatenated. Use `ITEM_LENGTH` to split:

```python
def decode_health_list(payload: bytes, item_length: int, entity_class):
    items = []
    for offset in range(0, len(payload), item_length):
        chunk = payload[offset:offset + item_length]
        if len(chunk) < item_length:
            break
        item = entity_class()
        item.decode(chunk)
        items.append(item)
    return items

# Example: decode heart rate data
heart_rates = decode_health_list(payload, 6, BleHeartRate)
```

---

## 10. Workout Entities

### BleWorkout — 48 bytes per item

```
Offset  Size  Type     Field
  0      4    int32    mStart        (start time, seconds since 2000-01-01)
  4      4    int32    mEnd          (end time)
  8      2    uint16   mDuration     (duration in seconds)
 10      2    int16    mAltitude     (altitude in meters)
 12      2    uint16   mAirPressure  (air pressure)
 14      1    uint8    mSpm          (steps per minute)
 15      1    uint8    mMode         (workout mode/type)
 16      4    int32    mStep         (total steps)
 20      4    int32    mDistance     (total distance in meters)
 24      4    int32    mCalorie      (total calories)
 28      4    int32    mSpeed        (speed)
 32      4    int32    mPace         (pace)
 36      1    uint8    mAvgBpm       (average heart rate)
 37      1    uint8    mMaxBpm       (max heart rate)
 38-47   10   —        remaining bytes (padding/reserved)
```

### BleWorkout2 — 128 bytes per item

First 48 bytes identical to BleWorkout, then:

```
Offset  Size  Type     Field
 38      1    uint8    mMinBpm       (min heart rate)
 39      1    int8     mUndefined    (skip byte)
 40      2    int16    mMaxSpm       (max steps/min)
 42      2    int16    mMinSpm       (min steps/min)
 44      4    int32    mMaxPace      (max pace)
 48      4    int32    mMinPace      (min pace)
 52      2    int16    mMaxAltitude  (max altitude)
 54      2    int16    mMinAltitude  (min altitude)
 56      1    uint8    mMinStress
 57      1    uint8    mMaxStress
 58      1    uint8    mAvgStress
 59      4    int32    mMaxSpeed
 63      4    int32    mMinSpeed
 67      4    int32    mRestDuration (rest duration in seconds)
 71-127  —    —        remaining (padding/reserved)
```

### BleWorkout3 — 2048 bytes per item

First 128 bytes identical to BleWorkout2 (including the 1-byte skip after mMinBpm), then:

```
Offset  Size  Type     Field
~71+     4    int32    mMetTotal       (MET total)
         4    float    mAerobic        (aerobic TE)
         4    float    mAnaerobic      (anaerobic TE)
         4    int32    mStamina
         4    int32    (skip)
         4    float    mAvgSpeed
         2    uint16   mCadence
         2    uint16   mMaxCadence
         4    int32    mCnt
        10    uint16×5 mBpmZoneCount   (5 HR zones)
        10    uint16×5 mPersonalZone   (5 personal zones)
         4    int32    mLactateThresholdPace
         4    int32    mRecoveryTime
         2    uint16   mTrainingLoad
         2    uint16   mMaxVO2
         4    int32    mLactateThresholdHr
         2    uint16   mAlgorithmMarking
```

**Path Arrays** (GPS, HR, pace, speed, cadence, altitude):

Each path array has:
```
         4    int32    pathCount          (actual point count, max 32)
         4    int32    pathSampleInterval (seconds between samples)
       256    varies   pathPoints[32]     (32 data points, trimmed to pathCount)
```

- **GPS path**: 32 × `{lat: float32, lon: float32}` = 256 bytes
- **HR path**: 32 × `int32` = 128 bytes
- **Pace path**: 32 × `int32` = 128 bytes
- **Speed path**: 32 × `int32` = 128 bytes
- **Cadence path**: 32 × `int32` = 128 bytes
- **Altitude path**: 32 × `int32` = 128 bytes

`WORKOUT_MAX_POINT = 32` — arrays are always 32 entries but only `pathCount` entries are valid.

---

## 11. Settings & Configuration

### Timing Measurement Settings (Writable)

Both `BlePressureTimingMeasurement` and `BleEcgSettings` share the same format:

```
Offset  Size  Type    Field
  0      5    —       BleTimeRange  (start/end time + day mask)
  5      1    uint8   mInterval     (measurement interval in minutes, min=1, default=60)
```

`BleTimeRange` (5 bytes):
```
  0      1    uint8   startHour
  1      1    uint8   startMinute
  2      1    uint8   endHour
  3      1    uint8   endMinute
  4      1    uint8   dayMask     (bitmask for days of week)
```

### Common Settings Keys (Command = 0x02 / SET or 0x01 / UPDATE)

Read with `keyFlag=0x10` (READ), write with `keyFlag=0x00` (UPDATE):

- Device info, power, firmware version
- User profile, step/calorie/distance/sleep goals
- Unit system, hour format (12/24h)
- Backlight settings, sedentary reminders
- Do-not-disturb mode, alarms
- Language, gesture wake
- And many more (90+ settings in BleDeviceInfo support flags)

---

## 12. Stream Transfer (Watchfaces)

### Protocol

Watchface files are transferred using the stream protocol over `BleKey.WATCH_FACE` (0x0701).

### BleStreamPacket Format

```
Offset  Size  Type     Field
  0      1    uint8    type       (stream type identifier)
  1      4    uint32   totalSize  (total file size in bytes)
  5      4    uint32   index      (byte offset of this packet's data)
  9      N    bytes    data       (packet payload, max BUFFER_MAX_SIZE)
```

- **Header size**: 9 bytes
- **Default max packet data**: 480 bytes (`BUFFER_MAX_SIZE`)
- **Actual max**: controlled by `mIOBufferSize` from `BleDeviceInfo`

### Transfer Flow

```python
def send_watchface(file_data: bytes, io_buffer_size: int = 480):
    total_size = len(file_data)
    packet_data_size = io_buffer_size - 9  # subtract header
    
    for offset in range(0, total_size, packet_data_size):
        chunk = file_data[offset:offset + packet_data_size]
        
        # Build stream packet
        packet = bytearray()
        packet.append(stream_type)                          # type: 1 byte
        packet.extend(total_size.to_bytes(4, 'little'))     # totalSize: 4 bytes
        packet.extend(offset.to_bytes(4, 'little'))         # index: 4 bytes
        packet.extend(chunk)                                # data
        
        # Wrap in BLE frame
        send(command=7, key=1, keyFlag=0x00, payload=bytes(packet))
        # WATCH_FACE / UPDATE
        
        # Track progress
        progress = min(offset + len(chunk), total_size) / total_size
```

### Watchface Binary Format

Watchface binaries are built by `libsmawatchface.so` native library via JNI:
- `WatchFaceBuilder.initLib()` — initialize
- `WatchFaceBuilder.build(fields)` — construct binary from field descriptors

Field descriptors include: type, x, y, w, h, gravity, hasAlpha, ignoreBlack, playInterval, imageBuffers, bottomOffset.

---

## 13. Device Info

### BleDeviceInfo Decode Format

After session login, device sends its `BleDeviceInfo`:

```
[mId: 4 bytes, LE int32]              — Device binding ID (session token)
[mDataKeys: variable]                  — Supported data key pairs, terminated by 0x00
    Each pair: 2 bytes → (byte0 << 8) | byte1 = BleKey mKey value
    0x00 byte terminates the list
[mBleName: null-terminated string]     — BLE device name
[mBleAddress: null-terminated string]  — BLE MAC address (uppercased)
[mPlatform: null-terminated string]    — Chipset platform (see table)
[mPrototype: null-terminated string]   — Device prototype identifier
[mFirmwareFlag: null-terminated string]— Firmware flag
[mAGpsType: 1 byte, int8]             — AGPS type
[mIOBufferSize: 2 bytes, LE uint16]   — Max I/O buffer for streams
[mWatchFaceType: 1 byte, int8]        — Watchface type
[mClassicAddress: null-terminated str] — Classic BT address (uppercased)
[...90+ support flags: 1 byte each]   — Feature support booleans
```

### Platform Identifiers

| Value        | Chipset      |
|--------------|--------------|
| `JL`         | Jieli        |
| `JL707`      | Jieli 707    |
| `JL707Lite`  | Jieli 707 Lite|
| `SIFLI`      | SiFli        |
| `Nordic`     | Nordic Semi  |
| `MTK`        | MediaTek     |
| `Realtek`    | Realtek      |
| `Goodix`     | Goodix       |
| `ZKLX`       | ZKLX         |

### Using mDataKeys

The `mDataKeys` list tells you which `BleKey` values the device supports. Only request data for keys present in this list.

---

## 14. Callbacks Reference

### Health Data

| Callback                | BleKey          | Description              |
|-------------------------|-----------------|--------------------------|
| `onReadHeartRate`       | HEART_RATE      | Heart rate records       |
| `onReadBloodPressure`   | BLOOD_PRESSURE  | Blood pressure records   |
| `onReadBloodOxygen`     | BLOOD_OXYGEN    | SpO2 records             |
| `onReadSleep`           | SLEEP           | Sleep records            |
| `onReadActivity`        | ACTIVITY        | Activity/steps records   |
| `onReadTemperature`     | TEMPERATURE     | Temperature records      |
| `onReadPressure`        | PRESSURE        | Stress records           |
| `onReadWorkout`         | WORKOUT         | Basic workout records    |
| `onReadWorkout2`        | WORKOUT2        | Extended workout records |
| `onReadWorkout3`        | —               | Full workout + paths     |
| `onReadBleHrv`          | HRV             | HRV records              |
| `onReadBloodGlucose`    | —               | Blood glucose records    |
| `onReadEcg`             | —               | ECG records              |
| `onReadLocation`        | LOCATION        | GPS location records     |

### Session

| Callback                   | Description                       |
|----------------------------|-----------------------------------|
| `onSessionStateChange`     | Session connected/disconnected    |
| `onIdentityCreate`         | Binding result                    |
| `onIdentityDelete`         | Unbind result                     |
| `onIdentityDeleteByDevice` | Device-initiated unbind           |

### Stream/IO

| Callback                  | Description                       |
|---------------------------|-----------------------------------|
| `onStreamProgress`        | Watchface transfer progress       |
| `onReadWatchFaceId`       | Current watchface ID              |
| `onReadWatchFaceIndex`    | Watchface index/slot              |
| `onWatchFaceIdUpdate`     | Watchface ID changed              |
| `onWatchFaceIndexCreate`  | New watchface slot created        |
| `onWatchFaceIndexUpdate`  | Watchface slot updated            |

### Realtime Measurement

| Callback                  | Description                       |
|---------------------------|-----------------------------------|
| `onRealTimeMeasurement`   | Generic realtime measurement      |
| `onUpdateHeartRate`       | Live heart rate update            |
| `onUpdateBloodPressure`   | Live blood pressure update        |
| `onUpdateTemperature`     | Live temperature update           |

### Device Push (device → phone)

| Callback                    | Description                     |
|-----------------------------|---------------------------------|
| `onFindPhone`               | Watch triggered find-phone      |
| `onCameraStateChange`       | Camera remote control state     |
| `onCameraResponse`          | Camera command response         |
| `onReceiveMusicCommand`     | Music playback control          |
| `onReceiveLocationGga`      | GPS GGA sentence request        |
| `onReceiveLocationGsv`      | GPS GSV sentence request        |
| `onReceiveRealtimeLog`      | Device debug log                |
| `onReceiveFilePacket`       | Incoming file data              |
| `onReceiveRecordPacket`     | Incoming record data            |
| `onReceiveGSensorRaw`       | Raw accelerometer data          |
| `onReceiveGSensorMotion`    | Motion event                    |
| `onReceiveHRRaw`            | Raw heart rate sensor data      |

---

## 15. Constants Reference

```python
# Protocol constants
MAGIC_BYTE       = 0xAB
FRAME_MIN_SIZE   = 9         # LENGTH_BEFORE_DATA
DATA_EPOCH       = 946684800 # Unix timestamp for 2000-01-01T00:00:00Z
BLE_OK           = 0
BLE_ERROR        = 1
ID_ALL           = 255       # Used with DATA_ALL to read all data types

# Connection constants
CONNECT_TIMEOUT  = 8000      # ms
RECONNECT_BASE   = 5000      # ms
RECONNECT_MAX    = 40000     # ms
RETRY_MAX        = 3         # message retry count

# Stream constants
BUFFER_MAX_SIZE  = 480       # default max stream packet size
STREAM_HEADER    = 9         # stream packet header size

# BLE Transport
GATT_TRANSPORT   = 2         # LE transport
WRITE_TYPE       = 1         # WRITE_TYPE_NO_RESPONSE
```

---

## 16. Implementation Notes

### Session Persistence Fix

**Problem**: Session drops and doesn't reconnect properly.

**Solution**:
1. On first bind: store `mId` from `BleDeviceInfo` persistently (SharedPreferences, database, etc.)
2. On every reconnection after MTU exchange: send `SESSION/CREATE` with stored `mId`
3. Do NOT re-bind — binding creates a new identity and may require user confirmation on the watch
4. Implement auto-reconnect with exponential backoff (5s → 10s → 20s → 40s cap)
5. Handle Bluetooth adapter state changes: reset on OFF, reconnect on ON
6. There is NO keepalive — the BLE connection will drop if the OS decides. Rely on reconnection.

### Transfer Reliability Fix

**Problem**: Watchface transfers fail or stall.

**Solution**:
1. Read `mIOBufferSize` from `BleDeviceInfo` to determine max packet size
2. Subtract 9 bytes for stream header when calculating data chunk size
3. Each packet must include the full stream header (`type + totalSize + index`)
4. Use `WRITE_TYPE_NO_RESPONSE` for throughput
5. Track progress via `mStreamProgressCompleted / mStreamProgressTotal`
6. Message timeout is 8000ms — if a write stalls, retry up to 3 times
7. If transfer fails entirely, the whole stream needs to be restarted

### Health Data Parsing

**Pattern for reading health data**:

```python
# 1. Send READ request
send_frame(command=5, key=3, keyFlag=0x10)  # Read heart rate

# 2. Receive response (via notification)
# Parser accumulates bytes, delivers complete frame
# Payload contains N items × ITEM_LENGTH bytes

# 3. Decode items
items = []
for i in range(0, len(payload), ITEM_LENGTH):
    chunk = payload[i:i+ITEM_LENGTH]
    time_raw = int.from_bytes(chunk[0:4], 'little', signed=True)
    timestamp = datetime.utcfromtimestamp(time_raw + 946684800)
    # ... decode remaining fields per entity spec

# 4. Send ACK (reply)
send_frame(command=5, key=3, keyFlag=0x00, is_reply=True)

# 5. Check if more data available
# If device sends READ_CONTINUE response, send READ_CONTINUE request
send_frame(command=5, key=3, keyFlag=0x11)  # Read continue
```

### Important Gotchas

1. **Frame length field** does NOT include the 6-byte header (magic+header+length+crc)
2. **CRC is only over** command+key+keyFlag+payload (bytes 6+), NOT the full frame
3. **Timestamps** are relative to 2000-01-01, NOT Unix epoch 1970-01-01
4. **All integers** in payloads are **little-endian**, but length and CRC in the frame header are **big-endian**
5. **BleActivity** packs mode and state into a single byte (mode=upper 5 bits, state=lower 3 bits)
6. **Sleep data** uses START(17) and END(34) markers to delimit sleep sessions
7. **mDataKeys** in DeviceInfo tells you what the device supports — don't request unsupported keys
8. **No heartbeat/keepalive** — connection persistence is entirely BLE stack + auto-reconnect

---

*Document generated from reverse engineering of STF/CO-FIT v2.0.3.4 APK*
*BLE SDK: com.szabh.smable3 by SMA/Szabh*
*Protocol: SMA BLE Protocol v1 over Nordic UART Service*

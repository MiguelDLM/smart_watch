# 08 — Health Data Synchronization and Cloud Endpoints

## Overview

The application synchronizes health data collected by the watch through a multi-stage pipeline: BLE transport from watch to phone, local SQLite persistence, and subsequent upload to cloud backends and third-party fitness platforms.

```
Watch ─(BLE)─► Phone App ─(HTTPS)─► Cloud Backend
                   │
                   ├──► Baidu Yingyan  (location tracks)
                   ├──► Fitbit API     (workouts)
                   ├──► Strava API     (workouts)
                   ├──► OpenAI         (voice transcription)
                   └──► iFlyTek        (voice AI)
```

Source files:
- `decompiled_apk/sources/com/szabh/smable3/component/BleCache.java`
- `decompiled_apk/sources/com/sma/smartv3/ble/ProductManager.java`
- `decompiled_apk/sources/com/sma/smartv3/network/BaiDu.java`

---

## BLE Data Retrieval Protocol

Health data is pulled from the watch using a paginated read protocol. The phone acts as the initiator (GATT central); the watch acts as the responder (GATT peripheral).

### Flow Diagram

```
Phone                                   Watch
  │                                       │
  │── DATA cmd (BleKey, FLAG=READ 0x10) ──►│
  │                                       │
  │◄── packed binary records (N × ITEM_LENGTH bytes) ──│
  │                                       │
  │   [if more data available]            │
  │── DATA cmd (BleKey, FLAG=READ_CONTINUE 0x11) ──►│
  │                                       │
  │◄── next batch of records ─────────────│
  │                                       │
  │   [repeat until empty/short response] │
  │                                       │
  │── [sync complete] ────────────────────│
```

### Protocol Steps

1. Phone sends `BleKey.DATA` command (`0x05xx`) with flag `BleKeyFlag.READ` (`0x10`).
2. Watch responds with packed binary records formatted as `N × ITEM_LENGTH` bytes.
3. Phone parses each record using the entity-specific `decode()` method.
4. If the response indicates more data is available, the phone sends `BleKeyFlag.READ_CONTINUE` (`0x11`).
5. Watch transmits the next batch of records.
6. Steps 4–5 repeat until the watch returns an empty or short (terminal) response.

---

## Data Types Synchronized

### Watch → Phone (READ commands)

| BleKey             | Hex Code | Entity Class      | Description                 |
|--------------------|----------|-------------------|-----------------------------|
| STEP               | `0x0501` | BleStep           | Daily step count records     |
| ACTIVITY           | `0x0502` | BleActivity       | Activity/movement records    |
| HEART_RATE         | `0x0503` | BleHeartRate      | Heart rate measurements      |
| BLOOD_PRESSURE     | —        | BleBloodPressure  | Systolic/diastolic readings  |
| SLEEP              | `0x0505` | BleSleep          | Sleep stage records          |
| WORKOUT            | `0x0506` | BleWorkout        | Workout session data         |
| LOCATION           | `0x0507` | BleLocation       | GPS coordinate records       |
| TEMPERATURE        | `0x0508` | BleTemperature    | Body temperature readings    |
| BLOOD_OXYGEN       | `0x0509` | BleBloodOxygen    | SpO2 measurements            |
| HRV                | `0x050A` | BleHrv            | Heart rate variability data  |
| ECG                | `0x050D` | BleEcg            | Electrocardiogram data       |
| PRESSURE           | `0x050E` | BlePressure       | Stress level readings        |
| BLOOD_GLUCOSE      | —        | BleBloodGlucose   | Blood glucose measurements   |

### Phone → Watch (SET commands)

| BleKey               | Hex Code | Description                        |
|----------------------|----------|------------------------------------|
| TIME                 | `0x0201` | Current time synchronization       |
| USER_PROFILE         | `0x0206` | User height, weight, age, gender   |
| STEP_GOAL            | `0x0207` | Daily step goal                    |
| ALARM                | `0x0210` | Alarm clock settings               |
| WEATHER_REALTIME     | `0x0404` | Current weather conditions         |
| WEATHER_FORECAST     | `0x0405` | Multi-day weather forecast         |
| NOTIFICATION         | `0x0401` | Phone notification forwarding      |
| WATCH_FACE           | `0x0701` | Watch face binary upload           |
| AGPS_FILE            | `0x0702` | AGPS/EPO data file upload          |
| CONTACT              | `0x0704` | Emergency contact list             |

---

## Cloud Backend Endpoints

### Primary Vendor Backend

| Property | Value |
|----------|-------|
| Base URL | `https://api.iot-solution.net/kotlinweb` |
| Purpose  | Health data upload, device registration, user account management |

### Test/Staging Server (Present in Production Code)

| Property | Value |
|----------|-------|
| Base URL | `https://ceshi.smawatch.cn` |
| Note     | "ceshi" (测试) is Chinese for "test" — this staging server URL is embedded in production builds |

> **Security Note:** A test server endpoint is present in released production code. Requests may be inadvertently routed to a non-production environment depending on configuration state.

### SMA Watch API

| Property | Value |
|----------|-------|
| Base URL | `https://api.smawatch.cn` |
| Purpose  | EPO/AGPS data files, device firmware metadata |
| AGPS File | `https://api.smawatch.cn/epo/ble_epo_offline.bin` |

---

## Third-Party Data Synchronization

### Fitbit

| Property      | Value |
|---------------|-------|
| API Base URL  | `https://api.fitbit.com` |
| Data Synced   | Workout and activity data |
| Auth Method   | OAuth2 |
| Credential    | `fitbit_client_secret` embedded in app resources |

> **Security Note:** The OAuth2 `client_secret` is stored statically in application resources, exposing it to extraction via decompilation.

### Strava

| Property      | Value |
|---------------|-------|
| API Base URL  | `https://www.strava.com/api/v3` |
| Data Synced   | Workout and activity data |
| Auth Method   | OAuth2 |
| Credential    | `strava_client_secret` embedded in app resources |

> **Security Note:** Same static credential embedding issue as Fitbit above.

### Baidu Yingyan (Location Tracking)

| Property   | Value |
|------------|-------|
| Track Upload | `https://yingyan.baidu.com/api/v3/track/addpoints` |
| Entity Create | `https://yingyan.baidu.com/api/v3/entity/add` |
| Data Sent  | Batches of GPS coordinates with timestamps |
| API Key    | `qcXtk4qlqB31PI8KK74Sw8k6jQhBlBqH` (hardcoded) |

> **Privacy Note:** GPS coordinate data is transmitted to Baidu's location tracking platform (Yingyan). The API key is hardcoded in the application.

### OpenAI

| Property  | Value |
|-----------|-------|
| Purpose   | Voice recording transcription |
| Direction | Phone → OpenAI API |

### iFlyTek

| Property  | Value |
|-----------|-------|
| Purpose   | Voice AI processing |
| Direction | Phone → iFlyTek API |

---

## AGPS Data Sources

Assisted GPS data is downloaded by the phone and pushed to the watch via `BleKey.AGPS_FILE` (`0x0702`).

| Provider  | URL                                                                            | Format     |
|-----------|--------------------------------------------------------------------------------|------------|
| MediaTek  | `http://wepodownload.mediatek.com/EPO_GR_3_1.DAT`                              | EPO binary |
| u-blox    | `https://alp.u-blox.com/current_1d.alp`                                       | ALP binary |
| SMA (Ali) | `https://sma-product.oss-accelerate.aliyuncs.com/a-gps/...`                   | Custom     |
| SMA API   | `https://api.smawatch.cn/epo/ble_epo_offline.bin`                              | EPO binary |

> **Note:** The MediaTek EPO URL uses plain HTTP (not HTTPS), making that download susceptible to interception or tampering.

---

## BLE Cache and Local Storage

### SharedPreferences

| Property | Value |
|----------|-------|
| Key      | `sma_ble_sdk3` |
| Stores   | BLE MAC address, platform identifier, prototype name, device info, binding state |

### SQLite Database

Health records retrieved from the watch are persisted locally in the application's SQLite database before cloud upload. Sync state metadata tracks which records have been successfully uploaded to the backend.

### Upload Lifecycle

```
Watch ──(BLE READ)──► Phone SQLite
                           │
                    [background sync job]
                           │
                           ├── Mark record as "pending upload"
                           ├── POST to cloud backend
                           └── Mark record as "uploaded"
```

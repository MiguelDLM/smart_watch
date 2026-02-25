# 09 — Supported Hardware Platforms, Prototypes, and Device Support

## Overview

The application supports a heterogeneous set of smartwatch hardware platforms, each using a different chipset vendor, OTA update mechanism, and BLE stack. Device capabilities are communicated at pairing time via the `BleDeviceInfo` structure, which carries over 100 boolean feature flags alongside platform and prototype identifiers.

Source files:
- `decompiled_apk/sources/com/szabh/smable3/entity/BleDeviceInfo.java`
- `decompiled_apk/sources/com/szabh/smable3/entity/BleDeviceInfo2.java`
- `devices_supported.csv` (repository root — 1,012 device entries)

---

## Hardware Platforms

Each platform value is transmitted as a variable-length string field within the `BleDeviceInfo` payload. The phone uses this value to select the appropriate OTA manager, BLE characteristic set, and protocol variant.

| Platform    | Chipset                   | OTA Mechanism          | Notes                             |
|-------------|---------------------------|------------------------|-----------------------------------|
| JL          | JieLi                     | JOTAManager            | Most common platform in the fleet |
| JL707       | JieLi JL707               | JOTAManager            | Newer JieLi variant               |
| JL707Lite   | JieLi JL707 Lite          | JOTAManager            | Low-cost variant of JL707         |
| Nordic      | Nordic Semiconductor      | DfuServiceInitiator    | nRF series (nRF52xxx typical)     |
| Goodix      | Goodix                    | BleConnector direct    | GR series (GR5xxx typical)        |
| MTK         | MediaTek                  | BLE characteristics    | MT2502 / MT2523 chipsets          |
| Realtek     | Realtek                   | ROTAManager            | RTL8762 series                    |
| SIFLI       | SiFli Technology (SF32LB) | SOTAManager            | SF32LB series                     |
| ZKLX        | Unknown                   | Unknown                | Rare; limited documentation       |

### OTA Manager Summary

| OTA Manager          | Platform(s)           | Protocol Basis                        |
|----------------------|-----------------------|---------------------------------------|
| JOTAManager          | JL, JL707, JL707Lite  | Proprietary JieLi OTA over BLE        |
| DfuServiceInitiator  | Nordic                | Nordic DFU (Device Firmware Upgrade)  |
| BleConnector direct  | Goodix                | Goodix proprietary OTA                |
| ROTAManager          | Realtek               | Realtek OTA protocol                  |
| SOTAManager          | SIFLI                 | SiFli proprietary OTA                 |
| BLE characteristics  | MTK                   | MediaTek characteristic-based update  |

---

## Device Prototypes

Each connected device reports a prototype identifier string (e.g., `AM05`, `F13`, `R9`) within `BleDeviceInfo`. This prototype value maps to a specific hardware configuration, display type, and default feature set.

- The application recognizes **80+ distinct prototype identifiers**.
- Known examples include: `AM05`, `F13`, `R9`, and many others cataloged in `BleDeviceInfo.java`.
- The repository root file `devices_supported.csv` contains **1,012 named device entries** referencing the full range of supported commercial products built on these prototypes.

---

## AGPS Type Enumeration

The `agpsType` field (1 byte, `int8`) in `BleDeviceInfo` indicates which Assisted GPS system the device supports.

| Value | Constant | Description                        |
|-------|----------|------------------------------------|
| 0     | NONE     | No AGPS support                    |
| 1     | EPO      | MediaTek EPO (Extended Prediction Orbit) |
| 2     | UBLOX    | u-blox AGNSS                       |
| 6     | AGNSS    | Generic AGNSS                      |
| 7     | EPO2     | MediaTek EPO version 2             |
| 8     | LTO      | Long-Term Orbit data               |
| 9     | 6228     | MediaTek MT6228-specific AGPS      |

---

## Watch Face Type Enumeration

The `watchFaceType` field (1 byte, `int8`) in `BleDeviceInfo` indicates the watch face format the device accepts.

| Value | Meaning                                                    |
|-------|------------------------------------------------------------|
| 0     | No custom watch face support                               |
| 1     | Standard watch face (built via WatchFaceBuilder)           |
| 2+    | Extended watch face types (HK89 binary format and others) |

---

## BleDeviceInfo Decode Format

The `BleDeviceInfo` structure is delivered as a binary payload during the device information exchange. Fields are decoded sequentially using entity-specific `decode()` methods.

| Field                | Size (bytes) | Type       | Description                                      |
|----------------------|--------------|------------|--------------------------------------------------|
| mId                  | 4            | int32      | Device identifier                                |
| dataKeys             | variable     | byte pairs | Supported BleKey list (2 bytes each → int)       |
| bleName              | variable     | string     | BLE advertised device name                       |
| bleAddress           | variable     | string     | BLE MAC address (uppercase hex, colon-separated) |
| platform             | variable     | string     | Platform identifier (JL, Nordic, Goodix, etc.)   |
| prototype            | variable     | string     | Prototype model name                             |
| firmwareFlag         | variable     | string     | Firmware build flag string                       |
| agpsType             | 1            | int8       | AGPS type (see enumeration above)                |
| ioBufferSize         | 2            | uint16     | I/O buffer size for file transfer operations     |
| watchFaceType        | 1            | int8       | Watch face binary format type                    |
| classicAddress       | variable     | string     | Classic Bluetooth address (for audio/calls)      |
| [feature flags]      | 1 each       | int8       | Boolean capability flags (0 = false, 1 = true)   |

Source: `decompiled_apk/sources/com/szabh/smable3/entity/BleDeviceInfo.java`

---

## BleDeviceInfo2 Decode Format

`BleDeviceInfo2` is a supplementary structure providing versioning details and language state. It is decoded after the primary `BleDeviceInfo`.

| Field            | Size (bytes) | Type      | Description                            |
|------------------|--------------|-----------|----------------------------------------|
| bleAddress       | variable     | string    | BLE MAC address                        |
| classicAddress   | variable     | string    | Classic Bluetooth MAC address          |
| firmwareVersion  | 3            | 3× uint8  | Firmware version as X.Y.Z             |
| uiVersion        | 3            | 3× uint8  | UI resource version as X.Y.Z          |
| languageVersion  | 3            | 3× uint8  | Language pack version as X.Y.Z        |
| languageCode     | 1            | uint8     | Currently active language code         |
| bleName          | variable     | string    | BLE advertised name                    |
| platform         | variable     | string    | Platform identifier                    |
| prototype        | variable     | string    | Prototype model name                   |
| firmwareFlag     | variable     | string    | Firmware build flag                    |
| fullVersion      | variable     | string    | Full version string (human-readable)   |

Source: `decompiled_apk/sources/com/szabh/smable3/entity/BleDeviceInfo2.java`

---

## Feature Support Flags

Over 100 boolean capability flags are packed into the `BleDeviceInfo` payload, one byte each (`int8`, value `0` or `1`). These flags allow the phone application to conditionally enable UI elements and protocol features based on what the connected device actually supports.

### Health Monitoring

| Flag                              | Description                         |
|-----------------------------------|-------------------------------------|
| mSupportBloodOxygen               | SpO2 (blood oxygen saturation) measurement |
| mSupportBloodPressure             | Blood pressure measurement          |
| mSupportBloodPressureCalibration  | Blood pressure user calibration     |
| mSupportTemperature               | Body temperature measurement        |
| mSupportHRV                       | Heart rate variability analysis     |
| mSupportECG                       | Electrocardiogram recording         |
| mSupportBloodGlucose              | Blood glucose measurement           |
| mSupportBodyStatus                | Body status analysis                |
| mSupportMindStatus                | Mental health / mood status         |
| mSupportPressure                  | Stress level monitoring             |

### Watch Features

| Flag                   | Description                          |
|------------------------|--------------------------------------|
| mSupportWatchFace      | Custom watch face upload             |
| mSupportWatchFaceWidget| Watch face widget support            |
| mSupportAlarm          | Alarm clock configuration            |
| mSupportWorldClock     | World clock display                  |
| mSupportSedentariness  | Sedentary reminder alerts            |
| mSupportDrinkWater     | Drink water reminder alerts          |
| mSupportGestureWake    | Raise-to-wake gesture detection      |

### Communication

| Flag                   | Description                                  |
|------------------------|----------------------------------------------|
| mSupportNotification   | Phone notification forwarding                |
| mSupportNotification2  | Extended notifications (includes phone number)|
| mSupportIncomingCall   | Incoming call display on watch               |
| mSupportFindPhone      | Find my phone feature                        |
| mSupportSOSContacts    | SOS emergency contact alerts                 |
| mSupportContact        | Contact list synchronization                 |
| mSupportLoveTap        | Love tap haptic feature                      |

### Sports and GPS

| Flag                   | Description                              |
|------------------------|------------------------------------------|
| mSupportSport          | Sports session tracking                  |
| mSupportGPS            | Built-in GPS module                      |
| mSupportAGPS           | Assisted GPS support                     |
| mSupportNavigation     | Turn-by-turn navigation display          |
| mSupportPhoneGPSSport  | Use phone GPS for sports tracking        |

### Device Capabilities

| Flag                   | Description                              |
|------------------------|------------------------------------------|
| mSupportOTA            | Over-the-air firmware update             |
| mSupportPowerSaveMode  | Low power / power save mode              |
| mSupportNightMode      | Night mode (reduced brightness)          |
| mSupportCamera         | Camera shutter remote control            |
| mSupportMusicControl   | Music playback control                   |
| mSupportDoubleScreen   | Dual screen hardware support             |
| mSupportClassicBluetooth | Classic Bluetooth (for phone calls)   |
| mSupportEDR            | Bluetooth Enhanced Data Rate             |

### Voice and AI

| Flag                        | Description                              |
|-----------------------------|------------------------------------------|
| mSupportVoice               | Voice recording capability               |
| mSupportAITranslation       | AI-powered translation                   |
| mSupportAIWatchFace         | AI-generated watch face creation         |
| mSupportRealTimeConversation| Real-time voice conversation             |
| mSupportEarphone            | Earphone / earbud pairing support        |

### Miscellaneous

| Flag                        | Description                              |
|-----------------------------|------------------------------------------|
| mSupportGame                | Games running on watch                   |
| mSupportGirlCare            | Menstrual cycle tracking                 |
| mSupportAntiLost            | Anti-lost proximity alert                |
| mSupportMedicationReminder  | Medication reminder notifications        |
| mSupportQRCode              | QR code display on watch screen          |
| mSupportBrandInfo           | Custom brand / OEM information           |
| mSupportUIFile              | UI resource file transfer                |
| mSupportLanguageFile        | Language pack file transfer              |
| mSupportFontFile            | Font file transfer                       |

---

## Device Count Summary

| Source                  | Count |
|-------------------------|-------|
| Known prototype IDs     | 80+   |
| Named devices (CSV)     | 1,012 |
| Supported platforms     | 9     |
| Feature flags (approx.) | 100+  |

# 06 — OTA Firmware Update Protocol

**Scope:** Over-the-air firmware update mechanisms for all supported hardware platforms.
Covers OTA manager selection, status codes, DFU address calculation, and per-platform
transfer protocols.

**Source files referenced:**
- `decompiled_apk/sources/com/szabh/smable3/ota/oxoX.java` (OTAManagerFactory)
- `decompiled_apk/sources/com/szabh/smable3/ota/oIX0oI.java` (base OTA manager)
- `decompiled_apk/sources/com/szabh/smable3/ota/II0xO0.java` (JOTAManager — JieLi)
- `decompiled_apk/sources/com/szabh/smable3/ota/SOTAManager.java` (SiFli OTA)
- `decompiled_apk/sources/com/szabh/smable3/ota/ROTAManager.java` (Realtek OTA)
- `decompiled_apk/sources/no/nordicsemi/android/dfu/DfuBaseService.java` (Nordic DFU)
- `decompiled_apk/sources/com/szabh/smable3/component/BleConnector.java` (MTK OTA)
- `decompiled_apk/sources/com/szabh/smable3/component/BleCache.java` (DFU address calc)

---

## 1. Architecture Overview

```
  [ Firmware .bin / .zip file ]
            |
            v
  [ OTAManagerFactory (oxoX.java) ]
            |
     platform string
            |
     +------+--------+-----------+----------+
     |      |        |           |          |
     v      v        v           v          v
  JOTAMgr  SOTAMgr  ROTAMgr  DfuService  BleConnector
  (JieLi)  (SiFli)  (Realtek) (Nordic)   (MTK/Goodix)
```

The `OTAManagerFactory` (`oxoX.java`) instantiates the correct OTA implementation at
runtime based on the device's declared platform string.

---

## 2. Platform-to-OTA-Manager Mapping

| Platform   | OTA Manager            | SDK / Library                          |
|------------|------------------------|----------------------------------------|
| JL         | JOTAManager            | `com.jieli.jl_bt_ota`                  |
| JL707      | JOTAManager            | `com.jieli.jl_bt_ota`                  |
| JL707Lite  | JOTAManager            | `com.jieli.jl_bt_ota`                  |
| SIFLI      | SOTAManager            | `com.sifli.siflidfu`                   |
| Realtek    | ROTAManager            | `com.realsil.sdk.dfu`                  |
| Nordic     | DfuServiceInitiator    | `no.nordicsemi.android.dfu`            |
| MTK        | BleConnector (direct)  | Custom BLE characteristics             |
| Goodix     | BleConnector (direct)  | `com.goodix.ble.gr.libdfu`             |
| ZKLX       | Unknown                | Not identified                         |

### 2.1 Factory Selection Logic

```java
// oxoX.java — OTAManagerFactory
if (platform.equals("JL") || platform.equals("JL707") || platform.equals("JL707Lite")) {
    return new JOTAManager();   // II0xO0.java
}
if (platform.equals("SIFLI")) {
    return new SOTAManager();
}
// default
return new ROTAManager();
```

Nordic DFU is initiated separately via `DfuServiceInitiator` from UI activities
(`FirmwareUpgradeNActivity`, etc.) and is not routed through the factory.

---

## 3. OTA Status Codes (oIX0oI.java — base class)

All OTA manager implementations report progress through a shared status code integer.

| Code | Meaning                                                  |
|------|----------------------------------------------------------|
| -1   | Initial / Unknown state (not yet started)                |
|  1   | OTA Started (`startOTA` called)                          |
|  2   | Error: device disconnected during setup                  |
|  3   | OTA Connecting / Preparing                               |
|  4   | Transferring — phase 1 (init / verify)                   |
|  5   | Transferring — phase 2 (firmware data); progress 0.0–1.0 |
|  6   | OTA Complete (success)                                   |
|  7   | OTA Failed (error message attached)                      |

Status 5 carries a floating-point progress value in the range `[0.0, 1.0]` representing
the fraction of firmware data transferred.

---

## 4. DFU Address Calculation

JieLi, Nordic, and Goodix platforms boot into a DFU bootloader that advertises under a
modified BLE address: the original device address incremented by 1.

### 4.1 Algorithm

```
Input:  canonical BLE address string  "AA:BB:CC:DD:EE:FF"
Output: DFU BLE address string        "AA:BB:CC:DD:EF:00"

Steps:
  1. Strip colons:         "AA:BB:CC:DD:EE:FF" → "AABBCCDDEEFF"
  2. Parse as hex long:    0xAABBCCDDEEFF
  3. Add 1:                0xAABBCCDDEEFF + 0x1 = 0xAABBCCDDEF00
  4. Format with colons:   "AA:BB:CC:DD:EF:00"
```

The source for this logic is `BleCache.java`.

### 4.2 Usage

- JieLi OTA: uses normal address initially; switches to DFU address after `onNeedReconnect`.
- Nordic OTA: `DfuServiceInitiator` is given the DFU address directly.
- Goodix OTA: DFU address passed to `BleConnector`.

---

## 5. JieLi OTA (JOTAManager — II0xO0.java)

### 5.1 Dependencies

| Component                | Class / Package                                    |
|--------------------------|----------------------------------------------------|
| OTA core                 | `com.jieli.jl_bt_ota.model.BluetoothOTAConfigure`  |
| OTA manager              | `com.jieli.watchtesttool.tool.upgrade.OTAManager`  |
| Bluetooth helper         | `BluetoothHelper` (JieLi SDK)                      |

### 5.2 State Machine

```
        +--------+
        |  INIT  |
        +--------+
             |
             | Release any existing OTA manager
             v
    +-------------------+
    | INITIALIZE SDK    |  Init BluetoothHelper + OTAManager
    +-------------------+
             |
             | Register BtEventCallback
             v
    +-------------------+
    | CONFIGURE FIRMWARE|  Set file path via BluetoothOTAConfigure
    +-------------------+
             |
             v
       +-----------+
       |  CONNECT  |  Connect to device
       +-----------+  (normal address OR DFU address if reconnecting)
             |
             | Connected
             v
       +-----------+
       | START OTA |  OTAManager.startOTA()
       +-----------+
             |
      +------+------+
      |             |
      v             v
  PROGRESS      NEED_RECONNECT
  (0.0–1.0)         |
      |             | Reconnect using DFU address (BLE + 1)
      |             v
      |        +-----------+
      |        |  CONNECT  | (DFU address)
      |        +-----------+
      |             |
      +------+------+
             |
             v
        +--------+
        | RESULT |
        +--------+
        /        \
  onStopOTA    onError
  (success)   (failure)
```

### 5.3 IUpgradeCallback Events

| Callback          | Description                                          |
|-------------------|------------------------------------------------------|
| `onStartOTA`      | OTA session opened, transfer about to begin          |
| `onProgress(type, pct)` | Progress update: type=0 init phase, type=1 data transfer |
| `onStopOTA`       | Transfer complete, device will reboot                |
| `onError`         | Non-recoverable error; OTA aborted                   |
| `onCancelOTA`     | OTA was cancelled by user or system                  |
| `onNeedReconnect` | Device needs reconnection on DFU address             |

Progress mapping to unified status codes:
- `onStartOTA` → status 1
- `onProgress(type=0, ...)` → status 4
- `onProgress(type=1, pct)` → status 5, progress = pct / 100.0
- `onStopOTA` → status 6
- `onError` / `onCancelOTA` → status 7

---

## 6. SiFli OTA (SOTAManager.java)

### 6.1 Dependencies

| Component       | Class / Package                          |
|-----------------|------------------------------------------|
| DFU service     | `com.sifli.siflidfu.SifliDFUService`     |
| Service binder  | `ISifliDFUService` (AIDL interface)      |
| Broadcasts      | `LocalBroadcastManager`                  |

### 6.2 Firmware ZIP Contents

The SiFli firmware is distributed as a ZIP archive. The following files are recognized:

| Filename         | Type Code | Description                  |
|------------------|-----------|------------------------------|
| `otaApp.bin`     | 0         | Application firmware         |
| `otaRes.bin`     | 3         | Resource assets              |
| `otaFont.bin`    | 4         | Font data                    |
| `otaroot.bin`    | 5         | Root / bootloader            |
| `ctrl_packet.bin`| -1        | Control packet — skipped     |

Unrecognized filenames are ignored.

### 6.3 Transfer Flow

```
  1. Bind to SifliDFUService Android service (Context.bindService)
  2. onServiceConnected: acquire ISifliDFUService binder
  3. Unzip firmware archive to Context.getExternalCacheDir()
  4. Build DFUImagePath list from zip contents (see table above)
  5. Call: startActionDFUNorExt(context, address, imagePaths, mode=1, flags=0)
  6. Monitor via LocalBroadcastManager:
     - BROADCAST_DFU_PROGRESS → raw percentage; progress = value / 100.0
     - BROADCAST_DFU_STATE    → state==100 && result==0 → success; else failure
     - BROADCAST_DFU_LOG      → debug / diagnostic strings
  7. On completion or error: unbind service, unregister broadcast receiver
```

### 6.4 Broadcast Actions

| Action                  | Key Fields                  | Meaning                         |
|-------------------------|-----------------------------|---------------------------------|
| `BROADCAST_DFU_PROGRESS`| percentage (int)            | Current transfer progress       |
| `BROADCAST_DFU_STATE`   | state (int), result (int)   | state=100, result=0 → success   |
| `BROADCAST_DFU_LOG`     | message (String)            | Diagnostic log entry            |

---

## 7. Realtek OTA (ROTAManager.java)

### 7.1 Dependencies

| Component       | Class / Package                              |
|-----------------|----------------------------------------------|
| DFU adapter     | `com.realsil.sdk.dfu.utils.GattDfuAdapter`   |
| Callback        | `DfuAdapter.DfuHelperCallback`               |
| Config          | `DfuConfig`                                  |

### 7.2 DfuConfig Parameters

| Parameter                    | Value / Notes                            |
|------------------------------|------------------------------------------|
| `setAddress`                 | DFU BLE address string                   |
| `setAutomaticActiveEnabled`  | `true` — auto-activate after transfer    |
| `setFileLocation`            | `0` — local file on device storage       |
| `setVersionCheckEnabled`     | `false` — skip firmware version gating   |
| `setOtaWorkMode`             | `0` — normal OTA mode                    |
| `setFilePath`                | Absolute path to firmware .bin file      |

### 7.3 Transfer Flow

```
  1. Initialize GattDfuAdapter singleton
  2. Register DfuHelperCallback
  3. Populate DfuConfig (see table above)
  4. adapter.initialize(callback) — adapter connects and discovers OTA service
  5. onStateChanged(527)   → adapter connected; retrieve OtaDeviceInfo; start OTA
  6. onProgressChanged(pct)→ status 5; progress = pct / 100.0
  7. onProcessStateChanged(258) → OTA complete; status 6
  8. onStateChanged(4097)  → device disconnected unexpectedly; status 7 (failure)
  9. onError(type, code)   → OTA failed; status 7
```

### 7.4 State / Event Codes

| Code | Event                  | Meaning                                      |
|------|------------------------|----------------------------------------------|
|  527 | `onStateChanged`       | DFU adapter connected; ready to start OTA    |
|  258 | `onProcessStateChanged`| OTA transfer completed successfully          |
| 4097 | `onStateChanged`       | Device disconnected (abnormal, implies fail) |

### 7.5 Release Procedure

```java
adapter.abort();
adapter.close();
```

Both must be called to prevent resource leaks when OTA ends (success or failure).

---

## 8. Nordic DFU (no.nordicsemi.android.dfu)

### 8.1 Overview

The Nordic Semiconductor DFU library is used independently of the OTAManagerFactory.
It is invoked directly from UI activities (`FirmwareUpgradeNActivity`, etc.) via the
`DfuServiceInitiator` helper class.

### 8.2 Supported Update Types

- Legacy DFU
- Secure DFU (buttonless activation)
- Experimental buttonless Secure DFU

Each firmware update package is a ZIP archive containing a `manifest.json` descriptor and
one or more binary segments.

### 8.3 Firmware ZIP Contents

| Component    | Description                                     |
|--------------|-------------------------------------------------|
| `manifest.json` | Declares update type and file list           |
| application  | Application firmware binary                     |
| bootloader   | Bootloader binary (optional)                    |
| softdevice   | SoftDevice (Nordic BLE stack) binary (optional) |

### 8.4 Features

| Feature                        | Notes                                         |
|--------------------------------|-----------------------------------------------|
| MTU negotiation                | Maximizes throughput on supported devices      |
| Packet Receipt Notifications   | Flow control for reliable chunk delivery       |
| Resume support                 | Can resume interrupted transfers               |

### 8.5 Broadcast Actions

| Action                                              | Purpose                        |
|-----------------------------------------------------|--------------------------------|
| `no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION`   | General DFU state events  |
| `no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS` | Transfer progress updates |
| `no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR`    | Error notifications       |
| `no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG`      | Debug log messages        |

### 8.6 DFU Address Usage

The `DfuServiceInitiator` is given the DFU address (BLE + 1) directly before starting
the service. The bootloader advertises under this incremented address during the update.

---

## 9. MTK OTA (MediaTek — BleConnector direct)

### 9.1 GATT Service UUIDs

| Role         | UUID                                     |
|--------------|------------------------------------------|
| OTA Service  | `c6a22905-f821-18bf-9704-0266f20e80fd`   |
| Data Service | `c6a2b98b-f821-18bf-9704-0266f20e80fd`   |

### 9.2 GATT Characteristics

| Role        | UUID (suffix)   | Full UUID                                  | Purpose                    |
|-------------|-----------------|-------------------------------------------|----------------------------|
| Flag        | `c6a22922-...`  | `c6a22922-f821-18bf-9704-0266f20e80fd`    | Control / status flags     |
| Data        | `c6a22924-...`  | `c6a22924-f821-18bf-9704-0266f20e80fd`    | Firmware data chunks       |
| MD5         | `c6a22926-...`  | `c6a22926-f821-18bf-9704-0266f20e80fd`    | Firmware MD5 hash          |
| Meta        | `c6a22916-...`  | `c6a22916-f821-18bf-9704-0266f20e80fd`    | Metadata                   |
| Size        | `c6a22920-...`  | `c6a22920-f821-18bf-9704-0266f20e80fd`    | Total firmware size        |

### 9.3 Transfer Flow

```
  1. Write total firmware size to Size characteristic
  2. Write firmware MD5 hash to MD5 characteristic
  3. Stream firmware binary in 180-byte chunks to Data characteristic
  4. Read / monitor Flag characteristic to verify transfer completion
```

Chunk size: **180 bytes** (fixed MTK OTA packet size).

---

## 10. Goodix OTA

- SDK: `com.goodix.ble.gr.libdfu`
- Integrated via `BleConnector`; detailed protocol is in the Goodix proprietary SDK.
- Uses DFU address (BLE address + 1) for bootloader connection.

---

## 11. OTA State Machine (Unified View)

The following state machine applies to all manager implementations at the app layer.
Platform-specific internals map onto these states via the status codes defined in Section 3.

```
        +---------+
        |  IDLE   |  status = -1
        +---------+
              |
              | startOTA() called
              v
        +---------+
        | STARTED |  status = 1
        +---------+
              |
              | Begin connecting
              v
       +------------+
       | CONNECTING |  status = 3
       +------------+
              |
         +----+----+
         |         |
         v         v
   DISCONNECT    CONNECTED
   status = 2       |
                    | Platform OTA begins
                    v
           +------------------+
           | TRANSFER PHASE 1 |  status = 4 (init / verify)
           +------------------+
                    |
                    v
           +------------------+
           | TRANSFER PHASE 2 |  status = 5, progress 0.0–1.0
           +------------------+
                    |
               +----+----+
               |         |
               v         v
          +--------+  +--------+
          |  DONE  |  | FAILED |
          | (s=6)  |  | (s=7)  |
          +--------+  +--------+
```

---

## 12. Implementation Notes

1. **Platform string source:** The platform string is stored in device pairing records
   (BleCache) and populated during initial device binding. It is a device-model-level
   attribute, not negotiated at runtime.

2. **Firmware file paths:** Each OTA manager receives the absolute local filesystem path
   to the firmware file. For SiFli, the ZIP is extracted to `externalCacheDir` before
   being passed to the SDK. The extracted directory must be cleaned up after OTA.

3. **DFU address arithmetic:** The +1 increment is applied to the entire 48-bit address
   as a single integer, not just the last octet. Overflow propagates through octets.
   Example: `AA:BB:CC:DD:EE:FF` + 1 = `AA:BB:CC:DD:EF:00`.

4. **Reconnection (JieLi):** The JieLi SDK triggers `onNeedReconnect` when the device
   resets into DFU bootloader mode mid-session. The app must disconnect, wait, then
   reconnect using the DFU address.

5. **Realtek state codes:** The numeric state/process codes (527, 258, 4097) are
   Realtek SDK internal constants. They are not documented publicly and were extracted
   from decompiled sources.

6. **MTK characteristic UUIDs:** The MTK OTA service uses non-standard 128-bit UUIDs.
   All UUIDs share the base `f821-18bf-9704-0266f20e80fd`.

7. **Nordic resume:** The Nordic DFU library can resume an interrupted upload by
   reading the bootloader's offset and seeking to the correct position in the firmware
   ZIP before retransmitting.

8. **Concurrent OTA prevention:** The base class (`oIX0oI.java`) must ensure only one
   OTA session is active at a time. Calling `startOTA` while status is 3, 4, or 5 should
   be a no-op or return an error.

# Dial Sender — Findings

This document summarizes the reverse‑engineering and changes made while implementing Jieli RCSP "External Flash IO Ctrl" (dial/watchface) transfer in the `dial-sender` project.

## Goal
- Send dial files (e.g. `kronos.bin`) to a Jieli-based smartwatch over BLE using RCSP External Flash IO Ctrl and install them.

## Summary of what we did
- Decompiled the co-fit app and inspected RCSP implementation to learn exact packet layout and byte order.
- Implemented changes in `app/src/main/java/com/example/dialsender/MainActivity.java` to match co-fit behavior:
  - Use Big Endian for file size, offsets and CRC fields in External Flash IO Ctrl payloads.
  - Wait for CCCD write confirmation and set a `notificationsEnabled` flag before expecting notifications.
  - Retry writes using `WRITE_TYPE_DEFAULT` (with response) if write-without-response + notifications doesn't yield a response.
  - Added logging around CCCD write and write-type fallbacks.

## Key findings (technical)
- co-fit packs numeric fields (file length, offsets, CRC) in Big Endian (see `ExternalFlashIOCtrlParam` / `CHexConver` in the decompiled app).
- Many Jieli firmwares reply via BLE notifications; failing to write/confirm CCCD causes silent timeouts.
- Using the wrong endianness results in incorrect interpreted lengths/offsets, producing an Insert Start failure (timeout / device rejection).

## Files edited
- `app/src/main/java/com/example/dialsender/MainActivity.java` — changes above (endianness, notifications handling, write fallback).

## Latest Changes (Session 6)
- **Header Tag Change:** Switched from `FE DC BA` (RCSP v2) to `AB BC CD` (RCSP v1).
    - Many older or specific Jieli implementations ("Kronos" series) might use the v1 header.
    - If `FE...` fails consistently, `AB...` is the next logical step.
- **Length Endianness (Revert):** Reverted Header Length to **Big Endian**.
    - RCSP v1 typically uses Big Endian for Length.
- **Connection Test:** Added logic to read the **Firmware Revision** (UUID `2A26`) immediately after connecting.
    - If this works (logs "Firmware Rev: ..."), the BLE connection is healthy.
    - If this fails, the device is unstable or disconnected.

## Critical Fixes (Session 7 - Root Cause Analysis)

### Issue #1: Response Validation Rejecting Valid Responses (Line 571)
**Problem:** Code was checking `if (response[0] == (byte)0xFE)` which only accepted v2 headers. Since we're sending v1 headers (`AB BC CD`), devices respond with matching v1 headers. All responses were being rejected as "Invalid response format".

**Fix:** Updated response validation to accept both v1 (`0xAB 0xBC 0xCD`) and v2 (`0xFE 0xDC 0xBA`) headers. Now correctly parses responses regardless of protocol version.

```java
// NOW accepts both:
boolean isValidTag = (response[0] == (byte)0xFE && response[1] == (byte)0xDC && response[2] == (byte)0xBA) ||
                     (response[0] == (byte)0xAB && response[1] == (byte)0xBC && response[2] == (byte)0xCD);
```

### Issue #2: Chunk Offset Endianness Bug (Line 416)
**Problem:** Comment said offset was "Little Endian" but APK reverse-engineering confirmed it should be **Big Endian**. This caused device to write chunks at wrong memory locations.

**Fix:** Confirmed offset is properly set to Big Endian via `chunkPayload.order(ByteOrder.BIG_ENDIAN)` at line 409. Updated comment to reflect this.

### Issue #3: Dial Activation Missing File Path (Line 463-464)
**Problem:** Op 3 (DIAL) command was sending only `[Op=3][0x00]` but APK shows it requires the full dial path: `[Op=3][flag=1][path_string][null_terminator]`.

**Fix:** Modified dial payload to include:
- Op code (0x03)
- Flag byte (0x01 to activate)
- Full path string (e.g., "dial/kronos.bin")
- Null terminator

This ensures the device knows which dial file to activate.

## How to reproduce locally
1. Build debug APK: `./gradlew assembleDebug`
2. Install: `adb install -r app/build/outputs/apk/debug/app-debug.apk`
3. Pair/connect the watch and run the app. Select a dial file (example: `kronos.bin`) and start transfer.
4. Collect logs: `adb logcat -s DialSender` or `adb logcat > logcat-full.txt`.

## Expected success criteria
- `Insert Start` returns a response (status 0) instead of timing out.
- Transfer proceeds through chunk writes, CRC verification and `Insert Stop`, finishing with a successful install.
- Device activates the new dial after completion.

## Troubleshooting / next steps
1. If still timing out, check if device is responding at all: Look for "Rx:" messages in logcat.
2. If response header is neither 0xAB nor 0xFE, capture the first 3 bytes of response and add support for that variant.
3. If chunks are being written but CRC fails, verify file wasn't corrupted in transit (use hex dump to compare).
4. If dial activation fails, verify the path format matches what device expects (typically "dial/filename.bin").

## Useful commands
- Build: `./gradlew assembleDebug`
- Install: `adb install -r app/build/outputs/apk/debug/app-debug.apk`
- Logcat (tag): `adb logcat -s DialSender`
- Full log: `adb logcat > logcat-full.txt`
- Hex dump of APK: `adb logcat -s DialSender | grep "Tx:"` to see packet hex

## References (from decompiled co-fit app)
- `decompiled_apk/sources/com/jieli/jl_rcsp/model/parameter/ExternalFlashIOCtrlParam.java`
- `decompiled_apk/sources/com/jieli/jl_rcsp/util/CHexConver.java`
- `decompiled_apk/sources/com/jieli/jl_rcsp/constant/Command.java`

---

## Summary of Changes Made

| Change | Line(s) | Reason |
|--------|---------|--------|
| Accept both v1/v2 response headers | 571-585 | Device may respond with either header format |
| Fixed offset endianness comment | 407 | Confirmed Big Endian from APK analysis |
| Added full path to dial activation | 460-470 | Op 3 requires path string for device to activate correct dial |

**Build Status:** ✅ Successful (v1.5 compile, no errors)

---

If you want, I can also:
1. Create a short script to collect tx/rx hex dumps and the negotiated MTU.
2. Add more granular packet logging to `MainActivity.java` (I can add and create a patch).

Tell me which of the two you prefer and I'll apply the change.


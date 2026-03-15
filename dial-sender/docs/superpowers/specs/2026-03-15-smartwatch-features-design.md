# Smartwatch App — Feature Design Spec
**Date:** 2026-03-15
**Status:** Approved
**Areas:** Background image crop, GIF/video animation frames, Sleep monitoring, BLE session persistence, Notification management

---

## 1. Background Image — Crop/Drag (No Deformation)

### Problem
`addBackgroundLayer(Bitmap bmp, int elementType)` calls `Bitmap.createScaledBitmap(bmp, 466, 466, true)` when `elementType == TYPE_BACKGROUND`, forcibly stretching the image to 466×466 regardless of aspect ratio.

### Solution
- Remove the forced `createScaledBitmap` stretch
- Apply `scaleToCover = Math.max(canvasWidth / w, canvasHeight / h)` to fill the canvas without distortion
- Import background as `layer.locked = false` so the existing drag/transform system allows repositioning
- Add a "Lock background" button in the layers panel to fix it once framed
- Compilation: canvas renders at 466×466 using the existing `Matrix + postTranslate` pipeline; anything outside bounds is naturally clipped

### Files affected
- `DialEditorActivity.java` — `addBackgroundLayer(Bitmap, int)` method
- `res/layout/activity_dial_editor.xml` — add lock button to layers panel

---

## 2. GIF/Video Animation Frames

### Goal
Allow users to import animated GIFs or video clips as watch face background layers. Frames are compiled into the `.bin` file and transferred to the watch.

### Flow
1. New "Add animation" button in layer menu alongside "Add image"
2. Intent picker accepts `image/gif` and `video/*`
3. **GIF decoding**: `ImageDecoder.decodeDrawable()` → `AnimatedImageDrawable` → draw each frame at interval into a `Bitmap[]`
4. **Video decoding**: `MediaMetadataRetriever` → extract frames at configurable interval (100ms / 200ms / 500ms) up to 30 frames max
5. Frame extraction dialog shows: source duration, frame count preview, interval selector
6. Frames stored in `layer.frames[]` with `layer.nativeElementType = TYPE_BACKGROUND`
7. Compiler treats multi-frame background as animated block (already supported by `block.frames` field)
8. Editor preview shows frame 0 with badge "N frames"

### Constraints
- Max 30 frames to prevent memory exhaustion and oversized `.bin`
- Min API 28 for `ImageDecoder` (already targeted by project)
- No new library dependencies

### Files affected
- `DialEditorActivity.java` — new `importAnimation()` method, updated layer menu
- `DialCompiler.java` — verify multi-frame background block compilation (likely already works)
- `res/layout/activity_dial_editor.xml` — animation button
- New `res/layout/dialog_frame_picker.xml` — interval/frame count dialog

---

## 3. Sleep Monitoring — Fix + Phase Breakdown

### Problem
Current storage saves `soft + strong` (motion intensity values), not sleep duration. `MODE_START` and `MODE_END` markers are discarded. Result is always 0 or meaningless.

### Solution

**Storage format change** in `BleManager.java`:
Each record: `timestamp:mode:soft:strong` comma-separated in SharedPreferences key `health_sleep`.

**New class `SleepAnalyzer`**:
- Parse records sorted by timestamp
- `MODE_START (17)` opens a session
- `MODE_END (34)` closes session → duration = `end_ts - start_ts`
- Between start/end: accumulate spans per mode
  - `DEEP (1)` → deep sleep minutes
  - `LIGHT (2)` → light sleep minutes
  - `REM (9)` → REM minutes
  - `AWAKE (3)` → awake minutes
- Returns: `{ totalMinutes, deepMin, lightMin, remMin, awakeMin }` for last sleep session

**HomeFragment**: show total hours + sub-label `"P: Xh Ym · L: Xh · REM: Xm"`

**StatusFragment**: new sleep card with color-coded phase bars using existing MPAndroidChart `BarChart`

### Files affected
- `BleManager.java` — update sleep record storage format
- New `SleepAnalyzer.java` — session calculation logic
- `HomeFragment.java` — update sleep display
- `StatusFragment.java` — new sleep phase card

---

## 4. BLE Session Persistence (Foreground Service)

### Goal
Keep the BLE connection alive when the app is backgrounded or closed.

### Solution

**New class `BleForegroundService extends Service`**:
- Calls `startForeground(NOTIF_ID, notification)` immediately on `onStartCommand`
- Notification shows: app icon, "Reloj conectado" / "Desconectado", action button "Desconectar"
- `onStartCommand` returns `START_STICKY` (Android restarts if killed)
- Owns the `BleManager.getInstance()` lifecycle — BleManager stays alive as long as Service runs
- Auto-reconnect loop: if `BleManager` disconnects, retry every 30s using `lastDeviceAddress` saved in SharedPreferences

**MainActivity integration**:
- On successful BLE connect: `startForegroundService(Intent(BleForegroundService))`
- `bindService()` for UI updates
- On explicit disconnect: `stopService()`

**AndroidManifest additions**:
- `<uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>`
- `<uses-permission android:name="android.permission.FOREGROUND_SERVICE_CONNECTED_DEVICE"/>` (API 34+)
- `<service android:name=".ble.BleForegroundService" android:foregroundServiceType="connectedDevice"/>`

### Files affected
- New `ble/BleForegroundService.java`
- `MainActivity.java` — startForegroundService on connect, stopService on disconnect
- `AndroidManifest.xml` — service declaration + permissions
- `BleManager.java` — expose `getLastDeviceAddress()`, add `reconnect(address)` method

---

## 5. Notification Management

### Goal
Forward phone notifications to the watch. User can configure which apps are forwarded.

### Solution

**New class `WatchNotificationService extends NotificationListenerService`**:
- `onNotificationPosted(sbn)`:
  1. Check if `BleManager.isSessionReady()`
  2. Get `packageName` from `sbn`
  3. Check if package is in whitelist (SharedPreferences `notif_enabled_packages`)
  4. Extract `title` (max 32 chars) and `text`/`bigText` (max 250 chars)
  5. Detect `Notification.CATEGORY_CALL` → `category = 1`, else `category = 127`
  6. Build payload per protocol: `[category:1B][BleTime:7B][package:32B][title:32B][content:250B]`
  7. Send via `BleManager.sendNotification(payload)`

**New `NotificationSettingsActivity`**:
- Loads all installed apps with launcher intent
- Shows app name, icon, toggle switch
- Persists enabled set to SharedPreferences as comma-separated package names
- Top banner: checks `NotificationListenerService` permission; if missing, shows "Grant permission" button → `Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS`

**DeviceFragment**: new row "Notificaciones →" opens `NotificationSettingsActivity`

**AndroidManifest additions**:
- `<service android:name=".WatchNotificationService" android:permission="android.permission.BIND_NOTIFICATION_LISTENER_SERVICE" android:exported="true">` with `<intent-filter action="android.service.notification.NotificationListenerService"/>`

**BleManager additions**:
- New `sendNotification(byte[] payload)` method: builds frame with `BleKey.NOTIFICATION`, `BleKeyFlag.CREATE`, sends via command queue

### Files affected
- New `WatchNotificationService.java`
- New `NotificationSettingsActivity.java`
- New `res/layout/activity_notification_settings.xml`
- New `res/layout/item_app_notif.xml`
- `fragments/DeviceFragment.java` — add notifications row
- `BleManager.java` — `sendNotification()` method
- `AndroidManifest.xml` — service + meta-data

---

## Architecture Summary

```
BleForegroundService (START_STICKY)
  └── BleManager (singleton, lives in Service)
        ├── BleParser / BleMessenger
        ├── sendNotification() ← WatchNotificationService
        └── syncHealth() → SleepAnalyzer

WatchNotificationService (NotificationListenerService)
  └── reads whitelist from SharedPrefs
  └── calls BleManager.sendNotification()

DialEditorActivity
  └── addBackgroundLayer() — scaleToCover, unlocked drag
  └── importAnimation() — GIF/video → frames[]
  └── DialCompiler — multi-frame background block (existing)
```

---

## Testing Checklist
- [ ] Import landscape photo → fills canvas without stretch, drag repositions correctly
- [ ] Import portrait photo → fills canvas without stretch
- [ ] Import GIF → frames extracted, badge shows count, compiles to .bin
- [ ] Import video → frame interval dialog works, max 30 frames enforced
- [ ] Sync health → sleep shows total + deep/light/REM breakdown
- [ ] Close app → Service keeps running, watch stays connected
- [ ] Reconnect after Bluetooth off/on → auto-reconnects within 30s
- [ ] Notification arrives on phone → appears on watch (whitelisted app)
- [ ] Non-whitelisted app → notification NOT forwarded
- [ ] Grant notification permission flow works end-to-end

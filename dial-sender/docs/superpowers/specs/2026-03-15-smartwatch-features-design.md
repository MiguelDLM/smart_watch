# Smartwatch App — Feature Design Spec
**Date:** 2026-03-15
**Status:** Approved
**Areas:** Background image crop, GIF/video animation frames, Sleep monitoring, BLE session persistence, Notification management

---

## 1. Background Image — Crop/Drag (No Deformation)

### Problem
`addBackgroundLayer(Bitmap bmp, int elementType)` (the two-arg overload, lines ~1604-1641) calls `Bitmap.createScaledBitmap(bmp, 466, 466, true)` when `elementType == TYPE_BACKGROUND`, forcibly stretching to 466×466. The single-arg overload `addBackgroundLayer(Bitmap bmp)` already does `scaleToCover` correctly — it must NOT be changed.

### Solution
- In the **two-arg overload only**: remove the `createScaledBitmap` stretch and apply `scaleToCover = Math.max((float)canvasWidth / bmp.getWidth(), (float)canvasHeight / bmp.getHeight())`
- Both overloads must set `layer.locked = false` (currently hardcoded `true` on lines 1598 and 1639 — this is a deliberate reversal) so the existing drag/transform system allows repositioning immediately after import
- Add a "Lock background" toggle button in the layers panel — tapping it sets `layer.locked = true` for the selected background layer
- Compilation: canvas renders at 466×466 using the existing `Matrix + postTranslate` pipeline; content outside bounds is naturally clipped

### Files affected
- `DialEditorActivity.java` — fix two-arg `addBackgroundLayer(Bitmap, int)`, change `layer.locked = true` → `false` in both overloads
- `res/layout/activity_dial_editor.xml` — add lock toggle to layers panel

---

## 2. GIF/Video Animation Frames

### Goal
Allow users to import animated GIFs or video clips as watch face background layers. Frames are compiled into the `.bin` file and transferred to the watch.

### Flow
1. New "Add animation" button in layer menu alongside "Add image"
2. Intent picker accepts `image/gif` and `video/*`
3. **GIF decoding** — `AnimatedImageDrawable` has no frame-iteration API, so use a render-loop approach:
   - Decode with `ImageDecoder` to get an `AnimatedImageDrawable`
   - Get frame count and per-frame durations via `ImageDecoder.Source` intrinsics (API 31+) OR fall back to using `Movie` (deprecated but available API 28-30) to get frame count and seek per frame
   - For API 28-30: use `android.graphics.Movie` — `movie.setTime(frameTime)`, `movie.draw(canvas, 0, 0)` per frame
   - For API 31+: use `ImageDecoder` with frame index access
   - Cap at 30 frames regardless of source length
4. **Video decoding**: `MediaMetadataRetriever` → `getFrameAtTime(timeUs, OPTION_CLOSEST)` at configurable interval (100ms / 200ms / 500ms) up to 30 frames max
5. Frame extraction dialog shows: source duration, estimated frame count, interval selector
6. Frames stored in `layer.frames[]` with `layer.nativeElementType = TYPE_BACKGROUND`
7. **Compiler fix required**: in `buildBlocks()`, the `TYPE_BACKGROUND` branch hardcodes `block.frames = 1` (line ~1996). Must change to `block.frames = layer.frames.length` and render each frame separately into the canvas loop, not just `frames[0]`
8. Editor preview shows frame 0 with badge "N frames"

### Constraints
- Max 30 frames to prevent memory exhaustion and oversized `.bin`
- GIF: API 28-30 uses `android.graphics.Movie`; API 31+ uses `ImageDecoder` frame index
- No new library dependencies

### Files affected
- `DialEditorActivity.java` — new `importAnimation()` method, updated layer menu
- `DialCompiler.java` — fix `block.frames = 1` hardcode in TYPE_BACKGROUND branch; add multi-frame render loop
- `res/layout/activity_dial_editor.xml` — animation button
- New `res/layout/dialog_frame_picker.xml` — interval/frame count dialog

---

## 3. Sleep Monitoring — Fix + Phase Breakdown

### Problem
Current storage saves `soft + strong` (motion intensity values), discarding `mode`, `MODE_START`, and `MODE_END` markers. Result displayed is always 0 or meaningless.

### Endianness note
`BleManager.parseAndStoreHealthData()` uses `ByteBuffer` default (big-endian) for all health records. The watch sends sleep data big-endian. `BleSleep.java` declares `LITTLE_ENDIAN` but is not used in the parse path — ignore it; the BleManager parse path is correct.

### Solution

**Storage format change** in `BleManager.java`, `HEALTH_KEY_SLEEP` branch:
Each record stored as `timestamp:mode:soft:strong`, comma-separated in SharedPreferences key `health_sleep`. Example: `1741234567:17:0:0,1741234900:1:3:12,1741235100:34:0:0`

**New class `SleepAnalyzer`** (package `com.example.dialsender.ble`):
- Parse records sorted by timestamp
- `MODE_START (17)` opens a session
- `MODE_END (34)` closes session → `totalMinutes = (end_ts - start_ts) / 60`
- Between start/end, accumulate spans per mode (duration = next_record_ts - current_ts):
  - `DEEP (1)` → `deepMin`
  - `LIGHT (2)` → `lightMin`
  - `REM (9)` → `remMin`
  - `AWAKE (3)` → `awakeMin`
  - `PIECEMEAL (8)` → map to `lightMin` (fragmented light sleep)
- Returns `SleepResult { totalMinutes, deepMin, lightMin, remMin, awakeMin }` for last sleep session

**HomeFragment**: show total hours + sub-label `"D: Xh Ym · L: Xh · REM: Xm"` (D=Deep/Profundo, L=Light/Ligero)

**StatusFragment**: new sleep card with color-coded phase bars using existing MPAndroidChart `BarChart`

### Files affected
- `BleManager.java` — update sleep record storage format in `HEALTH_KEY_SLEEP` branch
- New `ble/SleepAnalyzer.java` — session calculation logic
- `HomeFragment.java` — update sleep display
- `StatusFragment.java` — new sleep phase card

---

## 4. BLE Session Persistence (Foreground Service)

### Goal
Keep the BLE connection alive when the app is backgrounded or closed.

### Solution

**New class `ble/BleForegroundService extends Service`**:
- `onCreate()`: create `NotificationChannel` (required API 26+, channel id `"ble_connection"`)
- `onStartCommand()`: call `startForeground(NOTIF_ID, buildNotification())` immediately; return `START_STICKY`
- Notification shows: app icon, "Reloj conectado" / "Desconectado", action button "Desconectar"
- Owns the `BleManager.getInstance()` lifecycle — BleManager stays alive as long as Service runs
- Auto-reconnect loop: `Handler.postDelayed()` every 30s; if `!BleManager.isSessionReady()` and `lastDeviceAddress != null`, call `BleManager.reconnect(address)`

**BleManager additions**:
- Save device address to SharedPreferences on every successful `onConnectionStateChange(CONNECTED)`: `prefs.edit().putString("last_device_address", device.getAddress()).apply()`
- `public String getLastDeviceAddress()` — reads from prefs
- `public void reconnect(String address)` — calls `connectToDevice(address)` if not already connecting

**MainActivity integration**:
- On successful BLE session ready: `startForegroundService(new Intent(this, BleForegroundService.class))`
- `bindService()` for UI updates
- On explicit disconnect: `stopService(new Intent(this, BleForegroundService.class))`

**AndroidManifest additions**:
```xml
<uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>
<uses-permission android:name="android.permission.FOREGROUND_SERVICE_CONNECTED_DEVICE"/>
<uses-permission android:name="android.permission.POST_NOTIFICATIONS"/>
<service
    android:name=".ble.BleForegroundService"
    android:foregroundServiceType="connectedDevice"
    android:exported="false"/>
```

### Files affected
- New `ble/BleForegroundService.java`
- `MainActivity.java` — startForegroundService on session ready, stopService on disconnect
- `AndroidManifest.xml` — service declaration + 3 permissions
- `BleManager.java` — save address on connect, `getLastDeviceAddress()`, `reconnect()`

---

## 5. Notification Management

### Goal
Forward phone notifications to the watch. User can configure which apps are forwarded.

### Solution

**New class `ble/WatchNotificationService extends NotificationListenerService`**:
- `onNotificationPosted(sbn)`:
  1. Check `BleManager.isSessionReady()`
  2. Get `packageName` from `sbn`
  3. Check whitelist (SharedPreferences `notif_enabled_packages`, comma-separated)
  4. Extract `title` (max 32 chars) and `text`/`bigText` (max 250 chars)
  5. Detect `Notification.CATEGORY_CALL` → `category = 1`, else `category = 127`
  6. Build payload: `[category:1B][timestamp:4B LE][package:32B null-padded][title:32B null-padded][content:250B null-terminated]`
     - Timestamp: seconds since 2000-01-01 (same epoch as all other health data), 4 bytes little-endian
  7. Send via `BleManager.sendNotification(payload)`

**New `NotificationSettingsActivity`** (package `com.example.dialsender`):
- Loads all installed apps with launcher intent via `PackageManager`
- Shows app name, icon, toggle switch per app
- Persists enabled set to SharedPreferences as comma-separated package names key `notif_enabled_packages`
- Top banner: checks `NotificationManagerCompat.getEnabledListenerPackages()` — if not granted, shows "Conceder permiso" button → `Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS`

**DeviceFragment**: new list row "Notificaciones →" → opens `NotificationSettingsActivity`

**AndroidManifest additions**:
```xml
<service
    android:name=".ble.WatchNotificationService"
    android:permission="android.permission.BIND_NOTIFICATION_LISTENER_SERVICE"
    android:exported="true">
    <intent-filter>
        <action android:name="android.service.notification.NotificationListenerService"/>
    </intent-filter>
    <meta-data
        android:name="android.service.notification.default_filter_types"
        android:value="conversations|alerts"/>
</service>
```

**BleManager additions**:
- `public void sendNotification(byte[] payload)`: enqueues frame built with `BleKey.NOTIFICATION`, `BleKeyFlag.CREATE` via existing command queue

### Files affected
- New `ble/WatchNotificationService.java`
- New `NotificationSettingsActivity.java`
- New `res/layout/activity_notification_settings.xml`
- New `res/layout/item_app_notif.xml`
- `fragments/DeviceFragment.java` — add notifications row
- `BleManager.java` — `sendNotification()` method
- `AndroidManifest.xml` — service declaration + meta-data

---

## Architecture Summary

```
BleForegroundService (START_STICKY, connectedDevice)
  └── BleManager (singleton, lives in Service context)
        ├── BleParser / BleMessenger
        ├── sendNotification() ← WatchNotificationService
        ├── syncHealth() → SleepAnalyzer
        ├── getLastDeviceAddress() / reconnect()
        └── saveDeviceAddress() on connect

WatchNotificationService (NotificationListenerService)
  └── reads whitelist from SharedPrefs
  └── calls BleManager.sendNotification()

DialEditorActivity
  └── addBackgroundLayer(Bitmap, int) — scaleToCover, locked=false
  └── importAnimation() — GIF (Movie/ImageDecoder) or video (MediaMetadataRetriever) → frames[]
  └── DialCompiler — multi-frame background block (block.frames fix required)

SleepAnalyzer (ble package)
  └── parses timestamp:mode:soft:strong records
  └── returns SleepResult { totalMin, deepMin, lightMin, remMin, awakeMin }
```

---

## Testing Checklist
- [ ] Import landscape photo → fills canvas without stretch, drag repositions correctly
- [ ] Import portrait photo → fills canvas without stretch
- [ ] Background lock button works — locked layer cannot be dragged
- [ ] Import GIF (API 28) → `Movie` path extracts frames, badge shows count, compiles to .bin
- [ ] Import GIF (API 31+) → `ImageDecoder` path extracts frames
- [ ] Import video → frame interval dialog works, max 30 frames enforced
- [ ] Animated .bin plays on watch (multi-frame background)
- [ ] Sync health → sleep shows total + D:/L:/REM: breakdown
- [ ] MODE_PIECEMEAL records counted in lightMin
- [ ] Close app → Service keeps running, watch stays connected, persistent notification visible
- [ ] Reconnect after Bluetooth off/on → auto-reconnects within 30s
- [ ] POST_NOTIFICATIONS granted on API 33+, notification channel exists
- [ ] Notification arrives on phone → appears on watch (whitelisted app)
- [ ] Non-whitelisted app → notification NOT forwarded
- [ ] Grant notification permission flow works end-to-end
- [ ] Call notification → category=1 sent to watch

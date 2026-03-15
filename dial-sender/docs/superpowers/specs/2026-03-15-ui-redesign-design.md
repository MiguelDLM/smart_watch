# UI Redesign — Gauges, Settings Tab & Bug Fixes Design Spec

## Goal

Redesign the Home screen with gauge-type charts per metric, move health charts behind gauge taps (bottom sheet), rename the "Salud" tab to "Ajustes/Settings" with app configuration, and fix several bugs: invisible button text, missing notification apps, SpO2 showing zero, and an invisible BLE log.

---

## Scope

Eight changes, grouped into six implementation areas:

### 1. Bug Fixes (3 bugs)

**a) Button text invisible in DeviceFragment**

Root cause: `Widget.MaterialComponents.Button` enforces `android:minHeight="48dp"` by default. The log buttons in `fragment_device.xml` set `android:layout_height="38dp"`, but the `minHeight` override forces them to render at 48dp internally while the view clips to 38dp — the text is rendered outside the visible clip region.

Fix: add `android:minHeight="0dp"` inline on both `btnCopyLog` and `btnSaveLog` in `fragment_device.xml`. This removes the Material minimum-height enforcement and lets the 38dp height take effect. No changes needed in `styles.xml`.

**b) Blood oxygen (`blood_oxygen`) always shows 0**

`StatusFragment.renderMetrics()` renders `latestToday` (an int) via `String.valueOf(latestToday)` without checking for zero (line 190). When the watch has no SpO2 measurement it sends a value of 0. Fix: in `StatusFragment.renderMetrics()`, after computing `latestToday`, check `if (latestToday == 0 && metric.equals("blood_oxygen"))` and display "—" as the value text. The same zero-guard pattern exists in `HomeFragment.refreshMetrics()` for `heart_rate` and `steps`. The preference key is `"blood_oxygen"` (element of the `METRICS` array at line 36).

**c) Missing notification apps (Facebook, Messenger, Telegram, Gmail, etc.)**

`NotificationSettingsActivity` builds `launcherApps` via a nested loop: for each `ResolveInfo` from `queryIntentActivities`, it scans all installed `ApplicationInfo` objects for a matching package name. This is O(n²) and can silently drop entries where `activityInfo.packageName` is not found in the flat `getInstalledApplications()` result (e.g., split APKs, instant apps, system-managed packages). Fix: build the list directly from `ResolveInfo.activityInfo.applicationInfo`, which is always populated by `queryIntentActivities`. Remove the nested loop entirely.

---

### 2. BLE Log Toggle

Add a toggle button in `DeviceFragment` to show/hide the BLE log `ScrollView`. State persists for the session (not to `SharedPreferences` — no need). Button label: "Ocultar log" / "Mostrar log". Button placed immediately above the log container.

---

### 3. GaugeView — Custom View

A new `GaugeView extends View` drawn with `Canvas.drawArc()`.

**Modes** (configurable via `SharedPreferences` key `gauge_style`):
- `A` (default) — semi-circle arc (180°), track + filled arc + value text centered below arc
- `B` — full donut (270°), track + filled arc
- `C` — thin ring (270°), no value overlay (value text below)

**Attributes (via XML `declare-styleable`):**
- `gv_value` float — current value (0.0–1.0 progress fraction)
- `gv_label` string — label text (e.g. "PASOS")
- `gv_valueText` string — display value (e.g. "7.2K")
- `gv_subText` string — sub-label (e.g. "meta 10K")
- `gv_color` color — arc color

**File:** `app/src/main/java/com/example/dialsender/views/GaugeView.java`
**Attrs:** `app/src/main/res/values/attrs_gauge.xml`

---

### 4. Home Screen Redesign

Replace the 2×2 metric card grid and the "Enviar carátula" quick action with gauge cards.

**Layout:**
- 2×2 `GaugeView` grid: Steps (green), Heart Rate (red), Calories (amber), SpO2 (cyan)
- 1 full-width Sleep gauge card (purple) with phase summary subtitle
- No "Enviar carátula" card

Each gauge card is clickable → opens `MetricDetailBottomSheet` for that metric.

`HomeFragment` wires up click listeners; the `GaugeView` progress fraction = `(float) latestValue / goalValue` (explicit float cast to avoid integer truncation), clamped to `[0f, 1f]`.

Goals come from `SharedPreferences`:
- Steps: `goal_steps` int, default 10000
- Calories: `goal_calories` int, default 500
- Sleep: `goal_sleep_min` int, default 480 (minutes)
- Blood oxygen: fixed denominator 100 (percent — no user-configurable goal, 98/100 = 0.98 progress)
- Heart rate: fixed denominator 200 (BPM — max reference, no goal ring; gauge displays value only, arc always at `hr/200f` clamped)

Goals are stored as `int` in SharedPreferences.

**File:** `app/src/main/res/layout/fragment_home.xml` — rewrite gauge grid, remove send-dial card
**File:** `app/src/main/java/com/example/dialsender/fragments/HomeFragment.java` — rewire metric loading + gauge updates + click listeners

---

### 5. MetricDetailBottomSheet + SleepTimelineView

**`MetricDetailBottomSheet extends BottomSheetDialogFragment`**

Opened from Home gauge tap. Created via `MetricDetailBottomSheet.newInstance(String metricKey)`. Argument bundle key: `"metric_key"`. Valid values are the strings from `StatusFragment.METRICS`: `"steps"`, `"calories"`, `"sleep"`, `"distance"`, `"heart_rate"`, `"blood_oxygen"`.

Shows:
- Metric title + current value header
- Day/Week/Month selector (reusing existing toggle logic from `StatusFragment`)
- For non-sleep metrics: `BarChart` (reuse existing rendering logic from `StatusFragment.renderMetrics()`)
- For sleep: `SleepTimelineView`
- **Sync health button** (replaces the button removed from the old `StatusFragment` tab): a row at the bottom of the bottom sheet with label "Sincronizar datos" that calls `BleManager.syncHealth()`. This preserves the sync action previously on `btnSyncHealthFromScreen`.

**`SleepTimelineView extends View`**

Horizontal segmented bar drawn with `Canvas`. Each segment = a continuous sleep-phase block drawn as a colored rectangle proportional to its duration on the time axis. Phase colors: deep=`#34D399`, light=`#22D3EE`, REM=`#BC8CFF`, awake=`#F87171`. Time axis labels below.

**Data contract:**

`SleepTimelineView` receives the raw `health_sleep` preference string (comma-separated records of `"timestamp:mode:soft:strong"`). It iterates records between the last `MODE_START` (17) and `MODE_END` (34) session, exactly as `SleepAnalyzer.analyze()` does, and draws each consecutive span as a colored segment from the previous record's timestamp to the current one.

Phase color mapping (from `BleSleep` constants):
- `MODE_DEEP` (1) → `#34D399` (green)
- `MODE_LIGHT` (2) → `#22D3EE` (cyan)
- `MODE_PIECEMEAL` (8) → `#22D3EE` (cyan, same as light)
- `MODE_REM` (9) → `#BC8CFF` (purple)
- `MODE_AWAKE` (3) → `#F87171` (red)
- `MODE_START` (17) / `MODE_END` (34) → skip (sentinel records, no segment drawn)

Gaps between records (where two consecutive timestamps are more than 30 minutes apart) are drawn as `#1a2332` (background color — "unknown").

The view does NOT call `SleepAnalyzer.analyze()`. It parses the raw string itself using the same `timestamp:mode` split logic as `SleepAnalyzer`.

**Files:**
- `app/src/main/java/com/example/dialsender/fragments/MetricDetailBottomSheet.java`
- `app/src/main/java/com/example/dialsender/views/SleepTimelineView.java`
- `app/src/main/res/layout/bottom_sheet_metric_detail.xml`

---

### 6. Settings Tab

**Rename tab:** `strings.xml` `nav_health` → "Ajustes"

**Replace `StatusFragment` with `SettingsFragment`** in `MainActivity`'s `nav_health` case. `StatusFragment` is not deleted — it is still accessible via `MetricDetailBottomSheet`.

**`SettingsFragment` content (scrollable):**

1. **Notificaciones** — row with chevron → launches `NotificationSettingsActivity`
2. **Estilo de Gauge** — radio group: A (Semi-círculo), B (Donut), C (Anillo fino). Saved to `SharedPreferences` key `gauge_style`. On change, uses `LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.example.dialsender.GAUGE_STYLE_CHANGED"))`. `HomeFragment` registers a `BroadcastReceiver` in `onResume()` and unregisters in `onPause()` via `LocalBroadcastManager`. The action string constant `ACTION_GAUGE_STYLE_CHANGED = "com.example.dialsender.GAUGE_STYLE_CHANGED"` is defined as a `public static final` in `SettingsFragment`.
3. **Unidades** — two spinners: Distancia (km / millas), Peso (kg / libras). Saved to `SharedPreferences` keys `unit_distance` (values: `"km"` / `"mi"`) and `unit_weight` (values: `"kg"` / `"lb"`).
4. **Metas diarias** — four `EditText` (inputType=number) fields, each with a static unit label to the right:
   - "Pasos" + label "pasos" — key `goal_steps`, default 10000
   - "Sueño" + label "minutos" — key `goal_sleep_min`, default 480 (user enters raw minutes, e.g. 480 for 8h)
   - "Calorías" + label "kcal" — key `goal_calories`, default 500
   - "Distancia" + label from `unit_distance` pref — key `goal_distance`, default 5
   Saved on focus lost (`OnFocusChangeListener`).

**Files:**
- `app/src/main/java/com/example/dialsender/fragments/SettingsFragment.java`
- `app/src/main/res/layout/fragment_settings.xml`
- `app/src/main/res/values/strings.xml` — update `nav_health` to "Ajustes"
- `app/src/main/res/values-es/strings.xml` — update `nav_health` to "Ajustes" (Spanish locale)
- `app/src/main/java/com/example/dialsender/MainActivity.java` — swap fragment for `nav_health`
- `app/src/main/res/menu/bottom_nav_menu.xml` — update icon to `@drawable/ic_settings` (or keep existing if no settings icon; verify available drawables)

**Note on DeviceFragment notification button:** `DeviceFragment` has an existing `btnNotificationSettings` button that also launches `NotificationSettingsActivity`. Keep it — it provides a second entry point which is fine. Do not remove it.

---

## Architecture Notes

- All `SharedPreferences` uses the existing `PREF_NAME = "dial_sender_prefs"` store.
- `GaugeView` does NOT read `SharedPreferences` in `onDraw()`. The style is set once via `setGaugeStyle(String style)` called from `HomeFragment` after reading `SharedPreferences`. `HomeFragment` calls `setGaugeStyle()` on all gauge views when the `GAUGE_STYLE_CHANGED` broadcast arrives and on `onResume()`.
- `MetricDetailBottomSheet` reuses `SleepAnalyzer` and the existing `BarChart` rendering approach — no new data layer needed.
- `SleepTimelineView` consumes the raw `health_sleep` preference string directly (same format as `SleepAnalyzer`).

## Out of Scope

- No changes to BLE protocol or data parsing.
- No changes to `DialEditorActivity`, `DialsFragment`, or `DialCompiler`.
- `StatusFragment` is kept intact (used by `MetricDetailBottomSheet`).

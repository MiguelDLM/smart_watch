# Smartwatch App — 5 Features Implementation Plan

> **For agentic workers:** REQUIRED: Use superpowers:subagent-driven-development (if subagents available) or superpowers:executing-plans to implement this plan. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Fix background image deformation, add GIF/video animation frames to watch face compiler, fix sleep monitoring with phase breakdown, add BLE foreground service for session persistence, and implement notification forwarding with per-app configuration.

**Architecture:** All 5 features are independent. BleManager (singleton) is the shared communication layer. New classes go in `com.example.dialsender.ble` or `com.example.dialsender` matching the existing package structure. The foreground service keeps BleManager alive after the app is closed.

**Tech Stack:** Java, Android SDK 34 (minSdk 24), JUnit 4 for pure-logic unit tests, `android.graphics.Movie` for GIF frame extraction (available all API levels, deprecated 33 but functional), `MediaMetadataRetriever` for video, `NotificationListenerService` for notification forwarding. Note: `ImageDecoder` has no public frame-iteration API for animated GIFs at any API level — `Movie` is used exclusively for GIF extraction.

**Spec:** `docs/superpowers/specs/2026-03-15-smartwatch-features-design.md`

---

## Chunk 1: Background Image Crop/Drag Fix

### File map
- **Modify:** `app/src/main/java/com/example/dialsender/DialEditorActivity.java`
  - `addBackgroundLayer(Bitmap bmp)` — change `layer.locked = true` → `false`
  - `addBackgroundLayer(Bitmap bmp, int elementType)` — remove stretch, add scaleToCover, change `layer.locked = true` → `false`
- **Modify:** `app/src/main/res/layout/activity_dial_editor.xml` — add lock toggle button

---

### Task 1: Fix the two-arg `addBackgroundLayer` and unlock both overloads

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/DialEditorActivity.java`

- [ ] **Step 1: Read the two overloads** — lines 1584-1645 in `DialEditorActivity.java`. Find exactly where `createScaledBitmap(bmp, canvasWidth, canvasHeight, true)` is called in the `TYPE_BACKGROUND` branch.

- [ ] **Step 2: Fix the two-arg overload** — In the `if (elementType == DialCompiler.TYPE_BACKGROUND)` block (around line 1608), replace the stretch block with scaleToCover logic. Replace:
```java
if (bmp.getWidth() != canvasWidth || bmp.getHeight() != canvasHeight) {
    bmp = Bitmap.createScaledBitmap(bmp, canvasWidth, canvasHeight, true);
}
// Ensure ARGB_8888 for firmware compatibility
if (bmp.getConfig() != Bitmap.Config.ARGB_8888) {
    Bitmap argb = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(argb);
    c.drawBitmap(bmp, 0, 0, null);
    bmp = argb;
}
```
With:
```java
// Ensure ARGB_8888 for firmware compatibility (but don't stretch — preserve aspect ratio)
if (bmp.getConfig() != Bitmap.Config.ARGB_8888) {
    Bitmap argb = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(argb);
    c.drawBitmap(bmp, 0, 0, null);
    bmp = argb;
}
```

- [ ] **Step 3: Fix scaleToCover in two-arg overload** — In the same two-arg method, the `scaleToCover` computation at the bottom checks `if (elementType != DialCompiler.TYPE_BACKGROUND)` and leaves it at `1.0f` otherwise. Change it so TYPE_BACKGROUND also gets scaleToCover:
```java
float scaleToCover = Math.max(
        (float) canvasWidth / bmp.getWidth(),
        (float) canvasHeight / bmp.getHeight());
```
(Remove the `if (elementType != TYPE_BACKGROUND)` guard entirely — both branches now use the same scaleToCover math.)

- [ ] **Step 4: Unlock both overloads** — In both `addBackgroundLayer` methods, change `layer.locked = true` to `layer.locked = false`. There are exactly 2 occurrences (lines ~1598 and ~1639).

- [ ] **Step 5: Manual test** — Build and install APK. Open Dial Editor → Add Background → pick a horizontal landscape photo. Verify it fills the canvas without stretching, and you can drag it to reframe.

- [ ] **Step 6: Commit**
```bash
git add app/src/main/java/com/example/dialsender/DialEditorActivity.java
git commit -m "fix(editor): background image no longer stretched to 466x466, drag to reframe enabled"
```

---

### Task 2: Add "Lock background" button to layers panel

**Files:**
- Modify: `app/src/main/res/layout/activity_dial_editor.xml`
- Modify: `app/src/main/java/com/example/dialsender/DialEditorActivity.java`

- [ ] **Step 1: Add lock button to XML** — In `activity_dial_editor.xml`, find the layers panel section. Add a `MaterialButton` after the existing layer controls:
```xml
<com.google.android.material.button.MaterialButton
    android:id="@+id/btnLockBackground"
    style="@style/Widget.MaterialComponents.Button.OutlinedButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Bloquear fondo"
    android:visibility="gone"/>
```

- [ ] **Step 2: Declare field and wire in `onCreate`** — In `DialEditorActivity.java`, `btnLockBg` must be an **instance field** (not a local variable) so the layer-selection callback can reference it. Add the field declaration near the other view fields at the top of the class:
```java
private MaterialButton btnLockBg;
```
Then in `onCreate` (not `onCreateView` — this is an `Activity`, not a `Fragment`), initialize and wire it:
```java
btnLockBg = findViewById(R.id.btnLockBackground);
btnLockBg.setOnClickListener(v -> {
    if (selectedLayerIndex >= 0 && selectedLayerIndex < layers.size()) {
        DialLayer l = layers.get(selectedLayerIndex);
        if (l.layerType == DialLayer.TYPE_BACKGROUND) {
            l.locked = !l.locked;
            btnLockBg.setText(l.locked ? "Desbloquear fondo" : "Bloquear fondo");
        }
    }
});
```

- [ ] **Step 3: Show/hide button on layer selection** — In the layer selection callback (where `selectedLayerIndex` is updated), toggle the button visibility using the `btnLockBg` instance field:
```java
boolean isBg = layers.get(selectedLayerIndex).layerType == DialLayer.TYPE_BACKGROUND;
btnLockBg.setVisibility(isBg ? View.VISIBLE : View.GONE);
if (isBg) {
    boolean locked = layers.get(selectedLayerIndex).locked;
    btnLockBg.setText(locked ? "Desbloquear fondo" : "Bloquear fondo");
}
```

- [ ] **Step 4: Manual test** — Import background → drag to reframe → tap "Bloquear fondo" → verify layer cannot be dragged → tap "Desbloquear fondo" → drag works again.

- [ ] **Step 5: Commit**
```bash
git add app/src/main/java/com/example/dialsender/DialEditorActivity.java \
        app/src/main/res/layout/activity_dial_editor.xml
git commit -m "feat(editor): add lock/unlock toggle for background layer"
```

---

## Chunk 2: GIF/Video Animation Frames

### File map
- **Modify:** `app/src/main/java/com/example/dialsender/DialEditorActivity.java` — new `importAnimation()`, updated `onActivityResult`, show animation button
- **Modify:** `app/src/main/java/com/example/dialsender/DialCompiler.java` — fix animated background compile loop
- **New:** `app/src/main/res/layout/dialog_frame_picker.xml`

---

### Task 3: Fix animated background compile loop in DialEditorActivity

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/DialEditorActivity.java` (compile block loop inline in the compile button's background thread, ~lines 1960-2000 — there is no separate `buildBlocks()` method; this code is inline)

- [ ] **Step 1: Read the background block compile section** — In `DialEditorActivity.java` find the `TYPE_BACKGROUND` branch in the compile loop (~line 1972). Note:
  - It currently fetches only `layer.frames[0]` as `layerBmp`
  - It renders a single `bgBitmap` canvas
  - It sets `block.frames = 1` and `block.images = new Bitmap[] { normalizedBg }`

- [ ] **Step 2: Extend to multi-frame** — Replace the single-frame render with a loop over all frames:
```java
if (block.type == DialCompiler.TYPE_BACKGROUND) {
    int frameCount = (layer.frames != null && layer.frames.length > 0) ? layer.frames.length : 1;
    Bitmap[] renderedFrames = new Bitmap[frameCount];
    for (int fi = 0; fi < frameCount; fi++) {
        Bitmap bgBitmap = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
        Canvas bgCanvas = new Canvas(bgBitmap);
        bgCanvas.drawColor(Color.BLACK);
        Bitmap layerBmp = (layer.frames != null && layer.frames.length > fi) ? layer.frames[fi] : layer.icon;
        if (layerBmp != null) {
            Matrix m = new Matrix();
            m.postScale(layer.scale, layer.scale);
            if (layer.rotation != 0) {
                float sw = layerBmp.getWidth() * layer.scale;
                float sh = layerBmp.getHeight() * layer.scale;
                m.postRotate(layer.rotation, sw / 2, sh / 2);
            }
            m.postTranslate(layer.posX, layer.posY);
            bgCanvas.drawBitmap(layerBmp, m, null);
        }
        renderedFrames[fi] = DialCompiler.normalizeForWatch(bgBitmap, canvasWidth, canvasHeight);
    }
    block.images = renderedFrames;
    block.width = canvasWidth;
    block.height = canvasHeight;
    block.frames = frameCount;
    block.x = 0;
    block.y = 0;
}
```

- [ ] **Step 3: Verify single-frame still works** — The change is backward compatible: when `frameCount == 1`, behavior is identical to before. Build APK, import a static background, compile to .bin — should still work.

- [ ] **Step 4: Commit**
```bash
git add app/src/main/java/com/example/dialsender/DialEditorActivity.java
git commit -m "feat(compiler): animated background compiles all frames into .bin sprite sheet"
```

---

### Task 4: Add frame picker dialog layout

**Files:**
- New: `app/src/main/res/layout/dialog_frame_picker.xml`

- [ ] **Step 1: Create dialog layout**
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/tvFramePickerTitle"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Importar animación"
        android:textStyle="bold"
        android:textSize="16sp"
        android:layout_marginBottom="8dp"/>

    <TextView
        android:id="@+id/tvFramePickerInfo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Duración: — ms · Frames estimados: —"
        android:layout_marginBottom="12dp"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Intervalo entre frames:"
        android:layout_marginBottom="4dp"/>

    <RadioGroup
        android:id="@+id/rgInterval"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <RadioButton android:id="@+id/rb100ms" android:layout_width="wrap_content"
            android:layout_height="wrap_content" android:text="100ms"/>
        <RadioButton android:id="@+id/rb200ms" android:layout_width="wrap_content"
            android:layout_height="wrap_content" android:text="200ms" android:checked="true"/>
        <RadioButton android:id="@+id/rb500ms" android:layout_width="wrap_content"
            android:layout_height="wrap_content" android:text="500ms"/>
    </RadioGroup>

    <TextView
        android:id="@+id/tvFrameCount"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="→ 0 frames (máx 30)"
        android:layout_marginTop="8dp"/>

</LinearLayout>
```

- [ ] **Step 2: Commit**
```bash
git add app/src/main/res/layout/dialog_frame_picker.xml
git commit -m "feat(editor): add frame picker dialog layout for animation import"
```

---

### Task 5: Implement GIF frame extraction

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/DialEditorActivity.java`

GIF decoding uses `android.graphics.Movie` (available API 24+, deprecated 33 but functional).

- [ ] **Step 1: Add constants and request code** — At the top of `DialEditorActivity`, add:
```java
private static final int PICK_ANIMATION_CODE = 2003;
```

- [ ] **Step 2: Add "Add animation" button to layer menu** — Find where the existing "Add image" / layer-add options are shown (look for `PICK_IMAGE_CODE` launch or the layer-add menu). Add a new option "Agregar animación" that calls:
```java
Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
intent.setType("*/*");
String[] mimeTypes = {"image/gif", "video/mp4", "video/avi", "video/3gpp", "video/*"};
intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
startActivityForResult(intent, PICK_ANIMATION_CODE);
```

- [ ] **Step 3: Add `extractGifFrames` method** — GIF decoding via `android.graphics.Movie`. Accepts a pre-decoded `Movie` object (decoded once in Step 6's `onActivityResult`) to avoid double-decoding:
```java
@SuppressWarnings("deprecation")
private Bitmap[] extractGifFrames(android.graphics.Movie movie, int intervalMs) {
    try {
        if (movie == null) return null;

        int duration = movie.duration();
        List<Bitmap> frames = new ArrayList<>();

        if (duration == 0) {
            // Single-frame GIF: render at t=0
            Bitmap bmp = Bitmap.createBitmap(movie.width(), movie.height(), Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(bmp);
            c.drawColor(Color.TRANSPARENT, android.graphics.PorterDuff.Mode.CLEAR);
            movie.setTime(0);
            movie.draw(c, 0, 0);
            return new Bitmap[]{bmp};
        }

        for (int t = 0; t < duration && frames.size() < 30; t += intervalMs) {
            Bitmap bmp = Bitmap.createBitmap(movie.width(), movie.height(), Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(bmp);
            c.drawColor(Color.TRANSPARENT, android.graphics.PorterDuff.Mode.CLEAR);
            movie.setTime(t);
            movie.draw(c, 0, 0);
            frames.add(bmp);
        }
        return frames.isEmpty() ? null : frames.toArray(new Bitmap[0]);
    } catch (Exception e) {
        Log.e(TAG, "GIF decode failed", e);
        return null;
    }
}

private byte[] readBytes(InputStream is) throws Exception {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    byte[] buf = new byte[4096];
    int n;
    while ((n = is.read(buf)) != -1) bos.write(buf, 0, n);
    return bos.toByteArray();
}
```

- [ ] **Step 4: Add `extractVideoFrames` method** — Video decoding via `MediaMetadataRetriever`:
```java
private Bitmap[] extractVideoFrames(Uri uri, int intervalMs) {
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    try {
        retriever.setDataSource(this, uri);
        String durationStr = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        long durationMs = durationStr != null ? Long.parseLong(durationStr) : 0;
        if (durationMs == 0) return null;

        List<Bitmap> frames = new ArrayList<>();
        for (long t = 0; t < durationMs && frames.size() < 30; t += intervalMs) {
            Bitmap bmp = retriever.getFrameAtTime(t * 1000L, MediaMetadataRetriever.OPTION_CLOSEST);
            if (bmp != null) frames.add(bmp);
        }
        return frames.toArray(new Bitmap[0]);
    } catch (Exception e) {
        Log.e(TAG, "Video decode failed", e);
        return null;
    } finally {
        try { retriever.release(); } catch (Exception ignored) {}
    }
}
```

- [ ] **Step 5: Remove `loadGifBytes` — no longer needed.** The Movie object is decoded once and passed directly (see Step 6).

- [ ] **Step 6: Handle `PICK_ANIMATION_CODE` in `onActivityResult`** — Decode Movie once, show dialog, pass Movie to extraction thread:
```java
} else if (requestCode == PICK_ANIMATION_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
    Uri animUri = data.getData();
    String mime = getContentResolver().getType(animUri);
    boolean isGif = mime != null && mime.equals("image/gif");

    // For GIF: decode Movie once — reused for duration display AND frame extraction
    @SuppressWarnings("deprecation")
    final android.graphics.Movie gifMovie;
    if (isGif) {
        try {
            InputStream is = getContentResolver().openInputStream(animUri);
            byte[] gifData = readBytes(is);
            is.close();
            gifMovie = android.graphics.Movie.decodeByteArray(gifData, 0, gifData.length);
        } catch (Exception e) {
            Toast.makeText(this, "Error al leer GIF", Toast.LENGTH_SHORT).show();
            return;
        }
    } else {
        gifMovie = null;
    }

    // Compute duration
    long durationMs;
    if (isGif) {
        durationMs = gifMovie != null ? gifMovie.duration() : 0;
    } else {
        MediaMetadataRetriever r = new MediaMetadataRetriever();
        try {
            r.setDataSource(this, animUri);
            String s = r.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            durationMs = s != null ? Long.parseLong(s) : 0;
        } catch (Exception e) { durationMs = 0; }
        finally { try { r.release(); } catch (Exception ignored) {} }
    }
    final long finalDuration = durationMs;

    // Show dialog to pick interval
    View dialogView = getLayoutInflater().inflate(R.layout.dialog_frame_picker, null);
    RadioGroup rg = dialogView.findViewById(R.id.rgInterval);
    TextView tvInfo = dialogView.findViewById(R.id.tvFramePickerInfo);
    TextView tvCount = dialogView.findViewById(R.id.tvFrameCount);

    rg.setOnCheckedChangeListener((g, id) -> {
        int ms = id == R.id.rb100ms ? 100 : id == R.id.rb500ms ? 500 : 200;
        long est = finalDuration > 0 ? Math.min(30, finalDuration / ms) : 1;
        tvCount.setText("→ " + est + " frames (máx 30)");
    });
    tvInfo.setText("Duración: " + finalDuration + " ms");
    long estDefault = finalDuration > 0 ? Math.min(30, finalDuration / 200) : 1;
    tvCount.setText("→ " + estDefault + " frames (máx 30)");

    new AlertDialog.Builder(this)
        .setView(dialogView)
        .setPositiveButton("Importar", (dlg, w) -> {
            int checkedId = rg.getCheckedRadioButtonId();
            int ms = checkedId == R.id.rb100ms ? 100 : checkedId == R.id.rb500ms ? 500 : 200;
            new Thread(() -> {
                Bitmap[] frames = isGif
                    ? extractGifFrames(gifMovie, ms)
                    : extractVideoFrames(animUri, ms);
                runOnUiThread(() -> {
                    if (frames == null || frames.length == 0) {
                        Toast.makeText(this, "No se pudo extraer frames", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    DialLayer layer = new DialLayer(DialLayer.TYPE_BACKGROUND, frames[0],
                        getBlockLabel(DialCompiler.TYPE_BACKGROUND), DialCompiler.TYPE_BACKGROUND);
                    layer.frames = frames;
                    layer.frameCount = frames.length;
                    layer.isSpriteSheet = true;
                    float scaleToCover = Math.max(
                        (float) canvasWidth / frames[0].getWidth(),
                        (float) canvasHeight / frames[0].getHeight());
                    layer.scale = scaleToCover;
                    layer.posX = (canvasWidth - frames[0].getWidth() * scaleToCover) / 2f;
                    layer.posY = (canvasHeight - frames[0].getHeight() * scaleToCover) / 2f;
                    layer.locked = false;
                    layers.add(0, layer);
                    selectedLayerIndex = 0;
                    Toast.makeText(this, "\u2713 " + frames.length + " frames importados", Toast.LENGTH_SHORT).show();
                    refreshAll();
                });
            }).start();
        })
        .setNegativeButton("Cancelar", null)
        .show();
}
```

- [ ] **Step 7: Manual test** — Import a GIF → verify frame count badge in layers panel → compile → send .bin to watch → animation should play.

- [ ] **Step 8: Commit**
```bash
git add app/src/main/java/com/example/dialsender/DialEditorActivity.java
git commit -m "feat(editor): import GIF and video as animated background frames"
```

---

## Chunk 3: Sleep Monitoring Fix

### File map
- **Modify:** `app/src/main/java/com/example/dialsender/ble/BleManager.java` — store `timestamp:mode:soft:strong`
- **New:** `app/src/main/java/com/example/dialsender/ble/SleepAnalyzer.java`
- **New:** `app/src/test/java/com/example/dialsender/ble/SleepAnalyzerTest.java`
- **Modify:** `app/src/main/java/com/example/dialsender/fragments/HomeFragment.java`
- **Modify:** `app/src/main/java/com/example/dialsender/fragments/StatusFragment.java`

---

### Task 6: Fix sleep storage format in BleManager

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/ble/BleManager.java`

- [ ] **Step 1: Find the sleep parse block** — In `BleManager.java`, find `case HEALTH_KEY_SLEEP:` (~line 943). Current code:
```java
sb.append(time).append(":").append(soft + strong);
```

- [ ] **Step 2: Change storage format** — Replace the append with:
```java
sb.append(time).append(":").append(mode).append(":").append(soft).append(":").append(strong);
```

Now each record is `timestamp:mode:soft:strong`. Note: don't change the prefs key (`prefix + "sleep"`), only the value format.

- [ ] **Step 3: Commit**
```bash
git add app/src/main/java/com/example/dialsender/ble/BleManager.java
git commit -m "fix(ble): store sleep mode and motion separately for proper phase analysis"
```

---

### Task 7: Write SleepAnalyzer with TDD

**Files:**
- New: `app/src/main/java/com/example/dialsender/ble/SleepAnalyzer.java`
- New: `app/src/test/java/com/example/dialsender/ble/SleepAnalyzerTest.java`

- [ ] **Step 1: Write the failing test first**

Create `app/src/test/java/com/example/dialsender/ble/SleepAnalyzerTest.java`:
```java
package com.example.dialsender.ble;

import org.junit.Test;
import static org.junit.Assert.*;

public class SleepAnalyzerTest {

    // Build a record string: "ts:mode:soft:strong"
    private String rec(int ts, int mode) {
        return ts + ":" + mode + ":0:0";
    }

    @Test
    public void testBasicSession() {
        // START at t=0, END at t=3600 (1 hour)
        // Deep phase: t=100 to t=1900 (30 min deep)
        // Light phase: t=1900 to t=3600 (28 min light)
        String data = rec(0, BleSleep.MODE_START) + ","
                + rec(100, BleSleep.MODE_DEEP) + ","
                + rec(1900, BleSleep.MODE_LIGHT) + ","
                + rec(3600, BleSleep.MODE_END);
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(data);
        assertEquals(60, r.totalMinutes); // 3600s = 60min
        assertEquals(30, r.deepMin);      // 1800s = 30min
        assertEquals(28, r.lightMin);     // 1700s ≈ 28min
    }

    @Test
    public void testEmptyData() {
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze("");
        assertEquals(0, r.totalMinutes);
    }

    @Test
    public void testNullData() {
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(null);
        assertEquals(0, r.totalMinutes);
    }

    @Test
    public void testPiecemealCountsAsLight() {
        // START at t=0, PIECEMEAL starts at t=60 (non-zero to avoid ambiguity), END at t=660
        String data = rec(0, BleSleep.MODE_START) + ","
                + rec(60, BleSleep.MODE_PIECEMEAL) + ","   // 600s piecemeal (t=60 to t=660)
                + rec(660, BleSleep.MODE_END);
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(data);
        assertEquals(11, r.totalMinutes); // 660s = 11min total
        assertEquals(10, r.lightMin);     // piecemeal (600s = 10min) maps to light
    }

    @Test
    public void testRemPhase() {
        // REM starts at t=60 (non-zero) to avoid ordering ambiguity with MODE_START
        String data = rec(0, BleSleep.MODE_START) + ","
                + rec(60, BleSleep.MODE_REM) + ","
                + rec(1200, BleSleep.MODE_END);
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(data);
        assertEquals(20, r.totalMinutes);  // (1200-0)/60 = 20
        assertEquals(19, r.remMin);        // (1200-60)/60 = 19
    }

    @Test
    public void testLastSessionWins() {
        // Two sessions — only the last one should be returned
        String data = rec(0, BleSleep.MODE_START) + ","
                + rec(3600, BleSleep.MODE_END) + ","
                + rec(7200, BleSleep.MODE_START) + ","
                + rec(9000, BleSleep.MODE_END);
        SleepAnalyzer.SleepResult r = SleepAnalyzer.analyze(data);
        assertEquals(30, r.totalMinutes); // 9000-7200=1800s=30min
    }
}
```

- [ ] **Step 2: Run test to verify it fails**
```bash
cd /home/miguel/Documents/github/smart_watch/dial-sender
./gradlew test --tests "com.example.dialsender.ble.SleepAnalyzerTest" 2>&1 | tail -20
```
Expected: compilation error (SleepAnalyzer does not exist yet).

- [ ] **Step 3: Implement SleepAnalyzer**

Create `app/src/main/java/com/example/dialsender/ble/SleepAnalyzer.java`:
```java
package com.example.dialsender.ble;

public class SleepAnalyzer {

    public static class SleepResult {
        public int totalMinutes;
        public int deepMin;
        public int lightMin;
        public int remMin;
        public int awakeMin;
    }

    /**
     * Analyzes a sleep record string (comma-separated "timestamp:mode:soft:strong").
     * Returns the last complete session (MODE_START to MODE_END).
     */
    public static SleepResult analyze(String data) {
        SleepResult result = new SleepResult();
        if (data == null || data.isEmpty()) return result;

        String[] records = data.split(",");
        // Find the last complete session (last MODE_END, then scan back for its MODE_START)
        int endIdx = -1;
        for (int i = records.length - 1; i >= 0; i--) {
            int mode = parseMode(records[i]);
            if (mode == BleSleep.MODE_END) { endIdx = i; break; }
        }
        if (endIdx < 0) return result;

        int startIdx = -1;
        for (int i = endIdx - 1; i >= 0; i--) {
            int mode = parseMode(records[i]);
            if (mode == BleSleep.MODE_START) { startIdx = i; break; }
        }
        if (startIdx < 0) return result;

        long sessionStart = parseTs(records[startIdx]);
        long sessionEnd = parseTs(records[endIdx]);
        result.totalMinutes = (int) ((sessionEnd - sessionStart) / 60);

        // Accumulate phase spans
        int currentMode = BleSleep.MODE_AWAKE;
        long currentTs = sessionStart;

        for (int i = startIdx + 1; i <= endIdx; i++) {
            long ts = parseTs(records[i]);
            int mode = parseMode(records[i]);
            long spanSecs = ts - currentTs;
            int spanMin = (int) (spanSecs / 60);

            switch (currentMode) {
                case BleSleep.MODE_DEEP:       result.deepMin  += spanMin; break;
                case BleSleep.MODE_LIGHT:      result.lightMin += spanMin; break;
                case BleSleep.MODE_REM:        result.remMin   += spanMin; break;
                case BleSleep.MODE_AWAKE:      result.awakeMin += spanMin; break;
                case BleSleep.MODE_PIECEMEAL:  result.lightMin += spanMin; break; // fragmented → light
            }
            currentMode = mode;
            currentTs = ts;
        }
        return result;
    }

    private static long parseTs(String record) {
        try { return Long.parseLong(record.split(":")[0]); }
        catch (Exception e) { return 0; }
    }

    private static int parseMode(String record) {
        try { return Integer.parseInt(record.split(":")[1]); }
        catch (Exception e) { return 0; }
    }
}
```

- [ ] **Step 4: Run tests to verify they pass**
```bash
cd /home/miguel/Documents/github/smart_watch/dial-sender
./gradlew test --tests "com.example.dialsender.ble.SleepAnalyzerTest" 2>&1 | tail -20
```
Expected: `BUILD SUCCESSFUL`, all 6 tests pass.

- [ ] **Step 5: Commit**
```bash
git add app/src/main/java/com/example/dialsender/ble/SleepAnalyzer.java \
        app/src/test/java/com/example/dialsender/ble/SleepAnalyzerTest.java
git commit -m "feat(health): add SleepAnalyzer with phase breakdown (deep/light/REM/awake)"
```

---

### Task 8: Update HomeFragment sleep display

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/fragments/HomeFragment.java`

- [ ] **Step 1: Replace `getLatestMetricValue("sleep")` call** — In `HomeFragment.refreshMetrics()`, find the sleep block (~line 109):
```java
int sleepMin = getLatestMetricValue("sleep");
```
Replace with:
```java
String sleepData = prefs.getString(PREF_HEALTH_PREFIX + "sleep", "");
SleepAnalyzer.SleepResult sleepRes = SleepAnalyzer.analyze(sleepData);
int sleepMin = sleepRes.totalMinutes;
```

- [ ] **Step 2: Add phase sub-label** — After the existing sleep display block, update `txtSleepSub` to show phases. Find where `txtSleepSub` is set and add:
```java
if (sleepMin > 0) {
    int h = sleepMin / 60;
    int m = sleepMin % 60;
    txtSleep.setText(h > 0 ? h + "h " + m + "m" : m + "m");
    String phases = "";
    if (sleepRes.deepMin > 0) phases += "P: " + (sleepRes.deepMin/60) + "h" + (sleepRes.deepMin%60) + "m  ";
    if (sleepRes.lightMin > 0) phases += "L: " + (sleepRes.lightMin/60) + "h" + (sleepRes.lightMin%60) + "m  ";
    if (sleepRes.remMin > 0)   phases += "REM: " + sleepRes.remMin + "m";
    txtSleepSub.setText(phases.trim().isEmpty() ? "Sin desglose" : phases.trim());
} else {
    txtSleep.setText("—");
    txtSleepSub.setText("Sin datos");
}
```

- [ ] **Step 3: Add import** — At top of file add:
```java
import com.example.dialsender.ble.SleepAnalyzer;
```

- [ ] **Step 4: Manual test** — Sync health data. If watch returns sleep data, home card shows total + phases. If no data yet, shows "—" / "Sin datos".

- [ ] **Step 5: Commit**
```bash
git add app/src/main/java/com/example/dialsender/fragments/HomeFragment.java
git commit -m "feat(home): show sleep phase breakdown (deep/light/REM)"
```

---

### Task 9: Add sleep phase card to StatusFragment

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/fragments/StatusFragment.java`

- [ ] **Step 1: Add imports** to `StatusFragment.java`:
```java
import com.example.dialsender.ble.SleepAnalyzer;
import android.util.TypedValue;
```

- [ ] **Step 2: Add sleep card to `renderMetrics()`** — After the existing metric cards loop, add a dedicated sleep section:
```java
// Sleep phase card
String sleepData = prefs.getString(PREF_HEALTH_PREFIX + "sleep", "");
SleepAnalyzer.SleepResult sr = SleepAnalyzer.analyze(sleepData);
if (sr.totalMinutes > 0) {
    // Title
    TextView sleepTitle = new TextView(requireContext());
    sleepTitle.setText("Sueño: " + (sr.totalMinutes/60) + "h " + (sr.totalMinutes%60) + "m");
    sleepTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
    sleepTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_primary));
    healthContainer.addView(sleepTitle);

    // Bar chart with phase breakdown
    BarChart chart = new BarChart(requireContext());
    chart.setLayoutParams(new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, 300));
    List<BarEntry> entries = new ArrayList<>();
    entries.add(new BarEntry(0, sr.deepMin));
    entries.add(new BarEntry(1, sr.lightMin));
    entries.add(new BarEntry(2, sr.remMin));
    entries.add(new BarEntry(3, sr.awakeMin));
    BarDataSet ds = new BarDataSet(entries, "Fases");
    ds.setColors(
        ContextCompat.getColor(requireContext(), R.color.chart_bar),
        ContextCompat.getColor(requireContext(), R.color.chart_line),
        0xFF9C27B0, // purple for REM
        ContextCompat.getColor(requireContext(), R.color.text_secondary)
    );
    ds.setValueTextColor(ContextCompat.getColor(requireContext(), R.color.text_primary));
    chart.setData(new BarData(ds));
    com.github.mikephil.charting.components.XAxis xAxis = chart.getXAxis();
    xAxis.setValueFormatter(new com.github.mikephil.charting.formatter.IndexAxisValueFormatter(
            new String[]{"Profundo", "Ligero", "REM", "Despierto"}));
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    chart.getAxisRight().setEnabled(false);
    chart.getLegend().setEnabled(false);
    chart.getDescription().setEnabled(false);
    chart.invalidate();
    healthContainer.addView(chart);
}
```

- [ ] **Step 3: Commit**
```bash
git add app/src/main/java/com/example/dialsender/fragments/StatusFragment.java
git commit -m "feat(status): add sleep phase bar chart (deep/light/REM/awake)"
```

---

## Chunk 4: BLE Session Persistence

### File map
- **New:** `app/src/main/java/com/example/dialsender/ble/BleForegroundService.java`
- **Modify:** `app/src/main/java/com/example/dialsender/ble/BleManager.java` — save address on connect, `getLastDeviceAddress()`, `reconnect()`
- **Modify:** `app/src/main/java/com/example/dialsender/MainActivity.java`
- **Modify:** `app/src/main/AndroidManifest.xml`

---

### Task 10: Add address persistence to BleManager

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/ble/BleManager.java`

- [ ] **Step 1: Save address on connect** — In `BleManager`, find `onConnectionStateChange` callback where `BluetoothProfile.STATE_CONNECTED` is handled (around the `log("Connected...")` line). Add:
```java
prefs.edit().putString("last_device_address", gatt.getDevice().getAddress()).apply();
```

- [ ] **Step 2: Add `getLastDeviceAddress()`**
```java
public String getLastDeviceAddress() {
    return prefs.getString("last_device_address", null);
}
```

- [ ] **Step 3: Add `reconnect(String address)` method** — The existing connect entry point in BleManager is `connect(BluetoothDevice)` (not `connectToDevice`):
```java
public void reconnect(String address) {
    if (isConnected || address == null) return;
    BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);
    connect(device); // existing public connect method
}
```

- [ ] **Step 4: Commit**
```bash
git add app/src/main/java/com/example/dialsender/ble/BleManager.java
git commit -m "feat(ble): persist last device address, add reconnect() method"
```

---

### Task 11: Create BleForegroundService

**Files:**
- New: `app/src/main/java/com/example/dialsender/ble/BleForegroundService.java`

- [ ] **Step 1: Create service class**
```java
package com.example.dialsender.ble;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

import androidx.core.app.NotificationCompat;

import com.example.dialsender.MainActivity;
import com.example.dialsender.R;

public class BleForegroundService extends Service {

    public static final String ACTION_DISCONNECT = "com.example.dialsender.ACTION_DISCONNECT";
    private static final int NOTIF_ID = 1001;
    private static final String CHANNEL_ID = "ble_connection";
    private static final long RECONNECT_INTERVAL_MS = 30_000L;

    private Handler handler;
    private Runnable reconnectRunnable;
    private BleManager bleManager;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler(Looper.getMainLooper());
        bleManager = BleManager.getInstance(this);
        createNotificationChannel();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && ACTION_DISCONNECT.equals(intent.getAction())) {
            bleManager.disconnect();
            stopSelf();
            return START_NOT_STICKY;
        }
        startForeground(NOTIF_ID, buildNotification(bleManager.isConnected()));
        scheduleReconnect();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (reconnectRunnable != null) handler.removeCallbacks(reconnectRunnable);
    }

    private void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID, "Conexión con reloj", NotificationManager.IMPORTANCE_LOW);
        channel.setDescription("Mantiene la conexión BLE activa en segundo plano");
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
    }

    private Notification buildNotification(boolean connected) {
        Intent openApp = new Intent(this, MainActivity.class);
        PendingIntent openPi = PendingIntent.getActivity(this, 0, openApp,
                PendingIntent.FLAG_IMMUTABLE);

        Intent disconnectIntent = new Intent(this, BleForegroundService.class);
        disconnectIntent.setAction(ACTION_DISCONNECT);
        PendingIntent disconnectPi = PendingIntent.getService(this, 1, disconnectIntent,
                PendingIntent.FLAG_IMMUTABLE);

        return new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Dial Studio")
                .setContentText(connected ? "Reloj conectado" : "Buscando reloj...")
                .setContentIntent(openPi)
                .addAction(0, "Desconectar", disconnectPi)
                .setOngoing(true)
                .build();
    }

    public void updateNotification(boolean connected) {
        NotificationManager nm = getSystemService(NotificationManager.class);
        nm.notify(NOTIF_ID, buildNotification(connected));
    }

    private void scheduleReconnect() {
        reconnectRunnable = () -> {
            if (!bleManager.isSessionReady()) {
                String addr = bleManager.getLastDeviceAddress();
                if (addr != null) bleManager.reconnect(addr);
            }
            scheduleReconnect(); // reschedule
        };
        handler.postDelayed(reconnectRunnable, RECONNECT_INTERVAL_MS);
    }
}
```

- [ ] **Step 2: Add `isConnected()` public method to BleManager** if it doesn't exist — check if `isConnected` field is public or has a getter. Add if missing:
```java
public boolean isConnected() {
    return isConnected;
}
```

- [ ] **Step 3: Commit**
```bash
git add app/src/main/java/com/example/dialsender/ble/BleForegroundService.java \
        app/src/main/java/com/example/dialsender/ble/BleManager.java
git commit -m "feat(ble): add foreground service for persistent BLE connection"
```

---

### Task 12: Wire service in MainActivity and update Manifest

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/MainActivity.java`
- Modify: `app/src/main/AndroidManifest.xml`

- [ ] **Step 1: Update AndroidManifest.xml** — Add inside `<manifest>` before `<application>`:
```xml
<uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>
<uses-permission android:name="android.permission.FOREGROUND_SERVICE_CONNECTED_DEVICE"/>
<uses-permission android:name="android.permission.POST_NOTIFICATIONS"/>
```
Add inside `<application>`:
```xml
<service
    android:name=".ble.BleForegroundService"
    android:foregroundServiceType="connectedDevice"
    android:exported="false"/>
```

- [ ] **Step 2: Start service when session is ready** — In `MainActivity.java`, find `BleStateListener.onConnectionStateChange()` callback. When `sessionReady == true`, add — note the API 26 guard since `minSdk` is 24:
```java
Intent serviceIntent = new Intent(this, BleForegroundService.class);
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    startForegroundService(serviceIntent);
} else {
    startService(serviceIntent);
}
```
Also add `import android.os.Build;` if not already present.

- [ ] **Step 3: Stop service on explicit disconnect** — Find where disconnect is called from the UI (e.g., disconnect button). After calling `bleManager.disconnect()`, add:
```java
stopService(new Intent(this, BleForegroundService.class));
```

- [ ] **Step 4: Request POST_NOTIFICATIONS on Android 13+** — In `MainActivity.onCreate()` or initial setup:
```java
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
            != PackageManager.PERMISSION_GRANTED) {
        requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 200);
    }
}
```

- [ ] **Step 5: Manual test** — Connect to watch → verify persistent notification appears in status bar → close app → verify notification remains → wait 30s → verify watch stays connected or reconnects.

- [ ] **Step 6: Commit**
```bash
git add app/src/main/AndroidManifest.xml \
        app/src/main/java/com/example/dialsender/MainActivity.java
git commit -m "feat(service): start foreground BLE service on session ready, auto-reconnect every 30s"
```

---

## Chunk 5: Notification Management

### File map
- **New:** `app/src/main/java/com/example/dialsender/ble/WatchNotificationService.java`
- **New:** `app/src/main/java/com/example/dialsender/NotificationSettingsActivity.java`
- **New:** `app/src/main/res/layout/activity_notification_settings.xml`
- **New:** `app/src/main/res/layout/item_app_notif.xml`
- **Modify:** `app/src/main/java/com/example/dialsender/ble/BleManager.java` — `sendNotification()`
- **Modify:** `app/src/main/java/com/example/dialsender/fragments/DeviceFragment.java`
- **Modify:** `app/src/main/AndroidManifest.xml`

---

### Task 13: Add sendNotification() to BleManager

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/ble/BleManager.java`

- [ ] **Step 1: Add method**
```java
public void sendNotification(int category, String title, String content, String packageName) {
    if (!isSessionReady()) return;

    // Payload: [category:1B][timestamp:4B LE][package:32B][title:32B][content:250B null-term]
    byte[] pkgBytes  = fixedBytes(packageName, 32);
    byte[] titleBytes = fixedBytes(title != null ? title : "", 32);
    byte[] contentBytes = limitedBytes(content != null ? content : "", 250);

    long ts = (System.currentTimeMillis() / 1000L) - 946684800L; // seconds since 2000-01-01
    byte[] payload = new byte[1 + 4 + 32 + 32 + contentBytes.length];
    int i = 0;
    payload[i++] = (byte) category;
    // timestamp 4 bytes little-endian
    payload[i++] = (byte)(ts & 0xFF);
    payload[i++] = (byte)((ts >> 8) & 0xFF);
    payload[i++] = (byte)((ts >> 16) & 0xFF);
    payload[i++] = (byte)((ts >> 24) & 0xFF);
    System.arraycopy(pkgBytes, 0, payload, i, 32);   i += 32;
    System.arraycopy(titleBytes, 0, payload, i, 32); i += 32;
    System.arraycopy(contentBytes, 0, payload, i, contentBytes.length);

    byte[] frame = BleMessenger.buildFrame(BleKey.NOTIFICATION, BleKeyFlag.CREATE, payload, false);
    commandQueue.add(frame);
    if (!isSending) sendNextChunk(); // existing queue drain method
}

/** Returns a null-padded byte array of exactly `len` bytes from `s` (UTF-8). */
private byte[] fixedBytes(String s, int len) {
    byte[] src = s.getBytes(java.nio.charset.StandardCharsets.UTF_8);
    byte[] dst = new byte[len];
    System.arraycopy(src, 0, dst, 0, Math.min(src.length, len));
    return dst;
}

/** Returns UTF-8 bytes of `s`, truncated to `maxLen`, null-terminated. */
private byte[] limitedBytes(String s, int maxLen) {
    byte[] src = s.getBytes(java.nio.charset.StandardCharsets.UTF_8);
    int len = Math.min(src.length, maxLen - 1);
    byte[] dst = new byte[len + 1]; // +1 for null terminator
    System.arraycopy(src, 0, dst, 0, len);
    return dst;
}
```

- [ ] **Step 2: Check `BleKeyFlag.CREATE` exists** — Open `BleKeyFlag.java` and verify `CREATE` is defined. If not, add it (check the existing flag values to avoid collision).

- [ ] **Step 3: Commit**
```bash
git add app/src/main/java/com/example/dialsender/ble/BleManager.java
git commit -m "feat(ble): add sendNotification() for forwarding phone notifications to watch"
```

---

### Task 13b: Add RecyclerView dependency to build.gradle

**Files:**
- Modify: `app/build.gradle`

- [ ] **Step 1: Add RecyclerView** — In the `dependencies` block of `app/build.gradle`, add:
```groovy
implementation 'androidx.recyclerview:recyclerview:1.3.2'
```

- [ ] **Step 2: Sync Gradle** — Run `./gradlew dependencies` or use Android Studio "Sync Now".

- [ ] **Step 3: Commit**
```bash
git add app/build.gradle
git commit -m "feat(deps): add RecyclerView dependency for notification settings"
```

---

### Task 14: Create notification settings layouts

**Files:**
- New: `app/src/main/res/layout/activity_notification_settings.xml`
- New: `app/src/main/res/layout/item_app_notif.xml`

- [ ] **Step 1: Create main layout**

`activity_notification_settings.xml`:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@color/bg_primary">

    <!-- Permission banner -->
    <LinearLayout
        android:id="@+id/bannerPermission"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/status_warning"
        android:orientation="horizontal"
        android:padding="12dp"
        android:visibility="gone">

        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Permiso de notificaciones no concedido"
            android:textColor="#FFFFFF"/>

        <Button
            android:id="@+id/btnGrantPermission"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Conceder"
            android:textColor="#FFFFFF"
            style="@style/Widget.MaterialComponents.Button.TextButton"/>
    </LinearLayout>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Apps que se reenvían al reloj"
        android:textSize="14sp"
        android:padding="16dp"
        android:textColor="@color/text_secondary"/>

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rvApps"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"/>

</LinearLayout>
```

- [ ] **Step 2: Create list item layout**

`item_app_notif.xml`:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:padding="12dp"
    android:gravity="center_vertical">

    <ImageView
        android:id="@+id/imgAppIcon"
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:layout_marginEnd="12dp"/>

    <TextView
        android:id="@+id/tvAppName"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:textSize="15sp"
        android:textColor="@color/text_primary"/>

    <com.google.android.material.switchmaterial.SwitchMaterial
        android:id="@+id/switchEnabled"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>
```

- [ ] **Step 3: Commit**
```bash
git add app/src/main/res/layout/activity_notification_settings.xml \
        app/src/main/res/layout/item_app_notif.xml
git commit -m "feat(notifications): add notification settings layouts"
```

---

### Task 15: Create NotificationSettingsActivity

**Files:**
- New: `app/src/main/java/com/example/dialsender/NotificationSettingsActivity.java`

- [ ] **Step 1: Create activity**
```java
package com.example.dialsender;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import android.content.pm.ResolveInfo;

public class NotificationSettingsActivity extends AppCompatActivity {

    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String PREF_NOTIF_PACKAGES = "notif_enabled_packages";

    private SharedPreferences prefs;
    private Set<String> enabledPackages;
    private List<ApplicationInfo> appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);
        if (getSupportActionBar() != null) getSupportActionBar().setTitle("Notificaciones");

        prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String saved = prefs.getString(PREF_NOTIF_PACKAGES, "");
        enabledPackages = new HashSet<>(Arrays.asList(saved.split(",")));
        enabledPackages.remove(""); // clean up empty string from split

        // Permission banner
        LinearLayout banner = findViewById(R.id.bannerPermission);
        boolean hasPermission = isNotificationListenerEnabled();
        banner.setVisibility(hasPermission ? View.GONE : View.VISIBLE);
        findViewById(R.id.btnGrantPermission).setOnClickListener(v ->
                startActivity(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)));

        // Load apps
        appList = getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
        // Filter: only apps with launcher intent (user-visible apps)
        List<ApplicationInfo> launcherApps = new ArrayList<>();
        Intent launcherIntent = new Intent(Intent.ACTION_MAIN, null);
        launcherIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        for (ResolveInfo ri : getPackageManager().queryIntentActivities(launcherIntent, 0)) {
            for (ApplicationInfo ai : appList) {
                if (ai.packageName.equals(ri.activityInfo.packageName)) {
                    launcherApps.add(ai);
                    break;
                }
            }
        }

        RecyclerView rv = findViewById(R.id.rvApps);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new AppAdapter(launcherApps));
    }

    private boolean isNotificationListenerEnabled() {
        Set<String> enabled = NotificationManagerCompat.getEnabledListenerPackages(this);
        return enabled.contains(getPackageName());
    }

    private void saveEnabledPackages() {
        prefs.edit().putString(PREF_NOTIF_PACKAGES, String.join(",", enabledPackages)).apply();
    }

    class AppAdapter extends RecyclerView.Adapter<AppAdapter.VH> {
        private final List<ApplicationInfo> apps;
        AppAdapter(List<ApplicationInfo> apps) { this.apps = apps; }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_app_notif, parent, false);
            return new VH(v);
        }

        @Override
        public void onBindViewHolder(VH h, int pos) {
            ApplicationInfo ai = apps.get(pos);
            PackageManager pm = getPackageManager();
            h.tvName.setText(pm.getApplicationLabel(ai));
            h.imgIcon.setImageDrawable(pm.getApplicationIcon(ai));
            h.sw.setOnCheckedChangeListener(null);
            h.sw.setChecked(enabledPackages.contains(ai.packageName));
            h.sw.setOnCheckedChangeListener((btn, checked) -> {
                if (checked) enabledPackages.add(ai.packageName);
                else enabledPackages.remove(ai.packageName);
                saveEnabledPackages();
            });
        }

        @Override public int getItemCount() { return apps.size(); }

        class VH extends RecyclerView.ViewHolder {
            ImageView imgIcon; TextView tvName; SwitchMaterial sw;
            VH(View v) {
                super(v);
                imgIcon = v.findViewById(R.id.imgAppIcon);
                tvName  = v.findViewById(R.id.tvAppName);
                sw      = v.findViewById(R.id.switchEnabled);
            }
        }
    }
}
```

- [ ] **Step 2: Commit**
```bash
git add app/src/main/java/com/example/dialsender/NotificationSettingsActivity.java
git commit -m "feat(notifications): add NotificationSettingsActivity with per-app toggles"
```

---

### Task 16: Create WatchNotificationService

**Files:**
- New: `app/src/main/java/com/example/dialsender/ble/WatchNotificationService.java`

- [ ] **Step 1: Create service**
```java
package com.example.dialsender.ble;

import android.app.Notification;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import androidx.core.app.NotificationCompat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WatchNotificationService extends NotificationListenerService {

    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String PREF_NOTIF_PACKAGES = "notif_enabled_packages";
    private static final int CATEGORY_CALL = 1;
    private static final int CATEGORY_MESSAGE = 127;

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        if (sbn == null) return;

        BleManager ble = BleManager.getInstance(getApplicationContext());
        if (!ble.isSessionReady()) return;

        String pkg = sbn.getPackageName();

        // Skip our own notifications
        if (pkg.equals(getPackageName())) return;

        // Check whitelist
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String saved = prefs.getString(PREF_NOTIF_PACKAGES, "");
        Set<String> enabled = new HashSet<>(Arrays.asList(saved.split(",")));
        if (!enabled.contains(pkg)) return;

        Notification notif = sbn.getNotification();
        Bundle extras = notif.extras;

        String title = extras.getString(NotificationCompat.EXTRA_TITLE, "");
        CharSequence bigText = extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        String content = bigText != null ? bigText.toString()
                : extras.getString(NotificationCompat.EXTRA_TEXT, "");

        int category = Notification.CATEGORY_CALL.equals(notif.category) ? CATEGORY_CALL : CATEGORY_MESSAGE;

        ble.sendNotification(category, title, content, pkg);
    }
}
```

- [ ] **Step 2: Commit**
```bash
git add app/src/main/java/com/example/dialsender/ble/WatchNotificationService.java
git commit -m "feat(notifications): forward phone notifications to watch via WatchNotificationService"
```

---

### Task 17: Register service, activity in Manifest + wire DeviceFragment

**Files:**
- Modify: `app/src/main/AndroidManifest.xml`
- Modify: `app/src/main/java/com/example/dialsender/fragments/DeviceFragment.java`

- [ ] **Step 1: Update AndroidManifest** — Add inside `<application>`:
```xml
<activity
    android:name=".NotificationSettingsActivity"
    android:exported="false"/>

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

- [ ] **Step 2: Add notifications button to `fragment_device.xml`** — Open `fragment_device.xml`. Find the section containing `@+id/btnWatchFaceGallery` (line ~155) and `@+id/btnWatchFaceBuilder` (line ~192). Add a new button after `btnWatchFaceBuilder`, following the same style:
```xml
<com.google.android.material.button.MaterialButton
    android:id="@+id/btnNotificationSettings"
    style="@style/Widget.MaterialComponents.Button.OutlinedButton"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="8dp"
    android:text="Notificaciones →"/>
```

- [ ] **Step 3: Wire button in DeviceFragment.java** — In `onCreateView`, after the existing `btnWatchFaceBuilder.setOnClickListener` block, add:
```java
view.findViewById(R.id.btnNotificationSettings).setOnClickListener(v ->
    startActivity(new Intent(requireContext(), com.example.dialsender.NotificationSettingsActivity.class)));
```

- [ ] **Step 3: Manual test** — Open DeviceFragment → tap "Notificaciones" → grant permission if prompted → enable WhatsApp → receive a WhatsApp message → verify notification appears on watch.

- [ ] **Step 4: Commit**
```bash
git add app/src/main/AndroidManifest.xml \
        app/src/main/java/com/example/dialsender/fragments/DeviceFragment.java
git commit -m "feat(notifications): register WatchNotificationService and NotificationSettingsActivity in manifest"
```

---

## Final Integration Checklist

- [ ] Build full APK: `./gradlew assembleDebug`
- [ ] Install: `adb install -r app/build/outputs/apk/debug/app-debug.apk`
- [ ] Run all unit tests: `./gradlew test`
- [ ] Test background image: import landscape → no stretch → drag → lock
- [ ] Test GIF import → frame count badge → compile → .bin plays on watch
- [ ] Test video import → frame picker → 30-frame cap → compile
- [ ] Test sleep sync → StatusFragment shows phase breakdown
- [ ] Test foreground service: connect → persistent notification → close app → notification remains → watch stays connected
- [ ] Test auto-reconnect: disable Bluetooth → re-enable → watch reconnects within 30s
- [ ] Test notifications: grant permission → enable an app → receive notification → appears on watch
- [ ] Confirm non-whitelisted app notifications are NOT forwarded

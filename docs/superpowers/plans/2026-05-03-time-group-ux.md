# Time Group UX Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Replace the flat Hour/Minute/Second picker with a time-group system that lets users choose HH:MM or HH:MM:SS, design all parts together or separately, with orange placeholders and auto-apply of existing styles.

**Architecture:** New `TimeGroup` class tracks format/mode/parts. `DialLayer` gains `layerId`/`timeGroupId`/`pendingStyle`/`isColonSeparator` fields. `DialEditorActivity` gains `showTimeFormatDialog()` and `createTimeGroup()`, and patches the touch handler, renderer, and source picker.

**Tech Stack:** Android (minSdk 21), Java, Material AlertDialog, Canvas drawing, JUnit 4

---

## File Map

| File | Action | Responsibility |
|------|--------|---------------|
| `app/src/main/java/com/example/dialsender/TimeGroup.java` | **Create** | Data class: format, mode, parts list, toJson/fromJson |
| `app/src/main/java/com/example/dialsender/DialLayer.java` | **Modify** | Add layerId, timeGroupId, pendingStyle, isColonSeparator |
| `app/src/main/java/com/example/dialsender/DialEditorActivity.java` | **Modify** | Dialog, group creation, rendering, touch, source picker |
| `app/src/test/java/com/example/dialsender/TimeGroupTest.java` | **Create** | Unit tests for TimeGroup serialization and state |

---

### Task 1: Add fields to DialLayer

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/DialLayer.java`

- [ ] **Step 1: Add four new fields to DialLayer**

Open `DialLayer.java`. After the `locked` field (currently last field before the constructors), add:

```java
// Time group support
public String  layerId         = java.util.UUID.randomUUID().toString();
public String  timeGroupId     = null;   // null = not part of any time group
public boolean pendingStyle    = false;  // true = placeholder, no style assigned yet
public boolean isColonSeparator = false; // true = the ":" between HH/MM/SS, not compiled
```

The full modified field section (lines 5–34) becomes:

```java
public class DialLayer {
    public static final int TYPE_BACKGROUND = 0;
    public static final int TYPE_ELEMENT = 1;
    public static final int TYPE_ARM = 2;
    public static final int TYPE_PREVIEW = 3;

    public int layerType;
    public Bitmap icon;
    public String name;
    public int nativeElementType;

    public float scale = 1.0f;
    public float rotation = 0;
    public float posX = 0;
    public float posY = 0;
    public float alpha = 1.0f;

    public Bitmap[] frames;
    public int frameCount = 1;
    public boolean isSpriteSheet = false;
    public boolean locked = false;

    public int animIntervalMs = 100;
    public Bitmap compositeImage;

    // Time group support
    public String  layerId          = java.util.UUID.randomUUID().toString();
    public String  timeGroupId      = null;
    public boolean pendingStyle     = false;
    public boolean isColonSeparator = false;

    public DialLayer(int layerType, Bitmap icon, String name) { ... }
    public DialLayer(int layerType, Bitmap icon, String name, int nativeElementType) { ... }
}
```

- [ ] **Step 2: Build to confirm no compile errors**

```bash
cd /home/miguel/Documents/github/smart_watch/dial-sender
./gradlew app:assembleDebug 2>&1 | tail -5
```

Expected: `BUILD SUCCESSFUL`

- [ ] **Step 3: Commit**

```bash
git add dial-sender/app/src/main/java/com/example/dialsender/DialLayer.java
git commit -m "feat(time-group): add layerId/timeGroupId/pendingStyle/isColonSeparator to DialLayer"
```

---

### Task 2: Create TimeGroup class

**Files:**
- Create: `app/src/main/java/com/example/dialsender/TimeGroup.java`
- Create: `app/src/test/java/com/example/dialsender/TimeGroupTest.java`

- [ ] **Step 1: Write the failing tests first**

Create `app/src/test/java/com/example/dialsender/TimeGroupTest.java`:

```java
package com.example.dialsender;

import org.json.JSONObject;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class TimeGroupTest {

    private DialLayer makeLayer(String id, boolean pending) {
        DialLayer l = new DialLayer(DialLayer.TYPE_ELEMENT, null, "test");
        l.layerId = id;
        l.pendingStyle = pending;
        return l;
    }

    @Test
    public void isComplete_allStyled_returnsTrue() {
        DialLayer h = makeLayer("h", false);
        DialLayer m = makeLayer("m", false);
        List<DialLayer> parts = new ArrayList<>();
        parts.add(h); parts.add(m);
        TimeGroup g = new TimeGroup("g1", TimeGroup.Format.HH_MM, TimeGroup.Mode.PARTS, parts);
        assertTrue(g.isComplete());
    }

    @Test
    public void isComplete_onePending_returnsFalse() {
        DialLayer h = makeLayer("h", false);
        DialLayer m = makeLayer("m", true);  // pending
        List<DialLayer> parts = new ArrayList<>();
        parts.add(h); parts.add(m);
        TimeGroup g = new TimeGroup("g1", TimeGroup.Format.HH_MM, TimeGroup.Mode.PARTS, parts);
        assertFalse(g.isComplete());
    }

    @Test
    public void pendingParts_returnsOnlyPending() {
        DialLayer h = makeLayer("h", false);
        DialLayer m = makeLayer("m", true);
        List<DialLayer> parts = new ArrayList<>();
        parts.add(h); parts.add(m);
        TimeGroup g = new TimeGroup("g1", TimeGroup.Format.HH_MM, TimeGroup.Mode.PARTS, parts);
        List<DialLayer> pending = g.pendingParts();
        assertEquals(1, pending.size());
        assertEquals("m", pending.get(0).layerId);
    }

    @Test
    public void toJson_fromJson_roundtrip() throws Exception {
        DialLayer h = makeLayer("h-id", false);
        h.timeGroupId = "g1";
        DialLayer m = makeLayer("m-id", true);
        m.timeGroupId = "g1";
        List<DialLayer> parts = new ArrayList<>();
        parts.add(h); parts.add(m);

        TimeGroup g = new TimeGroup("g1", TimeGroup.Format.HH_MM_SS, TimeGroup.Mode.TOGETHER, parts);
        JSONObject json = g.toJson();

        // Reconstruct from JSON + layer list
        List<DialLayer> allLayers = new ArrayList<>(parts);
        TimeGroup restored = TimeGroup.fromJson(json, allLayers);

        assertEquals("g1", restored.groupId);
        assertEquals(TimeGroup.Format.HH_MM_SS, restored.format);
        assertEquals(TimeGroup.Mode.TOGETHER, restored.mode);
        assertEquals(2, restored.parts.size());
        assertEquals("h-id", restored.parts.get(0).layerId);
        assertEquals("m-id", restored.parts.get(1).layerId);
    }
}
```

- [ ] **Step 2: Run tests to confirm they fail (class not found)**

```bash
cd /home/miguel/Documents/github/smart_watch/dial-sender
./gradlew app:testDebugUnitTest --tests "com.example.dialsender.TimeGroupTest" 2>&1 | tail -15
```

Expected: FAIL — `TimeGroup` not found

- [ ] **Step 3: Create TimeGroup.java**

Create `app/src/main/java/com/example/dialsender/TimeGroup.java`:

```java
package com.example.dialsender;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class TimeGroup {

    public enum Format { HH_MM, HH_MM_SS }
    public enum Mode   { TOGETHER, PARTS }

    public final String groupId;
    public final Format format;
    public final Mode   mode;
    public final List<DialLayer> parts; // ordered: [hours, (colon), minutes, (colon), (seconds)]

    public TimeGroup(String groupId, Format format, Mode mode, List<DialLayer> parts) {
        this.groupId = groupId;
        this.format  = format;
        this.mode    = mode;
        this.parts   = parts;
    }

    /** True when no part has pendingStyle=true. */
    public boolean isComplete() {
        for (DialLayer l : parts) {
            if (l.pendingStyle) return false;
        }
        return true;
    }

    /** Returns only the parts that still need a style assigned. */
    public List<DialLayer> pendingParts() {
        List<DialLayer> result = new ArrayList<>();
        for (DialLayer l : parts) {
            if (l.pendingStyle) result.add(l);
        }
        return result;
    }

    /** Returns the first styled (non-pending, non-colon) sibling of the given layer, or null. */
    public DialLayer styledSiblingOf(DialLayer layer) {
        for (DialLayer l : parts) {
            if (l == layer || l.isColonSeparator) continue;
            if (!l.pendingStyle) return l;
        }
        return null;
    }

    public JSONObject toJson() throws Exception {
        JSONObject o = new JSONObject();
        o.put("groupId", groupId);
        o.put("format",  format.name());
        o.put("mode",    mode.name());
        JSONArray ids = new JSONArray();
        for (DialLayer l : parts) ids.put(l.layerId);
        o.put("partIds", ids);
        return o;
    }

    /** Reconstruct a TimeGroup by matching partIds against allLayers by layerId. */
    public static TimeGroup fromJson(JSONObject o, List<DialLayer> allLayers) throws Exception {
        String groupId = o.getString("groupId");
        Format format  = Format.valueOf(o.getString("format"));
        Mode   mode    = Mode.valueOf(o.getString("mode"));
        JSONArray ids  = o.getJSONArray("partIds");
        List<DialLayer> parts = new ArrayList<>();
        for (int i = 0; i < ids.length(); i++) {
            String id = ids.getString(i);
            for (DialLayer l : allLayers) {
                if (id.equals(l.layerId)) { parts.add(l); break; }
            }
        }
        return new TimeGroup(groupId, format, mode, parts);
    }
}
```

- [ ] **Step 4: Run tests again**

```bash
./gradlew app:testDebugUnitTest --tests "com.example.dialsender.TimeGroupTest" 2>&1 | tail -15
```

Expected: `4 tests completed, 0 failures`

- [ ] **Step 5: Commit**

```bash
git add dial-sender/app/src/main/java/com/example/dialsender/TimeGroup.java \
        dial-sender/app/src/test/java/com/example/dialsender/TimeGroupTest.java
git commit -m "feat(time-group): add TimeGroup class with format/mode/parts and JSON roundtrip"
```

---

### Task 3: showTimeFormatDialog() + createTimeGroup()

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/DialEditorActivity.java`

- [ ] **Step 1: Add `timeGroups` field**

Near the top of `DialEditorActivity` class (after `private int selectedLayerIndex = -1;`), add:

```java
private final List<TimeGroup> timeGroups = new ArrayList<>();
```

Also add the import at the top of the file:
```java
import com.example.dialsender.TimeGroup;
```

- [ ] **Step 2: Add `showTimeFormatDialog()`**

Add this method after `showScalePicker()` (around line 477):

```java
private void showTimeFormatDialog() {
    final TimeGroup.Format[] selectedFormat = {TimeGroup.Format.HH_MM};
    final TimeGroup.Mode[]   selectedMode   = {TimeGroup.Mode.TOGETHER};

    View v = LayoutInflater.from(this).inflate(R.layout.dialog_time_format, null);
    RadioGroup rgFormat = v.findViewById(R.id.rgTimeFormat);
    RadioGroup rgMode   = v.findViewById(R.id.rgTimeMode);

    rgFormat.setOnCheckedChangeListener((g, id) -> {
        selectedFormat[0] = (id == R.id.rbHHMMSS)
                ? TimeGroup.Format.HH_MM_SS
                : TimeGroup.Format.HH_MM;
    });
    rgMode.setOnCheckedChangeListener((g, id) -> {
        selectedMode[0] = (id == R.id.rbParts)
                ? TimeGroup.Mode.PARTS
                : TimeGroup.Mode.TOGETHER;
    });

    new AlertDialog.Builder(this)
            .setTitle(R.string.add_time_group)
            .setView(v)
            .setNegativeButton(R.string.cancel, null)
            .setPositiveButton(R.string.cont, (d, w) ->
                    createTimeGroup(selectedFormat[0], selectedMode[0]))
            .show();
}
```

- [ ] **Step 3: Add `createTimeGroup()`**

Add this method immediately after `showTimeFormatDialog()`:

```java
private void createTimeGroup(TimeGroup.Format format, TimeGroup.Mode mode) {
    String groupId = java.util.UUID.randomUUID().toString();
    boolean withSeconds = (format == TimeGroup.Format.HH_MM_SS);

    int digitW = 40; // default placeholder width
    int digitH = 60; // default placeholder height
    int colonW = 16;
    int cx = canvasWidth  / 2;
    int cy = canvasHeight / 2;

    // Calculate total width to center the group
    int totalW = digitW * 2 + colonW + (withSeconds ? digitW + colonW : 0);
    int startX = cx - totalW / 2;
    int topY   = cy - digitH / 2;

    // Hours
    DialLayer hoursLayer = new DialLayer(DialLayer.TYPE_ELEMENT, null, getString(R.string.lbl_hours));
    hoursLayer.nativeElementType = DialCompiler.TYPE_DIGITAL_HOUR;
    hoursLayer.posX        = startX;
    hoursLayer.posY        = topY;
    hoursLayer.timeGroupId = groupId;
    hoursLayer.pendingStyle = true;

    // Colon HH:MM
    DialLayer colon1 = new DialLayer(DialLayer.TYPE_ELEMENT, null, ":");
    colon1.posX             = startX + digitW;
    colon1.posY             = topY;
    colon1.timeGroupId      = groupId;
    colon1.isColonSeparator = true;

    // Minutes
    DialLayer minutesLayer = new DialLayer(DialLayer.TYPE_ELEMENT, null, getString(R.string.lbl_minutes));
    minutesLayer.nativeElementType = DialCompiler.TYPE_DIGITAL_MIN;
    minutesLayer.posX        = startX + digitW + colonW;
    minutesLayer.posY        = topY;
    minutesLayer.timeGroupId = groupId;
    minutesLayer.pendingStyle = true;

    List<DialLayer> parts = new ArrayList<>();
    parts.add(hoursLayer);
    parts.add(colon1);
    parts.add(minutesLayer);

    layers.add(hoursLayer);
    layers.add(colon1);
    layers.add(minutesLayer);

    if (withSeconds) {
        DialLayer colon2 = new DialLayer(DialLayer.TYPE_ELEMENT, null, ":");
        colon2.posX             = startX + digitW + colonW + digitW;
        colon2.posY             = topY;
        colon2.timeGroupId      = groupId;
        colon2.isColonSeparator = true;

        DialLayer secondsLayer = new DialLayer(DialLayer.TYPE_ELEMENT, null, getString(R.string.lbl_seconds));
        secondsLayer.nativeElementType = DialCompiler.TYPE_SECONDS;
        secondsLayer.posX        = startX + digitW + colonW + digitW + colonW;
        secondsLayer.posY        = topY;
        secondsLayer.timeGroupId = groupId;
        secondsLayer.pendingStyle = true;

        parts.add(colon2);
        parts.add(secondsLayer);
        layers.add(colon2);
        layers.add(secondsLayer);
    }

    TimeGroup group = new TimeGroup(groupId, format, mode, parts);
    timeGroups.add(group);

    selectedLayerIndex = layers.size() - 1;
    refreshAll();

    // TOGETHER mode: immediately open style picker for hours; on confirm copies to all
    if (mode == TimeGroup.Mode.TOGETHER) {
        showSourcePickerForGroup(hoursLayer, group);
    }
}
```

- [ ] **Step 4: Add `showSourcePickerForGroup()` helper**

Add this method after `createTimeGroup()`:

```java
/**
 * Opens the source picker for one layer in a TOGETHER group.
 * On style selection, copies frames+scale to all non-colon siblings.
 */
private void showSourcePickerForGroup(DialLayer hoursLayer, TimeGroup group) {
    // Temporarily intercept loadPreset result by overriding pendingGroupTarget
    pendingGroupTarget = group;
    pendingGroupSourceLayer = hoursLayer;
    showSourcePicker(hoursLayer.nativeElementType);
}
```

Also add these two fields near the top of the class (with the other drag-state fields):

```java
private TimeGroup pendingGroupTarget      = null;
private DialLayer pendingGroupSourceLayer = null;
```

- [ ] **Step 5: Wire showCategoryPicker to call showTimeFormatDialog for category 0 (Time)**

Find `showCategoryPicker()` at around line 591. Change it so category index 0 (Time) triggers the new dialog:

```java
private void showCategoryPicker(int categoryIndex) {
    // Category 0 = Time: use the new format/mode dialog
    if (categoryIndex == 0) {
        showTimeFormatDialog();
        return;
    }

    String[] catNames = getCategoryNames();
    int[] types = ELEMENT_CATEGORIES[categoryIndex];
    String[] labels = new String[types.length];
    for (int i = 0; i < types.length; i++) {
        int frames = DialCompiler.getDefaultFrameCount(types[i]);
        String frameLabel = frames > 1 ? " (" + frames + " frames)" : "";
        labels[i] = getBlockLabel(types[i]) + frameLabel;
    }

    new AlertDialog.Builder(this)
            .setTitle(catNames[categoryIndex])
            .setItems(labels, (dialog, which) -> {
                int selectedType = types[which];
                showSourcePicker(selectedType);
            })
            .show();
}
```

- [ ] **Step 6: Add string resources**

In `app/src/main/res/values/strings.xml`, add:

```xml
<string name="add_time_group">Agregar hora</string>
<string name="cont">Continuar</string>
<string name="lbl_hours">Horas</string>
<string name="lbl_minutes">Minutos</string>
<string name="lbl_seconds">Segundos</string>
```

- [ ] **Step 7: Create the dialog layout**

Create `app/src/main/res/layout/dialog_time_format.xml`:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="20dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Formato"
        android:textStyle="bold"
        android:textSize="14sp"
        android:layout_marginBottom="8dp" />

    <RadioGroup
        android:id="@+id/rgTimeFormat"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="16dp">

        <RadioButton
            android:id="@+id/rbHHMM"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="HH:MM"
            android:checked="true" />

        <RadioButton
            android:id="@+id/rbHHMMSS"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="HH:MM:SS" />
    </RadioGroup>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Modo de diseño"
        android:textStyle="bold"
        android:textSize="14sp"
        android:layout_marginBottom="8dp" />

    <RadioGroup
        android:id="@+id/rgTimeMode"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <RadioButton
            android:id="@+id/rbTogether"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Todo junto — un solo estilo para todos"
            android:checked="true" />

        <RadioButton
            android:id="@+id/rbParts"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Por partes — diseñas cada parte" />
    </RadioGroup>

</LinearLayout>
```

- [ ] **Step 8: Build**

```bash
./gradlew app:assembleDebug 2>&1 | tail -5
```

Expected: `BUILD SUCCESSFUL`

- [ ] **Step 9: Commit**

```bash
git add dial-sender/app/src/main/java/com/example/dialsender/DialEditorActivity.java \
        dial-sender/app/src/main/res/layout/dialog_time_format.xml \
        dial-sender/app/src/main/res/values/strings.xml
git commit -m "feat(time-group): add showTimeFormatDialog, createTimeGroup, wire category 0"
```

---

### Task 4: Placeholder rendering in updatePreview()

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/DialEditorActivity.java` (method `updatePreview()`, around line 2153)

- [ ] **Step 1: Render colons and placeholders**

Inside `updatePreview()`, in the `for` loop that draws each layer, add handling for `isColonSeparator` and `pendingStyle` **before** the existing `getPreviewBitmap(layer)` call:

```java
for (int i = 0; i < layers.size(); i++) {
    DialLayer layer = layers.get(i);

    // Draw colon separators as text
    if (layer.isColonSeparator) {
        Paint colonPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        colonPaint.setColor(Color.WHITE);
        colonPaint.setTextSize(48f);
        colonPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(":", layer.posX, layer.posY + 48f, colonPaint);
        if (i == selectedLayerIndex) {
            Paint border = new Paint();
            border.setStyle(Paint.Style.STROKE);
            border.setColor(Color.parseColor("#58A6FF"));
            border.setStrokeWidth(2);
            canvas.drawRect(layer.posX, layer.posY, layer.posX + 16, layer.posY + 60, border);
        }
        continue;
    }

    // Draw placeholder for pending-style layers
    if (layer.pendingStyle) {
        int pw = 40, ph = 60;
        float px = layer.posX, py = layer.posY;
        Paint bg = new Paint();
        bg.setColor(0x33FF8C00); // orange 20%
        canvas.drawRect(px, py, px + pw, py + ph, bg);

        Paint border = new Paint();
        border.setStyle(Paint.Style.STROKE);
        border.setColor(0xFFFF8C00); // orange
        border.setStrokeWidth(2);
        canvas.drawRect(px, py, px + pw, py + ph, border);

        Paint txt = new Paint(Paint.ANTI_ALIAS_FLAG);
        txt.setColor(0xFFFF8C00);
        txt.setTextSize(18f);
        txt.setTextAlign(Paint.Align.CENTER);
        String label = layer.name != null ? layer.name.substring(0, Math.min(2, layer.name.length())) : "??";
        canvas.drawText(label, px + pw / 2f, py + ph / 2f, txt);
        txt.setTextSize(12f);
        canvas.drawText("✋", px + pw / 2f, py + ph - 6f, txt);

        if (i == selectedLayerIndex) {
            border.setColor(Color.parseColor("#58A6FF"));
            canvas.drawRect(px, py, px + pw, py + ph, border);
        }
        continue;
    }

    // --- existing draw code below (unchanged) ---
    Bitmap drawBmp = getPreviewBitmap(layer);
    // ... rest of existing loop body
```

- [ ] **Step 2: Handle tap on placeholder in ACTION_DOWN**

In the touch handler's `ACTION_DOWN` block (around line 301), after setting `isDragging = true`, add:

```java
case MotionEvent.ACTION_DOWN:
    int hitIdx = findLayerAt(tx, ty);
    if (hitIdx >= 0) {
        selectedLayerIndex = hitIdx;
        DialLayer tappedLayer = layers.get(hitIdx);

        // Tap on placeholder → open style picker immediately, no drag
        if (tappedLayer.pendingStyle) {
            isDragging = false;
            showSourcePickerForPendingLayer(tappedLayer);
            refreshAll();
            return true;
        }

        isDragging = true;
        dragStartX = tx;
        dragStartY = ty;
        DialLayer l = layers.get(hitIdx);
        layerStartX = l.posX;
        layerStartY = l.posY;
        refreshAll();
    }
    return true;
```

- [ ] **Step 3: Add `showSourcePickerForPendingLayer()`**

```java
private void showSourcePickerForPendingLayer(DialLayer layer) {
    pendingGroupTarget      = null;
    pendingGroupSourceLayer = null;

    // Check if there's a styled sibling to offer as first option
    if (layer.timeGroupId != null) {
        TimeGroup group = findGroup(layer.timeGroupId);
        if (group != null) {
            DialLayer donor = group.styledSiblingOf(layer);
            if (donor != null) {
                showSourcePickerWithAutoApply(layer, donor, group);
                return;
            }
        }
    }
    showSourcePicker(layer.nativeElementType);
}

private TimeGroup findGroup(String groupId) {
    for (TimeGroup g : timeGroups) {
        if (g.groupId.equals(groupId)) return g;
    }
    return null;
}
```

- [ ] **Step 4: Build and install**

```bash
./gradlew app:assembleDebug 2>&1 | tail -5
adb install -r dial-sender/app/build/outputs/apk/debug/app-debug.apk
```

Expected: `BUILD SUCCESSFUL`, `Success`

- [ ] **Step 5: Manual test**
  - Open the app → Editor → `+` → Hora
  - Verify: format dialog appears with two RadioGroups
  - Select HH:MM + Por partes → Continuar
  - Verify: two orange placeholder boxes appear on canvas with "Ho" and "Mi" labels and a ":" colon between them
  - Tap a placeholder → verify `showSourcePicker` opens

- [ ] **Step 6: Commit**

```bash
git add dial-sender/app/src/main/java/com/example/dialsender/DialEditorActivity.java
git commit -m "feat(time-group): render placeholders and colons, tap placeholder opens picker"
```

---

### Task 5: Linked movement for TOGETHER groups

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/DialEditorActivity.java` (touch handler `ACTION_MOVE`, around line 316)

- [ ] **Step 1: Store start positions of all group members on ACTION_DOWN**

Add a field near the drag-state fields:

```java
private List<float[]> groupMemberStartPositions = new ArrayList<>(); // [posX, posY] per group member in order
private List<DialLayer> activeDragGroup = new ArrayList<>();
```

In `ACTION_DOWN`, after setting `layerStartX = l.posX; layerStartY = l.posY;`, add:

```java
// If layer belongs to a TOGETHER group, store start positions of all members
activeDragGroup.clear();
groupMemberStartPositions.clear();
if (l.timeGroupId != null) {
    TimeGroup grp = findGroup(l.timeGroupId);
    if (grp != null && grp.mode == TimeGroup.Mode.TOGETHER) {
        for (DialLayer part : grp.parts) {
            activeDragGroup.add(part);
            groupMemberStartPositions.add(new float[]{part.posX, part.posY});
        }
    }
}
```

- [ ] **Step 2: Apply delta to all group members in ACTION_MOVE**

Replace the existing `ACTION_MOVE` block (lines 316-324):

```java
case MotionEvent.ACTION_MOVE:
    if (isDragging && selectedLayerIndex >= 0 && selectedLayerIndex < layers.size()) {
        float dx = tx - dragStartX;
        float dy = ty - dragStartY;
        DialLayer l = layers.get(selectedLayerIndex);
        if (!activeDragGroup.isEmpty()) {
            // Move all TOGETHER group members
            for (int gi = 0; gi < activeDragGroup.size(); gi++) {
                activeDragGroup.get(gi).posX = groupMemberStartPositions.get(gi)[0] + dx;
                activeDragGroup.get(gi).posY = groupMemberStartPositions.get(gi)[1] + dy;
            }
        } else {
            l.posX = layerStartX + dx;
            l.posY = layerStartY + dy;
        }
        updatePreview();
    }
    return true;
```

- [ ] **Step 3: Clear drag group on ACTION_UP**

In `ACTION_UP`:

```java
case MotionEvent.ACTION_UP:
case MotionEvent.ACTION_CANCEL:
    isDragging = false;
    activeDragGroup.clear();
    groupMemberStartPositions.clear();
    updateControls();
    return true;
```

- [ ] **Step 4: Build and test**

```bash
./gradlew app:assembleDebug 2>&1 | tail -5
adb install -r dial-sender/app/build/outputs/apk/debug/app-debug.apk
```

Manual test:
- Add a time group with "Todo junto"
- After style is assigned, drag one part → verify all parts move together
- Add a "Por partes" group → drag one part → verify only that part moves

- [ ] **Step 5: Commit**

```bash
git add dial-sender/app/src/main/java/com/example/dialsender/DialEditorActivity.java
git commit -m "feat(time-group): linked movement for TOGETHER mode groups"
```

---

### Task 6: Auto-apply "Igual que…" in source picker

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/DialEditorActivity.java`

- [ ] **Step 1: Add `showSourcePickerWithAutoApply()`**

Add this method after `showSourcePickerForPendingLayer()`:

```java
/**
 * Opens the source picker for a pending layer, with "Igual que [donor.name]"
 * prepended as the first option. If chosen, copies frames+scale from donor.
 */
private void showSourcePickerWithAutoApply(DialLayer target, DialLayer donor, TimeGroup group) {
    int elementType = target.nativeElementType;
    List<String> presetPaths = findPresetFolders(elementType);

    View galleryView = LayoutInflater.from(this).inflate(R.layout.dialog_preset_gallery, null);
    TextView titleView = galleryView.findViewById(R.id.txtGalleryTitle);
    titleView.setText(getString(R.string.select_style) + " — " + getBlockLabel(elementType));
    RecyclerView grid = galleryView.findViewById(R.id.gridPresets);
    grid.setLayoutManager(new GridLayoutManager(this, 3));

    List<Object[]> items = new ArrayList<>();

    // "Igual que X" as first option
    String donorLabel = "🔁 " + getString(R.string.same_as) + " " + donor.name;
    items.add(new Object[]{ donorLabel, "__COPY__", null });

    // Standard options
    items.add(new Object[]{ getString(R.string.from_gallery), null, null });
    if (isDigitElementType(elementType)) {
        items.add(new Object[]{ getString(R.string.from_font), "__FONT__", null });
    }
    items.add(new Object[]{ getString(R.string.from_svg), "__SVG__", null });
    for (String p : presetPaths) {
        Bitmap thumb = loadPresetThumbnail(p, elementType);
        int lastSlash = p.lastIndexOf('/');
        String styleName = lastSlash >= 0 ? p.substring(lastSlash + 1) : p;
        items.add(new Object[]{ styleName, p, thumb });
    }

    AlertDialog dialog = new AlertDialog.Builder(this)
            .setView(galleryView)
            .setNegativeButton(R.string.cancel, null)
            .create();

    grid.setAdapter(new RecyclerView.Adapter<PresetVH>() {
        @NonNull @Override
        public PresetVH onCreateViewHolder(@NonNull ViewGroup parent, int vt) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_preset_thumb, parent, false);
            return new PresetVH(v);
        }

        @Override
        public void onBindViewHolder(@NonNull PresetVH h, int pos) {
            Object[] item = items.get(pos);
            h.txtName.setText((String) item[0]);
            Bitmap thumb = (Bitmap) item[2];
            if (thumb != null) {
                h.imgThumb.setImageBitmap(thumb);
            } else if ("__COPY__".equals(item[1]) && donor.frames != null && donor.frames.length > 0) {
                h.imgThumb.setImageBitmap(donor.frames[0]);
            } else {
                h.imgThumb.setImageBitmap(null);
            }
            h.itemView.setOnClickListener(v -> {
                dialog.dismiss();
                String path = (String) item[1];
                if ("__COPY__".equals(path)) {
                    // Copy style from donor
                    target.frames       = donor.frames != null ? donor.frames.clone() : null;
                    target.icon         = donor.icon;
                    target.scale        = donor.scale;
                    target.frameCount   = donor.frameCount;
                    target.isSpriteSheet = donor.isSpriteSheet;
                    target.pendingStyle = false;
                    refreshAll();
                } else if (path == null) {
                    pendingElementType = elementType;
                    pickImageFromGallery();
                } else if ("__FONT__".equals(path)) {
                    showFontCreator(elementType);
                } else if ("__SVG__".equals(path)) {
                    pendingElementType = elementType;
                    pickSvgFromGallery();
                } else {
                    loadPreset(path, elementType);
                    target.pendingStyle = false;
                }
            });
        }

        @Override public int getItemCount() { return items.size(); }
    });

    dialog.show();
}
```

- [ ] **Step 2: Add string resource**

In `strings.xml`:
```xml
<string name="same_as">Igual que</string>
```

- [ ] **Step 3: Handle TOGETHER mode style propagation**

After `loadPreset()` completes (that method calls `refreshAll()` at the end), we need to propagate the style to all pending group members if the layer belongs to a TOGETHER group. Find where `loadPreset()` finishes adding the layer to `layers` and calls `refreshAll()` (around line 1639). At the very end of `loadPreset()`, add:

```java
// Propagate style to all pending TOGETHER siblings
if (pendingGroupTarget != null && pendingGroupSourceLayer != null) {
    DialLayer justLoaded = layers.get(layers.size() - 1); // the freshly loaded layer
    // Copy back into the original placeholder layer
    pendingGroupSourceLayer.frames       = justLoaded.frames != null ? justLoaded.frames.clone() : null;
    pendingGroupSourceLayer.icon         = justLoaded.icon;
    pendingGroupSourceLayer.scale        = justLoaded.scale;
    pendingGroupSourceLayer.frameCount   = justLoaded.frameCount;
    pendingGroupSourceLayer.isSpriteSheet = justLoaded.isSpriteSheet;
    pendingGroupSourceLayer.pendingStyle = false;
    // Remove the duplicate layer loadPreset added
    layers.remove(justLoaded);
    // Copy style to remaining pending TOGETHER siblings
    for (DialLayer sibling : pendingGroupTarget.parts) {
        if (sibling == pendingGroupSourceLayer || sibling.isColonSeparator) continue;
        sibling.frames       = pendingGroupSourceLayer.frames != null ? pendingGroupSourceLayer.frames.clone() : null;
        sibling.icon         = pendingGroupSourceLayer.icon;
        sibling.scale        = pendingGroupSourceLayer.scale;
        sibling.frameCount   = pendingGroupSourceLayer.frameCount;
        sibling.isSpriteSheet = pendingGroupSourceLayer.isSpriteSheet;
        sibling.pendingStyle = false;
    }
    pendingGroupTarget      = null;
    pendingGroupSourceLayer = null;
    refreshAll();
}
```

- [ ] **Step 4: Build and install**

```bash
./gradlew app:assembleDebug 2>&1 | tail -5
adb install -r dial-sender/app/build/outputs/apk/debug/app-debug.apk
```

Manual test:
- Add HH:MM · Por partes → style Horas with any preset
- Tap MM placeholder → verify "🔁 Igual que Horas" appears first in picker
- Select it → verify MM gets same style, `pendingStyle=false`

- [ ] **Step 5: Commit**

```bash
git add dial-sender/app/src/main/java/com/example/dialsender/DialEditorActivity.java \
        dial-sender/app/src/main/res/values/strings.xml
git commit -m "feat(time-group): auto-apply 'Igual que X' and TOGETHER style propagation"
```

---

### Task 7: Context menu — Desagrupar + restrict pending

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/DialEditorActivity.java`

- [ ] **Step 1: Find the long-press / layer-options code**

```bash
grep -n "longClick\|LongClick\|showLayerOptions\|AlertDialog.*layer\|\"Eliminar\"\|\"Delete\"\|delete.*layer\|removeLayer\|layers.remove" /home/miguel/Documents/github/smart_watch/dial-sender/app/src/main/java/com/example/dialsender/DialEditorActivity.java | head -20
```

Identify the method or inline block that shows options when a layer is long-pressed or options-button tapped. Note the line number.

- [ ] **Step 2: Add "Desagrupar" option for grouped layers**

In the layer options menu builder, add a condition:

```java
// If this layer belongs to a group, offer "Desagrupar"
if (layer.timeGroupId != null && !layer.isColonSeparator) {
    options.add(getString(R.string.ungroup));
}
```

And handle the selection:

```java
if (getString(R.string.ungroup).equals(chosen)) {
    ungroupTimeGroup(layer.timeGroupId);
}
```

- [ ] **Step 3: Add `ungroupTimeGroup()`**

```java
private void ungroupTimeGroup(String groupId) {
    TimeGroup group = findGroup(groupId);
    if (group == null) return;
    // Remove all colon separators from layers list
    layers.removeIf(l -> l.isColonSeparator && groupId.equals(l.timeGroupId));
    // Strip group metadata from remaining parts
    for (DialLayer l : group.parts) {
        if (!l.isColonSeparator) {
            l.timeGroupId  = null;
            l.pendingStyle = false; // keep whatever style they had
        }
    }
    timeGroups.remove(group);
    refreshAll();
}
```

- [ ] **Step 4: Restrict pending-layer context menu**

When showing the context menu for a layer with `pendingStyle=true`, only offer:
- "Asignar estilo" (opens showSourcePickerForPendingLayer)
- "Eliminar" (removes layer and its colon siblings from group, then removes from layers list)

```java
if (layer.pendingStyle) {
    new AlertDialog.Builder(this)
        .setTitle(layer.name)
        .setItems(new String[]{
                getString(R.string.assign_style),
                getString(R.string.delete_layer)
        }, (d, w) -> {
            if (w == 0) showSourcePickerForPendingLayer(layer);
            else        removePendingLayer(layer);
        })
        .show();
    return;
}
```

- [ ] **Step 5: Add `removePendingLayer()`**

```java
private void removePendingLayer(DialLayer layer) {
    // Also remove the adjacent colon separator(s) from the same group
    String gid = layer.timeGroupId;
    if (gid != null) {
        TimeGroup group = findGroup(gid);
        if (group != null) {
            group.parts.remove(layer);
            // Remove orphaned colons (colons with no non-colon neighbor on one side)
            group.parts.removeIf(l -> l.isColonSeparator);
            layers.removeIf(l -> l.isColonSeparator && gid.equals(l.timeGroupId));
            if (group.parts.isEmpty()) timeGroups.remove(group);
        }
    }
    layers.remove(layer);
    if (selectedLayerIndex >= layers.size()) selectedLayerIndex = layers.size() - 1;
    refreshAll();
}
```

- [ ] **Step 6: Add string resources**

```xml
<string name="ungroup">Desagrupar</string>
<string name="assign_style">Asignar estilo</string>
<string name="delete_layer">Eliminar capa</string>
```

- [ ] **Step 7: Build and install**

```bash
./gradlew app:assembleDebug 2>&1 | tail -5
adb install -r dial-sender/app/build/outputs/apk/debug/app-debug.apk
```

Manual test:
- Long-press a styled group layer → verify "Desagrupar" appears
- Tap Desagrupar → verify colons disappear, remaining layers are moveable independently
- Long-press a placeholder → verify only "Asignar estilo" and "Eliminar capa" appear

- [ ] **Step 8: Commit**

```bash
git add dial-sender/app/src/main/java/com/example/dialsender/DialEditorActivity.java \
        dial-sender/app/src/main/res/values/strings.xml
git commit -m "feat(time-group): Desagrupar option and restricted context menu for placeholders"
```

---

### Task 8: Exclude colons and placeholders from DialCompiler output

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/DialEditorActivity.java` (compilation loop, around line 2338)

- [ ] **Step 1: Skip colon and pending layers during compilation**

Find the compilation loop (around line 2338) where `DialLayer` objects are converted to `DialCompiler.Block`. Add two guards at the top of the loop:

```java
for (DialLayer layer : layers) {
    // Colon separators are decorative only — not compiled to watch binary
    if (layer.isColonSeparator) continue;
    // Pending placeholder layers have no style — skip to avoid empty blocks
    if (layer.pendingStyle) continue;

    // ... rest of existing compilation code
```

- [ ] **Step 2: Build**

```bash
./gradlew app:assembleDebug 2>&1 | tail -5
```

Expected: `BUILD SUCCESSFUL`

- [ ] **Step 3: Commit**

```bash
git add dial-sender/app/src/main/java/com/example/dialsender/DialEditorActivity.java
git commit -m "feat(time-group): exclude colon separators and pending placeholders from binary output"
```

---

### Task 9: Final integration test

- [ ] **Step 1: Install and full flow test**

```bash
adb install -r dial-sender/app/build/outputs/apk/debug/app-debug.apk
```

Test checklist:
1. `+` → Hora → dialog appears with format + mode radio groups
2. HH:MM + Todo junto → Continuar → source picker opens → pick a preset → verify hours AND minutes get same style, both `pendingStyle=false`, move as one unit when dragged
3. `+` → Hora → HH:MM:SS + Por partes → Continuar → 3 orange placeholders + 2 colons appear
4. Tap Minutos placeholder → "🔁 Igual que Horas" missing (Horas also pending) → pick a preset for Horas first
5. Tap Minutos placeholder → "🔁 Igual que Horas" appears first → select it → Minutos gets same style
6. Long-press grouped layer → "Desagrupar" visible → tap → colons removed, layers independent
7. Long-press placeholder → only "Asignar estilo" + "Eliminar capa" visible
8. Compile and send dial to watch → colons/placeholders NOT in binary (no extra blocks)

- [ ] **Step 2: Run unit tests**

```bash
./gradlew app:testDebugUnitTest 2>&1 | tail -10
```

Expected: all tests pass

- [ ] **Step 3: Final commit**

```bash
git add -A
git commit -m "feat(time-group): complete time group UX — format picker, placeholders, auto-apply, grouped movement"
```

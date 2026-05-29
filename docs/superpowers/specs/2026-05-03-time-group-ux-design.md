# Time Group UX — Design Spec
Date: 2026-05-03

## Overview

Replace the current flat "add Hour / Minute / Second" element flow with a grouped time-format picker that lets the user choose format (HH:MM or HH:MM:SS) and design mode (together or by parts), with auto-apply of existing styles across parts.

## Decisions Made

| Question | Choice |
|----------|--------|
| Dialog structure | Single dialog: format selector + mode selector, one "Continuar" button |
| Together mode canvas | Linked group (moves as one unit, expandable to separate) |
| Parts auto-suggest | Placeholder layer on canvas; tap → picker with "Igual que Horas" first |
| Parts guidance | Both layers appear on canvas from start — pending ones show as orange placeholders |

---

## Architecture

### New file: `TimeGroup.java`

```java
public class TimeGroup {
    public enum Format { HH_MM, HH_MM_SS }
    public enum Mode   { TOGETHER, PARTS }

    public final String       groupId;   // UUID
    public final Format       format;
    public final Mode         mode;
    public final List<DialLayer> parts;  // [hours, minutes] or [hours, minutes, seconds]

    public boolean isComplete();             // no parts have pendingStyle=true
    public List<DialLayer> pendingParts();   // parts where pendingStyle==true
    public JSONObject toJson();
    public static TimeGroup fromJson(JSONObject json, List<DialLayer> allLayers);
}
```

### Modified: `DialLayer.java`

Three new fields, serialized in existing `toJson()`/`fromJson()`:

```java
public String  layerId      = UUID.randomUUID().toString(); // stable ID for group cross-references
public String  timeGroupId  = null;   // null if not in a group
public boolean pendingStyle = false;  // true = orange placeholder, no style yet
```

`layerId` is assigned once on construction and persists through save/load. It allows `TimeGroup.fromJson()` to reconnect `partIds` → `DialLayer` references without relying on list index.

### Modified: `DialEditorActivity.java`

New field:
```java
private final List<TimeGroup> timeGroups = new ArrayList<>();
```

New methods:
- `showTimeFormatDialog()` — replaces direct category → source flow for time types
- `createTimeGroup(Format, Mode)` — instantiates TimeGroup, creates placeholder DialLayers, adds to canvas

Modified methods:
- `showCategoryPicker()` → when time category selected, call `showTimeFormatDialog()` instead of `showSourcePicker()`
- `showSourcePicker(layer)` → prepend "Igual que X" option when layer is a pending group member with a styled sibling
- Touch handler `onTouchMove` → if layer in TOGETHER group, apply delta to all group members
- Long-press context menu → add "Desagrupar" for grouped layers; limit pending layers to "Asignar estilo" / "Eliminar"
- `saveProject()` / `loadProject()` → include `timeGroups` array in project JSON

---

## Dialog: `showTimeFormatDialog()`

```
┌─ Agregar hora ──────────────────┐
│                                 │
│  Formato                        │
│  ◉ HH:MM          (default)    │
│  ○ HH:MM:SS                    │
│                                 │
│  Modo de diseño                 │
│  ◉ Todo junto     (default)    │
│     Un solo estilo para todos   │
│  ○ Por partes                  │
│     Diseñas cada parte          │
│                                 │
│  [Cancelar]        [Continuar] │
└─────────────────────────────────┘
```

On "Continuar":
- `createTimeGroup(format, mode)` creates placeholder layers on canvas
- If `mode=TOGETHER`: immediately opens `showSourcePicker(hoursLayer)`. On confirm, copies style to all sibling parts (all become `pendingStyle=false`)
- If `mode=PARTS`: layers land on canvas as orange placeholders; user taps each to style

---

## Canvas Behavior

### Placeholder rendering

When `layer.pendingStyle == true`:
- Background: orange at 20% opacity
- Border: dashed orange 2dp
- Centered text: "HH", "MM", or "SS" in orange
- Small tap icon (✋) at bottom

Tap on placeholder → calls `showSourcePicker(layer)` directly (no context menu).

### Default placement

On group creation, layers are pre-positioned centered on the dial face:
- `HH` at `(centerX - digitWidth - colonWidth/2, centerY - digitHeight/2)`
- `MM` at `(centerX + colonWidth/2, centerY - digitHeight/2)`
- `SS` (if present) at `(centerX + colonWidth/2 + digitWidth + colonWidth, centerY - digitHeight/2)`
- A static colon `:` text layer is added between each pair, grouped with them

### Linked movement (TOGETHER mode)

```
onTouchMove(layer):
  if layer.timeGroupId != null:
    group = getGroup(layer.timeGroupId)
    if group.mode == TOGETHER:
      apply (dx, dy) to all group.parts
```

### Context menu (long-press)

Grouped layer options:
- "Desagrupar" → removes `timeGroupId` from all parts, deletes TimeGroup entry. Layers stay on canvas with their styles.

Pending layer (`pendingStyle=true`) options only:
- "Asignar estilo"
- "Eliminar"

---

## Auto-apply: "Igual que…"

In `showSourcePicker(layer)`, when `layer.pendingStyle==true` and `layer.timeGroupId!=null`:

1. Find siblings in same group that already have a style (`pendingStyle==false`)
2. If any exist, prepend this option at the top of the style picker:

```
┌─────────────────────────────────────────┐
│ 🔁  Igual que Horas                    │
│     [nombre del preset/fuente actual]  │
└─────────────────────────────────────────┘
```

3. If chosen:
   - Copy `frames`, `scale` from donor layer
   - Set `layer.pendingStyle = false`
   - Position is **not** copied — each part keeps its own position

---

## Colon Separator

The `:` between HH and MM is a static decorative layer (no native element type, renders as text ":" in the same color/font as the group if possible). It:
- Is created alongside the group
- Moves with the group in TOGETHER mode (added to `group.parts`)
- Is deleted if the group is ungrouped or a part is deleted
- Is not compiled into the watch binary as a separate block (excluded from DialCompiler output)

---

## Serialization

Project JSON gains a `timeGroups` array:

```json
{
  "layers": [...],
  "timeGroups": [
    {
      "groupId": "uuid",
      "format": "HH_MM",
      "mode": "PARTS",
      "partIds": ["layerId1", "layerId2"]
    }
  ]
}
```

Each DialLayer JSON gains two fields:
```json
{ "timeGroupId": "uuid", "pendingStyle": false }
```

---

## Out of Scope

- Visual alignment guides / magnet snap (separate spec)
- Modifying existing ungrouped time layers to join a group
- Changing format after group is created (user must delete and recreate)

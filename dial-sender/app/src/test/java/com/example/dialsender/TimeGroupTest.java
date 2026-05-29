package com.example.dialsender;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
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

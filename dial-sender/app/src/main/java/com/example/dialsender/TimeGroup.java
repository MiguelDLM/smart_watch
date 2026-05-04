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

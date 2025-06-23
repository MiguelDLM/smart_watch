package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.c.a.a.q;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class TTWidgetManager {
    public static TTWidgetManager create(View view) {
        Bridge bridge;
        if (view == null) {
            return null;
        }
        if (view.getTag() instanceof Bridge) {
            bridge = (Bridge) view.getTag();
        } else {
            bridge = null;
        }
        if (bridge == null) {
            return null;
        }
        return new q(bridge);
    }

    public abstract boolean updateWidgetWithType(int i, JSONObject jSONObject);
}

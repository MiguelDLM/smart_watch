package com.baidu.ar;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.garmin.fit.xOxOoo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class la {
    public static lb cs(String str) {
        File file = new File(str, "targets.json");
        if (!file.exists()) {
            return null;
        }
        try {
            return o(new JSONObject(km.h(file)).optJSONObject("slam_model"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static lb o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        lb lbVar = new lb();
        try {
            if (jSONObject.has("id")) {
                lbVar.setId(jSONObject.getString("id"));
            }
            if (jSONObject.has("place_type")) {
                lbVar.X(jSONObject.getInt("place_type"));
            }
            if (jSONObject.has(RequestParameters.POSITION)) {
                lbVar.ct(jSONObject.getString(RequestParameters.POSITION));
            }
            if (jSONObject.has(xOxOoo.f15470o00)) {
                lbVar.Y(jSONObject.getInt(xOxOoo.f15470o00));
            }
            if (jSONObject.has("pitch_angle")) {
                lbVar.Z(jSONObject.getInt("pitch_angle"));
            }
            if (jSONObject.has("rotation")) {
                lbVar.cu(jSONObject.getString("rotation"));
            }
            if (jSONObject.has("immediately_place_model")) {
                boolean z = true;
                if (jSONObject.getInt("immediately_place_model") != 1) {
                    z = false;
                }
                lbVar.ag(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lbVar;
    }
}

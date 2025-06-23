package com.iflytek.sparkchain.plugins.map.tools;

import android.util.Log;
import com.iflytek.sparkchain.plugins.base.BaseTool;
import com.iflytek.sparkchain.plugins.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class a extends BaseTool {
    public a() {
        init();
    }

    private void init() {
        this.argsSchema = new com.iflytek.sparkchain.plugins.ifla.ifla.a();
        this.description = "路线规划或导航。";
        this.name = MapPlugin.MapSearchTool;
    }

    @Override // com.iflytek.sparkchain.plugins.base.BaseTool
    public Object run(Object obj, String... strArr) {
        Log.d(Utils.TAG, obj.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("area", "");
            JSONObject jSONObject2 = new JSONObject(obj.toString());
            if (jSONObject2.has("destination") && jSONObject2.get("destination").getClass().equals(String.class)) {
                jSONObject.put("area", jSONObject2.get("destination"));
            }
        } catch (JSONException e) {
            Log.w(Utils.TAG, e.getMessage() + "");
        }
        return toResult(jSONObject.toString(), 0, "do search success!");
    }
}

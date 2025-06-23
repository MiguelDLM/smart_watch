package com.iflytek.sparkchain.plugins.music.tools;

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
        this.argsSchema = new com.iflytek.sparkchain.plugins.music.ifla.a();
        this.name = MusicPlugin.OperateTool;
        this.description = "歌曲切换。执行歌曲上、下一首切换";
    }

    @Override // com.iflytek.sparkchain.plugins.base.BaseTool
    public Object run(Object obj, String... strArr) {
        Log.i(Utils.TAG, " " + obj.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(obj.toString());
            if (jSONObject2.has("switch")) {
                jSONObject.put("switch", jSONObject2.get("switch"));
            } else {
                jSONObject.put("switch", "");
            }
            return toResult(jSONObject, 0, "do control music success!");
        } catch (JSONException e) {
            Log.e(Utils.TAG, e.getMessage() + "");
            return toResult(jSONObject, 19000, "do control music success!");
        }
    }
}

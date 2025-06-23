package com.iflytek.sparkchain.plugins.mail;

import android.util.Log;
import com.iflytek.sparkchain.plugins.utils.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ParseJson {
    public static JSONObject parseMailContent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("payload")) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("payload");
            if (!jSONObject2.has("plugins")) {
                return null;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("plugins");
            if (!jSONObject3.has("text")) {
                return null;
            }
            JSONArray jSONArray = jSONObject3.getJSONArray("text");
            if (jSONArray.length() > 0) {
                return (JSONObject) jSONArray.get(0);
            }
            return null;
        } catch (JSONException e) {
            Log.e(Utils.TAG, "parse sent_email json  failure: " + e.getMessage());
            return null;
        }
    }

    public static JSONObject parseSendJson(JSONObject jSONObject) {
        try {
            if ((!jSONObject.has("role") || "tool".equals(jSONObject.getString("role"))) && jSONObject.has("content")) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("content"));
                if (jSONObject2.has("args")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("args");
                    if (jSONObject3.has("parameters")) {
                        return jSONObject3.getJSONObject("parameters");
                    }
                }
            }
            return null;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}

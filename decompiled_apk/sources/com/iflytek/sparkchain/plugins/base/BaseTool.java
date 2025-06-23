package com.iflytek.sparkchain.plugins.base;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public abstract class BaseTool {
    public BaseModel argsSchema;
    public String description;
    public boolean isDirect = false;
    public String name;

    public abstract Object run(Object obj, String... strArr);

    public JSONObject toResult(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("msg", str2);
            jSONObject.put("result", str);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject toResult(JSONObject jSONObject, int i, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("code", i);
            jSONObject2.put("msg", str);
            jSONObject2.put("result", jSONObject);
            return jSONObject2;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}

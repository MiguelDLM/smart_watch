package com.iflytek.sparkchain.plugins.sms.tools;

import android.util.Log;
import com.iflytek.sparkchain.plugins.base.BaseTool;
import com.iflytek.sparkchain.plugins.utils.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class a extends BaseTool {
    public a() {
        init();
    }

    private void init() {
        this.argsSchema = new com.iflytek.sparkchain.plugins.ifld.ifla.a();
        this.description = "发送短信。";
        this.name = SMSPlugin.SMSTool;
    }

    @Override // com.iflytek.sparkchain.plugins.base.BaseTool
    public Object run(Object obj, String... strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(obj.toString());
            JSONArray jSONArray = new JSONArray();
            if (jSONObject2.has("to") && jSONObject2.get("to").getClass().equals(JSONArray.class)) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("to");
                for (int i = 0; i < jSONArray2.length(); i++) {
                    jSONArray.put(Utils.getContactsPhone(jSONArray2.getString(i)));
                }
            }
            jSONObject.put("to", jSONArray);
            if (jSONObject2.has("body") && jSONObject2.get("body").getClass().equals(String.class)) {
                jSONObject.put("body", jSONObject2.getString("body"));
            }
        } catch (JSONException e) {
            Log.e(Utils.TAG, e.getMessage() + " ");
        }
        return toResult(jSONObject.toString(), 0, "do sms success!");
    }
}

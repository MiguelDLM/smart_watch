package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class d {
    private final String aVB;
    private final LinkedHashMap<String, String> aVC = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    public d(String str) {
        this.aVB = str;
    }

    public synchronized JSONObject Pc() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.aVC.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("time", this.time);
                jSONObject.put("span_name", this.aVB);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }
}

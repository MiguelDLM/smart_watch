package com.jd.ad.sdk.jad_vi;

import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.logger.Logger;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_jw implements Serializable {
    public Double jad_an;
    public Double jad_bo;

    public jad_jw(JSONObject jSONObject) {
        Double valueOf = Double.valueOf(-1.0d);
        this.jad_an = valueOf;
        this.jad_bo = valueOf;
        if (jSONObject == null) {
            return;
        }
        jad_an(jSONObject);
    }

    public final void jad_an(JSONObject jSONObject) {
        try {
            this.jad_an = Double.valueOf(jSONObject.optDouble("lon"));
            this.jad_bo = Double.valueOf(jSONObject.optDouble("lat"));
        } catch (Exception e) {
            Logger.w("parse geo from json ", e.getMessage());
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            JsonUtils.put(jSONObject, "lon", this.jad_an);
            JsonUtils.put(jSONObject, "lat", this.jad_bo);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }
}

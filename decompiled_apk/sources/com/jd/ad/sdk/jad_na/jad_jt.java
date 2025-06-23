package com.jd.ad.sdk.jad_na;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_jt {
    public String jad_an;
    public String jad_bo;
    public String jad_cp;
    public String jad_dq;
    public String jad_er;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("deviceInfoList", this.jad_an);
            jSONObject.putOpt("screenInfoList", this.jad_bo);
            jSONObject.putOpt("osInfoList", this.jad_cp);
            jSONObject.putOpt("userInfoList", this.jad_dq);
            jSONObject.putOpt("realTimeInfoList", this.jad_er);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

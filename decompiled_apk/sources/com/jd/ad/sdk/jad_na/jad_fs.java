package com.jd.ad.sdk.jad_na;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.logger.Logger;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_fs {
    public int jad_an;
    public String jad_bo;
    public String jad_cp;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", Integer.valueOf(this.jad_an));
            jSONObject.putOpt("sn", this.jad_bo);
            jSONObject.putOpt("sa", this.jad_cp);
        } catch (Exception e) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an third info ");
            jad_an.append(e.getMessage());
            Logger.d(jad_an.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANThirdPlatformInfo{id=");
        jad_an.append(this.jad_an);
        jad_an.append(", sn='");
        jad_an.append(this.jad_bo);
        jad_an.append('\'');
        jad_an.append(", sa='");
        jad_an.append(this.jad_cp);
        jad_an.append('\'');
        jad_an.append('}');
        return jad_an.toString();
    }
}

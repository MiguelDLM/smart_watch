package com.jd.ad.sdk.jad_na;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.logger.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_bo {
    public String jad_an;
    public String jad_bo;
    public String jad_cp;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("eu", this.jad_cp);
            jSONObject.putOpt("ou", this.jad_an);
            jSONObject.putOpt("tu", this.jad_bo);
        } catch (JSONException e) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an api ");
            jad_an.append(e.getMessage());
            Logger.d(jad_an.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANApi{ou='");
        jad_an.append(this.jad_an);
        jad_an.append('\'');
        jad_an.append(", tu='");
        jad_an.append(this.jad_bo);
        jad_an.append('\'');
        jad_an.append(", eu='");
        jad_an.append(this.jad_cp);
        jad_an.append('\'');
        jad_an.append('}');
        return jad_an.toString();
    }
}

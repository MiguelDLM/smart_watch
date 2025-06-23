package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public String ayy;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.ayy = jSONObject.optString("adTrackLog");
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        com.kwad.sdk.utils.t.putValue(jSONObject, "adTrackLog", this.ayy);
    }
}

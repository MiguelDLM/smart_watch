package com.kwad.sdk.contentalliance.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public a() {
        this.clickTime = -1L;
    }

    @NonNull
    public static a bF(@NonNull AdTemplate adTemplate) {
        return new a(adTemplate, l.eo(adTemplate));
    }

    public final String BI() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e) {
            c.printStackTrace(e);
        }
        return jSONObject.toString();
    }

    public a(@NonNull AdTemplate adTemplate, long j) {
        this.clickTime = -1L;
        this.photoId = e.dY(adTemplate);
        this.clickTime = j;
        this.adStyle = e.dN(adTemplate);
        this.contentType = e.dO(adTemplate);
    }
}

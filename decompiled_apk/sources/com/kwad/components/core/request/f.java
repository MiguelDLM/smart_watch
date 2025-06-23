package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public f() {
        try {
            JSONArray jSONArray = new JSONArray();
            t.a(jSONArray, new JSONObject());
            putBody("impInfo", jSONArray);
            putBody("appTag", y.Ms());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.yG();
    }
}

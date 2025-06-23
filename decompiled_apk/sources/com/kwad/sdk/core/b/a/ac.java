package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ac implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.apT = jSONObject.optInt("ad_action_type");
        bVar.retryCount = jSONObject.optInt("retry_count");
        bVar.aqz = jSONObject.optInt("retry_error_code");
        bVar.aqA = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(bVar.aqA)) {
            bVar.aqA = "";
        }
        bVar.aqJ = jSONObject.optInt("cache_total_num");
        bVar.aqK = jSONObject.optInt("cache_num");
        bVar.aqL = jSONObject.optLong("cacheTimeMs");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i);
        }
        int i2 = bVar.apT;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_action_type", i2);
        }
        int i3 = bVar.retryCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retry_count", i3);
        }
        int i4 = bVar.aqz;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retry_error_code", i4);
        }
        String str = bVar.aqA;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retry_error_msg", bVar.aqA);
        }
        int i5 = bVar.aqJ;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cache_total_num", i5);
        }
        int i6 = bVar.aqK;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cache_num", i6);
        }
        long j = bVar.aqL;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cacheTimeMs", j);
        }
        return jSONObject;
    }
}

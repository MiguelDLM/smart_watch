package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ht implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.aBi = jSONObject.optInt("adPhotoCountForMedia");
        aVar.aBj = jSONObject.optBoolean("enablePreload");
        aVar.aBk = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.aBl = jSONObject.optInt("adLoadStrategy");
        aVar.aBm = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = aVar.posId;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j);
        }
        int i = aVar.aBi;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adPhotoCountForMedia", i);
        }
        boolean z = aVar.aBj;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enablePreload", z);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "increaseAdLoadTime", aVar.aBk);
        int i2 = aVar.aBl;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adLoadStrategy", i2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "drawAdForcedWatchTimes", aVar.aBm);
        return jSONObject;
    }
}

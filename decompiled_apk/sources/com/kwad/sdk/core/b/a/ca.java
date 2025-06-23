package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ca implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.h> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        a2(hVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        return b2(hVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.llsid = jSONObject.optLong("llsid");
        hVar.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        hVar.score = jSONObject.optInt("score");
        hVar.ayS = jSONObject.optInt("is_bidding");
        hVar.source = jSONObject.optString("source");
        if (JSONObject.NULL.toString().equals(hVar.source)) {
            hVar.source = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = hVar.llsid;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j);
        }
        long j2 = hVar.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j2);
        }
        int i = hVar.score;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "score", i);
        }
        int i2 = hVar.ayS;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_bidding", i2);
        }
        String str = hVar.source;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "source", hVar.source);
        }
        return jSONObject;
    }
}

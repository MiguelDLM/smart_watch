package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class gf implements com.kwad.sdk.core.d<FeedPageInfo.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedPageInfo.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedPageInfo.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(FeedPageInfo.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.materialType = jSONObject.optInt("material_type");
        aVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(aVar.materialUrl)) {
            aVar.materialUrl = "";
        }
        aVar.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedPageInfo.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.materialType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", i);
        }
        String str = aVar.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_url", aVar.materialUrl);
        }
        long j = aVar.creativeId;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j);
        }
        return jSONObject;
    }
}

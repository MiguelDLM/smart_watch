package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class au implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.apT = jSONObject.optInt("ad_action_type");
        bVar.apL = jSONObject.optString("origin_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.apL)) {
            bVar.apL = "";
        }
        bVar.apM = jSONObject.optString("final_url");
        if (obj.toString().equals(bVar.apM)) {
            bVar.apM = "";
        }
        bVar.apU = jSONObject.optInt("request_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
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
        String str = bVar.apL;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "origin_url", bVar.apL);
        }
        String str2 = bVar.apM;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "final_url", bVar.apM);
        }
        int i3 = bVar.apU;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_type", i3);
        }
        return jSONObject;
    }
}

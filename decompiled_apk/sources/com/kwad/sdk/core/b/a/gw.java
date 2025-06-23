package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class gw implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aAS = jSONObject.optString("mac");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(dVar.aAS)) {
            dVar.aAS = "";
        }
        dVar.aAT = jSONObject.optString("kMac");
        if (obj.toString().equals(dVar.aAT)) {
            dVar.aAT = "";
        }
        dVar.aAU = jSONObject.optInt("connectionType");
        dVar.aAV = jSONObject.optInt("operatorType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.aAS;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mac", dVar.aAS);
        }
        String str2 = dVar.aAT;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "kMac", dVar.aAT);
        }
        int i = dVar.aAU;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connectionType", i);
        }
        int i2 = dVar.aAV;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "operatorType", i2);
        }
        return jSONObject;
    }
}

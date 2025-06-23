package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class iv implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.smallApp.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.apj = jSONObject.optString("url_host");
        if (obj.toString().equals(bVar.apj)) {
            bVar.apj = "";
        }
        bVar.apq = jSONObject.optString("url_path");
        if (obj.toString().equals(bVar.apq)) {
            bVar.apq = "";
        }
        bVar.apO = jSONObject.optString("small_origin_id");
        if (obj.toString().equals(bVar.apO)) {
            bVar.apO = "";
        }
        bVar.apP = jSONObject.optString("small_app_id");
        if (obj.toString().equals(bVar.apP)) {
            bVar.apP = "";
        }
        bVar.apQ = jSONObject.optString("jump_from");
        if (obj.toString().equals(bVar.apQ)) {
            bVar.apQ = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.smallApp.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.apj;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url_host", bVar.apj);
        }
        String str3 = bVar.apq;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url_path", bVar.apq);
        }
        String str4 = bVar.apO;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "small_origin_id", bVar.apO);
        }
        String str5 = bVar.apP;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "small_app_id", bVar.apP);
        }
        String str6 = bVar.apQ;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jump_from", bVar.apQ);
        }
        return jSONObject;
    }
}

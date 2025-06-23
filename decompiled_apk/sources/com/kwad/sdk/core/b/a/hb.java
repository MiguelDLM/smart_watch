package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class hb implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(nVar.url)) {
            nVar.url = "";
        }
        nVar.title = jSONObject.optString("title");
        if (obj.toString().equals(nVar.title)) {
            nVar.title = "";
        }
        nVar.abb = jSONObject.optBoolean("showConfirmDialog");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = nVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", nVar.url);
        }
        String str2 = nVar.title;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", nVar.title);
        }
        boolean z = nVar.abb;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showConfirmDialog", z);
        }
        return jSONObject;
    }
}

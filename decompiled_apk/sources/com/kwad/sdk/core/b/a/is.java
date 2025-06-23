package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class is implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.s> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.s sVar, JSONObject jSONObject) {
        a2(sVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.s sVar, JSONObject jSONObject) {
        return b2(sVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sVar.message = jSONObject.optString("message");
        if (JSONObject.NULL.toString().equals(sVar.message)) {
            sVar.message = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = sVar.message;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "message", sVar.message);
        }
        return jSONObject;
    }
}

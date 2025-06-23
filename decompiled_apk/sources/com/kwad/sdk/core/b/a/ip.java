package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ip implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.q> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.abd = jSONObject.optBoolean("userForce");
        qVar.type = jSONObject.optInt("type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = qVar.abd;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userForce", z);
        }
        int i = qVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i);
        }
        return jSONObject;
    }
}

package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class jf implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.u> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        a2(uVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        return b2(uVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uVar.nF = jSONObject.optInt("currentTime");
        uVar.abf = jSONObject.optBoolean("finished");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = uVar.nF;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i);
        }
        boolean z = uVar.abf;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "finished", z);
        }
        return jSONObject;
    }
}

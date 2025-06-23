package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class kt implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.y> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        a2(yVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        return b2(yVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.nF = jSONObject.optInt("currentTime");
        yVar.abj = jSONObject.optBoolean("failed");
        yVar.abf = jSONObject.optBoolean("finished");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = yVar.nF;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i);
        }
        boolean z = yVar.abj;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failed", z);
        }
        boolean z2 = yVar.abf;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "finished", z2);
        }
        return jSONObject;
    }
}

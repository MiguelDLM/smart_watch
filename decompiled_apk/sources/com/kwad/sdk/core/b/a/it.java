package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class it implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.t> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        a2(tVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        return b2(tVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tVar.abe = jSONObject.optBoolean("needPromopt");
        tVar.Lf = jSONObject.optBoolean("needReport");
        tVar.showTime = jSONObject.optInt("showTime");
        tVar.WF = jSONObject.optLong("playDuration");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = tVar.abe;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needPromopt", z);
        }
        boolean z2 = tVar.Lf;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needReport", z2);
        }
        int i = tVar.showTime;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showTime", i);
        }
        long j = tVar.WF;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j);
        }
        return jSONObject;
    }
}

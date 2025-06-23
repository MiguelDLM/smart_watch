package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class km implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.w> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.w wVar, JSONObject jSONObject) {
        a2(wVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.w wVar, JSONObject jSONObject) {
        return b2(wVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.w wVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        wVar.abh = jSONObject.optInt("videoCloseTime", new Integer("0").intValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.w wVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "videoCloseTime", wVar.abh);
        return jSONObject;
    }
}

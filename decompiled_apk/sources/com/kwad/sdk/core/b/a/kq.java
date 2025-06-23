package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class kq implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.x> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        a2(xVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        return b2(xVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xVar.abi = jSONObject.optString("status");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(xVar.abi)) {
            xVar.abi = "";
        }
        xVar.errorCode = jSONObject.optInt("errorCode");
        xVar.errorReason = jSONObject.optString("errorReason");
        if (obj.toString().equals(xVar.errorReason)) {
            xVar.errorReason = "";
        }
        xVar.nF = jSONObject.optInt("currentTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.x xVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = xVar.abi;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", xVar.abi);
        }
        int i = xVar.errorCode;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", i);
        }
        String str2 = xVar.errorReason;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorReason", xVar.errorReason);
        }
        int i2 = xVar.nF;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentTime", i2);
        }
        return jSONObject;
    }
}

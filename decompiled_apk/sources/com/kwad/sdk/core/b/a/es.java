package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class es implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aFE = jSONObject.optString("Access-Control-Allow-Origin");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aFE)) {
            aVar.aFE = "";
        }
        aVar.aFF = jSONObject.optString("Timing-Allow-Origin");
        if (obj.toString().equals(aVar.aFF)) {
            aVar.aFF = "";
        }
        aVar.aFG = jSONObject.optString("content-type");
        if (obj.toString().equals(aVar.aFG)) {
            aVar.aFG = "";
        }
        aVar.aFH = jSONObject.optString("Date");
        if (obj.toString().equals(aVar.aFH)) {
            aVar.aFH = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aFE;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Access-Control-Allow-Origin", aVar.aFE);
        }
        String str2 = aVar.aFF;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Timing-Allow-Origin", aVar.aFF);
        }
        String str3 = aVar.aFG;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "content-type", aVar.aFG);
        }
        String str4 = aVar.aFH;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Date", aVar.aFH);
        }
        return jSONObject;
    }
}

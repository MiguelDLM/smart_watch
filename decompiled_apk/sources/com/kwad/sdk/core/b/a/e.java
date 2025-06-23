package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Yl = jSONObject.optBoolean("clickActionButton");
        aVar.Yn = jSONObject.optInt("area");
        aVar.kl = jSONObject.optInt("itemClickType");
        aVar.aFZ = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        com.kwad.sdk.core.webview.d.b.c cVar = new com.kwad.sdk.core.webview.d.b.c();
        aVar.Yo = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.Lf = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.Lt = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(aVar.Lt)) {
            aVar.Lt = "";
        }
        aVar.aGa = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
        aVar.aGb = jSONObject.optBoolean("isCallbackOnly");
        aVar.aGc = jSONObject.optBoolean("disableCallback");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.Yl;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickActionButton", z);
        }
        int i = aVar.Yn;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "area", i);
        }
        int i2 = aVar.kl;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "convertPageType", aVar.aFZ);
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.Yo);
        com.kwad.sdk.utils.t.putValue(jSONObject, "needReport", aVar.Lf);
        com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", aVar.creativeId);
        String str = aVar.Lt;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "liveItemId", aVar.Lt);
        }
        int i3 = aVar.aGa;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sceneType", i3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", aVar.adStyle);
        boolean z2 = aVar.aGb;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isCallbackOnly", z2);
        }
        boolean z3 = aVar.aGc;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableCallback", z3);
        }
        return jSONObject;
    }
}

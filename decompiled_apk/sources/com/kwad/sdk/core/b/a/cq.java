package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.al;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class cq implements com.kwad.sdk.core.d<al.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(al.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(al.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(al.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Yl = jSONObject.optBoolean("clickActionButton");
        aVar.Ym = jSONObject.optString("adTemplate");
        if (JSONObject.NULL.toString().equals(aVar.Ym)) {
            aVar.Ym = "";
        }
        aVar.Yn = jSONObject.optInt("area");
        com.kwad.sdk.core.webview.d.b.c cVar = new com.kwad.sdk.core.webview.d.b.c();
        aVar.Yo = cVar;
        cVar.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(al.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.Yl;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickActionButton", z);
        }
        String str = aVar.Ym;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adTemplate", aVar.Ym);
        }
        int i = aVar.Yn;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "area", i);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "logParam", aVar.Yo);
        return jSONObject;
    }
}

package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.config.item.h;
import com.sma.smartv3.ui.me.O0OOX0IIx;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ex implements com.kwad.sdk.core.d<h.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aux = jSONObject.optString(O0OOX0IIx.f23381X0o0xo);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aux)) {
            aVar.aux = "";
        }
        aVar.auy = jSONObject.optString("oaid");
        if (obj.toString().equals(aVar.auy)) {
            aVar.auy = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aux;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, O0OOX0IIx.f23381X0o0xo, aVar.aux);
        }
        String str2 = aVar.auy;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "oaid", aVar.auy);
        }
        return jSONObject;
    }
}

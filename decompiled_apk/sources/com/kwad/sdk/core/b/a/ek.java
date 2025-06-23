package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.h;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ek implements com.kwad.sdk.core.d<h.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.WM = jSONObject.optInt("playableSrc");
        bVar.WN = jSONObject.optInt("isMiddleEnd");
        bVar.MF = jSONObject.optInt("adType");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.WM;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableSrc", i);
        }
        int i2 = bVar.WN;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isMiddleEnd", i2);
        }
        int i3 = bVar.MF;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adType", i3);
        }
        return jSONObject;
    }
}

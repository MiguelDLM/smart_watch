package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.h.a.a.b;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class kc implements com.kwad.sdk.core.d<b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.nC = jSONObject.optInt("timerName");
        aVar.nD = jSONObject.optInt("time");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.nC;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timerName", i);
        }
        int i2 = aVar.nD;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "time", i2);
        }
        return jSONObject;
    }
}

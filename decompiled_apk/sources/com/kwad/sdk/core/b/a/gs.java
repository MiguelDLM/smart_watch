package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class gs implements com.kwad.sdk.core.d<a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.errorCode = jSONObject.optInt("errorCode");
        cVar.WE = jSONObject.optInt("extra");
        cVar.WF = jSONObject.optLong("playDuration");
        cVar.WG = jSONObject.optBoolean("clickRewardDialog");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = cVar.errorCode;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", i);
        }
        int i2 = cVar.WE;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extra", i2);
        }
        long j = cVar.WF;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j);
        }
        boolean z = cVar.WG;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickRewardDialog", z);
        }
        return jSONObject;
    }
}

package com.kwad.sdk.core.b.a;

import XIXIX.OOXIXo;
import com.kwad.components.core.webview.jshandler.an;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class fo implements com.kwad.sdk.core.d<an.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(an.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(an.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(an.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Yt = jSONObject.optDouble("progress");
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong("totalBytes");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(an.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = bVar.Yt;
        if (d != OOXIXo.f3760XO) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "progress", d);
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i);
        }
        long j = bVar.totalBytes;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "totalBytes", j);
        }
        return jSONObject;
    }
}

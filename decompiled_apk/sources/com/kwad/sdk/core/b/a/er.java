package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.bc;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class er implements com.kwad.sdk.core.d<bc.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(bc.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(bc.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(bc.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.visibility = jSONObject.optInt("visibility");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(bc.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.visibility;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "visibility", i);
        }
        return jSONObject;
    }
}

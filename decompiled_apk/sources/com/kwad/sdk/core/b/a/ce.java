package com.kwad.sdk.core.b.a;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ce implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.Lh = jSONObject.optString("payload");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(gVar.Lh)) {
            gVar.Lh = "";
        }
        gVar.actionType = jSONObject.optInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        gVar.Wy = jSONObject.optInt("adCacheId");
        gVar.JK = jSONObject.optString("creativeId");
        if (obj.toString().equals(gVar.JK)) {
            gVar.JK = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.Lh;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", gVar.Lh);
        }
        int i = gVar.actionType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, i);
        }
        int i2 = gVar.Wy;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheId", i2);
        }
        String str2 = gVar.JK;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", gVar.JK);
        }
        return jSONObject;
    }
}

package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class kl implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.aBd = jSONObject.optString("thirdUserId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(gVar.aBd)) {
            gVar.aBd = "";
        }
        gVar.aBe = jSONObject.optString("thirdUserName");
        if (obj.toString().equals(gVar.aBe)) {
            gVar.aBe = "";
        }
        gVar.thirdAge = jSONObject.optInt("thirdAge");
        gVar.thirdGender = jSONObject.optInt("thirdGender");
        gVar.thirdInterest = jSONObject.optString("thirdInterest");
        if (obj.toString().equals(gVar.thirdInterest)) {
            gVar.thirdInterest = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.aBd;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdUserId", gVar.aBd);
        }
        String str2 = gVar.aBe;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdUserName", gVar.aBe);
        }
        int i = gVar.thirdAge;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdAge", i);
        }
        int i2 = gVar.thirdGender;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdGender", i2);
        }
        String str3 = gVar.thirdInterest;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdInterest", gVar.thirdInterest);
        }
        return jSONObject;
    }
}

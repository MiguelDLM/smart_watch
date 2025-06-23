package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class m implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.apz = jSONObject.optString("method_name");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.apz)) {
            bVar.apz = "";
        }
        bVar.apA = jSONObject.optBoolean("is_convert");
        bVar.adNum = jSONObject.optInt("ad_num");
        bVar.apB = jSONObject.optBoolean("is_api_native");
        bVar.apC = jSONObject.optString("ad_request_type");
        if (obj.toString().equals(bVar.apC)) {
            bVar.apC = "";
        }
        bVar.adSource = jSONObject.optString("ad_require_source");
        if (obj.toString().equals(bVar.adSource)) {
            bVar.adSource = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.apz;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "method_name", bVar.apz);
        }
        boolean z = bVar.apA;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_convert", z);
        }
        int i = bVar.adNum;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_num", i);
        }
        boolean z2 = bVar.apB;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_api_native", z2);
        }
        String str2 = bVar.apC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_request_type", bVar.apC);
        }
        String str3 = bVar.adSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_require_source", bVar.adSource);
        }
        return jSONObject;
    }
}

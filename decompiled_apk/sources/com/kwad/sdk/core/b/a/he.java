package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class he implements com.kwad.sdk.core.d<com.kwad.sdk.g.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.g.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.g.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.g.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aJm = jSONObject.optString("packageId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aJm)) {
            bVar.aJm = "";
        }
        bVar.aJn = jSONObject.optString("zipFileName");
        if (obj.toString().equals(bVar.aJn)) {
            bVar.aJn = "";
        }
        bVar.aJo = jSONObject.optString("zipPath");
        if (obj.toString().equals(bVar.aJo)) {
            bVar.aJo = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (obj.toString().equals(bVar.packageUrl)) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (obj.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.akB = jSONObject.optString("checksum");
        if (obj.toString().equals(bVar.akB)) {
            bVar.akB = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.aJq = jSONObject.optBoolean("public");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.g.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aJm;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageId", bVar.aJm);
        }
        String str2 = bVar.aJn;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "zipFileName", bVar.aJn);
        }
        String str3 = bVar.aJo;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "zipPath", bVar.aJo);
        }
        String str4 = bVar.packageUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.akB;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "checksum", bVar.akB);
        }
        int i = bVar.loadType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadType", i);
        }
        int i2 = bVar.packageType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageType", i2);
        }
        boolean z = bVar.aJq;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "public", z);
        }
        return jSONObject;
    }
}

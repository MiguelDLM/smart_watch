package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class bc implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.apj = jSONObject.optString("url_host");
        if (obj.toString().equals(bVar.apj)) {
            bVar.apj = "";
        }
        bVar.downloadId = jSONObject.optString("download_id");
        if (obj.toString().equals(bVar.downloadId)) {
            bVar.downloadId = "";
        }
        bVar.apk = jSONObject.optString("apk_package");
        if (obj.toString().equals(bVar.apk)) {
            bVar.apk = "";
        }
        bVar.apl = jSONObject.optString("apk_name");
        if (obj.toString().equals(bVar.apl)) {
            bVar.apl = "";
        }
        bVar.apm = jSONObject.optLong("apk_size");
        bVar.downloadTime = jSONObject.optLong("download_time");
        bVar.apn = jSONObject.optLong("apk_cur_size");
        bVar.apo = jSONObject.optInt("apk_install_type");
        bVar.app = jSONObject.optInt("apk_install_source");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.commercial.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i);
        }
        String str = bVar.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", bVar.url);
        }
        String str2 = bVar.apj;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url_host", bVar.apj);
        }
        String str3 = bVar.downloadId;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_id", bVar.downloadId);
        }
        String str4 = bVar.apk;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_package", bVar.apk);
        }
        String str5 = bVar.apl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_name", bVar.apl);
        }
        long j = bVar.apm;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_size", j);
        }
        long j2 = bVar.downloadTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_time", j2);
        }
        long j3 = bVar.apn;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_cur_size", j3);
        }
        int i2 = bVar.apo;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_install_type", i2);
        }
        int i3 = bVar.app;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apk_install_source", i3);
        }
        return jSONObject;
    }
}

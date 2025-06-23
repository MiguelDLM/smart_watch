package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ah;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class kk implements com.kwad.sdk.core.d<ah.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ah.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ah.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.appName = jSONObject.optString("appName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.pkgName = jSONObject.optString("pkgName");
        if (obj.toString().equals(aVar.pkgName)) {
            aVar.pkgName = "";
        }
        aVar.version = jSONObject.optString("version");
        if (obj.toString().equals(aVar.version)) {
            aVar.version = "";
        }
        aVar.versionCode = jSONObject.optInt("versionCode");
        aVar.XR = jSONObject.optInt("appSize");
        aVar.md5 = jSONObject.optString("md5");
        if (obj.toString().equals(aVar.md5)) {
            aVar.md5 = "";
        }
        aVar.url = jSONObject.optString("url");
        if (obj.toString().equals(aVar.url)) {
            aVar.url = "";
        }
        aVar.XS = jSONObject.optString("appLink");
        if (obj.toString().equals(aVar.XS)) {
            aVar.XS = "";
        }
        aVar.icon = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cD);
        if (obj.toString().equals(aVar.icon)) {
            aVar.icon = "";
        }
        aVar.qc = jSONObject.optString("desc");
        if (obj.toString().equals(aVar.qc)) {
            aVar.qc = "";
        }
        aVar.appId = jSONObject.optString(com.huawei.openalliance.ad.uriaction.i.Code);
        if (obj.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.XT = jSONObject.optString("marketUri");
        if (obj.toString().equals(aVar.XT)) {
            aVar.XT = "";
        }
        aVar.XU = jSONObject.optBoolean("disableLandingPageDeepLink");
        aVar.XV = jSONObject.optBoolean("isLandscapeSupported");
        aVar.XW = jSONObject.optBoolean("isFromLive");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ah.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.type;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i);
        }
        String str = aVar.appName;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", aVar.appName);
        }
        String str2 = aVar.pkgName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pkgName", aVar.pkgName);
        }
        String str3 = aVar.version;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", aVar.version);
        }
        int i2 = aVar.versionCode;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "versionCode", i2);
        }
        int i3 = aVar.XR;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appSize", i3);
        }
        String str4 = aVar.md5;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "md5", aVar.md5);
        }
        String str5 = aVar.url;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", aVar.url);
        }
        String str6 = aVar.XS;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appLink", aVar.XS);
        }
        String str7 = aVar.icon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.openalliance.ad.constant.x.cD, aVar.icon);
        }
        String str8 = aVar.qc;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "desc", aVar.qc);
        }
        String str9 = aVar.appId;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.openalliance.ad.uriaction.i.Code, aVar.appId);
        }
        String str10 = aVar.XT;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "marketUri", aVar.XT);
        }
        boolean z = aVar.XU;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableLandingPageDeepLink", z);
        }
        boolean z2 = aVar.XV;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isLandscapeSupported", z2);
        }
        boolean z3 = aVar.XW;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isFromLive", z3);
        }
        return jSONObject;
    }
}

package com.kwad.sdk.core.b.a;

import com.baidu.ar.constants.HttpConstants;
import com.kwad.components.core.webview.jshandler.af;
import o0oIxXOx.oO;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class hr implements com.kwad.sdk.core.d<af.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(af.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(af.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Xz = jSONObject.optString("SDKVersion");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.Xz)) {
            aVar.Xz = "";
        }
        aVar.XA = jSONObject.optInt("SDKVersionCode");
        aVar.XB = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(aVar.XB)) {
            aVar.XB = "";
        }
        aVar.XC = jSONObject.optInt("sdkApiVersionCode");
        aVar.sdkType = jSONObject.optInt("sdkType");
        aVar.appVersion = jSONObject.optString("appVersion");
        if (obj.toString().equals(aVar.appVersion)) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString("appName");
        if (obj.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString(com.huawei.openalliance.ad.uriaction.i.Code);
        if (obj.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.XD = jSONObject.optString("networkType");
        if (obj.toString().equals(aVar.XD)) {
            aVar.XD = "";
        }
        aVar.XE = jSONObject.optString(HttpConstants.HTTP_MANUFACTURER);
        if (obj.toString().equals(aVar.XE)) {
            aVar.XE = "";
        }
        aVar.model = jSONObject.optString("model");
        if (obj.toString().equals(aVar.model)) {
            aVar.model = "";
        }
        aVar.XF = jSONObject.optString("deviceBrand");
        if (obj.toString().equals(aVar.XF)) {
            aVar.XF = "";
        }
        aVar.XG = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        aVar.XH = jSONObject.optString("systemVersion");
        if (obj.toString().equals(aVar.XH)) {
            aVar.XH = "";
        }
        aVar.f18465XI = jSONObject.optInt("osApi");
        aVar.XJ = jSONObject.optString("language");
        if (obj.toString().equals(aVar.XJ)) {
            aVar.XJ = "";
        }
        aVar.XK = jSONObject.optString(oO.f31191X0o0xo);
        if (obj.toString().equals(aVar.XK)) {
            aVar.XK = "";
        }
        aVar.XL = jSONObject.optInt("screenWidth");
        aVar.XM = jSONObject.optInt("screenHeight");
        aVar.XN = jSONObject.optInt("statusBarHeight");
        aVar.f18466XO = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.Xz;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersion", aVar.Xz);
        }
        int i = aVar.XA;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = aVar.XB;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", aVar.XB);
        }
        int i2 = aVar.XC;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = aVar.sdkType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i3);
        }
        String str3 = aVar.appVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        String str4 = aVar.appName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", aVar.appName);
        }
        String str5 = aVar.appId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.openalliance.ad.uriaction.i.Code, aVar.appId);
        }
        String str6 = aVar.XD;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "networkType", aVar.XD);
        }
        String str7 = aVar.XE;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HttpConstants.HTTP_MANUFACTURER, aVar.XE);
        }
        String str8 = aVar.model;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "model", aVar.model);
        }
        String str9 = aVar.XF;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", aVar.XF);
        }
        int i4 = aVar.XG;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, i4);
        }
        String str10 = aVar.XH;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemVersion", aVar.XH);
        }
        int i5 = aVar.f18465XI;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i5);
        }
        String str11 = aVar.XJ;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "language", aVar.XJ);
        }
        String str12 = aVar.XK;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, oO.f31191X0o0xo, aVar.XK);
        }
        int i6 = aVar.XL;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = aVar.XM;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i7);
        }
        int i8 = aVar.XN;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = aVar.f18466XO;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "titleBarHeight", i9);
        }
        return jSONObject;
    }
}

package com.kwad.sdk.core.b.a;

import com.baidu.ar.constants.HttpConstants;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.kwad.sdk.core.webview.d.a;
import com.sma.smartv3.ui.me.O0OOX0IIx;
import o0oIxXOx.oO;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ep implements com.kwad.sdk.core.d<a.C0861a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0861a c0861a, JSONObject jSONObject) {
        a2(c0861a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0861a c0861a, JSONObject jSONObject) {
        return b2(c0861a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0861a c0861a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0861a.Xz = jSONObject.optString("SDKVersion");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0861a.Xz)) {
            c0861a.Xz = "";
        }
        c0861a.XA = jSONObject.optInt("SDKVersionCode");
        c0861a.azQ = jSONObject.optString("tkVersion");
        if (obj.toString().equals(c0861a.azQ)) {
            c0861a.azQ = "";
        }
        c0861a.XB = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(c0861a.XB)) {
            c0861a.XB = "";
        }
        c0861a.XC = jSONObject.optInt("sdkApiVersionCode");
        c0861a.sdkType = jSONObject.optInt("sdkType");
        c0861a.appVersion = jSONObject.optString("appVersion");
        if (obj.toString().equals(c0861a.appVersion)) {
            c0861a.appVersion = "";
        }
        c0861a.appName = jSONObject.optString("appName");
        if (obj.toString().equals(c0861a.appName)) {
            c0861a.appName = "";
        }
        c0861a.appId = jSONObject.optString(com.huawei.openalliance.ad.uriaction.i.Code);
        if (obj.toString().equals(c0861a.appId)) {
            c0861a.appId = "";
        }
        c0861a.aFT = jSONObject.optString("globalId");
        if (obj.toString().equals(c0861a.aFT)) {
            c0861a.aFT = "";
        }
        c0861a.aAH = jSONObject.optString("eGid");
        if (obj.toString().equals(c0861a.aAH)) {
            c0861a.aAH = "";
        }
        c0861a.aAG = jSONObject.optString("deviceSig");
        if (obj.toString().equals(c0861a.aAG)) {
            c0861a.aAG = "";
        }
        c0861a.XD = jSONObject.optString("networkType");
        if (obj.toString().equals(c0861a.XD)) {
            c0861a.XD = "";
        }
        c0861a.XE = jSONObject.optString(HttpConstants.HTTP_MANUFACTURER);
        if (obj.toString().equals(c0861a.XE)) {
            c0861a.XE = "";
        }
        c0861a.model = jSONObject.optString("model");
        if (obj.toString().equals(c0861a.model)) {
            c0861a.model = "";
        }
        c0861a.XF = jSONObject.optString("deviceBrand");
        if (obj.toString().equals(c0861a.XF)) {
            c0861a.XF = "";
        }
        c0861a.XG = jSONObject.optInt(HttpConstants.HTTP_OS_TYPE_OLD);
        c0861a.XH = jSONObject.optString("systemVersion");
        if (obj.toString().equals(c0861a.XH)) {
            c0861a.XH = "";
        }
        c0861a.f18473XI = jSONObject.optInt("osApi");
        c0861a.XJ = jSONObject.optString("language");
        if (obj.toString().equals(c0861a.XJ)) {
            c0861a.XJ = "";
        }
        c0861a.XK = jSONObject.optString(oO.f31191X0o0xo);
        if (obj.toString().equals(c0861a.XK)) {
            c0861a.XK = "";
        }
        c0861a.aFU = jSONObject.optString(Constant.MAP_KEY_UUID);
        if (obj.toString().equals(c0861a.aFU)) {
            c0861a.aFU = "";
        }
        c0861a.aFV = jSONObject.optBoolean("isDynamic");
        c0861a.XL = jSONObject.optInt("screenWidth");
        c0861a.XM = jSONObject.optInt("screenHeight");
        c0861a.aux = jSONObject.optString(O0OOX0IIx.f23381X0o0xo);
        if (obj.toString().equals(c0861a.aux)) {
            c0861a.aux = "";
        }
        c0861a.auy = jSONObject.optString("oaid");
        if (obj.toString().equals(c0861a.auy)) {
            c0861a.auy = "";
        }
        c0861a.aAB = jSONObject.optString("androidId");
        if (obj.toString().equals(c0861a.aAB)) {
            c0861a.aAB = "";
        }
        c0861a.aAS = jSONObject.optString("mac");
        if (obj.toString().equals(c0861a.aAS)) {
            c0861a.aAS = "";
        }
        c0861a.XN = jSONObject.optInt("statusBarHeight");
        c0861a.f18474XO = jSONObject.optInt("titleBarHeight");
        c0861a.aFW = jSONObject.optString("bridgeVersion");
        if (obj.toString().equals(c0861a.aFW)) {
            c0861a.aFW = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0861a c0861a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0861a.Xz;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersion", c0861a.Xz);
        }
        int i = c0861a.XA;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersionCode", i);
        }
        String str2 = c0861a.azQ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tkVersion", c0861a.azQ);
        }
        String str3 = c0861a.XB;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", c0861a.XB);
        }
        int i2 = c0861a.XC;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersionCode", i2);
        }
        int i3 = c0861a.sdkType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i3);
        }
        String str4 = c0861a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", c0861a.appVersion);
        }
        String str5 = c0861a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", c0861a.appName);
        }
        String str6 = c0861a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.openalliance.ad.uriaction.i.Code, c0861a.appId);
        }
        String str7 = c0861a.aFT;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "globalId", c0861a.aFT);
        }
        String str8 = c0861a.aAH;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "eGid", c0861a.aAH);
        }
        String str9 = c0861a.aAG;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceSig", c0861a.aAG);
        }
        String str10 = c0861a.XD;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "networkType", c0861a.XD);
        }
        String str11 = c0861a.XE;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HttpConstants.HTTP_MANUFACTURER, c0861a.XE);
        }
        String str12 = c0861a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "model", c0861a.model);
        }
        String str13 = c0861a.XF;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", c0861a.XF);
        }
        int i4 = c0861a.XG;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, i4);
        }
        String str14 = c0861a.XH;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemVersion", c0861a.XH);
        }
        int i5 = c0861a.f18473XI;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i5);
        }
        String str15 = c0861a.XJ;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "language", c0861a.XJ);
        }
        String str16 = c0861a.XK;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, oO.f31191X0o0xo, c0861a.XK);
        }
        String str17 = c0861a.aFU;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, Constant.MAP_KEY_UUID, c0861a.aFU);
        }
        boolean z = c0861a.aFV;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isDynamic", z);
        }
        int i6 = c0861a.XL;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i6);
        }
        int i7 = c0861a.XM;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i7);
        }
        String str18 = c0861a.aux;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, O0OOX0IIx.f23381X0o0xo, c0861a.aux);
        }
        String str19 = c0861a.auy;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "oaid", c0861a.auy);
        }
        String str20 = c0861a.aAB;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "androidId", c0861a.aAB);
        }
        String str21 = c0861a.aAS;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mac", c0861a.aAS);
        }
        int i8 = c0861a.XN;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "statusBarHeight", i8);
        }
        int i9 = c0861a.f18474XO;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "titleBarHeight", i9);
        }
        String str22 = c0861a.aFW;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bridgeVersion", c0861a.aFW);
        }
        return jSONObject;
    }
}

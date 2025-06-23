package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class dd implements com.kwad.sdk.core.d<AdInfo.DownloadSafeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        a2(downloadSafeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        return b2(downloadSafeInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadSafeInfo.permissionInfo = jSONObject.optString("permissionInfo");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(downloadSafeInfo.permissionInfo)) {
            downloadSafeInfo.permissionInfo = "";
        }
        downloadSafeInfo.appName = jSONObject.optString("appName");
        if (obj.toString().equals(downloadSafeInfo.appName)) {
            downloadSafeInfo.appName = "";
        }
        downloadSafeInfo.corporationName = jSONObject.optString("corporationName");
        if (obj.toString().equals(downloadSafeInfo.corporationName)) {
            downloadSafeInfo.corporationName = "";
        }
        downloadSafeInfo.packageSize = jSONObject.optLong("packageSize");
        downloadSafeInfo.appVersion = jSONObject.optString("appVersion");
        if (obj.toString().equals(downloadSafeInfo.appVersion)) {
            downloadSafeInfo.appVersion = "";
        }
        downloadSafeInfo.appPrivacyUrl = jSONObject.optString("appPrivacyUrl");
        if (obj.toString().equals(downloadSafeInfo.appPrivacyUrl)) {
            downloadSafeInfo.appPrivacyUrl = "";
        }
        downloadSafeInfo.appPermissionInfoUrl = jSONObject.optString("appPermissionInfoUrl");
        if (obj.toString().equals(downloadSafeInfo.appPermissionInfoUrl)) {
            downloadSafeInfo.appPermissionInfoUrl = "";
        }
        downloadSafeInfo.introductionInfo = jSONObject.optString("introductionInfo");
        if (obj.toString().equals(downloadSafeInfo.introductionInfo)) {
            downloadSafeInfo.introductionInfo = "";
        }
        downloadSafeInfo.introductionInfoUrl = jSONObject.optString("introductionInfoUrl");
        if (obj.toString().equals(downloadSafeInfo.introductionInfoUrl)) {
            downloadSafeInfo.introductionInfoUrl = "";
        }
        downloadSafeInfo.secWindowPopNoWifiSwitch = jSONObject.optBoolean("secWindowPopNoWifiSwitch");
        downloadSafeInfo.secWindowPopSwitch = jSONObject.optBoolean("secWindowPopSwitch");
        downloadSafeInfo.downloadPauseEnable = jSONObject.optBoolean("downloadPauseEnable", new Boolean("false").booleanValue());
        downloadSafeInfo.windowPopUrl = jSONObject.optString("windowPopUrl");
        if (obj.toString().equals(downloadSafeInfo.windowPopUrl)) {
            downloadSafeInfo.windowPopUrl = "";
        }
        downloadSafeInfo.webPageTipbarSwitch = jSONObject.optBoolean("webPageTipbarSwitch", new Boolean("false").booleanValue());
        downloadSafeInfo.webPageTipbarText = jSONObject.optString("webPageTipbarText");
        if (obj.toString().equals(downloadSafeInfo.webPageTipbarText)) {
            downloadSafeInfo.webPageTipbarText = "";
        }
        downloadSafeInfo.autoDownloadUrl = jSONObject.optString("autoDownloadUrl");
        if (obj.toString().equals(downloadSafeInfo.autoDownloadUrl)) {
            downloadSafeInfo.autoDownloadUrl = "";
        }
        AdInfo.ComplianceInfo complianceInfo = new AdInfo.ComplianceInfo();
        downloadSafeInfo.complianceInfo = complianceInfo;
        complianceInfo.parseJson(jSONObject.optJSONObject("complianceInfo"));
        downloadSafeInfo.recordNumber = jSONObject.optString("recordNumber");
        if (obj.toString().equals(downloadSafeInfo.recordNumber)) {
            downloadSafeInfo.recordNumber = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = downloadSafeInfo.permissionInfo;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "permissionInfo", downloadSafeInfo.permissionInfo);
        }
        String str2 = downloadSafeInfo.appName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", downloadSafeInfo.appName);
        }
        String str3 = downloadSafeInfo.corporationName;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "corporationName", downloadSafeInfo.corporationName);
        }
        long j = downloadSafeInfo.packageSize;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageSize", j);
        }
        String str4 = downloadSafeInfo.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", downloadSafeInfo.appVersion);
        }
        String str5 = downloadSafeInfo.appPrivacyUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
        }
        String str6 = downloadSafeInfo.appPermissionInfoUrl;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appPermissionInfoUrl", downloadSafeInfo.appPermissionInfoUrl);
        }
        String str7 = downloadSafeInfo.introductionInfo;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "introductionInfo", downloadSafeInfo.introductionInfo);
        }
        String str8 = downloadSafeInfo.introductionInfoUrl;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "introductionInfoUrl", downloadSafeInfo.introductionInfoUrl);
        }
        boolean z = downloadSafeInfo.secWindowPopNoWifiSwitch;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "secWindowPopNoWifiSwitch", z);
        }
        boolean z2 = downloadSafeInfo.secWindowPopSwitch;
        if (z2) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "secWindowPopSwitch", z2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
        String str9 = downloadSafeInfo.windowPopUrl;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "windowPopUrl", downloadSafeInfo.windowPopUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
        String str10 = downloadSafeInfo.webPageTipbarText;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
        }
        String str11 = downloadSafeInfo.autoDownloadUrl;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "autoDownloadUrl", downloadSafeInfo.autoDownloadUrl);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "complianceInfo", downloadSafeInfo.complianceInfo);
        String str12 = downloadSafeInfo.recordNumber;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "recordNumber", downloadSafeInfo.recordNumber);
        }
        return jSONObject;
    }
}

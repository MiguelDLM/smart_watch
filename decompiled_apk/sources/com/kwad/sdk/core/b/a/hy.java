package com.kwad.sdk.core.b.a;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.huawei.openalliance.ad.constant.bn;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.scene.URLPackage;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class hy implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.timestamp = jSONObject.optLong("timestamp");
        nVar.sessionId = jSONObject.optString("sessionId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(nVar.sessionId)) {
            nVar.sessionId = "";
        }
        nVar.Jg = jSONObject.optLong("seq");
        nVar.ayV = jSONObject.optLong("listId");
        nVar.actionType = jSONObject.optLong(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        nVar.Lh = jSONObject.optString("payload");
        if (obj.toString().equals(nVar.Lh)) {
            nVar.Lh = "";
        }
        nVar.llsid = jSONObject.optLong("llsid");
        nVar.ayW = jSONObject.optJSONObject("extra");
        nVar.ayX = jSONObject.optJSONObject("impAdExtra");
        nVar.posId = jSONObject.optLong("posId");
        nVar.contentType = jSONObject.optInt("contentType");
        nVar.realShowType = jSONObject.optInt("realShowType");
        nVar.photoId = jSONObject.optLong("photoId");
        nVar.position = jSONObject.optLong(RequestParameters.POSITION);
        nVar.ayY = jSONObject.optLong("serverPosition");
        nVar.ayZ = jSONObject.optLong("photoDuration");
        nVar.aza = jSONObject.optLong("effectivePlayDuration");
        nVar.WF = jSONObject.optLong("playDuration");
        nVar.blockDuration = jSONObject.optLong("blockDuration");
        nVar.azb = jSONObject.optLong("intervalDuration");
        nVar.azc = jSONObject.optLong("allIntervalDuration");
        nVar.azd = jSONObject.optLong("flowSdk");
        nVar.aze = jSONObject.optLong("blockTimes");
        nVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        nVar.are = jSONObject.optInt("adAggPageSource");
        nVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (obj.toString().equals(nVar.entryPageSource)) {
            nVar.entryPageSource = "";
        }
        URLPackage uRLPackage = new URLPackage();
        nVar.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        nVar.azf = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        nVar.SK = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        nVar.azg = jSONObject.optString("photoSize");
        if (obj.toString().equals(nVar.azg)) {
            nVar.azg = "";
        }
        nVar.azh = jSONObject.optJSONArray("appInstalled");
        nVar.azi = jSONObject.optJSONArray("appUninstalled");
        n.a aVar = new n.a();
        nVar.azj = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        nVar.azk = jSONObject.optInt("playerType");
        nVar.azl = jSONObject.optInt("uiType");
        nVar.azm = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        nVar.Ye = jSONObject.optInt("refreshType");
        nVar.azn = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        nVar.azo = jSONObject.optString("failUrl");
        if (obj.toString().equals(nVar.azo)) {
            nVar.azo = "";
        }
        nVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (obj.toString().equals(nVar.errorMsg)) {
            nVar.errorMsg = "";
        }
        nVar.errorCode = jSONObject.optInt("errorCode", new Integer("0").intValue());
        nVar.creativeId = jSONObject.optLong("creativeId");
        nVar.azr = jSONObject.optString("cacheFailedReason");
        if (obj.toString().equals(nVar.azr)) {
            nVar.azr = "";
        }
        nVar.azs = jSONObject.optJSONObject("appExt");
        nVar.azt = jSONObject.optJSONArray("appRunningInfoList");
        nVar.downloadDuration = jSONObject.optLong("downloadDuration");
        nVar.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        nVar.azu = jSONObject.optInt("speedLimitStatus");
        nVar.azv = jSONObject.optInt("speedLimitThreshold");
        nVar.azw = jSONObject.optInt("currentRealDownloadSpeed");
        nVar.azy = jSONObject.optJSONArray("sdkPlatform");
        nVar.azz = jSONObject.optBoolean("isKsUnion");
        nVar.azA = jSONObject.optString("trackMethodName");
        if (obj.toString().equals(nVar.azA)) {
            nVar.azA = "";
        }
        nVar.azB = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        nVar.clickTime = jSONObject.optLong("clickTime");
        nVar.azD = jSONObject.optLong("frameRenderTime");
        nVar.azE = jSONObject.optInt("playerEnterAction");
        nVar.azF = jSONObject.optString("requestUrl");
        if (obj.toString().equals(nVar.azF)) {
            nVar.azF = "";
        }
        nVar.azG = jSONObject.optLong("requestTotalTime");
        nVar.azH = jSONObject.optLong("requestResponseTime");
        nVar.azI = jSONObject.optLong("requestParseDataTime");
        nVar.azJ = jSONObject.optLong("requestCallbackTime");
        nVar.azK = jSONObject.optString("requestFailReason");
        if (obj.toString().equals(nVar.azK)) {
            nVar.azK = "";
        }
        nVar.RH = jSONObject.optString("pageName");
        if (obj.toString().equals(nVar.RH)) {
            nVar.RH = "";
        }
        nVar.RP = jSONObject.optLong("pageCreateTime");
        nVar.RQ = jSONObject.optLong("pageResumeTime");
        nVar.azL = jSONObject.optInt("trackUrlType");
        nVar.azM = jSONObject.optJSONArray("trackUrlList");
        nVar.RO = jSONObject.optLong("pageLaunchTime");
        nVar.azP = jSONObject.optJSONArray("appAuthorityInfoList");
        nVar.azQ = jSONObject.optString("tkVersion");
        if (obj.toString().equals(nVar.azQ)) {
            nVar.azQ = "";
        }
        nVar.azR = jSONObject.optString("jsVersion");
        if (obj.toString().equals(nVar.azR)) {
            nVar.azR = "";
        }
        nVar.azS = jSONObject.optString("jsFileName");
        if (obj.toString().equals(nVar.azS)) {
            nVar.azS = "";
        }
        nVar.azT = jSONObject.optString("jsErrorMsg");
        if (obj.toString().equals(nVar.azT)) {
            nVar.azT = "";
        }
        nVar.azU = jSONObject.optString("jsConfig");
        if (obj.toString().equals(nVar.azU)) {
            nVar.azU = "";
        }
        nVar.azV = jSONObject.optInt("adBizType");
        nVar.azW = jSONObject.optString("customKey");
        if (obj.toString().equals(nVar.azW)) {
            nVar.azW = "";
        }
        nVar.azX = jSONObject.optString("customValue");
        if (obj.toString().equals(nVar.azX)) {
            nVar.azX = "";
        }
        nVar.trace = jSONObject.optString(MqttServiceConstants.TRACE_ACTION);
        if (obj.toString().equals(nVar.trace)) {
            nVar.trace = "";
        }
        nVar.azY = jSONObject.optInt("filterCode");
        nVar.azZ = jSONObject.optInt("sdkVersionCode");
        nVar.sdkVersion = jSONObject.optString(bn.f.Code);
        if (obj.toString().equals(nVar.sdkVersion)) {
            nVar.sdkVersion = "";
        }
        nVar.aAa = jSONObject.optString("adSdkVersion");
        if (obj.toString().equals(nVar.aAa)) {
            nVar.aAa = "";
        }
        nVar.XB = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(nVar.XB)) {
            nVar.XB = "";
        }
        nVar.sdkType = jSONObject.optInt("sdkType");
        nVar.aAb = jSONObject.optLong("appUseDuration");
        nVar.aAc = jSONObject.optLong("appStartType");
        nVar.avo = jSONObject.optLong("sequenceNumber");
        nVar.Jd = jSONObject.optString("appColdStart");
        if (obj.toString().equals(nVar.Jd)) {
            nVar.Jd = "";
        }
        nVar.Je = jSONObject.optString("appStart");
        if (obj.toString().equals(nVar.Je)) {
            nVar.Je = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = nVar.timestamp;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timestamp", j);
        }
        String str = nVar.sessionId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sessionId", nVar.sessionId);
        }
        long j2 = nVar.Jg;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "seq", j2);
        }
        long j3 = nVar.ayV;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "listId", j3);
        }
        long j4 = nVar.actionType;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, j4);
        }
        String str2 = nVar.Lh;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", nVar.Lh);
        }
        long j5 = nVar.llsid;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "extra", nVar.ayW);
        com.kwad.sdk.utils.t.putValue(jSONObject, "impAdExtra", nVar.ayX);
        long j6 = nVar.posId;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j6);
        }
        int i = nVar.contentType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "contentType", i);
        }
        int i2 = nVar.realShowType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "realShowType", i2);
        }
        long j7 = nVar.photoId;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoId", j7);
        }
        long j8 = nVar.position;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, RequestParameters.POSITION, j8);
        }
        long j9 = nVar.ayY;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverPosition", j9);
        }
        long j10 = nVar.ayZ;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoDuration", j10);
        }
        long j11 = nVar.aza;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "effectivePlayDuration", j11);
        }
        long j12 = nVar.WF;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j12);
        }
        long j13 = nVar.blockDuration;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockDuration", j13);
        }
        long j14 = nVar.azb;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "intervalDuration", j14);
        }
        long j15 = nVar.azc;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "allIntervalDuration", j15);
        }
        long j16 = nVar.azd;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "flowSdk", j16);
        }
        long j17 = nVar.aze;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockTimes", j17);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "contentSourceType", nVar.contentSourceType);
        int i3 = nVar.are;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAggPageSource", i3);
        }
        String str3 = nVar.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "entryPageSource", nVar.entryPageSource);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", nVar.urlPackage);
        com.kwad.sdk.utils.t.a(jSONObject, "referURLPackage", nVar.azf);
        long j18 = nVar.SK;
        if (j18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j18);
        }
        String str4 = nVar.azg;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoSize", nVar.azg);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appInstalled", nVar.azh);
        com.kwad.sdk.utils.t.putValue(jSONObject, "appUninstalled", nVar.azi);
        com.kwad.sdk.utils.t.a(jSONObject, "clientExt", nVar.azj);
        int i4 = nVar.azk;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playerType", i4);
        }
        int i5 = nVar.azl;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "uiType", i5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "isLeftSlipStatus", nVar.azm);
        int i6 = nVar.Ye;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshType", i6);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "photoResponseType", nVar.azn);
        String str5 = nVar.azo;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failUrl", nVar.azo);
        }
        String str6 = nVar.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, nVar.errorMsg);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", nVar.errorCode);
        long j19 = nVar.creativeId;
        if (j19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", j19);
        }
        String str7 = nVar.azr;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cacheFailedReason", nVar.azr);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appExt", nVar.azs);
        com.kwad.sdk.utils.t.putValue(jSONObject, "appRunningInfoList", nVar.azt);
        long j20 = nVar.downloadDuration;
        if (j20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadDuration", j20);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "pageType", nVar.pageType);
        int i7 = nVar.azu;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speedLimitStatus", i7);
        }
        int i8 = nVar.azv;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speedLimitThreshold", i8);
        }
        int i9 = nVar.azw;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentRealDownloadSpeed", i9);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "sdkPlatform", nVar.azy);
        boolean z = nVar.azz;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isKsUnion", z);
        }
        String str8 = nVar.azA;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trackMethodName", nVar.azA);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "viewModeType", nVar.azB);
        long j21 = nVar.clickTime;
        if (j21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickTime", j21);
        }
        long j22 = nVar.azD;
        if (j22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "frameRenderTime", j22);
        }
        int i10 = nVar.azE;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playerEnterAction", i10);
        }
        String str9 = nVar.azF;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestUrl", nVar.azF);
        }
        long j23 = nVar.azG;
        if (j23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestTotalTime", j23);
        }
        long j24 = nVar.azH;
        if (j24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestResponseTime", j24);
        }
        long j25 = nVar.azI;
        if (j25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestParseDataTime", j25);
        }
        long j26 = nVar.azJ;
        if (j26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestCallbackTime", j26);
        }
        String str10 = nVar.azK;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestFailReason", nVar.azK);
        }
        String str11 = nVar.RH;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageName", nVar.RH);
        }
        long j27 = nVar.RP;
        if (j27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageCreateTime", j27);
        }
        long j28 = nVar.RQ;
        if (j28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageResumeTime", j28);
        }
        int i11 = nVar.azL;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trackUrlType", i11);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "trackUrlList", nVar.azM);
        long j29 = nVar.RO;
        if (j29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageLaunchTime", j29);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appAuthorityInfoList", nVar.azP);
        String str12 = nVar.azQ;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tkVersion", nVar.azQ);
        }
        String str13 = nVar.azR;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsVersion", nVar.azR);
        }
        String str14 = nVar.azS;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsFileName", nVar.azS);
        }
        String str15 = nVar.azT;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsErrorMsg", nVar.azT);
        }
        String str16 = nVar.azU;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsConfig", nVar.azU);
        }
        int i12 = nVar.azV;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adBizType", i12);
        }
        String str17 = nVar.azW;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "customKey", nVar.azW);
        }
        String str18 = nVar.azX;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "customValue", nVar.azX);
        }
        String str19 = nVar.trace;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MqttServiceConstants.TRACE_ACTION, nVar.trace);
        }
        int i13 = nVar.azY;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "filterCode", i13);
        }
        int i14 = nVar.azZ;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkVersionCode", i14);
        }
        String str20 = nVar.sdkVersion;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, bn.f.Code, nVar.sdkVersion);
        }
        String str21 = nVar.aAa;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adSdkVersion", nVar.aAa);
        }
        String str22 = nVar.XB;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", nVar.XB);
        }
        int i15 = nVar.sdkType;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i15);
        }
        long j30 = nVar.aAb;
        if (j30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appUseDuration", j30);
        }
        long j31 = nVar.aAc;
        if (j31 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStartType", j31);
        }
        long j32 = nVar.avo;
        if (j32 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sequenceNumber", j32);
        }
        String str23 = nVar.Jd;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appColdStart", nVar.Jd);
        }
        String str24 = nVar.Je;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStart", nVar.Je);
        }
        return jSONObject;
    }
}

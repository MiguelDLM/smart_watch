package com.kwad.sdk.core.b.a;

import XIXIX.OOXIXo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.qq.e.comm.pi.IBidding;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ae implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdTemplate adTemplate = new AdTemplate();
        aVar.adTemplate = adTemplate;
        adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        aVar.aqN = jSONObject.optJSONObject("extData");
        aVar.apT = jSONObject.optInt("adActionType");
        aVar.aqO = jSONObject.optInt("photoPlaySecond");
        aVar.aqP = jSONObject.optInt("awardReceiveStage");
        aVar.kl = jSONObject.optInt("itemClickType");
        aVar.aqQ = jSONObject.optInt("itemCloseType");
        aVar.aqR = jSONObject.optInt("elementType");
        aVar.aqS = jSONObject.optString("adRenderArea");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aqS)) {
            aVar.aqS = "";
        }
        aVar.aqT = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        aVar.aqU = jSONObject.optInt("impFailReason");
        aVar.aqV = jSONObject.optLong("winEcpm");
        aVar.adnType = jSONObject.optInt("adnType");
        aVar.adnName = jSONObject.optString(MediationConstant.KEY_ADN_NAME);
        if (obj.toString().equals(aVar.adnName)) {
            aVar.adnName = "";
        }
        aVar.aqW = jSONObject.optInt("retainCodeType");
        aVar.Lj = jSONObject.optInt("photoSizeStyle");
        aVar.Lh = jSONObject.optString("payload");
        if (obj.toString().equals(aVar.Lh)) {
            aVar.Lh = "";
        }
        aVar.aqX = jSONObject.optInt("deeplinkType");
        aVar.aqY = jSONObject.optString("deeplinkAppName");
        if (obj.toString().equals(aVar.aqY)) {
            aVar.aqY = "";
        }
        aVar.aqZ = jSONObject.optInt("deeplinkFailedReason");
        aVar.downloadSource = jSONObject.optInt(com.huawei.hms.ads.fz.I);
        aVar.ara = jSONObject.optInt("isPackageChanged");
        aVar.arb = jSONObject.optString("installedFrom");
        if (obj.toString().equals(aVar.arb)) {
            aVar.arb = "";
        }
        aVar.arc = jSONObject.optString("downloadFailedReason");
        if (obj.toString().equals(aVar.arc)) {
            aVar.arc = "";
        }
        aVar.ard = jSONObject.optInt("isChangedEndcard");
        aVar.are = jSONObject.optInt("adAggPageSource");
        aVar.arf = jSONObject.optString("serverPackageName");
        if (obj.toString().equals(aVar.arf)) {
            aVar.arf = "";
        }
        aVar.arg = jSONObject.optString("installedPackageName");
        if (obj.toString().equals(aVar.arg)) {
            aVar.arg = "";
        }
        aVar.arh = jSONObject.optInt("closeButtonImpressionTime");
        aVar.ari = jSONObject.optInt("closeButtonClickTime");
        aVar.arj = jSONObject.optLong("landingPageLoadedDuration");
        aVar.LJ = jSONObject.optLong("leaveTime");
        aVar.ark = jSONObject.optLong("adItemClickBackDuration");
        aVar.arl = jSONObject.optInt("appStorePageType");
        aVar.arm = jSONObject.optInt("installStatus");
        aVar.downloadStatus = jSONObject.optInt("downloadStatus");
        aVar.arn = jSONObject.optInt("downloadCardType");
        a.C0845a c0845a = new a.C0845a();
        aVar.Li = c0845a;
        c0845a.parseJson(jSONObject.optJSONObject("clientExtData"));
        aVar.OP = jSONObject.optInt("landingPageType");
        aVar.vA = jSONObject.optLong("playedDuration");
        aVar.aro = jSONObject.optInt("playedRate");
        aVar.arp = jSONObject.optInt("adOrder");
        aVar.Lg = jSONObject.optInt("adInterstitialSource");
        aVar.ko = jSONObject.optDouble("splashShakeAcceleration");
        aVar.arq = jSONObject.optString("splashInteractionRotateAngle");
        if (obj.toString().equals(aVar.arq)) {
            aVar.arq = "";
        }
        aVar.arr = jSONObject.optInt("downloadInstallType");
        aVar.ars = jSONObject.optInt("businessSceneType");
        aVar.adxResult = jSONObject.optInt("adxResult");
        aVar.art = jSONObject.optInt("fingerSwipeType");
        aVar.aru = jSONObject.optInt("fingerSwipeDistance");
        aVar.Lk = jSONObject.optInt("triggerType");
        aVar.arv = jSONObject.optInt("cardCloseType");
        aVar.arw = jSONObject.optString("clientPkFailAdInfo");
        if (obj.toString().equals(aVar.arw)) {
            aVar.arw = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", aVar.adTemplate);
        com.kwad.sdk.utils.t.putValue(jSONObject, "extData", aVar.aqN);
        int i = aVar.apT;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adActionType", i);
        }
        int i2 = aVar.aqO;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoPlaySecond", i2);
        }
        int i3 = aVar.aqP;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "awardReceiveStage", i3);
        }
        int i4 = aVar.kl;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i4);
        }
        int i5 = aVar.aqQ;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemCloseType", i5);
        }
        int i6 = aVar.aqR;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "elementType", i6);
        }
        String str = aVar.aqS;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adRenderArea", aVar.aqS);
        }
        long j = aVar.aqT;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, IBidding.HIGHEST_LOSS_PRICE, j);
        }
        int i7 = aVar.aqU;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "impFailReason", i7);
        }
        long j2 = aVar.aqV;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "winEcpm", j2);
        }
        int i8 = aVar.adnType;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adnType", i8);
        }
        String str2 = aVar.adnName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        int i9 = aVar.aqW;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainCodeType", i9);
        }
        int i10 = aVar.Lj;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoSizeStyle", i10);
        }
        String str3 = aVar.Lh;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", aVar.Lh);
        }
        int i11 = aVar.aqX;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkType", i11);
        }
        String str4 = aVar.aqY;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkAppName", aVar.aqY);
        }
        int i12 = aVar.aqZ;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkFailedReason", i12);
        }
        int i13 = aVar.downloadSource;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.huawei.hms.ads.fz.I, i13);
        }
        int i14 = aVar.ara;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isPackageChanged", i14);
        }
        String str5 = aVar.arb;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installedFrom", aVar.arb);
        }
        String str6 = aVar.arc;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadFailedReason", aVar.arc);
        }
        int i15 = aVar.ard;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isChangedEndcard", i15);
        }
        int i16 = aVar.are;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAggPageSource", i16);
        }
        String str7 = aVar.arf;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverPackageName", aVar.arf);
        }
        String str8 = aVar.arg;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installedPackageName", aVar.arg);
        }
        int i17 = aVar.arh;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeButtonImpressionTime", i17);
        }
        int i18 = aVar.ari;
        if (i18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeButtonClickTime", i18);
        }
        long j3 = aVar.arj;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageLoadedDuration", j3);
        }
        long j4 = aVar.LJ;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leaveTime", j4);
        }
        long j5 = aVar.ark;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adItemClickBackDuration", j5);
        }
        int i19 = aVar.arl;
        if (i19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStorePageType", i19);
        }
        int i20 = aVar.arm;
        if (i20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installStatus", i20);
        }
        int i21 = aVar.downloadStatus;
        if (i21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadStatus", i21);
        }
        int i22 = aVar.arn;
        if (i22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadCardType", i22);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clientExtData", aVar.Li);
        int i23 = aVar.OP;
        if (i23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageType", i23);
        }
        long j6 = aVar.vA;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playedDuration", j6);
        }
        int i24 = aVar.aro;
        if (i24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playedRate", i24);
        }
        int i25 = aVar.arp;
        if (i25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adOrder", i25);
        }
        int i26 = aVar.Lg;
        if (i26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adInterstitialSource", i26);
        }
        double d = aVar.ko;
        if (d != OOXIXo.f3760XO) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "splashShakeAcceleration", d);
        }
        String str9 = aVar.arq;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "splashInteractionRotateAngle", aVar.arq);
        }
        int i27 = aVar.arr;
        if (i27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadInstallType", i27);
        }
        int i28 = aVar.ars;
        if (i28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "businessSceneType", i28);
        }
        int i29 = aVar.adxResult;
        if (i29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adxResult", i29);
        }
        int i30 = aVar.art;
        if (i30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fingerSwipeType", i30);
        }
        int i31 = aVar.aru;
        if (i31 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fingerSwipeDistance", i31);
        }
        int i32 = aVar.Lk;
        if (i32 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "triggerType", i32);
        }
        int i33 = aVar.arv;
        if (i33 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardCloseType", i33);
        }
        String str10 = aVar.arw;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clientPkFailAdInfo", aVar.arw);
        }
        return jSONObject;
    }
}

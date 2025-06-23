package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bh;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    private static Random aBf = new Random();

    public static int a(boolean z, @NonNull AdInfo adInfo) {
        if (z) {
            return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType;
        }
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.renderType;
    }

    @Nullable
    public static String cA(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cz(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static boolean cB(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cA(adTemplate))) {
            return true;
        }
        return false;
    }

    @Nullable
    private static String cC(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, e.dS(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static String cD(@NonNull AdTemplate adTemplate) {
        if (cE(adTemplate)) {
            return cC(adTemplate);
        }
        return a.aR(e.dS(adTemplate));
    }

    private static boolean cE(@NonNull AdTemplate adTemplate) {
        if (!adTemplate.mIsForceJumpLandingPage && !a.cb(adTemplate) && dq(e.dS(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo cF(@NonNull AdTemplate adTemplate) {
        if (cG(adTemplate)) {
            return ce(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo;
        }
        return ce(adTemplate).adDataV2.feedInfo;
    }

    private static boolean cG(@NonNull AdTemplate adTemplate) {
        if (a.cM(e.dS(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo cH(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    @Nullable
    public static String cI(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cF(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    private static AdMatrixInfo.FeedTKInfo cJ(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.feedTKCardInfo;
    }

    @Nullable
    public static String cK(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cH(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    @Nullable
    public static boolean cL(@NonNull AdTemplate adTemplate) {
        if (cF(adTemplate).interactionInfo.interactiveStyle == 2) {
            return true;
        }
        return false;
    }

    @Nullable
    public static boolean cM(@NonNull AdTemplate adTemplate) {
        return cF(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    @Nullable
    public static int cN(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cF(adTemplate).interactionInfo;
        if (adInteractionInfo != null && (shakeInfo = adInteractionInfo.shakeInfo) != null) {
            return shakeInfo.acceleration;
        }
        return 0;
    }

    public static double cO(@NonNull AdTemplate adTemplate) {
        return e.dS(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean cP(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cI(adTemplate))) {
            return true;
        }
        return false;
    }

    public static boolean cQ(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cJ(adTemplate).templateId)) {
            return true;
        }
        return false;
    }

    public static String cR(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo cJ = cJ(adTemplate);
        if (TextUtils.isEmpty(cJ.templateId)) {
            return "ksad-feed-card";
        }
        return cJ.templateId;
    }

    public static boolean cS(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cK(adTemplate))) {
            return true;
        }
        return false;
    }

    public static float cT(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = e.dS(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    public static boolean cU(@NonNull AdTemplate adTemplate) {
        try {
            if (e.dS(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static float cV(@NonNull AdTemplate adTemplate) {
        int i;
        try {
            i = e.dS(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static AdMatrixInfo.RotateInfo cW(@NonNull AdTemplate adTemplate) {
        try {
            return e.dS(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return null;
        }
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate cX(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.complianceCardInfo;
    }

    @Nullable
    public static String cY(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cX(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static boolean cZ(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cY(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    public static AdMatrixInfo ce(@NonNull AdTemplate adTemplate) {
        if (e.dK(adTemplate)) {
            return e.dS(adTemplate).adMatrixInfo;
        }
        return new AdMatrixInfo();
    }

    public static List<AdMatrixInfo.MatrixTemplate> cf(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).styles.templateList;
    }

    @NonNull
    public static AdMatrixInfo.AdDataV2 cg(@NonNull AdTemplate adTemplate) {
        return e.dS(adTemplate).adMatrixInfo.adDataV2;
    }

    public static FeedSlideConf ch(@NonNull AdTemplate adTemplate) {
        String str;
        JSONArray optJSONArray;
        AdMatrixInfo.TemplateData l = l(adTemplate, cF(adTemplate).templateId);
        if (l != null) {
            str = l.data;
        } else {
            str = "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("slideInfo");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("angle")) != null && optJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) optJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) optJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean ci(@NonNull AdTemplate adTemplate) {
        return n(adTemplate, cj(adTemplate).templateId);
    }

    @NonNull
    public static AdMatrixInfo.InterstitialCardInfo cj(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.interstitialCardInfo;
    }

    @Nullable
    public static String ck(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, ce(adTemplate).adDataV2.splashActionBarInfo.templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    @NonNull
    private static AdMatrixInfo.ActionBarInfoNew cl(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.actionBarInfo;
    }

    @Nullable
    public static String cm(@NonNull AdTemplate adTemplate) {
        boolean z;
        AdInfo dS = e.dS(adTemplate);
        int dM = e.dM(adTemplate);
        if (dM != 3 && dM != 2) {
            z = false;
        } else {
            z = true;
        }
        if (a.cM(dS)) {
            return "";
        }
        if (z && a.cd(adTemplate)) {
            AdMatrixInfo.MatrixTemplate k = k(adTemplate, dd(adTemplate).templateId);
            if (k == null) {
                return "";
            }
            return k.templateUrl;
        }
        AdMatrixInfo.MatrixTemplate k2 = k(adTemplate, cl(adTemplate).templateId);
        if (k2 == null) {
            return "";
        }
        return k2.templateUrl;
    }

    public static long cn(@NonNull AdTemplate adTemplate) {
        return cl(adTemplate).maxTimeOut;
    }

    public static boolean co(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cm(adTemplate))) {
            return true;
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.AggregationCardInfo cp(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.aggregationCardInfo;
    }

    @Nullable
    public static String cq(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cp(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static long cr(@NonNull AdTemplate adTemplate) {
        return m(adTemplate, cp(adTemplate).templateId);
    }

    public static long cs(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).changeTime * 1000;
    }

    public static int ct(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).maxTimesPerDay;
    }

    public static long cu(@NonNull AdTemplate adTemplate) {
        return cp(adTemplate).intervalTime;
    }

    public static boolean cv(@NonNull AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        if (!a.aE(dS) && a.as(dS)) {
            return true;
        }
        return false;
    }

    public static boolean cw(@NonNull AdTemplate adTemplate) {
        if (TextUtils.isEmpty(cq(adTemplate)) || cr(adTemplate) <= 0) {
            return false;
        }
        return aj.isOrientationPortrait();
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate cx(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.halfCardInfo;
    }

    @Nullable
    public static String cy(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, cx(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    @NonNull
    private static AdMatrixInfo.EndCardInfo cz(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.endCardInfo;
    }

    public static boolean dA(@NonNull AdInfo adInfo) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo;
        return adInteractionInfo.isMediaDisable && adInteractionInfo.interactiveStyle == 4;
    }

    public static boolean dB(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int dC(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    public static int dD(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    public static boolean dE(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2) {
            return true;
        }
        return false;
    }

    public static boolean dF(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1) {
            return true;
        }
        return false;
    }

    public static boolean dG(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1) {
            return true;
        }
        return false;
    }

    public static boolean dH(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3) {
            return true;
        }
        return false;
    }

    public static boolean dI(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10) {
            return true;
        }
        return false;
    }

    public static boolean dJ(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3) {
            return true;
        }
        return false;
    }

    public static boolean dK(@NonNull AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
            if (i != 4 && i != 9) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean dL(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle != 4) {
            return false;
        }
        return true;
    }

    public static boolean dM(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled) {
            return false;
        }
        return true;
    }

    public static long dN(@NonNull AdInfo adInfo) {
        try {
            long j = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j <= 0) {
                return 1500L;
            }
            return j;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    public static boolean dO(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled) {
            return false;
        }
        return true;
    }

    public static float dP(@NonNull AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static float dQ(@NonNull AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static String dR(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String dS(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String dT(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String dU(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts dV(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts dW(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean dX(@NonNull AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean dY(@NonNull AdInfo adInfo) {
        if (adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1) {
            return true;
        }
        return false;
    }

    public static boolean dZ(@NonNull AdInfo adInfo) {
        if (a.bI(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) {
            return false;
        }
        return true;
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate da(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    @Nullable
    public static String db(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = k(adTemplate, da(adTemplate).templateId);
        if (k != null) {
            return k.templateUrl;
        }
        return "";
    }

    public static boolean dc(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(db(adTemplate))) {
            return true;
        }
        return false;
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo dd(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo de(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.fullScreenInfo;
    }

    public static AdMatrixInfo.SplashPlayCardTKInfo df(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    public static long dg(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    public static int dh(@NonNull AdTemplate adTemplate) {
        return ce(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    public static boolean di(AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        if (g(dS) || e.ee(adTemplate) || cl(adTemplate).cardType == 4 || e.dS(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType > 0 || dS.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle != 2) {
            return false;
        }
        return true;
    }

    public static boolean dj(AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        if (g(dS) || e.ee(adTemplate) || cl(adTemplate).cardType == 4 || e.dS(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || dS.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) {
            return false;
        }
        return true;
    }

    @Nullable
    public static AdMatrixInfo.PreLandingPageTKInfo dk(@NonNull AdTemplate adTemplate) {
        return e.dS(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    public static boolean dl(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean dm(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean dn(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    /* renamed from: do, reason: not valid java name */
    public static boolean m276do(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean dp(@NonNull AdInfo adInfo) {
        if (dq(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean dq(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static String dr(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static long ds(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String dt(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static String du(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean dv(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static String dw(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.cutIconUrl;
    }

    public static String dx(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.refreshIconUrl;
    }

    public static String dy(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.convertIconUrl;
    }

    public static int dz(@NonNull AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i != 2) {
                return 1;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return 1;
        }
    }

    public static int ea(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    public static String eb(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    public static boolean ec(@NonNull AdInfo adInfo) {
        if (a.bc(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId)) {
            return true;
        }
        return false;
    }

    public static boolean ez(String str) {
        try {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ca(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(@NonNull AdInfo adInfo) {
        if (adInfo.adRewardInfo.recommendAggregateSwitch && !a.cS(adInfo) && !a.bI(adInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate k(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : ce(adTemplate).styles.templateList) {
            if (bh.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    @Nullable
    private static AdMatrixInfo.TemplateData l(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : ce(adTemplate).adDataV2.templateDataList) {
            if (bh.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    private static long m(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData l = l(adTemplate, str);
        if (l != null) {
            return l.templateDelayTime;
        }
        return 0L;
    }

    private static boolean n(@NonNull AdTemplate adTemplate, String str) {
        String str2;
        AdMatrixInfo.TemplateData l = l(adTemplate, str);
        if (l != null) {
            str2 = l.data;
        } else {
            str2 = "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str2).optJSONObject("autoCallAppInfo");
            if (optJSONObject == null) {
                return false;
            }
            if (TextUtils.isEmpty(optJSONObject.optString("adTitle"))) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String dA(AdTemplate adTemplate) {
        return cg(adTemplate).pushTKInfo.templateId;
    }

    public static String dB(AdTemplate adTemplate) {
        return cg(adTemplate).preLandingPageTKInfo.templateId;
    }

    public static String dC(AdTemplate adTemplate) {
        return cg(adTemplate).feedTKCardInfo.templateId;
    }

    public static boolean dl(@NonNull AdTemplate adTemplate) {
        return cg(adTemplate).installedActivateInfo.cardSwitch;
    }

    public static long dm(@NonNull AdTemplate adTemplate) {
        long j = cg(adTemplate).installedActivateInfo.showTime;
        if (j > 0) {
            return j;
        }
        return 0L;
    }

    public static String dn(AdTemplate adTemplate) {
        return cg(adTemplate).topFloorTKInfo.templateId;
    }

    /* renamed from: do, reason: not valid java name */
    public static String m275do(AdTemplate adTemplate) {
        return cg(adTemplate).neoTKInfo.templateId;
    }

    public static String dq(AdTemplate adTemplate) {
        return cg(adTemplate).videoImageTKInfo.templateId;
    }

    public static String dr(AdTemplate adTemplate) {
        return cg(adTemplate).fullScreenInfo.templateId;
    }

    public static String ds(AdTemplate adTemplate) {
        return cg(adTemplate).rewardVideoTaskInfo.templateId;
    }

    public static String dt(AdTemplate adTemplate) {
        return cg(adTemplate).splashPlayCardTKInfo.templateId;
    }

    public static String du(AdTemplate adTemplate) {
        return cg(adTemplate).splashEndCardTKInfo.templateId;
    }

    public static String dv(AdTemplate adTemplate) {
        return cg(adTemplate).interstitialCardInfo.templateId;
    }

    public static String dw(AdTemplate adTemplate) {
        return cg(adTemplate).confirmTKInfo.templateId;
    }

    public static String dx(AdTemplate adTemplate) {
        return cg(adTemplate).activityTKInfo.templateId;
    }

    public static String dy(AdTemplate adTemplate) {
        return cg(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    public static String dp(AdTemplate adTemplate) {
        return cg(adTemplate).videoLiveTKInfo.templateId;
    }

    public static String dz(AdTemplate adTemplate) {
        return cg(adTemplate).rewardVideoInteractInfo.templateId;
    }
}

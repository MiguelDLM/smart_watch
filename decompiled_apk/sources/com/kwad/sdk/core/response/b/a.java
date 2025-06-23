package com.kwad.sdk.core.response.b;

import XIXIX.OOXIXo;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.cn;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bh;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    public static String FQ() {
        return "继续下载";
    }

    public static String H(AdInfo adInfo) {
        return adInfo.downloadFilePath;
    }

    public static long J(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    public static String K(@NonNull AdInfo adInfo) {
        return aU(adInfo).materialUrl;
    }

    public static int L(@NonNull AdInfo adInfo) {
        if (bd(adInfo) == 2) {
            return aT(adInfo).videoDuration;
        }
        return aU(adInfo).videoDuration;
    }

    public static long M(@NonNull AdInfo adInfo) {
        int i;
        if (bd(adInfo) == 2) {
            i = aT(adInfo).videoDuration;
        } else {
            i = aU(adInfo).videoDuration;
        }
        return i * 1000;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature N(@NonNull AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        if (ai.P(list)) {
            return list.get(0);
        }
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String O(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = bd(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L35
            r3 = 2
            if (r0 == r3) goto L12
            if (r0 == r1) goto L12
            r2 = 8
            if (r0 == r2) goto L58
            goto L7b
        L12:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L35
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1a
            java.lang.String r5 = r4.firstFrame
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1a
            java.lang.String r6 = r4.firstFrame
            return r6
        L35:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L3d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L3d
            java.lang.String r4 = r3.firstFrame
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L3d
            java.lang.String r6 = r3.firstFrame
            return r6
        L58:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L60:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L7b
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L60
            java.lang.String r2 = r0.firstFrame
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L60
            java.lang.String r6 = r0.firstFrame
            return r6
        L7b:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.O(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static boolean P(@NonNull AdInfo adInfo) {
        if (adInfo.adConversionInfo.supportThirdDownload == 1) {
            return true;
        }
        return false;
    }

    public static int Q(@NonNull AdInfo adInfo) {
        return aU(adInfo).videoWidth;
    }

    public static int R(@NonNull AdInfo adInfo) {
        return aU(adInfo).videoHeight;
    }

    public static boolean S(@NonNull AdInfo adInfo) {
        if (adInfo.adConversionInfo.webUriSourceType == 2) {
            return true;
        }
        return false;
    }

    public static boolean T(AdInfo adInfo) {
        return adInfo.adConversionInfo.appSecondConfirmationSwitch;
    }

    public static boolean U(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5SecondConfirmationSwitch;
    }

    public static boolean V(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aU = aU(adInfo);
        if (aU.videoWidth <= aU.videoHeight) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0072  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String W(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r6) {
        /*
            int r0 = bd(r6)
            r1 = 3
            r2 = 1
            if (r0 == r2) goto L41
            r3 = 2
            if (r0 == r3) goto L13
            if (r0 == r1) goto L13
            r2 = 8
            if (r0 == r2) goto L64
            goto L87
        L13:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L1b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L41
            java.lang.Object r4 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r4 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r4
            int r5 = r4.featureType
            if (r5 != r3) goto L1b
            java.lang.String r5 = r4.materialUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L36
            java.lang.String r6 = r4.materialUrl
            return r6
        L36:
            java.lang.String r5 = r4.coverUrl
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L1b
            java.lang.String r6 = r4.coverUrl
            return r6
        L41:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
        L49:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L64
            java.lang.Object r3 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r3 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r3
            int r4 = r3.featureType
            if (r4 != r2) goto L49
            java.lang.String r4 = r3.coverUrl
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L49
            java.lang.String r6 = r3.coverUrl
            return r6
        L64:
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r6 = r6.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r6 = r6.materialFeatureList
            java.util.Iterator r6 = r6.iterator()
        L6c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L87
            java.lang.Object r0 = r6.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            int r2 = r0.featureType
            if (r2 != r1) goto L6c
            java.lang.String r2 = r0.coverUrl
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L6c
            java.lang.String r6 = r0.coverUrl
            return r6
        L87:
            java.lang.String r6 = ""
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.W(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static String X(@NonNull AdInfo adInfo) {
        int bd = bd(adInfo);
        if (bd != 1) {
            if (bd != 2 && bd != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return aW(adInfo).blurBackgroundUrl;
    }

    private static int Y(@NonNull AdInfo adInfo) {
        return aU(adInfo).width;
    }

    private static int Z(@NonNull AdInfo adInfo) {
        return aU(adInfo).height;
    }

    public static boolean a(AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        if (smallAppJumpInfo == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(smallAppJumpInfo.originId) || TextUtils.isEmpty(smallAppJumpInfo.smallAppJumpUrl)) {
            return false;
        }
        return true;
    }

    public static boolean aA(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    public static float aB(@NonNull AdInfo adInfo) {
        float f = adInfo.adBaseInfo.appScore;
        if (f < 30.0f) {
            return 3.0f;
        }
        if (f < 35.0f) {
            return 3.5f;
        }
        if (f < 40.0f) {
            return 4.0f;
        }
        if (f < 45.0f) {
            return 4.5f;
        }
        return 5.0f;
    }

    public static String aC(AdInfo adInfo) {
        if (bh.isNullString(adInfo.adBaseInfo.adSourceDescription)) {
            return "广告";
        }
        return adInfo.adBaseInfo.adSourceDescription;
    }

    public static String aD(@Nullable AdInfo adInfo) {
        String str = "立即下载";
        if (adInfo == null) {
            return "立即下载";
        }
        String str2 = adInfo.adBaseInfo.adActionDescription;
        if (TextUtils.isEmpty(str2)) {
            if (!aE(adInfo)) {
                str = "查看详情";
            }
            return str;
        }
        return str2;
    }

    public static boolean aE(@NonNull AdInfo adInfo) {
        if (aP(adInfo) == 1) {
            return true;
        }
        return false;
    }

    public static boolean aF(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId)) {
            return true;
        }
        return false;
    }

    public static int aG(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    public static int aH(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    public static int aI(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    public static int aJ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    public static int aK(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    public static int aL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    public static int aM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    public static boolean aN(@NonNull AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId)) {
            return true;
        }
        return false;
    }

    public static boolean aO(@NonNull AdInfo adInfo) {
        if (adInfo.downloadSafeInfo.complianceInfo == null || !aE(adInfo) || adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch != 1) {
            return false;
        }
        return true;
    }

    public static int aP(@NonNull AdInfo adInfo) {
        int i = adInfo.adBaseInfo.adOperationType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    public static int aQ(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String aR(@NonNull AdInfo adInfo) {
        Context context;
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            context = null;
        } else {
            context = fVar.getContext();
        }
        if (TextUtils.isEmpty(adInfo.adConversionInfo.h5Url)) {
            return "";
        }
        return ac.c(context, adInfo.adConversionInfo.h5Url, aA(adInfo));
    }

    public static int aS(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aT(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aU(@NonNull AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean aV(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aT;
        if (bb(adInfo)) {
            aT = aU(adInfo);
        } else {
            aT = aT(adInfo);
        }
        if (aT.height > aT.width) {
            return true;
        }
        return false;
    }

    @NonNull
    public static AdInfo.AdMaterialInfo.MaterialFeature aW(@NonNull AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature;
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        if (list.size() > 0) {
            materialFeature = list.get(0);
        } else {
            materialFeature = null;
        }
        if (materialFeature == null) {
            return new AdInfo.AdMaterialInfo.MaterialFeature();
        }
        return materialFeature;
    }

    public static boolean aX(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aU = aU(adInfo);
        if (aU.height > aU.width) {
            return true;
        }
        return false;
    }

    public static String aY(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    @NonNull
    public static List<String> aZ(@NonNull AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int bd = bd(adInfo);
        if (bd != 2 && bd != 3) {
            return arrayList;
        }
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                arrayList.add(materialFeature.materialUrl);
            }
        }
        return arrayList;
    }

    public static long aa(@NonNull AdInfo adInfo) {
        return aU(adInfo).photoId;
    }

    public static String ab(@Nullable AdInfo adInfo) {
        if (adInfo != null && !TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) {
            return adInfo.adBaseInfo.openAppLabel;
        }
        return "立即打开";
    }

    public static long ac(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int ad(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long ae(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    public static long af(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    private static int ag(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean ah(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdShakeInfo nativeAdShakeInfo;
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null && (nativeAdShakeInfo = nativeAdInfo.shakeInfo) != null) {
            return nativeAdShakeInfo.enableShake;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return false;
    }

    public static int ai(@NonNull AdInfo adInfo) {
        AdInfo.NativeAdInfo nativeAdInfo = adInfo.adStyleConfInfo.nativeAdInfo;
        if (nativeAdInfo != null) {
            return nativeAdInfo.shakeInfo.acceleration;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    public static boolean aj(@NonNull AdInfo adInfo) {
        if (ag(adInfo) != 0) {
            return true;
        }
        return false;
    }

    public static long ak(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return r4.fullScreenSkipShowTime * 1000;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long al(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static int am(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    public static boolean an(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    public static boolean ao(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    public static boolean ap(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    public static long aq(@NonNull AdInfo adInfo) {
        AdInfo.AdStyleConfInfo adStyleConfInfo = adInfo.adStyleConfInfo;
        if (adStyleConfInfo != null) {
            return adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.e.c.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean ar(@NonNull AdInfo adInfo) {
        if (!aE(adInfo) && as(adInfo)) {
            return true;
        }
        return false;
    }

    public static boolean as(@NonNull AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            if ((!aN(adInfo) || aM(adInfo) != 1) && !cS(adInfo)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static String at(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String au(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    private static String av(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.realAppName;
    }

    public static String aw(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String ax(AdInfo adInfo) {
        AdInfo.AdBaseInfo adBaseInfo;
        if (adInfo != null && (adBaseInfo = adInfo.adBaseInfo) != null) {
            return adBaseInfo.appPackageName;
        }
        return null;
    }

    public static String ay(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float az(@NonNull AdInfo adInfo) {
        int i = adInfo.adBaseInfo.appScore;
        if (i <= 0) {
            return 0.0f;
        }
        return i / 10.0f;
    }

    public static boolean b(@NonNull AdInfo adInfo, boolean z) {
        return ((z && aE(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || bh.isNullString(aR(adInfo))) ? false : true;
    }

    @Nullable
    public static String bA(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    @Nullable
    public static String bB(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    @Nullable
    public static String bC(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bD(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfo;
        }
        return null;
    }

    @Nullable
    public static String bE(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.introductionInfoUrl;
        }
        return null;
    }

    @Nullable
    public static String bF(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    @Nullable
    public static String bG(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long bH(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static boolean bI(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        boolean z;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            String str = adConversionInfo.playableUrl;
            if (str != null && adConversionInfo.playableStyleInfo != null && !TextUtils.isEmpty(str.trim())) {
                z = true;
            } else {
                z = false;
            }
            if (bL(adInfo) && z) {
                return true;
            }
        }
        return false;
    }

    public static long bJ(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            return adConversionInfo.h5DeeplinkLimitedTimeMs;
        }
        return 0L;
    }

    public static long bK(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            return adConversionInfo.playableDeeplinkLimitedTimeMs;
        }
        return 0L;
    }

    public static boolean bL(AdInfo adInfo) {
        if (aj.isOrientationPortrait()) {
            return bN(adInfo);
        }
        return bM(adInfo);
    }

    private static boolean bM(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        if (i != 0 && i != 2) {
            return false;
        }
        return true;
    }

    private static boolean bN(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        AdInfo.PlayableStyleInfo playableStyleInfo;
        if (adInfo == null || (adConversionInfo = adInfo.adConversionInfo) == null || (playableStyleInfo = adConversionInfo.playableStyleInfo) == null) {
            return false;
        }
        int i = playableStyleInfo.playableOrientation;
        if (i != 0 && i != 1) {
            return false;
        }
        return true;
    }

    @Nullable
    public static String bO(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            return adConversionInfo.playableUrl;
        }
        return null;
    }

    @Nullable
    public static String bP(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            return adConversionInfo.callbackUrl;
        }
        return null;
    }

    @Nullable
    public static String bQ(AdInfo adInfo) {
        AdInfo.AdConversionInfo adConversionInfo;
        if (adInfo != null && (adConversionInfo = adInfo.adConversionInfo) != null) {
            return adConversionInfo.callbackUrlInfo;
        }
        return null;
    }

    @Nullable
    public static String bR(AdInfo adInfo) {
        String str;
        if (adInfo != null && (str = adInfo.serverExt) != null) {
            return str;
        }
        return null;
    }

    public static boolean bS(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean bT(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean bU(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoSoundType != 2) {
            return false;
        }
        return true;
    }

    public static boolean bV(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null) {
            return false;
        }
        int i = adFeedInfo.videoAutoPlayType;
        if (i != 1 && i != 0) {
            return false;
        }
        return true;
    }

    public static boolean bW(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 2) {
            return false;
        }
        return true;
    }

    public static boolean bX(AdInfo adInfo) {
        AdInfo.AdFeedInfo adFeedInfo;
        if (adInfo == null || (adFeedInfo = adInfo.adFeedInfo) == null || adFeedInfo.videoAutoPlayType != 3) {
            return false;
        }
        return true;
    }

    public static boolean bY(AdInfo adInfo) {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if ((hVar != null && hVar.zB()) || TextUtils.isEmpty(aR(adInfo)) || adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse != 1) {
            return false;
        }
        return true;
    }

    @NonNull
    public static String bZ(@NonNull AdInfo adInfo) {
        String str = adInfo.adStyleInfo.adBrowseInfo.rewardDescription;
        if (TextUtils.isEmpty(str)) {
            return "浏览页面";
        }
        return str;
    }

    @NonNull
    public static String ba(@NonNull AdInfo adInfo) {
        if (bb(adInfo)) {
            return K(adInfo);
        }
        List<String> aZ = aZ(adInfo);
        if (aZ.size() > 0) {
            return aZ.get(0);
        }
        return "";
    }

    public static boolean bb(@NonNull AdInfo adInfo) {
        if (bd(adInfo) == 1) {
            return true;
        }
        return false;
    }

    public static boolean bc(@NonNull AdInfo adInfo) {
        if (aT(adInfo).featureType == 2) {
            return true;
        }
        return false;
    }

    public static int bd(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.materialType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i != 5) {
                    if (i == 8) {
                        return 8;
                    }
                    return 0;
                }
                return 3;
            }
        }
        return i2;
    }

    public static int be(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    public static String bf(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    public static boolean bg(AdInfo adInfo) {
        if (adInfo.adMaterialInfo.materialType == 1) {
            return true;
        }
        return false;
    }

    public static boolean bh(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    public static boolean bi(AdInfo adInfo) {
        return adInfo.adConversionInfo.interceptH5JumpAppMkt;
    }

    public static int bj(AdInfo adInfo) {
        return adInfo.adConversionInfo.interceptH5JumpTimeOut;
    }

    public static boolean bk(AdInfo adInfo) {
        return adInfo.adConversionInfo.isSupportKeepPlaying;
    }

    public static long bl(AdInfo adInfo) {
        return adInfo.adConversionInfo.keepPlayingBackOffTime;
    }

    public static boolean bm(AdInfo adInfo) {
        if (new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig).length() == 0) {
            return false;
        }
        return true;
    }

    @Nullable
    public static List<Integer> bn(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt > 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    @NonNull
    private static int[] bo(@NonNull AdInfo adInfo) {
        String[] split;
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            split = str.split(",");
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (split.length < 3) {
            return iArr;
        }
        iArr[0] = Integer.parseInt(split[0]);
        iArr[1] = Integer.parseInt(split[1]);
        iArr[2] = Integer.parseInt(split[2]);
        return iArr;
    }

    public static int bp(@NonNull AdInfo adInfo) {
        int i = bo(adInfo)[0];
        if (i > 0) {
            return i;
        }
        return 3;
    }

    public static int bq(@NonNull AdInfo adInfo) {
        int i = bo(adInfo)[1];
        if (i <= 0) {
            i = 3;
        }
        return i + bp(adInfo);
    }

    public static int br(@NonNull AdInfo adInfo) {
        int i = bo(adInfo)[2];
        if (i <= 0) {
            i = 3;
        }
        return i + bq(adInfo);
    }

    @NonNull
    public static com.kwad.sdk.core.response.model.b bs(@NonNull AdInfo adInfo) {
        String W;
        int Y;
        int Z;
        boolean z;
        String O = O(adInfo);
        int Q = Q(adInfo);
        int R = R(adInfo);
        if (!bh.isNullString(O) && !bh.gZ(O) && Q != 0 && R != 0) {
            W = O;
            Y = Q;
            Z = R;
            z = false;
        } else {
            W = W(adInfo);
            Y = Y(adInfo);
            Z = Z(adInfo);
            z = true;
        }
        com.kwad.sdk.core.e.c.d("AdInfoHelper", "frameUrl=" + W + " useCover=" + z + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(W, Y, Z, true, z);
    }

    public static String bt(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "您访问的网站由第三方提供";
    }

    public static boolean bu(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean bv(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int bw(AdInfo adInfo) {
        AdInfo.ComplianceInfo complianceInfo = adInfo.downloadSafeInfo.complianceInfo;
        if (complianceInfo == null) {
            return -1;
        }
        return complianceInfo.materialJumpType;
    }

    public static boolean bx(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int by(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        int i = adInfo.status;
        if (i == 0) {
            return 1;
        }
        if (1 == i || 2 == i || 3 == i || 4 == i) {
            return 2;
        }
        if (8 != i) {
            return 0;
        }
        return 3;
    }

    public static int bz(AdInfo adInfo) {
        return adInfo.status;
    }

    public static boolean cA(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.impressionStatisticalChangeSwitch;
    }

    public static int cB(@NonNull AdInfo adInfo) {
        double d = adInfo.adSplashInfo.impressionLimitSize;
        if (d <= OOXIXo.f3760XO || d > 1.0d) {
            d = 0.699999988079071d;
        }
        return ((int) d) * 100;
    }

    public static boolean cC(AdInfo adInfo) {
        AdInfo.DownloadSafeInfo downloadSafeInfo;
        if (adInfo != null && (downloadSafeInfo = adInfo.downloadSafeInfo) != null) {
            return downloadSafeInfo.downloadPauseEnable;
        }
        return false;
    }

    public static String cD(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    @Deprecated
    public static boolean cE(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.innerAdType == 3) {
            return true;
        }
        return false;
    }

    public static boolean cF(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    @Deprecated
    public static boolean cG(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.innerAdType == 1) {
            return true;
        }
        return false;
    }

    @Nullable
    public static String cH(@NonNull AdInfo adInfo) {
        int i = adInfo.advertiserInfo.fansCount;
        if (i >= 200 && i < 10000) {
            return String.valueOf(i);
        }
        if (i >= 10000) {
            double d = i / 10000.0d;
            return new DecimalFormat(cn.d).format(d) + IAdInterListener.AdReqParam.WIDTH;
        }
        return null;
    }

    public static String cI(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String cJ(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    @Deprecated
    public static boolean cK(@NonNull AdInfo adInfo) {
        int i = adInfo.adStyleConfInfo.innerAdType;
        if (i != 4 && i != 5) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean cL(@NonNull AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.innerAdType == 7) {
            return true;
        }
        return false;
    }

    public static boolean cM(@NonNull AdInfo adInfo) {
        if (adInfo.adBaseInfo.universeLiveType == 1 && ch(adInfo) != 0) {
            return true;
        }
        return false;
    }

    public static boolean cN(@NonNull AdInfo adInfo) {
        if (!cM(adInfo) && !cL(adInfo)) {
            return false;
        }
        return true;
    }

    public static String cO(@NonNull AdInfo adInfo) {
        Context context;
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            context = null;
        } else {
            context = fVar.getContext();
        }
        return ac.c(context, adInfo.adConversionInfo.deeplinkUrl, aA(adInfo));
    }

    public static String cP(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.appDownloadUrl;
    }

    public static AdProductInfo cQ(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String cR(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    public static boolean cS(@NonNull AdInfo adInfo) {
        if (aE(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean cT(@NonNull AdInfo adInfo) {
        if (cS(adInfo) && af(adInfo) < M(adInfo)) {
            return true;
        }
        return false;
    }

    public static boolean cU(@NonNull AdInfo adInfo) {
        if (TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            com.kwad.sdk.core.e.c.d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if ((java.lang.System.currentTimeMillis() - r2) > (r6 * 1000)) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean cV(@androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdInfo r8) {
        /*
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r0 = r8.adStyleConfInfo
            boolean r0 = r0.adPushSwitch
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            long r2 = com.kwad.sdk.utils.y.Mu()
            r0 = 1
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L15
        L13:
            r1 = 1
            goto L2e
        L15:
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r8 = r8.adStyleConfInfo
            int r8 = r8.adPushIntervalTime
            long r6 = (long) r8
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 > 0) goto L20
            r6 = 900(0x384, double:4.447E-321)
        L20:
            r4 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r4
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L2e
            goto L13
        L2e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "isPushAdEnable intervalEnable: "
            r8.<init>(r0)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            java.lang.String r0 = "AdInfoHelper"
            com.kwad.sdk.core.e.c.d(r0, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.b.a.cV(com.kwad.sdk.core.response.model.AdInfo):boolean");
    }

    public static int cW(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    public static boolean cX(@NonNull AdInfo adInfo) {
        if (cM(adInfo) && !TextUtils.isEmpty(b.eb(adInfo)) && !cY(adInfo)) {
            return true;
        }
        return false;
    }

    private static boolean cY(@NonNull AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    public static long cZ(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.callBackAdvanceMs;
    }

    public static String ca(AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2 && !cL(e.dS(adTemplate)) && !cM(e.dS(adTemplate))) {
            return "安装获取奖励";
        }
        if (adTemplate == null) {
            return "立即安装";
        }
        AdInfo dS = e.dS(adTemplate);
        if (TextUtils.isEmpty(dS.adBaseInfo.installAppLabel)) {
            return "立即安装";
        }
        return dS.adBaseInfo.installAppLabel;
    }

    public static boolean cb(AdTemplate adTemplate) {
        return e.dS(adTemplate).adBaseInfo.apiExpParam.aggregateMiddlePageShowPathSwitch;
    }

    public static String cc(AdTemplate adTemplate) {
        return e.dS(adTemplate).adMatrixInfo.adDataV2.rewardWebTaskCloseInfo.templateId;
    }

    @NonNull
    public static String cd(@NonNull AdInfo adInfo) {
        String aw;
        if (aE(adInfo)) {
            aw = au(adInfo);
        } else {
            aw = aw(adInfo);
        }
        if (TextUtils.isEmpty(aw)) {
            aw = adInfo.advertiserInfo.rawUserName;
        }
        return TextUtils.isEmpty(aw) ? "可爱的广告君" : aw;
    }

    @NonNull
    public static String ce(@NonNull AdInfo adInfo) {
        String av = av(adInfo);
        if (TextUtils.isEmpty(av)) {
            return "可爱的广告君";
        }
        return av;
    }

    @NonNull
    public static String cf(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String cg(@NonNull AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        if (TextUtils.isEmpty(str) || !aE(adInfo)) {
            return adInfo.advertiserInfo.portraitUrl;
        }
        return str;
    }

    public static long ch(@NonNull AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    public static String ci(@NonNull AdInfo adInfo) {
        if (bh.isNullString(adInfo.adConversionInfo.liveServiceToken)) {
            return "";
        }
        return adInfo.adConversionInfo.liveServiceToken;
    }

    public static long cj(@NonNull AdInfo adInfo) {
        return adInfo.adConversionInfo.liveVisitorId;
    }

    @NonNull
    public static String ck(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        String str;
        if (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || (str = adSplashInfo.skipTips) == null || TextUtils.isEmpty(str)) {
            return "跳过";
        }
        return adInfo.adSplashInfo.skipTips;
    }

    public static AdInfo.CutRuleInfo cl(AdInfo adInfo) {
        return adInfo.adSplashInfo.cutRuleInfo;
    }

    public static int cm(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    public static boolean cn(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    public static int co(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int cp(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int cq(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static String cr(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static boolean cs(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateSwitch;
    }

    public static int ct(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static int cu(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateInterval;
    }

    public static int cv(@NonNull AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateDailyShowCount;
    }

    public static boolean cw(@NonNull AdInfo adInfo) {
        int i = adInfo.adSplashInfo.skipType;
        if (i != 2 && i != 3) {
            return false;
        }
        return true;
    }

    public static boolean cx(@Nullable AdInfo adInfo) {
        if (!cy(adInfo)) {
            return false;
        }
        int i = adInfo.adSplashInfo.skipType;
        if (i != 0 && i != 2) {
            return false;
        }
        return true;
    }

    public static boolean cy(@Nullable AdInfo adInfo) {
        if (adInfo.adSplashInfo.skipSecond >= 0) {
            return true;
        }
        return false;
    }

    public static boolean cz(AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo;
        if (adInfo == null || (adSplashInfo = adInfo.adSplashInfo) == null || adSplashInfo.countdownShow != 1) {
            return false;
        }
        return true;
    }

    public static boolean da(@NonNull AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.serverCheckSwitch;
    }

    public static boolean db(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.rewardAdvanceSwitch;
    }

    public static KSAdInfoData dc(AdInfo adInfo) {
        KSAdInfoData interactionType = KSAdInfoData.obtain().setAdDescription(at(adInfo)).setProductName(aw(adInfo)).setAdSource(aC(adInfo)).setVideoUrl(K(adInfo)).setMaterialType(bd(adInfo)).setAppIconUrl(cg(adInfo)).setAppName(au(adInfo)).setImageList(dd(adInfo)).setVideoCoverImageUrl(de(adInfo)).setInteractionType(aP(adInfo));
        try {
            interactionType.setCreativeId(J(adInfo));
        } catch (Throwable unused) {
        }
        return interactionType;
    }

    private static List<String> dd(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int bd = bd(adInfo);
        if (bd == 2 || bd == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
        }
        return arrayList;
    }

    private static String de(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aU = aU(adInfo);
        if (!TextUtils.isEmpty(aU.coverUrl)) {
            return aU.coverUrl;
        }
        return null;
    }

    public static String df(AdInfo adInfo) {
        return adInfo.adConversionInfo.smallAppJumpInfo.mediaSmallAppId;
    }

    public static boolean dg(@NonNull AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.derivativeMaterialType;
        if (i != 6 && i != 2) {
            return false;
        }
        return true;
    }

    public static int dh(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adBaseInfo.campaignType;
    }

    public static int di(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.ocpcActionType;
    }

    public static int dj(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adBaseInfo.industryFirstLevelId;
    }

    public static int dk(@NonNull AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adConversionInfo.webUriSourceType;
    }

    @Deprecated
    public static String dm(int i) {
        return s(i, "下载中  %s%%");
    }

    public static String dn(int i) {
        return "继续下载 " + i + "%";
    }

    public static String s(int i, String str) {
        if (str == null) {
            str = "下载中  %s%%";
        }
        return String.format(str, Integer.valueOf(i));
    }

    public static int cb(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.endCardType;
    }

    public static int cc(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.confirmCardType;
    }

    @Nullable
    public static SpannableString b(AdInfo adInfo, @ColorInt int i) {
        String format;
        int indexOf;
        String cH = cH(adInfo);
        if (cH == null || (indexOf = (format = String.format("已有%s粉丝关注了TA", cH)).indexOf(cH)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(i), indexOf, cH.length() + indexOf, 18);
        return spannableString;
    }

    @Deprecated
    public static boolean cd(@NonNull AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo dd = b.dd(adTemplate);
        return (dd == null || dd.isEmpty() || dS.adStyleConfInfo.innerAdType != 2) ? false : true;
    }

    public static int ca(AdInfo adInfo) {
        if (adInfo == null) {
            return 0;
        }
        return adInfo.adStyleConfInfo.actionBarType;
    }
}

package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.MApiIMediationViewBinderReversal;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
class BaiduAdapterUtil {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static Map<String, Integer> f10375oIX0oI;

    static {
        HashMap hashMap = new HashMap();
        f10375oIX0oI = hashMap;
        hashMap.put("0", 0);
        f10375oIX0oI.put("0103010", 1);
        f10375oIX0oI.put("0103011", 1);
        f10375oIX0oI.put("0103012", 1);
        f10375oIX0oI.put("0103060", 2);
        f10375oIX0oI.put("0107001", 3);
        f10375oIX0oI.put("0107002", 3);
        f10375oIX0oI.put("0107003", 4);
        f10375oIX0oI.put("1020001", 5);
        f10375oIX0oI.put("1040001", 6);
        f10375oIX0oI.put("1040003", 7);
        f10375oIX0oI.put("3030002", 8);
    }

    public static MediationViewBinder buildViewBinder(Bridge bridge) {
        MApiIMediationViewBinderReversal mApiIMediationViewBinderReversal = new MApiIMediationViewBinderReversal(bridge);
        return new MediationViewBinder.Builder(mApiIMediationViewBinderReversal.getLayoutId()).callToActionId(mApiIMediationViewBinderReversal.getCallToActionId()).addExtras(mApiIMediationViewBinderReversal.getExtras()).descriptionTextId(mApiIMediationViewBinderReversal.getDecriptionTextId()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage1Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage2Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage3Id()).iconImageId(mApiIMediationViewBinderReversal.getIconImageId()).mainImageId(mApiIMediationViewBinderReversal.getMainImageId()).mediaViewIdId(mApiIMediationViewBinderReversal.getMediaViewId()).logoLayoutId(mApiIMediationViewBinderReversal.getLogoLayoutId()).shakeViewContainerId(mApiIMediationViewBinderReversal.getShakeViewContainerId()).titleId(mApiIMediationViewBinderReversal.getTitleId()).sourceId(mApiIMediationViewBinderReversal.getSourceId()).build();
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static RequestParameters getRequestParameters(MediationAdSlotValueSet mediationAdSlotValueSet) {
        RequestParameters requestParameters;
        RequestParameters.Builder builder = new RequestParameters.Builder();
        if ((mediationAdSlotValueSet.getBaiduRequestParameters() instanceof RequestParameters) && (requestParameters = (RequestParameters) mediationAdSlotValueSet.getBaiduRequestParameters()) != null) {
            builder.downloadAppConfirmPolicy(requestParameters.getAPPConfirmPolicy());
            Map<String, String> extras = requestParameters.getExtras();
            if (extras != null) {
                try {
                    for (Map.Entry<String, String> entry : extras.entrySet()) {
                        if (entry != null) {
                            builder.addExtra(entry.getKey(), entry.getValue());
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        int width = mediationAdSlotValueSet.getWidth() > 0 ? mediationAdSlotValueSet.getWidth() : 0;
        int height = mediationAdSlotValueSet.getHeight() > 0 ? mediationAdSlotValueSet.getHeight() : 0;
        if (width > 0 && height > 0) {
            builder.setWidth(width).setHeight(height);
        }
        return builder.build();
    }

    public static int getinteractionType(int i) {
        if (i != 1) {
            return i != 2 ? -1 : 4;
        }
        return 3;
    }

    public static boolean isDownloadAd(ExpressResponse expressResponse) {
        return expressResponse != null && expressResponse.getAdActionType() == 2;
    }

    public static boolean isNativeSmartOpt(int i) {
        return i == 28 || i == 29 || i == 30 || i == 33 || i == 34 || i == 35 || i == 36 || i == 37;
    }

    public static void printPrivacyLog(MediationInitConfig mediationInitConfig) {
    }

    public static boolean isDownloadAd(NativeResponse nativeResponse) {
        return nativeResponse != null && nativeResponse.getAdActionType() == 2;
    }
}

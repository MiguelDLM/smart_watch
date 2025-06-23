package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationSplashRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* loaded from: classes8.dex */
public class MediationAdSlotUtil {
    public static ValueSet getMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
        if (iMediationAdSlot != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8444, iMediationAdSlot.isMuted());
            create.add(8445, iMediationAdSlot.isSplashShakeButton());
            create.add(8446, iMediationAdSlot.isSplashPreLoad());
            create.add(8447, iMediationAdSlot.getVolume());
            create.add(8448, iMediationAdSlot.isUseSurfaceView());
            create.add(8449, iMediationAdSlot.getExtraObject());
            create.add(8450, iMediationAdSlot.isBidNotify());
            create.add(8451, iMediationAdSlot.getScenarioId());
            create.add(8454, iMediationAdSlot.isAllowShowCloseBtn());
            create.add(8455, iMediationAdSlot.getShakeViewWidth());
            create.add(8456, iMediationAdSlot.getShakeViewHeight());
            create.add(8459, iMediationAdSlot.getWxAppId());
            return create.build();
        }
        return null;
    }

    public static ValueSet getMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
        if (mediationSplashRequestInfo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8530, mediationSplashRequestInfo.getAdnName());
            create.add(8531, mediationSplashRequestInfo.getAdnSlotId());
            create.add(8532, mediationSplashRequestInfo.getAppId());
            create.add(8533, mediationSplashRequestInfo.getAppkey());
            return create.build();
        }
        return null;
    }
}

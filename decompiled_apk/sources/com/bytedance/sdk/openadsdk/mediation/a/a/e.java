package com.bytedance.sdk.openadsdk.mediation.a.a;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: classes8.dex */
public class e extends com.bytedance.sdk.openadsdk.mediation.ad.a.a.b.a {

    /* renamed from: a, reason: collision with root package name */
    private IMediationAdSlot f10826a;

    public e(IMediationAdSlot iMediationAdSlot) {
        super(iMediationAdSlot);
        this.f10826a = iMediationAdSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.a.a.b.a, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f10826a == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i == 266101) {
            return (T) new com.bytedance.sdk.openadsdk.mediation.ad.a.a.b.c((IMediationNativeToBannerListener) super.call(i, null, IMediationNativeToBannerListener.class));
        }
        if (i == 266102) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo = (IMediationSplashRequestInfo) super.call(i, null, IMediationSplashRequestInfo.class);
            if (iMediationSplashRequestInfo == null) {
                return null;
            }
            return (T) new i(iMediationSplashRequestInfo);
        }
        return (T) super.call(i, valueSet, cls);
    }
}

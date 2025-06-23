package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* loaded from: classes8.dex */
public class MediationSplashRequestInfoImpl implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private IMediationSplashRequestInfo f10811a;

    public MediationSplashRequestInfoImpl(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f10811a = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo;
        if (i == 8530) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.f10811a;
            if (iMediationSplashRequestInfo2 != null) {
                return (T) iMediationSplashRequestInfo2.getAdnName();
            }
            return null;
        }
        if (i == 8532) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.f10811a;
            if (iMediationSplashRequestInfo3 != null) {
                return (T) iMediationSplashRequestInfo3.getAppId();
            }
            return null;
        }
        if (i == 8533) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.f10811a;
            if (iMediationSplashRequestInfo4 != null) {
                return (T) iMediationSplashRequestInfo4.getAppkey();
            }
            return null;
        }
        if (i == 8531 && (iMediationSplashRequestInfo = this.f10811a) != null) {
            return (T) iMediationSplashRequestInfo.getAdnSlotId();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}

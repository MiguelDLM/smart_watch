package com.bytedance.sdk.openadsdk.mediation.ad.a.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class d implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10847a = xXxxox0I.f31020I0Io;
    private final IMediationSplashRequestInfo b;

    public d(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.b = iMediationSplashRequestInfo;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo = this.b;
        if (iMediationSplashRequestInfo == null) {
            return null;
        }
        switch (i) {
            case 267001:
                return (T) iMediationSplashRequestInfo.getAdnName();
            case 267002:
                return (T) iMediationSplashRequestInfo.getAdnSlotId();
            case 267003:
                return (T) iMediationSplashRequestInfo.getAppId();
            case 267004:
                return (T) iMediationSplashRequestInfo.getAppkey();
            default:
                a(i, valueSet, cls);
                return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10847a;
    }
}

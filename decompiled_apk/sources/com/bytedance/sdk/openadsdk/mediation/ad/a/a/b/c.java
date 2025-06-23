package com.bytedance.sdk.openadsdk.mediation.ad.a.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class c implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10846a = xXxxox0I.f31020I0Io;
    private final IMediationNativeToBannerListener b;

    public c(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.b = iMediationNativeToBannerListener;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.b == null) {
            return null;
        }
        if (i != 266013) {
            a(i, valueSet, cls);
            return null;
        }
        return (T) this.b.getMediationBannerViewFromNativeAd(new com.bytedance.sdk.openadsdk.mediation.ad.a.a.a.a((Bridge) valueSet.objectValue(0, Bridge.class)));
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10846a;
    }
}

package com.bytedance.sdk.openadsdk.mediation.ad.a.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class g implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10850a = xXxxox0I.f31020I0Io;
    private final MediationShakeViewListener b;

    public g(MediationShakeViewListener mediationShakeViewListener) {
        this.b = mediationShakeViewListener;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        MediationShakeViewListener mediationShakeViewListener = this.b;
        if (mediationShakeViewListener == null) {
            return null;
        }
        if (i == 270012) {
            mediationShakeViewListener.onDismissed();
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10850a;
    }
}

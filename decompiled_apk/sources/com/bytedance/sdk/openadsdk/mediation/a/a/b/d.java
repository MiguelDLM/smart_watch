package com.bytedance.sdk.openadsdk.mediation.a.a.b;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class d implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10822a = xXxxox0I.f31020I0Io;
    private final IMediationPreloadRequestInfo b;

    public d(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.b = iMediationPreloadRequestInfo;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.b;
        if (iMediationPreloadRequestInfo == null) {
            return null;
        }
        switch (i) {
            case 271044:
                return (T) Integer.class.cast(Integer.valueOf(iMediationPreloadRequestInfo.getAdType()));
            case 271045:
                return (T) iMediationPreloadRequestInfo.getAdSlot();
            case 271046:
                return (T) iMediationPreloadRequestInfo.getPrimeRitList();
            default:
                a(i, valueSet, cls);
                return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10822a;
    }
}

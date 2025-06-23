package com.bytedance.sdk.openadsdk.mediation.a.a;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: classes8.dex */
public class h extends com.bytedance.sdk.openadsdk.mediation.a.a.b.d {

    /* renamed from: a, reason: collision with root package name */
    private IMediationPreloadRequestInfo f10829a;

    public h(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        super(iMediationPreloadRequestInfo);
        this.f10829a = iMediationPreloadRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.a.a.b.d, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.f10829a;
        if (iMediationPreloadRequestInfo == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i == 271045) {
            if (iMediationPreloadRequestInfo != null) {
                return (T) a.a(iMediationPreloadRequestInfo.getAdSlot());
            }
            return null;
        }
        return (T) super.call(i, valueSet, cls);
    }
}

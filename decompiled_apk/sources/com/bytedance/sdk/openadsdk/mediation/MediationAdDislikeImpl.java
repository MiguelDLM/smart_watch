package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* loaded from: classes8.dex */
public class MediationAdDislikeImpl implements Bridge, MediationAdDislike {

    /* renamed from: a, reason: collision with root package name */
    private Bridge f10800a;

    public MediationAdDislikeImpl(Bridge bridge) {
        this.f10800a = bridge;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        if (this.f10800a != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8317, new MediationDislikeCallbackImpl(iMediationDislikeCallback));
            this.f10800a.call(6085, create.build(), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        Bridge bridge = this.f10800a;
        if (bridge != null) {
            bridge.call(8184, null, null);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}

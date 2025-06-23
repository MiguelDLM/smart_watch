package com.bytedance.sdk.openadsdk.m.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class b implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10799a = xXxxox0I.f31020I0Io;
    private final TTRewardVideoAd.RewardAdPlayAgainController b;

    public b(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.b = rewardAdPlayAgainController;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.b == null) {
            return null;
        }
        if (i == 122101) {
            this.b.getPlayAgainCondition(valueSet.intValue(0), new com.bytedance.sdk.openadsdk.d.a.a.a.a.a((Bridge) valueSet.objectValue(1, Bridge.class)));
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f10799a;
    }
}

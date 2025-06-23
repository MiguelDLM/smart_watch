package com.bytedance.sdk.openadsdk.d.a.a.a.a;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10753a;

    public a(Bridge bridge) {
        this.f10753a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, bundle);
        this.f10753a.call(123101, II0xO02.OOXIXo(), Void.class);
    }
}

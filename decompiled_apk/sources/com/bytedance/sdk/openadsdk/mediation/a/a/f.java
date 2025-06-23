package com.bytedance.sdk.openadsdk.mediation.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class f implements IMediationDislikeCallback {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10827a;

    public f(Bridge bridge) {
        this.f10827a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
        this.f10827a.call(268014, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i, String str) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(2);
        II0xO02.X0o0xo(0, i);
        II0xO02.II0XooXoX(1, str);
        this.f10827a.call(268013, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
        this.f10827a.call(268015, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }
}

package com.bytedance.sdk.openadsdk.mediation.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class m extends com.bytedance.sdk.openadsdk.c.a.a.l {

    /* renamed from: a, reason: collision with root package name */
    private Bridge f10834a;

    public m(Bridge bridge) {
        super(bridge);
        this.f10834a = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.c.a.a.l, com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.mediation.a.a.b.b((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            II0xO02.X0o0xo(1, 1);
        } else {
            II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.j.a.a.a.a(fullScreenVideoAdInteractionListener));
            II0xO02.X0o0xo(1, 0);
        }
        Bridge bridge = this.f10834a;
        if (bridge != null) {
            bridge.call(130101, II0xO02.OOXIXo(), Void.class);
        }
    }
}

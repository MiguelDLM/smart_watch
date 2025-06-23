package com.bytedance.sdk.openadsdk.mediation.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class k extends com.bytedance.sdk.openadsdk.c.a.a.j {

    /* renamed from: a, reason: collision with root package name */
    private Bridge f10832a;

    public k(Bridge bridge) {
        super(bridge);
        this.f10832a = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.c.a.a.j, com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        if (expressRenderListener instanceof MediationExpressRenderListener) {
            II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.mediation.ad.a.a.b.f((MediationExpressRenderListener) expressRenderListener));
            II0xO02.X0o0xo(1, 1);
        } else {
            II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.k.a.a.a.b(expressRenderListener));
            II0xO02.X0o0xo(1, 0);
        }
        Bridge bridge = this.f10832a;
        if (bridge != null) {
            bridge.call(140111, II0xO02.OOXIXo(), Void.class);
        }
    }
}

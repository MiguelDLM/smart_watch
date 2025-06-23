package com.bytedance.sdk.openadsdk.mediation.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class c implements IMediationNativeTokenInfo {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10817a;

    public c(Bridge bridge) {
        this.f10817a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(2);
        II0xO02.II0XooXoX(0, str);
        II0xO02.Oxx0IOOO(1, new com.bytedance.sdk.openadsdk.g.a.a.a.b(feedAdListener));
        this.f10817a.call(270028, II0xO02.OOXIXo(), Void.class);
    }
}

package com.bytedance.sdk.openadsdk.mediation.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a implements IMediationDrawTokenInfo {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10815a;

    public a(Bridge bridge) {
        this.f10815a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo
    public void loadDrawAdByAdm(String str, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(2);
        II0xO02.II0XooXoX(0, str);
        II0xO02.Oxx0IOOO(1, new com.bytedance.sdk.openadsdk.g.a.a.a.a(drawFeedAdListener));
        this.f10815a.call(270031, II0xO02.OOXIXo(), Void.class);
    }
}

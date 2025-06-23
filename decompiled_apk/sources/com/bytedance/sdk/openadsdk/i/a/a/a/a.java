package com.bytedance.sdk.openadsdk.i.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a implements TTFeedAd.CustomizeVideo {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10778a;

    public a(Bridge bridge) {
        this.f10778a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        return (String) this.f10778a.call(162101, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        this.f10778a.call(162107, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.XO(0, j);
        this.f10778a.call(162106, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.XO(0, j);
        this.f10778a.call(162104, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j, int i, int i2) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(3);
        II0xO02.XO(0, j);
        II0xO02.X0o0xo(1, i);
        II0xO02.X0o0xo(2, i2);
        this.f10778a.call(162109, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        this.f10778a.call(162105, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.XO(0, j);
        this.f10778a.call(162103, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        this.f10778a.call(162102, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i, int i2) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(2);
        II0xO02.X0o0xo(0, i);
        II0xO02.X0o0xo(1, i2);
        this.f10778a.call(162108, II0xO02.OOXIXo(), Void.class);
    }
}

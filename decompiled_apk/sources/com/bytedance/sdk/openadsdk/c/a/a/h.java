package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class h implements TTAdDislike {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10721a;

    public h(Bridge bridge) {
        this.f10721a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        return ((Boolean) this.f10721a.call(240105, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        this.f10721a.call(240104, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.f.a.a.a.a(dislikeInteractionCallback));
        this.f10721a.call(240102, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.II0XooXoX(0, str);
        this.f10721a.call(240103, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        this.f10721a.call(240101, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }
}

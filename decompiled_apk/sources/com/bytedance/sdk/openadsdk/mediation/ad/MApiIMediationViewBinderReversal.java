package com.bytedance.sdk.openadsdk.mediation.ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import java.util.Map;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class MApiIMediationViewBinderReversal implements IMediationViewBinderReversal {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10835a;

    public MApiIMediationViewBinderReversal(Bridge bridge) {
        this.f10835a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getCallToActionId() {
        return ((Integer) this.f10835a.call(271024, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getDecriptionTextId() {
        return ((Integer) this.f10835a.call(271023, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public Map<String, Integer> getExtras() {
        return (Map) this.f10835a.call(271034, xXxxox0I.II0xO0(0).OOXIXo(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage1Id() {
        return ((Integer) this.f10835a.call(271029, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage2Id() {
        return ((Integer) this.f10835a.call(271030, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage3Id() {
        return ((Integer) this.f10835a.call(271031, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getIconImageId() {
        return ((Integer) this.f10835a.call(271025, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLayoutId() {
        return ((Integer) this.f10835a.call(271021, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLogoLayoutId() {
        return ((Integer) this.f10835a.call(271032, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMainImageId() {
        return ((Integer) this.f10835a.call(271026, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMediaViewId() {
        return ((Integer) this.f10835a.call(271027, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getShakeViewContainerId() {
        return ((Integer) this.f10835a.call(271033, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getSourceId() {
        return ((Integer) this.f10835a.call(271028, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getTitleId() {
        return ((Integer) this.f10835a.call(271022, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }
}

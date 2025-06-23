package com.bytedance.sdk.openadsdk.c.a.a;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import java.util.Map;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class p implements TTRewardVideoAd {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10729a;

    public p(Bridge bridge) {
        this.f10729a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public long getExpirationTimestamp() {
        return this.f10729a.values().longValue(120004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        return this.f10729a.values().intValue(120001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f10729a.values().objectValue(120002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public MediationRewardManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.a.a.a.e((Bridge) this.f10729a.call(121109, xXxxox0I.II0xO0(0).OOXIXo(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        return this.f10729a.values().intValue(120003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(3);
        II0xO02.Oxx0IOOO(0, d);
        II0xO02.II0XooXoX(1, str);
        II0xO02.II0XooXoX(2, str2);
        this.f10729a.call(210102, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.c.a.b.a(tTAdInteractionListener));
        this.f10729a.call(210104, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.c.a.b.b(tTAppDownloadListener));
        this.f10729a.call(120104, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, d);
        this.f10729a.call(210103, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.m.a.a.a.a(rewardAdInteractionListener));
        this.f10729a.call(120101, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainController(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.m.a.a.a.b(rewardAdPlayAgainController));
        this.f10729a.call(120103, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.m.a.a.a.a(rewardAdInteractionListener));
        this.f10729a.call(120102, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.xxIXOIIO(0, z);
        this.f10729a.call(120107, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, activity);
        this.f10729a.call(120105, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, d);
        this.f10729a.call(210101, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(3);
        II0xO02.Oxx0IOOO(0, activity);
        II0xO02.Oxx0IOOO(1, ritScenes);
        II0xO02.II0XooXoX(2, str);
        this.f10729a.call(120106, II0xO02.OOXIXo(), Void.class);
    }
}

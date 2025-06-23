package com.bytedance.sdk.openadsdk.c.a.a;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.Map;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class l implements TTFullScreenVideoAd {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10725a;

    public l(Bridge bridge) {
        this.f10725a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.f10725a.values().longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.f10725a.values().intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.f10725a.values().intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f10725a.values().objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public MediationFullScreenManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.a.a.a.c((Bridge) this.f10725a.call(130106, xXxxox0I.II0xO0(0).OOXIXo(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(3);
        II0xO02.Oxx0IOOO(0, d);
        II0xO02.II0XooXoX(1, str);
        II0xO02.II0XooXoX(2, str2);
        this.f10725a.call(210102, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.c.a.b.a(tTAdInteractionListener));
        this.f10725a.call(210104, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.c.a.b.b(tTAppDownloadListener));
        this.f10725a.call(130102, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new com.bytedance.sdk.openadsdk.j.a.a.a.a(fullScreenVideoAdInteractionListener));
        this.f10725a.call(130101, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, d);
        this.f10725a.call(210103, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.xxIXOIIO(0, z);
        this.f10725a.call(130105, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, activity);
        this.f10725a.call(130103, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, d);
        this.f10725a.call(210101, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(3);
        II0xO02.Oxx0IOOO(0, activity);
        II0xO02.Oxx0IOOO(1, ritScenes);
        II0xO02.II0XooXoX(2, str);
        this.f10725a.call(130104, II0xO02.OOXIXo(), Void.class);
    }
}

package com.bytedance.sdk.openadsdk.mediation.ad.a.a.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.c.a.a.d;
import com.bytedance.sdk.openadsdk.c.a.a.h;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.a.a.b.e;
import java.util.List;
import java.util.Map;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class a implements IMediationNativeAdInfo {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10841a;

    public a(Bridge bridge) {
        this.f10841a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getActionText() {
        return (String) this.f10841a.call(268005, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getAdImageMode() {
        return ((Integer) this.f10841a.call(268009, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getDescription() {
        return (String) this.f10841a.call(268002, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, activity);
        return new b((Bridge) this.f10841a.call(268102, II0xO02.OOXIXo(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public TTAdDislike getDislikeDialog2(Activity activity) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, activity);
        return new h((Bridge) this.f10841a.call(268018, II0xO02.OOXIXo(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public DislikeInfo getDislikeInfo() {
        return new d((Bridge) this.f10841a.call(268020, xXxxox0I.II0xO0(0).OOXIXo(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getIconUrl() {
        return (String) this.f10841a.call(268003, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public List<String> getImageList() {
        return (List) this.f10841a.call(268007, xXxxox0I.II0xO0(0).OOXIXo(), List.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getImageUrl() {
        return (String) this.f10841a.call(268004, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getInteractionType() {
        return ((Integer) this.f10841a.call(268010, xXxxox0I.II0xO0(0).OOXIXo(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationNativeAdAppInfo getNativeAdAppInfo() {
        return new c((Bridge) this.f10841a.values().objectValue(268101, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getSource() {
        return (String) this.f10841a.call(268008, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public double getStarRating() {
        return ((Double) this.f10841a.call(268006, xXxxox0I.II0xO0(0).OOXIXo(), Double.TYPE)).doubleValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getTitle() {
        return (String) this.f10841a.call(268001, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public boolean hasDislike() {
        return ((Boolean) this.f10841a.call(268012, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, IMediationViewBinder iMediationViewBinder) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(6);
        II0xO02.Oxx0IOOO(0, activity);
        II0xO02.Oxx0IOOO(1, viewGroup);
        II0xO02.Oxx0IOOO(2, list);
        II0xO02.Oxx0IOOO(3, list2);
        II0xO02.Oxx0IOOO(4, list3);
        II0xO02.Oxx0IOOO(5, new e(iMediationViewBinder));
        this.f10841a.call(268011, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(2);
        II0xO02.Oxx0IOOO(0, activity);
        II0xO02.Oxx0IOOO(1, new com.bytedance.sdk.openadsdk.f.a.a.a.a(dislikeInteractionCallback));
        this.f10841a.call(268016, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, tTDislikeDialogAbstract);
        this.f10841a.call(268017, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(2);
        II0xO02.Oxx0IOOO(0, activity);
        II0xO02.Oxx0IOOO(1, map);
        return new b((Bridge) this.f10841a.call(268103, II0xO02.OOXIXo(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, tTDislikeDialogAbstract);
        return new h((Bridge) this.f10841a.call(268019, II0xO02.OOXIXo(), Bridge.class));
    }
}

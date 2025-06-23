package com.bytedance.sdk.openadsdk.mediation.ad.a.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import java.util.Map;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class c extends MediationNativeAdAppInfo {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10843a;

    public c(Bridge bridge) {
        this.f10843a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, Object> getAppInfoExtra() {
        return (Map) this.f10843a.call(271042, xXxxox0I.II0xO0(0).OOXIXo(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAppName() {
        return (String) this.f10843a.call(271035, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAuthorName() {
        return (String) this.f10843a.call(271036, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getFunctionDescUrl() {
        return (String) this.f10843a.call(271047, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public long getPackageSizeBytes() {
        return ((Long) this.f10843a.call(271037, xXxxox0I.II0xO0(0).OOXIXo(), Long.TYPE)).longValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, String> getPermissionsMap() {
        return (Map) this.f10843a.call(271039, xXxxox0I.II0xO0(0).OOXIXo(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPermissionsUrl() {
        return (String) this.f10843a.call(271038, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPrivacyAgreement() {
        return (String) this.f10843a.call(271040, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getVersionName() {
        return (String) this.f10843a.call(271041, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }
}

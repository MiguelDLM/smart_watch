package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* loaded from: classes8.dex */
public class MediationNativeAppInfoImpl implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private MediationNativeAdAppInfo f10862a;
    private MediationValueSetBuilder b = MediationValueSetBuilder.create();

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.f10862a = mediationNativeAdAppInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.f10862a;
        if (mediationNativeAdAppInfo != null) {
            this.b.add(8505, mediationNativeAdAppInfo.getAppName());
            this.b.add(8506, this.f10862a.getAuthorName());
            this.b.add(8507, this.f10862a.getPackageSizeBytes());
            this.b.add(8508, this.f10862a.getPermissionsUrl());
            this.b.add(8509, this.f10862a.getPermissionsMap());
            this.b.add(8510, this.f10862a.getPrivacyAgreement());
            this.b.add(8511, this.f10862a.getVersionName());
            this.b.add(8512, this.f10862a.getAppInfoExtra());
        }
        return this.b.build();
    }
}

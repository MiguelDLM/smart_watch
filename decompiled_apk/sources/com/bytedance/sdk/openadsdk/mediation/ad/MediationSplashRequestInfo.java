package com.bytedance.sdk.openadsdk.mediation.ad;

import androidx.annotation.Nullable;

/* loaded from: classes8.dex */
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f10839a;
    private String b;
    private String c;
    private String d;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.f10839a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnName() {
        return this.f10839a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnSlotId() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppId() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppkey() {
        return this.d;
    }
}

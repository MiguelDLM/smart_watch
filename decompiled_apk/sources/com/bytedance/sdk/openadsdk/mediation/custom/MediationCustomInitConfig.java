package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: classes8.dex */
public class MediationCustomInitConfig {

    /* renamed from: a, reason: collision with root package name */
    private String f10869a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.c = str;
        this.f10869a = str2;
        this.b = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
    }

    public String getADNName() {
        return this.c;
    }

    public String getAdnInitClassName() {
        return this.d;
    }

    public String getAppId() {
        return this.f10869a;
    }

    public String getAppKey() {
        return this.b;
    }

    public String getBannerClassName() {
        return this.e;
    }

    public String getDrawClassName() {
        return this.k;
    }

    public String getFeedClassName() {
        return this.j;
    }

    public String getFullVideoClassName() {
        return this.h;
    }

    public String getInterstitialClassName() {
        return this.f;
    }

    public String getRewardClassName() {
        return this.g;
    }

    public String getSplashClassName() {
        return this.i;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.f10869a + "', mAppKey='" + this.b + "', mADNName='" + this.c + "', mAdnInitClassName='" + this.d + "', mBannerClassName='" + this.e + "', mInterstitialClassName='" + this.f + "', mRewardClassName='" + this.g + "', mFullVideoClassName='" + this.h + "', mSplashClassName='" + this.i + "', mFeedClassName='" + this.j + "', mDrawClassName='" + this.k + "'}";
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.c = valueSet.stringValue(8003);
            this.f10869a = valueSet.stringValue(8534);
            this.b = valueSet.stringValue(8535);
            this.d = valueSet.stringValue(8536);
            this.e = valueSet.stringValue(8537);
            this.f = valueSet.stringValue(8538);
            this.g = valueSet.stringValue(8539);
            this.h = valueSet.stringValue(8540);
            this.i = valueSet.stringValue(8541);
            this.j = valueSet.stringValue(8542);
            this.k = valueSet.stringValue(8543);
        }
    }
}

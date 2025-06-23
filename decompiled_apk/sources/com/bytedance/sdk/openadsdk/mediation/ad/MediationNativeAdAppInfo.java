package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Map;

/* loaded from: classes8.dex */
public class MediationNativeAdAppInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f10838a;
    private String b;
    private long c;
    private String d;
    private Map<String, String> e;
    private String f;
    private String g;
    private String h;
    private Map<String, Object> i;

    public Map<String, Object> getAppInfoExtra() {
        return this.i;
    }

    public String getAppName() {
        return this.f10838a;
    }

    public String getAuthorName() {
        return this.b;
    }

    public String getFunctionDescUrl() {
        return this.h;
    }

    public long getPackageSizeBytes() {
        return this.c;
    }

    public Map<String, String> getPermissionsMap() {
        return this.e;
    }

    public String getPermissionsUrl() {
        return this.d;
    }

    public String getPrivacyAgreement() {
        return this.f;
    }

    public String getVersionName() {
        return this.g;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.i = map;
    }

    public void setAppName(String str) {
        this.f10838a = str;
    }

    public void setAuthorName(String str) {
        this.b = str;
    }

    public void setFunctionDescUrl(String str) {
        this.h = str;
    }

    public void setPackageSizeBytes(long j) {
        this.c = j;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.e = map;
    }

    public void setPermissionsUrl(String str) {
        this.d = str;
    }

    public void setPrivacyAgreement(String str) {
        this.f = str;
    }

    public void setVersionName(String str) {
        this.g = str;
    }
}

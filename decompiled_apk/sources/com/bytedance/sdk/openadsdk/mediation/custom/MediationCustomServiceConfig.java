package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: classes8.dex */
public final class MediationCustomServiceConfig {

    /* renamed from: a, reason: collision with root package name */
    private String f10870a;
    private String b;
    private int c;
    private int d;
    private String e;

    public MediationCustomServiceConfig(String str, String str2, int i, int i2, String str3) {
        this.f10870a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = str3;
    }

    public String getADNNetworkName() {
        return this.f10870a;
    }

    public String getADNNetworkSlotId() {
        return this.b;
    }

    public int getAdStyleType() {
        return this.c;
    }

    public String getCustomAdapterJson() {
        return this.e;
    }

    public int getSubAdtype() {
        return this.d;
    }

    public String toString() {
        return "MediationCustomServiceConfig{mADNNetworkName='" + this.f10870a + "', mADNNetworkSlotId='" + this.b + "', mAdStyleType=" + this.c + ", mSubAdtype=" + this.d + ", mCustomAdapterJson='" + this.e + "'}";
    }

    public MediationCustomServiceConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.f10870a = valueSet.stringValue(8003);
            this.b = valueSet.stringValue(2);
            this.c = valueSet.intValue(8008);
            this.d = valueSet.intValue(8094);
            this.e = valueSet.stringValue(8547);
        }
    }
}

package com.bytedance.sdk.openadsdk;

/* loaded from: classes8.dex */
public class TTLocation implements LocationProvider {

    /* renamed from: a, reason: collision with root package name */
    private double f10656a;
    private double b;

    public TTLocation(double d, double d2) {
        this.f10656a = d;
        this.b = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.f10656a;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.b;
    }

    public void setLatitude(double d) {
        this.f10656a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }
}

package com.baidu.platform.comapi.basestruct;

/* loaded from: classes8.dex */
public class GeoPoint {

    /* renamed from: a, reason: collision with root package name */
    private double f9537a;
    private double b;

    public GeoPoint(int i, int i2) {
        this.f9537a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (Math.abs(this.f9537a - geoPoint.f9537a) > 1.0E-6d || Math.abs(this.b - geoPoint.b) > 1.0E-6d) {
            return false;
        }
        return true;
    }

    public double getLatitude() {
        return this.f9537a;
    }

    public double getLatitudeE6() {
        return this.f9537a;
    }

    public double getLongitude() {
        return this.b;
    }

    public double getLongitudeE6() {
        return this.b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public void setLatitude(double d) {
        this.f9537a = d;
    }

    public void setLatitudeE6(double d) {
        this.f9537a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public void setLongitudeE6(double d) {
        this.b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f9537a + ", Longitude: " + this.b;
    }

    public void setLatitude(int i) {
        this.f9537a = i;
    }

    public void setLongitude(int i) {
        this.b = i;
    }

    public GeoPoint(double d, double d2) {
        this.f9537a = d;
        this.b = d2;
    }
}

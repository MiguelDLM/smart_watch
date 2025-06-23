package com.baidu.nplatform.comapi.basestruct;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class GeoPoint implements Serializable {
    public static final int INVALID_VALUE = Integer.MIN_VALUE;
    private static final long serialVersionUID = 8310223307513791423L;
    private int mLatitudeE6;
    private int mLongitudeE6;

    public GeoPoint() {
        this.mLongitudeE6 = Integer.MIN_VALUE;
        this.mLatitudeE6 = Integer.MIN_VALUE;
    }

    public boolean approximate(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeoPoint.class != obj.getClass()) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (Math.abs(this.mLatitudeE6 - geoPoint.mLatitudeE6) <= 3 && Math.abs(this.mLongitudeE6 - geoPoint.mLongitudeE6) <= 3) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeoPoint.class != obj.getClass()) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.mLatitudeE6 == geoPoint.mLatitudeE6 && this.mLongitudeE6 == geoPoint.mLongitudeE6) {
            return true;
        }
        return false;
    }

    public int getLatitudeE6() {
        return this.mLatitudeE6;
    }

    public int getLongitudeE6() {
        return this.mLongitudeE6;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isValid() {
        if (this.mLongitudeE6 != Integer.MIN_VALUE && this.mLatitudeE6 != Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public void setLatitudeE6(int i) {
        this.mLatitudeE6 = i;
    }

    public void setLongitudeE6(int i) {
        this.mLongitudeE6 = i;
    }

    public String toString() {
        return "GeoPoint(" + this.mLongitudeE6 + "," + this.mLatitudeE6 + ") ";
    }

    public String toStringForAutoCheck() {
        return "{\"mLatitudeE6\":" + this.mLatitudeE6 + ", \"mLongitudeE6\":" + this.mLongitudeE6 + '}';
    }

    public GeoPoint(GeoPoint geoPoint) {
        this.mLongitudeE6 = geoPoint.mLongitudeE6;
        this.mLatitudeE6 = geoPoint.mLatitudeE6;
    }

    public GeoPoint(int i, int i2) {
        this.mLongitudeE6 = i;
        this.mLatitudeE6 = i2;
    }
}

package com.baidu.ar.baidumap.bean;

/* loaded from: classes7.dex */
public class VpasDestination extends CommandDate {
    private double[] mLocationAt;
    private float mScale = 1.0f;

    public VpasDestination(double[] dArr) {
        this.mLocationAt = dArr;
    }

    public double[] getLocationAt() {
        return this.mLocationAt;
    }

    public float getScale() {
        return this.mScale;
    }

    public void setLocationAt(double[] dArr) {
        this.mLocationAt = dArr;
    }

    public void setScale(float f) {
        this.mScale = f;
    }
}

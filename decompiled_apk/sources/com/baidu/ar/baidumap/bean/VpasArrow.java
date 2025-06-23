package com.baidu.ar.baidumap.bean;

/* loaded from: classes7.dex */
public class VpasArrow extends CommandDate {
    private String mArrowId;
    private ArrowType mArrowType;
    private double[] mLocationAt;
    private double[] mLocationEnd;
    private double[] mLocationStart;
    private float mScale = 1.0f;

    /* loaded from: classes7.dex */
    public enum ArrowType {
        POSTURE_LIE_DOWN,
        POSTURE_STAND
    }

    public VpasArrow(String str, ArrowType arrowType, double[] dArr, double[] dArr2, double[] dArr3) {
        this.mArrowId = str;
        this.mArrowType = arrowType;
        this.mLocationStart = dArr;
        this.mLocationEnd = dArr2;
        this.mLocationAt = dArr3;
    }

    public String getArrowId() {
        return this.mArrowId;
    }

    public ArrowType getArrowType() {
        return this.mArrowType;
    }

    public double[] getLocationAt() {
        return this.mLocationAt;
    }

    public double[] getLocationEnd() {
        return this.mLocationEnd;
    }

    public double[] getLocationStart() {
        return this.mLocationStart;
    }

    public float getScale() {
        return this.mScale;
    }

    public void setArrowId(String str) {
        this.mArrowId = str;
    }

    public void setArrowType(ArrowType arrowType) {
        this.mArrowType = arrowType;
    }

    public void setLocationAt(double[] dArr) {
        this.mLocationAt = dArr;
    }

    public void setLocationEnd(double[] dArr) {
        this.mLocationEnd = dArr;
    }

    public void setLocationStart(double[] dArr) {
        this.mLocationStart = dArr;
    }

    public void setScale(float f) {
        this.mScale = f;
    }
}

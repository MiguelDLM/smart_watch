package com.baidu.ar.marker;

/* loaded from: classes7.dex */
public class MarkerFrameInfo {
    private byte[] image;
    private int tS;
    private int tT;
    private double[] tU;
    private float[] tV;
    private float[] tW;
    private int tX;
    private int tY;
    private float[] tZ;
    private float ua;
    private float[] ub;

    public float[] getDistort() {
        return this.tW;
    }

    public int getFps() {
        return this.tY;
    }

    public byte[] getImage() {
        return this.image;
    }

    public int getInputHeight() {
        return this.tT;
    }

    public int getInputWidth() {
        return this.tS;
    }

    public float[] getIntrinsics() {
        return this.tV;
    }

    public double[] getMagnet() {
        return this.tU;
    }

    public float[] getOrignalTransform() {
        return this.ub;
    }

    public float[] getPoseMat() {
        return this.tZ;
    }

    public float getScaleY() {
        return this.ua;
    }

    public int getTrackingState() {
        return this.tX;
    }

    public void setDistort(float[] fArr) {
        this.tW = fArr;
    }

    public void setFps(int i) {
        this.tY = i;
    }

    public void setImage(byte[] bArr) {
        this.image = bArr;
    }

    public void setInputHeight(int i) {
        this.tT = i;
    }

    public void setInputWidth(int i) {
        this.tS = i;
    }

    public void setIntrinsics(float[] fArr) {
        this.tV = fArr;
    }

    public void setMagnet(double[] dArr) {
        this.tU = dArr;
    }

    public void setOrignalTransform(float[] fArr) {
        this.ub = fArr;
    }

    public void setPoseMat(float[] fArr) {
        this.tZ = fArr;
    }

    public void setScaleY(float f) {
        this.ua = f;
    }

    public void setTrackingState(int i) {
        this.tX = i;
    }
}

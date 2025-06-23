package com.baidu.ar;

import com.baidu.ar.algo.FrameType;
import com.baidu.ar.marker.TrackerStatus;
import com.baidu.ar.marker.model.TranslationPrior;

/* loaded from: classes7.dex */
public class ga {
    private int height;
    private byte[] image;
    private float[] pose;
    private double[] tU;
    private float[] tV;
    private float[] tW;
    private double ui;
    private float[] uj;
    private TrackerStatus uk;
    private int ul = 2;
    private float[] um;
    private FrameType un;
    private TranslationPrior uo;
    private int width;

    public void E(int i) {
        this.ul = i;
    }

    public void a(double d) {
        this.ui = d;
    }

    public void clear() {
        if (this.image != null) {
            this.image = null;
        }
    }

    public void e(float[] fArr) {
        this.um = fArr;
    }

    public TranslationPrior eo() {
        return this.uo;
    }

    public float[] ep() {
        return this.um;
    }

    public double eq() {
        return this.ui;
    }

    public float[] er() {
        return this.uj;
    }

    public TrackerStatus es() {
        return this.uk;
    }

    public int et() {
        return this.ul;
    }

    public FrameType eu() {
        return this.un;
    }

    public void f(float[] fArr) {
        this.uj = fArr;
    }

    public float[] getDistort() {
        return this.tW;
    }

    public int getHeight() {
        return this.height;
    }

    public byte[] getImage() {
        return this.image;
    }

    public float[] getIntrinsics() {
        return this.tV;
    }

    public double[] getMagnet() {
        return this.tU;
    }

    public float[] getPose() {
        return this.pose;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDistort(float[] fArr) {
        this.tW = fArr;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setImage(byte[] bArr) {
        this.image = bArr;
    }

    public void setIntrinsics(float[] fArr) {
        this.tV = fArr;
    }

    public void setMagnet(double[] dArr) {
        this.tU = dArr;
    }

    public void setPose(float[] fArr) {
        this.pose = fArr;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void a(FrameType frameType) {
        this.un = frameType;
    }

    public void a(TrackerStatus trackerStatus) {
        this.uk = trackerStatus;
    }

    public void a(TranslationPrior translationPrior) {
        this.uo = translationPrior;
    }
}

package com.baidu.ar;

/* loaded from: classes7.dex */
public class fh {
    private float[] ku;
    private int sQ;
    private float sR;
    private float[] sS;

    public void B(int i) {
        this.sQ = i;
    }

    public void a(float f) {
        this.sR = f;
    }

    public int dU() {
        return this.sQ;
    }

    public float[] dV() {
        return this.sS;
    }

    public float getAngle() {
        return this.sR;
    }

    public float[] getMatrix() {
        return this.ku;
    }

    public void setMatrix(float[] fArr) {
        this.ku = fArr;
    }

    public void a(float[] fArr) {
        this.sS = fArr;
    }
}

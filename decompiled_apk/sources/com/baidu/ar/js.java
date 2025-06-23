package com.baidu.ar;

/* loaded from: classes7.dex */
public class js {
    private boolean Br;
    private boolean Bs;
    private boolean Bt;
    private float[] ku;
    private long mTimestamp;
    private float sZ;
    private boolean vU;
    private boolean vW;
    private long vX;

    public void C(boolean z) {
        this.vU = z;
    }

    public void D(boolean z) {
        this.vW = z;
    }

    public void T(boolean z) {
        this.Br = z;
    }

    public void U(boolean z) {
        this.Bs = z;
    }

    public void V(boolean z) {
        this.Bt = z;
    }

    public void d(float f) {
        this.sZ = f;
    }

    public void f(long j) {
        this.vX = j;
    }

    public float getDistance() {
        return this.sZ;
    }

    public float[] getMatrix() {
        return this.ku;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public boolean gx() {
        return this.Bs;
    }

    public boolean gy() {
        return this.Bt;
    }

    public boolean isTracked() {
        return this.vW;
    }

    public void setMatrix(float[] fArr) {
        this.ku = fArr;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}

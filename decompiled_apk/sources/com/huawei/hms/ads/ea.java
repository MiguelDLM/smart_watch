package com.huawei.hms.ads;

import java.nio.FloatBuffer;

/* loaded from: classes10.dex */
class ea {
    private final int B;
    private final int C;
    private final float[] Code;
    private final int D;
    private final FloatBuffer F;
    private final int I;
    private final int L;
    private final float[] S;
    private final FloatBuffer V;
    private final int Z;

    public ea(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        this.Code = fArr;
        this.V = floatBuffer;
        this.I = i;
        this.Z = i2;
        this.B = i3;
        this.C = i4;
        this.S = fArr2;
        this.F = floatBuffer2;
        this.D = i5;
        this.L = i6;
    }

    public int B() {
        return this.B;
    }

    public int C() {
        return this.C;
    }

    public float[] Code() {
        return this.Code;
    }

    public int D() {
        return this.D;
    }

    public FloatBuffer F() {
        return this.F;
    }

    public int I() {
        return this.I;
    }

    public int L() {
        return this.L;
    }

    public float[] S() {
        return this.S;
    }

    public FloatBuffer V() {
        return this.V;
    }

    public int Z() {
        return this.Z;
    }
}

package com.baidu.ar;

import android.opengl.Matrix;

/* loaded from: classes7.dex */
public class mi extends mh implements mm {
    protected float[] FE;
    protected float[] FF;

    public mi(String str, int i) {
        super(str, i);
        this.FE = new float[16];
        this.FF = new float[16];
    }

    @Override // com.baidu.ar.mm
    public boolean iq() {
        return false;
    }

    public float[] iu() {
        if (this.Fy == null) {
            return this.FF;
        }
        float[] fArr = new float[16];
        Matrix.invertM(fArr, 0, this.FF, 0);
        float[] fArr2 = new float[16];
        Matrix.multiplyMM(fArr2, 0, fArr, 0, this.Fy.iw(), 0);
        float[] fArr3 = new float[16];
        Matrix.invertM(fArr3, 0, fArr2, 0);
        return fArr3;
    }

    @Override // com.baidu.ar.mh
    public void reset() {
    }
}

package com.baidu.ar;

import android.opengl.Matrix;

/* loaded from: classes7.dex */
public class nl extends mh {
    private long HA;
    private boolean HB;
    float[] HC;
    private float[] Hw;
    private float[] Hx;
    private float[] Hy;
    private int jf;

    public nl(String str, int i) {
        super(str, i);
        this.HA = 20L;
        this.HB = true;
        this.HC = new float[]{0.0f, 1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        float[] fArr = new float[16];
        this.Hw = fArr;
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(this.Hw, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        float[] fArr2 = new float[16];
        this.Hx = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.rotateM(this.Hx, 0, 180.0f, 0.0f, 0.0f, 1.0f);
        float[] fArr3 = new float[16];
        Matrix.multiplyMM(fArr3, 0, this.Hx, 0, this.Hw, 0);
        float[] fArr4 = new float[16];
        this.Hy = fArr4;
        Matrix.multiplyMM(fArr4, 0, this.Hx, 0, fArr3, 0);
    }

    public float[] a(int i, float[] fArr) {
        this.jf++;
        float[] fArr2 = new float[16];
        Matrix.multiplyMM(fArr2, 0, fArr, 0, this.HC, 0);
        float[] fArr3 = new float[16];
        this.FB = fArr3;
        Matrix.multiplyMM(fArr3, 0, this.Hy, 0, fArr2, 0);
        boolean z = this.HB;
        if (z && i == 0 && this.jf >= this.HA) {
            this.HB = !z;
            this.Fx = true;
            this.FC.il();
            this.FC = null;
        }
        mr mrVar = this.FD;
        if (mrVar != null) {
            mrVar.a(this);
        }
        return this.FB;
    }

    @Override // com.baidu.ar.mh, com.baidu.ar.mq
    public int ir() {
        return this.Fr;
    }

    @Override // com.baidu.ar.mh
    public void reset() {
        super.reset();
        this.HB = true;
        this.Fx = false;
        this.FD = null;
    }
}

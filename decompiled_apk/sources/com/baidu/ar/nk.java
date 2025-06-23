package com.baidu.ar;

import android.content.Context;
import android.opengl.Matrix;

/* loaded from: classes7.dex */
public class nk extends mh {
    private long HA;
    private float[] Hw;
    private float[] Hx;
    private float[] Hy;
    private float[] Hz;
    private int jf;

    public nk(Context context) {
        super("IMU", my.Local3Dof.Fr);
        this.HA = 20L;
        float[] fArr = new float[16];
        this.Hw = fArr;
        Matrix.setIdentityM(fArr, 0);
        Matrix.rotateM(this.Hw, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        float[] fArr2 = new float[16];
        this.Hx = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.rotateM(this.Hx, 0, 180.0f, 0.0f, 0.0f, 1.0f);
        float[] fArr3 = new float[16];
        this.Hy = fArr3;
        Matrix.multiplyMM(fArr3, 0, this.Hx, 0, this.Hw, 0);
    }

    public float[] F(float[] fArr) {
        float[] fArr2 = {fArr[0], fArr[4], fArr[8], 0.0f, fArr[1], fArr[5], fArr[9], 0.0f, fArr[2], fArr[6], fArr[10], 0.0f, fArr[3], fArr[7], fArr[11], 1.0f};
        this.Fx = true;
        this.jf++;
        float[] fArr3 = new float[16];
        this.Hz = fArr3;
        Matrix.setIdentityM(fArr3, 0);
        Matrix.rotateM(this.Hz, 0, -90.0f, 1.0f, 0.0f, 0.0f);
        float[] fArr4 = new float[16];
        Matrix.multiplyMM(fArr4, 0, this.Hz, 0, fArr2, 0);
        Matrix.multiplyMM(this.FB, 0, this.Hy, 0, fArr4, 0);
        mf mfVar = this.FC;
        if (mfVar != null && this.jf >= this.HA) {
            mfVar.il();
            this.FC = null;
        }
        mr mrVar = this.FD;
        if (mrVar != null) {
            mrVar.a(this);
        }
        return this.FB;
    }

    @Override // com.baidu.ar.mh, com.baidu.ar.mo
    public boolean is() {
        return this.Fx;
    }
}

package com.baidu.ar;

import android.opengl.Matrix;
import com.baidu.ar.arplay.representation.Vector4f;

/* loaded from: classes7.dex */
public class mu implements mn {
    public float[] FU = new float[16];
    public Vector4f FP = new Vector4f();
    public Vector4f FV = new Vector4f();
    public float[] FW = new float[16];

    @Override // com.baidu.ar.mn
    public void b(float[] fArr, float[] fArr2, float[] fArr3) {
        this.FU = fArr;
        this.FP = nq.J(fArr2);
        this.FV = nq.J(fArr3);
        float[] fArr4 = new float[16];
        Matrix.setIdentityM(fArr4, 0);
        float[] G = nn.G(fArr4);
        Vector4f H = nn.H(fArr4);
        float[] fArr5 = new float[16];
        Matrix.multiplyMM(fArr5, 0, this.FU, 0, G, 0);
        H.add(nn.b(this.FV));
        float[] fArr6 = new float[4];
        Matrix.multiplyMV(fArr6, 0, this.FU, 0, H.toArray(), 0);
        Vector4f J = nq.J(fArr6);
        J.add(this.FP);
        fArr5[12] = J.getX();
        fArr5[13] = J.getY();
        fArr5[14] = J.getZ();
        this.FW = fArr5;
    }

    @Override // com.baidu.ar.mn
    public float[] iw() {
        return this.FW;
    }

    @Override // com.baidu.ar.mn
    public float[] w(float[] fArr) {
        float[] fArr2 = new float[16];
        Matrix.multiplyMM(fArr2, 0, this.FW, 0, fArr, 0);
        return fArr2;
    }
}

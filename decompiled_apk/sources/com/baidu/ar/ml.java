package com.baidu.ar;

import XIXIX.OOXIXo;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.ar.arplay.representation.Vector4f;

/* loaded from: classes7.dex */
public class ml {
    public boolean FM;
    public float FN;
    private float[] FO = new float[16];
    private Vector4f FP = new Vector4f();
    private Vector4f FQ = new Vector4f();
    private float[] FR = new float[4];
    public float[] FS = new float[16];
    public float[] FT = new float[16];

    private void iv() {
        float[] fArr = this.FS;
        System.arraycopy(fArr, 0, r4, 0, fArr.length);
        float[] fArr2 = {r3[0], r3[1], r3[2], r3[3], r2[0], r2[1], r2[2], r2[3], r3[0], r3[1], r3[2], r3[3], 0.0f, 0.0f, 0.0f, 1.0f};
        float[] u = u(new float[]{fArr2[1], fArr2[2], fArr2[3], fArr2[4]});
        float[] u2 = u(new float[]{fArr2[4], fArr2[5], fArr2[6], fArr2[7]});
        float[] u3 = u(new float[]{fArr2[8], fArr2[9], fArr2[10], fArr2[11]});
        float[] fArr3 = new float[4];
        Matrix.multiplyMV(fArr3, 0, fArr2, 0, new Vector4f(0.0f, 1.0f, 0.0f, 1.0f).toArray(), 0);
        float[] v = v(new float[]{fArr3[0], fArr3[1]});
        float f = v[0];
        double d = OOXIXo.f3760XO;
        if (f != 0.0f || v[1] >= 0.0f) {
            if (f == 0.0f && v[1] > 0.0f) {
                d = 3.141592653589793d;
            } else if (f > 0.0f && v[1] == 0.0f) {
                d = 1.5707963267948966d;
            } else if (f >= 0.0f || v[1] != 0.0f) {
                if (f > 0.0f) {
                    if (v[1] < 0.0f) {
                        d = Math.atan(f / (-r13));
                    }
                }
                if (f > 0.0f) {
                    if (v[1] > 0.0f) {
                        d = Math.atan(r13 / f) + 1.5707963267948966d;
                    }
                }
                if (f < 0.0f) {
                    if (v[1] > 0.0f) {
                        d = Math.atan((-f) / r9) + 3.141592653589793d;
                    }
                }
                if (f < 0.0f) {
                    if (v[1] < 0.0f) {
                        d = Math.atan(r1 / f) + 4.71238898038469d;
                    }
                }
            } else {
                d = 4.71238898038469d;
            }
        }
        this.FN = (float) d;
        Log.e("GeoLocalTransform", "angle: " + ((d / 3.141592653589793d) * 180.0d));
    }

    private void normalize() {
        float[] fArr = new float[16];
        Matrix.invertM(fArr, 0, this.FO, 0);
        Vector4f J = nq.J(new float[]{0.0f, 0.0f, 0.0f, 1.0f});
        J.subtract(this.FP);
        float[] fArr2 = new float[4];
        Matrix.multiplyMV(fArr2, 0, fArr, 0, J.toArray(), 0);
        Vector4f J2 = nq.J(fArr2);
        J2.subdivide(nq.J(this.FR));
        J2.setY(-J2.getY());
        J2.setX(-J2.getX());
        J2.add(this.FQ);
        float[] fArr3 = {J2.getX(), J2.getY()};
        this.FQ = new Vector4f(J2.getX(), J2.getY(), 0.0f, 1.0f);
        this.FP = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
        this.FR = t(fArr3);
        float[] fArr4 = new float[16];
        Matrix.invertM(fArr4, 0, this.FO, 0);
        float[] fArr5 = this.FR;
        float[] fArr6 = new float[16];
        Matrix.multiplyMM(fArr6, 0, nn.a(new Vector4f(1.0f / (-fArr5[0]), 1.0f / (-fArr5[1]), 1.0f, 1.0f)), 0, fArr4, 0);
        float[] fArr7 = {fArr6[0], fArr6[1], fArr6[2], fArr6[3], fArr6[4], fArr6[5], fArr6[6], fArr6[7], fArr6[8], fArr6[9], fArr6[10], fArr6[11], this.FQ.getX(), this.FQ.getY(), this.FQ.getZ(), 1.0f};
        this.FT = fArr7;
        Matrix.invertM(this.FS, 0, fArr7, 0);
    }

    private float[] t(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float[] fArr2 = {f, f2};
        float[] fArr3 = {f, f2 + 1.0f};
        float[] fArr4 = {f + 1.0f, f2};
        return new float[]{nn.d(fArr4[0], fArr4[1], fArr2[0], fArr2[1]), nn.d(fArr3[0], fArr3[1], fArr2[0], fArr2[1]), 0.0f, 1.0f};
    }

    private float[] u(float[] fArr) {
        float sqrt = (float) Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d) + Math.pow(fArr[3], 2.0d));
        return new float[]{fArr[0] / sqrt, fArr[1] / sqrt, fArr[2] / sqrt, fArr[3] / sqrt};
    }

    private float[] v(float[] fArr) {
        float sqrt = (float) Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d));
        return new float[]{fArr[0] / sqrt, fArr[1] / sqrt};
    }

    public void a(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        this.FO = fArr;
        this.FP = nq.J(fArr2);
        this.FQ = nq.J(fArr3);
        this.FR = fArr4;
        normalize();
        iv();
    }

    public void q(float[] fArr) {
        this.FS = fArr;
        Matrix.invertM(this.FT, 0, fArr, 0);
        iv();
    }

    public float[] r(float[] fArr) {
        float[] fArr2 = {fArr[0], fArr[1], 0.0f, 1.0f};
        float[] fArr3 = this.FS;
        Vector4f J = nq.J(fArr2);
        no.a(new double[]{fArr3[0], fArr3[1], fArr3[2], fArr3[3], fArr3[4], fArr3[5], fArr3[6], fArr3[7], fArr3[8], fArr3[9], fArr3[10], fArr3[11], fArr3[12], fArr3[13], fArr3[14], fArr3[15]}, J);
        return J.toArray();
    }

    public float[] s(float[] fArr) {
        float[] fArr2 = new float[4];
        Matrix.multiplyMV(fArr2, 0, this.FT, 0, fArr, 0);
        return new float[]{fArr2[0], fArr2[1]};
    }
}

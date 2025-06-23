package com.baidu.ar;

import XIXIX.OOXIXo;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.ar.arplay.representation.Vector4f;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class nn {
    public static float[] G(float[] fArr) {
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
        return fArr;
    }

    public static Vector4f H(float[] fArr) {
        return new Vector4f(fArr[12], fArr[13], fArr[14], 0.0f);
    }

    public static double I(float[] fArr) {
        float[] G = G(fArr);
        Log.e("GeoLocalTransform", "rotate：" + Arrays.toString(G));
        float[] fArr2 = new float[4];
        Matrix.multiplyMV(fArr2, 0, G, 0, new float[]{0.0f, 0.0f, -1.0f, 1.0f}, 0);
        Vector4f J = nq.J(fArr2);
        Log.e("GeoLocalTransform", "vector：" + Arrays.toString(J.toArray()));
        if (J.getX() == 0.0f && J.getY() < 0.0f) {
            return OOXIXo.f3760XO;
        }
        if (J.getX() == 0.0f && J.getY() > 0.0f) {
            return 3.141592653589793d;
        }
        if (J.getX() > 0.0f && J.getY() == 0.0f) {
            return 1.5707963267948966d;
        }
        if (J.getX() >= 0.0f || J.getY() != 0.0f) {
            return (J.getX() <= 0.0f || J.getY() >= 0.0f) ? (J.getX() <= 0.0f || J.getY() <= 0.0f) ? (J.getX() >= 0.0f || J.getY() <= 0.0f) ? (J.getX() >= 0.0f || J.getY() >= 0.0f) ? OOXIXo.f3760XO : Math.atan(J.getY() / J.getX()) + 4.71238898038469d : Math.atan((-J.getX()) / J.getY()) + 3.141592653589793d : Math.atan(J.getY() / J.getX()) + 1.5707963267948966d : Math.atan(J.getX() / (-J.getY()));
        }
        return 4.71238898038469d;
    }

    public static float[] a(Vector4f vector4f) {
        return new float[]{vector4f.getX(), 0.0f, 0.0f, 0.0f, 0.0f, vector4f.getY(), 0.0f, 0.0f, 0.0f, 0.0f, vector4f.getZ(), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public static double b(double d) {
        while (d > 360.0d) {
            d -= 360.0d;
        }
        while (d < OOXIXo.f3760XO) {
            d += 360.0d;
        }
        return d;
    }

    public static float d(float f, float f2, float f3, float f4) {
        float f5 = (float) ((f2 * 3.141592653589793d) / 180.0d);
        float f6 = (float) ((f4 * 3.141592653589793d) / 180.0d);
        return Math.round((((float) (Math.asin(Math.sqrt(Math.pow(Math.sin((f5 - f6) / 2.0f), 2.0d) + ((Math.cos(f5) * Math.cos(f6)) * Math.pow(Math.sin(((float) (((f - f3) * 3.141592653589793d) / 180.0d)) / 2.0f), 2.0d)))) * 2.0d)) * 6378137.0f) * 10000.0f) / 10000.0f;
    }

    public static float[] e(float[] fArr, float[] fArr2) {
        float[] fArr3 = {fArr2[0], fArr2[1], fArr2[2], fArr2[3], fArr2[4], fArr2[5], fArr2[6], fArr2[7], fArr2[8], fArr2[9], fArr2[10], fArr2[11], 0.0f, 0.0f, 0.0f, 1.0f};
        float[] fArr4 = {fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7], fArr[8], fArr[9], fArr[10], fArr[11], 0.0f, 0.0f, 0.0f, 1.0f};
        float[] fArr5 = new float[16];
        Matrix.invertM(fArr5, 0, fArr3, 0);
        float[] fArr6 = new float[16];
        Matrix.multiplyMM(fArr6, 0, fArr4, 0, fArr5, 0);
        return fArr6;
    }

    public static Vector4f b(Vector4f vector4f) {
        return new Vector4f(-vector4f.getX(), -vector4f.getY(), -vector4f.getZ(), -vector4f.getW());
    }
}

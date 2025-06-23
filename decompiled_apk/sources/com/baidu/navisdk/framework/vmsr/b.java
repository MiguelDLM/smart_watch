package com.baidu.navisdk.framework.vmsr;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class b {
    public static float[] a(float f, int i) {
        float[] fArr = new float[i];
        Arrays.fill(fArr, f);
        return fArr;
    }

    public static float b(float[] fArr) {
        float f = fArr[0];
        int length = fArr.length;
        for (int i = 1; i < length; i++) {
            float f2 = fArr[i];
            if (f > f2) {
                f = f2;
            }
        }
        return f;
    }

    public static void c(float[][] fArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            float abs = Math.abs(fArr[0][i3]);
            fArr[0][i3] = 0.0f;
            for (int i4 = 1; i4 < i; i4++) {
                float[] fArr2 = fArr[i4];
                fArr2[i3] = Math.abs(fArr2[i3]) - abs;
            }
        }
    }

    public static float d(float[][] fArr, int i, int i2) {
        float abs = Math.abs(fArr[0][i2]);
        int min = Math.min(i, fArr.length);
        float f = abs;
        for (int i3 = 1; i3 < min; i3++) {
            float abs2 = Math.abs(fArr[i3][i2]);
            abs = Math.max(abs, abs2);
            f = Math.min(f, abs2);
        }
        return abs - f;
    }

    @Deprecated
    public static float[][] a(float[] fArr, int i) {
        float[][] fArr2 = new float[i];
        Arrays.fill(fArr2, fArr);
        return fArr2;
    }

    public static float b(float[][] fArr, int i, int i2) {
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i3 = 0; i3 < i; i3++) {
            f2 += fArr[i3][i2];
        }
        float f3 = f2 / i;
        for (int i4 = 0; i4 < i; i4++) {
            float f4 = fArr[i4][i2];
            f += (f4 - f3) * (f4 - f3);
        }
        return (float) Math.sqrt(f / r2);
    }

    public static float[][] a(float f, int i, int i2) {
        int[] iArr = {i, i2};
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, iArr);
        for (int i3 = 0; i3 < i; i3++) {
            Arrays.fill(fArr[i3], f);
        }
        return fArr;
    }

    public static float[] a(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        if (fArr4 == null) {
            fArr4 = new float[fArr.length + fArr2.length + fArr3.length];
        }
        System.arraycopy(fArr, 0, fArr4, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr4, fArr.length, fArr2.length);
        System.arraycopy(fArr3, 0, fArr4, fArr.length + fArr2.length, fArr3.length);
        return fArr4;
    }

    public static float[][] a(float[][] fArr, float[][] fArr2) {
        if (fArr == null) {
            return fArr2;
        }
        if (fArr2 == null) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        int max = Math.max(fArr[0].length, fArr2[0].length);
        float[][] fArr3 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, length, max);
        int length2 = fArr.length;
        for (int i = 0; i < length2; i++) {
            for (int i2 = 0; i2 < max; i2++) {
                fArr3[i][i2] = fArr[i][i2];
            }
        }
        for (int i3 = 0; i3 < fArr2.length; i3++) {
            for (int i4 = 0; i4 < max; i4++) {
                fArr3[fArr.length + i3][i4] = fArr2[i3][i4];
            }
        }
        return fArr3;
    }

    public static float a(float[] fArr) {
        float f = fArr[0];
        int length = fArr.length;
        for (int i = 1; i < length; i++) {
            float f2 = fArr[i];
            if (f < f2) {
                f = f2;
            }
        }
        return f;
    }

    public static int a(float[] fArr, float f) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (fArr[i] == f) {
                return i;
            }
        }
        return -1;
    }

    public static int a(Object[] objArr, Object obj) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public static String a(float[][] fArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        int length = fArr[0].length;
        while (i < i2) {
            for (int i3 = 0; i3 < length; i3++) {
                sb.append(String.format("%f", Float.valueOf(fArr[i][i3])));
                sb.append(",");
            }
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }
}

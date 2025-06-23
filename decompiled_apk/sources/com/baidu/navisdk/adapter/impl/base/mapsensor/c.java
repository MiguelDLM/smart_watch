package com.baidu.navisdk.adapter.impl.base.mapsensor;

/* loaded from: classes7.dex */
public class c {
    public static float a(float f, float f2) {
        return f2 + ((f - f2) * 0.1f);
    }

    public static void a(float[] fArr, float[] fArr2) {
        float sqrt;
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        if (fArr2.length >= 4) {
            sqrt = fArr2[3];
        } else {
            float f4 = ((1.0f - (f * f)) - (f2 * f2)) - (f3 * f3);
            sqrt = f4 > 0.0f ? (float) Math.sqrt(f4) : 0.0f;
        }
        float f5 = f * 2.0f;
        float f6 = f * f5;
        float f7 = f2 * 2.0f;
        float f8 = f7 * f2;
        float f9 = 2.0f * f3;
        float f10 = f9 * f3;
        float f11 = f2 * f5;
        float f12 = f9 * sqrt;
        float f13 = f5 * f3;
        float f14 = f7 * sqrt;
        float f15 = f7 * f3;
        float f16 = f5 * sqrt;
        if (fArr.length == 9) {
            fArr[0] = (1.0f - f8) - f10;
            fArr[1] = f11 - f12;
            fArr[2] = f13 + f14;
            fArr[3] = f11 + f12;
            float f17 = 1.0f - f6;
            fArr[4] = f17 - f10;
            fArr[5] = f15 - f16;
            fArr[6] = f13 - f14;
            fArr[7] = f15 + f16;
            fArr[8] = f17 - f8;
            return;
        }
        if (fArr.length == 16) {
            fArr[0] = (1.0f - f8) - f10;
            fArr[1] = f11 - f12;
            fArr[2] = f13 + f14;
            fArr[3] = 0.0f;
            fArr[4] = f11 + f12;
            float f18 = 1.0f - f6;
            fArr[5] = f18 - f10;
            fArr[6] = f15 - f16;
            fArr[7] = 0.0f;
            fArr[8] = f13 - f14;
            fArr[9] = f15 + f16;
            fArr[10] = f18 - f8;
            fArr[11] = 0.0f;
            fArr[14] = 0.0f;
            fArr[13] = 0.0f;
            fArr[12] = 0.0f;
            fArr[15] = 1.0f;
        }
    }
}

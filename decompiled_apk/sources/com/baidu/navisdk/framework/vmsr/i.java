package com.baidu.navisdk.framework.vmsr;

import XIXIX.OOXIXo;

/* loaded from: classes7.dex */
public class i {
    public static void a(float[] fArr, int i, float[] fArr2, int i2, float[] fArr3, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                double d = OOXIXo.f3760XO;
                for (int i9 = 0; i9 < i6; i9++) {
                    d += fArr[(i8 * i6) + i9] * fArr2[(i9 * i5) + i7];
                }
                fArr3[(i8 * i5) + i7] = (float) d;
            }
        }
    }

    public static void a(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4) {
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            fArr2[i5] = fArr[i5];
        }
    }
}

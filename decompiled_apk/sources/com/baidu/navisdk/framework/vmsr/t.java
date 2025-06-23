package com.baidu.navisdk.framework.vmsr;

/* loaded from: classes7.dex */
public class t {
    public static boolean a(k[] kVarArr, int i) {
        int length = kVarArr.length;
        for (int i2 = length - 1; i2 >= length - i; i2--) {
            k kVar = kVarArr[i2];
            if (kVar.c <= 4 || kVar.b >= 30.0f || kVar.f6844a < 3.0f) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(float f) {
        return f > 0.5f;
    }

    public static boolean c(float f) {
        if (Math.round(f) >= 0 && f <= 10.0f) {
            return true;
        }
        return false;
    }

    public static boolean d(float f) {
        if (Math.round(f) >= 0 && f <= 3.6f) {
            return true;
        }
        return false;
    }

    public static boolean a(float f) {
        return Math.round(f) == -1;
    }
}

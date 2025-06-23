package org.apache.commons.lang3;

import java.util.Random;

/* loaded from: classes6.dex */
public class IO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Random f32495oIX0oI = new Random();

    public static double I0Io() {
        return oxoX(XIXIX.OOXIXo.f3760XO, Double.MAX_VALUE);
    }

    public static int II0XooXoX(int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (i2 >= i) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Start value must be smaller or equal to end value.", new Object[0]);
        if (i < 0) {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "Both range values must be non-negative.", new Object[0]);
        if (i == i2) {
            return i;
        }
        return i + f32495oIX0oI.nextInt(i2 - i);
    }

    public static byte[] II0xO0(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i];
        f32495oIX0oI.nextBytes(bArr);
        return bArr;
    }

    public static int Oxx0IOOO() {
        return II0XooXoX(0, Integer.MAX_VALUE);
    }

    public static float X0o0xo() {
        return XO(0.0f, Float.MAX_VALUE);
    }

    public static float XO(float f, float f2) {
        boolean z;
        boolean z2 = true;
        if (f2 >= f) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Start value must be smaller or equal to end value.", new Object[0]);
        if (f < 0.0f) {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "Both range values must be non-negative.", new Object[0]);
        if (f == f2) {
            return f;
        }
        return f + ((f2 - f) * f32495oIX0oI.nextFloat());
    }

    public static boolean oIX0oI() {
        return f32495oIX0oI.nextBoolean();
    }

    public static double oxoX(double d, double d2) {
        boolean z;
        boolean z2 = true;
        if (d2 >= d) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Start value must be smaller or equal to end value.", new Object[0]);
        if (d < XIXIX.OOXIXo.f3760XO) {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "Both range values must be non-negative.", new Object[0]);
        if (d == d2) {
            return d;
        }
        return d + ((d2 - d) * f32495oIX0oI.nextDouble());
    }

    public static long xoIox(long j, long j2) {
        boolean z;
        boolean z2 = true;
        if (j2 >= j) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Start value must be smaller or equal to end value.", new Object[0]);
        if (j < 0) {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "Both range values must be non-negative.", new Object[0]);
        if (j == j2) {
            return j;
        }
        return (long) oxoX(j, j2);
    }

    public static long xxIXOIIO() {
        return xoIox(0L, Long.MAX_VALUE);
    }
}

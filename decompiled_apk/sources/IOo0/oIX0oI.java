package IOo0;

import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class oIX0oI {
    public static double I0Io(double... dArr) {
        boolean z;
        xoIxX.xo0x(dArr, "The Array must not be null", new Object[0]);
        if (dArr.length != 0) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Array cannot be empty.", new Object[0]);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            d = oIX0oI(dArr[i], d);
        }
        return d;
    }

    public static double II0XooXoX(double d, double d2, double d3) {
        return Oxx0IOOO(Oxx0IOOO(d, d2), d3);
    }

    public static double II0xO0(double d, double d2, double d3) {
        return oIX0oI(oIX0oI(d, d2), d3);
    }

    public static float OOXIXo(float f, float f2, float f3) {
        return xoIox(xoIox(f, f2), f3);
    }

    public static double Oxx0IOOO(double d, double d2) {
        if (Double.isNaN(d)) {
            return d2;
        }
        if (Double.isNaN(d2)) {
            return d;
        }
        return Math.min(d, d2);
    }

    public static float X0o0xo(float f, float f2, float f3) {
        return oxoX(oxoX(f, f2), f3);
    }

    public static float XO(float... fArr) {
        boolean z;
        xoIxX.xo0x(fArr, "The Array must not be null", new Object[0]);
        if (fArr.length != 0) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Array cannot be empty.", new Object[0]);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            f = oxoX(fArr[i], f);
        }
        return f;
    }

    public static double oIX0oI(double d, double d2) {
        if (Double.isNaN(d)) {
            return d2;
        }
        if (Double.isNaN(d2)) {
            return d;
        }
        return Math.max(d, d2);
    }

    public static float oOoXoXO(float... fArr) {
        boolean z;
        xoIxX.xo0x(fArr, "The Array must not be null", new Object[0]);
        if (fArr.length != 0) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Array cannot be empty.", new Object[0]);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            f = xoIox(fArr[i], f);
        }
        return f;
    }

    public static float oxoX(float f, float f2) {
        if (Float.isNaN(f)) {
            return f2;
        }
        if (Float.isNaN(f2)) {
            return f;
        }
        return Math.max(f, f2);
    }

    public static float xoIox(float f, float f2) {
        if (Float.isNaN(f)) {
            return f2;
        }
        if (Float.isNaN(f2)) {
            return f;
        }
        return Math.min(f, f2);
    }

    public static double xxIXOIIO(double... dArr) {
        boolean z;
        xoIxX.xo0x(dArr, "The Array must not be null", new Object[0]);
        if (dArr.length != 0) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "Array cannot be empty.", new Object[0]);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            d = Oxx0IOOO(dArr[i], d);
        }
        return d;
    }
}

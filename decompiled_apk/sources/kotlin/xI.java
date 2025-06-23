package kotlin;

/* loaded from: classes6.dex */
public class xI extends ooXIXxIX {
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final double I0X0x0oIo(double d, float f) {
        double d2 = f;
        double d3 = d % d2;
        if (d3 != XIXIX.OOXIXo.f3760XO && Math.signum(d3) != Math.signum(d2)) {
            return d3 + d2;
        }
        return d3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int I0oOIX(long j, int i) {
        long j2 = i;
        long j3 = j % j2;
        return (int) (j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63)));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long I0oOoX(long j, short s) {
        long j2 = s;
        long j3 = j / j2;
        if ((j ^ j2) < 0 && j2 * j3 != j) {
            return j3 - 1;
        }
        return j3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int IO(short s, byte b) {
        int i = s / b;
        if ((s ^ b) < 0 && b * i != s) {
            return i - 1;
        }
        return i;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long Io(long j, byte b) {
        long j2 = b;
        long j3 = j / j2;
        if ((j ^ j2) < 0 && j2 * j3 != j) {
            return j3 - 1;
        }
        return j3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int IoOoX(byte b, short s) {
        int i = b / s;
        if ((b ^ s) < 0 && s * i != b) {
            return i - 1;
        }
        return i;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long IoOoo(int i, long j) {
        long j2 = i % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final short Ioxxx(long j, short s) {
        long j2 = j % s;
        return (short) (j2 + (r0 & (((j2 ^ r0) & ((-j2) | j2)) >> 63)));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int O0Xx(int i, int i2) {
        int i3 = i % i2;
        return i3 + (i2 & (((i3 ^ i2) & ((-i3) | i3)) >> 31));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long OI0(int i, long j) {
        long j2 = i;
        long j3 = j2 / j;
        if ((j2 ^ j) < 0 && j * j3 != j2) {
            return j3 - 1;
        }
        return j3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long OO(byte b, long j) {
        long j2 = b % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final short OO0x0xX(byte b, short s) {
        int i = b % s;
        return (short) (i + (s & (((i ^ s) & ((-i) | i)) >> 31)));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int X00IoxXI(int i, short s) {
        int i2 = i / s;
        if ((i ^ s) < 0 && s * i2 != i) {
            return i2 - 1;
        }
        return i2;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final short XIo0oOXIx(int i, short s) {
        int i2 = i % s;
        return (short) (i2 + (s & (((i2 ^ s) & ((-i2) | i2)) >> 31)));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long XOxIOxOx(byte b, long j) {
        long j2 = b;
        long j3 = j2 / j;
        if ((j2 ^ j) < 0 && j * j3 != j2) {
            return j3 - 1;
        }
        return j3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long XX(long j, long j2) {
        long j3 = j / j2;
        if ((j ^ j2) < 0 && j2 * j3 != j) {
            return j3 - 1;
        }
        return j3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final double XX0(double d, double d2) {
        double d3 = d % d2;
        if (d3 != XIXIX.OOXIXo.f3760XO && Math.signum(d3) != Math.signum(d2)) {
            return d3 + d2;
        }
        return d3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final float Xo0(float f, float f2) {
        float f3 = f % f2;
        if (f3 != 0.0f && Math.signum(f3) != Math.signum(f2)) {
            return f3 + f2;
        }
        return f3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int XoI0Ixx0(byte b, int i) {
        int i2 = b % i;
        return i2 + (i & (((i2 ^ i) & ((-i2) | i2)) >> 31));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final byte XoX(byte b, byte b2) {
        int i = b % b2;
        return (byte) (i + (b2 & (((i ^ b2) & ((-i) | i)) >> 31)));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int Xx000oIo(int i, int i2) {
        int i3 = i / i2;
        if ((i ^ i2) < 0 && i2 * i3 != i) {
            return i3 - 1;
        }
        return i3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long o0(long j, int i) {
        long j2 = i;
        long j3 = j / j2;
        if ((j ^ j2) < 0 && j2 * j3 != j) {
            return j3 - 1;
        }
        return j3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int oOXoIIIo(int i, byte b) {
        int i2 = i / b;
        if ((i ^ b) < 0 && b * i2 != i) {
            return i2 - 1;
        }
        return i2;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final double oX(float f, double d) {
        double d2 = f % d;
        if (d2 != XIXIX.OOXIXo.f3760XO && Math.signum(d2) != Math.signum(d)) {
            return d2 + d;
        }
        return d2;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int oo(byte b, int i) {
        int i2 = b / i;
        if ((b ^ i) < 0 && i * i2 != b) {
            return i2 - 1;
        }
        return i2;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int oo0xXOI0I(byte b, byte b2) {
        int i = b / b2;
        if ((b ^ b2) < 0 && b2 * i != b) {
            return i - 1;
        }
        return i;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final byte oxXx0IX(int i, byte b) {
        int i2 = i % b;
        return (byte) (i2 + (b & (((i2 ^ b) & ((-i2) | i2)) >> 31)));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long oxxXoxO(short s, long j) {
        long j2 = s;
        long j3 = j2 / j;
        if ((j2 ^ j) < 0 && j * j3 != j2) {
            return j3 - 1;
        }
        return j3;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int x0o(short s, short s2) {
        int i = s / s2;
        if ((s ^ s2) < 0 && s2 * i != s) {
            return i - 1;
        }
        return i;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long x0xO(short s, long j) {
        long j2 = s % j;
        return j2 + (j & (((j2 ^ j) & ((-j2) | j2)) >> 63));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int xII(short s, int i) {
        int i2 = s / i;
        if ((s ^ i) < 0 && i * i2 != s) {
            return i2 - 1;
        }
        return i2;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final byte xXOx(short s, byte b) {
        int i = s % b;
        return (byte) (i + (b & (((i ^ b) & ((-i) | i)) >> 31)));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final byte xo0x(long j, byte b) {
        long j2 = j % b;
        return (byte) (j2 + (r0 & (((j2 ^ r0) & ((-j2) | j2)) >> 63)));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final long xoIxX(long j, long j2) {
        long j3 = j % j2;
        return j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final int xoxXI(short s, int i) {
        int i2 = s % i;
        return i2 + (i & (((i2 ^ i) & ((-i2) | i2)) >> 31));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    @xx0o0O.Oxx0IOOO
    public static final short xxIO(short s, short s2) {
        int i = s % s2;
        return (short) (i + (s2 & (((i ^ s2) & ((-i) | i)) >> 31)));
    }
}

package xX0ox;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public class II0XooXoX extends Oxx0IOOO {
    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final byte I0X0x0oIo(byte b, byte b2, byte b3) {
        return (byte) Math.min((int) b, Math.min((int) b2, (int) b3));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final float I0oOIX(float f, float f2) {
        return Math.min(f, f2);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.1")
    public static <T extends Comparable<? super T>> T I0oOoX(@OXOo.OOXIXo T a2, @OXOo.OOXIXo T b) {
        IIX0o.x0xO0oo(a2, "a");
        IIX0o.x0xO0oo(b, "b");
        if (a2.compareTo(b) < 0) {
            return b;
        }
        return a2;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final float IO(float f, float f2, float f3) {
        return Math.max(f, Math.max(f2, f3));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final long Io(long j, long j2) {
        return Math.max(j, j2);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final double IoOoX(double d, double d2) {
        return Math.max(d, d2);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final int IoOoo(int i, int i2) {
        return Math.min(i, i2);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final long Ioxxx(long j, @OXOo.OOXIXo long... other) {
        IIX0o.x0xO0oo(other, "other");
        for (long j2 : other) {
            j = Math.min(j, j2);
        }
        return j;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final short O00XxXI(short s, short s2) {
        return (short) Math.min((int) s, (int) s2);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double O0Xx(double d, @OXOo.OOXIXo double... other) {
        IIX0o.x0xO0oo(other, "other");
        for (double d2 : other) {
            d = Math.min(d, d2);
        }
        return d;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int OI0(int i, @OXOo.OOXIXo int... other) {
        IIX0o.x0xO0oo(other, "other");
        for (int i2 : other) {
            i = Math.max(i, i2);
        }
        return i;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float OO(float f, @OXOo.OOXIXo float... other) {
        IIX0o.x0xO0oo(other, "other");
        for (float f2 : other) {
            f = Math.min(f, f2);
        }
        return f;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final long OO0x0xX(long j, long j2) {
        return Math.min(j, j2);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final float X00IoxXI(float f, float f2) {
        return Math.max(f, f2);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final short XI0oooXX(short s, @OXOo.OOXIXo short... other) {
        IIX0o.x0xO0oo(other, "other");
        for (short s2 : other) {
            s = (short) Math.min((int) s, (int) s2);
        }
        return s;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final long XIo0oOXIx(long j, long j2, long j3) {
        return Math.min(j, Math.min(j2, j3));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final int XOxIOxOx(int i, int i2, int i3) {
        return Math.max(i, Math.max(i2, i3));
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final long XX(long j, @OXOo.OOXIXo long... other) {
        IIX0o.x0xO0oo(other, "other");
        for (long j2 : other) {
            j = Math.max(j, j2);
        }
        return j;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final byte XX0(byte b, byte b2) {
        return (byte) Math.min((int) b, (int) b2);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.1")
    public static final <T extends Comparable<? super T>> T XX0xXo(@OXOo.OOXIXo T a2, @OXOo.OOXIXo T b, @OXOo.OOXIXo T c) {
        IIX0o.x0xO0oo(a2, "a");
        IIX0o.x0xO0oo(b, "b");
        IIX0o.x0xO0oo(c, "c");
        return (T) xxIO(a2, xxIO(b, c));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final double Xo0(double d, double d2) {
        return Math.min(d, d2);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final double XoI0Ixx0(double d, double d2, double d3) {
        return Math.min(d, Math.min(d2, d3));
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T extends Comparable<? super T>> T XoX(@OXOo.OOXIXo T a2, @OXOo.OOXIXo T... other) {
        IIX0o.x0xO0oo(a2, "a");
        IIX0o.x0xO0oo(other, "other");
        for (T t : other) {
            a2 = (T) I0oOoX(a2, t);
        }
        return a2;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double Xx000oIo(double d, @OXOo.OOXIXo double... other) {
        IIX0o.x0xO0oo(other, "other");
        for (double d2 : other) {
            d = Math.max(d, d2);
        }
        return d;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final long o0(long j, long j2, long j3) {
        return Math.max(j, Math.max(j2, j3));
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T extends Comparable<? super T>> T o0xxxXXxX(@OXOo.OOXIXo T a2, @OXOo.OOXIXo T... other) {
        IIX0o.x0xO0oo(a2, "a");
        IIX0o.x0xO0oo(other, "other");
        for (T t : other) {
            a2 = (T) xxIO(a2, t);
        }
        return a2;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final double oOXoIIIo(double d, double d2, double d3) {
        return Math.max(d, Math.max(d2, d3));
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte oX(byte b, @OXOo.OOXIXo byte... other) {
        IIX0o.x0xO0oo(other, "other");
        for (byte b2 : other) {
            b = (byte) Math.min((int) b, (int) b2);
        }
        return b;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte oo(byte b, @OXOo.OOXIXo byte... other) {
        IIX0o.x0xO0oo(other, "other");
        for (byte b2 : other) {
            b = (byte) Math.max((int) b, (int) b2);
        }
        return b;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final byte oo0xXOI0I(byte b, byte b2, byte b3) {
        return (byte) Math.max((int) b, Math.max((int) b2, (int) b3));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final short ox(short s, short s2, short s3) {
        return (short) Math.min((int) s, Math.min((int) s2, (int) s3));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final short oxXx0IX(short s, short s2) {
        return (short) Math.max((int) s, (int) s2);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.1")
    public static final <T extends Comparable<? super T>> T oxxXoxO(@OXOo.OOXIXo T a2, @OXOo.OOXIXo T b, @OXOo.OOXIXo T c) {
        IIX0o.x0xO0oo(a2, "a");
        IIX0o.x0xO0oo(b, "b");
        IIX0o.x0xO0oo(c, "c");
        return (T) I0oOoX(a2, I0oOoX(b, c));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final int x0o(int i, int i2) {
        return Math.max(i, i2);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int x0xO(int i, @OXOo.OOXIXo int... other) {
        IIX0o.x0xO0oo(other, "other");
        for (int i2 : other) {
            i = Math.min(i, i2);
        }
        return i;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final byte xI(byte b, byte b2) {
        return (byte) Math.max((int) b, (int) b2);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float xII(float f, @OXOo.OOXIXo float... other) {
        IIX0o.x0xO0oo(other, "other");
        for (float f2 : other) {
            f = Math.max(f, f2);
        }
        return f;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final short xXOx(short s, @OXOo.OOXIXo short... other) {
        IIX0o.x0xO0oo(other, "other");
        for (short s2 : other) {
            s = (short) Math.max((int) s, (int) s2);
        }
        return s;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final short xo0x(short s, short s2, short s3) {
        return (short) Math.max((int) s, Math.max((int) s2, (int) s3));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final int xoIxX(int i, int i2, int i3) {
        return Math.min(i, Math.min(i2, i3));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final float xoxXI(float f, float f2, float f3) {
        return Math.min(f, Math.min(f2, f3));
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.1")
    public static final <T extends Comparable<? super T>> T xxIO(@OXOo.OOXIXo T a2, @OXOo.OOXIXo T b) {
        IIX0o.x0xO0oo(a2, "a");
        IIX0o.x0xO0oo(b, "b");
        if (a2.compareTo(b) > 0) {
            return b;
        }
        return a2;
    }
}

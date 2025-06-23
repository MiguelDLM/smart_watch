package oOIx;

import XIXIX.OOXIXo;
import kotlin.IIX0;
import kotlin.IXxxXO;
import kotlin.oxxXoxO;
import xx0o0O.XO;

/* loaded from: classes6.dex */
public class oxoX extends I0Io {
    @XO
    @oxxXoxO(version = "1.2")
    public static final double I0(double d, double d2) {
        return Math.nextAfter(d, d2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double I0Io(double d, double d2) {
        return Math.IEEEremainder(d, d2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double I0X0x0oIo(double d, double d2) {
        return Math.hypot(d, d2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float I0oOIX(float f) {
        return (float) Math.log1p(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final long II0XooXoX(long j) {
        return Math.abs(j);
    }

    @oxxXoxO(version = "1.2")
    public static int IIX0(double d) {
        if (!Double.isNaN(d)) {
            if (d > 2.147483647E9d) {
                return Integer.MAX_VALUE;
            }
            if (d < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double IIX0o(double d) {
        return Math.expm1(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float IIXOooo(float f) {
        return (float) OxxIIOOXO(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float IIxOXoOo0(float f) {
        return Math.nextAfter(f, Double.NEGATIVE_INFINITY);
    }

    @oxxXoxO(version = "1.2")
    public static final double IXO(double d) {
        if (!Double.isNaN(d) && !Double.isInfinite(d)) {
            if (d > OOXIXo.f3760XO) {
                return Math.floor(d);
            }
            return Math.ceil(d);
        }
        return d;
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float IXxxXO(float f) {
        return (float) Math.atan(f);
    }

    public static int Io(int i) {
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            return 1;
        }
        return 0;
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double IoIOOxIIo(double d) {
        return Math.sin(d);
    }

    public static final float IoOoX(float f) {
        return Math.abs(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double IoOoo(double d) {
        return Math.log10(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float IoXIXo(float f, float f2) {
        return Math.copySign(f, f2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float Ioxxx(float f, float f2) {
        return Math.max(f, f2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double Ix00oIoI(double d, double d2) {
        return Math.copySign(d, d2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double IxIX0I(double d) {
        return Math.tanh(d);
    }

    @oxxXoxO(version = "1.2")
    public static final long O0(float f) {
        return Ox0O(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float O00XxXI(float f, float f2) {
        return Math.min(f, f2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double O0IxXx(double d, int i) {
        return Math.copySign(d, i);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float O0X(float f) {
        return (float) Math.rint(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double O0Xx(double d) {
        return Math.log1p(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float O0xOxO(float f) {
        return (float) Math.ceil(f);
    }

    public static final float OI0(float f) {
        return Math.signum(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float OIOoIIOIx(float f) {
        return (float) Math.sqrt(f);
    }

    @oxxXoxO(version = "1.2")
    public static final float OO(float f, float f2) {
        if (f2 > 0.0f && f2 != 1.0f) {
            return (float) (Math.log(f) / Math.log(f2));
        }
        return Float.NaN;
    }

    @oxxXoxO(version = "1.2")
    public static final float OO0x0xX(float f) {
        return (float) (Math.log(f) / oIX0oI.f32001II0xO0);
    }

    @oxxXoxO(version = "1.2")
    public static final double OOXIXo(double d) {
        if (d < 1.0d) {
            return Double.NaN;
        }
        if (d > oIX0oI.f32004XO) {
            return Math.log(d) + oIX0oI.f32001II0xO0;
        }
        double d2 = 1;
        double d3 = d - d2;
        if (d3 >= oIX0oI.f32003X0o0xo) {
            return Math.log(d + Math.sqrt((d * d) - d2));
        }
        double sqrt = Math.sqrt(d3);
        if (sqrt >= oIX0oI.f32006oxoX) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double OOXIxO0(double d) {
        return Math.nextAfter(d, Double.NEGATIVE_INFINITY);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float OX00O0xII(float f) {
        return Math.nextUp(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double Oo(double d) {
        return Math.atan(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double OoO(double d) {
        return Math.sqrt(d);
    }

    @oxxXoxO(version = "1.2")
    public static long Ox0O(double d) {
        if (!Double.isNaN(d)) {
            return Math.round(d);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double OxI(double d) {
        return Math.ceil(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final int Oxx0IOOO(int i) {
        return Math.abs(i);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double Oxx0xo(double d, double d2) {
        return Math.atan2(d, d2);
    }

    @oxxXoxO(version = "1.2")
    public static final double OxxIIOOXO(double d) {
        if (Math.abs(d) < oIX0oI.f32003X0o0xo) {
            if (Math.abs(d) > oIX0oI.f32006oxoX) {
                return d + (((d * d) * d) / 3);
            }
            return d;
        }
        double d2 = 1;
        return Math.log((d2 + d) / (d2 - d)) / 2;
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double X0IIOO(double d) {
        return Math.cos(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double X0o0xo(double d) {
        return Math.abs(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float XI0IXoo(float f) {
        return (float) Math.cos(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final long XI0oooXX(long j, long j2) {
        return Math.min(j, j2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float XIXIX(float f, float f2) {
        return (float) Math.pow(f, f2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float XIXIxO(float f) {
        return (float) Math.sinh(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double XIo0oOXIx(double d, double d2) {
        return Math.max(d, d2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double XIxXXX0x0(double d) {
        return Math.cosh(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float XO(float f) {
        return Math.abs(f);
    }

    public static final double XOxIOxOx(double d) {
        return Math.signum(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final long XX0xXo(long j, long j2) {
        return Math.max(j, j2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float XXoOx0(float f) {
        return (float) Math.tan(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double Xo0(double d) {
        return Math.log(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float XoI0Ixx0(float f) {
        return (float) Math.log(f);
    }

    public static final long Xx000oIo(long j) {
        return Math.abs(j);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double XxX0x0xxx(double d) {
        return Math.exp(d);
    }

    public static int o0(long j) {
        if (j < 0) {
            return -1;
        }
        if (j > 0) {
            return 1;
        }
        return 0;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @XO
    @oxxXoxO(version = "1.8")
    public static final float o00(float f) {
        return (float) Math.cbrt(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double o0oIxOo(double d) {
        return Math.sinh(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double o0xxxXXxX(double d, double d2) {
        return Math.min(d, d2);
    }

    @oxxXoxO(version = "1.2")
    public static final float oI(float f) {
        double ceil;
        if (!Float.isNaN(f) && !Float.isInfinite(f)) {
            if (f > 0.0f) {
                ceil = Math.floor(f);
            } else {
                ceil = Math.ceil(f);
            }
            return (float) ceil;
        }
        return f;
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float oI0IIXIo(float f, float f2) {
        return (float) Math.atan2(f, f2);
    }

    @oxxXoxO(version = "1.2")
    public static final double oO(double d) {
        double d2 = oIX0oI.f32003X0o0xo;
        if (d >= d2) {
            if (d > oIX0oI.f32002Oxx0IOOO) {
                if (d > oIX0oI.f32004XO) {
                    return Math.log(d) + oIX0oI.f32001II0xO0;
                }
                double d3 = d * 2;
                return Math.log(d3 + (1 / d3));
            }
            return Math.log(d + Math.sqrt((d * d) + 1));
        }
        if (d <= (-d2)) {
            return -oO(-d);
        }
        if (Math.abs(d) >= oIX0oI.f32006oxoX) {
            return d - (((d * d) * d) / 6);
        }
        return d;
    }

    public static final int oOXoIIIo(int i) {
        return Math.abs(i);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double oOo(double d) {
        return Math.rint(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float oOoIIO0(float f) {
        return (float) Math.tanh(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float oOoXoXO(float f) {
        return (float) OOXIXo(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float oX(float f, float f2) {
        return (float) Math.hypot(f, f2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float oXIO0o0XI(float f, int i) {
        return (float) Math.pow(f, i);
    }

    public static final double oo(double d) {
        return Math.abs(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float oo0xXOI0I(float f) {
        return (float) Math.floor(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double ooOOo0oXI(double d) {
        return Math.asin(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float ooOx(float f, float f2) {
        return Math.nextAfter(f, f2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float ooXIXxIX(float f) {
        return (float) Math.expm1(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final int ox(int i, int i2) {
        return Math.min(i, i2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float oxIIX0o(float f) {
        return (float) Math.sin(f);
    }

    public static final double oxXx0IX(double d) {
        return Math.ulp(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float oxoX(float f, float f2) {
        return (float) Math.IEEEremainder(f, f2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double x0OIX00oO(double d) {
        return Math.tan(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float x0XOIxOo(float f) {
        return (float) Math.asin(f);
    }

    @oxxXoxO(version = "1.2")
    public static final double x0xO(double d) {
        return Math.log(d) / oIX0oI.f32001II0xO0;
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float x0xO0oo(float f) {
        return (float) oO(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double xI(double d) {
        return Math.floor(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float xI0oxI00(float f) {
        return Math.signum(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double xOOOX(double d, int i) {
        return Math.pow(d, i);
    }

    @oxxXoxO(version = "1.2")
    public static int xOoOIoI(float f) {
        if (!Float.isNaN(f)) {
            return Math.round(f);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double xX0IIXIx0(double d, double d2) {
        return Math.pow(d, d2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float xXxxox0I(float f) {
        return (float) Math.exp(f);
    }

    public static final float xo0x(float f) {
        return Math.ulp(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float xoIox(float f) {
        return (float) Math.acos(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float xoIxX(float f) {
        return (float) Math.log10(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double xoO0xx0(double d) {
        return Math.nextUp(d);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @XO
    @oxxXoxO(version = "1.8")
    public static final double xoXoI(double d) {
        return Math.cbrt(d);
    }

    @oxxXoxO(version = "1.2")
    public static final double xoxXI(double d, double d2) {
        if (d2 > OOXIXo.f3760XO && d2 != 1.0d) {
            return Math.log(d) / Math.log(d2);
        }
        return Double.NaN;
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double xx0X0(double d) {
        return Math.signum(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final int xxIO(int i, int i2) {
        return Math.max(i, i2);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final double xxIXOIIO(double d) {
        return Math.acos(d);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float xxOXOOoIX(float f, int i) {
        return Math.copySign(f, i);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final float xxX(float f) {
        return (float) Math.cosh(f);
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static /* synthetic */ void I0oOoX(float f) {
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static /* synthetic */ void IO(float f) {
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static /* synthetic */ void X00IoxXI(double d) {
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static /* synthetic */ void XX(double d) {
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static /* synthetic */ void XX0(float f) {
    }

    @oxxXoxO(version = "1.2")
    public static /* synthetic */ void XoX(long j) {
    }

    @oxxXoxO(version = "1.2")
    public static /* synthetic */ void oxxXoxO(int i) {
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static /* synthetic */ void x0o(long j) {
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static /* synthetic */ void xII(int i) {
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static /* synthetic */ void xXOx(double d) {
    }
}

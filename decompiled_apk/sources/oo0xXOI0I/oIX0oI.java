package oo0xXOI0I;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f32288oIX0oI = new oIX0oI();

    public final double I0Io(double d, double d2) {
        return oxoX.f32289oIX0oI.I0Io(((d2 + Oo(d, ooOOo0oXI(d))) - 0.00569d) - (Math.sin(I0Io.II0xO0(125.04d - (d * 1934.136d))) * 0.00478d));
    }

    public final double II0XooXoX(double d, double d2, double d3, double d4) {
        double d5 = d - d2;
        double d6 = d3 - d;
        return d + ((d4 / 2) * (d5 + d6 + (d4 * (d6 - d5))));
    }

    public final double II0xO0(double d, double d2) {
        return d2 + (Math.cos(I0Io.II0xO0(125.04d - (d * 1934.136d))) * 0.00256d);
    }

    public final double OOXIXo(double d) {
        double pow = Math.pow(d, 2.0d) * 1.639E-7d;
        return ((23.439291d - (0.013004167d * d)) - pow) + (Math.pow(d, 3.0d) * 5.036E-7d);
    }

    public final double Oo(double d, double d2) {
        double II0xO02 = I0Io.II0xO0(d2);
        return (((1.914602d - (0.004817d * d)) - (Math.pow(d, 2.0d) * 1.4E-5d)) * Math.sin(II0xO02)) + ((0.019993d - (d * 1.01E-4d)) * Math.sin(2 * II0xO02)) + (Math.sin(3 * II0xO02) * 2.89E-4d);
    }

    public final double Oxx0IOOO(double d, double d2, double d3, double d4, double d5, double d6) {
        oxoX oxox = oxoX.f32289oIX0oI;
        return ((oxox.oIX0oI((oxox.I0Io(d3 + (360.985647d * d)) - ((-1) * d2)) - oxox.I0Io(xxIXOIIO(d4, d5, d6, d))) / (-360)) + d) * 24;
    }

    public final double X0o0xo(double d) {
        double d2 = 1934.136261d * d;
        return oxoX.f32289oIX0oI.I0Io((125.04452d - d2) + (Math.pow(d, 2.0d) * 0.0020708d) + (Math.pow(d, 3.0d) / 450000));
    }

    public final double XO(double d, double d2, @OOXIXo ooXIXxIX.II0xO0 coordinates, boolean z, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        IIX0o.x0xO0oo(coordinates, "coordinates");
        double II0xO02 = coordinates.II0xO0() * (-1);
        double oIX0oI2 = I0Io.oIX0oI(Math.acos((Math.sin(I0Io.II0xO0(d2)) - (Math.sin(I0Io.II0xO0(coordinates.oIX0oI())) * Math.sin(I0Io.II0xO0(d7)))) / (Math.cos(I0Io.II0xO0(coordinates.oIX0oI())) * Math.cos(I0Io.II0xO0(d7))))) / 360;
        double d10 = z ? d + oIX0oI2 : d - oIX0oI2;
        oxoX oxox = oxoX.f32289oIX0oI;
        double I0Io2 = oxox.I0Io(d3 + (360.985647d * d10));
        double I0Io3 = oxox.I0Io(xxIXOIIO(d4, d5, d6, d10));
        double II0XooXoX2 = II0XooXoX(d7, d8, d9, d10);
        double d11 = (I0Io2 - II0xO02) - I0Io3;
        return (d10 + ((oIX0oI(coordinates.oIX0oI(), II0XooXoX2, d11) - d2) / (((360 * Math.cos(I0Io.II0xO0(II0XooXoX2))) * Math.cos(I0Io.II0xO0(coordinates.oIX0oI()))) * Math.sin(I0Io.II0xO0(d11))))) * 24;
    }

    public final double oIX0oI(double d, double d2, double d3) {
        return I0Io.oIX0oI(Math.asin((Math.sin(I0Io.II0xO0(d)) * Math.sin(I0Io.II0xO0(d2))) + (Math.cos(I0Io.II0xO0(d)) * Math.cos(I0Io.II0xO0(d2)) * Math.cos(I0Io.II0xO0(d3)))));
    }

    public final double oO(double d, double d2, double d3, double d4) {
        double d5 = 2;
        return (((Math.sin(I0Io.II0xO0(d4)) * (-0.0047777777777777775d)) - (Math.sin(I0Io.II0xO0(d2) * d5) * 3.6666666666666667E-4d)) - (Math.sin(I0Io.II0xO0(d3) * d5) * 6.38888888888889E-5d)) + (Math.sin(d5 * I0Io.II0xO0(d4)) * 5.833333333333333E-5d);
    }

    public final double oOoXoXO(double d) {
        return oxoX.f32289oIX0oI.I0Io(((((((36525 * d) + 2451545.0d) - 2451545) * 360.98564736629d) + 280.46061837d) + (Math.pow(d, 2.0d) * 3.87933E-4d)) - (Math.pow(d, 3.0d) / 38710000));
    }

    public final double ooOOo0oXI(double d) {
        return oxoX.f32289oIX0oI.I0Io(((35999.05029d * d) + 357.52911d) - (Math.pow(d, 2.0d) * 1.537E-4d));
    }

    public final double oxoX(double d, double d2, double d3) {
        return oxoX.f32289oIX0oI.II0xO0(((d3 + (d * (-1))) - d2) / 360, 1.0d);
    }

    public final double x0XOIxOo(double d) {
        return oxoX.f32289oIX0oI.I0Io((36000.76983d * d) + 280.4664567d + (Math.pow(d, 2.0d) * 3.032E-4d));
    }

    public final double x0xO0oo(double d, double d2, double d3, double d4) {
        double d5 = 2;
        return (((Math.cos(I0Io.II0xO0(d4)) * 0.0025555555555555553d) + (Math.cos(I0Io.II0xO0(d2) * d5) * 1.5833333333333332E-4d)) + (Math.cos(I0Io.II0xO0(d3) * d5) * 2.777777777777778E-5d)) - (Math.cos(d5 * I0Io.II0xO0(d4)) * 2.4999999999999998E-5d);
    }

    public final double xoIox(double d) {
        return oxoX.f32289oIX0oI.I0Io((d * 481267.8813d) + 218.3165d);
    }

    public final double xxIXOIIO(double d, double d2, double d3, double d4) {
        oxoX oxox = oxoX.f32289oIX0oI;
        double I0Io2 = oxox.I0Io(d - d2);
        double I0Io3 = oxox.I0Io(d3 - d);
        return d + ((d4 / 2) * (I0Io2 + I0Io3 + (d4 * (I0Io3 - I0Io2))));
    }
}

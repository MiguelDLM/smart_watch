package com.sma.smartv3.util;

import com.garmin.fit.X0xOO;
import java.util.Arrays;

/* loaded from: classes12.dex */
public final class xoXoI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final double f24726I0Io = 6378245.0d;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final double f24727II0xO0 = 52.35987755982988d;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final double f24728oIX0oI = 3.141592653589793d;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final double f24729oxoX = 0.006693421622965943d;

    @OXOo.OOXIXo
    public static final double[] I0Io(double d, double d2) {
        double sqrt = Math.sqrt((d2 * d2) + (d * d)) + (Math.sin(d * 52.35987755982988d) * 2.0E-5d);
        double atan2 = Math.atan2(d, d2) + (Math.cos(d2 * 52.35987755982988d) * 3.0E-6d);
        return new double[]{(sqrt * Math.sin(atan2)) + 0.006d, (Math.cos(atan2) * sqrt) + 0.0065d};
    }

    public static final double II0XooXoX(double d) {
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%.6f", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        Double valueOf = Double.valueOf(format);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        return valueOf.doubleValue();
    }

    @OXOo.OOXIXo
    public static final double[] II0xO0(double d, double d2) {
        double[] oIX0oI2 = oIX0oI(d, d2);
        double[] oxoX2 = oxoX(oIX0oI2[0], oIX0oI2[1]);
        oxoX2[0] = II0XooXoX(oxoX2[0]);
        oxoX2[1] = II0XooXoX(oxoX2[1]);
        return oxoX2;
    }

    public static final double OOXIXo(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * 3.141592653589793d) * 20.0d) + (Math.sin((d * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d * 3.141592653589793d) * 20.0d) + (Math.sin((d / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }

    public static final boolean Oxx0IOOO(double d, double d2) {
        return d2 < 72.004d || d2 > 137.8347d || d < 0.8293d || d > 55.8271d;
    }

    @OXOo.oOoXoXO
    public static final double[] X0o0xo(double d, double d2) {
        double[] XO2 = XO(d, d2);
        return I0Io(XO2[0], XO2[1]);
    }

    @OXOo.OOXIXo
    public static final double[] XO(double d, double d2) {
        if (Oxx0IOOO(d, d2)) {
            return new double[]{d, d2};
        }
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double xoIox2 = xoIox(d3, d4);
        double OOXIXo2 = OOXIXo(d3, d4);
        double d5 = (d / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d5);
        double d6 = 1 - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d6);
        return new double[]{d + ((xoIox2 * 180.0d) / ((6335552.717000426d / (d6 * sqrt)) * 3.141592653589793d)), d2 + ((OOXIXo2 * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d5)) * 3.141592653589793d))};
    }

    @OXOo.OOXIXo
    public static final double[] oIX0oI(double d, double d2) {
        double d3 = d2 - 0.0065d;
        double d4 = d - 0.006d;
        double sqrt = Math.sqrt((d3 * d3) + (d4 * d4)) - (Math.sin(d4 * 52.35987755982988d) * 2.0E-5d);
        double atan2 = Math.atan2(d4, d3) - (Math.cos(d3 * 52.35987755982988d) * 3.0E-6d);
        return new double[]{sqrt * Math.sin(atan2), Math.cos(atan2) * sqrt};
    }

    @OXOo.OOXIXo
    public static final double[] oxoX(double d, double d2) {
        double[] xxIXOIIO2 = xxIXOIIO(d, d2);
        double d3 = 2;
        return new double[]{(d * d3) - xxIXOIIO2[0], (d2 * d3) - xxIXOIIO2[1]};
    }

    public static final double xoIox(double d, double d2) {
        double d3 = d * 2.0d;
        double sqrt = (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((6.0d * d) * 3.141592653589793d) * 20.0d) + (Math.sin(d3 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d);
        double d4 = d2 * 3.141592653589793d;
        return sqrt + ((((Math.sin(d4) * 20.0d) + (Math.sin((d2 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * 3.141592653589793d) * 160.0d) + (X0xOO.f13583O0o0 * Math.sin(d4 / 30.0d))) * 2.0d) / 3.0d);
    }

    @OXOo.OOXIXo
    public static final double[] xxIXOIIO(double d, double d2) {
        if (Oxx0IOOO(d, d2)) {
            return new double[]{d, d2};
        }
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double xoIox2 = xoIox(d3, d4);
        double OOXIXo2 = OOXIXo(d3, d4);
        double d5 = (d / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d5);
        double d6 = 1 - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d6);
        return new double[]{d + ((xoIox2 * 180.0d) / ((6335552.717000426d / (d6 * sqrt)) * 3.141592653589793d)), d2 + ((OOXIXo2 * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d5)) * 3.141592653589793d))};
    }
}

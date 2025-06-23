package com.vtrump.vtble;

import com.baidu.ar.auth.FeatureCodes;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes13.dex */
public class OxxIIOOXO {
    public static double I0Io(double d, int i) {
        return new BigDecimal((d * 2.0d) + "").setScale(i, RoundingMode.HALF_UP).doubleValue();
    }

    public static double II0XooXoX(double d) {
        return (d * 2.204622622d) / 14.0d;
    }

    public static double II0xO0(double d) {
        return d * 2.0d;
    }

    public static double OOXIXo(double d, int i) {
        return new BigDecimal(d + "").setScale(i, RoundingMode.HALF_UP).doubleValue();
    }

    public static double Oo(String str) {
        String[] split = str.split(":");
        double doubleValue = Double.valueOf(split[0]).doubleValue();
        double doubleValue2 = Double.valueOf(split[1]).doubleValue();
        double d = doubleValue * 14.0d;
        return (doubleValue >= XIXIX.OOXIXo.f3760XO ? d + doubleValue2 : d - doubleValue2) / 2.204622622d;
    }

    public static double Oxx0IOOO(double d) {
        return ((((int) ((((d * 10.0d) * 22046.0d) / 1000.0d) + 5.0d)) / 10) & 65534) / 10.0d;
    }

    public static double X0o0xo(double d) {
        double d2 = d * 2.204d;
        if (((int) (d2 * 10.0d)) % 2 != 0) {
            d2 = (r2 + 1) / 10.0d;
        }
        return new BigDecimal(d2).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public static double XO(double d, int i) {
        return new BigDecimal((((((int) (((((d * 100.0d) * 22046.0d) / 1000.0d) + 5.0d) / 10.0d)) / 5) * 5) / 100.0d) + "").setScale(i, RoundingMode.HALF_UP).doubleValue();
    }

    public static double oIX0oI(double d) {
        return d / 2.0d;
    }

    public static double oO(double d) {
        return (d * 14.0d) / 2.204622622d;
    }

    public static String oOoXoXO(double d) {
        int i = (((int) (((((d * 100.0d) * 22046.0d) / 1000.0d) + 5.0d) / 10.0d)) / 5) * 5;
        int i2 = i / FeatureCodes.POSE;
        int i3 = (i - (i2 * FeatureCodes.POSE)) / 10;
        return String.format("%d:%d.%d", Integer.valueOf(i2), Integer.valueOf(i3 / 10), Integer.valueOf(i3 % 10));
    }

    public static double ooOOo0oXI(double d) {
        return d / 2.204622622d;
    }

    public static double oxoX(double d) {
        return ((new BigDecimal(d + "").multiply(new BigDecimal("100")).longValue() * 144480) / 65536) / 100.0d;
    }

    public static double x0XOIxOo(double d) {
        return d / 14.0d;
    }

    public static double x0xO0oo(double d) {
        return d * 14.0d;
    }

    public static String xoIox(double d) {
        int i = (((int) (((((d * 100.0d) * 22046.0d) / 1000.0d) + 5.0d) / 10.0d)) / 5) * 5;
        int i2 = i / FeatureCodes.POSE;
        int i3 = (i - (i2 * FeatureCodes.POSE)) / 10;
        return String.format("%d:%d.%d", Integer.valueOf(i2), Integer.valueOf(i3 / 10), Integer.valueOf(i3 % 10));
    }

    public static String xxIXOIIO(double d) {
        long j = (((int) (d * 100.0d)) * 144480) / 65536;
        int i = (int) ((j % 1400) / 10);
        return String.format("%d:%d.%d", Integer.valueOf((int) (j / 1400)), Integer.valueOf(i / 10), Integer.valueOf(i % 10));
    }
}

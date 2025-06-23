package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes9.dex */
public final class Cam16 {
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;
    private final double j;
    private final double jstar;
    private final double m;
    private final double q;
    private final double s;
    private final double[] tempArray = {XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO};
    static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    private Cam16(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.hue = d;
        this.chroma = d2;
        this.j = d3;
        this.q = d4;
        this.m = d5;
        this.s = d6;
        this.jstar = d7;
        this.astar = d8;
        this.bstar = d9;
    }

    public static Cam16 fromInt(int i) {
        return fromIntInViewingConditions(i, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromIntInViewingConditions(int i, ViewingConditions viewingConditions) {
        double linearized = ColorUtils.linearized((16711680 & i) >> 16);
        double linearized2 = ColorUtils.linearized((65280 & i) >> 8);
        double linearized3 = ColorUtils.linearized(i & 255);
        return fromXyzInViewingConditions((0.41233895d * linearized) + (0.35762064d * linearized2) + (0.18051042d * linearized3), (0.2126d * linearized) + (0.7152d * linearized2) + (0.0722d * linearized3), (linearized * 0.01932141d) + (linearized2 * 0.11916382d) + (linearized3 * 0.95034478d), viewingConditions);
    }

    public static Cam16 fromJch(double d, double d2, double d3) {
        return fromJchInViewingConditions(d, d2, d3, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double d4 = d / 100.0d;
        double c = (4.0d / viewingConditions.getC()) * Math.sqrt(d4) * (viewingConditions.getAw() + 4.0d) * viewingConditions.getFlRoot();
        double flRoot = d2 * viewingConditions.getFlRoot();
        double sqrt = Math.sqrt(((d2 / Math.sqrt(d4)) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double radians = Math.toRadians(d3);
        double d5 = (1.7000000000000002d * d) / ((0.007d * d) + 1.0d);
        double log1p = 43.859649122807014d * Math.log1p(flRoot * 0.0228d);
        return new Cam16(d3, d2, d, c, flRoot, sqrt, d5, Math.cos(radians) * log1p, Math.sin(radians) * log1p);
    }

    public static Cam16 fromUcs(double d, double d2, double d3) {
        return fromUcsInViewingConditions(d, d2, d3, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double expm1 = (Math.expm1(Math.hypot(d2, d3) * 0.0228d) / 0.0228d) / viewingConditions.getFlRoot();
        double atan2 = Math.atan2(d3, d2) * 57.29577951308232d;
        if (atan2 < XIXIX.OOXIXo.f3760XO) {
            atan2 += 360.0d;
        }
        return fromJchInViewingConditions(d / (1.0d - ((d - 100.0d) * 0.007d)), expm1, atan2, viewingConditions);
    }

    public static Cam16 fromXyzInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double d4;
        double[][] dArr = XYZ_TO_CAM16RGB;
        double[] dArr2 = dArr[0];
        double d5 = (dArr2[0] * d) + (dArr2[1] * d2) + (dArr2[2] * d3);
        double[] dArr3 = dArr[1];
        double d6 = (dArr3[0] * d) + (dArr3[1] * d2) + (dArr3[2] * d3);
        double[] dArr4 = dArr[2];
        double d7 = (dArr4[0] * d) + (dArr4[1] * d2) + (dArr4[2] * d3);
        double d8 = viewingConditions.getRgbD()[0] * d5;
        double d9 = viewingConditions.getRgbD()[1] * d6;
        double d10 = viewingConditions.getRgbD()[2] * d7;
        double pow = Math.pow((viewingConditions.getFl() * Math.abs(d8)) / 100.0d, 0.42d);
        double pow2 = Math.pow((viewingConditions.getFl() * Math.abs(d9)) / 100.0d, 0.42d);
        double pow3 = Math.pow((viewingConditions.getFl() * Math.abs(d10)) / 100.0d, 0.42d);
        double signum = ((Math.signum(d8) * 400.0d) * pow) / (pow + 27.13d);
        double signum2 = ((Math.signum(d9) * 400.0d) * pow2) / (pow2 + 27.13d);
        double signum3 = ((Math.signum(d10) * 400.0d) * pow3) / (pow3 + 27.13d);
        double d11 = (((signum * 11.0d) + ((-12.0d) * signum2)) + signum3) / 11.0d;
        double d12 = ((signum + signum2) - (signum3 * 2.0d)) / 9.0d;
        double d13 = signum2 * 20.0d;
        double d14 = (((signum * 20.0d) + d13) + (21.0d * signum3)) / 20.0d;
        double d15 = (((signum * 40.0d) + d13) + signum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d12, d11));
        if (degrees < XIXIX.OOXIXo.f3760XO) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d16 = degrees;
        double radians = Math.toRadians(d16);
        double pow4 = Math.pow((d15 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ()) * 100.0d;
        double d17 = pow4 / 100.0d;
        double c = (4.0d / viewingConditions.getC()) * Math.sqrt(d17) * (viewingConditions.getAw() + 4.0d) * viewingConditions.getFlRoot();
        if (d16 < 20.14d) {
            d4 = d16 + 360.0d;
        } else {
            d4 = d16;
        }
        double pow5 = Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d) * Math.pow(((((((Math.cos(Math.toRadians(d4) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * viewingConditions.getNc()) * viewingConditions.getNcb()) * Math.hypot(d11, d12)) / (d14 + 0.305d), 0.9d);
        double sqrt = Math.sqrt(d17) * pow5;
        double flRoot = sqrt * viewingConditions.getFlRoot();
        double log1p = Math.log1p(flRoot * 0.0228d) * 43.859649122807014d;
        return new Cam16(d16, sqrt, pow4, c, flRoot, Math.sqrt((pow5 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0d)) * 50.0d, (1.7000000000000002d * pow4) / ((0.007d * pow4) + 1.0d), log1p * Math.cos(radians), log1p * Math.sin(radians));
    }

    public double distance(Cam16 cam16) {
        double jstar = getJstar() - cam16.getJstar();
        double astar = getAstar() - cam16.getAstar();
        double bstar = getBstar() - cam16.getBstar();
        return Math.pow(Math.sqrt((jstar * jstar) + (astar * astar) + (bstar * bstar)), 0.63d) * 1.41d;
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.m;
    }

    public double getQ() {
        return this.q;
    }

    public double getS() {
        return this.s;
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public int viewed(ViewingConditions viewingConditions) {
        double[] xyzInViewingConditions = xyzInViewingConditions(viewingConditions, this.tempArray);
        return ColorUtils.argbFromXyz(xyzInViewingConditions[0], xyzInViewingConditions[1], xyzInViewingConditions[2]);
    }

    public double[] xyzInViewingConditions(ViewingConditions viewingConditions, double[] dArr) {
        double d;
        if (getChroma() != XIXIX.OOXIXo.f3760XO && getJ() != XIXIX.OOXIXo.f3760XO) {
            d = getChroma() / Math.sqrt(getJ() / 100.0d);
        } else {
            d = 0.0d;
        }
        double pow = Math.pow(d / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(getHue());
        double cos = (Math.cos(2.0d + radians) + 3.8d) * 0.25d;
        double aw = viewingConditions.getAw() * Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ());
        double nc = cos * 3846.153846153846d * viewingConditions.getNc() * viewingConditions.getNcb();
        double nbb = aw / viewingConditions.getNbb();
        double sin = Math.sin(radians);
        double cos2 = Math.cos(radians);
        double d2 = (((0.305d + nbb) * 23.0d) * pow) / (((nc * 23.0d) + ((11.0d * pow) * cos2)) + ((pow * 108.0d) * sin));
        double d3 = cos2 * d2;
        double d4 = d2 * sin;
        double d5 = nbb * 460.0d;
        double d6 = (((451.0d * d3) + d5) + (288.0d * d4)) / 1403.0d;
        double d7 = ((d5 - (891.0d * d3)) - (261.0d * d4)) / 1403.0d;
        double d8 = ((d5 - (d3 * 220.0d)) - (d4 * 6300.0d)) / 1403.0d;
        double signum = Math.signum(d6) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(XIXIX.OOXIXo.f3760XO, (Math.abs(d6) * 27.13d) / (400.0d - Math.abs(d6))), 2.380952380952381d);
        double signum2 = Math.signum(d7) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(XIXIX.OOXIXo.f3760XO, (Math.abs(d7) * 27.13d) / (400.0d - Math.abs(d7))), 2.380952380952381d);
        double signum3 = Math.signum(d8) * (100.0d / viewingConditions.getFl()) * Math.pow(Math.max(XIXIX.OOXIXo.f3760XO, (Math.abs(d8) * 27.13d) / (400.0d - Math.abs(d8))), 2.380952380952381d);
        double d9 = signum / viewingConditions.getRgbD()[0];
        double d10 = signum2 / viewingConditions.getRgbD()[1];
        double d11 = signum3 / viewingConditions.getRgbD()[2];
        double[][] dArr2 = CAM16RGB_TO_XYZ;
        double[] dArr3 = dArr2[0];
        double d12 = (dArr3[0] * d9) + (dArr3[1] * d10) + (dArr3[2] * d11);
        double[] dArr4 = dArr2[1];
        double d13 = (dArr4[0] * d9) + (dArr4[1] * d10) + (dArr4[2] * d11);
        double[] dArr5 = dArr2[2];
        double d14 = (d9 * dArr5[0]) + (d10 * dArr5[1]) + (d11 * dArr5[2]);
        if (dArr != null) {
            dArr[0] = d12;
            dArr[1] = d13;
            dArr[2] = d14;
            return dArr;
        }
        return new double[]{d12, d13, d14};
    }
}

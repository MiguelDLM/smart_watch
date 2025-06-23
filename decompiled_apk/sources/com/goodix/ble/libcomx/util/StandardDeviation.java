package com.goodix.ble.libcomx.util;

import XIXIX.OOXIXo;

/* loaded from: classes9.dex */
public class StandardDeviation {
    public double average;
    public double stdDeviation;
    public double sum;
    public double variance;

    public double calc(int[] iArr, int i, int i2) {
        double d = OOXIXo.f3760XO;
        if (iArr != null && i2 != 0) {
            if (i < 0 && (i = i + iArr.length) < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = iArr.length;
            }
            int i3 = i2 + i;
            if (i3 > iArr.length) {
                i3 = iArr.length;
            }
            if (i < i3) {
                double d2 = 0.0d;
                for (int i4 = i; i4 < i3; i4++) {
                    d2 += iArr[i4];
                }
                double d3 = i3 - i;
                this.sum = d2;
                this.average = d2 / d3;
                while (i < i3) {
                    double d4 = iArr[i] - this.average;
                    d += d4 * d4;
                    i++;
                }
                double d5 = d / d3;
                this.variance = d5;
                double sqrt = Math.sqrt(d5);
                this.stdDeviation = sqrt;
                return sqrt;
            }
        }
        return OOXIXo.f3760XO;
    }

    public double calc(float[] fArr, int i, int i2) {
        double d = OOXIXo.f3760XO;
        if (fArr != null && i2 != 0) {
            if (i < 0 && (i = i + fArr.length) < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = fArr.length;
            }
            int i3 = i2 + i;
            if (i3 > fArr.length) {
                i3 = fArr.length;
            }
            if (i < i3) {
                double d2 = 0.0d;
                for (int i4 = i; i4 < i3; i4++) {
                    d2 += fArr[i4];
                }
                double d3 = i3 - i;
                this.sum = d2;
                this.average = d2 / d3;
                while (i < i3) {
                    double d4 = fArr[i] - this.average;
                    d += d4 * d4;
                    i++;
                }
                double d5 = d / d3;
                this.variance = d5;
                double sqrt = Math.sqrt(d5);
                this.stdDeviation = sqrt;
                return sqrt;
            }
        }
        return OOXIXo.f3760XO;
    }

    public double calc(double[] dArr, int i, int i2) {
        double d = OOXIXo.f3760XO;
        if (dArr != null && i2 != 0) {
            if (i < 0 && (i = i + dArr.length) < 0) {
                i = 0;
            }
            if (i2 < 0) {
                i2 = dArr.length;
            }
            int i3 = i2 + i;
            if (i3 > dArr.length) {
                i3 = dArr.length;
            }
            if (i < i3) {
                double d2 = 0.0d;
                for (int i4 = i; i4 < i3; i4++) {
                    d2 += dArr[i4];
                }
                double d3 = i3 - i;
                this.sum = d2;
                this.average = d2 / d3;
                while (i < i3) {
                    double d4 = dArr[i] - this.average;
                    d += d4 * d4;
                    i++;
                }
                double d5 = d / d3;
                this.variance = d5;
                double sqrt = Math.sqrt(d5);
                this.stdDeviation = sqrt;
                return sqrt;
            }
        }
        return OOXIXo.f3760XO;
    }
}

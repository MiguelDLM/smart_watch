package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes9.dex */
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    /* loaded from: classes9.dex */
    public static final class Distance implements Comparable<Distance> {
        int index = -1;
        double distance = -1.0d;

        @Override // java.lang.Comparable
        public int compareTo(Distance distance) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance.distance));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i) {
        int[] iArr3;
        int i2;
        int i3;
        int i4 = 1;
        Random random = new Random(272008L);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr = new double[iArr.length];
        int[] iArr4 = new int[iArr.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i5 = 0;
        for (int i6 : iArr) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i6));
            if (num == null) {
                dArr[i5] = pointProviderLab.fromInt(i6);
                iArr4[i5] = i6;
                i5++;
                linkedHashMap.put(Integer.valueOf(i6), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i6), Integer.valueOf(num.intValue() + 1));
            }
        }
        int[] iArr5 = new int[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            iArr5[i7] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr4[i7]))).intValue();
        }
        int min = Math.min(i, i5);
        if (iArr2.length != 0) {
            min = Math.min(min, iArr2.length);
        }
        double[][] dArr2 = new double[min];
        int i8 = 0;
        for (int i9 = 0; i9 < iArr2.length; i9++) {
            dArr2[i9] = pointProviderLab.fromInt(iArr2[i9]);
            i8++;
        }
        int i10 = min - i8;
        if (i10 > 0) {
            for (int i11 = 0; i11 < i10; i11++) {
            }
        }
        int[] iArr6 = new int[i5];
        for (int i12 = 0; i12 < i5; i12++) {
            iArr6[i12] = random.nextInt(min);
        }
        int[][] iArr7 = new int[min];
        for (int i13 = 0; i13 < min; i13++) {
            iArr7[i13] = new int[min];
        }
        Distance[][] distanceArr = new Distance[min];
        for (int i14 = 0; i14 < min; i14++) {
            distanceArr[i14] = new Distance[min];
            for (int i15 = 0; i15 < min; i15++) {
                distanceArr[i14][i15] = new Distance();
            }
        }
        int[] iArr8 = new int[min];
        int i16 = 0;
        while (true) {
            if (i16 < 10) {
                int i17 = 0;
                while (i17 < min) {
                    int i18 = i17 + 1;
                    int i19 = i18;
                    while (i19 < min) {
                        int[] iArr9 = iArr8;
                        double distance = pointProviderLab.distance(dArr2[i17], dArr2[i19]);
                        Distance distance2 = distanceArr[i19][i17];
                        distance2.distance = distance;
                        distance2.index = i17;
                        Distance distance3 = distanceArr[i17][i19];
                        distance3.distance = distance;
                        distance3.index = i19;
                        i4 = 1;
                        i19++;
                        iArr8 = iArr9;
                        i16 = i16;
                    }
                    int[] iArr10 = iArr8;
                    int i20 = i16;
                    Arrays.sort(distanceArr[i17]);
                    for (int i21 = 0; i21 < min; i21 += i4) {
                        iArr7[i17][i21] = distanceArr[i17][i21].index;
                    }
                    iArr8 = iArr10;
                    i16 = i20;
                    i17 = i18;
                }
                int[] iArr11 = iArr8;
                int i22 = i16;
                int i23 = 0;
                int i24 = 0;
                while (i23 < i5) {
                    double[] dArr3 = dArr[i23];
                    int i25 = iArr6[i23];
                    double distance4 = pointProviderLab.distance(dArr3, dArr2[i25]);
                    int[][] iArr12 = iArr7;
                    double d = distance4;
                    int i26 = -1;
                    int i27 = 0;
                    while (i27 < min) {
                        Distance[][] distanceArr2 = distanceArr;
                        int i28 = i5;
                        if (distanceArr[i25][i27].distance < 4.0d * distance4) {
                            double distance5 = pointProviderLab.distance(dArr3, dArr2[i27]);
                            if (distance5 < d) {
                                d = distance5;
                                i26 = i27;
                            }
                        }
                        i27++;
                        i5 = i28;
                        distanceArr = distanceArr2;
                    }
                    Distance[][] distanceArr3 = distanceArr;
                    int i29 = i5;
                    if (i26 != -1 && Math.abs(Math.sqrt(d) - Math.sqrt(distance4)) > 3.0d) {
                        i24++;
                        iArr6[i23] = i26;
                    }
                    i23++;
                    iArr7 = iArr12;
                    i5 = i29;
                    distanceArr = distanceArr3;
                }
                int[][] iArr13 = iArr7;
                Distance[][] distanceArr4 = distanceArr;
                int i30 = i5;
                if (i24 == 0 && i22 != 0) {
                    iArr3 = iArr11;
                    break;
                }
                double[] dArr4 = new double[min];
                double[] dArr5 = new double[min];
                double[] dArr6 = new double[min];
                char c = 0;
                Arrays.fill(iArr11, 0);
                int i31 = 0;
                while (true) {
                    i2 = i30;
                    if (i31 >= i2) {
                        break;
                    }
                    int i32 = iArr6[i31];
                    double[] dArr7 = dArr[i31];
                    int i33 = iArr5[i31];
                    iArr11[i32] = iArr11[i32] + i33;
                    double d2 = dArr4[i32];
                    double d3 = dArr7[c];
                    int[] iArr14 = iArr5;
                    double d4 = i33;
                    dArr4[i32] = d2 + (d3 * d4);
                    dArr5[i32] = dArr5[i32] + (dArr7[1] * d4);
                    dArr6[i32] = dArr6[i32] + (dArr7[2] * d4);
                    i31++;
                    iArr5 = iArr14;
                    iArr6 = iArr6;
                    c = 0;
                    i30 = i2;
                }
                int[] iArr15 = iArr5;
                int[] iArr16 = iArr6;
                int i34 = 0;
                while (i34 < min) {
                    int i35 = iArr11[i34];
                    if (i35 == 0) {
                        dArr2[i34] = new double[]{XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO};
                        i3 = 1;
                    } else {
                        double d5 = i35;
                        double d6 = dArr4[i34] / d5;
                        double d7 = dArr5[i34] / d5;
                        double d8 = dArr6[i34] / d5;
                        double[] dArr8 = dArr2[i34];
                        dArr8[0] = d6;
                        i3 = 1;
                        dArr8[1] = d7;
                        dArr8[2] = d8;
                    }
                    i34 += i3;
                }
                i16 = i22 + 1;
                iArr5 = iArr15;
                iArr8 = iArr11;
                i5 = i2;
                iArr7 = iArr13;
                iArr6 = iArr16;
                distanceArr = distanceArr4;
                i4 = 1;
            } else {
                iArr3 = iArr8;
                break;
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i36 = 0; i36 < min; i36++) {
            int i37 = iArr3[i36];
            if (i37 != 0) {
                int i38 = pointProviderLab.toInt(dArr2[i36]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i38))) {
                    linkedHashMap2.put(Integer.valueOf(i38), Integer.valueOf(i37));
                }
            }
        }
        return linkedHashMap2;
    }
}

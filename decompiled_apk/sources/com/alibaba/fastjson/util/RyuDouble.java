package com.alibaba.fastjson.util;

import com.garmin.fit.X0xOO;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaPeriodQueue;
import java.lang.reflect.Array;
import java.math.BigInteger;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes.dex */
public final class RyuDouble {
    private static final int[][] POW5_INV_SPLIT;
    private static final int[][] POW5_SPLIT;

    static {
        int i;
        int[] iArr = {X0xOO.f13676oI0, 4};
        Class cls = Integer.TYPE;
        POW5_SPLIT = (int[][]) Array.newInstance((Class<?>) cls, iArr);
        POW5_INV_SPLIT = (int[][]) Array.newInstance((Class<?>) cls, X0xOO.f13580O0OOX0IIx, 4);
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger subtract = bigInteger.shiftLeft(31).subtract(bigInteger);
        BigInteger subtract2 = bigInteger.shiftLeft(31).subtract(bigInteger);
        for (int i2 = 0; i2 < 326; i2++) {
            BigInteger pow = BigInteger.valueOf(5L).pow(i2);
            int bitLength = pow.bitLength();
            if (i2 == 0) {
                i = 1;
            } else {
                i = (int) (((i2 * 23219280) + 9999999) / 10000000);
            }
            if (i == bitLength) {
                if (i2 < POW5_SPLIT.length) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        POW5_SPLIT[i2][i3] = pow.shiftRight((bitLength - 121) + ((3 - i3) * 31)).and(subtract).intValue();
                    }
                }
                if (i2 < POW5_INV_SPLIT.length) {
                    BigInteger bigInteger2 = BigInteger.ONE;
                    BigInteger add = bigInteger2.shiftLeft(bitLength + 121).divide(pow).add(bigInteger2);
                    for (int i4 = 0; i4 < 4; i4++) {
                        if (i4 == 0) {
                            POW5_INV_SPLIT[i2][i4] = add.shiftRight((3 - i4) * 31).intValue();
                        } else {
                            POW5_INV_SPLIT[i2][i4] = add.shiftRight((3 - i4) * 31).and(subtract2).intValue();
                        }
                    }
                }
            } else {
                throw new IllegalStateException(bitLength + " != " + i);
            }
        }
    }

    public static String toString(double d) {
        char[] cArr = new char[24];
        return new String(cArr, 0, toString(d, cArr, 0));
    }

    public static int toString(double d, char[] cArr, int i) {
        int i2;
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        int i3;
        boolean z3;
        boolean z4;
        long j4;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z5;
        int i9;
        int i10;
        int i11;
        int i12;
        if (!Double.isNaN(d)) {
            if (d == Double.POSITIVE_INFINITY) {
                cArr[i] = 'I';
                cArr[i + 1] = 'n';
                cArr[i + 2] = 'f';
                cArr[i + 3] = 'i';
                cArr[i + 4] = 'n';
                cArr[i + 5] = 'i';
                cArr[i + 6] = 't';
                i8 = i + 8;
                cArr[i + 7] = 'y';
            } else if (d == Double.NEGATIVE_INFINITY) {
                cArr[i] = '-';
                cArr[i + 1] = 'I';
                cArr[i + 2] = 'n';
                cArr[i + 3] = 'f';
                cArr[i + 4] = 'i';
                cArr[i + 5] = 'n';
                cArr[i + 6] = 'i';
                cArr[i + 7] = 't';
                i12 = i + 9;
                cArr[i + 8] = 'y';
            } else {
                long doubleToLongBits = Double.doubleToLongBits(d);
                if (doubleToLongBits == 0) {
                    cArr[i] = '0';
                    cArr[i + 1] = '.';
                    i12 = i + 3;
                    cArr[i + 2] = '0';
                } else if (doubleToLongBits == Long.MIN_VALUE) {
                    cArr[i] = '-';
                    cArr[i + 1] = '0';
                    cArr[i + 2] = '.';
                    i8 = i + 4;
                    cArr[i + 3] = '0';
                } else {
                    int i13 = (int) ((doubleToLongBits >>> 52) & 2047);
                    long j5 = doubleToLongBits & 4503599627370495L;
                    if (i13 == 0) {
                        i2 = -1074;
                    } else {
                        i2 = i13 - 1075;
                        j5 |= 4503599627370496L;
                    }
                    boolean z6 = doubleToLongBits < 0;
                    boolean z7 = (j5 & 1) == 0;
                    long j6 = 4 * j5;
                    long j7 = j6 + 2;
                    int i14 = (j5 != 4503599627370496L || i13 <= 1) ? 1 : 0;
                    long j8 = (j6 - 1) - i14;
                    int i15 = i2 - 2;
                    int i16 = 3;
                    if (i15 >= 0) {
                        int max = Math.max(0, ((int) ((i15 * 3010299) / 10000000)) - 1);
                        int i17 = (((-i15) + max) + ((max == 0 ? 1 : (int) (((max * 23219280) + 9999999) / 10000000)) + 121)) - 114;
                        if (i17 >= 0) {
                            int[] iArr = POW5_INV_SPLIT[max];
                            long j9 = j6 >>> 31;
                            long j10 = j6 & 2147483647L;
                            int i18 = iArr[0];
                            int i19 = iArr[1];
                            int i20 = iArr[2];
                            z2 = z7;
                            int i21 = iArr[3];
                            long j11 = ((((((((((((j10 * i21) >>> 31) + (i20 * j10)) + (i21 * j9)) >>> 31) + (i19 * j10)) + (i20 * j9)) >>> 31) + (i18 * j10)) + (i19 * j9)) >>> 21) + ((i18 * j9) << 10)) >>> i17;
                            long j12 = j7 >>> 31;
                            long j13 = j7 & 2147483647L;
                            z = z6;
                            long j14 = ((((((((((((j13 * i21) >>> 31) + (i20 * j13)) + (j12 * i21)) >>> 31) + (i19 * j13)) + (i20 * j12)) >>> 31) + (i18 * j13)) + (i19 * j12)) >>> 21) + ((i18 * j12) << 10)) >>> i17;
                            long j15 = j8 >>> 31;
                            long j16 = j8 & 2147483647L;
                            j2 = j14;
                            j3 = ((((((((((((j16 * i21) >>> 31) + (i20 * j16)) + (j15 * i21)) >>> 31) + (i19 * j16)) + (i20 * j15)) >>> 31) + (i18 * j16)) + (i19 * j15)) >>> 21) + ((i18 * j15) << 10)) >>> i17;
                            if (max <= 21) {
                                long j17 = j6 % 5;
                                if (j17 == 0) {
                                    if (j17 != 0) {
                                        i11 = 0;
                                    } else if (j6 % 25 != 0) {
                                        i11 = 1;
                                    } else if (j6 % 125 != 0) {
                                        i11 = 2;
                                    } else if (j6 % 625 != 0) {
                                        i11 = 3;
                                    } else {
                                        long j18 = j6 / 625;
                                        int i22 = 4;
                                        for (long j19 = 0; j18 > j19 && j18 % 5 == j19; j19 = 0) {
                                            j18 /= 5;
                                            i22++;
                                        }
                                        i11 = i22;
                                    }
                                    z5 = i11 >= max;
                                    z4 = false;
                                    j = j11;
                                    z3 = z5;
                                    i3 = max;
                                } else if (z2) {
                                    if (j8 % 5 != 0) {
                                        i10 = 0;
                                    } else if (j8 % 25 != 0) {
                                        i10 = 1;
                                    } else if (j8 % 125 != 0) {
                                        i10 = 2;
                                    } else if (j8 % 625 != 0) {
                                        i10 = 3;
                                    } else {
                                        long j20 = j8 / 625;
                                        int i23 = 4;
                                        for (long j21 = 0; j20 > j21 && j20 % 5 == j21; j21 = 0) {
                                            j20 /= 5;
                                            i23++;
                                        }
                                        i10 = i23;
                                    }
                                    z4 = i10 >= max;
                                    z5 = false;
                                    j = j11;
                                    z3 = z5;
                                    i3 = max;
                                } else {
                                    if (j7 % 5 != 0) {
                                        i9 = 0;
                                    } else if (j7 % 25 != 0) {
                                        i9 = 1;
                                    } else if (j7 % 125 != 0) {
                                        i9 = 2;
                                    } else if (j7 % 625 != 0) {
                                        i9 = 3;
                                    } else {
                                        long j22 = j7 / 625;
                                        int i24 = 4;
                                        for (long j23 = 0; j22 > j23 && j22 % 5 == j23; j23 = 0) {
                                            j22 /= 5;
                                            i24++;
                                        }
                                        i9 = i24;
                                    }
                                    if (i9 >= max) {
                                        j2--;
                                    }
                                }
                            }
                            z5 = false;
                            z4 = false;
                            j = j11;
                            z3 = z5;
                            i3 = max;
                        } else {
                            throw new IllegalArgumentException("" + i17);
                        }
                    } else {
                        z = z6;
                        z2 = z7;
                        int i25 = -i15;
                        int max2 = Math.max(0, ((int) ((i25 * 6989700) / 10000000)) - 1);
                        int i26 = i25 - max2;
                        int i27 = (max2 - ((i26 == 0 ? 1 : (int) (((i26 * 23219280) + 9999999) / 10000000)) - 121)) - 114;
                        if (i27 >= 0) {
                            int[] iArr2 = POW5_SPLIT[i26];
                            long j24 = j6 >>> 31;
                            long j25 = j6 & 2147483647L;
                            int i28 = iArr2[0];
                            int i29 = iArr2[1];
                            int i30 = i14;
                            int i31 = iArr2[2];
                            int i32 = iArr2[3];
                            long j26 = ((((((((((((j25 * i32) >>> 31) + (i31 * j25)) + (j24 * i32)) >>> 31) + (i29 * j25)) + (i31 * j24)) >>> 31) + (i28 * j25)) + (i29 * j24)) >>> 21) + ((i28 * j24) << 10)) >>> i27;
                            long j27 = j7 >>> 31;
                            long j28 = j7 & 2147483647L;
                            j = j26;
                            j2 = ((((((((((((j28 * i32) >>> 31) + (i31 * j28)) + (j27 * i32)) >>> 31) + (i29 * j28)) + (i31 * j27)) >>> 31) + (i28 * j28)) + (i29 * j27)) >>> 21) + ((i28 * j27) << 10)) >>> i27;
                            long j29 = j8 >>> 31;
                            long j30 = j8 & 2147483647L;
                            j3 = ((((((((((((j30 * i32) >>> 31) + (i31 * j30)) + (j29 * i32)) >>> 31) + (i29 * j30)) + (i31 * j29)) >>> 31) + (i28 * j30)) + (i29 * j29)) >>> 21) + ((i28 * j29) << 10)) >>> i27;
                            i3 = max2 + i15;
                            z3 = true;
                            if (max2 > 1) {
                                z3 = max2 < 63 && (j6 & ((1 << (max2 - 1)) - 1)) == 0;
                            } else if (!z2) {
                                j2--;
                            } else if (i30 == 1) {
                                z4 = true;
                            }
                            z4 = false;
                        } else {
                            throw new IllegalArgumentException("" + i27);
                        }
                    }
                    if (j2 >= 1000000000000000000L) {
                        i16 = 19;
                    } else if (j2 >= 100000000000000000L) {
                        i16 = 18;
                    } else if (j2 >= 10000000000000000L) {
                        i16 = 17;
                    } else if (j2 >= 1000000000000000L) {
                        i16 = 16;
                    } else if (j2 >= 100000000000000L) {
                        i16 = 15;
                    } else if (j2 >= 10000000000000L) {
                        i16 = 14;
                    } else if (j2 >= MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US) {
                        i16 = 13;
                    } else if (j2 >= 100000000000L) {
                        i16 = 12;
                    } else if (j2 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                        i16 = 11;
                    } else if (j2 >= C.NANOS_PER_SECOND) {
                        i16 = 10;
                    } else if (j2 >= 100000000) {
                        i16 = 9;
                    } else if (j2 >= 10000000) {
                        i16 = 8;
                    } else if (j2 >= 1000000) {
                        i16 = 7;
                    } else if (j2 >= 100000) {
                        i16 = 6;
                    } else if (j2 >= 10000) {
                        i16 = 5;
                    } else if (j2 >= 1000) {
                        i16 = 4;
                    } else if (j2 < 100) {
                        i16 = j2 >= 10 ? 2 : 1;
                    }
                    int i33 = i3 + i16;
                    int i34 = i33 - 1;
                    boolean z8 = i34 < -3 || i34 >= 7;
                    if (z4 || z3) {
                        int i35 = 0;
                        int i36 = 0;
                        while (true) {
                            long j31 = j2 / 10;
                            long j32 = j3 / 10;
                            if (j31 <= j32 || (j2 < 100 && z8)) {
                                break;
                            }
                            z4 &= j3 % 10 == 0;
                            z3 &= i35 == 0;
                            i35 = (int) (j % 10);
                            j /= 10;
                            i36++;
                            j2 = j31;
                            j3 = j32;
                        }
                        if (z4 && z2) {
                            while (j3 % 10 == 0 && (j2 >= 100 || !z8)) {
                                z3 &= i35 == 0;
                                i35 = (int) (j % 10);
                                j2 /= 10;
                                j /= 10;
                                j3 /= 10;
                                i36++;
                            }
                        }
                        if (z3 && i35 == 5 && j % 2 == 0) {
                            i35 = 4;
                        }
                        j4 = j + (((j != j3 || (z4 && z2)) && i35 < 5) ? 0 : 1);
                        i4 = i36;
                    } else {
                        i4 = 0;
                        int i37 = 0;
                        while (true) {
                            long j33 = j2 / 10;
                            long j34 = j3 / 10;
                            if (j33 <= j34 || (j2 < 100 && z8)) {
                                break;
                            }
                            i37 = (int) (j % 10);
                            j /= 10;
                            i4++;
                            j2 = j33;
                            j3 = j34;
                        }
                        j4 = j + ((j == j3 || i37 >= 5) ? 1 : 0);
                    }
                    int i38 = i16 - i4;
                    if (z) {
                        i5 = i + 1;
                        cArr[i] = '-';
                    } else {
                        i5 = i;
                    }
                    if (!z8) {
                        char c = '0';
                        if (i34 < 0) {
                            int i39 = i5 + 1;
                            cArr[i5] = '0';
                            int i40 = i5 + 2;
                            cArr[i39] = '.';
                            int i41 = -1;
                            while (i41 > i34) {
                                cArr[i40] = c;
                                i41--;
                                i40++;
                                c = '0';
                            }
                            i6 = i40;
                            for (int i42 = 0; i42 < i38; i42++) {
                                cArr[((i40 + i38) - i42) - 1] = (char) ((j4 % 10) + 48);
                                j4 /= 10;
                                i6++;
                            }
                        } else if (i33 >= i38) {
                            for (int i43 = 0; i43 < i38; i43++) {
                                cArr[((i5 + i38) - i43) - 1] = (char) ((j4 % 10) + 48);
                                j4 /= 10;
                            }
                            int i44 = i5 + i38;
                            while (i38 < i33) {
                                cArr[i44] = '0';
                                i38++;
                                i44++;
                            }
                            cArr[i44] = '.';
                            i6 = i44 + 2;
                            cArr[i44 + 1] = '0';
                        } else {
                            int i45 = i5 + 1;
                            for (int i46 = 0; i46 < i38; i46++) {
                                if ((i38 - i46) - 1 == i34) {
                                    cArr[((i45 + i38) - i46) - 1] = '.';
                                    i45--;
                                }
                                cArr[((i45 + i38) - i46) - 1] = (char) ((j4 % 10) + 48);
                                j4 /= 10;
                            }
                            i6 = i5 + i38 + 1;
                        }
                        return i6 - i;
                    }
                    for (int i47 = 0; i47 < i38 - 1; i47++) {
                        int i48 = (int) (j4 % 10);
                        j4 /= 10;
                        cArr[(i5 + i38) - i47] = (char) (i48 + 48);
                    }
                    cArr[i5] = (char) ((j4 % 10) + 48);
                    cArr[i5 + 1] = '.';
                    int i49 = i5 + i38 + 1;
                    if (i38 == 1) {
                        cArr[i49] = '0';
                        i49++;
                    }
                    int i50 = i49 + 1;
                    cArr[i49] = 'E';
                    if (i34 < 0) {
                        cArr[i50] = '-';
                        i34 = -i34;
                        i50 = i49 + 2;
                    }
                    if (i34 >= 100) {
                        int i51 = i50 + 1;
                        i7 = 48;
                        cArr[i50] = (char) ((i34 / 100) + 48);
                        i34 %= 100;
                        i50 += 2;
                        cArr[i51] = (char) ((i34 / 10) + 48);
                    } else {
                        i7 = 48;
                        if (i34 >= 10) {
                            cArr[i50] = (char) ((i34 / 10) + 48);
                            i50++;
                        }
                    }
                    i8 = i50 + 1;
                    cArr[i50] = (char) ((i34 % 10) + i7);
                }
            }
            return i8 - i;
        }
        cArr[i] = 'N';
        cArr[i + 1] = 'a';
        i12 = i + 3;
        cArr[i + 2] = 'N';
        return i12 - i;
    }
}

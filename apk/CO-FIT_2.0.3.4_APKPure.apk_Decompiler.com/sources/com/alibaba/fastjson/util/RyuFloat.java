package com.alibaba.fastjson.util;

import com.garmin.fit.O0Xx;
import com.tencent.mm.opensdk.constants.Build;

public final class RyuFloat {
    private static final int[][] POW5_INV_SPLIT = {new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};
    private static final int[][] POW5_SPLIT = {new int[]{536870912, 0}, new int[]{Build.SUPPORT_SEND_MUSIC_VIDEO_MESSAGE, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{1000000000, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};

    public static String toString(float f) {
        char[] cArr = new char[15];
        return new String(cArr, 0, toString(f, cArr, 0));
    }

    public static int toString(float f, char[] cArr, int i) {
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        boolean z2;
        int i6;
        boolean z3;
        boolean z4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        if (Float.isNaN(f)) {
            cArr[i] = 'N';
            cArr[i + 1] = 'a';
            i18 = i + 3;
            cArr[i + 2] = 'N';
        } else {
            if (f == Float.POSITIVE_INFINITY) {
                cArr[i] = 'I';
                cArr[i + 1] = 'n';
                cArr[i + 2] = 'f';
                cArr[i + 3] = 'i';
                cArr[i + 4] = 'n';
                cArr[i + 5] = 'i';
                cArr[i + 6] = 't';
                i17 = i + 8;
                cArr[i + 7] = 'y';
            } else if (f == Float.NEGATIVE_INFINITY) {
                cArr[i] = '-';
                cArr[i + 1] = 'I';
                cArr[i + 2] = 'n';
                cArr[i + 3] = 'f';
                cArr[i + 4] = 'i';
                cArr[i + 5] = 'n';
                cArr[i + 6] = 'i';
                cArr[i + 7] = 't';
                i18 = i + 9;
                cArr[i + 8] = 'y';
            } else {
                int floatToIntBits = Float.floatToIntBits(f);
                if (floatToIntBits == 0) {
                    cArr[i] = '0';
                    cArr[i + 1] = '.';
                    i18 = i + 3;
                    cArr[i + 2] = '0';
                } else if (floatToIntBits == Integer.MIN_VALUE) {
                    cArr[i] = '-';
                    cArr[i + 1] = '0';
                    cArr[i + 2] = '.';
                    i17 = i + 4;
                    cArr[i + 3] = '0';
                } else {
                    int i19 = (floatToIntBits >> 23) & 255;
                    int i20 = 8388607 & floatToIntBits;
                    if (i19 == 0) {
                        i2 = -149;
                    } else {
                        i2 = i19 - 150;
                        i20 |= 8388608;
                    }
                    boolean z5 = floatToIntBits < 0;
                    boolean z6 = (i20 & 1) == 0;
                    int i21 = i20 * 4;
                    int i22 = i21 + 2;
                    int i23 = i21 - ((((long) i20) != O0Xx.f30764o00 || i19 <= 1) ? 2 : 1);
                    int i24 = i2 - 2;
                    if (i24 >= 0) {
                        i6 = (int) ((((long) i24) * 3010299) / 10000000);
                        if (i6 == 0) {
                            i15 = 1;
                        } else {
                            i15 = (int) (((((long) i6) * 23219280) + 9999999) / 10000000);
                        }
                        int i25 = (-i24) + i6;
                        int[][] iArr = POW5_INV_SPLIT;
                        int[] iArr2 = iArr[i6];
                        long j = (long) iArr2[0];
                        long j2 = (long) iArr2[1];
                        long j3 = (long) i21;
                        int i26 = ((i15 + 58) + i25) - 31;
                        z3 = z6;
                        int i27 = i21;
                        i3 = (int) (((j3 * j) + ((j3 * j2) >> 31)) >> i26);
                        long j4 = (long) i22;
                        i4 = (int) (((j4 * j) + ((j4 * j2) >> 31)) >> i26);
                        long j5 = j3;
                        long j6 = (long) i23;
                        i7 = (int) (((j * j6) + ((j6 * j2) >> 31)) >> i26);
                        if (i6 == 0 || (i4 - 1) / 10 > i7 / 10) {
                            i8 = 0;
                        } else {
                            int i28 = i6 - 1;
                            if (i28 == 0) {
                                i16 = 1;
                            } else {
                                i16 = (int) (((((long) i28) * 23219280) + 9999999) / 10000000);
                            }
                            int[] iArr3 = iArr[i28];
                            i8 = (int) ((((j5 * ((long) iArr3[0])) + ((((long) iArr3[1]) * j5) >> 31)) >> (((i25 - 1) + (i16 + 58)) - 31)) % 10);
                        }
                        int i29 = 0;
                        while (i22 > 0 && i22 % 5 == 0) {
                            i22 /= 5;
                            i29++;
                        }
                        int i30 = 0;
                        while (i27 > 0 && i27 % 5 == 0) {
                            i27 /= 5;
                            i30++;
                        }
                        int i31 = 0;
                        while (i23 > 0 && i23 % 5 == 0) {
                            i23 /= 5;
                            i31++;
                        }
                        z4 = i29 >= i6;
                        z2 = i30 >= i6;
                        z = i31 >= i6;
                        i5 = 0;
                    } else {
                        z3 = z6;
                        int i32 = i21;
                        int i33 = -i24;
                        int i34 = (int) ((((long) i33) * 6989700) / 10000000);
                        int i35 = i33 - i34;
                        if (i35 == 0) {
                            i12 = 1;
                        } else {
                            i12 = (int) (((((long) i35) * 23219280) + 9999999) / 10000000);
                        }
                        int[][] iArr4 = POW5_SPLIT;
                        int[] iArr5 = iArr4[i35];
                        long j7 = (long) iArr5[0];
                        long j8 = (long) iArr5[1];
                        int i36 = (i34 - (i12 - 61)) - 31;
                        int i37 = i32;
                        long j9 = (long) i37;
                        long j10 = j9;
                        i3 = (int) (((j9 * j7) + ((j9 * j8) >> 31)) >> i36);
                        long j11 = (long) i22;
                        int i38 = (int) (((j11 * j7) + ((j11 * j8) >> 31)) >> i36);
                        long j12 = (long) i23;
                        int i39 = (int) (((j7 * j12) + ((j12 * j8) >> 31)) >> i36);
                        if (i34 == 0 || (i38 - 1) / 10 > i39 / 10) {
                            i5 = 0;
                            i13 = 0;
                        } else {
                            int i40 = i35 + 1;
                            int i41 = i34 - 1;
                            if (i40 == 0) {
                                i14 = 1;
                            } else {
                                i14 = (int) (((((long) i40) * 23219280) + 9999999) / 10000000);
                            }
                            int[] iArr6 = iArr4[i40];
                            i5 = 0;
                            i13 = (int) ((((j10 * ((long) iArr6[0])) + ((((long) iArr6[1]) * j10) >> 31)) >> ((i41 - (i14 - 61)) - 31)) % 10);
                        }
                        int i42 = i24 + i34;
                        boolean z7 = 1 >= i34;
                        boolean z8 = i34 < 23 && (i37 & ((1 << (i34 + -1)) - 1)) == 0;
                        boolean z9 = (i23 % 2 == 1 ? (char) 0 : 1) >= i34;
                        z4 = z7;
                        i4 = i38;
                        boolean z10 = z8;
                        z = z9;
                        i7 = i39;
                        i6 = i42;
                        z2 = z10;
                    }
                    int i43 = 1000000000;
                    int i44 = 10;
                    while (i44 > 0 && i4 < i43) {
                        i43 /= 10;
                        i44--;
                    }
                    int i45 = i6 + i44;
                    int i46 = i45 - 1;
                    boolean z11 = i46 < -3 || i46 >= 7;
                    if (z4 && !z3) {
                        i4--;
                    }
                    int i47 = 0;
                    while (true) {
                        int i48 = i4 / 10;
                        int i49 = i7 / 10;
                        if (i48 > i49 && (i4 >= 100 || !z11)) {
                            z &= i7 % 10 == 0;
                            i8 = i3 % 10;
                            i3 /= 10;
                            i47++;
                            i4 = i48;
                            i7 = i49;
                        } else if (z && z3) {
                            while (i7 % 10 == 0 && (i4 >= 100 || !z11)) {
                                i4 /= 10;
                                i8 = i3 % 10;
                                i3 /= 10;
                                i7 /= 10;
                                i47++;
                            }
                        }
                    }
                    while (i7 % 10 == 0) {
                        i4 /= 10;
                        i8 = i3 % 10;
                        i3 /= 10;
                        i7 /= 10;
                        i47++;
                    }
                    int i50 = i3;
                    if (z2 && i8 == 5 && i50 % 2 == 0) {
                        i8 = 4;
                    }
                    int i51 = i50 + (((i50 != i7 || (z && z3)) && i8 < 5) ? 0 : 1);
                    int i52 = i44 - i47;
                    if (z5) {
                        i9 = i + 1;
                        cArr[i] = '-';
                    } else {
                        i9 = i;
                    }
                    if (z11) {
                        while (i5 < i52 - 1) {
                            int i53 = i51 % 10;
                            i51 /= 10;
                            cArr[(i9 + i52) - i5] = (char) (i53 + 48);
                            i5++;
                        }
                        cArr[i9] = (char) ((i51 % 10) + 48);
                        cArr[i9 + 1] = '.';
                        int i54 = i9 + i52 + 1;
                        if (i52 == 1) {
                            cArr[i54] = '0';
                            i54++;
                        }
                        int i55 = i54 + 1;
                        cArr[i54] = 'E';
                        if (i46 < 0) {
                            cArr[i55] = '-';
                            i46 = -i46;
                            i55 = i54 + 2;
                        }
                        if (i46 >= 10) {
                            i11 = 48;
                            cArr[i55] = (char) ((i46 / 10) + 48);
                            i55++;
                        } else {
                            i11 = 48;
                        }
                        i10 = i55 + 1;
                        cArr[i55] = (char) ((i46 % 10) + i11);
                    } else if (i46 < 0) {
                        int i56 = i9 + 1;
                        cArr[i9] = '0';
                        int i57 = i9 + 2;
                        cArr[i56] = '.';
                        int i58 = -1;
                        while (i58 > i46) {
                            cArr[i57] = '0';
                            i58--;
                            i57++;
                        }
                        int i59 = i57;
                        while (i5 < i52) {
                            cArr[((i57 + i52) - i5) - 1] = (char) ((i51 % 10) + 48);
                            i51 /= 10;
                            i59++;
                            i5++;
                        }
                        i10 = i59;
                    } else if (i45 >= i52) {
                        while (i5 < i52) {
                            cArr[((i9 + i52) - i5) - 1] = (char) ((i51 % 10) + 48);
                            i51 /= 10;
                            i5++;
                        }
                        int i60 = i9 + i52;
                        while (i52 < i45) {
                            cArr[i60] = '0';
                            i52++;
                            i60++;
                        }
                        int i61 = i60 + 1;
                        cArr[i60] = '.';
                        i10 = i60 + 2;
                        cArr[i61] = '0';
                    } else {
                        int i62 = i9 + 1;
                        while (i5 < i52) {
                            if ((i52 - i5) - 1 == i46) {
                                cArr[((i62 + i52) - i5) - 1] = '.';
                                i62--;
                            }
                            cArr[((i62 + i52) - i5) - 1] = (char) ((i51 % 10) + 48);
                            i51 /= 10;
                            i5++;
                        }
                        i10 = i9 + i52 + 1;
                    }
                    return i10 - i;
                }
            }
            return i17 - i;
        }
        return i18 - i;
    }
}

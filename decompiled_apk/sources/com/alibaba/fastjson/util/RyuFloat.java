package com.alibaba.fastjson.util;

import com.garmin.fit.O0Xx;
import com.tencent.mm.opensdk.constants.Build;

/* loaded from: classes.dex */
public final class RyuFloat {
    private static final int[][] POW5_SPLIT = {new int[]{536870912, 0}, new int[]{Build.SUPPORT_SEND_MUSIC_VIDEO_MESSAGE, 0}, new int[]{838860800, 0}, new int[]{1048576000, 0}, new int[]{655360000, 0}, new int[]{819200000, 0}, new int[]{1024000000, 0}, new int[]{640000000, 0}, new int[]{800000000, 0}, new int[]{1000000000, 0}, new int[]{625000000, 0}, new int[]{781250000, 0}, new int[]{976562500, 0}, new int[]{610351562, 1073741824}, new int[]{762939453, 268435456}, new int[]{953674316, 872415232}, new int[]{596046447, 1619001344}, new int[]{745058059, 1486880768}, new int[]{931322574, 1321730048}, new int[]{582076609, 289210368}, new int[]{727595761, 898383872}, new int[]{909494701, 1659850752}, new int[]{568434188, 1305842176}, new int[]{710542735, 1632302720}, new int[]{888178419, 1503507488}, new int[]{555111512, 671256724}, new int[]{693889390, 839070905}, new int[]{867361737, 2122580455}, new int[]{542101086, 521306416}, new int[]{677626357, 1725374844}, new int[]{847032947, 546105819}, new int[]{1058791184, 145761362}, new int[]{661744490, 91100851}, new int[]{827180612, 1187617888}, new int[]{1033975765, 1484522360}, new int[]{646234853, 1196261931}, new int[]{807793566, 2032198326}, new int[]{1009741958, 1466506084}, new int[]{631088724, 379695390}, new int[]{788860905, 474619238}, new int[]{986076131, 1130144959}, new int[]{616297582, 437905143}, new int[]{770371977, 1621123253}, new int[]{962964972, 415791331}, new int[]{601853107, 1333611405}, new int[]{752316384, 1130143345}, new int[]{940395480, 1412679181}};
    private static final int[][] POW5_INV_SPLIT = {new int[]{268435456, 1}, new int[]{214748364, 1717986919}, new int[]{171798691, 1803886265}, new int[]{137438953, 1013612282}, new int[]{219902325, 1192282922}, new int[]{175921860, 953826338}, new int[]{140737488, 763061070}, new int[]{225179981, 791400982}, new int[]{180143985, 203624056}, new int[]{144115188, 162899245}, new int[]{230584300, 1978625710}, new int[]{184467440, 1582900568}, new int[]{147573952, 1266320455}, new int[]{236118324, 308125809}, new int[]{188894659, 675997377}, new int[]{151115727, 970294631}, new int[]{241785163, 1981968139}, new int[]{193428131, 297084323}, new int[]{154742504, 1955654377}, new int[]{247588007, 1840556814}, new int[]{198070406, 613451992}, new int[]{158456325, 61264864}, new int[]{253530120, 98023782}, new int[]{202824096, 78419026}, new int[]{162259276, 1780722139}, new int[]{259614842, 1990161963}, new int[]{207691874, 733136111}, new int[]{166153499, 1016005619}, new int[]{265845599, 337118801}, new int[]{212676479, 699191770}, new int[]{170141183, 988850146}};

    public static String toString(float f) {
        char[] cArr = new char[15];
        return new String(cArr, 0, toString(f, cArr, 0));
    }

    public static int toString(float f, char[] cArr, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        boolean z2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        boolean z4;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        if (!Float.isNaN(f)) {
            if (f == Float.POSITIVE_INFINITY) {
                cArr[i] = 'I';
                cArr[i + 1] = 'n';
                cArr[i + 2] = 'f';
                cArr[i + 3] = 'i';
                cArr[i + 4] = 'n';
                cArr[i + 5] = 'i';
                cArr[i + 6] = 't';
                i12 = i + 8;
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
                i13 = i + 9;
                cArr[i + 8] = 'y';
            } else {
                int floatToIntBits = Float.floatToIntBits(f);
                if (floatToIntBits == 0) {
                    cArr[i] = '0';
                    cArr[i + 1] = '.';
                    i13 = i + 3;
                    cArr[i + 2] = '0';
                } else if (floatToIntBits == Integer.MIN_VALUE) {
                    cArr[i] = '-';
                    cArr[i + 1] = '0';
                    cArr[i + 2] = '.';
                    i12 = i + 4;
                    cArr[i + 3] = '0';
                } else {
                    int i14 = (floatToIntBits >> 23) & 255;
                    int i15 = 8388607 & floatToIntBits;
                    if (i14 == 0) {
                        i2 = -149;
                    } else {
                        i2 = i14 - 150;
                        i15 |= 8388608;
                    }
                    boolean z5 = floatToIntBits < 0;
                    boolean z6 = (i15 & 1) == 0;
                    int i16 = i15 * 4;
                    int i17 = i16 + 2;
                    int i18 = i16 - ((((long) i15) != O0Xx.f12368o00 || i14 <= 1) ? 2 : 1);
                    int i19 = i2 - 2;
                    if (i19 >= 0) {
                        i8 = (int) ((i19 * 3010299) / 10000000);
                        int i20 = i8 == 0 ? 1 : (int) (((i8 * 23219280) + 9999999) / 10000000);
                        int i21 = (-i19) + i8;
                        int[][] iArr = POW5_INV_SPLIT;
                        int[] iArr2 = iArr[i8];
                        long j = iArr2[0];
                        long j2 = iArr2[1];
                        long j3 = i16;
                        int i22 = ((i20 + 58) + i21) - 31;
                        z = z6;
                        int i23 = i16;
                        i3 = (int) (((j3 * j) + ((j3 * j2) >> 31)) >> i22);
                        long j4 = i17;
                        i6 = (int) (((j4 * j) + ((j4 * j2) >> 31)) >> i22);
                        long j5 = i18;
                        i7 = (int) (((j * j5) + ((j5 * j2) >> 31)) >> i22);
                        if (i8 == 0 || (i6 - 1) / 10 > i7 / 10) {
                            i5 = 0;
                        } else {
                            int i24 = i8 - 1;
                            int i25 = (i21 - 1) + (i24 == 0 ? 1 : (int) (((i24 * 23219280) + 9999999) / 10000000)) + 58;
                            int[] iArr3 = iArr[i24];
                            i5 = (int) ((((j3 * iArr3[0]) + ((iArr3[1] * j3) >> 31)) >> (i25 - 31)) % 10);
                        }
                        int i26 = 0;
                        while (i17 > 0 && i17 % 5 == 0) {
                            i17 /= 5;
                            i26++;
                        }
                        int i27 = 0;
                        while (i23 > 0 && i23 % 5 == 0) {
                            i23 /= 5;
                            i27++;
                        }
                        int i28 = 0;
                        while (i18 > 0 && i18 % 5 == 0) {
                            i18 /= 5;
                            i28++;
                        }
                        z2 = i26 >= i8;
                        z4 = i27 >= i8;
                        z3 = i28 >= i8;
                        i4 = 0;
                    } else {
                        z = z6;
                        int i29 = -i19;
                        int i30 = (int) ((i29 * 6989700) / 10000000);
                        int i31 = i29 - i30;
                        int i32 = i31 == 0 ? 1 : (int) (((i31 * 23219280) + 9999999) / 10000000);
                        int[][] iArr4 = POW5_SPLIT;
                        int[] iArr5 = iArr4[i31];
                        long j6 = iArr5[0];
                        long j7 = iArr5[1];
                        int i33 = (i30 - (i32 - 61)) - 31;
                        long j8 = i16;
                        i3 = (int) (((j8 * j6) + ((j8 * j7) >> 31)) >> i33);
                        long j9 = i17;
                        int i34 = (int) (((j9 * j6) + ((j9 * j7) >> 31)) >> i33);
                        long j10 = i18;
                        int i35 = (int) (((j6 * j10) + ((j10 * j7) >> 31)) >> i33);
                        if (i30 == 0 || (i34 - 1) / 10 > i35 / 10) {
                            i4 = 0;
                            i5 = 0;
                        } else {
                            int i36 = i31 + 1;
                            int i37 = (i30 - 1) - ((i36 == 0 ? 1 : (int) (((i36 * 23219280) + 9999999) / 10000000)) - 61);
                            int[] iArr6 = iArr4[i36];
                            i4 = 0;
                            i5 = (int) ((((j8 * iArr6[0]) + ((iArr6[1] * j8) >> 31)) >> (i37 - 31)) % 10);
                        }
                        int i38 = i19 + i30;
                        boolean z7 = 1 >= i30;
                        boolean z8 = i30 < 23 && (i16 & ((1 << (i30 + (-1))) - 1)) == 0;
                        boolean z9 = (i18 % 2 == 1 ? 0 : 1) >= i30;
                        z2 = z7;
                        i6 = i34;
                        boolean z10 = z8;
                        z3 = z9;
                        i7 = i35;
                        i8 = i38;
                        z4 = z10;
                    }
                    int i39 = 1000000000;
                    int i40 = 10;
                    while (i40 > 0 && i6 < i39) {
                        i39 /= 10;
                        i40--;
                    }
                    int i41 = i8 + i40;
                    int i42 = i41 - 1;
                    boolean z11 = i42 < -3 || i42 >= 7;
                    if (z2 && !z) {
                        i6--;
                    }
                    int i43 = 0;
                    while (true) {
                        int i44 = i6 / 10;
                        int i45 = i7 / 10;
                        if (i44 <= i45 || (i6 < 100 && z11)) {
                            break;
                        }
                        z3 &= i7 % 10 == 0;
                        i5 = i3 % 10;
                        i3 /= 10;
                        i43++;
                        i6 = i44;
                        i7 = i45;
                    }
                    if (z3 && z) {
                        while (i7 % 10 == 0 && (i6 >= 100 || !z11)) {
                            i6 /= 10;
                            i5 = i3 % 10;
                            i3 /= 10;
                            i7 /= 10;
                            i43++;
                        }
                    }
                    int i46 = i3;
                    if (z4 && i5 == 5 && i46 % 2 == 0) {
                        i5 = 4;
                    }
                    int i47 = i46 + (((i46 != i7 || (z3 && z)) && i5 < 5) ? 0 : 1);
                    int i48 = i40 - i43;
                    if (z5) {
                        i9 = i + 1;
                        cArr[i] = '-';
                    } else {
                        i9 = i;
                    }
                    if (z11) {
                        while (i4 < i48 - 1) {
                            int i49 = i47 % 10;
                            i47 /= 10;
                            cArr[(i9 + i48) - i4] = (char) (i49 + 48);
                            i4++;
                        }
                        cArr[i9] = (char) ((i47 % 10) + 48);
                        cArr[i9 + 1] = '.';
                        int i50 = i9 + i48 + 1;
                        if (i48 == 1) {
                            cArr[i50] = '0';
                            i50++;
                        }
                        int i51 = i50 + 1;
                        cArr[i50] = 'E';
                        if (i42 < 0) {
                            cArr[i51] = '-';
                            i42 = -i42;
                            i51 = i50 + 2;
                        }
                        if (i42 >= 10) {
                            i11 = 48;
                            cArr[i51] = (char) ((i42 / 10) + 48);
                            i51++;
                        } else {
                            i11 = 48;
                        }
                        i10 = i51 + 1;
                        cArr[i51] = (char) ((i42 % 10) + i11);
                    } else if (i42 < 0) {
                        int i52 = i9 + 1;
                        cArr[i9] = '0';
                        int i53 = i9 + 2;
                        cArr[i52] = '.';
                        int i54 = -1;
                        while (i54 > i42) {
                            cArr[i53] = '0';
                            i54--;
                            i53++;
                        }
                        int i55 = i53;
                        while (i4 < i48) {
                            cArr[((i53 + i48) - i4) - 1] = (char) ((i47 % 10) + 48);
                            i47 /= 10;
                            i55++;
                            i4++;
                        }
                        i10 = i55;
                    } else if (i41 >= i48) {
                        while (i4 < i48) {
                            cArr[((i9 + i48) - i4) - 1] = (char) ((i47 % 10) + 48);
                            i47 /= 10;
                            i4++;
                        }
                        int i56 = i9 + i48;
                        while (i48 < i41) {
                            cArr[i56] = '0';
                            i48++;
                            i56++;
                        }
                        int i57 = i56 + 1;
                        cArr[i56] = '.';
                        i10 = i56 + 2;
                        cArr[i57] = '0';
                    } else {
                        int i58 = i9 + 1;
                        while (i4 < i48) {
                            if ((i48 - i4) - 1 == i42) {
                                cArr[((i58 + i48) - i4) - 1] = '.';
                                i58--;
                            }
                            cArr[((i58 + i48) - i4) - 1] = (char) ((i47 % 10) + 48);
                            i47 /= 10;
                            i4++;
                        }
                        i10 = i9 + i48 + 1;
                    }
                    return i10 - i;
                }
            }
            return i12 - i;
        }
        cArr[i] = 'N';
        cArr[i + 1] = 'a';
        i13 = i + 3;
        cArr[i + 2] = 'N';
        return i13 - i;
    }
}

package com.alibaba.fastjson.util;

import java.util.Arrays;

public class Base64 {
    public static final char[] CA;
    public static final int[] IA;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            IA[CA[i]] = i;
        }
        IA[61] = 0;
    }

    public static byte[] decodeFast(char[] cArr, int i, int i2) {
        int i3;
        int i4 = i2;
        int i5 = 0;
        if (i4 == 0) {
            return new byte[0];
        }
        int i6 = (i + i4) - 1;
        int i7 = i;
        while (i7 < i6 && IA[cArr[i7]] < 0) {
            i7++;
        }
        while (i6 > 0 && IA[cArr[i6]] < 0) {
            i6--;
        }
        int i8 = cArr[i6] == '=' ? cArr[i6 + -1] == '=' ? 2 : 1 : 0;
        int i9 = (i6 - i7) + 1;
        if (i4 > 76) {
            i3 = (cArr[76] == 13 ? i9 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i10 = (((i9 - i3) * 6) >> 3) - i8;
        byte[] bArr = new byte[i10];
        int i11 = (i10 / 3) * 3;
        int i12 = 0;
        loop2:
        while (true) {
            int i13 = 0;
            while (i12 < i11) {
                int[] iArr = IA;
                int i14 = i7 + 4;
                int i15 = iArr[cArr[i7 + 3]] | (iArr[cArr[i7 + 1]] << 12) | (iArr[cArr[i7]] << 18) | (iArr[cArr[i7 + 2]] << 6);
                bArr[i12] = (byte) (i15 >> 16);
                int i16 = i12 + 2;
                bArr[i12 + 1] = (byte) (i15 >> 8);
                i12 += 3;
                bArr[i16] = (byte) i15;
                if (i3 <= 0 || (i13 = i13 + 1) != 19) {
                    i7 = i14;
                } else {
                    i7 += 6;
                }
            }
            break loop2;
        }
        if (i12 < i10) {
            int i17 = 0;
            while (i7 <= i6 - i8) {
                i5 |= IA[cArr[i7]] << (18 - (i17 * 6));
                i17++;
                i7++;
            }
            int i18 = 16;
            while (i12 < i10) {
                bArr[i12] = (byte) (i5 >> i18);
                i18 -= 8;
                i12++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i, int i2) {
        int i3;
        int i4;
        String str2 = str;
        int i5 = i2;
        if (i5 == 0) {
            return new byte[0];
        }
        int i6 = (i + i5) - 1;
        int i7 = i;
        while (i3 < i6 && IA[str2.charAt(i3)] < 0) {
            i7 = i3 + 1;
        }
        while (i6 > 0 && IA[str2.charAt(i6)] < 0) {
            i6--;
        }
        int i8 = str2.charAt(i6) == '=' ? str2.charAt(i6 + -1) == '=' ? 2 : 1 : 0;
        int i9 = (i6 - i3) + 1;
        if (i5 > 76) {
            i4 = (str2.charAt(76) == 13 ? i9 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i10 = (((i9 - i4) * 6) >> 3) - i8;
        byte[] bArr = new byte[i10];
        int i11 = (i10 / 3) * 3;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int[] iArr = IA;
            int i14 = i3 + 4;
            int i15 = iArr[str2.charAt(i3 + 3)] | (iArr[str2.charAt(i3 + 1)] << 12) | (iArr[str2.charAt(i3)] << 18) | (iArr[str2.charAt(i3 + 2)] << 6);
            bArr[i12] = (byte) (i15 >> 16);
            int i16 = i12 + 2;
            bArr[i12 + 1] = (byte) (i15 >> 8);
            i12 += 3;
            bArr[i16] = (byte) i15;
            if (i4 <= 0 || (i13 = i13 + 1) != 19) {
                i3 = i14;
            } else {
                i3 += 6;
                i13 = 0;
            }
        }
        if (i12 < i10) {
            int i17 = 0;
            int i18 = 0;
            while (i3 <= i6 - i8) {
                i17 |= IA[str2.charAt(i3)] << (18 - (i18 * 6));
                i18++;
                i3++;
            }
            int i19 = 16;
            while (i12 < i10) {
                bArr[i12] = (byte) (i17 >> i19);
                i19 -= 8;
                i12++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i;
        int i2;
        String str2 = str;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i3 = length - 1;
        int i4 = 0;
        while (i < i3 && IA[str2.charAt(i) & 255] < 0) {
            i4 = i + 1;
        }
        while (i3 > 0 && IA[str2.charAt(i3) & 255] < 0) {
            i3--;
        }
        int i5 = str2.charAt(i3) == '=' ? str2.charAt(i3 + -1) == '=' ? 2 : 1 : 0;
        int i6 = (i3 - i) + 1;
        if (length > 76) {
            i2 = (str2.charAt(76) == 13 ? i6 / 78 : 0) << 1;
        } else {
            i2 = 0;
        }
        int i7 = (((i6 - i2) * 6) >> 3) - i5;
        byte[] bArr = new byte[i7];
        int i8 = (i7 / 3) * 3;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int[] iArr = IA;
            int i11 = i + 4;
            int i12 = iArr[str2.charAt(i + 3)] | (iArr[str2.charAt(i + 1)] << 12) | (iArr[str2.charAt(i)] << 18) | (iArr[str2.charAt(i + 2)] << 6);
            bArr[i9] = (byte) (i12 >> 16);
            int i13 = i9 + 2;
            bArr[i9 + 1] = (byte) (i12 >> 8);
            i9 += 3;
            bArr[i13] = (byte) i12;
            if (i2 <= 0 || (i10 = i10 + 1) != 19) {
                i = i11;
            } else {
                i += 6;
                i10 = 0;
            }
        }
        if (i9 < i7) {
            int i14 = 0;
            int i15 = 0;
            while (i <= i3 - i5) {
                i14 |= IA[str2.charAt(i)] << (18 - (i15 * 6));
                i15++;
                i++;
            }
            int i16 = 16;
            while (i9 < i7) {
                bArr[i9] = (byte) (i14 >> i16);
                i16 -= 8;
                i9++;
            }
        }
        return bArr;
    }
}

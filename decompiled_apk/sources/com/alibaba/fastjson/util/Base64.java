package com.alibaba.fastjson.util;

import java.util.Arrays;

/* loaded from: classes.dex */
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
        int i4 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i5 = (i + i2) - 1;
        int i6 = i;
        while (i6 < i5 && IA[cArr[i6]] < 0) {
            i6++;
        }
        while (i5 > 0 && IA[cArr[i5]] < 0) {
            i5--;
        }
        int i7 = cArr[i5] == '=' ? cArr[i5 + (-1)] == '=' ? 2 : 1 : 0;
        int i8 = (i5 - i6) + 1;
        if (i2 > 76) {
            i3 = (cArr[76] == '\r' ? i8 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i9 = (((i8 - i3) * 6) >> 3) - i7;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        loop2: while (true) {
            int i12 = 0;
            while (i11 < i10) {
                int[] iArr = IA;
                int i13 = i6 + 4;
                int i14 = iArr[cArr[i6 + 3]] | (iArr[cArr[i6 + 1]] << 12) | (iArr[cArr[i6]] << 18) | (iArr[cArr[i6 + 2]] << 6);
                bArr[i11] = (byte) (i14 >> 16);
                int i15 = i11 + 2;
                bArr[i11 + 1] = (byte) (i14 >> 8);
                i11 += 3;
                bArr[i15] = (byte) i14;
                if (i3 <= 0 || (i12 = i12 + 1) != 19) {
                    i6 = i13;
                }
            }
            i6 += 6;
        }
        if (i11 < i9) {
            int i16 = 0;
            while (i6 <= i5 - i7) {
                i4 |= IA[cArr[i6]] << (18 - (i16 * 6));
                i16++;
                i6++;
            }
            int i17 = 16;
            while (i11 < i9) {
                bArr[i11] = (byte) (i4 >> i17);
                i17 -= 8;
                i11++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i, int i2) {
        int i3;
        if (i2 == 0) {
            return new byte[0];
        }
        int i4 = (i + i2) - 1;
        int i5 = i;
        while (i5 < i4 && IA[str.charAt(i5)] < 0) {
            i5++;
        }
        while (i4 > 0 && IA[str.charAt(i4)] < 0) {
            i4--;
        }
        int i6 = str.charAt(i4) == '=' ? str.charAt(i4 + (-1)) == '=' ? 2 : 1 : 0;
        int i7 = (i4 - i5) + 1;
        if (i2 > 76) {
            i3 = (str.charAt(76) == '\r' ? i7 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i8 = (((i7 - i3) * 6) >> 3) - i6;
        byte[] bArr = new byte[i8];
        int i9 = (i8 / 3) * 3;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int[] iArr = IA;
            int i12 = i5 + 4;
            int i13 = iArr[str.charAt(i5 + 3)] | (iArr[str.charAt(i5 + 1)] << 12) | (iArr[str.charAt(i5)] << 18) | (iArr[str.charAt(i5 + 2)] << 6);
            bArr[i10] = (byte) (i13 >> 16);
            int i14 = i10 + 2;
            bArr[i10 + 1] = (byte) (i13 >> 8);
            i10 += 3;
            bArr[i14] = (byte) i13;
            if (i3 <= 0 || (i11 = i11 + 1) != 19) {
                i5 = i12;
            } else {
                i5 += 6;
                i11 = 0;
            }
        }
        if (i10 < i8) {
            int i15 = 0;
            int i16 = 0;
            while (i5 <= i4 - i6) {
                i15 |= IA[str.charAt(i5)] << (18 - (i16 * 6));
                i16++;
                i5++;
            }
            int i17 = 16;
            while (i10 < i8) {
                bArr[i10] = (byte) (i15 >> i17);
                i17 -= 8;
                i10++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i2 && IA[str.charAt(i3) & 255] < 0) {
            i3++;
        }
        while (i2 > 0 && IA[str.charAt(i2) & 255] < 0) {
            i2--;
        }
        int i4 = str.charAt(i2) == '=' ? str.charAt(i2 + (-1)) == '=' ? 2 : 1 : 0;
        int i5 = (i2 - i3) + 1;
        if (length > 76) {
            i = (str.charAt(76) == '\r' ? i5 / 78 : 0) << 1;
        } else {
            i = 0;
        }
        int i6 = (((i5 - i) * 6) >> 3) - i4;
        byte[] bArr = new byte[i6];
        int i7 = (i6 / 3) * 3;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int[] iArr = IA;
            int i10 = i3 + 4;
            int i11 = iArr[str.charAt(i3 + 3)] | (iArr[str.charAt(i3 + 1)] << 12) | (iArr[str.charAt(i3)] << 18) | (iArr[str.charAt(i3 + 2)] << 6);
            bArr[i8] = (byte) (i11 >> 16);
            int i12 = i8 + 2;
            bArr[i8 + 1] = (byte) (i11 >> 8);
            i8 += 3;
            bArr[i12] = (byte) i11;
            if (i <= 0 || (i9 = i9 + 1) != 19) {
                i3 = i10;
            } else {
                i3 += 6;
                i9 = 0;
            }
        }
        if (i8 < i6) {
            int i13 = 0;
            int i14 = 0;
            while (i3 <= i2 - i4) {
                i13 |= IA[str.charAt(i3)] << (18 - (i14 * 6));
                i14++;
                i3++;
            }
            int i15 = 16;
            while (i8 < i6) {
                bArr[i8] = (byte) (i13 >> i15);
                i15 -= 8;
                i8++;
            }
        }
        return bArr;
    }
}

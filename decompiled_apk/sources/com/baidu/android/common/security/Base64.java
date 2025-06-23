package com.baidu.android.common.security;

import IIIxO.oIX0oI;
import com.garmin.fit.Fit;
import java.io.UnsupportedEncodingException;
import okio.Utf8;

/* loaded from: classes7.dex */
public final class Base64 {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    private Base64() {
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[length + (length / 76) + 3];
        int length2 = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length2; i3 += 3) {
            byte[] bArr3 = MAP;
            bArr2[i] = bArr3[(bArr[i3] & 255) >> 2];
            int i4 = i3 + 1;
            bArr2[i + 1] = bArr3[((bArr[i3] & 3) << 4) | ((bArr[i4] & 255) >> 4)];
            int i5 = i3 + 2;
            bArr2[i + 2] = bArr3[((bArr[i4] & 15) << 2) | ((bArr[i5] & 255) >> 6)];
            int i6 = i + 4;
            bArr2[i + 3] = bArr3[bArr[i5] & Utf8.REPLACEMENT_BYTE];
            if ((i6 - i2) % 76 == 0 && i6 != 0) {
                i += 5;
                bArr2[i6] = 10;
                i2++;
            } else {
                i = i6;
            }
        }
        int length3 = bArr.length % 3;
        if (length3 != 1) {
            if (length3 == 2) {
                byte[] bArr4 = MAP;
                bArr2[i] = bArr4[(bArr[length2] & 255) >> 2];
                int i7 = (bArr[length2] & 3) << 4;
                int i8 = length2 + 1;
                bArr2[i + 1] = bArr4[((bArr[i8] & 255) >> 4) | i7];
                int i9 = i + 3;
                bArr2[i + 2] = bArr4[(bArr[i8] & 15) << 2];
                i += 4;
                bArr2[i9] = oIX0oI.f236II0XooXoX;
            }
        } else {
            byte[] bArr5 = MAP;
            bArr2[i] = bArr5[(bArr[length2] & 255) >> 2];
            bArr2[i + 1] = bArr5[(bArr[length2] & 3) << 4];
            int i10 = i + 3;
            bArr2[i + 2] = oIX0oI.f236II0XooXoX;
            i += 4;
            bArr2[i10] = oIX0oI.f236II0XooXoX;
        }
        return new String(bArr2, 0, i, str);
    }

    public static byte[] decode(byte[] bArr, int i) {
        byte b;
        int i2;
        int i3 = (i / 4) * 3;
        if (i3 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i3];
        int i4 = i;
        int i5 = 0;
        while (true) {
            byte b2 = bArr[i4 - 1];
            b = 10;
            if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                if (b2 != 61) {
                    break;
                }
                i5++;
            }
            i4--;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < i4) {
            byte b3 = bArr[i6];
            if (b3 != b && b3 != 13 && b3 != 32 && b3 != 9) {
                if (b3 >= 65 && b3 <= 90) {
                    i2 = b3 + Fit.f11227x0OxxIOxX;
                } else if (b3 >= 97 && b3 <= 122) {
                    i2 = b3 - 71;
                } else if (b3 >= 48 && b3 <= 57) {
                    i2 = b3 + 4;
                } else if (b3 == 43) {
                    i2 = 62;
                } else {
                    if (b3 != 47) {
                        return null;
                    }
                    i2 = 63;
                }
                i7 = ((byte) i2) | (i7 << 6);
                if (i9 % 4 == 3) {
                    bArr2[i8] = (byte) ((16711680 & i7) >> 16);
                    int i10 = i8 + 2;
                    bArr2[i8 + 1] = (byte) ((65280 & i7) >> 8);
                    i8 += 3;
                    bArr2[i10] = (byte) (i7 & 255);
                }
                i9++;
            }
            i6++;
            b = 10;
        }
        if (i5 > 0) {
            int i11 = i7 << (i5 * 6);
            int i12 = i8 + 1;
            bArr2[i8] = (byte) ((i11 & 16711680) >> 16);
            if (i5 == 1) {
                i8 += 2;
                bArr2[i12] = (byte) ((i11 & 65280) >> 8);
            } else {
                i8 = i12;
            }
        }
        byte[] bArr3 = new byte[i8];
        System.arraycopy(bArr2, 0, bArr3, 0, i8);
        return bArr3;
    }
}

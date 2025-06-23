package com.goodix.ble.libcomx.util;

/* loaded from: classes9.dex */
public class HexEndian {
    public static int changeEndian(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 << 8) | (i & 255);
            i >>= 8;
        }
        return i3;
    }

    public static int fromByte(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i + i2;
        int i4 = 0;
        if (bArr != null && i >= 0 && i2 >= 0) {
            if (i3 > bArr.length) {
                i3 = bArr.length;
            }
            if (z) {
                while (i < i3) {
                    i4 = (i4 << 8) | (bArr[i] & 255);
                    i++;
                }
            } else {
                for (int i5 = i3 - 1; i5 >= i; i5--) {
                    i4 = (i4 << 8) | (bArr[i5] & 255);
                }
            }
        }
        return i4;
    }

    public static long fromByteLong(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i + i2;
        long j = 0;
        if (bArr != null && i >= 0 && i2 >= 0) {
            if (i3 > bArr.length) {
                i3 = bArr.length;
            }
            if (z) {
                while (i < i3) {
                    j = (j << 8) | (bArr[i] & 255);
                    i++;
                }
            } else {
                for (int i4 = i3 - 1; i4 >= i; i4--) {
                    j = (j << 8) | (bArr[i4] & 255);
                }
            }
        }
        return j;
    }

    public static byte[] toByte(int i, byte[] bArr, int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        if (bArr != null && i2 >= 0 && i3 >= 0) {
            if (i4 > bArr.length) {
                i4 = bArr.length;
            }
            if (z) {
                for (int i5 = i4 - 1; i5 >= i2; i5--) {
                    bArr[i5] = (byte) (i & 255);
                    i >>= 8;
                }
            } else {
                while (i2 < i4) {
                    bArr[i2] = (byte) (i & 255);
                    i >>= 8;
                    i2++;
                }
            }
        }
        return bArr;
    }

    public static byte[] toByteLong(long j, byte[] bArr, int i, int i2, boolean z) {
        int i3 = i + i2;
        if (bArr != null && i >= 0 && i2 >= 0) {
            if (i3 > bArr.length) {
                i3 = bArr.length;
            }
            if (z) {
                for (int i4 = i3 - 1; i4 >= i; i4--) {
                    bArr[i4] = (byte) (j & 255);
                    j >>= 8;
                }
            } else {
                while (i < i3) {
                    bArr[i] = (byte) (j & 255);
                    j >>= 8;
                    i++;
                }
            }
        }
        return bArr;
    }
}

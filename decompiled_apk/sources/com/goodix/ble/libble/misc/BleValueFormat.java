package com.goodix.ble.libble.misc;

/* loaded from: classes9.dex */
public class BleValueFormat {
    private static int a(int i, int i2) {
        int i3 = 1 << (i2 - 1);
        return (i & i3) != 0 ? (i3 - (i & (i3 - 1))) * (-1) : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static float getFloatValue(byte[] bArr, int i, int i2) {
        int a2;
        int a3;
        int i3;
        int i4;
        if (i + i2 > bArr.length) {
            return 0.0f;
        }
        if (i2 == 2) {
            int i5 = bArr[i] & 255;
            int i6 = i + 1;
            a2 = a(i5 + ((bArr[i6] & 15) << 8), 12);
            a3 = a((bArr[i6] & 255) >> 4, 4);
        } else {
            if (i2 != 4) {
                i4 = 0;
                i3 = 0;
                return (float) (i4 * Math.pow(10.0d, i3));
            }
            a2 = a((bArr[i] & 255) + ((bArr[i + 1] & 255) << 8) + ((bArr[i + 2] & 255) << 16), 24);
            a3 = bArr[i + 3];
        }
        i3 = a3;
        i4 = a2;
        return (float) (i4 * Math.pow(10.0d, i3));
    }

    public static String getStringValue(byte[] bArr, int i) {
        if (bArr == null || i > bArr.length) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length - i];
        for (int i2 = 0; i2 != bArr.length - i; i2++) {
            bArr2[i2] = bArr[i + i2];
        }
        return new String(bArr2);
    }
}

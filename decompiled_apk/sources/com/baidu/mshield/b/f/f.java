package com.baidu.mshield.b.f;

/* loaded from: classes7.dex */
public class f {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return c(bArr, bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            return c(bArr, bArr2);
        }
        return null;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] a2 = a(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte b = a2[i];
            i2 = ((b & 255) + i2) & 255;
            a2[i] = a2[i2];
            a2[i2] = b;
            int i4 = ((a2[i] & 255) + (b & 255)) & 255;
            byte b2 = (byte) (a2[i4] ^ bArr[i3]);
            bArr3[i3] = b2;
            bArr3[i3] = (byte) (b2 ^ 42);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            int i5 = bArr[i2] & 255;
            byte b = bArr2[i4];
            i3 = (i5 + (b & 255) + i3) & 255;
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b;
            i2 = (i2 + 1) % bArr.length;
        }
        return bArr2;
    }
}

package com.kwad.components.core.e.b;

import java.nio.ByteBuffer;

/* loaded from: classes11.dex */
public final class c {
    private final int[] KE;

    private c(int[] iArr) {
        this.KE = iArr;
    }

    public static c a(int[] iArr) {
        return new c(iArr);
    }

    private static long b(long j, int[] iArr) {
        int i = 31;
        while (i > 23) {
            j = d(i, iArr, j);
            i--;
        }
        while (i > 15) {
            j = c(i, iArr, j);
            i--;
        }
        while (i > 7) {
            j = d(i, iArr, j);
            i--;
        }
        while (i >= 0) {
            j = c(i, iArr, j);
            i--;
        }
        return j;
    }

    private static long c(int i, int[] iArr, long j) {
        long j2 = (j >> 32) & 65535;
        long j3 = (j >> 16) & 65535;
        return ((i + 1) ^ ((j >>> 48) ^ j2)) | ((j & 65535) << 16) | (f(i, iArr, j2) << 48) | (j3 << 32);
    }

    private static long d(int i, int[] iArr, long j) {
        long j2 = (j >> 32) & 65535;
        return (((i + 1) ^ (f(i, iArr, j2) ^ ((j >> 16) & 65535))) << 32) | (f(i, iArr, j2) << 48) | ((j & 65535) << 16) | (j >>> 48);
    }

    private static long e(int i, int[] iArr, long j) {
        int i2 = (int) (j >>> 8);
        int i3 = (int) (j & 255);
        int i4 = i * 4;
        int i5 = iArr[i4 % 10];
        int i6 = iArr[(i4 + 1) % 10];
        int i7 = iArr[(i4 + 2) % 10];
        int i8 = iArr[(i4 + 3) % 10];
        int[] iArr2 = b.KD;
        int i9 = iArr2[i5 ^ i3] ^ i2;
        return ((i9 ^ iArr2[(i3 ^ iArr2[i6 ^ i9]) ^ i7]) << 8) | (iArr2[i8 ^ r7] ^ r8);
    }

    private static long f(int i, int[] iArr, long j) {
        int i2 = (int) (255 & j);
        int i3 = (int) (j >>> 8);
        int i4 = i * 4;
        int i5 = iArr[(i4 + 3) % 10];
        int i6 = iArr[(i4 + 2) % 10];
        int i7 = iArr[(i4 + 1) % 10];
        int i8 = iArr[i4 % 10];
        int[] iArr2 = b.KD;
        int i9 = iArr2[i5 ^ i3] ^ i2;
        return ((iArr2[i8 ^ r6] ^ r7) << 8) | (i9 ^ iArr2[(i3 ^ iArr2[i9 ^ i6]) ^ i7]);
    }

    public final long ae(String str) {
        byte[] decode = com.kwad.sdk.core.a.c.Ef().decode(str);
        if (decode != null && decode.length == 8) {
            return b(ByteBuffer.wrap(decode).getLong(), this.KE);
        }
        throw new RuntimeException("fail to decode: " + str);
    }

    public final String u(long j) {
        return com.kwad.sdk.core.a.c.Ed().encodeToString(ByteBuffer.allocate(8).putLong(a(j, this.KE)).array());
    }

    private static long a(long j, int[] iArr) {
        int i = 0;
        while (i < 8) {
            j = a(i, iArr, j);
            i++;
        }
        while (i < 16) {
            j = b(i, iArr, j);
            i++;
        }
        while (i < 24) {
            j = a(i, iArr, j);
            i++;
        }
        while (i < 32) {
            j = b(i, iArr, j);
            i++;
        }
        return j;
    }

    private static long b(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 16) & 65535;
        long e = e(i, iArr, j2);
        return (((i + 1) ^ (j2 ^ ((j >> 32) & 65535))) << 16) | ((j & 65535) << 48) | (e << 32) | j3;
    }

    private static long a(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & 65535;
        return (e(i, iArr, j2) << 32) | ((((j & 65535) ^ e(i, iArr, j2)) ^ (i + 1)) << 48) | (j3 << 16) | ((j >> 16) & 65535);
    }
}

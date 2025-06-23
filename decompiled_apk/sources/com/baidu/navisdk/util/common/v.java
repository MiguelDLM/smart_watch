package com.baidu.navisdk.util.common;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes8.dex */
public class v {
    static final byte[] e = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    private long[] f9252a = new long[4];
    private long[] b = new long[2];
    private byte[] c = new byte[64];
    private byte[] d = new byte[16];

    public v() {
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long a(byte r2) {
        /*
            if (r2 >= 0) goto L4
            r2 = r2 & 255(0xff, float:3.57E-43)
        L4:
            long r0 = (long) r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.common.v.a(byte):long");
    }

    private long b(long j, long j2, long j3) {
        return (j & j3) | (j2 & (~j3));
    }

    private long c(long j, long j2, long j3) {
        return (j ^ j2) ^ j3;
    }

    private long d(long j, long j2, long j3) {
        return (j | (~j3)) ^ j2;
    }

    private long a(long j, long j2, long j3) {
        return ((~j) & j3) | (j2 & j);
    }

    private void b() {
        long[] jArr = this.b;
        jArr[0] = 0;
        jArr[1] = 0;
        long[] jArr2 = this.f9252a;
        jArr2[0] = 1732584193;
        jArr2[1] = 4023233417L;
        jArr2[2] = 2562383102L;
        jArr2[3] = 271733878;
    }

    private long c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        int c = (int) (c(j2, j3, j4) + j5 + j7 + j);
        return ((c >>> ((int) (32 - j6))) | (c << ((int) j6))) + j2;
    }

    private long d(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        int d = (int) (d(j2, j3, j4) + j5 + j7 + j);
        return ((d >>> ((int) (32 - j6))) | (d << ((int) j6))) + j2;
    }

    public static String c(byte b) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        return new String(new char[]{cArr[(b >>> 4) & 15], cArr[b & 15]});
    }

    public byte[] a(byte[] bArr) {
        b();
        a(bArr, bArr.length);
        a();
        return this.d;
    }

    private long a(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        int a2 = (int) (a(j2, j3, j4) + j5 + j7 + j);
        return ((a2 >>> ((int) (32 - j6))) | (a2 << ((int) j6))) + j2;
    }

    private void a(byte[] bArr, int i) {
        int i2;
        byte[] bArr2 = new byte[64];
        long[] jArr = this.b;
        long j = jArr[0];
        int i3 = ((int) (j >>> 3)) & 63;
        long j2 = i << 3;
        long j3 = j + j2;
        jArr[0] = j3;
        if (j3 < j2) {
            jArr[1] = jArr[1] + 1;
        }
        jArr[1] = jArr[1] + (i >>> 29);
        int i4 = 64 - i3;
        if (i >= i4) {
            a(this.c, bArr, i3, 0, i4);
            b(this.c);
            while (i4 + 63 < i) {
                a(bArr2, bArr, 0, i4, 64);
                b(bArr2);
                i4 += 64;
            }
            i2 = i4;
            i3 = 0;
        } else {
            i2 = 0;
        }
        a(this.c, bArr, i3, i2, i - i2);
    }

    private long b(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        int b = (int) (b(j2, j3, j4) + j5 + j7 + j);
        return ((b >>> ((int) (32 - j6))) | (b << ((int) j6))) + j2;
    }

    private void b(byte[] bArr) {
        long[] jArr = this.f9252a;
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long[] jArr2 = new long[16];
        a(jArr2, bArr, 64);
        long a2 = a(j, j2, j3, j4, jArr2[0], 7L, 3614090360L);
        long a3 = a(j4, a2, j2, j3, jArr2[1], 12L, 3905402710L);
        long a4 = a(j3, a3, a2, j2, jArr2[2], 17L, 606105819L);
        long a5 = a(j2, a4, a3, a2, jArr2[3], 22L, 3250441966L);
        long a6 = a(a2, a5, a4, a3, jArr2[4], 7L, 4118548399L);
        long a7 = a(a3, a6, a5, a4, jArr2[5], 12L, 1200080426L);
        long a8 = a(a4, a7, a6, a5, jArr2[6], 17L, 2821735955L);
        long a9 = a(a5, a8, a7, a6, jArr2[7], 22L, 4249261313L);
        long a10 = a(a6, a9, a8, a7, jArr2[8], 7L, 1770035416L);
        long a11 = a(a7, a10, a9, a8, jArr2[9], 12L, 2336552879L);
        long a12 = a(a8, a11, a10, a9, jArr2[10], 17L, 4294925233L);
        long a13 = a(a9, a12, a11, a10, jArr2[11], 22L, 2304563134L);
        long a14 = a(a10, a13, a12, a11, jArr2[12], 7L, 1804603682L);
        long a15 = a(a11, a14, a13, a12, jArr2[13], 12L, 4254626195L);
        long a16 = a(a12, a15, a14, a13, jArr2[14], 17L, 2792965006L);
        long a17 = a(a13, a16, a15, a14, jArr2[15], 22L, 1236535329L);
        long b = b(a14, a17, a16, a15, jArr2[1], 5L, 4129170786L);
        long b2 = b(a15, b, a17, a16, jArr2[6], 9L, 3225465664L);
        long b3 = b(a16, b2, b, a17, jArr2[11], 14L, 643717713L);
        long b4 = b(a17, b3, b2, b, jArr2[0], 20L, 3921069994L);
        long b5 = b(b, b4, b3, b2, jArr2[5], 5L, 3593408605L);
        long b6 = b(b2, b5, b4, b3, jArr2[10], 9L, 38016083L);
        long b7 = b(b3, b6, b5, b4, jArr2[15], 14L, 3634488961L);
        long b8 = b(b4, b7, b6, b5, jArr2[4], 20L, 3889429448L);
        long b9 = b(b5, b8, b7, b6, jArr2[9], 5L, 568446438L);
        long b10 = b(b6, b9, b8, b7, jArr2[14], 9L, 3275163606L);
        long b11 = b(b7, b10, b9, b8, jArr2[3], 14L, 4107603335L);
        long b12 = b(b8, b11, b10, b9, jArr2[8], 20L, 1163531501L);
        long b13 = b(b9, b12, b11, b10, jArr2[13], 5L, 2850285829L);
        long b14 = b(b10, b13, b12, b11, jArr2[2], 9L, 4243563512L);
        long b15 = b(b11, b14, b13, b12, jArr2[7], 14L, 1735328473L);
        long b16 = b(b12, b15, b14, b13, jArr2[12], 20L, 2368359562L);
        long c = c(b13, b16, b15, b14, jArr2[5], 4L, 4294588738L);
        long c2 = c(b14, c, b16, b15, jArr2[8], 11L, 2272392833L);
        long c3 = c(b15, c2, c, b16, jArr2[11], 16L, 1839030562L);
        long c4 = c(b16, c3, c2, c, jArr2[14], 23L, 4259657740L);
        long c5 = c(c, c4, c3, c2, jArr2[1], 4L, 2763975236L);
        long c6 = c(c2, c5, c4, c3, jArr2[4], 11L, 1272893353L);
        long c7 = c(c3, c6, c5, c4, jArr2[7], 16L, 4139469664L);
        long c8 = c(c4, c7, c6, c5, jArr2[10], 23L, 3200236656L);
        long c9 = c(c5, c8, c7, c6, jArr2[13], 4L, 681279174L);
        long c10 = c(c6, c9, c8, c7, jArr2[0], 11L, 3936430074L);
        long c11 = c(c7, c10, c9, c8, jArr2[3], 16L, 3572445317L);
        long c12 = c(c8, c11, c10, c9, jArr2[6], 23L, 76029189L);
        long c13 = c(c9, c12, c11, c10, jArr2[9], 4L, 3654602809L);
        long c14 = c(c10, c13, c12, c11, jArr2[12], 11L, 3873151461L);
        long c15 = c(c11, c14, c13, c12, jArr2[15], 16L, 530742520L);
        long c16 = c(c12, c15, c14, c13, jArr2[2], 23L, 3299628645L);
        long d = d(c13, c16, c15, c14, jArr2[0], 6L, 4096336452L);
        long d2 = d(c14, d, c16, c15, jArr2[7], 10L, 1126891415L);
        long d3 = d(c15, d2, d, c16, jArr2[14], 15L, 2878612391L);
        long d4 = d(c16, d3, d2, d, jArr2[5], 21L, 4237533241L);
        long d5 = d(d, d4, d3, d2, jArr2[12], 6L, 1700485571L);
        long d6 = d(d2, d5, d4, d3, jArr2[3], 10L, 2399980690L);
        long d7 = d(d3, d6, d5, d4, jArr2[10], 15L, 4293915773L);
        long d8 = d(d4, d7, d6, d5, jArr2[1], 21L, 2240044497L);
        long d9 = d(d5, d8, d7, d6, jArr2[8], 6L, 1873313359L);
        long d10 = d(d6, d9, d8, d7, jArr2[15], 10L, 4264355552L);
        long d11 = d(d7, d10, d9, d8, jArr2[6], 15L, 2734768916L);
        long d12 = d(d8, d11, d10, d9, jArr2[13], 21L, 1309151649L);
        long d13 = d(d9, d12, d11, d10, jArr2[4], 6L, 4149444226L);
        long d14 = d(d10, d13, d12, d11, jArr2[11], 10L, 3174756917L);
        long d15 = d(d11, d14, d13, d12, jArr2[2], 15L, 718787259L);
        long d16 = d(d12, d15, d14, d13, jArr2[9], 21L, 3951481745L);
        long[] jArr3 = this.f9252a;
        jArr3[0] = jArr3[0] + d13;
        jArr3[1] = jArr3[1] + d16;
        jArr3[2] = jArr3[2] + d15;
        jArr3[3] = jArr3[3] + d14;
    }

    private void a() {
        byte[] bArr = new byte[8];
        a(bArr, this.b, 8);
        int i = ((int) (this.b[0] >>> 3)) & 63;
        a(e, i < 56 ? 56 - i : 120 - i);
        a(bArr, 8);
        a(this.d, this.f9252a, 16);
    }

    private void a(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i + i4] = bArr2[i2 + i4];
        }
    }

    private void a(byte[] bArr, long[] jArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            long j = jArr[i2];
            bArr[i3] = (byte) (j & 255);
            bArr[i3 + 1] = (byte) ((j >>> 8) & 255);
            bArr[i3 + 2] = (byte) ((j >>> 16) & 255);
            bArr[i3 + 3] = (byte) ((j >>> 24) & 255);
            i2++;
        }
    }

    private void a(long[] jArr, byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            jArr[i2] = a(bArr[i3]) | (a(bArr[i3 + 1]) << 8) | (a(bArr[i3 + 2]) << 16) | (a(bArr[i3 + 3]) << 24);
            i2++;
        }
    }

    public static String a(String str, String str2) {
        byte[] bytes;
        try {
            bytes = str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] a2 = new v().a(bytes);
        String str3 = "";
        for (int i = 0; i < 16; i++) {
            str3 = str3 + b(a2[i]);
        }
        return str3;
    }

    public static String a(String str) {
        MessageDigest messageDigest;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes();
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        messageDigest.update(bytes);
        try {
            byte[] digest = messageDigest.digest();
            String str2 = "";
            for (byte b : digest) {
                str2 = str2 + c(b);
            }
            return str2;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String b(byte b) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b >>> 4) & 15], cArr[b & 15]});
    }

    public static String b(String str) {
        return a(str, "ISO8859_1");
    }
}

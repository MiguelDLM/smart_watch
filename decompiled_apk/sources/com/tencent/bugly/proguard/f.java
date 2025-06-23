package com.tencent.bugly.proguard;

/* loaded from: classes13.dex */
public final class f {
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f26608a = new byte[0];

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i = 0; i < bArr.length; i++) {
                byte b2 = bArr[i];
                int i2 = i * 2;
                char[] cArr2 = b;
                cArr[i2 + 1] = cArr2[b2 & 15];
                cArr[i2] = cArr2[((byte) (b2 >>> 4)) & 15];
            }
            return new String(cArr);
        }
        return null;
    }
}

package com.baidu.mshield.x6.e;

import java.util.Random;

/* loaded from: classes7.dex */
public class h {
    public static String a(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = com.baidu.mshield.b.f.a.b(bArr, bArr2)) != null) {
                    if (bArr3.length > 0) {
                        return bArr3;
                    }
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
        return bArr3;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = com.baidu.mshield.b.f.f.b(bArr, bArr2)) != null) {
                    if (bArr3.length > 0) {
                        return bArr3;
                    }
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
        return bArr3;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = com.baidu.mshield.b.f.f.a(bArr, bArr2)) != null) {
                    if (bArr3.length > 0) {
                        return bArr3;
                    }
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = com.baidu.mshield.b.f.a.a(bArr, bArr2)) != null) {
                    if (bArr3.length > 0) {
                        return bArr3;
                    }
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
        return bArr3;
    }
}

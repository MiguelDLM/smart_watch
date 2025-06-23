package com.baidu.sec.privacy.d;

import android.util.Base64;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f10019a;

    public static String a(byte[] bArr) {
        byte[] a2;
        if (bArr != null) {
            try {
                if (bArr.length != 0 && (a2 = a(a(), bArr)) != null && a2.length > 0) {
                    return Base64.encodeToString(a2, 0);
                }
                return null;
            } catch (Throwable th) {
                c.a(th);
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            return com.baidu.xclient.gdid.a.b(bArr2, bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return com.baidu.xclient.gdid.a.a(bArr2, bArr);
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new String(b(a(), Base64.decode(str, 0)));
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    public static synchronized byte[] a() {
        byte[] bArr;
        byte[] bArr2;
        synchronized (a.class) {
            try {
                bArr2 = f10019a;
            } finally {
                return bArr;
            }
            if (bArr2 != null) {
                if (bArr2.length != 16) {
                }
                bArr = f10019a;
            }
            f10019a = Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 74, 107, 97, 87, 78, 49, 90, 71, 108, 104, 89, 103, IIIxO.oIX0oI.f236II0XooXoX, IIIxO.oIX0oI.f236II0XooXoX}, 0);
            bArr = f10019a;
        }
        return bArr;
    }
}

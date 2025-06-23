package com.baidu.xclient.gdid.jni;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.xclient.gdid.e.d;
import java.security.SecureRandom;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f10239a;
    public Native b = new Native();
    public Context c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public c(Context context) {
        this.c = context;
    }

    public static c a(Context context) {
        if (f10239a == null) {
            synchronized (c.class) {
                try {
                    if (f10239a == null) {
                        f10239a = new c(context);
                    }
                } finally {
                }
            }
        }
        return f10239a;
    }

    public String b() {
        String str = null;
        try {
            str = (String) this.b.jnictl(6, null, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        return str == null ? "" : str;
    }

    public int c() {
        String str = null;
        try {
            str = (String) this.b.jnictl(7, null, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        if (str == null) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    public String d() {
        String str = null;
        try {
            str = (String) this.b.jnictl(14, null, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public String e() {
        try {
            return (String) this.b.jnictl(17, null, null, null);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public String f() {
        if (!com.baidu.sec.privacy.c.a.a(this.c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = c("ro.product.manufacturer");
        }
        if (TextUtils.isEmpty(this.d)) {
            this.d = Build.MANUFACTURER;
        }
        return this.d;
    }

    public String g() {
        if (!com.baidu.sec.privacy.c.a.a(this.c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.e)) {
            this.e = c("ro.product.name");
        }
        if (TextUtils.isEmpty(this.e)) {
            this.e = Build.PRODUCT;
        }
        return this.e;
    }

    public String h() {
        if (!com.baidu.sec.privacy.c.a.a(this.c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.f)) {
            this.f = c("ro.hardware");
        }
        if (TextUtils.isEmpty(this.f)) {
            this.f = Build.HARDWARE;
        }
        return this.f;
    }

    public String i() {
        if (!com.baidu.sec.privacy.c.a.a(this.c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.g)) {
            this.g = c("ro.product.device");
        }
        if (TextUtils.isEmpty(this.g)) {
            this.g = Build.DEVICE;
        }
        return this.g;
    }

    public String j() {
        if (!com.baidu.sec.privacy.c.a.a(this.c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.h)) {
            this.h = c("ro.product.board");
        }
        if (TextUtils.isEmpty(this.h)) {
            this.h = Build.BOARD;
        }
        return this.h;
    }

    public String k() {
        if (!com.baidu.sec.privacy.c.a.a(this.c).a()) {
            return "";
        }
        if (TextUtils.isEmpty(this.i)) {
            this.i = c("ro.product.brand");
        }
        if (TextUtils.isEmpty(this.i)) {
            this.i = Build.BRAND;
        }
        return this.i;
    }

    public Object a(int i, Object obj, Object obj2, Object obj3) {
        try {
            return this.b.jnictl(i, obj, obj2, obj3);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public String b(String str) {
        String str2 = null;
        try {
            byte[] bArr = (byte[]) this.b.jnictl(9, str, null, null);
            if (bArr != null) {
                str2 = new String(bArr);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return str2 == null ? "" : str2;
    }

    public String c(String str) {
        String str2 = null;
        try {
            str2 = (String) this.b.jnictl(10, str, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        return str2 == null ? "" : str2;
    }

    public String d(String str) {
        String str2 = null;
        try {
            str2 = (String) this.b.jnictl(11, str, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        return str2 == null ? "" : str2;
    }

    public String e(String str) {
        String str2;
        try {
            str2 = (String) this.b.jnictl(13, str, null, null);
        } catch (Throwable th) {
            d.a(th);
            str2 = "";
        }
        return TextUtils.isEmpty(str2) ? "|" : str2;
    }

    public String a() {
        return this.b.a();
    }

    public String a(String str) {
        String str2 = null;
        try {
            str2 = (String) this.b.jnictl(8, str, null, null);
        } catch (Throwable th) {
            d.a(th);
        }
        return str2 == null ? "" : str2;
    }

    public byte[] a(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    byte[] bArr2 = new byte[8];
                    new SecureRandom().nextBytes(bArr2);
                    byte[] bArr3 = new byte[bArr.length + 8];
                    System.arraycopy(bArr2, 0, bArr3, 0, 8);
                    System.arraycopy(bArr, 0, bArr3, 8, bArr.length);
                    return (byte[]) this.b.jnictl(12, bArr3, null, null);
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
        return null;
    }
}

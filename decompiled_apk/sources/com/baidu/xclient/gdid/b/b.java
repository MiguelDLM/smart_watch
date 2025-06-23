package com.baidu.xclient.gdid.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.d;
import com.baidu.mshield.b.f.e;
import com.baidu.xclient.gdid.c;
import com.baidu.xclient.gdid.g;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f10224a;
    public String b = g.f10235a;

    public b(Context context) {
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            bVar = new b(context);
        }
        return bVar;
    }

    public final void b() {
        try {
            f10224a = new String(d.b(Base64.decode(this.b, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
    }

    public final String a() {
        if (TextUtils.isEmpty(f10224a)) {
            b();
        }
        return f10224a;
    }

    public String a(String str, String str2) {
        String str3 = c.c;
        String str4 = c.d;
        String str5 = "";
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        try {
            str5 = a(str3, str4, currentTimeMillis);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
        sb.append(a());
        sb.append(str);
        sb.append(250);
        sb.append("/");
        sb.append(str3);
        sb.append("/");
        sb.append(currentTimeMillis);
        sb.append("/");
        sb.append(str5);
        sb.append("?skey=");
        sb.append(str2);
        return sb.toString();
    }

    public String a(String str, String str2, long j) {
        try {
            return e.a(str + j + str2);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
            return "";
        }
    }

    public byte[] a(byte[] bArr, String str) {
        byte[] bArr2;
        try {
            bArr2 = com.baidu.mshield.b.a.c.a(str.getBytes("utf-8"));
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
            bArr2 = null;
        }
        return d.a(bArr2, bArr);
    }
}

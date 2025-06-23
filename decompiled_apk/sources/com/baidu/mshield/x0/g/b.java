package com.baidu.mshield.x0.g;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.x0.b.d;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f6418a;
    public String b = "";

    public b(Context context) {
        this.f6418a = context;
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            bVar = new b(context);
        }
        return bVar;
    }

    public String b(String str) {
        StringBuilder sb = new StringBuilder();
        String c = d.c();
        sb.append(a("p/1/r", str));
        sb.append("&msg_id=" + c);
        return sb.toString();
    }

    public final String a() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        String a2 = d.a(this.f6418a);
        if (!TextUtils.isEmpty(a2)) {
            this.b = a2;
        }
        return this.b;
    }

    public byte[] a(byte[] bArr, String str) {
        byte[] bArr2 = null;
        try {
            bArr2 = com.baidu.mshield.b.a.c.a(str.getBytes("utf-8"));
            return com.baidu.mshield.b.f.d.a(bArr2, bArr);
        } catch (Throwable th) {
            d.a(th);
            return bArr2;
        }
    }

    public String a(String str) {
        return a("s/5/aio", str);
    }

    public final String a(String str, String str2, String str3) {
        String str4;
        try {
            String c = d.c(this.f6418a);
            String d = d.d(this.f6418a);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                str4 = d.a(c, d, currentTimeMillis);
            } catch (Throwable th) {
                d.a(th);
                str4 = "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a());
            stringBuffer.append(str);
            stringBuffer.append("/250");
            stringBuffer.append("/" + c);
            stringBuffer.append("/" + currentTimeMillis);
            stringBuffer.append("/" + str4);
            stringBuffer.append("?skey=" + str2);
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("&page=" + str3);
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            d.a(th2);
            return "";
        }
    }

    public final String a(String str, String str2) {
        return a(str, str2, "");
    }
}

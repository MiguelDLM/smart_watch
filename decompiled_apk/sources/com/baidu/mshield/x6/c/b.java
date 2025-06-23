package com.baidu.mshield.x6.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.utility.c;
import com.baidu.mshield.x6.e.f;
import com.baidu.mshield.x6.e.h;
import java.net.URLEncoder;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f6429a;
    public String b = "";

    public b(Context context) {
        this.f6429a = context;
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            bVar = new b(context);
        }
        return bVar;
    }

    public String b(String str) {
        return a() + e("c/11/z") + "?skey=" + c(str);
    }

    public String c(String str) {
        return URLEncoder.encode(Base64.encodeToString(h.c(str.getBytes(), e.a(c.a(this.f6429a)).getBytes()), 0));
    }

    public String d(String str) {
        return a() + e("f/2/sig") + "?skey=" + c(str);
    }

    public final String e(String str) {
        String str2;
        try {
            String a2 = f.a();
            String b = f.b();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                str2 = f.a(a2, b, currentTimeMillis);
            } catch (Throwable th) {
                f.a(th);
                str2 = "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("/250");
            stringBuffer.append("/" + a2);
            stringBuffer.append("/" + currentTimeMillis);
            stringBuffer.append("/" + str2);
            return stringBuffer.toString();
        } catch (Throwable th2) {
            f.a(th2);
            return "";
        }
    }

    public final String a() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        String a2 = f.a(this.f6429a);
        if (!TextUtils.isEmpty(a2)) {
            this.b = a2;
        }
        return this.b;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        if (com.baidu.mshield.x6.b.b.a()) {
            sb.append(e("f/2/ejc"));
        } else {
            sb.append(e("f/2/jc"));
        }
        sb.append("?skey=");
        sb.append(c(str));
        return sb.toString();
    }
}

package com.baidu.sec.privacy.a;

import android.content.Context;
import com.baidu.sec.privacy.b.d;
import com.baidu.sec.privacy.d.c;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f10007a;
    public static boolean b;
    public static com.baidu.sec.privacy.a c;
    public static com.baidu.sec.privacy.b d;
    public static boolean e;

    public static com.baidu.sec.privacy.a a() {
        return c;
    }

    public static Context b() {
        return f10007a;
    }

    public static boolean c() {
        return e;
    }

    public static com.baidu.sec.privacy.b d() {
        return d;
    }

    public static void a(Context context, String str, com.baidu.sec.privacy.a aVar) {
        c = aVar;
        a(context, str);
    }

    public static void a(Context context, String str) {
        if (b) {
            return;
        }
        try {
            e = false;
            a(context, str, false, null);
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static void a(Context context, String str, boolean z, com.baidu.sec.privacy.b bVar) {
        if (b) {
            return;
        }
        try {
            b = true;
            f10007a = context.getApplicationContext();
            d = bVar;
            e = z;
            d.a(str, z, bVar);
            com.baidu.sec.privacy.b.a.a(str);
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static a a(Context context) {
        return com.baidu.sec.privacy.c.a.a(context);
    }

    public static void a(boolean z) {
        try {
            c.a(z);
        } catch (Throwable th) {
            c.a(th);
        }
    }
}

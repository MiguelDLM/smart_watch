package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.c;

/* loaded from: classes7.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6228a = "PluginLoader";
    private static ClassLoader b;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public static void a(double d, an.b bVar, a aVar) {
        s sVar = (s) c.a().a(c.a.f6266a).a();
        if (sVar != null) {
            sVar.startLoadRemotePhp(d, bVar);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public static void b(int i) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.b(i);
        }
    }

    public static Activity c() {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            return tVar.c();
        }
        return null;
    }

    public static boolean d() {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            return tVar.d();
        }
        return false;
    }

    public static boolean e() {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            return tVar.e();
        }
        return false;
    }

    public static boolean f() {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            return tVar.f();
        }
        az.c().e("未能初始化小说sdk，请检查小说包和广告sdk是否匹配");
        return false;
    }

    public static void g() {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.g();
        }
    }

    public static void h() {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.a();
        }
    }

    public static void b() {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.b();
        }
    }

    public static boolean a() {
        return co.d.booleanValue();
    }

    public static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        s sVar;
        if (!a()) {
            return classLoader;
        }
        if (b == null && (sVar = (s) c.a().a(c.a.f6266a).a()) != null) {
            b = sVar.getClassLoaderFromJar(str, str2, str3, classLoader);
        }
        return b;
    }

    public static void b(int i, int i2) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.a(i, i2);
        }
    }

    public static void a(Context context, String str, String str2) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.a(context, str, str2);
        }
    }

    public static void a(u uVar) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.a(uVar);
        }
    }

    public static void a(int i) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.a(i);
        }
    }

    public static void a(int i, boolean z) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.a(i, z);
        }
    }

    public static View a(Context context) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            return tVar.a(context);
        }
        return null;
    }

    public static void a(Context context, String str) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.a(context, str);
        }
    }

    public static void a(boolean z) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.a(z);
        }
    }

    public static void a(int i, int i2) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.b(i, i2);
        }
    }

    public static void a(boolean z, int i, int i2, int i3) {
        t tVar = (t) c.a().a(c.a.b).a();
        if (tVar != null) {
            tVar.a(z, i, i2, i3);
        }
    }
}

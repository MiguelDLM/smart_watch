package com.baidu.sec.privacy.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.ac.F;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f10010a = false;
    public static String b = "";
    public static String c = "";

    public static boolean a() {
        try {
            SharedPreferences b2 = b();
            if (b2 == null) {
                b2 = com.baidu.sec.privacy.a.b.b().getSharedPreferences("leroadcfg", 0);
            }
            return b2.getBoolean("s_a_pl", false);
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return false;
        }
    }

    public static SharedPreferences b() {
        return b("getPlatformSharedSharedPreferences");
    }

    public static SharedPreferences c() {
        return b("getPlatformPrivateSharedPreferences");
    }

    public static SharedPreferences b(String str) {
        try {
            return (SharedPreferences) F.class.getDeclaredMethod(str, Context.class).invoke(F.class.getDeclaredMethod("getInstance", null).invoke(F.class, null), com.baidu.sec.privacy.a.b.b());
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return null;
        }
    }

    public static boolean a(String str) {
        try {
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
        }
        if (f10010a) {
            return true;
        }
        if (com.baidu.sec.privacy.a.b.c()) {
            com.baidu.sec.privacy.b d = com.baidu.sec.privacy.a.b.d();
            if (d != null) {
                f10010a = d.a();
            }
            return f10010a;
        }
        com.baidu.sec.privacy.a a2 = com.baidu.sec.privacy.a.b.a();
        if (a2 != null) {
            boolean a3 = a2.a();
            f10010a = a3;
            return a3;
        }
        try {
            Class<?> cls = Class.forName("com.baidu." + str + ".ac.F");
            Method method = null;
            Object invoke = cls.getDeclaredMethod("getInstance", null).invoke(cls, null);
            Method[] declaredMethods = Class.forName("com.baidu." + str + ".ac.FI").getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method2 = declaredMethods[i];
                if ("cp".equals(method2.getName())) {
                    method = method2;
                    break;
                }
                i++;
            }
            if (method == null) {
                f10010a = a();
            } else {
                f10010a = ((Boolean) method.invoke(invoke, com.baidu.sec.privacy.a.b.b())).booleanValue();
            }
        } catch (Throwable unused) {
            f10010a = a();
        }
        return f10010a;
    }

    public static String a(String str, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences c2 = c();
            if (c2 == null) {
                c2 = com.baidu.sec.privacy.a.b.b().getSharedPreferences(c, 0);
            }
            c2.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            return c2.getString(b, "");
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return "";
        }
    }

    public static void a(String str, boolean z, com.baidu.sec.privacy.b bVar) {
        try {
            if (!z) {
                if ("sofire".equals(str)) {
                    str = "";
                }
                c = "leroad" + str + "cfg";
                b = "p_s_p_c";
            } else {
                if (bVar == null) {
                    return;
                }
                c = bVar.b();
                b = bVar.c();
            }
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
        }
    }
}

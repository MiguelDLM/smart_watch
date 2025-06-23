package com.baidu.sec.privacy.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;

/* loaded from: classes8.dex */
public class a implements com.baidu.sec.privacy.a.a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f10011a;
    public static Context b;
    public com.baidu.sec.privacy.c.a.a<String> c;
    public com.baidu.sec.privacy.c.a.a<Integer> d;
    public com.baidu.sec.privacy.c.a.a<Integer> e;
    public com.baidu.sec.privacy.c.a.a<String> f;
    public com.baidu.sec.privacy.c.a.a<String> g;
    public com.baidu.sec.privacy.c.a.a<String> h;
    public com.baidu.sec.privacy.c.a.a<String> i;

    public a(Context context) {
        b = context;
    }

    public final String b() {
        return com.baidu.sec.privacy.d.b.a(b);
    }

    public final String d(String str) {
        try {
            return Settings.System.getString(b.getContentResolver(), str);
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return "";
        }
    }

    public final int e(String str) {
        try {
            return Settings.System.getInt(b.getContentResolver(), str);
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public final Object f(String str) {
        try {
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("&&");
        if (split.length != 2) {
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        if ("1".equals(str2)) {
            return d(str3);
        }
        if ("2".equals(str2)) {
            return Integer.valueOf(e(str3));
        }
        return null;
    }

    public final String g(String str) {
        try {
            return Settings.Secure.getString(b.getContentResolver(), str);
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return "";
        }
    }

    public final int h(String str) {
        try {
            return Settings.Secure.getInt(b.getContentResolver(), str);
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public boolean e() {
        if (com.baidu.sec.privacy.d.c.a(b)) {
            return true;
        }
        return com.baidu.sec.privacy.b.a.b();
    }

    public String a(String str, boolean z) {
        return a(str, z, false);
    }

    public int b(String str, boolean z) {
        return b(str, z, false);
    }

    public final String c() {
        return com.baidu.sec.privacy.d.b.b(b);
    }

    public final String d() {
        try {
            return com.baidu.sec.privacy.d.d.a(b);
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return "";
        }
    }

    public String g() {
        if (this.i == null) {
            this.i = new h(this);
        }
        return com.baidu.sec.privacy.d.g.a(b, 71, false, this.i, new Object[0]);
    }

    public static a a(Context context) {
        if (f10011a == null) {
            synchronized (a.class) {
                f10011a = new a(context);
            }
        }
        return f10011a;
    }

    public int b(String str, boolean z, boolean z2) {
        if (z) {
            if (this.d == null) {
                this.d = new c(this);
            }
            return com.baidu.sec.privacy.d.g.a(b, 42, "2&&" + str, -1, z2, this.d, new Object[0]);
        }
        if (com.baidu.sec.privacy.d.g.a(b, 42)) {
            return e(str);
        }
        return com.baidu.sec.privacy.d.g.a(b, -1, z2);
    }

    public int c(String str, boolean z) {
        return c(str, z, false);
    }

    public int c(String str, boolean z, boolean z2) {
        if (z) {
            if (this.e == null) {
                this.e = new d(this);
            }
            return com.baidu.sec.privacy.d.g.a(b, 48, "2&&" + str, -1, z2, this.e, new Object[0]);
        }
        if (com.baidu.sec.privacy.d.g.a(b, 48)) {
            return h(str);
        }
        return com.baidu.sec.privacy.d.g.a(b, -1, z2);
    }

    public String a(String str, boolean z, boolean z2) {
        if (z) {
            if (this.c == null) {
                this.c = new b(this);
            }
            return com.baidu.sec.privacy.d.g.a(b, 42, "1&&" + str, z2, this.c, new Object[0]);
        }
        if (com.baidu.sec.privacy.d.g.a(b, 42)) {
            return d(str);
        }
        return com.baidu.sec.privacy.d.g.a(b, z2);
    }

    public static Object b(String str) {
        try {
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("&&");
        if (split.length != 2) {
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        if ("1".equals(str2)) {
            return a(com.baidu.sec.privacy.a.b.b()).g(str3);
        }
        if ("2".equals(str2)) {
            return Integer.valueOf(a(com.baidu.sec.privacy.a.b.b()).h(str3));
        }
        return null;
    }

    public Pair<String, String> f() {
        if (this.h == null) {
            this.h = new g(this);
        }
        String a2 = com.baidu.sec.privacy.d.g.a(b, 64, false, this.h, new Object[0]);
        String str = "";
        if (com.baidu.sec.privacy.d.g.a("64")) {
            str = "" + com.baidu.sec.privacy.b.a.a("64la_in", 0L);
        }
        return new Pair<>(a2, str);
    }

    @Override // com.baidu.sec.privacy.a.a
    public boolean a() {
        return com.baidu.sec.privacy.b.d.a(com.baidu.sec.privacy.b.a.e);
    }

    @Override // com.baidu.sec.privacy.a.a
    public File a(String str) {
        try {
            if (com.baidu.sec.privacy.d.g.a(b, 44)) {
                return new File(str);
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return null;
        }
    }

    public String a(boolean z) {
        if (this.f == null) {
            this.f = new e(this);
        }
        return com.baidu.sec.privacy.d.g.a(b, 7, z, this.f, new Object[0]);
    }

    @Override // com.baidu.sec.privacy.a.a
    public Class a(ClassLoader classLoader, String str) throws ClassNotFoundException {
        if (com.baidu.sec.privacy.d.g.a(b, 54)) {
            return classLoader.loadClass(str);
        }
        return null;
    }

    public String b(boolean z) {
        if (this.g == null) {
            this.g = new f(this);
        }
        return com.baidu.sec.privacy.d.g.a(b, 8, z, this.g, new Object[0]);
    }

    public boolean a(String str, String str2) {
        try {
            if (com.baidu.sec.privacy.d.g.a(b, 42) && com.baidu.sec.privacy.d.f.a(b, new String[]{"android.permission.WRITE_SETTINGS"})) {
                return Settings.System.putString(b.getContentResolver(), str, str2);
            }
            return false;
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return false;
        }
    }
}

package com.baidu.navisdk.module.cloudconfig;

import android.content.SharedPreferences;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class a {
    private static volatile a c;
    private static HashMap<String, Object> d = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f7089a;
    private SharedPreferences.Editor b;

    public a() {
        SharedPreferences sharedPreferences = com.baidu.navisdk.framework.a.c().a().getSharedPreferences("navi_cloud", 0);
        this.f7089a = sharedPreferences;
        this.b = sharedPreferences.edit();
    }

    public static a b() {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        c = new a();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public boolean a(String str) {
        return this.f7089a.contains(str);
    }

    public boolean c(String str, int i) {
        this.b.putInt(str, i);
        return true;
    }

    public boolean d(String str, boolean z) {
        this.b.putBoolean(str, z);
        return true;
    }

    public boolean a(String str, boolean z) {
        return this.f7089a.getBoolean(str, z);
    }

    public boolean c(String str, boolean z) {
        this.b.putBoolean(str, z);
        this.b.apply();
        return true;
    }

    public float a(String str, float f) {
        return this.f7089a.getFloat(str, f);
    }

    public int a(String str, int i) {
        return this.f7089a.getInt(str, i);
    }

    public String a(String str, String str2) {
        return this.f7089a.getString(str, str2);
    }

    public void a() {
        this.b.apply();
    }

    public boolean b(String str, boolean z) {
        Object obj;
        if (d.containsKey(str) && (obj = d.get(str)) != null) {
            return ((Boolean) obj).booleanValue();
        }
        boolean a2 = a(str, z);
        d.put(str, Boolean.valueOf(a2));
        return a2;
    }

    public boolean b(String str, int i) {
        this.b.putInt(str, i);
        this.b.apply();
        return true;
    }

    public boolean b(String str, float f) {
        this.b.putFloat(str, f);
        this.b.apply();
        return true;
    }

    public boolean b(String str, String str2) {
        this.b.putString(str, str2);
        this.b.apply();
        return true;
    }

    public boolean b(String str) {
        if (!a(str)) {
            return true;
        }
        this.b.remove(str);
        this.b.apply();
        return true;
    }
}

package com.baidu.navisdk.framework.pref;

import android.content.SharedPreferences;
import java.util.HashMap;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f6834a;
    private final SharedPreferences.Editor b;

    public a() {
        new HashMap();
        SharedPreferences sharedPreferences = com.baidu.navisdk.framework.a.c().a().getSharedPreferences(b(), 0);
        this.f6834a = sharedPreferences;
        this.b = sharedPreferences.edit();
    }

    public boolean a(String str, boolean z) {
        return this.f6834a.getBoolean(str, z);
    }

    public abstract String b();

    public boolean b(String str, String str2) {
        this.b.putString(str, str2);
        return true;
    }

    public String a(String str, String str2) {
        return this.f6834a.getString(str, str2);
    }

    public boolean b(String str, boolean z) {
        this.b.putBoolean(str, z);
        this.b.apply();
        return true;
    }

    public void a() {
        this.b.apply();
    }
}

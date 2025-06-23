package com.baidu.mshield;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f6373a;
    public SharedPreferences.Editor b;

    public c(Context context) {
        try {
            SharedPreferences b = com.baidu.mshield.sharedpreferences.a.a(context).b("msgzpfc");
            this.f6373a = b;
            this.b = b.edit();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.c(th.getMessage());
        }
    }

    public boolean a() {
        return this.f6373a.getInt("cloud_sw", 0) == 1;
    }

    public int b() {
        return this.f6373a.getInt("wm_in_ma_cco", 3);
    }

    public void a(String str, int i) {
        this.b.putInt("wm_in_cco" + str, i);
        this.b.commit();
    }

    public int a(String str) {
        return this.f6373a.getInt("wm_in_cco" + str, 0);
    }
}

package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f27636a;
    private SharedPreferences.Editor b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f27636a = sharedPreferences;
            this.b = sharedPreferences.edit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str) {
        this.b.putString("kwtk", str);
        this.b.commit();
    }

    public String b() {
        return this.f27636a.getString("kwtk", "");
    }

    public boolean a() {
        return this.f27636a.getBoolean("xytk", true);
    }
}

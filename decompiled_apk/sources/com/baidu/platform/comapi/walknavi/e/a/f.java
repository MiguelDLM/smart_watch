package com.baidu.platform.comapi.walknavi.e.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f9734a;

    public f(Context context) {
        this.f9734a = context;
    }

    public void a(String str, String str2) {
        try {
            a().edit().putString(str, str2).apply();
        } catch (Exception unused) {
            com.baidu.platform.comapi.walknavi.e.a.g.a.a("saveLocalResourcePath exception");
        }
    }

    public String a(String str) {
        return a().getString(str, "");
    }

    private SharedPreferences a() {
        return this.f9734a.getSharedPreferences("ar_resource_info", 0);
    }
}

package com.baidu.navisdk.ui.routeguide.ugc;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f9150a;
    private SharedPreferences.Editor b;

    public e(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.f9150a = sharedPreferences;
        this.b = sharedPreferences.edit();
    }

    public long a(String str, long j) {
        return this.f9150a.getLong(str, j);
    }

    public void b(String str, long j) {
        this.b.putLong(str, j);
        this.b.apply();
    }

    public Map<String, ?> a() {
        return this.f9150a.getAll();
    }
}

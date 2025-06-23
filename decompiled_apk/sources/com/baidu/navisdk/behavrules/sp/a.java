package com.baidu.navisdk.behavrules.sp;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f6657a;
    private SharedPreferences.Editor b;

    public a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.f6657a = sharedPreferences;
        this.b = sharedPreferences.edit();
    }

    public int a(String str, int i) {
        return this.f6657a.getInt(str, i);
    }

    public boolean b(String str, int i) {
        this.b.putInt(str, i);
        this.b.apply();
        return true;
    }

    public long a(String str, long j) {
        return this.f6657a.getLong(str, j);
    }

    public void a() {
        this.b.clear();
        this.b.apply();
    }

    public void b(String str, long j) {
        this.b.putLong(str, j);
        this.b.apply();
    }

    public String a(String str, String str2) {
        return this.f6657a.getString(str, str2);
    }

    public boolean b(String str, String str2) {
        this.b.putString(str, str2);
        this.b.apply();
        return true;
    }
}

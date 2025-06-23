package com.adp.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private String f4739a = "showcount";
    private SharedPreferences b;
    private SharedPreferences.Editor c;

    public i(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("showcount", 4);
        this.b = sharedPreferences;
        this.c = sharedPreferences.edit();
    }

    public void a(String str, int i) {
        try {
            this.c.putInt(str, i);
            this.c.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int a(String str) {
        try {
            return this.b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }
}

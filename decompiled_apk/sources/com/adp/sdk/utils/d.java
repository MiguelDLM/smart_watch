package com.adp.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f4733a = "parmIP";
    private SharedPreferences b;
    private SharedPreferences.Editor c;

    public d(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("parmIP", 4);
        this.b = sharedPreferences;
        this.c = sharedPreferences.edit();
    }

    public void a(String str, String str2) {
        try {
            this.c.putString(str, str2);
            this.c.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String b(String str, String str2) {
        try {
            return this.b.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}

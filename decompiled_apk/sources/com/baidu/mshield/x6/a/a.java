package com.baidu.mshield.x6.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.x6.e.f;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f6426a;

    public a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("msgzpfc", 4);
            this.f6426a = sharedPreferences;
            sharedPreferences.edit();
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public String a(String str) {
        return this.f6426a.getString(str, "");
    }
}

package com.baidu.sec.privacy.b;

import android.content.SharedPreferences;

/* loaded from: classes8.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f10009a;
    public final /* synthetic */ String b;

    public c(b bVar, SharedPreferences sharedPreferences, String str) {
        this.f10009a = sharedPreferences;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b(this.f10009a.getString(this.b, ""));
    }
}

package com.baidu.sec.privacy.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes8.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static volatile i f10017a;
    public static Context b;

    public i(Context context) {
        b = context;
    }

    public static i a(Context context) {
        if (f10017a == null) {
            synchronized (i.class) {
                f10017a = new i(context);
            }
        }
        return f10017a;
    }

    @SuppressLint({"MissingPermission"})
    public NetworkInfo a() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.getSystemService("connectivity");
            if (com.baidu.sec.privacy.d.f.a(b, new String[]{com.kuaishou.weapon.p0.g.b})) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return null;
        }
    }
}

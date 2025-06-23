package com.baidu.sec.privacy.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static volatile j f10018a;
    public static Context b;

    public j(Context context) {
        b = context;
    }

    public static j a(Context context) {
        if (f10018a == null) {
            synchronized (j.class) {
                f10018a = new j(context);
            }
        }
        return f10018a;
    }

    public PackageInfo a(String str, int i) throws PackageManager.NameNotFoundException {
        try {
            if (com.baidu.sec.privacy.b.a.a(19)) {
                return b.getPackageManager().getPackageInfo(str, i);
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return null;
        }
    }
}

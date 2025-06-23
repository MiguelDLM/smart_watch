package com.baidu.platform.comapi.walknavi.e.a.g;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f9742a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            try {
                if (f9742a == null) {
                    f9742a = new Handler(Looper.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f9742a.post(runnable);
    }
}

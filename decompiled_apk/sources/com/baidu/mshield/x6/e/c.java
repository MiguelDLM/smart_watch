package com.baidu.mshield.x6.e;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes7.dex */
public class c extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    public static volatile c f6445a;
    public static Handler b;

    public c() {
        super("BackgroundThread", 10);
    }

    public static void a() {
        if (f6445a == null) {
            f6445a = new c();
            f6445a.start();
            b = new Handler(f6445a.getLooper());
        }
    }

    public static Handler b() {
        Handler handler;
        try {
            synchronized (c.class) {
                a();
                handler = b;
            }
            return handler;
        } catch (Throwable th) {
            f.a(th);
            return b;
        }
    }
}

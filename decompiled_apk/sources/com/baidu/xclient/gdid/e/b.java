package com.baidu.xclient.gdid.e;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes8.dex */
public class b extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    public static b f10231a;
    public static Handler b;

    public b() {
        super("BackgroundThread", 10);
    }

    public static void a() {
        if (f10231a == null) {
            b bVar = new b();
            f10231a = bVar;
            bVar.start();
            b = new Handler(f10231a.getLooper());
        }
    }

    public static b b() {
        b bVar;
        synchronized (b.class) {
            a();
            bVar = f10231a;
        }
        return bVar;
    }

    public static Handler c() {
        Handler handler;
        synchronized (b.class) {
            a();
            handler = b;
        }
        return handler;
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            c().post(runnable);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}

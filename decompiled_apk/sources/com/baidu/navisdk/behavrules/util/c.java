package com.baidu.navisdk.behavrules.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes7.dex */
public class c {
    private static c d;

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f6663a;
    private Handler b;
    private Handler c = new Handler(Looper.getMainLooper());

    private c() {
        b();
    }

    public static c a() {
        if (d == null) {
            synchronized (c.class) {
                try {
                    if (d == null) {
                        d = new c();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    private void b() {
        if (this.f6663a == null) {
            HandlerThread handlerThread = new HandlerThread("BNAsrWorkCentersubThread");
            this.f6663a = handlerThread;
            handlerThread.start();
            this.b = new Handler(this.f6663a.getLooper());
        }
    }

    public void b(Runnable runnable, long j) {
        this.b.postDelayed(runnable, j);
    }

    public void b(Runnable runnable) {
        this.b.removeCallbacks(runnable);
    }

    public void a(Runnable runnable, long j) {
        this.c.postDelayed(runnable, j);
    }

    public void a(Runnable runnable) {
        this.c.removeCallbacks(runnable);
    }
}

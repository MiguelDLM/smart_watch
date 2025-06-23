package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static Executor f10528a = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.bytedance.pangle.d.e.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f10529a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pangle-Fast-" + this.f10529a.getAndIncrement());
        }
    });
    private static final Object b = new Object();
    private static Handler c = null;

    public static void a(Runnable runnable) {
        f10528a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        if (a().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    public static ExecutorService a(int i) {
        return Executors.newFixedThreadPool(i, new ThreadFactory() { // from class: com.bytedance.pangle.d.e.2

            /* renamed from: a, reason: collision with root package name */
            private final AtomicInteger f10530a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pangle-Install-" + this.f10530a.getAndIncrement());
            }
        });
    }

    private static Handler a() {
        Handler handler;
        synchronized (b) {
            try {
                if (c == null) {
                    c = new Handler(Looper.getMainLooper());
                }
                handler = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }
}

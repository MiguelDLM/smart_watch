package com.baidu.mapframework.nirvana;

import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes7.dex */
public class NirvanaScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    public static final String TAG = "NirvanaScheduledThreadPool";

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Long> f6074a;
    private final AtomicLong b;
    private final AtomicLong c;

    public NirvanaScheduledThreadPoolExecutor(int i, ThreadFactory threadFactory) {
        super(i, threadFactory);
        this.f6074a = new ThreadLocal<>();
        this.b = new AtomicLong();
        this.c = new AtomicLong();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        try {
            long nanoTime = System.nanoTime() - this.f6074a.get().longValue();
            this.b.incrementAndGet();
            this.c.addAndGet(nanoTime);
            Utils.logi(TAG, String.format(Locale.getDefault(), "Thread %s : end task %s, time = %d ms, executed task num: %d", Thread.currentThread(), runnable, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(nanoTime)), Long.valueOf(this.b.get())));
        } finally {
            super.afterExecute(runnable, th);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.f6074a.set(Long.valueOf(System.nanoTime()));
        Utils.logi(TAG, String.format("Thread %s : start task %s at: %s", thread, runnable, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(this.f6074a.get().longValue()))) + "");
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void terminated() {
        try {
            if (this.b.get() != 0) {
                Utils.logi(TAG, String.format(Locale.getDefault(), "Terminated : total time=%d, avg time=%dns", Long.valueOf(this.c.get()), Long.valueOf(this.c.get() / this.b.get())));
            }
        } finally {
            super.terminated();
        }
    }
}

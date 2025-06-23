package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public final class b extends ThreadPoolExecutor implements c {
    public static volatile boolean aCh = false;
    private final ConcurrentHashMap<Runnable, Long> aCi;
    private long aCj;
    private int aCk;

    public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.aCi = new ConcurrentHashMap<>();
        this.aCj = 0L;
        this.aCk = 0;
    }

    @Override // com.kwad.sdk.core.threads.a.c
    public final long GG() {
        return this.aCj;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (aCh && this.aCi.containsKey(runnable) && this.aCi.get(runnable) != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.aCi.get(runnable).longValue();
            if (elapsedRealtime >= 0 && elapsedRealtime < 1800000) {
                long j = this.aCj;
                int i = this.aCk;
                this.aCj = ((j * i) + elapsedRealtime) / (i + 1);
                this.aCk = i + 1;
            }
            this.aCi.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aCh) {
            this.aCi.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }

    public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.aCi = new ConcurrentHashMap<>();
        this.aCj = 0L;
        this.aCk = 0;
    }
}

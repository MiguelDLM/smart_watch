package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes11.dex */
public final class a extends ScheduledThreadPoolExecutor implements c {
    public static volatile boolean aCh = false;
    private final ConcurrentHashMap<Runnable, Long> aCi;
    private long aCj;
    private int aCk;

    public a(int i, ThreadFactory threadFactory) {
        super(1, threadFactory);
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

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aCh) {
            this.aCi.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }
}

package com.jd.ad.sdk.fdt.thread;

import com.jd.ad.sdk.jad_cn.jad_an;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes10.dex */
public final class WorkExecutor {
    private static final ScheduledThreadPoolExecutor POOL;

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        POOL = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(30L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.setRejectedExecutionHandler(new jad_an("Work"));
    }

    private WorkExecutor() {
    }

    public static void execute(Runnable runnable) {
        POOL.execute(runnable);
    }

    public static void remove(Runnable runnable) {
        POOL.remove(runnable);
    }

    public static ScheduledFuture<?> scheduleDelay(Runnable runnable, long j, TimeUnit timeUnit) {
        return POOL.schedule(runnable, j, timeUnit);
    }

    public static ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return POOL.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    public static ScheduledFuture<?> execute(Runnable runnable, long j, TimeUnit timeUnit) {
        return POOL.schedule(runnable, j, timeUnit);
    }
}

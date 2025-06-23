package com.baidu.mapframework.nirvana;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class NirvanaExecutors {

    /* renamed from: a, reason: collision with root package name */
    private static final int f6072a;
    private static final int b;
    private static ExecutorService c;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f6072a = availableProcessors;
        Math.max(2, Math.min(availableProcessors - 1, 4));
        b = Math.min((availableProcessors * 2) + 1, 8);
        c = newDefaultThreadPool("DEFAULT");
    }

    private static ThreadPoolExecutor a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    public static ExecutorService defaultThreadPool() {
        return c;
    }

    public static int getDefaultThreadPoolSize(int i) {
        return Math.min(b, i);
    }

    public static ExecutorService newCachedThreadPool(String str) {
        return a(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new SynchronousQueue(), new NirvanaThreadFactory(str));
    }

    public static ExecutorService newDefaultThreadPool(String str) {
        int i = b;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor a2 = a(i, i, 60L, timeUnit, new LinkedBlockingQueue(), new NirvanaThreadFactory(str));
        try {
            a2.setKeepAliveTime(60L, timeUnit);
            a2.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            Utils.loge("NirvanaExecutors newFixedThreadPool allowCoreThreadTimeOut", e);
        }
        return a2;
    }

    public static ExecutorService newFixedThreadPool(String str, int i) {
        return a(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new NirvanaThreadFactory(str));
    }

    public static ScheduledThreadPoolExecutor newScheduledThreadPool(String str, int i) {
        return a(i, new NirvanaThreadFactory(str));
    }

    private static ScheduledThreadPoolExecutor a(int i, ThreadFactory threadFactory) {
        return new ScheduledThreadPoolExecutor(i, threadFactory);
    }
}

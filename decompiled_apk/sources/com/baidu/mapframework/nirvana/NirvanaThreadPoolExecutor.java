package com.baidu.mapframework.nirvana;

import com.baidu.mapframework.common.logger.Level;
import com.baidu.mapframework.common.logger.LogManager;
import com.baidu.mapframework.common.logger.Logger;
import com.baidu.mapframework.nirvana.ThreadPoolProfile;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes7.dex */
public class NirvanaThreadPoolExecutor extends ThreadPoolExecutor {
    public static final String TAG = "NirvanaThreadPool";
    private static final ConcurrentMap<String, ThreadPoolProfile> d = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Long> f6078a;
    private final AtomicLong b;
    private final AtomicLong c;

    public NirvanaThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.f6078a = new ThreadLocal<>();
        this.b = new AtomicLong();
        this.c = new AtomicLong();
    }

    public static void dumpProfile() {
        Logger logger = LogManager.getLogger(Level.DEBUG, "Profile");
        for (Map.Entry<String, ThreadPoolProfile> entry : d.entrySet()) {
            logger.debug(String.valueOf(entry.getKey()) + ":" + entry.getValue() + "\n");
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        try {
            long nanoTime = System.nanoTime();
            long longValue = nanoTime - this.f6078a.get().longValue();
            this.b.incrementAndGet();
            this.c.addAndGet(longValue);
            Utils.logi(TAG, String.format(Locale.getDefault(), "Thread %s : end task %s, time = %d ms, executed task num: %d", Thread.currentThread(), runnable, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(longValue)), Long.valueOf(this.b.get())));
            ThreadPoolProfile threadPoolProfile = d.get(Thread.currentThread().getName());
            if (threadPoolProfile != null) {
                ThreadPoolProfile.ProfileItem profileItem = new ThreadPoolProfile.ProfileItem();
                profileItem.name = runnable.toString();
                profileItem.startTime = this.f6078a.get().longValue();
                profileItem.endTime = nanoTime;
                threadPoolProfile.f6081a.add(profileItem);
            }
        } finally {
            super.afterExecute(runnable, th);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.f6078a.set(Long.valueOf(System.nanoTime()));
        Utils.logi(TAG, String.format("Thread %s : start task %s at: %s", thread, runnable, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(this.f6078a.get().longValue()))) + "");
        ConcurrentMap<String, ThreadPoolProfile> concurrentMap = d;
        if (concurrentMap.get(thread.getName()) == null) {
            concurrentMap.put(thread.getName(), new ThreadPoolProfile());
        }
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

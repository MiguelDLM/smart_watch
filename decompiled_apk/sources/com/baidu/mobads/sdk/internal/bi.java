package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
final class bi implements RejectedExecutionHandler {
    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadFactory threadFactory;
        az.h("ThreadPoolFactory").e("Exceeded ThreadPoolExecutor pool size");
        synchronized (this) {
            try {
                threadPoolExecutor2 = bf.d;
                if (threadPoolExecutor2 == null) {
                    LinkedBlockingQueue unused = bf.e = new LinkedBlockingQueue();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    linkedBlockingQueue = bf.e;
                    threadFactory = bf.f;
                    ThreadPoolExecutor unused2 = bf.d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, linkedBlockingQueue, threadFactory);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        threadPoolExecutor3 = bf.d;
        threadPoolExecutor3.execute(runnable);
    }
}

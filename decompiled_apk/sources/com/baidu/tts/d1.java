package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class d1 extends ThreadPoolExecutor {

    /* loaded from: classes8.dex */
    public static class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            LoggerProxy.d("LimitQueueThreadPoolExecutor", "rejectedExecution");
            if (!threadPoolExecutor.isShutdown()) {
                try {
                    threadPoolExecutor.getQueue().put(runnable);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public d1(int i, String str, RejectedExecutionHandler rejectedExecutionHandler) {
        this(i, new a3(str), rejectedExecutionHandler);
    }

    public d1(int i, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        this(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(i), threadFactory, rejectedExecutionHandler);
    }

    public d1(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }
}

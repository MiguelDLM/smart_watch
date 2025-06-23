package com.huawei.openalliance.ad.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes10.dex */
public class i implements ThreadFactory {
    private final ThreadGroup Code;
    private final String I;
    private final AtomicInteger V;
    private final int Z;

    public i(String str) {
        this(str, 5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.Code, runnable, this.I + this.V.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int priority = thread.getPriority();
        int i = this.Z;
        if (priority != i) {
            thread.setPriority(i);
        }
        return thread;
    }

    public i(String str, int i) {
        this.V = new AtomicInteger(1);
        this.Z = i;
        this.Code = Thread.currentThread().getThreadGroup();
        this.I = str + "-pool-thread-";
    }
}

package com.baidu.mshield.x0.b.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f6401a = new AtomicInteger(1);
    public final AtomicInteger b;
    public String c;
    public int d;

    public c() {
        this(5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.c + this.b.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i = this.d;
        if (i != 5) {
            thread.setPriority(i);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }

    public c(int i) {
        this.b = new AtomicInteger(1);
        this.c = "sec-" + f6401a.getAndIncrement() + "-thread-";
        this.d = i;
    }
}

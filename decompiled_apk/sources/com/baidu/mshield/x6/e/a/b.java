package com.baidu.mshield.x6.e.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f6443a = new AtomicInteger(1);
    public final AtomicInteger b;
    public String c;
    public int d;

    public b() {
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

    public b(int i) {
        this.b = new AtomicInteger(1);
        System.getSecurityManager();
        this.c = "fin-" + f6443a.getAndIncrement() + "-thread-";
        this.d = i;
    }
}

package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class be {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6244a = "TaskScheduler";
    private static volatile be d;
    private ThreadPoolExecutor b;
    private ScheduledThreadPoolExecutor c;

    private be() {
        b();
    }

    public static be a() {
        if (d == null) {
            synchronized (be.class) {
                try {
                    if (d == null) {
                        d = new be();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    private void b() {
        this.b = bf.a(1, 1);
        this.c = bf.a(1);
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.b.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void a(i iVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (iVar == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            iVar.a(System.currentTimeMillis());
            ThreadPoolExecutor threadPoolExecutor2 = this.b;
            iVar.a((Future) ((threadPoolExecutor2 == null || threadPoolExecutor2.isShutdown()) ? null : (FutureTask) this.b.submit(iVar)));
        } catch (Throwable unused) {
        }
    }

    public void a(i iVar, long j, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (iVar == null || (scheduledThreadPoolExecutor = this.c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            iVar.a(System.currentTimeMillis());
            iVar.a((Future) this.c.schedule(iVar, j, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void a(i iVar, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (iVar == null || (scheduledThreadPoolExecutor = this.c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            iVar.a(System.currentTimeMillis());
            iVar.a((Future) this.c.scheduleAtFixedRate(iVar, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }
}

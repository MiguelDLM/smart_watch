package com.baidu.platform.comapi.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private static final int f9693a;
    private static final int b;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f9693a = availableProcessors;
        b = Math.min((availableProcessors * 2) + 1, 8);
    }

    public static ExecutorService a(String str) {
        int i = b;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, timeUnit, new LinkedBlockingQueue(), new c(str));
        try {
            threadPoolExecutor.setKeepAliveTime(60L, timeUnit);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        return threadPoolExecutor;
    }
}

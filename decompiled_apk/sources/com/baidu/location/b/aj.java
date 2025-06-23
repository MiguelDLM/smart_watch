package com.baidu.location.b;

import java.util.concurrent.ExecutorService;

/* loaded from: classes7.dex */
public class aj {

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f5622a;
    private ExecutorService b;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static aj f5623a = new aj();
    }

    private aj() {
        this.f5622a = null;
        this.b = null;
    }

    public static aj a() {
        return a.f5623a;
    }

    public synchronized ExecutorService b() {
        return this.f5622a;
    }

    public synchronized ExecutorService c() {
        return this.b;
    }

    public void d() {
        ExecutorService executorService = this.f5622a;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.b;
        if (executorService2 != null) {
            executorService2.shutdown();
        }
    }
}

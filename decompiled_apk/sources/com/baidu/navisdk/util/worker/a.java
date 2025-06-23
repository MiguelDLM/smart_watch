package com.baidu.navisdk.util.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class a extends d {
    private static h d;
    private static final Object e = new Object();
    private ExecutorService c = null;

    private a() {
        b();
    }

    private void b() {
        this.c = Executors.newFixedThreadPool(3);
    }

    @Override // com.baidu.navisdk.util.worker.d, com.baidu.navisdk.util.worker.h
    public <K, T> void a(f<K, T> fVar, e eVar) {
    }

    public static h a() {
        if (d == null) {
            synchronized (e) {
                try {
                    if (d == null) {
                        d = new a();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    @Override // com.baidu.navisdk.util.worker.d, com.baidu.navisdk.util.worker.h
    public <K, T> Future<?> a(g<K, T> gVar, e eVar) {
        ExecutorService executorService;
        if (!b(gVar) || (executorService = this.c) == null) {
            return null;
        }
        Future<?> submit = executorService.submit(gVar);
        if (submit != null) {
            this.f9394a.put(gVar, submit);
        }
        return submit;
    }
}

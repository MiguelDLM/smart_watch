package com.baidu.tts;

import com.baidu.tts.m;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes8.dex */
public class i implements Callable<m.a> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r4 f10105a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ j c;

    public i(j jVar, r4 r4Var, CountDownLatch countDownLatch) {
        this.c = jVar;
        this.f10105a = r4Var;
        this.b = countDownLatch;
    }

    @Override // java.util.concurrent.Callable
    public m.a call() throws Exception {
        try {
            return this.c.a(this.f10105a.b);
        } finally {
            this.b.countDown();
        }
    }
}

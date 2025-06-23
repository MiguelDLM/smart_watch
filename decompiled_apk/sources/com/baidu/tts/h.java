package com.baidu.tts;

import com.baidu.tts.o;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes8.dex */
public class h implements Callable<o.a> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r4 f10099a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ j c;

    public h(j jVar, r4 r4Var, CountDownLatch countDownLatch) {
        this.c = jVar;
        this.f10099a = r4Var;
        this.b = countDownLatch;
    }

    @Override // java.util.concurrent.Callable
    public o.a call() throws Exception {
        try {
            return this.c.a(this.f10099a.f10162a);
        } finally {
            this.b.countDown();
        }
    }
}

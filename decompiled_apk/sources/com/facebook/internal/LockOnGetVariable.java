package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class LockOnGetVariable<T> {

    @OXOo.oOoXoXO
    private CountDownLatch initLatch;

    @OXOo.oOoXoXO
    private T storedValue;

    public LockOnGetVariable(T t) {
        this.storedValue = t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0, reason: not valid java name */
    public static final Void m209_init_$lambda0(LockOnGetVariable this$0, Callable callable) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(callable, "$callable");
        try {
            this$0.storedValue = (T) callable.call();
        } finally {
            CountDownLatch countDownLatch = this$0.initLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private final void waitOnInit() {
        CountDownLatch countDownLatch = this.initLatch;
        if (countDownLatch == null) {
            return;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    @OXOo.oOoXoXO
    public final T getValue() {
        waitOnInit();
        return this.storedValue;
    }

    public LockOnGetVariable(@OXOo.OOXIXo final Callable<T> callable) {
        IIX0o.x0xO0oo(callable, "callable");
        this.initLatch = new CountDownLatch(1);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FacebookSdk.getExecutor().execute(new FutureTask(new Callable() { // from class: com.facebook.internal.oO
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void m209_init_$lambda0;
                m209_init_$lambda0 = LockOnGetVariable.m209_init_$lambda0(LockOnGetVariable.this, callable);
                return m209_init_$lambda0;
            }
        }));
    }
}

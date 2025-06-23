package androidx.work.impl;

import java.util.concurrent.Callable;

public final /* synthetic */ class x0xO0oo implements Callable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f573XO;

    public /* synthetic */ x0xO0oo(WorkerWrapper workerWrapper) {
        this.f573XO = workerWrapper;
    }

    public final Object call() {
        return WorkerWrapper.trySetRunning$lambda$11(this.f573XO);
    }
}

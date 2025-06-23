package androidx.work.impl;

import java.util.concurrent.Callable;

public final /* synthetic */ class oO implements Callable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f539XO;

    public /* synthetic */ oO(WorkerWrapper workerWrapper) {
        this.f539XO = workerWrapper;
    }

    public final Object call() {
        return WorkerWrapper.runWorker$lambda$1(this.f539XO);
    }
}

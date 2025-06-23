package androidx.work.impl;

import androidx.work.impl.WorkerWrapper;
import java.util.concurrent.Callable;

public final /* synthetic */ class IXxxXO implements Callable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f518Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper.Resolution f519XO;

    public /* synthetic */ IXxxXO(WorkerWrapper.Resolution resolution, WorkerWrapper workerWrapper) {
        this.f519XO = resolution;
        this.f518Oo = workerWrapper;
    }

    public final Object call() {
        return WorkerWrapper$launch$1.invokeSuspend$lambda$1(this.f519XO, this.f518Oo);
    }
}

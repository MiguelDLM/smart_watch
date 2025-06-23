package androidx.work.impl;

import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class I0Io implements Runnable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f511IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f512Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ Processor f513XO;

    public /* synthetic */ I0Io(Processor processor, ListenableFuture listenableFuture, WorkerWrapper workerWrapper) {
        this.f513XO = processor;
        this.f512Oo = listenableFuture;
        this.f511IXxxXO = workerWrapper;
    }

    public final void run() {
        this.f513XO.lambda$startWork$1(this.f512Oo, this.f511IXxxXO);
    }
}

package androidx.work;

import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class xoIox implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f580XO;

    public /* synthetic */ xoIox(AtomicBoolean atomicBoolean) {
        this.f580XO = atomicBoolean;
    }

    public final void run() {
        WorkerKt.future$lambda$2$lambda$0(this.f580XO);
    }
}

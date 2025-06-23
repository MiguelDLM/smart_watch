package androidx.work;

import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class oxoX implements Runnable {

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f579XO;

    public /* synthetic */ oxoX(AtomicBoolean atomicBoolean) {
        this.f579XO = atomicBoolean;
    }

    public final void run() {
        ListenableFutureKt.executeAsync$lambda$4$lambda$2(this.f579XO);
    }
}

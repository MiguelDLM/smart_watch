package androidx.work.impl;

import Oox.oOoXoXO;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class WorkerWrapperKt$awaitWithin$2$1 extends Lambda implements oOoXoXO<Throwable, oXIO0o0XI> {
    final /* synthetic */ ListenableFuture<T> $this_awaitWithin;
    final /* synthetic */ ListenableWorker $worker;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkerWrapperKt$awaitWithin$2$1(ListenableWorker listenableWorker, ListenableFuture<T> listenableFuture) {
        super(1);
        this.$worker = listenableWorker;
        this.$this_awaitWithin = listenableFuture;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(Throwable th) {
        if (th instanceof WorkerStoppedException) {
            this.$worker.stop(((WorkerStoppedException) th).getReason());
        }
        this.$this_awaitWithin.cancel(false);
    }
}

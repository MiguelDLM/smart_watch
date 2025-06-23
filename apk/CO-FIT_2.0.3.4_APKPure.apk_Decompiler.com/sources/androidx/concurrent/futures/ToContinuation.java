package androidx.concurrent.futures;

import OXOo.OOXIXo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.oO;

final class ToContinuation<T> implements Runnable {
    @OOXIXo
    private final oO<T> continuation;
    @OOXIXo
    private final ListenableFuture<T> futureToObserve;

    public ToContinuation(@OOXIXo ListenableFuture<T> listenableFuture, @OOXIXo oO<? super T> oOVar) {
        IIX0o.Oo(listenableFuture, "futureToObserve");
        IIX0o.Oo(oOVar, "continuation");
        this.futureToObserve = listenableFuture;
        this.continuation = oOVar;
    }

    @OOXIXo
    public final oO<T> getContinuation() {
        return this.continuation;
    }

    @OOXIXo
    public final ListenableFuture<T> getFutureToObserve() {
        return this.futureToObserve;
    }

    public void run() {
        if (this.futureToObserve.isCancelled()) {
            oO.oIX0oI.oIX0oI(this.continuation, (Throwable) null, 1, (Object) null);
            return;
        }
        try {
            oO<T> oOVar = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            oOVar.resumeWith(Result.m42constructorimpl(AbstractResolvableFuture.getUninterruptibly(this.futureToObserve)));
        } catch (ExecutionException e) {
            oO<T> oOVar2 = this.continuation;
            Throwable access$nonNullCause = ListenableFutureKt.nonNullCause(e);
            Result.oIX0oI oix0oi2 = Result.Companion;
            oOVar2.resumeWith(Result.m42constructorimpl(I0oOoX.oIX0oI(access$nonNullCause)));
        }
    }
}

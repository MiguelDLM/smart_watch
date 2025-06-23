package androidx.concurrent.futures;

import OXOo.OOXIXo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.oO;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ToContinuation<T> implements Runnable {

    @OOXIXo
    private final oO<T> continuation;

    @OOXIXo
    private final ListenableFuture<T> futureToObserve;

    /* JADX WARN: Multi-variable type inference failed */
    public ToContinuation(@OOXIXo ListenableFuture<T> futureToObserve, @OOXIXo oO<? super T> continuation) {
        IIX0o.Oo(futureToObserve, "futureToObserve");
        IIX0o.Oo(continuation, "continuation");
        this.futureToObserve = futureToObserve;
        this.continuation = continuation;
    }

    @OOXIXo
    public final oO<T> getContinuation() {
        return this.continuation;
    }

    @OOXIXo
    public final ListenableFuture<T> getFutureToObserve() {
        return this.futureToObserve;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable nonNullCause;
        if (this.futureToObserve.isCancelled()) {
            oO.oIX0oI.oIX0oI(this.continuation, null, 1, null);
            return;
        }
        try {
            oO<T> oOVar = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            oOVar.resumeWith(Result.m287constructorimpl(AbstractResolvableFuture.getUninterruptibly(this.futureToObserve)));
        } catch (ExecutionException e) {
            oO<T> oOVar2 = this.continuation;
            nonNullCause = ListenableFutureKt.nonNullCause(e);
            Result.oIX0oI oix0oi2 = Result.Companion;
            oOVar2.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(nonNullCause)));
        }
    }
}

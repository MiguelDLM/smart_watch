package androidx.work.impl;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.oO;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ToContinuation<T> implements Runnable {

    @OXOo.OOXIXo
    private final kotlinx.coroutines.oO<T> continuation;

    @OXOo.OOXIXo
    private final ListenableFuture<T> futureToObserve;

    /* JADX WARN: Multi-variable type inference failed */
    public ToContinuation(@OXOo.OOXIXo ListenableFuture<T> futureToObserve, @OXOo.OOXIXo kotlinx.coroutines.oO<? super T> continuation) {
        IIX0o.x0xO0oo(futureToObserve, "futureToObserve");
        IIX0o.x0xO0oo(continuation, "continuation");
        this.futureToObserve = futureToObserve;
        this.continuation = continuation;
    }

    @OXOo.OOXIXo
    public final kotlinx.coroutines.oO<T> getContinuation() {
        return this.continuation;
    }

    @OXOo.OOXIXo
    public final ListenableFuture<T> getFutureToObserve() {
        return this.futureToObserve;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable nonNullCause;
        Object uninterruptibly;
        if (this.futureToObserve.isCancelled()) {
            oO.oIX0oI.oIX0oI(this.continuation, null, 1, null);
            return;
        }
        try {
            kotlinx.coroutines.oO<T> oOVar = this.continuation;
            Result.oIX0oI oix0oi = Result.Companion;
            uninterruptibly = WorkerWrapperKt.getUninterruptibly(this.futureToObserve);
            oOVar.resumeWith(Result.m287constructorimpl(uninterruptibly));
        } catch (ExecutionException e) {
            kotlinx.coroutines.oO<T> oOVar2 = this.continuation;
            Result.oIX0oI oix0oi2 = Result.Companion;
            nonNullCause = WorkerWrapperKt.nonNullCause(e);
            oOVar2.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(nonNullCause)));
        }
    }
}

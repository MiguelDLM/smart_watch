package androidx.work.impl;

import IXIxx0.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.RestrictTo;
import androidx.work.DirectExecutor;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.x0xO0oo;

@XX({"SMAP\nWorkerWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapperKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,607:1\n314#2,11:608\n*S KotlinDebug\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapperKt\n*L\n553#1:608,11\n*E\n"})
public final class WorkerWrapperKt {
    /* access modifiers changed from: private */
    @OOXIXo
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkerWrapper");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"WorkerWrapper\")");
        TAG = tagWithPrefix;
    }

    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> Object awaitWithin(@OOXIXo ListenableFuture<T> listenableFuture, @OOXIXo ListenableWorker listenableWorker, @OOXIXo I0Io<? super T> i0Io) {
        try {
            if (listenableFuture.isDone()) {
                return getUninterruptibly(listenableFuture);
            }
            x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
            x0xo0oo.IO();
            listenableFuture.addListener(new ToContinuation(listenableFuture, x0xo0oo), DirectExecutor.INSTANCE);
            x0xo0oo.ooXIXxIX(new WorkerWrapperKt$awaitWithin$2$1(listenableWorker, listenableFuture));
            Object o002 = x0xo0oo.o00();
            if (o002 == II0xO0.oOoXoXO()) {
                XO.I0Io(i0Io);
            }
            return o002;
        } catch (ExecutionException e) {
            throw nonNullCause(e);
        }
    }

    /* access modifiers changed from: private */
    public static final <V> V getUninterruptibly(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* access modifiers changed from: private */
    public static final Throwable nonNullCause(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        IIX0o.ooOOo0oXI(cause);
        return cause;
    }
}

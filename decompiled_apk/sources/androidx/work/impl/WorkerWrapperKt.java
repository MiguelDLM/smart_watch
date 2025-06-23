package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.DirectExecutor;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nWorkerWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapperKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,607:1\n314#2,11:608\n*S KotlinDebug\n*F\n+ 1 WorkerWrapper.kt\nandroidx/work/impl/WorkerWrapperKt\n*L\n553#1:608,11\n*E\n"})
/* loaded from: classes.dex */
public final class WorkerWrapperKt {

    @OXOo.OOXIXo
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkerWrapper");
        IIX0o.oO(tagWithPrefix, "tagWithPrefix(\"WorkerWrapper\")");
        TAG = tagWithPrefix;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    @OXOo.oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> Object awaitWithin(@OXOo.OOXIXo final ListenableFuture<T> listenableFuture, @OXOo.OOXIXo final ListenableWorker listenableWorker, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        try {
            if (listenableFuture.isDone()) {
                return getUninterruptibly(listenableFuture);
            }
            kotlinx.coroutines.x0xO0oo x0xo0oo = new kotlinx.coroutines.x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
            x0xo0oo.IO();
            listenableFuture.addListener(new ToContinuation(listenableFuture, x0xo0oo), DirectExecutor.INSTANCE);
            x0xo0oo.ooXIXxIX(new Oox.oOoXoXO<Throwable, oXIO0o0XI>() { // from class: androidx.work.impl.WorkerWrapperKt$awaitWithin$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Throwable th) {
                    invoke2(th);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    if (th instanceof WorkerStoppedException) {
                        ListenableWorker.this.stop(((WorkerStoppedException) th).getReason());
                    }
                    listenableFuture.cancel(false);
                }
            });
            Object o002 = x0xo0oo.o00();
            if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                IXIxx0.XO.I0Io(i0Io);
            }
            return o002;
        } catch (ExecutionException e) {
            throw nonNullCause(e);
        }
    }

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

    public static final Throwable nonNullCause(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        IIX0o.ooOOo0oXI(cause);
        return cause;
    }
}

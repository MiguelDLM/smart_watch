package androidx.concurrent.futures;

import IXIxx0.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.x0xO0oo;

public final class ListenableFutureKt {
    @oOoXoXO
    public static final <T> Object await(@OOXIXo ListenableFuture<T> listenableFuture, @OOXIXo I0Io<? super T> i0Io) {
        try {
            if (listenableFuture.isDone()) {
                return AbstractResolvableFuture.getUninterruptibly(listenableFuture);
            }
            x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
            listenableFuture.addListener(new ToContinuation(listenableFuture, x0xo0oo), DirectExecutor.INSTANCE);
            x0xo0oo.ooXIXxIX(new ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(listenableFuture));
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
    public static final Throwable nonNullCause(@OOXIXo ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        if (cause == null) {
            IIX0o.IoOoX();
        }
        return cause;
    }
}

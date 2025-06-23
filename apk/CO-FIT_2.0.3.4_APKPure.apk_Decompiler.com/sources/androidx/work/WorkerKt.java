package androidx.work;

import Oox.oIX0oI;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

public final class WorkerKt {
    /* access modifiers changed from: private */
    public static final <T> ListenableFuture<T> future(Executor executor, oIX0oI<? extends T> oix0oi) {
        ListenableFuture<T> future = CallbackToFutureAdapter.getFuture(new oOoXoXO(executor, oix0oi));
        IIX0o.oO(future, "getFuture {\n        val …        }\n        }\n    }");
        return future;
    }

    /* access modifiers changed from: private */
    public static final oXIO0o0XI future$lambda$2(Executor executor, oIX0oI oix0oi, CallbackToFutureAdapter.Completer completer) {
        IIX0o.x0xO0oo(completer, "it");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new xoIox(atomicBoolean), DirectExecutor.INSTANCE);
        executor.execute(new OOXIXo(atomicBoolean, completer, oix0oi));
        return oXIO0o0XI.f19155oIX0oI;
    }

    /* access modifiers changed from: private */
    public static final void future$lambda$2$lambda$0(AtomicBoolean atomicBoolean) {
        atomicBoolean.set(true);
    }

    /* access modifiers changed from: private */
    public static final void future$lambda$2$lambda$1(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, oIX0oI oix0oi) {
        if (!atomicBoolean.get()) {
            try {
                completer.set(oix0oi.invoke());
            } catch (Throwable th) {
                completer.setException(th);
            }
        }
    }
}

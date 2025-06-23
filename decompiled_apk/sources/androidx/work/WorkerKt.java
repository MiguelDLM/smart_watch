package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class WorkerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> ListenableFuture<T> future(final Executor executor, final Oox.oIX0oI<? extends T> oix0oi) {
        ListenableFuture<T> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.work.oOoXoXO
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                oXIO0o0XI future$lambda$2;
                future$lambda$2 = WorkerKt.future$lambda$2(executor, oix0oi, completer);
                return future$lambda$2;
            }
        });
        IIX0o.oO(future, "getFuture {\n        val …        }\n        }\n    }");
        return future;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final oXIO0o0XI future$lambda$2(Executor executor, final Oox.oIX0oI oix0oi, final CallbackToFutureAdapter.Completer it) {
        IIX0o.x0xO0oo(it, "it");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        it.addCancellationListener(new Runnable() { // from class: androidx.work.xoIox
            @Override // java.lang.Runnable
            public final void run() {
                atomicBoolean.set(true);
            }
        }, DirectExecutor.INSTANCE);
        executor.execute(new Runnable() { // from class: androidx.work.OOXIXo
            @Override // java.lang.Runnable
            public final void run() {
                WorkerKt.future$lambda$2$lambda$1(atomicBoolean, it, oix0oi);
            }
        });
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void future$lambda$2$lambda$1(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, Oox.oIX0oI oix0oi) {
        if (atomicBoolean.get()) {
            return;
        }
        try {
            completer.set(oix0oi.invoke());
        } catch (Throwable th) {
            completer.setException(th);
        }
    }
}

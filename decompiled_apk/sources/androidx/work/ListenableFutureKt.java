package androidx.work;

import Oox.x0xO0oo;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xII;

/* loaded from: classes.dex */
public final class ListenableFutureKt {
    @OXOo.OOXIXo
    public static final <V> ListenableFuture<V> executeAsync(@OXOo.OOXIXo final Executor executor, @OXOo.OOXIXo final String debugTag, @OXOo.OOXIXo final Oox.oIX0oI<? extends V> block) {
        IIX0o.x0xO0oo(executor, "<this>");
        IIX0o.x0xO0oo(debugTag, "debugTag");
        IIX0o.x0xO0oo(block, "block");
        ListenableFuture<V> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.work.II0xO0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                Object executeAsync$lambda$4;
                executeAsync$lambda$4 = ListenableFutureKt.executeAsync$lambda$4(executor, debugTag, block, completer);
                return executeAsync$lambda$4;
            }
        });
        IIX0o.oO(future, "getFuture { completer ->… }\n        debugTag\n    }");
        return future;
    }

    public static final Object executeAsync$lambda$4(Executor executor, String str, final Oox.oIX0oI oix0oi, final CallbackToFutureAdapter.Completer completer) {
        IIX0o.x0xO0oo(completer, "completer");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new Runnable() { // from class: androidx.work.oxoX
            @Override // java.lang.Runnable
            public final void run() {
                atomicBoolean.set(true);
            }
        }, DirectExecutor.INSTANCE);
        executor.execute(new Runnable() { // from class: androidx.work.X0o0xo
            @Override // java.lang.Runnable
            public final void run() {
                ListenableFutureKt.executeAsync$lambda$4$lambda$3(atomicBoolean, completer, oix0oi);
            }
        });
        return str;
    }

    public static final void executeAsync$lambda$4$lambda$3(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, Oox.oIX0oI oix0oi) {
        if (atomicBoolean.get()) {
            return;
        }
        try {
            completer.set(oix0oi.invoke());
        } catch (Throwable th) {
            completer.setException(th);
        }
    }

    @OXOo.OOXIXo
    public static final <T> ListenableFuture<T> launchFuture(@OXOo.OOXIXo final CoroutineContext context, @OXOo.OOXIXo final CoroutineStart start, @OXOo.OOXIXo final x0xO0oo<? super xII, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> block) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(start, "start");
        IIX0o.x0xO0oo(block, "block");
        ListenableFuture<T> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.work.I0Io
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                Object launchFuture$lambda$1;
                launchFuture$lambda$1 = ListenableFutureKt.launchFuture$lambda$1(CoroutineContext.this, start, block, completer);
                return launchFuture$lambda$1;
            }
        });
        IIX0o.oO(future, "getFuture { completer ->…owable)\n        }\n    }\n}");
        return future;
    }

    public static /* synthetic */ ListenableFuture launchFuture$default(CoroutineContext coroutineContext, CoroutineStart coroutineStart, x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return launchFuture(coroutineContext, coroutineStart, x0xo0oo);
    }

    public static final Object launchFuture$lambda$1(CoroutineContext coroutineContext, CoroutineStart coroutineStart, x0xO0oo x0xo0oo, CallbackToFutureAdapter.Completer completer) {
        oXIO0o0XI XO2;
        IIX0o.x0xO0oo(completer, "completer");
        final oXIO0o0XI oxio0o0xi = (oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f30343xxIXOIIO);
        completer.addCancellationListener(new Runnable() { // from class: androidx.work.XO
            @Override // java.lang.Runnable
            public final void run() {
                ListenableFutureKt.launchFuture$lambda$1$lambda$0(oXIO0o0XI.this);
            }
        }, DirectExecutor.INSTANCE);
        XO2 = kotlinx.coroutines.xoIox.XO(x0o.oIX0oI(coroutineContext), null, coroutineStart, new ListenableFutureKt$launchFuture$1$2(x0xo0oo, completer, null), 1, null);
        return XO2;
    }

    public static final void launchFuture$lambda$1$lambda$0(oXIO0o0XI oxio0o0xi) {
        if (oxio0o0xi != null) {
            oXIO0o0XI.oIX0oI.II0xO0(oxio0o0xi, null, 1, null);
        }
    }
}

package androidx.work;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import com.huawei.openalliance.ad.constant.bn;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.oXIO0o0XI;
import kotlinx.coroutines.x0o;
import kotlinx.coroutines.xII;
import kotlinx.coroutines.xoIox;

public final class ListenableFutureKt {
    @OOXIXo
    public static final <V> ListenableFuture<V> executeAsync(@OOXIXo Executor executor, @OOXIXo String str, @OOXIXo oIX0oI<? extends V> oix0oi) {
        IIX0o.x0xO0oo(executor, "<this>");
        IIX0o.x0xO0oo(str, "debugTag");
        IIX0o.x0xO0oo(oix0oi, "block");
        ListenableFuture<V> future = CallbackToFutureAdapter.getFuture(new II0xO0(executor, str, oix0oi));
        IIX0o.oO(future, "getFuture { completer ->… }\n        debugTag\n    }");
        return future;
    }

    /* access modifiers changed from: private */
    public static final Object executeAsync$lambda$4(Executor executor, String str, oIX0oI oix0oi, CallbackToFutureAdapter.Completer completer) {
        IIX0o.x0xO0oo(completer, "completer");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new oxoX(atomicBoolean), DirectExecutor.INSTANCE);
        executor.execute(new X0o0xo(atomicBoolean, completer, oix0oi));
        return str;
    }

    /* access modifiers changed from: private */
    public static final void executeAsync$lambda$4$lambda$2(AtomicBoolean atomicBoolean) {
        atomicBoolean.set(true);
    }

    /* access modifiers changed from: private */
    public static final void executeAsync$lambda$4$lambda$3(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, oIX0oI oix0oi) {
        if (!atomicBoolean.get()) {
            try {
                completer.set(oix0oi.invoke());
            } catch (Throwable th) {
                completer.setException(th);
            }
        }
    }

    @OOXIXo
    public static final <T> ListenableFuture<T> launchFuture(@OOXIXo CoroutineContext coroutineContext, @OOXIXo CoroutineStart coroutineStart, @OOXIXo x0xO0oo<? super xII, ? super I0Io<? super T>, ? extends Object> x0xo0oo) {
        IIX0o.x0xO0oo(coroutineContext, bn.f.o);
        IIX0o.x0xO0oo(coroutineStart, "start");
        IIX0o.x0xO0oo(x0xo0oo, "block");
        ListenableFuture<T> future = CallbackToFutureAdapter.getFuture(new I0Io(coroutineContext, coroutineStart, x0xo0oo));
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

    /* access modifiers changed from: private */
    public static final Object launchFuture$lambda$1(CoroutineContext coroutineContext, CoroutineStart coroutineStart, x0xO0oo x0xo0oo, CallbackToFutureAdapter.Completer completer) {
        IIX0o.x0xO0oo(completer, "completer");
        completer.addCancellationListener(new XO((oXIO0o0XI) coroutineContext.get(oXIO0o0XI.f20106xxIXOIIO)), DirectExecutor.INSTANCE);
        return xoIox.XO(x0o.oIX0oI(coroutineContext), (CoroutineContext) null, coroutineStart, new ListenableFutureKt$launchFuture$1$2(x0xo0oo, completer, (I0Io<? super ListenableFutureKt$launchFuture$1$2>) null), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void launchFuture$lambda$1$lambda$0(oXIO0o0XI oxio0o0xi) {
        if (oxio0o0xi != null) {
            oXIO0o0XI.oIX0oI.II0xO0(oxio0o0xi, (CancellationException) null, 1, (Object) null);
        }
    }
}

package androidx.work;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.work.ListenableWorker;
import com.facebook.internal.NativeProtocol;
import com.google.common.util.concurrent.ListenableFuture;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.intrinsics.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Ox0O;
import kotlinx.coroutines.Xo0;
import kotlinx.coroutines.oXIO0o0XI;

public abstract class CoroutineWorker extends ListenableWorker {
    @OOXIXo
    private final CoroutineDispatcher coroutineContext = DeprecatedDispatcher.INSTANCE;
    @OOXIXo
    private final WorkerParameters params;

    public static final class DeprecatedDispatcher extends CoroutineDispatcher {
        @OOXIXo
        public static final DeprecatedDispatcher INSTANCE = new DeprecatedDispatcher();
        @OOXIXo
        private static final CoroutineDispatcher dispatcher = Xo0.oIX0oI();

        private DeprecatedDispatcher() {
        }

        public void dispatch(@OOXIXo CoroutineContext coroutineContext, @OOXIXo Runnable runnable) {
            IIX0o.x0xO0oo(coroutineContext, bn.f.o);
            IIX0o.x0xO0oo(runnable, "block");
            dispatcher.dispatch(coroutineContext, runnable);
        }

        @OOXIXo
        public final CoroutineDispatcher getDispatcher() {
            return dispatcher;
        }

        public boolean isDispatchNeeded(@OOXIXo CoroutineContext coroutineContext) {
            IIX0o.x0xO0oo(coroutineContext, bn.f.o);
            return dispatcher.isDispatchNeeded(coroutineContext);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(@OOXIXo Context context, @OOXIXo WorkerParameters workerParameters) {
        super(context, workerParameters);
        IIX0o.x0xO0oo(context, "appContext");
        IIX0o.x0xO0oo(workerParameters, NativeProtocol.WEB_DIALOG_PARAMS);
        this.params = workerParameters;
    }

    @kotlin.OOXIXo(message = "use withContext(...) inside doWork() instead.")
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    public static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, I0Io<? super ForegroundInfo> i0Io) {
        throw new IllegalStateException("Not implemented");
    }

    @oOoXoXO
    public abstract Object doWork(@OOXIXo I0Io<? super ListenableWorker.Result> i0Io);

    @OOXIXo
    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    @oOoXoXO
    public Object getForegroundInfo(@OOXIXo I0Io<? super ForegroundInfo> i0Io) {
        return getForegroundInfo$suspendImpl(this, i0Io);
    }

    @OOXIXo
    public final ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        return ListenableFutureKt.launchFuture$default(getCoroutineContext().plus(Ox0O.I0Io((oXIO0o0XI) null, 1, (Object) null)), (CoroutineStart) null, new CoroutineWorker$getForegroundInfoAsync$1(this, (I0Io<? super CoroutineWorker$getForegroundInfoAsync$1>) null), 2, (Object) null);
    }

    public final void onStopped() {
        super.onStopped();
    }

    @oOoXoXO
    public final Object setForeground(@OOXIXo ForegroundInfo foregroundInfo, @OOXIXo I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        ListenableFuture<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        IIX0o.oO(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        Object await = ListenableFutureKt.await(foregroundAsync, i0Io);
        if (await == II0xO0.oOoXoXO()) {
            return await;
        }
        return kotlin.oXIO0o0XI.f19155oIX0oI;
    }

    @oOoXoXO
    public final Object setProgress(@OOXIXo Data data, @OOXIXo I0Io<? super kotlin.oXIO0o0XI> i0Io) {
        ListenableFuture<Void> progressAsync = setProgressAsync(data);
        IIX0o.oO(progressAsync, "setProgressAsync(data)");
        Object await = ListenableFutureKt.await(progressAsync, i0Io);
        if (await == II0xO0.oOoXoXO()) {
            return await;
        }
        return kotlin.oXIO0o0XI.f19155oIX0oI;
    }

    @OOXIXo
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        CoroutineContext coroutineContext2;
        if (!IIX0o.Oxx0IOOO(getCoroutineContext(), DeprecatedDispatcher.INSTANCE)) {
            coroutineContext2 = getCoroutineContext();
        } else {
            coroutineContext2 = this.params.getWorkerContext();
        }
        IIX0o.oO(coroutineContext2, "if (coroutineContext != …rkerContext\n            }");
        return ListenableFutureKt.launchFuture$default(coroutineContext2.plus(Ox0O.I0Io((oXIO0o0XI) null, 1, (Object) null)), (CoroutineStart) null, new CoroutineWorker$startWork$1(this, (I0Io<? super CoroutineWorker$startWork$1>) null), 2, (Object) null);
    }
}

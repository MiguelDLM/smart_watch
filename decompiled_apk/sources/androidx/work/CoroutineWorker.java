package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Ox0O;
import kotlinx.coroutines.XI0IXoo;
import kotlinx.coroutines.Xo0;

/* loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {

    @OXOo.OOXIXo
    private final CoroutineDispatcher coroutineContext;

    @OXOo.OOXIXo
    private final WorkerParameters params;

    /* loaded from: classes.dex */
    public static final class DeprecatedDispatcher extends CoroutineDispatcher {

        @OXOo.OOXIXo
        public static final DeprecatedDispatcher INSTANCE = new DeprecatedDispatcher();

        @OXOo.OOXIXo
        private static final CoroutineDispatcher dispatcher = Xo0.oIX0oI();

        private DeprecatedDispatcher() {
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public void dispatch(@OXOo.OOXIXo CoroutineContext context, @OXOo.OOXIXo Runnable block) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(block, "block");
            dispatcher.dispatch(context, block);
        }

        @OXOo.OOXIXo
        public final CoroutineDispatcher getDispatcher() {
            return dispatcher;
        }

        @Override // kotlinx.coroutines.CoroutineDispatcher
        public boolean isDispatchNeeded(@OXOo.OOXIXo CoroutineContext context) {
            IIX0o.x0xO0oo(context, "context");
            return dispatcher.isDispatchNeeded(context);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(@OXOo.OOXIXo Context appContext, @OXOo.OOXIXo WorkerParameters params) {
        super(appContext, params);
        IIX0o.x0xO0oo(appContext, "appContext");
        IIX0o.x0xO0oo(params, "params");
        this.params = params;
        this.coroutineContext = DeprecatedDispatcher.INSTANCE;
    }

    @kotlin.OOXIXo(message = "use withContext(...) inside doWork() instead.")
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    public static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, kotlin.coroutines.I0Io<? super ForegroundInfo> i0Io) {
        throw new IllegalStateException("Not implemented");
    }

    @OXOo.oOoXoXO
    public abstract Object doWork(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super ListenableWorker.Result> i0Io);

    @OXOo.OOXIXo
    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    @OXOo.oOoXoXO
    public Object getForegroundInfo(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super ForegroundInfo> i0Io) {
        return getForegroundInfo$suspendImpl(this, i0Io);
    }

    @Override // androidx.work.ListenableWorker
    @OXOo.OOXIXo
    public final ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        XI0IXoo I0Io2;
        CoroutineDispatcher coroutineContext = getCoroutineContext();
        I0Io2 = Ox0O.I0Io(null, 1, null);
        return ListenableFutureKt.launchFuture$default(coroutineContext.plus(I0Io2), null, new CoroutineWorker$getForegroundInfoAsync$1(this, null), 2, null);
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
    }

    @OXOo.oOoXoXO
    public final Object setForeground(@OXOo.OOXIXo ForegroundInfo foregroundInfo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        ListenableFuture<Void> foregroundAsync = setForegroundAsync(foregroundInfo);
        IIX0o.oO(foregroundAsync, "setForegroundAsync(foregroundInfo)");
        Object await = androidx.concurrent.futures.ListenableFutureKt.await(foregroundAsync, i0Io);
        if (await == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return await;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @OXOo.oOoXoXO
    public final Object setProgress(@OXOo.OOXIXo Data data, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        ListenableFuture<Void> progressAsync = setProgressAsync(data);
        IIX0o.oO(progressAsync, "setProgressAsync(data)");
        Object await = androidx.concurrent.futures.ListenableFutureKt.await(progressAsync, i0Io);
        if (await == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return await;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // androidx.work.ListenableWorker
    @OXOo.OOXIXo
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        CoroutineContext workerContext;
        XI0IXoo I0Io2;
        if (!IIX0o.Oxx0IOOO(getCoroutineContext(), DeprecatedDispatcher.INSTANCE)) {
            workerContext = getCoroutineContext();
        } else {
            workerContext = this.params.getWorkerContext();
        }
        IIX0o.oO(workerContext, "if (coroutineContext != …rkerContext\n            }");
        I0Io2 = Ox0O.I0Io(null, 1, null);
        return ListenableFutureKt.launchFuture$default(workerContext.plus(I0Io2), null, new CoroutineWorker$startWork$1(this, null), 2, null);
    }
}

package androidx.work;

import android.content.Context;
import androidx.annotation.WorkerThread;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Worker(@OXOo.OOXIXo Context context, @OXOo.OOXIXo WorkerParameters workerParams) {
        super(context, workerParams);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(workerParams, "workerParams");
    }

    @OXOo.OOXIXo
    @WorkerThread
    public abstract ListenableWorker.Result doWork();

    @OXOo.OOXIXo
    @WorkerThread
    public ForegroundInfo getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for `getForegroundInfo()`");
    }

    @Override // androidx.work.ListenableWorker
    @OXOo.OOXIXo
    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        ListenableFuture<ForegroundInfo> future;
        Executor backgroundExecutor = getBackgroundExecutor();
        IIX0o.oO(backgroundExecutor, "backgroundExecutor");
        future = WorkerKt.future(backgroundExecutor, new Oox.oIX0oI<ForegroundInfo>() { // from class: androidx.work.Worker$getForegroundInfoAsync$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ForegroundInfo invoke() {
                return Worker.this.getForegroundInfo();
            }
        });
        return future;
    }

    @Override // androidx.work.ListenableWorker
    @OXOo.OOXIXo
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        ListenableFuture<ListenableWorker.Result> future;
        Executor backgroundExecutor = getBackgroundExecutor();
        IIX0o.oO(backgroundExecutor, "backgroundExecutor");
        future = WorkerKt.future(backgroundExecutor, new Oox.oIX0oI<ListenableWorker.Result>() { // from class: androidx.work.Worker$startWork$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ListenableWorker.Result invoke() {
                return Worker.this.doWork();
            }
        });
        return future;
    }
}

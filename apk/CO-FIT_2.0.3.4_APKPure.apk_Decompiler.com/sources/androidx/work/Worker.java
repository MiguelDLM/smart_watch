package androidx.work;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.annotation.WorkerThread;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import com.huawei.openalliance.ad.constant.bn;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;

public abstract class Worker extends ListenableWorker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Worker(@OOXIXo Context context, @OOXIXo WorkerParameters workerParameters) {
        super(context, workerParameters);
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(workerParameters, "workerParams");
    }

    @WorkerThread
    @OOXIXo
    public abstract ListenableWorker.Result doWork();

    @WorkerThread
    @OOXIXo
    public ForegroundInfo getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for `getForegroundInfo()`");
    }

    @OOXIXo
    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        Executor backgroundExecutor = getBackgroundExecutor();
        IIX0o.oO(backgroundExecutor, "backgroundExecutor");
        return WorkerKt.future(backgroundExecutor, new Worker$getForegroundInfoAsync$1(this));
    }

    @OOXIXo
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        Executor backgroundExecutor = getBackgroundExecutor();
        IIX0o.oO(backgroundExecutor, "backgroundExecutor");
        return WorkerKt.future(backgroundExecutor, new Worker$startWork$1(this));
    }
}

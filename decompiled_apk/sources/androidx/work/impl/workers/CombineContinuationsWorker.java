package androidx.work.impl.workers;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class CombineContinuationsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineContinuationsWorker(@OOXIXo Context context, @OOXIXo WorkerParameters workerParams) {
        super(context, workerParams);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(workerParams, "workerParams");
    }

    @Override // androidx.work.Worker
    @OOXIXo
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result success = ListenableWorker.Result.success(getInputData());
        IIX0o.oO(success, "success(inputData)");
        return success;
    }
}

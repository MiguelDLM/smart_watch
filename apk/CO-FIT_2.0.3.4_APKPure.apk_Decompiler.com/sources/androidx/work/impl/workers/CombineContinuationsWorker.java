package androidx.work.impl.workers;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;

public final class CombineContinuationsWorker extends Worker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineContinuationsWorker(@OOXIXo Context context, @OOXIXo WorkerParameters workerParameters) {
        super(context, workerParameters);
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(workerParameters, "workerParams");
    }

    @OOXIXo
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result success = ListenableWorker.Result.success(getInputData());
        IIX0o.oO(success, "success(inputData)");
        return success;
    }
}

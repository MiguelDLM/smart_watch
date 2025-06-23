package androidx.work.impl.workers;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import com.huawei.openalliance.ad.constant.bn;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;

public final class DiagnosticsWorker extends Worker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(@OOXIXo Context context, @OOXIXo WorkerParameters workerParameters) {
        super(context, workerParameters);
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(workerParameters, "parameters");
    }

    @OOXIXo
    public ListenableWorker.Result doWork() {
        WorkManagerImpl instance = WorkManagerImpl.getInstance(getApplicationContext());
        IIX0o.oO(instance, "getInstance(applicationContext)");
        WorkDatabase workDatabase = instance.getWorkDatabase();
        IIX0o.oO(workDatabase, "workManager.workDatabase");
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkNameDao workNameDao = workDatabase.workNameDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        List<WorkSpec> recentlyCompletedWork = workSpecDao.getRecentlyCompletedWork(instance.getConfiguration().getClock().currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<WorkSpec> runningWork = workSpecDao.getRunningWork();
        List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
        if (!recentlyCompletedWork.isEmpty()) {
            Logger.get().info(DiagnosticsWorkerKt.TAG, "Recently completed work:\n\n");
            Logger.get().info(DiagnosticsWorkerKt.TAG, DiagnosticsWorkerKt.workSpecRows(workNameDao, workTagDao, systemIdInfoDao, recentlyCompletedWork));
        }
        if (!runningWork.isEmpty()) {
            Logger.get().info(DiagnosticsWorkerKt.TAG, "Running work:\n\n");
            Logger.get().info(DiagnosticsWorkerKt.TAG, DiagnosticsWorkerKt.workSpecRows(workNameDao, workTagDao, systemIdInfoDao, runningWork));
        }
        if (!allEligibleWorkSpecsForScheduling.isEmpty()) {
            Logger.get().info(DiagnosticsWorkerKt.TAG, "Enqueued work:\n\n");
            Logger.get().info(DiagnosticsWorkerKt.TAG, DiagnosticsWorkerKt.workSpecRows(workNameDao, workTagDao, systemIdInfoDao, allEligibleWorkSpecsForScheduling));
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        IIX0o.oO(success, "success()");
        return success;
    }
}

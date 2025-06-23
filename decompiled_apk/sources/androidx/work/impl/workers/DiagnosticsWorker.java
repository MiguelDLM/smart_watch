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
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(@OOXIXo Context context, @OOXIXo WorkerParameters parameters) {
        super(context, parameters);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(parameters, "parameters");
    }

    @Override // androidx.work.Worker
    @OOXIXo
    public ListenableWorker.Result doWork() {
        String str;
        String str2;
        String workSpecRows;
        String str3;
        String str4;
        String workSpecRows2;
        String str5;
        String str6;
        String workSpecRows3;
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
        IIX0o.oO(workManagerImpl, "getInstance(applicationContext)");
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        IIX0o.oO(workDatabase, "workManager.workDatabase");
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkNameDao workNameDao = workDatabase.workNameDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        List<WorkSpec> recentlyCompletedWork = workSpecDao.getRecentlyCompletedWork(workManagerImpl.getConfiguration().getClock().currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<WorkSpec> runningWork = workSpecDao.getRunningWork();
        List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
        if (!recentlyCompletedWork.isEmpty()) {
            Logger logger = Logger.get();
            str5 = DiagnosticsWorkerKt.TAG;
            logger.info(str5, "Recently completed work:\n\n");
            Logger logger2 = Logger.get();
            str6 = DiagnosticsWorkerKt.TAG;
            workSpecRows3 = DiagnosticsWorkerKt.workSpecRows(workNameDao, workTagDao, systemIdInfoDao, recentlyCompletedWork);
            logger2.info(str6, workSpecRows3);
        }
        if (!runningWork.isEmpty()) {
            Logger logger3 = Logger.get();
            str3 = DiagnosticsWorkerKt.TAG;
            logger3.info(str3, "Running work:\n\n");
            Logger logger4 = Logger.get();
            str4 = DiagnosticsWorkerKt.TAG;
            workSpecRows2 = DiagnosticsWorkerKt.workSpecRows(workNameDao, workTagDao, systemIdInfoDao, runningWork);
            logger4.info(str4, workSpecRows2);
        }
        if (!allEligibleWorkSpecsForScheduling.isEmpty()) {
            Logger logger5 = Logger.get();
            str = DiagnosticsWorkerKt.TAG;
            logger5.info(str, "Enqueued work:\n\n");
            Logger logger6 = Logger.get();
            str2 = DiagnosticsWorkerKt.TAG;
            workSpecRows = DiagnosticsWorkerKt.workSpecRows(workNameDao, workTagDao, systemIdInfoDao, allEligibleWorkSpecsForScheduling);
            logger6.info(str2, workSpecRows);
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        IIX0o.oO(success, "success()");
        return success;
    }
}

package androidx.work.impl;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import androidx.annotation.RestrictTo;
import androidx.work.BackoffPolicy;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableFutureKt;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.Tracer;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWorkerUpdater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerUpdater.kt\nandroidx/work/impl/WorkerUpdater\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,165:1\n1855#2,2:166\n*S KotlinDebug\n*F\n+ 1 WorkerUpdater.kt\nandroidx/work/impl/WorkerUpdater\n*L\n56#1:166,2\n*E\n"})
@xxIXOIIO(name = "WorkerUpdater")
public final class WorkerUpdater {
    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Operation enqueueUniquelyNamedPeriodic(@OOXIXo WorkManagerImpl workManagerImpl, @OOXIXo String str, @OOXIXo WorkRequest workRequest) {
        IIX0o.x0xO0oo(workManagerImpl, "<this>");
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(workRequest, "workRequest");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String str2 = "enqueueUniquePeriodic_" + str;
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
        return OperationKt.launchOperation(tracer, str2, serialTaskExecutor, new WorkerUpdater$enqueueUniquelyNamedPeriodic$1(workManagerImpl, str, workRequest));
    }

    /* access modifiers changed from: private */
    public static final WorkManager.UpdateResult updateWorkImpl(Processor processor, WorkDatabase workDatabase, Configuration configuration, List<? extends Scheduler> list, WorkSpec workSpec, Set<String> set) {
        String str = workSpec.id;
        WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec2 == null) {
            throw new IllegalArgumentException("Worker with " + str + " doesn't exist");
        } else if (workSpec2.state.isFinished()) {
            return WorkManager.UpdateResult.NOT_APPLIED;
        } else {
            if (!(workSpec2.isPeriodic() ^ workSpec.isPeriodic())) {
                boolean isEnqueued = processor.isEnqueued(str);
                if (!isEnqueued) {
                    for (Scheduler cancel : list) {
                        cancel.cancel(str);
                    }
                }
                workDatabase.runInTransaction((Runnable) new x0XOIxOo(workDatabase, workSpec2, workSpec, list, str, set, isEnqueued));
                if (!isEnqueued) {
                    Schedulers.schedule(configuration, workDatabase, list);
                }
                return isEnqueued ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
            }
            WorkerUpdater$updateWorkImpl$type$1 workerUpdater$updateWorkImpl$type$1 = WorkerUpdater$updateWorkImpl$type$1.INSTANCE;
            throw new UnsupportedOperationException("Can't update " + ((String) workerUpdater$updateWorkImpl$type$1.invoke(workSpec2)) + " Worker to " + ((String) workerUpdater$updateWorkImpl$type$1.invoke(workSpec)) + " Worker. Update operation must preserve worker's type.");
        }
    }

    /* access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$2(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String str, Set set, boolean z) {
        WorkSpec workSpec3 = workSpec;
        String str2 = str;
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        WorkTagDao workTagDao2 = workTagDao;
        WorkSpecDao workSpecDao2 = workSpecDao;
        WorkSpec copy$default = WorkSpec.copy$default(workSpec2, (String) null, workSpec3.state, (String) null, (String) null, (Data) null, (Data) null, 0, 0, 0, (Constraints) null, workSpec3.runAttemptCount, (BackoffPolicy) null, 0, workSpec3.lastEnqueueTime, 0, 0, false, (OutOfQuotaPolicy) null, workSpec.getPeriodCount(), workSpec.getGeneration() + 1, workSpec.getNextScheduleTimeOverride(), workSpec.getNextScheduleTimeOverrideGeneration(), 0, (String) null, 12835837, (Object) null);
        if (workSpec2.getNextScheduleTimeOverrideGeneration() == 1) {
            copy$default.setNextScheduleTimeOverride(workSpec2.getNextScheduleTimeOverride());
            copy$default.setNextScheduleTimeOverrideGeneration(copy$default.getNextScheduleTimeOverrideGeneration() + 1);
        }
        WorkSpecDao workSpecDao3 = workSpecDao2;
        workSpecDao3.updateWorkSpec(EnqueueUtilsKt.wrapWorkSpecIfNeeded(list, copy$default));
        workTagDao2.deleteByWorkSpecId(str2);
        workTagDao2.insertTags(str2, set);
        if (!z) {
            workSpecDao3.markWorkSpecScheduled(str2, -1);
            workDatabase.workProgressDao().delete(str2);
        }
    }

    @OOXIXo
    public static final ListenableFuture<WorkManager.UpdateResult> updateWorkImpl(@OOXIXo WorkManagerImpl workManagerImpl, @OOXIXo WorkRequest workRequest) {
        IIX0o.x0xO0oo(workManagerImpl, "<this>");
        IIX0o.x0xO0oo(workRequest, "workRequest");
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "updateWorkImpl", new WorkerUpdater$updateWorkImpl$3(workManagerImpl, workRequest));
    }
}

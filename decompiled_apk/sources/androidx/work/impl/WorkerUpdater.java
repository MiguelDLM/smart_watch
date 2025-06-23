package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableFutureKt;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XO0OX.xxIXOIIO(name = "WorkerUpdater")
@XX({"SMAP\nWorkerUpdater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkerUpdater.kt\nandroidx/work/impl/WorkerUpdater\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,165:1\n1855#2,2:166\n*S KotlinDebug\n*F\n+ 1 WorkerUpdater.kt\nandroidx/work/impl/WorkerUpdater\n*L\n56#1:166,2\n*E\n"})
/* loaded from: classes.dex */
public final class WorkerUpdater {
    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Operation enqueueUniquelyNamedPeriodic(@OXOo.OOXIXo final WorkManagerImpl workManagerImpl, @OXOo.OOXIXo final String name, @OXOo.OOXIXo final WorkRequest workRequest) {
        IIX0o.x0xO0oo(workManagerImpl, "<this>");
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(workRequest, "workRequest");
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String str = "enqueueUniquePeriodic_" + name;
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
        return OperationKt.launchOperation(tracer, str, serialTaskExecutor, new Oox.oIX0oI<oXIO0o0XI>() { // from class: androidx.work.impl.WorkerUpdater$enqueueUniquelyNamedPeriodic$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final WorkRequest workRequest2 = workRequest;
                final WorkManagerImpl workManagerImpl2 = WorkManagerImpl.this;
                final String str2 = name;
                Oox.oIX0oI<oXIO0o0XI> oix0oi = new Oox.oIX0oI<oXIO0o0XI>() { // from class: androidx.work.impl.WorkerUpdater$enqueueUniquelyNamedPeriodic$1$enqueueNew$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                        invoke2();
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        EnqueueRunnable.enqueue(new WorkContinuationImpl(workManagerImpl2, str2, ExistingWorkPolicy.KEEP, oI0IIXIo.OOXIXo(WorkRequest.this)));
                    }
                };
                WorkSpecDao workSpecDao = WorkManagerImpl.this.getWorkDatabase().workSpecDao();
                List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workSpecDao.getWorkSpecIdAndStatesForName(name);
                if (workSpecIdAndStatesForName.size() <= 1) {
                    WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) CollectionsKt___CollectionsKt.XxXX(workSpecIdAndStatesForName);
                    if (idAndState == null) {
                        oix0oi.invoke();
                        return;
                    }
                    WorkSpec workSpec = workSpecDao.getWorkSpec(idAndState.id);
                    if (workSpec != null) {
                        if (workSpec.isPeriodic()) {
                            if (idAndState.state == WorkInfo.State.CANCELLED) {
                                workSpecDao.delete(idAndState.id);
                                oix0oi.invoke();
                                return;
                            }
                            WorkSpec copy$default = WorkSpec.copy$default(workRequest.getWorkSpec(), idAndState.id, null, null, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, 16777214, null);
                            Processor processor = WorkManagerImpl.this.getProcessor();
                            IIX0o.oO(processor, "processor");
                            WorkDatabase workDatabase = WorkManagerImpl.this.getWorkDatabase();
                            IIX0o.oO(workDatabase, "workDatabase");
                            Configuration configuration = WorkManagerImpl.this.getConfiguration();
                            IIX0o.oO(configuration, "configuration");
                            List<Scheduler> schedulers = WorkManagerImpl.this.getSchedulers();
                            IIX0o.oO(schedulers, "schedulers");
                            WorkerUpdater.updateWorkImpl(processor, workDatabase, configuration, schedulers, copy$default, workRequest.getTags());
                            return;
                        }
                        throw new UnsupportedOperationException("Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
                    }
                    throw new IllegalStateException("WorkSpec with " + idAndState.id + ", that matches a name \"" + name + "\", wasn't found");
                }
                throw new UnsupportedOperationException("Can't apply UPDATE policy to the chains of work.");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkManager.UpdateResult updateWorkImpl(Processor processor, final WorkDatabase workDatabase, Configuration configuration, final List<? extends Scheduler> list, final WorkSpec workSpec, final Set<String> set) {
        final String str = workSpec.id;
        final WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec2 != null) {
            if (workSpec2.state.isFinished()) {
                return WorkManager.UpdateResult.NOT_APPLIED;
            }
            if (!(workSpec2.isPeriodic() ^ workSpec.isPeriodic())) {
                final boolean isEnqueued = processor.isEnqueued(str);
                if (!isEnqueued) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        ((Scheduler) it.next()).cancel(str);
                    }
                }
                workDatabase.runInTransaction(new Runnable() { // from class: androidx.work.impl.x0XOIxOo
                    @Override // java.lang.Runnable
                    public final void run() {
                        WorkerUpdater.updateWorkImpl$lambda$2(WorkDatabase.this, workSpec2, workSpec, list, str, set, isEnqueued);
                    }
                });
                if (!isEnqueued) {
                    Schedulers.schedule(configuration, workDatabase, list);
                }
                return isEnqueued ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
            }
            WorkerUpdater$updateWorkImpl$type$1 workerUpdater$updateWorkImpl$type$1 = new Oox.oOoXoXO<WorkSpec, String>() { // from class: androidx.work.impl.WorkerUpdater$updateWorkImpl$type$1
                @Override // Oox.oOoXoXO
                public final String invoke(WorkSpec spec) {
                    IIX0o.x0xO0oo(spec, "spec");
                    return spec.isPeriodic() ? "Periodic" : "OneTime";
                }
            };
            throw new UnsupportedOperationException("Can't update " + workerUpdater$updateWorkImpl$type$1.invoke((WorkerUpdater$updateWorkImpl$type$1) workSpec2) + " Worker to " + workerUpdater$updateWorkImpl$type$1.invoke((WorkerUpdater$updateWorkImpl$type$1) workSpec) + " Worker. Update operation must preserve worker's type.");
        }
        throw new IllegalArgumentException("Worker with " + str + " doesn't exist");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$2(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String str, Set set, boolean z) {
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        WorkSpec copy$default = WorkSpec.copy$default(workSpec2, null, workSpec.state, null, null, null, null, 0L, 0L, 0L, null, workSpec.runAttemptCount, null, 0L, workSpec.lastEnqueueTime, 0L, 0L, false, null, workSpec.getPeriodCount(), workSpec.getGeneration() + 1, workSpec.getNextScheduleTimeOverride(), workSpec.getNextScheduleTimeOverrideGeneration(), 0, null, 12835837, null);
        if (workSpec2.getNextScheduleTimeOverrideGeneration() == 1) {
            copy$default.setNextScheduleTimeOverride(workSpec2.getNextScheduleTimeOverride());
            copy$default.setNextScheduleTimeOverrideGeneration(copy$default.getNextScheduleTimeOverrideGeneration() + 1);
        }
        workSpecDao.updateWorkSpec(EnqueueUtilsKt.wrapWorkSpecIfNeeded(list, copy$default));
        workTagDao.deleteByWorkSpecId(str);
        workTagDao.insertTags(str, set);
        if (!z) {
            workSpecDao.markWorkSpecScheduled(str, -1L);
            workDatabase.workProgressDao().delete(str);
        }
    }

    @OXOo.OOXIXo
    public static final ListenableFuture<WorkManager.UpdateResult> updateWorkImpl(@OXOo.OOXIXo final WorkManagerImpl workManagerImpl, @OXOo.OOXIXo final WorkRequest workRequest) {
        IIX0o.x0xO0oo(workManagerImpl, "<this>");
        IIX0o.x0xO0oo(workRequest, "workRequest");
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "updateWorkImpl", new Oox.oIX0oI<WorkManager.UpdateResult>() { // from class: androidx.work.impl.WorkerUpdater$updateWorkImpl$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final WorkManager.UpdateResult invoke() {
                WorkManager.UpdateResult updateWorkImpl;
                Processor processor = WorkManagerImpl.this.getProcessor();
                IIX0o.oO(processor, "processor");
                WorkDatabase workDatabase = WorkManagerImpl.this.getWorkDatabase();
                IIX0o.oO(workDatabase, "workDatabase");
                Configuration configuration = WorkManagerImpl.this.getConfiguration();
                IIX0o.oO(configuration, "configuration");
                List<Scheduler> schedulers = WorkManagerImpl.this.getSchedulers();
                IIX0o.oO(schedulers, "schedulers");
                updateWorkImpl = WorkerUpdater.updateWorkImpl(processor, workDatabase, configuration, schedulers, workRequest.getWorkSpec(), workRequest.getTags());
                return updateWorkImpl;
            }
        });
    }
}

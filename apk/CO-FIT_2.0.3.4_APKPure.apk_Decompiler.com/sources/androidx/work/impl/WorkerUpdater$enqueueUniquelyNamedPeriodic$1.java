package androidx.work.impl;

import O0IoXXOx.XO;
import Oox.oIX0oI;
import androidx.work.BackoffPolicy;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class WorkerUpdater$enqueueUniquelyNamedPeriodic$1 extends Lambda implements oIX0oI<oXIO0o0XI> {
    final /* synthetic */ String $name;
    final /* synthetic */ WorkManagerImpl $this_enqueueUniquelyNamedPeriodic;
    final /* synthetic */ WorkRequest $workRequest;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkerUpdater$enqueueUniquelyNamedPeriodic$1(WorkManagerImpl workManagerImpl, String str, WorkRequest workRequest) {
        super(0);
        this.$this_enqueueUniquelyNamedPeriodic = workManagerImpl;
        this.$name = str;
        this.$workRequest = workRequest;
    }

    public final void invoke() {
        WorkerUpdater$enqueueUniquelyNamedPeriodic$1$enqueueNew$1 workerUpdater$enqueueUniquelyNamedPeriodic$1$enqueueNew$1 = new WorkerUpdater$enqueueUniquelyNamedPeriodic$1$enqueueNew$1(this.$workRequest, this.$this_enqueueUniquelyNamedPeriodic, this.$name);
        WorkSpecDao workSpecDao = this.$this_enqueueUniquelyNamedPeriodic.getWorkDatabase().workSpecDao();
        List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workSpecDao.getWorkSpecIdAndStatesForName(this.$name);
        if (workSpecIdAndStatesForName.size() <= 1) {
            WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) CollectionsKt___CollectionsKt.XxXX(workSpecIdAndStatesForName);
            if (idAndState == null) {
                workerUpdater$enqueueUniquelyNamedPeriodic$1$enqueueNew$1.invoke();
                return;
            }
            WorkSpec workSpec = workSpecDao.getWorkSpec(idAndState.id);
            if (workSpec == null) {
                throw new IllegalStateException("WorkSpec with " + idAndState.id + ", that matches a name \"" + this.$name + "\", wasn't found");
            } else if (!workSpec.isPeriodic()) {
                throw new UnsupportedOperationException("Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
            } else if (idAndState.state == WorkInfo.State.CANCELLED) {
                workSpecDao.delete(idAndState.id);
                workerUpdater$enqueueUniquelyNamedPeriodic$1$enqueueNew$1.invoke();
            } else {
                WorkSpec copy$default = WorkSpec.copy$default(this.$workRequest.getWorkSpec(), idAndState.id, (WorkInfo.State) null, (String) null, (String) null, (Data) null, (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 0, 0, 0, (String) null, 16777214, (Object) null);
                Processor processor = this.$this_enqueueUniquelyNamedPeriodic.getProcessor();
                IIX0o.oO(processor, "processor");
                WorkDatabase workDatabase = this.$this_enqueueUniquelyNamedPeriodic.getWorkDatabase();
                IIX0o.oO(workDatabase, "workDatabase");
                Configuration configuration = this.$this_enqueueUniquelyNamedPeriodic.getConfiguration();
                IIX0o.oO(configuration, XO.f15419Oxx0IOOO);
                List<Scheduler> schedulers = this.$this_enqueueUniquelyNamedPeriodic.getSchedulers();
                IIX0o.oO(schedulers, "schedulers");
                WorkManager.UpdateResult unused = WorkerUpdater.updateWorkImpl(processor, workDatabase, configuration, schedulers, copy$default, this.$workRequest.getTags());
            }
        } else {
            throw new UnsupportedOperationException("Can't apply UPDATE policy to the chains of work.");
        }
    }
}

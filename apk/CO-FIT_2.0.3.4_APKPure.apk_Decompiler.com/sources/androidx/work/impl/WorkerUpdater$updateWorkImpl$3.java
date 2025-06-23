package androidx.work.impl;

import O0IoXXOx.XO;
import Oox.oIX0oI;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class WorkerUpdater$updateWorkImpl$3 extends Lambda implements oIX0oI<WorkManager.UpdateResult> {
    final /* synthetic */ WorkManagerImpl $this_updateWorkImpl;
    final /* synthetic */ WorkRequest $workRequest;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkerUpdater$updateWorkImpl$3(WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        super(0);
        this.$this_updateWorkImpl = workManagerImpl;
        this.$workRequest = workRequest;
    }

    public final WorkManager.UpdateResult invoke() {
        Processor processor = this.$this_updateWorkImpl.getProcessor();
        IIX0o.oO(processor, "processor");
        WorkDatabase workDatabase = this.$this_updateWorkImpl.getWorkDatabase();
        IIX0o.oO(workDatabase, "workDatabase");
        Configuration configuration = this.$this_updateWorkImpl.getConfiguration();
        IIX0o.oO(configuration, XO.f15419Oxx0IOOO);
        List<Scheduler> schedulers = this.$this_updateWorkImpl.getSchedulers();
        IIX0o.oO(schedulers, "schedulers");
        return WorkerUpdater.updateWorkImpl(processor, workDatabase, configuration, schedulers, this.$workRequest.getWorkSpec(), this.$workRequest.getTags());
    }
}

package androidx.work.impl;

import Oox.oIX0oI;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class WorkerUpdater$enqueueUniquelyNamedPeriodic$1$enqueueNew$1 extends Lambda implements oIX0oI<oXIO0o0XI> {
    final /* synthetic */ String $name;
    final /* synthetic */ WorkManagerImpl $this_enqueueUniquelyNamedPeriodic;
    final /* synthetic */ WorkRequest $workRequest;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkerUpdater$enqueueUniquelyNamedPeriodic$1$enqueueNew$1(WorkRequest workRequest, WorkManagerImpl workManagerImpl, String str) {
        super(0);
        this.$workRequest = workRequest;
        this.$this_enqueueUniquelyNamedPeriodic = workManagerImpl;
        this.$name = str;
    }

    public final void invoke() {
        EnqueueRunnable.enqueue(new WorkContinuationImpl(this.$this_enqueueUniquelyNamedPeriodic, this.$name, ExistingWorkPolicy.KEEP, oI0IIXIo.OOXIXo(this.$workRequest)));
    }
}

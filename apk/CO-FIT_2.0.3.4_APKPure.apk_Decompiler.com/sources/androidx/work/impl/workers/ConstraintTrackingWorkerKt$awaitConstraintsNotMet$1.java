package androidx.work.impl.workers;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@oxoX(c = "androidx.work.impl.workers.ConstraintTrackingWorkerKt", f = "ConstraintTrackingWorker.kt", i = {}, l = {160}, m = "awaitConstraintsNotMet", n = {}, s = {})
public final class ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1(I0Io<? super ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1> i0Io) {
        super(i0Io);
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ConstraintTrackingWorkerKt.awaitConstraintsNotMet((WorkConstraintsTracker) null, (WorkSpec) null, this);
    }
}

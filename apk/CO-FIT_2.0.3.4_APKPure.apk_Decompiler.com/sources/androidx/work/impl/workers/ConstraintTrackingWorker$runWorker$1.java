package androidx.work.impl.workers;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.work.ListenableWorker;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@oxoX(c = "androidx.work.impl.workers.ConstraintTrackingWorker", f = "ConstraintTrackingWorker.kt", i = {}, l = {125}, m = "runWorker", n = {}, s = {})
public final class ConstraintTrackingWorker$runWorker$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConstraintTrackingWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker$runWorker$1(ConstraintTrackingWorker constraintTrackingWorker, I0Io<? super ConstraintTrackingWorker$runWorker$1> i0Io) {
        super(i0Io);
        this.this$0 = constraintTrackingWorker;
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runWorker((ListenableWorker) null, (WorkConstraintsTracker) null, (WorkSpec) null, this);
    }
}

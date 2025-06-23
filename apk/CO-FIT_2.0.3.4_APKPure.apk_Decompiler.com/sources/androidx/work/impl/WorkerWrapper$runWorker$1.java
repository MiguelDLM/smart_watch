package androidx.work.impl;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@oxoX(c = "androidx.work.impl.WorkerWrapper", f = "WorkerWrapper.kt", i = {0, 0}, l = {299}, m = "runWorker", n = {"this", "params"}, s = {"L$0", "L$1"})
public final class WorkerWrapper$runWorker$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$runWorker$1(WorkerWrapper workerWrapper, I0Io<? super WorkerWrapper$runWorker$1> i0Io) {
        super(i0Io);
        this.this$0 = workerWrapper;
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runWorker(this);
    }
}

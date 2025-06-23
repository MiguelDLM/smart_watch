package androidx.work.impl;

import com.facebook.internal.NativeProtocol;
import com.garmin.fit.X0xOO;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@IXIxx0.oxoX(c = "androidx.work.impl.WorkerWrapper", f = "WorkerWrapper.kt", i = {0, 0}, l = {X0xOO.f13593OIxOX}, m = "runWorker", n = {"this", NativeProtocol.WEB_DIALOG_PARAMS}, s = {"L$0", "L$1"})
/* loaded from: classes.dex */
public final class WorkerWrapper$runWorker$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$runWorker$1(WorkerWrapper workerWrapper, kotlin.coroutines.I0Io<? super WorkerWrapper$runWorker$1> i0Io) {
        super(i0Io);
        this.this$0 = workerWrapper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @OXOo.oOoXoXO
    public final Object invokeSuspend(@OXOo.OOXIXo Object obj) {
        Object runWorker;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        runWorker = this.this$0.runWorker(this);
        return runWorker;
    }
}

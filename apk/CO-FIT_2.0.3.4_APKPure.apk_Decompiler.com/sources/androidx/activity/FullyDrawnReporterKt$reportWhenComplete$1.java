package androidx.activity;

import IXIxx0.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.coroutines.I0Io;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.oXIO0o0XI;

@oxoX(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", i = {0}, l = {173}, m = "reportWhenComplete", n = {"$this$reportWhenComplete"}, s = {"L$0"})
public final class FullyDrawnReporterKt$reportWhenComplete$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FullyDrawnReporterKt$reportWhenComplete$1(I0Io<? super FullyDrawnReporterKt$reportWhenComplete$1> i0Io) {
        super(i0Io);
    }

    @oOoXoXO
    public final Object invokeSuspend(@OOXIXo Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FullyDrawnReporterKt.reportWhenComplete((FullyDrawnReporter) null, (Oox.oOoXoXO<? super I0Io<? super oXIO0o0XI>, ? extends Object>) null, this);
    }
}

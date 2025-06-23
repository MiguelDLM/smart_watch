package androidx.work.impl;

import Oox.oOoXoXO;
import androidx.work.ListenableWorker;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class WorkerWrapper$runWorker$2 extends Lambda implements oOoXoXO<Throwable, oXIO0o0XI> {
    final /* synthetic */ boolean $isTracingEnabled;
    final /* synthetic */ String $traceTag;
    final /* synthetic */ ListenableWorker $worker;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$runWorker$2(ListenableWorker listenableWorker, boolean z, String str, WorkerWrapper workerWrapper) {
        super(1);
        this.$worker = listenableWorker;
        this.$isTracingEnabled = z;
        this.$traceTag = str;
        this.this$0 = workerWrapper;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return oXIO0o0XI.f19155oIX0oI;
    }

    public final void invoke(Throwable th) {
        if (th instanceof WorkerStoppedException) {
            this.$worker.stop(((WorkerStoppedException) th).getReason());
        }
        if (this.$isTracingEnabled && this.$traceTag != null) {
            this.this$0.configuration.getTracer().endAsyncSection(this.$traceTag, this.this$0.getWorkSpec().hashCode());
        }
    }
}

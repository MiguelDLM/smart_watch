package androidx.work;

import Oox.oIX0oI;
import androidx.work.ListenableWorker;
import kotlin.jvm.internal.Lambda;

public final class Worker$startWork$1 extends Lambda implements oIX0oI<ListenableWorker.Result> {
    final /* synthetic */ Worker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Worker$startWork$1(Worker worker) {
        super(0);
        this.this$0 = worker;
    }

    public final ListenableWorker.Result invoke() {
        return this.this$0.doWork();
    }
}

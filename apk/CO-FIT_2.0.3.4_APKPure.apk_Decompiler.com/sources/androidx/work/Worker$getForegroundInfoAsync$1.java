package androidx.work;

import Oox.oIX0oI;
import kotlin.jvm.internal.Lambda;

public final class Worker$getForegroundInfoAsync$1 extends Lambda implements oIX0oI<ForegroundInfo> {
    final /* synthetic */ Worker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Worker$getForegroundInfoAsync$1(Worker worker) {
        super(0);
        this.this$0 = worker;
    }

    public final ForegroundInfo invoke() {
        return this.this$0.getForegroundInfo();
    }
}

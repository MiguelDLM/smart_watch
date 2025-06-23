package androidx.work.impl;

import Oox.oOoXoXO;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class WorkerUpdater$updateWorkImpl$type$1 extends Lambda implements oOoXoXO<WorkSpec, String> {
    public static final WorkerUpdater$updateWorkImpl$type$1 INSTANCE = new WorkerUpdater$updateWorkImpl$type$1();

    public WorkerUpdater$updateWorkImpl$type$1() {
        super(1);
    }

    public final String invoke(WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "spec");
        return workSpec.isPeriodic() ? "Periodic" : "OneTime";
    }
}

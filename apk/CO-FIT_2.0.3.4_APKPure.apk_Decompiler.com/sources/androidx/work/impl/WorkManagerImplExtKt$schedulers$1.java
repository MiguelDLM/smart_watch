package androidx.work.impl;

import Oox.OxxIIOOXO;
import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class WorkManagerImplExtKt$schedulers$1 extends Lambda implements OxxIIOOXO<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<? extends Scheduler>> {
    final /* synthetic */ Scheduler[] $schedulers;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkManagerImplExtKt$schedulers$1(Scheduler[] schedulerArr) {
        super(6);
        this.$schedulers = schedulerArr;
    }

    public final List<Scheduler> invoke(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        IIX0o.x0xO0oo(context, "<anonymous parameter 0>");
        IIX0o.x0xO0oo(configuration, "<anonymous parameter 1>");
        IIX0o.x0xO0oo(taskExecutor, "<anonymous parameter 2>");
        IIX0o.x0xO0oo(workDatabase, "<anonymous parameter 3>");
        IIX0o.x0xO0oo(trackers, "<anonymous parameter 4>");
        IIX0o.x0xO0oo(processor, "<anonymous parameter 5>");
        return ArraysKt___ArraysKt.IoXOX(this.$schedulers);
    }
}

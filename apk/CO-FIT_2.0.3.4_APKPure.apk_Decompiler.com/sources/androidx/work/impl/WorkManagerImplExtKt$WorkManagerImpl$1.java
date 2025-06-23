package androidx.work.impl;

import Oox.OxxIIOOXO;
import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.kuaishou.weapon.p0.bq;
import java.util.List;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.IIX0o;

public /* synthetic */ class WorkManagerImplExtKt$WorkManagerImpl$1 extends FunctionReferenceImpl implements OxxIIOOXO<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<? extends Scheduler>> {
    public static final WorkManagerImplExtKt$WorkManagerImpl$1 INSTANCE = new WorkManagerImplExtKt$WorkManagerImpl$1();

    public WorkManagerImplExtKt$WorkManagerImpl$1() {
        super(6, WorkManagerImplExtKt.class, "createSchedulers", "createSchedulers(Landroid/content/Context;Landroidx/work/Configuration;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/WorkDatabase;Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/Processor;)Ljava/util/List;", 1);
    }

    public final List<Scheduler> invoke(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        IIX0o.x0xO0oo(context, bq.g);
        IIX0o.x0xO0oo(configuration, "p1");
        IIX0o.x0xO0oo(taskExecutor, "p2");
        IIX0o.x0xO0oo(workDatabase, "p3");
        IIX0o.x0xO0oo(trackers, "p4");
        IIX0o.x0xO0oo(processor, "p5");
        return WorkManagerImplExtKt.createSchedulers(context, configuration, taskExecutor, workDatabase, trackers, processor);
    }
}

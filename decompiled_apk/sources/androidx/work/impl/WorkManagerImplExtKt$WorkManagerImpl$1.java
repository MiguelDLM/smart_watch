package androidx.work.impl;

import Oox.OxxIIOOXO;
import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.List;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public /* synthetic */ class WorkManagerImplExtKt$WorkManagerImpl$1 extends FunctionReferenceImpl implements OxxIIOOXO<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<? extends Scheduler>> {
    public static final WorkManagerImplExtKt$WorkManagerImpl$1 INSTANCE = new WorkManagerImplExtKt$WorkManagerImpl$1();

    public WorkManagerImplExtKt$WorkManagerImpl$1() {
        super(6, WorkManagerImplExtKt.class, "createSchedulers", "createSchedulers(Landroid/content/Context;Landroidx/work/Configuration;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/WorkDatabase;Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/Processor;)Ljava/util/List;", 1);
    }

    @Override // Oox.OxxIIOOXO
    public final List<Scheduler> invoke(Context p0, Configuration p1, TaskExecutor p2, WorkDatabase p3, Trackers p4, Processor p5) {
        List<Scheduler> createSchedulers;
        IIX0o.x0xO0oo(p0, "p0");
        IIX0o.x0xO0oo(p1, "p1");
        IIX0o.x0xO0oo(p2, "p2");
        IIX0o.x0xO0oo(p3, "p3");
        IIX0o.x0xO0oo(p4, "p4");
        IIX0o.x0xO0oo(p5, "p5");
        createSchedulers = WorkManagerImplExtKt.createSchedulers(p0, p1, p2, p3, p4, p5);
        return createSchedulers;
    }
}

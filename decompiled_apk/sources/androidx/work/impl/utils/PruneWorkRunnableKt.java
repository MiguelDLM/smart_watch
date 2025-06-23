package androidx.work.impl.utils;

import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class PruneWorkRunnableKt {
    @OXOo.OOXIXo
    public static final Operation pruneWork(@OXOo.OOXIXo final WorkDatabase workDatabase, @OXOo.OOXIXo Configuration configuration, @OXOo.OOXIXo TaskExecutor executor) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(executor, "executor");
        Tracer tracer = configuration.getTracer();
        SerialExecutor serialTaskExecutor = executor.getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "executor.serialTaskExecutor");
        return OperationKt.launchOperation(tracer, "PruneWork", serialTaskExecutor, new Oox.oIX0oI<oXIO0o0XI>() { // from class: androidx.work.impl.utils.PruneWorkRunnableKt$pruneWork$1
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WorkDatabase.this.workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();
            }
        });
    }
}

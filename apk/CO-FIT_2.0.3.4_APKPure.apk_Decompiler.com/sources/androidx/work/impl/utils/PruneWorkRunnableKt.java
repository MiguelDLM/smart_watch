package androidx.work.impl.utils;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.IIX0o;

public final class PruneWorkRunnableKt {
    @OOXIXo
    public static final Operation pruneWork(@OOXIXo WorkDatabase workDatabase, @OOXIXo Configuration configuration, @OOXIXo TaskExecutor taskExecutor) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(taskExecutor, "executor");
        Tracer tracer = configuration.getTracer();
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "executor.serialTaskExecutor");
        return OperationKt.launchOperation(tracer, "PruneWork", serialTaskExecutor, new PruneWorkRunnableKt$pruneWork$1(workDatabase));
    }
}

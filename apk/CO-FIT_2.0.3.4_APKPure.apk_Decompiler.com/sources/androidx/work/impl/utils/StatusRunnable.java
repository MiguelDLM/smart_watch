package androidx.work.impl.utils;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import androidx.work.ListenableFutureKt;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;

@xxIXOIIO(name = "StatusRunnable")
public final class StatusRunnable {
    @OOXIXo
    public static final ListenableFuture<List<WorkInfo>> forStringIds(@OOXIXo WorkDatabase workDatabase, @OOXIXo TaskExecutor taskExecutor, @OOXIXo List<String> list) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(taskExecutor, "executor");
        IIX0o.x0xO0oo(list, "ids");
        return loadStatusFuture(workDatabase, taskExecutor, new StatusRunnable$forStringIds$1(list));
    }

    @OOXIXo
    public static final ListenableFuture<List<WorkInfo>> forTag(@OOXIXo WorkDatabase workDatabase, @OOXIXo TaskExecutor taskExecutor, @OOXIXo String str) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(taskExecutor, "executor");
        IIX0o.x0xO0oo(str, "tag");
        return loadStatusFuture(workDatabase, taskExecutor, new StatusRunnable$forTag$1(str));
    }

    @OOXIXo
    public static final ListenableFuture<WorkInfo> forUUID(@OOXIXo WorkDatabase workDatabase, @OOXIXo TaskExecutor taskExecutor, @OOXIXo UUID uuid) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(taskExecutor, "executor");
        IIX0o.x0xO0oo(uuid, "id");
        return loadStatusFuture(workDatabase, taskExecutor, new StatusRunnable$forUUID$1(uuid));
    }

    @OOXIXo
    public static final ListenableFuture<List<WorkInfo>> forUniqueWork(@OOXIXo WorkDatabase workDatabase, @OOXIXo TaskExecutor taskExecutor, @OOXIXo String str) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(taskExecutor, "executor");
        IIX0o.x0xO0oo(str, "name");
        return loadStatusFuture(workDatabase, taskExecutor, new StatusRunnable$forUniqueWork$1(str));
    }

    @OOXIXo
    public static final ListenableFuture<List<WorkInfo>> forWorkQuerySpec(@OOXIXo WorkDatabase workDatabase, @OOXIXo TaskExecutor taskExecutor, @OOXIXo WorkQuery workQuery) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(taskExecutor, "executor");
        IIX0o.x0xO0oo(workQuery, "querySpec");
        return loadStatusFuture(workDatabase, taskExecutor, new StatusRunnable$forWorkQuerySpec$1(workQuery));
    }

    private static final <T> ListenableFuture<T> loadStatusFuture(WorkDatabase workDatabase, TaskExecutor taskExecutor, oOoXoXO<? super WorkDatabase, ? extends T> oooxoxo) {
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "executor.serialTaskExecutor");
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "loadStatusFuture", new StatusRunnable$loadStatusFuture$1(oooxoxo, workDatabase));
    }
}

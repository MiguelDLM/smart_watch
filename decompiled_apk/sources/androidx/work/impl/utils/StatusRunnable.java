package androidx.work.impl.utils;

import androidx.work.ListenableFutureKt;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;

@XO0OX.xxIXOIIO(name = "StatusRunnable")
/* loaded from: classes.dex */
public final class StatusRunnable {
    @OXOo.OOXIXo
    public static final ListenableFuture<List<WorkInfo>> forStringIds(@OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo TaskExecutor executor, @OXOo.OOXIXo final List<String> ids) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(executor, "executor");
        IIX0o.x0xO0oo(ids, "ids");
        return loadStatusFuture(workDatabase, executor, new Oox.oOoXoXO<WorkDatabase, List<? extends WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable$forStringIds$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final List<WorkInfo> invoke(WorkDatabase db) {
                IIX0o.x0xO0oo(db, "db");
                List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(db.workSpecDao().getWorkStatusPojoForIds(ids));
                IIX0o.oO(apply, "WORK_INFO_MAPPER.apply(d…orkStatusPojoForIds(ids))");
                return apply;
            }
        });
    }

    @OXOo.OOXIXo
    public static final ListenableFuture<List<WorkInfo>> forTag(@OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo TaskExecutor executor, @OXOo.OOXIXo final String tag) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(executor, "executor");
        IIX0o.x0xO0oo(tag, "tag");
        return loadStatusFuture(workDatabase, executor, new Oox.oOoXoXO<WorkDatabase, List<? extends WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable$forTag$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final List<WorkInfo> invoke(WorkDatabase db) {
                IIX0o.x0xO0oo(db, "db");
                List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(db.workSpecDao().getWorkStatusPojoForTag(tag));
                IIX0o.oO(apply, "WORK_INFO_MAPPER.apply(d…orkStatusPojoForTag(tag))");
                return apply;
            }
        });
    }

    @OXOo.OOXIXo
    public static final ListenableFuture<WorkInfo> forUUID(@OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo TaskExecutor executor, @OXOo.OOXIXo final UUID id) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(executor, "executor");
        IIX0o.x0xO0oo(id, "id");
        return loadStatusFuture(workDatabase, executor, new Oox.oOoXoXO<WorkDatabase, WorkInfo>() { // from class: androidx.work.impl.utils.StatusRunnable$forUUID$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final WorkInfo invoke(WorkDatabase db) {
                IIX0o.x0xO0oo(db, "db");
                WorkSpecDao workSpecDao = db.workSpecDao();
                String uuid = id.toString();
                IIX0o.oO(uuid, "id.toString()");
                WorkSpec.WorkInfoPojo workStatusPojoForId = workSpecDao.getWorkStatusPojoForId(uuid);
                if (workStatusPojoForId != null) {
                    return workStatusPojoForId.toWorkInfo();
                }
                return null;
            }
        });
    }

    @OXOo.OOXIXo
    public static final ListenableFuture<List<WorkInfo>> forUniqueWork(@OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo TaskExecutor executor, @OXOo.OOXIXo final String name) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(executor, "executor");
        IIX0o.x0xO0oo(name, "name");
        return loadStatusFuture(workDatabase, executor, new Oox.oOoXoXO<WorkDatabase, List<? extends WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable$forUniqueWork$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final List<WorkInfo> invoke(WorkDatabase db) {
                IIX0o.x0xO0oo(db, "db");
                List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(db.workSpecDao().getWorkStatusPojoForName(name));
                IIX0o.oO(apply, "WORK_INFO_MAPPER.apply(d…kStatusPojoForName(name))");
                return apply;
            }
        });
    }

    @OXOo.OOXIXo
    public static final ListenableFuture<List<WorkInfo>> forWorkQuerySpec(@OXOo.OOXIXo WorkDatabase workDatabase, @OXOo.OOXIXo TaskExecutor executor, @OXOo.OOXIXo final WorkQuery querySpec) {
        IIX0o.x0xO0oo(workDatabase, "<this>");
        IIX0o.x0xO0oo(executor, "executor");
        IIX0o.x0xO0oo(querySpec, "querySpec");
        return loadStatusFuture(workDatabase, executor, new Oox.oOoXoXO<WorkDatabase, List<? extends WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable$forWorkQuerySpec$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final List<WorkInfo> invoke(WorkDatabase db) {
                IIX0o.x0xO0oo(db, "db");
                List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(db.rawWorkInfoDao().getWorkInfoPojos(RawQueries.toRawQuery(WorkQuery.this)));
                IIX0o.oO(apply, "WORK_INFO_MAPPER.apply(d…(querySpec.toRawQuery()))");
                return apply;
            }
        });
    }

    private static final <T> ListenableFuture<T> loadStatusFuture(final WorkDatabase workDatabase, TaskExecutor taskExecutor, final Oox.oOoXoXO<? super WorkDatabase, ? extends T> oooxoxo) {
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        IIX0o.oO(serialTaskExecutor, "executor.serialTaskExecutor");
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "loadStatusFuture", new Oox.oIX0oI<T>() { // from class: androidx.work.impl.utils.StatusRunnable$loadStatusFuture$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public final T invoke() {
                return oooxoxo.invoke(workDatabase);
            }
        });
    }
}

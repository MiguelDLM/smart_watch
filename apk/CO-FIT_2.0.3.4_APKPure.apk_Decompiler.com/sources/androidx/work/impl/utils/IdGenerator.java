package androidx.work.impl.utils;

import OXOo.OOXIXo;
import androidx.work.impl.WorkDatabase;
import kotlin.jvm.internal.IIX0o;

public final class IdGenerator {
    @OOXIXo
    private final WorkDatabase workDatabase;

    public IdGenerator(@OOXIXo WorkDatabase workDatabase2) {
        IIX0o.x0xO0oo(workDatabase2, "workDatabase");
        this.workDatabase = workDatabase2;
    }

    /* access modifiers changed from: private */
    public static final Integer nextAlarmManagerId$lambda$1(IdGenerator idGenerator) {
        return Integer.valueOf(IdGeneratorKt.nextId(idGenerator.workDatabase, IdGeneratorKt.NEXT_ALARM_MANAGER_ID_KEY));
    }

    /* access modifiers changed from: private */
    public static final Integer nextJobSchedulerIdWithRange$lambda$0(IdGenerator idGenerator, int i, int i2) {
        int access$nextId = IdGeneratorKt.nextId(idGenerator.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY);
        if (i > access$nextId || access$nextId > i2) {
            IdGeneratorKt.updatePreference(idGenerator.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY, i + 1);
        } else {
            i = access$nextId;
        }
        return Integer.valueOf(i);
    }

    public final int nextAlarmManagerId() {
        Object runInTransaction = this.workDatabase.runInTransaction(new xxIXOIIO(this));
        IIX0o.oO(runInTransaction, "workDatabase.runInTransa…NAGER_ID_KEY) }\n        )");
        return ((Number) runInTransaction).intValue();
    }

    public final int nextJobSchedulerIdWithRange(int i, int i2) {
        Object runInTransaction = this.workDatabase.runInTransaction(new xoIox(this, i, i2));
        IIX0o.oO(runInTransaction, "workDatabase.runInTransa…d\n            }\n        )");
        return ((Number) runInTransaction).intValue();
    }
}

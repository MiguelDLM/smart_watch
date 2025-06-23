package androidx.work.impl.utils;

import Oox.oIX0oI;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class CancelWorkRunnable$forId$1 extends Lambda implements oIX0oI<oXIO0o0XI> {
    final /* synthetic */ UUID $id;
    final /* synthetic */ WorkManagerImpl $workManagerImpl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancelWorkRunnable$forId$1(WorkManagerImpl workManagerImpl, UUID uuid) {
        super(0);
        this.$workManagerImpl = workManagerImpl;
        this.$id = uuid;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(WorkManagerImpl workManagerImpl, UUID uuid) {
        String uuid2 = uuid.toString();
        IIX0o.oO(uuid2, "id.toString()");
        CancelWorkRunnable.cancel(workManagerImpl, uuid2);
    }

    public final void invoke() {
        WorkDatabase workDatabase = this.$workManagerImpl.getWorkDatabase();
        IIX0o.oO(workDatabase, "workManagerImpl.workDatabase");
        workDatabase.runInTransaction((Runnable) new I0Io(this.$workManagerImpl, this.$id));
        CancelWorkRunnable.reschedulePendingWorkers(this.$workManagerImpl);
    }
}

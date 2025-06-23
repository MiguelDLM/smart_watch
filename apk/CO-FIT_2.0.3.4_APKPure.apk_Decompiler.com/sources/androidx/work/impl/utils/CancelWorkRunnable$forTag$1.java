package androidx.work.impl.utils;

import Oox.oIX0oI;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class CancelWorkRunnable$forTag$1 extends Lambda implements oIX0oI<oXIO0o0XI> {
    final /* synthetic */ String $tag;
    final /* synthetic */ WorkManagerImpl $workManagerImpl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancelWorkRunnable$forTag$1(WorkManagerImpl workManagerImpl, String str) {
        super(0);
        this.$workManagerImpl = workManagerImpl;
        this.$tag = str;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        for (String access$cancel : workDatabase.workSpecDao().getUnfinishedWorkWithTag(str)) {
            CancelWorkRunnable.cancel(workManagerImpl, access$cancel);
        }
    }

    public final void invoke() {
        WorkDatabase workDatabase = this.$workManagerImpl.getWorkDatabase();
        IIX0o.oO(workDatabase, "workManagerImpl.workDatabase");
        workDatabase.runInTransaction((Runnable) new oxoX(workDatabase, this.$tag, this.$workManagerImpl));
        CancelWorkRunnable.reschedulePendingWorkers(this.$workManagerImpl);
    }
}

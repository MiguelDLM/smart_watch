package androidx.work.impl.utils;

import Oox.oIX0oI;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class CancelWorkRunnable$forAll$1 extends Lambda implements oIX0oI<oXIO0o0XI> {
    final /* synthetic */ WorkManagerImpl $workManagerImpl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancelWorkRunnable$forAll$1(WorkManagerImpl workManagerImpl) {
        super(0);
        this.$workManagerImpl = workManagerImpl;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(WorkDatabase workDatabase, WorkManagerImpl workManagerImpl) {
        for (String access$cancel : workDatabase.workSpecDao().getAllUnfinishedWork()) {
            CancelWorkRunnable.cancel(workManagerImpl, access$cancel);
        }
        new PreferenceUtils(workDatabase).setLastCancelAllTimeMillis(workManagerImpl.getConfiguration().getClock().currentTimeMillis());
    }

    public final void invoke() {
        WorkDatabase workDatabase = this.$workManagerImpl.getWorkDatabase();
        IIX0o.oO(workDatabase, "workManagerImpl.workDatabase");
        workDatabase.runInTransaction((Runnable) new II0xO0(workDatabase, this.$workManagerImpl));
    }
}

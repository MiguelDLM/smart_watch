package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class CancelWorkRunnable$forId$1 extends Lambda implements Oox.oIX0oI<oXIO0o0XI> {
    final /* synthetic */ UUID $id;
    final /* synthetic */ WorkManagerImpl $workManagerImpl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CancelWorkRunnable$forId$1(WorkManagerImpl workManagerImpl, UUID uuid) {
        super(0);
        this.$workManagerImpl = workManagerImpl;
        this.$id = uuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(WorkManagerImpl workManagerImpl, UUID uuid) {
        String uuid2 = uuid.toString();
        IIX0o.oO(uuid2, "id.toString()");
        CancelWorkRunnable.cancel(workManagerImpl, uuid2);
    }

    @Override // Oox.oIX0oI
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
        invoke2();
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WorkDatabase workDatabase = this.$workManagerImpl.getWorkDatabase();
        IIX0o.oO(workDatabase, "workManagerImpl.workDatabase");
        final WorkManagerImpl workManagerImpl = this.$workManagerImpl;
        final UUID uuid = this.$id;
        workDatabase.runInTransaction(new Runnable() { // from class: androidx.work.impl.utils.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                CancelWorkRunnable$forId$1.invoke$lambda$0(WorkManagerImpl.this, uuid);
            }
        });
        CancelWorkRunnable.reschedulePendingWorkers(this.$workManagerImpl);
    }
}

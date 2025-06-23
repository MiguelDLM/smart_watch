package androidx.work.impl.utils;

import Oox.oIX0oI;
import androidx.work.impl.WorkManagerImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class CancelWorkRunnable$forName$1 extends Lambda implements oIX0oI<oXIO0o0XI> {
    final /* synthetic */ String $name;
    final /* synthetic */ WorkManagerImpl $workManagerImpl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancelWorkRunnable$forName$1(String str, WorkManagerImpl workManagerImpl) {
        super(0);
        this.$name = str;
        this.$workManagerImpl = workManagerImpl;
    }

    public final void invoke() {
        CancelWorkRunnable.forNameInline(this.$name, this.$workManagerImpl);
        CancelWorkRunnable.reschedulePendingWorkers(this.$workManagerImpl);
    }
}

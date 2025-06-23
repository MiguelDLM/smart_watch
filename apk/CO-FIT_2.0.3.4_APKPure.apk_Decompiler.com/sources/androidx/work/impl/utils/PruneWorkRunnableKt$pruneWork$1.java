package androidx.work.impl.utils;

import Oox.oIX0oI;
import androidx.work.impl.WorkDatabase;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

public final class PruneWorkRunnableKt$pruneWork$1 extends Lambda implements oIX0oI<oXIO0o0XI> {
    final /* synthetic */ WorkDatabase $this_pruneWork;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PruneWorkRunnableKt$pruneWork$1(WorkDatabase workDatabase) {
        super(0);
        this.$this_pruneWork = workDatabase;
    }

    public final void invoke() {
        this.$this_pruneWork.workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();
    }
}

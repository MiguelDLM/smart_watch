package androidx.work.impl.utils;

import Oox.oIX0oI;
import Oox.oOoXoXO;
import androidx.work.impl.WorkDatabase;
import kotlin.jvm.internal.Lambda;

public final class StatusRunnable$loadStatusFuture$1 extends Lambda implements oIX0oI<T> {
    final /* synthetic */ oOoXoXO<WorkDatabase, T> $block;
    final /* synthetic */ WorkDatabase $this_loadStatusFuture;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StatusRunnable$loadStatusFuture$1(oOoXoXO<? super WorkDatabase, ? extends T> oooxoxo, WorkDatabase workDatabase) {
        super(0);
        this.$block = oooxoxo;
        this.$this_loadStatusFuture = workDatabase;
    }

    public final T invoke() {
        return this.$block.invoke(this.$this_loadStatusFuture);
    }
}

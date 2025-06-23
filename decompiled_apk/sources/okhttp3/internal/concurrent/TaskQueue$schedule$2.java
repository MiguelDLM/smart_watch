package okhttp3.internal.concurrent;

import Oox.oIX0oI;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$schedule$2\n*L\n1#1,218:1\n*E\n"})
/* loaded from: classes6.dex */
public final class TaskQueue$schedule$2 extends Task {
    final /* synthetic */ oIX0oI<Long> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$schedule$2(String str, oIX0oI<Long> oix0oi) {
        super(str, false, 2, null);
        this.$block = oix0oi;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        return this.$block.invoke().longValue();
    }
}

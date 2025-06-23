package okhttp3.internal.concurrent;

import Oox.oIX0oI;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue$execute$1\n*L\n1#1,218:1\n*E\n"})
/* loaded from: classes6.dex */
public final class TaskQueue$execute$1 extends Task {
    final /* synthetic */ oIX0oI<oXIO0o0XI> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(String str, boolean z, oIX0oI<oXIO0o0XI> oix0oi) {
        super(str, z);
        this.$block = oix0oi;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        this.$block.invoke();
        return -1L;
    }
}

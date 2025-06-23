package androidx.work;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.IIX0o;

public final class ConfigurationKt$createDefaultExecutor$factory$1 implements ThreadFactory {
    final /* synthetic */ boolean $isTaskExecutor;
    private final AtomicInteger threadCount = new AtomicInteger(0);

    public ConfigurationKt$createDefaultExecutor$factory$1(boolean z) {
        this.$isTaskExecutor = z;
    }

    public Thread newThread(Runnable runnable) {
        String str;
        IIX0o.x0xO0oo(runnable, "runnable");
        if (this.$isTaskExecutor) {
            str = "WM.task-";
        } else {
            str = "androidx.work-";
        }
        return new Thread(runnable, str + this.threadCount.incrementAndGet());
    }
}

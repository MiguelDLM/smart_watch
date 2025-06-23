package androidx.arch.core.executor;

import java.util.concurrent.Executor;

public final /* synthetic */ class oIX0oI implements Executor {
    public final void execute(Runnable runnable) {
        ArchTaskExecutor.getInstance().postToMainThread(runnable);
    }
}

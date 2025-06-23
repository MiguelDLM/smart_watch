package androidx.work.impl.utils.taskexecutor;

import androidx.annotation.NonNull;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.O00XxXI;

/* loaded from: classes.dex */
public final /* synthetic */ class oIX0oI {
    @NonNull
    public static CoroutineDispatcher II0xO0(TaskExecutor taskExecutor) {
        return O00XxXI.I0Io(taskExecutor.getSerialTaskExecutor());
    }

    public static void oIX0oI(TaskExecutor _this, @NonNull Runnable runnable) {
        _this.getSerialTaskExecutor().execute(runnable);
    }
}

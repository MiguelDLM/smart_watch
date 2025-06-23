package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SynchronousExecutor implements Executor {
    public void execute(@NonNull Runnable runnable) {
        runnable.run();
    }
}

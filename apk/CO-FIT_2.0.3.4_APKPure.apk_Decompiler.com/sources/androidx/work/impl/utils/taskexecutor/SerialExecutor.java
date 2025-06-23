package androidx.work.impl.utils.taskexecutor;

import java.util.concurrent.Executor;

public interface SerialExecutor extends Executor {
    boolean hasPendingTasks();
}

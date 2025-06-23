package com.androidnetworking.core;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface ExecutorSupplier {
    ANExecutor forImmediateNetworkTasks();

    Executor forMainThreadTasks();

    ANExecutor forNetworkTasks();
}

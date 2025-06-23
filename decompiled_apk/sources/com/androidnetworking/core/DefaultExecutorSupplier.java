package com.androidnetworking.core;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class DefaultExecutorSupplier implements ExecutorSupplier {
    public static final int DEFAULT_MAX_NUM_THREADS = (Runtime.getRuntime().availableProcessors() * 2) + 1;
    private final ANExecutor mImmediateNetworkExecutor;
    private final Executor mMainThreadExecutor;
    private final ANExecutor mNetworkExecutor;

    public DefaultExecutorSupplier() {
        PriorityThreadFactory priorityThreadFactory = new PriorityThreadFactory(10);
        this.mNetworkExecutor = new ANExecutor(DEFAULT_MAX_NUM_THREADS, priorityThreadFactory);
        this.mImmediateNetworkExecutor = new ANExecutor(2, priorityThreadFactory);
        this.mMainThreadExecutor = new MainThreadExecutor();
    }

    @Override // com.androidnetworking.core.ExecutorSupplier
    public ANExecutor forImmediateNetworkTasks() {
        return this.mImmediateNetworkExecutor;
    }

    @Override // com.androidnetworking.core.ExecutorSupplier
    public Executor forMainThreadTasks() {
        return this.mMainThreadExecutor;
    }

    @Override // com.androidnetworking.core.ExecutorSupplier
    public ANExecutor forNetworkTasks() {
        return this.mNetworkExecutor;
    }
}

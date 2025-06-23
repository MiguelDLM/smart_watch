package com.goodix.ble.libcomx.task;

import androidx.profileinstaller.I0Io;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes9.dex */
public class TaskExecutor {
    private static Executor DEFAULT_EXECUTOR;
    private static Executor IMMEDIATE_EXECUTOR;

    private TaskExecutor() {
    }

    public static Executor getDefaultExecutor() {
        if (DEFAULT_EXECUTOR == null) {
            synchronized (TaskExecutor.class) {
                try {
                    if (DEFAULT_EXECUTOR == null) {
                        DEFAULT_EXECUTOR = Executors.newScheduledThreadPool(1);
                    }
                } finally {
                }
            }
        }
        return DEFAULT_EXECUTOR;
    }

    public static Executor getImmediateExecutor() {
        if (IMMEDIATE_EXECUTOR == null) {
            synchronized (TaskExecutor.class) {
                try {
                    if (IMMEDIATE_EXECUTOR == null) {
                        IMMEDIATE_EXECUTOR = new I0Io();
                    }
                } finally {
                }
            }
        }
        return IMMEDIATE_EXECUTOR;
    }

    public static void setDefaultExecutor(Executor executor) {
        ExecutorService executorService;
        if (executor == null) {
            return;
        }
        synchronized (TaskExecutor.class) {
            try {
                Executor executor2 = DEFAULT_EXECUTOR;
                executorService = null;
                if (executor != executor2) {
                    if (executor2 instanceof ExecutorService) {
                        executorService = (ExecutorService) executor2;
                    }
                    DEFAULT_EXECUTOR = executor;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (executorService != null && !executorService.isShutdown()) {
            try {
                executorService.shutdown();
            } catch (Exception unused) {
            }
        }
    }
}

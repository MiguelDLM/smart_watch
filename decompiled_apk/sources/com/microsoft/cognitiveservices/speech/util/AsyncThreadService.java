package com.microsoft.cognitiveservices.speech.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public class AsyncThreadService {
    private static int s_activeExecutorServiceClientCounter;
    private static Object s_asyncThreadServiceLock = new Object();
    private static ExecutorService s_executorService;

    public static void initialize() {
        synchronized (s_asyncThreadServiceLock) {
            try {
                if (s_activeExecutorServiceClientCounter == 0) {
                    s_executorService = Executors.newCachedThreadPool();
                }
                s_activeExecutorServiceClientCounter++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void shutdown() {
        synchronized (s_asyncThreadServiceLock) {
            try {
                int i = s_activeExecutorServiceClientCounter - 1;
                s_activeExecutorServiceClientCounter = i;
                if (i == 0) {
                    s_executorService.shutdownNow();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static <T> Future<T> submit(Callable<T> callable) {
        Future<T> submit;
        synchronized (s_asyncThreadServiceLock) {
            try {
                if (s_executorService.isShutdown() || s_activeExecutorServiceClientCounter == 0) {
                    throw new IllegalStateException("ExecutorService has been shutdown", new IllegalStateException());
                }
                submit = s_executorService.submit(callable);
            } catch (Throwable th) {
                throw th;
            }
        }
        return submit;
    }
}

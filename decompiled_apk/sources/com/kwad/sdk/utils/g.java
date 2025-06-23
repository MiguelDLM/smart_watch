package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class g {
    private static volatile Executor aPy;
    private static volatile ScheduledExecutorService aPz;

    public static void execute(Runnable runnable) {
        if (aPy == null) {
            synchronized (g.class) {
                try {
                    if (aPy == null) {
                        aPy = GlobalThreadPools.Gu();
                    }
                } finally {
                }
            }
        }
        aPy.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (aPz == null) {
            synchronized (g.class) {
                try {
                    if (aPz == null) {
                        aPz = GlobalThreadPools.Gv();
                    }
                } finally {
                }
            }
        }
        aPz.schedule(runnable, j, timeUnit);
    }
}

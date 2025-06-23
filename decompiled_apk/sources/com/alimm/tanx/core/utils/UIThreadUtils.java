package com.alimm.tanx.core.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class UIThreadUtils implements NotConfused {

    /* loaded from: classes.dex */
    public static final class tanxc_do {
        private static final Handler tanxc_do = new Handler(Looper.getMainLooper());
    }

    private UIThreadUtils() {
    }

    public static void post(@NonNull Runnable runnable) {
        tanxc_do.tanxc_do.post(runnable);
    }

    public static void postDelayed(@NonNull Runnable runnable, long j) {
        tanxc_do.tanxc_do.postDelayed(runnable, j);
    }

    public static void removeCallbacks(@NonNull Runnable runnable) {
        tanxc_do.tanxc_do.removeCallbacks(runnable);
    }

    public static void run(@NonNull Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            tanxc_do.tanxc_do.post(runnable);
        }
    }
}

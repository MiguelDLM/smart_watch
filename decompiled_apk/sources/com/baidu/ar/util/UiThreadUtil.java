package com.baidu.ar.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes7.dex */
public class UiThreadUtil {
    private static Handler De = new Handler(Looper.getMainLooper());

    public static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void postDelayed(Runnable runnable, long j) {
        De.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        De.removeCallbacks(runnable);
    }

    public static void removeCallbacksAndMessages() {
        De.removeCallbacksAndMessages(null);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (isOnUiThread()) {
            runnable.run();
        } else {
            De.post(runnable);
        }
    }
}

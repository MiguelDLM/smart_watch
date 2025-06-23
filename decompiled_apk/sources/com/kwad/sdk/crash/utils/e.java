package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* loaded from: classes11.dex */
public final class e {
    private static Context aAl;

    @WorkerThread
    public static long FE() {
        long bt = bt(aAl);
        b(aAl, 1 + bt);
        return bt;
    }

    @WorkerThread
    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
        edit.putLong("crashseq", j);
        return edit.commit();
    }

    @WorkerThread
    private static long bt(Context context) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) != null) {
            return sharedPreferences.getLong("crashseq", 1L);
        }
        return 0L;
    }

    public static void init(Context context) {
        aAl = context;
    }
}

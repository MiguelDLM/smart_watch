package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;

/* loaded from: classes11.dex */
public final class t {
    private static String aAj = FG();
    private static long aAk = 0;
    private static Context aAl;

    public static String FC() {
        com.kwad.sdk.core.e.c.d("ReportIdManager", ">> updateSessionId");
        String FG = FG();
        aAj = FG;
        return FG;
    }

    public static String FD() {
        return aAj;
    }

    @WorkerThread
    public static long FE() {
        long bt = bt(aAl);
        b(aAl, 1 + bt);
        return bt;
    }

    public static long FF() {
        return aAk;
    }

    private static String FG() {
        return UUID.randomUUID().toString();
    }

    @WorkerThread
    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        edit.putLong("seq", j);
        return edit.commit();
    }

    @WorkerThread
    private static long bt(Context context) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) != null) {
            return sharedPreferences.getLong("seq", 1L);
        }
        return 0L;
    }

    public static void init(Context context) {
        aAl = context;
    }
}

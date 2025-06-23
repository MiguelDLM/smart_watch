package com.baidu.navisdk.ui.util;

import android.os.SystemClock;

/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static long f9202a = 800;
    private static long b;

    public static boolean a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - b;
        if (0 < j && j < f9202a) {
            return true;
        }
        b = elapsedRealtime;
        return false;
    }

    public static boolean a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime - b;
        if (0 < j2 && j2 < j) {
            return true;
        }
        b = elapsedRealtime;
        return false;
    }
}

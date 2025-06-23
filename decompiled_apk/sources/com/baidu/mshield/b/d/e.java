package com.baidu.mshield.b.d;

import android.annotation.SuppressLint;
import android.net.TrafficStats;

/* loaded from: classes7.dex */
public class e {
    @SuppressLint({"NewApi"})
    public static void a() {
        try {
            TrafficStats.setThreadStatsTag(155648);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }

    @SuppressLint({"NewApi"})
    public static void b() {
        try {
            TrafficStats.clearThreadStatsTag();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }
}

package com.baidu.navisdk.util.statistic;

import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    ActivityManager f9374a;
    int[] b;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static j f9375a = new j();
    }

    public static j b() {
        return b.f9375a;
    }

    public int a() {
        if (this.f9374a == null && com.baidu.navisdk.framework.a.c().a() != null) {
            this.b = new int[]{Process.myPid()};
            this.f9374a = (ActivityManager) com.baidu.navisdk.framework.a.c().a().getSystemService(TTDownloadField.TT_ACTIVITY);
        }
        ActivityManager activityManager = this.f9374a;
        if (activityManager == null) {
            return 0;
        }
        try {
            Debug.MemoryInfo memoryInfo = activityManager.getProcessMemoryInfo(this.b)[0];
            if (memoryInfo == null) {
                return 0;
            }
            return memoryInfo.getTotalPss();
        } catch (Exception unused) {
            return 0;
        }
    }

    private j() {
        this.b = new int[]{Process.myPid()};
        if (com.baidu.navisdk.framework.a.c().a() != null) {
            this.f9374a = (ActivityManager) com.baidu.navisdk.framework.a.c().a().getSystemService(TTDownloadField.TT_ACTIVITY);
        }
    }
}

package com.baidu.sec.privacy.d;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.PowerManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f10021a = false;
    public static volatile boolean b = false;
    public static long c = 0;
    public static boolean d = false;

    public static void a(Throwable th) {
    }

    public static boolean b(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static boolean c(Context context) {
        String[] strArr;
        try {
            if (f10021a) {
                return b;
            }
            if (context != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0 && (strArr = runningAppProcessInfo.pkgList) != null && strArr.length != 0 && Arrays.asList(strArr).contains(context.getPackageName())) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static boolean d(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        ComponentName componentName;
        try {
            if (!f.a(context, new String[]{com.kuaishou.weapon.p0.g.e})) {
                return true;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager.getRunningTasks(1) != null && (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) != null) {
                componentName = runningTaskInfo.topActivity;
                return context.getPackageName().equals(componentName.getPackageName());
            }
            return false;
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public static boolean a(Context context) {
        long currentTimeMillis;
        try {
            currentTimeMillis = System.currentTimeMillis();
        } catch (Throwable th) {
            a(th);
        }
        if (currentTimeMillis - c < 1000) {
            return d;
        }
        d = b(context) && c(context);
        c = currentTimeMillis;
        return d;
    }

    public static void a(boolean z) {
        f10021a = true;
        b = z;
    }
}

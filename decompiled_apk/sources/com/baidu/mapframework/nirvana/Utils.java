package com.baidu.mapframework.nirvana;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

/* loaded from: classes7.dex */
public class Utils {
    public static void asserts(boolean z, String str) {
        if (NirvanaFramework.isDebug() && !z) {
            throw new AssertionError(str);
        }
    }

    public static boolean executeParamCheck(Module module, NirvanaTask nirvanaTask, ScheduleConfig scheduleConfig) {
        boolean z;
        boolean z2;
        boolean z3;
        if (module != null) {
            z = true;
        } else {
            z = false;
        }
        asserts(z, "executeTask module 不能为空");
        if (nirvanaTask != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        asserts(z2, "executeTask task 不能为空");
        if (scheduleConfig != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        asserts(z3, "executeTask config 不能为空");
        if (module != null && nirvanaTask != null && scheduleConfig != null) {
            return true;
        }
        loge("executeTask param error", new Throwable());
        return false;
    }

    public static void logd(@NonNull String str) {
        if (NirvanaFramework.isDebug()) {
            Log.d("NIRVANA", str);
        }
    }

    public static void loge(@NonNull String str, @NonNull Throwable th) {
        Log.e("NIRVANA", str, th);
    }

    public static void logi(@NonNull String str, @NonNull String str2) {
        if (NirvanaFramework.isDebug()) {
            Log.i(str, str2);
        }
    }

    public static void loge(@NonNull String str, @NonNull String str2) {
        Log.e(str, str2);
    }

    public static void logd(@NonNull String str, @NonNull String str2) {
        if (NirvanaFramework.isDebug()) {
            Log.d(str, str2);
        }
    }

    public static void loge(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        Log.e(str, str2, th);
    }
}

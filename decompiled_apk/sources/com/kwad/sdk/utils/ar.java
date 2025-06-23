package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;

/* loaded from: classes11.dex */
public final class ar {
    private static String aQJ = "";
    private static volatile Boolean aQK;

    private static String MN() {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        return "";
    }

    private static String MO() {
        try {
            Object callStaticMethod = s.callStaticMethod(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            if (!(callStaticMethod instanceof String)) {
                return "";
            }
            return (String) callStaticMethod;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String cG(@NonNull Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static String getProcessName(@NonNull Context context) {
        if (!TextUtils.isEmpty(aQJ)) {
            return aQJ;
        }
        String MN = MN();
        aQJ = MN;
        if (!TextUtils.isEmpty(MN)) {
            return aQJ;
        }
        String MO = MO();
        aQJ = MO;
        if (!TextUtils.isEmpty(MO)) {
            return aQJ;
        }
        String cG = cG(context);
        aQJ = cG;
        return cG;
    }

    public static boolean isInMainProcess(Context context) {
        boolean z;
        if (aQK == null) {
            String processName = getProcessName(context);
            if (!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName())) {
                z = true;
            } else {
                z = false;
            }
            aQK = Boolean.valueOf(z);
        }
        return aQK.booleanValue();
    }
}

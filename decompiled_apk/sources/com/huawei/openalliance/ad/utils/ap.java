package com.huawei.openalliance.ad.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public abstract class ap {
    public static final int Code = -2;
    private static final String V = "PermissionUtil";

    private static int Code(Context context, String str, String str2, int i, int i2) {
        int i3;
        Object systemService;
        try {
            if (-1 == context.checkPermission(str, i, i2)) {
                return -1;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && applicationInfo.targetSdkVersion > 23) {
                return 0;
            }
            int i4 = Build.VERSION.SDK_INT;
            String permissionToOp = i4 >= 23 ? AppOpsManager.permissionToOp(str) : null;
            if (permissionToOp == null) {
                return 0;
            }
            if (TextUtils.isEmpty(str2)) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
                if (ad.Code(packagesForUid)) {
                    return -1;
                }
                str2 = packagesForUid[0];
            }
            if (i4 >= 23) {
                systemService = context.getSystemService((Class<Object>) AppOpsManager.class);
                i3 = ((AppOpsManager) systemService).noteProxyOpNoThrow(permissionToOp, str2);
            } else {
                i3 = 1;
            }
            return i3 != 0 ? -2 : 0;
        } catch (Throwable th) {
            fb.I(V, "validatePermission " + th.getClass().getSimpleName());
            return -1;
        }
    }

    public static boolean Code(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            return Code(context, str, context.getPackageName(), Process.myPid(), Process.myUid()) == 0;
        }
        fb.V(V, "hasPermission Invalid Input Param");
        return false;
    }
}

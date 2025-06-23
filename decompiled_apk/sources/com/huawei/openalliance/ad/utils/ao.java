package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class ao {
    private static final String Code = "PackageNameUtil";

    public static String Code(Context context) {
        if (context.getPackageManager() != null) {
            return Code(context, Binder.getCallingUid(), Binder.getCallingPid());
        }
        fb.I(Code, "pm is null");
        return "";
    }

    private static String Code(Context context, int i) {
        return null;
    }

    private static String Code(Context context, int i, int i2) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            String nameForUid = packageManager.getNameForUid(i);
            if (!TextUtils.isEmpty(nameForUid) && nameForUid.contains(":")) {
                fb.V(Code, "pkg=" + nameForUid);
                nameForUid = Code(context, i2);
            }
            if (!TextUtils.isEmpty(nameForUid)) {
                return nameForUid;
            }
            String[] packagesForUid = packageManager.getPackagesForUid(i);
            return !ad.Code(packagesForUid) ? packagesForUid[0] : nameForUid;
        } catch (Throwable unused) {
            fb.I(Code, "get name for uid error");
            return "";
        }
    }
}

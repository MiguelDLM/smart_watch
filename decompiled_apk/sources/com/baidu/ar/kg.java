package com.baidu.ar;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public class kg {
    private static String Dg = "pro";
    private static String Dh = "101";

    public static int getVersionCode() {
        return 6100;
    }

    public static String getVersionName() {
        return "6.1.0";
    }

    public static String n(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            StringBuilder sb = new StringBuilder(context.getApplicationContext().getPackageName());
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (!TextUtils.isEmpty(str)) {
                        sb.append("_");
                        sb.append(str);
                        kf.cj("appId = " + sb.toString());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            return sb.toString();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

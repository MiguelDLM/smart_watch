package com.alimm.tanx.core.web.cache.utils;

import android.content.Context;
import android.content.pm.PackageManager;

public class AppUtils {
    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

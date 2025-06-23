package com.baidu.navisdk.ui.routeguide.utils;

import android.os.Build;

/* loaded from: classes8.dex */
public class f {
    public static boolean a() {
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
            String str = Build.MODEL;
            if ("RLI-AN00".equalsIgnoreCase(str) || "RLI-N29".equalsIgnoreCase(str) || "TAH-AN00".equalsIgnoreCase(str) || "TAH-N29".equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        }
        return false;
    }
}

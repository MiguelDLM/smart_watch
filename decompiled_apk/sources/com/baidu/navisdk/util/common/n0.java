package com.baidu.navisdk.util.common;

import android.content.Context;

/* loaded from: classes8.dex */
public class n0 {
    public static boolean a(Context context, String str) {
        return a(context, str, false, null);
    }

    @Deprecated
    public static boolean a(Context context, String str, boolean z, String str2) {
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}

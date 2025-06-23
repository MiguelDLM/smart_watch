package com.baidu.navisdk.imageloader.config;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes7.dex */
public class ContextChecker {
    public static boolean check(Context context) {
        if (!isValidContext(context)) {
            return false;
        }
        return true;
    }

    private static boolean isValidContext(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }
}

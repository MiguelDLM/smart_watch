package com.tenmeter.smlibrary.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes13.dex */
public class Utils {
    private static Activity sActivity;

    public static Intent getLaunchAppIntent(Context context, String str) {
        String launcherActivity = getLauncherActivity(context, str);
        if (isSpace(launcherActivity)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName(str, launcherActivity);
        return intent.addFlags(268435456);
    }

    public static String getLauncherActivity(Context context, @NonNull String str) {
        if (isSpace(str)) {
            return "";
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
            return "";
        }
        return queryIntentActivities.get(0).activityInfo.name;
    }

    public static void hideVirtualButton() {
        if (sActivity != null) {
            int intValue = ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION")).intValue();
            int intValue2 = ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN")).intValue();
            int intValue3 = ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_HIDE_NAVIGATION")).intValue();
            Cocos2dxReflectionHelper.invokeInstanceMethod(sActivity.getWindow().getDecorView(), "setSystemUiVisibility", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(intValue | ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE")).intValue() | intValue2 | intValue3 | ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_FULLSCREEN")).intValue() | ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_IMMERSIVE_STICKY")).intValue())});
        }
    }

    public static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void relaunchApp(Context context, boolean z) {
        Intent launchAppIntent = getLaunchAppIntent(context, context.getPackageName());
        if (launchAppIntent == null) {
            Log.e("AppUtils", "Didn't exist launcher activity.");
            return;
        }
        launchAppIntent.addFlags(335577088);
        context.getApplicationContext().startActivity(launchAppIntent);
        if (!z) {
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    public static void setActivity(Activity activity) {
        sActivity = activity;
    }

    public static void setDarkStatusWhite(Activity activity, boolean z) {
        int i;
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = activity.getWindow().getDecorView();
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.white));
            if (decorView != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z) {
                    i = systemUiVisibility | 8192;
                } else {
                    i = systemUiVisibility & (-8193);
                }
                decorView.setSystemUiVisibility(i);
            }
        }
    }
}

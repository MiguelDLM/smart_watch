package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;

public class DeviceUtils implements NotConfused {
    private static final String TAG = "DeviceUtils";

    public static Point getAppWindowSize(@NonNull Context context) {
        Point point = new Point();
        new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        } catch (Exception e) {
            LogUtils.d(TAG, "getAppWindowSize size failed.", e);
        }
        LogUtils.d(TAG, "getAppWindowSize: appWindowSize = " + point);
        return point;
    }

    public static int getNavigationBarHeight(@NonNull Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static int getRealHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics});
            return displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getRealWidth(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics});
            return displayMetrics.widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getStatusBarHeight(@NonNull Context context) {
        if (context == null) {
            return 50;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static boolean isHuaweiDevice() {
        String lowerCase = Build.BRAND.toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || (!lowerCase.contains("huawei") && !lowerCase.contains("honor"))) {
            return false;
        }
        return true;
    }

    public static boolean isNavigationBarShow(@NonNull Context context) {
        if (isXiaomiDevice()) {
            if (Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
                return true;
            }
            return false;
        } else if (isHuaweiDevice()) {
            if (Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 0) {
                return true;
            }
            return false;
        } else if (!isVivoDevice()) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            LogUtils.d(TAG, "isNavigationBarShow: sY = " + point.y + ", rY = " + point2.y);
            int i = point2.y;
            int i2 = point.y;
            if (i != i2 && Math.abs(i - i2) >= getNavigationBarHeight(context)) {
                return true;
            }
            return false;
        } else if (Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOppoDevice() {
        String lowerCase = Build.BRAND.toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || !lowerCase.contains("oppo")) {
            return false;
        }
        return true;
    }

    public static boolean isSamsungDevice() {
        String lowerCase = Build.BRAND.toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || !lowerCase.contains("samsung")) {
            return false;
        }
        return true;
    }

    public static boolean isVivoDevice() {
        String lowerCase = Build.BRAND.toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || !lowerCase.contains("vivo")) {
            return false;
        }
        return true;
    }

    public static boolean isXiaomiDevice() {
        String lowerCase = Build.BRAND.toLowerCase();
        if (TextUtils.isEmpty(lowerCase) || !lowerCase.contains("xiaomi")) {
            return false;
        }
        return true;
    }
}

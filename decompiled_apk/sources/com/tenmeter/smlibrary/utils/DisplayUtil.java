package com.tenmeter.smlibrary.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oOoIIO0.oIX0oI;

/* loaded from: classes13.dex */
public class DisplayUtil {
    public static boolean checkDeviceHasNavigationBar(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        if (displayMetrics.heightPixels + getNavigationBarHeight(context) <= point.y) {
            return true;
        }
        return false;
    }

    public static int dp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static String getDeviceForceName() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase("HUAWEI") && !"HONOR".equals(str)) {
            if (str.equalsIgnoreCase(oIX0oI.f32057oO)) {
                return "force_fsg_nav_bar";
            }
            if (str.equalsIgnoreCase(oIX0oI.f32059ooOOo0oXI)) {
                return "navigation_gesture_on";
            }
            if (str.equalsIgnoreCase("OPPO")) {
                return "hide_navigationbar_enable";
            }
            if (str.equalsIgnoreCase("samsung")) {
                return "navigationbar_hide_bar_enabled";
            }
            if (str.equalsIgnoreCase("Nokia")) {
                if (Build.VERSION.SDK_INT < 28) {
                    return "navigation_bar_can_hiden";
                }
                return "swipe_up_to_switch_apps_enabled";
            }
        }
        return "navigationbar_is_min";
    }

    private static List<String> getHomes(Context context) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().activityInfo.packageName);
        }
        return arrayList;
    }

    public static int getNavigationBarHeight(Context context) {
        if (isXiaoMi(context)) {
            return getNavigationBarHeightByXiaomi(context);
        }
        if (hasNavigationBar(context)) {
            Resources resources = context.getResources();
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
        }
        return 0;
    }

    public static int getNavigationBarHeightByXiaomi(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels - defaultDisplay.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String getNavigationBarOverride() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static int getRealScreenHeight(Context context) {
        if (!isNavBarHide(context)) {
            return getScreenHeight() + getNavigationBarHeight(context);
        }
        return getScreenHeight();
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().widthPixels > Resources.getSystem().getDisplayMetrics().heightPixels ? Resources.getSystem().getDisplayMetrics().widthPixels : Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels > Resources.getSystem().getDisplayMetrics().heightPixels ? Resources.getSystem().getDisplayMetrics().heightPixels : Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getSmartBarHeight() {
        int identifier = Resources.getSystem().getIdentifier("mz_action_button_min_height", "dimen", "android");
        if (identifier > 0) {
            return Resources.getSystem().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getSoftKeyboardHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return getScreenHeight() - rect.bottom;
    }

    public static int getStatusHeight() {
        int identifier = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return Resources.getSystem().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static boolean hasNavigationBar(Context context) {
        int identifier = Resources.getSystem().getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = Resources.getSystem().getBoolean(identifier);
            String navigationBarOverride = getNavigationBarOverride();
            if ("1".equals(navigationBarOverride)) {
                return false;
            }
            if ("0".equals(navigationBarOverride)) {
                return true;
            }
            return z;
        }
        return !ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    public static boolean isHome(Context context) {
        ComponentName componentName;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1);
        List<String> homes = getHomes(context);
        componentName = runningTasks.get(0).topActivity;
        return homes.contains(componentName.getPackageName());
    }

    public static boolean isMeizu() {
        return Build.BRAND.equals("Meizu");
    }

    public static boolean isNavBarHide(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int navigationBarHeight = getNavigationBarHeight(context);
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || (!str.equalsIgnoreCase(oIX0oI.f32059ooOOo0oXI) && !str.equalsIgnoreCase("OPPO"))) {
                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("Nokia")) {
                    if (Settings.Secure.getInt(context.getContentResolver(), "swipe_up_to_switch_apps_enabled", 0) != 1 && Settings.System.getInt(context.getContentResolver(), "navigation_bar_can_hiden", 0) == 0) {
                        return false;
                    }
                    return true;
                }
                if (displayMetrics.heightPixels + navigationBarHeight > point.y && Settings.Global.getInt(context.getContentResolver(), getDeviceForceName(), 0) == 0) {
                    return false;
                }
                return true;
            }
            if (Settings.Secure.getInt(context.getContentResolver(), getDeviceForceName(), 0) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isXiaoMi(Context context) {
        if (!Build.MANUFACTURER.equals("Xiaomi") || Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
            return false;
        }
        return true;
    }

    public static int px2dp(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}

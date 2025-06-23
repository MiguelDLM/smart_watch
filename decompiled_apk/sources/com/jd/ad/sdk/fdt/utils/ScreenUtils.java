package com.jd.ad.sdk.fdt.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_do.jad_bo;

/* loaded from: classes10.dex */
public class ScreenUtils {
    private ScreenUtils() {
    }

    public static float dip2px(Context context, float f) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        return context == null ? f : (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int getDensityDpi(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return getDisplay(context).densityDpi;
    }

    public static int getDimSize() {
        return Resources.getSystem().getConfiguration().screenLayout & 15;
    }

    public static int getDirection(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getConfiguration().orientation;
    }

    public static DisplayMetrics getDisplay(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static int getPhoneHeight(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return getDisplay(context).heightPixels;
    }

    public static int getPhoneWidth(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return getDisplay(context).widthPixels;
    }

    public static int getScreenDensity() {
        int i = Resources.getSystem().getDisplayMetrics().densityDpi;
        if (i == 0) {
            return 1;
        }
        if (i < 140) {
            return 0;
        }
        return i > 200 ? 2 : 1;
    }

    public static int getScreenDpi(@NonNull Context context) {
        WindowManager windowManager;
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (SecurityException e) {
            e.printStackTrace();
            windowManager = null;
        }
        if (windowManager == null) {
            return 1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    public static int getScreenSize() {
        int i = Resources.getSystem().getConfiguration().screenLayout & 15;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return 0;
                    }
                }
            }
        }
        return i2;
    }

    public static float getShowHeight(Context context, float f, float f2) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return f2;
        }
        float dip2px = dip2px(context, f);
        float dip2px2 = dip2px(context, f2);
        float phoneWidth = getPhoneWidth(context);
        return dip2px > phoneWidth ? (dip2px2 * phoneWidth) / phoneWidth : dip2px2;
    }

    public static int getXdpi(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return (int) getDisplay(context).xdpi;
    }

    public static int getYdpi(Context context) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return (int) getDisplay(context).ydpi;
    }

    public static int px2dip(Context context, float f) {
        if (context == null) {
            context = jad_bo.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int[] getScreenSize(@NonNull Context context) {
        WindowManager windowManager;
        int[] iArr = new int[2];
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (SecurityException e) {
            e.printStackTrace();
            windowManager = null;
        }
        if (windowManager == null) {
            return iArr;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }
}

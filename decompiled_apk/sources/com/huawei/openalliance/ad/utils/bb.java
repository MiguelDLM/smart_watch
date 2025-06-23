package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.ads.cl;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class bb {
    public static int Code(Context context) {
        Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0 && I(context) && Z(context)) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static boolean I(Context context) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int b = d.b(context);
            fb.Code("SysUtil", "isGesture: %s", Integer.valueOf(b));
            if (b == 0) {
                return true;
            }
        } else {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
            String Code = Code("qemu.hw.mainkeys", context);
            if (!"1".equals(Code)) {
                if ("0".equals(Code)) {
                    return true;
                }
                return z;
            }
        }
        return false;
    }

    public static int V(Context context, int i) {
        return i == 0 ? d.Z(context) : d.B(context);
    }

    private static boolean Z(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i - displayMetrics2.heightPixels > 0 || i2 - displayMetrics2.widthPixels > 0;
    }

    public static int Code(Context context, float f) {
        if (context != null && f > 0.0f) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static void V(Context context) {
        if (context == null) {
            return;
        }
        com.huawei.openalliance.ad.ipc.g.V(context).Code("removeExSplashBlock", null, null, null);
    }

    public static int Code(Context context, int i) {
        return i == 0 ? d.B(context) : d.Z(context);
    }

    public static String Code(String str, Context context) {
        StringBuilder sb;
        String str2;
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    cls = Class.forName(cl.Code(context).C());
                } catch (ClassNotFoundException unused) {
                }
                return (String) cls.getMethod("get", String.class).invoke(cls, str);
            }
            cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (RuntimeException e) {
            e = e;
            sb = new StringBuilder();
            str2 = "getSystemProperties RuntimeException:";
            sb.append(str2);
            sb.append(e.getClass().getSimpleName());
            fb.I("SysUtil", sb.toString());
            return null;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str2 = "getSystemProperties Exception:";
            sb.append(str2);
            sb.append(e.getClass().getSimpleName());
            fb.I("SysUtil", sb.toString());
            return null;
        }
    }
}

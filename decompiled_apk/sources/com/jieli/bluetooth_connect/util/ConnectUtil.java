package com.jieli.bluetooth_connect.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes10.dex */
public class ConnectUtil {
    public static final boolean isSupportAndroid12 = true;

    @SuppressLint({"StaticFieldLeak"})
    private static WeakReference<Context> sContextWeak;

    public static void checkAllNotNull(Object... references) {
        for (Object obj : references) {
            obj.getClass();
        }
    }

    public static <T> T checkNotNull(T obj) {
        obj.getClass();
        return obj;
    }

    public static String formatString(String format, Object... args) {
        return String.format(Locale.ENGLISH, format, args);
    }

    public static Context getContext() {
        WeakReference<Context> weakReference = sContextWeak;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static long getCurrentTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public static boolean isHasConnectPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return isHasPermission(context, "android.permission.BLUETOOTH_CONNECT");
        }
        return true;
    }

    public static boolean isHasLocationPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return true;
        }
        return isHasPermission(context, g.h);
    }

    public static boolean isHasPermission(Context context, String permission) {
        if (context != null && ContextCompat.checkSelfPermission(context, permission) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isHasScanPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return isHasPermission(context, "android.permission.BLUETOOTH_SCAN");
        }
        return true;
    }

    public static boolean isHasStoragePermission(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            if (i >= 33) {
                if (isHasPermission(context, "android.permission.READ_MEDIA_IMAGES") || isHasPermission(context, "android.permission.READ_MEDIA_AUDIO") || isHasPermission(context, "android.permission.READ_MEDIA_VIDEO") || isHasPermission(context, g.i)) {
                    return true;
                }
                return false;
            }
            return isHasPermission(context, g.i);
        }
        if (isHasPermission(context, g.i) && isHasPermission(context, g.j)) {
            return true;
        }
        return false;
    }

    public static void setContext(Context context) {
        sContextWeak = new WeakReference<>(context);
    }

    public static <T> T checkNotNull(T obj, String errMsg) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(errMsg);
    }
}

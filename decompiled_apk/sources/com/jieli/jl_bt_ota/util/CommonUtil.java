package com.jieli.jl_bt_ota.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes10.dex */
public class CommonUtil {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static WeakReference<Context> f17810a = null;
    public static final boolean isSupportAndroid12 = true;

    private static void a() {
        WeakReference<Context> weakReference = f17810a;
        if (weakReference != null) {
            weakReference.clear();
            System.gc();
        }
    }

    public static void checkAllNotNull(Object... objArr) {
        for (Object obj : objArr) {
            obj.getClass();
        }
    }

    public static boolean checkHasConnectPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return checkHasPermission(context, "android.permission.BLUETOOTH_CONNECT");
        }
        return true;
    }

    public static boolean checkHasLocationPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 31 || checkHasPermission(context, g.g) || checkHasPermission(context, g.h)) {
            return true;
        }
        return false;
    }

    public static boolean checkHasPermission(Context context, String str) {
        if (context == null || ContextCompat.checkSelfPermission(context, str) != 0) {
            return false;
        }
        return true;
    }

    public static boolean checkHasScanPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return checkHasPermission(context, "android.permission.BLUETOOTH_SCAN");
        }
        return true;
    }

    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static long getCurrentTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public static Context getMainContext() {
        WeakReference<Context> weakReference = f17810a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static void setMainContext(Context context) {
        f17810a = new WeakReference<>((Context) checkNotNull(context));
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}

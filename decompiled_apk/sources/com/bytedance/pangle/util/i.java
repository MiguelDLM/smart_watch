package com.bytedance.pangle.util;

import android.os.Build;

/* loaded from: classes8.dex */
public final class i {
    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return false;
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT <= 23) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT <= 25) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 && i <= 28) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29 && i <= 30) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        if (Build.VERSION.SDK_INT > 23) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            if (i2 == 27) {
                i = Build.VERSION.PREVIEW_SDK_INT;
                if (i <= 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean k() {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 31) {
            if (i2 == 30) {
                i = Build.VERSION.PREVIEW_SDK_INT;
                if (i <= 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }
}

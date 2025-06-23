package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes13.dex */
public final class al {

    /* renamed from: a, reason: collision with root package name */
    public static String f26544a = "CrashReportInfo";
    public static String b = "CrashReport";
    public static boolean c = false;

    private static boolean a(int i, String str, Object... objArr) {
        if (!c) {
            return false;
        }
        if (str == null) {
            str = "null";
        } else if (objArr != null && objArr.length != 0) {
            str = String.format(Locale.US, str, objArr);
        }
        if (i == 0) {
            Log.i(b, str);
            return true;
        }
        if (i == 1) {
            Log.d(b, str);
            return true;
        }
        if (i == 2) {
            Log.w(b, str);
            return true;
        }
        if (i == 3) {
            Log.e(b, str);
            return true;
        }
        if (i != 5) {
            return false;
        }
        Log.i(f26544a, str);
        return true;
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Throwable th) {
        return a(3, th);
    }

    private static boolean a(int i, Throwable th) {
        if (c) {
            return a(i, ap.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(Throwable th) {
        return a(2, th);
    }
}

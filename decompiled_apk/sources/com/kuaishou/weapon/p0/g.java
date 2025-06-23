package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Process;

/* loaded from: classes11.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f18396a = "android.permission.INTERNET";
    public static final String b = "android.permission.ACCESS_NETWORK_STATE";
    public static final String c = "android.permission.READ_PHONE_STATE";
    public static final String d = "android.permission.ACCESS_WIFI_STATE";
    public static final String e = "android.permission.GET_TASKS";
    public static final String f = "android.permission.GET_ACCOUNTS";
    public static final String g = "android.permission.ACCESS_FINE_LOCATION";
    public static final String h = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String i = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String j = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String k = "android.permission.BIND_ACCESSIBILITY_SERVICE";

    public static boolean a(Context context, String[] strArr) {
        if (strArr == null) {
            return true;
        }
        try {
            for (String str : strArr) {
                if (a(context, str) != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int a(Context context, String str) {
        if (context == null || str == null) {
            return -1;
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }
}

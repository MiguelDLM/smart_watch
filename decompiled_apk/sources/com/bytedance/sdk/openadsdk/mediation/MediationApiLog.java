package com.bytedance.sdk.openadsdk.mediation;

import android.util.Log;

/* loaded from: classes8.dex */
public class MediationApiLog {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f10801a = false;
    private static String b = "MEDIATION_LOG";

    public static void e(String str, String str2) {
        if (f10801a) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (f10801a) {
            Log.i(str, str2);
        }
    }

    public static void setDebug(Boolean bool) {
        f10801a = bool.booleanValue();
    }

    public static void e(String str) {
        if (f10801a) {
            Log.e(b, str);
        }
    }

    public static void i(String str) {
        if (f10801a) {
            Log.i(b, str);
        }
    }
}

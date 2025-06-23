package com.jd.ad.sdk.jad_dq;

import android.util.Log;

/* loaded from: classes10.dex */
public class jad_an {
    public static boolean jad_an = false;
    public static boolean jad_bo = false;
    public static boolean jad_cp = false;

    public static void jad_an(String str, String str2) {
        String str3;
        if (jad_an) {
            Log.d(str, str2);
            try {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                StringBuilder sb = new StringBuilder("stacktrace: \n");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
                str3 = sb.toString();
            } catch (Throwable unused) {
                str3 = "";
            }
            Log.d(str, str3);
        }
    }

    public static void jad_bo(String str, String str2) {
        if (jad_cp) {
            Log.e(str, str2);
        }
    }

    public static void jad_cp(String str, String str2) {
        if (jad_bo) {
            Log.w(str, str2);
        }
    }
}

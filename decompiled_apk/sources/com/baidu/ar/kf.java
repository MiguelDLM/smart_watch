package com.baidu.ar;

import android.util.Log;

/* loaded from: classes7.dex */
public final class kf {
    private static int Df = 2;

    public static void ae(boolean z) {
        Df = z ? 2 : 6;
    }

    public static void b(String str, String str2) {
        if (Df > 6) {
            return;
        }
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        if (Df > 3) {
            return;
        }
        Log.d(str, str2);
    }

    public static void ci(String str) {
        t("ARLOG", hf() + " " + str);
    }

    public static void cj(String str) {
        c("ARLOG", hf() + " " + str);
    }

    public static void ck(String str) {
        u("ARLOG", hf() + " " + str);
    }

    public static void cl(String str) {
        b("ARLOG", hf() + " " + str);
    }

    public static String hf() {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[2];
        StringBuffer stringBuffer = new StringBuffer("[");
        stringBuffer.append(stackTraceElement.getFileName());
        stringBuffer.append(" | ");
        stringBuffer.append(stackTraceElement.getLineNumber());
        stringBuffer.append(" | ");
        stringBuffer.append(stackTraceElement.getMethodName());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static void t(String str, String str2) {
        if (Df > 2) {
            return;
        }
        Log.v(str, str2);
    }

    public static void u(String str, String str2) {
        if (Df > 4) {
            return;
        }
        Log.i(str, str2);
    }

    public static void v(String str, String str2) {
        if (Df > 5) {
            return;
        }
        Log.w(str, str2);
    }
}

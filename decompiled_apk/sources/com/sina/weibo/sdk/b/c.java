package com.sina.weibo.sdk.b;

import XXO0.oIX0oI;
import android.util.Log;

/* loaded from: classes11.dex */
public final class c {
    private static boolean ai = false;

    public static void a(String str, String str2) {
        if (ai) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(str, (stackTraceElement.getFileName() + oIX0oI.I0Io.f4096II0xO0 + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
        }
    }

    public static void b(String str, String str2) {
        if (ai) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.e(str, (stackTraceElement.getFileName() + oIX0oI.I0Io.f4096II0xO0 + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
        }
    }

    public static void setLoggerEnable(boolean z) {
        ai = z;
    }
}

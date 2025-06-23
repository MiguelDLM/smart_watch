package com.baidu.datahub;

import android.util.Log;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

/* loaded from: classes7.dex */
public final class BDLog {
    public static boolean LOG_ENABLE = false;

    public static final void d(String str, String str2) {
        if (LOG_ENABLE) {
            Log.d(str + HelpFormatter.DEFAULT_OPT_PREFIX + getMethodName() + HelpFormatter.DEFAULT_OPT_PREFIX + getLineInfo(), str2);
            LogFile.d(str, str2);
        }
    }

    public static final void dforce(String str, String str2) {
        String str3 = str + HelpFormatter.DEFAULT_OPT_PREFIX + getMethodName() + HelpFormatter.DEFAULT_OPT_PREFIX + getLineInfo();
        Log.d(str3, str2);
        LogFile.d(str3, str2);
    }

    public static final void e(String str, String str2) {
        if (LOG_ENABLE) {
            String str3 = str + HelpFormatter.DEFAULT_OPT_PREFIX + getMethodName() + HelpFormatter.DEFAULT_OPT_PREFIX + getLineInfo();
            Log.e(str3, str2);
            LogFile.e(str3, str2);
        }
    }

    private static String getFileName() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }

    private static String getLineInfo() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + ": Line " + stackTraceElement.getLineNumber();
    }

    private static String getMethodName() {
        return new Throwable().getStackTrace()[2].getMethodName();
    }

    private static String getShortTraceInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        stringBuffer.append("[method: ");
        stringBuffer.append(stackTrace[2].getMethodName());
        stringBuffer.append("; line: ");
        stringBuffer.append(stackTrace[2].getLineNumber());
        stringBuffer.append("; class: ");
        stringBuffer.append(stackTrace[2].getFileName());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private static String getTraceInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        stringBuffer.append("method: ");
        stringBuffer.append(stackTrace[2].getMethodName());
        stringBuffer.append("; line: ");
        stringBuffer.append(stackTrace[2].getLineNumber());
        stringBuffer.append("; class: ");
        stringBuffer.append(stackTrace[2].getClassName());
        return stringBuffer.toString();
    }

    public static final void i(String str, String str2) {
        if (LOG_ENABLE) {
            String str3 = str + HelpFormatter.DEFAULT_OPT_PREFIX + getMethodName() + HelpFormatter.DEFAULT_OPT_PREFIX + getLineInfo();
            Log.i(str3, str2);
            LogFile.i(str3, str2);
        }
    }

    public static void setLogEnable(boolean z) {
        LOG_ENABLE = z;
    }

    public static final void dforce(String str, String str2, Throwable th) {
        String str3 = str + HelpFormatter.DEFAULT_OPT_PREFIX + getMethodName() + HelpFormatter.DEFAULT_OPT_PREFIX + getLineInfo();
        Log.d(str3, str2, th);
        LogFile.d(str3, str2);
    }

    public static final void d(String str, String str2, Throwable th) {
        if (LOG_ENABLE) {
            String str3 = str + HelpFormatter.DEFAULT_OPT_PREFIX + getMethodName() + HelpFormatter.DEFAULT_OPT_PREFIX + getLineInfo();
            Log.d(str3, str2, th);
            LogFile.d(str3, str2);
        }
    }

    public static final void e(String str, String str2, Throwable th) {
        if (LOG_ENABLE) {
            String str3 = str + HelpFormatter.DEFAULT_OPT_PREFIX + getMethodName() + HelpFormatter.DEFAULT_OPT_PREFIX + getLineInfo();
            Log.e(str3, str2, th);
            LogFile.e(str3, str2);
        }
    }

    public static final void i(String str, String str2, Throwable th) {
        if (LOG_ENABLE) {
            String str3 = str + HelpFormatter.DEFAULT_OPT_PREFIX + getMethodName() + HelpFormatter.DEFAULT_OPT_PREFIX + getLineInfo();
            Log.i(str3, str2, th);
            LogFile.i(str3, str2);
        }
    }
}

package com.alibaba.sdk.android.oss.common;

public class OSSLog {
    private static final String TAG = "OSS-Android-SDK";
    private static boolean enableLog = false;
    private static LogPrinter logPrinter = new DefaultLogPrinter();
    private static LogPrinter nopLogPrinter = new LogPrinter() {
        public void log(LogLevel logLevel, String str) {
        }
    };

    public static void disableLog() {
        enableLog = false;
    }

    public static void enableLog() {
        enableLog = true;
    }

    public static LogPrinter getLogPrinter() {
        return logPrinter;
    }

    public static boolean isEnableLog() {
        return enableLog;
    }

    private static void log2Local(String str, boolean z) {
        if (z) {
            OSSLogToFileUtils.getInstance().write(str);
        }
    }

    public static void logDebug(String str) {
        logDebug(TAG, str);
    }

    public static void logError(String str) {
        logError(TAG, str);
    }

    public static void logInfo(String str) {
        logInfo(str, true);
    }

    public static void logThrowable2Local(Throwable th) {
        if (enableLog) {
            OSSLogToFileUtils.getInstance().write(th);
        }
    }

    public static void logVerbose(String str) {
        logVerbose(str, true);
    }

    public static void logWarn(String str) {
        logWarn(str, true);
    }

    public static void setLogPrinter(LogPrinter logPrinter2) {
        if (logPrinter2 == null) {
            logPrinter = nopLogPrinter;
        } else {
            logPrinter = logPrinter2;
        }
    }

    public static void logDebug(String str, String str2) {
        logDebug(str, str2, true);
    }

    public static void logError(String str, String str2) {
        logError(str, str2, true);
    }

    public static void logInfo(String str, boolean z) {
        if (enableLog) {
            logPrinter.log(LogLevel.INFO, str);
            log2Local(str, z);
        }
    }

    public static void logVerbose(String str, boolean z) {
        if (enableLog) {
            logPrinter.log(LogLevel.VERBOSE, str);
            log2Local(str, z);
        }
    }

    public static void logWarn(String str, boolean z) {
        if (enableLog) {
            logPrinter.log(LogLevel.WARN, str);
            log2Local(str, z);
        }
    }

    public static void logDebug(String str, boolean z) {
        logDebug(TAG, str, z);
    }

    public static void logError(String str, boolean z) {
        logError(TAG, str, z);
    }

    public static void logDebug(String str, String str2, boolean z) {
        if (enableLog) {
            logPrinter.log(LogLevel.DEBUG, str2);
            log2Local(str2, z);
        }
    }

    public static void logError(String str, String str2, boolean z) {
        if (enableLog) {
            logPrinter.log(LogLevel.ERROR, str2);
            log2Local(str2, z);
        }
    }
}

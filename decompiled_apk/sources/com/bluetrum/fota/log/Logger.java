package com.bluetrum.fota.log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes8.dex */
public class Logger {
    private static int logLevel = 4;
    private static ILogger logger;

    public static void d(@Nullable String str, @NonNull String str2) {
        log(3, str, str2, null);
    }

    public static void e(@Nullable String str, @NonNull String str2) {
        log(6, str, str2, null);
    }

    public static void i(@Nullable String str, @NonNull String str2) {
        log(4, str, str2, null);
    }

    public static void log(int i, @Nullable String str, @NonNull String str2, @Nullable Throwable th) {
        ILogger iLogger = logger;
        if (iLogger != null && i >= logLevel) {
            iLogger.log(i, str, str2, th);
        }
    }

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    public static void setLogger(ILogger iLogger) {
        logger = iLogger;
    }

    public static void v(@Nullable String str, @NonNull String str2) {
        log(2, str, str2, null);
    }

    public static void w(@Nullable String str, @NonNull String str2) {
        log(5, str, str2, null);
    }

    public static void wtf(@Nullable String str, @NonNull String str2) {
        log(7, str, str2, null);
    }

    public static void d(@Nullable String str, @NonNull String str2, @Nullable Throwable th) {
        log(3, str, str2, th);
    }

    public static void e(@Nullable String str, @Nullable Throwable th) {
        log(6, str, "", th);
    }

    public static void i(@Nullable String str, @NonNull String str2, @Nullable Throwable th) {
        log(4, str, str2, th);
    }

    public static void v(@Nullable String str, @NonNull String str2, @Nullable Throwable th) {
        log(2, str, str2, th);
    }

    public static void w(@Nullable String str, @NonNull String str2, @Nullable Throwable th) {
        log(5, str, str2, th);
    }

    public static void wtf(@Nullable String str, @NonNull Throwable th) {
        log(7, str, "", th);
    }

    public static void e(@Nullable String str, @NonNull String str2, @Nullable Throwable th) {
        log(6, str, str2, th);
    }

    public static void w(@Nullable String str, @NonNull Throwable th) {
        log(5, str, "", th);
    }

    public static void wtf(@Nullable String str, @NonNull String str2, @Nullable Throwable th) {
        log(7, str, str2, th);
    }
}

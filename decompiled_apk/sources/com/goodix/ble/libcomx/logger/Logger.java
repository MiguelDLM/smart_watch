package com.goodix.ble.libcomx.logger;

import com.goodix.ble.libcomx.ILogger;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes9.dex */
public class Logger {
    public static final SimpleDateFormat DATE_FORMAT_LOG_FILE;
    public static final SimpleDateFormat DATE_FORMAT_TIMESTAMP;

    static {
        Locale locale = Locale.US;
        DATE_FORMAT_TIMESTAMP = new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD_HH_MM_SS_SSS, locale);
        DATE_FORMAT_LOG_FILE = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS", locale);
    }

    public static void d(ILogger iLogger, String str, String str2) {
        if (iLogger != null) {
            iLogger.d(str, str2);
        }
    }

    public static void e(ILogger iLogger, String str, String str2) {
        if (iLogger != null) {
            iLogger.e(str, str2);
        }
    }

    public static void i(ILogger iLogger, String str, String str2) {
        if (iLogger != null) {
            iLogger.i(str, str2);
        }
    }

    public static void v(ILogger iLogger, String str, String str2) {
        if (iLogger != null) {
            iLogger.v(str, str2);
        }
    }

    public static void w(ILogger iLogger, String str, String str2) {
        if (iLogger != null) {
            iLogger.w(str, str2);
        }
    }

    public static void d(ILogger iLogger, String str, String str2, Object... objArr) {
        if (iLogger != null) {
            iLogger.d(str, String.format(str2, objArr));
        }
    }

    public static void e(ILogger iLogger, String str, String str2, Throwable th) {
        if (iLogger != null) {
            iLogger.e(str, str2, th);
        }
    }

    public static void i(ILogger iLogger, String str, String str2, Object... objArr) {
        if (iLogger != null) {
            iLogger.i(str, String.format(str2, objArr));
        }
    }

    public static void v(ILogger iLogger, String str, String str2, Object... objArr) {
        if (iLogger != null) {
            iLogger.v(str, String.format(str2, objArr));
        }
    }

    public static void w(ILogger iLogger, String str, String str2, Object... objArr) {
        if (iLogger != null) {
            iLogger.w(str, String.format(str2, objArr));
        }
    }

    public static void e(ILogger iLogger, String str, String str2, Object... objArr) {
        if (iLogger != null) {
            iLogger.e(str, String.format(str2, objArr));
        }
    }

    public static void e(ILogger iLogger, String str, String str2, Throwable th, Object... objArr) {
        if (iLogger != null) {
            iLogger.e(str, String.format(str2, objArr), th);
        }
    }
}

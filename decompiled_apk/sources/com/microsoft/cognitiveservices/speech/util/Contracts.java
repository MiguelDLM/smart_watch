package com.microsoft.cognitiveservices.speech.util;

import java.io.File;

/* loaded from: classes11.dex */
public class Contracts {
    private static final native String getErrorCallStack(long j);

    private static final native int getErrorCode(long j);

    private static final native String getErrorMessage(long j);

    public static void logErrorIfFail(long j) {
        if (j != 0) {
            int errorCode = getErrorCode(j);
            if (getErrorMessage(j) == "") {
                Integer.toString(errorCode);
            }
            releaseErrorHandle(j);
        }
    }

    private static final native long releaseErrorHandle(long j);

    public static void throwIfDirectoryDoesNotExist(String str, String str2) {
        throwIfNullOrWhitespace(str, str2);
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void throwIfFail(long j) {
        if (j != 0) {
            int errorCode = getErrorCode(j);
            String errorMessage = getErrorMessage(j);
            if (errorMessage == "") {
                errorMessage = "Exception with an error code:" + Integer.toString(errorCode);
            }
            releaseErrorHandle(j);
            throw new RuntimeException(errorMessage);
        }
    }

    public static void throwIfFileDoesNotExist(String str, String str2) {
        throwIfNullOrWhitespace(str, str2);
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void throwIfIllegalLanguage(String str, String str2) {
        throwIfNullOrWhitespace(str, str2);
    }

    public static void throwIfIllegalSubscriptionKey(String str, String str2) {
        throwIfNullOrWhitespace(str, str2);
    }

    public static void throwIfNull(long j, String str) {
        if (j == 0) {
            throw new NullPointerException(str);
        }
    }

    public static void throwIfNullOrWhitespace(String str, String str2) {
        if (str == null) {
            throw new NullPointerException(str2);
        }
        if (str.length() == 0 || str.trim().length() == 0) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void throwIfStateIsTrue(Boolean bool, String str) {
        if (bool.booleanValue()) {
            throw new IllegalStateException(str);
        }
    }

    public static void throwIfNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }
}

package com.univocity.parsers.common;

import java.util.Arrays;

/* loaded from: classes13.dex */
abstract class AbstractException extends RuntimeException {
    private static final long serialVersionUID = -2993096896413328423L;

    public AbstractException(String str, Throwable th) {
        super(str, th);
    }

    public static String printIfNotEmpty(String str, String str2, Object obj) {
        String valueOf;
        if (obj != null && !obj.toString().isEmpty()) {
            if ((obj instanceof Number) && ((Number) obj).intValue() < 0) {
                return str;
            }
            if (obj.getClass().isArray()) {
                valueOf = Arrays.toString((Object[]) obj);
            } else {
                valueOf = String.valueOf(obj);
            }
            String str3 = str2 + '=' + valueOf;
            if (!str.isEmpty()) {
                return str + ", " + str3;
            }
            return str3;
        }
        return str;
    }

    public abstract String getDetails();

    public abstract String getErrorDescription();

    @Override // java.lang.Throwable
    public final String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = getErrorDescription() + ": ";
        }
        String details = getDetails();
        if (details != null && !details.isEmpty()) {
            return message + "\nInternal state when error was thrown: " + details;
        }
        return message;
    }
}

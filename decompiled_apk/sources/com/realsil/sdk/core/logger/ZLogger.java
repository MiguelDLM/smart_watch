package com.realsil.sdk.core.logger;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.realsil.sdk.core.g.a;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class ZLogger {
    public static final int ASSET = 6;
    public static final int DEBUG = 2;
    public static final int ERROR = 5;
    public static int GLOBAL_LOG_LEVEL = 1;
    public static final int INFO = 3;
    public static boolean LOG_ENABLED = false;
    public static final int NA = 0;
    public static final int VERBOSE = 1;
    public static final int WARN = 4;

    /* renamed from: a, reason: collision with root package name */
    public static String f19520a = "Realtek";
    public static int b;
    public static Logger c = new a();

    public static void a(boolean z, int i, String str, Object obj) {
        String[] strArr;
        if (z) {
            Object[] objArr = {obj};
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null || stackTrace.length < 6) {
                strArr = null;
            } else {
                String className = stackTrace[5].getClassName();
                String[] split = className.split("\\.");
                if (split.length > 0) {
                    className = split[split.length - 1] + ".java";
                }
                if (className.contains("$")) {
                    className = className.split("\\$")[0] + ".java";
                }
                String methodName = stackTrace[5].getMethodName();
                int lineNumber = stackTrace[5].getLineNumber();
                if (lineNumber < 0) {
                    lineNumber = 0;
                }
                String str2 = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
                String str3 = str == null ? className : str;
                if (TextUtils.isEmpty(str3)) {
                    str3 = f19520a;
                }
                strArr = new String[]{str3, objArr[0].toString(), String.format(Locale.US, "[ (%s:%d)#%s ]", className, Integer.valueOf(lineNumber), str2)};
            }
            if (strArr != null && strArr.length >= 3) {
                String str4 = strArr[0];
                String str5 = strArr[1];
                a(i, str4, strArr[2] + str5);
                return;
            }
            a(i, str, (String) obj);
        }
    }

    public static void d(String str) {
        a(LOG_ENABLED, 2, f19520a, str);
    }

    public static void e(String str) {
        a(LOG_ENABLED, 5, f19520a, str);
    }

    public static void i(String str) {
        a(LOG_ENABLED, 3, f19520a, str);
    }

    public static void initialize(String str, boolean z) {
        initialize(str, z, 1);
    }

    public static void setConsoleLogLevel(int i) {
        GLOBAL_LOG_LEVEL = i;
    }

    public static void setFilterLogLevel(int i) {
        b = i;
    }

    public static void setLogger(@NonNull Logger logger) {
        c = logger;
    }

    public static void v(String str) {
        a(LOG_ENABLED, 1, f19520a, str);
    }

    public static void w(String str) {
        a(LOG_ENABLED, 4, f19520a, str);
    }

    public static void d(boolean z, String str) {
        a(z, 2, f19520a, str);
    }

    public static void e(boolean z, String str) {
        a(z, 5, f19520a, str);
    }

    public static void i(boolean z, String str) {
        a(z, 3, f19520a, str);
    }

    public static void initialize(String str, boolean z, int i) {
        f19520a = str;
        LOG_ENABLED = z;
        GLOBAL_LOG_LEVEL = i;
    }

    public static void v(boolean z, String str) {
        a(z, 1, f19520a, str);
    }

    public static void w(boolean z, String str) {
        a(z, 4, f19520a, str);
    }

    public static void d(boolean z, String str, String str2) {
        a(z, 2, str, str2);
    }

    public static void e(boolean z, String str, String str2) {
        a(z, 5, str, str2);
    }

    public static void i(boolean z, String str, String str2) {
        a(z, 3, str, str2);
    }

    public static void v(boolean z, String str, String str2) {
        a(z, 1, str, str2);
    }

    public static void w(boolean z, String str, String str2) {
        a(z, 4, str, str2);
    }

    public static void a(int i, String str, String str2) {
        if (c == null) {
            return;
        }
        int max = Math.max(i, GLOBAL_LOG_LEVEL);
        if ((max & 6) == 6 && b <= 6) {
            c.log(6, str, str2);
            return;
        }
        if ((max & 5) == 5 && b <= 5) {
            c.log(5, str, str2);
            return;
        }
        if ((max & 4) == 4 && b <= 4) {
            c.log(4, str, str2);
            return;
        }
        if ((max & 3) == 3 && b <= 3) {
            c.log(3, str, str2);
            return;
        }
        if ((max & 2) == 2 && b <= 2) {
            c.log(2, str, str2);
        } else {
            if ((max & 1) != 1 || b > 1) {
                return;
            }
            c.log(1, str, str2);
        }
    }
}

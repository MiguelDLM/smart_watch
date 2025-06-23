package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: classes11.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int f18394a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = -1;
    public static int f = -1;
    static ThreadLocal<StringBuilder> g = new ThreadLocal<>();
    private static int h;

    private static void a(int i, String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            if (i == 0) {
                Log.i("WeaponSDK", str);
                return;
            } else if (i == 1) {
                Log.d("WeaponSDK", str);
                return;
            } else {
                if (i != 2) {
                    return;
                }
                Log.e("WeaponSDK", str);
                return;
            }
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        if (fileName.length() > 5) {
            fileName = fileName.substring(0, fileName.length() - 5);
        }
        StringBuilder sb2 = g.get();
        if (sb2 == null) {
            sb2 = new StringBuilder();
            g.set(sb2);
        }
        synchronized (sb2) {
            sb2.setLength(0);
            sb2.append("[");
            sb2.append(h);
            sb2.append("][");
            sb2.append(fileName);
            sb2.append(':');
            sb2.append(lineNumber);
            sb2.append('.');
            sb2.append(methodName);
            sb2.append("] ");
            sb2.append(str);
            sb = sb2.toString();
            h++;
        }
        if (i == 0) {
            Log.i("WeaponSDK", sb);
        } else if (i == 1) {
            Log.d("WeaponSDK", sb);
        } else {
            if (i != 2) {
                return;
            }
            Log.e("WeaponSDK", sb);
        }
    }

    public static void b(String str) {
        int i = f;
        if (i == -1 || i == 0 || i == 1) {
            a(1, str);
        }
    }

    public static void c(String str) {
        int i = f;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            a(2, str);
        }
    }

    public static void d(String str) {
    }

    public static void b(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0 || i == 1) {
            a(1, str + "\n" + a(th));
        }
    }

    public static void c(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0 || i == 1 || i == 2) {
            a(2, str + "\n" + a(th));
        }
    }

    public static void a(String str) {
        int i = f;
        if (i == -1 || i == 0) {
            a(0, str);
        }
    }

    public static void a(String str, Throwable th) {
        int i = f;
        if (i == -1 || i == 0) {
            a(0, str + "\n" + a(th));
        }
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}

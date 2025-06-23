package com.baidu.mobads.sdk.internal;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.az;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class ax extends az.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6238a = "local";
    private static final int b = 4000;
    private static final int c = 23;
    private static final int d = 5;
    private static final Pattern e = Pattern.compile("(\\$\\d+)+$");
    private static final char f = 9556;
    private static final char g = 9562;
    private static final char h = 9567;
    private static final char i = 9553;
    private static final String j = "════════════════════════════════════════════";
    private static final String k = "------------------------------------------";
    private static final String l = "╔════════════════════════════════════════════════════════════════════════════════════════";
    private static final String m = "╚════════════════════════════════════════════════════════════════════════════════════════";
    private static final String n = "╟------------------------------------------------------------------------------------";

    @Override // com.baidu.mobads.sdk.internal.az.a
    @NonNull
    public String a() {
        return "local";
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    public final String b() {
        String b2 = super.b();
        if (b2 != null) {
            return b2;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length <= 5) {
            return "";
        }
        return a(stackTrace[5]);
    }

    public String c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z = false;
        int i2 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (!className.equals(az.class.getName()) && !className.equals(bv.class.getName())) {
                if (z) {
                    break;
                }
            } else {
                z = true;
            }
            i2++;
        }
        return "   (" + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + ")# " + stackTrace[i2].getMethodName();
    }

    public String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = e.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String substring = className.substring(className.lastIndexOf(46) + 1);
        return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    public void a(int i2, String str, String str2, Throwable th) {
        int min;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("当前线程：");
            sb.append(Thread.currentThread().getName());
            sb.append(";  ");
            sb.append("调用位置：");
            sb.append(c());
            sb.append(";  ");
            sb.append("打印消息：");
            if (str2.length() > 4000) {
                ArrayList arrayList = new ArrayList();
                int length = str2.length();
                int i3 = 0;
                while (i3 < length) {
                    int indexOf = str2.indexOf(10, i3);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i3 + 4000);
                        arrayList.add(str2.substring(i3, min));
                        if (min >= indexOf) {
                            break;
                        } else {
                            i3 = min;
                        }
                    }
                    i3 = min + 1;
                }
                for (String str3 : (String[]) arrayList.toArray(new String[arrayList.size()])) {
                    a(i2, str, sb.toString() + str3);
                }
                return;
            }
            sb.append(str2);
            a(i2, str, sb.toString());
        } catch (Throwable th2) {
            a(6, str, th2.toString());
        }
    }

    private static void a(int i2, String str, String str2) {
        if (i2 == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i2, str, str2);
        }
    }
}

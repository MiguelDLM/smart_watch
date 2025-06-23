package com.kwad.sdk.crash.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes11.dex */
public final class a {
    private static Set<String> aHf;

    static {
        HashSet hashSet = new HashSet();
        aHf = hashSet;
        hashSet.add("commonHT");
        aHf.add("reportHT");
        aHf.add("IpDirectHelper");
        aHf.add("filedownloader serial thread");
        aHf.add("RemitHandoverToDB");
        aHf.add("source-status-callback");
        aHf.add("ObiwanMMAPTracer");
        aHf.add("FrameSequence decoding thread");
    }

    private static boolean F(@NonNull List<StackTraceElement[]> list) {
        Iterator<StackTraceElement[]> it = list.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] Ig = e.If().Ig();
        if (Ig == null || Ig.length == 0) {
            return true;
        }
        boolean z = false;
        for (String str : Ig) {
            z = a(stackTraceElementArr, str);
            if (z) {
                break;
            }
        }
        if (z) {
            for (String str2 : e.If().Ih()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return z;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AdExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    private static boolean fA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("ksad-") && !str.startsWith("filedownloader serial thread")) {
            return false;
        }
        return true;
    }

    public static boolean fB(String str) {
        if (fA(str) || i.bL(str)) {
            return true;
        }
        Set<String> set = aHf;
        if (set != null && set.contains(str)) {
            c.d("CrashFilter", "needReportByThreadName:" + str);
            return true;
        }
        return false;
    }

    public static boolean fC(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] Ig = e.If().Ig();
        if (Ig != null && Ig.length != 0) {
            boolean z = false;
            for (String str2 : Ig) {
                z = str.contains(str2);
                if (z) {
                    break;
                }
            }
            if (z) {
                for (String str3 : e.If().Ih()) {
                    if (str.contains(str3)) {
                        return false;
                    }
                }
            }
            return z;
        }
        return true;
    }

    public static boolean o(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i = 0; i < 5; i++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return F(arrayList);
    }

    private static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                c.d("AdExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }
}

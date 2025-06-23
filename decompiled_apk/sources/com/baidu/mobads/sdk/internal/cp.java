package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class cp implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public static String f6291a = "";
    private static final String b = "remote";
    private static final String c = "proxy";
    private static final String d = "third-mtj";
    private static final String e = "third-cpu";
    private static final String f = "third-cpu-cyber";
    private static final String g = "third-novel";
    private static final String h = "third-aigc";
    private static final String i = "third-aigc-virtual";
    private static final String j = "third-aigc-speech";
    private static Thread.UncaughtExceptionHandler k = null;
    private static volatile cp l = null;
    private static final String o = "key_crash_source";
    private static final String p = "key_crash_trace";
    private static final String q = "key_crash_ad";
    private Context m;
    private a n;

    /* loaded from: classes7.dex */
    public interface a {
        void a(String str);
    }

    private cp(Context context) {
        this.m = context.getApplicationContext();
        k = Thread.getDefaultUncaughtExceptionHandler();
    }

    private List<String> d() {
        IXAdContainerFactory c2;
        ArrayList arrayList = new ArrayList();
        try {
            aa a2 = aa.a();
            if (a2 != null && (c2 = a2.c()) != null) {
                Object remoteParam = c2.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private SharedPreferences e() {
        return this.m.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor f2 = f();
        f2.clear();
        f2.apply();
    }

    public void c() {
        this.n = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a2 = a(th);
            if (a2 != null) {
                a(a2, Log.getStackTraceString(th));
                a aVar = this.n;
                if (aVar != null) {
                    aVar.a(a2);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = k;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception e2) {
            bv.a().c(e2);
        }
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cp) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static cp a(Context context) {
        if (l == null) {
            synchronized (cp.class) {
                try {
                    if (l == null) {
                        l = new cp(context);
                    }
                } finally {
                }
            }
        }
        return l;
    }

    public void a() {
        be.a().a((i) new cq(this));
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        List<String> d2 = d();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className.startsWith("junit.framework")) {
                return null;
            }
            if (!className.startsWith(x.av) && !className.startsWith(x.aw) && !className.startsWith(x.ax)) {
                if (!className.startsWith(x.ay) && !className.startsWith(x.az) && !className.startsWith(x.aA)) {
                    if (className.startsWith(x.aB)) {
                        return d;
                    }
                    if (className.startsWith(x.aC)) {
                        return e;
                    }
                    if (className.startsWith(x.aD) || className.startsWith(x.aE)) {
                        return f;
                    }
                    if (className.startsWith(x.aM)) {
                        return j;
                    }
                    if (!className.startsWith(x.aI) && !className.startsWith(x.aJ) && !className.startsWith(x.aK) && !className.startsWith(x.aL)) {
                        if (className.startsWith(x.aH)) {
                            return h;
                        }
                        if (!className.startsWith(x.aF) && !className.startsWith(x.aG)) {
                            if (a(className, d2)) {
                            }
                        } else if (co.g.booleanValue()) {
                            return g;
                        }
                    } else {
                        return i;
                    }
                } else {
                    return c;
                }
            }
            return b;
        }
        return null;
    }

    private boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor f2 = f();
        String str3 = "crashtime:" + System.currentTimeMillis() + " ";
        f2.putString(o, str);
        f2.putString(p, str3 + str2);
        f2.putString(q, f6291a);
        f2.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return e().getString(str, "");
    }
}

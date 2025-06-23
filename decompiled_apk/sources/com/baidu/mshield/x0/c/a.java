package com.baidu.mshield.x0.c;

import android.text.TextUtils;
import com.baidu.mshield.x0.b.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* loaded from: classes7.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public static a f6410a = new a();
    public Thread.UncaughtExceptionHandler b;
    public boolean c;
    public b d;

    public static a a() {
        return f6410a;
    }

    public synchronized void b() {
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler != null) {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                this.b = null;
            }
        } finally {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a2 = a(th);
            if (!TextUtils.isEmpty(a2)) {
                if (!a2.contains("mshield")) {
                    if (!a2.contains("WebViewProvider")) {
                        if (a2.contains("createWebView")) {
                        }
                    }
                }
                b bVar = this.d;
                if (bVar != null) {
                    bVar.a(a2);
                }
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public synchronized void a(b bVar) {
        this.d = bVar;
        if (bVar == null) {
            return;
        }
        if (bVar.a()) {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public final String a(Throwable th) {
        PrintWriter printWriter;
        try {
            StringWriter stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            try {
                th.printStackTrace(printWriter);
                String obj = stringWriter.toString();
                printWriter.close();
                return obj;
            } catch (Throwable unused) {
                if (printWriter == null) {
                    return "";
                }
                printWriter.close();
                return "";
            }
        } catch (Throwable unused2) {
            printWriter = null;
        }
    }
}

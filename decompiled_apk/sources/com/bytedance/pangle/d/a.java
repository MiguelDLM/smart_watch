package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Class f10522a;
    private static Object b;

    public static final Object a() {
        if (b == null) {
            try {
                synchronized (a.class) {
                    try {
                        if (b == null) {
                            if (f10522a == null) {
                                f10522a = Class.forName("android.app.ActivityThread");
                            }
                            b = MethodUtils.invokeStaticMethod(f10522a, "currentActivityThread", new Object[0]);
                        }
                        if (b == null && Looper.myLooper() != Looper.getMainLooper()) {
                            final Object obj = new Object();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.d.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        try {
                                            Object unused = a.b = MethodUtils.invokeStaticMethod(a.f10522a, "currentActivityThread", new Object[0]);
                                            synchronized (obj) {
                                                obj.notify();
                                            }
                                        } catch (Exception e) {
                                            ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e);
                                            synchronized (obj) {
                                                obj.notify();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        synchronized (obj) {
                                            obj.notify();
                                            throw th;
                                        }
                                    }
                                }
                            });
                            if (b == null) {
                                synchronized (obj) {
                                    try {
                                        obj.wait(5000L);
                                    } catch (InterruptedException e) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);
                                    }
                                }
                            }
                        }
                    } finally {
                    }
                }
            } catch (Exception e2) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e2);
            }
        }
        return b;
    }
}

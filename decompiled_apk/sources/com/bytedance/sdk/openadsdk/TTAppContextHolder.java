package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.c;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class TTAppContextHolder {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context f10653a;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application f10654a;

        static {
            try {
                Object b = b();
                f10654a = (Application) b.getClass().getMethod("getApplication", null).invoke(b, null);
                c.d("MyApplication", "application get success");
            } catch (Throwable th) {
                c.c("MyApplication", "application get failed", th);
            }
        }

        public static Application a() {
            return f10654a;
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null);
                method.setAccessible(true);
                return method.invoke(null, null);
            } catch (Throwable th) {
                c.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static Context getContext() {
        if (f10653a == null) {
            setContext(null);
        }
        return f10653a;
    }

    public static synchronized void setContext(Context context) {
        synchronized (TTAppContextHolder.class) {
            if (f10653a == null) {
                if (context != null) {
                    f10653a = context.getApplicationContext();
                } else if (a.a() != null) {
                    try {
                        f10653a = a.a();
                        if (f10653a != null) {
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}

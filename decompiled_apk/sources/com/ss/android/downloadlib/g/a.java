package com.ss.android.downloadlib.g;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes11.dex */
public class a {

    /* renamed from: com.ss.android.downloadlib.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C1046a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private Object f26117a;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    a.a(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.f26117a, objArr);
        }

        private C1046a(Object obj) {
            this.f26117a = obj;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.a.c.a(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        Field declaredField;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else {
                declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return;
            }
            Class<?> cls = Class.forName("android.app.IActivityManager");
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C1046a(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.k.a().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.a.c.a(str, new File(str2));
    }

    public static void a() {
        if (com.ss.android.downloadlib.addownload.k.j().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.f.e.h();
                a.c();
            }
        }, 10000L);
    }

    public static void a(Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.k.j().optInt("hook", 0) == 1 && (objArr[1] instanceof String)) {
            Object obj = objArr[2];
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                if ("android.intent.action.VIEW".equals(intent.getAction()) && com.ss.android.socialbase.downloader.constants.e.f26241a.equals(intent.getType())) {
                    if (com.ss.android.socialbase.appdownloader.f.e.d()) {
                        String optString = com.ss.android.downloadlib.addownload.k.j().optString("hook_vivo_arg", "com.android.settings");
                        if ("null".equals(optString)) {
                            return;
                        }
                        objArr[1] = optString;
                        return;
                    }
                    if (com.ss.android.socialbase.appdownloader.f.e.e()) {
                        String optString2 = com.ss.android.downloadlib.addownload.k.j().optString("hook_kllk_arg1", "com." + com.ss.android.socialbase.downloader.constants.e.c + ".market");
                        if (!"null".equals(optString2)) {
                            objArr[1] = optString2;
                        }
                        String optString3 = com.ss.android.downloadlib.addownload.k.j().optString("hook_kllk_arg2", "com.android.browser");
                        String optString4 = com.ss.android.downloadlib.addownload.k.j().optString("hook_kllk_arg3", "m.store." + com.ss.android.socialbase.downloader.constants.e.c + "mobile.com");
                        StringBuilder sb = new StringBuilder();
                        sb.append(com.ss.android.socialbase.downloader.constants.e.c);
                        sb.append("_extra_pkg_name");
                        intent.putExtra(sb.toString(), optString3);
                        intent.putExtra("refererHost", optString4);
                        if (com.ss.android.downloadlib.addownload.k.j().optInt("hook_kllk_arg4", 0) == 1) {
                            Intent intent2 = new Intent();
                            intent2.putExtra(com.ss.android.socialbase.downloader.constants.e.c + "_extra_pkg_name", optString3);
                            intent2.putExtra("refererHost", optString4);
                            intent.putExtra("android.intent.extra.INTENT", intent2);
                            return;
                        }
                        return;
                    }
                    if (com.ss.android.socialbase.appdownloader.f.e.a()) {
                        String optString5 = com.ss.android.downloadlib.addownload.k.j().optString("hook_huawei_arg1", x.Y);
                        if (!"null".equals(optString5)) {
                            objArr[1] = optString5;
                        }
                        intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.k.j().optString("hook_huawei_arg2", x.Y));
                    }
                }
            }
        }
    }
}

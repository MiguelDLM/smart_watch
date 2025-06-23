package com.qq.e.comm.managers.plugin;

import com.tencent.bugly.crashreport.CrashReport;
import java.lang.reflect.Method;

/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f19447a = null;
    private static boolean b = false;

    public static void a(Throwable th, String str) {
        try {
            Exception exc = new Exception("插件错误：" + str, th);
            if (!b) {
                if (f19447a == null) {
                    Method declaredMethod = CrashReport.class.getDeclaredMethod("postCatchedException", Throwable.class);
                    f19447a = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                f19447a.invoke(null, exc);
            }
        } catch (Throwable unused) {
            b = true;
        }
    }
}

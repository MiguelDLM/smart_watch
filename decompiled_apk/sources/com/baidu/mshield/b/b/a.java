package com.baidu.mshield.b.b;

import android.content.Context;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.utility.c;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class a {
    public static synchronized String a(Context context) {
        String str;
        synchronized (a.class) {
            try {
                Method declaredMethod = F.class.getDeclaredMethod("getInstance", null);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, null);
                Method declaredMethod2 = F.class.getDeclaredMethod("gzd", Context.class);
                declaredMethod2.setAccessible(true);
                str = (String) declaredMethod2.invoke(invoke, context);
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
                return "";
            }
        }
        return str;
    }

    public static String b(Context context) {
        try {
            Method declaredMethod = c.class.getDeclaredMethod("loadSettingDeviceId", Context.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, context);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static String c(Context context) {
        try {
            Method declaredMethod = c.class.getDeclaredMethod("loadExternalDeviceId", Context.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, context);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }
}

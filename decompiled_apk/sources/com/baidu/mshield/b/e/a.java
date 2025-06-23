package com.baidu.mshield.b.e;

import android.content.Context;
import java.io.File;

/* loaded from: classes7.dex */
public class a {
    public static String a(Context context) {
        return a(context, false);
    }

    public static String b(Context context) {
        return b(context, false);
    }

    public static boolean c(Context context) {
        boolean e = com.baidu.sec.privacy.c.a.a(context).e();
        com.baidu.mshield.b.c.a.a("---privacy isCanRequestNetBackground---" + e + " time: " + System.currentTimeMillis());
        return e;
    }

    public static Class d(Context context) {
        try {
            com.baidu.mshield.b.c.a.a("---privacy getServiceManagerClass---" + System.currentTimeMillis());
            return com.baidu.sec.privacy.c.a.a(context).a(context.getClassLoader(), "android.os.ServiceManager");
        } catch (ClassNotFoundException e) {
            com.baidu.mshield.b.c.a.a(e);
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        com.baidu.mshield.b.c.a.a("---privacy getCuidV3ByIPC---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.c.a.a(context).a(z);
    }

    public static String b(Context context, boolean z) {
        com.baidu.mshield.b.c.a.a("---privacy getCuidV3ByFile---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.c.a.a(context).b(z);
    }

    public static int c(Context context, String str) {
        com.baidu.mshield.b.c.a.a("---privacy getIntFromSystemSetting---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.c.a.a(context).b(str, false);
    }

    public static File a(Context context, String str) {
        com.baidu.mshield.b.c.a.a("---privacy getFile---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.c.a.a(context).a(str);
    }

    public static int b(Context context, String str) {
        com.baidu.mshield.b.c.a.a("---privacy getIntFromSystemSecure---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.c.a.a(context).c(str, false);
    }

    public static String d(Context context, String str) {
        return a(context, str, false);
    }

    public static String a(Context context, String str, boolean z) {
        com.baidu.mshield.b.c.a.a("---privacy getStringFromSystemSetting---" + System.currentTimeMillis());
        return com.baidu.sec.privacy.c.a.a(context).a(str, true, z);
    }

    public static void a(Context context, String str, String str2) {
        com.baidu.mshield.b.c.a.a("---privacy setStringFromSystemSetting---" + System.currentTimeMillis());
        com.baidu.sec.privacy.c.a.a(context).a(str, str2);
    }
}

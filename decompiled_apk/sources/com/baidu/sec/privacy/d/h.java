package com.baidu.sec.privacy.d;

/* loaded from: classes8.dex */
public class h {
    public static String a(String str, String str2) {
        try {
            Class a2 = com.baidu.sec.privacy.a.b.a(com.baidu.sec.privacy.a.b.b()).a(h.class.getClassLoader(), "android.os.SystemProperties");
            if (a2 == null) {
                return str2;
            }
            return (String) a2.getMethod("get", String.class).invoke(a2, str);
        } catch (Throwable th) {
            c.a(th);
            return str2;
        }
    }
}

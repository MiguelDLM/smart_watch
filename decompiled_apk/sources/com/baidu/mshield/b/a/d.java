package com.baidu.mshield.b.a;

import android.content.Context;
import android.net.NetworkInfo;

/* loaded from: classes7.dex */
public class d {
    public static boolean a(Context context) {
        NetworkInfo a2;
        try {
            if (!com.baidu.sec.privacy.d.f.a(context, new String[]{com.kuaishou.weapon.p0.g.b}) || (a2 = com.baidu.mshield.b.e.b.a(context)) == null) {
                return false;
            }
            if (1 != a2.getType()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
        return false;
    }

    public static boolean b(Context context) {
        try {
            if (!com.baidu.sec.privacy.d.f.a(context, new String[]{com.kuaishou.weapon.p0.g.b})) {
                return true;
            }
            NetworkInfo a2 = com.baidu.mshield.b.e.b.a(context);
            if (a2 == null) {
                return false;
            }
            return a2.isConnected();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return false;
        }
    }

    public static String c(Context context) {
        try {
            return com.baidu.mshield.b.e.c.a(context, context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }
}

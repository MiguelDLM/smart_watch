package com.baidu.navisdk;

import android.content.Context;
import com.baidu.navisdk.util.common.e0;

/* loaded from: classes7.dex */
public class o {
    public static void a(m mVar, String str) {
        if (a() == null) {
            return;
        }
        e0.a(a()).b("dynamic_data" + mVar, str);
    }

    public static String a(m mVar) {
        if (a() == null) {
            return null;
        }
        return e0.a(a()).a("dynamic_data" + mVar, (String) null);
    }

    private static Context a() {
        return com.baidu.navisdk.framework.a.c().a();
    }
}

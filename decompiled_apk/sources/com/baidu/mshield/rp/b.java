package com.baidu.mshield.rp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.utility.c;

/* loaded from: classes7.dex */
public class b {
    public static String a(Context context) {
        String str = "";
        try {
            com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(context);
            String o = a2.o();
            try {
                if (!TextUtils.isEmpty(o)) {
                    a2.e("");
                }
                return c.f(context);
            } catch (Throwable th) {
                th = th;
                str = o;
                com.baidu.mshield.utility.a.a(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(Context context) {
        String str = "";
        try {
            com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(context);
            String p = a2.p();
            try {
                if (!TextUtils.isEmpty(p)) {
                    a2.f("");
                }
                return c.g(context);
            } catch (Throwable th) {
                th = th;
                str = p;
                com.baidu.mshield.utility.a.a(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(Context context) {
        String str = "";
        try {
            com.baidu.mshield.sharedpreferences.a a2 = com.baidu.mshield.sharedpreferences.a.a(context);
            String q = a2.q();
            try {
                if (!TextUtils.isEmpty(q)) {
                    a2.g("");
                }
                return c.j(context);
            } catch (Throwable th) {
                th = th;
                str = q;
                com.baidu.mshield.utility.a.a(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

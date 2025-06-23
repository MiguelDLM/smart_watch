package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public final class c {
    private static b b = null;
    private static String c = "";
    private static volatile String d = "";

    /* renamed from: a, reason: collision with root package name */
    private final Context f5559a;

    private c(Context context) {
        this.f5559a = context.getApplicationContext();
    }

    public static String a() {
        if (TextUtils.isEmpty(c)) {
            c = "0newiqr3mini0";
        }
        return c;
    }

    private b b() {
        b b2 = b.b(this.f5559a);
        boolean z = b2 == null;
        if (b2 == null) {
            a b3 = a.b(this.f5559a);
            if (b3 == null) {
                b2 = b.a(this.f5559a, a());
            } else {
                b3.c();
                b2 = b.a(b3);
            }
        }
        if (z) {
            b2.a(this.f5559a);
        }
        a.a(this.f5559a);
        return b2;
    }

    public static String a(Context context) {
        return b(context).a();
    }

    private static b b(Context context) {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new c(context).b();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static void a(String str) {
        if (!d.a(str, 5)) {
            throw new IllegalArgumentException("expect src only letter or number , less than 6");
        }
        synchronized (b.class) {
            if (TextUtils.isEmpty(d)) {
                d = str;
                int length = 5 - str.length();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("0newiqr3");
                stringBuffer.append(str);
                for (int i = 0; i < length; i++) {
                    stringBuffer.append("0");
                }
                c = stringBuffer.toString().trim();
            }
        }
    }
}

package com.baidu.xclient.gdid.e;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes8.dex */
public class a {
    public static String a(Context context) {
        try {
            String b = com.baidu.mshield.b.b.a.b(context);
            return TextUtils.isEmpty(b) ? com.baidu.mshield.b.b.a.c(context) : b;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }
}

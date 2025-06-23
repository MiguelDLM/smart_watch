package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/* loaded from: classes11.dex */
public class bx {

    /* renamed from: a, reason: collision with root package name */
    private static String f18340a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);
    private static String b = c.b(b, 2);
    private static String b = c.b(b, 2);

    public static String a(Context context) {
        String str = TextUtils.isEmpty(d(context)) ? "0" : "1";
        String c = c(context);
        if (TextUtils.isEmpty(c)) {
            return "0" + str;
        }
        String str2 = "1" + str;
        b(context, c);
        return str2;
    }

    public static String b(Context context) {
        String c = c(context);
        String d = d(context);
        if (!TextUtils.isEmpty(c) && TextUtils.equals(c, d)) {
            return c;
        }
        if (!TextUtils.isEmpty(c)) {
            b(context, c);
            return c;
        }
        if (!TextUtils.isEmpty(d)) {
            a(context, d);
            return d;
        }
        return "";
    }

    public static String c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f18340a);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return df.a(context).e();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        boolean canWrite;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                canWrite = Settings.System.canWrite(context.getApplicationContext());
                if (!canWrite) {
                    return;
                }
            }
            Settings.System.putString(context.getContentResolver(), f18340a, str);
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str) {
        df.a(context).d(str);
    }
}

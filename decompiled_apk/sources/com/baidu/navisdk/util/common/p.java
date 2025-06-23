package com.baidu.navisdk.util.common;

import com.sma.smartv3.util.xoIox;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes8.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f9247a = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    public static final SimpleDateFormat b = new SimpleDateFormat(xoIox.f24709oo0xXOI0I);
    private static final SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private static final SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss_SSS");

    public static String a(SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

    public static String b() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static String c() {
        return d.format(new Date());
    }

    public static String a() {
        return c.format(new Date());
    }

    public static String a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(7);
        if (i < 1 || i > 7) {
            return null;
        }
        return f9247a[i - 1];
    }
}

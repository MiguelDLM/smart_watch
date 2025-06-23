package com.baidu.navisdk.module.future.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes7.dex */
public class a {
    public static String a(Date date) {
        if (date == null) {
            return "empty";
        }
        if (com.baidu.navisdk.module.future.a.b) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            } catch (Exception e) {
                return "error:" + e;
            }
        }
        return String.valueOf(date.getTime());
    }

    public static int b(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(12);
    }

    public static int a(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        int i = calendar2.get(1);
        int i2 = calendar2.get(6);
        int i3 = calendar.get(1);
        int i4 = calendar.get(6);
        if (i - i3 == 1) {
            return (((i3 % 400 != 0 && (i3 % 4 != 0 || i3 % 100 == 0)) ? 365 : 366) - i4) + i2;
        }
        return i2 - i4;
    }
}

package com.baidu.navisdk.lightnavi.utils;

import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.p;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/* loaded from: classes7.dex */
public class a {
    public static String a(int i) {
        String format;
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        Date date2 = new Date(currentTimeMillis + (i * 1000));
        String format2 = new SimpleDateFormat("HH:mm").format(date2);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTime(date2);
        if (gregorianCalendar.get(5) == gregorianCalendar2.get(5)) {
            format = String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time), format2);
        } else {
            int a2 = a(date, date2);
            if (a2 == 1) {
                format = String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time_at_tomorrow), format2);
            } else if (a2 == 2) {
                format = String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time_at_after_tomorrow), format2);
            } else if (a2 > 2) {
                format = String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time_at_week_day), p.a(date2), format2);
            } else {
                format = String.format(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time), format2);
            }
        }
        return com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_arrive_time_prefix) + format;
    }

    private static int a(Date date, Date date2) {
        long time = date2.getTime() - date.getTime();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            time = simpleDateFormat.parse(simpleDateFormat.format(date2)).getTime() - simpleDateFormat.parse(simpleDateFormat.format(date)).getTime();
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
        }
        return (int) (time / 86400000);
    }
}

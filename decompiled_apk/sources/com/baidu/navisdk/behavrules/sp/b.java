package com.baidu.navisdk.behavrules.sp;

import android.content.Context;
import java.util.Calendar;

/* loaded from: classes7.dex */
public class b {
    private static b g;

    /* renamed from: a, reason: collision with root package name */
    private a f6658a;
    private a b;
    private a c;
    private a d;
    private a e;
    private a f;

    private b(Context context) {
        this.f6658a = new a(context, "navi_xd_scene_day");
        this.b = new a(context, "navi_xd_scene_week");
        this.c = new a(context, "navi_xd_scene_month");
        this.e = new a(context, "navi_xd_scene_navi");
        this.d = new a(context, "navi_xd_scene_life");
        this.f = new a(context, "navi_xd_scene_time");
    }

    public static b a(Context context) {
        if (g == null) {
            g = new b(context);
        }
        return g;
    }

    public void b(String str) {
        this.d.b(str, h(str) + 1);
    }

    public void c(String str) {
        this.c.b(str, i(str) + 1);
    }

    public void d(String str) {
        this.e.b(str, j(str) + 1);
    }

    public void e(String str) {
        a(str);
        f(str);
        c(str);
        d(str);
        b(str);
    }

    public void f(String str) {
        this.b.b(str, l(str) + 1);
    }

    public int g(String str) {
        long a2 = this.f6658a.a("day_record_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis / 86400000 != a2 / 86400000) {
            this.f6658a.a();
        }
        this.f6658a.b("day_record_time", currentTimeMillis);
        return this.f6658a.a(str, 0);
    }

    public int h(String str) {
        return this.d.a(str, 0);
    }

    public int i(String str) {
        Calendar calendar = Calendar.getInstance();
        String str2 = calendar.get(1) + "_" + calendar.get(2);
        if (!str2.equals(this.c.a("year_month_record_time", "year_month_record_time"))) {
            this.c.a();
        }
        this.c.b("year_month_record_time", str2);
        return this.c.a(str, 0);
    }

    public int j(String str) {
        return this.e.a(str, 0);
    }

    public long k(String str) {
        return this.f.a("recordTime" + str, 0L);
    }

    public int l(String str) {
        Calendar calendar = Calendar.getInstance();
        String str2 = calendar.get(1) + "_" + calendar.get(3);
        if (!str2.equals(this.b.a("year_week_record_time", "year_week_record_time"))) {
            this.b.a();
        }
        this.b.b("year_week_record_time", str2);
        return this.b.a(str, 0);
    }

    public void m(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f.b("recordTime" + str, currentTimeMillis);
    }

    public void n(String str) {
        m(str);
        a(str);
        f(str);
        c(str);
        d(str);
        b(str);
    }

    public void b() {
        this.e.a();
    }

    public void a(String str) {
        this.f6658a.b(str, g(str) + 1);
    }

    public void a() {
        this.f6658a.a();
        this.b.a();
        this.c.a();
        this.e.a();
        this.d.a();
        this.f.a();
    }
}

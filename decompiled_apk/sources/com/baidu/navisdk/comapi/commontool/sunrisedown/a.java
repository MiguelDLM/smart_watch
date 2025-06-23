package com.baidu.navisdk.comapi.commontool.sunrisedown;

import XIXIX.OOXIXo;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes7.dex */
public class a {
    private static a d;

    /* renamed from: a, reason: collision with root package name */
    private double f6707a;
    private double b;
    private double c;

    /* loaded from: classes7.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f6708a;

        private b(a aVar) {
        }

        public int a() {
            return this.f6708a;
        }
    }

    /* loaded from: classes7.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private b f6709a;
        private b b;
        private b c;
        private b d;

        public c(a aVar) {
            this.f6709a = new b();
            this.b = new b();
            this.c = new b();
            this.d = new b();
        }

        public int a() {
            return this.c.a();
        }

        public int b() {
            return this.d.a();
        }

        public int c() {
            return this.f6709a.a();
        }

        public int d() {
            return this.b.a();
        }
    }

    private a() {
    }

    private double a(double d2) {
        double d3 = ((d2 / 6.283185307179586d) - ((long) r6)) * 6.283185307179586d;
        return d3 < OOXIXo.f3760XO ? d3 + 6.283185307179586d : d3;
    }

    private double b(double d2, double d3) {
        double tan = Math.tan(d3 + (d2 < OOXIXo.f3760XO ? -0.014515321612419507d : 0.014515321612419507d)) * Math.tan(d2 * 0.017453292519943295d);
        if (tan > 0.99999d) {
            tan = 1.0d;
        }
        return Math.asin(tan) + 1.5707963267948966d;
    }

    public static a a() {
        if (d == null) {
            d = new a();
        }
        return d;
    }

    private double b(double d2) {
        this.f6707a = a((0.017202792393721557d * d2) + 4.894967873435816d);
        double a2 = a((d2 * 0.017201970343643867d) + 6.240040768070287d);
        this.b = a2;
        return a(this.f6707a + (Math.sin(a2) * 0.03342305517569141d) + (Math.sin(this.b * 2.0d) * 3.4906585039886593E-4d));
    }

    private double a(int i, int i2, int i3, float f) {
        return (((((((((i2 + 9) / 12) + i) * (-7)) / 4) + ((i2 * 275) / 9)) + i3) + (i * 367)) - 730531.5d) + (f / 24.0d);
    }

    private void a(double d2, int i, b bVar, b bVar2) {
        int i2 = (int) d2;
        bVar.f6708a = i2 + i;
        bVar2.f6708a = (int) ((d2 - i2) * 60.0d);
    }

    private int b() {
        TimeZone timeZone = TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone timeZone2 = TimeZone.getDefault();
        if (timeZone != null && timeZone2 != null) {
            Calendar calendar = Calendar.getInstance(timeZone);
            Calendar calendar2 = Calendar.getInstance(timeZone2);
            if (calendar != null && calendar2 != null) {
                return ((calendar2.get(15) + calendar2.get(16)) - calendar.get(15)) / 3600000;
            }
        }
        return 0;
    }

    public c a(double d2, double d3) {
        c cVar = new c(this);
        Calendar calendar = Calendar.getInstance();
        double d4 = d3 / 15.0d;
        double d5 = (int) (d4 + 1.0d);
        int i = 8 - ((int) d5);
        double a2 = a(calendar.get(1), calendar.get(2) + 1, calendar.get(5), 12);
        double b2 = b(a2);
        double d6 = 0.4090877233749509d - (a2 * 6.981317007977318E-9d);
        double atan2 = Math.atan2(Math.cos(d6) * Math.sin(b2), Math.cos(b2));
        double asin = Math.asin(Math.sin(d6) * Math.sin(b2));
        double d7 = this.f6707a;
        double d8 = d7 - atan2;
        if (d7 < 3.141592653589793d) {
            d8 += 6.283185307179586d;
        }
        double d9 = (1.0d - (d8 / 6.283185307179586d)) * 1440.0d;
        double b3 = b(d2, asin);
        double d10 = (57.29577951308232d * b3) / 7.5d;
        this.c = d10;
        if (d10 < 1.0E-4d) {
            this.c = OOXIXo.f3760XO;
        }
        double d11 = (b3 * 12.0d) / 3.141592653589793d;
        double d12 = d9 / 60.0d;
        double d13 = (((12.0d - d11) + d5) - d4) + d12;
        double d14 = (((d11 + 12.0d) + d5) - d4) + d12;
        if (d13 > 24.0d) {
            d13 -= 24.0d;
        }
        if (d14 > 24.0d) {
            d14 -= 24.0d;
        }
        a(d13, i, cVar.f6709a, cVar.b);
        a(d14, i, cVar.c, cVar.d);
        return cVar;
    }

    public void a(c cVar) {
        if (cVar == null || cVar.c == null || cVar.f6709a == null) {
            return;
        }
        int b2 = b();
        cVar.c.f6708a += b2;
        cVar.f6709a.f6708a += b2;
    }
}

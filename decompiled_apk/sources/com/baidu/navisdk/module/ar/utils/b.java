package com.baidu.navisdk.module.ar.utils;

import XIXIX.OOXIXo;
import java.util.Calendar;

/* loaded from: classes7.dex */
public class b {
    private static b d;

    /* renamed from: a, reason: collision with root package name */
    private double f7006a;
    private double b;
    private double c;

    /* renamed from: com.baidu.navisdk.module.ar.utils.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0219b {

        /* renamed from: a, reason: collision with root package name */
        int f7007a;

        private C0219b(b bVar) {
        }

        public int a() {
            return this.f7007a;
        }
    }

    /* loaded from: classes7.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private C0219b f7008a;
        private C0219b b;
        private C0219b c;
        private C0219b d;

        public c(b bVar) {
            this.f7008a = new C0219b();
            this.b = new C0219b();
            this.c = new C0219b();
            this.d = new C0219b();
        }

        public int a() {
            return this.c.a();
        }

        public int b() {
            return this.d.a();
        }

        public int c() {
            return this.f7008a.a();
        }

        public int d() {
            return this.b.a();
        }
    }

    private b() {
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

    public static b a() {
        if (d == null) {
            d = new b();
        }
        return d;
    }

    private double b(double d2) {
        this.f7006a = a((0.017202792393721557d * d2) + 4.894967873435816d);
        double a2 = a((d2 * 0.017201970343643867d) + 6.240040768070287d);
        this.b = a2;
        return a(this.f7006a + (Math.sin(a2) * 0.03342305517569141d) + (Math.sin(this.b * 2.0d) * 3.4906585039886593E-4d));
    }

    private double a(int i, int i2, int i3, float f) {
        return (((((((((i2 + 9) / 12) + i) * (-7)) / 4) + ((i2 * 275) / 9)) + i3) + (i * 367)) - 730531.5d) + (f / 24.0d);
    }

    private void a(double d2, int i, C0219b c0219b, C0219b c0219b2) {
        int i2 = (int) d2;
        c0219b.f7007a = i2 + i;
        c0219b2.f7007a = (int) ((d2 - i2) * 60.0d);
    }

    public c a(double d2, double d3) {
        c cVar = new c(this);
        Calendar calendar = Calendar.getInstance();
        double d4 = d3 / 15.0d;
        double d5 = (int) (d4 + 1.0d);
        int i = 8 - ((int) d5);
        double a2 = a(calendar.get(1), calendar.get(2) + 1, calendar.get(5), 12);
        double b = b(a2);
        double d6 = 0.4090877233749509d - (a2 * 6.981317007977318E-9d);
        double atan2 = Math.atan2(Math.cos(d6) * Math.sin(b), Math.cos(b));
        double asin = Math.asin(Math.sin(d6) * Math.sin(b));
        double d7 = this.f7006a;
        double d8 = d7 - atan2;
        if (d7 < 3.141592653589793d) {
            d8 += 6.283185307179586d;
        }
        double d9 = (1.0d - (d8 / 6.283185307179586d)) * 1440.0d;
        double b2 = b(d2, asin);
        double d10 = (57.29577951308232d * b2) / 7.5d;
        this.c = d10;
        if (d10 < 1.0E-4d) {
            this.c = OOXIXo.f3760XO;
        }
        double d11 = (b2 * 12.0d) / 3.141592653589793d;
        double d12 = d9 / 60.0d;
        double d13 = (((12.0d - d11) + d5) - d4) + d12;
        double d14 = (((d11 + 12.0d) + d5) - d4) + d12;
        if (d13 > 24.0d) {
            d13 -= 24.0d;
        }
        if (d14 > 24.0d) {
            d14 -= 24.0d;
        }
        a(d13, i, cVar.f7008a, cVar.b);
        a(d14, i, cVar.c, cVar.d);
        return cVar;
    }
}

package com.baidu.platform.comapi.map.b;

import XIXIX.OOXIXo;
import android.view.MotionEvent;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0527a f9640a = new C0527a(new b(OOXIXo.f3760XO, OOXIXo.f3760XO), new b(1.0d, OOXIXo.f3760XO));
    public static final C0527a b = new C0527a(new b(OOXIXo.f3760XO, OOXIXo.f3760XO), new b(OOXIXo.f3760XO, 1.0d));
    public static final C0527a c = new C0527a(new b(OOXIXo.f3760XO, 1.0d), new b(OOXIXo.f3760XO, OOXIXo.f3760XO));

    /* renamed from: com.baidu.platform.comapi.map.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0527a {

        /* renamed from: a, reason: collision with root package name */
        public b f9642a;
        public b b;

        public C0527a(b bVar, b bVar2) {
            this.f9642a = bVar;
            this.b = bVar2;
        }

        public b a() {
            b bVar = this.f9642a;
            double d = bVar.f9644a;
            b bVar2 = this.b;
            return new b((d + bVar2.f9644a) / 2.0d, (bVar.b + bVar2.b) / 2.0d);
        }

        public double b() {
            b bVar = this.f9642a;
            double d = bVar.f9644a;
            b bVar2 = this.b;
            double d2 = bVar2.f9644a;
            double d3 = bVar.b;
            double d4 = bVar2.b;
            return Math.sqrt(((d - d2) * (d - d2)) + ((d3 - d4) * (d3 - d4)));
        }

        public d c() {
            b bVar = this.b;
            double d = bVar.f9644a;
            b bVar2 = this.f9642a;
            return new d(d - bVar2.f9644a, bVar.b - bVar2.b);
        }

        public String toString() {
            return getClass().getSimpleName() + "  a : " + this.f9642a.toString() + " b : " + this.b.toString();
        }

        public static C0527a a(MotionEvent motionEvent) {
            return new C0527a(new b(motionEvent.getX(0), motionEvent.getY(0)), new b(motionEvent.getX(1), motionEvent.getY(1)));
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public double f9644a;
        public double b;

        public b(double d, double d2) {
            this.f9644a = d;
            this.b = d2;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f9644a + " y : " + this.b;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final double f9645a;
        public final double b;
        public final d c;

        public c(C0527a c0527a, C0527a c0527a2) {
            this.c = new d(c0527a.a(), c0527a2.a());
            this.b = c0527a2.b() / c0527a.b();
            this.f9645a = d.a(c0527a.c(), c0527a2.c());
        }

        public String toString() {
            return getClass().getSimpleName() + " rotate : " + this.f9645a + " scale : " + (this.b * 100.0d) + " move : " + this.c.toString();
        }
    }

    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public double f9646a;
        public double b;

        public d(double d, double d2) {
            this.f9646a = d;
            this.b = d2;
        }

        public static double a(d dVar, d dVar2) {
            double atan2 = Math.atan2(dVar.b, dVar.f9646a) - Math.atan2(dVar2.b, dVar2.f9646a);
            if (atan2 > 3.141592653589793d) {
                atan2 -= 6.283185307179586d;
            } else if (atan2 < -3.141592653589793d) {
                atan2 += 6.283185307179586d;
            }
            return (atan2 * 180.0d) / 3.141592653589793d;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f9646a + " y : " + this.b;
        }

        public d(b bVar, b bVar2) {
            this.f9646a = bVar2.f9644a - bVar.f9644a;
            this.b = bVar2.b - bVar.b;
        }
    }
}

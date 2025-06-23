package com.baidu.nplatform.comapi.map.gesture;

import XIXIX.OOXIXo;
import android.view.MotionEvent;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0524a f9500a = new C0524a(new b(OOXIXo.f3760XO, OOXIXo.f3760XO), new b(1.0d, OOXIXo.f3760XO));
    public static final C0524a b = new C0524a(new b(OOXIXo.f3760XO, OOXIXo.f3760XO), new b(OOXIXo.f3760XO, 1.0d));

    /* renamed from: com.baidu.nplatform.comapi.map.gesture.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0524a {

        /* renamed from: a, reason: collision with root package name */
        public b f9501a;
        public b b;

        public C0524a(b bVar, b bVar2) {
            this.f9501a = bVar;
            this.b = bVar2;
        }

        public b a() {
            b bVar = this.f9501a;
            double d = bVar.f9502a;
            b bVar2 = this.b;
            return new b((d + bVar2.f9502a) / 2.0d, (bVar.b + bVar2.b) / 2.0d);
        }

        public double b() {
            b bVar = this.f9501a;
            double d = bVar.f9502a;
            b bVar2 = this.b;
            double d2 = d - bVar2.f9502a;
            double d3 = bVar.b - bVar2.b;
            return Math.sqrt((d2 * d2) + (d3 * d3));
        }

        public d c() {
            b bVar = this.b;
            double d = bVar.f9502a;
            b bVar2 = this.f9501a;
            return new d(d - bVar2.f9502a, bVar.b - bVar2.b);
        }

        public String toString() {
            return C0524a.class.getSimpleName() + "  a : " + this.f9501a.toString() + " b : " + this.b.toString();
        }

        public static C0524a a(MotionEvent motionEvent) {
            return new C0524a(new b(motionEvent.getX(0), motionEvent.getY(0)), new b(motionEvent.getX(1), motionEvent.getY(1)));
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public double f9502a;
        public double b;

        public b(double d, double d2) {
            this.f9502a = d;
            this.b = d2;
        }

        public String toString() {
            return b.class.getSimpleName() + " x : " + this.f9502a + " y : " + this.b;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final double f9503a;
        public final double b;
        public final d c;

        public c(C0524a c0524a, C0524a c0524a2) {
            this.c = new d(c0524a.a(), c0524a2.a());
            double b = c0524a.b();
            if (b <= 1.0E-7d && b >= -1.0E-7d) {
                this.b = OOXIXo.f3760XO;
            } else {
                this.b = c0524a2.b() / b;
            }
            this.f9503a = d.a(c0524a.c(), c0524a2.c());
        }

        public String toString() {
            return c.class.getSimpleName() + " rotate : " + this.f9503a + " scale : " + (this.b * 100.0d) + " move : " + this.c.toString();
        }
    }

    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public double f9504a;
        public double b;

        public d(double d, double d2) {
            this.f9504a = d;
            this.b = d2;
        }

        public static double a(d dVar, d dVar2) {
            return ((Math.atan2(dVar.b, dVar.f9504a) - Math.atan2(dVar2.b, dVar2.f9504a)) * 180.0d) / 3.141592653589793d;
        }

        public String toString() {
            return d.class.getSimpleName() + " x : " + this.f9504a + " y : " + this.b;
        }

        public d(b bVar, b bVar2) {
            this.f9504a = bVar2.f9502a - bVar.f9502a;
            this.b = bVar2.b - bVar.b;
        }
    }
}

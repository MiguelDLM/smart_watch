package com.baidu.nplatform.comapi.basestruct;

import XIXIX.OOXIXo;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public float f9474a = -1.0f;
    public float b = -1.0f;
    public int c = -1;
    public double d = -1.0d;
    public double e = -1.0d;
    public double f = OOXIXo.f3760XO;
    public long i = 0;
    public long j = 0;
    public C0522b g = new C0522b();
    public a h = new a();
    public boolean k = false;
    public String l = "";
    public float m = 0.0f;
    public float n = 0.0f;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f9475a = 0;
        public long b = 0;
        public long c = 0;
        public long d = 0;
        public c e = new c(OOXIXo.f3760XO, OOXIXo.f3760XO);
        public c f = new c(OOXIXo.f3760XO, OOXIXo.f3760XO);
        public c g = new c(OOXIXo.f3760XO, OOXIXo.f3760XO);
        public c h = new c(OOXIXo.f3760XO, OOXIXo.f3760XO);

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.d == aVar.d && this.f9475a == aVar.f9475a && this.b == aVar.b && this.c == aVar.c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j = this.d;
            long j2 = this.f9475a;
            int i = (((((int) (j ^ (j >>> 32))) + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.b;
            int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.c;
            return i2 + ((int) (j4 ^ (j4 >>> 32)));
        }
    }

    /* renamed from: com.baidu.nplatform.comapi.basestruct.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0522b {

        /* renamed from: a, reason: collision with root package name */
        public int f9476a = 0;
        public int b = 0;
        public int c = 0;
        public int d = 0;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof C0522b)) {
                return false;
            }
            C0522b c0522b = (C0522b) obj;
            if (this.d == c0522b.d && this.f9476a == c0522b.f9476a && this.b == c0522b.b && this.c == c0522b.c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.d + 31) * 31) + this.f9476a) * 31) + this.b) * 31) + this.c;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        b bVar = (b) obj;
        if (this.d != bVar.d || this.e != bVar.e || this.k != bVar.k) {
            return false;
        }
        a aVar = this.h;
        if (aVar == null) {
            if (bVar.h != null) {
                return false;
            }
        } else if (!aVar.equals(bVar.h)) {
            return false;
        }
        if (Float.floatToIntBits(this.f9474a) != Float.floatToIntBits(bVar.f9474a) || this.c != bVar.c || this.b != bVar.b || this.j != bVar.j || this.i != bVar.i || this.m != bVar.m || this.n != bVar.n) {
            return false;
        }
        C0522b c0522b = this.g;
        if (c0522b == null) {
            if (bVar.g != null) {
                return false;
            }
        } else if (!c0522b.equals(bVar.g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        double d = (((((((this.d + 31.0d) * 31.0d) + this.e) * 31.0d) + this.f) * 31.0d) + (this.k ? 1.0d : 0.0d)) * 31.0d;
        a aVar = this.h;
        int i = 0;
        if (aVar == null) {
            hashCode = 0;
        } else {
            hashCode = aVar.hashCode();
        }
        double floatToIntBits = (((((((d + hashCode) * 31.0d) + Float.floatToIntBits(this.f9474a)) * 31.0d) + this.c) * 31.0d) + Float.floatToIntBits(this.b)) * 31.0d;
        C0522b c0522b = this.g;
        if (c0522b != null) {
            i = c0522b.hashCode();
        }
        return (int) (floatToIntBits + i);
    }

    public String toString() {
        return "MapStatus{level=" + this.f9474a + ", rotation=" + this.b + ", overlooking=" + this.c + ", centerPtX=" + this.d + ", centerPtY=" + this.e + ", centerPtZ=" + this.f + ", winRound=" + this.g + ", geoRound=" + this.h + ", xOffset=" + this.i + ", yOffset=" + this.j + ", screenXOffset=" + this.m + ", screenYOffset=" + this.n + ", bfpp=" + this.k + ", panoId='" + this.l + '}';
    }
}

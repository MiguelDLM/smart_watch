package com.baidu.nplatform.comapi.basestruct;

import XIXIX.OOXIXo;
import java.io.Serializable;

/* loaded from: classes8.dex */
public class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private double f9477a;
    private double b;

    public c() {
    }

    public void a(int i) {
        this.f9477a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return (int) this.f9477a;
    }

    public int d() {
        return (int) this.b;
    }

    public boolean e() {
        double d = this.f9477a;
        if ((d == OOXIXo.f3760XO && this.b == OOXIXo.f3760XO) || (d == -2.147483648E9d && this.b == -2.147483648E9d)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f9477a == cVar.f9477a && this.b == cVar.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((c() + 31) * 31) + d();
    }

    public String toString() {
        return "Point [x=" + this.f9477a + ", y=" + this.b + "]";
    }

    public c(double d, double d2) {
        this.f9477a = d;
        this.b = d2;
    }

    public double a() {
        return this.f9477a;
    }

    public double b() {
        return this.b;
    }

    public void a(double d) {
        this.f9477a = d;
    }

    public void b(double d) {
        this.b = d;
    }

    public void a(double d, double d2) {
        a(d);
        b(d2);
    }

    public c(c cVar) {
        if (cVar != null) {
            this.f9477a = cVar.a();
            this.b = cVar.b();
        }
    }

    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return Math.abs(this.f9477a - cVar.a()) < 3.0d && Math.abs(this.b - cVar.b()) < 3.0d;
    }
}

package com.baidu.mapapi.map;

import android.graphics.Point;

/* loaded from: classes7.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    public final double f5906a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public o(double d, double d2, double d3, double d4) {
        this.f5906a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2) {
        return this.f5906a <= d && d <= this.c && this.b <= d2 && d2 <= this.d;
    }

    public boolean b(o oVar) {
        if (oVar.f5906a >= this.f5906a && oVar.c <= this.c && oVar.b >= this.b && oVar.d <= this.d) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f5906a);
        sb.append(" minY: " + this.b);
        sb.append(" maxX: " + this.c);
        sb.append(" maxY: " + this.d);
        sb.append(" midX: " + this.e);
        sb.append(" midY: " + this.f);
        return sb.toString();
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.f5906a < d2 && d3 < this.d && this.b < d4;
    }

    public boolean a(o oVar) {
        return a(oVar.f5906a, oVar.c, oVar.b, oVar.d);
    }
}

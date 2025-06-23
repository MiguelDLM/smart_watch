package com.baidu.navisdk.preset.model;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.framework.message.bean.c {
    public long b;
    public double c;
    public double d;
    public double e;
    public double f;
    public float g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    public a(long j, double d, double d2, double d3, double d4, float f, int i, int i2, boolean z, boolean z2, boolean z3) {
        super(-1);
        this.b = j;
        this.c = d;
        this.d = d2;
        this.e = d3;
        this.f = d4;
        this.g = f;
        this.h = i;
        this.i = i2;
        this.j = z;
        this.k = z2;
        this.l = z3;
    }

    public String toString() {
        return "timetag:" + this.b + " lots:" + this.c + " lats:" + this.d + " lotm:" + this.e + " latm:" + this.f + " mDh:" + this.g + " roadlevel:" + this.h + " oneway:" + this.i + " isIntersection:" + this.j + " rerouted:" + this.k + " reliable:" + this.l;
    }
}

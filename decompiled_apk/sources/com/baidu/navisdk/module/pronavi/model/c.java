package com.baidu.navisdk.module.pronavi.model;

import android.text.TextUtils;
import androidx.annotation.DrawableRes;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f7463a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public String j;
    public int k;
    public int l;
    public int m;
    public boolean n = false;
    public String o;

    @DrawableRes
    public int p;

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f7463a = cVar.f7463a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        this.i = cVar.i;
        this.j = cVar.j;
        this.k = cVar.k;
        this.l = cVar.l;
        this.m = cVar.m;
        this.o = cVar.o;
        this.p = cVar.p;
        this.n = cVar.n;
    }

    public boolean b() {
        return this.c == 3 && (this.h < 0 || this.d == this.e);
    }

    public boolean c() {
        int i = this.e;
        int i2 = this.d;
        if (i >= i2 && i - i2 < 100000) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "BNRoadConditionJamModel{eventId='" + this.f7463a + "', eventType=" + this.b + ", jamType=" + this.c + ", beginAddDist=" + this.d + ", endAddDist=" + this.e + ", showAddDist=" + this.f + ", travelTime=" + this.g + ", jamIndex=" + this.h + ", jamVersion=" + this.i + ", routeMD5='" + this.j + "', priority=" + this.k + ", startShapeIndex=" + this.l + ", endShapeIndex=" + this.m + ", isSupportAvoidJam=" + this.n + '}';
    }

    public boolean b(c cVar) {
        int i;
        if (cVar == null || (i = cVar.f) < this.d || i > this.e) {
            return false;
        }
        if (cVar.c == 3) {
            return !TextUtils.isEmpty(cVar.f7463a) && cVar.f7463a.equals(this.f7463a);
        }
        return !b();
    }

    public int a() {
        return this.f;
    }

    public boolean a(int i) {
        return b() ? i > this.f : i > this.d;
    }
}

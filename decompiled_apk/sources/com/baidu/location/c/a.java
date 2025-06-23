package com.baidu.location.c;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f5679a;
    public long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public char i;
    public int j;
    public int k;
    public int l;
    public String m;
    public String n;
    public String o;
    public boolean p;

    public a() {
        this.f5679a = -1;
        this.b = -1L;
        this.c = -1;
        this.d = -1;
        this.e = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0L;
        this.h = -1;
        this.i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = false;
        this.g = System.currentTimeMillis();
    }

    public boolean a(a aVar) {
        if (this.f5679a != aVar.f5679a || this.b != aVar.b || this.d != aVar.d || this.c != aVar.c) {
            return false;
        }
        String str = this.n;
        if (str == null || !str.equals(aVar.n)) {
            return this.n == null && aVar.n == null;
        }
        return true;
    }

    public boolean b() {
        if (this.f5679a > -1 && this.b > 0) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f5679a == -1 && this.b == -1 && this.d == -1 && this.c == -1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f5679a > -1 && this.b > -1 && this.d == -1 && this.c == -1) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f5679a > -1 && this.b > -1 && this.d > -1 && this.c > -1) {
            return true;
        }
        return false;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.g;
        return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
    }

    public a(int i, long j, int i2, int i3, int i4, char c, int i5) {
        this.e = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0L;
        this.j = Integer.MAX_VALUE;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = false;
        this.f5679a = i;
        this.b = j;
        this.c = i2;
        this.d = i3;
        this.h = i4;
        this.i = c;
        this.g = System.currentTimeMillis();
        this.j = i5;
    }

    public a(a aVar) {
        this(aVar.f5679a, aVar.b, aVar.c, aVar.d, aVar.h, aVar.i, aVar.j);
        this.g = aVar.g;
        this.m = aVar.m;
        this.k = aVar.k;
        this.o = aVar.o;
        this.l = aVar.l;
        this.n = aVar.n;
    }
}

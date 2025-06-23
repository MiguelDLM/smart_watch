package com.realsil.sdk.dfu.b;

/* loaded from: classes11.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public int f19534a;
    public int b;
    public String c;
    public int d;
    public int e;
    public int f;
    public int g;

    public g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f19534a = i;
        this.b = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.c = String.format("%d.%d.%d.%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static g a(int i, int i2) {
        if (-1 == i2) {
            return new g(i2, i, 0);
        }
        if (i == 1) {
            return new g(i2, i, i2 & 255, (i2 >> 8) & 255, (i2 >> 16) & 255, (i2 >> 24) & 255);
        }
        if (i == 515) {
            return new g(i2, i, (i2 >> 24) & 255, (i2 >> 16) & 255, (i2 >> 8) & 255, i2 & 255);
        }
        if (i == 516) {
            return new g(i2, i, (i2 >> 24) & 255, (i2 >> 16) & 255, (i2 >> 8) & 255, i2 & 255);
        }
        if (i == 2) {
            return new g(i2, i, (i2 >> 24) & 255, (i2 >> 16) & 255, (i2 >> 8) & 255, i2 & 255);
        }
        if (i == 3) {
            return new g(i2, i, i2 & 15, (i2 >> 4) & 255, (i2 >> 12) & 32767, (i2 >> 27) & 31);
        }
        if (i == 5) {
            return new g(i2, i, i2 & 15, (i2 >> 4) & 255, (i2 >> 12) & 511, (i2 >> 21) & 32767);
        }
        if (i == 4) {
            return new g(i2, i, i2);
        }
        if (i == 7) {
            return new g(i2, i, i2);
        }
        if (i == 514) {
            return new g(i2, i, (i2 >> 8) & 255, i2 & 255, (i2 >> 24) & 255, (i2 >> 16) & 255);
        }
        return new g(i2, i, i2);
    }

    public String toString() {
        return "ImageVersion{" + String.format("\n\t%d(%08X)", Integer.valueOf(this.f19534a), Integer.valueOf(this.f19534a)) + String.format("\n\t%d(%s))", Integer.valueOf(this.b), this.c) + "\n}";
    }

    public g(int i, int i2, int i3) {
        this.f19534a = i;
        this.b = i2;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = i3;
        this.c = String.valueOf(i3);
    }

    public int a(g gVar) {
        int i = this.d;
        int i2 = gVar.d;
        if (i > i2) {
            return 1;
        }
        if (i < i2) {
            return -1;
        }
        int i3 = this.e;
        int i4 = gVar.e;
        if (i3 > i4) {
            return 1;
        }
        if (i3 < i4) {
            return -1;
        }
        int i5 = this.f;
        int i6 = gVar.f;
        if (i5 > i6) {
            return 1;
        }
        if (i5 < i6) {
            return -1;
        }
        return Integer.compare(this.g, gVar.g);
    }
}

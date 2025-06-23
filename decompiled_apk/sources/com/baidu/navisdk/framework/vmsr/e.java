package com.baidu.navisdk.framework.vmsr;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    float f6840a;
    float[] b;
    float[] c;
    float[] d;
    float[] e;
    float[] f;
    float[] g;
    float[] h;
    float[] i;
    float[] j;
    float[] k;
    float[] l;
    float[] m;
    int[] n;
    int[] o;
    int[] p;
    int[] q;

    public e(q qVar, f fVar) {
        this.f6840a = 1.0f - fVar.e;
        this.h = b.a(0.0f, qVar.d);
        this.i = b.a(0.0f, qVar.e);
        this.j = b.a(0.0f, qVar.c);
        this.l = b.a(0.0f, qVar.c);
        this.m = b.a(0.0f, qVar.e);
        this.k = b.a(0.0f, qVar.e);
        this.g = b.a(0.0f, qVar.g);
        this.f = b.a(0.0f, qVar.f);
        int i = qVar.g;
        this.n = new int[i];
        this.o = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int[] iArr = this.n;
            int i3 = qVar.e;
            iArr[i2] = i2 / i3;
            this.o[i2] = i2 % i3;
        }
        int i4 = qVar.f;
        this.p = new int[i4];
        this.q = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int[] iArr2 = this.p;
            int i6 = qVar.d;
            iArr2[i5] = i5 / i6;
            this.q[i5] = i5 % i6;
        }
        float[] a2 = b.a(0.0f, qVar.f);
        this.b = a2;
        this.c = a2;
        float[] a3 = b.a(0.0f, qVar.c * qVar.e);
        this.d = a3;
        this.e = a3;
    }
}

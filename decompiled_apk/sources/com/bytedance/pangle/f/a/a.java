package com.bytedance.pangle.f.a;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes8.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    int f10546a;
    b b;
    int[] c;
    private boolean i;
    private f k;
    private boolean j = false;
    private final c l = new c();
    int d = 0;
    int e = 1;
    int f = 2;
    int g = 3;
    int h = 4;

    public a() {
        c();
    }

    private int e(int i) {
        if (this.f10546a == 2) {
            int i2 = i * 5;
            if (i2 < this.c.length) {
                return i2;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public final void a() {
        if (this.j) {
            this.j = false;
            b bVar = this.b;
            InputStream inputStream = bVar.f10547a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                bVar.a((InputStream) null);
            }
            this.k = null;
            this.b = null;
            c cVar = this.l;
            cVar.b = 0;
            cVar.c = 0;
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0223, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b() {
        /*
            Method dump skipped, instructions count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.f.a.a.b():int");
    }

    public final int c(int i) {
        return this.c[e(i) + 4];
    }

    public final String d(int i) {
        int e = e(i);
        int[] iArr = this.c;
        if (iArr[e + 3] == 3) {
            return this.k.a(iArr[e + 2]);
        }
        return "";
    }

    private void c() {
        this.c = null;
        this.f10546a = -1;
    }

    public final String a(int i) {
        int i2 = this.c[e(i) + 1];
        return i2 == -1 ? "" : this.k.a(i2);
    }

    public final int b(int i) {
        return this.c[e(i) + 3];
    }
}

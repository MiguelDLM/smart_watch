package com.bytedance.pangle.res.a;

import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes8.dex */
public final class b {
    g c;
    private final h i;
    private final byte[] j;
    private int[] l;
    private boolean n;
    private int o;
    private int[] p;
    private int q;

    /* renamed from: a, reason: collision with root package name */
    HashMap<Integer, Integer> f10604a = new HashMap<>();
    boolean b = false;
    private boolean k = false;
    private final a m = new a();
    int d = 0;
    int e = 1;
    int f = 2;
    int g = 3;
    int h = 4;

    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        int[] f10605a = new int[32];
        int b;
        int c;

        public final void a() {
            b();
            int i = this.b;
            int[] iArr = this.f10605a;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.b = i + 2;
            this.c++;
        }

        public final void b() {
            int[] iArr = this.f10605a;
            int length = iArr.length;
            int i = this.b;
            int i2 = length - i;
            if (i2 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.f10605a = iArr2;
        }
    }

    public b(byte[] bArr, h hVar) {
        this.i = hVar;
        this.j = bArr;
        c();
    }

    private void c() {
        this.o = -1;
        this.p = null;
        this.q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0290, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r8 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x012b, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r8 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.a.b.d():void");
    }

    public final void a() {
        if (!this.k) {
            return;
        }
        this.k = false;
        this.c = null;
        this.l = null;
        a aVar = this.m;
        aVar.b = 0;
        aVar.c = 0;
        c();
    }

    public final int b() {
        if (this.c != null) {
            try {
                d();
                return this.o;
            } catch (IOException e) {
                a();
                throw e;
            }
        }
        throw new RuntimeException("Parser is not opened.");
    }
}

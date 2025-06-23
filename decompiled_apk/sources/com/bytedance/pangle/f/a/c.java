package com.bytedance.pangle.f.a;

/* loaded from: classes8.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    int[] f10548a = new int[32];
    int b;
    int c;

    public final void a() {
        b();
        int i = this.b;
        int[] iArr = this.f10548a;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.b = i + 2;
        this.c++;
    }

    public final void b() {
        int[] iArr = this.f10548a;
        int length = iArr.length;
        int i = this.b;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.f10548a = iArr2;
        }
    }
}

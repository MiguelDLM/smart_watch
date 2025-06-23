package com.baidu.tts;

import java.util.Iterator;

/* loaded from: classes8.dex */
public class g3 implements Iterator<f3> {

    /* renamed from: a, reason: collision with root package name */
    public int f10096a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public f3 next() {
        f3 f3Var = new f3();
        int i = this.c + this.b;
        int i2 = i - 1;
        int i3 = this.f10096a;
        if (i2 <= i3 - 1) {
            int i4 = (i2 - this.d) + 1;
            int i5 = this.e;
            f3Var.f10086a = i5;
            f3Var.b = i4;
            this.d = i;
            this.c = i;
            this.e = i5 + i4;
            f3Var.d = i / i3;
            f3Var.c = true;
        } else {
            int i6 = this.d;
            int i7 = i3 - i6;
            int i8 = this.e;
            f3Var.f10086a = i8;
            f3Var.b = i7;
            this.d = i6 + i7;
            this.e = i8 + i7;
        }
        return f3Var;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.d < this.f10096a - 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
    }
}

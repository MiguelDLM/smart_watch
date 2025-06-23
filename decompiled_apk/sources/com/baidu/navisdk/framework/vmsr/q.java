package com.baidu.navisdk.framework.vmsr;

/* loaded from: classes7.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public int f6853a;
    public int b;
    public int c;
    int d;
    int e;
    int f;
    int g;

    public q(int i, int i2, int i3) throws Exception {
        if (i >= 0 && i2 >= 0 && i3 >= 0) {
            this.f6853a = i;
            this.b = i2;
            this.c = i3;
            int i4 = i + 1;
            this.d = i4;
            int i5 = i2 + 1;
            this.e = i5;
            this.f = i2 * i4;
            this.g = i3 * i5;
            return;
        }
        throw new Exception("Number of input, hidden and output nodes must be positive and nonzero.");
    }
}

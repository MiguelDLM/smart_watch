package com.baidu.navisdk.framework.vmsr;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    int f6835a;

    private a(int i) {
        this.f6835a = i;
    }

    public static a a(int i) {
        return new a(i);
    }

    public float a(Float f) {
        int i = this.f6835a;
        if (i == 0) {
            return f.floatValue();
        }
        if (i == 1) {
            return Math.max(0.0f, f.floatValue());
        }
        if (i == 2) {
            return (float) (1.0d / (Math.exp(-f.floatValue()) + 1.0d));
        }
        if (i != 3) {
            return 0.0f;
        }
        return (float) Math.tanh(f.floatValue());
    }

    public float a(float f) {
        int i = this.f6835a;
        if (i == 0) {
            return 1.0f;
        }
        if (i == 1) {
            return f == 0.0f ? 0.0f : 1.0f;
        }
        if (i == 2) {
            return f * (1.0f - f);
        }
        if (i != 3) {
            return 0.0f;
        }
        return 1.0f - (f * f);
    }
}

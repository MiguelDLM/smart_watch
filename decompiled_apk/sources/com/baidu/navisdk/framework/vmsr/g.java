package com.baidu.navisdk.framework.vmsr;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    final int f6842a;

    private g(int i) {
        this.f6842a = i;
    }

    public static g a(int i) {
        return new g(i);
    }

    public float a(float[] fArr, float[] fArr2) {
        if (this.f6842a != 0) {
            return 0.0f;
        }
        int min = Math.min(fArr.length, fArr2.length) - 1;
        float f = fArr[min];
        float f2 = fArr2[min];
        return ((f - f2) * (f - f2)) / 2.0f;
    }

    public float a(Float f, Float f2) {
        int i = this.f6842a;
        if (i == 0) {
            return f.floatValue() - f2.floatValue();
        }
        if (i != 1) {
            return 0.0f;
        }
        return (f.floatValue() - f2.floatValue()) / ((1.0f - f.floatValue()) * f.floatValue());
    }
}

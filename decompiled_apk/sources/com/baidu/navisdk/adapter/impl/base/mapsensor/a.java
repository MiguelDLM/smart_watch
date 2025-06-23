package com.baidu.navisdk.adapter.impl.base.mapsensor;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private float f6492a;
    private float b = 2.0f;

    private float a(float f, float f2, float f3) {
        float f4 = f - f2;
        return (f4 > 180.0f || f4 < -180.0f) ? f2 : (f4 < (-f3) || f3 < f4) ? (f + f2) / 2.0f : f;
    }

    public float a(float f) {
        float a2 = a(this.f6492a, f, this.b);
        this.f6492a = a2;
        return a2;
    }
}

package com.baidu.navisdk.framework.vmsr;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public a f6841a;
    public a b;
    public g c;
    public float d;
    public float e;

    public f(a aVar, a aVar2, g gVar, float f, float f2) throws Exception {
        if (f >= 0.0f && f2 >= 0.0f) {
            this.f6841a = aVar;
            this.b = aVar2;
            this.c = gVar;
            this.d = f;
            this.e = f2;
            return;
        }
        throw new Exception("Learning rate and MOMENTUM must be positive.");
    }
}

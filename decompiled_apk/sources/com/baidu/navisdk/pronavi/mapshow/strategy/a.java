package com.baidu.navisdk.pronavi.mapshow.strategy;

/* loaded from: classes7.dex */
public abstract class a implements com.baidu.navisdk.pronavi.mapshow.i.a {

    /* renamed from: a, reason: collision with root package name */
    private int f7803a;
    private int b;

    public a(int i, int i2) {
        this.f7803a = i;
        this.b = i2;
    }

    @Override // com.baidu.navisdk.pronavi.mapshow.i.a
    public void a(int i, int i2) {
        this.f7803a = i;
        this.b = i2;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.f7803a;
    }
}

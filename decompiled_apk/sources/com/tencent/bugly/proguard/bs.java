package com.tencent.bugly.proguard;

/* loaded from: classes13.dex */
public final class bs extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f26604a = "";
    public String b = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f26604a, 0);
        lVar.a(this.b, 1);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f26604a = kVar.b(0, true);
        this.b = kVar.b(1, true);
    }
}

package com.tencent.bugly.proguard;

/* loaded from: classes13.dex */
public final class bl extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f26597a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f26597a, 0);
        String str = this.b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        String str3 = this.d;
        if (str3 != null) {
            lVar.a(str3, 3);
        }
        String str4 = this.e;
        if (str4 != null) {
            lVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f26597a = kVar.b(0, true);
        this.b = kVar.b(1, false);
        this.c = kVar.b(2, false);
        this.d = kVar.b(3, false);
        this.e = kVar.b(4, false);
    }
}

package com.tencent.bugly.proguard;

/* loaded from: classes13.dex */
public final class bn extends m implements Cloneable {
    static byte[] d;

    /* renamed from: a, reason: collision with root package name */
    public byte f26599a;
    public String b;
    public byte[] c;

    public bn() {
        this.f26599a = (byte) 0;
        this.b = "";
        this.c = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f26599a, 0);
        lVar.a(this.b, 1);
        byte[] bArr = this.c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    public bn(byte b, String str, byte[] bArr) {
        this.f26599a = b;
        this.b = str;
        this.c = bArr;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f26599a = kVar.a(this.f26599a, 0, true);
        this.b = kVar.b(1, true);
        if (d == null) {
            d = r0;
            byte[] bArr = {0};
        }
        this.c = kVar.c(2, false);
    }
}

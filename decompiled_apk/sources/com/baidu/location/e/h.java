package com.baidu.location.e;

import com.baidu.location.b.ab;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class h implements ab.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f5739a;
    final /* synthetic */ g b;

    public h(g gVar, long j) {
        this.b = gVar;
        this.f5739a = j;
    }

    @Override // com.baidu.location.b.ab.a
    public void a(int i, String str) {
        g gVar;
        boolean z;
        if (i == 200) {
            this.b.dI = System.currentTimeMillis() - this.f5739a;
            gVar = this.b;
            gVar.dA = str;
            z = true;
        } else {
            gVar = this.b;
            gVar.dA = null;
            z = false;
        }
        gVar.a(z);
    }

    @Override // com.baidu.location.b.ab.a
    public void b(int i, String str) {
        g gVar = this.b;
        gVar.dA = null;
        gVar.a(false);
    }
}

package com.baidu.platform.comapi.walknavi.e.a;

import com.baidu.platform.comapi.walknavi.e.a.b;
import com.baidu.platform.comapi.walknavi.e.a.d.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9720a;

    public c(b bVar) {
        this.f9720a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.d.b.a
    public void a(boolean z, boolean z2) {
        b.a aVar;
        this.f9720a.k = z2;
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("download so finished");
        if (z) {
            this.f9720a.f();
        } else {
            aVar = this.f9720a.g;
            aVar.b("download so failed");
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.d.b.a
    public void a(int i) {
        b.a aVar;
        com.baidu.platform.comapi.walknavi.e.a.g.a.a("so progress: " + i);
        aVar = this.f9720a.g;
        aVar.a(i / 2);
    }
}

package com.baidu.platform.comapi.walknavi.e;

import com.baidu.platform.comapi.walknavi.e.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class h implements com.baidu.platform.comapi.walknavi.e.a.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9749a;
    final /* synthetic */ g b;

    public h(g gVar, c cVar) {
        this.b = gVar;
        this.f9749a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.a
    public void a(boolean z, float f) {
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.a
    public void a(int i) {
        g.a aVar;
        g.a aVar2;
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onProgress = " + i);
        if (i == 100) {
            this.b.n = false;
            g.b bVar = this.b.b;
            bVar.c = 0;
            bVar.b = "";
        }
        aVar = this.b.o;
        if (aVar != null) {
            g gVar = this.b;
            gVar.b.c = i;
            aVar2 = gVar.o;
            aVar2.a(this.b.b);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.a
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onResponse = " + this.f9749a);
        this.b.n = false;
        g.b bVar = this.b.b;
        bVar.c = 0;
        bVar.b = "";
        c cVar = this.f9749a;
        if (cVar != null) {
            cVar.a(i, str);
        }
    }
}

package com.baidu.platform.comapi.walknavi.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class i implements com.baidu.platform.comapi.walknavi.e.a.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9750a;
    final /* synthetic */ g b;

    public i(g gVar, c cVar) {
        this.b = gVar;
        this.f9750a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.a
    public void a(boolean z, float f) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa MainActivity isUpdate=" + z + ", size=" + f);
        this.f9750a.a(z, f);
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.a
    public void a(int i) {
        c cVar = this.f9750a;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.a
    public void a(int i, String str) {
        c cVar = this.f9750a;
        if (cVar != null) {
            cVar.a(i, str);
        }
    }
}

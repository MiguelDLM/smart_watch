package com.baidu.platform.comapi.walknavi;

import com.baidu.platform.comapi.walknavi.h.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class h implements b.InterfaceC0537b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9762a;

    public h(b bVar) {
        this.f9762a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.h.b.InterfaceC0537b
    public void a(int i) {
        if (i == 1) {
            if (b.a().Y() instanceof com.baidu.platform.comapi.walknavi.h.b) {
                b.a().X().a(new i(this));
                return;
            }
            return;
        }
        this.f9762a.x();
    }

    @Override // com.baidu.platform.comapi.walknavi.h.b.InterfaceC0537b
    public void b(int i) {
        if (i != 3 && i != 1) {
            if (i == 2) {
                b.a().a(false);
                b.a().K().c(false);
                return;
            }
            return;
        }
        b.a().Y().t();
    }
}

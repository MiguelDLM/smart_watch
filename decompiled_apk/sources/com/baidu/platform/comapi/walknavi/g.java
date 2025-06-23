package com.baidu.platform.comapi.walknavi;

import com.baidu.platform.comapi.walknavi.h.b;
import com.baidu.platform.comapi.walknavi.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class g implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.InterfaceC0537b f9760a;
    final /* synthetic */ int b;
    final /* synthetic */ b c;

    public g(b bVar, b.InterfaceC0537b interfaceC0537b, int i) {
        this.c = bVar;
        this.f9760a = interfaceC0537b;
        this.b = i;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.b.a
    public void a() {
        b.InterfaceC0537b interfaceC0537b = this.f9760a;
        if (interfaceC0537b != null) {
            interfaceC0537b.b(this.b);
        }
    }
}

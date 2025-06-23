package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class f implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9547a;

    public f(b bVar) {
        this.f9547a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.b.a
    public void a() {
        b.a aVar;
        b.a aVar2;
        aVar = this.f9547a.x;
        if (aVar != null) {
            aVar2 = this.f9547a.x;
            aVar2.cancel();
        }
    }
}

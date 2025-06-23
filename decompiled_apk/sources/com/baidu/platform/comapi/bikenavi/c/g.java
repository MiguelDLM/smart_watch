package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class g implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9548a;

    public g(b bVar) {
        this.f9548a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.b.a
    public void a() {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        aVar = this.f9548a.x;
        if (aVar != null) {
            aVar2 = this.f9548a.x;
            aVar2.onFinish();
            aVar3 = this.f9548a.x;
            aVar3.cancel();
            return;
        }
        this.f9548a.t();
    }
}

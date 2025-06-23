package com.baidu.platform.comapi.walknavi.h;

import com.baidu.platform.comapi.walknavi.h.b;
import com.baidu.platform.comapi.walknavi.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class f implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9804a;

    public f(b bVar) {
        this.f9804a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.b.a
    public void a() {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        aVar = this.f9804a.t;
        if (aVar != null) {
            aVar2 = this.f9804a.t;
            aVar2.onFinish();
            aVar3 = this.f9804a.t;
            aVar3.cancel();
            return;
        }
        this.f9804a.t();
    }
}

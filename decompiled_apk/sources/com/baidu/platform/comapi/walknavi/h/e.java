package com.baidu.platform.comapi.walknavi.h;

import com.baidu.platform.comapi.walknavi.h.b;
import com.baidu.platform.comapi.walknavi.widget.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9803a;

    public e(b bVar) {
        this.f9803a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.b.a
    public void a() {
        b.a aVar;
        b.a aVar2;
        aVar = this.f9803a.t;
        if (aVar != null) {
            aVar2 = this.f9803a.t;
            aVar2.cancel();
        }
    }
}

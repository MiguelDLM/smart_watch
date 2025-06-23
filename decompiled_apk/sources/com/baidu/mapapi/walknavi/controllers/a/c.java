package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.platform.comapi.walknavi.widget.a.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements z.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f6031a;

    public c(a aVar) {
        this.f6031a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.z.a
    public void a() {
        com.baidu.platform.comapi.walknavi.d.a aVar;
        com.baidu.platform.comapi.walknavi.d.a aVar2;
        aVar = this.f6031a.l;
        if (aVar != null) {
            aVar2 = this.f6031a.l;
            aVar2.a();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.z.a
    public void b() {
        com.baidu.platform.comapi.walknavi.d.a aVar;
        com.baidu.platform.comapi.walknavi.d.a aVar2;
        aVar = this.f6031a.l;
        if (aVar != null) {
            aVar2 = this.f6031a.l;
            aVar2.b();
        }
    }
}

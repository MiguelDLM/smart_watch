package com.baidu.platform.comapi.walknavi.e.a.d;

import com.baidu.platform.comapi.walknavi.e.a.d.a.c;
import com.baidu.platform.comapi.walknavi.e.a.d.b;
import com.baidu.platform.comapi.walknavi.e.a.g.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements c.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.C0536b f9727a;

    public d(b.C0536b c0536b) {
        this.f9727a = c0536b;
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.d.a.c.a
    public boolean a() {
        return this.f9727a.b();
    }

    @Override // com.baidu.platform.comapi.walknavi.e.a.d.a.c.InterfaceC0535c
    public void a(long j, long j2) {
        j.a(new e(this, j, j2));
    }
}

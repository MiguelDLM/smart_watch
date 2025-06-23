package com.baidu.platform.comapi.walknavi;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class j implements WalkNaviModeSwitchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9826a;
    final /* synthetic */ boolean b;
    final /* synthetic */ b c;

    public j(b bVar, int i, boolean z) {
        this.c = bVar;
        this.f9826a = i;
        this.b = z;
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onFailed() {
    }

    @Override // com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener
    public void onSuccess() {
        com.baidu.platform.comapi.wnplatform.o.a aVar;
        com.baidu.platform.comapi.wnplatform.o.a aVar2;
        com.baidu.platform.comapi.wnplatform.o.a aVar3;
        this.c.W = this.f9826a;
        aVar = this.c.p;
        if (aVar != null) {
            aVar2 = this.c.p;
            if (aVar2 instanceof com.baidu.platform.comapi.walknavi.h.b) {
                aVar3 = this.c.p;
                ((com.baidu.platform.comapi.walknavi.h.b) aVar3).a(this.f9826a, this.b);
            }
        }
        if (com.baidu.platform.comapi.wnplatform.f.a().b()) {
            b.a().g(0);
        } else if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
            new Handler(Looper.myLooper()).postDelayed(new k(this), 400L);
        } else if (com.baidu.platform.comapi.wnplatform.f.a().f()) {
            b.a().g(3);
        }
    }
}

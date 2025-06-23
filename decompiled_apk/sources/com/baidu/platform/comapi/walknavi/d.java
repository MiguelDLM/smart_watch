package com.baidu.platform.comapi.walknavi;

import com.baidu.mapapi.map.BaiduMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9709a;

    public d(b bVar) {
        this.f9709a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.platform.comapi.wnplatform.model.c cVar;
        com.baidu.platform.comapi.wnplatform.model.c cVar2;
        com.baidu.platform.comapi.wnplatform.model.c cVar3;
        if (!com.baidu.platform.comapi.wnplatform.f.a().f()) {
            this.f9709a.M().runEntryState();
        } else {
            this.f9709a.M().run("[查看全览]按钮点击");
        }
        if (com.baidu.platform.comapi.wnplatform.f.a().d()) {
            cVar = this.f9709a.I;
            if (cVar != null) {
                BaiduMap map = b.a().N().a().getMap();
                cVar2 = this.f9709a.I;
                String b = cVar2.b();
                cVar3 = this.f9709a.I;
                map.switchBaseIndoorMapFloor(b, cVar3.a());
            }
        }
    }
}

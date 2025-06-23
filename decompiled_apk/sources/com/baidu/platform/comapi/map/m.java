package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.map.MapController;

/* loaded from: classes8.dex */
class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapController.b f9666a;

    public m(MapController.b bVar) {
        this.f9666a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.mapsdkplatform.comapi.map.w mapStatusInner = MapController.this.getMapStatusInner();
        if (MapController.this.mListeners != null) {
            for (int i = 0; i < MapController.this.mListeners.size(); i++) {
                ak akVar = MapController.this.mListeners.get(i);
                if (akVar != null) {
                    akVar.b();
                    MapController.this.U = true;
                    akVar.c(mapStatusInner);
                }
            }
        }
    }
}

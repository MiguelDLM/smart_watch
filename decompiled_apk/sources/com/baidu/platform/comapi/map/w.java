package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

/* loaded from: classes8.dex */
class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f9676a;
    final /* synthetic */ MapSurfaceView b;

    public w(MapSurfaceView mapSurfaceView, boolean z) {
        this.b = mapSurfaceView;
        this.f9676a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        MapController mapController = this.b.f9621a;
        if (mapController != null && (baseMap = mapController.getBaseMap()) != null) {
            baseMap.ShowBaseIndoorMap(this.f9676a);
        }
    }
}

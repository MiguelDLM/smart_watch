package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

/* loaded from: classes8.dex */
class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f9674a;

    public u(MapSurfaceView mapSurfaceView) {
        this.f9674a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        MapController mapController = this.f9674a.f9621a;
        if (mapController != null && (baseMap = mapController.getBaseMap()) != null) {
            z = this.f9674a.l;
            baseMap.ShowTrafficMap(z);
        }
    }
}

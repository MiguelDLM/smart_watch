package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

/* loaded from: classes8.dex */
class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f9672a;

    public s(MapSurfaceView mapSurfaceView) {
        this.f9672a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        MapController mapController = this.f9672a.f9621a;
        if (mapController != null && (baseMap = mapController.getBaseMap()) != null) {
            z = this.f9672a.m;
            baseMap.ShowSatelliteMap(z);
        }
    }
}

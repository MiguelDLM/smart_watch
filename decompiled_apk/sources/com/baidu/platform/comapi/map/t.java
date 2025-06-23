package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f9673a;

    public t(MapSurfaceView mapSurfaceView) {
        this.f9673a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        MapController mapController = this.f9673a.f9621a;
        if (mapController != null && (baseMap = mapController.getBaseMap()) != null) {
            z = this.f9673a.l;
            baseMap.ShowTrafficMap(z);
        }
    }
}

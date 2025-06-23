package com.baidu.platform.comapi.map.b;

import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements a.InterfaceC0528a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9650a;

    public c(b bVar) {
        this.f9650a = bVar;
    }

    @Override // com.baidu.platform.comapi.map.b.a.a.InterfaceC0528a
    public boolean a(com.baidu.platform.comapi.map.b.a.a aVar) {
        MapController mapController;
        MapController mapController2;
        MapController mapController3;
        MapController mapController4;
        MapController mapController5;
        MapController mapController6;
        MapController mapController7;
        MapController mapController8;
        MapController mapController9;
        mapController = this.f9650a.b;
        if (mapController.isTwoTouchClickZoomEnabled()) {
            mapController2 = this.f9650a.b;
            mapController2.setActingTwoClickZoom(true);
            mapController3 = this.f9650a.b;
            d gestureMonitor = mapController3.getGestureMonitor();
            mapController4 = this.f9650a.b;
            gestureMonitor.c(mapController4.getZoomLevel() - 1.0f);
            mapController5 = this.f9650a.b;
            mapController5.mapStatusChangeStart();
            mapController6 = this.f9650a.b;
            mapController6.MapMsgProc(8193, 4, 0);
            mapController7 = this.f9650a.b;
            if (mapController7.isNaviMode()) {
                mapController8 = this.f9650a.b;
                if (mapController8.getNaviMapViewListener() != null) {
                    mapController9 = this.f9650a.b;
                    mapController9.getNaviMapViewListener().onAction(521, null);
                }
            }
            return true;
        }
        return false;
    }
}

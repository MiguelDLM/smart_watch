package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;

/* loaded from: classes8.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapStatus f9665a;
    final /* synthetic */ MapController.b b;

    public l(MapController.b bVar, MapStatus mapStatus) {
        this.b = bVar;
        this.f9665a = mapStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        GeoPoint geoPoint;
        if (MapController.this.getMapView() != null && MapController.this.getMapView().getProjection() != null) {
            geoPoint = MapController.this.i.get().getProjection().fromPixels(this.f9665a.winRound.left + (MapController.this.getScreenWidth() / 2), this.f9665a.winRound.top + (MapController.this.getScreenHeight() / 2));
        } else {
            geoPoint = null;
        }
        if (geoPoint != null) {
            MapController.CleanAfterDBClick(MapController.this.y, (float) geoPoint.getLongitudeE6(), (float) geoPoint.getLatitudeE6());
        }
        MapController.this.V = false;
    }
}

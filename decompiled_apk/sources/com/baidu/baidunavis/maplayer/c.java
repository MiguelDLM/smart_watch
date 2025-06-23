package com.baidu.baidunavis.maplayer;

import com.baidu.mapframework.common.mapview.BaseMapViewListener;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.platform.comapi.map.PoiDynamicMapOverlay;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c extends BaseMapViewListener {
    public c() {
        a.h().b().getOverlay(PoiDynamicMapOverlay.class);
        this.mMapController = MapViewFactory.getInstance().getMapView().getController();
        this.mMapView = MapViewFactory.getInstance().getMapView();
    }

    public void a(b bVar) {
    }
}

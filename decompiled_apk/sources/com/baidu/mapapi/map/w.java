package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class w implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapView f5917a;

    public w(MapView mapView) {
        this.f5917a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        MapSurfaceView mapSurfaceView3;
        MapSurfaceView mapSurfaceView4;
        mapSurfaceView = this.f5917a.e;
        float zoomLevel = mapSurfaceView.getZoomLevel();
        float f = 1.0f + zoomLevel;
        double d = zoomLevel;
        if (((int) Math.ceil(d)) != ((int) zoomLevel)) {
            f = (float) Math.ceil(d);
        }
        mapSurfaceView2 = this.f5917a.e;
        if (mapSurfaceView2.getController() != null) {
            mapSurfaceView3 = this.f5917a.e;
            float min = Math.min(f, mapSurfaceView3.getController().mMaxZoomLevel);
            BaiduMap.mapStatusReason |= 16;
            mapSurfaceView4 = this.f5917a.e;
            mapSurfaceView4.setZoomLevel(min);
        }
    }
}

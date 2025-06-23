package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class v implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapView f5916a;

    public v(MapView mapView) {
        this.f5916a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        MapSurfaceView mapSurfaceView3;
        MapSurfaceView mapSurfaceView4;
        mapSurfaceView = this.f5916a.e;
        float zoomLevel = mapSurfaceView.getZoomLevel();
        float f = zoomLevel - 1.0f;
        double d = zoomLevel;
        if (Math.floor(d) != d) {
            f = (float) Math.floor(d);
        }
        mapSurfaceView2 = this.f5916a.e;
        if (mapSurfaceView2.getController() != null) {
            mapSurfaceView3 = this.f5916a.e;
            float max = Math.max(f, mapSurfaceView3.getController().mMinZoomLevel);
            BaiduMap.mapStatusReason |= 16;
            mapSurfaceView4 = this.f5916a.e;
            mapSurfaceView4.setZoomLevel(max);
        }
    }
}

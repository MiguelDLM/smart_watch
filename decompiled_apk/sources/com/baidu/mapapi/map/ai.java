package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapTextureView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ai implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextureMapView f5885a;

    public ai(TextureMapView textureMapView) {
        this.f5885a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapTextureView mapTextureView;
        MapTextureView mapTextureView2;
        MapTextureView mapTextureView3;
        mapTextureView = this.f5885a.b;
        float zoomLevel = mapTextureView.getZoomLevel();
        float f = zoomLevel - 1.0f;
        double d = zoomLevel;
        if (Math.floor(d) != d) {
            f = (float) Math.floor(d);
        }
        mapTextureView2 = this.f5885a.b;
        float max = Math.max(f, mapTextureView2.getController().mMinZoomLevel);
        BaiduMap.mapStatusReason |= 16;
        mapTextureView3 = this.f5885a.b;
        mapTextureView3.setZoomLevel(max);
    }
}

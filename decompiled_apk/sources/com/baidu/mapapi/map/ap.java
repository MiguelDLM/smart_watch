package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ap implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WearMapView f5892a;

    public ap(WearMapView wearMapView) {
        this.f5892a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        mapSurfaceView = this.f5892a.f;
        com.baidu.mapsdkplatform.comapi.map.w E = mapSurfaceView.getBaseMap().E();
        E.f6196a += 1.0f;
        mapSurfaceView2 = this.f5892a.f;
        mapSurfaceView2.getBaseMap().a(E, 300);
    }
}

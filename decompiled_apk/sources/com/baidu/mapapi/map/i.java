package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MapViewLayoutParams;

/* loaded from: classes7.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InfoWindow f5901a;
    final /* synthetic */ h b;

    public i(h hVar, InfoWindow infoWindow) {
        this.b = hVar;
        this.f5901a = infoWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5901a.c.setLayoutParams(new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(this.f5901a.d).yOffset(this.f5901a.g).build());
    }
}

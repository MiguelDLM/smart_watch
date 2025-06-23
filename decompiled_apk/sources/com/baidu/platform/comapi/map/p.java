package com.baidu.platform.comapi.map;

/* loaded from: classes8.dex */
class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f9669a;
    final /* synthetic */ o b;

    public p(o oVar, MapSurfaceView mapSurfaceView) {
        this.b = oVar;
        this.f9669a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        MapSurfaceView mapSurfaceView = this.f9669a;
        if (mapSurfaceView != null) {
            mapSurfaceView.setBackgroundResource(0);
        }
    }
}

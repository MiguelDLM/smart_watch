package com.baidu.platform.comapi.map.b;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a.a;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    a.InterfaceC0528a f9647a = new c(this);
    private MapController b;
    private com.baidu.platform.comapi.map.b.a.b c;
    private com.baidu.platform.comapi.map.b.a.a d;

    public b(MapController mapController) {
        this.b = mapController;
        this.c = new com.baidu.platform.comapi.map.b.a.b(new com.baidu.platform.comapi.map.b.b.b(mapController));
        this.d = new com.baidu.platform.comapi.map.b.a.a(this.f9647a, mapController);
    }

    public void a(MotionEvent motionEvent) {
        this.c.a(motionEvent);
        this.d.a(motionEvent);
    }
}

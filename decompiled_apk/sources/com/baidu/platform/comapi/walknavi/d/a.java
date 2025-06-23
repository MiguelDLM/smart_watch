package com.baidu.platform.comapi.walknavi.d;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

/* loaded from: classes8.dex */
public class a extends FrameLayout {
    private static final String d = "com.baidu.platform.comapi.walknavi.d.a";

    /* renamed from: a, reason: collision with root package name */
    b f9710a;
    MapTextureView b;
    private Context c;

    public a(Context context) {
        super(context);
        this.f9710a = null;
        this.c = context;
        c();
    }

    private void c() {
    }

    public void a(MapTextureView mapTextureView) {
        addView(mapTextureView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void b() {
        MapController controller;
        MapTextureView mapTextureView = this.b;
        if (mapTextureView != null && (controller = mapTextureView.getController()) != null) {
            controller.onResume();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        AppBaseMap baseMap;
        super.onAttachedToWindow();
        try {
            b bVar = new b(this.c);
            this.f9710a = bVar;
            MapTextureView a2 = bVar.a();
            this.b = a2;
            a2.setFPS(15);
            MapController controller = this.b.getController();
            if (this.b != null && controller != null && (baseMap = controller.getBaseMap()) != null) {
                com.baidu.platform.comapi.walknavi.b.a().a(baseMap.GetId());
                a(this.b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f9710a;
        if (bVar != null) {
            bVar.b();
        }
        com.baidu.platform.comapi.walknavi.b.a().m();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void a() {
        MapController controller;
        MapTextureView mapTextureView = this.b;
        if (mapTextureView == null || (controller = mapTextureView.getController()) == null) {
            return;
        }
        controller.onPause();
    }
}

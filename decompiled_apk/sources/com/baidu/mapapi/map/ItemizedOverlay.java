package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;

/* loaded from: classes7.dex */
public class ItemizedOverlay extends Overlay {

    /* renamed from: a, reason: collision with root package name */
    MapView f5817a;

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.marker;
        this.f5817a = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions != null) {
            this.f5817a.getMap().addOverlay(overlayOptions);
        }
    }

    public void reAddAll() {
    }

    public void removeAll() {
        this.f5817a.getMap().clear();
    }
}

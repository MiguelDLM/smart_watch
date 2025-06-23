package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public final class UiSettings {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.c f5870a;

    public UiSettings(com.baidu.mapsdkplatform.comapi.map.c cVar) {
        this.f5870a = cVar;
    }

    public boolean isCompassEnabled() {
        return this.f5870a.t();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f5870a.A();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f5870a.z();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f5870a.x();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f5870a.y();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setDoubleClickZoomEnabled(z);
        setTwoTouchClickZoomEnabled(z);
        setDoubleClickMoveZoomEnable(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f5870a.o(z);
    }

    public void setDoubleClickMoveZoomEnable(boolean z) {
        this.f5870a.y(z);
    }

    public void setDoubleClickZoomEnabled(boolean z) {
        this.f5870a.w(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f5870a.z(z);
    }

    public void setFlingEnable(boolean z) {
        this.f5870a.A(z);
    }

    public void setInertialAnimation(boolean z) {
        this.f5870a.v(z);
    }

    public void setLatLngGesturesCenter(LatLng latLng) {
        this.f5870a.a(latLng);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f5870a.C(z);
    }

    public void setPointGesturesCenter(Point point) {
        this.f5870a.b(point);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f5870a.B(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f5870a.t(z);
    }

    public void setTwoTouchClickZoomEnabled(boolean z) {
        this.f5870a.x(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f5870a.u(z);
    }
}

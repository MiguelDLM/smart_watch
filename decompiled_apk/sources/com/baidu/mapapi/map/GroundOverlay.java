package com.baidu.mapapi.map;

import XIXIX.OOXIXo;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public final class GroundOverlay extends Overlay {
    private static final String k = "GroundOverlay";

    /* renamed from: a, reason: collision with root package name */
    int f5809a;
    BitmapDescriptor b;
    LatLng c;
    double d;
    double e;
    float f;
    float g;
    LatLngBounds h;
    float i;
    boolean j = false;

    public GroundOverlay() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.ground;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        bundle.putBundle("image_info", this.b.b());
        if (this.f5809a == 1) {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.h.southwest);
            double longitudeE6 = ll2mc.getLongitudeE6();
            double latitudeE6 = ll2mc.getLatitudeE6();
            GeoPoint ll2mc2 = CoordUtil.ll2mc(this.h.northeast);
            double longitudeE62 = ll2mc2.getLongitudeE6();
            double latitudeE62 = ll2mc2.getLatitudeE6();
            double d = longitudeE62 - longitudeE6;
            this.d = d;
            double d2 = latitudeE62 - latitudeE6;
            this.e = d2;
            this.c = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (d2 / 2.0d), longitudeE6 + (d / 2.0d)));
            this.f = 0.5f;
            this.g = 0.5f;
        }
        double d3 = this.d;
        if (d3 > OOXIXo.f3760XO && this.e > OOXIXo.f3760XO) {
            bundle.putDouble("x_distance", d3);
            if (this.e == 2.147483647E9d) {
                this.e = (int) ((this.d * this.b.f5792a.getHeight()) / this.b.f5792a.getWidth());
            }
            bundle.putDouble("y_distance", this.e);
            GeoPoint ll2mc3 = CoordUtil.ll2mc(this.c);
            bundle.putDouble("location_x", ll2mc3.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc3.getLatitudeE6());
            bundle.putFloat("anchor_x", this.f);
            bundle.putFloat("anchor_y", this.g);
            bundle.putFloat("transparency", this.i);
            bundle.putInt("isClickable", this.j ? 1 : 0);
            return bundle;
        }
        throw new IllegalStateException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
    }

    public float getAnchorX() {
        return this.f;
    }

    public float getAnchorY() {
        return this.g;
    }

    public LatLngBounds getBounds() {
        return this.h;
    }

    public double getHeight() {
        return this.e;
    }

    public BitmapDescriptor getImage() {
        return this.b;
    }

    public LatLng getPosition() {
        return this.c;
    }

    public float getTransparency() {
        return this.i;
    }

    public double getWidth() {
        return this.d;
    }

    public boolean isClickable() {
        return this.j;
    }

    public void setAnchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.f = f;
            this.g = f2;
            this.listener.c(this);
        }
    }

    public void setClickable(boolean z) {
        this.j = z;
        this.listener.c(this);
    }

    public void setDimensions(int i) {
        this.d = i;
        this.e = 2.147483647E9d;
        this.listener.c(this);
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.b = bitmapDescriptor;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: image can not be null");
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.f5809a = 2;
            this.c = latLng;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds != null) {
            this.f5809a = 1;
            this.h = latLngBounds;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
    }

    public void setTransparency(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.i = f;
            this.listener.c(this);
        }
    }

    public void setDimensions(int i, int i2) {
        this.d = i;
        this.e = i2;
        this.listener.c(this);
    }
}

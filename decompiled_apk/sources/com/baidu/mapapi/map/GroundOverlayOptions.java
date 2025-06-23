package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

/* loaded from: classes7.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    int f5810a;
    Bundle c;
    private BitmapDescriptor d;
    private LatLng e;
    private int f;
    private int g;
    private LatLngBounds j;
    private float h = 0.5f;
    private float i = 0.5f;
    private float k = 1.0f;
    private boolean l = false;
    boolean b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        LatLng latLng;
        int i;
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.M = this.b;
        groundOverlay.L = this.f5810a;
        groundOverlay.N = this.c;
        BitmapDescriptor bitmapDescriptor = this.d;
        if (bitmapDescriptor != null) {
            groundOverlay.b = bitmapDescriptor;
            LatLngBounds latLngBounds = this.j;
            if (latLngBounds == null && (latLng = this.e) != null) {
                int i2 = this.f;
                if (i2 > 0 && (i = this.g) > 0) {
                    groundOverlay.c = latLng;
                    groundOverlay.f = this.h;
                    groundOverlay.g = this.i;
                    groundOverlay.d = i2;
                    groundOverlay.e = i;
                    groundOverlay.f5809a = 2;
                } else {
                    throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
                }
            } else if (this.e == null && latLngBounds != null) {
                groundOverlay.h = latLngBounds;
                groundOverlay.f5809a = 1;
            } else {
                throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
            }
            groundOverlay.i = this.k;
            groundOverlay.j = this.l;
            return groundOverlay;
        }
        throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.h = f;
            this.i = f2;
        }
        return this;
    }

    public GroundOverlayOptions dimensions(int i) {
        this.f = i;
        this.g = Integer.MAX_VALUE;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public float getAnchorX() {
        return this.h;
    }

    public float getAnchorY() {
        return this.i;
    }

    public LatLngBounds getBounds() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getHeight() {
        int i = this.g;
        if (i == Integer.MAX_VALUE) {
            return (int) ((this.f * this.d.f5792a.getHeight()) / this.d.f5792a.getWidth());
        }
        return i;
    }

    public BitmapDescriptor getImage() {
        return this.d;
    }

    public LatLng getPosition() {
        return this.e;
    }

    public float getTransparency() {
        return this.k;
    }

    public int getWidth() {
        return this.f;
    }

    public int getZIndex() {
        return this.f5810a;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.d = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: image can not be null");
    }

    public boolean isVisible() {
        return this.b;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        if (latLng != null) {
            this.e = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds != null) {
            this.j = latLngBounds;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
    }

    public GroundOverlayOptions setClickable(boolean z) {
        this.l = z;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.k = f;
        }
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public GroundOverlayOptions zIndex(int i) {
        this.f5810a = i;
        return this;
    }

    public GroundOverlayOptions dimensions(int i, int i2) {
        this.f = i;
        this.g = i2;
        return this;
    }
}

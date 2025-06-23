package com.baidu.mapapi.map;

import java.util.List;

/* loaded from: classes7.dex */
public final class MultiPointOption extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private List<MultiPointItem> f5837a;
    private BitmapDescriptor b;
    private int c;
    private int d;
    private float e = 0.5f;
    private float f = 0.5f;
    private boolean g = true;
    private boolean h = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        MultiPoint multiPoint = new MultiPoint();
        multiPoint.b = this.b;
        List<MultiPointItem> list = this.f5837a;
        if (list != null) {
            multiPoint.f5835a = list;
            multiPoint.d = this.d;
            multiPoint.c = this.c;
            multiPoint.e = this.e;
            multiPoint.f = this.f;
            multiPoint.M = this.g;
            multiPoint.g = this.h;
            return multiPoint;
        }
        throw new IllegalStateException("BDMapSDKException: when you add mMultiPointItems, you must set the mMultiPointItems");
    }

    public float getAnchorX() {
        return this.e;
    }

    public float getAnchorY() {
        return this.f;
    }

    public BitmapDescriptor getIcon() {
        return this.b;
    }

    public List<MultiPointItem> getMultiPointItems() {
        return this.f5837a;
    }

    public int getPointSizeHeight() {
        return this.d;
    }

    public int getPointSizeWidth() {
        return this.c;
    }

    public boolean isVisible() {
        return this.g;
    }

    public MultiPointOption setAnchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.e = f;
            this.f = f2;
        }
        return this;
    }

    public MultiPointOption setClickable(boolean z) {
        this.h = z;
        return this;
    }

    public MultiPointOption setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            if (this.c == 0) {
                this.c = bitmapDescriptor.getBitmap().getWidth();
            }
            if (this.d == 0) {
                this.d = bitmapDescriptor.getBitmap().getHeight();
            }
            this.b = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: MultiPoint icon can not be null");
    }

    public MultiPointOption setMultiPointItems(List<MultiPointItem> list) {
        if (list != null) {
            if (!list.contains(null)) {
                this.f5837a = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
        }
        throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
    }

    public MultiPointOption setPointSize(int i, int i2) {
        if (this.c > 0 && this.d > 0) {
            this.c = i;
            this.d = i2;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
    }

    public MultiPointOption visible(boolean z) {
        this.g = z;
        return this;
    }
}

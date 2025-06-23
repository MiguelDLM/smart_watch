package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class MultiPoint extends Overlay {

    /* renamed from: a, reason: collision with root package name */
    List<MultiPointItem> f5835a;
    BitmapDescriptor b;
    int c;
    int d;
    float e;
    float f;
    boolean g = true;

    public MultiPoint() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.multiPoint;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        List<MultiPointItem> list = this.f5835a;
        if (list != null && list.size() > 0) {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f5835a.get(0).getPoint());
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f5835a.size(); i++) {
                MultiPointItem multiPointItem = this.f5835a.get(i);
                if (multiPointItem != null) {
                    arrayList.add(multiPointItem.getPoint());
                }
            }
            Overlay.a(arrayList, bundle);
        }
        BitmapDescriptor bitmapDescriptor = this.b;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.b());
        }
        bundle.putInt("isClickable", this.g ? 1 : 0);
        bundle.putFloat("anchor_x", this.e);
        bundle.putFloat("anchor_y", this.f);
        bundle.putFloat("pointsize_x", this.c);
        bundle.putFloat("pointsize_y", this.d);
        return bundle;
    }

    public void anchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.e = f;
            this.f = f2;
            this.listener.c(this);
        }
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
        return this.f5835a;
    }

    public int getPointSizeHeight() {
        return this.d;
    }

    public int getPointSizeWidth() {
        return this.c;
    }

    public boolean isClickable() {
        return this.g;
    }

    public void setClickable(boolean z) {
        this.g = z;
        this.listener.c(this);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.b = bitmapDescriptor;
            if (this.c == 0) {
                this.c = bitmapDescriptor.getBitmap().getWidth();
            }
            if (this.d == 0) {
                this.d = bitmapDescriptor.getBitmap().getHeight();
            }
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
    }

    public void setMultiPointItems(List<MultiPointItem> list) {
        if (list != null) {
            if (!list.contains(null)) {
                this.f5835a = list;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
        }
        throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
    }

    public void setPointSize(int i, int i2) {
        if (this.c > 0 && this.d > 0) {
            this.c = i;
            this.d = i2;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
    }
}

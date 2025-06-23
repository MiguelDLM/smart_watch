package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;

/* loaded from: classes7.dex */
public class Prism extends Overlay {
    float k;
    List<LatLng> l;
    int m = ViewCompat.MEASURED_STATE_MASK;
    int n = -16711936;
    BitmapDescriptor o;

    /* loaded from: classes7.dex */
    public enum AnimateType {
        AnimateSlow,
        AnimateNormal,
        AnimateFast
    }

    public Prism() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.prism;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        Overlay.c(this.m, bundle);
        Overlay.d(this.n, bundle);
        BitmapDescriptor bitmapDescriptor = this.o;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.b());
        }
        List<LatLng> list = this.l;
        if (list != null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(list.get(0));
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            Overlay.a(this.l, bundle);
            bundle.putDouble("m_height", this.k);
        }
        return bundle;
    }

    public BitmapDescriptor getCustomSideImage() {
        return this.o;
    }

    public float getHeight() {
        return this.k;
    }

    public List<LatLng> getPoints() {
        return this.l;
    }

    public int getSideFaceColor() {
        return this.n;
    }

    public int getTopFaceColor() {
        return this.m;
    }

    public void setCustomSideImage(BitmapDescriptor bitmapDescriptor) {
        this.o = bitmapDescriptor;
        this.listener.c(this);
    }

    public void setHeight(float f) {
        this.k = f;
        this.listener.c(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list != null) {
            if (list.size() > 3) {
                if (!list.contains(null)) {
                    int i = 0;
                    while (i < list.size()) {
                        int i2 = i + 1;
                        for (int i3 = i2; i3 < list.size(); i3++) {
                            if (list.get(i) == list.get(i3)) {
                                throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                            }
                        }
                        i = i2;
                    }
                    this.l = list;
                    this.listener.c(this);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than four");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public void setSideFaceColor(int i) {
        this.n = i;
        this.listener.c(this);
    }

    public void setTopFaceColor(int i) {
        this.m = i;
        this.listener.c(this);
    }
}

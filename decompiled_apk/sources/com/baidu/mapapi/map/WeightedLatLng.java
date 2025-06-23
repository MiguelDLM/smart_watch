package com.baidu.mapapi.map;

import XIXIX.OOXIXo;
import android.graphics.Point;
import com.baidu.mapapi.map.z;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public class WeightedLatLng extends z.a {
    public static final double DEFAULT_INTENSITY = 1.0d;

    /* renamed from: a, reason: collision with root package name */
    private Point f5875a;
    public final double intensity;
    public final LatLng mLatLng;

    public WeightedLatLng(LatLng latLng, double d) {
        if (latLng != null) {
            this.mLatLng = latLng;
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            this.f5875a = new Point((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6());
            if (d > OOXIXo.f3760XO) {
                this.intensity = d;
                return;
            } else {
                this.intensity = 1.0d;
                return;
            }
        }
        throw new IllegalArgumentException("BDMapSDKException: latLng can not be null");
    }

    public double getIntensity() {
        return this.intensity;
    }

    @Override // com.baidu.mapapi.map.z.a
    public Point getPoint() {
        return this.f5875a;
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }
}

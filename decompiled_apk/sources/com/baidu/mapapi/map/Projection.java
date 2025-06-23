package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.w;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public final class Projection {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.c f5859a;

    public Projection(com.baidu.mapsdkplatform.comapi.map.c cVar) {
        this.f5859a = cVar;
    }

    public LatLng fromScreenLocation(Point point) {
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        if (point != null && (cVar = this.f5859a) != null) {
            return CoordUtil.mc2ll(cVar.b(point.x, point.y));
        }
        return null;
    }

    public Point geoPoint3toScreenLocation(LatLng latLng, int i) {
        if (latLng != null && this.f5859a != null && i >= 0) {
            return this.f5859a.a(CoordUtil.ll2mc(latLng), i);
        }
        return null;
    }

    public float metersToEquatorPixels(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        return (float) (f / this.f5859a.L());
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng != null && mapStatus != null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            com.baidu.mapsdkplatform.comapi.map.w wVar = mapStatus.f5826a;
            return new PointF((float) (ll2mc.getLongitudeE6() - wVar.d), (float) (ll2mc.getLatitudeE6() - wVar.e));
        }
        return null;
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng != null && mapStatus != null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            w.a aVar = mapStatus.f5826a.k;
            return new PointF((float) ((((ll2mc.getLongitudeE6() - aVar.f6197a) * 2.0d) / Math.abs(aVar.b - aVar.f6197a)) - 1.0d), (float) ((((ll2mc.getLatitudeE6() - aVar.d) * 2.0d) / Math.abs(aVar.c - aVar.d)) - 1.0d));
        }
        return null;
    }

    public Point toScreenLocation(LatLng latLng) {
        if (latLng != null && this.f5859a != null) {
            return this.f5859a.a(CoordUtil.ll2mc(latLng));
        }
        return null;
    }
}

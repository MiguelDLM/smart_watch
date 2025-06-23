package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes7.dex */
public final class MapStatusUpdate {
    private static final String o = "MapStatusUpdate";

    /* renamed from: a, reason: collision with root package name */
    MapStatus f5828a;
    LatLng b;
    LatLngBounds c;
    int d;
    int e;
    float f;
    int g;
    int h;
    float i;
    Point j;
    int k = 0;
    int l = 0;
    int m = 0;
    int n = 0;
    private int p;

    private MapStatusUpdate() {
    }

    public MapStatus a(com.baidu.mapsdkplatform.comapi.map.c cVar, MapStatus mapStatus) {
        if (cVar == null || mapStatus == null) {
            return null;
        }
        switch (this.p) {
            case 1:
                return this.f5828a;
            case 2:
                return new MapStatus(mapStatus.rotate, this.b, mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, null);
            case 3:
                LatLngBounds latLngBounds = this.c;
                if (latLngBounds == null) {
                    return null;
                }
                GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
                GeoPoint ll2mc2 = CoordUtil.ll2mc(this.c.northeast);
                double longitudeE6 = ll2mc.getLongitudeE6();
                double latitudeE6 = ll2mc2.getLatitudeE6();
                double longitudeE62 = ll2mc2.getLongitudeE6();
                int latitudeE62 = (int) ll2mc.getLatitudeE6();
                WinRound winRound = mapStatus.f5826a.j;
                float a2 = cVar.a((int) longitudeE6, (int) latitudeE6, (int) longitudeE62, latitudeE62, winRound.right - winRound.left, winRound.bottom - winRound.top);
                return new MapStatus(mapStatus.rotate, this.c.getCenter(), mapStatus.overlook, a2, mapStatus.targetScreen, null);
            case 4:
                return new MapStatus(mapStatus.rotate, this.b, mapStatus.overlook, this.f, mapStatus.targetScreen, null);
            case 5:
                GeoPoint b = cVar.b((cVar.I() / 2) + this.g, (cVar.J() / 2) + this.h);
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(b), mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, b.getLongitudeE6(), b.getLatitudeE6(), null);
            case 6:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, mapStatus.zoom + this.i, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 7:
                Point point = this.j;
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(cVar.b(point.x, point.y)), mapStatus.overlook, mapStatus.zoom + this.i, this.j, null);
            case 8:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, this.f, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 9:
                LatLngBounds latLngBounds2 = this.c;
                if (latLngBounds2 == null) {
                    return null;
                }
                GeoPoint ll2mc3 = CoordUtil.ll2mc(latLngBounds2.southwest);
                GeoPoint ll2mc4 = CoordUtil.ll2mc(this.c.northeast);
                float a3 = cVar.a((int) ll2mc3.getLongitudeE6(), (int) ll2mc4.getLatitudeE6(), (int) ll2mc4.getLongitudeE6(), (int) ll2mc3.getLatitudeE6(), this.d, this.e);
                return new MapStatus(mapStatus.rotate, this.c.getCenter(), mapStatus.overlook, a3, mapStatus.targetScreen, null);
            case 10:
                if (this.c == null) {
                    return null;
                }
                int I = (cVar.I() - this.k) - this.m;
                if (I < 0) {
                    I = cVar.I();
                    Log.e(o, "Bound paddingLeft or paddingRight too larger, please check");
                }
                int J = (cVar.J() - this.l) - this.n;
                if (J < 0) {
                    J = cVar.J();
                    Log.e(o, "Bound paddingTop or paddingBottom too larger, please check");
                }
                float a4 = a(this.c, cVar, I, J);
                LatLng a5 = a(this.c, cVar, a(a4));
                if (a5 == null) {
                    Log.e(o, "Bound center error");
                    return null;
                }
                boolean a6 = a(this.c, cVar);
                boolean a7 = a(this.k, this.l, this.m, this.n, cVar);
                if (!a6 && !a7) {
                    if (cVar.G() != null) {
                        return cVar.G().f5828a;
                    }
                    return null;
                }
                MapStatus mapStatus2 = new MapStatus(mapStatus.rotate, a5, mapStatus.overlook, a4, null, null);
                cVar.a(a(mapStatus2));
                return mapStatus2;
            case 11:
                if (this.c == null) {
                    return null;
                }
                int I2 = (cVar.I() - this.k) - this.m;
                if (I2 < 0) {
                    I2 = cVar.I();
                    Log.e(o, "Bound paddingLeft or paddingRight too larger, please check");
                }
                int J2 = (cVar.J() - this.l) - this.n;
                if (J2 < 0) {
                    J2 = cVar.J();
                    Log.e(o, "Bound paddingTop or paddingBottom too larger, please check");
                }
                GeoPoint ll2mc5 = CoordUtil.ll2mc(this.c.southwest);
                GeoPoint ll2mc6 = CoordUtil.ll2mc(this.c.northeast);
                float a8 = cVar.a((int) ll2mc5.getLongitudeE6(), (int) ll2mc6.getLatitudeE6(), (int) ll2mc6.getLongitudeE6(), (int) ll2mc5.getLatitudeE6(), I2, J2);
                Point point2 = new Point(this.k + (I2 / 2), this.l + (J2 / 2));
                return new MapStatus(mapStatus.rotate, this.c.getCenter(), mapStatus.overlook, a8, point2, null);
            default:
                return null;
        }
    }

    public MapStatusUpdate(int i) {
        this.p = i;
    }

    private float a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.c cVar, int i, int i2) {
        GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.northeast);
        int longitudeE6 = (int) ll2mc.getLongitudeE6();
        int latitudeE6 = (int) ll2mc.getLatitudeE6();
        return cVar.a(longitudeE6, (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), latitudeE6, i, i2);
    }

    private boolean a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.c cVar) {
        MapStatusUpdate G = cVar.G();
        if (G == null) {
            return true;
        }
        LatLng latLng = latLngBounds.southwest;
        double d = latLng.latitude;
        double d2 = latLng.longitude;
        LatLng latLng2 = latLngBounds.northeast;
        double d3 = latLng2.latitude;
        double d4 = latLng2.longitude;
        LatLngBounds latLngBounds2 = G.c;
        LatLng latLng3 = latLngBounds2.southwest;
        double d5 = latLng3.latitude;
        double d6 = latLng3.longitude;
        LatLng latLng4 = latLngBounds2.northeast;
        return (d == d5 && d2 == d6 && d3 == latLng4.latitude && d4 == latLng4.longitude) ? false : true;
    }

    private boolean a(int i, int i2, int i3, int i4, com.baidu.mapsdkplatform.comapi.map.c cVar) {
        MapStatusUpdate G = cVar.G();
        return (G != null && i == G.k && i2 == G.l && i3 == G.m && i4 == G.n) ? false : true;
    }

    private LatLng a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.c cVar, float f) {
        double longitudeE6;
        double latitudeE6;
        double latitudeE62;
        if (latLngBounds == null || cVar == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.getCenter());
        int i = this.k;
        double d = i * f;
        int i2 = this.m;
        double d2 = i2 * f;
        double d3 = this.l * f;
        double d4 = this.n * f;
        if (i > i2) {
            longitudeE6 = ll2mc.getLongitudeE6() - ((d - d2) / 2.0d);
        } else if (i < i2) {
            longitudeE6 = ll2mc.getLongitudeE6() + ((d2 - d) / 2.0d);
        } else {
            longitudeE6 = ll2mc.getLongitudeE6();
        }
        int i3 = this.l;
        int i4 = this.n;
        if (i3 < i4) {
            latitudeE62 = ll2mc.getLatitudeE6() - ((d4 - d3) / 2.0d);
        } else if (i3 > i4) {
            latitudeE62 = ll2mc.getLatitudeE6();
            d3 -= d4;
        } else {
            latitudeE6 = ll2mc.getLatitudeE6();
            return CoordUtil.mc2ll(new GeoPoint(latitudeE6, longitudeE6));
        }
        latitudeE6 = latitudeE62 + (d3 / 2.0d);
        return CoordUtil.mc2ll(new GeoPoint(latitudeE6, longitudeE6));
    }

    private MapStatusUpdate a(MapStatus mapStatus) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate();
        synchronized (this) {
            mapStatusUpdate.f5828a = mapStatus;
            mapStatusUpdate.c = this.c;
            mapStatusUpdate.k = this.k;
            mapStatusUpdate.l = this.l;
            mapStatusUpdate.m = this.m;
            mapStatusUpdate.n = this.n;
        }
        return mapStatusUpdate;
    }

    private float a(float f) {
        return (float) (Math.pow(2.0d, 18.0f - f) / (SysOSUtil.getDensityDpi() / 310.0f));
    }
}

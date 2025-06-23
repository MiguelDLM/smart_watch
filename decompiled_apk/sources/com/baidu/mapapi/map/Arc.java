package com.baidu.mapapi.map;

import XIXIX.OOXIXo;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmArc;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class Arc extends Overlay {
    private static final String n = "Arc";

    /* renamed from: a, reason: collision with root package name */
    int f5784a;
    int b;
    LatLng c;
    LatLng d;
    LatLng e;
    boolean f = true;
    double g;
    double h;
    double i;
    boolean j;
    com.baidu.platform.comapi.bmsdk.b k;
    LatLng l;
    BmLineStyle m;
    private BmArc o;

    public Arc() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.arc;
    }

    private void a(double d, double d2, double d3) {
        if (d < d2) {
            if (d >= d3) {
                if (d <= d3 || d2 < d3 || d2 <= d3) {
                    return;
                }
                this.h = d;
                this.i = d3 + 6.283185307179586d;
                this.j = false;
                return;
            }
            if (d2 < d3) {
                this.h = d;
                this.i = d3;
                this.j = false;
                return;
            } else {
                if (d2 > d3) {
                    this.h = d3;
                    this.i = d + 6.283185307179586d;
                    this.j = false;
                    return;
                }
                return;
            }
        }
        if (d > d2) {
            if (d < d3) {
                if (d2 < d3) {
                    this.h = d3;
                    this.i = d + 6.283185307179586d;
                    this.j = false;
                    return;
                }
                return;
            }
            if (d > d3) {
                if (d2 < d3) {
                    this.h = d;
                    this.i = d3 + 6.283185307179586d;
                    this.j = false;
                } else if (d2 > d3) {
                    this.h = d3;
                    this.i = d;
                    this.j = false;
                }
            }
        }
    }

    private void b() {
        LatLng latLng = this.c;
        if (latLng == null && this.d == null && this.e == null) {
            return;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(this.d);
        GeoPoint ll2mc3 = CoordUtil.ll2mc(this.e);
        GeoPoint a2 = a(ll2mc.getLongitudeE6(), ll2mc.getLatitudeE6(), ll2mc2.getLongitudeE6(), ll2mc2.getLatitudeE6(), ll2mc3.getLongitudeE6(), ll2mc3.getLatitudeE6());
        this.k = new com.baidu.platform.comapi.bmsdk.b(a2.getLongitudeE6(), a2.getLatitudeE6());
        this.g = a(ll2mc, a2);
        a(b(ll2mc, a2), b(ll2mc2, a2), b(ll2mc3, a2));
    }

    public BmArc getBmArc() {
        return this.o;
    }

    public int getColor() {
        return this.f5784a;
    }

    public LatLng getEndPoint() {
        return this.e;
    }

    public LatLng getMiddlePoint() {
        return this.d;
    }

    public LatLng getStartPoint() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public boolean isClickable() {
        return this.f;
    }

    public void setClickable(boolean z) {
        this.f = z;
        this.listener.c(this);
    }

    public void setColor(int i) {
        this.f5784a = i;
        this.listener.c(this);
    }

    public void setPoints(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng != null && latLng2 != null && latLng3 != null) {
            if (latLng != latLng2 && latLng != latLng3 && latLng2 != latLng3) {
                this.c = latLng;
                this.d = latLng2;
                this.e = latLng3;
                this.listener.c(this);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
        }
        throw new IllegalArgumentException("BDMapSDKException:start and middle and end points can not be null");
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.b = i;
            this.listener.c(this);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmArc bmArc = new BmArc();
        this.o = bmArc;
        bmArc.a(this);
        setDrawItem(this.o);
        super.toDrawItem();
        BmLineStyle bmLineStyle = new BmLineStyle();
        this.m = bmLineStyle;
        bmLineStyle.b(this.b);
        this.m.a(this.f5784a);
        this.o.a(this.m);
        if (this.c != null && this.d != null && this.e != null) {
            b();
        } else {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.l);
            if (ll2mc != null) {
                this.k = new com.baidu.platform.comapi.bmsdk.b(ll2mc.getLongitudeE6(), ll2mc.getLatitudeE6());
            }
        }
        this.o.a(this.k);
        this.o.a(this.j);
        this.o.c(this.i);
        this.o.b(this.h);
        this.o.a(this.g);
        this.o.b(this.f);
        return this.o;
    }

    private double b(GeoPoint geoPoint, GeoPoint geoPoint2) {
        double latitudeE6 = geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6();
        double longitudeE6 = geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6();
        if (longitudeE6 == OOXIXo.f3760XO) {
            longitudeE6 = 1.0E-5d;
        }
        if (latitudeE6 == OOXIXo.f3760XO) {
            latitudeE6 = 1.0E-5d;
        }
        double atan = Math.atan(latitudeE6 / longitudeE6);
        return (longitudeE6 <= OOXIXo.f3760XO || latitudeE6 <= OOXIXo.f3760XO) ? ((longitudeE6 >= OOXIXo.f3760XO || latitudeE6 <= OOXIXo.f3760XO) && (longitudeE6 >= OOXIXo.f3760XO || latitudeE6 >= OOXIXo.f3760XO)) ? atan + 6.283185307179586d : atan + 3.141592653589793d : atan * 1.0d;
    }

    private double a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        double longitudeE6 = geoPoint.getLongitudeE6();
        double latitudeE6 = geoPoint.getLatitudeE6();
        double longitudeE62 = longitudeE6 - geoPoint2.getLongitudeE6();
        double latitudeE62 = latitudeE6 - geoPoint2.getLatitudeE6();
        return Math.sqrt((longitudeE62 * longitudeE62) + (latitudeE62 * latitudeE62));
    }

    private GeoPoint a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7;
        double d8 = (d + d3) / 2.0d;
        double d9 = (d2 + d4) / 2.0d;
        double d10 = (d3 + d5) / 2.0d;
        double d11 = (d4 + d6) / 2.0d;
        double d12 = d4 - d2;
        if (d12 == OOXIXo.f3760XO) {
            double d13 = d6 - d4;
            if (d13 == OOXIXo.f3760XO) {
                return null;
            }
            d7 = ((((d5 - d3) * (-1.0d)) / d13) * (d8 - d10)) + d11;
        } else {
            double d14 = ((d3 - d) * (-1.0d)) / d12;
            double d15 = d6 - d4;
            if (d15 == OOXIXo.f3760XO) {
                d7 = d9 + (d14 * (d10 - d8));
                d8 = d10;
            } else {
                double d16 = ((d5 - d3) * (-1.0d)) / d15;
                if (d14 == d16) {
                    return null;
                }
                double d17 = (((d11 - d9) + (d14 * d8)) - (d10 * d16)) / (d14 - d16);
                d7 = d9 + (d14 * (d17 - d8));
                d8 = d17;
            }
        }
        return new GeoPoint(d7, d8);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(this.c);
        arrayList.add(this.d);
        arrayList.add(this.e);
        GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.b);
        Overlay.a(arrayList, bundle);
        Overlay.a(this.f5784a, bundle);
        bundle.putInt("isClickable", this.f ? 1 : 0);
        return bundle;
    }
}

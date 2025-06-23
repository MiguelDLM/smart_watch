package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmPolygon;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class Polygon extends Overlay {

    /* renamed from: a, reason: collision with root package name */
    Stroke f5847a;
    BmSurfaceStyle c;
    BmLineStyle d;
    BmGeoElement f;
    BmGeoElement g;
    int i;
    List<LatLng> j;
    List<HoleOptions> k;
    HoleOptions l;
    boolean m;
    String q;
    EncodePointType r;
    BmPolygon s;
    boolean b = false;
    int e = PolylineDottedLineType.DOTTED_LINE_SQUARE.ordinal();
    List<BmGeoElement> h = new ArrayList();
    boolean n = false;
    boolean o = false;
    int p = -1;

    public Polygon() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.polygon;
    }

    private void b(Bundle bundle) {
        String str;
        if (this.e == 1) {
            str = "CircleDashTexture.png";
        } else {
            str = "lineDashTexture.png";
        }
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
        if (fromAsset != null) {
            bundle.putBundle("image_info", fromAsset.b());
        }
    }

    private void c(List<HoleOptions> list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        boolean b = Overlay.b(list, bundle2);
        bundle.putInt("has_holes", b ? 1 : 0);
        if (b) {
            bundle.putBundle("holes", bundle2);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.m) {
            bundle.putInt("has_dotted_stroke", 1);
            b(bundle);
        } else {
            bundle.putInt("has_dotted_stroke", 0);
        }
        String str = this.q;
        if (str != null && str.length() > 0 && this.r != null) {
            bundle.putString("encodedPoints", this.q);
            bundle.putInt("encodePointType", this.r.ordinal());
        } else {
            List<LatLng> list = this.j;
            if (list != null) {
                GeoPoint ll2mc = CoordUtil.ll2mc(list.get(0));
                bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                Overlay.a(this.j, bundle);
                if (this.m) {
                    bundle.putDouble("dotted_stroke_location_x", ll2mc.getLongitudeE6());
                    bundle.putDouble("dotted_stroke_location_y", ll2mc.getLatitudeE6());
                }
            }
        }
        Overlay.a(this.i, bundle);
        if (this.f5847a == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f5847a.a(new Bundle()));
        }
        List<HoleOptions> list2 = this.k;
        if (list2 != null && list2.size() != 0) {
            c(this.k, bundle);
            bundle.putInt("holes_count", this.k.size());
        } else if (this.l != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.l);
            c((List<HoleOptions>) arrayList, bundle);
            bundle.putInt("holes_count", 1);
        } else {
            bundle.putInt("has_holes", 0);
        }
        bundle.putInt("isClickable", this.n ? 1 : 0);
        bundle.putInt("isHoleClickable", this.o ? 1 : 0);
        return bundle;
    }

    public String getEncodedPoint() {
        return this.q;
    }

    public int getFillColor() {
        return this.i;
    }

    public BmGeoElement getGeoElement() {
        BmGeoElement bmGeoElement = this.f;
        if (bmGeoElement == null) {
            return null;
        }
        return bmGeoElement;
    }

    public int getHoleClickedIndex() {
        return this.p;
    }

    public HoleOptions getHoleOption() {
        return this.l;
    }

    public List<HoleOptions> getHoleOptions() {
        return this.k;
    }

    public EncodePointType getPointType() {
        return this.r;
    }

    public List<LatLng> getPoints() {
        return this.j;
    }

    public Stroke getStroke() {
        return this.f5847a;
    }

    public boolean isClickable() {
        return this.n;
    }

    public void setClickable(boolean z) {
        this.n = z;
        this.listener.c(this);
    }

    public void setEncodeInfo(String str, EncodePointType encodePointType) {
        this.q = str;
        this.r = encodePointType;
        this.listener.c(this);
    }

    public void setFillColor(int i) {
        this.i = i;
        this.listener.c(this);
    }

    public void setHoleClickable(boolean z) {
        this.o = z;
        this.listener.c(this);
    }

    public void setHoleOption(HoleOptions holeOptions) {
        if (holeOptions == null) {
            return;
        }
        this.l = holeOptions;
        this.k = null;
        this.listener.c(this);
    }

    public void setHoleOptions(List<HoleOptions> list) {
        this.k = list;
        this.l = null;
        this.listener.c(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list != null) {
            if (list.size() > 2) {
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
                    this.j = list;
                    this.listener.c(this);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public void setStroke(Stroke stroke) {
        this.f5847a = stroke;
        this.b = true;
        this.listener.c(this);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmPolygon bmPolygon = new BmPolygon();
        this.s = bmPolygon;
        bmPolygon.a(this);
        setDrawItem(this.s);
        super.toDrawItem();
        BmLineStyle bmLineStyle = new BmLineStyle();
        this.d = bmLineStyle;
        Stroke stroke = this.f5847a;
        if (stroke != null) {
            bmLineStyle.b(stroke.strokeWidth);
            this.d.a(this.f5847a.color);
            if (this.m) {
                setDottedBitmapResource(this.d, this.e);
                this.d.c(5);
            } else {
                this.d.d(0);
            }
        }
        BmGeoElement bmGeoElement = new BmGeoElement();
        this.f = bmGeoElement;
        bmGeoElement.a(this.d);
        ArrayList arrayList = new ArrayList();
        String str = this.q;
        if (str != null && str.length() > 0 && this.r != null) {
            this.f.a(this.q);
            this.f.a(this.r.ordinal());
        } else {
            List<LatLng> list = this.j;
            if (list != null) {
                Overlay.mcLocation = CoordUtil.ll2mc(list.get(0));
                Iterator<LatLng> it = this.j.iterator();
                while (it.hasNext()) {
                    GeoPoint ll2mc = CoordUtil.ll2mc(it.next());
                    arrayList.add(new com.baidu.platform.comapi.bmsdk.b(ll2mc.getLongitudeE6(), ll2mc.getLatitudeE6()));
                }
                this.f.a(arrayList);
                this.s.a(this.f);
            }
        }
        List<HoleOptions> list2 = this.k;
        if (list2 != null && list2.size() != 0) {
            List<List<com.baidu.platform.comapi.bmsdk.b>> holeInfo2BmGeo = Overlay.holeInfo2BmGeo(this.k);
            for (int i = 0; i < holeInfo2BmGeo.size(); i++) {
                BmGeoElement bmGeoElement2 = new BmGeoElement();
                bmGeoElement2.a(holeInfo2BmGeo.get(i));
                this.h.add(bmGeoElement2);
                this.s.b(bmGeoElement2);
            }
        } else if (this.l != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.l);
            List<com.baidu.platform.comapi.bmsdk.b> list3 = Overlay.holeInfo2BmGeo(arrayList2).get(0);
            BmGeoElement bmGeoElement3 = new BmGeoElement();
            this.g = bmGeoElement3;
            bmGeoElement3.a(list3);
            this.s.b(this.g);
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        this.c = bmSurfaceStyle;
        bmSurfaceStyle.a(this.i);
        this.s.a(this.c);
        this.s.a(4096);
        this.s.b(this.n);
        this.s.c(this.o);
        return this.s;
    }
}

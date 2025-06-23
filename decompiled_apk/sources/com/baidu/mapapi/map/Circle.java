package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmCircle;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class Circle extends Overlay {

    /* renamed from: a, reason: collision with root package name */
    LatLng f5797a;
    int b;
    int c;
    Stroke d;
    boolean e;
    List<HoleOptions> f;
    HoleOptions g;
    boolean h;
    int q;
    int r;
    private BmCircle u;
    boolean i = false;
    boolean j = false;
    int k = -1;
    List<Integer> l = new ArrayList();
    int m = 1;
    BmLineStyle n = new BmLineStyle();
    int o = PolylineDottedLineType.DOTTED_LINE_SQUARE.ordinal();
    BmSurfaceStyle p = new BmSurfaceStyle();
    float s = 0.5f;
    float t = 0.2f;

    public Circle() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.circle;
    }

    private void b(Bundle bundle) {
        String str;
        if (this.o == 1) {
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
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f5797a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        if (this.h) {
            bundle.putInt("m_isGradientCircle", 1);
            Overlay.e(this.q, bundle);
            Overlay.f(this.r, bundle);
            bundle.putFloat("m_color_weight", this.t);
            bundle.putFloat("m_radius_weight", this.s);
        } else {
            bundle.putInt("m_isGradientCircle", 0);
        }
        if (this.e) {
            bundle.putDouble("dotted_stroke_location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("dotted_stroke_location_y", ll2mc.getLatitudeE6());
            bundle.putInt("has_dotted_stroke", 1);
            b(bundle);
        } else {
            bundle.putInt("has_dotted_stroke", 0);
        }
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f5797a, this.c));
        Overlay.a(this.b, bundle);
        if (this.d == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.d.a(new Bundle()));
        }
        List<HoleOptions> list = this.f;
        if (list != null && list.size() != 0) {
            c(this.f, bundle);
            bundle.putInt("holes_count", this.f.size());
        } else if (this.g != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.g);
            c((List<HoleOptions>) arrayList, bundle);
            bundle.putInt("holes_count", 1);
        } else {
            bundle.putInt("has_holes", 0);
        }
        bundle.putInt("isClickable", this.i ? 1 : 0);
        bundle.putInt("isHoleClickable", this.j ? 1 : 0);
        return bundle;
    }

    public LatLng getCenter() {
        return this.f5797a;
    }

    public int getCenterColor() {
        return this.q;
    }

    public float getColorWeight() {
        return this.t;
    }

    public int getDottedStrokeType() {
        return this.o;
    }

    public int getFillColor() {
        return this.b;
    }

    public int getHoleClickedIndex() {
        return this.k;
    }

    public HoleOptions getHoleOption() {
        return this.g;
    }

    public List<HoleOptions> getHoleOptions() {
        return this.f;
    }

    public int getRadius() {
        return this.c;
    }

    public float getRadiusWeight() {
        return this.s;
    }

    public int getSideColor() {
        return this.r;
    }

    public Stroke getStroke() {
        return this.d;
    }

    public boolean isClickable() {
        return this.i;
    }

    public boolean isDottedStroke() {
        return this.e;
    }

    public boolean isIsGradientCircle() {
        return this.h;
    }

    public void setCenter(LatLng latLng) {
        if (latLng != null) {
            this.f5797a = latLng;
            Overlay.mcLocation = CoordUtil.ll2mc(latLng);
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
    }

    public void setCenterColor(int i) {
        this.q = i;
        this.listener.c(this);
    }

    public void setClickable(boolean z) {
        this.i = z;
        this.listener.c(this);
    }

    public void setColorWeight(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.t = f;
            this.listener.c(this);
        }
    }

    public void setDottedStroke(boolean z) {
        this.e = z;
        this.listener.c(this);
    }

    public void setDottedStrokeType(CircleDottedStrokeType circleDottedStrokeType) {
        this.o = circleDottedStrokeType.ordinal();
        this.listener.c(this);
    }

    public void setFillColor(int i) {
        this.b = i;
        this.listener.c(this);
    }

    public void setHoleClickable(boolean z) {
        this.j = z;
        this.listener.c(this);
    }

    public void setHoleOption(HoleOptions holeOptions) {
        if (holeOptions == null) {
            return;
        }
        this.g = holeOptions;
        this.f = null;
        this.listener.c(this);
    }

    public void setHoleOptions(List<HoleOptions> list) {
        if (list != null && list.size() != 0) {
            this.f = list;
            this.g = null;
            this.listener.c(this);
        }
    }

    public void setIsGradientCircle(boolean z) {
        this.h = z;
        this.listener.c(this);
    }

    public void setRadius(int i) {
        this.c = i;
        this.listener.c(this);
    }

    public void setRadiusWeight(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.s = f;
            this.listener.c(this);
        }
    }

    public void setSideColor(int i) {
        this.r = i;
        this.listener.c(this);
    }

    public void setStroke(Stroke stroke) {
        this.d = stroke;
        this.listener.c(this);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmCircle bmCircle = new BmCircle();
        this.u = bmCircle;
        bmCircle.a(this);
        setDrawItem(this.u);
        super.toDrawItem();
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f5797a);
        Overlay.mcLocation = ll2mc;
        this.u.a(new com.baidu.platform.comapi.bmsdk.b(ll2mc.getLongitudeE6(), Overlay.mcLocation.getLatitudeE6()));
        this.u.a(CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f5797a, this.c));
        BmLineStyle bmLineStyle = new BmLineStyle();
        this.n = bmLineStyle;
        Stroke stroke = this.d;
        if (stroke != null) {
            bmLineStyle.b(stroke.strokeWidth);
            this.n.a(this.d.color);
            if (this.e) {
                setDottedBitmapResource(this.n, this.o);
                this.n.c(5);
            } else {
                this.n.d(0);
            }
            this.u.a(this.n);
        }
        this.p.a(this.b);
        this.u.a(this.p);
        List<HoleOptions> list = this.f;
        if (list != null && list.size() != 0) {
            List<List<com.baidu.platform.comapi.bmsdk.b>> holeInfo2BmGeo = Overlay.holeInfo2BmGeo(this.f);
            for (int i = 0; i < holeInfo2BmGeo.size(); i++) {
                BmGeoElement bmGeoElement = new BmGeoElement();
                bmGeoElement.a(holeInfo2BmGeo.get(i));
                this.u.a(bmGeoElement);
            }
        } else if (this.g != null) {
            BmGeoElement bmGeoElement2 = new BmGeoElement();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.g);
            bmGeoElement2.a(Overlay.holeInfo2BmGeo(arrayList).get(0));
            this.u.a(bmGeoElement2);
        }
        this.u.c(this.j);
        this.u.b(this.i);
        boolean z = this.h;
        if (z) {
            this.u.a(z);
            this.u.b(this.t);
            this.u.a(this.s);
            this.l.add(Integer.valueOf(this.q));
            this.l.add(Integer.valueOf(this.r));
            this.u.a(this.m, this.l);
        }
        return this.u;
    }
}

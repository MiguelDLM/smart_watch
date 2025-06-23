package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* loaded from: classes7.dex */
public final class PolygonOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    int f5849a;
    Bundle c;
    private Stroke d;
    private List<LatLng> f;
    private List<HoleOptions> g;
    private HoleOptions h;
    private String j;
    private EncodePointType k;
    private int e = ViewCompat.MEASURED_STATE_MASK;
    private boolean i = false;
    private int l = 0;
    private boolean m = false;
    boolean b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polygon polygon = new Polygon();
        polygon.M = this.b;
        polygon.L = this.f5849a;
        polygon.N = this.c;
        List<LatLng> list = this.f;
        if (list == null || list.size() < 2) {
            String str = this.j;
            if (str != null && str.length() > 0) {
                polygon.q = this.j;
                polygon.r = this.k;
            } else {
                throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
            }
        }
        polygon.j = this.f;
        polygon.i = this.e;
        polygon.f5847a = this.d;
        polygon.k = this.g;
        polygon.l = this.h;
        polygon.m = this.i;
        polygon.e = this.l;
        polygon.n = this.m;
        return polygon;
    }

    public PolygonOptions addHoleOption(HoleOptions holeOptions) {
        this.h = holeOptions;
        return this;
    }

    public PolygonOptions addHoleOptions(List<HoleOptions> list) {
        this.g = list;
        return this;
    }

    public PolygonOptions dottedStroke(boolean z) {
        this.i = z;
        return this;
    }

    public PolygonOptions dottedStrokeType(PolylineDottedLineType polylineDottedLineType) {
        this.l = polylineDottedLineType.ordinal();
        return this;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.e = i;
        return this;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getFillColor() {
        return this.e;
    }

    public List<LatLng> getPoints() {
        return this.f;
    }

    public Stroke getStroke() {
        return this.d;
    }

    public int getZIndex() {
        return this.f5849a;
    }

    public boolean isVisible() {
        return this.b;
    }

    public PolygonOptions points(String str, EncodePointType encodePointType) {
        this.j = str;
        this.k = encodePointType;
        return this;
    }

    public PolygonOptions setClickable(boolean z) {
        this.m = z;
        return this;
    }

    public PolygonOptions stroke(Stroke stroke) {
        this.d = stroke;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public PolygonOptions zIndex(int i) {
        this.f5849a = i;
        return this;
    }

    public PolygonOptions points(List<LatLng> list) {
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
                    this.f = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }
}

package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class PolylineOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    int f5852a;
    Bundle c;
    private List<LatLng> e;
    private List<Integer> f;
    private List<Integer> g;
    private BitmapDescriptor i;
    private List<BitmapDescriptor> j;
    private int y;
    private int z;
    private int d = ViewCompat.MEASURED_STATE_MASK;
    private int h = 5;
    private boolean k = true;
    private boolean l = false;
    boolean b = true;
    private boolean m = false;
    private boolean n = true;
    private int o = 0;
    private LineJoinType p = LineJoinType.LineJoinRound;
    private LineCapType q = LineCapType.LineCapButt;
    private boolean r = true;
    private boolean s = false;
    private boolean t = false;
    private LineDirectionCross180 u = LineDirectionCross180.NONE;
    private LineBloomType v = LineBloomType.NONE;
    private float w = 5.0f;
    private int x = 1;

    /* loaded from: classes7.dex */
    public enum LineBloomType {
        NONE,
        GradientA,
        BLUR
    }

    /* loaded from: classes7.dex */
    public enum LineCapType {
        LineCapButt,
        LineCapRound
    }

    /* loaded from: classes7.dex */
    public enum LineDirectionCross180 {
        NONE,
        FROM_EAST_TO_WEST,
        FROM_WEST_TO_EAST
    }

    /* loaded from: classes7.dex */
    public enum LineJoinType {
        LineJoinBevel,
        LineJoinMiter,
        LineJoinRound,
        LineJoinBerzier
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polyline polyline = new Polyline();
        List<LatLng> list = this.e;
        if (list != null && list.size() >= 2) {
            polyline.x = this.v;
            polyline.q = this.y;
            polyline.r = this.z;
            polyline.s = this.w;
            polyline.t = this.x;
            boolean z = this.t;
            if (z) {
                polyline.type = com.baidu.mapsdkplatform.comapi.map.h.gradientLine;
                return a(polyline);
            }
            polyline.M = this.b;
            polyline.g = this.m;
            polyline.L = this.f5852a;
            polyline.N = this.c;
            polyline.b = this.e;
            polyline.f5850a = this.d;
            polyline.f = this.h;
            polyline.k = this.i;
            polyline.l = this.j;
            polyline.h = this.k;
            polyline.i = this.l;
            polyline.j = this.n;
            polyline.n = this.r;
            polyline.o = this.s;
            polyline.p = z;
            polyline.m = this.o;
            polyline.v = this.p;
            polyline.u = this.q;
            polyline.w = this.u;
            List<Integer> list2 = this.f;
            if (list2 != null && list2.size() < this.e.size() - 1) {
                ArrayList arrayList = new ArrayList((this.e.size() - 1) - this.f.size());
                List<Integer> list3 = this.f;
                list3.addAll(list3.size(), arrayList);
            }
            List<Integer> list4 = this.f;
            int i = 0;
            if (list4 != null && list4.size() > 0) {
                int[] iArr = new int[this.f.size()];
                Iterator<Integer> it = this.f.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    iArr[i2] = it.next().intValue();
                    i2++;
                }
                polyline.c = iArr;
            }
            List<Integer> list5 = this.g;
            if (list5 != null && list5.size() < this.e.size() - 1) {
                ArrayList arrayList2 = new ArrayList((this.e.size() - 1) - this.g.size());
                List<Integer> list6 = this.g;
                list6.addAll(list6.size(), arrayList2);
            }
            List<Integer> list7 = this.g;
            if (list7 != null && list7.size() > 0) {
                int[] iArr2 = new int[this.g.size()];
                Iterator<Integer> it2 = this.g.iterator();
                while (it2.hasNext()) {
                    iArr2[i] = it2.next().intValue();
                    i++;
                }
                polyline.d = iArr2;
            }
            return polyline;
        }
        throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
    }

    public PolylineOptions bloomAlpha(int i) {
        if (i > 255 || i < 0) {
            i = 255;
        }
        this.z = i;
        return this;
    }

    public PolylineOptions bloomType(LineBloomType lineBloomType) {
        this.v = lineBloomType;
        return this;
    }

    public PolylineOptions bloomWidth(int i) {
        if (i < 0) {
            i = 0;
        }
        this.y = i;
        return this;
    }

    public PolylineOptions clickable(boolean z) {
        this.n = z;
        return this;
    }

    public PolylineOptions color(int i) {
        this.d = i;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list != null) {
            if (!list.contains(null)) {
                this.g = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
        }
        throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        this.i = bitmapDescriptor;
        return this;
    }

    public PolylineOptions customTextureList(List<BitmapDescriptor> list) {
        if (list != null) {
            if (list.size() == 0) {
                Log.e("baidumapsdk", "custom texture list is empty,the texture will not work");
            }
            Iterator<BitmapDescriptor> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    Log.e("baidumapsdk", "the custom texture item is null,it will be discard");
                }
            }
            this.j = list;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: customTexture list can not be null");
    }

    public PolylineOptions dottedLine(boolean z) {
        this.m = z;
        return this;
    }

    public PolylineOptions dottedLineType(PolylineDottedLineType polylineDottedLineType) {
        this.o = polylineDottedLineType.ordinal();
        return this;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z) {
        this.k = z;
        return this;
    }

    public int getColor() {
        return this.d;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.i;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public List<LatLng> getPoints() {
        return this.e;
    }

    public List<Integer> getTextureIndexs() {
        return this.f;
    }

    public int getWidth() {
        return this.h;
    }

    public int getZIndex() {
        return this.f5852a;
    }

    public boolean isDottedLine() {
        return this.m;
    }

    public boolean isFocus() {
        return this.k;
    }

    public PolylineOptions isGeodesic(boolean z) {
        this.s = z;
        return this;
    }

    public PolylineOptions isGradient(boolean z) {
        this.t = z;
        return this;
    }

    public PolylineOptions isThined(boolean z) {
        this.r = z;
        return this;
    }

    public boolean isVisible() {
        return this.b;
    }

    public PolylineOptions keepScale(boolean z) {
        this.l = z;
        return this;
    }

    public PolylineOptions lineCapType(LineCapType lineCapType) {
        this.q = lineCapType;
        return this;
    }

    public PolylineOptions lineDirectionCross180(LineDirectionCross180 lineDirectionCross180) {
        this.u = lineDirectionCross180;
        return this;
    }

    public PolylineOptions lineJoinType(LineJoinType lineJoinType) {
        this.p = lineJoinType;
        return this;
    }

    public PolylineOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() >= 2) {
                if (!list.contains(null)) {
                    this.e = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public PolylineOptions setBloomBlurTimes(int i) {
        if (i < 1) {
            i = 1;
        }
        if (i > 10) {
            i = 10;
        }
        this.x = i;
        return this;
    }

    public PolylineOptions setBloomGradientASpeed(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.w = f;
        return this;
    }

    public PolylineOptions textureIndex(List<Integer> list) {
        if (list != null) {
            if (!list.contains(null)) {
                this.f = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: index list can not contains null");
        }
        throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
    }

    public PolylineOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public PolylineOptions width(int i) {
        if (i > 0) {
            this.h = i;
        }
        return this;
    }

    public PolylineOptions zIndex(int i) {
        this.f5852a = i;
        return this;
    }

    private Polyline a(Polyline polyline) {
        polyline.M = this.b;
        polyline.w = this.u;
        polyline.b = this.e;
        polyline.f = this.h;
        polyline.p = this.t;
        List<Integer> list = this.g;
        if (list != null && list.size() != 0) {
            List<LatLng> list2 = this.e;
            if (list2 != null && list2.size() != 0) {
                int[] iArr = new int[this.g.size()];
                Iterator<Integer> it = this.g.iterator();
                int i = 0;
                while (it.hasNext()) {
                    iArr[i] = it.next().intValue();
                    i++;
                }
                polyline.d = iArr;
                return polyline;
            }
            throw new IllegalStateException("BDMapSDKException: mPoints array can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: colors array can not be null");
    }
}

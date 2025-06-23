package com.baidu.mapapi.map;

import XIXIX.OOXIXo;
import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmBaseLine;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmGradientLine;
import com.baidu.platform.comapi.bmsdk.BmPolyline;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class Polyline extends Overlay {
    private BmGeoElement A;

    /* renamed from: a, reason: collision with root package name */
    int f5850a;
    List<LatLng> b;
    int[] c;
    int[] d;
    List<Integer> e;
    BitmapDescriptor k;
    List<BitmapDescriptor> l;
    int q;
    int r;
    private BmBaseLine y;
    private BmLineStyle z;
    int f = 5;
    boolean g = false;
    boolean h = false;
    boolean i = true;
    boolean j = true;
    int m = 0;
    boolean n = true;
    boolean o = false;
    boolean p = false;
    float s = 5.0f;
    int t = 1;
    PolylineOptions.LineCapType u = PolylineOptions.LineCapType.LineCapButt;
    PolylineOptions.LineJoinType v = PolylineOptions.LineJoinType.LineJoinRound;
    PolylineOptions.LineDirectionCross180 w = PolylineOptions.LineDirectionCross180.NONE;
    PolylineOptions.LineBloomType x = PolylineOptions.LineBloomType.NONE;

    public Polyline() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.polyline;
    }

    private static void a(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("traffic_array", iArr);
    }

    private static void b(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
        bundle.putInt("total", 1);
    }

    private static void c(int[] iArr, Bundle bundle) {
        if (iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_indexs", iArr);
        }
    }

    private static void d(int[] iArr, Bundle bundle) {
        if (iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_array", iArr);
        }
    }

    public int getBloomAlpha() {
        return this.r;
    }

    public int getBloomBlurTimes() {
        return this.t;
    }

    public float getBloomGradientASpeed() {
        return this.s;
    }

    public int getBloomWidth() {
        int i = this.q;
        if (i == 0) {
            return this.f * 2;
        }
        return i;
    }

    public int getColor() {
        return this.f5850a;
    }

    public int[] getColorList() {
        return this.d;
    }

    public int getDottedLineType() {
        return this.m;
    }

    public PolylineOptions.LineBloomType getLineBloomType() {
        return this.x;
    }

    public PolylineOptions.LineCapType getLineCapType() {
        return this.u;
    }

    public PolylineOptions.LineDirectionCross180 getLineDirectionCross180() {
        return this.w;
    }

    public PolylineOptions.LineJoinType getLineJoinType() {
        return this.v;
    }

    public List<LatLng> getPoints() {
        return this.b;
    }

    public BitmapDescriptor getTexture() {
        return this.k;
    }

    public int getWidth() {
        return this.f;
    }

    public boolean isClickable() {
        return this.j;
    }

    public boolean isDottedLine() {
        return this.g;
    }

    public boolean isFocus() {
        return this.h;
    }

    public boolean isGeodesic() {
        return this.o;
    }

    public boolean isGradient() {
        return this.p;
    }

    public boolean isIsKeepScale() {
        return this.i;
    }

    public boolean isThined() {
        return this.n;
    }

    public void setBloomAlpha(int i) {
        if (i > 255 || i < 0) {
            i = 255;
        }
        this.r = i;
        this.listener.c(this);
    }

    public void setBloomBlurTimes(int i) {
        if (i > 10) {
            i = 10;
        }
        if (i < 1) {
            i = 1;
        }
        this.t = i;
        this.listener.c(this);
    }

    public void setBloomGradientASpeed(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.s = f;
        this.listener.c(this);
    }

    public void setBloomWidth(int i) {
        if (i < 0) {
            i = 0;
        }
        this.q = i;
        this.listener.c(this);
    }

    public void setClickable(boolean z) {
        this.j = z;
        this.listener.c(this);
    }

    public void setColor(int i) {
        this.f5850a = i;
        this.listener.c(this);
    }

    public void setColorList(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            this.d = iArr;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
    }

    public void setDottedLine(boolean z) {
        this.g = z;
        this.listener.c(this);
    }

    public void setDottedLineType(PolylineDottedLineType polylineDottedLineType) {
        this.m = polylineDottedLineType.ordinal();
        this.listener.c(this);
    }

    public void setFocus(boolean z) {
        this.h = z;
        this.listener.c(this);
    }

    public void setGeodesic(boolean z) {
        this.o = z;
        this.listener.c(this);
    }

    public void setGradient(boolean z) {
        this.p = z;
        this.listener.c(this);
    }

    public void setIndexs(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            this.c = iArr;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
    }

    public void setIsKeepScale(boolean z) {
        this.i = z;
    }

    public void setLineBloomType(PolylineOptions.LineBloomType lineBloomType) {
        this.x = lineBloomType;
        this.listener.c(this);
    }

    public void setLineCapType(PolylineOptions.LineCapType lineCapType) {
        this.u = lineCapType;
        this.listener.c(this);
    }

    public void setLineDirectionCross180(PolylineOptions.LineDirectionCross180 lineDirectionCross180) {
        this.w = lineDirectionCross180;
    }

    public void setLineJoinType(PolylineOptions.LineJoinType lineJoinType) {
        this.v = lineJoinType;
        this.listener.c(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list != null) {
            if (list.size() >= 2) {
                if (!list.contains(null)) {
                    this.b = list;
                    this.listener.c(this);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2 or more than 10000");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        this.k = bitmapDescriptor;
        this.listener.c(this);
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        if (list != null && !list.isEmpty()) {
            this.l = list;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
    }

    public void setThined(boolean z) {
        this.n = z;
        this.listener.c(this);
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.f = i;
            this.listener.c(this);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        List<LatLng> list;
        int[] iArr;
        if (this.p) {
            this.y = new BmGradientLine();
        } else {
            this.y = new BmPolyline();
        }
        this.y.a(this);
        setDrawItem(this.y);
        super.toDrawItem();
        List<LatLng> list2 = this.b;
        if (list2 != null && list2.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = 1;
            if (this.o && this.b.size() == 2) {
                list = com.baidu.mapsdkplatform.comapi.map.j.b(this.b.get(0), this.b.get(1));
            } else {
                list = this.b;
            }
            Bundle bundle = new Bundle();
            a(list, this.w, bundle);
            if (bundle.containsKey("x_array") && bundle.containsKey("y_array")) {
                double[] doubleArray = bundle.getDoubleArray("x_array");
                double[] doubleArray2 = bundle.getDoubleArray("y_array");
                for (int i3 = 0; i3 < doubleArray.length; i3++) {
                    arrayList.add(new com.baidu.platform.comapi.bmsdk.b(doubleArray[i3], doubleArray2[i3]));
                }
            }
            BmGeoElement bmGeoElement = new BmGeoElement(0);
            this.A = bmGeoElement;
            bmGeoElement.a(arrayList);
            BmLineStyle bmLineStyle = new BmLineStyle();
            this.z = bmLineStyle;
            bmLineStyle.b(this.f);
            this.y.e(a(this.v));
            this.y.c(a(this.u));
            this.y.d(a(this.u));
            this.y.f(this.x.ordinal());
            this.y.c(this.q / 2);
            this.y.b(this.r);
            this.y.g(this.t);
            this.y.d(this.s);
            this.y.h(this.w.ordinal());
            this.y.b(this.j);
            this.e = new ArrayList();
            if (this.p && (iArr = this.d) != null && iArr.length > 0) {
                while (true) {
                    int[] iArr2 = this.d;
                    if (i >= iArr2.length) {
                        break;
                    }
                    this.e.add(Integer.valueOf(iArr2[i]));
                    i++;
                }
                for (int size = this.e.size(); size < this.b.size(); size++) {
                    List<Integer> list3 = this.e;
                    list3.add(list3.get(list3.size() - 1));
                }
                this.A.a(1, this.e);
                this.A.a(this.z);
                this.y.a(this.A);
                return this.y;
            }
            if (this.o) {
                this.n = false;
                this.p = false;
            }
            if (this.n) {
                this.y.b(2);
                this.y.a(4.0f);
                this.y.a(32);
                this.y.a(16);
            }
            if (this.g) {
                setDottedBitmapResource(this.z, this.m);
                this.z.c(5);
            } else {
                this.z.d(0);
            }
            List<BitmapDescriptor> list4 = this.l;
            if (list4 != null && list4.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                while (i2 < this.b.size()) {
                    ArrayList arrayList4 = new ArrayList();
                    GeoPoint ll2mc = CoordUtil.ll2mc(this.b.get(i2 - 1));
                    GeoPoint ll2mc2 = CoordUtil.ll2mc(this.b.get(i2));
                    com.baidu.platform.comapi.bmsdk.b bVar = new com.baidu.platform.comapi.bmsdk.b(ll2mc.getLongitudeE6(), ll2mc.getLatitudeE6());
                    com.baidu.platform.comapi.bmsdk.b bVar2 = new com.baidu.platform.comapi.bmsdk.b(ll2mc2.getLongitudeE6(), ll2mc2.getLatitudeE6());
                    arrayList4.add(bVar);
                    arrayList4.add(bVar2);
                    arrayList2.add(arrayList4);
                    i2++;
                }
                while (i < arrayList2.size()) {
                    BmGeoElement bmGeoElement2 = new BmGeoElement();
                    BmLineStyle bmLineStyle2 = new BmLineStyle();
                    bmLineStyle2.b(this.f);
                    bmLineStyle2.a(new BmBitmapResource(this.l.get(i).getBitmap()));
                    bmGeoElement2.a(bmLineStyle2);
                    bmGeoElement2.a((List<com.baidu.platform.comapi.bmsdk.b>) arrayList2.get(i));
                    arrayList3.add(bmGeoElement2);
                    this.y.a(bmGeoElement2);
                    i++;
                }
            } else if (this.d != null) {
                int i4 = 0;
                while (true) {
                    int[] iArr3 = this.d;
                    if (i4 >= iArr3.length) {
                        break;
                    }
                    this.e.add(Integer.valueOf(iArr3[i4]));
                    i4++;
                }
                for (int size2 = this.e.size(); size2 < this.b.size(); size2++) {
                    List<Integer> list5 = this.e;
                    list5.add(list5.get(list5.size() - 1));
                }
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                while (i2 < this.b.size()) {
                    ArrayList arrayList7 = new ArrayList();
                    GeoPoint ll2mc3 = CoordUtil.ll2mc(this.b.get(i2 - 1));
                    GeoPoint ll2mc4 = CoordUtil.ll2mc(this.b.get(i2));
                    com.baidu.platform.comapi.bmsdk.b bVar3 = new com.baidu.platform.comapi.bmsdk.b(ll2mc3.getLongitudeE6(), ll2mc3.getLatitudeE6());
                    com.baidu.platform.comapi.bmsdk.b bVar4 = new com.baidu.platform.comapi.bmsdk.b(ll2mc4.getLongitudeE6(), ll2mc4.getLatitudeE6());
                    arrayList7.add(bVar3);
                    arrayList7.add(bVar4);
                    arrayList5.add(arrayList7);
                    i2++;
                }
                while (i < arrayList5.size()) {
                    BmGeoElement bmGeoElement3 = new BmGeoElement();
                    BmLineStyle bmLineStyle3 = new BmLineStyle();
                    bmLineStyle3.b(this.f);
                    if (this.g) {
                        setDottedBitmapResource(bmLineStyle3, this.m);
                        bmLineStyle3.c(5);
                    }
                    bmLineStyle3.a(this.e.get(i).intValue());
                    bmGeoElement3.a(bmLineStyle3);
                    bmGeoElement3.a((List<com.baidu.platform.comapi.bmsdk.b>) arrayList5.get(i));
                    arrayList6.add(bmGeoElement3);
                    this.y.a(bmGeoElement3);
                    i++;
                }
            } else {
                BitmapDescriptor bitmapDescriptor = this.k;
                if (bitmapDescriptor != null) {
                    this.z.a(new BmBitmapResource(bitmapDescriptor.getBitmap()));
                } else {
                    this.z.b(this.f);
                    this.z.a(this.f5850a);
                }
                this.A.a(this.z);
                this.y.a(this.A);
            }
            return this.y;
        }
        throw new IllegalStateException("BDMapSDKException: when you add Polyline, you must at least supply 2 points");
    }

    private static int a(PolylineOptions.LineJoinType lineJoinType) {
        int i = aa.f5877a[lineJoinType.ordinal()];
        if (i == 1) {
            return 2048;
        }
        if (i != 2) {
            return i != 3 ? 2048 : 4096;
        }
        return 8192;
    }

    private static int a(PolylineOptions.LineCapType lineCapType) {
        int i = aa.b[lineCapType.ordinal()];
        return (i == 1 || i != 2) ? 2 : 4;
    }

    private Bundle b(boolean z, String str) {
        String str2;
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putInt("total", 1);
            if (this.m == 1) {
                str2 = "CircleDashTexture.png";
            } else {
                str2 = "lineDashTexture.png";
            }
            if (str == null) {
                str = str2;
            }
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
            if (fromAsset != null) {
                bundle.putBundle("texture_0", fromAsset.b());
            }
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        int i = 0;
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            if (this.l.get(i2) != null) {
                bundle2.putBundle("texture_" + String.valueOf(i), this.l.get(i2).b());
                i++;
            }
        }
        bundle2.putInt("total", i);
        return bundle2;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        List<LatLng> list = this.b;
        if (list != null && list.size() >= 2) {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.b.get(0));
            bundle.putDouble("location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("location_y", ll2mc.getLatitudeE6());
            bundle.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f);
            bundle.putInt("isClickable", this.j ? 1 : 0);
            bundle.putInt("lineBloomType", this.x.ordinal());
            bundle.putInt("lineBloomWidth", this.q);
            bundle.putInt("lineBloomAlpha", this.r);
            bundle.putFloat("lineBloomGradientASPeed", this.s);
            bundle.putInt("lineBloomBlurTimes", this.t);
            if (this.p) {
                return b(bundle);
            }
            if (this.o && this.b.size() == 2) {
                this.b = com.baidu.mapsdkplatform.comapi.map.j.b(this.b.get(0), this.b.get(1));
            }
            a(this.b, this.w, bundle);
            Overlay.a(this.f5850a, bundle);
            a(this.c, bundle);
            b(this.d, bundle);
            int[] iArr = this.c;
            if (iArr != null && iArr.length > 0 && iArr.length > this.b.size() - 1) {
                Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
            }
            bundle.putInt("dotline", this.g ? 1 : 0);
            bundle.putInt("focus", this.h ? 1 : 0);
            if (this.o) {
                this.n = false;
                this.p = false;
            }
            bundle.putInt("isThined", this.n ? 1 : 0);
            bundle.putInt("isGradient", this.p ? 1 : 0);
            bundle.putInt("lineJoinType", this.v.ordinal());
            bundle.putInt("lineCapType", this.u.ordinal());
            bundle.putInt("lineDirectionCross180", this.w.ordinal());
            try {
                String str = "line_texture.png";
                if (this.k != null) {
                    bundle.putInt("custom", 1);
                    bundle.putBundle("image_info", a(false, (String) null));
                } else {
                    if (this.g) {
                        bundle.putBundle("image_info", a(true, (String) null));
                        bundle.putInt("dotted_line_type", this.m);
                    } else {
                        bundle.putBundle("image_info", a(true, "line_texture.png"));
                    }
                    bundle.putInt("custom", 0);
                }
                if (this.l != null) {
                    bundle.putInt("customlist", 1);
                    bundle.putBundle("image_info_list", b(false, (String) null));
                } else {
                    if (this.g) {
                        str = null;
                    }
                    int[] iArr2 = this.d;
                    if (iArr2 != null && iArr2.length > 0) {
                        bundle.putBundle("image_info_list", b(true, str));
                    } else {
                        BitmapDescriptor bitmapDescriptor = this.k;
                        if (bitmapDescriptor != null) {
                            bundle.putBundle("image_info", bitmapDescriptor.b());
                            bundle.putInt("dotline", 0);
                        } else {
                            bundle.putBundle("image_info", a(true, str));
                        }
                    }
                    bundle.putInt("customlist", 0);
                }
                bundle.putInt("keep", this.i ? 1 : 0);
            } catch (Exception unused) {
                Log.e("baidumapsdk", "load texture resource failed!");
                bundle.putInt("dotline", 0);
            }
            return bundle;
        }
        throw new IllegalStateException("BDMapSDKException: when you add Polyline, you must at least supply 2 points");
    }

    private Bundle b(Bundle bundle) {
        int[] iArr = this.d;
        if (iArr != null) {
            if (iArr.length != 0) {
                d(iArr, bundle);
                a(this.b, this.w, bundle);
                int length = this.d.length;
                int[] iArr2 = new int[length];
                for (int i = 0; i < length; i++) {
                    iArr2[i] = i;
                }
                if (this.b.size() == this.d.length) {
                    iArr2[r2.length - 1] = r2.length - 2;
                }
                c(iArr2, bundle);
                return bundle;
            }
            throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
        }
        throw new IllegalStateException("BDMapSDKException: colors array can not be null");
    }

    private Bundle a(boolean z, String str) {
        String str2;
        if (z) {
            if (this.m == 1) {
                str2 = "CircleDashTexture.png";
            } else {
                str2 = "lineDashTexture.png";
            }
            if (str == null) {
                str = str2;
            }
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
            if (fromAsset != null) {
                return fromAsset.b();
            }
        }
        return this.k.b();
    }

    private static void a(List<LatLng> list, PolylineOptions.LineDirectionCross180 lineDirectionCross180, Bundle bundle) {
        LatLng latLng;
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            LatLng latLng2 = list.get(i);
            if (lineDirectionCross180 == PolylineOptions.LineDirectionCross180.FROM_EAST_TO_WEST && latLng2.longitude < OOXIXo.f3760XO) {
                latLng = new LatLng(latLng2.latitude, latLng2.longitude + 360.0d);
            } else {
                if (lineDirectionCross180 == PolylineOptions.LineDirectionCross180.FROM_WEST_TO_EAST && latLng2.longitude > OOXIXo.f3760XO) {
                    latLng = new LatLng(latLng2.latitude, latLng2.longitude - 360.0d);
                }
                GeoPoint ll2mc = CoordUtil.ll2mc(latLng2);
                dArr[i] = ll2mc.getLongitudeE6();
                dArr2[i] = ll2mc.getLatitudeE6();
            }
            latLng2 = latLng;
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
            dArr[i] = ll2mc2.getLongitudeE6();
            dArr2[i] = ll2mc2.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }
}

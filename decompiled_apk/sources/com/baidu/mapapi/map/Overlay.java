package com.baidu.mapapi.map;

import XXooOOI.oIX0oI;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class Overlay {
    protected static GeoPoint mcLocation;
    String K;
    int L;
    boolean M;
    Bundle N;

    /* renamed from: a, reason: collision with root package name */
    private String f5842a;
    protected a listener;
    protected BmDrawItem mDrawItem;
    public com.baidu.mapsdkplatform.comapi.map.h type;

    /* loaded from: classes7.dex */
    public interface a {
        LatLngBounds a(Overlay overlay);

        void b(Overlay overlay);

        void c(Overlay overlay);

        boolean d(Overlay overlay);
    }

    public Overlay() {
        String str = System.currentTimeMillis() + "_" + hashCode();
        this.K = str;
        this.f5842a = str;
    }

    public static boolean b(List<HoleOptions> list, Bundle bundle) {
        boolean z;
        boolean z2;
        if (list == null || list.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (HoleOptions holeOptions : list) {
            if (holeOptions instanceof CircleHoleOptions) {
                arrayList.add((CircleHoleOptions) holeOptions);
            } else if (holeOptions instanceof PolygonHoleOptions) {
                arrayList2.add((PolygonHoleOptions) holeOptions);
            }
        }
        if (arrayList.size() != 0) {
            z = c(arrayList, bundle);
            bundle.putInt("has_circle_hole", z ? 1 : 0);
        } else {
            bundle.putInt("has_circle_hole", 0);
            z = false;
        }
        if (arrayList2.size() != 0) {
            z2 = d(arrayList2, bundle);
            bundle.putInt("has_polygon_hole", z2 ? 1 : 0);
        } else {
            bundle.putInt("has_polygon_hole", 0);
            z2 = false;
        }
        return z || z2;
    }

    private static boolean c(List<CircleHoleOptions> list, Bundle bundle) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            LatLng holeCenter = list.get(i).getHoleCenter();
            int holeRadius = list.get(i).getHoleRadius();
            if (holeCenter == null || holeRadius <= 0) {
                return false;
            }
            GeoPoint ll2mc = CoordUtil.ll2mc(holeCenter);
            dArr[i] = ll2mc.getLongitudeE6();
            dArr2[i] = ll2mc.getLatitudeE6();
            iArr[i] = holeRadius;
            iArr2[i] = i;
        }
        bundle.putDoubleArray("circle_hole_x_array", dArr);
        bundle.putDoubleArray("circle_hole_y_array", dArr2);
        bundle.putIntArray("circle_hole_radius_array", iArr);
        bundle.putIntArray("circle_hole_index_array", iArr2);
        return true;
    }

    public static List<List<com.baidu.platform.comapi.bmsdk.b>> circleHoleInfo2BmGeo(List<CircleHoleOptions> list) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            LatLng holeCenter = list.get(i).getHoleCenter();
            int holeRadius = list.get(i).getHoleRadius();
            if (holeCenter != null && holeRadius > 0) {
                GeoPoint ll2mc = CoordUtil.ll2mc(holeCenter);
                dArr[i] = ll2mc.getLongitudeE6();
                dArr2[i] = ll2mc.getLatitudeE6();
                iArr[i] = holeRadius;
                iArr2[i] = i;
            } else {
                return null;
            }
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < size) {
            double d = dArr[i2];
            double d2 = dArr2[i2];
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < 360) {
                double d3 = ((i3 * 3.141592653589793d) * 2.0d) / 360;
                arrayList2.add(new com.baidu.platform.comapi.bmsdk.b((Math.cos(d3) * iArr[r20]) + (d - mcLocation.getLongitudeE6()) + mcLocation.getLongitudeE6(), (Math.sin(d3) * iArr[r20]) + (d2 - mcLocation.getLatitudeE6()) + mcLocation.getLatitudeE6()));
                i3++;
                i2 = i2;
                size = size;
                dArr = dArr;
            }
            int i4 = size;
            int i5 = i2;
            int i6 = iArr2[i5];
            arrayList.add(arrayList2);
            i2 = i5 + 1;
            size = i4;
        }
        return arrayList;
    }

    private static boolean d(List<PolygonHoleOptions> list, Bundle bundle) {
        int size = list.size();
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            List<LatLng> holePoints = list.get(i).getHolePoints();
            if (holePoints == null) {
                return false;
            }
            arrayList.addAll(holePoints);
            iArr[i] = holePoints.size();
            iArr2[i] = i;
        }
        int size2 = arrayList.size();
        if (size2 == 0) {
            return false;
        }
        bundle.putIntArray("polygon_hole_count_array", iArr);
        bundle.putIntArray("polygon_hole_index_array", iArr2);
        double[] dArr = new double[size2];
        double[] dArr2 = new double[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(i2));
            dArr[i2] = ll2mc.getLongitudeE6();
            dArr2[i2] = ll2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("polygon_hole_x_array", dArr);
        bundle.putDoubleArray("polygon_hole_y_array", dArr2);
        return true;
    }

    public static void e(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat(oIX0oI.f4121ooOOo0oXI, ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4123x0XOIxOo, ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4119oO, (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("m_center_color", bundle2);
    }

    public static void f(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat(oIX0oI.f4121ooOOo0oXI, ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4123x0XOIxOo, ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4119oO, (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("m_side_color", bundle2);
    }

    public static List<List<com.baidu.platform.comapi.bmsdk.b>> holeInfo2BmGeo(List<HoleOptions> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (HoleOptions holeOptions : list) {
                if (holeOptions instanceof CircleHoleOptions) {
                    arrayList2.add((CircleHoleOptions) holeOptions);
                } else if (holeOptions instanceof PolygonHoleOptions) {
                    arrayList3.add((PolygonHoleOptions) holeOptions);
                }
            }
            if (arrayList2.size() != 0) {
                arrayList.addAll(circleHoleInfo2BmGeo(arrayList2));
            }
            if (arrayList3.size() != 0) {
                arrayList.addAll(polygonHoleInfo2BmGeo(arrayList3));
            }
            return arrayList;
        }
        return null;
    }

    public static List<List<com.baidu.platform.comapi.bmsdk.b>> polygonHoleInfo2BmGeo(List<PolygonHoleOptions> list) {
        int size = list.size();
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < size; i++) {
            List<LatLng> holePoints = list.get(i).getHolePoints();
            if (holePoints == null) {
                return null;
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator<LatLng> it = holePoints.iterator();
            while (it.hasNext()) {
                GeoPoint ll2mc = CoordUtil.ll2mc(it.next());
                arrayList3.add(new com.baidu.platform.comapi.bmsdk.b(ll2mc.getLongitudeE6(), ll2mc.getLatitudeE6()));
            }
            arrayList.addAll(holePoints);
            iArr[i] = holePoints.size();
            iArr2[i] = i;
            arrayList2.add(arrayList3);
        }
        return arrayList2;
    }

    public Bundle a(Bundle bundle) {
        bundle.putString("id", this.K);
        bundle.putInt("type", this.type.ordinal());
        bundle.putInt("visibility", this.M ? 1 : 0);
        bundle.putInt("z_index", this.L);
        return bundle;
    }

    public BmDrawItem getDrawItem() {
        return this.mDrawItem;
    }

    public Bundle getExtraInfo() {
        return this.N;
    }

    public String getName() {
        return this.f5842a;
    }

    public LatLngBounds getOverlayLatLngBounds() {
        return this.listener.a(this);
    }

    public int getZIndex() {
        return this.L;
    }

    public boolean isRemoved() {
        return this.listener.d(this);
    }

    public boolean isVisible() {
        return this.M;
    }

    public void remove() {
        this.listener.b(this);
    }

    public void setDottedBitmapResource(BmLineStyle bmLineStyle, int i) {
        String str;
        if (bmLineStyle == null) {
            return;
        }
        int i2 = 1;
        if (i == 1) {
            str = "CircleDashTexture.png";
            i2 = 2;
        } else {
            str = "lineDashTexture.png";
        }
        bmLineStyle.d(i2);
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
        if (fromAsset != null) {
            bmLineStyle.a(new BmBitmapResource(fromAsset.getBitmap()));
        }
    }

    public void setDrawItem(BmDrawItem bmDrawItem) {
        this.mDrawItem = bmDrawItem;
    }

    public void setExtraInfo(Bundle bundle) {
        this.N = bundle;
    }

    public void setVisible(boolean z) {
        this.M = z;
        this.listener.c(this);
    }

    public void setZIndex(int i) {
        this.L = i;
        this.listener.c(this);
    }

    public BmDrawItem toDrawItem() {
        this.mDrawItem.b(getName());
        this.mDrawItem.i(this.M ? 1 : 0);
        this.mDrawItem.a((short) this.L);
        return this.mDrawItem;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("id", this.K);
        bundle.putInt("type", this.type.ordinal());
        return bundle;
    }

    public static void a(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat(oIX0oI.f4121ooOOo0oXI, ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4123x0XOIxOo, ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4119oO, (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("color", bundle2);
    }

    public static void a(List<LatLng> list, Bundle bundle) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            GeoPoint ll2mc = CoordUtil.ll2mc(list.get(i));
            dArr[i] = ll2mc.getLongitudeE6();
            dArr2[i] = ll2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }

    public static void b(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat(oIX0oI.f4121ooOOo0oXI, ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4123x0XOIxOo, ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4119oO, (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("m_floorColor", bundle2);
    }

    public static void c(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat(oIX0oI.f4121ooOOo0oXI, ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4123x0XOIxOo, ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4119oO, (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("m_topFaceColor", bundle2);
    }

    public static void d(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat(oIX0oI.f4121ooOOo0oXI, ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4123x0XOIxOo, ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat(oIX0oI.f4119oO, (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("m_sideFaceColor", bundle2);
    }
}

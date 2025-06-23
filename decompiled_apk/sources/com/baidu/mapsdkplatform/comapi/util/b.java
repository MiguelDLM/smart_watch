package com.baidu.mapsdkplatform.comapi.util;

import XIXIX.OOXIXo;
import android.os.Bundle;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static double[] f6201a = {1.289059486E7d, 8362377.87d, 5591021.0d, 3481989.83d, 1678043.12d, OOXIXo.f3760XO};
    static double[] b = {7.5E7d, 6.0E7d, 4.5E7d, 3.0E7d, 1.5E7d, OOXIXo.f3760XO};
    static double[][] c = {new double[]{1.410526172116255E-8d, 8.98305509648872E-6d, -1.9939833816331d, 200.9824383106796d, -187.2403703815547d, 91.6087516669843d, -23.38765649603339d, 2.57121317296198d, -0.03801003308653d, 1.73379812E7d}, new double[]{-7.435856389565537E-9d, 8.983055097726239E-6d, -0.78625201886289d, 96.32687599759846d, -1.85204757529826d, -59.36935905485877d, 47.40033549296737d, -16.50741931063887d, 2.28786674699375d, 1.026014486E7d}, new double[]{-3.030883460898826E-8d, 8.98305509983578E-6d, 0.30071316287616d, 59.74293618442277d, 7.357984074871d, -25.38371002664745d, 13.45380521110908d, -3.29883767235584d, 0.32710905363475d, 6856817.37d}, new double[]{-1.981981304930552E-8d, 8.983055099779535E-6d, 0.03278182852591d, 40.31678527705744d, 0.65659298677277d, -4.44255534477492d, 0.85341911805263d, 0.12923347998204d, -0.04625736007561d, 4482777.06d}, new double[]{3.09191371068437E-9d, 8.983055096812155E-6d, 6.995724062E-5d, 23.10934304144901d, -2.3663490511E-4d, -0.6321817810242d, -0.00663494467273d, 0.03430082397953d, -0.00466043876332d, 2555164.4d}, new double[]{2.890871144776878E-9d, 8.983055095805407E-6d, -3.068298E-8d, 7.47137025468032d, -3.53937994E-6d, -0.02145144861037d, -1.234426596E-5d, 1.0322952773E-4d, -3.23890364E-6d, 826088.5d}};
    static double[][] d = {new double[]{-0.0015702102444d, 111320.7020616939d, 1.704480524535203E15d, -1.033898737604234E16d, 2.611266785660388E16d, -3.51496691766537E16d, 2.659570071840392E16d, -1.072501245418824E16d, 1.800819912950474E15d, 82.5d}, new double[]{8.277824516172526E-4d, 111320.7020463578d, 6.477955746671607E8d, -4.082003173641316E9d, 1.077490566351142E10d, -1.517187553151559E10d, 1.205306533862167E10d, -5.124939663577472E9d, 9.133119359512032E8d, 67.5d}, new double[]{0.00337398766765d, 111320.7020202162d, 4481351.045890365d, -2.339375119931662E7d, 7.968221547186455E7d, -1.159649932797253E8d, 9.723671115602145E7d, -4.366194633752821E7d, 8477230.501135234d, 52.5d}, new double[]{0.00220636496208d, 111320.7020209128d, 51751.86112841131d, 3796837.749470245d, 992013.7397791013d, -1221952.21711287d, 1340652.697009075d, -620943.6990984312d, 144416.9293806241d, 37.5d}, new double[]{-3.441963504368392E-4d, 111320.7020576856d, 278.2353980772752d, 2485758.690035394d, 6070.750963243378d, 54821.18345352118d, 9540.606633304236d, -2710.55326746645d, 1405.483844121726d, 22.5d}, new double[]{-3.218135878613132E-4d, 111320.7020701615d, 0.00369383431289d, 823725.6402795718d, 0.46104986909093d, 2351.343141331292d, 1.58060784298199d, 8.77738589078284d, 0.37238884252424d, 7.45d}};

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        double f6202a;
        double b;
    }

    public static a a(a aVar, double[] dArr) {
        a aVar2 = new a();
        aVar2.f6202a = dArr[0] + (dArr[1] * Math.abs(aVar.f6202a));
        double abs = Math.abs(aVar.b) / dArr[9];
        double d2 = dArr[2] + (dArr[3] * abs) + (dArr[4] * abs * abs) + (dArr[5] * abs * abs * abs) + (dArr[6] * abs * abs * abs * abs) + (dArr[7] * abs * abs * abs * abs * abs) + (dArr[8] * abs * abs * abs * abs * abs * abs);
        aVar2.b = d2;
        aVar2.f6202a *= aVar.f6202a < OOXIXo.f3760XO ? -1 : 1;
        aVar2.b = d2 * (aVar.b < OOXIXo.f3760XO ? -1 : 1);
        return aVar2;
    }

    public static Point b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        JNITools.CoordinateEncryptMc((float) latLng.longitude, (float) latLng.latitude, bundle);
        Point point = new Point(0, 0);
        point.setIntX((int) bundle.getDouble("x"));
        point.setIntY((int) bundle.getDouble("y"));
        return point;
    }

    public static List<LatLng> c(String str) {
        ArrayList<ArrayList<Point>> arrayList;
        com.baidu.platform.comapi.basestruct.a a2 = com.baidu.mapsdkplatform.comjni.tools.a.a(str);
        ArrayList arrayList2 = new ArrayList();
        if (a2 != null && (arrayList = a2.d) != null) {
            if (arrayList.size() > 0) {
                ArrayList<Point> arrayList3 = arrayList.get(0);
                for (int i = 0; i < arrayList3.size(); i++) {
                    Point point = arrayList3.get(i);
                    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                        arrayList2.add(CoordTrans.baiduToGcj(a(new GeoPoint(point.getDoubleY() / 100.0d, point.getDoubleX() / 100.0d))));
                    } else {
                        arrayList2.add(a(new GeoPoint(point.getDoubleY() / 100.0d, point.getDoubleX() / 100.0d)));
                    }
                }
            }
            return arrayList2;
        }
        return null;
    }

    public static List<List<LatLng>> d(String str) {
        ArrayList<ArrayList<Point>> arrayList;
        com.baidu.platform.comapi.basestruct.a a2 = com.baidu.mapsdkplatform.comjni.tools.a.a(str);
        if (a2 != null && (arrayList = a2.d) != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<ArrayList<Point>> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<Point> next = it.next();
                ArrayList arrayList3 = new ArrayList();
                Iterator<Point> it2 = next.iterator();
                while (it2.hasNext()) {
                    Point next2 = it2.next();
                    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                        arrayList3.add(CoordTrans.baiduToGcj(a(new GeoPoint(next2.getDoubleY() / 100.0d, next2.getDoubleX() / 100.0d))));
                    } else {
                        arrayList3.add(a(new GeoPoint(next2.getDoubleY() / 100.0d, next2.getDoubleX() / 100.0d)));
                    }
                }
                arrayList2.add(arrayList3);
            }
            return arrayList2;
        }
        return null;
    }

    public static LatLng b(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("strkey", str);
        JNITools.TransNodeStr2Pt(bundle);
        return a(new GeoPoint(bundle.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY), bundle.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX)));
    }

    public static LatLng a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        a aVar = new a();
        aVar.f6202a = geoPoint.getLongitudeE6();
        aVar.b = geoPoint.getLatitudeE6();
        a aVar2 = new a();
        double d2 = aVar.f6202a;
        aVar2.f6202a = d2;
        if (d2 > 2.0037508342E7d) {
            aVar2.f6202a = (d2 - 2.0037508342E7d) - 2.0037508342E7d;
        } else if (d2 < -2.0037508342E7d) {
            aVar2.f6202a = 2.0037508342E7d - ((-2.0037508342E7d) - d2);
        }
        double d3 = aVar.b;
        aVar2.b = d3;
        if (d3 < 1.0E-6d && d3 >= OOXIXo.f3760XO) {
            aVar2.b = 1.0E-6d;
        } else if (d3 < OOXIXo.f3760XO && d3 > -1.0E-6d) {
            aVar2.b = -1.0E-6d;
        } else if (d3 > 2.0037508342E7d) {
            aVar2.b = 2.0037508342E7d;
        } else if (d3 < -2.0037508342E7d) {
            aVar2.b = -2.0037508342E7d;
        }
        double[] dArr = new double[10];
        int i = 0;
        while (true) {
            if (i >= 6) {
                break;
            }
            if (Math.abs(aVar2.b) > f6201a[i]) {
                dArr = c[i];
                break;
            }
            i++;
        }
        a a2 = a(aVar2, dArr);
        return new LatLng(a2.b, a2.f6202a);
    }

    public static GeoPoint a(LatLng latLng) {
        a aVar = new a();
        double[] dArr = new double[10];
        double abs = Math.abs(latLng.latitude * 1000000.0d);
        aVar.b = abs;
        if (abs < 0.1d) {
            aVar.b = 0.1d;
        }
        int i = 0;
        while (true) {
            double[] dArr2 = b;
            if (i >= dArr2.length) {
                break;
            }
            if (aVar.b > dArr2[i]) {
                dArr = d[i];
                break;
            }
            i++;
        }
        aVar.f6202a = latLng.longitude;
        aVar.b = latLng.latitude;
        a a2 = a(aVar, dArr);
        return new GeoPoint(a2.b, a2.f6202a);
    }

    public static int a(LatLng latLng, int i) {
        LatLng latLng2 = new LatLng(latLng.latitude + (i / 111000.0d), latLng.longitude);
        GeoPoint a2 = a(latLng);
        GeoPoint a3 = a(latLng2);
        return (int) Math.sqrt(Math.pow(a2.getLatitudeE6() - a3.getLatitudeE6(), 2.0d) + Math.pow(a2.getLongitudeE6() - a3.getLongitudeE6(), 2.0d));
    }

    public static LatLng a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("strkey", str);
        JNITools.TransGeoStr2Pt(bundle);
        GeoPoint geoPoint = new GeoPoint(0, 0);
        geoPoint.setLongitudeE6(bundle.getInt(MapBundleKey.MapObjKey.OBJ_SL_PTX));
        geoPoint.setLatitudeE6(bundle.getInt(MapBundleKey.MapObjKey.OBJ_SL_PTY));
        return a(geoPoint);
    }

    public static LatLng a(float f, float f2, String str) {
        if (str == null) {
            return null;
        }
        if (!str.equals("") && !str.equals("bd09ll")) {
            if (!str.equals("bd09ll") && !str.equals("bd09mc") && !str.equals("gcj02") && !str.equals("wgs84")) {
                return null;
            }
            Bundle bundle = new Bundle();
            JNITools.CoordinateEncryptEx(f, f2, str, bundle);
            if (bundle.isEmpty()) {
                return null;
            }
            return new LatLng(bundle.getDouble("y"), bundle.getDouble("x"));
        }
        return new LatLng(f, f2);
    }
}

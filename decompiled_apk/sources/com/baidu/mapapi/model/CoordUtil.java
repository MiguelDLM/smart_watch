package com.baidu.mapapi.model;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.List;

/* loaded from: classes7.dex */
public class CoordUtil {
    public static LatLng Coordinate_encryptEx(float f, float f2, String str) {
        return com.baidu.mapsdkplatform.comapi.util.b.a(f, f2, str);
    }

    public static LatLng decodeLocation(String str) {
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            return CoordTrans.baiduToGcj(com.baidu.mapsdkplatform.comapi.util.b.a(str));
        }
        return com.baidu.mapsdkplatform.comapi.util.b.a(str);
    }

    public static List<LatLng> decodeLocationList(String str) {
        return com.baidu.mapsdkplatform.comapi.util.b.c(str);
    }

    public static List<List<LatLng>> decodeLocationList2D(String str) {
        return com.baidu.mapsdkplatform.comapi.util.b.d(str);
    }

    public static LatLng decodeNodeLocation(String str) {
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            return CoordTrans.baiduToGcj(com.baidu.mapsdkplatform.comapi.util.b.b(str));
        }
        return com.baidu.mapsdkplatform.comapi.util.b.b(str);
    }

    public static double getDistance(Point point, Point point2) {
        return com.baidu.mapsdkplatform.comjni.tools.a.a(point, point2);
    }

    public static int getMCDistanceByOneLatLngAndRadius(LatLng latLng, int i) {
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            return com.baidu.mapsdkplatform.comapi.util.b.a(CoordTrans.gcjToBaidu(latLng), i);
        }
        return com.baidu.mapsdkplatform.comapi.util.b.a(latLng, i);
    }

    public static GeoPoint ll2mc(LatLng latLng) {
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            return com.baidu.mapsdkplatform.comapi.util.b.a(CoordTrans.gcjToBaidu(latLng));
        }
        return com.baidu.mapsdkplatform.comapi.util.b.a(latLng);
    }

    public static GeoPoint ll2mcDirect(LatLng latLng) {
        return com.baidu.mapsdkplatform.comapi.util.b.a(latLng);
    }

    public static Point ll2point(LatLng latLng) {
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            return com.baidu.mapsdkplatform.comapi.util.b.b(CoordTrans.gcjToBaidu(latLng));
        }
        return com.baidu.mapsdkplatform.comapi.util.b.b(latLng);
    }

    public static LatLng mc2ll(GeoPoint geoPoint) {
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            return CoordTrans.baiduToGcj(com.baidu.mapsdkplatform.comapi.util.b.a(geoPoint));
        }
        return com.baidu.mapsdkplatform.comapi.util.b.a(geoPoint);
    }
}

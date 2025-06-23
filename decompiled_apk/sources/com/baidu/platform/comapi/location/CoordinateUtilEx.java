package com.baidu.platform.comapi.location;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.basestruct.a;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class CoordinateUtilEx {
    public static Point Coordinate_encryptEx(float f, float f2, String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("")) {
            str = "bd09ll";
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1395470197:
                if (str.equals("bd09ll")) {
                    c = 0;
                    break;
                }
                break;
            case -1395470175:
                if (str.equals("bd09mc")) {
                    c = 1;
                    break;
                }
                break;
            case 98175376:
                if (str.equals("gcj02")) {
                    c = 2;
                    break;
                }
                break;
            case 113079775:
                if (str.equals("wgs84")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return CoordinateUtil.bd09llTobd09mc(f, f2);
            case 1:
                return new Point(f, f2);
            case 2:
                return CoordinateUtil.gcj02Tobd09mc(f, f2);
            case 3:
                return CoordinateUtil.wgs84Tobd09mc(f, f2);
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0075. Please report as an issue. */
    public static ArrayList<Point> Coordinate_encryptExArray(ArrayList<Point> arrayList, String str) {
        String str2;
        int i;
        Point bd09llTobd09mc;
        String str3 = str;
        String str4 = "wgs84";
        Point point = null;
        if (str3 == null) {
            return null;
        }
        if (str3.equals("")) {
            str3 = "bd09ll";
        }
        if (!str3.equals("bd09ll") && !str3.equals("bd09mc") && !str3.equals("gcj02") && !str3.equals("wgs84")) {
            return null;
        }
        int size = arrayList.size();
        float[] fArr = new float[size];
        float[] fArr2 = new float[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            fArr[i2] = arrayList.get(i2).getIntX() / 100000.0f;
            fArr2[i2] = arrayList.get(i2).getIntY() / 100000.0f;
        }
        ArrayList<Point> arrayList2 = new ArrayList<>();
        int i3 = 0;
        while (i3 < size) {
            char c = 65535;
            switch (str3.hashCode()) {
                case -1395470197:
                    if (str3.equals("bd09ll")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1395470175:
                    if (str3.equals("bd09mc")) {
                        c = 1;
                        break;
                    }
                    break;
                case 98175376:
                    if (str3.equals("gcj02")) {
                        c = 2;
                        break;
                    }
                    break;
                case 113079775:
                    if (str3.equals(str4)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str2 = str4;
                    i = size;
                    bd09llTobd09mc = CoordinateUtil.bd09llTobd09mc(fArr[i3], fArr2[i3]);
                    break;
                case 1:
                    str2 = str4;
                    i = size;
                    bd09llTobd09mc = new Point(fArr[i3], fArr2[i3]);
                    break;
                case 2:
                    str2 = str4;
                    bd09llTobd09mc = CoordinateUtil.gcj02Tobd09mc(fArr[i3], fArr2[i3]);
                    break;
                case 3:
                    str2 = str4;
                    bd09llTobd09mc = CoordinateUtil.wgs84Tobd09mc(fArr[i3], fArr2[i3]);
                    break;
                default:
                    str2 = str4;
                    bd09llTobd09mc = point;
                    break;
            }
            i = size;
            if (bd09llTobd09mc != null) {
                arrayList2.add(bd09llTobd09mc);
            }
            i3++;
            size = i;
            str4 = str2;
            point = null;
        }
        return arrayList2;
    }

    public static double getDistanceByMc(Point point, Point point2) {
        return CoordinateUtil.getDistanceByMc(point.getDoubleX(), point.getDoubleY(), point2.getDoubleX(), point2.getDoubleY());
    }

    @Deprecated
    public static a getGeoComplexPointFromString(String str) {
        if (str != null && !str.equals("")) {
            return CoordinateUtil.geoStringToComplexPt(str);
        }
        return null;
    }

    @Deprecated
    public static a getGeoComplexPtBoundFromString(String str) {
        if (str != null && !str.equals("")) {
            return CoordinateUtil.geoStringToComplexPtBound(str);
        }
        return null;
    }

    public static Point getGeoPointFromString(String str) {
        if (str != null && !str.equals("")) {
            return CoordinateUtil.geoStringToPoint(str);
        }
        return null;
    }

    public static String getStringFromGeoPoint(Point point) {
        return CoordinateUtil.pointToGeoString(point);
    }

    public static double getDistanceByMc(GeoPoint geoPoint, GeoPoint geoPoint2) {
        return CoordinateUtil.getDistanceByMc(geoPoint.getLongitude(), geoPoint.getLatitude(), geoPoint2.getLongitude(), geoPoint2.getLatitude());
    }
}

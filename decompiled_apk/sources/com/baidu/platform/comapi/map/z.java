package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;

/* loaded from: classes8.dex */
public class z {
    public static GeoPoint a(GeoPoint geoPoint) {
        Point bd09llTobd09mc = CoordinateUtil.bd09llTobd09mc(geoPoint.getLongitude(), geoPoint.getLatitude());
        if (bd09llTobd09mc != null) {
            return new GeoPoint(bd09llTobd09mc.getDoubleY(), bd09llTobd09mc.getDoubleX());
        }
        return null;
    }
}

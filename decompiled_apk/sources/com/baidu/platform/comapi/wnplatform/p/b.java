package com.baidu.platform.comapi.wnplatform.p;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes8.dex */
public class b {
    public static GeoPoint a(double d, double d2) {
        LatLng a2 = a(new LatLng(d2, d), "wgs84");
        return new GeoPoint((int) (a2.latitude * 100000.0d), (int) (a2.longitude * 100000.0d));
    }

    private static LatLng a(LatLng latLng, String str) {
        if (latLng == null) {
            return null;
        }
        return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }
}

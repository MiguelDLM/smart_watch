package com.baidu.platform.comapi.wnplatform.p;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* loaded from: classes8.dex */
public class f {
    public static MapStatusUpdate a(MapStatus mapStatus) {
        return MapStatusUpdateFactory.newMapStatus(mapStatus);
    }

    public static LatLng a(GeoPoint geoPoint) {
        LatLng Coordinate_encryptEx = CoordUtil.Coordinate_encryptEx(((float) geoPoint.getLongitudeE6()) / 100000.0f, ((float) geoPoint.getLatitudeE6()) / 100000.0f, "gcj02");
        return SDKInitializer.getCoordType() == CoordType.GCJ02 ? CoordTrans.baiduToGcj(Coordinate_encryptEx) : Coordinate_encryptEx;
    }
}

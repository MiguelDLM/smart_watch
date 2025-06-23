package com.baidu.navisdk.util.logic;

import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes8.dex */
public class h {
    public static GeoPoint a() {
        GeoPoint geoPoint = new GeoPoint();
        int[] iArr = {0};
        int[] iArr2 = {0};
        if (BNRouteGuider.getInstance().getCarPoint(iArr, iArr2) && iArr[0] != 0 && iArr2[0] != 0) {
            LogUtil.e("BNLocationPointUtil", "getCarGeoPoint. Engine(guidance_control) value is valid");
            geoPoint.setLongitudeE6(iArr[0]);
            geoPoint.setLatitudeE6(iArr2[0]);
        } else {
            LogUtil.e("BNLocationPointUtil", "getCarGeoPoint. Engine(guidance_control) value is valid, set LastValidLocation as car point.");
            geoPoint = g.j().e();
        }
        if (geoPoint == null || !geoPoint.isValid()) {
            geoPoint = g.j().c();
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNLocationPointUtil", "getCarGeoPoint --> carGeoPt = " + geoPoint);
        }
        return geoPoint;
    }

    public static GeoPoint b() {
        new GeoPoint();
        GeoPoint e = g.j().e();
        if (e == null || !e.isValid()) {
            e = g.j().c();
        }
        if (e == null || !e.isValid()) {
            int[] iArr = {0};
            int[] iArr2 = {0};
            if (BNRouteGuider.getInstance().getCarPoint(iArr, iArr2) && iArr[0] != 0 && iArr2[0] != 0) {
                LogUtil.e("BNLocationPointUtil", "getCarGeoPoint. Engine(guidance_control) value is valid");
                if (e == null) {
                    e = new GeoPoint();
                }
                e.setLongitudeE6(iArr[0]);
                e.setLatitudeE6(iArr2[0]);
            }
        }
        return e;
    }
}

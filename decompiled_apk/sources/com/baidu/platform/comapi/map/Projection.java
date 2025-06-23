package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;

/* loaded from: classes8.dex */
public interface Projection {
    GeoPoint fromPixels(int i, int i2);

    float metersToEquatorPixels(float f);

    Point toPixels(GeoPoint geoPoint, int i, Point point);

    Point toPixels(GeoPoint geoPoint, Point point);

    Point world2Screen(float f, float f2, float f3);
}

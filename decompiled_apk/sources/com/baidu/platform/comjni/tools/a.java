package com.baidu.platform.comjni.tools;

import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;

@Deprecated
/* loaded from: classes8.dex */
public class a {
    public static double a(Point point, Point point2) {
        return CoordinateUtil.getDistanceByMc(point.getDoubleX(), point.getDoubleY(), point2.getDoubleX(), point2.getDoubleY());
    }
}

package com.baidu.navisdk.module.base;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.offlinedata.BNOfflineDataManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class c {
    public static boolean a() {
        GeoPoint geoPoint;
        if (!BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            return false;
        }
        Iterator<RoutePlanNode> it = ((f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).k().iterator();
        while (it.hasNext()) {
            RoutePlanNode next = it.next();
            if (next != null && next.isNodeSettedData() && (geoPoint = next.getGeoPoint()) != null && geoPoint.isValid()) {
                com.baidu.navisdk.model.datastruct.f a2 = com.baidu.navisdk.poisearch.c.a(geoPoint, 0);
                while (a2 != null && a2.f6925a > 2) {
                    a2 = com.baidu.navisdk.poisearch.c.b(a2.b);
                }
                if (a2 != null && !BNOfflineDataManager.getInstance().isProvinceDataDownload(a2.b)) {
                    return false;
                }
            }
        }
        return true;
    }
}

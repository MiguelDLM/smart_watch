package com.baidu.datahub.protocol;

import android.content.Context;
import android.os.Handler;
import com.baidu.mapapi.CoordType;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class SyncShareImpl {
    public void addUserOP(String str, String str2, String str3, String str4) {
    }

    public abstract Context getAppContext();

    public List<ShareETAInfoProtocol> getCarPoolETAInfos() {
        return null;
    }

    public abstract CoordType getCoordType();

    public abstract String getCuid();

    public List<ShareETAInfoProtocol> getNormalETAInfos() {
        return null;
    }

    public abstract String getSignMD5String(String str);

    public void registerCarPoolShareLocationHandler(Handler handler) {
    }

    public void registerNormalShareLocationHandler(Handler handler) {
    }

    public void setUserLocation(RoutePlanNodeProtocol routePlanNodeProtocol, String str, long j, boolean z) {
    }

    public void unregisterCarPoolShareLocationHandler(Handler handler) {
    }

    public void unregisterNormalShareLocationHandler(Handler handler) {
    }

    public int updateOrderEndPosition(String str, RoutePlanNodeProtocol routePlanNodeProtocol, long j, String str2) {
        return 0;
    }

    public boolean updateOrderPassRoute(String str) {
        return false;
    }

    public int updateOrderStartPosition(String str, RoutePlanNodeProtocol routePlanNodeProtocol, long j, String str2) {
        return 0;
    }

    public int updateWayPoints(List<WayPointInfoProtocol> list, long j, String str) {
        return 0;
    }
}

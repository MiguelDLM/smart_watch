package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public class WayPointInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f5928a;
    private LatLng b;

    public LatLng getLatLng() {
        return this.b;
    }

    public String getWayPointName() {
        return this.f5928a;
    }

    public WayPointInfo setLatLng(LatLng latLng) {
        if (latLng != null) {
            this.b = latLng;
            return this;
        }
        throw new IllegalStateException("BDMapSDKException: The latitude and longitude of the waypoint cannot be null");
    }

    public WayPointInfo setWayPointName(String str) {
        this.f5928a = str;
        return this;
    }
}

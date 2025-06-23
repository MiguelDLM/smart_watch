package com.baidu.navisdk.adapter.struct;

import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class BNRoutePlanInfos {
    ArrayList<ArrayList<BNPassCityInfo>> cityLists;
    ArrayList<String> limitInfo;
    ArrayList<ArrayList<BNRouteDetail>> routeDetailLists;
    ArrayList<ArrayList<ArrayList<LatLng>>> routeInfoLatLngLists;
    ArrayList<BNRoutePlanItem> routeTabInfos;

    public ArrayList<ArrayList<BNPassCityInfo>> getCityLists() {
        return this.cityLists;
    }

    public ArrayList<String> getLimitInfo() {
        return this.limitInfo;
    }

    public ArrayList<ArrayList<BNRouteDetail>> getRouteDetailLists() {
        return this.routeDetailLists;
    }

    public ArrayList<ArrayList<ArrayList<LatLng>>> getRouteInfoLatLngLists() {
        return this.routeInfoLatLngLists;
    }

    public ArrayList<BNRoutePlanItem> getRouteTabInfos() {
        return this.routeTabInfos;
    }

    public void setCityLists(ArrayList<ArrayList<BNPassCityInfo>> arrayList) {
        this.cityLists = arrayList;
    }

    public void setLimitInfo(ArrayList<String> arrayList) {
        this.limitInfo = arrayList;
    }

    public void setRouteDetailLists(ArrayList<ArrayList<BNRouteDetail>> arrayList) {
        this.routeDetailLists = arrayList;
    }

    public void setRouteInfoLatLngLists(ArrayList<ArrayList<ArrayList<LatLng>>> arrayList) {
        this.routeInfoLatLngLists = arrayList;
    }

    public void setRouteTabInfos(ArrayList<BNRoutePlanItem> arrayList) {
        this.routeTabInfos = arrayList;
    }
}

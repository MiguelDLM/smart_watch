package com.baidu.navisdk.ui.widget;

/* loaded from: classes8.dex */
public class RouteDetailDataModel {
    public RouteDirect routeDirect;
    public String routeDistance;
    public String routeName;
    public RouteStatus routeStatus;

    /* loaded from: classes8.dex */
    public enum RouteDirect {
        STRAIGHT,
        LEFT,
        RIGHT
    }

    /* loaded from: classes8.dex */
    public enum RouteStatus {
        NONE,
        CLEAR,
        NORMAL,
        CROWED,
        SNAIL
    }

    public RouteDetailDataModel(RouteStatus routeStatus, RouteDirect routeDirect, String str, String str2) {
        this.routeStatus = routeStatus;
        this.routeDirect = routeDirect;
        this.routeName = str;
        this.routeDistance = str2;
    }
}

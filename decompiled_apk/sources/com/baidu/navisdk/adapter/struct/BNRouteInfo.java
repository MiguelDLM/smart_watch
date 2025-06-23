package com.baidu.navisdk.adapter.struct;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public class BNRouteInfo {
    public Rect bound;
    public ArrayList<BNRoadCondition> roadConditions;
    public int routeDist;
    public String routeId;
    public int routeTime;
    public ArrayList<Point> shapePoints;
    public int trafficLights;

    /* loaded from: classes7.dex */
    public static class Point {
        public double x;
        public double y;
    }

    /* loaded from: classes7.dex */
    public static class Rect {
        public double bottom;
        public double left;
        public double right;
        public double top;
    }
}

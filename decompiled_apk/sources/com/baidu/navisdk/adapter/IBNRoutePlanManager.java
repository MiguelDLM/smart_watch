package com.baidu.navisdk.adapter;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.navisdk.adapter.struct.BNRoutePlanInfos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes7.dex */
public interface IBNRoutePlanManager {
    public static final int MSG_NAVI_ROUTE_PLAN_CANCELED = 1001;
    public static final int MSG_NAVI_ROUTE_PLAN_FAILED = 1003;
    public static final int MSG_NAVI_ROUTE_PLAN_START = 1000;
    public static final int MSG_NAVI_ROUTE_PLAN_SUCCESS = 1002;
    public static final int MSG_NAVI_ROUTE_PLAN_TO_NAVI = 8000;

    /* loaded from: classes7.dex */
    public interface RouteLinkDataListener {
        void onDataChange(ArrayList<Bundle> arrayList);
    }

    /* loaded from: classes7.dex */
    public interface RoutePlanPreference {
        public static final int ROUTE_PLAN_PREFERENCE_AVOID_TRAFFIC_JAM = 16;
        public static final int ROUTE_PLAN_PREFERENCE_DEFAULT = 1;
        public static final int ROUTE_PLAN_PREFERENCE_DISTANCE_FIRST = 128;
        public static final int ROUTE_PLAN_PREFERENCE_ECONOMIC_ROUTE = 1024;
        public static final int ROUTE_PLAN_PREFERENCE_NOHIGHWAY = 4;
        public static final int ROUTE_PLAN_PREFERENCE_NOTOLL = 8;
        public static final int ROUTE_PLAN_PREFERENCE_ROAD_FIRST = 512;
        public static final int ROUTE_PLAN_PREFERENCE_TIME_FIRST = 256;
    }

    /* loaded from: classes7.dex */
    public interface SelectRouteListener {
        void onSelectComplete();
    }

    /* loaded from: classes7.dex */
    public interface SubVehicle {
        public static final int DEFAULT = 0;
        public static final int NEW_ENERGY = 1;
    }

    /* loaded from: classes7.dex */
    public interface Vehicle {
        public static final int CAR = 1;
        public static final int INVALID = 0;
        public static final int MOTOR = 2;
        public static final int TRUCK = 3;
    }

    BNRoutePlanInfos getRoutePlanInfo();

    int getSelectRouteId();

    void removeRequestByHandler(Handler handler);

    boolean routePlan(List<BNRoutePlanNode> list, int i, Bundle bundle, Handler handler);

    void selectRoute(int i, SelectRouteListener selectRouteListener);

    void setAvoidBlockedRoad(boolean z);

    void setRouteLinkDataListener(RouteLinkDataListener routeLinkDataListener);

    void setRoutePlanTime(Date date);

    void setViaPreferRoutePlanEnable(boolean z);
}

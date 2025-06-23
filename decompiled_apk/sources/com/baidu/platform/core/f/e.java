package com.baidu.platform.core.f;

import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;

/* loaded from: classes8.dex */
public interface e {
    void a();

    void a(OnGetRoutePlanResultListener onGetRoutePlanResultListener);

    boolean a(BikingRoutePlanOption bikingRoutePlanOption);

    boolean a(DrivingRoutePlanOption drivingRoutePlanOption);

    boolean a(IndoorRoutePlanOption indoorRoutePlanOption);

    boolean a(MassTransitRoutePlanOption massTransitRoutePlanOption);

    boolean a(TransitRoutePlanOption transitRoutePlanOption);

    boolean a(WalkingRoutePlanOption walkingRoutePlanOption);
}

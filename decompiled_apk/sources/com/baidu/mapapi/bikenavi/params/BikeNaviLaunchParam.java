package com.baidu.mapapi.bikenavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.f.a;
import com.baidu.platform.comapi.walknavi.f.b;

/* loaded from: classes7.dex */
public class BikeNaviLaunchParam {

    /* renamed from: a, reason: collision with root package name */
    private LatLng f5776a;
    private LatLng b;
    private BikeRouteNodeInfo c;
    private BikeRouteNodeInfo d;
    private int e = 0;
    private int f;

    public static a create() {
        return new b();
    }

    public BikeNaviLaunchParam copy() {
        BikeNaviLaunchParam bikeNaviLaunchParam = new BikeNaviLaunchParam();
        bikeNaviLaunchParam.c = this.c;
        bikeNaviLaunchParam.d = this.d;
        bikeNaviLaunchParam.e = this.e;
        bikeNaviLaunchParam.f5776a = this.f5776a;
        bikeNaviLaunchParam.b = this.b;
        bikeNaviLaunchParam.f = this.f;
        return bikeNaviLaunchParam;
    }

    public BikeNaviLaunchParam endNodeInfo(BikeRouteNodeInfo bikeRouteNodeInfo) {
        this.d = bikeRouteNodeInfo;
        return this;
    }

    public BikeNaviLaunchParam endPt(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public BikeNaviLaunchParam extraNaviMode(int i) {
        this.f = i;
        return this;
    }

    public BikeRouteNodeInfo getEndNodeInfo() {
        return this.d;
    }

    public LatLng getEndPt() {
        return this.b;
    }

    public int getExtraNaviMode() {
        return this.f;
    }

    public BikeRouteNodeInfo getStartNodeInfo() {
        return this.c;
    }

    public LatLng getStartPt() {
        return this.f5776a;
    }

    public int getVehicle() {
        return this.e;
    }

    public BikeNaviLaunchParam stPt(LatLng latLng) {
        this.f5776a = latLng;
        return this;
    }

    public BikeNaviLaunchParam startNodeInfo(BikeRouteNodeInfo bikeRouteNodeInfo) {
        this.c = bikeRouteNodeInfo;
        return this;
    }

    public BikeNaviLaunchParam vehicle(int i) {
        this.e = i;
        return this;
    }
}

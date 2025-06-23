package com.baidu.mapapi.walknavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.f.c;
import com.baidu.platform.comapi.walknavi.f.d;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes7.dex */
public class WalkNaviLaunchParam {

    /* renamed from: a, reason: collision with root package name */
    private LatLng f6045a;
    private LatLng b;
    private a c;
    private a d;
    private List<a> e = new LinkedList();
    private int f;

    public static c create() {
        return new d();
    }

    public WalkNaviLaunchParam copy() {
        WalkNaviLaunchParam walkNaviLaunchParam = new WalkNaviLaunchParam();
        walkNaviLaunchParam.c = this.c;
        walkNaviLaunchParam.d = this.d;
        walkNaviLaunchParam.f6045a = this.f6045a;
        walkNaviLaunchParam.b = this.b;
        walkNaviLaunchParam.f = this.f;
        walkNaviLaunchParam.e = this.e;
        return walkNaviLaunchParam;
    }

    public WalkNaviLaunchParam endNodeInfo(WalkRouteNodeInfo walkRouteNodeInfo) {
        this.d = walkRouteNodeInfo;
        return this;
    }

    public WalkNaviLaunchParam endPt(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public WalkNaviLaunchParam extraNaviMode(int i) {
        this.f = i;
        return this;
    }

    public a getEndNodeInfo() {
        return this.d;
    }

    public LatLng getEndPt() {
        return this.b;
    }

    public int getExtraNaviMode() {
        return this.f;
    }

    public a getStartNodeInfo() {
        return this.c;
    }

    public LatLng getStartPt() {
        return this.f6045a;
    }

    public List<a> getViaNodes() {
        return this.e;
    }

    public void setViaNodes(List<a> list) {
        this.e.addAll(list);
    }

    public WalkNaviLaunchParam stPt(LatLng latLng) {
        this.f6045a = latLng;
        return this;
    }

    public WalkNaviLaunchParam startNodeInfo(WalkRouteNodeInfo walkRouteNodeInfo) {
        this.c = walkRouteNodeInfo;
        return this;
    }
}

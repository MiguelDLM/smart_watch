package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.NaviParaOption;
import org.json.JSONArray;

/* loaded from: classes7.dex */
public class TruckNaviOption extends NaviParaOption {
    int g;
    double h;
    double i;
    double j;
    double k;
    double l;
    int m;
    boolean n;
    String o;
    int p;
    int q;
    int r;
    int s;
    int t;

    public int getAxleCount() {
        return this.m;
    }

    public double getAxleWeight() {
        return this.l;
    }

    public int getDisplacement() {
        return this.q;
    }

    public int getEmissionLimit() {
        return this.s;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public String getEndName() {
        return super.getEndName();
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public LatLng getEndPoint() {
        return super.getEndPoint();
    }

    public double getHeight() {
        return this.h;
    }

    public boolean getIsTrailer() {
        return this.n;
    }

    public double getLength() {
        return this.k;
    }

    public int getLoadWeight() {
        return this.t;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public String getNaviRoutePolicy() {
        return super.getNaviRoutePolicy();
    }

    public int getPlateColor() {
        return this.p;
    }

    public String getPlateNumber() {
        return this.o;
    }

    public int getPowerType() {
        return this.r;
    }

    public int getTruckType() {
        return this.g;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public JSONArray getWayPoint() {
        return super.getWayPoint();
    }

    public double getWeight() {
        return this.j;
    }

    public double getWidth() {
        return this.i;
    }

    public TruckNaviOption setAxleCount(int i) {
        this.m = i;
        return this;
    }

    public TruckNaviOption setAxleWeight(double d) {
        this.l = d;
        return this;
    }

    public TruckNaviOption setDisplacement(int i) {
        this.q = i;
        return this;
    }

    public TruckNaviOption setEmissionLimit(int i) {
        this.s = i;
        return this;
    }

    public TruckNaviOption setHeight(double d) {
        this.h = d;
        return this;
    }

    public TruckNaviOption setIsTrailer(boolean z) {
        this.n = z;
        return this;
    }

    public TruckNaviOption setLength(double d) {
        this.k = d;
        return this;
    }

    public TruckNaviOption setLoadWeight(int i) {
        this.t = i;
        return this;
    }

    public TruckNaviOption setPlateColor(int i) {
        this.p = i;
        return this;
    }

    public TruckNaviOption setPlateNumber(String str) {
        this.o = str;
        return this;
    }

    public TruckNaviOption setPowerType(int i) {
        this.r = i;
        return this;
    }

    public TruckNaviOption setTruckType(int i) {
        this.g = i;
        return this;
    }

    public TruckNaviOption setWeight(double d) {
        this.j = d;
        return this;
    }

    public TruckNaviOption setWidth(double d) {
        this.i = d;
        return this;
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption endName(String str) {
        return (TruckNaviOption) super.endName(str);
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption endPoint(LatLng latLng) {
        return (TruckNaviOption) super.endPoint(latLng);
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption setNaviRoutePolicy(NaviParaOption.NaviRoutePolicy naviRoutePolicy) {
        return (TruckNaviOption) super.setNaviRoutePolicy(naviRoutePolicy);
    }

    @Override // com.baidu.mapapi.navi.NaviParaOption
    public TruckNaviOption setWayPoint(WayPoint wayPoint) {
        return (TruckNaviOption) super.setWayPoint(wayPoint);
    }
}

package com.baidu.mapapi.walknavi.model;

import com.baidu.mapapi.map.BitmapDescriptor;

/* loaded from: classes7.dex */
public class MultiRouteDisplayOption {

    /* renamed from: a, reason: collision with root package name */
    private BitmapDescriptor f6036a;
    private BitmapDescriptor b;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;

    public int getFocusColor() {
        return this.e;
    }

    public BitmapDescriptor getFocusRouteBitmapDescriptor() {
        return this.f6036a;
    }

    public int getFocusRouteWidth() {
        return this.c;
    }

    public int getNoFocusColor() {
        return this.f;
    }

    public BitmapDescriptor getNoFocusRouteBitmapDescriptor() {
        return this.b;
    }

    public int getNoFocusRouteWidth() {
        return this.d;
    }

    public void setFocusColor(int i) {
        this.e = i;
    }

    public void setFocusRouteBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        this.f6036a = bitmapDescriptor;
    }

    public void setFocusRouteWidth(int i) {
        this.c = i;
    }

    public void setNoFocusColor(int i) {
        this.f = i;
    }

    public void setNoFocusRouteBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        this.b = bitmapDescriptor;
    }

    public void setNoFocusRouteWidth(int i) {
        this.d = i;
    }
}

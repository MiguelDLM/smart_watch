package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public final class MultiPointItem {

    /* renamed from: a, reason: collision with root package name */
    private LatLng f5836a;
    private String b;

    public MultiPointItem(LatLng latLng) {
        if (latLng != null) {
            this.f5836a = latLng;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: MultiPointItem point can not be null");
    }

    public LatLng getPoint() {
        return this.f5836a;
    }

    public String getTitle() {
        return this.b;
    }

    public void setTitle(String str) {
        this.b = str;
    }
}

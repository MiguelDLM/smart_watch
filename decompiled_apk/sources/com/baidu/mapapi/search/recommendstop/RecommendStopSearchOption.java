package com.baidu.mapapi.search.recommendstop;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public class RecommendStopSearchOption {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5974a = false;
    public LatLng mLocation;

    public LatLng getLocation() {
        return this.mLocation;
    }

    public boolean isNeedStationInfo() {
        return this.f5974a;
    }

    public RecommendStopSearchOption location(LatLng latLng) {
        this.mLocation = latLng;
        return this;
    }

    public RecommendStopSearchOption setNeedStationInfo(boolean z) {
        this.f5974a = z;
        return this;
    }
}

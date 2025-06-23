package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* loaded from: classes7.dex */
public class PolygonHoleOptions extends HoleOptions {

    /* renamed from: a, reason: collision with root package name */
    private List<LatLng> f5848a;

    public PolygonHoleOptions() {
        this.mHoleType = "polygon";
    }

    public PolygonHoleOptions addPoints(List<LatLng> list) {
        if (list != null && list.size() >= 3) {
            this.f5848a = list;
            return this;
        }
        Log.e("baidumapsdk", "PolygonHole's points can not be null or points's size can not be less than three");
        return this;
    }

    public List<LatLng> getHolePoints() {
        return this.f5848a;
    }
}

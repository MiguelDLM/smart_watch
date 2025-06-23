package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes7.dex */
public class CircleHoleOptions extends HoleOptions {

    /* renamed from: a, reason: collision with root package name */
    private LatLng f5799a;
    private int b;

    public CircleHoleOptions() {
        this.mHoleType = TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE;
    }

    public CircleHoleOptions center(LatLng latLng) {
        if (latLng == null) {
            Log.e("baidumapsdk", "CircleHole center can not be null");
            return this;
        }
        this.f5799a = latLng;
        return this;
    }

    public LatLng getHoleCenter() {
        return this.f5799a;
    }

    public int getHoleRadius() {
        return this.b;
    }

    public CircleHoleOptions radius(int i) {
        if (i <= 0) {
            Log.e("baidumapsdk", "CircleHole's radius can not be less than zero");
            return this;
        }
        this.b = i;
        return this;
    }
}

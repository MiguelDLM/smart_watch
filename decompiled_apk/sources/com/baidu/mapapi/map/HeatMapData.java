package com.baidu.mapapi.map;

import android.os.Bundle;
import java.util.Collection;

/* loaded from: classes7.dex */
public class HeatMapData {

    /* renamed from: a, reason: collision with root package name */
    private double[] f5815a;
    private double[] b;
    private double[] c;
    private float d;

    public HeatMapData(Collection<WeightedLatLng> collection, float f) {
        int size = collection.size();
        this.f5815a = new double[size];
        this.b = new double[size];
        this.c = new double[size];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (WeightedLatLng weightedLatLng : collection) {
            this.f5815a[i] = weightedLatLng.getPoint().x;
            this.b[i2] = weightedLatLng.getPoint().y;
            this.c[i3] = weightedLatLng.getIntensity();
            i3++;
            i2++;
            i++;
        }
        this.d = f;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putDoubleArray("x_array", this.f5815a);
        bundle.putDoubleArray("y_array", this.b);
        bundle.putDoubleArray("z_array", this.c);
        bundle.putFloat("max_intentity", this.d);
        return bundle;
    }
}

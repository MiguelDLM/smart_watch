package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    int f5802a;
    Bundle c;
    private LatLng d;
    private int e = ViewCompat.MEASURED_STATE_MASK;
    private int f = 5;
    boolean b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Dot dot = new Dot();
        dot.M = this.b;
        dot.L = this.f5802a;
        dot.N = this.c;
        dot.b = this.e;
        dot.f5801a = this.d;
        dot.c = this.f;
        return dot;
    }

    public DotOptions center(LatLng latLng) {
        if (latLng != null) {
            this.d = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
    }

    public DotOptions color(int i) {
        this.e = i;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.d;
    }

    public int getColor() {
        return this.e;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getRadius() {
        return this.f;
    }

    public int getZIndex() {
        return this.f5802a;
    }

    public boolean isVisible() {
        return this.b;
    }

    public DotOptions radius(int i) {
        if (i > 0) {
            this.f = i;
        }
        return this;
    }

    public DotOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public DotOptions zIndex(int i) {
        this.f5802a = i;
        return this;
    }
}

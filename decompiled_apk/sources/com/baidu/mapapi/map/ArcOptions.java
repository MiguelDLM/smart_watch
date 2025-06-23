package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public final class ArcOptions extends OverlayOptions {
    private static final String d = "ArcOptions";

    /* renamed from: a, reason: collision with root package name */
    int f5785a;
    Bundle c;
    private LatLng h;
    private LatLng i;
    private LatLng j;
    private int e = ViewCompat.MEASURED_STATE_MASK;
    private int f = 5;
    private boolean g = false;
    boolean b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Arc arc = new Arc();
        arc.M = this.b;
        arc.L = this.f5785a;
        arc.N = this.c;
        arc.f5784a = this.e;
        arc.b = this.f;
        arc.c = this.h;
        arc.d = this.i;
        arc.e = this.j;
        arc.f = this.g;
        return arc;
    }

    public ArcOptions color(int i) {
        this.e = i;
        return this;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public int getColor() {
        return this.e;
    }

    public LatLng getEndPoint() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public LatLng getMiddlePoint() {
        return this.i;
    }

    public LatLng getStartPoint() {
        return this.h;
    }

    public int getWidth() {
        return this.f;
    }

    public int getZIndex() {
        return this.f5785a;
    }

    public boolean isVisible() {
        return this.b;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng != null && latLng2 != null && latLng3 != null) {
            if (latLng != latLng2 && latLng != latLng3 && latLng2 != latLng3) {
                this.h = latLng;
                this.i = latLng2;
                this.j = latLng3;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
        }
        throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be null");
    }

    public ArcOptions setClickable(boolean z) {
        this.g = z;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public ArcOptions width(int i) {
        if (i > 0) {
            this.f = i;
        }
        return this;
    }

    public ArcOptions zIndex(int i) {
        this.f5785a = i;
        return this;
    }
}

package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* loaded from: classes7.dex */
public final class CircleOptions extends OverlayOptions {
    private static final String d = "CircleOptions";

    /* renamed from: a, reason: collision with root package name */
    int f5800a;
    Bundle c;
    private LatLng e;
    private int g;
    private Stroke h;
    private List<HoleOptions> k;
    private HoleOptions l;
    private int o;
    private int p;
    private int f = ViewCompat.MEASURED_STATE_MASK;
    private boolean i = false;
    private int j = 0;
    private boolean m = false;
    private boolean n = false;
    private float q = 0.5f;
    private float r = 0.2f;
    boolean b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Circle circle = new Circle();
        circle.M = this.b;
        circle.L = this.f5800a;
        circle.N = this.c;
        circle.b = this.f;
        circle.f5797a = this.e;
        circle.c = this.g;
        circle.d = this.h;
        circle.e = this.i;
        circle.o = this.j;
        circle.f = this.k;
        circle.g = this.l;
        circle.h = this.m;
        circle.q = this.o;
        circle.r = this.p;
        circle.s = this.q;
        circle.t = this.r;
        circle.i = this.n;
        return circle;
    }

    public CircleOptions addHoleOption(HoleOptions holeOptions) {
        this.l = holeOptions;
        return this;
    }

    public CircleOptions addHoleOptions(List<HoleOptions> list) {
        this.k = list;
        return this;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng != null) {
            this.e = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
    }

    public CircleOptions dottedStroke(boolean z) {
        this.i = z;
        return this;
    }

    public CircleOptions dottedStrokeType(CircleDottedStrokeType circleDottedStrokeType) {
        this.j = circleDottedStrokeType.ordinal();
        return this;
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.e;
    }

    public int getCenterColor() {
        return this.o;
    }

    public float getColorWeight() {
        return this.r;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getFillColor() {
        return this.f;
    }

    public int getRadius() {
        return this.g;
    }

    public float getRadiusWeight() {
        return this.q;
    }

    public int getSideColor() {
        return this.p;
    }

    public Stroke getStroke() {
        return this.h;
    }

    public int getZIndex() {
        return this.f5800a;
    }

    public boolean isIsGradientCircle() {
        return this.m;
    }

    public boolean isVisible() {
        return this.b;
    }

    public CircleOptions radius(int i) {
        this.g = i;
        return this;
    }

    public CircleOptions setCenterColor(int i) {
        this.o = i;
        return this;
    }

    public CircleOptions setClickable(boolean z) {
        this.n = z;
        return this;
    }

    public CircleOptions setColorWeight(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.r = f;
        }
        return this;
    }

    public CircleOptions setIsGradientCircle(boolean z) {
        this.m = z;
        return this;
    }

    public CircleOptions setRadiusWeight(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.q = f;
        }
        return this;
    }

    public CircleOptions setSideColor(int i) {
        this.p = i;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.h = stroke;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public CircleOptions zIndex(int i) {
        this.f5800a = i;
        return this;
    }
}

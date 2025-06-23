package com.baidu.mapapi.map;

import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* loaded from: classes7.dex */
public class PrismOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    private float f5858a;
    private List<LatLng> c;
    private BitmapDescriptor f;
    private int d = ViewCompat.MEASURED_STATE_MASK;
    private int e = ViewCompat.MEASURED_STATE_MASK;
    boolean b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Prism prism = new Prism();
        prism.M = this.b;
        prism.o = this.f;
        prism.k = this.f5858a;
        List<LatLng> list = this.c;
        if (list != null && list.size() > 3) {
            prism.l = this.c;
            prism.n = this.e;
            prism.m = this.d;
            return prism;
        }
        throw new IllegalStateException("BDMapSDKException: when you add prism, you must at least supply 4 points");
    }

    public PrismOptions customSideImage(BitmapDescriptor bitmapDescriptor) {
        this.f = bitmapDescriptor;
        return this;
    }

    public BitmapDescriptor getCustomSideImage() {
        return this.f;
    }

    public float getHeight() {
        return this.f5858a;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public int getSideFaceColor() {
        return this.e;
    }

    public int getTopFaceColor() {
        return this.d;
    }

    public boolean isVisible() {
        return this.b;
    }

    public PrismOptions setHeight(float f) {
        this.f5858a = f;
        return this;
    }

    public PrismOptions setPoints(List<LatLng> list) {
        this.c = list;
        return this;
    }

    public PrismOptions setSideFaceColor(int i) {
        this.e = i;
        return this;
    }

    public PrismOptions setTopFaceColor(int i) {
        this.d = i;
        return this;
    }

    public PrismOptions visible(boolean z) {
        this.b = z;
        return this;
    }
}

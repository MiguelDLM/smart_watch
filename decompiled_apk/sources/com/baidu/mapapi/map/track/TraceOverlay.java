package com.baidu.mapapi.map.track;

import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.a.b;
import java.util.List;

/* loaded from: classes7.dex */
public class TraceOverlay {
    List<LatLng> c;
    int[] d;
    boolean g;
    boolean h;
    int i;
    boolean j;
    public b mListener;
    BitmapDescriptor o;
    BM3DModelOptions p;

    /* renamed from: a, reason: collision with root package name */
    int f5914a = -265058817;
    int b = 14;
    int e = 300;
    int f = 0;
    boolean k = true;
    boolean l = false;
    boolean m = true;
    boolean n = true;
    boolean q = false;
    float r = 5.0f;
    boolean s = false;
    boolean t = false;

    public void clear() {
        this.mListener.c(this);
    }

    public int getAnimationDuration() {
        return this.f;
    }

    public int getAnimationTime() {
        return this.e;
    }

    public int getAnimationType() {
        return this.i;
    }

    public float getBloomSpeed() {
        return this.r;
    }

    public int getColor() {
        return this.f5914a;
    }

    public int[] getColors() {
        return this.d;
    }

    public BitmapDescriptor getIcon() {
        return this.o;
    }

    public BM3DModelOptions getIcon3D() {
        return this.p;
    }

    public LatLngBounds getLatLngBounds() {
        List<LatLng> list = this.c;
        if (list != null && list.size() != 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(this.c);
            return builder.build();
        }
        return null;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public void icon(BitmapDescriptor bitmapDescriptor) {
        this.o = bitmapDescriptor;
    }

    public void icon3D(BM3DModelOptions bM3DModelOptions) {
        this.p = bM3DModelOptions;
    }

    public boolean isAnimate() {
        return this.h;
    }

    public boolean isDataReduction() {
        return this.m;
    }

    public boolean isDataSmooth() {
        return this.n;
    }

    public boolean isOnPause() {
        return this.t;
    }

    public boolean isPointMove() {
        return this.l;
    }

    public boolean isRotateWhenTrack() {
        return this.k;
    }

    public boolean isStatusChanged() {
        return this.s;
    }

    public boolean isTrackBloom() {
        return this.q;
    }

    public boolean isTrackMove() {
        return this.j;
    }

    public boolean isUseColorArray() {
        return this.g;
    }

    public void pause() {
        this.s = true;
        this.t = true;
        this.mListener.b(this);
    }

    public void remove() {
        this.mListener.a(this);
    }

    public void resume() {
        this.t = false;
        this.s = true;
        this.mListener.b(this);
        this.s = false;
    }

    public void setAnimate(boolean z) {
        this.h = z;
    }

    public void setAnimationDuration(int i) {
        this.f = i;
    }

    public void setAnimationTime(int i) {
        if (i >= 300) {
            this.e = i;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
    }

    public void setBloomSpeed(float f) {
        this.r = f;
    }

    public void setColor(int i) {
        this.f5914a = i;
    }

    public void setDataReduction(boolean z) {
        this.m = z;
    }

    public void setDataSmooth(boolean z) {
        this.n = z;
    }

    public void setPointMove(boolean z) {
        this.l = z;
    }

    public void setRotateWhenTrack(boolean z) {
        this.k = z;
    }

    public void setTraceAnimationType(TraceOptions.TraceAnimateType traceAnimateType) {
        if (traceAnimateType == null) {
            traceAnimateType = TraceOptions.TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
        }
        this.i = traceAnimateType.ordinal();
    }

    public void setTraceColors(int[] iArr) {
        this.d = iArr;
    }

    public void setTracePoints(List<LatLng> list) {
        this.c = list;
    }

    public void setTrackBloom(boolean z) {
        this.q = z;
    }

    public void setTrackMove(boolean z) {
        this.j = z;
    }

    public void setWidth(int i) {
        this.b = i;
    }

    public void update() {
        this.mListener.b(this);
    }

    public void useColorArray(boolean z) {
        this.g = z;
    }
}

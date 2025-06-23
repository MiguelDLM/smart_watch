package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class MarkerOptions extends OverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    int f5833a;
    Bundle c;
    private LatLng d;
    private BitmapDescriptor e;
    private float j;
    private TitleOptions k;
    private String l;
    private int m;
    private int n;
    private ArrayList<BitmapDescriptor> p;
    private Point x;
    private InfoWindow z;
    private float f = 0.5f;
    private float g = 1.0f;
    private boolean h = true;
    private boolean i = false;
    private boolean o = false;
    private int q = 20;
    private float r = 1.0f;
    private float s = 1.0f;
    private float t = 1.0f;
    private int u = 0;
    private int v = MarkerAnimateType.none.ordinal();
    private boolean w = false;
    private boolean y = true;
    private int A = Integer.MAX_VALUE;
    private boolean B = false;
    private int C = 4;
    private int D = 22;
    private boolean E = false;
    private boolean F = false;
    boolean b = true;

    /* loaded from: classes7.dex */
    public enum MarkerAnimateType {
        none,
        drop,
        grow,
        jump
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Marker marker = new Marker();
        marker.M = this.b;
        marker.L = this.f5833a;
        marker.N = this.c;
        LatLng latLng = this.d;
        if (latLng != null) {
            marker.f5832a = latLng;
            BitmapDescriptor bitmapDescriptor = this.e;
            if (bitmapDescriptor == null && this.p == null) {
                throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the icon or icons");
            }
            marker.b = bitmapDescriptor;
            marker.c = this.f;
            marker.d = this.g;
            marker.e = this.h;
            marker.f = this.i;
            marker.g = this.j;
            marker.i = this.k;
            marker.j = this.m;
            marker.k = this.n;
            marker.l = this.o;
            marker.v = this.p;
            marker.w = this.q;
            marker.n = this.t;
            marker.u = this.u;
            marker.y = this.r;
            marker.z = this.s;
            marker.o = this.v;
            marker.p = this.w;
            marker.C = this.z;
            marker.q = this.y;
            marker.F = this.A;
            marker.t = this.B;
            marker.G = this.C;
            marker.H = this.D;
            marker.r = this.E;
            marker.s = this.F;
            Point point = this.x;
            if (point != null) {
                marker.B = point;
            }
            return marker;
        }
        throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the position");
    }

    public MarkerOptions alpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.t = f;
            return this;
        }
        this.t = 1.0f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.f = f;
            this.g = f2;
        }
        return this;
    }

    public MarkerOptions animateType(MarkerAnimateType markerAnimateType) {
        if (markerAnimateType == null) {
            markerAnimateType = MarkerAnimateType.none;
        }
        this.v = markerAnimateType.ordinal();
        return this;
    }

    public MarkerOptions clickable(boolean z) {
        this.y = z;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.i = z;
        return this;
    }

    public MarkerOptions endLevel(int i) {
        this.D = i;
        return this;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public MarkerOptions fixedScreenPosition(Point point) {
        this.x = point;
        this.w = true;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.o = z;
        return this;
    }

    public float getAlpha() {
        return this.t;
    }

    public float getAnchorX() {
        return this.f;
    }

    public float getAnchorY() {
        return this.g;
    }

    public MarkerAnimateType getAnimateType() {
        int i = this.v;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return MarkerAnimateType.none;
                }
                return MarkerAnimateType.jump;
            }
            return MarkerAnimateType.grow;
        }
        return MarkerAnimateType.drop;
    }

    public int getEndLevel() {
        return this.D;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public boolean getForceDisPlay() {
        return this.B;
    }

    public int getHeight() {
        return this.u;
    }

    public BitmapDescriptor getIcon() {
        return this.e;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.p;
    }

    public boolean getIsClickable() {
        return this.y;
    }

    public boolean getJoinCollision() {
        return this.E;
    }

    public int getPeriod() {
        return this.q;
    }

    public LatLng getPosition() {
        return this.d;
    }

    public int getPriority() {
        return this.A;
    }

    public float getRotate() {
        return this.j;
    }

    public int getStartLevel() {
        return this.C;
    }

    @Deprecated
    public String getTitle() {
        return this.l;
    }

    public TitleOptions getTitleOptions() {
        return this.k;
    }

    public int getZIndex() {
        return this.f5833a;
    }

    public MarkerOptions height(int i) {
        if (i < 0) {
            this.u = 0;
            return this;
        }
        this.u = i;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.e = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                return this;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == null || arrayList.get(i).f5792a == null) {
                    return this;
                }
            }
            this.p = arrayList;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
    }

    public MarkerOptions infoWindow(InfoWindow infoWindow) {
        this.z = infoWindow;
        return this;
    }

    public boolean isDraggable() {
        return this.i;
    }

    public boolean isFlat() {
        return this.o;
    }

    public MarkerOptions isForceDisPlay(boolean z) {
        this.B = z;
        return this;
    }

    public MarkerOptions isJoinCollision(boolean z) {
        this.E = z;
        return this;
    }

    public boolean isPerspective() {
        return this.h;
    }

    public boolean isPoiCollided() {
        return this.F;
    }

    public boolean isVisible() {
        return this.b;
    }

    public MarkerOptions period(int i) {
        if (i > 0) {
            this.q = i;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
    }

    public MarkerOptions perspective(boolean z) {
        this.h = z;
        return this;
    }

    public MarkerOptions poiCollided(boolean z) {
        this.F = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng != null) {
            this.d = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
    }

    public MarkerOptions priority(int i) {
        this.A = i;
        return this;
    }

    public MarkerOptions rotate(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        this.j = f % 360.0f;
        return this;
    }

    public MarkerOptions scaleX(float f) {
        if (f < 0.0f) {
            return this;
        }
        this.r = f;
        return this;
    }

    public MarkerOptions scaleY(float f) {
        if (f < 0.0f) {
            return this;
        }
        this.s = f;
        return this;
    }

    public MarkerOptions startLevel(int i) {
        this.C = i;
        return this;
    }

    public MarkerOptions title(String str) {
        this.l = str;
        return this;
    }

    public MarkerOptions titleOptions(TitleOptions titleOptions) {
        this.f = 0.5f;
        this.g = 0.0f;
        this.k = titleOptions;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public MarkerOptions xOffset(int i) {
        this.n = i;
        return this;
    }

    public MarkerOptions yOffset(int i) {
        this.m = i;
        return this;
    }

    public MarkerOptions zIndex(int i) {
        this.f5833a = i;
        return this;
    }
}

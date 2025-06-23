package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes7.dex */
public class InfoWindow {

    /* renamed from: a, reason: collision with root package name */
    String f5816a;
    BitmapDescriptor b;
    View c;
    LatLng d;
    OnInfoWindowClickListener e;
    a f;
    int g;
    boolean h;
    int i;
    boolean j;
    boolean k;
    boolean l;

    /* loaded from: classes7.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(InfoWindow infoWindow);

        void b(InfoWindow infoWindow);
    }

    public InfoWindow(View view, LatLng latLng, int i) {
        this.f5816a = "";
        this.h = false;
        this.i = SysOSUtil.getDensityDpi();
        this.j = false;
        this.k = false;
        this.l = false;
        if (view != null && latLng != null) {
            this.c = view;
            this.d = latLng;
            this.g = i;
            this.k = true;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.b;
    }

    public LatLng getPosition() {
        return this.d;
    }

    public String getTag() {
        return this.f5816a;
    }

    public View getView() {
        return this.c;
    }

    public int getYOffset() {
        return this.g;
    }

    public void setBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        a aVar;
        if (bitmapDescriptor != null && (aVar = this.f) != null) {
            this.b = bitmapDescriptor;
            aVar.b(this);
        }
    }

    public void setPosition(LatLng latLng) {
        a aVar;
        if (latLng != null && (aVar = this.f) != null) {
            this.d = latLng;
            if (aVar != null) {
                aVar.b(this);
            }
        }
    }

    public void setTag(String str) {
        this.f5816a = str;
    }

    public void setView(View view) {
        a aVar;
        if (view != null && (aVar = this.f) != null) {
            this.c = view;
            aVar.b(this);
        }
    }

    public void setYOffset(int i) {
        a aVar = this.f;
        if (aVar == null) {
            return;
        }
        this.g = i;
        aVar.b(this);
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i, OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f5816a = "";
        this.h = false;
        this.i = SysOSUtil.getDensityDpi();
        this.j = false;
        this.k = false;
        this.l = false;
        if (bitmapDescriptor != null && latLng != null) {
            this.b = bitmapDescriptor;
            this.d = latLng;
            this.e = onInfoWindowClickListener;
            this.g = i;
            this.l = true;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
    }

    public InfoWindow(View view, LatLng latLng, int i, boolean z, int i2) {
        this.f5816a = "";
        this.h = false;
        this.i = SysOSUtil.getDensityDpi();
        this.j = false;
        this.k = false;
        this.l = false;
        if (view != null && latLng != null) {
            this.c = view;
            this.d = latLng;
            this.g = i;
            this.h = z;
            this.i = i2;
            this.k = true;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
    }
}

package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class u implements com.baidu.platform.comapi.map.ak {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MapView f5915a;

    public u(MapView mapView) {
        this.f5915a = mapView;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a() {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void b() {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void c() {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void d() {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void e(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(MotionEvent motionEvent) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void b(com.baidu.mapsdkplatform.comapi.map.w wVar) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void c(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void d(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(com.baidu.mapsdkplatform.comapi.map.w wVar) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void b(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean c(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean d(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean b(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void c(com.baidu.mapsdkplatform.comapi.map.w wVar) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        MapSurfaceView mapSurfaceView3;
        MapSurfaceView mapSurfaceView4;
        MapSurfaceView mapSurfaceView5;
        MapSurfaceView mapSurfaceView6;
        float f;
        SparseIntArray sparseIntArray;
        MapSurfaceView mapSurfaceView7;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView2;
        MapSurfaceView mapSurfaceView8;
        mapSurfaceView = this.f5915a.e;
        if (mapSurfaceView != null) {
            mapSurfaceView2 = this.f5915a.e;
            if (mapSurfaceView2.getController() == null) {
                return;
            }
            mapSurfaceView3 = this.f5915a.e;
            float zoomLevel = mapSurfaceView3.getZoomLevel();
            mapSurfaceView4 = this.f5915a.e;
            if (zoomLevel < mapSurfaceView4.getController().mMinZoomLevel) {
                mapSurfaceView8 = this.f5915a.e;
                zoomLevel = mapSurfaceView8.getController().mMinZoomLevel;
            } else {
                mapSurfaceView5 = this.f5915a.e;
                if (zoomLevel > mapSurfaceView5.getController().mMaxZoomLevel) {
                    mapSurfaceView6 = this.f5915a.e;
                    zoomLevel = mapSurfaceView6.getController().mMaxZoomLevel;
                }
            }
            f = this.f5915a.v;
            if (Math.abs(f - zoomLevel) > 0.0f) {
                sparseIntArray = MapView.r;
                int i = sparseIntArray.get(Math.round(zoomLevel));
                mapSurfaceView7 = this.f5915a.e;
                int zoomUnitsInMeter = (int) (i / mapSurfaceView7.getController().getZoomUnitsInMeter());
                imageView = this.f5915a.o;
                if (imageView != null) {
                    imageView2 = this.f5915a.o;
                    int i2 = zoomUnitsInMeter / 2;
                    imageView2.setPadding(i2, 0, i2, 0);
                }
                String format = i >= 1000 ? String.format(" %d公里 ", Integer.valueOf(i / 1000)) : String.format(" %d米 ", Integer.valueOf(i));
                textView = this.f5915a.m;
                if (textView != null) {
                    textView4 = this.f5915a.m;
                    textView4.setText(format);
                }
                textView2 = this.f5915a.n;
                if (textView2 != null) {
                    textView3 = this.f5915a.n;
                    textView3.setText(format);
                }
                this.f5915a.v = zoomLevel;
            }
            this.f5915a.d();
            this.f5915a.requestLayout();
        }
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(String str) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean b(String str) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(GL10 gl10, com.baidu.mapsdkplatform.comapi.map.w wVar) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public void a(boolean z, int i) {
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean a(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean a(Point point, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.ak
    public boolean a(MotionEvent motionEvent, float f, float f2, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        return false;
    }
}

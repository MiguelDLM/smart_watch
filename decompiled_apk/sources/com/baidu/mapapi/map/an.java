package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class an implements com.baidu.platform.comapi.map.ak {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WearMapView f5890a;

    public an(WearMapView wearMapView) {
        this.f5890a = wearMapView;
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
        SparseArray sparseArray;
        MapSurfaceView mapSurfaceView7;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        MapSurfaceView mapSurfaceView8;
        mapSurfaceView = this.f5890a.f;
        if (mapSurfaceView != null) {
            mapSurfaceView2 = this.f5890a.f;
            if (mapSurfaceView2.getBaseMap() == null) {
                return;
            }
            mapSurfaceView3 = this.f5890a.f;
            float zoomLevel = mapSurfaceView3.getZoomLevel();
            mapSurfaceView4 = this.f5890a.f;
            if (zoomLevel < mapSurfaceView4.getController().mMinZoomLevel) {
                mapSurfaceView8 = this.f5890a.f;
                zoomLevel = mapSurfaceView8.getController().mMinZoomLevel;
            } else {
                mapSurfaceView5 = this.f5890a.f;
                if (zoomLevel > mapSurfaceView5.getController().mMaxZoomLevel) {
                    mapSurfaceView6 = this.f5890a.f;
                    zoomLevel = mapSurfaceView6.getController().mMaxZoomLevel;
                }
            }
            f = this.f5890a.A;
            if (Math.abs(f - zoomLevel) > 0.0f) {
                sparseArray = WearMapView.x;
                Integer num = (Integer) sparseArray.get(Math.round(zoomLevel));
                int intValue = num.intValue();
                mapSurfaceView7 = this.f5890a.f;
                int zoomUnitsInMeter = (int) (intValue / mapSurfaceView7.getController().getZoomUnitsInMeter());
                imageView = this.f5890a.r;
                int i = zoomUnitsInMeter / 2;
                imageView.setPadding(i, 0, i, 0);
                String format = intValue >= 1000 ? String.format(" %d公里 ", Integer.valueOf(intValue / 1000)) : String.format(" %d米 ", num);
                textView = this.f5890a.p;
                textView.setText(format);
                textView2 = this.f5890a.q;
                textView2.setText(format);
                this.f5890a.A = zoomLevel;
            }
            this.f5890a.requestLayout();
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

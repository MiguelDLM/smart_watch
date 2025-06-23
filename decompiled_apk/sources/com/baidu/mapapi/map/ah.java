package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapTextureView;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ah implements com.baidu.platform.comapi.map.ak {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextureMapView f5884a;

    public ah(TextureMapView textureMapView) {
        this.f5884a = textureMapView;
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
        MapTextureView mapTextureView;
        MapTextureView mapTextureView2;
        MapTextureView mapTextureView3;
        MapTextureView mapTextureView4;
        MapTextureView mapTextureView5;
        MapTextureView mapTextureView6;
        float f;
        SparseArray sparseArray;
        MapTextureView mapTextureView7;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView2;
        MapTextureView mapTextureView8;
        mapTextureView = this.f5884a.b;
        if (mapTextureView != null) {
            mapTextureView2 = this.f5884a.b;
            if (mapTextureView2.getController() == null) {
                return;
            }
            mapTextureView3 = this.f5884a.b;
            float zoomLevel = mapTextureView3.getZoomLevel();
            mapTextureView4 = this.f5884a.b;
            if (zoomLevel < mapTextureView4.getController().mMinZoomLevel) {
                mapTextureView8 = this.f5884a.b;
                zoomLevel = mapTextureView8.getController().mMinZoomLevel;
            } else {
                mapTextureView5 = this.f5884a.b;
                if (zoomLevel > mapTextureView5.getController().mMaxZoomLevel) {
                    mapTextureView6 = this.f5884a.b;
                    zoomLevel = mapTextureView6.getController().mMaxZoomLevel;
                }
            }
            f = this.f5884a.s;
            if (Math.abs(f - zoomLevel) > 0.0f) {
                sparseArray = TextureMapView.q;
                Integer num = (Integer) sparseArray.get(Math.round(zoomLevel));
                int intValue = num.intValue();
                mapTextureView7 = this.f5884a.b;
                int zoomUnitsInMeter = (int) (intValue / mapTextureView7.getController().getZoomUnitsInMeter());
                imageView = this.f5884a.o;
                if (imageView != null) {
                    imageView2 = this.f5884a.o;
                    int i = zoomUnitsInMeter / 2;
                    imageView2.setPadding(i, 0, i, 0);
                }
                String format = intValue >= 1000 ? String.format(" %d公里 ", Integer.valueOf(intValue / 1000)) : String.format(" %d米 ", num);
                textView = this.f5884a.m;
                if (textView != null) {
                    textView4 = this.f5884a.m;
                    textView4.setText(format);
                }
                textView2 = this.f5884a.n;
                if (textView2 != null) {
                    textView3 = this.f5884a.n;
                    textView3.setText(format);
                }
                this.f5884a.s = zoomLevel;
            }
            this.f5884a.d();
            this.f5884a.requestLayout();
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

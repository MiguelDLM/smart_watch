package com.baidu.nplatform.comapi.map;

import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.b;

/* loaded from: classes8.dex */
public class m extends GLSurfaceView implements t {

    /* renamed from: a, reason: collision with root package name */
    private j f9519a;
    u b;

    public j getController() {
        if (this.f9519a == null) {
            this.f9519a = new j(getContext(), this);
        }
        return this.f9519a;
    }

    public b.a getGeoRound() {
        return null;
    }

    public int getLatitudeSpan() {
        return 0;
    }

    public int getLongitudeSpan() {
        return 0;
    }

    public GeoPoint getMapCenter() {
        return null;
    }

    public int getMapRotation() {
        return 0;
    }

    public com.baidu.nplatform.comapi.basestruct.b getMapStatus() {
        return null;
    }

    public u getMapViewListener() {
        return this.b;
    }

    public int getOverlooking() {
        return 0;
    }

    public b.C0522b getWinRound() {
        return null;
    }

    public float getZoomLevel() {
        return 0.0f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        LogUtil.e("Map", "surface onPause");
        j jVar = this.f9519a;
        if (jVar != null) {
            jVar.x();
        }
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        LogUtil.e("Map", "surface onResume");
        j jVar = this.f9519a;
        if (jVar != null) {
            jVar.y();
        }
        setRenderMode(1);
        try {
            super.onResume();
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        j jVar = this.f9519a;
        if (jVar != null) {
            return jVar.c(motionEvent);
        }
        return false;
    }

    public void setGeoRound(b.a aVar) {
    }

    public void setMapCenter(GeoPoint geoPoint) {
    }

    public void setMapStatus(com.baidu.nplatform.comapi.basestruct.b bVar) {
    }

    public void setMapTo2D(boolean z) {
    }

    public void setMapViewListener(u uVar) {
        this.b = uVar;
    }

    public void setOverlooking(int i) {
    }

    public void setRotation(int i) {
    }

    public void setSatellite(boolean z) {
    }

    public void setStreetRoad(boolean z) {
    }

    public void setTraffic(boolean z) {
    }

    public void setWinRound(b.C0522b c0522b) {
    }

    public void setZoomLevel(int i) {
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        LogUtil.e("Map", "surfaceChanged w:" + i2 + " h:" + i3);
        o.f9520a = i2;
        o.b = i3;
        o.c = 0;
        this.f9519a.d(i2, i3);
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        LogUtil.e("Map", "surfaceCreated ");
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        LogUtil.e("Map", "surfaceDestroyed");
    }
}

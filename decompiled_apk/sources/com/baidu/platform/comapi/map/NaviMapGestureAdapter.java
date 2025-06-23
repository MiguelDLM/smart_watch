package com.baidu.platform.comapi.map;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes8.dex */
public class NaviMapGestureAdapter extends GestureDetector.SimpleOnGestureListener {
    private MapController mMapController;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.mMapController.isNaviMode() && this.mMapController.getNaviMapViewListener() != null) {
            this.mMapController.getNaviMapViewListener().onAction(520, motionEvent);
            return false;
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.mMapController.isNaviMode() && this.mMapController.getNaviMapViewListener() != null) {
            this.mMapController.getNaviMapViewListener().onAction(515, motionEvent);
            return false;
        }
        return super.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mMapController.isNaviMode() && this.mMapController.getNaviMapViewListener() != null) {
            this.mMapController.getNaviMapViewListener().onAction(516, null);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.mMapController.isNaviMode() && this.mMapController.getNaviMapViewListener() != null && !this.mMapController.isEnableDMoveZoom()) {
            this.mMapController.getNaviMapViewListener().onAction(517, motionEvent);
        }
        super.onLongPress(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mMapController.isNaviMode() && this.mMapController.getNaviMapViewListener() != null) {
            this.mMapController.getNaviMapViewListener().onAction(518, null);
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    public void setMapController(MapController mapController) {
        this.mMapController = mapController;
    }
}

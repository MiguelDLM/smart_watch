package com.baidu.baidunavis.maplayer;

import android.graphics.drawable.Drawable;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.ItemizedOverlay;
import com.baidu.platform.comapi.map.MapSurfaceView;

/* loaded from: classes7.dex */
public class BMItemizedOverlay extends ItemizedOverlay {
    private MapSurfaceView mMapGLSurfaceView;
    private i mOnTapListener;

    public BMItemizedOverlay() {
        super((Drawable) null, a.h().b());
        this.mMapGLSurfaceView = a.h().b();
    }

    public i getOnTapListener() {
        return this.mOnTapListener;
    }

    public void hide() {
        if (this.mMapGLSurfaceView.getOverlays().contains(this)) {
            this.mMapGLSurfaceView.removeOverlay(this);
        }
    }

    public boolean isShowing() {
        if (this.mMapGLSurfaceView.getOverlays().contains(this) && getAllItem() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.ItemizedOverlay
    public final boolean onTap(int i) {
        i iVar = this.mOnTapListener;
        if (iVar == null || !iVar.a(i)) {
            return super.onTap(i);
        }
        return true;
    }

    public void setOnTapListener(i iVar) {
        this.mOnTapListener = iVar;
    }

    public void show() {
        if (this.mMapGLSurfaceView.getOverlays().contains(this)) {
            hide();
        }
        this.mMapGLSurfaceView.addOverlay(this);
    }

    public String toString() {
        return "BMItemizedOverlay{mLayerID=" + this.mLayerID + ", mType=" + this.mType + ", mOnTapListener" + this.mOnTapListener + '}';
    }

    public BMItemizedOverlay(Drawable drawable) {
        super(drawable, a.h().b());
        this.mMapGLSurfaceView = a.h().b();
    }

    @Override // com.baidu.platform.comapi.map.ItemizedOverlay
    public final boolean onTap(GeoPoint geoPoint, MapSurfaceView mapSurfaceView) {
        com.baidu.nplatform.comapi.basestruct.c cVar = new com.baidu.nplatform.comapi.basestruct.c();
        if (geoPoint != null) {
            cVar.a(geoPoint.getLongitude(), geoPoint.getLatitude());
        }
        i iVar = this.mOnTapListener;
        if (iVar == null || !iVar.a(cVar)) {
            return super.onTap(geoPoint, mapSurfaceView);
        }
        return true;
    }

    @Override // com.baidu.platform.comapi.map.ItemizedOverlay
    public final boolean onTap(int i, int i2, GeoPoint geoPoint) {
        com.baidu.nplatform.comapi.basestruct.c cVar = new com.baidu.nplatform.comapi.basestruct.c();
        if (geoPoint != null) {
            cVar.a(geoPoint.getLongitude(), geoPoint.getLatitude());
        }
        i iVar = this.mOnTapListener;
        if (iVar == null || !iVar.a(i, i2, cVar)) {
            return super.onTap(i, i2, geoPoint);
        }
        return true;
    }
}

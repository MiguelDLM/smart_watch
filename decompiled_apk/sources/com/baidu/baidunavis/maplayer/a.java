package com.baidu.baidunavis.maplayer;

import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.platform.comapi.map.EngineMsgListener;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapViewListener;
import com.baidu.platform.comapi.map.OnLongPressListener;
import com.baidu.platform.comapi.map.Overlay;
import java.util.List;

/* loaded from: classes7.dex */
public class a {
    private static final String e = "a";

    /* renamed from: a, reason: collision with root package name */
    private MapSurfaceView f5577a;
    private MapViewListener b;
    private EngineMsgListener c;
    private OnLongPressListener d;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f5578a = new a();
    }

    public static a h() {
        return b.f5578a;
    }

    private void i() {
        try {
            this.f5577a = MapViewFactory.getInstance().getMapView();
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
    }

    public void a(MapSurfaceView mapSurfaceView) {
        this.f5577a = mapSurfaceView;
    }

    public MapSurfaceView b() {
        return this.f5577a;
    }

    public List<Overlay> c() {
        MapSurfaceView mapSurfaceView = this.f5577a;
        if (mapSurfaceView == null) {
            return null;
        }
        return mapSurfaceView.getOverlays();
    }

    public int d() {
        if (a() != null) {
            return a().getScreenHeight();
        }
        return ScreenUtil.getInstance().getHeightPixels();
    }

    public int e() {
        if (a() != null) {
            return a().getScreenWidth();
        }
        return ScreenUtil.getInstance().getWidthPixels();
    }

    public float f() {
        MapSurfaceView mapSurfaceView = this.f5577a;
        if (mapSurfaceView == null) {
            return 0.0f;
        }
        return mapSurfaceView.getZoomLevel();
    }

    public void g() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(e, "unRegisterMapViewListener,getController():" + a() + ",mMapViewListener:" + this.b + ",mEngineMsgListener:" + this.c);
        }
        if (a() != null) {
            a().setMapViewListener(this.b);
            a().setEngineMsgListener(this.c);
            a().setDoubleClickZoom(true);
            a().setMapClickEnable(true);
        }
        MapSurfaceView mapSurfaceView = this.f5577a;
        if (mapSurfaceView != null) {
            mapSurfaceView.setOnLongPressListener(this.d);
        }
    }

    private a() {
        this.f5577a = null;
        i();
    }

    public MapController a() {
        MapSurfaceView mapSurfaceView = this.f5577a;
        if (mapSurfaceView == null) {
            return null;
        }
        return mapSurfaceView.getController();
    }

    public void b(Overlay overlay) {
        MapSurfaceView mapSurfaceView;
        if (overlay == null || (mapSurfaceView = this.f5577a) == null) {
            return;
        }
        mapSurfaceView.refresh(overlay);
    }

    public synchronized boolean c(Overlay overlay) {
        if (overlay != null) {
            MapSurfaceView mapSurfaceView = this.f5577a;
            if (mapSurfaceView != null) {
                return mapSurfaceView.removeOverlay(overlay);
            }
        }
        return false;
    }

    public synchronized Overlay a(Class<?> cls) {
        MapSurfaceView mapSurfaceView = this.f5577a;
        if (mapSurfaceView == null) {
            return null;
        }
        return mapSurfaceView.getOverlay(cls);
    }

    public synchronized boolean a(Overlay overlay) {
        MapSurfaceView mapSurfaceView = this.f5577a;
        if (mapSurfaceView == null) {
            return false;
        }
        return mapSurfaceView.addOverlay(overlay);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.platform.comapi.map.MapViewListener, com.baidu.platform.comapi.map.EngineMsgListener, com.baidu.baidunavis.maplayer.c, com.baidu.platform.comapi.map.OnLongPressListener] */
    public void a(com.baidu.baidunavis.maplayer.b bVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(e, "registerMapViewListener,mapViewEventListener:" + bVar);
        }
        ?? cVar = new c();
        cVar.a(bVar);
        if (a() != null) {
            this.b = a().getMapViewListener();
            this.c = a().getIndoorMapListener();
            a().setMapViewListener(cVar);
            a().setEngineMsgListener(cVar);
            a().setDoubleClickZoom(true);
            a().setMapClickEnable(true);
        }
        MapSurfaceView mapSurfaceView = this.f5577a;
        if (mapSurfaceView != null) {
            this.d = mapSurfaceView.getOnLongPressListener();
            this.f5577a.setOnLongPressListener(cVar);
        }
    }

    public void a(double d, double d2, int i) {
        if (a() != null) {
            MapStatus mapStatus = a().getMapStatus();
            mapStatus.centerPtX = d;
            mapStatus.centerPtY = d2;
            a(mapStatus, i);
        }
    }

    public void a(MapStatus mapStatus, int i) {
        if (a() != null) {
            a().setMapStatusWithAnimation(mapStatus, i);
        }
    }
}

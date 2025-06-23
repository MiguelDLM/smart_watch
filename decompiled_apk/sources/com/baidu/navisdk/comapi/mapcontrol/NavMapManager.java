package com.baidu.navisdk.comapi.mapcontrol;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.baidu.baidunavis.maplayer.a;
import com.baidu.mapframework.common.mapview.BaseMapViewListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.nplatform.comapi.basestruct.c;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.CaptureMapListener;
import com.baidu.platform.comapi.map.InnerOverlay;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapViewListener;
import com.baidu.platform.comapi.map.NaviMapGestureAdapter;
import com.baidu.platform.comapi.map.NaviMapViewListener;

/* loaded from: classes7.dex */
public class NavMapManager {
    private static final int SlideBarConstant_NORMAL_MODE = 1;
    private static final int SlideBarConstant_SALLATE_MODE = 2;
    private static final String TAG = "NavMapManager";
    private boolean mBaseMapListenerModified;
    private MapViewListener mBaseMapViewListener;
    private boolean mInited;
    private MapController mMapController;
    private int[] mMapOverlays2BClosedInNavi;
    private int[] mMapOverlays2BClosedInRoute;
    private SparseArray<Boolean> mMapOverlaysChangeLog;
    private MapSurfaceView mMapView;
    private NaviMapViewListener mNaviMapViewListener;
    private Object mSyncObj;
    private NaviMapGestureAdapter naviMapGestureAdapter;

    /* loaded from: classes7.dex */
    public static class Holder {
        private static NavMapManager sInstance = new NavMapManager();
    }

    public static NavMapManager getInstance() {
        return Holder.sInstance;
    }

    private InnerOverlay getMapOverlay(int i) {
        try {
            return (InnerOverlay) a.h().b().getOverlay(i);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException(TAG, e);
                return null;
            }
            return null;
        }
    }

    private int getNaviMapMode(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
            case 6:
                return 100;
            default:
                return 0;
        }
    }

    private void logChangeLog() {
        if (LogUtil.LOGGABLE) {
            for (int i = 0; i < this.mMapOverlaysChangeLog.size(); i++) {
                int keyAt = this.mMapOverlaysChangeLog.keyAt(i);
                LogUtil.e(TAG, "logChangeLog: --> key: " + keyAt + ", value: " + this.mMapOverlaysChangeLog.get(keyAt).booleanValue());
            }
        }
    }

    public void addMapObserver(BNMapObserver bNMapObserver) {
        if (bNMapObserver != null) {
            com.baidu.nplatform.comapi.map.a.c().a(bNMapObserver);
        }
    }

    public void addNaviMapListener() {
        LogUtil.e(TAG, "addNaviMapListener: --> ");
        init();
        MapController mapController = this.mMapController;
        if (mapController != null && this.mMapView != null) {
            mapController.setNaviMapViewListener(this.mNaviMapViewListener);
            NaviMapGestureAdapter naviMapGestureAdapter = this.naviMapGestureAdapter;
            if (naviMapGestureAdapter != null) {
                this.mMapView.removeSimpleOnGestureListener(naviMapGestureAdapter);
            } else {
                NaviMapGestureAdapter naviMapGestureAdapter2 = new NaviMapGestureAdapter();
                this.naviMapGestureAdapter = naviMapGestureAdapter2;
                naviMapGestureAdapter2.setMapController(this.mMapController);
            }
            this.mMapView.addSimpleOnGestureListener(this.naviMapGestureAdapter);
        }
    }

    public void clearLocationIcon() {
        LogUtil.e(TAG, "NMM.clearLocationIcon()");
        if (a.h().b() != null) {
            a.h().b().clearDefaultLocationLayerData(new Bundle());
        }
    }

    @Deprecated
    public void closeBlackLayer() {
    }

    public void deleteMapObserver(BNMapObserver bNMapObserver) {
        if (bNMapObserver != null) {
            com.baidu.nplatform.comapi.map.a.c().b(bNMapObserver);
        }
    }

    public void fullviewForCarResult(int i, int i2, int i3, int i4) {
        BNMapController.getInstance().resetRouteDetailIndex();
    }

    public MapController getBaseMapController() {
        return this.mMapController;
    }

    public void getMapScreenshot(final String str, final Handler handler, final int i) {
        MapController mapController = this.mMapController;
        if (mapController != null && str != null && handler != null) {
            try {
                mapController.setCaptureMapListener(new CaptureMapListener() { // from class: com.baidu.navisdk.comapi.mapcontrol.NavMapManager.2
                    @Override // com.baidu.platform.comapi.map.CaptureMapListener
                    public void onGetCaptureMap(boolean z) {
                        LogUtil.e(NavMapManager.TAG, "onGetCaptureMap: isCapOk --> " + z);
                        Message obtainMessage = handler.obtainMessage(i);
                        if (z) {
                            obtainMessage.obj = BitmapFactory.decodeFile(str);
                        } else {
                            obtainMessage.obj = null;
                        }
                        obtainMessage.sendToTarget();
                    }
                });
                this.mMapController.saveScreenToLocal(str);
            } catch (Exception unused) {
            }
        }
    }

    public void handleMapOverlays(int i) {
        LogUtil.e(TAG, "handleMapOverlays: naviMapMode --> " + i);
        if (i == 0) {
            resetMapOverlays();
            return;
        }
        if (i == 100) {
            for (int i2 : this.mMapOverlays2BClosedInRoute) {
                if (isOverlayShowing(i2)) {
                    this.mMapOverlaysChangeLog.put(i2, Boolean.TRUE);
                    setMapOverlayShow(i2, false);
                }
            }
            logChangeLog();
            return;
        }
        for (int i3 : this.mMapOverlays2BClosedInNavi) {
            if (isOverlayShowing(i3)) {
                this.mMapOverlaysChangeLog.put(i3, Boolean.TRUE);
                setMapOverlayShow(i3, false);
            }
        }
        logChangeLog();
    }

    public void handleMapThemeAndScene(int i) {
        boolean z;
        int naviMapMode = getNaviMapMode(i);
        if (naviMapMode != 1 && naviMapMode != 2 && naviMapMode != 3) {
            resetBlackLayer();
        } else {
            closeBlackLayer();
        }
        if (naviMapMode != 1 && naviMapMode != 2 && naviMapMode != 3 && naviMapMode != 4 && naviMapMode != 5) {
            z = false;
        } else {
            z = true;
        }
        g gVar = g.MAP;
        gVar.a("handleMapThemeAndScene:" + i + ", mapMode:" + naviMapMode + ", mapToNav:" + z);
        if (z) {
            if (!NavMapModeManager.getInstance().keyHasCached(NavMapModeManager.CACHE_COMMON_NAVI_PAGE)) {
                NavMapModeManager.getInstance().cacheMapMode(NavMapModeManager.CACHE_COMMON_NAVI_PAGE);
            }
            handleMapOverlays(naviMapMode);
            setNaviMapMode(naviMapMode);
            return;
        }
        setNaviMapMode(naviMapMode);
        NavMapModeManager.getInstance().restoreMapMode(NavMapModeManager.CACHE_COMMON_NAVI_PAGE);
        handleMapOverlays(naviMapMode);
        int a2 = com.baidu.navisdk.module.page.a.b().a();
        if (gVar.e()) {
            gVar.g("handleMapThemeAndScene: lastPageType --> " + a2);
        }
        if (a2 == 1 || a2 == 4) {
            syncMapTraffic();
        }
    }

    public void handleRoadCondition(int i) {
        if (i != 0 && i < 100) {
            BNRoutePlaner.getInstance().a(true);
        } else {
            BNRoutePlaner.getInstance().a(false);
        }
    }

    public void init() {
        g gVar = g.MAP;
        if (gVar.a()) {
            gVar.a(TAG, "init,mInited:" + this.mInited);
        }
        if (this.mInited) {
            return;
        }
        try {
            synchronized (this.mSyncObj) {
                try {
                    if (gVar.a()) {
                        gVar.a(TAG, "init,synchronized,mInited:" + this.mInited);
                    }
                    if (this.mInited) {
                        return;
                    }
                    if (this.mMapView == null) {
                        this.mMapView = a.h().b();
                    }
                    this.mMapController = this.mMapView.getController();
                    Bundle bundle = new Bundle();
                    bundle.putInt(BNMapController.BNMapConfigParams.KEY_SCREEN_WIDTH, this.mMapView.getWidth());
                    bundle.putInt(BNMapController.BNMapConfigParams.KEY_SCREEN_HEIGHT, this.mMapView.getHeight());
                    com.baidu.nplatform.comapi.map.a.c().a(com.baidu.navisdk.framework.a.c().a(), bundle);
                    BNMapController.getInstance().showLayer(9, false);
                    com.baidu.navisdk.comapi.commontool.a.getInstance().c(BNCommSettingManager.getInstance().getNaviDayAndNightMode());
                    if (!this.mMapController.getMapClickEnable()) {
                        this.mMapController.setMapClickEnable(true);
                    }
                    this.mInited = true;
                } finally {
                }
            }
        } catch (Throwable th) {
            this.mInited = false;
            g gVar2 = g.MAP;
            if (gVar2.a()) {
                gVar2.a(TAG, "NavMapManager init crash :" + th.getCause());
                gVar2.a(TAG, "NavMapManager init crash :" + th.getMessage());
            }
        }
    }

    public boolean isMapConfigTrafficOn() {
        MapSurfaceView mapSurfaceView = this.mMapView;
        if (mapSurfaceView != null) {
            return mapSurfaceView.isTraffic();
        }
        return false;
    }

    public boolean isOverlayShowing(int i) {
        InnerOverlay mapOverlay = getMapOverlay(i);
        if (mapOverlay != null) {
            boolean IsOverlayShow = mapOverlay.IsOverlayShow();
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "isOverlayShowing: --> showing: " + IsOverlayShow + ", overlay: " + mapOverlay);
            }
            return IsOverlayShow;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "isOverlayShowing: --> showing: false, mapOverlayId: " + i);
            return false;
        }
        return false;
    }

    public boolean releaseSharedMapData() {
        return BNMapController.getInstance().releaseSharedMapData();
    }

    public void removeNaviMapListener() {
        LogUtil.e(TAG, "removeNaviMapListener: --> ");
        MapController mapController = this.mMapController;
        if (mapController != null && this.mMapView != null) {
            mapController.setNaviMapViewListener(null);
            NaviMapGestureAdapter naviMapGestureAdapter = this.naviMapGestureAdapter;
            if (naviMapGestureAdapter != null) {
                this.mMapView.removeSimpleOnGestureListener(naviMapGestureAdapter);
            }
        }
    }

    public void resetBaseMapViewListener() {
        if (this.mMapController != null && this.mBaseMapListenerModified) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "resetBaseMapViewListener,mBaseMapViewListener:" + this.mBaseMapViewListener);
            }
            this.mBaseMapListenerModified = false;
            this.mMapController.setMapViewListener(this.mBaseMapViewListener);
        }
    }

    @Deprecated
    public void resetBlackLayer() {
    }

    public void resetMapOverlays() {
        MapStatus mapStatus;
        LogUtil.e(TAG, "resetMapOverlays: --> ");
        for (int i : this.mMapOverlays2BClosedInNavi) {
            SparseArray<Boolean> sparseArray = this.mMapOverlaysChangeLog;
            Boolean bool = Boolean.FALSE;
            if (sparseArray.get(i, bool).booleanValue()) {
                this.mMapOverlaysChangeLog.put(i, bool);
                setMapOverlayShow(i, true);
            }
        }
        MapSurfaceView mapSurfaceView = this.mMapView;
        if (mapSurfaceView != null && (mapStatus = mapSurfaceView.getMapStatus()) != null) {
            mapStatus.overlooking = 0;
            mapStatus.rotation = 0;
            mapStatus.xOffset = 0.0f;
            mapStatus.yOffset = 0.0f;
            this.mMapView.setMapStatus(mapStatus);
        }
        logChangeLog();
        LogUtil.e(TAG, "resetMapOverlays: --> end");
    }

    @Deprecated
    public void restoreMapLayer() {
    }

    public void set3DGestureEnable(boolean z) {
        if (this.mMapController != null) {
            LogUtil.e(TAG, "set3DGestureEnable: enable --> " + z);
            this.mMapController.set3DGestureEnable(z);
        }
    }

    public void setBaseMapViewListener(BaseMapViewListener baseMapViewListener) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setBaseMapViewListener,baseMapViewListener:" + baseMapViewListener);
        }
        MapController mapController = this.mMapController;
        if (mapController != null) {
            this.mBaseMapListenerModified = true;
            this.mBaseMapViewListener = mapController.getMapViewListener();
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "setBaseMapViewListener,mBaseMapViewListener:" + this.mBaseMapViewListener);
            }
            this.mMapController.setMapViewListener(baseMapViewListener);
        }
    }

    public void setMapOverlayShow(int i, boolean z) {
        InnerOverlay mapOverlay = getMapOverlay(i);
        if (mapOverlay != null) {
            mapOverlay.SetOverlayShow(z);
            mapOverlay.UpdateOverlay();
        }
    }

    public void setNaviMapMode(int i) {
        LogUtil.e(TAG, "setNaviMapMode: naviMapMode --> " + i);
        if (i >= 100) {
            BNMapController.getInstance().setNaviMapMode(0);
        } else {
            BNMapController.getInstance().setNaviMapMode(i);
        }
    }

    public boolean setOverlookGestureEnable(boolean z) {
        MapController mapController = this.mMapController;
        if (mapController != null) {
            mapController.setOverlookGestureEnable(z);
            return true;
        }
        return false;
    }

    @Deprecated
    public void setScreenShow(int i, int i2, int i3, int i4) {
        LogUtil.e(TAG, "setScreenShow " + i + "," + i2 + "," + i4 + "," + i3);
        BNMapController.getInstance().setMapShowScreenRect(ScreenUtil.getInstance().dip2px(i3), ScreenUtil.getInstance().dip2px(i), ScreenUtil.getInstance().getWidthPixels() - ScreenUtil.getInstance().dip2px(i4), ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().dip2px(i2));
    }

    public void syncMapTraffic() {
        if (this.mMapView != null) {
            boolean isMapConfigTrafficOn = isMapConfigTrafficOn();
            LogUtil.e(TAG, "syncMapTraffic: isMapConfigTrafficOn --> " + isMapConfigTrafficOn);
            this.mMapView.forceSetTraffic(isMapConfigTrafficOn);
        }
    }

    public void unInit() {
        int i;
        try {
            synchronized (this.mSyncObj) {
                try {
                    LogUtil.e(TAG, "unInit: --> ");
                    com.baidu.nplatform.comapi.map.a.c().b();
                    if (this.mMapController != null) {
                        if (isMapConfigTrafficOn()) {
                            i = 5;
                        } else {
                            i = 0;
                        }
                        this.mMapController.setMapThemeScene(1, i, new Bundle());
                        this.mMapController.setOverlookGestureEnable(true);
                    }
                    set3DGestureEnable(b.T());
                    resetMapOverlays();
                    this.mInited = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            this.mInited = false;
            LogUtil.e(TAG, "unInit: Exception --> " + th2.getMessage());
        }
    }

    public boolean updateShareMapData() {
        return BNMapController.getInstance().updateShareMapData();
    }

    private NavMapManager() {
        this.mSyncObj = new Object();
        this.mMapView = null;
        this.mMapController = null;
        this.mBaseMapViewListener = null;
        this.mInited = false;
        this.mBaseMapListenerModified = false;
        this.mMapOverlays2BClosedInNavi = new int[]{7, 20, 12};
        this.mMapOverlays2BClosedInRoute = new int[]{20};
        this.mMapOverlaysChangeLog = new SparseArray<>();
        this.mNaviMapViewListener = new NaviMapViewListener() { // from class: com.baidu.navisdk.comapi.mapcontrol.NavMapManager.1
            @Override // com.baidu.platform.comapi.map.NaviMapViewListener
            public void onAction(int i, Object obj) {
                com.baidu.nplatform.comapi.map.a.c().a(i, obj);
            }

            @Override // com.baidu.platform.comapi.map.NaviMapViewListener
            public boolean onItemClick(String str, int i, int i2) {
                g gVar = g.MAP;
                if (gVar.d()) {
                    gVar.e(NavMapManager.TAG, "onItemClick: mapObjJson --> " + str);
                }
                return com.baidu.nplatform.comapi.map.a.c().a(str, i, i2);
            }

            @Override // com.baidu.platform.comapi.map.NaviMapViewListener
            public void onMapAnimationFinish() {
                com.baidu.nplatform.comapi.map.a.c().a();
            }

            @Override // com.baidu.platform.comapi.map.NaviMapViewListener
            public void onMapRenderModeChange(int i) {
            }

            @Override // com.baidu.platform.comapi.map.NaviMapViewListener
            public Point onTapInterception(Point point) {
                if (point == null) {
                    return null;
                }
                c a2 = com.baidu.nplatform.comapi.map.a.c().a(new c(point.getIntX(), point.getIntY()));
                if (a2 != null) {
                    point.setIntX(a2.c());
                    point.setIntY(a2.d());
                }
                return point;
            }

            @Override // com.baidu.platform.comapi.map.NaviMapViewListener
            public void resizeScreen(int i, int i2) {
                BNMapController.getInstance().resizeScreen(i, i2);
            }
        };
        this.naviMapGestureAdapter = null;
    }
}

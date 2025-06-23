package com.baidu.navisdk.comapi.mapcontrol;

import android.os.Bundle;
import com.baidu.baidunavis.maplayer.a;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.statistic.q;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.MapSurfaceView;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class NavMapModeManager {
    public static final String CACHE_COMMON_NAVI_PAGE = "cache_common_navi_page";
    public static final boolean NAV_THEME_SCENE_BYSELF = false;
    private static final String TAG = "NavMapModeManager";
    private static NavMapModeManager self;
    private int cacheMapTheme = -99;
    private int cacheMapScene = -99;
    private boolean cacheIsOverlookGestureEnable = true;
    private final HashMap<String, CacheMode> cacheModes = new HashMap<>();

    /* loaded from: classes7.dex */
    public static class CacheMode {
        public int cacheMapTheme = -99;
        public int cacheMapScene = -99;
        public boolean cacheIsOverlookGestureEnable = true;
    }

    private NavMapModeManager() {
    }

    private boolean checkCacheOK() {
        int i;
        int i2 = this.cacheMapTheme;
        if (i2 >= 0 && i2 != 9 && (i = this.cacheMapScene) >= 0 && i != 2) {
            return true;
        }
        return false;
    }

    public static void destroy() {
        NavMapModeManager navMapModeManager = self;
        if (navMapModeManager != null) {
            navMapModeManager.reset();
        }
    }

    public static NavMapModeManager getInstance() {
        if (self == null) {
            self = new NavMapModeManager();
        }
        return self;
    }

    private int getTheme() {
        int i = this.cacheMapTheme;
        if (i != 1 && i != 3) {
            return 1;
        }
        return i;
    }

    public void cacheMapMode() {
        if (checkCacheOK()) {
            return;
        }
        MapSurfaceView b = a.h().b();
        if (b != null) {
            this.cacheMapTheme = b.getController().getMapTheme();
            this.cacheMapScene = 0;
            this.cacheIsOverlookGestureEnable = b.getController().isOverlookGestureEnable();
            if (this.cacheMapTheme == 9) {
                this.cacheMapTheme = 1;
            }
            if (this.cacheMapTheme == 0) {
                this.cacheMapTheme = 1;
            }
            int i = this.cacheMapScene;
            if (i == 2 || isNaviScene(i)) {
                this.cacheMapScene = 0;
                return;
            }
            return;
        }
        this.cacheMapScene = -99;
        this.cacheIsOverlookGestureEnable = true;
    }

    public void changeMapObserver(BNMapObserver bNMapObserver) {
        changeMapObserver(bNMapObserver, false);
    }

    public void changeMode(boolean z, BNMapObserver bNMapObserver) {
        changeMode(z, bNMapObserver, false);
    }

    public int getCurrentMapTheme() {
        MapSurfaceView b = a.h().b();
        if (b != null) {
            return b.getController().getMapTheme();
        }
        return 1;
    }

    public boolean isNaviScene(int i) {
        return i >= 8 && i <= 19;
    }

    public void justChangeThemeScene() {
        justChangeThemeScene(false);
    }

    public boolean keyHasCached(String str) {
        if (str != null && str.length() != 0 && this.cacheModes.containsKey(str)) {
            LogUtil.e(TAG, "keyHasCached: true --> key: " + str);
            return true;
        }
        LogUtil.e(TAG, "keyHasCached: false --> key: " + str);
        return false;
    }

    public void reset() {
        this.cacheMapTheme = -99;
        this.cacheMapScene = -99;
        this.cacheIsOverlookGestureEnable = true;
        this.cacheModes.clear();
    }

    public void restoreMapMode() {
        restoreMapMode(false);
    }

    public void setMapScene(int i) {
        LogUtil.e(TAG, "setMapScene.scene=" + i);
        if (a.h().b() != null) {
            a.h().b().getController().setMapScene(i);
        }
    }

    public void setMapSceneByJNI(int i) {
        LogUtil.e(TAG, "setMapSceneByJNI.scene=" + i);
        if (MapViewFactory.getInstance().getMapView() != null) {
            MapViewFactory.getInstance().getMapView().getController().setMapScene(i);
        }
    }

    public void setMapSceneForce(int i) {
        LogUtil.e(TAG, "setMapSceneForce.scene=" + i);
        if (a.h().b() != null) {
            a.h().b().getController().forceSetMapScene(i);
        }
    }

    public void setMapTheme(int i) {
        LogUtil.e(TAG, "setMapTheme.theme=" + i);
        if (a.h().b() != null) {
            a.h().b().getController().setMapTheme(i, new Bundle());
        }
    }

    public void setMapThemeByJNI(int i) {
        LogUtil.e(TAG, "setMapThemeByJNI.theme=" + i);
        if (a.h().b() != null) {
            a.h().b().getController().setMapTheme(i, new Bundle());
        }
    }

    public void setMapThemeScene(int i, int i2) {
        LogUtil.e(TAG, "setMapThemeScene.theme=" + i + ", scene=" + i2);
        if (a.h().b() != null) {
            a.h().b().getController().setMapThemeScene(i, i2, new Bundle());
        }
    }

    public void setMapThemeSceneByJNI(int i, int i2) {
        LogUtil.e(TAG, "setMapThemeSceneByJNI.theme=" + i + ", scene=" + i2 + ", self=false");
        if (MapViewFactory.getInstance().getMapView() != null) {
            a.h().b().getController().setMapThemeScene(i, i2, new Bundle());
        }
    }

    public void setMapThemeSceneForce(int i, int i2) {
        LogUtil.e(TAG, "setMapThemeSceneForce.theme=" + i + ", scene=" + i2);
        if (a.h().b() != null) {
            a.h().b().getController().forceSetMapThemeScene(i, i2, new Bundle());
        }
    }

    public boolean setPreRoutePlanStatus(boolean z) {
        return BNMapController.getInstance().setPreRoutePlanStatus(z);
    }

    private void restoreMapMode(boolean z) {
        int i;
        g.MAP.a("restoreMapMode " + z);
        MapSurfaceView b = a.h().b();
        b.g(true);
        int i2 = this.cacheMapTheme;
        if (i2 < 0 || (i = this.cacheMapScene) < 0) {
            if (z && i2 >= 0 && b != null) {
                setMapTheme(i2);
            }
            int i3 = this.cacheMapScene;
            if (i3 >= 0) {
                if (z) {
                    if (i3 != 0 && i3 != 5) {
                        setMapSceneForce(i3);
                    } else {
                        setMapSceneForce(MapViewFactory.getInstance().getMapView().isTraffic() ? 5 : 0);
                    }
                }
                if (b != null) {
                    b.getController().setOverlookGestureEnable(this.cacheIsOverlookGestureEnable);
                }
            }
        } else if (b != null) {
            if (i != 0 && i != 5) {
                r2 = i;
            } else if (a.h().b().isTraffic()) {
                r2 = 5;
            }
            if (z) {
                setMapThemeScene(this.cacheMapTheme, r2);
            }
            b.getController().setOverlookGestureEnable(this.cacheIsOverlookGestureEnable);
            LogUtil.e(TAG, "restoreMapMode() theme=" + this.cacheMapTheme + ", scene=" + r2 + ", over=" + this.cacheIsOverlookGestureEnable);
        }
        NavMapManager.getInstance().resetBlackLayer();
    }

    public void changeMapObserver(BNMapObserver bNMapObserver, boolean z) {
        if (z) {
            NavMapManager.getInstance().deleteMapObserver(bNMapObserver);
        } else {
            NavMapManager.getInstance().addMapObserver(bNMapObserver);
        }
    }

    public void changeMode(boolean z, BNMapObserver bNMapObserver, boolean z2) {
        boolean isMapConfigTrafficOn;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = c.p().h();
        boolean z3 = h != null && h.x0();
        g gVar = g.MAP;
        gVar.a("changeMode f " + z + ",nav" + z3);
        if (z3) {
            return;
        }
        if (gVar.e()) {
            gVar.g(TAG, "changeMode cacheMapTheme=" + this.cacheMapTheme + ", isDrawRouteByMap:" + z2);
        }
        MapSurfaceView b = a.h().b();
        if (z2 && !z) {
            NavMapManager.getInstance().removeNaviMapListener();
            NavMapManager.getInstance().handleRoadCondition(0);
            NavMapManager.getInstance().setNaviMapMode(0);
            NavMapManager.getInstance().handleMapOverlays(0);
            NavMapManager.getInstance().deleteMapObserver(bNMapObserver);
            if (BNRoutePlaner.getInstance().i() == 2) {
                b.getController().setOverlookGestureEnable(this.cacheIsOverlookGestureEnable);
            } else {
                restoreMapMode(true);
            }
        } else {
            if (j.d() && this.cacheMapScene != 5 && j.d() && (isMapConfigTrafficOn = NavMapManager.getInstance().isMapConfigTrafficOn())) {
                MapViewFactory.getInstance().getMapView().setTraffic(isMapConfigTrafficOn);
            }
            b.g(false);
            NavMapManager.getInstance().addNaviMapListener();
            NavMapManager.getInstance().handleMapOverlays(5);
            NavMapManager.getInstance().setNaviMapMode(5);
            NavMapManager.getInstance().handleRoadCondition(5);
            NavMapManager.getInstance().addMapObserver(bNMapObserver);
        }
        BNRouteGuider.getInstance().setBrowseStatus(true);
        if (b != null) {
            b.getController().setOverlookGestureEnable(false);
            MapStatus mapStatus = b.getMapStatus();
            if (mapStatus != null) {
                mapStatus.overlooking = 0;
                mapStatus.rotation = 0;
                b.setMapStatus(mapStatus);
            }
        }
        if (LogUtil.LOGGABLE) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("changeMode() theme=");
            int i = this.cacheMapTheme;
            sb.append(i >= 0 ? i : 1);
            sb.append(", scene=");
            sb.append(2);
            sb.append(", over=");
            sb.append(this.cacheIsOverlookGestureEnable);
            LogUtil.e(str, sb.toString());
            LogUtil.printCallStack();
        }
    }

    public void justChangeThemeScene(boolean z) {
        a.h().b();
        if (z) {
            NavMapManager.getInstance().setNaviMapMode(0);
        } else {
            NavMapManager.getInstance().setNaviMapMode(5);
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("justChangeThemeScene() theme=");
        int i = this.cacheMapTheme;
        if (i < 0) {
            i = 1;
        }
        sb.append(i);
        sb.append(", scene=");
        sb.append(2);
        sb.append(", over=");
        sb.append(this.cacheIsOverlookGestureEnable);
        LogUtil.e(str, sb.toString());
    }

    public void cacheMapMode(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        CacheMode cacheMode = new CacheMode();
        MapSurfaceView b = a.h().b();
        if (b != null) {
            cacheMode.cacheMapTheme = b.getController().getMapTheme();
            cacheMode.cacheMapScene = 0;
            cacheMode.cacheIsOverlookGestureEnable = b.getController().isOverlookGestureEnable();
            if (cacheMode.cacheMapTheme == 9) {
                cacheMode.cacheMapTheme = 1;
            }
            int i = cacheMode.cacheMapScene;
            if (i == 2 || isNaviScene(i)) {
                cacheMode.cacheMapScene = 0;
            }
        } else {
            cacheMode.cacheMapScene = -99;
            cacheMode.cacheIsOverlookGestureEnable = true;
        }
        LogUtil.e(TAG, "cacheMapMode: --> cacheKey: " + str + ", theme: " + cacheMode.cacheMapTheme + ", scene: " + cacheMode.cacheMapScene);
        this.cacheModes.put(str, cacheMode);
    }

    public void restoreMapMode(String str) {
        CacheMode cacheMode;
        int i;
        if (str == null || str.length() == 0 || !this.cacheModes.containsKey(str) || (cacheMode = this.cacheModes.get(str)) == null) {
            return;
        }
        q.a(0, "map_setmpamode_start", System.currentTimeMillis());
        MapSurfaceView b = a.h().b();
        if (cacheMode.cacheMapTheme < 0 || (i = cacheMode.cacheMapScene) < 0) {
            if (cacheMode.cacheMapScene >= 0 && b != null) {
                b.getController().setOverlookGestureEnable(cacheMode.cacheIsOverlookGestureEnable);
            }
        } else if (b != null) {
            if (i == 0 || i == 5) {
                a.h().b().isTraffic();
            }
            b.getController().setOverlookGestureEnable(cacheMode.cacheIsOverlookGestureEnable);
        }
        this.cacheModes.remove(str);
    }
}

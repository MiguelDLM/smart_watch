package com.baidu.mapapi.bikenavi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
import com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.adapter.IBTTSPlayer;
import com.baidu.mapapi.bikenavi.controllers.BNavigatorWrapper;
import com.baidu.mapapi.bikenavi.controllers.UnsupportedBikeNaviException;
import com.baidu.mapapi.bikenavi.controllers.a.a;
import com.baidu.mapapi.bikenavi.model.BikeExtraNaviMode;
import com.baidu.mapapi.bikenavi.model.BikeLightNaviManager;
import com.baidu.mapapi.bikenavi.model.BikeNaviDisplayOption;
import com.baidu.mapapi.bikenavi.model.BikeNormalNaviManager;
import com.baidu.mapapi.bikenavi.params.BikeNaviLaunchParam;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;

/* loaded from: classes7.dex */
public class BikeNavigateHelper {
    private static BikeNavigateHelper i;

    /* renamed from: a, reason: collision with root package name */
    boolean f5766a;
    Activity b;
    Activity c;
    private BikeLightNaviManager g;
    private BikeNormalNaviManager h;
    private boolean e = false;
    private boolean f = false;
    private a d = new a();

    private BikeNavigateHelper() {
    }

    public static BikeNavigateHelper getInstance() {
        if (i == null) {
            i = new BikeNavigateHelper();
        }
        return i;
    }

    public BikeLightNaviManager getLightNaviManager() {
        if (this.g == null) {
            this.g = new BikeLightNaviManager(this.d);
        }
        return this.g;
    }

    public MapView getNaviMap() {
        a aVar = this.d;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    public BikeNormalNaviManager getNormalNaviManager() {
        if (this.h == null) {
            this.h = new BikeNormalNaviManager(this.d);
        }
        return this.h;
    }

    public void initNaviEngine(Activity activity, IBEngineInitListener iBEngineInitListener) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(activity, iBEngineInitListener);
            this.e = true;
        }
    }

    public boolean isInitEngine() {
        return this.e;
    }

    public void naviToOverView() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.f();
        }
    }

    public View onCreate(Activity activity) {
        a aVar = this.d;
        if (aVar != null) {
            this.b = activity;
            return aVar.a(activity);
        }
        return null;
    }

    public void onDestroy(boolean z) {
        if (!z) {
            return;
        }
        this.g = null;
        this.h = null;
        this.f5766a = false;
        if (i != null) {
            i = null;
        }
    }

    public void pause() {
        b.a().j();
        a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void quit() {
        if (b.a().Y() != null) {
            b.a().Y().t();
        }
        b.a().n();
        b.a().C();
        b.a().k();
        a aVar = this.d;
        if (aVar != null) {
            aVar.d();
            this.d = null;
        }
        this.f5766a = false;
        this.b = null;
        if (i != null) {
            i = null;
        }
    }

    public void resume() {
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing()) {
            b.a().i();
            a aVar = this.d;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void routePlanWithParams(BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        a aVar = this.d;
        if (aVar != null) {
            if (aVar.a()) {
                if (bikeNaviLaunchParam != null && bikeNaviLaunchParam.getStartPt() != null && bikeNaviLaunchParam.getEndPt() != null) {
                    GeoPoint ll2mc = CoordUtil.ll2mc(bikeNaviLaunchParam.getStartPt());
                    GeoPoint ll2mc2 = CoordUtil.ll2mc(bikeNaviLaunchParam.getEndPt());
                    com.baidu.platform.comapi.walknavi.f.a create = BikeNaviLaunchParam.create();
                    if (bikeNaviLaunchParam.getVehicle() == 1) {
                        create.a(bikeNaviLaunchParam.getVehicle());
                    }
                    create.b(1);
                    BNavigatorWrapper.getWNavigator().e(1);
                    BNavigatorWrapper.getWNavigator().f(bikeNaviLaunchParam.getExtraNaviMode());
                    b.a().a(bikeNaviLaunchParam.getStartPt());
                    b.a().b(bikeNaviLaunchParam.getEndPt());
                    create.a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), 131);
                    create.c(0);
                    create.a(new int[]{(int) ll2mc2.getLongitudeE6()}, new int[]{(int) ll2mc2.getLatitudeE6()}, new int[]{131});
                    com.baidu.platform.comapi.wnplatform.j.a.a().a(create, iBRoutePlanListener);
                    return;
                }
                throw new UnsupportedBikeNaviException("BDMapSDKException: launch param or startPt or endPt cannot be null");
            }
            throw new UnsupportedBikeNaviException("BDMapSDKException: naviengine init failed, please init naviengine first");
        }
    }

    public void routePlanWithRouteNode(BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        if (this.d == null || b.a().K().p()) {
            return;
        }
        if (this.d.a()) {
            if (bikeNaviLaunchParam != null) {
                if (bikeNaviLaunchParam.getStartNodeInfo() != null && bikeNaviLaunchParam.getEndNodeInfo() != null) {
                    if (bikeNaviLaunchParam.getStartNodeInfo().getLocation() != null && bikeNaviLaunchParam.getEndNodeInfo().getLocation() != null) {
                        BikeNaviLaunchParam copy = bikeNaviLaunchParam.copy();
                        if (copy.getStartNodeInfo() != null && copy.getStartNodeInfo().getLocation() != null) {
                            com.baidu.platform.comapi.wnplatform.j.a.a().b(copy, iBRoutePlanListener);
                            return;
                        } else {
                            com.baidu.platform.comapi.wnplatform.j.a.a().a(copy, iBRoutePlanListener);
                            return;
                        }
                    }
                    throw new UnsupportedBikeNaviException("BDMapSDKException: the start and end location cannot be null");
                }
                throw new UnsupportedBikeNaviException("BDMapSDKException:  startNode or endNodeInfo cannot be null");
            }
            throw new UnsupportedBikeNaviException("BDMapSDKException: launch param cannot be null");
        }
        throw new UnsupportedBikeNaviException("BDMapSDKException: naviengine init failed, please init naviengine first");
    }

    public void setBikeNaviDisplayOption(BikeNaviDisplayOption bikeNaviDisplayOption) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(bikeNaviDisplayOption);
        }
    }

    public void setBikeNaviStatusListener(IBNaviStatusListener iBNaviStatusListener) {
        b.a().a(iBNaviStatusListener);
    }

    public void setExtraNaviMode(BikeExtraNaviMode bikeExtraNaviMode) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(bikeExtraNaviMode.getValue());
        }
    }

    public void setIsSwitchNavi(boolean z) {
        this.f = z;
    }

    public boolean setNaviMapUp() {
        MapView e = this.d.e();
        if (e != null) {
            e.setZOrderMediaOverlay(true);
            return true;
        }
        return false;
    }

    public void setRouteGuidanceListener(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        if (iBRouteGuidanceListener != null) {
            this.d.a(activity, iBRouteGuidanceListener);
        }
    }

    public void setTTsPlayer(IBTTSPlayer iBTTSPlayer) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(iBTTSPlayer);
        }
    }

    public void showUIDebuggable(String str) {
        this.d.a(str);
    }

    public boolean startBikeNavi(Activity activity) {
        if (!b.a().a(activity, (Bundle) null)) {
            return false;
        }
        if (!this.f5766a) {
            if (!b.a().u()) {
                return false;
            }
            this.f5766a = true;
        } else if (this.f) {
            if (!b.a().u()) {
                return false;
            }
            this.f = false;
        }
        return true;
    }

    public void triggerLocation(WLocData wLocData) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(wLocData);
        }
    }

    public void unInitNaviEngine() {
        b.a().C();
        b.a().k();
        a aVar = this.d;
        if (aVar != null) {
            aVar.d();
            this.d = null;
        }
        this.f5766a = false;
        this.e = false;
        this.b = null;
        this.c = null;
        if (i != null) {
            i = null;
        }
    }
}

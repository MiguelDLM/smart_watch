package com.baidu.mapapi.walknavi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviCalcRouteListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.MultiRouteDisplayOption;
import com.baidu.mapapi.walknavi.model.WalkExtraNaviMode;
import com.baidu.mapapi.walknavi.model.WalkLightNaviManager;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.mapapi.walknavi.model.WalkNormalNaviManager;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.RouteNodeType;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.platform.comapi.walknavi.f.c;
import com.baidu.platform.comapi.wnplatform.j.f;
import com.baidu.platform.comapi.wnplatform.j.h;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class WalkNavigateHelper {
    private static WalkNavigateHelper h;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6026a;
    private Activity e;
    private c g;
    private WalkLightNaviManager j;
    private WalkNormalNaviManager k;
    private f l;
    private boolean b = false;
    private boolean c = false;
    private int d = 0;
    private boolean f = false;
    private boolean i = false;
    public com.baidu.mapapi.walknavi.controllers.a.a walkNaviManager = new com.baidu.mapapi.walknavi.controllers.a.a();

    private WalkNavigateHelper() {
    }

    public static WalkNavigateHelper getInstance() {
        if (h == null) {
            h = new WalkNavigateHelper();
        }
        return h;
    }

    public void addMoreNPCModelOnClickListener(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(iWMoreNPCModelOnClickListener);
        }
    }

    public void addNPCLoadAndInitListener(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(iWNPCLoadAndInitListener);
        }
    }

    public List<Polyline> displayRoutePlanResult(MapView mapView, MultiRouteDisplayOption multiRouteDisplayOption) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            return aVar.a(mapView, multiRouteDisplayOption);
        }
        return null;
    }

    public WalkLightNaviManager getLightNaviManager() {
        if (this.j == null) {
            this.j = new WalkLightNaviManager(this.walkNaviManager);
        }
        return this.j;
    }

    public MapView getNaviMap() {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            return aVar.i();
        }
        return null;
    }

    public WalkNormalNaviManager getNormalNaviManager() {
        if (this.k == null) {
            this.k = new WalkNormalNaviManager(this.walkNaviManager);
        }
        return this.k;
    }

    public ArrayList<BaseNpcModel> getWalkNpcModelInfoList() {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public boolean hasIndoorRoute() {
        return this.i;
    }

    public void initNaviEngine(Activity activity, IWEngineInitListener iWEngineInitListener) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(activity, iWEngineInitListener);
            this.f = true;
        }
    }

    public boolean isInit() {
        return this.f6026a;
    }

    public boolean isInitEngine() {
        return this.f;
    }

    public void naviCalcRoute(int i, IWNaviCalcRouteListener iWNaviCalcRouteListener) {
        com.baidu.platform.comapi.walknavi.b.a().a(i);
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(this.g, i, iWNaviCalcRouteListener);
        }
    }

    public void naviToOverView() {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.c();
        }
    }

    public View onCreate(Activity activity) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            this.e = activity;
            return aVar.a(activity);
        }
        return null;
    }

    public void onDestroy(boolean z) {
        if (!z) {
            return;
        }
        if (this.l != null) {
            com.baidu.platform.comapi.walknavi.b.a().b(this.l);
        }
        this.k = null;
        this.j = null;
        this.f6026a = false;
        this.g = null;
        if (h != null) {
            h = null;
        }
    }

    public void pause() {
        com.baidu.platform.comapi.walknavi.b.a().j();
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void quit() {
        if (com.baidu.platform.comapi.walknavi.b.a().Y() != null) {
            com.baidu.platform.comapi.walknavi.b.a().Y().t();
        }
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null && this.f6026a) {
            aVar.g();
            this.walkNaviManager.h();
        }
        com.baidu.platform.comapi.walknavi.b.a().n();
        com.baidu.platform.comapi.walknavi.b.a().C();
        com.baidu.platform.comapi.walknavi.b.a().k();
        com.baidu.mapapi.walknavi.controllers.a.a aVar2 = this.walkNaviManager;
        if (aVar2 != null) {
            aVar2.f();
            this.walkNaviManager = null;
        }
        this.f6026a = false;
        this.e = null;
        this.g = null;
        if (h != null) {
            h = null;
        }
    }

    public void resume() {
        Activity activity = this.e;
        if (activity != null && !activity.isFinishing()) {
            com.baidu.platform.comapi.walknavi.b.a().i();
            com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
            if (aVar != null) {
                aVar.e();
            }
        }
    }

    public void routePlanWithParams(WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            if (aVar.a()) {
                if (walkNaviLaunchParam != null && walkNaviLaunchParam.getStartPt() != null && walkNaviLaunchParam.getEndPt() != null) {
                    if (walkNaviLaunchParam.getExtraNaviMode() == 1 && !b()) {
                        if (iWRoutePlanListener != null) {
                            iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.INVAILD_PERMISSION);
                            return;
                        }
                        return;
                    }
                    if ((!walkNaviLaunchParam.getStartNodeInfo().getBuildingID().isEmpty() || !walkNaviLaunchParam.getEndNodeInfo().getBuildingID().isEmpty()) && !a()) {
                        if (iWRoutePlanListener != null) {
                            iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.INVAILD_PERMISSION);
                            return;
                        }
                        return;
                    } else if (h.a().a(walkNaviLaunchParam)) {
                        if (iWRoutePlanListener != null) {
                            iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_LESS_THAN_30M);
                            return;
                        }
                        return;
                    } else {
                        if (h.a().b(walkNaviLaunchParam)) {
                            if (iWRoutePlanListener != null) {
                                iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_MORE_THAN_50KM);
                                return;
                            }
                            return;
                        }
                        h.a().a(walkNaviLaunchParam, iWRoutePlanListener, false);
                        return;
                    }
                }
                throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: launch param or startPt or endPt cannot be null");
            }
            throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: naviengine init failed, please init naviengine first");
        }
    }

    public void routePlanWithRouteNode(WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener) {
        if (this.walkNaviManager == null || com.baidu.platform.comapi.walknavi.b.a().K().p()) {
            return;
        }
        if (this.walkNaviManager.a()) {
            if (walkNaviLaunchParam != null) {
                this.d = walkNaviLaunchParam.getExtraNaviMode();
                if (walkNaviLaunchParam.getExtraNaviMode() == 1 && !b()) {
                    if (iWRoutePlanListener != null) {
                        iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.INVAILD_PERMISSION);
                        return;
                    }
                    return;
                }
                if (walkNaviLaunchParam.getStartNodeInfo() != null && walkNaviLaunchParam.getEndNodeInfo() != null) {
                    WalkNaviLaunchParam copy = walkNaviLaunchParam.copy();
                    RouteNodeType type = copy.getStartNodeInfo().getType();
                    RouteNodeType routeNodeType = RouteNodeType.LOCATION;
                    if (type != routeNodeType && copy.getEndNodeInfo().getType() != routeNodeType) {
                        RouteNodeType type2 = copy.getStartNodeInfo().getType();
                        RouteNodeType routeNodeType2 = RouteNodeType.KEYWORD;
                        if (type2 == routeNodeType2 || copy.getEndNodeInfo().getType() == routeNodeType2) {
                            if (copy.getStartNodeInfo().getKeyword() != null && copy.getEndNodeInfo().getKeyword() != null && !copy.getStartNodeInfo().getKeyword().isEmpty() && !copy.getEndNodeInfo().getKeyword().isEmpty()) {
                                if ((!copy.getStartNodeInfo().getBuildingID().isEmpty() || !copy.getEndNodeInfo().getBuildingID().isEmpty()) && !a()) {
                                    if (iWRoutePlanListener != null) {
                                        iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.INVAILD_PERMISSION);
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: if WalkRouteNodeInfo's type is RouteNodeType.KEYWORD ,the startNodeInfo and endNodeInfo keyword cannot be null or empty");
                            }
                        }
                        WNavigatorWrapper.getWNavigator().a(0, 0);
                        if (this.l == null) {
                            this.l = new a(this, iWRoutePlanListener, copy);
                        }
                        com.baidu.platform.comapi.walknavi.b.a().a(this.l);
                        com.baidu.platform.comapi.walknavi.b.a().J().a(copy);
                        return;
                    }
                    if (copy.getStartNodeInfo().getLocation() != null && copy.getEndNodeInfo().getLocation() != null) {
                        if (copy.getStartNodeInfo() != null && copy.getStartNodeInfo().getLocation() != null) {
                            if (h.a().a(copy)) {
                                if (iWRoutePlanListener != null) {
                                    iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_LESS_THAN_30M);
                                    return;
                                }
                                return;
                            } else {
                                if (h.a().b(copy)) {
                                    if (iWRoutePlanListener != null) {
                                        iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_MORE_THAN_50KM);
                                        return;
                                    }
                                    return;
                                }
                                h.a().a(copy, iWRoutePlanListener, true);
                                return;
                            }
                        }
                        h.a().a(copy, iWRoutePlanListener);
                        return;
                    }
                    throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: the start and end location cannot be null");
                }
                throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException:  startNode or endNodeInfo cannot be null");
            }
            throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: launch param cannot be null");
        }
        throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: naviengine init failed, please init naviengine first");
    }

    public void setExtraNaviMode(WalkExtraNaviMode walkExtraNaviMode) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(walkExtraNaviMode.getValue());
        }
    }

    public void setIsSwitchNavi(boolean z) {
        this.c = z;
    }

    public void setRouteGuidanceListener(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        if (iWRouteGuidanceListener != null) {
            this.walkNaviManager.a(activity, iWRouteGuidanceListener);
        }
    }

    public void setTTsPlayer(IWTTSPlayer iWTTSPlayer) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(iWTTSPlayer);
        }
    }

    public void setWalkNaviDisplayOption(WalkNaviDisplayOption walkNaviDisplayOption) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(walkNaviDisplayOption);
        }
    }

    public void setWalkNaviStatusListener(IWNaviStatusListener iWNaviStatusListener) {
        com.baidu.platform.comapi.walknavi.b.a().a(iWNaviStatusListener);
    }

    public void setWalkNpcModelInfoList(ArrayList<BaseNpcModel> arrayList) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(arrayList);
        }
    }

    public void startCameraAndSetMapView(Activity activity) {
        this.walkNaviManager.b(activity);
    }

    public boolean startWalkNavi(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (this.d == 1) {
            if (com.baidu.platform.comapi.wnplatform.f.a().c() && !PermissionUtils.getInstance().isWalkARNaviAuthorized()) {
                return false;
            }
            com.baidu.platform.comapi.wnplatform.c.a().a(activity, new b(this, activity));
        } else {
            this.b = com.baidu.platform.comapi.walknavi.b.a().a(activity, (Bundle) null);
        }
        if (!this.b) {
            return false;
        }
        if (!this.f6026a) {
            if (!com.baidu.platform.comapi.walknavi.b.a().u()) {
                return false;
            }
            this.f6026a = true;
        } else if (this.c) {
            if (!com.baidu.platform.comapi.walknavi.b.a().u()) {
                return false;
            }
            this.c = false;
        }
        return true;
    }

    public void switchNPCModel(BaseNpcModel baseNpcModel) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(baseNpcModel);
        }
    }

    public void switchWalkNaviMode(Activity activity, int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(activity, i, walkNaviModeSwitchListener);
        }
    }

    public void triggerLocation(WLocData wLocData) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.a(wLocData);
        }
    }

    public void unInitNaviEngine() {
        com.baidu.platform.comapi.walknavi.b.a().C();
        com.baidu.platform.comapi.walknavi.b.a().k();
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.walkNaviManager;
        if (aVar != null) {
            aVar.f();
            this.walkNaviManager = null;
        }
        this.f6026a = false;
        this.f = false;
        this.e = null;
        this.g = null;
        if (h != null) {
            h = null;
        }
    }

    private boolean b() {
        return PermissionUtils.getInstance().isWalkARNaviAuthorized();
    }

    private boolean a() {
        return PermissionUtils.getInstance().isIndoorNaviAuthorized();
    }
}

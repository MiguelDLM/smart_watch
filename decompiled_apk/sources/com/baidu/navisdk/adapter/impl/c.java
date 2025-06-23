package com.baidu.navisdk.adapter.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.baidu.baidunavis.baseline.BNOuterMapViewManager;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.navisdk.GpsRealTime;
import com.baidu.navisdk.adapter.BNRoutePlanNode;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.adapter.IBNRouteGuideManager;
import com.baidu.navisdk.adapter.IBNaviListener;
import com.baidu.navisdk.adapter.IBNaviViewListener;
import com.baidu.navisdk.adapter.impl.base.BNaviAuthManager;
import com.baidu.navisdk.adapter.impl.base.a;
import com.baidu.navisdk.adapter.sl.BNCarPoolManager;
import com.baidu.navisdk.adapter.sl.BNShareLocationManager;
import com.baidu.navisdk.adapter.struct.BNGuideConfig;
import com.baidu.navisdk.adapter.struct.BNRoutePlanInfo;
import com.baidu.navisdk.adapter.struct.BNSearchPoi;
import com.baidu.navisdk.adapter.struct.BNaviResultInfo;
import com.baidu.navisdk.adapter.struct.RoadEventItem;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.NavMapManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectory;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectoryStatusInfo;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.framework.interfaces.pronavi.o;
import com.baidu.navisdk.j;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.r;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.o0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.MapItem;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class c implements IBNRouteGuideManager {
    private static final String i = "c";
    private static volatile c j;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.framework.interfaces.pronavi.b f6495a;
    private GpsRealTime c;
    private boolean d;
    private IBNRouteGuideManager.RefreshRouteListener f;
    private IBNRouteGuideManager.ChangeRouteListener g;
    private Bundle b = null;
    private Context e = null;
    private a.r0 h = new f();

    /* loaded from: classes7.dex */
    public class a implements o {
        public a(c cVar) {
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.o
        public void a(int i, int i2, int i3, Object obj) {
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.o
        public void b() {
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.o
        public void c() {
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.o
        public void a(String str) {
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.o
        public void b(String str) {
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.o
        public void a() {
            if (com.baidu.navisdk.util.common.g.c0) {
                com.baidu.navisdk.util.common.g.OPEN_SDK.f(c.i, "onNaviGuideEnd");
            }
            com.baidu.navisdk.b.f().onNaviGuideEnd();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements com.baidu.navisdk.module.offlinedownload.a {
        public b(c cVar) {
        }

        @Override // com.baidu.navisdk.module.offlinedownload.a
        public void a() {
        }
    }

    /* renamed from: com.baidu.navisdk.adapter.impl.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0161c implements a.InterfaceC0159a {
        public C0161c(c cVar) {
        }

        @Override // com.baidu.navisdk.adapter.impl.base.a.InterfaceC0159a
        public void a(int i, int i2, int i3, Bundle bundle) {
            BNShareLocationManager.getInstance().onCommonMessageCallback(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bundle);
            BNCarPoolManager.getInstance().onCommonMessageCallback(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bundle);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements k.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IBNRouteGuideManager.RoutePlanCallbackListener f6496a;

        public d(c cVar, IBNRouteGuideManager.RoutePlanCallbackListener routePlanCallbackListener) {
            this.f6496a = routePlanCallbackListener;
        }

        @Override // com.baidu.navisdk.framework.interfaces.k.b
        public void a(int i, RoutePlanNode routePlanNode, int i2) {
            BNRoutePlanInfo bNRoutePlanInfo;
            if (this.f6496a != null) {
                if (routePlanNode != null) {
                    bNRoutePlanInfo = new BNRoutePlanInfo(routePlanNode, i2);
                } else {
                    bNRoutePlanInfo = null;
                }
                this.f6496a.onSuccess(i, bNRoutePlanInfo);
            }
        }

        @Override // com.baidu.navisdk.framework.interfaces.k.b
        public void b(int i, RoutePlanNode routePlanNode, int i2) {
            BNRoutePlanInfo bNRoutePlanInfo;
            if (this.f6496a != null) {
                if (routePlanNode != null) {
                    bNRoutePlanInfo = new BNRoutePlanInfo(routePlanNode, i2);
                } else {
                    bNRoutePlanInfo = null;
                }
                this.f6496a.onFail(i, bNRoutePlanInfo);
            }
        }

        @Override // com.baidu.navisdk.framework.interfaces.k.b
        public void onStart() {
            IBNRouteGuideManager.RoutePlanCallbackListener routePlanCallbackListener = this.f6496a;
            if (routePlanCallbackListener != null) {
                routePlanCallbackListener.onStart();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements k.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IBNRouteGuideManager.ISearchPoiListener f6497a;

        public e(c cVar, IBNRouteGuideManager.ISearchPoiListener iSearchPoiListener) {
            this.f6497a = iSearchPoiListener;
        }

        @Override // com.baidu.navisdk.framework.interfaces.k.a
        public void a(ArrayList<s> arrayList) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                BNSearchPoi bNSearchPoi = new BNSearchPoi();
                bNSearchPoi.mAddress = next.g;
                bNSearchPoi.mDistrictId = next.l;
                bNSearchPoi.mGuidePoint = next.j;
                bNSearchPoi.mName = next.e;
                bNSearchPoi.mUid = next.p;
                bNSearchPoi.mPhone = next.i;
                bNSearchPoi.mPoiTag = next.t;
                bNSearchPoi.mRouteCost = next.u;
                arrayList2.add(bNSearchPoi);
            }
            this.f6497a.onSearchSuccess(arrayList2);
        }

        @Override // com.baidu.navisdk.framework.interfaces.k.a
        public void onSearchExit() {
            this.f6497a.onSearchExit();
        }

        @Override // com.baidu.navisdk.framework.interfaces.k.a
        public void onSearchFailed() {
            this.f6497a.onSearchExit();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.r0 {
        public f() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.a.r0
        public int a(AudioManager audioManager, int i) {
            return c.this.a(audioManager, i);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.a.r0
        public int b(AudioManager audioManager, int i) {
            return c.this.b(audioManager, i);
        }
    }

    private c() {
    }

    private View a(Activity activity, Bundle bundle, boolean z) {
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar;
        if (!BNaviAuthManager.getInstance().isAuthSuccess() || activity == null || bundle == null || (bVar = this.f6495a) == null) {
            return null;
        }
        bVar.C().a(new a(this));
        MapView mapView = z ? BNOuterMapViewManager.getInstance().getMapView() : null;
        this.d = z;
        return this.f6495a.a(activity, bundle, mapView);
    }

    public static c f() {
        if (j == null) {
            synchronized (c.class) {
                try {
                    if (j == null) {
                        j = new c();
                    }
                } finally {
                }
            }
        }
        j.g();
        return j;
    }

    private void g() {
        if (this.f6495a == null) {
            this.f6495a = com.baidu.navisdk.framework.interfaces.c.p().h();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void addViaNodes(List<BNRoutePlanNode> list) {
        if (list == null) {
            return;
        }
        a0.G = 1;
        ArrayList arrayList = new ArrayList();
        for (BNRoutePlanNode bNRoutePlanNode : list) {
            RoutePlanNode routePlanNode = new RoutePlanNode(com.baidu.navisdk.adapter.impl.d.b().b(bNRoutePlanNode).mGeoPoint, 1, null, null);
            routePlanNode.mName = bNRoutePlanNode.getName();
            routePlanNode.mNodeType = 1;
            arrayList.add(routePlanNode);
        }
        l.l().a(arrayList);
    }

    public IBNRouteGuideManager.ChangeRouteListener b() {
        return this.g;
    }

    public IBNRouteGuideManager.RefreshRouteListener c() {
        return this.f;
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void changeRouteByMainSideBridge(int i2, IBNRouteGuideManager.ChangeRouteListener changeRouteListener) {
        a(changeRouteListener);
        BNRouteGuider.getInstance().onlineChangeRoute(i2);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void continueNavi() {
        com.baidu.navisdk.ui.routeguide.b.V().r().m();
    }

    public void d() {
        BNCommSettingManager.getInstance().setHdNaviEnable(true);
        BNCommSettingManager.getInstance().setNormalHdNaviEnable(false);
        com.baidu.navisdk.function.b.FUNC_HD_NAVI_SETTING_ITEM.a(true);
        com.baidu.navisdk.function.b.FUNC_NORMAL_HD_NAVI_SETTING_ITEM.a(false);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void deleteViaNodes() {
        l.l().j();
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void forceQuitNaviWithoutDialog() {
        LogUtil.out(i, "f q nwd");
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar = this.f6495a;
        if (bVar != null) {
            bVar.C().b(0, false);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void fullView(boolean z) {
        if (z) {
            com.baidu.navisdk.ui.routeguide.b.V().r().k();
        } else {
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public List<RoadEventItem> getForwardRoadEvent() {
        List<Bundle> leftRoadEventForYaw = BNRouteGuider.getInstance().getLeftRoadEventForYaw();
        if (leftRoadEventForYaw != null && leftRoadEventForYaw.size() != 0) {
            LogUtil.out(i, "偏航事件 size:" + leftRoadEventForYaw.size());
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < leftRoadEventForYaw.size(); i2++) {
                Bundle bundle = leftRoadEventForYaw.get(i2);
                LogUtil.out(i, "偏航事件 Bundle:" + bundle);
                if (bundle != null && bundle.containsKey("roadEventType") && bundle.containsKey("x") && bundle.containsKey("y")) {
                    int i3 = bundle.getInt("roadEventType");
                    if (r.b(i3)) {
                        double d2 = bundle.getDouble("x");
                        double d3 = bundle.getDouble("y");
                        if (SDKInitializer.getCoordType() == CoordType.BD09LL) {
                            LatLng gcjToBaidu = CoordTrans.gcjToBaidu(new LatLng(d2, d3));
                            d2 = gcjToBaidu.longitude;
                            d3 = gcjToBaidu.latitude;
                        }
                        arrayList.add(new RoadEventItem(i3, r.a(i3), d2, d3));
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public int getMainSideBridgeType() {
        int a0 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a0();
        if (a0 == 1) {
            return 1;
        }
        if (a0 == 2) {
            return 2;
        }
        if (a0 == 4) {
            return 4;
        }
        if (a0 == 8) {
            return 8;
        }
        return -1;
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public BNaviResultInfo getNaviResultInfo() {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out(i, "getNaviResultInfo --> init is failed.");
            return null;
        }
        String a2 = com.baidu.navisdk.comapi.trajectory.c.c().a().a();
        NaviTrajectoryStatusInfo naviTrajectoryStatusInfo = new NaviTrajectoryStatusInfo();
        JNITrajectoryControl.sInstance.getTrajectoryStatusById(a2, naviTrajectoryStatusInfo);
        NaviTrajectory a3 = com.baidu.navisdk.comapi.trajectory.c.c().a().a(a2);
        BNaviResultInfo bNaviResultInfo = new BNaviResultInfo();
        bNaviResultInfo.setTotalTime(a3.mDuration);
        bNaviResultInfo.setTotalDistance(a3.mDistance);
        bNaviResultInfo.setMaxSpeed((float) (a3.mMaxSpeed * 3.6d));
        bNaviResultInfo.setAverageSpeed((float) (a3.mAverageSpeed * 3.6d));
        bNaviResultInfo.setSpeedNum(naviTrajectoryStatusInfo.mOverSpeedCnt);
        return bNaviResultInfo;
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public String getNextGuideText() {
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f2()) {
            return a0.I().g();
        }
        return JarUtils.getResources().getString(R.string.asr_rg_answer_forward, a0.I().a(a0.I().h().getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0)), a0.I().o());
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onActivityResult(int i2, int i3, Intent intent) {
        com.baidu.navisdk.ui.routeguide.b.V().a(i2, i3, intent);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onBackPressed(boolean z) {
        onBackPressed(z, true);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onBackground() {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().c3();
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onConfigurationChanged(Configuration configuration) {
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar = this.f6495a;
        if (bVar != null) {
            bVar.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public View onCreate(FragmentActivity fragmentActivity, BNGuideConfig bNGuideConfig) {
        Bundle bundle;
        boolean z;
        IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback;
        IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback2;
        IBNRouteGuideManager.NaviAddViewCallback naviAddViewCallback3;
        boolean z2;
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar;
        String str = i;
        LogUtil.out(str, "BNRouteGuideManager --> onCreate");
        g();
        if (!BNaviAuthManager.getInstance().isAuthSuccess()) {
            LogUtil.out(str, "onCreate --> auth failed");
            return null;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar2 = this.f6495a;
        if (bVar2 != null) {
            bVar2.a(fragmentActivity.getViewModelStore(), fragmentActivity);
        }
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar == null) {
            return null;
        }
        if (fVar.o() != null && fVar.g() != null) {
            com.baidu.navisdk.module.pronavi.model.g.o().a(true);
            if (bNGuideConfig != null) {
                bundle = bNGuideConfig.getParams();
            } else {
                bundle = null;
            }
            if (bundle != null) {
                z = bundle.getBoolean(BNaviCommonParams.ProGuideKey.IS_REALNAVI, true);
            } else {
                z = true;
            }
            a(z, (Handler) null);
            if (this.b != null && fragmentActivity != null) {
                this.e = fragmentActivity.getApplicationContext();
                BNRoutePlaner.getInstance().setObserver(new com.baidu.navisdk.ui.routeguide.routeplan.b(fragmentActivity, new b(this)));
                com.baidu.navisdk.adapter.impl.base.a aVar = com.baidu.navisdk.adapter.impl.base.a.INSTANCE;
                aVar.a(null);
                aVar.a(new C0161c(this));
                if (bNGuideConfig != null) {
                    naviAddViewCallback2 = bNGuideConfig.getAboveBottomView();
                    naviAddViewCallback3 = bNGuideConfig.getBottomBarView();
                    naviAddViewCallback = bNGuideConfig.getBelowBottomView();
                } else {
                    naviAddViewCallback = null;
                    naviAddViewCallback2 = null;
                    naviAddViewCallback3 = null;
                }
                if (naviAddViewCallback2 != null) {
                    x.b().a(naviAddViewCallback2.getAddedView(), naviAddViewCallback2.getViewHeight());
                    a();
                }
                if (naviAddViewCallback3 != null) {
                    x.b().c(naviAddViewCallback3.getAddedView());
                }
                if (naviAddViewCallback != null) {
                    x.b().b(naviAddViewCallback.getAddedView(), naviAddViewCallback.getViewHeight());
                    a();
                }
                if (bundle != null) {
                    this.b.putAll(bundle);
                    z2 = bundle.getBoolean(BNaviCommonParams.ProGuideKey.ADD_MAP, true);
                } else {
                    z2 = true;
                }
                if (bundle == null || !bundle.containsKey(BNaviCommonParams.ProGuideKey.IS_SUPPORT_FULL_SCREEN)) {
                    this.b.putBoolean(BNaviCommonParams.ProGuideKey.IS_SUPPORT_FULL_SCREEN, false);
                }
                this.b.putInt("page_from_vehicle", BNRoutePlaner.getInstance().m());
                com.baidu.navisdk.framework.interfaces.pronavi.b bVar3 = this.f6495a;
                if (bVar3 != null) {
                    bVar3.a(fragmentActivity, this.b);
                }
                View a2 = a(fragmentActivity, this.b, z2);
                if (a2 != null && (bVar = this.f6495a) != null) {
                    bVar.C().a((Bundle) null);
                    if (!j.d()) {
                        com.baidu.navisdk.adapter.impl.b.c().setRealRoadCondition(true);
                    }
                }
                NavMapManager.getInstance().addNaviMapListener();
                NavMapManager.getInstance().handleMapThemeAndScene(1);
                NavMapManager.getInstance().set3DGestureEnable(true);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(this.h);
                com.baidu.navisdk.comapi.commontool.a.getInstance().c(BNSettingManager.getNaviDayAndNightMode());
                com.baidu.navisdk.comapi.trajectory.c.c().a().a("", null, com.baidu.navisdk.comapi.trajectory.j.TRAJECTORY_FROM_SDK_NAVI, true);
                com.baidu.navisdk.util.statistic.core.a.p().a(fVar.o(), fVar.g(), MapItem.KEY_IS_MAP_ITEM, "online", "nav_nav");
                if (this.c == null) {
                    this.c = new GpsRealTime();
                }
                this.c.start();
                if (com.baidu.navisdk.util.common.g.c0) {
                    com.baidu.navisdk.skyeye.a.n().a(2048, 255, "导航SDK日志上传");
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("49.0.4.1", null, null, null);
                return a2;
            }
            LogUtil.e(str, "启动参数为空.");
            return null;
        }
        LogUtil.out(str, "node == null");
        return null;
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onDestroy(boolean z) {
        String str = i;
        LogUtil.out(str, "BNRouteGuideManager --> onDestroy, isSwitchToLightNavi is " + z);
        com.baidu.navisdk.module.viewbound.a.e().c();
        GpsRealTime gpsRealTime = this.c;
        if (gpsRealTime != null) {
            gpsRealTime.stop();
        }
        this.e = null;
        if (!BNaviAuthManager.getInstance().isAuthSuccess()) {
            LogUtil.out(str, "onDestroy --> auth failed");
            return;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar = this.f6495a;
        if (bVar != null) {
            bVar.C().a((o) null);
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar2 = this.f6495a;
        if (bVar2 != null && bVar2.x0()) {
            LogUtil.out(str, "de f q");
            forceQuitNaviWithoutDialog();
        } else {
            LogUtil.out(str, "de f q 2");
        }
        com.baidu.navisdk.comapi.trajectory.c.c().a().a(null, com.baidu.navisdk.comapi.trajectory.j.TRAJECTORY_FROM_NAVI);
        BNRoutePlaner.getInstance().setObserver(null);
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar3 = this.f6495a;
        if (bVar3 != null) {
            bVar3.onDestroy();
        }
        com.baidu.navisdk.b.f().e();
        com.baidu.navisdk.util.statistic.userop.b.r().a("32.0.4.1560", null, null, null);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onForeground() {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f3();
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        int streamVolume;
        int streamVolume2;
        Context context = this.e;
        if (context == null) {
            return false;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        if (i2 != 24) {
            if (i2 != 25) {
                return false;
            }
            if (c(audioManager, -1)) {
                return true;
            }
            com.baidu.navisdk.framework.interfaces.pronavi.b bVar = this.f6495a;
            if (bVar != null && bVar.x0()) {
                streamVolume2 = a(audioManager, streamMaxVolume);
            } else {
                audioManager.adjustStreamVolume(3, -1, 1);
                streamVolume2 = audioManager.getStreamVolume(3);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().c("3.kb");
            if (streamVolume2 == 0) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().U(true);
            }
            return true;
        }
        if (c(audioManager, 1)) {
            return true;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar2 = this.f6495a;
        if (bVar2 != null && bVar2.x0()) {
            streamVolume = b(audioManager, streamMaxVolume);
        } else {
            audioManager.adjustStreamVolume(3, 1, 1);
            streamVolume = audioManager.getStreamVolume(3);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().c("3.ka");
        if (streamVolume > 0) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().U(false);
        }
        return true;
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onPause() {
        String str = i;
        LogUtil.out(str, "BNRouteGuideManager --> onPause");
        if (!BNaviAuthManager.getInstance().isAuthSuccess()) {
            LogUtil.out(str, "onPause --> auth failed");
            return;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar = this.f6495a;
        if (bVar != null) {
            bVar.onPause();
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("32.0.49.1559", null, null, null);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        o0.b().a(i2, strArr, iArr);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onResume() {
        String str = i;
        LogUtil.out(str, "BNRouteGuideManager --> onResume");
        if (!BNaviAuthManager.getInstance().isAuthSuccess()) {
            LogUtil.out(str, "onResume --> auth failed");
            return;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar = this.f6495a;
        if (bVar != null) {
            bVar.onResume();
        }
        com.baidu.navisdk.ui.routeguide.b.V().r().l();
        com.baidu.navisdk.util.statistic.userop.b.r().a("32.0.4.1558", null, null, null);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onStart() {
        if (this.d) {
            BNMapController.getInstance().onResume();
            BNOuterMapViewManager.getInstance().onResume();
        }
        BNOuterMapViewManager.getInstance().setBaiduMapLogoVisible(false);
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar = this.f6495a;
        if (bVar != null) {
            bVar.onStart();
        }
        GpsRealTime gpsRealTime = this.c;
        if (gpsRealTime != null) {
            gpsRealTime.setInBackground(false);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onStop() {
        String str = i;
        LogUtil.out(str, "BNRouteGuideManager --> onStop");
        if (!BNaviAuthManager.getInstance().isAuthSuccess()) {
            LogUtil.out(str, "onStop --> auth failed");
            return;
        }
        if (this.d) {
            BNMapController.getInstance().onPause();
            BNOuterMapViewManager.getInstance().onPause();
        }
        BNOuterMapViewManager.getInstance().setBaiduMapLogoVisible(true);
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar = this.f6495a;
        if (bVar != null) {
            bVar.onStop();
        }
        GpsRealTime gpsRealTime = this.c;
        if (gpsRealTime != null) {
            gpsRealTime.setInBackground(true);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void pauseRouteGuide() {
        BNRouteGuider.getInstance().pauseRouteGuide();
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void reCalcRouteWithPrefer(int i2) {
        com.baidu.navisdk.ui.routeguide.b.V().d().d(i2);
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(false);
        a0.G = 2;
        l.l().i();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.a", Integer.toString(i2), "1", null);
        com.baidu.navisdk.util.statistic.userop.b.r().a("2.i.1", i2 + "", "3", null);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void refreshRoute(IBNRouteGuideManager.RefreshRouteListener refreshRouteListener) {
        a(refreshRouteListener);
        BNRouteGuider.getInstance().calcOtherRoute("", 1, 28);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public boolean resetEndNodeInNavi(BNRoutePlanNode bNRoutePlanNode) {
        return resetEndNodeInNavi(bNRoutePlanNode, false);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void resumeRouteGuide() {
        BNRouteGuider.getInstance().resumeRouteGuide();
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public boolean routeSearchPoi(String str, ArrayList<String> arrayList, IBNRouteGuideManager.ISearchPoiListener iSearchPoiListener) {
        if (com.baidu.navisdk.module.asr.h.a() || str == null) {
            return false;
        }
        if (arrayList == null || arrayList.size() == 0 || TextUtils.isEmpty(arrayList.get(0))) {
            arrayList = new ArrayList<>();
            arrayList.add(e0.a(this.e).a(str, ""));
        }
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.a(new e(this, iSearchPoiListener));
        }
        return com.baidu.navisdk.ui.routeguide.b.V().a(str, arrayList);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void selectRoute(int i2) {
        BNRoutePlaner.getInstance().n(i2);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void setNaviListener(IBNaviListener iBNaviListener) {
        com.baidu.navisdk.b.f().a(iBNaviListener);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void setNaviViewListener(IBNaviViewListener iBNaviViewListener) {
        com.baidu.navisdk.f.a().a(iBNaviViewListener);
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void setRoutePlanCallback(IBNRouteGuideManager.RoutePlanCallbackListener routePlanCallbackListener) {
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.a(new d(this, routePlanCallbackListener));
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void stopNavi() {
        com.baidu.navisdk.ui.routeguide.b.V().a(false);
    }

    private boolean c(AudioManager audioManager, int i2) {
        if (com.baidu.navisdk.util.common.b.b().a() != 2 && com.baidu.navisdk.util.common.b.b().a() != 1) {
            return false;
        }
        audioManager.adjustStreamVolume(0, i2, 1);
        return true;
    }

    public int b(AudioManager audioManager, int i2) {
        a(audioManager);
        int streamVolume = audioManager.getStreamVolume(3);
        audioManager.adjustStreamVolume(3, 1, 4);
        int streamVolume2 = audioManager.getStreamVolume(3);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(streamVolume2, streamVolume, i2, TTSPlayerControl.getCurrentVolume(), true);
        return streamVolume2;
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public void onBackPressed(boolean z, boolean z2) {
        if (z2) {
            com.baidu.navisdk.framework.interfaces.pronavi.b bVar = this.f6495a;
            if (bVar != null) {
                bVar.onBackPressed();
                return;
            }
            return;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b bVar2 = this.f6495a;
        if (bVar2 != null) {
            bVar2.C().b(0, false);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNRouteGuideManager
    public boolean resetEndNodeInNavi(BNRoutePlanNode bNRoutePlanNode, boolean z) {
        if (BNaviAuthManager.getInstance().isAuthSuccess() && bNRoutePlanNode != null) {
            try {
                com.baidu.navisdk.framework.interfaces.pronavi.b bVar = this.f6495a;
                if (bVar != null && bVar.x0()) {
                    a0.G = 10;
                    return l.l().a(bNRoutePlanNode.getName(), com.baidu.navisdk.adapter.impl.d.b().b(bNRoutePlanNode).mGeoPoint, bNRoutePlanNode.getId(), z);
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void a(boolean z, Handler handler) {
        this.b = new Bundle();
        if (j.e()) {
            if (!z) {
                this.b.putInt("locate_mode", 2);
            } else {
                this.b.putInt("locate_mode", 5);
            }
        } else if (!z) {
            this.b.putInt("locate_mode", 2);
        } else {
            this.b.putInt("locate_mode", 1);
        }
        this.b.putBoolean("net_refresh", false);
        this.b.putBoolean("show_fullview", BNSettingManager.isStartByFullView());
        if (handler != null) {
            handler.sendEmptyMessage(8000);
        }
    }

    public void a() {
        BNCommSettingManager.getInstance().setHdNaviEnable(false);
        BNCommSettingManager.getInstance().setNormalHdNaviEnable(false);
        com.baidu.navisdk.function.b.FUNC_HD_NAVI_SETTING_ITEM.a(false);
        com.baidu.navisdk.function.b.FUNC_NORMAL_HD_NAVI_SETTING_ITEM.a(false);
    }

    public void a(IBNRouteGuideManager.RefreshRouteListener refreshRouteListener) {
        this.f = refreshRouteListener;
    }

    public void a(IBNRouteGuideManager.ChangeRouteListener changeRouteListener) {
        this.g = changeRouteListener;
    }

    public int a(AudioManager audioManager, int i2) {
        a(audioManager);
        int streamVolume = audioManager.getStreamVolume(3);
        audioManager.adjustStreamVolume(3, -1, 4);
        int streamVolume2 = audioManager.getStreamVolume(3);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(streamVolume2, streamVolume, i2, TTSPlayerControl.getCurrentVolume(), false);
        return streamVolume2;
    }

    private void a(AudioManager audioManager) {
        audioManager.adjustStreamVolume(3, 0, 0);
    }
}

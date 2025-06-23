package com.baidu.navisdk.adapter.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Toast;
import com.baidu.baidunavis.baseline.BNOuterMapViewManager;
import com.baidu.navisdk.GpsRealTime;
import com.baidu.navisdk.adapter.BNLightNaviListener;
import com.baidu.navisdk.adapter.IBNLightNaviListener;
import com.baidu.navisdk.adapter.IBNLightNaviManager;
import com.baidu.navisdk.adapter.impl.base.BNaviAuthManager;
import com.baidu.navisdk.adapter.sl.orderstate.BNOrderStateManager;
import com.baidu.navisdk.adapter.struct.BNRoutePlanItem;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.mapcontrol.NavMapManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.j;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.y;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.map.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class f implements IBNLightNaviManager {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.lightnavi.controller.d f6502a;
    private IBNLightNaviListener f;
    private IBNLightNaviManager.IRouteClickedListener g;
    String h;
    private Activity b = null;
    private boolean c = true;
    private boolean d = true;
    private GpsRealTime e = null;
    private final BNMapObserver i = new a();
    private final com.baidu.navisdk.util.worker.f<String, String> j = new b("LightNavi-AutoLoc", null);
    private final com.baidu.navisdk.lightnavi.listener.a k = new c();

    /* loaded from: classes7.dex */
    public class a implements BNMapObserver {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            if (2 == i) {
                if (i2 != 513) {
                    if (i2 == 518) {
                        if (com.baidu.navisdk.ui.routeguide.c.g().f()) {
                            BNMapController.getInstance().setDragMapStatus(com.baidu.navisdk.ui.routeguide.c.g().e());
                            BNRouteGuider.getInstance().setBrowseStatus(true);
                        } else {
                            BNMapController.getInstance().setDragMapStatus(true);
                            BNRouteGuider.getInstance().setBrowseStatus(true);
                        }
                        f.this.h();
                    }
                } else {
                    BNRouteGuider.getInstance().setBrowseStatus(true);
                    f.this.h();
                }
            }
            if (1 == i && i2 == 278) {
                f.this.a(obj);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (com.baidu.navisdk.ui.routeguide.c.g().f()) {
                BNRouteGuider.getInstance().setBrowseStatus(false);
                f.this.g();
                return null;
            }
            BNRouteGuider.getInstance().setBrowseStatus(true);
            f.this.backLocation();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements com.baidu.navisdk.lightnavi.listener.a {
        public c() {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a(int i) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void b() {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void c() {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void d() {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void e() {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void f(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void g(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void h(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void i(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void j(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void k(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void l(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void m(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void n(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void o(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void p(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void q(Message message) {
            com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(36, message.arg1, message.arg2, null);
            LogUtil.out("BNSDKLightNaviManager", "onRemainInfoUpdate=" + message.arg1 + message.arg2);
            if (f.this.f != null) {
                f.this.f.onRemainInfoUpdate(message.arg1, message.arg2);
            }
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void r(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void s(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void z(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a(int i, int i2) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void b(boolean z) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void c(int i) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void d(Message message) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("4.h");
            com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(41, message.arg1, message.arg2, null);
            if (f.this.f != null) {
                f.this.f.onStartYawing();
            }
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void e(Message message) {
            if (j.d()) {
                Toast.makeText(f.this.b, "偏航路线规划成功", 1).show();
            }
            com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(39, message.arg1, message.arg2, null);
            LogUtil.out("BNSDKLightNaviManager", "lngo.onYawingRerouteSuccess. mIsOnStarted=" + f.this.d);
            if (f.this.d) {
                f.this.fullView();
            }
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a(int i, boolean z, boolean z2) {
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x000e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
        @Override // com.baidu.navisdk.lightnavi.listener.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(android.os.Message r5) {
            /*
                r4 = this;
                if (r5 == 0) goto Lb
                java.lang.Object r5 = r5.obj
                boolean r0 = r5 instanceof android.os.Bundle
                if (r0 == 0) goto Lb
                android.os.Bundle r5 = (android.os.Bundle) r5
                goto Lc
            Lb:
                r5 = 0
            Lc:
                if (r5 != 0) goto Lf
                return
            Lf:
                java.lang.String r0 = "road_name"
                java.lang.String r0 = r5.getString(r0)
                java.lang.String r1 = "remain_dist"
                int r1 = r5.getInt(r1)
                java.lang.String r2 = "icon_name"
                java.lang.String r2 = r5.getString(r2)
                com.baidu.navisdk.ui.routeguide.model.a0 r3 = com.baidu.navisdk.ui.routeguide.model.a0.I()
                android.graphics.drawable.Drawable r2 = r3.d(r2)
                java.lang.String r3 = "cur_road_name"
                java.lang.String r5 = r5.getString(r3)
                com.baidu.navisdk.adapter.impl.f r3 = com.baidu.navisdk.adapter.impl.f.this
                com.baidu.navisdk.adapter.IBNLightNaviListener r3 = com.baidu.navisdk.adapter.impl.f.c(r3)
                if (r3 == 0) goto L68
                com.baidu.navisdk.adapter.impl.f r3 = com.baidu.navisdk.adapter.impl.f.this
                java.lang.String r3 = r3.h
                boolean r3 = r5.equals(r3)
                if (r3 != 0) goto L4e
                com.baidu.navisdk.adapter.impl.f r3 = com.baidu.navisdk.adapter.impl.f.this
                com.baidu.navisdk.adapter.IBNLightNaviListener r3 = com.baidu.navisdk.adapter.impl.f.c(r3)
                r3.onRoadNameUpdate(r5)
                com.baidu.navisdk.adapter.impl.f r3 = com.baidu.navisdk.adapter.impl.f.this
                r3.h = r5
            L4e:
                android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2
                android.graphics.Bitmap r5 = r2.getBitmap()
                com.baidu.navisdk.adapter.struct.BNaviInfo r2 = new com.baidu.navisdk.adapter.struct.BNaviInfo
                r2.<init>()
                r2.roadName = r0
                r2.distance = r1
                r2.turnIcon = r5
                com.baidu.navisdk.adapter.impl.f r5 = com.baidu.navisdk.adapter.impl.f.this
                com.baidu.navisdk.adapter.IBNLightNaviListener r5 = com.baidu.navisdk.adapter.impl.f.c(r5)
                r5.updateGuideInfo(r2)
            L68:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.adapter.impl.f.c.b(android.os.Message):void");
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void c(Message message) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a(boolean z) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a(Message message) {
            if (f.this.f != null) {
                f.this.f.onArriveDest();
            }
            com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(40, 0, 0, null);
            f.this.b();
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a() {
            f.this.fullView();
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void b(int i) {
            Bundle bundle = new Bundle();
            BNRoutePlaner.getInstance().c(bundle);
            bundle.putInt("BNRouteChangeType", i);
            com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(35, 0, 0, bundle);
            if (f.this.f != null) {
                f.this.f.onMainRouteChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final f f6506a = new f();
    }

    private boolean f() {
        return JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(JNIGuidanceControl.getInstance().getSelectRouteIdx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        LogUtil.out("BNSDKLightNaviManager", "judgeCarIconOffset()");
        if (!com.baidu.navisdk.ui.routeguide.c.g().f()) {
            LogUtil.out("BNSDKLightNaviManager", "judgeCarIconOffset() return for car freedom.");
            return;
        }
        com.baidu.nplatform.comapi.basestruct.b mapStatus = BNMapController.getInstance().getMapStatus();
        if (mapStatus != null) {
            if (com.baidu.navisdk.ui.routeguide.c.g().f()) {
                mapStatus.i = com.baidu.navisdk.ui.routeguide.c.g().a();
                mapStatus.j = com.baidu.navisdk.ui.routeguide.c.g().c();
            } else {
                mapStatus.i = 0L;
                mapStatus.j = 0L;
            }
            BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationNone);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.d) {
            LogUtil.out("BNSDKLightNaviManager", "scheduleAutoLocTask() return for 轻导航没在前台");
            return;
        }
        BNOrderStateManager bNOrderStateManager = BNOrderStateManager.INSTANCE;
        if (bNOrderStateManager.isWaitingStateNeedRoute() && bNOrderStateManager.getLastestOrderStateNum() == 3) {
            LogUtil.out("BNSDKLightNaviManager", "取消自动回车");
        } else {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.j, false);
            com.baidu.navisdk.util.worker.c.a().a(this.j, new com.baidu.navisdk.util.worker.e(2, 0), 10000L);
        }
    }

    private void i() {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out("BNSDKLightNaviManager", "setMapView --> init is failed.");
            return;
        }
        NavMapManager.getInstance().addNaviMapListener();
        BNOuterMapViewManager.getInstance().getGLSurfaceView().getController().setMapTheme(1, new Bundle());
        NavMapManager.getInstance().handleMapThemeAndScene(2);
        NavMapManager.getInstance().set3DGestureEnable(false);
        LogUtil.out("BNSDKLightNaviManager", "setMapView() isCarFreedom=" + com.baidu.navisdk.ui.routeguide.c.g().f());
        if (!com.baidu.navisdk.ui.routeguide.c.g().f()) {
            LogUtil.out("BNSDKLightNaviManager", "setMapView() isCarFreedom=false");
            BNRouteGuider.getInstance().SetFullViewState(true);
            BNRouteGuider.getInstance().setBrowseStatus(true);
            showRoute(this.c);
            g();
            return;
        }
        LogUtil.out("BNSDKLightNaviManager", "setMapView() carfreedom");
        BNRouteGuider.getInstance().SetFullViewState(false);
        if (com.baidu.navisdk.ui.routeguide.c.g().f()) {
            BNRouteGuider.getInstance().setBrowseStatus(true);
        } else {
            BNRouteGuider.getInstance().setBrowseStatus(false);
        }
        BNRouteGuider.getInstance().setRotateMode(1);
        a(true);
        g();
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void backLocation() {
        com.baidu.navisdk.lightnavi.controller.d dVar = this.f6502a;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void fullView() {
        if (!this.d) {
            LogUtil.out("BNSDKLightNaviManager", "zoomToSlightNaviFullView() return for mIsOnStarted=" + this.d);
            return;
        }
        BNMapController.getInstance().setDragMapStatus(false);
        BNRouteGuider.getInstance().setBrowseStatus(false);
        int[] lightNaviRouteMargin = BNSettingManager.getLightNaviRouteMargin();
        if (lightNaviRouteMargin != null && lightNaviRouteMargin.length == 4) {
            com.baidu.navisdk.lightnavi.utils.c.a(lightNaviRouteMargin[0], lightNaviRouteMargin[1], lightNaviRouteMargin[2], lightNaviRouteMargin[3], BNMapController.getInstance().getScreenHeight(), BNMapController.getInstance().getScreenWidth());
        } else {
            com.baidu.navisdk.lightnavi.utils.c.b();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public List<BNRoutePlanItem> getRemainRouteInfo() {
        ArrayList<BNRoutePlanItem> c2 = c();
        if (BNRoutePlaner.getInstance().m() == 3 && !BNaviAuthManager.getInstance().hasEtcPermission() && c2 != null) {
            for (int i = 0; i < c2.size(); i++) {
                c2.get(i).setToll(0);
            }
        }
        return c2;
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public int getSelectRouteIndex() {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out("BNSDKLightNaviManager", "getSelectRouteIndex --> init is failed.");
            return 0;
        }
        int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
        int convertToTabIndex = BNRouteGuider.getInstance().convertToTabIndex(selectRouteIdx);
        if (LogUtil.OUT_LOGGABLE) {
            LogUtil.out("BNSDKLightNaviManager", "getRouteIndex :index " + selectRouteIdx + " tabIndex:" + convertToTabIndex);
        }
        return convertToTabIndex;
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public boolean isIpoRoadCondOnOrOff() {
        return isRoadConditionOpen();
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public boolean isRoadConditionOpen() {
        return BNSettingManager.isIpoRoadCondOnOrOff();
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public View onCreate(Activity activity) {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out("BNSDKLightNaviManager", "onCreate --> init is failed.");
            return null;
        }
        this.b = activity;
        if (this.e == null) {
            this.e = new GpsRealTime();
        }
        this.f6502a = new com.baidu.navisdk.lightnavi.controller.d();
        i();
        com.baidu.navisdk.util.statistic.userop.b.r().a("32.0.4.1553", null, null, null);
        return this.f6502a.a(activity);
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void onDestroy(boolean z) {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out("BNSDKLightNaviManager", "onDestroy --> init is failed.");
            return;
        }
        com.baidu.navisdk.lightnavi.controller.d dVar = this.f6502a;
        if (dVar != null) {
            dVar.a(z);
        }
        if (!z) {
            this.b = null;
        }
        this.d = true;
        com.baidu.navisdk.util.statistic.userop.b.r().a("32.0.4.1", BNOuterMapViewManager.getInstance().getMapViewParentHash(), null, null);
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void onPause() {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out("BNSDKLightNaviManager", "onPause --> init is failed.");
            return;
        }
        com.baidu.navisdk.lightnavi.controller.d dVar = this.f6502a;
        if (dVar != null) {
            dVar.b();
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("32.0.4.1555", BNOuterMapViewManager.getInstance().getMapViewParentHash(), null, null);
        BNMapController.getInstance().deleteObserver(this.i);
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void onResume() {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out("BNSDKLightNaviManager", "onResume --> init is failed.");
            return;
        }
        com.baidu.navisdk.lightnavi.controller.d dVar = this.f6502a;
        if (dVar != null) {
            dVar.c();
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("32.0.4.2", BNOuterMapViewManager.getInstance().getMapViewParentHash(), null, null);
        BNMapController.getInstance().addObserver(this.i);
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void onStart() {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out("BNSDKLightNaviManager", "onStart --> init is failed.");
            return;
        }
        com.baidu.navisdk.lightnavi.controller.d dVar = this.f6502a;
        if (dVar != null) {
            dVar.d();
        }
        a();
        this.d = true;
        showRoute(this.c);
        GpsRealTime gpsRealTime = this.e;
        if (gpsRealTime != null) {
            gpsRealTime.setInBackground(false);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void onStop() {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out("BNSDKLightNaviManager", "onStop --> init is failed.");
            return;
        }
        com.baidu.navisdk.lightnavi.controller.d dVar = this.f6502a;
        if (dVar != null) {
            dVar.e();
        }
        d();
        this.d = false;
        GpsRealTime gpsRealTime = this.e;
        if (gpsRealTime != null) {
            gpsRealTime.setInBackground(true);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void selectRoute(int i) {
        if (i < 3 && i >= 0) {
            BNRoutePlaner.getInstance().n(BNRouteGuider.getInstance().convertToMapRouteIndex(i));
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void setLightNaviListener(BNLightNaviListener bNLightNaviListener) {
        this.f = bNLightNaviListener;
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void setRoadCondition(boolean z) {
        if (this.b == null) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("4.2");
        boolean isFirstItsOn = BNSettingManager.isFirstItsOn();
        if (z) {
            if (e0.a(this.b).a(SettingParams.Key.NAVI_REAL_HISTORY_ITS, true)) {
                if (isFirstItsOn) {
                    BNSettingManager.setFirstItsOn(false);
                }
                if (y.d(this.b)) {
                    BNMapController.getInstance().switchITSMode(true);
                    BNMapController.getInstance().showTrafficMap(true);
                    BNSettingManager.setIpoRoadCondOnOff(true);
                    return;
                }
                return;
            }
            return;
        }
        BNMapController.getInstance().showTrafficMap(false);
        BNSettingManager.setIpoRoadCondOnOff(false);
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void setRouteClickedListener(IBNLightNaviManager.IRouteClickedListener iRouteClickedListener) {
        this.g = iRouteClickedListener;
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void setViewSegmentStatus(boolean z) {
        BNRouteGuider.getInstance().setViewSegmentStatus(z);
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void showRoute(boolean z) {
        this.c = z;
        a(z);
        BNMapController.getInstance().showLayer(27, z);
        BNMapController.getInstance().showLayer(35, z);
        try {
            if (!z) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M0();
            } else {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().N3();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BNMapController.getInstance().showLayer(8, z);
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public boolean startLightNavi() {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out("BNSDKLightNaviManager", "startLightNavi --> init is failed.");
            return false;
        }
        if (!f()) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("4.0.4.1");
            LogUtil.out("BNSDKLightNaviManager", "startLightNavi --> data is not ready");
            return false;
        }
        LogUtil.out("BNSDKLightNaviManager", "startLightNavi");
        com.baidu.navisdk.lightnavi.controller.d dVar = this.f6502a;
        if (dVar != null) {
            dVar.f();
        }
        i();
        com.baidu.navisdk.lightnavi.controller.a.getInstance().a(this.k);
        GpsRealTime gpsRealTime = this.e;
        if (gpsRealTime != null) {
            gpsRealTime.start();
            return true;
        }
        return true;
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public boolean startProfessionalNavi() {
        if (com.baidu.navisdk.ui.util.g.a(1000L)) {
            LogUtil.out("BNSDKLightNaviManager", "fast double click, return false");
            com.baidu.navisdk.util.statistic.userop.b.r().a("32.0.4.1565", "1", null, null);
            return false;
        }
        if (this.f6502a != null) {
            if (!f()) {
                com.baidu.navisdk.util.statistic.userop.b.r().b("4.0.4.1");
                LogUtil.out("BNSDKLightNaviManager", "startProfessionalNavi --> data is not ready");
                return false;
            }
            if (this.f6502a.g()) {
                com.baidu.navisdk.lightnavi.controller.b.c().a(true);
                com.baidu.navisdk.lightnavi.controller.a.getInstance().a((com.baidu.navisdk.lightnavi.listener.a) null);
                LogUtil.out("BNSDKLightNaviManager", "startProfessionalNavi --> route plan ok, start switch to professional navi");
                return true;
            }
            LogUtil.out("BNSDKLightNaviManager", "startProfessionalNavi --> retry route plan");
            com.baidu.navisdk.util.statistic.userop.b.r().a("32.0.4.1565", "3", "0");
            return false;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("32.0.4.1565", "4", null, null);
        return false;
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void stopLightNavi(boolean z) {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out("BNSDKLightNaviManager", "stopLightNavi --> init is failed.");
            return;
        }
        LogUtil.out("BNSDKLightNaviManager", "quitLightNav");
        com.baidu.navisdk.lightnavi.controller.a.getInstance().a((com.baidu.navisdk.lightnavi.listener.a) null);
        GpsRealTime gpsRealTime = this.e;
        if (gpsRealTime != null) {
            gpsRealTime.stop();
        }
        com.baidu.navisdk.lightnavi.controller.d dVar = this.f6502a;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void switchIpoRoadCondition() {
        if (this.b != null) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("4.2");
            boolean isFirstItsOn = BNSettingManager.isFirstItsOn();
            if (!BNSettingManager.isIpoRoadCondOnOrOff()) {
                if (e0.a(this.b).a(SettingParams.Key.NAVI_REAL_HISTORY_ITS, true)) {
                    if (isFirstItsOn) {
                        BNSettingManager.setFirstItsOn(false);
                    }
                    if (y.d(this.b)) {
                        BNMapController.getInstance().switchITSMode(true);
                        BNMapController.getInstance().showTrafficMap(true);
                        BNSettingManager.setIpoRoadCondOnOff(true);
                        return;
                    }
                    return;
                }
                return;
            }
            BNMapController.getInstance().showTrafficMap(false);
            BNSettingManager.setIpoRoadCondOnOff(false);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void zoomInMap() {
        BNMapController.getInstance().zoomIn();
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviManager
    public void zoomOutMap() {
        BNMapController.getInstance().zoomOut();
    }

    private void d() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.j, false);
    }

    public static f e() {
        return d.f6506a;
    }

    public void b() {
        com.baidu.navisdk.ui.routeguide.c.g().b(true);
        BNRouteGuider.getInstance().removeRoute(2);
        NavMapManager.getInstance().set3DGestureEnable(false);
        if (this.d) {
            BNMapController.getInstance().showCarResultLayer(false);
            a(true);
            BNRouteGuider.getInstance().SetFullViewState(false);
            BNRouteGuider.getInstance().setBrowseStatus(false);
            BNRouteGuider.getInstance().setRotateMode(1);
            LogUtil.out("BNSDKLightNaviManager", "enterCarIconFreedom() 地图");
            g();
            return;
        }
        BNMapController.getInstance().showCarResultLayer(false);
        BNMapController.getInstance().showCarResultLayer(true);
    }

    public ArrayList<BNRoutePlanItem> c() {
        Bundle bundle = new Bundle();
        com.baidu.navisdk.lightnavi.controller.a.a(bundle);
        com.baidu.navisdk.lightnavi.model.a a2 = com.baidu.navisdk.lightnavi.model.a.a(bundle);
        int selectRouteIndex = getSelectRouteIndex();
        ArrayList<BNRoutePlanItem> arrayList = new ArrayList<>();
        for (int i = 0; i < a2.g(); i++) {
            arrayList.add(a(i, selectRouteIndex, a2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        MapItem mapItem = (MapItem) obj;
        int i = mapItem.mItemID;
        if (mapItem.mClickType == 1) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("4.8", "", null, null);
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("4.8", null, "", null);
        }
        com.baidu.navisdk.naviresult.a.d().a().d++;
        if (i < 0 || i > 3) {
            return;
        }
        BNRoutePlaner.getInstance().n(i);
        if (this.g != null) {
            this.g.routeClicked(BNRouteGuider.getInstance().convertToTabIndex(i));
        }
    }

    public void a() {
        if (y.d(this.b) && isIpoRoadCondOnOrOff()) {
            BNMapController.getInstance().switchITSMode(true);
            BNMapController.getInstance().showTrafficMap(true);
            BNSettingManager.setIpoRoadCondOnOff(true);
        }
    }

    public void a(boolean z) {
        if (z) {
            BNMapController.getInstance().showCarResultLayer(true);
            if (BNMapController.getInstance().getSDKMapController() != null) {
                BNMapController.getInstance().getSDKMapController().a(false);
                return;
            }
            return;
        }
        BNMapController.getInstance().showCarResultLayer(true);
        if (BNMapController.getInstance().getSDKMapController() != null) {
            BNMapController.getInstance().getSDKMapController().a(true);
        }
    }

    public BNRoutePlanItem a(int i, int i2, com.baidu.navisdk.lightnavi.model.a aVar) {
        BNRoutePlanItem bNRoutePlanItem = new BNRoutePlanItem();
        if (i == i2) {
            bNRoutePlanItem.setLength(aVar.d());
            bNRoutePlanItem.setLights(aVar.f()[i]);
            bNRoutePlanItem.setPassTime(aVar.e());
            bNRoutePlanItem.setPusLabelName("当前路线");
            return bNRoutePlanItem;
        }
        if (i == 0) {
            bNRoutePlanItem.setLength(aVar.b()[0]);
            bNRoutePlanItem.setPassTime(aVar.c()[0]);
            bNRoutePlanItem.setPusLabelName(aVar.a()[0]);
        } else if (i != 1) {
            if (i == 2) {
                bNRoutePlanItem.setLength(aVar.b()[1]);
                bNRoutePlanItem.setPassTime(aVar.c()[1]);
                bNRoutePlanItem.setPusLabelName(aVar.a()[1]);
            }
        } else if (i2 > 1) {
            bNRoutePlanItem.setLength(aVar.b()[1]);
            bNRoutePlanItem.setPassTime(aVar.c()[1]);
            bNRoutePlanItem.setPusLabelName(aVar.a()[1]);
        } else {
            bNRoutePlanItem.setLength(aVar.b()[0]);
            bNRoutePlanItem.setPassTime(aVar.c()[0]);
            bNRoutePlanItem.setPusLabelName(aVar.a()[0]);
        }
        bNRoutePlanItem.setLights(aVar.f()[i]);
        return bNRoutePlanItem;
    }
}

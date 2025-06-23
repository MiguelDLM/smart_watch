package com.baidu.navisdk;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import com.baidu.baidunavis.baseline.BNOuterMapViewManager;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.navcore.tts.BaseTTSPlayer;
import com.baidu.navisdk.adapter.IBNRouteGuideManager;
import com.baidu.navisdk.adapter.IBNaviListener;
import com.baidu.navisdk.adapter.IBNaviViewListener;
import com.baidu.navisdk.adapter.impl.base.BNaviAuthManager;
import com.baidu.navisdk.adapter.struct.BNavLineItem;
import com.baidu.navisdk.adapter.struct.BNaviLocation;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;
import com.baidu.nplatform.comjni.tools.JNITools;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class c implements com.baidu.navisdk.framework.interfaces.k {

    /* renamed from: a, reason: collision with root package name */
    private k.a f6676a;
    private k.b b;

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void A() {
        f.a().onBottomBarClick(IBNaviViewListener.Action.ContinueNavi);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void B() {
        com.baidu.navisdk.adapter.impl.base.a.INSTANCE.a(43, 0, 0, null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void D() {
        IBNRouteGuideManager.RefreshRouteListener c = com.baidu.navisdk.adapter.impl.c.f().c();
        if (c != null) {
            c.onFail();
            com.baidu.navisdk.adapter.impl.c.f().a((IBNRouteGuideManager.RefreshRouteListener) null);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public int E() {
        return BNSettingManager.getViaPointCount();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean F() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void G() {
        b.f().onMapStateChange(IBNaviListener.MapStateMode.BROWSE);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void H() {
        b.f().onArriveDestination();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean J() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void L() {
        f.a().onRefreshBtnClick();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public long N() {
        return BNOuterMapViewManager.getInstance().getGLSurfaceView().getController().getMapId();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean P() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public String R() {
        return BNaviAuthManager.getInstance().getToken();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean S() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean T() {
        if (!j.d()) {
            return BNaviAuthManager.getInstance().hasNewEnergyPermission();
        }
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean U() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void V() {
        b.f().onHighWayInfoUpdate(IBNaviListener.Action.HIDE, b.f().a());
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void W() {
        f.a().onMapMoved();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean X() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(long j, float f, float f2, double d, double d2, double d3, double d4, float f3) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a0() {
        f.a().onBottomBarClick(IBNaviViewListener.Action.OpenSetting);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public long[] b(boolean z) {
        return null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void c(String str) {
        b.f().onStartYawing(str);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public Rect c0() {
        return null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void d(int i) {
        b.f().onDiyVoiceModeChanged(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void e(boolean z) {
        f.a().onFullViewWindowClick(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void f(int i) {
        b.f().onArrivedWayPoint(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean f0() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void g() {
        IBNRouteGuideManager.ChangeRouteListener b = com.baidu.navisdk.adapter.impl.c.f().b();
        if (b != null) {
            b.onFail();
            com.baidu.navisdk.adapter.impl.c.f().a((IBNRouteGuideManager.ChangeRouteListener) null);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void h(int i) {
        b.f().onGuideModeChanged(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean h0() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void i(boolean z) {
        f.a().onFullViewButtonClick(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void i0() {
        this.f6676a = null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean isNodeClick() {
        return BNSettingManager.isNodeClick();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void j(boolean z) {
        b.f().a(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean j0() {
        if (!j.d()) {
            return BNaviAuthManager.getInstance().hasMapTrafficLightPermission();
        }
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void k(int i) {
        f.a().onZoomLevelChange(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void k0() {
        IBNRouteGuideManager.ChangeRouteListener b = com.baidu.navisdk.adapter.impl.c.f().b();
        if (b != null) {
            b.onSuccess();
            com.baidu.navisdk.adapter.impl.c.f().a((IBNRouteGuideManager.ChangeRouteListener) null);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void l() {
        b.f().onHighWayInfoUpdate(IBNaviListener.Action.UPDATE, b.f().a());
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public k.b l0() {
        return this.b;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void m(int i) {
        b.f().onVoiceModeChanged(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public k.a m0() {
        return this.f6676a;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void n(int i) {
        b.f().onMainSideBridgeUpdate(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean o0() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean onBackPressed() {
        if (com.baidu.navisdk.ui.routeguide.navicenter.b.b().a(com.baidu.navcore.ui.c.class.getName())) {
            com.baidu.navisdk.ui.routeguide.navicenter.b.b().a();
            return true;
        }
        if (com.baidu.navisdk.ui.routeguide.navicenter.b.b().a(com.baidu.navcore.ui.b.class.getName())) {
            com.baidu.navisdk.ui.routeguide.navicenter.b.b().a();
            return true;
        }
        if (com.baidu.navisdk.ui.routeguide.navicenter.b.b().a(com.baidu.navcore.ui.a.class.getName())) {
            com.baidu.navisdk.ui.routeguide.navicenter.b.b().a();
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar) {
        if (gVar != null) {
            BNaviLocation bNaviLocation = new BNaviLocation();
            if (SDKInitializer.getCoordType().equals(CoordType.BD09LL)) {
                LatLng wgsToBaidu = CoordTrans.wgsToBaidu(new LatLng(gVar.f6926a, gVar.b));
                bNaviLocation.latitude = wgsToBaidu.latitude;
                bNaviLocation.longitude = wgsToBaidu.longitude;
            } else {
                Bundle Wgs84ToGcj02 = JNITools.Wgs84ToGcj02(gVar.b, gVar.f6926a);
                bNaviLocation.latitude = Wgs84ToGcj02.getDouble("LLy");
                bNaviLocation.longitude = Wgs84ToGcj02.getDouble("LLx");
            }
            bNaviLocation.accuracy = gVar.f;
            bNaviLocation.altitude = gVar.h;
            bNaviLocation.direction = gVar.e;
            bNaviLocation.speed = gVar.c;
            bNaviLocation.time = gVar.j;
            b.f().onLocationChange(bNaviLocation);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void onNoNewRoute() {
        IBNRouteGuideManager.RefreshRouteListener c = com.baidu.navisdk.adapter.impl.c.f().c();
        if (c != null) {
            c.onNoNewRoute();
            com.baidu.navisdk.adapter.impl.c.f().a((IBNRouteGuideManager.RefreshRouteListener) null);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void onRemainInfoUpdate(int i, int i2) {
        b.f().onRemainInfoUpdate(i, i2);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void onRoadNameUpdate(String str) {
        b.f().onRoadNameUpdate(str);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean p() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean p0() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void q() {
        b.f().onHeavyTraffic();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void q0() {
        b.f().onHighWayInfoUpdate(IBNaviListener.Action.SHOW, b.f().a());
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void r() {
        f.a().onNaviTurnClick();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void r0() {
        b.f().onMapStateChange(IBNaviListener.MapStateMode.NAVING);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void s() {
        f.a().onMainInfoPanCLick();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean s0() {
        return BNSettingManager.isViaPreferRoutePlanEnable();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void t() {
        f.a().onNaviSettingClick();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void u() {
        IBNRouteGuideManager.RefreshRouteListener c = com.baidu.navisdk.adapter.impl.c.f().c();
        if (c != null) {
            c.onRefreshTimeout();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void u0() {
        b.f().d();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean v() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void w() {
        b.f().onYawingSuccess();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void w0() {
        f.a().onNaviBackClick();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void y(Message message) {
        b.f().onViaListRemainInfoUpdate(message);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean z() {
        return false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(com.baidu.navisdk.model.datastruct.g gVar) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void b(String str) {
        b.f().onNotificationShow(str);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void c(Activity activity, String str, Bundle bundle) {
        b.f().a(activity, str, bundle, IBNaviListener.Action.SHOW);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void d(boolean z) {
        b.f().onRoadEnlargeViewChanged(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void f(boolean z) {
        b.f().onAutoScaleChanged(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void h(boolean z) {
        b.f().onCarLogoToEndRedLineChanged(z);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void i(int i) {
        b.f().onFullViewModeChanged(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void j() {
        IBNRouteGuideManager.RefreshRouteListener c = com.baidu.navisdk.adapter.impl.c.f().c();
        if (c != null) {
            c.onSuccess();
            com.baidu.navisdk.adapter.impl.c.f().a((IBNRouteGuideManager.RefreshRouteListener) null);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean k() {
        return BaseTTSPlayer.j().c() != null;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public boolean m() {
        if (j.d()) {
            return true;
        }
        return BNaviAuthManager.getInstance().hasDynamicDataPermission();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(String str, int i) {
        int i2;
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i2 = -1;
        }
        b.f().onSpeedUpdate(i2, i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void b(Activity activity, String str, Bundle bundle) {
        b.f().a(activity, str, bundle, IBNaviListener.Action.HIDE);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void c(int i) {
        b.f().onGuideViewModeChanged(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void y() {
        b.f().onLaneInfoUpdate(IBNaviListener.Action.HIDE, null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void b(int i) {
        b.f().a(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void l(int i) {
        b.f().onYawingArriveViaPoint(i);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(String str, int i, String str2, int i2) {
        b.f().a(str, i, str2, i2);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(double d) {
        b.f().onRoadConditionInfoUpdate(d, b.f().b());
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(String str, int i, String str2) {
        b.f().a(str, i, str2);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(Activity activity, String str, Bundle bundle) {
        b.f().a(activity, str, bundle, IBNaviListener.Action.UPDATE);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(List<RGLineItem> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new BNavLineItem(list.get(i)));
        }
        b.f().onLaneInfoUpdate(IBNaviListener.Action.SHOW, arrayList);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a() {
        b.f().onNaviGuideEnd();
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(String str) {
        b.f().a(str);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(k.a aVar) {
        this.f6676a = aVar;
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(k.b bVar) {
        this.b = bVar;
    }
}

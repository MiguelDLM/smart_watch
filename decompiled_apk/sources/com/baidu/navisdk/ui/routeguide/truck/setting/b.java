package com.baidu.navisdk.ui.routeguide.truck.setting;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.module.trucknavi.c;
import com.baidu.navisdk.module.trucknavi.logic.plate.d;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.y;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;

/* loaded from: classes8.dex */
public class b implements com.baidu.navisdk.module.trucknavi.view.support.module.setting.interfaces.a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.trucknavi.view.support.module.setting.interfaces.b f9139a;
    private final Activity b;

    public b(Activity activity) {
        this.b = activity;
        if (com.baidu.navisdk.module.trucknavi.preferences.a.r0().s() == 0 && !l.c(com.baidu.navisdk.framework.a.c().a())) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().m(2);
        }
        if (TextUtils.isEmpty(c.a()) && com.baidu.navisdk.module.trucknavi.preferences.a.r0().S()) {
            com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().b(false);
        }
    }

    private String j() {
        VoiceInterfaceImplProxy o;
        if (!j.d() || (o = com.baidu.navisdk.framework.interfaces.c.p().o()) == null) {
            return null;
        }
        String currentVoiceWithMultiStyle = o.getCurrentVoiceWithMultiStyle();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("TruckNaviSettingPagePre", "getVoiceName， ttsId=" + currentVoiceWithMultiStyle);
        }
        if (currentVoiceWithMultiStyle != null && !"putonghua99".equals(currentVoiceWithMultiStyle) && !o.getCurGlobalId().equals(currentVoiceWithMultiStyle)) {
            String downloadedVoiceOuterBeanName = o.getDownloadedVoiceOuterBeanName(currentVoiceWithMultiStyle);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("TruckNaviSettingPagePre", "getVoiceName， name=" + downloadedVoiceOuterBeanName);
                return downloadedVoiceOuterBeanName;
            }
            return downloadedVoiceOuterBeanName;
        }
        return JarUtils.getResources().getString(R.string.nsdk_string_normal_new);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void b() {
        c.b();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.c
    public void c() {
        if (this.f9139a != null) {
            d dVar = new d(com.baidu.navisdk.module.trucknavi.logic.plate.c.g().a());
            boolean S = com.baidu.navisdk.module.trucknavi.preferences.a.r0().S();
            this.f9139a.a(dVar, S);
            this.f9139a.d(S);
            this.f9139a.m(com.baidu.navisdk.module.trucknavi.preferences.a.r0().p());
            this.f9139a.l(com.baidu.navisdk.module.trucknavi.preferences.a.r0().o());
            this.f9139a.k(com.baidu.navisdk.module.trucknavi.preferences.a.r0().m());
            this.f9139a.v(com.baidu.navisdk.module.trucknavi.preferences.a.r0().I());
            this.f9139a.k(com.baidu.navisdk.module.trucknavi.preferences.a.r0().v());
            this.f9139a.p(com.baidu.navisdk.module.trucknavi.preferences.a.r0().H());
            this.f9139a.e(j());
            this.f9139a.l(com.baidu.navisdk.module.trucknavi.preferences.a.r0().X());
            this.f9139a.r(com.baidu.navisdk.module.trucknavi.preferences.a.r0().t());
            this.f9139a.w(com.baidu.navisdk.module.trucknavi.preferences.a.r0().a0());
            this.f9139a.j(com.baidu.navisdk.module.trucknavi.preferences.a.r0().s() != 2);
            this.f9139a.i(com.baidu.navisdk.module.trucknavi.preferences.a.r0().u());
            this.f9139a.g(com.baidu.navisdk.module.trucknavi.preferences.a.r0().k());
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void d(boolean z) {
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().m(z ? 0 : 2);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void e(boolean z) {
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().m(z);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void f(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("TruckNaviSettingPagePre", "updatePlateLimitOpen-> isOpen=" + z + ", CarNum=" + c.a());
        }
        if (z && TextUtils.isEmpty(c.a())) {
            z = false;
        }
        com.baidu.navisdk.module.trucknavi.logic.plate.c.g().b(z);
        com.baidu.navisdk.module.trucknavi.view.support.module.setting.interfaces.b bVar = this.f9139a;
        if (bVar != null) {
            bVar.m(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void g(boolean z) {
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().s(z);
        if (z) {
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
            y.d();
        } else {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J4();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(false);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v3();
        }
    }

    public void h(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("TruckNaviSettingPagePre", "updatePlateWeightLimitOpen-> isOpen=" + z);
        }
        com.baidu.navisdk.module.trucknavi.logic.plate.c.g().a(z);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void i() {
        if (this.f9139a != null) {
            d a2 = com.baidu.navisdk.module.trucknavi.logic.plate.c.g().a();
            if (TextUtils.isEmpty(a2.getPlate())) {
                com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().b(false);
                this.f9139a.d(false);
            }
            this.f9139a.a(a2, g());
            this.f9139a.r(com.baidu.navisdk.module.trucknavi.preferences.a.r0().t());
            if (com.baidu.navisdk.module.trucknavi.preferences.a.r0().s() == 0 && !l.c(com.baidu.navisdk.framework.a.c().a())) {
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().m(2);
                this.f9139a.j(false);
            }
            e();
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.c
    public void a(com.baidu.navisdk.module.trucknavi.view.support.module.setting.interfaces.b bVar) {
        this.f9139a = bVar;
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void b(int i) {
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().k(i);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public int d() {
        return com.baidu.navisdk.module.trucknavi.preferences.a.r0().o();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void e() {
        com.baidu.navisdk.module.trucknavi.view.support.module.setting.interfaces.b bVar = this.f9139a;
        if (bVar != null) {
            bVar.e(j());
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void a(boolean z) {
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().n(z);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void b(boolean z) {
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(z);
        BNMapController.getInstance().getMapController().m(z);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void d(int i) {
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().g(i);
        this.f9139a.r(com.baidu.navisdk.module.trucknavi.preferences.a.r0().t());
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void a(int i) {
        com.baidu.navisdk.ui.routeguide.b.V().b(i);
        x.b().I().b(true);
        x.b().Y2();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void h() {
        com.baidu.navisdk.framework.b.a(18, (Object) 0);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public boolean g() {
        return com.baidu.navisdk.module.trucknavi.preferences.a.r0().S();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void f() {
        com.baidu.navisdk.module.page.a.b().a(26, null, this.b);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void c(int i) {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.1", "", null, "2");
        RouteGuideFSM.getInstance().setFullViewByUser(false);
        if (i == 1 || i == 3) {
            RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.Car3D);
        } else if (i == 2) {
            RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.North2D);
        }
        com.baidu.navisdk.ui.routeguide.b.V().r().l();
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().j(i);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void c(boolean z) {
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().p(z);
        BNRouteGuider.getInstance().enableExpandmapDownload(z);
    }
}

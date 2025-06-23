package com.baidu.navisdk.ui.routeguide.motor.setting;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.j;
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
public class b implements com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.b f9029a;
    private final Activity b;

    public b(Activity activity) {
        this.b = activity;
        if (com.baidu.navisdk.module.motorbike.preferences.a.u0().w() == 0 && !l.c(com.baidu.navisdk.framework.a.c().a())) {
            com.baidu.navisdk.module.motorbike.preferences.a.u0().n(2);
        }
        if (TextUtils.isEmpty(com.baidu.navisdk.module.motorbike.a.a()) && com.baidu.navisdk.module.motorbike.preferences.a.u0().V()) {
            com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().b(false);
        }
    }

    private String j() {
        if (!j.d()) {
            return null;
        }
        VoiceInterfaceImplProxy o = c.p().o();
        if (o == null) {
            return "";
        }
        String currentVoiceWithMultiStyle = o.getCurrentVoiceWithMultiStyle();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MotorNaviSettingPagePre", "getVoiceName， ttsId=" + currentVoiceWithMultiStyle);
        }
        if (currentVoiceWithMultiStyle != null && !"putonghua99".equals(currentVoiceWithMultiStyle) && !o.getCurGlobalId().equals(currentVoiceWithMultiStyle)) {
            String downloadedVoiceOuterBeanName = o.getDownloadedVoiceOuterBeanName(currentVoiceWithMultiStyle);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("MotorNaviSettingPagePre", "getVoiceName， name=" + downloadedVoiceOuterBeanName);
                return downloadedVoiceOuterBeanName;
            }
            return downloadedVoiceOuterBeanName;
        }
        return JarUtils.getResources().getString(R.string.nsdk_string_normal_new);
    }

    private void k() {
        if (com.baidu.navisdk.framework.b.e0()) {
            com.baidu.navisdk.module.motorbike.a.a(true);
        } else {
            com.baidu.navisdk.module.motorbike.a.c();
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void b() {
        com.baidu.navisdk.module.motorbike.a.b();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.c
    public void c() {
        if (this.f9029a != null) {
            com.baidu.navisdk.module.motorbike.logic.plate.c cVar = new com.baidu.navisdk.module.motorbike.logic.plate.c(com.baidu.navisdk.module.motorbike.logic.plate.b.d().a());
            boolean V = com.baidu.navisdk.module.motorbike.preferences.a.u0().V();
            this.f9029a.a(cVar, V);
            this.f9029a.d(V);
            this.f9029a.m(com.baidu.navisdk.module.motorbike.preferences.a.u0().q());
            this.f9029a.l(com.baidu.navisdk.module.motorbike.preferences.a.u0().o());
            this.f9029a.k(com.baidu.navisdk.module.motorbike.preferences.a.u0().m());
            this.f9029a.v(com.baidu.navisdk.module.motorbike.preferences.a.u0().L());
            this.f9029a.k(com.baidu.navisdk.module.motorbike.preferences.a.u0().z());
            this.f9029a.p(com.baidu.navisdk.module.motorbike.preferences.a.u0().K());
            this.f9029a.e(j());
            this.f9029a.l(com.baidu.navisdk.module.motorbike.preferences.a.u0().a0());
            this.f9029a.r(com.baidu.navisdk.module.motorbike.preferences.a.u0().x());
            this.f9029a.w(com.baidu.navisdk.module.motorbike.preferences.a.u0().d0());
            this.f9029a.j(com.baidu.navisdk.module.motorbike.preferences.a.u0().w() != 2);
            this.f9029a.i(com.baidu.navisdk.module.motorbike.preferences.a.u0().y());
            this.f9029a.g(com.baidu.navisdk.module.motorbike.preferences.a.u0().k());
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void d(boolean z) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().n(z ? 0 : 2);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void e(boolean z) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().o(z);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void f(boolean z) {
        if (z && TextUtils.isEmpty(com.baidu.navisdk.module.motorbike.a.a())) {
            com.baidu.navisdk.module.motorbike.a.b();
        }
        com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().b(z);
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.b bVar = this.f9029a;
        if (bVar != null) {
            bVar.m(z);
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void g(boolean z) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().u(z);
        if (z) {
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
            y.d();
        } else {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J4();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(false);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v3();
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void h() {
        com.baidu.navisdk.framework.b.a(18, (Object) 0);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void i() {
        if (this.f9029a != null) {
            com.baidu.navisdk.module.motorbike.logic.plate.c a2 = com.baidu.navisdk.module.motorbike.logic.plate.b.d().a();
            if (TextUtils.isEmpty(a2.getPlate())) {
                com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().b(false);
            }
            boolean g = g();
            this.f9029a.d(g);
            this.f9029a.a(a2, g);
            this.f9029a.r(com.baidu.navisdk.module.motorbike.preferences.a.u0().x());
            if (com.baidu.navisdk.module.motorbike.preferences.a.u0().w() == 0 && !l.c(com.baidu.navisdk.framework.a.c().a())) {
                com.baidu.navisdk.module.motorbike.preferences.a.u0().n(2);
                this.f9029a.j(false);
            }
            e();
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.c
    public void a(com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.b bVar) {
        this.f9029a = bVar;
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void b(int i) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().k(i);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public int d() {
        return com.baidu.navisdk.module.motorbike.preferences.a.u0().o();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void e() {
        com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.b bVar = this.f9029a;
        if (bVar != null) {
            bVar.e(j());
        }
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void a(boolean z) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().p(z);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void b(boolean z) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().a(z);
        BNMapController.getInstance().getMapController().m(z);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void d(int i) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().g(i);
        this.f9029a.r(com.baidu.navisdk.module.motorbike.preferences.a.u0().x());
    }

    @Override // com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a
    public void a(com.baidu.navisdk.module.motorbike.logic.plate.c cVar) {
        k();
    }

    @Override // com.baidu.navisdk.module.motorbike.view.support.module.setting.interfaces.a
    public com.baidu.navisdk.module.motorbike.logic.plate.c a() {
        return com.baidu.navisdk.module.motorbike.logic.plate.b.d().a();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void a(int i) {
        com.baidu.navisdk.ui.routeguide.b.V().b(i);
        x.b().I().b(true);
        x.b().Y2();
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void f() {
        com.baidu.navisdk.module.page.a.b().a(18, null, this.b);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public boolean g() {
        return com.baidu.navisdk.module.motorbike.preferences.a.u0().V();
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
        com.baidu.navisdk.module.motorbike.preferences.a.u0().j(i);
    }

    @Override // com.baidu.navisdk.module.vehiclemanager.interfaces.a
    public void c(boolean z) {
        com.baidu.navisdk.module.motorbike.preferences.a.u0().r(z);
        BNRouteGuider.getInstance().enableExpandmapDownload(z);
    }
}

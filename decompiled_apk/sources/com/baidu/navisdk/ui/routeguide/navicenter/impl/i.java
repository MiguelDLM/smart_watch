package com.baidu.navisdk.ui.routeguide.navicenter.impl;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.abtest.model.k;
import com.baidu.navisdk.ui.routeguide.control.n;
import com.baidu.navisdk.ui.routeguide.control.r;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.l;
import com.baidu.navisdk.ui.routeguide.model.m;
import com.baidu.navisdk.ui.routeguide.model.s;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class i implements com.baidu.navisdk.comapi.routeguide.e {

    /* renamed from: a, reason: collision with root package name */
    private final BNavigatorLogic f9076a;

    public i(BNavigatorLogic bNavigatorLogic) {
        this.f9076a = bNavigatorLogic;
    }

    private void a(Message message, boolean z) {
        int i = message.arg2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("RGSubStatusListenerImpl", "onStartYawing naviSight=" + i + "，isFake" + z);
        }
        boolean A = a0.I().A();
        com.baidu.navisdk.ui.routeguide.holder.a.d().b(false);
        a0.I().f(true);
        l.f().b(true);
        com.baidu.navisdk.ui.routeguide.holder.a.d().a(false);
        com.baidu.navisdk.module.pronavi.model.i.f().b = false;
        a0.I().a(z);
        x.b().u(z);
        if (A) {
            if (gVar.d()) {
                gVar.e("RGSubStatusListenerImpl", "onStartYawing: refreshGuidePanelMode");
            }
            x.b().s3();
        }
        if (i == 7 || com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
            if (z) {
                return;
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().d(JarUtils.getResources().getString(R.string.nsdk_string_indoor_nav_route_plan_yawing_text));
            com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().v();
            return;
        }
        if (!z) {
            com.baidu.navisdk.framework.c.b().a(11, 12);
        }
        a0.I().i(false);
        x.b().F();
        if (!RGFSMTable.FsmState.HUD.equals(RouteGuideFSM.getInstance().getTopState()) && !RGFSMTable.FsmState.HUDMirror.equals(RouteGuideFSM.getInstance().getTopState())) {
            if (RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b())) {
                com.baidu.navisdk.ui.routeguide.b.V().r().l();
            }
            m.y().b(false);
            if (com.baidu.navisdk.ui.routeguide.asr.c.n().i()) {
                com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_YAWING_START);
            if (!z && RGFSMTable.FsmState.SimpleGuide.equals(RouteGuideFSM.getInstance().getCurrentState()) && !x.b().u2()) {
                x.b().s3();
            }
        } else {
            if (gVar.d()) {
                gVar.e("HUD=========111=");
            }
            x.b().V3();
        }
        com.baidu.navisdk.module.pronavi.model.g.o().m();
        m.y().w();
        com.baidu.navisdk.ui.routeguide.model.j.e().d();
        com.baidu.navisdk.ui.routeguide.model.c.a().b(false);
        s.a().a(false);
        x.b().z0();
        r.i().f();
        com.baidu.navisdk.ui.routeguide.b.V().w();
        com.baidu.navisdk.ui.routeguide.control.s.T().a(false, false, false);
        x.b().h1();
        x.b().D0();
        x.b().Y0();
        x.b().i(false);
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().l().e();
        }
        x.b().u1();
        x.b().m1();
        x.b().n1();
        x.b().c1();
        x.b().K0();
        x.b().B(1);
        x.b().E(false);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().a(8, false);
        x.b().A(false);
        x.b().M(false);
        x.b().J4();
        t.s().f();
        x.b().I().c(false);
        x.b().J().a(false, true);
        x.b().J().e(false);
        if (!com.baidu.navisdk.ugc.d.a()) {
            x.b().o3();
            x.b().b3();
        }
        x.b().a1();
        com.baidu.navisdk.module.a.h().c();
        if (com.baidu.navisdk.module.offscreen.a.g && com.baidu.navisdk.module.offscreen.a.h) {
            com.baidu.navisdk.module.offscreen.a.j = false;
            com.baidu.navisdk.module.offscreen.a.m().f();
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().b().f();
        }
        x.b().A1();
        x.b().h();
        LogUtil.e("XDVoice", "onRoutePlanYawing（） , XDPlan can't show");
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(false);
        if (z) {
            return;
        }
        x.b().B4();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().d(JarUtils.getResources().getString(R.string.nsdk_string_rg_nav_route_plan_yawing_text));
    }

    private void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSubStatusListenerImplVIA_ETA", "clearToolboxViaEta-> getUnpassedApproachPoiCount= " + com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.f());
        }
        if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.f() < 1) {
            x.b().D1();
            a0.I().G();
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.e
    public void b(Message message) {
        int i = message.arg2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSubStatusListenerImpl", "onReRouteComplete-> naviSight=" + i);
        }
        a0.I().c(false);
        a0.E = false;
        a0.I().f(false);
        a0.I().a(false);
        l.f().b(false);
        l.d(false);
        a0.I().g(false);
        com.baidu.navisdk.ui.routeguide.holder.a.d().a(false);
        m.y().w();
        com.baidu.navisdk.ui.routeguide.model.j.e().d();
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(true);
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.6", "99", i + "");
        if (i != 7 && !com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().m()) {
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b = com.baidu.navisdk.ui.routeguide.utils.b.b(false);
            if (b != null) {
                b.b("onReRouteComplete");
            }
            x.b().D(0);
            x.b().r1();
            x.b().L3();
            if (com.baidu.navisdk.ui.routeguide.b.V().o() != null) {
                com.baidu.navisdk.ui.routeguide.b.V().o().f();
            }
            x.b().z0();
            x.b().M1();
            x.b().m1();
            x.b().n1();
            com.baidu.navisdk.ui.routeguide.b.V().w();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v(false);
            if (!RGFSMTable.FsmState.HUD.equals(RouteGuideFSM.getInstance().getTopState()) && !RGFSMTable.FsmState.HUDMirror.equals(RouteGuideFSM.getInstance().getTopState())) {
                if (com.baidu.navisdk.ui.routeguide.asr.c.n().i()) {
                    com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
                }
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_YAWING_REROUTED);
            } else {
                LogUtil.e("", "HUD=========222=");
                x.b().N1();
                l.e = com.baidu.navisdk.util.common.h.a();
            }
            if (this.f9076a.v() != null) {
                this.f9076a.v().c();
            }
            c();
            n.d().a();
            Bundle bundle = new Bundle();
            LogUtil.e("RGSubStatusListenerImpl", "OfflineToOnline getRoutePlanSubResult subResult " + BNRoutePlaner.getInstance().a((ArrayList<Bundle>) null, bundle));
            if (com.baidu.navisdk.module.pronavi.a.j != 2 && BNRoutePlaner.getInstance().B()) {
                x.b().J(true);
            }
            if (bundle.containsKey("enPlanNetMode")) {
                BNRoutePlaner.getInstance().q(bundle.getInt("enPlanNetMode"));
            }
            LogUtil.e("XDVoice", "onReRouteComplete（） , XDPlan setEnable(true)");
            x.b().M(true);
            com.baidu.navisdk.ui.routeguide.control.s.T().v();
            com.baidu.navisdk.ui.routeguide.control.s.T().x();
            return;
        }
        x.b().M1();
        x.b().m1();
        x.b().n1();
        x.b().s3();
        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().w();
    }

    @Override // com.baidu.navisdk.comapi.routeguide.e
    public void d(Message message) {
        int i = message.arg2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("RGSubStatusListenerImpl", "onRoutePlanBegin-> naviSight=" + i);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.e
    public void e(Message message) {
        if (RouteGuideFSM.getInstance().getTopState() == RGFSMTable.FsmState.ArriveDest) {
            LogUtil.e("RGSubStatusListenerImpl", "onReRouteCarFree - getCurrentState is ArriveDest, return!");
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
            LogUtil.e("RGSubStatusListenerImpl", "onReRouteCarFree - isIndoorParkState, return!");
            return;
        }
        LogUtil.e("RGSubStatusListenerImpl", "onReRouteCarFree");
        a0.I().g(true);
        a0.I().f(false);
        l.f().b(false);
        x.b().z0();
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        x.b().o4();
        x.b().b(a0.I().h(), m.y().u());
    }

    @Override // com.baidu.navisdk.comapi.routeguide.e
    public void f(Message message) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("onRoutePlanFakeYawing");
        }
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.6.4", "2");
        k.x().s();
        com.baidu.navisdk.ui.routeguide.utils.b.b("onRoutePlanFakeYawing");
        if (com.baidu.navisdk.module.cloudconfig.f.c().c.j0) {
            a0.I().c(true);
        } else {
            a(message, true);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.e
    public void g(Message message) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("onYawingLoading");
        }
        if (com.baidu.navisdk.module.cloudconfig.f.c().c.j0) {
            a0.I().c(false);
            a(message, false);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.e
    public void h(Message message) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("RGSubStatusListenerImpl", "onRoutePlanYawing");
        }
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.6.4", "1");
        ProNaviStatItem.O().p();
        com.baidu.navisdk.naviresult.a.d().a().i();
        k.x().s();
        if (com.baidu.navisdk.ui.routeguide.b.V().k() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().k().a();
        }
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.c(BNRouteGuider.getInstance().getTruckSDKYawStamp());
        }
        com.baidu.navisdk.ui.routeguide.utils.b.b("onRoutePlanYawing");
        if (com.baidu.navisdk.module.cloudconfig.f.c().c.j0) {
            a0.I().c(true);
        } else {
            a(message, false);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.e
    public void i(Message message) {
        boolean z = false;
        if (message.arg2 != 5) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().G(false);
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a o5 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5();
        if (message.arg1 != 11) {
            z = true;
        }
        o5.G(z);
    }

    private boolean d() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c a2 = com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c.a(BNRouteGuider.getInstance().getDestRecommendInfo());
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
        if (gVar.d()) {
            gVar.e("dest model:" + a2);
        }
        if (!a2.a()) {
            return false;
        }
        BNRoutePlaner.getInstance().o();
        x.b().m1();
        BNRouteGuider.getInstance().stopRouteGuide();
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        com.baidu.navisdk.module.powersavemode.f.o().h();
        if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.Voice)) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.VOICE_STATE_EXIT);
        }
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENTER_ARRIVE_DEST);
        x.b().l3();
        com.baidu.navisdk.ugc.interaction.c.a().a(2);
        BNRoutePlaner.getInstance().p(10);
        com.baidu.navisdk.ui.routeguide.control.i.g().a(new com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.b(com.baidu.navisdk.ui.routeguide.b.V().c(), a2));
        return true;
    }

    @Override // com.baidu.navisdk.comapi.routeguide.e
    public void c(Message message) {
        int i = message.arg2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSubStatusListenerImpl", "onArriveDestNear-> naviSight=" + i);
        }
    }

    private void e() {
        com.baidu.navisdk.comapi.commontool.c.c().a(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.comapi.commontool.c.e);
        SDKDebugFileUtil.get(SDKDebugFileUtil.END_GUIDE_FILENAME).add("onArriveDest: will quit routeguide!!!");
        com.baidu.navisdk.util.statistic.userop.b.r().a("1.5", "2", null, null);
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "2", com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k() ? "2" : "1", null);
        com.baidu.navisdk.naviresult.a.d().a().b(true);
        k.x().f(false);
        this.f9076a.b(false);
        this.f9076a.y0();
        com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410343", "410343");
    }

    private void b() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1473", null, null, null);
        e();
        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().r();
    }

    @Override // com.baidu.navisdk.comapi.routeguide.e
    public void a(Message message) {
        int i = message.arg2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSubStatusListenerImpl", "onArriveDest-> naviSight=" + i);
        }
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a a2 = com.baidu.navisdk.ui.routeguide.utils.b.a();
        if (a2 != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSubStatusListenerImpl", "onArriveDest: exitARNavi");
            }
            a2.l();
        }
        this.f9076a.i(true);
        if (com.baidu.navisdk.ui.routeguide.control.d.e.a()) {
            return;
        }
        if (i != 7 && !com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().m()) {
            a();
        } else {
            b();
        }
        if (this.f9076a.v() != null) {
            this.f9076a.v().a(0, -1, -1, null);
            com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                k.H();
            }
        }
    }

    private void a() {
        e();
        if (!com.baidu.navisdk.j.d()) {
            if (BNSettingManager.isAutoQuitWhenArrived()) {
                com.baidu.navisdk.ui.routeguide.b.V().Q();
                return;
            }
            return;
        }
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().d().f()) {
            com.baidu.navisdk.ui.routeguide.control.f.k().a();
            if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
                com.baidu.navisdk.ui.routeguide.b.V().j().b().h();
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().d().g()) {
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            return;
        }
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null && fVar.g() != null) {
            int parkType = fVar.g().getParkType();
            r1 = com.baidu.navisdk.util.common.h.c(parkType) || com.baidu.navisdk.util.common.h.d(parkType);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSubStatusListenerImpl", "arriveCarDest parkType: " + parkType);
            }
        }
        if (LogUtil.LOGGABLE) {
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getRouteInfoInUniform(24, bundle);
            LogUtil.e("RGSubStatusListenerImpl", "onArriveDest->getDestNodeInfo=" + bundle + ", isIndoorScene=" + r1);
        }
        if (r1 && com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().f()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGSubStatusListenerImpl", "handleArriveCarDest=true!");
            }
        } else {
            if (d()) {
                return;
            }
            com.baidu.navisdk.ui.routeguide.b.V().Q();
        }
    }
}

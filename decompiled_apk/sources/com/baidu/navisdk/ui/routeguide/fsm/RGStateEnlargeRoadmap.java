package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.module.pronavi.model.i;
import com.baidu.navisdk.ugc.d;
import com.baidu.navisdk.ui.routeguide.b;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class RGStateEnlargeRoadmap extends RGBaseState {
    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter() {
        super.enter();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void excute(Bundle bundle) {
        g.PRO_NAV.d();
        super.excute(bundle);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        if (i.f().b) {
            i.f().b = false;
            BNMapController.getInstance().recoveryHighLightRoute();
        }
        if (!com.baidu.navisdk.ui.routeguide.model.g.h().e()) {
            x.b().O0();
            BNMapController.getInstance().setEnlargedStatus(false);
        }
        x.b().n4();
        if (!x.b().s2()) {
            x.b().K4();
        }
        x.b().N3();
        x.b().T4();
        if (a.o5().d0() == 2) {
            x.b().n(false);
            x.b().b();
        }
        x.b().M(true);
        super.exit();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public boolean intercept(Bundle bundle) {
        if (d.a()) {
            return true;
        }
        return super.intercept(bundle);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        BNMapController.getInstance().setEnlargedStatus(true);
        q.c().b();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        l.l().a();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        if (i.f().b) {
            i.f().b = false;
            BNMapController.getInstance().recoveryHighLightRoute();
        }
        if (!RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b())) {
            x.b().e(1);
        }
        x.b().u(0);
        x.b().O3();
        x.b().v(1);
        if (RGLaneInfoModel.getModel(false).isShowLaneLineView()) {
            a.o5().t(true);
        }
        x.b().E1();
        x.b().k1();
        x.b().B(1);
        x.b().Z4();
        x.b().I1();
        x.b().o3();
        x.b().a1();
        s.T().p();
        s.T().n();
        if (!s.T().i(999)) {
            s.T().o();
        }
        x.b().L3();
        if (a.o5().d0() == 2) {
            x.b().n(true);
            x.b().b();
        }
        x.b().B(true);
        x.b().a(false);
        x.b().b3();
        x.b().T0();
        x.b().I().a(8);
        x.b().A(false);
        x.b().M(false);
        x.b().I().c(false);
        t.s().f();
        if (b.V().j() != null) {
            b.V().j().b().c();
        }
    }
}

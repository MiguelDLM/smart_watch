package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.module.pronavi.model.i;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class RGStateColladamap extends RGBaseState {
    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter() {
        super.enter();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void excute() {
        super.excute();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "excute by reflection");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        if (i.f().b) {
            i.f().b = false;
            BNMapController.getInstance().recoveryHighLightRoute();
        }
        if (!com.baidu.navisdk.ui.routeguide.model.g.h().e()) {
            BNMapController.getInstance().setEnlargedStatus(false);
        }
        super.exit();
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
        if (RGLaneInfoModel.getModel(false).isShowLaneLineView()) {
            a.o5().X3();
        }
        x.b().Z4();
        x.b().n4();
        x.b().p4();
        x.b().N3();
        x.b().I1();
        s.T().a(false, true, true);
        x.b().o3();
        x.b().a1();
        x.b().a(false);
    }
}

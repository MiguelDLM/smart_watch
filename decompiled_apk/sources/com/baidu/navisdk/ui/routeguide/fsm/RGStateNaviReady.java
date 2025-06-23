package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.poisearch.model.a;
import com.baidu.navisdk.ui.routeguide.control.b;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.c;
import com.baidu.navisdk.ui.routeguide.model.j;
import com.baidu.navisdk.ui.routeguide.model.m;
import com.baidu.navisdk.ui.routeguide.model.s;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class RGStateNaviReady extends RGBaseState {
    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        super.exit();
        x.b().K1();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
        if (a.k().h()) {
            BNMapController.getInstance().showLayer(4, true);
            BNMapController.getInstance().updateLayer(4);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        b.k().a(true);
        BNMapController.getInstance().setEnlargedStatus(false);
        q.c().b();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        l.l().b();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGStateNaviReady", "onActionUI");
        }
        com.baidu.navisdk.ui.routeguide.holder.a.d().a(true);
        x.b().z0();
        com.baidu.navisdk.module.pronavi.model.g.o().m();
        m.y().w();
        j.e().d();
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().l().e();
        }
        c.a().b(false);
        s.a().a(false);
        com.baidu.navisdk.ui.routeguide.control.s.T().a(false, false, false);
        x.b().s3();
        x.b().h1();
        x.b().D0();
        x.b().Y0();
        x.b().i(false);
        x.b().I().a(8);
        x.b().m1();
        x.b().n1();
        x.b().c1();
        x.b().K0();
        x.b().a4();
        x.b().H0();
        x.b().B(1);
        x.b().K3();
        a0.I().i(false);
        x.b().F();
        if (com.baidu.navisdk.module.offscreen.a.g && com.baidu.navisdk.module.offscreen.a.h) {
            com.baidu.navisdk.module.offscreen.a.j = false;
            com.baidu.navisdk.module.offscreen.a.m().f();
        }
    }
}

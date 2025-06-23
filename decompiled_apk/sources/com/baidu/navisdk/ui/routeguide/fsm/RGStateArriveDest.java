package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.b;
import com.baidu.navisdk.ui.routeguide.control.f;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.c;
import com.baidu.navisdk.ui.routeguide.model.s;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class RGStateArriveDest extends RGStateBaseBrowseMap {
    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter(Bundle bundle) {
        super.enter(bundle);
        BNMapController.getInstance().setPreFinishStatus(true);
        BNRouteGuider.getInstance().SetFullViewState(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        super.exit();
        d.B().f();
        f.k().j();
        BNMapController.getInstance().setPreFinishStatus(false);
        BNRouteGuider.getInstance().SetFullViewState(false);
        x.b().C4();
        a.c().d = false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        super.onActionMapStatus();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        super.onActionNaviEngine();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        super.onActionUI();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGStateArriveDest", "onActionUI");
        }
        String string = this.enterParams.getString(RGFSMTable.FsmParamsKey.RUN_EVENT);
        if (!RGFSMTable.FsmEvent.MSG_ENTER_ARRIVE_DEST.equals(string) && !RGFSMTable.FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED.equals(string)) {
            if (RGFSMTable.FsmEvent.MAP_MOVE.equals(string) || RGFSMTable.FsmEvent.TOUCH_MAP.equals(string)) {
                f.k().j();
                return;
            }
            return;
        }
        b.V().R();
        c.a().b(false);
        s.a().a(false);
        x.b().G(false);
        com.baidu.navisdk.ui.routeguide.control.s.T().a(false, false, false);
        x.b().z0();
        x.b().A0();
        x.b().S0();
        x.b().h1();
        x.b().Y0();
        x.b().i(false);
        x.b().I().a(8);
        x.b().K0();
        x.b().I0();
        x.b().j1();
        x.b().C1();
        x.b().y1();
        x.b().E(false);
        x.b().I().c(false);
        t.s().f();
        a0.I().i(false);
        if (com.baidu.navisdk.module.offscreen.a.g && com.baidu.navisdk.module.offscreen.a.h) {
            com.baidu.navisdk.module.offscreen.a.j = false;
            com.baidu.navisdk.module.offscreen.a.m().f();
        }
        d.B().w();
        x.b().E1();
        x.b().B1();
        x.b().k1();
        x.b().k();
        x.b().R0();
        x.b().U0();
        x.b().M0();
        com.baidu.navisdk.module.vmsr.c.f().c();
        x.b().J4();
        x.b().M(false);
        x.b().h();
    }
}

package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.ugc.d;
import com.baidu.navisdk.ui.routeguide.b;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.ui.routeguide.model.x;

/* loaded from: classes8.dex */
public class RGStateVoice extends RGBaseState {
    private boolean operableViewNeedHide() {
        if (x.A().s() || s.T().k(112) || s.T().k(119) || s.T().k(120) || s.T().k(121) || s.T().k(133) || s.T().k(137)) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
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

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        a.o5().h1();
        if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState())) {
            com.baidu.navisdk.ui.routeguide.control.x.b().P0();
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().D0();
        com.baidu.navisdk.ui.routeguide.control.x.b().H0();
        com.baidu.navisdk.ui.routeguide.control.x.b().K3();
        com.baidu.navisdk.ui.routeguide.control.x.b().a(true);
        com.baidu.navisdk.ui.routeguide.control.x.b().I().a(8);
        com.baidu.navisdk.ui.routeguide.control.x.b().u(0);
        com.baidu.navisdk.ui.routeguide.control.x.b().L3();
        com.baidu.navisdk.ui.routeguide.control.x.b().Y0();
        com.baidu.navisdk.ui.routeguide.control.x.b().A0();
        com.baidu.navisdk.ui.routeguide.control.x.b().F1();
        com.baidu.navisdk.ui.routeguide.control.x.b().o3();
        com.baidu.navisdk.ui.routeguide.control.x.b().a1();
        com.baidu.navisdk.ui.routeguide.control.x.b().b3();
        com.baidu.navisdk.ui.routeguide.control.x.b().B(1);
        com.baidu.navisdk.ui.routeguide.control.x.b().A(false);
        com.baidu.navisdk.ui.routeguide.control.x.b().E(false);
        if (b.V().j() != null) {
            b.V().j().b().f();
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().T0();
        if (operableViewNeedHide()) {
            s.T().o();
            s.T().p();
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().s3();
        com.baidu.navisdk.ui.routeguide.control.x.b().I().c(false);
        t.s().f();
    }
}

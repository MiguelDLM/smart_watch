package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.skyeye.event.b;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.ui.routeguide.model.t;

/* loaded from: classes8.dex */
public class RGStateSimpleGuide extends RGBaseState {
    private void resetEnlargeRoadMap() {
        i.s().a(false);
        x.b().P0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void excute(Bundle bundle) {
        super.excute(bundle);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        d.B().a(1);
        a.a().a(new b(RGFSMTable.FsmState.SimpleGuide));
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
            BNMapController.getInstance().showLayer(4, true);
            BNMapController.getInstance().updateLayer(4);
        }
        if (t.s().j()) {
            RouteGuideFSM.getInstance();
            if (RGFSMTable.FsmState.Fullview.equals(RouteGuideFSM.getCurrentGlassState())) {
                t.s().n();
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        com.baidu.navisdk.ui.routeguide.control.b.k().a(true);
        BNMapController.getInstance().setEnlargedStatus(false);
        q.c().b();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        l.l().b();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        x.b().s3();
        resetEnlargeRoadMap();
        x.b().Z4();
        x.b().n4();
        x.b().N3();
        x.b().H0();
        x.b().K3();
        x.b().v(0);
        x.b().l(true);
        x.b().G4();
        x.b().U4();
        x.b().B(1);
        x.b().E(true);
        Bundle bundle = this.enterParams;
        if (bundle == null || !bundle.getBoolean(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE, false)) {
            s.T().C();
            s.T().B();
        }
        if (!com.baidu.navisdk.module.pronavi.model.i.f().b) {
            x.b().k(false);
            if (!x.b().D2()) {
                BNMapController.getInstance().recoveryHighLightRoute();
            }
        }
        x.b().B(true);
        x.b().u(0);
        if (!a0.I().D()) {
            x.b().L3();
        }
        x.b().T4();
        x.b().I().a(0);
    }
}

package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.g;
import com.baidu.navisdk.ui.routeguide.model.t;

/* loaded from: classes8.dex */
public class RGStateDynamicLayer extends RGStateBaseBrowseMap {
    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        x.b().a(this.exitParams);
        x.b().D(true);
        super.exit();
        BNMapController.getInstance().setRouteSearchStatus(false);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public boolean intercept(Bundle bundle) {
        return super.intercept(bundle);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        super.onActionMapStatus();
        BNMapController.getInstance().setRouteSearchStatus(true);
        Bundle bundle = this.enterParams;
        if (bundle != null && bundle.containsKey(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE)) {
            if (!this.enterParams.getBoolean(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE)) {
                x.b().c(this.enterParams);
            } else {
                x.b().b(this.enterParams);
            }
        } else {
            x.b().c(this.enterParams);
        }
        q.c().b();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        super.onActionUI();
        g.h().b(3);
        x.b().B(false);
        x.b().I().a(8);
        s.T().a(false, true, false);
        x.b().n4();
        x.b().K0();
        x.b().E(false);
        x.b().s3();
        x.b().N3();
        x.b().T4();
        x.b().b4();
        x.b().I().c(false);
        t.s().f();
        x.b().J0();
        if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState())) {
            x.b().P0();
        }
        x.b().y1();
    }
}

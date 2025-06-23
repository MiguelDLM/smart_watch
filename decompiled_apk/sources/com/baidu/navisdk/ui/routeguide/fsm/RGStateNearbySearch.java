package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.asr.c;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.r;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.g;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.ui.routeguide.utils.b;

/* loaded from: classes8.dex */
public class RGStateNearbySearch extends RGStateBaseBrowseMap {
    private static final String TAG = "RGStateNearbySearch";

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        super.exit();
        r.i().f();
        BNMapController.getInstance().setRouteSearchStatus(false);
        x.b().l(true);
        x.b().q1();
        x.b().B0();
        r.i().a();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public boolean intercept(Bundle bundle) {
        return super.intercept(bundle);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        super.onActionMapStatus();
        q.c().b();
        Bundle bundle = this.enterParams;
        if (bundle != null && bundle.containsKey(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE)) {
            if (!this.enterParams.getBoolean(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE)) {
                x.b().c4();
                return;
            }
            return;
        }
        x.b().c4();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        super.onActionUI();
        g.h().b(3);
        b.a(TAG);
        x.b().B(false);
        x.b().I().a(8);
        s.T().a(false, true, false);
        x.b().n4();
        x.b().B(2);
        x.b().K0();
        x.b().E(false);
        if (c.n().f()) {
            x.b().H0();
            Bundle bundle = this.enterParams;
            if (bundle != null && RGFSMTable.FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED.equals(bundle.getString(RGFSMTable.FsmParamsKey.RUN_EVENT))) {
                x.b().s3();
            }
        } else {
            x.b().s3();
            x.b().N3();
            x.b().T4();
            x.b().b4();
        }
        if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState())) {
            x.b().P0();
        }
        x.b().u(1);
        x.b().I().c(false);
        t.s().f();
    }
}

package com.baidu.navisdk.ui.routeguide.fsm;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.baidunavis.maplayer.e;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.module.offscreen.a;
import com.baidu.navisdk.ui.routeguide.control.indoorpark.c;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.ui.routeguide.model.s;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.statistic.userop.b;

/* loaded from: classes8.dex */
public class RGStateIndoorPark extends RGBaseState {
    private static final String TAG = "RGStateIndoorPark";

    private void resetEnlargeRoadMap() {
        i.s().a(false);
        x.b().P0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter(Bundle bundle) {
        super.enter(bundle);
        b.r().a("38.0.21.1470", null, null, null);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        super.exit();
        BNMapController.getInstance().setMap2DLook(false);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        super.onActionMapStatus();
        com.baidu.navisdk.ui.routeguide.b.V().l().l();
        com.baidu.navisdk.ui.routeguide.b.V().l().e(true);
        if (c.F().p()) {
            c.F().z();
        } else {
            c.F().h();
        }
        com.baidu.navisdk.ui.routeguide.control.b.k().a(true);
        e.k().b(true);
        BNMapController.getInstance().setEnlargedStatus(false);
        q.c().b();
        c.F().y();
        BNMapController.getInstance().setMap2DLook(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onActionUI");
        }
        if (RGFSMTable.FsmEvent.ENTRY_INDOOR_PARK.equals(this.enterParams.getString(RGFSMTable.FsmParamsKey.RUN_EVENT))) {
            if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.IndoorPark)) {
                if (gVar.d()) {
                    gVar.e(TAG, "onActionUI top state is indoor park");
                    return;
                }
                return;
            } else {
                com.baidu.navisdk.ui.routeguide.b.V().l().y();
                Activity b = com.baidu.navisdk.ui.routeguide.b.V().b();
                int d0 = x.b().d0();
                ScreenUtil.getInstance().setScreenOrientation(b, 1);
                if (d0 == 2) {
                    return;
                }
            }
        }
        resetEnlargeRoadMap();
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(8, false);
        if (!c.F().j()) {
            com.baidu.navisdk.ui.routeguide.b.V().R();
        }
        com.baidu.navisdk.ui.routeguide.model.c.a().b(false);
        s.a().a(false);
        x.b().G(false);
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
        x.b().z1();
        x.b().E(false);
        x.b().I().c(false);
        t.s().f();
        a0.I().i(false);
        if (a.g && a.h) {
            a.j = false;
            a.m().f();
        }
        com.baidu.navisdk.module.vmsr.c.f().c();
        x.b().J4();
        x.b().M(false);
        x.b().s3();
        if (c.F().j()) {
            x.b().N3();
        }
        c.F().e();
    }
}

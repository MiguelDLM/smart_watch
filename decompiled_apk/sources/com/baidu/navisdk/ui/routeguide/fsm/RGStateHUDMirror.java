package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.module.powersavemode.f;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class RGStateHUDMirror extends RGBaseState {
    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter(Bundle bundle) {
        x.b().m(true);
        super.enter(bundle);
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
    public void exit(Bundle bundle) {
        if (bundle != null && bundle.getString(RGFSMTable.FsmParamsKey.RUN_EVENT).equals(RGFSMTable.FsmEvent.MSG_MIRROR_GOTO_HUD)) {
            return;
        }
        BNRouteGuider.getInstance().setHUDEnabled(false);
        x.b().S0();
        f.o().j();
        super.exit();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        l.l().a();
        BNRouteGuider.getInstance().setHUDEnabled(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        x.b().H(true);
        f.o().l();
    }
}

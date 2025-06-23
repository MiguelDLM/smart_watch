package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.b;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;

/* loaded from: classes8.dex */
public abstract class RGStateBaseBrowseMap extends RGBaseState {
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
        super.exit();
        BNRouteGuider.getInstance().setBrowseStatus(false);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        b.k().a(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        BNRouteGuider.getInstance().setBrowseStatus(true);
        l.l().a();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        ProNaviStatItem.O().F();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (RGFSMTable.FsmState.SimpleGuide.equals(RouteGuideFSM.getInstance().getTopState()) && RGFSMTable.FsmEvent.TOUCH_MAP.equals(RouteGuideFSM.getInstance().getCurrentEvent()) && (com.baidu.navisdk.ui.routeguide.model.g.h().g == -1 || com.baidu.navisdk.ui.routeguide.model.g.h().g == 1)) {
            com.baidu.navisdk.ui.routeguide.model.g.h().g = 1;
        } else {
            com.baidu.navisdk.ui.routeguide.model.g.h().g = 0;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGStateBrowseMap", "enter() sAdjustLevel=" + com.baidu.navisdk.ui.routeguide.model.g.h().g);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void excute(Bundle bundle) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "excute by reflection , enterParams = " + bundle.toString());
        }
        super.excute(bundle);
    }
}

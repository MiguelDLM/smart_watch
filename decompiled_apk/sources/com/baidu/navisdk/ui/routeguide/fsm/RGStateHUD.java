package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b;
import com.baidu.navisdk.module.powersavemode.f;
import com.baidu.navisdk.module.pronavi.model.i;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class RGStateHUD extends RGBaseState {
    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter(Bundle bundle) {
        x.b().m(false);
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
        if (bundle != null && bundle.getString(RGFSMTable.FsmParamsKey.RUN_EVENT).equals(RGFSMTable.FsmEvent.MSG_HUD_GOTO_MIRROR)) {
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
        if (i.f().b) {
            i.f().b = false;
            BNMapController.getInstance().recoveryHighLightRoute();
        }
        x.b().H(false);
        f.o().l();
        b b = com.baidu.navisdk.ui.routeguide.utils.b.b(false);
        if (b != null) {
            b.a(0, "toHUD", true);
        }
    }
}

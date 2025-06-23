package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.ui.routeguide.control.b;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.l;

/* loaded from: classes8.dex */
public class RGStateHighway extends RGBaseState {
    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter() {
        x.b().U3();
        x.b().N3();
        x.b().n4();
        if (x.b().T()) {
            x.b().V3();
        }
        super.enter();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void excute(Bundle bundle) {
        super.excute(bundle);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        l.d(false);
        if (RouteGuideFSM.getInstance().getCurrentEvent() != null) {
            RouteGuideFSM.getInstance().getCurrentEvent().equals(RGFSMTable.FsmEvent.MSG_YAWING_START);
        }
        super.exit();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        b.k().a(true);
        q.c().b();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        x.b().s3();
        x.b().P0();
        x.b().H0();
        x.b().K3();
        x.b().v(0);
        x.b().G4();
        x.b().d((Bundle) null);
        x.b().n4();
        x.b().U3();
        x.b().N3();
        x.b().u(0);
        x.b().L3();
        if (x.b().T()) {
            x.b().V3();
        }
    }
}

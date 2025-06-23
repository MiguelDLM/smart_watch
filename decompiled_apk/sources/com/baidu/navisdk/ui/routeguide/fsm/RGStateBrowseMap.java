package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.module.viewbound.a;
import com.baidu.navisdk.ui.routeguide.asr.c;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.q;
import com.baidu.navisdk.util.common.g;
import com.baidu.nplatform.comapi.basestruct.b;
import com.baidu.nplatform.comapi.map.j;

/* loaded from: classes8.dex */
public class RGStateBrowseMap extends RGStateBaseBrowseMap {
    private static final String TAG = "RGStateBrowseMap";

    private boolean noNeedEnter() {
        if (!RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
            return false;
        }
        Bundle bundle = this.enterParams;
        if (bundle != null && (bundle.containsKey(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE) || this.enterParams.getString(RGFSMTable.FsmParamsKey.RUN_EVENT, "").equals(RGFSMTable.FsmEvent.VOICE_STATE_EXIT))) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        Bundle bundle = this.enterParams;
        if (bundle != null && bundle.getBoolean(RGFSMTable.FsmParamsKey.IS_AR_NAVI, false)) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "onActionMapStatus: is ar navi");
                return;
            }
            return;
        }
        super.exit();
        x.b().S(false);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
        super.onActionLayers();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        Bundle bundle = this.enterParams;
        if (bundle != null && bundle.getBoolean(RGFSMTable.FsmParamsKey.IS_AR_NAVI, false)) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "onActionMapStatus: is ar navi");
                return;
            }
            return;
        }
        super.onActionMapStatus();
        Bundle bundle2 = this.enterParams;
        if (bundle2 != null && bundle2.getBoolean(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE)) {
            b mapStatus = BNMapController.getInstance().getMapStatus();
            if (BNCommSettingManager.getInstance().getMapMode() == 1) {
                RGStateCar3D.setXYOffset(mapStatus);
            } else {
                RGStateNorth2D.setXYOffset(mapStatus, false);
            }
            BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationNone, 0, true);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        Bundle bundle = this.enterParams;
        if (bundle != null && bundle.getBoolean(RGFSMTable.FsmParamsKey.IS_AR_NAVI, false)) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "onActionMapStatus: is ar navi");
                return;
            }
            return;
        }
        super.onActionNaviEngine();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        super.onActionUI();
        if (noNeedEnter()) {
            x.b().a(0L);
            return;
        }
        a.e().a();
        com.baidu.navisdk.ui.routeguide.model.g.h().b(3);
        x.b().B(false);
        Bundle bundle = this.enterParams;
        if (bundle != null && bundle.containsKey(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE)) {
            if (!this.enterParams.getBoolean(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE)) {
                s.T().u();
                s.T().w();
            }
        } else {
            s.T().u();
            s.T().w();
        }
        x.b().n4();
        x.b().B(2);
        x.b().K0();
        if (c.n().f()) {
            x.b().H0();
            x.b().a(0L);
            Bundle bundle2 = this.enterParams;
            if (bundle2 != null && RGFSMTable.FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED.equals(bundle2.getString(RGFSMTable.FsmParamsKey.RUN_EVENT))) {
                x.b().s3();
            }
        } else {
            x.b().s3();
            x.b().N3();
            x.b().T4();
            x.b().v(2);
            x.b().C(!com.baidu.navisdk.poisearch.model.a.k().h());
        }
        if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState())) {
            x.b().P0();
        }
        x.b().E(false);
        q.d().a();
        s.T().e(112);
        s.T().e(115);
        if (!s.T().y()) {
            s.T().a(false, true, true);
        }
        x.b().u(1);
        x.b().S(true);
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().b().f();
        }
        x.b().I().c(false);
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.G();
        }
    }
}

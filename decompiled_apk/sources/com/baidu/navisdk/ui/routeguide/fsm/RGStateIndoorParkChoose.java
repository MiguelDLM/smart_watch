package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.control.b;
import com.baidu.navisdk.ui.routeguide.control.indoorpark.c;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.nplatform.comapi.map.j;

/* loaded from: classes8.dex */
public class RGStateIndoorParkChoose extends RGStateBaseBrowseMap {
    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGBaseState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        b.k().a(false);
        com.baidu.nplatform.comapi.basestruct.b c = b.k().c();
        c.c = 0;
        c.f9474a = -1.0f;
        BNMapController.getInstance().setMapStatus(c, j.b.eAnimationNone);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        super.onActionUI();
        if (c.F().j()) {
            x.b().a(0L);
        }
        c.F().d();
    }
}

package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.ui.routeguide.control.indoorpark.c;
import com.baidu.navisdk.ui.routeguide.control.x;

/* loaded from: classes8.dex */
public class RGStateIndoorParkBrowseMap extends RGStateBaseBrowseMap {
    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGStateBaseBrowseMap, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        super.onActionUI();
        if (c.F().j()) {
            x.b().a(0L);
        }
        c.F().d();
    }
}

package com.baidu.navisdk.pronavi.newenergy;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.module.pronavi.model.f;
import com.baidu.navisdk.pronavi.base.logic.RGBaseLogicFrame;
import com.baidu.navisdk.pronavi.ui.base.b;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;

/* loaded from: classes7.dex */
public class a extends b {
    public a(@NonNull Activity activity, @NonNull com.baidu.navisdk.framework.data.a aVar, f fVar, com.baidu.navisdk.ui.routeguide.subview.a aVar2, com.baidu.navisdk.pageframe.store.i.b bVar, ViewGroup viewGroup, RGBaseLogicFrame rGBaseLogicFrame) {
        super(activity, aVar, fVar, aVar2, bVar, viewGroup, rGBaseLogicFrame);
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.b
    public boolean I() {
        h a2;
        if (!RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getCurrentState()) || (a2 = j().e("RGChargeStationListComponent").a(4003).a()) == null || !a2.b("resultA")) {
            return false;
        }
        return true;
    }
}

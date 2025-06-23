package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* loaded from: classes7.dex */
public class t extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    public t(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_operate_state_travel_share_btn, "分享位置");
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        super.a(view);
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.3");
        if (com.baidu.navisdk.ui.util.g.a() || com.baidu.navisdk.module.international.a.a(this.f7853a.a())) {
            return;
        }
        com.baidu.navisdk.module.a.h().a(com.baidu.navisdk.ui.routeguide.b.V().b(), 0, true);
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_route_share"));
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (!com.baidu.navisdk.function.b.FUNC_TRAVEL_SHARE.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("TravelShareBtn", "visibility: isEnable not");
            }
            return 8;
        }
        if (com.baidu.navisdk.module.international.a.b() || com.baidu.navisdk.framework.b.O()) {
            return 8;
        }
        if (f()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("TravelShareBtn", "visibility:isHideControlPanelBtn ");
            }
            return 8;
        }
        if (this.f7853a.N()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("TravelShareBtn", "visibility: isRoused");
            }
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean h() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }
}

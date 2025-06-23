package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* loaded from: classes7.dex */
public class l extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    public l(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_common_ic_offline_to_online, "转在线");
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        super.a(view);
        if (view != null && view.isEnabled()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("OffToOnLineBtn", "onClicked: ");
            }
            com.baidu.navisdk.ui.routeguide.subview.a w = this.f7853a.w();
            if (w != null) {
                w.l();
            }
            if (BNCommSettingManager.getInstance().getPrefRoutPlanMode() == 2) {
                BNCommSettingManager.getInstance().setRPNetMode(false);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.3", null, "1", null);
            com.baidu.navisdk.ui.routeguide.control.x.b().a(0L);
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("OffToOnLineBtn", "onClicked: view not isEnabled");
        }
    }

    public void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("OffToOnLineBtn", "setEnable: " + z);
        }
        View view = getView();
        if (view != null) {
            view.setEnabled(z);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (f()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("OffToOnLineBtn", "visibility: isHideControlPanelBtn");
            }
            return 8;
        }
        if (this.f7853a.N()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("OffToOnLineBtn", "visibility: isRoused");
            }
            return 8;
        }
        if (!BNSettingManager.isRefreshButtonVisible()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("OffToOnLineBtn", "visibility: not isRefreshButtonVisible");
            }
            return 8;
        }
        if (!b(RGFSMTable.FsmState.BrowseMap)) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("OffToOnLineBtn", "visibility: not browsermap");
            }
            return 8;
        }
        if (BNRouteGuider.getInstance().isCurDriveRouteOnline()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("OffToOnLineBtn", "visibility: isCurDriveRouteOnline");
            }
            return 8;
        }
        if (!BNRoutePlaner.getInstance().B()) {
            return 8;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.3", "1", null, null);
        com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar6.d()) {
            gVar6.e("OffToOnLineBtn", "visibility: isOfflineRoutePlan");
        }
        b(!com.baidu.navisdk.ui.routeguide.control.s.T().k(110));
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void loadBucketItem(ViewGroup viewGroup, int i, Context context) {
        super.loadBucketItem(viewGroup, i, context);
        b(!com.baidu.navisdk.ui.routeguide.control.s.T().k(110));
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }
}

package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* loaded from: classes7.dex */
public class p extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    public p(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_common_ic_avoid_traffic_refresh, "刷新");
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        super.a(view);
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.l");
        if (com.baidu.navisdk.ui.routeguide.control.x.b().l2()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RefreshRoadBtn", "刷新路线 isInterceptRecalRouteForVdrGuide: ");
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.subview.a w = this.f7853a.w();
        if (w != null) {
            w.t();
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().d();
    }

    public void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RefreshRoadBtn", "setEnable: " + z);
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
                gVar.e("RefreshRoadBtn", "visibility: isHideControlPanelBtn");
            }
            return 8;
        }
        if (this.f7853a.N()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RefreshRoadBtn", "visibility: isRoused");
            }
            return 8;
        }
        if (!BNSettingManager.isRefreshButtonVisible()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RefreshRoadBtn", "visibility: not isRefreshButtonVisible");
            }
            return 8;
        }
        if (!com.baidu.navisdk.function.b.FUNC_REFRESH.a()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RefreshRoadBtn", "visibility: not isEnable");
            }
            return 8;
        }
        if (BNRoutePlaner.getInstance().B()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("RefreshRoadBtn", "visibility: isCurDriveRouteOnline");
            }
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().F()) {
            com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar6.d()) {
                gVar6.e("RefreshRoadBtn", "visibility: isTrajectoryRestoreGuide");
            }
            return 8;
        }
        if (b(RGFSMTable.FsmState.BrowseMap) && BNRouteGuider.getInstance().isCurDriveRouteOnline() && com.baidu.navisdk.util.common.z.b(this.f7853a.a()) && com.baidu.navisdk.module.pronavi.model.i.f().c() && JNIGuidanceControl.getInstance().getViaCnt() == 0) {
            com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar7.d()) {
                gVar7.e("RefreshRoadBtn", "visibility: visible");
                return 0;
            }
            return 0;
        }
        com.baidu.navisdk.util.common.g gVar8 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar8.d()) {
            gVar8.e("RefreshRoadBtn", "visibility gone");
        }
        return 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void loadBucketItem(ViewGroup viewGroup, int i, Context context) {
        super.loadBucketItem(viewGroup, i, context);
        t();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public String[] w() {
        return new String[]{"Refresh"};
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(com.baidu.navisdk.pronavi.style.i.a aVar) {
        a(aVar, "RGAllStyleResId");
    }
}

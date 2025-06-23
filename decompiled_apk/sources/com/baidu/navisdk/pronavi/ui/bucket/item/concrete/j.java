package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* loaded from: classes7.dex */
public class j extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    private boolean k;

    public j(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.bn_ic_rg_setting, R.string.nsdk_string_rg_alert_setting);
        this.k = true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        super.a(view);
        if (com.baidu.navisdk.ui.util.g.a()) {
            return;
        }
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("NaviSettingBtn", "onClicked: not hasCalcRouteOk");
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().y(1);
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.7", "1");
    }

    public void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviSettingBtn", "updateBtnState: " + z);
        }
        this.k = z;
        refreshVisible();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("NaviSettingBtn", "visibility: not hasCalcRouteOk");
            }
            return 8;
        }
        if (this.f7853a.N()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("NaviSettingBtn", "visibility: isShowXDPanel");
            }
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("NaviSettingBtn", "visibility: isYawing");
            }
            return 8;
        }
        if ((this.f7853a.A() || this.f7853a.D()) && !b(RGFSMTable.FsmState.BrowseMap)) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("NaviSettingBtn", "visibility: isHDNavi && not browseMap:" + b());
            }
            return 8;
        }
        if (!BNSettingManager.isSettingButtonVisible()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("NaviSettingBtn", "visibility: not isSettingButtonVisible");
            }
            return 8;
        }
        com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar6.d()) {
            gVar6.e("NaviSettingBtn", "visibility:" + i + "," + this.k + "," + b());
        }
        if (!this.k && !b(RGFSMTable.FsmState.BrowseMap)) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void loadBucketItem(ViewGroup viewGroup, int i, Context context) {
        super.loadBucketItem(viewGroup, i, context);
        t();
        getView().setTag("bucket_setting_btn");
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public String[] w() {
        return new String[]{"Setting"};
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(com.baidu.navisdk.pronavi.style.i.a aVar) {
        a(aVar, "RGAllStyleResId");
    }
}

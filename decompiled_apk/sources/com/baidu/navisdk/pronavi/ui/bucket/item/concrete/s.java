package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.util.TipTool;

/* loaded from: classes7.dex */
public class s extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    public s(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_common_btn_traffic_on, R.string.nsdk_string_its_name);
    }

    private void b(boolean z) {
        int i;
        RGImageTextBtn v = v();
        if (v != null) {
            if (z) {
                i = R.drawable.nsdk_drawable_common_btn_traffic_on;
            } else {
                i = R.drawable.nsdk_drawable_common_btn_traffic_off;
            }
            v.setIcon(i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        super.a(view);
        if (com.baidu.navisdk.ui.util.g.a() || com.baidu.navisdk.module.international.a.a(com.baidu.navisdk.framework.a.c().a())) {
            return;
        }
        if (com.baidu.navisdk.module.pronavi.model.i.f().b) {
            com.baidu.navisdk.module.pronavi.model.i.f().b = false;
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().k(true);
            BNMapController.getInstance().recoveryHighLightRoute();
        }
        if (BNCommSettingManager.getInstance().isRoadCondOnOrOff()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.2", null, "", "1");
            com.baidu.navisdk.ui.routeguide.subview.a w = this.f7853a.w();
            if (w != null) {
                w.c(false);
            }
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.2", "", null, "1");
            if (com.baidu.navisdk.util.common.z.b(com.baidu.navisdk.framework.a.c().a())) {
                com.baidu.navisdk.ui.routeguide.subview.a w2 = this.f7853a.w();
                if (w2 != null) {
                    w2.c(true);
                }
            } else {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_its_real_offline));
            }
        }
        b(BNCommSettingManager.getInstance().isRoadCondOnOrOff());
        com.baidu.navisdk.ui.routeguide.control.x.b().a(0L);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (!BNSettingManager.isRoadConditionButtonVisible() || f() || this.f7853a.N() || !b(RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.NearbySearch)) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean g() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void loadBucketItem(ViewGroup viewGroup, int i, Context context) {
        super.loadBucketItem(viewGroup, i, context);
        b(BNCommSettingManager.getInstance().isRoadCondOnOrOff());
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("TrafficBtn", "onVisibleChange: " + i);
        }
        if (i == 0) {
            b(BNCommSettingManager.getInstance().isRoadCondOnOrOff());
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.ArriveDest};
    }
}

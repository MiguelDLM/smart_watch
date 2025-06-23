package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.ar;

import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.util.g;

/* loaded from: classes7.dex */
public class d extends a {
    public d(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.bnav_ic_to_portrait_navi, R.string.bnav_switch_portrait_navi);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        int i;
        super.a(view);
        if (g.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ARToNormalNaviBtn", "onClicked: isFastDoubleClick");
                return;
            }
            return;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a a2 = com.baidu.navisdk.ui.routeguide.utils.b.a();
        if (a2 != null) {
            if (this.f7853a.E()) {
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.10.1.2", "1");
                i = 2;
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.10.1.2", "0");
                i = 1;
            }
            a2.c(i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.ar.a, com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (this.f7853a.z() && b(RGFSMTable.FsmState.BrowseMap) && !com.baidu.navisdk.module.abtest.model.a.v()) {
            return 0;
        }
        return 8;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        if (i == 0) {
            y();
        }
    }

    public void y() {
        if (this.f7853a.E()) {
            a(R.drawable.bnav_ic_to_land_navi, R.string.bnav_switch_land_navi);
        } else {
            a(R.drawable.bnav_ic_to_portrait_navi, R.string.bnav_switch_portrait_navi);
        }
    }
}

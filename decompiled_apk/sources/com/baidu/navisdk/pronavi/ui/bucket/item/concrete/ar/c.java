package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.ar;

import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.g;

/* loaded from: classes7.dex */
public class c extends a {
    public c(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.bnav_ic_ar_full, R.string.nsdk_string_show_full_screen);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        super.a(view);
        if (g.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ARSwitchMultiFullBtn", "onClicked: isFastDoubleClick");
                return;
            }
            return;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a a2 = com.baidu.navisdk.ui.routeguide.utils.b.a();
        if (a2 != null) {
            int j = a2.j();
            int i = 2;
            if (j == 3) {
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.10.1.3", "1");
            } else if (j == 2) {
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.10.1.3", "0");
                i = 3;
            } else {
                i = -1;
            }
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("ARSwitchMultiFullBtn", "onClicked: " + j + "->" + i);
            }
            if (i != -1) {
                a2.a(i);
            }
            y();
        }
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        if (i == 0) {
            y();
        }
    }

    public void y() {
        if (this.f7853a.l() == 2) {
            a(R.drawable.bnav_ic_ar_full, R.string.nsdk_string_show_full_screen);
        } else {
            a(R.drawable.bnav_ic_ar_multi, R.string.nsdk_string_show_split_screen);
        }
    }
}

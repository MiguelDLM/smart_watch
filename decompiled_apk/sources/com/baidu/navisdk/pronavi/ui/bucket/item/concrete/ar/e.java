package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.ar;

import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.g;

/* loaded from: classes7.dex */
public class e extends a {
    public e(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.bnav_ic_to_normal_navi, R.string.bnav_to_normal_navi);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
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
            a2.l();
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.10.1.1");
        }
    }
}

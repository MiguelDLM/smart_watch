package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.hd;

import android.view.View;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.pronavi.ui.bucket.item.c;
import com.baidu.navisdk.ui.util.g;

/* loaded from: classes7.dex */
public class b extends c {
    public b(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar) {
        super(bVar, dVar, R.drawable.bnav_ic_hd_multi, R.string.nsdk_string_split_screen, R.drawable.bnav_ic_ar_btn_bg, R.color.bnav_hd_navi_btn_txt_color);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        super.a(view);
        if (g.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("HdDoubleMapBtn", "onClicked: isFastDoubleClick");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.v.d", "0");
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b = com.baidu.navisdk.ui.routeguide.utils.b.b(false);
        if (b != null) {
            b.a(2);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hd_half"));
            BNSettingManager.setHdScreenMode(1);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (this.f7853a.B()) {
            return 0;
        }
        return 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean o() {
        return true;
    }
}

package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.ar;

import android.view.View;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class b extends a {
    public b(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.bnav_ic_ar_close, R.string.nsdk_quit_navi);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        super.a(view);
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a a2 = com.baidu.navisdk.ui.routeguide.utils.b.a();
        if (a2 != null) {
            a2.a(this.f7853a.w());
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.10.1.4");
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.ar.a, com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (this.f7853a.z()) {
            return 0;
        }
        return 8;
    }
}

package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.ar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    public a(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar, int i, int i2) {
        super(bVar, dVar, i, i2);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c, com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        return RGImageTextBtn.b.a(context, this.f, this.g, i, R.drawable.bnav_ic_ar_btn_bg, R.color.bnav_ar_navi_btn_txt_color);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (this.f7853a.z() && b(RGFSMTable.FsmState.BrowseMap)) {
            return 0;
        }
        return 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean n() {
        return true;
    }
}

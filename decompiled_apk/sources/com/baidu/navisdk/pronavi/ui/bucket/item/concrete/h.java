package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.view.View;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class h extends com.baidu.navisdk.pronavi.ui.bucket.item.b {

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.ui.routeguide.subview.a w = ((com.baidu.navisdk.pronavi.ui.bucket.item.a) h.this).f7853a.w();
            if (w != null) {
                w.m();
            }
        }
    }

    public h(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_rg_ic_quit);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (this.f7853a.C()) {
            return 0;
        }
        return 8;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public View.OnClickListener getOnClickListener() {
        return new a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean o() {
        return true;
    }
}

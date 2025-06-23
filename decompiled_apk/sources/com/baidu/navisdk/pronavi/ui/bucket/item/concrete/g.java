package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.view.View;
import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class g extends com.baidu.navisdk.pronavi.ui.bucket.item.b {

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.ui.routeguide.subview.a w = ((com.baidu.navisdk.pronavi.ui.bucket.item.a) g.this).f7853a.w();
            if (w != null) {
                w.d(com.baidu.navisdk.ui.routeguide.model.g.h().d());
            }
        }
    }

    public g(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_anolog_play);
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

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0) {
            y();
        }
    }

    public void y() {
        if (!com.baidu.navisdk.ui.routeguide.model.g.h().d()) {
            f(R.drawable.nsdk_drawable_anolog_play);
        } else {
            f(R.drawable.nsdk_drawable_anolog_pause);
        }
    }
}

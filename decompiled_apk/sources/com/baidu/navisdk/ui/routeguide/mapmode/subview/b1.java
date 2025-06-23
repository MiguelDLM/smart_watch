package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class b1 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private View i;

    public b1(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        n0();
    }

    private void n0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        this.i = viewGroup.findViewById(R.id.bnav_rg_top_base_background);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        n0();
        y();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        int d;
        if (!com.baidu.navisdk.ui.routeguide.b.V().E()) {
            View view = this.i;
            if (view != null) {
                view.setVisibility(8);
            }
            return false;
        }
        View view2 = this.i;
        if (view2 != null) {
            view2.setVisibility(0);
            if (this.f == 2) {
                if (Build.VERSION.SDK_INT >= 28 && a.c().b()) {
                    d = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_185dp) + ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
                } else {
                    d = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_185dp);
                }
                this.i.setLayoutParams(new FrameLayout.LayoutParams(d, -1));
                com.baidu.navisdk.ui.util.b.a(this.i, R.drawable.bnav_rg_guide_top_panel_base_backgroud_land);
            } else {
                com.baidu.navisdk.ui.util.b.a(this.i, R.drawable.bnav_rg_guide_top_panel_base_backgroud);
            }
        }
        return super.y();
    }
}

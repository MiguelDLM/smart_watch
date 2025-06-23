package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class v0 extends g implements View.OnClickListener {
    private View e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private Button j;
    private final com.baidu.navisdk.module.pronavi.model.d k;

    public v0(com.baidu.navisdk.module.pronavi.model.d dVar) {
        this.f8808a = 1004;
        this.k = dVar;
        s();
    }

    private void r() {
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().b().d();
        }
    }

    private void s() {
        View a2 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().b(), R.layout.nsdk_layout_dest_reminder_dest_arrive_card);
        this.e = a2;
        if (a2 != null) {
            a2.setOnClickListener(this);
            this.f = (ImageView) this.e.findViewById(R.id.iv_icon);
            this.g = (TextView) this.e.findViewById(R.id.tv_main_title);
            this.h = (TextView) this.e.findViewById(R.id.tv_sub_title);
            this.i = (TextView) this.e.findViewById(R.id.tv_arrive_label);
            Button button = (Button) this.e.findViewById(R.id.nsdk_finish_navi_btn);
            this.j = button;
            button.setOnClickListener(this);
        }
    }

    private void t() {
        if (this.e != null) {
            if (this.k.p() != 3 && this.k.p() != 5) {
                this.g.setText(this.k.h());
            } else {
                this.g.setText("出口  " + this.k.d());
            }
            String d = com.baidu.navisdk.ui.routeguide.model.a0.I().d();
            if (!com.baidu.navisdk.util.common.l0.c(d)) {
                this.h.setText(d);
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
            this.j.setText("我知道了");
            this.i.setText("即将到达");
            if (this.k.p() != 4 && this.k.p() != 7) {
                if (this.k.p() != 3 && this.k.p() != 5) {
                    if (this.k.p() == 1) {
                        this.f.setImageResource(R.drawable.nsdk_drawable_arrive_remind_toll_station);
                        return;
                    }
                    return;
                }
                this.f.setImageResource(R.drawable.nsdk_drawable_arrive_remind_exit);
                return;
            }
            this.f.setImageResource(R.drawable.nsdk_drawable_arrive_remind_service_area);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        } else {
            layoutParams.setMargins(com.baidu.navisdk.ui.routeguide.control.x.b().V(), dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        return layoutParams;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public View e() {
        return this.e;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void h() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
        super.j();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMServiceAreaArriveCard", "onHide!");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMServiceAreaArriveCard", "onShow! mRootView = " + this.e);
        }
        super.k();
        t();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public void n() {
        super.n();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMServiceAreaArriveCard", "onAutoHideCard!");
        }
        r();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.nsdk_finish_navi_btn) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMServiceAreaArriveCard", "DestRemind clickConfirmBtn ->");
            }
            r();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public boolean q() {
        return true;
    }
}

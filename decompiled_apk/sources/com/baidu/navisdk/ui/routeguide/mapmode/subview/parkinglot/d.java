package com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.f;
import com.baidu.navisdk.ui.routeguide.control.i;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g;
import com.baidu.navisdk.ui.routeguide.model.o;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class d extends g implements View.OnClickListener {
    private View e;
    private TextView f;
    private TextView g;
    private RelativeLayout h;
    private ImageView i;
    private Button j;
    private Button k;
    private o l;
    private String m;
    private View n;

    public d(String str, o oVar) {
        this.f8808a = 1007;
        this.l = oVar;
        this.m = str;
        r();
    }

    private void a(TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (l0.c(textView.getText().toString())) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
    }

    private void r() {
        View a2 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().b(), R.layout.nsdk_layout_dest_reminder_dest_arrive_card);
        this.e = a2;
        if (a2 != null) {
            this.h = (RelativeLayout) a2.findViewById(R.id.dest_street_image_layout);
            this.i = (ImageView) this.e.findViewById(R.id.iv_icon);
            this.f = (TextView) this.e.findViewById(R.id.tv_main_title);
            this.g = (TextView) this.e.findViewById(R.id.tv_sub_title);
            this.j = (Button) this.e.findViewById(R.id.nsdk_nearby_park_btn);
            this.k = (Button) this.e.findViewById(R.id.nsdk_finish_navi_btn);
            this.n = this.e.findViewById(R.id.tv_arrive_label);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.j.setVisibility(0);
            this.j.setText("结束导航");
            this.k.setText("更多车位");
            this.i.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_ic_dest_arrive_reminder));
            this.i.setVisibility(0);
            this.n.setVisibility(8);
        }
    }

    private void s() {
        String oVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("refreshData -> mStall = ");
            o oVar2 = this.l;
            if (oVar2 == null) {
                oVar = "null";
            } else {
                oVar = oVar2.toString();
            }
            sb.append(oVar);
            sb.append(", mRootView = ");
            sb.append(this.e);
            gVar.e("RGMoreIndoorCarStallCard", sb.toString());
        }
        if (this.e != null && this.l != null) {
            this.h.setVisibility(8);
            this.f.setText(this.m);
            this.g.setText(this.l.d());
            a(new TextView[0]);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (!x.b().s2()) {
            layoutParams.width = f.k().b();
        }
        layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
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
            gVar.e("RGMoreIndoorCarStallCard", "onHide!");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMoreIndoorCarStallCard", "onShow! isBackgroundNavi = " + com.baidu.navisdk.ui.routeguide.b.V().z() + ", mRootView = " + this.e);
        }
        if (this.e == null) {
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            return;
        }
        super.k();
        f.k().a(true);
        s();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7", "1", null, null);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public void n() {
        super.n();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMoreIndoorCarStallCard", "onAutoHideCard!");
        }
        com.baidu.navisdk.ui.routeguide.b.V().Q();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.2", null, null, "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p();
        if (view.getId() == R.id.nsdk_finish_navi_btn) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMoreIndoorCarStallCard", "clickLeftBtn ->");
            }
            i.g().f();
            com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().b(false);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7", null, "1", null);
            return;
        }
        if (view.getId() == R.id.nsdk_nearby_park_btn) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGMoreIndoorCarStallCard", "clickRightBtn ->");
            }
            com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().a(true);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7", null, "2", null);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public boolean q() {
        return true;
    }
}

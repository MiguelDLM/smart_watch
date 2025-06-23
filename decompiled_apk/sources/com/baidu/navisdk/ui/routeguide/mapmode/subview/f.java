package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class f extends g implements View.OnClickListener {
    private View e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private RelativeLayout j;
    private ImageView k;
    private Button l;
    private Button m;
    private boolean n;
    private RoutePlanNode o;

    public f(boolean z, RoutePlanNode routePlanNode) {
        this.f8808a = 1002;
        this.n = z;
        this.o = routePlanNode;
        s();
    }

    private void a(TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (com.baidu.navisdk.util.common.l0.c(textView.getText().toString())) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
    }

    private com.baidu.navisdk.ui.routeguide.control.g r() {
        if (com.baidu.navisdk.ui.routeguide.b.V().j() == null) {
            return null;
        }
        return com.baidu.navisdk.ui.routeguide.b.V().j().b();
    }

    private void s() {
        int i;
        View a2 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.routeguide.b.V().b(), R.layout.nsdk_layout_dest_reminder_dest_arrive_card);
        this.e = a2;
        if (a2 != null) {
            this.f = (ImageView) a2.findViewById(R.id.iv_icon);
            this.j = (RelativeLayout) this.e.findViewById(R.id.dest_street_image_layout);
            this.k = (ImageView) this.e.findViewById(R.id.iv_dest_street_image);
            this.g = (TextView) this.e.findViewById(R.id.tv_main_title);
            this.h = (TextView) this.e.findViewById(R.id.tv_sub_title);
            this.i = (TextView) this.e.findViewById(R.id.tv_arrive_label);
            this.l = (Button) this.e.findViewById(R.id.nsdk_nearby_park_btn);
            this.m = (Button) this.e.findViewById(R.id.nsdk_finish_navi_btn);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            Button button = this.l;
            if (this.n) {
                i = 0;
            } else {
                i = 8;
            }
            button.setVisibility(i);
        }
    }

    private void t() {
        String routePlanNode;
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("refreshData -> mRoutePlanNode = ");
            RoutePlanNode routePlanNode2 = this.o;
            if (routePlanNode2 == null) {
                routePlanNode = "null";
            } else {
                routePlanNode = routePlanNode2.toString();
            }
            sb.append(routePlanNode);
            sb.append(", mRootView = ");
            sb.append(this.e);
            LogUtil.e("RGMMArriveDestRemindCard - DestRemind", sb.toString());
        }
        if (this.o == null || this.e == null) {
            return;
        }
        if (r() != null && r().a().e() != null) {
            this.k.setImageDrawable(new BitmapDrawable(r().a().e()));
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        String name = this.o.getName();
        if (com.baidu.navisdk.util.common.l0.c(name)) {
            name = JarUtils.getResources().getString(R.string.nsdk_string_rg_arrive_default_poi_name);
        }
        this.g.setText(name);
        this.h.setText(this.o.getDescription());
        a(this.h);
        this.f.setImageResource(R.drawable.nsdk_ic_dest_arrive_reminder);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public RelativeLayout.LayoutParams d() {
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (!com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            layoutParams.width = com.baidu.navisdk.ui.routeguide.control.f.k().b();
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
        com.baidu.navisdk.ui.util.j.b(this.k);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
        super.j();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMArriveDestRemindCard - DestRemind", "onHide!");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g, com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMArriveDestRemindCard - DestRemind", "onShow! isBackgroundNavi = " + com.baidu.navisdk.ui.routeguide.b.V().z() + ", mRootView = " + this.e);
        }
        if (this.e == null) {
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            return;
        }
        super.k();
        com.baidu.navisdk.ui.routeguide.control.f.k().a(true);
        t();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public void n() {
        super.n();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMArriveDestRemindCard - DestRemind", "onAutoHideCard!");
        }
        com.baidu.navisdk.ui.routeguide.b.V().Q();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.2", null, null, "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p();
        if (view.getId() == R.id.nsdk_finish_navi_btn) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMArriveDestRemindCard - DestRemind", "DestRemind clickFinishNaviBtn ->");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.2", null, "1", null);
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            return;
        }
        if (view.getId() == R.id.nsdk_nearby_park_btn) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMArriveDestRemindCard - DestRemind", "DestRemind clickNearbyParkBtn ->");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.2", null, "2", null);
            com.baidu.navisdk.ui.routeguide.control.i.g().f();
            com.baidu.navisdk.ui.routeguide.control.f.k().h();
            return;
        }
        view.getId();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g
    public boolean q() {
        return true;
    }
}

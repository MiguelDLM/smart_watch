package com.baidu.navisdk.module.newguide.subviews.guides;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.f1;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class f extends com.baidu.navisdk.module.newguide.subviews.guides.a {
    private View i;
    private RelativeLayout j;
    private RelativeLayout k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private TextView t;
    private ImageView u;
    private Animation v;
    private boolean w;
    private f1 x;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a(f fVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMDefaultModeGuideNewView", "onClick: mTurnIcon");
            }
        }
    }

    public f(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = false;
        B0();
        u0();
    }

    private void A(boolean z) {
        int i = 0;
        if (this.w) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        TextView textView = this.r;
        if (textView != null && textView.getVisibility() != i) {
            this.r.setVisibility(i);
        }
        TextView textView2 = this.s;
        if (textView2 != null && this.t != null && textView2.getVisibility() != i) {
            this.s.setVisibility(i);
            this.t.setVisibility(i);
        }
    }

    private boolean A0() {
        f1 f1Var = this.x;
        if (f1Var != null && f1Var.b()) {
            return true;
        }
        return false;
    }

    private void B(boolean z) {
        int i = 0;
        if (this.w) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        TextView textView = this.m;
        if (textView != null && textView.getVisibility() != i) {
            this.m.setVisibility(i);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMDefaultModeGuideNewView", "justSetNormalSGInfoVisible mAfterMetersInfoTV - " + z);
            }
        }
        TextView textView2 = this.n;
        if (textView2 != null && textView2.getVisibility() != i) {
            this.n.setVisibility(i);
        }
        TextView textView3 = this.o;
        if (textView3 != null && textView3.getVisibility() != i) {
            this.o.setVisibility(i);
        }
        TextView textView4 = this.p;
        if (textView4 != null && textView4.getVisibility() != i) {
            this.p.setVisibility(i);
        }
        ImageView imageView = this.l;
        if (imageView != null && imageView.getVisibility() != i) {
            this.l.setVisibility(i);
        }
    }

    private void B0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeGuideNewView", "initViews - orientation = " + this.f);
        }
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            if (gVar.d()) {
                gVar.e("RGMMDefaultModeGuideNewView", "initViews null == mRootViewGroup");
                return;
            }
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.nsdk_layout_rg_mapmode_main_sub_simple_guide_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        View findViewById = this.b.findViewById(R.id.bnav_rg_new_simpleguide_open);
        this.i = findViewById;
        this.j = (RelativeLayout) findViewById.findViewById(R.id.nav_guide_info_layout);
        this.q = (LinearLayout) this.i.findViewById(R.id.bnav_rg_sg_info_text_layout);
        this.k = (RelativeLayout) this.i.findViewById(R.id.bnav_rg_simpleguide_inner_progress);
        this.l = (ImageView) this.i.findViewById(R.id.bnav_rg_sg_turn_icon);
        this.m = (TextView) this.i.findViewById(R.id.bnav_rg_sg_after_meters_info);
        this.n = (TextView) this.i.findViewById(R.id.bnav_rg_sg_after_label_info);
        this.o = (TextView) this.i.findViewById(R.id.bnav_rg_sg_link_info);
        this.p = (TextView) this.i.findViewById(R.id.bnav_rg_sg_go_where_info);
        this.r = (TextView) this.i.findViewById(R.id.bnav_rg_sg_location_info);
        this.s = (TextView) this.i.findViewById(R.id.bnav_rg_sg_satellite_info);
        this.t = (TextView) this.i.findViewById(R.id.bnav_rg_sg_satellite_info_other);
        this.u = (ImageView) this.i.findViewById(R.id.progress_cycle);
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
        }
        D0();
    }

    private void C(boolean z) {
        RelativeLayout relativeLayout;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VdrModeGuide", "default guide view setVdrLowPrecisionGuideVisibility: " + z);
        }
        f1 f1Var = this.x;
        if (f1Var != null) {
            f1Var.a(z);
        }
        if (!z && (relativeLayout = this.j) != null && relativeLayout.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
    }

    private void C0() {
        RelativeLayout relativeLayout;
        if (this.x == null) {
            this.x = new f1();
        }
        boolean a2 = this.x.a((ViewGroup) this.i, R.id.bnav_rg_vdr_low_precision_guide_layout);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeGuideNewView", "default guide view intoVdrLowPrecisionGuideView: " + a2);
        }
        if (a2 && (relativeLayout = this.j) != null && relativeLayout.getVisibility() != 8) {
            this.j.setVisibility(8);
        }
    }

    private void D0() {
        if (this.i != null) {
            com.baidu.navisdk.module.newguide.a.e().a(this.i);
        }
    }

    private void E0() {
        RelativeLayout relativeLayout;
        C(false);
        B(false);
        TextView textView = this.s;
        if (textView != null && this.t != null) {
            textView.setVisibility(8);
            this.t.setVisibility(8);
        }
        if (this.r != null && (relativeLayout = this.k) != null) {
            relativeLayout.setVisibility(0);
            this.r.setVisibility(0);
            this.r.setText("当前行驶在\n\t无数据道路上");
        }
    }

    private void F0() {
        A(false);
        B(true);
        C(false);
    }

    private void G0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VdrModeGuide", "default guide view showVdrLowPrecisionInfoView");
        }
        A(false);
        B(false);
        C(true);
    }

    private void H0() {
        RelativeLayout relativeLayout;
        Object valueOf;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("showWaitCalRouteFinish-> mSimpleGuideView= ");
            View view = this.i;
            if (view == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(view.getVisibility());
            }
            sb.append(valueOf);
            gVar.e("RGMMDefaultModeGuideNewView", sb.toString());
        }
        B(false);
        C(false);
        TextView textView = this.s;
        if (textView != null && this.t != null) {
            textView.setVisibility(8);
            this.t.setVisibility(8);
        }
        if (this.r != null && (relativeLayout = this.k) != null) {
            relativeLayout.setVisibility(0);
            this.r.setVisibility(0);
            if (a0.I().u) {
                this.r.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_is_wait_recalc_route));
                return;
            } else {
                this.r.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_is_preparing_nav));
                return;
            }
        }
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeGuideNewView", "showWaitCalRouteFinish-> mLocationInfoTV= " + this.r + ", mProgressLayout=" + this.k);
        }
    }

    private void I0() {
        Bundle h;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VdrModeGuide", "default guide view updateVdrGuideView: ");
        }
        if (this.x == null) {
            C0();
        }
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null && relativeLayout.getVisibility() != 8) {
            if (gVar.d()) {
                gVar.e("VdrModeGuide", "default guide view mGuideInfoLayout set gone");
            }
            this.j.setVisibility(8);
        }
        if (this.x != null && (h = a0.I().h()) != null) {
            this.x.a(h.getString("road_name"));
        }
    }

    private void v(int i) {
        int i2;
        if (this.j != null) {
            Object tag = this.l.getTag();
            if (tag instanceof Integer) {
                i2 = ((Integer) tag).intValue();
            } else {
                i2 = 0;
            }
            if (i2 != i && !com.baidu.navisdk.ui.routeguide.b.V().E()) {
                TranslateAnimation translateAnimation = new TranslateAnimation(ScreenUtil.getInstance().dip2px(90), 0.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(600L);
                this.j.startAnimation(translateAnimation);
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGMMDefaultModeGuideNewView", "updateTurnIconWithAnim lastResId: " + i2 + ", resId:" + i);
                }
            }
            this.l.setTag(Integer.valueOf(i));
        }
    }

    private void z0() {
        boolean z;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("default guide view exitVdrLowPrecisionGuideView: ");
            f1 f1Var = this.x;
            if (f1Var != null && f1Var.c()) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            gVar.e("VdrModeGuide", sb.toString());
        }
        f1 f1Var2 = this.x;
        if (f1Var2 != null && f1Var2.c()) {
            RelativeLayout relativeLayout = this.j;
            if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                this.j.setVisibility(0);
            }
            this.x.a();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        D0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeGuideNewView", "hide() - mSimpleGuideView = " + this.i);
        }
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        TextView textView;
        boolean z;
        String str;
        if (this.w) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateData = ");
            if (bundle != null) {
                str = bundle.toString();
            } else {
                str = "null";
            }
            sb.append(str);
            gVar.e("guide_info", sb.toString());
        }
        if (bundle == null) {
            if (gVar.d()) {
                gVar.e("guide_info", "updateData --> bundle==null");
                return;
            }
            return;
        }
        if (a0.I().D() && !a0.I().r()) {
            if (gVar.d()) {
                gVar.e("RGMMDefaultModeGuideNewView", "Yawing now! cannot updateData!");
            }
            f(JarUtils.getResources().getString(R.string.nsdk_string_rg_nav_route_plan_yawing_text));
            return;
        }
        boolean z2 = bundle.getBoolean("remain_dist_hide", false);
        int i = bundle.getInt("updatetype");
        if (i == 2) {
            return;
        }
        if (x.b().P2()) {
            I0();
        } else {
            boolean z3 = true;
            if (i == 1) {
                z0();
                int i2 = bundle.getInt("resid", 0);
                int i3 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0);
                String string = bundle.getString("road_name");
                if (gVar.d()) {
                    gVar.e("RGMMDefaultModeGuideNewView", "updateData! --> nextRoadName = " + string);
                }
                if (string == null || string.length() == 0) {
                    string = JarUtils.getResources().getString(R.string.nsdk_string_navi_no_name_road);
                }
                new Bundle().putString("next_road_name", string);
                if (i2 != 0 && this.l != null) {
                    try {
                        v(i2);
                        if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
                            Drawable drawable = JarUtils.getResources().getDrawable(i2);
                            this.l.setImageDrawable(drawable);
                            if (drawable == null) {
                                com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1359", "0", "2");
                            }
                        } else {
                            this.l.setImageDrawable(com.baidu.navisdk.ui.routeguide.subview.util.b.a(i2));
                        }
                    } catch (OutOfMemoryError unused) {
                    }
                } else if (i2 == 0) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1359", "0", "0");
                } else {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1359", "0", "1");
                }
                String a2 = a0.I().a(i3);
                String b = a0.I().b(a2);
                String a3 = a0.I().a(a2);
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("update text -> mAfterMetersInfoTV = ");
                    if (this.m == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb2.append(z);
                    sb2.append(", mAfterLabelInfoTV = ");
                    if (this.n != null) {
                        z3 = false;
                    }
                    sb2.append(z3);
                    sb2.append(", start = ");
                    sb2.append(b);
                    sb2.append(", end = ");
                    sb2.append(a3);
                    sb2.append(" ,frontInfo = ");
                    sb2.append(a2);
                    sb2.append(", remainDist = ");
                    sb2.append(i3);
                    gVar2.e("RGMMDefaultModeGuideNewView", sb2.toString());
                }
                if (this.m != null && gVar2.d()) {
                    gVar2.e("RGMMDefaultModeGuideNewView", "mAfterMetersInfoTV.getVisible = " + this.m.getVisibility());
                }
                TextView textView2 = this.m;
                if (textView2 != null && this.n != null && b != null && a3 != null) {
                    if (!z2) {
                        textView2.setTextSize(0, JarUtils.getResources().getDimension(R.dimen.nsdk_rg_guide_txt_size_num));
                        this.m.setText(b);
                        this.n.setText(a3);
                        this.m.setPadding(0, 0, 0, 0);
                    } else {
                        textView2.setTextSize(0, JarUtils.getResources().getDimension(R.dimen.navi_dimens_36dp));
                        this.m.setText("现在");
                        this.m.setPadding(0, com.baidu.navisdk.module.asr.busi.c.a(10.0f), 0, 10);
                        this.n.setText("");
                    }
                }
                String c = a0.I().c(string);
                if (gVar2.d() && a0.F) {
                    c = c + "--测试路名折行效果测试路名折行效果测试路名折行效果测试路名折行效果";
                }
                if (c != null && (textView = this.p) != null && !textView.getText().equals(c)) {
                    if (gVar2.d()) {
                        gVar2.e("RGMMDefaultModeGuideNewView", "mGoWhereInfoTV.setText --> " + c);
                    }
                    this.p.setText(c);
                }
                if (this.o != null) {
                    if ("目的地".equals(string)) {
                        this.o.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_arrive));
                    } else {
                        this.o.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_enter));
                    }
                }
            }
        }
        n0();
        t0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void f(String str) {
        RelativeLayout relativeLayout;
        if (this.w) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeGuideNewView", "showYawingProgressView()");
        }
        B(false);
        C(false);
        TextView textView = this.s;
        if (textView != null && this.t != null) {
            textView.setVisibility(8);
            this.t.setVisibility(8);
        }
        if (this.r != null && (relativeLayout = this.k) != null) {
            relativeLayout.setVisibility(0);
            this.r.setVisibility(0);
            this.r.setText(str);
            y0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        com.baidu.navisdk.ui.util.j.a(this.l);
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void o0() {
        LinearLayout linearLayout = this.q;
        if (linearLayout != null && linearLayout.isShown()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500L);
            this.q.clearAnimation();
            this.q.startAnimation(alphaAnimation);
            a(this.l, this.m, this.n, this.o, this.p);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public View p0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeGuideNewView", "getCurrentPanelView() mSimpleGuideView:" + this.i);
        }
        return this.i;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public int q0() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_default_top_guide_panel_total_min_height);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void s0() {
        H0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void t0() {
        ImageView imageView;
        if (this.w) {
            return;
        }
        try {
            if (!com.baidu.navisdk.ui.routeguide.b.V().x() && !a0.I().t) {
                H0();
                y0();
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGMMDefaultModeGuideNewView", "hasCalcRouteOk -- > false ,  cannot updateData!");
                    return;
                }
                return;
            }
            if (a0.I().D() && !a0.I().r()) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e("RGMMDefaultModeGuideNewView", "Yawing now! cannot updateData!");
                }
                f(JarUtils.getResources().getString(R.string.nsdk_string_rg_nav_route_plan_yawing_text));
                return;
            }
            int i = com.baidu.navisdk.module.pronavi.a.j;
            if ((i == 1 || i == 5) && a0.I().q()) {
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar3.d()) {
                    gVar3.e("RGMMDefaultModeGuideNewView", "not data route, showCarlogoFreeView!");
                }
                x0();
                E0();
                if (!a0.I().v()) {
                    com.baidu.navisdk.ui.routeguide.holder.a.d().a(true);
                    RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_NAVI_READY);
                    return;
                }
                return;
            }
            x0();
            if (a0.I().C() && (imageView = this.l) != null) {
                try {
                    imageView.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_rg_ic_turn_along));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (x.b().P2() && A0()) {
                G0();
            } else {
                F0();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void u0() {
        d(a0.I().h());
        d(a0.I().k());
        t0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public int w0() {
        View view = this.i;
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    public void x0() {
        ImageView imageView = this.u;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.u.clearAnimation();
            this.u.setVisibility(4);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.w) {
            return false;
        }
        super.y();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDefaultModeGuideNewView", "show() - mSimpleGuideView = " + this.i);
        }
        View view = this.i;
        if (view != null) {
            view.setVisibility(0);
            this.i.requestLayout();
            if (!x.b().Z1()) {
                x.b().N3();
            }
        }
        u0();
        return true;
    }

    public void y0() {
        if (this.w) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("guide_info", "showSatelliteProgressView -- ");
        }
        ImageView imageView = this.u;
        if (imageView != null) {
            imageView.setVisibility(0);
            if (this.u.getAnimation() != null && this.u.getAnimation().hasStarted() && !this.u.getAnimation().hasEnded()) {
                return;
            }
            if (this.v == null) {
                this.v = com.baidu.navisdk.ui.util.b.b(this.f9165a, R.anim.nsdk_anim_satellite_progress_wait);
            }
            this.v.setInterpolator(new LinearInterpolator());
            if (this.v != null) {
                this.u.clearAnimation();
                this.u.startAnimation(this.v);
            }
        }
    }

    public void z(boolean z) {
        int i;
        Log.e("gblog", "隐藏诱导");
        this.w = z;
        a0.I().i(!z);
        com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
        if (!z) {
            i = 0;
        } else {
            i = 8;
        }
        b.r(i);
        if (z) {
            A(false);
            c();
        } else {
            y();
            A(true);
        }
    }

    private void a(View... viewArr) {
        if (this.w) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.3f, 1.0f, 0.3f, 1, 0.0f, 1, 0.0f);
        scaleAnimation.setDuration(500L);
        for (View view : viewArr) {
            if (view != null) {
                view.clearAnimation();
                view.startAnimation(scaleAnimation);
            }
        }
    }
}

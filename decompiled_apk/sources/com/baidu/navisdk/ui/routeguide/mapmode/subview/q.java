package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class q extends com.baidu.navisdk.ui.routeguide.widget.b {
    private ViewGroup A;
    private RelativeLayout B;
    private LinearLayout C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private f1 L;
    private ViewGroup i;
    private View j;
    private View k;
    private View l;
    private TextView m;
    private TextView n;
    private View o;
    private TextView p;
    private TextView q;
    private ImageView r;
    private ImageView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private ViewGroup y;
    private ViewGroup z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.this.D0();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.this.D0();
        }
    }

    public q(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        z0();
    }

    private void A0() {
        ViewGroup viewGroup;
        if (this.L == null) {
            this.L = new f1();
        }
        boolean a2 = this.L.a((ViewGroup) this.j, R.id.bnav_rg_vdr_low_precision_guide_layout_highway);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "default highway intoVdrLowPrecisionGuideView: " + a2);
        }
        if (a2 && this.z != null && (viewGroup = this.y) != null) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean B0() {
        if (com.baidu.navisdk.ui.routeguide.model.m.y().m() && !com.baidu.navisdk.ui.routeguide.control.x.b().o2()) {
            return true;
        }
        return false;
    }

    private boolean C0() {
        if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        if (!com.baidu.navisdk.function.b.FUNC_HUD.a()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "onClickToHudMode FUNC_HUD.isEnable() false");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().n2()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "onClickToHudMode isInterceptToHUDModeOnVdr");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("RouteGuide", "RGMMDefaultHighView on click to hud");
        }
        if (2 != com.baidu.navisdk.module.pronavi.a.j) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.8");
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState())) {
                com.baidu.navisdk.ui.routeguide.control.r.i().b();
            }
            if (RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getTopState())) {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
            }
            com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                k.r();
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_HUD_ENTER);
        }
    }

    private void E0() {
        if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
            ViewGroup viewGroup = this.z;
            if (viewGroup != null) {
                viewGroup.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_guide_top_panel));
            }
            ViewGroup viewGroup2 = this.y;
            if (viewGroup2 != null) {
                viewGroup2.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_guide_top_panel));
            }
        }
    }

    private boolean F0() {
        if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1 && com.baidu.navisdk.ui.routeguide.model.m.y().t()) {
            if (B0()) {
                if (RouteGuideFSM.getInstance().isBrowseState()) {
                    LogUtil.e("RouteGuide", "FsmState = BrowseMap miniPanel, don't show!");
                    return false;
                }
                String j = com.baidu.navisdk.ui.routeguide.model.m.y().j();
                String b2 = com.baidu.navisdk.ui.routeguide.model.a0.I().b(j);
                String a2 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(j);
                if (b2 != null && a2 != null) {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M0();
                    if (!s0()) {
                        y(true);
                        return true;
                    }
                }
            } else {
                y(false);
            }
        }
        return false;
    }

    private void G0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "default highway updateVdrGuideView: ");
        }
        if (s0()) {
            y(false);
        }
        if (this.L == null) {
            A0();
        }
        ViewGroup viewGroup = this.y;
        if (viewGroup != null && viewGroup.getVisibility() != 8) {
            this.y.setVisibility(8);
        }
        View view = this.l;
        if (view != null && view.getVisibility() != 8) {
            this.l.setVisibility(8);
        }
        View view2 = this.k;
        if (view2 != null && view2.getVisibility() != 8) {
            this.k.setVisibility(8);
        }
        String a2 = com.baidu.navisdk.ui.routeguide.model.m.y().a(4);
        if (this.L != null && !TextUtils.isEmpty(a2)) {
            this.L.a(a2);
        }
    }

    private SpannableStringBuilder g(String str) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(JarUtils.getResources().getColor(R.color.nsdk_rg_main_info));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(JarUtils.getResources().getColor(R.color.nsdk_text_rg_normal_info));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str.endsWith(JarUtils.getResources().getString(R.string.bnav_string_hw_direction))) {
            spannableStringBuilder.setSpan(foregroundColorSpan, 0, str.length() - 2, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan2, str.length() - 2, str.length(), 33);
        } else {
            spannableStringBuilder.setSpan(foregroundColorSpan, 0, str.length(), 33);
        }
        return spannableStringBuilder;
    }

    private void h(String str) {
        ViewGroup viewGroup;
        if (this.E != null && (viewGroup = this.y) != null && viewGroup.getVisibility() != 8) {
            int x02 = x0();
            this.F.setMaxWidth(x02);
            if (!com.baidu.navisdk.util.common.l0.c(str) && str.trim().contains(" ")) {
                this.F.setText(a(this.F, x02, str, 1));
            } else {
                this.F.setText(str);
            }
        }
    }

    private void u0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "default highway exitVdrLowPrecisionGuideView: ");
        }
        f1 f1Var = this.L;
        if (f1Var != null && f1Var.c()) {
            this.L.a();
        }
    }

    private int w0() {
        int V;
        int dimensionPixelOffset;
        if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
            if (this.n == null) {
                LogUtil.e("RouteGuide", "getGoWhereViewWidth-> mDirectionTV == null");
                return 0;
            }
            V = (((((com.baidu.navisdk.pronavi.util.a.h.e() - (JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left_real_size) * 2)) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_icon_turn_zise)) - (JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_top_guide_turn_icon_margin) * 2)) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_top_guide_panel_margin_right_to_devices_view)) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_cp_icon_edge_margin)) - com.baidu.navisdk.ui.util.j.a(this.n, JarUtils.getResources().getString(R.string.bnav_string_hw_direction));
            dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_6dp);
        } else {
            V = com.baidu.navisdk.ui.routeguide.control.x.b().V();
            dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left_real_size) * 2;
        }
        int i = V - dimensionPixelOffset;
        LogUtil.e("RouteGuide", "getGoWhereViewWidth-> maxWidth= " + i);
        return i;
    }

    private int x0() {
        if (this.G != null && this.K != null && this.E != null) {
            int e = ((((com.baidu.navisdk.pronavi.util.a.h.e() - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_highway_mini_icon_width)) - (JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left_real_size) * 2)) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_highway_mini_icon_margin_left)) - (JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_highway_mini_icon_margin_right) * 4)) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_highway_mini_direction_margin_right);
            TextView textView = this.E;
            int a2 = e - com.baidu.navisdk.ui.util.j.a(textView, textView.getText().toString());
            TextView textView2 = this.K;
            int a3 = a2 - com.baidu.navisdk.ui.util.j.a(textView2, textView2.getText().toString());
            TextView textView3 = this.G;
            return (a3 - com.baidu.navisdk.ui.util.j.a(textView3, textView3.getText().toString())) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_8dp);
        }
        return 0;
    }

    private void y(boolean z) {
        LogUtil.e("RouteGuide", "showMiniPanel -> " + z);
        if (z) {
            y0();
            ViewGroup viewGroup = this.z;
            if (viewGroup != null && this.y != null) {
                viewGroup.setVisibility(8);
                this.y.setVisibility(0);
                com.baidu.navisdk.ui.routeguide.model.m.y().c(1);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M0();
            }
        } else {
            ViewGroup viewGroup2 = this.z;
            if (viewGroup2 != null && this.y != null) {
                viewGroup2.setVisibility(0);
                this.y.setVisibility(8);
                com.baidu.navisdk.ui.routeguide.model.m.y().c(0);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().N3();
            }
        }
        com.baidu.navisdk.ui.routeguide.control.q.c().b();
    }

    private void y0() {
        ViewGroup viewGroup;
        LogUtil.e("RouteGuide", "initMiniPanel - viewStub.inflate : mHighwayViewMiniLayout = " + this.y + ", mRootViewGroup = " + this.b);
        if (this.y == null && (viewGroup = this.b) != null) {
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.bnav_mini_layout);
            if (viewStub != null) {
                viewStub.inflate();
            }
            ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(R.id.bnav_mini_layout_root);
            this.y = viewGroup2;
            if (viewGroup2 != null) {
                this.B = (RelativeLayout) viewGroup2.findViewById(R.id.bnav_rg_hw_direction_mode_layout);
                this.C = (LinearLayout) this.y.findViewById(R.id.bnav_rg_hw_along_mode_layout);
                this.D = (ImageView) this.y.findViewById(R.id.bnav_rg_hw_turn_mini_icon);
                this.E = (TextView) this.y.findViewById(R.id.bnav_rg_hw_after_meters_multi_mini_tv);
                this.F = (TextView) this.y.findViewById(R.id.bnav_rg_hw_go_where_multi_mini_tv);
                this.G = (TextView) this.y.findViewById(R.id.bnav_rg_hw_direction_text);
                this.H = (TextView) this.y.findViewById(R.id.bnav_rg_hg_mini_cur_road_name_tv);
                this.I = (TextView) this.y.findViewById(R.id.bnav_rg_hg_mini_cur_road_remain_dist_tv);
                this.J = (TextView) this.y.findViewById(R.id.bnav_rg_hg_mini_cur_road_remain_dist_word);
                this.K = (TextView) this.y.findViewById(R.id.bnv_rg_hw_split);
                this.y.setVisibility(8);
            }
            E0();
        }
    }

    private void z0() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_highway_container);
        this.i = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        viewGroup2.removeAllViews();
        boolean z = true;
        if (1 == com.baidu.navisdk.ui.routeguide.control.x.b().d0()) {
            this.f = 1;
            this.j = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_rg_mapmode_highway, null);
        } else {
            this.f = 2;
            this.j = JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_rg_mapmode_highway_land, null);
        }
        if (this.j == null) {
            return;
        }
        if (1 == com.baidu.navisdk.ui.routeguide.control.x.b().d0()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        this.i.addView(this.j, layoutParams);
        this.i.requestLayout();
        this.k = this.j.findViewById(R.id.bnav_rg_hg_direction_mode);
        this.r = (ImageView) this.b.findViewById(R.id.bnav_rg_hw_turn_icon);
        this.o = this.b.findViewById(R.id.bnav_rg_hw_go_where_panel);
        this.p = (TextView) this.b.findViewById(R.id.bnav_rg_hw_go_label);
        this.q = (TextView) this.b.findViewById(R.id.bnav_rg_hw_go_where_multi_tv);
        this.s = (ImageView) this.b.findViewById(R.id.bnav_rg_hg_along_icon);
        this.t = (TextView) this.b.findViewById(R.id.bnav_rg_hw_after_meters_multi_tv);
        this.u = (TextView) this.b.findViewById(R.id.bnav_rg_hw_after_label_info);
        this.m = (TextView) this.b.findViewById(R.id.bnav_rg_hw_ic_code);
        this.n = (TextView) this.b.findViewById(R.id.bnav_rg_hw_direction);
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setOnClickListener(new a());
        }
        ImageView imageView2 = this.s;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new b());
        }
        if (1 == com.baidu.navisdk.ui.routeguide.control.x.b().d0()) {
            ViewGroup viewGroup3 = (ViewGroup) this.j.findViewById(R.id.bnav_defaul_layout);
            this.z = viewGroup3;
            viewGroup3.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_guide_top_panel));
            this.A = (ViewGroup) this.j.findViewById(R.id.bnav_rg_hw_guide_info_layout);
        } else {
            this.A = null;
        }
        this.l = this.j.findViewById(R.id.bnav_rg_hg_along_mode);
        this.v = (TextView) this.j.findViewById(R.id.bnav_rg_hg_cur_road_name_tv);
        this.w = (TextView) this.j.findViewById(R.id.bnav_rg_hg_cur_road_remain_dist_tv);
        this.x = (TextView) this.j.findViewById(R.id.bnav_rg_hg_cur_road_remain_dist_word);
        if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
            if (com.baidu.navisdk.ui.routeguide.model.m.y().c() == 0) {
                z = false;
            }
            y(z);
        }
        E0();
        t0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        LogUtil.e("RouteGuide", "hide() - mHighwayViewContainer = " + this.i);
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        boolean z;
        TextView textView;
        TextView textView2;
        int i;
        int i2;
        int i3;
        int i4;
        if (RouteGuideFSM.getInstance().getCurrentEvent() != null && RouteGuideFSM.getInstance().getCurrentEvent().equals(RGFSMTable.FsmEvent.MSG_YAWING_START)) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.model.m.y().i();
        String j = com.baidu.navisdk.ui.routeguide.model.m.y().j();
        String b2 = com.baidu.navisdk.ui.routeguide.model.a0.I().b(j);
        String a2 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(j);
        String a3 = com.baidu.navisdk.ui.routeguide.model.m.y().a();
        if (com.baidu.navisdk.ui.routeguide.control.x.b().P2()) {
            G0();
            return;
        }
        u0();
        View view = this.l;
        if (view != null) {
            if (a3 == null) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        View view2 = this.k;
        if (view2 != null) {
            if (a3 == null) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view2.setVisibility(i3);
        }
        F0();
        if (s0()) {
            RelativeLayout relativeLayout = this.B;
            if (relativeLayout != null) {
                if (a3 == null) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                relativeLayout.setVisibility(i2);
            }
            LinearLayout linearLayout = this.C;
            if (linearLayout != null) {
                if (a3 == null) {
                    i = 0;
                } else {
                    i = 8;
                }
                linearLayout.setVisibility(i);
            }
        }
        boolean z2 = true;
        if (a3 == null) {
            TextView textView3 = this.v;
            if (textView3 != null) {
                textView3.setText(com.baidu.navisdk.ui.routeguide.model.m.y().b());
            }
            TextView textView4 = this.w;
            if (textView4 != null) {
                textView4.setText(b2);
            }
            TextView textView5 = this.x;
            if (textView5 != null) {
                textView5.setText(a2);
            }
            if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1 && B0()) {
                y0();
                TextView textView6 = this.H;
                if (textView6 != null && this.I != null && this.J != null) {
                    textView6.setText(com.baidu.navisdk.ui.routeguide.model.m.y().b());
                    this.I.setText(b2);
                    this.J.setText(a2);
                    return;
                }
                return;
            }
            return;
        }
        TextView textView7 = this.t;
        if (textView7 != null && this.u != null && b2 != null && a2 != null) {
            textView7.setText(b2);
            this.u.setText(a2);
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
            if (!com.baidu.navisdk.ui.routeguide.model.m.y().s() && (textView2 = this.n) != null) {
                textView2.setVisibility(0);
            }
            TextView textView8 = this.q;
            if (textView8 != null) {
                textView8.setText(a(textView8, w0(), a3, 1));
                this.q.setVisibility(0);
            }
            if (B0()) {
                y0();
                if (this.D != null && this.F != null && (textView = this.E) != null && this.G != null && b2 != null && a2 != null) {
                    textView.setText(b2 + a2);
                    h(a3);
                    return;
                }
                return;
            }
            return;
        }
        TextView textView9 = this.n;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        SpannableStringBuilder g = g(a(this.q, w0(), a3 + "  " + JarUtils.getResources().getString(R.string.bnav_string_hw_direction), 2));
        TextView textView10 = this.q;
        if (textView10 != null && g != null) {
            textView10.setMaxLines(2);
            TextPaint paint = this.q.getPaint();
            if (this.q.getText() == null || paint.measureText(this.q.getText().toString()) <= w0()) {
                z = true;
            } else {
                z = false;
            }
            if (paint.measureText(g.toString()) > w0()) {
                z2 = false;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "reLayout default mode highway guide panel, oldDirectionSingleLine=" + z + ", newDirectionSingleLine=" + z2);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.q.getLayoutParams();
            if (z && !z2) {
                marginLayoutParams.topMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_control_panel_btn_margin_top);
            } else {
                if (!z && z2) {
                    marginLayoutParams.topMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_10dp);
                }
                this.q.setText(g);
                this.q.setVisibility(0);
            }
            this.q.setLayoutParams(marginLayoutParams);
            this.q.setText(g);
            this.q.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public void f(String str) {
        if ((str.equals(RGFSMTable.FsmState.North2D) || str.equals(RGFSMTable.FsmState.Car3D)) && com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1 && B0() && com.baidu.navisdk.ui.routeguide.model.m.y().t()) {
            y(true);
            t0();
            LogUtil.e("RouteGuide", "checked state --> " + str + " , showMiniPanel --> true");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.r = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public void n0() {
        Object valueOf;
        ViewGroup viewGroup = this.A;
        if (viewGroup != null && viewGroup.isShown()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.4f);
            alphaAnimation.setDuration(550L);
            this.A.clearAnimation();
            this.A.startAnimation(alphaAnimation);
            a(this.r, this.u, this.t, this.p, this.o, this.l);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("entryVoicePanelFuseAnim mGuideInfoLayout.isShown = ");
        ViewGroup viewGroup2 = this.A;
        if (viewGroup2 == null) {
            valueOf = "null";
        } else {
            valueOf = Boolean.valueOf(viewGroup2.isShown());
        }
        sb.append(valueOf);
        LogUtil.e("RouteGuide", sb.toString());
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public View o0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "getCurrentPanelView() mHighwayView:" + this.j);
        }
        return this.j;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public int p0() {
        if (s0()) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_top_guide_mini_height);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_top_panel_height);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public boolean q0() {
        if (C0() && B0()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "gestureDetectorTAG,onSingleTapConfirmed");
            }
            boolean s0 = s0();
            y(!s0);
            if (!s0) {
                t0();
            }
            com.baidu.navisdk.ui.routeguide.model.m.y().a(false);
        }
        return super.q0();
    }

    public void r0() {
        if (s0()) {
            y(false);
        }
    }

    public boolean s0() {
        ViewGroup viewGroup;
        if (a() && (viewGroup = this.y) != null && viewGroup.getVisibility() == 0) {
            LogUtil.e("RouteGuide", "ismMiniPanelShowing-1 = true");
            return true;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().s2() && com.baidu.navisdk.ui.routeguide.model.m.y().c() == 1) {
            LogUtil.e("RouteGuide", "ismMiniPanelShowing-2 = true");
            return true;
        }
        LogUtil.e("RouteGuide", "ismMiniPanelShowing = false");
        return false;
    }

    public void t0() {
        d(null);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public boolean v(int i) {
        if (C0() && B0()) {
            if (i > 0) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "gestureDetector,onFling,spread");
                }
                y(false);
                com.baidu.navisdk.ui.routeguide.model.m.y().a(false);
            } else if (i < 0) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "gestureDetector,onFling,shrink");
                }
                y(true);
                t0();
            }
        }
        return super.v(i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        E0();
    }

    private String a(TextView textView, int i, String str, int i2) {
        int lastIndexOf;
        return (textView == null || com.baidu.navisdk.ui.util.j.a(textView, i, str, i2) || (lastIndexOf = str.lastIndexOf(" ")) < 0) ? str : a(textView, i, str.substring(0, lastIndexOf), i2);
    }

    private void a(View... viewArr) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.3f, 1.0f, 0.3f, 1, 0.0f, 1, 0.0f);
        scaleAnimation.setDuration(550L);
        for (View view : viewArr) {
            if (view != null && view.isShown()) {
                view.clearAnimation();
                view.startAnimation(scaleAnimation);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        LogUtil.e("RouteGuide", "show() - mHighwayViewContainer = " + this.i);
        t0();
        ViewGroup viewGroup = this.i;
        if (viewGroup == null) {
            return true;
        }
        viewGroup.setVisibility(0);
        return true;
    }
}

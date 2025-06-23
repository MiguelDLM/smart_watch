package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.asr.i.c;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.asr.view.BNVoiceView;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.List;

/* loaded from: classes8.dex */
public class h1 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private static String N = "RGMMVoiceView";
    private static String O = "方向";
    private LinearLayout A;
    private ImageView B;
    private LinearLayout C;
    private TextView D;
    private TextView E;
    private TextView F;
    private ViewGroup G;
    private TextView H;
    private TextView I;
    private String J;
    private String K;
    private boolean L;
    private f1 M;
    private ViewStub i;
    private ViewGroup j;
    private RelativeLayout k;
    private ViewGroup l;
    private RelativeLayout m;
    private RelativeLayout n;
    private BNVoiceView o;
    private ProgressBar p;
    private TextView q;
    private TextView r;
    private ImageView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private ViewGroup w;
    private TextView x;
    private TextView y;
    private TextView z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h1.this.s0();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(h1.N, "startWithAnim() onAnimationEnd");
            }
            if (com.baidu.navisdk.ui.routeguide.control.x.b().s2() && ((com.baidu.navisdk.ui.routeguide.control.x.b().e2() || !com.baidu.navisdk.ui.routeguide.control.x.b().g2()) && h1.this.k != null)) {
                h1.this.k.setVisibility(0);
                if (gVar.d()) {
                    gVar.e(h1.N, "执行诱导信息部分动画! - mGuideInfoLayoutGoup.setVisibility(View.VISIBLE)");
                }
            }
            if (h1.this.o != null) {
                h1.this.o.setOperateAreaVisibility(0);
                if (h1.this.o.getCurrentStatus() == c.a.START) {
                    h1.this.o.getHeadView().start(false);
                }
                h1.this.o.getContentAnimView().setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(h1.N, "startWithAnim() onAnimationStart");
            }
            if (h1.this.o != null) {
                h1.this.o.getContentAnimView().setVisibility(4);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h1.this.C0()) {
                h1.this.A.setVisibility(8);
            }
        }
    }

    public h1(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.L = false;
        z0();
    }

    private void A(boolean z) {
        String str;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VdrModeGuide", "xdvoice updateVdrGuideView: ");
        }
        if (this.M == null) {
            B0();
        }
        LinearLayout linearLayout = this.A;
        if (linearLayout != null && linearLayout.getVisibility() != 8) {
            v(8);
        }
        ViewGroup viewGroup = this.l;
        if (viewGroup != null && viewGroup.getVisibility() != 8) {
            this.l.setVisibility(8);
        }
        if (z) {
            str = com.baidu.navisdk.ui.routeguide.model.m.y().a(4);
        } else {
            Bundle h = com.baidu.navisdk.ui.routeguide.model.a0.I().h();
            if (h != null) {
                str = h.getString("road_name");
            } else {
                str = null;
            }
        }
        f1 f1Var = this.M;
        if (f1Var != null) {
            f1Var.a(str);
        }
    }

    private void A0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.bnav_rg_xd_voice_container_stub);
        this.i = viewStub;
        if (viewStub != null) {
            viewStub.inflate();
        }
        ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(R.id.bnav_rg_xd_voice_container);
        this.j = viewGroup2;
        if (viewGroup2 != null) {
            if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
                this.k = (RelativeLayout) this.j.findViewById(R.id.bnav_rg_voice_guide_info_layout);
                this.l = (ViewGroup) this.j.findViewById(R.id.bnav_rg_voice_guide_info_panel);
                this.m = (RelativeLayout) this.j.findViewById(R.id.bnav_rg_simple_guide_info_layout);
                this.p = (ProgressBar) this.j.findViewById(R.id.bnav_rg_enlarge_progress);
                this.q = (TextView) this.j.findViewById(R.id.bnav_rg_remain_dist);
                this.r = (TextView) this.j.findViewById(R.id.bnav_rg_remain_dist_unit);
                this.s = (ImageView) this.j.findViewById(R.id.bnav_rg_turn_icon);
                this.t = (TextView) this.j.findViewById(R.id.bnav_rg_enter_next_road);
                this.u = (TextView) this.j.findViewById(R.id.bnav_rg_next_road);
                this.A = (LinearLayout) this.j.findViewById(R.id.bnav_rg_next_turn_layout);
                this.B = (ImageView) this.j.findViewById(R.id.bnav_rg_next_turn_image);
                this.G = (ViewGroup) this.j.findViewById(R.id.bnav_rg_fuzzy_panel_layout);
                this.H = (TextView) this.j.findViewById(R.id.bnav_rg_fuzzy_content_text);
                this.C = (LinearLayout) this.j.findViewById(R.id.bnav_rg_along_mode_layout);
                this.D = (TextView) this.j.findViewById(R.id.bnav_rg_cur_road_name_tv);
                this.E = (TextView) this.j.findViewById(R.id.bnav_rg_cur_road_remain_dist_tv);
                this.F = (TextView) this.j.findViewById(R.id.bnav_rg_cur_road_remain_dist_word);
                this.w = (ViewGroup) this.j.findViewById(R.id.bnav_rg_highway_panel_layout);
                this.x = (TextView) this.j.findViewById(R.id.bnav_rg_highway_remain_dist);
                this.y = (TextView) this.j.findViewById(R.id.bnav_rg_highway_remain_dist_unit);
                this.z = (TextView) this.j.findViewById(R.id.bnav_rg_highway_next_road);
                this.I = (TextView) this.j.findViewById(R.id.bnav_rg_enlarge_high_way_exit_code);
                this.k.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_voice_panel_guide_info));
                if (this.M != null) {
                    this.M = null;
                }
            } else {
                this.k = null;
                this.m = null;
            }
            this.n = (RelativeLayout) this.j.findViewById(R.id.bnav_rg_voice_panel_layout);
            if (this.o == null && com.baidu.navisdk.framework.a.c().a() != null) {
                this.o = new BNVoiceView(com.baidu.navisdk.framework.a.c().a());
                this.o.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            BNVoiceView bNVoiceView = this.o;
            if (bNVoiceView != null && bNVoiceView.getParent() != null) {
                ((ViewGroup) this.o.getParent()).removeView(this.o);
            }
            this.n.addView(this.o);
            this.o.b();
            b(N, new a());
        }
    }

    private void B0() {
        if (this.M == null) {
            this.M = new f1();
        }
        boolean a2 = this.M.a(this.b, R.id.bnav_rg_vdr_low_precision_guide_layout_voice);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VdrModeGuide", "xdvoice intoVdrLowPrecisionGuideView: " + a2);
        }
        if (a2) {
            if (this.A != null) {
                v(8);
            }
            ViewGroup viewGroup = this.l;
            if (viewGroup != null && viewGroup.getVisibility() != 8) {
                this.l.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C0() {
        int lineCount;
        Layout layout = this.u.getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
            return true;
        }
        return false;
    }

    private void D0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(N, "resetNextTurnVisible!");
        }
        com.baidu.navisdk.ui.routeguide.model.a0.I().i(false);
        com.baidu.navisdk.ui.routeguide.control.x.b().r(8);
    }

    private void E0() {
        LinearLayout linearLayout;
        if (this.m != null && this.G != null && (linearLayout = this.C) != null && this.w != null && this.p != null) {
            linearLayout.setVisibility(0);
            this.w.setVisibility(8);
            this.m.setVisibility(8);
            this.G.setVisibility(8);
            this.p.setVisibility(8);
        }
    }

    private void F0() {
        RelativeLayout relativeLayout = this.m;
        if (relativeLayout != null && this.G != null && this.C != null && this.w != null && this.p != null) {
            relativeLayout.setVisibility(0);
            this.G.setVisibility(8);
            this.C.setVisibility(8);
            this.w.setVisibility(8);
        }
    }

    private void G0() {
        ViewGroup viewGroup;
        if (this.m != null && (viewGroup = this.G) != null && this.C != null && this.w != null && this.p != null) {
            viewGroup.setVisibility(0);
            this.C.setVisibility(8);
            this.w.setVisibility(8);
            this.m.setVisibility(8);
            this.p.setVisibility(8);
        }
    }

    private void H0() {
        ViewGroup viewGroup;
        if (this.m != null && this.G != null && this.C != null && (viewGroup = this.w) != null && this.p != null) {
            viewGroup.setVisibility(0);
            this.m.setVisibility(8);
            this.G.setVisibility(8);
            this.C.setVisibility(8);
            this.p.setVisibility(8);
        }
    }

    private void I0() {
        RelativeLayout relativeLayout = this.m;
        if (relativeLayout != null && this.G != null && this.C != null && this.w != null && this.p != null) {
            relativeLayout.setVisibility(0);
            this.G.setVisibility(8);
            this.C.setVisibility(8);
            this.w.setVisibility(8);
            this.p.setVisibility(8);
        }
    }

    private void J0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(N, "updateDataByLastest");
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().P2()) {
            if (gVar.d()) {
                gVar.e(N, "updateDataByLastest isVdrLowPrecisionGuide ");
            }
            A(com.baidu.navisdk.ui.routeguide.model.m.y().u());
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().N2()) {
            if (gVar.d()) {
                gVar.e(N, "updateDataByLastest isVdrMiddleLowInStart");
            }
            z(false);
            return;
        }
        u0();
        if (com.baidu.navisdk.ui.routeguide.control.x.b().f2()) {
            z(true);
        } else if (com.baidu.navisdk.ui.routeguide.model.i.s().n()) {
            e(com.baidu.navisdk.ui.routeguide.model.i.s().e());
        } else if (com.baidu.navisdk.ui.routeguide.model.m.y().u()) {
            K0();
        } else {
            f(com.baidu.navisdk.ui.routeguide.model.a0.I().h());
            f(com.baidu.navisdk.ui.routeguide.model.a0.I().k());
        }
        t0();
    }

    private void K0() {
        TextView textView;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(N, "updateHighwayData");
        }
        if (!w(3)) {
            return;
        }
        String j = com.baidu.navisdk.ui.routeguide.model.m.y().j();
        String b2 = com.baidu.navisdk.ui.routeguide.model.a0.I().b(j);
        String a2 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(j);
        String a3 = com.baidu.navisdk.ui.routeguide.model.m.y().a();
        if (a3 == null) {
            E0();
        } else {
            H0();
        }
        if (a3 == null) {
            TextView textView2 = this.D;
            if (textView2 != null) {
                textView2.setText(com.baidu.navisdk.ui.routeguide.model.m.y().b());
            }
            TextView textView3 = this.E;
            if (textView3 != null) {
                textView3.setText(b2);
            }
            TextView textView4 = this.F;
            if (textView4 != null) {
                textView4.setText(a2);
                return;
            }
            return;
        }
        if (this.q != null && this.r != null && b2 != null && a2 != null) {
            this.x.setText(b2);
            this.y.setText(a2);
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1 && (textView = this.z) != null) {
            textView.setText(a3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        if (this.n != null && this.f == 2 && com.baidu.navisdk.module.newguide.a.e().d()) {
            int[] iArr = new int[2];
            this.n.getLocationOnScreen(iArr);
            int d = com.baidu.navisdk.pronavi.util.a.h.d();
            com.baidu.navisdk.framework.interfaces.pronavi.hd.f b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(1);
            if (b2.f6817a == 2) {
                d -= b2.c;
            }
            int i = d - iArr[0];
            if (i < JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_control_voice_panel_land_new_width)) {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.width = i;
                this.n.setLayoutParams(layoutParams);
            }
        }
    }

    private void t0() {
        if (this.A != null && this.B != null && !com.baidu.navisdk.ui.routeguide.control.x.b().f2() && !com.baidu.navisdk.ui.routeguide.control.x.b().N2() && !com.baidu.navisdk.ui.routeguide.model.a0.I().v() && !com.baidu.navisdk.ui.routeguide.model.m.y().u()) {
            if (com.baidu.navisdk.ui.routeguide.model.a0.I().i()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(N, "初始化语音诱导bar随后标");
                }
                Drawable d = com.baidu.navisdk.ui.routeguide.model.a0.I().e().d();
                if (d != null) {
                    this.B.setImageDrawable(d);
                    v(0);
                    return;
                }
                return;
            }
            v(8);
        }
    }

    private void u0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VdrModeGuide", "xdvoice exitVdrLowPrecisionGuideView: ");
        }
        f1 f1Var = this.M;
        if (f1Var != null) {
            f1Var.a();
        }
        ViewGroup viewGroup = this.l;
        if (viewGroup != null && viewGroup.getVisibility() != 0) {
            this.l.setVisibility(0);
        }
    }

    private boolean w(int i) {
        int i2;
        if (com.baidu.navisdk.ui.routeguide.control.x.b().N2()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(N, "allowUpdateData isVdrMiddleLowInStart");
            }
            return true;
        }
        if (com.baidu.navisdk.ui.routeguide.model.i.s().n()) {
            i2 = 1;
        } else if (com.baidu.navisdk.ui.routeguide.control.x.b().f2()) {
            i2 = 2;
        } else if (com.baidu.navisdk.ui.routeguide.model.m.y().u()) {
            i2 = 3;
        } else {
            i2 = 4;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e(N, "priority = " + i2 + ", dataType = " + i);
        }
        if (i == i2) {
            return true;
        }
        return false;
    }

    private int w0() {
        try {
            TextView textView = this.q;
            int a2 = com.baidu.navisdk.ui.util.j.a(textView, textView.getText().toString());
            int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_voice_guide_info_remain_dist_margin_left);
            TextView textView2 = this.r;
            int a3 = com.baidu.navisdk.ui.util.j.a(textView2, textView2.getText().toString());
            int dimensionPixelOffset2 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_voice_guide_info_remain_dist_unit_margin_left);
            int dimensionPixelOffset3 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_enlarge_next_turn_size);
            TextView textView3 = this.I;
            int a4 = com.baidu.navisdk.ui.util.j.a(textView3, textView3.getText().toString());
            int dimensionPixelOffset4 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_1dp) * 2;
            TextView textView4 = this.t;
            int a5 = com.baidu.navisdk.ui.util.j.a(textView4, textView4.getText().toString());
            int dimensionPixelOffset5 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_voice_guide_info_enter_label_margin_left);
            return (com.baidu.navisdk.pronavi.util.a.h.e() - (this.k.getPaddingLeft() * 2)) - (((((((((((((a2 + dimensionPixelOffset) + a3) + dimensionPixelOffset2) + dimensionPixelOffset3) + dimensionPixelOffset2) + a4) + dimensionPixelOffset4) + dimensionPixelOffset2) + a5) + dimensionPixelOffset5) + dimensionPixelOffset5) + dimensionPixelOffset2) + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_4dp));
        } catch (Exception e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(N, "getDirectionMaxWidth exception:" + e.toString());
                return 0;
            }
            return 0;
        }
    }

    private void x0() {
        this.J = null;
        this.K = null;
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null) {
            List<com.baidu.navisdk.module.pronavi.model.d> m = com.baidu.navisdk.ui.routeguide.b.V().i().c().m();
            if (m.size() > 0) {
                int i = 0;
                for (com.baidu.navisdk.module.pronavi.model.d dVar : m) {
                    i++;
                    if ((dVar.p() == 3 || dVar.p() == 5) && !com.baidu.navisdk.ui.routeguide.model.i.s().l()) {
                        int i2 = com.baidu.navisdk.ui.routeguide.model.a0.A.getInt("nGPAddDist");
                        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar.d()) {
                            gVar.e(N, "updateRasterMapInfo, addDist=" + i2 + ", serviceAreaBean.getAddDist()=" + dVar.a());
                        }
                        if (dVar.a() == i2) {
                            this.J = "出口" + dVar.d();
                            this.K = dVar.h();
                            return;
                        }
                    }
                    if (i >= 2) {
                        return;
                    }
                }
            }
        }
    }

    private void y0() {
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        BNVoiceView bNVoiceView = this.o;
        if (bNVoiceView != null) {
            bNVoiceView.setVisibility(4);
        }
        this.L = false;
    }

    private void z(boolean z) {
        String b2;
        if (!w(2)) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(N, "updateFuzzyData: " + z);
        }
        G0();
        if (z) {
            b2 = com.baidu.navisdk.ui.routeguide.model.a0.I().g();
        } else {
            b2 = com.baidu.navisdk.ui.routeguide.holder.a.d().b();
        }
        if (gVar.d()) {
            gVar.e(N, "updateFuzzyData: " + b2);
        }
        String string = JarUtils.getResources().getString(R.string.nsdk_string_rg_fuzzy_panel_text, b2);
        TextView textView = this.H;
        if (textView != null) {
            textView.setText(string);
        }
        y(z);
    }

    private void z0() {
        A0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
            if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
                ViewGroup viewGroup = this.j;
                if (viewGroup != null && viewGroup.isShown()) {
                    return new View[]{this.j};
                }
                return null;
            }
            BNVoiceView bNVoiceView = this.o;
            if (bNVoiceView != null && bNVoiceView.isShown()) {
                return new View[]{this.o};
            }
            return null;
        }
        return null;
    }

    public void f(String str) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        com.baidu.navisdk.asr.d.B().a((com.baidu.navisdk.asr.i.c) null);
        this.o = null;
    }

    public void n0() {
        ProgressBar progressBar = this.p;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        J0();
    }

    public boolean o0() {
        RelativeLayout relativeLayout;
        if (this.L && (relativeLayout = this.k) != null && relativeLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean p0() {
        return this.L;
    }

    public void q0() {
        boolean z;
        boolean z2;
        boolean z3;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            String str = N;
            StringBuilder sb = new StringBuilder();
            sb.append("BNMMVoiceView startWithAnim()， mVoiceInfoLayout = ");
            if (this.n == null) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append(", mBNVoiceView = ");
            if (this.o == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            sb.append(z2);
            sb.append(", mGuideInfoLayoutGoup = ");
            if (this.k == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            sb.append(z3);
            gVar.e(str, sb.toString());
        }
        if (o0()) {
            if (gVar.d()) {
                gVar.e(N, "BNMMVoiceView startWithAnim - getPanelFuseStatus() = true ,return !");
                return;
            }
            return;
        }
        RelativeLayout relativeLayout = this.n;
        if (relativeLayout != null && this.o != null) {
            relativeLayout.setVisibility(0);
            if (com.baidu.navisdk.ui.routeguide.control.x.b().s2() && !com.baidu.navisdk.ui.routeguide.control.x.b().e2() && com.baidu.navisdk.ui.routeguide.control.x.b().g2() && this.k != null) {
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500L);
                animationSet.addAnimation(alphaAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f);
                scaleAnimation.setDuration(500L);
                animationSet.addAnimation(scaleAnimation);
                this.k.setVisibility(0);
                this.k.clearAnimation();
                this.k.startAnimation(animationSet);
            }
            BNVoiceView bNVoiceView = this.o;
            if (bNVoiceView != null) {
                bNVoiceView.a(new b());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (C0() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v(int r5) {
        /*
            r4 = this;
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r1 = r0.d()
            if (r1 == 0) goto L1e
            java.lang.String r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.h1.N
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "RGMMVoiceView setNextTurnViewVisible visibility = "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0.e(r1, r2)
        L1e:
            r0 = 8
            if (r5 != 0) goto L2e
            android.widget.TextView r1 = r4.v
            if (r1 == 0) goto L2e
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L2e
            r5 = 8
        L2e:
            android.widget.TextView r1 = r4.u
            android.text.Layout r1 = r1.getLayout()
            if (r1 != 0) goto L41
            android.widget.TextView r0 = r4.u
            com.baidu.navisdk.ui.routeguide.mapmode.subview.h1$c r1 = new com.baidu.navisdk.ui.routeguide.mapmode.subview.h1$c
            r1.<init>()
            r0.post(r1)
            goto L48
        L41:
            boolean r1 = r4.C0()
            if (r1 == 0) goto L48
            goto L49
        L48:
            r0 = r5
        L49:
            android.widget.LinearLayout r5 = r4.A
            if (r5 == 0) goto L58
            int r5 = r5.getVisibility()
            if (r5 == r0) goto L58
            android.widget.LinearLayout r5 = r4.A
            r5.setVisibility(r0)
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.subview.h1.v(int):void");
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        return b((Bundle) null);
    }

    private void e(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            String str = N;
            StringBuilder sb = new StringBuilder();
            sb.append("updataEnlargeMapData b = ");
            sb.append(bundle == null ? "null" : bundle.toString());
            gVar.e(str, sb.toString());
        }
        if (w(1) && bundle != null) {
            F0();
            bundle.getBoolean(RouteGuideParams.RGKey.ExpandMap.UpdateProgress);
            String string = bundle.getString("road_name");
            int i = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.TotalDist);
            int i2 = bundle.getInt(RouteGuideParams.RGKey.ExpandMap.RemainDist);
            String string2 = bundle.getString(RouteGuideParams.RGKey.ExpandMap.RasterType);
            int i3 = 100;
            if (i2 > 0 && i > 0) {
                i3 = ((i - i2) * 100) / i;
            }
            if (gVar.d()) {
                gVar.e(N, "!# mRoadName=" + string + ", " + string2);
                gVar.e(N, "!# Raster Pos = " + i3 + " Total = " + i + " Rem = " + i2 + ", pos = " + i3);
            }
            int i4 = (RouteGuideParams.RasterType.VECTOR.equals(string2) || RouteGuideParams.RasterType.DIRECT_BOARD.equals(string2) || RouteGuideParams.RasterType.GRID.equals(string2) || RouteGuideParams.RasterType.COMMON_WINDOW.equals(string2)) ? bundle.getInt("resid", 0) : 0;
            a(i2, string2, i3, bundle.getBoolean("remain_dist_hide", false));
            a(string, string2);
            a(string2, i4);
        }
    }

    private void f(Bundle bundle) {
        TextView textView;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(N, "updateSimpleGuideData , b = " + bundle.toString());
        }
        if (w(4)) {
            if (bundle == null) {
                if (gVar.d()) {
                    gVar.e(N, "updateData --> bundle==null");
                    return;
                }
                return;
            }
            I0();
            boolean z = bundle.getBoolean("remain_dist_hide", false);
            if (bundle.getInt("updatetype") == 1) {
                int i = bundle.getInt("resid", 0);
                int i2 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0);
                String string = bundle.getString("road_name");
                if (gVar.d()) {
                    gVar.e(N, "updateData! --> nextRoadName = " + string);
                }
                if (string == null || string.length() == 0) {
                    string = JarUtils.getResources().getString(R.string.nsdk_string_navi_no_name_road);
                }
                new Bundle().putString("next_road_name", string);
                if (i != 0 && this.s != null) {
                    try {
                        if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
                            this.s.setImageDrawable(JarUtils.getResources().getDrawable(i));
                        } else {
                            this.s.setImageDrawable(com.baidu.navisdk.ui.routeguide.subview.util.b.a(i));
                        }
                    } catch (OutOfMemoryError unused) {
                    }
                }
                String a2 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(i2);
                String b2 = com.baidu.navisdk.ui.routeguide.model.a0.I().b(a2);
                String a3 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(a2);
                TextView textView2 = this.q;
                if (textView2 != null && this.r != null && b2 != null && a3 != null) {
                    if (!z) {
                        textView2.setText(b2);
                        this.r.setText(a3);
                    } else {
                        textView2.setText("现在");
                        this.r.setText("");
                    }
                }
                String c2 = com.baidu.navisdk.ui.routeguide.model.a0.I().c(string);
                if (c2 != null && (textView = this.u) != null && !textView.getText().equals(c2)) {
                    this.u.setText(c2);
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e(N, "mGoWhereInfoTV.setText --> " + c2);
                    }
                }
                TextView textView3 = this.I;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                TextView textView4 = this.v;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
                if (this.t != null) {
                    if ("目的地".equals(string)) {
                        this.t.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_arrive));
                    } else {
                        this.t.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_enter));
                    }
                }
            }
        }
    }

    private void y(boolean z) {
        Drawable f = z ? com.baidu.navisdk.ui.routeguide.model.a0.I().f() : null;
        if (f != null) {
            com.baidu.navisdk.ui.routeguide.control.x.b().a(f);
            com.baidu.navisdk.ui.routeguide.model.a0.I().i(true);
            com.baidu.navisdk.ui.routeguide.control.x.b().M0();
            com.baidu.navisdk.ui.routeguide.control.x.b().r(0);
            return;
        }
        D0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        A0();
        if (i == 1) {
            com.baidu.navisdk.ui.routeguide.control.x.b().s3();
            J0();
        }
        BNVoiceView bNVoiceView = this.o;
        if (bNVoiceView != null) {
            bNVoiceView.a();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            String str = N;
            StringBuilder sb = new StringBuilder();
            sb.append("show - bundle = ");
            sb.append(bundle == null ? "null" : bundle.toString());
            gVar.e(str, sb.toString());
        }
        if (this.j == null) {
            if (gVar.d()) {
                gVar.e(N, "mXDVoiceContainer == null,重新执行init()");
            }
            z0();
            return false;
        }
        if (this.o != null) {
            com.baidu.navisdk.asr.d.B().a(this.o);
        }
        this.j.setVisibility(0);
        if (gVar.d()) {
            gVar.e(N, "setVisible() -  getPanelFuseStatus : " + o0());
        }
        if (this.L) {
            ViewGroup viewGroup = this.j;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            if (this.k != null && com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
                this.k.setVisibility(0);
            }
            BNVoiceView bNVoiceView = this.o;
            if (bNVoiceView != null) {
                bNVoiceView.setVisibility(0);
            }
        } else {
            q0();
        }
        J0();
        this.L = true;
        super.b(bundle);
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(N, "hide");
        }
        super.c();
        y0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_voice_panel_guide_info));
        }
        BNVoiceView bNVoiceView = this.o;
        if (bNVoiceView != null) {
            bNVoiceView.setVoicePanelBackground(com.baidu.navisdk.ui.routeguide.control.x.b().s2());
        }
    }

    public void a(int i, Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            String str = N;
            StringBuilder sb = new StringBuilder();
            sb.append("RGXDVoiceView updateData dataType = ");
            sb.append(i);
            sb.append(", b = ");
            sb.append(bundle == null ? "null" : bundle.toString());
            gVar.e(str, sb.toString());
        }
        if (!com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            if (gVar.d()) {
                gVar.e(N, "当前时横屏，不允许更新数据");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().P2()) {
            if (gVar.d()) {
                gVar.e(N, "updateData isVdrLowPrecisionGuide");
            }
            A(i == 3);
        } else {
            if (com.baidu.navisdk.ui.routeguide.control.x.b().Q2()) {
                z(false);
                return;
            }
            u0();
            if (i == 1) {
                e(bundle);
                return;
            }
            if (i == 2) {
                z(true);
            } else if (i == 3) {
                K0();
            } else {
                f(bundle);
            }
        }
    }

    public void b(Drawable drawable) {
        ImageView imageView = this.B;
        if (imageView == null || drawable == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    private void a(String str, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(N, "updateEnlargeTurnIcon");
        }
        if (this.s == null) {
            return;
        }
        if ((!RouteGuideParams.RasterType.VECTOR.equals(str) && !RouteGuideParams.RasterType.DIRECT_BOARD.equals(str) && !RouteGuideParams.RasterType.GRID.equals(str) && !RouteGuideParams.RasterType.COMMON_WINDOW.equals(str)) || i == 0 || i == R.drawable.nsdk_drawable_rg_ic_turn_via_1) {
            return;
        }
        this.s.setVisibility(0);
        try {
            if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
                this.s.setImageDrawable(JarUtils.getResources().getDrawable(i));
            } else {
                this.s.setImageDrawable(com.baidu.navisdk.ui.routeguide.subview.util.b.a(i));
            }
        } catch (Throwable unused) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(N, "updateTurnIcon setImageDrawable throwable");
            }
        }
    }

    private void a(String str, String str2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(N, "updateRoadInfo, roadName=" + str);
        }
        if (this.u != null && this.t != null) {
            x0();
            if (!TextUtils.isEmpty(this.J) && !TextUtils.isEmpty(this.K)) {
                this.I.setVisibility(0);
                this.I.setText(this.J);
                this.t.setText(JarUtils.getResources().getString(R.string.nsdk_string_hw_go));
                this.u.setMaxWidth(w0());
                String str3 = this.K + O;
                this.K = str3;
                this.u.setText(str3);
                v(8);
                return;
            }
            this.u.setMaxWidth(Integer.MAX_VALUE);
            this.I.setVisibility(8);
            if (!RouteGuideParams.RasterType.VECTOR.equals(str2) && !RouteGuideParams.RasterType.DIRECT_BOARD.equals(str2) && !RouteGuideParams.RasterType.GRID.equals(str2) && !RouteGuideParams.RasterType.COMMON_WINDOW.equals(str2)) {
                if (RouteGuideParams.RasterType.STREET.equals(str2)) {
                    this.t.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_arrive));
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.u.setText(str);
                    return;
                }
                return;
            }
            this.t.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_enter));
            if (!TextUtils.isEmpty(str)) {
                this.u.setText(str);
                return;
            } else {
                this.u.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_no_name_road));
                return;
            }
        }
        if (gVar.d()) {
            gVar.e(N, "updateRoadInfo fail view is null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(int r9, java.lang.String r10, int r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.subview.h1.a(int, java.lang.String, int, boolean):void");
    }
}

package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class y0 extends com.baidu.navisdk.ui.routeguide.widget.a {
    private ViewGroup i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private TextView r;
    private ImageView s;
    private Animation t;
    private View u;
    private boolean v;
    private com.baidu.navisdk.pronavi.ui.guidepanel.a w;
    private com.baidu.navisdk.pronavi.ui.guidepanel.b x;
    private Animation y;
    private Animation z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a(y0 y0Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b(y0 y0Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.navisdk.module.newguide.a.e().d()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGMMSimpleModeGuideView", "onClick: mTurnIcon");
                    return;
                }
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.control.x.b().n2()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGMMSimpleModeGuideView", "isInterceptToHUDModeOnVdr");
                    return;
                }
                return;
            }
            if (!com.baidu.navisdk.function.b.FUNC_HUD.a()) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.a()) {
                    gVar2.a("RGMMSimpleModeGuideView", "onClickToHudMode FUNC_HUD.isEnable() false");
                    return;
                }
                return;
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
    }

    /* loaded from: classes8.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMSimpleModeGuideView", "随后-startNextTurnExitAnim onAnimationEnd, getNextTurnVisible（） = " + com.baidu.navisdk.ui.routeguide.model.a0.I().i());
            }
            y0.this.w(8);
            com.baidu.navisdk.ui.routeguide.control.x.b().N3();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            LogUtil.e("RGMMSimpleModeGuideView", "随后-startNextTurnExitAnim onAnimationStart");
        }
    }

    public y0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.v = false;
        this.y = null;
        this.z = null;
        I0();
    }

    private void F0() {
        Animation animation = this.y;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.z;
        if (animation2 != null) {
            animation2.cancel();
        }
    }

    private void G0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "default simple exitVdrLowPrecisionGuide: ");
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.c();
        }
        View view = this.u;
        if (view != null && view.getVisibility() != 0) {
            this.u.setVisibility(0);
        }
    }

    private Animation H0() {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        scaleAnimation.setDuration(550L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(550L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private void I0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            LogUtil.e("RGMMSimpleModeGuideView", "mRootViewGroup == null");
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.bnav_rg_simple_mode_guide_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(R.id.bnav_rg_simple_model_guide_panel);
        this.i = viewGroup2;
        if (viewGroup2 == null) {
            LogUtil.e("RGMMSimpleModeGuideView", "mSimpleModeGuideView == null");
            return;
        }
        viewGroup2.setOnClickListener(new a(this));
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.a();
        }
        this.x = new com.baidu.navisdk.pronavi.ui.guidepanel.b(this.f9165a, this.i, null);
        this.k = (LinearLayout) this.i.findViewById(R.id.bnav_rg_loading_bar_layout);
        this.j = (LinearLayout) this.i.findViewById(R.id.bnav_rg_guide_info_layout);
        this.l = (LinearLayout) this.i.findViewById(R.id.bnav_rg_next_turn_layout);
        this.m = (ImageView) this.i.findViewById(R.id.bnav_rg_turn_icon);
        this.n = (TextView) this.i.findViewById(R.id.bnav_rg_indoor_floor_icon);
        this.o = (TextView) this.i.findViewById(R.id.bnav_rg_distance_num_text);
        this.p = (TextView) this.i.findViewById(R.id.bnav_rg_after_label_info);
        this.q = (ImageView) this.i.findViewById(R.id.bnav_rg_progress_cycle);
        this.r = (TextView) this.i.findViewById(R.id.bnav_rg_loading_info);
        this.u = this.i.findViewById(R.id.bnav_rg_simple_info_layout);
        this.s = (ImageView) this.i.findViewById(R.id.bnav_rg_sg_next_turn_icon);
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.a aVar = this.w;
        if (aVar == null) {
            this.w = new com.baidu.navisdk.pronavi.ui.guidepanel.a("CommonSimpleGuide", this.i);
        } else {
            aVar.a(this.i);
        }
        this.w.a();
    }

    private void J0() {
        boolean z;
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null && bVar.g()) {
            z = true;
        } else {
            z = false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "default simple intoVdrLowPrecisionGuide: " + z);
        }
        View view = this.u;
        if (view != null && view.getVisibility() != 8) {
            this.u.setVisibility(8);
        }
        if (!z) {
            ImageView imageView = this.m;
            if (imageView != null) {
                try {
                    imageView.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_rg_ic_turn_along));
                } catch (Throwable unused) {
                }
            }
            E0();
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar2 = this.x;
        if (bVar2 != null) {
            bVar2.f();
        }
    }

    private void K0() {
        a(true, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_carlogo_free));
        if (!com.baidu.navisdk.ui.routeguide.model.a0.I().v()) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_NAVI_READY);
        }
    }

    private void L0() {
        String string;
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().u) {
            string = JarUtils.getResources().getString(R.string.nsdk_string_rg_is_wait_recalc_route);
        } else {
            string = JarUtils.getResources().getString(R.string.nsdk_string_rg_is_preparing_nav);
        }
        a(false, string);
    }

    public void A(boolean z) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.b(z);
        }
    }

    public void A0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMSimpleModeGuideView", "simple default openVdrLocationMode: ");
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.h();
        }
    }

    public void B(boolean z) {
        this.v = z;
        if (z) {
            c();
        } else {
            y();
        }
    }

    public void B0() {
        if (this.i != null && j0()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_panel_margin_top);
            if (marginLayoutParams != null && marginLayoutParams.topMargin != dimensionPixelOffset) {
                marginLayoutParams.topMargin = dimensionPixelOffset;
                this.i.requestLayout();
            }
        }
    }

    public void C0() {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void D0() {
        LinearLayout linearLayout;
        Object obj;
        Animation animation = this.z;
        if (animation != null && animation.hasStarted() && !this.z.hasEnded()) {
            this.z.cancel();
        }
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("随后-NextTurnAnim - startNextTurnEnterAnim, mNextTurnLayout.getVisibility() = ");
            LinearLayout linearLayout2 = this.l;
            if (linearLayout2 != null) {
                obj = Integer.valueOf(linearLayout2.getVisibility());
            } else {
                obj = "null";
            }
            sb.append(obj);
            LogUtil.e("RGMMSimpleModeGuideView", sb.toString());
        }
        if (com.baidu.navisdk.framework.a.c().a() != null && (linearLayout = this.l) != null && linearLayout.getVisibility() != 0) {
            Animation animation2 = this.y;
            if (animation2 != null && animation2.hasStarted() && !this.y.hasEnded()) {
                LogUtil.e("RGMMSimpleModeGuideView", "随后-enterNextTurnAnim running! ,return");
                return;
            }
            w(0);
            com.baidu.navisdk.ui.routeguide.control.x.b().M0();
            this.y = JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_rg_land_next_turn_enter);
            this.l.clearAnimation();
            this.l.startAnimation(this.y);
        }
    }

    public void E0() {
        LinearLayout linearLayout;
        Object obj;
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("随后-startNextTurnExitAnim - getVisibility() = ");
            LinearLayout linearLayout2 = this.l;
            if (linearLayout2 != null) {
                obj = Integer.valueOf(linearLayout2.getVisibility());
            } else {
                obj = "null";
            }
            sb.append(obj);
            LogUtil.e("RGMMSimpleModeGuideView", sb.toString());
        }
        Animation animation = this.y;
        if (animation != null && animation.hasStarted() && !this.y.hasEnded()) {
            this.y.cancel();
        }
        if (com.baidu.navisdk.framework.a.c().a() != null && (linearLayout = this.l) != null && linearLayout.getVisibility() == 0) {
            Animation animation2 = this.z;
            if (animation2 != null && animation2.hasStarted() && !this.z.hasEnded()) {
                LogUtil.e("RGMMSimpleModeGuideView", "随后-exitNextTurnAnim running! - return");
                return;
            }
            LogUtil.e("RGMMSimpleModeGuideView", "随后-startNextTurnExitAnim!");
            Animation loadAnimation = JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_rg_land_next_turn_exit);
            this.z = loadAnimation;
            if (loadAnimation != null) {
                loadAnimation.setAnimationListener(new c());
                this.l.clearAnimation();
                this.l.startAnimation(this.z);
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().N3();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        boolean b2 = super.b(bundle);
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.i();
        }
        return b2;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c(Bundle bundle) {
        super.c(bundle);
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        int i;
        String str;
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateData = ");
            if (bundle != null) {
                str = bundle.toString();
            } else {
                str = "null";
            }
            sb.append(str);
            LogUtil.e("RGMMSimpleModeGuideView", sb.toString());
        }
        if (bundle == null) {
            LogUtil.e("RGMMSimpleModeGuideView", "updateData --> bundle==null");
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D() && !com.baidu.navisdk.ui.routeguide.model.a0.I().r()) {
            LogUtil.e("RGMMSimpleModeGuideView", "Yawing now! cannot updateData!");
            if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
                i = R.string.nsdk_string_indoor_nav_route_plan_yawing_text;
            } else {
                i = R.string.nsdk_string_rg_nav_route_plan_yawing_text;
            }
            f(JarUtils.getResources().getString(i));
            return;
        }
        int i2 = bundle.getInt("updatetype");
        if (com.baidu.navisdk.ui.routeguide.control.x.b().P2()) {
            J0();
        } else {
            boolean z = true;
            if (i2 == 1) {
                G0();
                int i3 = bundle.getInt("resid", 0);
                bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.StartDist, 1);
                int i4 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0);
                String string = bundle.getString("road_name");
                LogUtil.e("RGMMSimpleModeGuideView", "updateData! --> nextRoadName = " + string);
                if (string == null || string.length() == 0) {
                    string = JarUtils.getResources().getString(R.string.nsdk_string_navi_no_name_road);
                }
                int i5 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TurnKind, 0);
                ImageView imageView = this.m;
                if (imageView != null && this.n != null) {
                    if (i5 == 70) {
                        imageView.setVisibility(8);
                        this.n.setVisibility(0);
                        this.n.setBackground(JarUtils.getResources().getDrawable(R.drawable.bnav_bg_indoor_floor_icon));
                        this.n.setText(bundle.getString(RouteGuideParams.RGKey.SimpleGuideInfo.IndoorParkFloor));
                    } else if (i3 != 0) {
                        imageView.setVisibility(0);
                        this.n.setVisibility(8);
                        try {
                            if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
                                Drawable drawable = JarUtils.getResources().getDrawable(i3);
                                this.m.setImageDrawable(drawable);
                                if (drawable == null) {
                                    com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1359", "3", "2");
                                }
                            } else {
                                this.m.setImageDrawable(com.baidu.navisdk.ui.routeguide.subview.util.b.a(i3));
                            }
                        } catch (OutOfMemoryError unused) {
                        }
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.3.1359", "3", "0");
                    }
                }
                boolean z2 = bundle.getBoolean("remain_dist_hide", false);
                if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
                    if (i4 > 5) {
                        z = false;
                    }
                } else {
                    z = z2;
                }
                String a2 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(i4);
                String b2 = com.baidu.navisdk.ui.routeguide.model.a0.I().b(a2);
                String a3 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(a2);
                TextView textView = this.o;
                if (textView != null && this.p != null) {
                    String str2 = "";
                    if (b2 != null && a3 != null) {
                        if (!z) {
                            textView.setText(b2);
                            this.p.setText(a3);
                        } else if (i5 == 70) {
                            textView.setText("");
                            this.p.setText("即将进入");
                        } else {
                            textView.setText("现在");
                            this.p.setText("");
                            a3 = "";
                        }
                    }
                    if ("目的地".equals(string)) {
                        if (b2 != null && a3 != null) {
                            str2 = a3;
                        }
                        this.o.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_text_size_simple_mode_guide));
                        this.p.setText(str2);
                    } else {
                        this.o.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_text_size_simple_mode_guide));
                    }
                }
            }
        }
        n0();
        A(com.baidu.navisdk.ui.routeguide.model.a0.I().s);
        t0();
        if (!com.baidu.navisdk.module.newguide.a.e().d() && com.baidu.navisdk.ui.routeguide.b.V().i().c() != null) {
            y(com.baidu.navisdk.ui.routeguide.b.V().i().c().n().size());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void f(String str) {
        a(true, str);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        F0();
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void o0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.isShown()) {
            Animation H0 = H0();
            ImageView imageView = this.m;
            if (imageView != null && this.o != null && this.p != null) {
                imageView.clearAnimation();
                this.o.clearAnimation();
                this.p.clearAnimation();
                this.m.startAnimation(H0);
                this.o.startAnimation(H0);
                this.p.startAnimation(H0);
            }
            LinearLayout linearLayout = this.l;
            if (linearLayout != null && linearLayout.isShown()) {
                this.l.startAnimation(H0);
            }
            com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
            if (bVar != null) {
                bVar.a(H0);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public View p0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMSimpleModeGuideView", "getCurrentPanelView() mSimpleModeGuideView:" + this.i);
        }
        return this.i;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public int q0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            return viewGroup.getBottom();
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_height);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void s0() {
        L0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void t0() {
        ImageView imageView;
        int i;
        try {
            if (!com.baidu.navisdk.ui.routeguide.b.V().x() && !com.baidu.navisdk.ui.routeguide.model.a0.I().t) {
                L0();
                LogUtil.e("RGMMSimpleModeGuideView", "SimpleModeGuideView - hasCalcRouteOk -- > false ,  cannot updateData!");
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.model.a0.I().D() && !com.baidu.navisdk.ui.routeguide.model.a0.I().r()) {
                LogUtil.e("RGMMSimpleModeGuideView", "SimpleModeGuideView - Yawing now! cannot updateData!");
                if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
                    i = R.string.nsdk_string_indoor_nav_route_plan_yawing_text;
                } else {
                    i = R.string.nsdk_string_rg_nav_route_plan_yawing_text;
                }
                f(JarUtils.getResources().getString(i));
                return;
            }
            int i2 = com.baidu.navisdk.module.pronavi.a.j;
            if ((i2 == 1 || i2 == 5) && com.baidu.navisdk.ui.routeguide.model.a0.I().q()) {
                LogUtil.e("RGMMSimpleModeGuideView", "SimpleModeGuideView - not data route, showCarlogoFreeView!");
                K0();
                return;
            }
            x0();
            if (com.baidu.navisdk.ui.routeguide.model.a0.I().C() && (imageView = this.m) != null) {
                try {
                    imageView.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_rg_ic_turn_along));
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            LogUtil.e("RGMMSimpleModeGuideView", th.toString());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void u0() {
        if (com.baidu.navisdk.ui.routeguide.control.x.b().O2()) {
            A0();
        }
        d(com.baidu.navisdk.ui.routeguide.model.a0.I().h());
        d(com.baidu.navisdk.ui.routeguide.model.a0.I().k());
        com.baidu.navisdk.ui.routeguide.control.x.b().E(com.baidu.navisdk.ui.routeguide.model.a0.I().j());
        t0();
    }

    public void v(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams()) != null && marginLayoutParams.topMargin != i) {
            marginLayoutParams.topMargin = i;
            this.i.setLayoutParams(marginLayoutParams);
        }
    }

    public void w(int i) {
        boolean z;
        if (this.l != null) {
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("随后-setNextTurnVisible - visible=");
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                LogUtil.e("RGMMSimpleModeGuideView", sb.toString());
            }
            this.l.setVisibility(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public int w0() {
        return ScreenUtil.getInstance().dip2px(180);
    }

    public void x(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INDOOR_PARK;
        if (gVar.d()) {
            gVar.e("RGMMSimpleModeGuideView", "signal = " + i);
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public void x0() {
        LinearLayout linearLayout = this.k;
        if (linearLayout != null && linearLayout.getVisibility() == 0 && this.q != null) {
            LogUtil.e("RGMMSimpleModeGuideView", "simpleModeGuideView dismissProgressView - mLoadingBarLayout.setVisibility(View.GONE)");
            this.q.clearAnimation();
            this.k.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.j;
        if (linearLayout2 != null && linearLayout2.getVisibility() != 0) {
            LogUtil.e("RGMMSimpleModeGuideView", "simpleModeGuideView dismissProgressView - mGuideInfoLayout.setVisibility(View.VISIBLE)");
            this.j.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.v) {
            return false;
        }
        super.y();
        LogUtil.e("RGMMSimpleModeGuideView", "show() - mSimpleModeGuideView = " + this.i);
        if (this.i == null) {
            LogUtil.e("RGMMSimpleModeGuideView", "mSimpleModeGuideView == null , 重新 initviews()");
            I0();
        } else {
            com.baidu.navisdk.pronavi.ui.guidepanel.a aVar = this.w;
            if (aVar != null) {
                aVar.a();
            }
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        u0();
        return true;
    }

    public void y0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMSimpleModeGuideView", "simple default exitVdrLocationMode: ");
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void z(boolean z) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public void z0() {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void a(boolean z, String str) {
        LogUtil.e("RGMMSimpleModeGuideView", "SimpleModeGuideView - showProgressView() isYawing=" + z + ", text=" + str);
        LinearLayout linearLayout = this.j;
        if (linearLayout == null || this.k == null || this.q == null || this.r == null) {
            return;
        }
        linearLayout.setVisibility(8);
        this.k.setVisibility(0);
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        if (z && com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
            this.q.clearAnimation();
            this.q.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_rg_indoor_yawing));
        } else {
            if (this.q.getAnimation() != null && this.q.getAnimation().hasStarted() && !this.q.getAnimation().hasEnded()) {
                return;
            }
            this.q.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.bnav_common_progress_cycle));
            if (this.t == null) {
                this.t = com.baidu.navisdk.ui.util.b.b(this.f9165a, R.anim.nsdk_anim_satellite_progress_wait);
            }
            this.t.setInterpolator(new LinearInterpolator());
            if (this.t != null) {
                this.q.clearAnimation();
                this.q.startAnimation(this.t);
            }
        }
        if (this.r != null) {
            if (!com.baidu.navisdk.util.common.l0.c(str)) {
                this.r.setText(str);
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        LogUtil.e("RGMMSimpleModeGuideView", "hide() - mSimpleModeGuideView = " + this.i);
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void y(int i) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    public void a(Drawable drawable) {
        ImageView imageView;
        if (drawable == null || (imageView = this.s) == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    public void a(Drawable drawable, String str, int i) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.x;
        if (bVar != null) {
            bVar.a(drawable, str, i);
        }
    }
}

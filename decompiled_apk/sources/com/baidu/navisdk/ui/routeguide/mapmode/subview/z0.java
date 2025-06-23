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
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class z0 extends com.baidu.navisdk.ui.routeguide.widget.b {
    private ViewGroup i;
    private ViewGroup j;
    private ImageView k;
    private TextView l;
    private TextView m;
    private View n;
    private com.baidu.navisdk.pronavi.ui.guidepanel.a o;
    private com.baidu.navisdk.pronavi.ui.guidepanel.b p;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a(z0 z0Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b(z0 z0Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.navisdk.module.newguide.a.e().d()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGMMSimpleModeHighwayView", "onClick: mExitTurnIcon");
                    return;
                }
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.control.x.b().n2()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGMMSimpleModeHighwayView", "isInterceptToHUDModeOnVdr");
                    return;
                }
                return;
            }
            if (!com.baidu.navisdk.function.b.FUNC_HUD.a()) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.a()) {
                    gVar2.a("RGMMSimpleModeHighwayView", "onClickToHudMode FUNC_HUD.isEnable() false");
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

    public z0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        A0();
    }

    private void A0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            LogUtil.e("RGMMSimpleModeHighwayView", "mRootViewGroup == null");
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.bnav_rg_simple_mode_highway_view_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(R.id.bnav_rg_simple_model_highway_view);
        this.i = viewGroup2;
        if (viewGroup2 == null) {
            LogUtil.e("RGMMSimpleModeHighwayView", "mSimpleModeHighwayView viewStub == null");
            return;
        }
        viewGroup2.setOnClickListener(new a(this));
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.a();
        }
        this.p = new com.baidu.navisdk.pronavi.ui.guidepanel.b(this.f9165a, this.i, null);
        this.k = (ImageView) this.i.findViewById(R.id.bnav_rg_turn_icon);
        this.l = (TextView) this.i.findViewById(R.id.bnav_rg_distance_num_text);
        this.m = (TextView) this.i.findViewById(R.id.bnav_rg_after_label_info);
        ViewGroup viewGroup3 = (ViewGroup) this.i.findViewById(R.id.bnav_rg_guide_info_layout);
        this.j = viewGroup3;
        viewGroup3.setVisibility(0);
        this.k.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_rg_ic_turn_along));
        this.n = this.i.findViewById(R.id.bnav_rg_simple_info_layout);
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
        x0();
        if (com.baidu.navisdk.ui.routeguide.control.x.b().O2()) {
            t0();
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.a aVar = this.o;
        if (aVar == null) {
            this.o = new com.baidu.navisdk.pronavi.ui.guidepanel.a("HighwaySimpleGuide", this.i);
        } else {
            aVar.a(this.i);
        }
        this.o.a();
    }

    private void B0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "highway simple intoVdrLowPrecisionGuide: ");
        }
        View view = this.n;
        if (view != null && view.getVisibility() != 8) {
            this.n.setVisibility(8);
        }
    }

    private void y0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "highway simple exitVdrLowPrecisionGuide: ");
        }
        View view = this.n;
        if (view != null && view.getVisibility() != 0) {
            this.n.setVisibility(0);
        }
    }

    private Animation z0() {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        scaleAnimation.setDuration(550L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(550L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        boolean b2 = super.b(bundle);
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.i();
        }
        return b2;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c(Bundle bundle) {
        super.c(bundle);
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        String j = com.baidu.navisdk.ui.routeguide.model.m.y().j();
        String b2 = com.baidu.navisdk.ui.routeguide.model.a0.I().b(j);
        String a2 = com.baidu.navisdk.ui.routeguide.model.a0.I().a(j);
        if (com.baidu.navisdk.ui.routeguide.model.m.y().a() == null) {
            TextView textView = this.l;
            if (textView != null) {
                textView.setText(b2);
            }
            TextView textView2 = this.m;
            if (textView2 != null) {
                textView2.setText(a2);
            }
        } else {
            TextView textView3 = this.l;
            if (textView3 != null && this.m != null && b2 != null && a2 != null) {
                textView3.setText(b2);
                if ("米".equals(a2)) {
                    a2 = a2 + "后";
                }
                this.m.setText(a2);
            }
        }
        y(com.baidu.navisdk.ui.routeguide.model.a0.I().s);
        if (!com.baidu.navisdk.module.newguide.a.e().d() && com.baidu.navisdk.ui.routeguide.b.V().i().c() != null) {
            x(com.baidu.navisdk.ui.routeguide.b.V().i().c().n().size());
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().P2()) {
            B0();
        } else {
            y0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.k = null;
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public void n0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.isShown()) {
            Animation z0 = z0();
            ImageView imageView = this.k;
            if (imageView != null && this.l != null && this.m != null) {
                imageView.clearAnimation();
                this.l.clearAnimation();
                this.m.clearAnimation();
                this.k.startAnimation(z0);
                this.l.startAnimation(z0);
                this.m.startAnimation(z0);
            }
            com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
            if (bVar != null) {
                bVar.a(z0);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public View o0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMSimpleModeHighwayView", "getCurrentPanelView() mSimpleModeHighwayView:" + this.i);
        }
        return this.i;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.b
    public int p0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            return viewGroup.getBottom();
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_height);
    }

    public void r0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMSimpleModeHighwayView", "simple highway exitVdrLocationMode: ");
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void s0() {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void t0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMSimpleModeHighwayView", "simple highway openVdrLocationMode: ");
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.h();
        }
    }

    public void u0() {
        if (this.i != null && j0()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_panel_margin_top);
            if (marginLayoutParams != null && marginLayoutParams.topMargin != dimensionPixelOffset) {
                marginLayoutParams.topMargin = dimensionPixelOffset;
                this.i.requestLayout();
            }
        }
    }

    public void w(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams()) != null && marginLayoutParams.topMargin != i) {
            marginLayoutParams.topMargin = i;
            this.i.requestLayout();
        }
    }

    public void w0() {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void x(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMSimpleModeHighwayView", "updateServiceAreaSubscribeNum: " + i);
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    public void x0() {
        d(null);
        com.baidu.navisdk.ui.routeguide.control.x.b().E(com.baidu.navisdk.ui.routeguide.model.a0.I().j());
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSimpleModeHighwayView", "show() - mSimpleModeHighwayView = " + this.i);
        }
        if (this.i == null) {
            LogUtil.e("RGMMSimpleModeHighwayView", "mSimpleModeHighwayView == null , 重新 initviews()");
            A0();
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        x0();
        return true;
    }

    public void a(Drawable drawable, String str, int i) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.a(drawable, str, i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMSimpleModeHighwayView", "hide() - mSimpleModeHighwayView = " + this.i);
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void y(boolean z) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.p;
        if (bVar != null) {
            bVar.b(z);
        }
    }
}

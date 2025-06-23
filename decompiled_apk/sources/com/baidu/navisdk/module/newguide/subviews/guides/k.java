package com.baidu.navisdk.module.newguide.subviews.guides;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class k extends com.baidu.navisdk.module.newguide.subviews.guides.b {
    private ViewGroup i;
    private LinearLayout j;
    private ImageView k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private View o;
    private boolean p;
    private com.baidu.navisdk.pronavi.style.i.a q;
    private com.baidu.navisdk.pronavi.ui.guidepanel.b r;
    private Animation s;
    private Animation t;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a(k kVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b(k kVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleModeExitMainRoa", "onClick:mTurnIcon ");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LogUtil.e("RGSimpleModeExitMainRoa", "随后-startNextTurnExitAnim onAnimationEnd, getNextTurnVisible（） = " + a0.I().i());
            k.this.w(8);
            x.b().N3();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            LogUtil.e("RGSimpleModeExitMainRoa", "随后-startNextTurnExitAnim onAnimationStart");
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.pronavi.style.c {
        public d(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGSimpleExitMainRoadGuide";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(@oOoXoXO String str) {
            k.this.L0();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            b(k.this.i);
        }
    }

    public k(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.p = false;
        this.s = null;
        this.t = null;
        I0();
    }

    private void F0() {
        Animation animation = this.s;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.t;
        if (animation2 != null) {
            animation2.cancel();
        }
    }

    private void G0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "default simple exitVdrLowPrecisionGuide: ");
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.c();
        }
        View view = this.o;
        if (view != null && view.getVisibility() != 0) {
            this.o.setVisibility(0);
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
            LogUtil.e("RGSimpleModeExitMainRoa", "mRootViewGroup == null");
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.bnav_rg_simple_mode_exit_main_road_stub);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Exception e) {
                e.printStackTrace();
                if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                    com.baidu.navisdk.util.common.g.PRO_NAV.e("RGSimpleModeExitMainRoa", "initView Exception: " + e);
                }
            }
        }
        ViewGroup viewGroup2 = (ViewGroup) this.b.findViewById(R.id.bnav_rg_simple_model_exit_main_road_panel);
        this.i = viewGroup2;
        if (viewGroup2 == null) {
            LogUtil.e("RGSimpleModeExitMainRoa", "mSimpleModeGuideView == null");
            return;
        }
        M0();
        this.i.setOnClickListener(new a(this));
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.a();
        }
        this.r = new com.baidu.navisdk.pronavi.ui.guidepanel.b(this.f9165a, this.i, null);
        this.j = (LinearLayout) this.i.findViewById(R.id.bnav_rg_next_turn_layout);
        this.k = (ImageView) this.i.findViewById(R.id.bnav_rg_turn_icon);
        this.l = (TextView) this.i.findViewById(R.id.bnav_rg_distance_num_text);
        this.m = (TextView) this.i.findViewById(R.id.bnav_rg_after_label_info);
        this.n = (ImageView) this.i.findViewById(R.id.bnav_rg_sg_next_turn_icon);
        this.o = this.i.findViewById(R.id.bnav_rg_simple_info_layout);
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
        K0();
    }

    private void J0() {
        boolean z;
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null && bVar.g()) {
            z = true;
        } else {
            z = false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "default simple intoVdrLowPrecisionGuide: " + z);
        }
        View view = this.o;
        if (view != null && view.getVisibility() != 8) {
            this.o.setVisibility(8);
        }
        if (!z) {
            ImageView imageView = this.k;
            if (imageView != null) {
                try {
                    imageView.setImageDrawable(JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_rg_ic_turn_along));
                } catch (Throwable unused) {
                }
            }
            E0();
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar2 = this.r;
        if (bVar2 != null) {
            bVar2.f();
        }
    }

    private void K0() {
        if (this.q == null) {
            d dVar = new d(new Integer[0]);
            this.q = dVar;
            com.baidu.navisdk.pronavi.style.f.b.a("RGSimpleExitRoad", dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        Drawable background;
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && (background = viewGroup.getBackground()) != null) {
            background.setAlpha(255);
        }
    }

    private void M0() {
        if (this.i != null) {
            com.baidu.navisdk.module.newguide.a.e().a(this.i, R.drawable.bn_bg_rg_exit_main_road_simple_guide_view);
        }
    }

    public void A(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleModeExitMainRoa", "updateVolumeView: " + z);
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.b(z);
        }
    }

    public void A0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleModeExitMainRoa", "simple default openVdrLocationMode: ");
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.h();
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
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.j();
        }
    }

    public void D0() {
        Object obj;
        LinearLayout linearLayout;
        Animation animation = this.t;
        if (animation != null && animation.hasStarted() && !this.t.hasEnded()) {
            this.t.cancel();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("随后-NextTurnAnim - startNextTurnEnterAnim, mNextTurnLayout.getVisibility() = ");
        LinearLayout linearLayout2 = this.j;
        if (linearLayout2 != null) {
            obj = Integer.valueOf(linearLayout2.getVisibility());
        } else {
            obj = "null";
        }
        sb.append(obj);
        LogUtil.e("RGSimpleModeExitMainRoa", sb.toString());
        if (com.baidu.navisdk.framework.a.c().a() != null && (linearLayout = this.j) != null && linearLayout.getVisibility() != 0) {
            Animation animation2 = this.s;
            if (animation2 != null && animation2.hasStarted() && !this.s.hasEnded()) {
                LogUtil.e("RGSimpleModeExitMainRoa", "随后-enterNextTurnAnim running! ,return");
                return;
            }
            w(0);
            x.b().M0();
            this.s = JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_rg_land_next_turn_enter);
            this.j.clearAnimation();
            this.j.startAnimation(this.s);
        }
    }

    public void E0() {
        LinearLayout linearLayout;
        Object obj;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("随后-startNextTurnExitAnim - getVisibility() = ");
            LinearLayout linearLayout2 = this.j;
            if (linearLayout2 != null) {
                obj = Integer.valueOf(linearLayout2.getVisibility());
            } else {
                obj = "null";
            }
            sb.append(obj);
            gVar.e("RGSimpleModeExitMainRoa", sb.toString());
        }
        Animation animation = this.s;
        if (animation != null && animation.hasStarted() && !this.s.hasEnded()) {
            this.s.cancel();
        }
        if (com.baidu.navisdk.framework.a.c().a() != null && (linearLayout = this.j) != null && linearLayout.getVisibility() == 0) {
            Animation animation2 = this.t;
            if (animation2 != null && animation2.hasStarted() && !this.t.hasEnded()) {
                LogUtil.e("RGSimpleModeExitMainRoa", "随后-exitNextTurnAnim running! - return");
                return;
            }
            LogUtil.e("RGSimpleModeExitMainRoa", "随后-startNextTurnExitAnim!");
            Animation loadAnimation = JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_rg_land_next_turn_exit);
            this.t = loadAnimation;
            if (loadAnimation != null) {
                loadAnimation.setAnimationListener(new c());
                this.j.clearAnimation();
                this.j.startAnimation(this.t);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c(Bundle bundle) {
        super.c(bundle);
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
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
            LogUtil.e("RGSimpleModeExitMainRoa", sb.toString());
        }
        if (bundle == null) {
            LogUtil.e("RGSimpleModeExitMainRoa", "updateData --> bundle==null");
            return;
        }
        boolean z = bundle.getBoolean("remain_dist_hide", false);
        int i = bundle.getInt("updatetype");
        if (x.b().P2()) {
            J0();
        } else if (i == 1) {
            G0();
            int i2 = bundle.getInt("resid", 0);
            bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.StartDist, 1);
            int i3 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0);
            String string = bundle.getString("road_name");
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleModeExitMainRoa", "updateData:nextRoadName = " + string);
            }
            if (string == null || string.length() == 0) {
                string = JarUtils.getResources().getString(R.string.nsdk_string_navi_no_name_road);
            }
            int i4 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TurnKind, 0);
            ImageView imageView = this.k;
            if (imageView != null && i2 != 0) {
                imageView.setVisibility(0);
                try {
                    if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
                        this.k.setImageDrawable(JarUtils.getResources().getDrawable(i2));
                    } else {
                        this.k.setImageDrawable(com.baidu.navisdk.ui.routeguide.subview.util.b.a(i2));
                    }
                } catch (OutOfMemoryError unused) {
                }
            }
            String a2 = a0.I().a(i3);
            String b2 = a0.I().b(a2);
            String a3 = a0.I().a(a2);
            TextView textView = this.l;
            if (textView != null && this.m != null) {
                String str2 = "";
                if (b2 != null && a3 != null) {
                    if (!z) {
                        textView.setText(b2);
                        this.m.setText(a3);
                    } else if (i4 == 70) {
                        textView.setText("");
                        this.m.setText("即将进入");
                    } else {
                        textView.setText("现在");
                        this.m.setText("");
                        a3 = "";
                    }
                }
                if ("目的地".equals(string)) {
                    if (b2 != null && a3 != null) {
                        str2 = a3;
                    }
                    this.l.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_text_size_simple_mode_guide));
                    this.m.setText(str2);
                } else {
                    this.l.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_text_size_simple_mode_guide));
                }
            }
        }
        x0();
        n0();
        A(a0.I().s);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void f(String str) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        F0();
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void o0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.isShown()) {
            Animation H0 = H0();
            ImageView imageView = this.k;
            if (imageView != null && this.l != null && this.m != null) {
                imageView.clearAnimation();
                this.l.clearAnimation();
                this.m.clearAnimation();
                this.k.startAnimation(H0);
                this.l.startAnimation(H0);
                this.m.startAnimation(H0);
            }
            LinearLayout linearLayout = this.j;
            if (linearLayout != null && linearLayout.isShown()) {
                this.j.startAnimation(H0);
            }
            com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
            if (bVar != null) {
                bVar.a(H0);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public View p0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleModeExitMainRoa", "getCurrentPanelView() mSimpleModeGuideView:" + this.i);
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
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void t0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public void u0() {
        if (x.b().O2()) {
            A0();
        }
        d(a0.I().h());
        x.b().E(a0.I().j());
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
        if (this.j != null) {
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("随后-setNextTurnVisible - visible=");
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                LogUtil.e("RGSimpleModeExitMainRoa", sb.toString());
            }
            this.j.setVisibility(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.a
    public int w0() {
        return ScreenUtil.getInstance().dip2px(180);
    }

    public void x(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INDOOR_PARK;
        if (gVar.d()) {
            gVar.e("RGSimpleModeExitMainRoa", "signal = " + i);
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.p) {
            return false;
        }
        super.y();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleModeExitMainRoa", "show() - mSimpleModeGuideView = " + this.i);
        }
        if (this.i == null) {
            LogUtil.e("RGSimpleModeExitMainRoa", "mSimpleModeGuideView == null , 重新 initviews()");
            I0();
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.i();
        }
        u0();
        return true;
    }

    public void y0() {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void z(boolean z) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public void z0() {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        boolean b2 = super.b(bundle);
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.i();
        }
        return b2;
    }

    public void a(Drawable drawable) {
        ImageView imageView;
        if (drawable == null || (imageView = this.n) == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleModeExitMainRoa", "hide:  - mSimpleModeGuideView = " + this.i);
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void a(Drawable drawable, String str, int i) {
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.a(drawable, str, i);
        }
    }

    public void y(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleModeExitMainRoa", "updateServiceAreaSubscribeNum: " + i);
        }
        com.baidu.navisdk.pronavi.ui.guidepanel.b bVar = this.r;
        if (bVar != null) {
            bVar.b(i);
        }
    }
}

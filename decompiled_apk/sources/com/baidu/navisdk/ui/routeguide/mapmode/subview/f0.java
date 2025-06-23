package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class f0 extends com.baidu.navisdk.ui.routeguide.widget.c implements com.baidu.navisdk.module.newguide.interfaces.a {
    private static String r = "RGMMNextDirectionIndicatorView 随后-";
    private ImageView m;
    private LinearLayout n;
    private Drawable o;
    private Animation p;
    private Animation q;

    /* loaded from: classes8.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LogUtil.e(f0.r, "随后-NextTurnAnim mExitAnim - onAnimationEnd, getNextTurnVisible（） = " + com.baidu.navisdk.ui.routeguide.model.a0.I().i());
            f0.this.c();
            com.baidu.navisdk.ui.routeguide.control.x.b().N3();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            LogUtil.e(f0.r, "随后-NextTurnAnim mExitAnim - onAnimationStart");
        }
    }

    public f0(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        u0();
    }

    private void A0() {
        LogUtil.e(r, "cancelExitAnim()");
        Animation animation = this.q;
        if (animation != null) {
            animation.cancel();
        }
        this.q = null;
    }

    private void B0() {
        Object valueOf;
        int i;
        if (com.baidu.navisdk.ui.routeguide.b.V().c() != null && this.n != null && !a(this.p) && this.n.getVisibility() != 0) {
            if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
                i = R.anim.nsdk_anim_rg_next_turn_enter;
            } else {
                i = R.anim.nsdk_anim_rg_land_next_turn_enter;
            }
            this.p = JarUtils.loadAnimation(com.baidu.navisdk.ui.routeguide.b.V().c(), i);
            com.baidu.navisdk.ui.routeguide.control.x.b().M0();
            this.n.setVisibility(0);
            this.n.clearAnimation();
            if (!com.baidu.navisdk.ui.routeguide.b.V().E() && !com.baidu.navisdk.j.c()) {
                this.n.startAnimation(this.p);
            }
            LogUtil.e(r, "NextDirectionIndicator - startEnterAnim()");
            return;
        }
        String str = r;
        StringBuilder sb = new StringBuilder();
        sb.append("NextDirectionIndicator - startEnterAnim(),，isAnimRunning(mEnterAnim) = ");
        sb.append(a(this.p));
        sb.append(", getContext = ");
        sb.append(com.baidu.navisdk.ui.routeguide.b.V().c());
        sb.append(", getVisibility = ");
        LinearLayout linearLayout = this.n;
        if (linearLayout == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(linearLayout.getVisibility());
        }
        sb.append(valueOf);
        LogUtil.e(str, sb.toString());
    }

    private boolean C0() {
        int i;
        LogUtil.e("guide_info", "随后-NextDirectionIndicator - mExitAnim(), isVisibility - " + a() + ", isAnimRunning(mExitAnim) = " + a(this.q) + ", getContext = " + com.baidu.navisdk.ui.routeguide.b.V().c());
        if (com.baidu.navisdk.ui.routeguide.b.V().c() != null && this.n != null) {
            if (a(this.q)) {
                LogUtil.e(r, "随后-enterNextTurnAnim running! ,不重复执行动画");
                return true;
            }
            if (this.f == 1) {
                i = R.anim.nsdk_anim_rg_next_turn_exit;
            } else {
                i = R.anim.nsdk_anim_rg_land_next_turn_exit;
            }
            Animation loadAnimation = JarUtils.loadAnimation(com.baidu.navisdk.ui.routeguide.b.V().c(), i);
            this.q = loadAnimation;
            loadAnimation.setAnimationListener(new a());
            this.n.clearAnimation();
            this.n.startAnimation(this.q);
            return true;
        }
        return false;
    }

    private void z0() {
        LogUtil.e(r, "cancelEnterAnim()");
        Animation animation = this.p;
        if (animation != null) {
            animation.cancel();
        }
        this.p = null;
    }

    @Override // com.baidu.navisdk.module.newguide.interfaces.a
    public void V() {
        if (!C0()) {
            super.c();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().i()) {
            LogUtil.e(r, "orientationChanged -> setNextTurnVisibility(View.VISIBLE)");
            com.baidu.navisdk.ui.routeguide.control.x.b().r(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        super.b(bundle);
        B0();
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        LinearLayout linearLayout = this.n;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        z0();
        A0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public ViewGroup.LayoutParams o0() {
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int p0() {
        return R.id.bnav_rg_next_deriction_indicator;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int q0() {
        return R.layout.nsdk_layout_rg_next_direction_indicator_land;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public int r0() {
        return R.layout.nsdk_layout_rg_next_direction_indicator;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public String s0() {
        return r;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void t0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void v(int i) {
        z0();
        A0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void w0() {
        this.n = (LinearLayout) this.k.findViewById(R.id.bnav_rg_next_turn_layout);
        this.m = (ImageView) this.k.findViewById(R.id.bnav_rg_sg_next_turn_icon);
        this.n.setVisibility(8);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.c
    public void x0() {
        ImageView imageView;
        Drawable drawable;
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().i() && (imageView = this.m) != null && (drawable = this.o) != null && this.f == 1) {
            imageView.setImageDrawable(drawable);
            b(null);
        }
    }

    private boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // com.baidu.navisdk.module.newguide.interfaces.a
    public boolean a(Drawable drawable) {
        ImageView imageView = this.m;
        if (imageView == null) {
            return false;
        }
        imageView.setImageDrawable(drawable);
        this.o = drawable;
        return true;
    }
}

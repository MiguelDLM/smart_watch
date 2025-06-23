package com.baidu.navisdk.module.newguide.subviews.guides;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class d extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.module.newguide.interfaces.a {
    private View i;
    private TextView j;
    private ImageView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private Animation o;
    private Animation p;
    private float q;
    private int r;
    private int s;
    private Drawable t;
    private boolean u;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a(d dVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "onClick: ");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (d.this.i != null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGDefaultModeFollowGuid", "随后visibility设置为visible");
                }
                d.this.i.setVisibility(0);
            }
            d.this.o = null;
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGDefaultModeFollowGuid", "enter onAnimationEnd show1 mNextTurnLayout");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "enter onAnimationStart: ");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d dVar = d.this;
            if (!dVar.a(dVar.o)) {
                d.this.c();
            }
            d.this.p = null;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "随后-NextTurnAnim mExitAnim - onAnimationEnd, getNextTurnVisible（） = " + a0.I().i());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "随后-NextTurnAnim mExitAnim - onAnimationStart");
            }
        }
    }

    public d(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.q = 0.0f;
        this.t = null;
        this.u = true;
        u0();
        this.r = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_follow_guide_height);
        this.s = 0;
    }

    private void n0() {
        if (this.q == 0.0f) {
            this.q = -(((r0 - this.s) * 1.0f) / this.r);
        }
    }

    private void o0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDefaultModeFollowGuid", "cancelEnterAnim: ");
        }
        if (this.o != null) {
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "enterAnim hasStarted : " + this.o.hasStarted() + " enterAnim hasEnded : " + this.o.hasEnded());
            }
            this.o.cancel();
        }
        this.o = null;
    }

    private void p0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDefaultModeFollowGuid", "cancelExitAnim: ");
        }
        Animation animation = this.p;
        if (animation != null) {
            animation.cancel();
        }
        this.p = null;
    }

    private Animation q0() {
        n0();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, this.q, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        return translateAnimation;
    }

    private Animation r0() {
        n0();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, this.q);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        return translateAnimation;
    }

    private void s0() {
        Animation animation;
        View view = this.i;
        if (view != null && (animation = view.getAnimation()) != null && animation == this.p) {
            this.i.clearAnimation();
            this.p = null;
        }
        p0();
        if (this.f9165a != null && this.i != null && !a(this.o) && (this.i.getVisibility() != 0 || a(this.p))) {
            o0();
            Animation q0 = q0();
            this.o = q0;
            q0.setAnimationListener(new b());
            w0();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "show mNextTurnLayout");
            }
            this.i.setVisibility(0);
            this.i.clearAnimation();
            if (!com.baidu.navisdk.ui.routeguide.b.V().E() && !com.baidu.navisdk.j.c()) {
                this.i.startAnimation(this.o);
            }
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", " startEnterAnim()");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGDefaultModeFollowGuid", "startEnterAnim(),，isAnimRunning(mEnterAnim) = " + a(this.o) + ", getContext = " + com.baidu.navisdk.ui.routeguide.b.V().c() + ", getVisibility = " + a() + ",isRunningExitAnim:" + a(this.p));
        }
    }

    private boolean t0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDefaultModeFollowGuid", "随后-NextDirectionIndicator - mExitAnim(), isVisibility - " + a() + ", isAnimRunning(mExitAnim) = " + a(this.p) + ", getContext = " + com.baidu.navisdk.ui.routeguide.b.V().c());
        }
        if (this.f9165a != null && this.i != null) {
            if (a(this.p)) {
                if (gVar.d()) {
                    gVar.e("RGDefaultModeFollowGuid", "随后-enterNextTurnAnim running! ,不重复执行动画");
                }
                return true;
            }
            p0();
            o0();
            Animation r0 = r0();
            this.p = r0;
            r0.setAnimationListener(new c());
            this.i.clearAnimation();
            this.i.startAnimation(this.p);
            return true;
        }
        return false;
    }

    private void u0() {
        if (this.i == null) {
            View findViewById = this.b.findViewById(R.id.bn_rg_exit_guide_follow_layout);
            this.i = findViewById;
            this.j = (TextView) findViewById.findViewById(R.id.bn_rg_next_deriction);
            this.k = (ImageView) this.i.findViewById(R.id.bn_rg_next_deriction_turn_icon);
            this.l = (TextView) this.i.findViewById(R.id.bn_rg_next_deriction_go);
            this.m = (TextView) this.i.findViewById(R.id.bn_rg_next_deriction_road_name);
            this.n = (TextView) this.i.findViewById(R.id.bnav_rg_hw_exit_code);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "init hide mNextTurnLayout");
            }
            this.i.setVisibility(8);
            this.i.setOnClickListener(new a(this));
            w0();
        }
    }

    private void w0() {
        boolean c2 = x.b().c2();
        boolean z = !c2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDefaultModeFollowGuid", "updateViewStyle isNeedDefaultViewStyle: " + z + "," + this.u);
        }
        if (z != this.u) {
            this.u = z;
            if (!c2) {
                com.baidu.navisdk.module.newguide.a.e().a(this.i, R.drawable.bn_bg_rg_default_guide_follow_view);
            } else {
                com.baidu.navisdk.module.newguide.a.e().a(this.i, R.drawable.bn_bg_rg_exit_main_road_follow_guide_view);
            }
            y(z);
        }
    }

    private void y(boolean z) {
        if (z) {
            TextView textView = this.j;
            if (textView != null) {
                com.baidu.navisdk.ui.util.b.a(textView, R.color.nsdk_rg_follow_guide_text_color);
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                com.baidu.navisdk.ui.util.b.a(textView2, R.color.nsdk_rg_follow_guide_direction_go_text_color);
            }
            TextView textView3 = this.m;
            if (textView3 != null) {
                com.baidu.navisdk.ui.util.b.a(textView3, R.color.nsdk_rg_follow_guide_text_color);
                return;
            }
            return;
        }
        TextView textView4 = this.j;
        if (textView4 != null) {
            com.baidu.navisdk.ui.util.b.a(textView4, R.color.nsdk_rg_exit_main_road_follow_guide_text_color);
        }
        TextView textView5 = this.m;
        if (textView5 != null) {
            com.baidu.navisdk.ui.util.b.a(textView5, R.color.nsdk_rg_exit_main_road_follow_guide_text_color);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.interfaces.a
    public void V() {
        if (!t0()) {
            super.c();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        super.d(bundle);
        w0();
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(R.string.nsdk_follow);
        }
        com.baidu.navisdk.ui.routeguide.model.k e = a0.I().e();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDefaultModeFollowGuid", "updateData: " + e);
        }
        if (this.k != null) {
            Drawable d = e.d();
            this.t = d;
            a(d, com.baidu.navisdk.ui.util.b.b());
        }
        if (this.n != null) {
            String a2 = e.a();
            if (TextUtils.isEmpty(a2)) {
                this.n.setVisibility(8);
            } else {
                this.n.setText(JarUtils.getResources().getString(R.string.nsdk_string_hw_ic_code, a2));
                this.n.setVisibility(0);
            }
        }
        if (this.m != null && this.l != null) {
            String b2 = e.b();
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "updateData: " + b2);
            }
            if (TextUtils.isEmpty(b2)) {
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                return;
            }
            if (b2.endsWith("方向")) {
                this.l.setText(R.string.nsdk_string_rg_destine_for);
            } else if ("目的地".equals(b2)) {
                this.l.setText(R.string.nsdk_string_rg_arrive);
            } else {
                this.l.setText(R.string.nsdk_string_rg_enter);
            }
            if (gVar.d() && a0.F) {
                b2 = b2 + "--测试路名超出效果测试路名超出效果测试路名超出效果测试路名超出效果";
            }
            this.l.setVisibility(0);
            this.m.setText(b2);
            this.m.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        o0();
        p0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        if (this.i != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "随后view hide()");
            }
            if (a(this.o)) {
                if (gVar.d()) {
                    gVar.e("RGDefaultModeFollowGuid", "取消进入动画");
                }
                this.o.setAnimationListener(null);
                o0();
            }
            this.i.clearAnimation();
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "随后view取消进入动画后 最后hide()");
            }
            this.i.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean b(Bundle bundle) {
        super.b(bundle);
        s0();
        return true;
    }

    @Override // com.baidu.navisdk.module.newguide.interfaces.a
    public boolean a(Drawable drawable) {
        d(null);
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        p0();
        o0();
        this.i = null;
        u0();
        if (a0.I().i()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDefaultModeFollowGuid", "orientationChanged -> setNextTurnVisibility(View.VISIBLE)");
            }
            d(null);
            x.b().r(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        w0();
    }

    private void a(Drawable drawable, boolean z) {
        if (drawable != null) {
            this.k.setImageDrawable(drawable);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.module.newguide.interfaces.a
    public boolean a() {
        View view = this.i;
        return view != null && view.getVisibility() == 0;
    }
}

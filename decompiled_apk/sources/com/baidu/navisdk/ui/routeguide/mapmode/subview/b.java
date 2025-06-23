package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import OXOo.OOXIXo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.data.vm.a;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.widget.BNDrawableTextView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class b extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    private ViewGroup i;
    private RelativeLayout j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private boolean o;
    private AnimationDrawable p;
    private ValueAnimator q;
    private ValueAnimator r;
    private AnimatorSet s;
    private View t;
    private View u;
    private boolean v;
    private com.baidu.navisdk.pronavi.style.i.a w;
    private boolean x;
    private a.q0 y;

    /* loaded from: classes8.dex */
    public class a implements a.q0 {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.a.q0
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.x.b().d(b.this.j);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0453b implements ValueAnimator.AnimatorUpdateListener {
        public C0453b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.t != null && b.this.u != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (!b.this.o) {
                    floatValue = 2.0f - floatValue;
                }
                if (floatValue < 1.0f) {
                    b.this.t.setVisibility(0);
                    b.this.t.setRotationX(floatValue * 180.0f);
                    b.this.t.setAlpha(b.this.a(1.0f - (floatValue * 1.0f)));
                } else {
                    b.this.t.setVisibility(8);
                }
                if (floatValue >= 1.0f) {
                    float f = floatValue - 1.0f;
                    b.this.u.setVisibility(0);
                    b.this.u.setRotationX((f * 180.0f) - 180.0f);
                    b.this.u.setAlpha(b.this.a(f));
                    return;
                }
                b.this.u.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i;
            if (b.this.t != null && b.this.u != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                View view = b.this.o ? b.this.u : b.this.t;
                double d = floatValue;
                float f = (float) ((((-40) / 12.566370614359172d) * d) + 40);
                if (b.this.o) {
                    i = 1;
                } else {
                    i = -1;
                }
                float sin = (float) (f * i * Math.sin(d));
                view.setVisibility(0);
                view.setRotationX(sin);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            b bVar = b.this;
            bVar.A(bVar.o);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (!b.this.o) {
                b.this.g(com.baidu.navisdk.ui.routeguide.model.a0.I().d());
                b.this.C0();
                b.this.p = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f8717a;

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f8717a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.j != null) {
                this.f8717a.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.j.requestLayout();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends com.baidu.navisdk.pronavi.style.c {
        public f(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGCurRoadName";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(String str) {
            b.this.D0();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            a(b.this.t);
            a(b.this.k);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Observer<a.b> {
        public g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(a.b bVar) {
            b.this.a(bVar.b(), bVar.a());
        }
    }

    public b(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.o = false;
        this.v = false;
        this.x = false;
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            this.v = k.J();
        }
        u0();
        y(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z) {
        View view;
        ViewGroup viewGroup;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCurRoadNameView", "handlerRoadNameVdrStatus: " + z);
        }
        if (z) {
            View view2 = this.t;
            if (view2 != null && view2.getVisibility() != 8) {
                this.t.setVisibility(8);
            }
            View view3 = this.u;
            if (view3 != null && view3.getVisibility() != 0) {
                this.u.setVisibility(0);
            }
            if (!com.baidu.navisdk.module.cloudconfig.a.b().b("disable_animation", false)) {
                Drawable[] compoundDrawables = this.n.getCompoundDrawables();
                if (compoundDrawables.length == 4) {
                    this.p = (AnimationDrawable) compoundDrawables[0];
                }
                B0();
            }
            if (w0() && (viewGroup = this.i) != null && viewGroup.getVisibility() != 0) {
                this.i.setVisibility(0);
                return;
            }
            return;
        }
        C0();
        this.p = null;
        View view4 = this.u;
        if (view4 != null && view4.getVisibility() != 8) {
            this.u.setVisibility(8);
        }
        if (x0() && w0() && (view = this.t) != null && view.getVisibility() != 0) {
            this.t.setVisibility(0);
        }
        g(com.baidu.navisdk.ui.routeguide.model.a0.I().d());
    }

    private void A0() {
    }

    private void B0() {
        ViewGroup viewGroup;
        if (this.o && this.p != null && (viewGroup = this.i) != null && viewGroup.getVisibility() == 0) {
            this.p.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        AnimationDrawable animationDrawable;
        if (this.o && (animationDrawable = this.p) != null) {
            animationDrawable.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        View view = this.t;
        if (view != null) {
            com.baidu.navisdk.ui.util.b.a(view, R.drawable.bnav_rg_route_name_bg);
        }
        TextView textView = this.k;
        if (textView != null) {
            com.baidu.navisdk.ui.util.b.a(textView, R.color.bnav_rg_text_b);
        }
    }

    private boolean h(String str) {
        return com.baidu.navisdk.util.common.l0.c(str) || "无名路".equals(str) || "当前道路".equals(str) || "无数据道路".equals(str);
    }

    private void q0() {
        if (!this.x && com.baidu.navisdk.ui.routeguide.b.V().s() != null) {
            com.baidu.navisdk.pronavi.data.vm.a aVar = (com.baidu.navisdk.pronavi.data.vm.a) com.baidu.navisdk.ui.routeguide.b.V().s().c(com.baidu.navisdk.pronavi.data.vm.a.class);
            LifecycleOwner f2 = com.baidu.navisdk.ui.routeguide.b.V().f();
            if (aVar != null && f2 != null) {
                this.x = true;
                aVar.c().observe(f2, new g());
            }
        }
    }

    private void r0() {
        AnimatorSet animatorSet = this.s;
        if (animatorSet != null && (animatorSet.isRunning() || this.s.isStarted())) {
            this.s.cancel();
        }
        AnimationDrawable animationDrawable = this.p;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.p = null;
        }
    }

    private int s0() {
        com.baidu.navisdk.framework.interfaces.pronavi.hd.f h0 = h0();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCurRoadNameView", "getPortraitMarginBottom: " + h0);
        }
        int i = h0.f6817a;
        if (i == 2) {
            return h0.b;
        }
        if (i == 3 && h0.g(true)) {
            return 0;
        }
        return com.baidu.navisdk.module.newguide.a.e().a();
    }

    private void t0() {
        if (this.q == null || this.r == null || this.s == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 2.0f);
            this.q = ofFloat;
            ofFloat.setDuration(1000L);
            this.q.setInterpolator(new AccelerateInterpolator());
            this.q.reverse();
            this.q.addUpdateListener(new C0453b());
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 12.566371f);
            this.r = ofFloat2;
            ofFloat2.setDuration(500L);
            this.r.addUpdateListener(new c());
            AnimatorSet animatorSet = new AnimatorSet();
            this.s = animatorSet;
            animatorSet.addListener(new d());
            this.s.play(this.q).before(this.r);
        }
    }

    private void u0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        try {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_cur_road_name_container);
            this.i = viewGroup2;
            if (viewGroup2 != null) {
                if (viewGroup2.getChildCount() > 0) {
                    this.i.removeAllViews();
                }
                RelativeLayout relativeLayout = this.j;
                if (relativeLayout == null) {
                    RelativeLayout relativeLayout2 = (RelativeLayout) JarUtils.inflate(this.f9165a, R.layout.nsdk_layout_rg_mapmode_cur_road_name, null);
                    this.j = relativeLayout2;
                    if (relativeLayout2 != null) {
                        this.k = (TextView) relativeLayout2.findViewById(R.id.bnav_rg_road_name_tv);
                        this.l = (TextView) this.j.findViewById(R.id.bnav_rg_road_name_green_light);
                        this.m = (TextView) this.j.findViewById(R.id.bnav_rg_cur_road_speed_tv);
                        this.t = this.j.findViewById(R.id.bnav_rg_road_container);
                        this.n = (BNDrawableTextView) this.j.findViewById(R.id.bnav_rg_vdr_gps_weak_tip);
                        this.u = this.j.findViewById(R.id.bnav_rg_vdr_container);
                    }
                } else if (relativeLayout.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.j.getParent()).removeView(this.j);
                }
                if (this.j != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    if (j0()) {
                        layoutParams.bottomMargin = com.baidu.navisdk.module.newguide.a.e().a();
                    } else {
                        layoutParams.bottomMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_4dp);
                    }
                    this.i.addView(this.j, layoutParams);
                }
                com.baidu.navisdk.ui.routeguide.control.x.b().d(this.j);
                this.y = new a();
                com.baidu.navisdk.ui.routeguide.control.x.b().a(this.y);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        g(com.baidu.navisdk.ui.routeguide.model.a0.I().d());
        y0();
    }

    private boolean w0() {
        if (RouteGuideFSM.getInstance().isBrowseState()) {
            LogUtil.e("RGCurRoadNameView", "isShouldShowRoadNameView --> 沿途搜索态、操作态不显示当前路名！");
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            LogUtil.e("RGCurRoadNameView", "isShouldShowRoadNameView --> 偏航时不显示当前路名！");
            return false;
        }
        String topState = RouteGuideFSM.getInstance().getTopState();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCurRoadNameView", "isShouldShowCurrentView: " + topState);
        }
        if (!RGFSMTable.FsmState.HUD.equals(topState) && !RGFSMTable.FsmState.HUDMirror.equals(topState)) {
            return true;
        }
        if (gVar.d()) {
            gVar.e("RGCurRoadNameView", "isShouldShowCurrentView: HUD");
        }
        return false;
    }

    private Animator x(int i) {
        int i2;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
        if (marginLayoutParams == null || (i2 = marginLayoutParams.bottomMargin) == i) {
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i);
        ofInt.addUpdateListener(new e(marginLayoutParams));
        return ofInt;
    }

    private boolean x0() {
        if (!BNCommSettingManager.getInstance().isShowCurrentRoad()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGCurRoadNameView", "isShouldShowRoadNameView BNCommSettingManager not show");
                return false;
            }
            return false;
        }
        return true;
    }

    private void y0() {
        if (this.w == null) {
            this.w = new f(new Integer[0]);
        }
        com.baidu.navisdk.pronavi.style.f.b.a("RGCommonWidget", this.w);
    }

    private void z(boolean z) {
        boolean z2;
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("doAnim,road2vdr:");
            sb.append(z);
            sb.append(",isVdrLocation:");
            sb.append(this.o);
            sb.append(",mAnimatorSet valid:");
            if (this.s != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            sb.append(z2);
            LogUtil.e("RGCurRoadNameView", sb.toString());
        }
        t0();
        this.o = z;
        AnimatorSet animatorSet = this.s;
        if (animatorSet != null) {
            if (animatorSet.isRunning() || this.s.isStarted()) {
                this.s.cancel();
            }
            this.s.start();
        }
    }

    private void z0() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null && relativeLayout.isShown()) {
            return new View[]{this.j};
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        r0();
        this.w = null;
        com.baidu.navisdk.ui.routeguide.control.x.b().b(this.y);
    }

    public void n0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGCurRoadNameView", "exitVdrLocation,isVdrLocation: " + this.o);
        }
        if (!this.o) {
            return;
        }
        if (x0() && !com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().l()) {
            z(false);
        } else {
            this.o = false;
            A(false);
        }
    }

    public void o0() {
        ViewGroup viewGroup;
        if (!j0() && (viewGroup = this.i) != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.width = com.baidu.navisdk.ui.routeguide.utils.a.f9151a.b() - com.baidu.navisdk.ui.routeguide.control.x.b().R();
                if (com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().b()) {
                    layoutParams2.width -= ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b()) * 2;
                }
                layoutParams2.addRule(11);
                this.i.setLayoutParams(layoutParams2);
            }
        }
    }

    public void p0() {
        ViewGroup viewGroup;
        if (!j0() && (viewGroup = this.i) != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int b = com.baidu.navisdk.ui.routeguide.utils.a.f9151a.b() - com.baidu.navisdk.ui.routeguide.control.x.b().V();
                if (com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().b()) {
                    b -= ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b()) * 2;
                }
                if (b != layoutParams2.width) {
                    layoutParams2.width = b;
                    layoutParams2.addRule(11);
                    this.i.requestLayout();
                }
            }
        }
    }

    public void v(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGCurRoadNameView", "setCurRoadVisibility: " + i + this.o);
        }
        if (this.o) {
            return;
        }
        r0();
        if (i == 0 && (!x0() || !w0())) {
            i = 8;
        }
        View view = this.t;
        if (view != null && view.getVisibility() != i) {
            this.t.setVisibility(i);
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.getVisibility() != i) {
            this.i.setVisibility(i);
        }
        if (i == 0) {
            g(com.baidu.navisdk.ui.routeguide.model.a0.I().d());
        }
    }

    public void w(int i) {
        TextView textView = this.m;
        if (textView == null) {
            com.baidu.navisdk.util.common.g.PRO_NAV.e("RGCurRoadNameView", "updateLimitSpeed , view = null");
            return;
        }
        if (i > 0) {
            textView.setText("" + i);
            this.m.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        boolean z = false;
        if (this.v || !w0() || !BNSettingManager.isRoadNameEnable()) {
            return false;
        }
        q0();
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            if (this.o) {
                viewGroup.setVisibility(0);
                B0();
            } else if (x0()) {
                this.i.setVisibility(0);
                g(com.baidu.navisdk.ui.routeguide.model.a0.I().d());
            } else {
                this.i.setVisibility(8);
            }
            z = true;
        }
        if (z) {
            super.y();
        }
        return z;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        if (this.o) {
            C0();
        }
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        if (this.j == null) {
            return null;
        }
        if (z) {
            Animator x = x(fVar.a());
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(x);
            return arrayList;
        }
        p0();
        return null;
    }

    public void f(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGCurRoadNameView", "openVdrLocation,isVdrLocation: " + this.o + ",vdrStateDescription:" + str);
        }
        if (this.o) {
            return;
        }
        if (x0() && !com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().l()) {
            z(true);
        } else {
            this.o = true;
            A(true);
        }
    }

    public void g(String str) {
        TextView textView;
        if (this.v) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "updateRoadName --> " + str + ", isVdrLocation:" + this.o);
        }
        if (!BNSettingManager.isRoadNameEnable() || this.o || !x0() || !w0() || this.i == null || (textView = this.k) == null || str == null || this.t == null || str.equals(textView.getText().toString())) {
            return;
        }
        if (h(str)) {
            this.t.setVisibility(8);
            this.k.setText("");
            this.i.setVisibility(8);
        } else {
            a(16, str);
            this.t.setVisibility(0);
            this.k.setText(str);
            w(com.baidu.navisdk.module.pronavi.model.g.o().l);
            this.i.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void h() {
        super.h();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGCurRoadNameView", "caoyujie-->isAnyEnlargeRoadMapShowing: " + com.baidu.navisdk.ui.routeguide.model.i.s().k() + ", isEnlargeOrColladaShow: " + com.baidu.navisdk.ui.routeguide.control.x.b().b2());
        }
        if (com.baidu.navisdk.ui.routeguide.model.i.s().k() && com.baidu.navisdk.ui.routeguide.control.x.b().b2()) {
            o0();
        } else {
            p0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        u0();
        if (j0()) {
            com.baidu.navisdk.pronavi.util.b.f7961a.a(this.j, s0());
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        if (this.j == null) {
            return null;
        }
        if (z) {
            Animator x = x(com.baidu.navisdk.module.newguide.a.e().a());
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(x);
            return arrayList;
        }
        p0();
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        if (z) {
            z0();
        } else {
            A0();
        }
    }

    private void a(int i, String str) {
        TextView textView = this.k;
        if (textView != null) {
            textView.setTextSize(1, i);
            if (com.baidu.navisdk.ui.util.j.a(this.k, JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_cur_road_name_width), str)) {
                return;
            }
            a(i - 2, str);
        }
    }

    public void y(boolean z) {
        Log.e("gblog", "hideview");
        this.v = z;
        if (z) {
            c();
        }
    }

    public float a(float f2) {
        return ((float) (Math.cos((f2 + 1.0f) * 3.141592653589793d) / 2.0d)) + 0.5f;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        if (this.j == null) {
            return null;
        }
        if (z) {
            Animator x = x(i2);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(x);
            return arrayList;
        }
        p0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (this.l != null) {
            if (TextUtils.isEmpty(str)) {
                this.l.setVisibility(8);
                return;
            }
            this.l.setVisibility(0);
            this.l.setText(str);
            this.l.setTextColor(JarUtils.getResources().getColor(i));
        }
    }
}

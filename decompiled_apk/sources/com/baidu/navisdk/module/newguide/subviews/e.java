package com.baidu.navisdk.module.newguide.subviews;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.viewmodels.a;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class e extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    private com.baidu.navisdk.pronavi.style.i.a A;
    private FrameLayout B;
    private ViewGroup i;
    private View j;
    private TextView k;
    private TextView l;
    private View m;
    private TextView n;
    private TextView o;
    private com.baidu.navisdk.module.newguide.viewmodels.a p;
    private boolean q;
    private boolean r;
    private Animation s;
    private Animation t;
    private AnimationSet u;
    private Handler v;
    private View.OnClickListener w;
    private Observer<a.d> x;
    private Observer<a.c> y;
    private com.baidu.navisdk.pronavi.ui.driving.a z;

    /* loaded from: classes7.dex */
    public class a implements Observer<a.d> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable a.d dVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleEtaView", "onChanged getClosetViaLiveData: " + dVar);
            }
            e.this.a(dVar);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Observer<a.c> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable a.c cVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleEtaView", "onChanged getDestShowLiveData: " + cVar);
            }
            e.this.a(cVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.w0()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGSimpleEtaView", "onClick: mDrivingDistanceTimeView is show");
                    return;
                }
                return;
            }
            if (e.this.w != null) {
                e.this.w.onClick(view);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.util.worker.loop.a {
        public d(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message.what == 1) {
                e.this.A0();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.subviews.e$e, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class AnimationAnimationListenerC0267e implements Animation.AnimationListener {
        public AnimationAnimationListenerC0267e(e eVar) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleEtaView", "onAnimationEnd: ");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleEtaView", "onAnimationStart: ");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f7345a;

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f7345a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (e.this.B != null) {
                this.f7345a.bottomMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                e.this.B.requestLayout();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends com.baidu.navisdk.pronavi.style.c {
        public g(Integer... numArr) {
            super(numArr);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public String a() {
            return "RGSimpleEtaView";
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(String str) {
            e.this.z0();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            a(e.this.k);
            a(e.this.l);
            a(e.this.i);
            e.this.z(false);
        }
    }

    public e(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.q = false;
        this.r = false;
        this.v = null;
        r0();
        s0();
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleEtaView VIA_ETA", "startViaEtaAnim");
        }
        if (this.m == null) {
            b(this.i);
        }
        if (this.j != null && this.m != null) {
            if (this.u == null || this.s == null || this.t == null) {
                AnimationSet animationSet = new AnimationSet(true);
                this.u = animationSet;
                animationSet.setFillAfter(true);
                this.s = AnimationUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_toolbox_eta_switch_in);
                this.t = AnimationUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_toolbox_eta_switch_out);
                this.u.addAnimation(this.s);
                this.u.addAnimation(this.t);
                View view = this.m;
                if (view != null) {
                    view.setVisibility(0);
                }
                this.u.setAnimationListener(new AnimationAnimationListenerC0267e(this));
            }
            if (this.m.getAnimation() != null && this.m.getAnimation() != this.t) {
                this.j.clearAnimation();
                this.m.clearAnimation();
                this.m.setAnimation(this.t);
                this.j.setAnimation(this.s);
            } else {
                this.j.clearAnimation();
                this.m.clearAnimation();
                this.j.setAnimation(this.t);
                this.m.setAnimation(this.s);
            }
            this.u.start();
            t0();
            Handler handler = this.v;
            if (handler != null) {
                if (handler.hasMessages(1)) {
                    this.v.removeMessages(1);
                }
                this.v.sendEmptyMessageDelayed(1, 5000L);
            }
        }
    }

    private void o0() {
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.B = (FrameLayout) this.b.findViewById(R.id.nsdk_rg_simple_eta_container);
        this.B.addView(this.i, new FrameLayout.LayoutParams(-1, JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_control_panel_btn_height_new)));
    }

    private void p0() {
        if (this.p == null) {
            this.p = com.baidu.navisdk.ui.routeguide.b.V().i().b();
        }
        if (this.p == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                gVar.c("RGSimpleEtaView", "addObserver mEtaViewModel == null:");
                return;
            }
            return;
        }
        if (this.q) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGSimpleEtaView", "addObserver isAddObserver: true");
                return;
            }
            return;
        }
        if (this.x == null) {
            this.x = new a();
        }
        if (this.y == null) {
            this.y = new b();
        }
        this.q = true;
        this.p.b().observeForever(this.y);
        this.p.a().observeForever(this.x);
    }

    private void q0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleEtaView", "hideViaLayout: " + this.m);
        }
        View view = this.m;
        if (view != null) {
            view.clearAnimation();
            this.m.setVisibility(8);
        }
    }

    private void r0() {
        this.i = (ViewGroup) com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.nsdk_layout_rg_simple_eta, null, false);
    }

    private void s0() {
        this.i.setOnClickListener(new c());
        if (this.r) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        a((View) this.i);
        x0();
    }

    private void t0() {
        if (this.v == null) {
            this.v = new d("RGToolBoxView");
        }
    }

    private boolean u0() {
        if (this.f == 1) {
            return true;
        }
        return false;
    }

    private void v(int i) {
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                this.B.requestLayout();
            }
        }
    }

    private List<Animator> w(int i) {
        int i2;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.B.getLayoutParams();
        if (marginLayoutParams == null || (i2 = marginLayoutParams.bottomMargin) == i) {
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i);
        ofInt.addUpdateListener(new f(marginLayoutParams));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(ofInt);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w0() {
        com.baidu.navisdk.pronavi.ui.driving.a aVar = this.z;
        if (aVar != null && aVar.a()) {
            return true;
        }
        return false;
    }

    private void x0() {
        if (this.A == null) {
            g gVar = new g(new Integer[0]);
            this.A = gVar;
            com.baidu.navisdk.pronavi.style.f.b.a("RGCommonWidget", gVar);
        }
    }

    private void y0() {
        this.q = false;
        com.baidu.navisdk.module.newguide.viewmodels.a aVar = this.p;
        if (aVar != null) {
            if (this.x != null) {
                aVar.a().removeObserver(this.x);
            }
            if (this.y != null) {
                this.p.b().removeObserver(this.y);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z) {
        com.baidu.navisdk.pronavi.style.i.a aVar = this.A;
        if (aVar != null) {
            TextView textView = this.o;
            if (textView != null) {
                aVar.a(textView);
            }
            TextView textView2 = this.n;
            if (textView2 != null) {
                this.A.a(textView2);
            }
            if (z) {
                this.A.a("RGCommonWidget");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            com.baidu.navisdk.ui.util.b.a(viewGroup, R.drawable.bnav_rg_route_name_bg);
        }
        TextView textView = this.k;
        if (textView != null) {
            com.baidu.navisdk.ui.util.b.a(textView, R.color.nsdk_cl_text_b_mm_title);
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            com.baidu.navisdk.ui.util.b.a(textView2, R.color.nsdk_cl_text_c_mm);
        }
        TextView textView3 = this.o;
        if (textView3 != null) {
            com.baidu.navisdk.ui.util.b.a(textView3, R.color.nsdk_cl_text_b_mm_title);
        }
        TextView textView4 = this.n;
        if (textView4 != null) {
            com.baidu.navisdk.ui.util.b.a(textView4, R.color.nsdk_cl_text_b_mm_title);
        }
        com.baidu.navisdk.pronavi.ui.driving.a aVar = this.z;
        if (aVar != null) {
            aVar.d(0, 0);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleEtaView", "dispose: ");
        }
        this.q = false;
        Handler handler = this.v;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.v = null;
        }
        c();
        com.baidu.navisdk.pronavi.ui.driving.a aVar = this.z;
        if (aVar != null) {
            aVar.i();
            this.z = null;
        }
        q0();
        View view = this.j;
        if (view != null) {
            view.clearAnimation();
            this.j.setVisibility(0);
        }
        com.baidu.navisdk.pronavi.style.f.b.b("RGCommonWidget", this.A);
    }

    public void n0() {
        v(0);
    }

    public void y(boolean z) {
        Handler handler;
        if (z && (handler = this.v) != null) {
            handler.removeMessages(1);
        }
        q0();
        View view = this.j;
        if (view != null) {
            view.clearAnimation();
        }
        this.s = null;
        this.t = null;
        this.u = null;
    }

    private boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str.charAt(0) + "").matches();
    }

    public void b(View.OnClickListener onClickListener) {
        this.w = onClickListener;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleEtaView", "getEnterFullHD: " + i + ",miniHDHeight:" + i2 + ", " + z);
        }
        if (this.B != null && z && i == 2) {
            return w(0);
        }
        return null;
    }

    private void b(View view) {
        try {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.bnav_rg_toolbox_via_time_dist_ly_stub);
            if (viewStub != null) {
                com.baidu.navisdk.ui.util.b.a(viewStub);
            }
        } catch (Exception e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleEtaView", "initViaPointView ViewStub exception: " + e.toString());
            }
            if (gVar.b()) {
                gVar.a("load initViaPointView exception", e);
            }
        }
        View findViewById = view.findViewById(R.id.bnav_rg_toolbox_via_time_and_dist_ly);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleEtaView VIA_ETA", "initViaEtaView->parent=" + findViewById);
        }
        if (findViewById != null) {
            this.m = findViewById;
            this.n = (TextView) findViewById.findViewById(R.id.bnav_rg_toolbox_via_remain_time_and_dist);
            this.o = (TextView) findViewById.findViewById(R.id.bnav_rg_toolbox_via_arrive_title);
            q0();
            z(true);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        y0();
        FrameLayout frameLayout = this.B;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.r = false;
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleEtaView", "hide: ");
            }
        }
    }

    private void a(View view) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleEtaView", "initEtaView> isOrientationPortrait=" + u0());
        }
        this.j = view.findViewById(R.id.bnav_rg_main_eta_details_layout);
        this.k = (TextView) view.findViewById(R.id.bnav_rg_toolbox_remain_time_and_dist);
        this.l = (TextView) view.findViewById(R.id.bnav_rg_toolbox_arrive_time);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        p0();
        com.baidu.navisdk.pronavi.style.f.b.a("RGCommonWidget", this.A);
        this.r = true;
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSimpleEtaView", "show: ");
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable a.c cVar) {
        if (cVar == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                gVar.c("RGSimpleEtaView", "updateDestinationEtaInfo: destEtaInfo == null ");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGSimpleEtaView", "updateDestinationEtaInfo: " + this.j);
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(cVar.f7358a);
            if (!TextUtils.isEmpty(cVar.f7358a) && cVar.f7358a.length() > 6) {
                this.k.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_18dp));
            } else {
                this.k.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_20dp));
            }
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setText(cVar.c);
            if (!f(cVar.c)) {
                this.l.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_15dp));
            } else {
                this.l.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_18dp));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable a.d dVar) {
        if (dVar != null && dVar.a()) {
            if (this.m == null) {
                b(this.i);
            }
            this.o.setText(dVar.d);
            this.n.setText(dVar.f7359a);
            t0();
            if (this.v.hasMessages(1) || w0()) {
                return;
            }
            this.v.sendEmptyMessageDelayed(1, 5000L);
            return;
        }
        y(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        o0();
        y(false);
        s0();
        this.m = null;
        com.baidu.navisdk.module.newguide.viewmodels.a aVar = this.p;
        if (aVar != null) {
            aVar.k();
        }
        com.baidu.navisdk.pronavi.ui.driving.a aVar2 = this.z;
        if (aVar2 != null) {
            aVar2.a(this.i, i);
            if (this.z.a()) {
                q0();
                View view = this.j;
                if (view != null) {
                    view.clearAnimation();
                    this.j.setVisibility(8);
                }
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGSimpleEtaView", "orientationChanged: " + this.m + ", " + this.j);
                }
            }
        }
        if (u0()) {
            v(com.baidu.navisdk.ui.routeguide.utils.b.a(true, (com.baidu.navisdk.framework.interfaces.pronavi.hd.f) null));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
    }

    public boolean a(ViewGroup viewGroup) {
        this.b = viewGroup;
        o0();
        y();
        return true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleEtaView", "getEnterDoubleMap: " + i + ",miniHDHeight:" + i2 + ", " + z);
        }
        if (this.B != null && z) {
            return w(i2);
        }
        return null;
    }
}

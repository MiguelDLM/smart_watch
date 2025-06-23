package com.baidu.navisdk.ui.routeguide.toolbox.view;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.widget.CustomLinearScrollView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.ui.routeguide.widget.d implements CustomLinearScrollView.OnStatusChangeListener {
    private TextView A;
    private View B;
    private TextView C;
    private TextView D;
    private TextView E;
    private View F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private View M;
    private TextView N;
    private ImageView O;
    private View P;
    private View Q;
    private ImageView R;
    private View S;
    private TextView T;
    private View U;
    private TextView V;
    private SparseArray<View> W;
    private com.baidu.navisdk.ui.routeguide.toolbox.present.b X;
    private ValueAnimator Y;
    private ValueAnimator Z;
    private boolean a0;
    private boolean b0;
    private int c0;
    private Animation d0;
    private Animation e0;
    private AnimationSet f0;
    private ViewGroup g0;
    private boolean h0;
    private final int i;
    private boolean i0;
    private final int j;
    private boolean j0;
    private ViewGroup k;
    private boolean k0;
    private View l;
    private String l0;
    private View m;
    private int m0;
    private View n;
    private boolean n0;
    private LinearLayout o;

    /* renamed from: o0, reason: collision with root package name */
    private MessageQueue.IdleHandler f9118o0;
    private CustomLinearScrollView p;
    private MessageQueue.IdleHandler p0;
    private ViewGroup q;
    private com.baidu.navisdk.ui.routeguide.toolbox.f q0;
    private View r;
    private com.baidu.navisdk.ui.routeguide.toolbox.d r0;
    private ViewGroup s;
    private boolean s0;
    private View t;
    private Handler t0;
    private View u;
    private View u0;
    private View v;
    private View v0;
    private View w;
    private com.baidu.navisdk.util.worker.f<String, String> w0;
    private View x;
    private View y;
    private TextView z;

    /* renamed from: com.baidu.navisdk.ui.routeguide.toolbox.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnTouchListenerC0481a implements View.OnTouchListener {
        public ViewOnTouchListenerC0481a(a aVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.n0();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9120a;

        public c(int i) {
            this.f9120a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int i = this.f9120a;
            if (intValue >= i) {
                a.this.y(i);
            } else {
                a.this.y(intValue);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (intValue <= 0) {
                a.this.y(0);
                if (a.this.a0) {
                    LogUtil.e("BNToolBoxView", "startExpandAnimation end - openBottomBar");
                    a.this.Q0();
                    a.this.a0 = false;
                    return;
                }
                return;
            }
            a.this.y(intValue);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements com.baidu.navisdk.ui.routeguide.toolbox.d {
        public e() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.d
        public void c() {
            a.this.o0();
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.d
        public void d() {
            a.this.n0();
        }
    }

    /* loaded from: classes8.dex */
    public class f extends com.baidu.navisdk.util.worker.loop.a {
        public f(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message.what == 1) {
                a.this.V0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.n0();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9125a;

        public h(int i) {
            this.f9125a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X.a(view, this.f9125a);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean gotoTop;
            if (((com.baidu.navisdk.ui.routeguide.widget.d) a.this).f == 1) {
                View view = (View) a.this.W.get(9 - com.baidu.navisdk.ui.routeguide.toolbox.c.f9114a.length);
                if (view != null) {
                    view.setVisibility(4);
                }
                if (a.this.Q != null) {
                    a.this.Q.setVisibility(4);
                }
            }
            if (a.this.p != null) {
                if (a.this.q0 != null && !a.this.q0.i()) {
                    gotoTop = a.this.p.gotoTopWithOutAnim();
                } else {
                    gotoTop = a.this.p.gotoTop();
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNToolBoxView", "openToolBox result :" + gotoTop);
                }
            } else if (LogUtil.LOGGABLE) {
                LogUtil.e("BNToolBoxView", "openToolBox mScrollView is null");
            }
            a.this.T0();
        }
    }

    /* loaded from: classes8.dex */
    public class j implements MessageQueue.IdleHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9127a;

        public j(int i) {
            this.f9127a = i;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            if (a.this.k(this.f9127a + "")) {
                a.this.B(0);
            } else {
                a.this.B(8);
            }
            a.this.f9118o0 = null;
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class k implements MessageQueue.IdleHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9128a;

        public k(int i) {
            this.f9128a = i;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            if (a.this.l(this.f9128a + "")) {
                a.this.C(0);
            } else {
                a.this.C(8);
            }
            a.this.p0 = null;
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements View.OnTouchListener {
        public l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && a.this.p != null && a.this.p.getCurStatus() == 0) {
                a.this.n0();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X.a(view, 12);
        }
    }

    /* loaded from: classes8.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.X.a(view, 13);
        }
    }

    /* loaded from: classes8.dex */
    public interface o {
        void a();
    }

    public a(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.i = com.baidu.navisdk.h.c();
        this.j = com.baidu.navisdk.ui.util.b.b(R.color.nsdk_rg_transparent);
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new SparseArray<>();
        this.X = null;
        this.a0 = false;
        this.b0 = true;
        this.c0 = 0;
        this.h0 = false;
        this.i0 = false;
        this.j0 = false;
        this.k0 = false;
        this.l0 = null;
        this.m0 = 1;
        this.n0 = false;
        this.t0 = new f("RGToolBoxView");
        this.w0 = new b("RGToolBoxView-autoHideTask", null);
        com.baidu.navisdk.framework.interfaces.k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k2 != null) {
            this.n0 = k2.o0();
        }
        this.k = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_toolbox_panel_container);
        z(false);
        a(com.baidu.navisdk.ui.util.b.b());
        N0();
        F(this.n0);
    }

    private void G(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.e()) {
            gVar.g("BNToolBoxView", "addToContainner fromOrientationChanged=" + z);
        }
        z(z);
        if (this.l == null) {
            if (gVar.a()) {
                gVar.a("Common: ", "addToContainner error mRootView is null");
                return;
            }
            return;
        }
        if (this.f == 1) {
            View I02 = I0();
            this.r = I02;
            if (I02 != null) {
                this.k.addView(I02);
            }
        }
        this.k.addView(this.l);
        h();
        f0();
        this.k.setOnTouchListener(new l());
        if (this.l.getVisibility() == 0) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
    }

    private void H(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView VIA_ETA", "clearViaEtaAnim -> isStopTimer = " + z);
        }
        View view = this.x;
        if (view != null && this.y != null) {
            view.clearAnimation();
            this.y.clearAnimation();
            this.y.setVisibility(8);
        }
        this.d0 = null;
        this.e0 = null;
        this.f0 = null;
        if (z) {
            this.t0.removeMessages(1);
        }
    }

    private View I0() {
        View view = new View(com.baidu.navisdk.framework.a.c().a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_bottom) + JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_bottom_panel_height));
        layoutParams.addRule(12);
        view.setLayoutParams(layoutParams);
        view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rg_bottombar_shadow));
        return view;
    }

    private void J0() {
        View findViewById;
        int i2;
        int i3 = 0;
        while (true) {
            int[] iArr = com.baidu.navisdk.ui.routeguide.toolbox.c.c;
            if (i3 < iArr.length) {
                int i4 = iArr[i3];
                if (this.f == 2 && i4 == (i2 = R.id.bnav_rg_main_eta_details_layout)) {
                    findViewById = this.b.findViewById(i2);
                } else {
                    findViewById = this.t.findViewById(i4);
                }
                if (findViewById != null) {
                    this.W.put(i3, findViewById);
                    findViewById.setOnClickListener(new h(com.baidu.navisdk.ui.routeguide.toolbox.c.b[i3]));
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private void K0() {
        LogUtil.e("BNToolBoxView", "initMultiRouteView->");
        if (x.b().s2()) {
            com.baidu.navisdk.ui.util.b.a((ViewStub) this.t.findViewById(R.id.bnav_rg_toolbox_resume_switch_layout_stub));
        }
        this.S = this.t.findViewById(R.id.bnav_rg_toolbox_resume_switch_layout);
        View findViewById = this.t.findViewById(R.id.bnav_rg_toolbox_resume_tv);
        View findViewById2 = this.t.findViewById(R.id.bnav_rg_toolbox_switch_route_tv);
        findViewById.setOnClickListener(new m());
        findViewById2.setOnClickListener(new n());
    }

    private void L0() {
        ViewGroup viewGroup;
        LogUtil.e("BNToolBoxView", "initOptionView!");
        com.baidu.navisdk.ui.routeguide.toolbox.f fVar = this.q0;
        if (fVar != null) {
            View e2 = fVar.e();
            if (e2.getParent() != null) {
                viewGroup = (ViewGroup) e2.getParent();
            } else {
                viewGroup = null;
            }
            if (viewGroup != null && viewGroup.getChildCount() > 0) {
                viewGroup.removeAllViews();
            }
            this.q.removeAllViews();
            this.q.addView(e2);
            com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = this.X;
            if (bVar != null) {
                bVar.a(this.q0.g());
            }
            this.s0 = true;
        }
    }

    private void M0() {
        if (this.r0 == null) {
            this.r0 = new e();
        }
    }

    private void N0() {
        com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = new com.baidu.navisdk.ui.routeguide.toolbox.present.b(this);
        this.X = bVar;
        com.baidu.navisdk.ui.routeguide.toolbox.f fVar = this.q0;
        if (fVar != null) {
            bVar.a(fVar.g());
        }
    }

    private void O0() {
        if (x.b().s2()) {
            com.baidu.navisdk.ui.util.b.a((ViewStub) this.t.findViewById(R.id.bnav_rg_toolbox_rp_watting_stub));
        }
        this.U = this.t.findViewById(R.id.bnav_rg_toolbox_rp_watting);
        this.V = (TextView) this.t.findViewById(R.id.bnav_rg_toolbox_rp_watting_tv);
        this.U.setOnTouchListener(new ViewOnTouchListenerC0481a(this));
    }

    private void P0() {
        View findViewById;
        if (x.b().s2()) {
            findViewById = this.t;
            com.baidu.navisdk.ui.util.b.a((ViewStub) findViewById.findViewById(R.id.bnav_rg_toolbox_via_time_and_dist_ly_stub));
        } else {
            findViewById = this.b.findViewById(R.id.bnav_rg_content_panel_land);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView VIA_ETA", "initViaEtaView->parent=" + findViewById);
        }
        if (findViewById != null) {
            this.y = findViewById.findViewById(R.id.bnav_rg_toolbox_via_time_and_dist_ly);
            this.z = (TextView) findViewById.findViewById(R.id.bnav_rg_toolbox_via_remain_time_and_dist);
            this.A = (TextView) findViewById.findViewById(R.id.bnav_rg_toolbox_via_arrive_title);
            this.J = (TextView) findViewById.findViewById(R.id.bnav_rg_toolbox_via_traffic_light_count);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        if (com.baidu.navisdk.function.b.FUNC_SETTING_BOTTOM_BAR.a() && BNSettingManager.isBottomBarOpen()) {
            if (!this.s0) {
                L0();
            }
            CustomLinearScrollView customLinearScrollView = this.p;
            if (customLinearScrollView != null) {
                customLinearScrollView.post(new i());
            }
            A(0);
            v(8);
            com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = this.X;
            if (bVar != null) {
                bVar.q();
                this.X.a();
            }
            s.T().o();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().m();
        }
    }

    private void R0() {
        ValueAnimator valueAnimator = this.Z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.Z = null;
        }
        ValueAnimator valueAnimator2 = this.Y;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.Y = null;
        }
        this.b0 = true;
        this.a0 = false;
        y(0);
    }

    private void S0() {
        this.S = null;
        this.y = null;
        this.U = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        com.baidu.navisdk.ui.routeguide.toolbox.f fVar = this.q0;
        if (fVar != null && !fVar.i()) {
            ViewGroup viewGroup = this.k;
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(this.i);
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = this.k;
        if (viewGroup2 != null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(viewGroup2, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, this.j, this.i);
            ofInt.setDuration(200L);
            ofInt.setEvaluator(new ArgbEvaluator());
            ofInt.start();
        }
    }

    private void U0() {
        com.baidu.navisdk.ui.routeguide.toolbox.f fVar = this.q0;
        if (fVar != null && !fVar.i()) {
            ViewGroup viewGroup = this.k;
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(this.j);
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = this.k;
        if (viewGroup2 != null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(viewGroup2, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, this.i, this.j);
            ofInt.setDuration(200L);
            ofInt.setEvaluator(new ArgbEvaluator());
            ofInt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView VIA_ETA", "startViaEtaAnim");
        }
        if (this.y == null) {
            P0();
        }
        if (this.x != null && this.y != null) {
            if (this.f0 == null || this.d0 == null || this.e0 == null) {
                AnimationSet animationSet = new AnimationSet(true);
                this.f0 = animationSet;
                animationSet.setFillAfter(true);
                this.d0 = AnimationUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_toolbox_eta_switch_in);
                this.e0 = AnimationUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_toolbox_eta_switch_out);
                this.f0.addAnimation(this.d0);
                this.f0.addAnimation(this.e0);
            }
            if (this.y.getAnimation() != null && this.y.getAnimation() != this.e0) {
                this.x.clearAnimation();
                this.y.clearAnimation();
                this.y.setAnimation(this.e0);
                this.x.setAnimation(this.d0);
            } else {
                this.x.clearAnimation();
                this.y.clearAnimation();
                this.x.setAnimation(this.e0);
                this.y.setAnimation(this.d0);
            }
            this.y.setVisibility(0);
            this.f0.start();
            if (this.t0.hasMessages(1)) {
                this.t0.removeMessages(1);
            }
            this.t0.sendEmptyMessageDelayed(1, 5000L);
        }
    }

    private void W0() {
        E(this.h0);
        C(this.i0);
        if (this.k0) {
            f(this.l0);
        } else {
            r0();
        }
        if (this.j0) {
            g(this.l0);
        } else {
            s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(String str) {
        int a2;
        int i2;
        View view = this.x;
        if (view == null || this.I == null) {
            return false;
        }
        int measuredWidth = view.getMeasuredWidth() - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_4dp);
        int a3 = a(this.I, str);
        if (x.b().s2()) {
            TextView textView = this.C;
            if (textView != null) {
                a2 = com.baidu.navisdk.ui.util.j.a(textView, textView.getText().toString());
                i2 = a2 + a3;
            }
            i2 = a3;
        } else {
            TextView textView2 = this.D;
            if (textView2 != null) {
                a2 = com.baidu.navisdk.ui.util.j.a(textView2, textView2.getText().toString());
                i2 = a2 + a3;
            }
            i2 = a3;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView", "isTrafficLightWidthEnough-> trafficLightCount= " + str + ", maxWidth= " + measuredWidth + ", needWidth" + i2 + ", trafficLightViewWidth= " + a3);
        }
        if (measuredWidth <= i2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(String str) {
        int i2;
        View view = this.y;
        if (view == null || this.J == null) {
            return false;
        }
        int measuredWidth = view.getMeasuredWidth() - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_4dp);
        int a2 = a(this.J, str);
        TextView textView = this.z;
        if (textView != null) {
            i2 = com.baidu.navisdk.ui.util.j.a(textView, textView.getText().toString()) + a2;
        } else {
            i2 = a2;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView", "isViaTrafficLightWidthEnough-> trafficLightCount= " + str + ", maxWidth= " + measuredWidth + ", needWidth" + i2 + ", trafficLightViewWidth= " + a2);
        }
        if (measuredWidth <= i2) {
            return false;
        }
        return true;
    }

    public boolean A(boolean z) {
        int i2;
        ViewGroup viewGroup = this.k;
        if (viewGroup == null) {
            return false;
        }
        if (z) {
            i2 = this.i;
        } else {
            i2 = this.j;
        }
        viewGroup.setBackgroundColor(i2);
        return true;
    }

    public void A0() {
        boolean z = true;
        if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
            this.a0 = true;
            x.b().B();
            return;
        }
        if (LogUtil.LOGGABLE && this.p != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("scrollError - openToolBox,");
            if (this.p.getScrollY() >= (-JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_210dp))) {
                z = false;
            }
            sb.append(z);
            LogUtil.e("CustomLinearScrollView", sb.toString());
            LogUtil.e("CustomLinearScrollView", "openToolBox - mScrollView.getScrollY() :" + this.p.getScrollY());
        }
        Q0();
    }

    public void B(boolean z) {
        LogUtil.e("BNToolBoxView", "setClearPoiVIewText : " + z + "mClearPoiView = " + this.T);
        if (z) {
            this.T.setText(R.string.nsdk_string_route_search_has_results_in_clear_view);
        } else {
            this.T.setText(R.string.nsdk_string_route_search_no_results_in_clear_view);
        }
    }

    public void B0() {
        int i2;
        TextView textView = this.G;
        if (textView != null) {
            if (com.baidu.navisdk.ui.routeguide.module.convoy.a.c) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
        }
    }

    public void C(boolean z) {
        LogUtil.e("BNToolBoxView", "showClearPoiView : " + z + ", mClearPoiView = " + this.T);
        TextView textView = this.T;
        if (textView != null || z) {
            if (z || textView.getVisibility() != 8) {
                this.i0 = z;
                this.T.setVisibility(z ? 0 : 8);
                boolean z2 = !z;
                D(z2);
                this.p.setScrollSupport(z2);
                n0();
            }
        }
    }

    public void C0() {
        if (this.n0) {
            return;
        }
        super.y();
        LogUtil.e("BNToolBoxView", "showToolBox :");
        if (this.k.getChildCount() == 0) {
            G(false);
            com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = this.X;
            if (bVar != null) {
                bVar.e();
            }
        }
        a(com.baidu.navisdk.ui.util.b.b());
        View view = this.l;
        if (view != null) {
            view.setVisibility(0);
        }
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        if (this.f == 2) {
            this.t.setVisibility(0);
        }
    }

    public void D(boolean z) {
        int i2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView", "showQuitAndMoreBtn(), show=" + z + ", mCurOrientation=" + this.f + "mClearPoiView.getVisibility()=" + this.T.getVisibility());
        }
        if (this.f == 2 && this.u0 != null && this.v0 != null) {
            int i3 = 0;
            if (z && this.T.getVisibility() == 0) {
                z = false;
            }
            View view = this.u0;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
            if (com.baidu.navisdk.function.b.FUNC_SETTING_BOTTOM_BAR.a()) {
                View view2 = this.v0;
                if (!z) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
            }
        }
    }

    public void D0() {
        LogUtil.e("BNToolBoxView", "startCollapseAnimation mIsExpandAnim - " + this.b0);
        this.b0 = false;
        int d2 = (com.baidu.navisdk.pronavi.util.a.h.d() / 2) - x.b().V();
        if (this.Y == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, d2);
            this.Y = ofInt;
            ofInt.setDuration(600L);
        }
        ValueAnimator valueAnimator = this.Z;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.Z.end();
            this.Z.cancel();
        }
        if (this.Y.isRunning()) {
            LogUtil.e("BNToolBoxView", "收缩动画已在进行中，return！");
        } else if (this.k != null) {
            this.Y.start();
            this.Y.addUpdateListener(new c(d2));
        }
    }

    public void E(boolean z) {
        int i2;
        View view;
        LogUtil.e("BNToolBoxView", "showResumeSwitchView : " + z);
        if (this.S == null) {
            if (z) {
                K0();
            } else {
                return;
            }
        }
        this.h0 = z;
        View view2 = this.S;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        view2.setVisibility(i2);
        TextView textView = this.K;
        if ((textView != null && textView.getVisibility() == 0) || ((view = this.U) != null && view.getVisibility() == 0)) {
            LogUtil.e("BNToolBoxView", "showResumeSwitchView loading view is show ");
        } else {
            this.p.setScrollSupport(!z);
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.c", "", null, null);
        }
    }

    public void E0() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            if (this.b0 && (layoutParams = viewGroup.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).leftMargin == 0) {
                LogUtil.e("BNToolBoxView", "toolbox.leftMargin = 0, return！");
                this.b0 = true;
                this.a0 = false;
                return;
            }
            this.b0 = true;
            if (this.Z == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt((com.baidu.navisdk.pronavi.util.a.h.d() / 2) - x.b().V(), 0);
                this.Z = ofInt;
                ofInt.setDuration(400L);
            }
            ValueAnimator valueAnimator = this.Y;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.Y.end();
                this.Y.cancel();
            }
            if (this.Z.isRunning()) {
                LogUtil.e("BNToolBoxView", "展开动画已在进行中，return！");
            } else if (this.k != null) {
                this.Z.start();
                this.Z.addUpdateListener(new d());
            }
        }
    }

    public void F(boolean z) {
        this.n0 = z;
        if (z) {
            t0();
        }
    }

    public void F0() {
        if (this.q != null && this.q0 != null && !com.baidu.navisdk.ui.routeguide.b.V().d().b(this.q0.b())) {
            M0();
            com.baidu.navisdk.ui.routeguide.toolbox.f a2 = com.baidu.navisdk.ui.routeguide.b.V().d().a(this.f9165a, this.r0, this.q0);
            this.q0 = a2;
            View e2 = a2.e();
            if (e2.getParent() != null) {
                ((ViewGroup) e2.getParent()).removeAllViews();
            }
            this.q.addView(e2);
            com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = this.X;
            if (bVar != null) {
                bVar.a(this.q0.g());
            }
        }
    }

    public void G0() {
        com.baidu.navisdk.ui.routeguide.toolbox.f fVar = this.q0;
        if (fVar != null) {
            fVar.h();
        }
    }

    public void H0() {
        com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = this.X;
        if (bVar != null) {
            bVar.b(7);
        }
    }

    public void a(int i2, int i3, Intent intent) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void f0() {
        super.f0();
        x.b().a(this.k);
    }

    public void n0() {
        boolean z;
        if (com.baidu.navisdk.function.b.FUNC_SETTING_BOTTOM_BAR.a() && BNSettingManager.isBottomBarOpen()) {
            if (this.p != null) {
                if (LogUtil.LOGGABLE) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("scrollError - closeToolBox,");
                    if (this.p.getScrollY() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    LogUtil.e("CustomLinearScrollView", sb.toString());
                    LogUtil.e("CustomLinearScrollView", "closeToolBox - mScrollView.getScrollY() :" + this.p.getScrollY());
                }
                com.baidu.navisdk.ui.routeguide.toolbox.f fVar = this.q0;
                if (fVar != null && !fVar.i()) {
                    this.p.gotoBottomWithOutAnim();
                } else {
                    this.p.gotoBottom();
                }
            }
            if (x0()) {
                U0();
            }
        }
    }

    public void o0() {
        boolean z;
        if (this.p != null) {
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("scrollError - closeToolBoxWithOutAnim,");
                if (this.p.getScrollY() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                LogUtil.e("CustomLinearScrollView", sb.toString());
                LogUtil.e("CustomLinearScrollView", "closeToolBoxWithOutAnim - mScrollView.getScrollY() :" + this.p.getScrollY());
            }
            this.p.gotoBottomWithOutAnim();
        }
        A(false);
    }

    @Override // com.baidu.navisdk.ui.widget.CustomLinearScrollView.OnStatusChangeListener
    public void onProgressChange(int i2) {
        LinearLayout linearLayout;
        View view;
        LogUtil.e("BNToolBoxView", "onProgressChange : " + i2);
        this.c0 = i2;
        if (i2 < 100 && !this.s0) {
            L0();
        }
        float f2 = i2 / 100.0f;
        if (this.f == 1 && (view = this.W.get(9 - com.baidu.navisdk.ui.routeguide.toolbox.c.f9114a.length)) != null) {
            view.setAlpha(f2);
            if (i2 < 90) {
                view.setVisibility(4);
            } else if (i2 > 90) {
                view.setVisibility(0);
            }
        }
        if (this.k != null) {
            this.k.setBackgroundColor(((int) ((1.0f - f2) * 0.5f * 255.0f)) * ((int) Math.pow(16.0d, 6.0d)));
            if (i2 > 98) {
                A(false);
            } else if (i2 < 2) {
                A(true);
            }
        }
        if (i2 > 0 && i2 < 100 && (linearLayout = this.o) != null && this.t != null) {
            if (linearLayout.getBackground() == null) {
                this.o.setBackgroundDrawable(t(R.drawable.bnav_rg_bg_tool_box));
            }
            if (this.t.getBackground() != null) {
                this.t.setBackgroundDrawable(null);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.widget.CustomLinearScrollView.OnStatusChangeListener
    public void onStatusChange(int i2) {
        LogUtil.e("BNToolBoxView", "onStatusChange :" + i2);
        if (this.W.size() < 1) {
            return;
        }
        if (i2 != 0) {
            if (i2 == 1) {
                if (this.f == 1) {
                    View view = this.Q;
                    if (view != null) {
                        view.setVisibility(0);
                        TextView textView = this.N;
                        if (textView != null) {
                            textView.setText("更多");
                            this.N.setTextColor(s(R.color.nsdk_cl_text_b_mm));
                        }
                        ImageView imageView = this.O;
                        if (imageView != null) {
                            imageView.setImageDrawable(t(R.drawable.nsdk_drawable_toolbox_icon_open_toolbox));
                        }
                    }
                    A(1);
                }
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.w0, false);
                this.m0 = 1;
                return;
            }
            return;
        }
        LogUtil.e("XDVoice", "CustomLinearScrollView.STATUS_TOP - XD stop!");
        com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
        if (this.f == 1) {
            View view2 = this.Q;
            if (view2 != null) {
                view2.setVisibility(4);
            }
            TextView textView2 = this.N;
            if (textView2 != null) {
                textView2.setText("收起");
                this.N.setTextColor(s(R.color.nsdk_cl_text_b_mm));
            }
            ImageView imageView2 = this.O;
            if (imageView2 != null) {
                imageView2.setImageDrawable(t(R.drawable.nsdk_drawable_toolbox_icon_close_toolbox));
            }
            A(0);
        }
        this.X.l();
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.w0, false);
        com.baidu.navisdk.util.worker.c.a().a(this.w0, new com.baidu.navisdk.util.worker.e(2, 0), 10000L);
        this.m0 = 0;
    }

    public com.baidu.navisdk.ui.routeguide.toolbox.present.b p0() {
        return this.X;
    }

    public int q0() {
        View view = this.t;
        if (view != null && view.getVisibility() == 0) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNToolBoxView", "getToolTitleBarHeight()");
            }
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_control_panel_btn_height) - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp);
        }
        return 0;
    }

    public void r0() {
        LogUtil.e("BNToolBoxView", "hideLoadingViewHasProgress");
        this.k0 = false;
        View view = this.U;
        if (view != null) {
            view.setVisibility(8);
        }
        CustomLinearScrollView customLinearScrollView = this.p;
        if (customLinearScrollView != null) {
            customLinearScrollView.setScrollSupport(true);
            D(true);
        }
    }

    public void s0() {
        LogUtil.e("BNToolBoxView", "hideLoadingViewNoProgress");
        this.j0 = false;
        int i2 = 8;
        this.K.setVisibility(8);
        View view = this.B;
        if (view != null) {
            view.setVisibility(0);
        }
        z(0);
        if (this.f == 1) {
            TextView textView = this.G;
            if (com.baidu.navisdk.ui.routeguide.module.convoy.a.c) {
                i2 = 0;
            }
            textView.setVisibility(i2);
            this.H.setVisibility(0);
        } else {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().E(true);
        }
        this.p.setScrollSupport(true);
        this.M.setEnabled(true);
        this.w.setEnabled(true);
        this.M.setAlpha(1.0f);
    }

    public void t0() {
        LogUtil.e("BNToolBoxView", "hideToolBox :");
        super.c();
        View view = this.l;
        if (view != null) {
            view.setVisibility(8);
        } else {
            LogUtil.e("BNToolBoxView", "showToolBox error");
        }
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        if (this.f == 2) {
            this.t.setVisibility(8);
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.w0, false);
    }

    public void u0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView VIA_ETA", "hideToolboxViaEta");
        }
        H(true);
    }

    public void v(int i2) {
        View view = this.P;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void w(int i2) {
        View view = this.t;
        if (view != null && this.f == 2 && com.baidu.navisdk.module.pronavi.a.j != 2) {
            view.setVisibility(i2);
        }
    }

    public boolean w0() {
        CustomLinearScrollView customLinearScrollView = this.p;
        if (customLinearScrollView != null) {
            return customLinearScrollView.mLastEventIsScroll;
        }
        return false;
    }

    public void x(int i2) {
        View view;
        LogUtil.e("BNToolBoxView", "setTopBarState : " + i2);
        if (i2 == 1) {
            if (this.f == 1 && (view = this.w) != null) {
                view.setVisibility(8);
            }
            TextView textView = this.L;
            if (textView != null) {
                textView.setText(RGFSMTable.FsmEvent.CONTINUE_NAVI);
                this.L.setVisibility(0);
                return;
            }
            return;
        }
        if (i2 == 0) {
            E(false);
            if (this.w != null && !com.baidu.navisdk.util.common.x.s()) {
                this.w.setVisibility(0);
            }
            TextView textView2 = this.L;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = this.X;
            if (bVar != null) {
                bVar.o();
            }
        }
    }

    public boolean x0() {
        CustomLinearScrollView customLinearScrollView = this.p;
        if (customLinearScrollView == null || customLinearScrollView.getCurStatus() != 0) {
            return false;
        }
        return true;
    }

    public void y(boolean z) {
        LogUtil.e("BNToolBoxView", "closeToolBox isNeedAnim:" + z);
        if (com.baidu.navisdk.function.b.FUNC_SETTING_BOTTOM_BAR.a() && BNSettingManager.isBottomBarOpen()) {
            if (this.p != null) {
                com.baidu.navisdk.ui.routeguide.toolbox.f fVar = this.q0;
                if (fVar != null && !fVar.i()) {
                    this.p.gotoBottomWithOutAnim();
                } else {
                    this.p.gotoBottom();
                }
            }
            if (x0() && z) {
                U0();
            }
        }
    }

    public boolean y0() {
        View view = this.S;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public View z(boolean z) {
        int i2 = this.f;
        if (i2 == 1 && this.m == null) {
            View a2 = com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.nsdk_layout_rg_mapmode_main_sub_toolbox_port);
            this.m = a2;
            if (a2 == null) {
                LogUtil.e("BNToolBoxView", "inflate fail mRootViewPort null");
                return null;
            }
        } else if (i2 == 2 && this.n == null) {
            View a3 = com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.nsdk_layout_rg_mapmode_main_sub_toolbox_land);
            this.n = a3;
            if (a3 == null) {
                LogUtil.e("BNToolBoxView", "inflate fail mRootViewLand null");
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) a3.findViewById(R.id.bnav_rg_toolbox_close_ll);
            this.g0 = viewGroup;
            viewGroup.setOnClickListener(new g());
        }
        if (this.f == 1) {
            this.n = null;
            View view = this.m;
            this.l = view;
            a(view);
            TextView textView = this.N;
            if (textView != null) {
                textView.setText("收起");
                this.N.setTextColor(s(R.color.nsdk_cl_text_b_mm));
            }
            ImageView imageView = this.O;
            if (imageView != null) {
                imageView.setImageDrawable(t(R.drawable.nsdk_drawable_toolbox_icon_close_toolbox));
            }
            this.q = (ViewGroup) this.l.findViewById(R.id.sub_scroll_layout);
        } else {
            this.m = null;
            this.l = this.n;
            a(this.b);
            this.q = (ViewGroup) this.l.findViewById(R.id.bnav_rg_toolbox_settings_container);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.l.setLayoutParams(layoutParams);
        CustomLinearScrollView customLinearScrollView = (CustomLinearScrollView) this.l.findViewById(R.id.bnav_rg_toolbox_scroollview);
        this.p = customLinearScrollView;
        this.o = (LinearLayout) customLinearScrollView.findViewById(R.id.bnav_rg_main_menu_layout);
        this.p.setInitScrollStatus(this.m0);
        this.p.addOnStatusChangeListener(this);
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.t.setVisibility(0);
        this.G.setVisibility(com.baidu.navisdk.ui.routeguide.module.convoy.a.c ? 0 : 8);
        M0();
        this.q0 = com.baidu.navisdk.ui.routeguide.b.V().d().a(this.f9165a, this.r0, this.q0);
        if (x0()) {
            L0();
        } else {
            View view2 = new View(this.f9165a);
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(1, this.q0.f());
            if (this.q.getChildCount() > 0) {
                this.q.removeAllViews();
            }
            this.q.addView(view2, layoutParams2);
            this.s0 = false;
        }
        com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = this.X;
        if (bVar != null) {
            bVar.j();
            this.X.p();
        }
        J0();
        this.b0 = true;
        return this.l;
    }

    public void z0() {
        LogUtil.e("BNToolBoxView", "onDestroy :");
        u0();
        this.W.clear();
        this.C = null;
        this.B = null;
        this.H = null;
        this.L = null;
        this.p = null;
        this.c0 = 0;
        com.baidu.navisdk.ui.routeguide.toolbox.f fVar = this.q0;
        if (fVar != null) {
            fVar.onDestroy();
            this.q0 = null;
        }
        if (this.f9118o0 != null) {
            Looper.myQueue().removeIdleHandler(this.f9118o0);
            this.f9118o0 = null;
        }
        if (this.p0 != null) {
            Looper.myQueue().removeIdleHandler(this.p0);
            this.p0 = null;
        }
    }

    public void d(int i2, int i3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView", "updateTrafficCount desCount: " + i2 + ", viaCount:" + i3 + ",mTrafficLightCount: " + this.I);
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNToolBoxView", "updateTrafficCount not main thread, return!");
                return;
            }
            return;
        }
        if (this.I != null) {
            if (this.f9118o0 != null) {
                Looper.myQueue().removeIdleHandler(this.f9118o0);
                this.f9118o0 = null;
            }
            if (i2 > 0) {
                this.I.setText(i2 + "");
                this.f9118o0 = new j(i2);
                Looper.myQueue().addIdleHandler(this.f9118o0);
            } else {
                B(8);
            }
        }
        if (this.J == null || com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.f() <= 0) {
            return;
        }
        if (this.p0 != null) {
            Looper.myQueue().removeIdleHandler(this.p0);
            this.p0 = null;
        }
        if (i3 > 0) {
            this.J.setText(i3 + "");
            this.p0 = new k(i3);
            Looper.myQueue().addIdleHandler(this.p0);
            return;
        }
        C(8);
    }

    public void f(String str) {
        if (this.U == null) {
            O0();
        }
        this.l0 = str;
        this.k0 = true;
        LogUtil.e("BNToolBoxView", "showLoadingViewHasProgress");
        this.U.setVisibility(0);
        this.V.setText(str);
        this.p.setScrollSupport(false);
        H(true);
        y(false);
    }

    public void g(String str) {
        LogUtil.e("BNToolBoxView", "showLoadingViewNoProgress");
        this.l0 = str;
        this.j0 = true;
        this.K.setText(str);
        this.K.setVisibility(0);
        if (this.f == 1) {
            View view = this.B;
            if (view != null) {
                view.setVisibility(8);
            }
            z(8);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
        }
        this.p.setScrollSupport(false);
        this.M.setEnabled(false);
        this.w.setEnabled(false);
        this.M.setAlpha(0.5f);
        H(true);
        n0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void h() {
        super.h();
        LogUtil.e("BNToolBoxView", "onSizeChange");
        Resources resources = JarUtils.getResources();
        int i2 = R.dimen.nsdk_rg_toolbox_margin_left;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i2);
        int dimensionPixelOffset2 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_1dp);
        if (x.b().e0() == 2) {
            int V = x.b().V() + dimensionPixelOffset2;
            b(V, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            a(V - JarUtils.getResources().getDimensionPixelOffset(i2), dimensionPixelOffset2, dimensionPixelOffset2, dimensionPixelOffset2);
        } else {
            b(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            a(dimensionPixelOffset2, dimensionPixelOffset2, dimensionPixelOffset2, dimensionPixelOffset2);
        }
    }

    public void i(String str) {
        LogUtil.e("BNToolBoxView", "updateArriveTime:" + str);
        TextView textView = this.H;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void j(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView VIA_ETA", "updateViaEtaDetails -> etaText = " + str + ", mHandler.hasMessages = " + this.t0.hasMessages(1));
        }
        if (!this.t0.hasMessages(1)) {
            this.t0.sendEmptyMessageDelayed(1, 5000L);
        }
        if (this.y == null) {
            P0();
        }
        if (this.A == null || this.z == null || l0.c(str)) {
            return;
        }
        if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.f() > 1) {
            this.A.setText("距最近途经点");
        } else {
            this.A.setText("距途经点");
        }
        this.z.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i2) {
        TextView textView = this.I;
        if (textView != null) {
            textView.setVisibility(i2);
        }
    }

    private void A(int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView", "setToolBarBackground(), scrollStatus=" + i2);
        }
        LinearLayout linearLayout = this.o;
        if (linearLayout == null || this.t == null) {
            return;
        }
        if (i2 == 1) {
            linearLayout.setBackgroundDrawable(null);
            com.baidu.navisdk.ui.util.b.a(this.t, R.drawable.bnav_rg_bg_tool_box);
        } else {
            com.baidu.navisdk.ui.util.b.a(linearLayout, R.drawable.bnav_rg_bg_tool_box);
            this.t.setBackgroundDrawable(null);
        }
    }

    private void b(View view) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView", "initEtaView-> isOrientationPortrait=" + x.b().s2());
        }
        this.w = view.findViewById(R.id.bnav_rg_main_eta_details_layout);
        if (com.baidu.navisdk.util.common.x.s()) {
            this.w.setVisibility(8);
        }
        this.x = view.findViewById(R.id.bnav_rg_toolbox_time_and_dist_ly);
        this.B = view.findViewById(R.id.bnav_rg_toolbox_remain_time_and_dist_content);
        if (x.b().s2()) {
            this.C = (TextView) view.findViewById(R.id.bnav_rg_toolbox_remain_time_and_dist);
            this.F = null;
            this.E = null;
            this.D = null;
        } else {
            this.C = null;
            this.F = view.findViewById(R.id.bnav_rg_toolbox_convoy_time_layout);
            this.E = (TextView) view.findViewById(R.id.bnav_rg_toolbox_remain_dist);
            this.D = (TextView) view.findViewById(R.id.bnav_rg_toolbox_remain_time);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView", "initEtaView-> mRemainTimeTv=" + this.C + ", mRemainDistLandTv=" + this.E + ", mRemainTimeLandTv=" + this.D);
        }
        this.G = (TextView) view.findViewById(R.id.bnav_rg_toolbox_convoy);
        this.H = (TextView) view.findViewById(R.id.bnav_rg_toolbox_arrive_time);
        this.I = (TextView) view.findViewById(R.id.bnav_rg_toolbox_traffic_light_count);
    }

    private void a(View view) {
        ViewGroup viewGroup = this.s;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.s.setVisibility(8);
        }
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.bnav_rg_toolbox_bottom_bar_container);
        this.s = viewGroup2;
        viewGroup2.setVisibility(0);
        int i2 = this.f;
        if (i2 == 1 && this.u == null) {
            this.v = null;
            this.u0 = null;
            this.v0 = null;
            this.u = com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.nsdk_layout_rg_mapmode_main_sub_toolbox_bottombar_port);
        } else if (i2 == 2 && this.v == null) {
            this.u = null;
            View a2 = com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.nsdk_layout_rg_mapmode_main_sub_toolbox_bottombar_land);
            this.v = a2;
            this.u0 = a2.findViewById(R.id.bnav_rg_toolbox_quit_ly);
            this.v0 = this.v.findViewById(R.id.bnav_rg_toolbox_open_close_ry);
        }
        if (this.f == 1) {
            this.t = this.u;
        } else {
            this.t = this.v;
        }
        this.K = (TextView) this.t.findViewById(R.id.bnav_rg_toolbox_loading_no_progress);
        this.L = (TextView) this.t.findViewById(R.id.bnav_rg_toolbox_continue_nav);
        this.M = this.t.findViewById(R.id.bnav_rg_toolbox_open_close_ry);
        if (!com.baidu.navisdk.function.b.FUNC_SETTING_BOTTOM_BAR.a()) {
            this.M.setVisibility(4);
            if (this.f == 2) {
                View view2 = this.v0;
                if (view2 != null) {
                    view2.setVisibility(4);
                }
                this.l.findViewById(R.id.bnav_rg_toolbox_open_close_divider).setVisibility(4);
            } else {
                this.t.findViewById(R.id.bnav_rg_toolbox_open_close_divider).setVisibility(4);
            }
        }
        this.N = (TextView) this.t.findViewById(R.id.bnav_rg_toolbox_open_close_tv);
        this.O = (ImageView) this.t.findViewById(R.id.bnav_rg_toolbox_open_close_iv);
        this.P = this.t.findViewById(R.id.bnav_rg_toolbox_new_tag_v);
        this.Q = this.t.findViewById(R.id.bnav_rg_toolbox_quit_divider);
        this.R = (ImageView) this.t.findViewById(R.id.bnav_rg_toolbox_quit_iv);
        this.T = (TextView) this.t.findViewById(R.id.bnav_rg_toolbox_clear_poi_tv);
        if (this.f == 1) {
            b(this.t);
        } else {
            b((ViewGroup) this.b.findViewById(R.id.bnav_rg_content_panel_land));
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().b(this.F);
        }
        com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = this.X;
        if (bVar != null) {
            bVar.j();
            this.X.p();
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M() != null) {
            this.s.addView(com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M());
        } else {
            this.s.addView(this.t);
        }
        if (this.f == 1) {
            CustomLinearScrollView customLinearScrollView = this.p;
            if (customLinearScrollView != null && customLinearScrollView.getCurStatus() == 0) {
                A(0);
            } else {
                A(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i2) {
        TextView textView = this.J;
        if (textView != null) {
            textView.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i2) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup viewGroup = this.k;
        if (viewGroup == null || (layoutParams = viewGroup.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).leftMargin = i2;
        this.k.requestLayout();
    }

    public void h(String str) {
        LogUtil.e("BNToolBoxView", "showLoadingViewNoProgress");
        x(0);
        this.K.setText(str);
        this.K.setVisibility(0);
        if (this.f == 1) {
            View view = this.B;
            if (view != null) {
                view.setVisibility(8);
            }
            z(8);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
        }
        this.p.setScrollSupport(false);
        this.M.setEnabled(false);
        this.w.setEnabled(false);
        n0();
    }

    public void b(ViewGroup viewGroup, int i2) {
        super.a(viewGroup, i2);
        H(false);
        R0();
        S0();
        this.k.removeAllViews();
        this.k = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_toolbox_panel_container);
        G(true);
        com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = this.X;
        if (bVar != null) {
            bVar.e();
        }
        if (x0()) {
            A(true);
        }
        int i3 = this.c0;
        if (i3 < 98 && i3 > 2) {
            n0();
        }
        a(com.baidu.navisdk.ui.util.b.b());
        W0();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView", "onOrientationChange(), orientation=" + i2 + ", mScrollView=" + this.p + ", mScrollView.getCurStatus()=" + this.p.getCurStatus() + ", mToolBoxStatus=" + this.m0);
        }
        int curStatus = this.p.getCurStatus();
        int i4 = this.m0;
        if (curStatus != i4) {
            if (i4 == 0) {
                A0();
            } else {
                n0();
            }
        }
    }

    private void b(int i2, int i3, int i4, int i5) {
        View view = this.l;
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).setMargins(i2, i3, i4, i5);
    }

    private void z(int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNToolBoxView", "setRemainTimeAndDistTvVisibility visibility: " + i2 + ", isOrientationPortrait= " + x.b().s2() + ", mRemainTimeTv=" + this.C + ", mRemainDistLandTv=" + this.E + ", mRemainTimeLandTv=" + this.D);
        }
        if (x.b().s2()) {
            TextView textView = this.C;
            if (textView != null) {
                textView.setVisibility(i2);
                return;
            }
            return;
        }
        TextView textView2 = this.E;
        if (textView2 == null || this.D == null) {
            return;
        }
        textView2.setVisibility(i2);
        this.D.setVisibility(i2);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        this.X.a(aVar);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        LogUtil.e("BNToolBoxView", "updateStyle day=" + z);
        super.a(z);
        TextView textView = this.H;
        if (textView != null && this.F != null && this.f == 2) {
            textView.setTextColor(s(R.color.nsdk_cl_text_a));
            this.F.setBackgroundDrawable(t(R.drawable.nsdk_drawable_rg_assist_eta_arrival_time_bg));
        }
        com.baidu.navisdk.ui.routeguide.toolbox.f fVar = this.q0;
        if (fVar != null) {
            fVar.a(z);
        }
        TextView textView2 = this.I;
        if (textView2 == null || this.f != 2) {
            return;
        }
        textView2.setTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_text_b_mm_title, false));
    }

    public void a(String str, String str2) {
        TextView textView;
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateRemainTimeAndDist remainDist");
            sb.append(str);
            sb.append(", remainTime:");
            sb.append(str2);
            sb.append(", mRemainTimeTv=");
            TextView textView2 = this.C;
            sb.append(textView2 == null ? "null" : Integer.valueOf(textView2.getVisibility()));
            sb.append(", mRemainTimeTv.isShow=");
            TextView textView3 = this.C;
            sb.append(textView3 == null ? "null" : Boolean.valueOf(textView3.isShown()));
            sb.append(", mRemainTimeTv.width=");
            TextView textView4 = this.C;
            sb.append(textView4 == null ? "null" : Integer.valueOf(textView4.getWidth()));
            sb.append(", mRemainTimeTv.height=");
            TextView textView5 = this.C;
            sb.append(textView5 == null ? "null" : Integer.valueOf(textView5.getHeight()));
            sb.append(", mRemainTimeTvContent=");
            View view = this.B;
            sb.append(view == null ? "null" : Integer.valueOf(view.getVisibility()));
            sb.append(", mRemainTimeTvContent.width=");
            View view2 = this.B;
            sb.append(view2 == null ? "null" : Integer.valueOf(view2.getWidth()));
            sb.append(", mRemainTimeTvContent.height=");
            View view3 = this.B;
            sb.append(view3 == null ? "null" : Integer.valueOf(view3.getHeight()));
            sb.append(", mRemainDistLandTv=");
            TextView textView6 = this.E;
            sb.append(textView6 == null ? "null" : Integer.valueOf(textView6.getVisibility()));
            sb.append(", mRemainTimeLandTv=");
            TextView textView7 = this.D;
            sb.append(textView7 != null ? Integer.valueOf(textView7.getVisibility()) : "null");
            LogUtil.e("BNToolBoxView", sb.toString());
        }
        if (!l0.c(str) && !l0.c(str2)) {
            if (x.b().s2()) {
                TextView textView8 = this.C;
                if (textView8 != null) {
                    textView8.setText(str + " " + str2);
                }
            } else if (this.D != null && (textView = this.E) != null) {
                textView.setText(str);
                this.D.setText(str2);
            }
            com.baidu.navisdk.ui.routeguide.toolbox.present.b bVar = this.X;
            if (bVar != null) {
                bVar.o();
                return;
            }
            return;
        }
        LogUtil.e("BNToolBoxView", "updateRemainTimeAndDist remainDist or remainTime is null, return!");
    }

    private int a(TextView textView, String str) {
        return com.baidu.navisdk.ui.util.j.a(textView, str) + JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_traffic_light_margin_left) + textView.getCompoundPaddingLeft();
    }

    private void a(int i2, int i3, int i4, int i5) {
        View view = this.r;
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) this.r.getLayoutParams()).setMargins(i2, i3, i4, i5);
        this.r.requestLayout();
    }
}

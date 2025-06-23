package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ugc.report.ui.UgcReportButton;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.routeguide.subview.widget.CircleProgressImageView;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class o extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.ui.routeguide.mapmode.iview.c {
    private static final int[] m0 = {R.id.bnav_rg_assist_top0_progressbar, R.id.bnav_rg_assist_top1_progressbar, R.id.bnav_rg_assist_top2_progressbar};
    private View A;
    private ImageView B;
    private TextView C;
    private View D;
    private ImageView E;
    private TextView F;
    private View G;
    private ImageView H;
    private TextView I;
    private View J;
    private ImageView K;
    private TextView L;
    private View M;
    private View N;
    private View O;
    private ImageView P;
    private TextView Q;
    private View R;
    private View S;
    private ImageView T;
    private TextView U;
    private View V;
    private View W;
    private ImageView X;
    private TextView Y;
    private RelativeLayout Z;
    private RelativeLayout a0;
    private View b0;
    private View c0;
    private ImageView d0;
    private ImageView e0;
    private p1 f0;
    private ValueAnimator g0;
    private ValueAnimator h0;
    boolean i;
    private final com.baidu.navisdk.ui.routeguide.mapmode.presenter.e i0;
    private ViewGroup j;
    private final com.baidu.navisdk.util.worker.f<String, String> j0;
    private ViewGroup k;
    private View.OnLayoutChangeListener k0;
    private r0 l;
    private a.q0 l0;
    private ViewGroup m;
    private ViewGroup n;
    private UgcReportButton o;
    private View p;
    private View q;
    private TextView r;
    private ImageView s;
    private View t;
    private ImageView u;
    private TextView v;
    private View w;
    private ImageView x;
    private TextView y;
    private View z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "1", null, "3");
            if (((com.baidu.navisdk.ui.routeguide.widget.d) o.this).c != null) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) o.this).c.a(6, 0, 2, null);
                o.this.M(false);
                o.this.B(true);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_quiet"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "0", null, "3");
            if (((com.baidu.navisdk.ui.routeguide.widget.d) o.this).c != null) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) o.this).c.a(6, 0, 0, null);
                o.this.M(false);
                o.this.B(true);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_play"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o.this.i0.d();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.l");
            o.this.i0.e();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (o.this.W != null && !o.this.W.isEnabled()) {
                return false;
            }
            return o.this.i0.a(motionEvent);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public f(o oVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnTouchListener {
        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && ((com.baidu.navisdk.ui.routeguide.widget.d) o.this).c != null) {
                if (com.baidu.navisdk.ui.routeguide.control.b.k().f() >= 20 && com.baidu.navisdk.ui.routeguide.b.V().A()) {
                    TipTool.onCreateToastDialog(view.getContext(), "已放大至最高级别");
                }
                ((com.baidu.navisdk.ui.routeguide.widget.d) o.this).c.k();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public h(o oVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnTouchListener {
        public i() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && ((com.baidu.navisdk.ui.routeguide.widget.d) o.this).c != null) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) o.this).c.a();
                if (com.baidu.navisdk.ui.routeguide.control.b.k().f() <= 5 && com.baidu.navisdk.ui.routeguide.b.V().A()) {
                    TipTool.onCreateToastDialog(view.getContext(), "已缩小到最小级别");
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public j(o oVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class k extends com.baidu.navisdk.util.worker.f<String, String> {
        public k(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (o.this.R == null) {
                return null;
            }
            o.this.R.setVisibility(8);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements a.q0 {

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.m.requestLayout();
            }
        }

        public l() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.a.q0
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.x.b().d(o.this.j);
            o.this.m.post(new a());
        }
    }

    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o.this.i0 != null) {
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.3");
                o.this.i0.a(view.getContext());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements ValueAnimator.AnimatorUpdateListener {
        public n() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.baidu.navisdk.ui.routeguide.utils.b.a(o.this.k, ((Integer) valueAnimator.getAnimatedValue()).intValue(), "left", false);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.o$o, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0460o implements ValueAnimator.AnimatorUpdateListener {
        public C0460o() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.baidu.navisdk.ui.routeguide.utils.b.a(o.this.k, ((Integer) valueAnimator.getAnimatedValue()).intValue(), "left", false);
        }
    }

    /* loaded from: classes8.dex */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o.this.R != null) {
                o.this.R.setVisibility(8);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().A(true);
        }
    }

    /* loaded from: classes8.dex */
    public class q implements View.OnLayoutChangeListener {

        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.util.worker.lite.b {
            public a(String str) {
                super(str);
            }

            @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
            public void run() {
                boolean G0 = o.this.G0();
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(com.baidu.navisdk.util.worker.g.TAG, "SafeguardView onLayoutChange: " + G0);
                }
            }
        }

        public q() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "SafeguardView onLayoutChange: , newHeight:" + (i4 - i2) + ", oldHeight:" + (i8 - i6));
            }
            if (i4 - i2 == i8 - i6 || o.this.n == null) {
                return;
            }
            if (!o.this.I0() && !o.this.J0()) {
                if (gVar.d()) {
                    gVar.e("RouteGuide", "SafeguardView handleShowOrHideSafeguardView: not need hide or show");
                    return;
                }
                return;
            }
            com.baidu.navisdk.util.worker.lite.a.c(new a("SafeDismissTip"));
        }
    }

    /* loaded from: classes8.dex */
    public class r implements View.OnTouchListener {
        public r() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return o.this.i0.c(motionEvent);
        }
    }

    /* loaded from: classes8.dex */
    public class s implements View.OnClickListener {
        public s(o oVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BNSettingManager.putBoolean(SettingParams.Key.EVER_SHOW_RG_MOSS_RED_POINT, true);
            if (o.this.i0 != null) {
                if (com.baidu.navisdk.ui.util.g.a()) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RouteGuide", "mProNavi2CommuteGuideLayout,fastDoubleClick");
                        return;
                    }
                    return;
                }
                if (com.baidu.navisdk.ui.routeguide.model.a0.I().q()) {
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e("RouteGuide", "mProNavi2CommuteGuideLayout,CarFree");
                        return;
                    }
                    return;
                }
                if (com.baidu.navisdk.ui.routeguide.model.a0.I().x()) {
                    com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar3.d()) {
                        gVar3.e("RouteGuide", "mProNavi2CommuteGuideLayout,isReRoutePlaning");
                        return;
                    }
                    return;
                }
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.v.8.1");
                o.this.i0.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements View.OnTouchListener {
        public u() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return o.this.i0.b(motionEvent);
        }
    }

    /* loaded from: classes8.dex */
    public class v implements View.OnClickListener {
        public v(o oVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.navisdk.function.b.FUNC_VOICE_PLAYER_BTN_FAST_SWITCH.a()) {
                o.this.F0();
            } else {
                o.this.R0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x implements View.OnClickListener {
        public x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "2", null, "3");
            if (((com.baidu.navisdk.ui.routeguide.widget.d) o.this).c != null) {
                ((com.baidu.navisdk.ui.routeguide.widget.d) o.this).c.a(6, 0, 3, null);
                o.this.M(false);
                o.this.B(true);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_justwarning"));
            }
        }
    }

    public o(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = false;
        this.j0 = new k("BNBaseView-autoHideTask", null);
        com.baidu.navisdk.framework.interfaces.k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k2 != null) {
            this.i = k2.X();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.e eVar = new com.baidu.navisdk.ui.routeguide.mapmode.presenter.e();
        this.i0 = eVar;
        I(false);
        eVar.a(this);
        a(true, false);
        e(true);
        a(com.baidu.navisdk.ui.util.b.b());
        F(this.i);
    }

    private void E0() {
        if (this.k0 != null) {
            return;
        }
        if (this.n != null && K0() && com.baidu.navisdk.module.newguide.a.e().d()) {
            if (this.k0 == null) {
                q qVar = new q();
                this.k0 = qVar;
                this.n.addOnLayoutChangeListener(qVar);
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "addLeftBottomBtnLayoutChangeListener: !isPortrait");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        String str;
        int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
        int i2 = 2;
        if (voiceMode == 2) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "0", null, "3");
            str = "asr_e_c_voice_mode_play";
            i2 = 0;
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "1", null, "3");
            str = "asr_e_c_voice_mode_quiet";
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "fastSwitchVoicePlay currentVoiceMode: " + voiceMode + ", setMode:" + i2);
        }
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        if (aVar != null) {
            aVar.a(6, 0, i2, null);
            B(true);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b(str));
        }
    }

    private boolean G(boolean z) {
        if (z) {
            if (!BNSettingManager.isVoiceButtonVisible()) {
                z = false;
            }
            if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                z = false;
            }
            if (RouteGuideParams.NavState.NAV_STATE_NAVING.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b()) || RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState()) || RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getTopState())) {
                z = false;
            }
            View view = this.z;
            if (view != null && view.getVisibility() == 0) {
                return false;
            }
            return z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "SafeguardView handleShowOrHideSafeguardView: ");
        }
        if (this.n == null) {
            return false;
        }
        if (!I0() && !J0()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "SafeguardView handleShowOrHideSafeguardView: not need hide or show");
            }
            return false;
        }
        if (H0()) {
            r0 r0Var = this.l;
            if (r0Var != null && r0Var.a()) {
                this.l.c();
            }
        } else {
            E(true);
        }
        return true;
    }

    private boolean H(boolean z) {
        boolean z2;
        TextView textView = this.U;
        if (textView != null) {
            int currentTextColor = textView.getCurrentTextColor();
            if (JarUtils.getResources() != null) {
                if (currentTextColor == JarUtils.getResources().getColor(R.color.nsdk_cl_text_h)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.e = z2;
            }
        }
        if (z != this.e) {
            return false;
        }
        return true;
    }

    private boolean H0() {
        if (!K0() || !com.baidu.navisdk.module.newguide.a.e().d()) {
            return false;
        }
        ViewGroup viewGroup = this.n;
        if (viewGroup == null) {
            return true;
        }
        int childCount = viewGroup.getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.n.getChildAt(i3);
            if (childAt != null && childAt.getVisibility() == 0 && childAt.getId() != R.id.bnav_rg_navi_safeguard_layout) {
                i2++;
            }
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "SafeguardView onVisibilityChanged onLayoutChange: " + i2);
        }
        if (i2 <= 0) {
            return false;
        }
        return true;
    }

    private void I(boolean z) {
        View view;
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) ((ViewStub) viewGroup.findViewById(R.id.bnav_rg_control_panel_stub)).inflate();
        this.j = viewGroup2;
        this.k = (ViewGroup) viewGroup2.findViewById(R.id.bnav_rg_control_panel_lb);
        this.m = (ViewGroup) this.j.findViewById(R.id.bnav_scale_and_logo_layout);
        this.n = (ViewGroup) this.j.findViewById(R.id.bnav_rg_left_bottom_control_btn_layout);
        this.o = (UgcReportButton) this.b.findViewById(R.id.bnav_rg_cp_ugc_report_innavi);
        this.p = this.b.findViewById(R.id.bnav_rg_navi_to_commute_guide_container);
        this.q = this.b.findViewById(R.id.bnav_rg_to_commute_red_point);
        if (!com.baidu.navisdk.j.d() && (view = this.p) != null) {
            view.setVisibility(8);
        }
        this.r = (TextView) this.b.findViewById(R.id.bnav_rg_to_commute_tv);
        this.s = (ImageView) this.b.findViewById(R.id.bnav_rg_to_commute_img);
        r0 r0Var = this.l;
        if (r0Var == null) {
            this.l = new r0(this.f9165a, this.b);
        } else if (z) {
            r0Var.a(this.b, this.f);
        }
        this.t = this.j.findViewById(R.id.bnav_rg_cp_traffic_panel);
        com.baidu.navisdk.ui.routeguide.control.x.b().d(this.j);
        this.l0 = new l();
        com.baidu.navisdk.ui.routeguide.control.x.b().a(this.l0);
        this.u = (ImageView) this.j.findViewById(R.id.bnav_rg_cp_traffic_panel_iv);
        this.v = (TextView) this.j.findViewById(R.id.bnav_rg_cp_traffic_panel_tv);
        this.z = this.j.findViewById(R.id.bnav_rg_cp_voice_mode_panel);
        this.A = this.j.findViewById(R.id.bnav_rg_cp_voice_mode_btn);
        this.B = (ImageView) this.j.findViewById(R.id.bnav_rg_cp_voice_mode_btn_iv);
        this.C = (TextView) this.j.findViewById(R.id.bnav_rg_cp_voice_mode_btn_tv);
        this.D = this.j.findViewById(R.id.bnav_rg_cp_voice_play_warning);
        this.E = (ImageView) this.j.findViewById(R.id.bnav_rg_cp_voice_play_warning_iv);
        this.F = (TextView) this.j.findViewById(R.id.bnav_rg_cp_voice_play_warning_tv);
        this.G = this.j.findViewById(R.id.bnav_rg_cp_voice_quiet);
        this.H = (ImageView) this.j.findViewById(R.id.bnav_rg_cp_voice_quiet_iv);
        this.I = (TextView) this.j.findViewById(R.id.bnav_rg_cp_voice_quiet_tv);
        this.J = this.j.findViewById(R.id.bnav_rg_cp_voice_open);
        this.K = (ImageView) this.j.findViewById(R.id.bnav_rg_cp_voice_open_iv);
        this.L = (TextView) this.j.findViewById(R.id.bnav_rg_cp_voice_open_tv);
        this.M = this.j.findViewById(R.id.bnav_rg_cp_voice_divider_1);
        this.N = this.j.findViewById(R.id.bnav_rg_cp_voice_divider_2);
        a(this.D.getPaddingTop(), this.D.getPaddingBottom(), this.M, this.N);
        this.O = this.j.findViewById(R.id.bnav_rg_cp_bluetooth_btn);
        this.P = (ImageView) this.j.findViewById(R.id.bnav_rg_cp_bluetooth_btn_iv);
        this.Q = (TextView) this.j.findViewById(R.id.bnav_rg_cp_bluetooth_btn_tv);
        this.R = this.j.findViewById(R.id.bnav_rg_cp_bluetooth_btn_tips);
        this.S = this.j.findViewById(R.id.bnav_rg_cp_refresh_road);
        this.T = (ImageView) this.j.findViewById(R.id.bnav_rg_cp_refresh_road_iv);
        this.U = (TextView) this.j.findViewById(R.id.bnav_rg_cp_refresh_road_tv);
        if (!com.baidu.navisdk.function.b.FUNC_REFRESH.a() || com.baidu.navisdk.ui.routeguide.b.V().F()) {
            this.S.setVisibility(8);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "initViews: mRefreshRoadView gone 1");
            }
        }
        this.V = this.j.findViewById(R.id.bnav_rg_control_panel_setting_btn);
        K(BNSettingManager.isSettingButtonVisible());
        this.W = this.j.findViewById(R.id.bnav_rg_cp_offline_to_online);
        this.X = (ImageView) this.j.findViewById(R.id.bnav_rg_cp_offline_to_online_iv);
        this.Y = (TextView) this.j.findViewById(R.id.bnav_rg_cp_offline_to_online_tv);
        this.Z = (RelativeLayout) this.j.findViewById(R.id.bnav_rg_cp_zoomin);
        this.a0 = (RelativeLayout) this.j.findViewById(R.id.bnav_rg_cp_zoomout);
        this.b0 = this.j.findViewById(R.id.bnav_rg_cp_zoom_ll);
        this.c0 = this.j.findViewById(R.id.bnav_rg_cp_zoom_divider);
        this.d0 = (ImageView) this.j.findViewById(R.id.bnav_rg_cp_zoomin_iv);
        this.e0 = (ImageView) this.j.findViewById(R.id.bnav_rg_cp_zoomout_iv);
        CircleProgressImageView[] circleProgressImageViewArr = new CircleProgressImageView[3];
        for (int i2 = 0; i2 < 3; i2++) {
            CircleProgressImageView circleProgressImageView = (CircleProgressImageView) this.b.findViewById(m0[i2]);
            circleProgressImageViewArr[i2] = circleProgressImageView;
            if (circleProgressImageView != null) {
                circleProgressImageView.setVisibility(8);
            }
        }
        if (circleProgressImageViewArr[0] != null) {
            com.baidu.navisdk.ui.routeguide.control.x.b().I().a(circleProgressImageViewArr);
        }
        if (this.f == 2 && !com.baidu.navisdk.module.newguide.a.e().d()) {
            com.baidu.navisdk.ui.routeguide.utils.b.a(this.k, com.baidu.navisdk.ui.routeguide.mapmode.a.o5().n0(), "bottom");
        }
        this.o.setOnTouchListener(new r());
        this.o.setOnClickListener(new s(this));
        View view2 = this.p;
        if (view2 != null) {
            view2.setOnClickListener(new t());
        }
        this.t.setOnTouchListener(new u());
        this.t.setOnClickListener(new v(this));
        this.A.setOnClickListener(new w());
        this.D.setOnClickListener(new x());
        this.G.setOnClickListener(new a());
        this.J.setOnClickListener(new b());
        this.O.setOnClickListener(new c());
        this.S.setOnClickListener(new d());
        this.W.setOnTouchListener(new e());
        this.W.setOnClickListener(new f(this));
        this.Z.setOnTouchListener(new g());
        this.Z.setOnClickListener(new h(this));
        this.a0.setOnTouchListener(new i());
        this.a0.setOnClickListener(new j(this));
        this.w = this.b.findViewById(R.id.travel_share_btn_container);
        this.x = (ImageView) this.b.findViewById(R.id.travel_share_btn);
        this.y = (TextView) this.b.findViewById(R.id.travel_share_tv);
        this.w.setOnClickListener(new m());
        z0();
        boolean z2 = com.baidu.navisdk.ui.routeguide.control.x.b().C0;
        D(false);
        com.baidu.navisdk.ui.routeguide.control.x.b().C0 = z2;
        if (this.f0 == null) {
            this.f0 = new p1(this.f9165a, this.b, this.c);
        }
        if (this.b0 != null) {
            if (com.baidu.navisdk.module.newguide.a.e().a(com.baidu.navisdk.pronavi.util.a.h.a(), K0()) && (com.baidu.navisdk.j.d() || BNSettingManager.isZoomButtonVisible())) {
                this.b0.setVisibility(0);
            } else {
                this.b0.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I0() {
        r0 r0Var;
        if (K0() && com.baidu.navisdk.module.newguide.a.e().d() && (r0Var = this.l) != null && r0Var.a()) {
            return true;
        }
        return false;
    }

    private void J(boolean z) {
        int i2;
        int i3 = 8;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        View view = this.A;
        if (view != null && view.getVisibility() != i2) {
            View view2 = this.A;
            if (z) {
                i3 = 0;
            }
            view2.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J0() {
        r0 r0Var = this.l;
        if (r0Var == null || r0Var.a() || !com.baidu.navisdk.module.navisafeguard.a.c().a() || com.baidu.navisdk.ui.routeguide.model.a0.I().D() || RGFSMTable.FsmState.Voice.equals(RouteGuideFSM.getInstance().getTopState()) || RGFSMTable.FsmState.ArriveDest.equals(RouteGuideFSM.getInstance().getCurrentState()) || RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getCurrentState()) || RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getCurrentState()) || RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getCurrentState()) || com.baidu.navisdk.module.pronavi.model.g.o().l() || com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k() || com.baidu.navisdk.module.pronavi.a.j == 2) {
            return false;
        }
        return true;
    }

    private void K(boolean z) {
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setSettingBtnVisibility-> show: " + z);
        }
        View view = this.V;
        if (view != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    private boolean K0() {
        if (com.baidu.navisdk.ui.routeguide.control.x.b().d0() == 1) {
            return true;
        }
        return false;
    }

    private void L(boolean z) {
        View view;
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setTrafficBtnVisibility-> show: " + z);
        }
        if ((!z || BNSettingManager.isRoadConditionButtonVisible()) && (view = this.t) != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    private boolean L0() {
        ViewGroup viewGroup = this.k;
        if (viewGroup == null || viewGroup.getLayoutParams() == null || ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).leftMargin <= JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_cp_icon_edge_margin)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z) {
        Object valueOf;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("setVoicePanelVisibility-> show: ");
            sb.append(z);
            sb.append(", LocationMode=");
            sb.append(com.baidu.navisdk.module.pronavi.a.j);
            sb.append(", NavState=");
            sb.append(com.baidu.navisdk.ui.routeguide.model.g.h().b());
            sb.append("VoiceCurModeBtn visibility=");
            View view = this.A;
            if (view == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(view.getVisibility());
            }
            sb.append(valueOf);
            gVar.e("RouteGuide", sb.toString());
        }
        if (z && !BNSettingManager.isVoiceButtonVisible()) {
            return;
        }
        int i2 = 0;
        if (z) {
            if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                z = false;
            }
            if (RouteGuideParams.NavState.NAV_STATE_NAVING.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b()) || RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState()) || RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getTopState())) {
                z = false;
            }
            View view2 = this.A;
            if (view2 != null && view2.getVisibility() == 0) {
                z = false;
            }
        }
        View view3 = this.z;
        if (view3 != null) {
            if (!z) {
                i2 = 8;
            }
            if (i2 != view3.getVisibility()) {
                this.z.setVisibility(i2);
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().C0 = z;
        }
        if (z) {
            View view4 = this.D;
            if (view4 != null && this.G != null && this.J != null) {
                view4.setBackgroundDrawable(t(R.drawable.nsdk_rg_cp_voice_left_btn_bg));
                this.G.setBackgroundDrawable(t(R.drawable.nsdk_rg_cp_voice_middle_btn_bg));
                this.J.setBackgroundDrawable(t(R.drawable.nsdk_rg_cp_voice_right_btn_bg));
            }
            View view5 = this.M;
            if (view5 != null && this.N != null) {
                int i3 = R.color.nsdk_rg_cp_voice_panel_item_divider_color;
                view5.setBackgroundColor(s(i3));
                this.N.setBackgroundColor(s(i3));
            }
            T0();
        }
    }

    private void M0() {
        if (this.A != null && this.B != null && this.F != null) {
            int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
            this.A.setBackgroundDrawable(t(R.drawable.nsdk_rg_selector_common_control_btn_bg));
            TextView textView = this.C;
            int i2 = R.color.nsdk_cl_text_h;
            textView.setTextColor(s(i2));
            if (voiceMode != 0 && voiceMode != 1) {
                if (voiceMode != 2) {
                    if (voiceMode == 3) {
                        this.B.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_warning_off));
                        this.C.setText("仅提示音");
                        return;
                    }
                    return;
                }
                this.B.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_quiet_off));
                this.C.setTextColor(s(i2));
                this.C.setText("导航静音");
                return;
            }
            this.B.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_open_off));
            this.C.setText("导航播报");
        }
    }

    private void N(boolean z) {
        float f2;
        RelativeLayout relativeLayout = this.Z;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(z);
            View childAt = this.Z.getChildAt(0);
            if (z) {
                f2 = 1.0f;
            } else {
                f2 = 0.2f;
            }
            childAt.setAlpha(f2);
        }
    }

    private void N0() {
        View.OnLayoutChangeListener onLayoutChangeListener;
        ViewGroup viewGroup = this.n;
        if (viewGroup != null && (onLayoutChangeListener = this.k0) != null) {
            viewGroup.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        this.k0 = null;
    }

    private void O(boolean z) {
        float f2;
        RelativeLayout relativeLayout = this.a0;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(z);
            View childAt = this.a0.getChildAt(0);
            if (z) {
                f2 = 1.0f;
            } else {
                f2 = 0.2f;
            }
            childAt.setAlpha(f2);
        }
    }

    private void O0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "resetLeftViewsLocation");
        }
        com.baidu.navisdk.ui.routeguide.utils.b.a(this.k, 0, "left", false);
    }

    private void P0() {
        View view = this.w;
        if (view != null) {
            view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rg_selector_common_control_btn_bg));
        }
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_operate_state_travel_share_btn));
        }
        TextView textView = this.y;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_h));
        }
    }

    private void Q0() {
        ViewGroup viewGroup;
        if (com.baidu.navisdk.function.b.FUNC_BLUETOOTH_SOUND.a() && this.R != null && (viewGroup = this.j) != null) {
            TextView textView = (TextView) viewGroup.findViewById(R.id.bnav_rg_cp_bluetooth_btn_tips_title);
            String d2 = com.baidu.navisdk.bluetooth.b.i().d();
            if (d2.length() > 7) {
                d2 = d2.substring(0, 7) + "...";
            }
            textView.setText("已连接蓝牙 " + d2);
            this.R.setVisibility(0);
            this.R.setOnClickListener(new p());
            com.baidu.navisdk.util.worker.c.a().a(this.j0, new com.baidu.navisdk.util.worker.e(2, 0), 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.7.1");
        B(false);
        M(true);
        com.baidu.navisdk.ui.routeguide.control.x.b().a(0L);
    }

    private void S0() {
        View view = this.O;
        if (view != null && this.P != null && this.Q != null) {
            view.setBackgroundDrawable(t(R.drawable.nsdk_rg_selector_common_control_btn_bg));
            this.P.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_bluetooth));
            this.Q.setTextColor(s(R.color.nsdk_cl_text_h));
        }
    }

    private void T0() {
        if (this.E != null && this.F != null && this.H != null && this.I != null && this.K != null && this.L != null) {
            int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
            if (voiceMode != 0 && voiceMode != 1) {
                if (voiceMode != 2) {
                    if (voiceMode == 3) {
                        this.E.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_warning_on));
                        this.F.setTextColor(s(R.color.nsdk_cl_text_g));
                        this.H.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_quiet_off));
                        TextView textView = this.I;
                        int i2 = R.color.nsdk_cl_text_h;
                        textView.setTextColor(s(i2));
                        this.K.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_open_off));
                        this.L.setTextColor(s(i2));
                        return;
                    }
                    return;
                }
                this.E.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_warning_off));
                TextView textView2 = this.F;
                int i3 = R.color.nsdk_cl_text_h;
                textView2.setTextColor(s(i3));
                this.H.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_quiet_on));
                this.I.setTextColor(s(R.color.nsdk_cl_text_g));
                this.K.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_open_off));
                this.L.setTextColor(s(i3));
                return;
            }
            this.E.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_warning_off));
            TextView textView3 = this.F;
            int i4 = R.color.nsdk_cl_text_h;
            textView3.setTextColor(s(i4));
            this.H.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_quiet_off));
            this.I.setTextColor(s(i4));
            this.K.setImageDrawable(t(R.drawable.nsdk_drawable_rg_cp_voice_open_on));
            this.L.setTextColor(s(R.color.nsdk_cl_text_g));
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "updateCurrentVoiceItem-> view == null!!");
        }
    }

    public void A(boolean z) {
        boolean z2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("setRefreshRoadAndOfflineToOnlineBtnVisibility-> show= ");
            sb.append(z);
            sb.append(", isNetworkAvailable= ");
            sb.append(com.baidu.navisdk.util.common.z.b(this.f9165a));
            sb.append(", isEnable= ");
            sb.append(com.baidu.navisdk.module.pronavi.model.i.f().c());
            sb.append(", isCurDriveRouteOnline= ");
            sb.append(BNRouteGuider.getInstance().isCurDriveRouteOnline());
            sb.append(", hasVia= ");
            if (JNIGuidanceControl.getInstance().getViaCnt() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            sb.append(z2);
            gVar.e("RouteGuide", sb.toString());
            gVar.e("Map", "mRefreshRoadView. BNRoutePlaner.getInstance().getEngineCalcRouteNetMode() = " + BNRoutePlaner.getInstance().e());
        }
        if (this.S != null && this.W != null) {
            if (z && BNSettingManager.isRefreshButtonVisible()) {
                if (BNRouteGuider.getInstance().isCurDriveRouteOnline()) {
                    if (com.baidu.navisdk.util.common.z.b(this.f9165a) && com.baidu.navisdk.module.pronavi.model.i.f().c() && JNIGuidanceControl.getInstance().getViaCnt() == 0) {
                        if (com.baidu.navisdk.function.b.FUNC_REFRESH.a() && !com.baidu.navisdk.ui.routeguide.b.V().F()) {
                            this.S.setVisibility(0);
                        }
                        this.W.setVisibility(8);
                        if (gVar.d()) {
                            gVar.e("RouteGuide", "mRefreshRoadView: not visible 1");
                        }
                    }
                } else if (BNRoutePlaner.getInstance().B()) {
                    this.S.setVisibility(8);
                    this.W.setVisibility(0);
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.3", "1", null, null);
                    if (gVar.d()) {
                        gVar.e("RouteGuide", "mRefreshRoadView: gone 2");
                    }
                }
            } else {
                this.S.setVisibility(8);
                this.W.setVisibility(8);
                if (gVar.d()) {
                    gVar.e("RouteGuide", "mRefreshRoadView: gone 3");
                }
            }
        }
        y(!com.baidu.navisdk.ui.routeguide.control.s.T().k(110));
    }

    public void A0() {
        if (BNCommSettingManager.getInstance().isRoadCondOnOrOff()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.2", "", null, "1");
            if (com.baidu.navisdk.util.common.z.b(com.baidu.navisdk.framework.a.c().a())) {
                this.c.c(true);
            }
            p(BNCommSettingManager.getInstance().isRoadCondOnOrOff());
        }
    }

    public void B(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setVoiceCurModeVisibility-> show: " + z + ", LocationMode=" + com.baidu.navisdk.module.pronavi.a.j + ", NavState=" + com.baidu.navisdk.ui.routeguide.model.g.h().b() + "ViceModePanel visibility=" + this.z.getVisibility());
        }
        M0();
        J(G(z));
    }

    public void B0() {
        p1 p1Var = this.f0;
        if (p1Var != null) {
            p1Var.o0();
        }
    }

    public void C(boolean z) {
        if (this.O == null || com.baidu.navisdk.module.newguide.a.e().d() || !com.baidu.navisdk.function.b.FUNC_BLUETOOTH_SOUND.a()) {
            return;
        }
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            z = false;
        }
        if (z) {
            if (!BNCommSettingManager.getInstance().isBluetoothGuideShowed()) {
                Q0();
                BNCommSettingManager.getInstance().setBluetoothGuideShowed();
            }
            S0();
            this.O.setVisibility(0);
            return;
        }
        this.O.setVisibility(8);
        View view = this.R;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void C0() {
        if (this.A.getVisibility() == 0) {
            this.A.setBackgroundDrawable(t(R.drawable.nsdk_rg_selector_common_control_btn_bg));
            B(true);
        }
        if (this.z.getVisibility() == 0) {
            View view = this.D;
            if (view != null && this.G != null && this.J != null) {
                view.setBackgroundDrawable(t(R.drawable.nsdk_rg_cp_voice_left_btn_bg));
                this.G.setBackgroundDrawable(t(R.drawable.nsdk_rg_cp_voice_middle_btn_bg));
                this.G.setBackgroundDrawable(t(R.drawable.nsdk_rg_cp_voice_right_btn_bg));
            }
            View view2 = this.M;
            if (view2 != null && this.N != null) {
                int i2 = R.color.nsdk_rg_cp_voice_panel_item_divider_color;
                view2.setBackgroundColor(s(i2));
                this.N.setBackgroundColor(s(i2));
            }
            M(true);
        }
    }

    public void D(boolean z) {
        String str;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        if (this.i) {
            z = false;
        }
        com.baidu.navisdk.ui.routeguide.model.g h2 = com.baidu.navisdk.ui.routeguide.model.g.h();
        if (z) {
            str = RouteGuideParams.NavState.NAV_STATE_OPERATE;
        } else {
            str = RouteGuideParams.NavState.NAV_STATE_NAVING;
        }
        h2.a(str);
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            i2 = 8;
        }
        boolean z6 = true;
        if (i2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        L(z2);
        if (i2 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        a(z3, true);
        if (i2 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        e(z4);
        if (z && com.baidu.navisdk.bluetooth.b.i().f()) {
            z5 = true;
        } else {
            z5 = false;
        }
        C(z5);
        if (z) {
            if (com.baidu.navisdk.ui.routeguide.control.x.b().C0) {
                B(false);
                M(true);
            } else {
                M(false);
                B(true);
            }
            E(false);
        } else {
            B(false);
            M(false);
            E(true);
        }
        if (i2 != 0) {
            z6 = false;
        }
        A(z6);
        if (i2 == 0 && !com.baidu.navisdk.module.newguide.a.e().a(com.baidu.navisdk.pronavi.util.a.h.a(), K0())) {
            i3 = 8;
        } else {
            i3 = i2;
        }
        RelativeLayout relativeLayout = this.Z;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i3);
        }
        RelativeLayout relativeLayout2 = this.a0;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(i3);
        }
        if (this.b0 != null) {
            if (i3 == 0 && (com.baidu.navisdk.j.d() || BNSettingManager.isZoomButtonVisible())) {
                this.b0.setVisibility(0);
            } else {
                this.b0.setVisibility(8);
            }
        }
        if (!com.baidu.navisdk.ui.routeguide.asr.c.n().g()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().I().d(i2);
        }
        if (this.w != null) {
            if (!com.baidu.navisdk.module.international.a.b() && !com.baidu.navisdk.framework.b.O()) {
                if (com.baidu.navisdk.function.b.FUNC_TRAVEL_SHARE.a()) {
                    this.w.setVisibility(i2);
                }
            } else {
                this.w.setVisibility(8);
            }
        }
        P0();
    }

    public void D0() {
        int f2 = com.baidu.navisdk.ui.routeguide.control.b.k().f();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("Map", "updateZoomButton. level = " + f2);
        }
        if (f2 <= 4) {
            N(true);
            O(false);
        } else if (f2 >= 21) {
            N(false);
            O(true);
        } else {
            N(true);
            O(true);
        }
    }

    public void E(boolean z) {
        if (this.l == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "showNaviSafeguardBtn->show=" + z + ", mNaviSafeguardView == null");
                return;
            }
            return;
        }
        boolean z2 = false;
        if (z && com.baidu.navisdk.module.newguide.a.e().d() && !K0()) {
            z = false;
        }
        if (z && (!com.baidu.navisdk.module.navisafeguard.a.c().a() || com.baidu.navisdk.ui.routeguide.model.a0.I().D() || RGFSMTable.FsmState.Voice.equals(RouteGuideFSM.getInstance().getTopState()) || RGFSMTable.FsmState.ArriveDest.equals(RouteGuideFSM.getInstance().getCurrentState()) || RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getCurrentState()) || RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getCurrentState()) || RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getCurrentState()) || com.baidu.navisdk.module.pronavi.model.g.o().l() || com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k() || com.baidu.navisdk.module.pronavi.a.j == 2)) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RouteGuide", "showNaviSafeguardBtn: 与其他场景发生互斥，show = false");
            }
            z = false;
        }
        if (z) {
            E0();
        }
        if (!z || !H0()) {
            z2 = z;
        }
        if (z2) {
            this.l.y();
        } else if (this.l.a()) {
            this.l.c();
        }
    }

    public void F(boolean z) {
        this.i = z;
        if (z) {
            c();
            D(false);
        }
    }

    public void n0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "cancelViewsMoveAnim");
        }
        ValueAnimator valueAnimator = this.g0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.h0;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        O0();
    }

    public void o0() {
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.presenter.e p0() {
        return this.i0;
    }

    public void q0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "hideVoiceAlwaysView");
        }
        View view = this.w;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void r0() {
        p1 p1Var = this.f0;
        if (p1Var != null) {
            p1Var.n0();
        }
    }

    public void s0() {
        p1 p1Var = this.f0;
        if (p1Var != null) {
            p1Var.c();
        }
    }

    public void t0() {
        if (this.f == 2 && !com.baidu.navisdk.module.newguide.a.e().d()) {
            com.baidu.navisdk.ui.routeguide.utils.b.a(this.k, 0, "bottom");
        }
    }

    public void u0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "moveLeftViews, leftViewsAlreadyMove = " + L0());
        }
        if (!L0()) {
            return;
        }
        int R = com.baidu.navisdk.ui.routeguide.control.x.b().R() - com.baidu.navisdk.ui.routeguide.control.x.b().V();
        ValueAnimator valueAnimator = this.h0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "moveLeftViews, moveRightAnim.isRunning(), cancel moveRightAnim!");
            }
            this.h0.cancel();
        }
        ValueAnimator valueAnimator2 = this.g0;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "moveLeftViews, moveLeftAnim.isRunning(), cancel moveLeftAnim!");
            }
            this.g0.cancel();
        }
        ValueAnimator valueAnimator3 = new ValueAnimator();
        this.g0 = valueAnimator3;
        valueAnimator3.setIntValues(R, 0);
        this.g0.setDuration(400L);
        this.g0.addUpdateListener(new C0460o());
        this.g0.start();
    }

    public void w0() {
        int R;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "moveRightViews, leftViewsAlreadyMove = " + L0());
        }
        if (L0() || (R = com.baidu.navisdk.ui.routeguide.control.x.b().R() - com.baidu.navisdk.ui.routeguide.control.x.b().V()) < 0) {
            return;
        }
        ValueAnimator valueAnimator = this.h0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "moveRightViews, moveRightAnim.isRunning(), cancel moveRightAnim!");
            }
            this.h0.cancel();
        }
        ValueAnimator valueAnimator2 = this.g0;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "moveRightViews, moveLeftAnim.isRunning(), cancel moveLeftAnim!");
            }
            this.g0.cancel();
        }
        ValueAnimator valueAnimator3 = new ValueAnimator();
        this.h0 = valueAnimator3;
        valueAnimator3.setIntValues(0, R);
        this.h0.setDuration(600L);
        this.h0.addUpdateListener(new n());
        this.h0.start();
    }

    public void x0() {
        if (this.f == 2 && !com.baidu.navisdk.module.newguide.a.e().d()) {
            com.baidu.navisdk.ui.routeguide.utils.b.a(this.k, com.baidu.navisdk.ui.routeguide.mapmode.a.o5().n0(), "bottom");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.i) {
            return false;
        }
        super.y();
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            a(false, true);
        } else {
            a(true, false);
        }
        e(true);
        com.baidu.navisdk.ui.routeguide.control.x.b().d(this.j);
        return true;
    }

    public void y0() {
        p1 p1Var;
        if (com.baidu.navisdk.j.d() && (p1Var = this.f0) != null) {
            p1Var.y();
        }
    }

    public void z(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setRefreshButtonEnable->enable=" + z);
        }
        ImageView imageView = this.T;
        if (imageView != null && this.U != null && this.S != null) {
            if (z) {
                imageView.setAlpha(1.0f);
                this.U.setAlpha(1.0f);
                this.S.setEnabled(true);
                return;
            } else {
                imageView.setAlpha(0.5f);
                this.U.setAlpha(0.5f);
                this.S.setEnabled(false);
                return;
            }
        }
        if (gVar.d()) {
            gVar.e("RouteGuide", "setRefreshButtonEnable->mRefreshRoadIv=" + this.T + ",mRefreshRoadTv=" + this.U + ",mRefreshRoadView=" + this.S);
        }
    }

    public void z0() {
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.ui.routeguide.model.g.h().b(4);
        }
        p(BNCommSettingManager.getInstance().isRoadCondOnOrOff());
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        D(false);
        a(false, true);
        e(false);
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.j0, true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void e(boolean z) {
        String str;
        String str2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "showToCommuteNaviBtn,show:" + z);
            gVar.e("RouteGuide", "showToCommuteNaviBtn,getLightCommutePreferMode:" + BNSettingManager.getLightCommutePreferMode());
            gVar.e("RouteGuide", "showToCommuteNaviBtn,currentState:" + RouteGuideFSM.getInstance().getCurrentState());
        }
        if (this.p != null) {
            if (!z) {
                a(false, "", "");
                return;
            }
            if (com.baidu.navisdk.module.vehiclemanager.b.i().b() != 1) {
                str = "非驾车";
            } else if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
                str = "偏航中";
            } else if (com.baidu.navisdk.ui.routeguide.model.a0.I().x()) {
                str = "算路中";
            } else if (RGFSMTable.FsmState.Voice.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                str = "语音态";
            } else if (RGFSMTable.FsmState.ArriveDest.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                str = "到达态";
            } else if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                str = "沿途搜态";
            } else if (com.baidu.navisdk.module.pronavi.model.g.o().l()) {
                str = "UI碰撞";
            } else if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                str = "模拟导航";
            } else if (!com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
                str = "横屏";
            } else if (BNRoutePlaner.getInstance().B()) {
                str = "离线算路";
            } else if (com.baidu.navisdk.ui.routeguide.b.V().q() == 3) {
                str = "极速导航";
            } else if (!com.baidu.navisdk.util.common.z.b(this.f9165a)) {
                str = "无网络";
            } else if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
                str = "室内导航";
            } else {
                str = com.baidu.navisdk.ui.routeguide.model.a0.I().q() ? "车标自由" : "";
            }
            com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
            boolean z2 = (fVar != null && fVar.h() == 2) || (fVar != null && fVar.h() == 1);
            boolean z3 = z2 && BNSettingManager.canShowCommuteEntrance();
            if (BNSettingManager.getLightCommutePreferMode() == 1 || z3) {
                a(true, str, "");
                return;
            }
            boolean equals = RGFSMTable.FsmState.SimpleGuide.equals(RouteGuideFSM.getInstance().getCurrentState());
            boolean equals2 = RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getCurrentState());
            if (equals) {
                if (this.i0.c()) {
                    if (!BNSettingManager.canShowCommuteEntrance()) {
                        str2 = "驾车页设置项关闭";
                    }
                    str2 = "";
                } else {
                    str2 = "引擎不展示";
                }
            } else if (equals2) {
                if (!z2) {
                    str2 = "算路未命中";
                }
                str2 = "";
            } else {
                str2 = "非操作态非浏览态";
            }
            if (!equals2 && !equals) {
                a(false, "", "");
                return;
            }
            int visibility = this.p.getVisibility();
            a(true, str, str2);
            int visibility2 = this.p.getVisibility();
            if (visibility != visibility2) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.8", visibility2 == 0 ? "0" : "1", equals2 ? "0" : "1", null);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void f() {
        if (TextUtils.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b(), RouteGuideParams.NavState.NAV_STATE_OPERATE)) {
            C(true);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void h(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onCollisionExceedMaxLine->isCollision=" + z);
        }
        boolean z2 = !z;
        a(z2, false);
        e(z2);
        E(z2);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        com.baidu.navisdk.util.drawable.a.a();
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.e eVar = this.i0;
        if (eVar != null) {
            eVar.a();
        }
        p1 p1Var = this.f0;
        if (p1Var != null) {
            p1Var.i();
            this.f0 = null;
        }
        N0();
        com.baidu.navisdk.ui.routeguide.control.x.b().b(this.l0);
        super.i();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void l() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void n() {
        if (TextUtils.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b(), RouteGuideParams.NavState.NAV_STATE_OPERATE)) {
            C(false);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void o(boolean z) {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void p(boolean z) {
        int i2;
        ImageView imageView = this.u;
        if (imageView != null) {
            if (z) {
                i2 = R.drawable.nsdk_drawable_common_btn_traffic_on;
            } else {
                i2 = R.drawable.nsdk_drawable_common_btn_traffic_off;
            }
            imageView.setImageDrawable(t(i2));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void t() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        if (aVar != null) {
            aVar.t();
        }
    }

    public void v(int i2) {
        ViewGroup viewGroup = this.n;
        if (viewGroup != null) {
            viewGroup.setVisibility(i2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i2) {
        super.a(viewGroup, i2);
        this.e = true;
        N0();
        I(true);
        a(com.baidu.navisdk.ui.util.b.b());
        n0();
        p1 p1Var = this.f0;
        if (p1Var != null) {
            p1Var.a(this.b, i2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void c(int i2) {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        if (aVar != null) {
            aVar.c(i2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void p() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onFlingMap(), hide voice panel");
        }
        M(false);
        J(G(true));
    }

    public void y(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setOfflineToOnlineButtonEnable->enable=" + z);
        }
        TextView textView = this.Y;
        if (textView != null && this.W != null && this.X != null) {
            if (z) {
                textView.setAlpha(1.0f);
                this.X.setAlpha(1.0f);
                this.W.setEnabled(true);
                return;
            } else {
                textView.setAlpha(0.51f);
                this.X.setAlpha(0.5f);
                this.W.setEnabled(false);
                return;
            }
        }
        if (gVar.d()) {
            gVar.e("RouteGuide", "setOfflineToOnlineButtonEnable->mOfflineToOnlineTv=" + this.Y + ",mOfflineToOnlineView=" + this.W + ",mOfflineToOnlineIv=" + this.X);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        View[] viewArr = new View[3];
        ViewGroup viewGroup = this.n;
        if (viewGroup != null && viewGroup.isShown()) {
            viewArr[0] = this.n;
        }
        View view = this.t;
        if (view != null && view.isShown()) {
            viewArr[1] = this.t;
        }
        View view2 = this.b0;
        if (view2 != null && view2.isShown()) {
            viewArr[2] = this.b0;
        }
        return viewArr;
    }

    private void a(int i2, int i3, View... viewArr) {
        for (View view : viewArr) {
            if (view != null && view.getLayoutParams() != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.topMargin = i2;
                marginLayoutParams.bottomMargin = i3;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        if (H(z)) {
            RelativeLayout relativeLayout = this.Z;
            if (relativeLayout == null || this.a0 == null) {
                return;
            }
            relativeLayout.setBackgroundDrawable(t(R.drawable.nsdk_rg_selector_zoom_in_btn));
            this.a0.setBackgroundDrawable(t(R.drawable.nsdk_rg_selector_zoom_out_btn));
            return;
        }
        super.a(z);
        RelativeLayout relativeLayout2 = this.Z;
        if (relativeLayout2 != null && this.a0 != null) {
            relativeLayout2.setBackgroundDrawable(t(R.drawable.nsdk_rg_selector_zoom_in_btn));
            this.a0.setBackgroundDrawable(t(R.drawable.nsdk_rg_selector_zoom_out_btn));
        }
        UgcReportButton ugcReportButton = this.o;
        if (ugcReportButton != null) {
            ugcReportButton.b();
        }
        if (this.Z == null || this.a0 == null || this.S == null || this.b0 == null || this.c0 == null || this.t == null) {
            return;
        }
        p(BNCommSettingManager.getInstance().isRoadCondOnOrOff());
        View view = this.t;
        int i2 = R.drawable.nsdk_rg_selector_common_control_btn_bg;
        view.setBackgroundDrawable(t(i2));
        TextView textView = this.v;
        int i3 = R.color.nsdk_cl_text_h;
        textView.setTextColor(s(i3));
        C0();
        View view2 = this.O;
        if (view2 != null && view2.getVisibility() == 0) {
            S0();
        }
        View view3 = this.S;
        int i4 = R.drawable.bnav_common_cp_refresh_button_selector;
        view3.setBackgroundDrawable(t(i4));
        this.W.setBackgroundDrawable(t(i4));
        this.c0.setBackgroundColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_cl_bg_a, this.e));
        this.T.setImageDrawable(t(R.drawable.nsdk_drawable_common_ic_avoid_traffic_refresh));
        this.X.setImageDrawable(t(R.drawable.nsdk_drawable_common_ic_offline_to_online));
        this.d0.setImageDrawable(t(R.drawable.nsdk_drawable_common_btn_zoom_in));
        this.e0.setImageDrawable(t(R.drawable.nsdk_drawable_common_btn_zoom_out));
        this.U.setTextColor(s(i3));
        this.Y.setTextColor(s(i3));
        P0();
        View view4 = this.p;
        if (view4 != null) {
            view4.setBackgroundDrawable(t(i2));
            this.r.setTextColor(s(i3));
            this.s.setImageDrawable(t(R.drawable.bnav_drawable_navi_to_commute_btn));
        }
    }

    @Deprecated
    private void a(boolean z, String str, String str2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "showToCommuteNaviBtn: specialLimit:" + str + ",curStateLimit:" + str2);
        }
        if (this.p != null) {
            boolean z2 = z && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2);
            if (com.baidu.navisdk.j.d()) {
                this.p.setVisibility(z2 ? 0 : 8);
                if (this.q != null) {
                    if (!BNSettingManager.getBoolean(SettingParams.Key.EVER_SHOW_RG_MOSS_RED_POINT, false)) {
                        this.q.setVisibility(0);
                    } else {
                        this.q.setVisibility(8);
                    }
                }
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.c
    public void a(boolean z, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "showUgcBtnLayout: visible --> " + z + ", immediately= " + z2 + "mAllowShowingUgcBtn=" + this.i0.b());
        }
        if (BNSettingManager.isUgcButtonEnable() && this.o != null) {
            if (!com.baidu.navisdk.function.b.FUNC_UGC_REPORT_BTN.a()) {
                this.o.setVisibility(8);
                if (gVar.d()) {
                    gVar.e("RouteGuide", "showUgcBtnLayout force hide , return!");
                    return;
                }
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.model.a0.I().D() || RGFSMTable.FsmState.ArriveDest.equals(RouteGuideFSM.getInstance().getTopState()) || RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getTopState()) || RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getTopState()) || RGFSMTable.FsmState.Voice.equals(RouteGuideFSM.getInstance().getTopState()) || com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k() || com.baidu.navisdk.module.pronavi.model.g.o().l()) {
                if (gVar.d()) {
                    gVar.e("RouteGuide", "showUgcBtnLayout: 与其他场景发生互斥，visible = false");
                }
                z = false;
            }
            if (z) {
                if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState()) || com.baidu.navisdk.j.d()) {
                    if (z2 || this.i0.b()) {
                        this.o.b();
                        this.o.setVisibility(0);
                        this.o.a();
                        return;
                    }
                    return;
                }
                return;
            }
            if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
                return;
            }
            this.o.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super.a(aVar);
        p1 p1Var = this.f0;
        if (p1Var != null) {
            p1Var.a(aVar);
        }
    }
}

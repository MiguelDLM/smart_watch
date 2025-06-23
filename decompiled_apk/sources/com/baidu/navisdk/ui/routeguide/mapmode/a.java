package com.baidu.navisdk.ui.routeguide.mapmode;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.Observer;
import com.baidu.ar.base.MsgField;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.framework.c;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.ar.BNARNaviEntrance;
import com.baidu.navisdk.module.newguide.subviews.guides.c;
import com.baidu.navisdk.pronavi.base.RGBaseUiFrame;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.b1;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.c1;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.d1;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.e1;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g1;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.h1;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.j1;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.q0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.s0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.t0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.u0;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.ui.routeguide.toolbox.view.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNImageCheckboxDialog;
import com.baidu.navisdk.ui.widget.BNImageTextDialog;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.ui.widget.BNQuitNaviDialog;
import com.baidu.navisdk.ui.widget.RGRootViewFrameLayout;
import com.baidu.navisdk.ui.widget.dialog.BNDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.jar.style.BNInflaterFactory;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: X0, reason: collision with root package name */
    private static final Object f8644X0 = new Object();
    private static volatile a Y0;
    private boolean B0;
    public boolean C0;
    public boolean D0;
    private com.baidu.navisdk.module.newguide.abs.a G0;
    private com.baidu.navisdk.pronavi.ui.other.a H0;

    /* renamed from: I0, reason: collision with root package name */
    private t0 f8645I0;
    private j1 J0;
    private com.baidu.navisdk.module.newguide.subviews.d K0;
    private BNARNaviEntrance L0;
    private ViewGroup M0;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.w N0;
    private com.baidu.navisdk.ui.routeguide.widget.volume.c R;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.e V;
    c.e V0;
    private com.baidu.navisdk.module.newguide.settings.c W;
    private com.baidu.navisdk.module.newguide.abs.b Y;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.r Z;

    /* renamed from: a, reason: collision with root package name */
    private d1 f8647a;
    private u0 a0;
    private Activity b;
    private b1 b0;
    private com.baidu.navisdk.ui.routeguide.mapmode.iview.e c0;
    private com.baidu.navisdk.ui.routeguide.mapmode.iview.g d0;
    private BNDialog e0;
    private BNQuitNaviDialog f0;
    private View g;
    private BNDialog g0;
    private int h;
    private ViewGroup i;
    private View j;
    private BNDialog j0;
    private int k;
    private BNDialog k0;
    private ViewGroup l;
    private BNImageTextDialog l0;
    private View m;
    private BNImageTextDialog m0;
    private int n;
    private BNImageTextDialog n0;

    /* renamed from: o0, reason: collision with root package name */
    private BNDialog f8648o0;
    private BNDialog p0;
    private com.baidu.navisdk.module.newguide.abs.c q;
    private BNDialog q0;
    private com.baidu.navisdk.ui.routeguide.subview.a r;
    private com.baidu.navisdk.util.common.d s;
    private View u0;
    private r0 y0;
    public boolean z0;
    private ViewGroup c = null;
    private FrameLayout d = null;
    private RGRootViewFrameLayout e = null;
    private int f = 1;
    private final ArrayList<q0> o = new ArrayList<>();
    private com.baidu.navisdk.pronavi.data.a p = new com.baidu.navisdk.pronavi.data.a();
    private com.baidu.navisdk.module.newguide.abs.e t = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.o u = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.e0 v = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.i w = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.u x = null;
    private com.baidu.navisdk.module.newguide.abs.d y = null;
    private h1 z = null;
    private g1 A = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.x B = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.j C = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.l0 D = null;
    private s0 E = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.p0 F = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.n G = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.h0 H = null;
    private c1 I = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 J = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.b K = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 L = null;
    private com.baidu.navisdk.module.newguide.interfaces.a M = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.c0 N = null;
    private BNMessageDialog O = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.k0 P = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.t Q = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.n0 S = null;
    private com.baidu.navisdk.ui.routeguide.widget.volume.e T = null;
    private com.baidu.navisdk.ui.routeguide.mapmode.iview.a U = null;
    private e1 X = null;
    private boolean h0 = false;
    private com.baidu.navisdk.ui.routeguide.subview.hud.a i0 = null;
    private BNCommonProgressDialog r0 = null;
    private BNCommonProgressDialog s0 = null;
    private BNCommonProgressDialog t0 = null;
    private boolean v0 = false;
    private int w0 = -1;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f8649x0 = false;
    private boolean A0 = false;
    private final com.baidu.navisdk.ui.routeguide.control.y E0 = new com.baidu.navisdk.ui.routeguide.control.y();
    public final Object F0 = new Object();

    /* renamed from: O0, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f8646O0 = new b0();
    private boolean P0 = false;
    final com.baidu.navisdk.util.worker.f<String, String> Q0 = new e("HideControlPanel", null);
    final com.baidu.navisdk.util.worker.f<String, String> R0 = new f("ExitRouteSearchMode", null);
    private boolean S0 = false;
    private final View.OnLayoutChangeListener T0 = new y();
    private BNImageCheckboxDialog U0 = null;
    com.baidu.navisdk.ui.routeguide.ar.a W0 = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0445a implements BNImageTextDialog.OnNaviClickListener {
        public C0445a(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.widget.BNImageTextDialog.OnNaviClickListener
        public void onClick() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.11", null, "2", null);
        }
    }

    /* loaded from: classes8.dex */
    public class a0 implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8650a;

        public a0(a aVar, View view) {
            this.f8650a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LogUtil.e("XDVoice", "startFuseDefaultModeGuidePanelAnim - onAnimationEnd - isRoused() = " + com.baidu.navisdk.ui.routeguide.asr.c.n().f());
            if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
                this.f8650a.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BNImageTextDialog.OnNaviClickListener {
        public b(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.widget.BNImageTextDialog.OnNaviClickListener
        public void onClick() {
            com.baidu.navisdk.ui.routeguide.b.V().a();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.11", null, "1", null);
        }
    }

    /* loaded from: classes8.dex */
    public class b0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public b0() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            int statusBarHeight;
            int i2;
            com.baidu.navisdk.ui.routeguide.control.g gVar;
            if (a.this.e == null) {
                com.baidu.navisdk.module.viewbound.a.e().d();
                return;
            }
            if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
                com.baidu.navisdk.module.viewbound.a.e().a();
                return;
            }
            if (!a.this.s2()) {
                Rect rect = new Rect();
                a.this.e.getGlobalVisibleRect(rect);
                if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                    i2 = -ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t);
                } else {
                    i2 = 0;
                }
                if (rect.left > 0) {
                    i2 = -ScreenUtil.getInstance().getNaviBarHeight();
                    if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                        i2 = (-ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t)) - ScreenUtil.getInstance().getNaviBarHeight();
                    }
                }
                i = 0;
            } else {
                if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
                    statusBarHeight = ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u);
                } else if (!com.baidu.navisdk.ui.routeguide.b.V().r().g()) {
                    statusBarHeight = ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
                } else {
                    i = 0;
                    i2 = 0;
                }
                i = -statusBarHeight;
                i2 = 0;
            }
            com.baidu.navisdk.module.viewbound.a.e().a(i2, i).a(a.this.q).a(a.this.J).a(a.this.w).a(a.this.u).a(a.this.K).a(a.this.C).a(a.this.Z).a(a.this.v).a((com.baidu.navisdk.framework.interfaces.y) a.this.c0).a(com.baidu.navisdk.ui.routeguide.control.s.T().g()).a(com.baidu.navisdk.ui.routeguide.b.V().u());
            com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
            if (j != null) {
                gVar = j.b();
            } else {
                gVar = null;
            }
            if (gVar != null) {
                com.baidu.navisdk.module.viewbound.a.e().a(gVar.b());
            }
            com.baidu.navisdk.module.viewbound.a.e().a(500L);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements BNDialog.OnNaviClickListener {
        public c() {
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            TipTool.onCreateToastDialog(a.this.b, JarUtils.getResources().getString(R.string.nsdk_string_rg_open_gps));
        }
    }

    /* loaded from: classes8.dex */
    public class c0 extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8653a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(String str, String str2, boolean z) {
            super(str, str2);
            this.f8653a = z;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (a.this.w != null) {
                if (com.baidu.navisdk.ui.routeguide.asr.c.n().i()) {
                    return null;
                }
                if (this.f8653a) {
                    if (!com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                        com.baidu.navisdk.ui.routeguide.control.x.b().I().d(0);
                    }
                } else {
                    com.baidu.navisdk.ui.routeguide.control.x.b().I().d(8);
                }
            }
            a.this.w3();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements BNDialog.OnNaviClickListener {
        public d() {
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            try {
                a.this.b.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } catch (Exception e) {
                LogUtil.e("", e.toString());
                TipTool.onCreateToastDialog(a.this.b, JarUtils.getResources().getString(R.string.nsdk_string_rg_no_gps));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d0 implements BNImageCheckboxDialog.OnClickListener {
        public d0() {
        }

        @Override // com.baidu.navisdk.ui.widget.BNImageCheckboxDialog.OnClickListener
        public void onAutoHide(int i) {
            if (i == 2) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.13.1.3", "2", null, null);
                BNCommSettingManager.getInstance().setNaviDayAndNightMode(1);
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.13.1.3", "1", null, null);
                BNCommSettingManager.getInstance().setNaviDayAndNightMode(2);
            }
            a.this.U0 = null;
        }

        @Override // com.baidu.navisdk.ui.widget.BNImageCheckboxDialog.OnClickListener
        public void onItemChecked(int i) {
            a.this.L0();
            if (i == 2) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.13.1.2", "2", null, null);
                BNCommSettingManager.getInstance().setNaviDayAndNightMode(1);
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.13.1.2", "1", null, null);
                BNCommSettingManager.getInstance().setNaviDayAndNightMode(2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends com.baidu.navisdk.util.worker.f<String, String> {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.l5();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class e0 implements View.OnClickListener {
        public e0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.T3();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.e.1", null, null, null);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends com.baidu.navisdk.util.worker.f<String, String> {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (a.this.r == null) {
                return null;
            }
            a.this.r.d();
            a.this.P0 = false;
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class f0 implements q0.a {

        /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.a$f0$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0446a implements Runnable {
            public RunnableC0446a(f0 f0Var) {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.navisdk.ui.routeguide.control.x.b().I().k();
                com.baidu.navisdk.ui.routeguide.control.x.b().I().g();
                com.baidu.navisdk.ui.routeguide.control.x.b().v0();
            }
        }

        public f0() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.q0.a
        public void a(boolean z) {
            com.baidu.navisdk.ui.routeguide.mapmode.presenter.f m0 = com.baidu.navisdk.ui.routeguide.control.x.b().m0();
            if (m0 != null) {
                if (z) {
                    m0.d();
                } else {
                    m0.i();
                }
            }
            if (a.this.I().s() != null) {
                a.this.I().s().post(new RunnableC0446a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements b.InterfaceC0197b {
        public g(a aVar) {
        }
    }

    /* loaded from: classes8.dex */
    public class g0 implements c.e {

        /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.a$g0$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0447a extends c.a {
            public C0447a() {
            }

            @Override // com.baidu.navisdk.framework.c.a
            public boolean a(c.e eVar, int i, Object obj) {
                g0.this.a(false);
                return true;
            }
        }

        /* loaded from: classes8.dex */
        public class b extends c.a {
            public b() {
            }

            @Override // com.baidu.navisdk.framework.c.a
            public boolean a(c.e eVar, int i, Object obj) {
                g0.this.a(true);
                return true;
            }
        }

        public g0() {
        }

        @Override // com.baidu.navisdk.framework.c.e
        public c.C0198c a() {
            c.C0198c c0198c = new c.C0198c(a.this.V0);
            C0447a c0447a = new C0447a();
            b bVar = new b();
            c0198c.b((Integer) 17, (c.a) bVar).b((Integer) 18, (c.a) c0447a).a((Integer) 16, (c.a) c0447a).a((Integer) 15, (c.a) bVar).a(RGFSMTable.FsmState.IndoorParkBrowse, c0447a).a(RGFSMTable.FsmState.IndoorPark, c0447a);
            return c0198c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            if (a.this.u != null) {
                a.this.u.e(z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8663a;

        public h(View view) {
            this.f8663a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ViewGroup.MarginLayoutParams) this.f8663a.getLayoutParams()).bottomMargin = a.this.k - ScreenUtil.getInstance().dip2px(2);
        }
    }

    /* loaded from: classes8.dex */
    public class h0 implements Observer<com.baidu.navisdk.ui.routeguide.ace.g> {
        public h0() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.ui.routeguide.ace.g gVar) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.ACE;
            if (gVar2.d()) {
                gVar2.e("RouteGuide", "status livedata apply " + gVar);
            }
            if (gVar == null) {
                return;
            }
            com.baidu.navisdk.pronavi.data.vm.b bVar = (com.baidu.navisdk.pronavi.data.vm.b) a.this.a(com.baidu.navisdk.pronavi.data.vm.b.class);
            if (bVar != null) {
                bVar.e();
            }
            com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a.k.a(0);
            a.this.z5();
            if (gVar.a()) {
                return;
            }
            if (gVar.b() && bVar != null) {
                bVar.f();
            }
            if (gVar.c()) {
                a.this.K5();
                if (bVar != null) {
                    bVar.g();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8665a;

        public i(a aVar, View view) {
            this.f8665a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ViewGroup.MarginLayoutParams) this.f8665a.getLayoutParams()).bottomMargin = 0;
        }
    }

    /* loaded from: classes8.dex */
    public class i0 implements Observer<com.baidu.navisdk.ui.routeguide.ace.d> {
        public i0() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.ui.routeguide.ace.d dVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
            if (gVar.d()) {
                gVar.e("RouteGuide", "green light  livedata apply " + dVar);
            }
            if (dVar == null) {
                a.this.z5();
            } else {
                a.this.a(dVar, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements i0.f {
        public j() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            com.baidu.navisdk.ui.routeguide.model.a0.B = false;
            a.this.Y(true);
            BNRouteGuider.getInstance().cancelOffline2OnlineRoute();
            if (BNRoutePlaner.getInstance().B()) {
                com.baidu.navisdk.ui.routeguide.control.s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_offline_to_online_failure), false);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.1", null, "2", null);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            if (!com.baidu.navisdk.ui.util.g.a() && a2 != null) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.1", null, "1", null);
                com.baidu.navisdk.ui.routeguide.model.a0.B = false;
                a.this.Y(true);
                BNRouteGuider.getInstance().cancelOffline2OnlineRoute();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j0 implements BNARNaviEntrance.b {
        public j0() {
        }

        @Override // com.baidu.navisdk.module.ar.BNARNaviEntrance.b
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "onDiscontent: ");
            }
        }

        @Override // com.baidu.navisdk.module.ar.BNARNaviEntrance.b
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "onMeetCondition: ");
            }
            a.this.e3();
        }
    }

    /* loaded from: classes8.dex */
    public class k implements g0.d {
        public k() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.d
        public void a() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "showOfflineToOnlineView --> onDismiss!!!");
                LogUtil.e("RouteGuide", "showOfflineToOnlineView --> isOfflineToOnlineViewExist = " + com.baidu.navisdk.ui.routeguide.control.s.T().k(110));
            }
            if (!com.baidu.navisdk.ui.routeguide.control.s.T().k(110)) {
                a.this.Y(true);
                com.baidu.navisdk.ui.routeguide.model.a0.B = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k0 implements BNQuitNaviDialog.OnNaviClickListener {
        public k0() {
        }

        @Override // com.baidu.navisdk.ui.widget.BNQuitNaviDialog.OnNaviClickListener
        public void onClick(int i) {
            if (i == 1) {
                a.this.v();
                com.baidu.navisdk.ugc.report.data.datarepository.g.c().a();
                com.baidu.navisdk.ui.routeguide.b.V().Q();
            } else if (i == 2) {
                a.this.v();
                com.baidu.navisdk.ui.routeguide.b.V().d(true);
                com.baidu.navisdk.ui.routeguide.b.V().Q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements i0.f {
        public l(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            LogUtil.e("RouteGuide", "showFirstYawingFailedView-> onCancelBtnClick");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.2", null, "2", null);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            LogUtil.e("RouteGuide", "showFirstYawingFailedView --> click confirm btn");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.2", null, "1", null);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.4.1", "1", null, null);
            BNRouteGuider.getInstance().refreshRoute(3);
        }
    }

    /* loaded from: classes8.dex */
    public class l0 implements BNDialog.OnNaviClickListener {
        public l0(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            BNRoutePlaner.getInstance().C();
        }
    }

    /* loaded from: classes8.dex */
    public class m implements c.InterfaceC0268c {
        public m() {
        }

        @Override // com.baidu.navisdk.module.newguide.subviews.guides.c.InterfaceC0268c
        public void a(boolean z) {
            if (a.this.q != null) {
                a.this.q.a(z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m0 implements BNDialog.OnNaviClickListener {
        public m0(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            BNRoutePlaner.getInstance().p();
            BNRoutePlaner.getInstance().r();
        }
    }

    /* loaded from: classes8.dex */
    public class n implements DialogInterface.OnCancelListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.r != null) {
                a.this.r.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n0 implements BNDialog.OnNaviClickListener {
        public n0() {
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            a.this.p();
        }
    }

    /* loaded from: classes8.dex */
    public class o implements BNBaseDialog.OnNaviClickListener {
        public o() {
        }

        @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
        public void onClick() {
            try {
                if (a.this.O != null && a.this.O.isShowing() && a.this.b != null && !a.this.b.isFinishing()) {
                    a.this.O.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o0 implements BNImageTextDialog.OnNaviClickListener {
        public o0(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.widget.BNImageTextDialog.OnNaviClickListener
        public void onClick() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.x.7", "3", null, null);
        }
    }

    /* loaded from: classes8.dex */
    public class p implements BNBaseDialog.OnNaviClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BNBaseDialog.OnNaviClickListener f8675a;

        public p(BNBaseDialog.OnNaviClickListener onNaviClickListener) {
            this.f8675a = onNaviClickListener;
        }

        @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
        public void onClick() {
            this.f8675a.onClick();
            try {
                if (a.this.O != null && a.this.O.isShowing() && a.this.b != null && !a.this.b.isFinishing()) {
                    a.this.O.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p0 implements BNImageTextDialog.OnNaviClickListener {
        public p0() {
        }

        @Override // com.baidu.navisdk.ui.widget.BNImageTextDialog.OnNaviClickListener
        public void onClick() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.x.7", "2", null, null);
            BNCommSettingManager.getInstance().setPrefFloatSwitch(true);
            if (!com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
                a.this.h4();
            } else {
                com.baidu.navisdk.ui.routeguide.control.s.T().F();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements BNDialog.OnNaviClickListener {
        public q(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            if (!com.baidu.navisdk.framework.b.z()) {
                com.baidu.navisdk.framework.b.d(true);
            }
            com.baidu.navisdk.util.common.c.a();
        }
    }

    /* loaded from: classes8.dex */
    public interface q0 {
        void a();
    }

    /* loaded from: classes8.dex */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) a.this.i.getLayoutParams();
            if (com.baidu.navisdk.module.newguide.a.e().d()) {
                marginLayoutParams.bottomMargin = (a.this.k - com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_5dp)) + com.baidu.navisdk.ui.util.b.d(R.dimen.nsdk_rg_new_control_panel_bottom_margin);
            } else {
                marginLayoutParams.bottomMargin = a.this.k + com.baidu.navisdk.ui.util.b.d(R.dimen.nsdk_rg_shouqi_view_bottom_margin);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface r0 {
        int a(AudioManager audioManager, int i);

        int b(AudioManager audioManager, int i);
    }

    /* loaded from: classes8.dex */
    public class s implements BNDialog.OnNaviClickListener {
        public s(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            com.baidu.navisdk.h.a("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        }
    }

    /* loaded from: classes8.dex */
    public class t implements BNDialog.OnNaviClickListener {
        public t() {
        }

        @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog.OnNaviClickListener
        public void onClick() {
            com.baidu.navisdk.util.common.l.a(a.this.b, 4101);
        }
    }

    /* loaded from: classes8.dex */
    public class u implements a.o {
        public u(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.view.a.o
        public void a() {
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            BNRoutePlaner.getInstance().o();
            com.baidu.navisdk.ui.routeguide.b.V().d().c(com.baidu.navisdk.ui.routeguide.b.V().d().a());
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.a()) {
                gVar.a("RouteGuide", "onQuitClick: " + com.baidu.navisdk.ui.routeguide.model.a0.G);
            }
            com.baidu.navisdk.ui.routeguide.asr.c.n().b(true);
        }
    }

    /* loaded from: classes8.dex */
    public class v implements a.o {
        public v() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.view.a.o
        public void a() {
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            a.this.v0 = true;
            a.this.X(true);
        }
    }

    /* loaded from: classes8.dex */
    public class w implements a.o {
        public w() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.view.a.o
        public void a() {
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            BNRoutePlaner.getInstance().o();
            a.this.n1();
        }
    }

    /* loaded from: classes8.dex */
    public class x implements a.o {
        public x() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.toolbox.view.a.o
        public void a() {
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            BNRouteGuider.getInstance().cancelOffline2OnlineRoute();
            a.this.c1();
        }
    }

    /* loaded from: classes8.dex */
    public class y implements View.OnLayoutChangeListener {

        /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.a$y$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0448a implements Runnable {
            public RunnableC0448a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.l3();
            }
        }

        public y() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            boolean z;
            if (view == a.this.c && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
                return;
            }
            int i9 = i3 - i;
            int i10 = i4 - i2;
            int max = Math.max(i9, i10);
            int min = Math.min(i9, i10);
            com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
            if (aVar.a(min, max)) {
                if (a.this.f != 2 ? aVar.c() - max != 0 : !(aVar.c() - max == 0 || aVar.c() - max == ScreenUtil.getInstance().getStatusBarHeight(a.this.b))) {
                    z = true;
                } else {
                    z = false;
                }
                ScreenUtil.getInstance().setNavibarShown(z);
                com.baidu.navisdk.framework.message.a.a().a(new com.baidu.navisdk.framework.message.bean.t(0));
                a.this.c.post(new RunnableC0448a());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class z implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8684a;

        public z(a aVar, View view) {
            this.f8684a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("XDVoice", "startFuseSimpleModeGuidePanelAnim - onAnimationEnd - isRoused() = " + com.baidu.navisdk.ui.routeguide.asr.c.n().f());
            }
            if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
                this.f8684a.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    private a() {
    }

    private void A5() {
        if (this.K0 == null) {
            this.K0 = com.baidu.navisdk.module.newguide.a.e().a(com.baidu.navisdk.module.newguide.a.e().d(), com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r);
        }
    }

    private void B5() {
        if (this.x == null) {
            this.x = new com.baidu.navisdk.ui.routeguide.mapmode.subview.u(this.b.getApplicationContext(), this.e, this.r);
            com.baidu.navisdk.ui.routeguide.mapmode.subview.u.K0();
        }
    }

    private void C5() {
        this.V0 = new g0();
        com.baidu.navisdk.framework.c.b().a(this.V0);
    }

    private boolean D5() {
        if (!com.baidu.navisdk.module.newguide.a.e().d() || s2()) {
            return false;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.j jVar = this.C;
        if (jVar != null && jVar.a()) {
            return false;
        }
        return true;
    }

    private boolean E5() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(RGLaneInfoModel.TAG, "isLaneViewShow " + RouteGuideParams.NavState.NAV_STATE_NAVING.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b()));
        }
        if (!RGLaneInfoModel.getModel(false).isShowLaneLineView() || !RouteGuideParams.NavState.NAV_STATE_NAVING.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b())) {
            return false;
        }
        return true;
    }

    private boolean F5() {
        com.baidu.navisdk.apicenter.h a2;
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 == null || (a2 = s2.j().e("RGBucketGroupComponent").a(1007).a()) == null || !a2.b("resultA")) {
            return false;
        }
        return true;
    }

    private boolean G5() {
        com.baidu.navisdk.apicenter.h a2;
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 == null || (a2 = s2.j().e("RGBucketGroupComponent").a(1008).a()) == null || !a2.b("resultA")) {
            return false;
        }
        return true;
    }

    private void H5() {
        ViewGroup viewGroup = this.c;
        if (viewGroup == null) {
            return;
        }
        viewGroup.addOnLayoutChangeListener(this.T0);
    }

    private void I5() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            cVar.l();
        } else {
            com.baidu.navisdk.ui.routeguide.control.m.f = null;
        }
        this.q = null;
    }

    private void J5() {
        if (this.Y == null) {
            this.Y = com.baidu.navisdk.module.newguide.a.e().a(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, com.baidu.navisdk.module.vehiclemanager.b.i().b());
        }
        this.Y.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K5() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "showSmartTrafficPanel: ");
        }
        if (!D5()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "showSmartTrafficPanel: false");
                return;
            }
            return;
        }
        ViewGroup viewGroup = this.M0;
        if (viewGroup != null && this.N0 != null && viewGroup.getVisibility() == 0 && this.M0.getChildCount() > 0) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "showLandGreenLightPanel: is showed");
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.e.findViewById(R.id.smart_traffic_panel_container);
        this.M0 = viewGroup2;
        if (viewGroup2 != null) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.w wVar = this.N0;
            if (wVar == null) {
                this.N0 = new com.baidu.navisdk.ui.routeguide.mapmode.subview.w(2, this.b);
            } else {
                com.baidu.navisdk.utils.b.a(wVar);
            }
            if (this.M0.getChildCount() > 0) {
                this.M0.removeAllViews();
            }
            this.M0.addView(this.N0, new RelativeLayout.LayoutParams(-1, -2));
            if (this.M0.getVisibility() != 0) {
                this.M0.setVisibility(0);
            }
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a.k.a(2);
    }

    private void L5() {
        if (com.baidu.navisdk.util.common.x.s()) {
            if (this.J0 == null) {
                this.J0 = new j1(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r, false);
            }
            this.J0.y();
        }
    }

    private void M5() {
        if (this.c0 == null && !com.baidu.navisdk.module.newguide.a.e().d()) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.q0 q0Var = new com.baidu.navisdk.ui.routeguide.mapmode.subview.q0(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e);
            this.c0 = q0Var;
            q0Var.a(new e0());
            this.c0.a(new f0());
        }
        com.baidu.navisdk.ui.routeguide.mapmode.iview.e eVar = this.c0;
        if (eVar != null && !eVar.a()) {
            boolean y2 = this.c0.y();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "showRouteWeatherView result: " + y2);
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "showRouteWeatherView is showed");
        }
    }

    private void N5() {
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1009).a();
        }
    }

    private void O5() {
        ViewGroup viewGroup = this.c;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeOnLayoutChangeListener(this.T0);
    }

    private void P5() {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.a(this.r);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.t tVar = this.Q;
        if (tVar != null) {
            tVar.a(this.r);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.a(this.r);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.a(this.r);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.n nVar = this.G;
        if (nVar != null) {
            nVar.a(this.r);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.h0 h0Var = this.H;
        if (h0Var != null) {
            h0Var.a(this.r);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.c0 c0Var = this.N;
        if (c0Var != null) {
            c0Var.a(this.r);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            b0Var.a(this.r);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var2 = this.L;
        if (b0Var2 != null) {
            b0Var2.a(this.r);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.a(this.r);
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.a(this.r);
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().a(this.r);
    }

    private void W(boolean z2) {
        if (z2) {
            y3();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.q0();
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.i();
            this.y = null;
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.i();
            this.G0 = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.iview.a aVar2 = this.U;
        if (aVar2 != null) {
            aVar2.d();
            this.U = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.p0 p0Var = this.F;
        if (p0Var != null) {
            p0Var.i();
            this.F = null;
        }
        d1 d1Var = this.f8647a;
        if (d1Var != null) {
            d1Var.b();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.x xVar = this.B;
        if (xVar != null) {
            xVar.i();
            this.B = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.j jVar = this.C;
        if (jVar != null) {
            jVar.i();
            this.C = null;
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().a();
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.E();
            this.W = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.i();
            this.K = null;
        }
        com.baidu.navisdk.module.newguide.interfaces.a aVar3 = this.M;
        if (aVar3 != null) {
            aVar3.i();
            this.M = null;
        }
        h1 h1Var = this.z;
        if (h1Var != null) {
            h1Var.i();
            this.z = null;
        }
        g1 g1Var = this.A;
        if (g1Var != null) {
            g1Var.i();
            this.A = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.iview.e eVar = this.c0;
        if (eVar != null) {
            eVar.i();
            this.c0 = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.e eVar2 = this.V;
        if (eVar2 != null) {
            eVar2.i();
            this.V = null;
        }
        com.baidu.navisdk.ui.routeguide.control.i.g().a();
        t0 t0Var = this.f8645I0;
        if (t0Var != null) {
            t0Var.i();
            this.f8645I0 = null;
        }
        j1 j1Var = this.J0;
        if (j1Var != null) {
            j1Var.i();
            this.J0 = null;
        }
    }

    private void a0(boolean z2) {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.A(z2);
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.z(z2);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.A(z2);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.A(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l5() {
        com.baidu.navisdk.ui.routeguide.b.V().r().l();
        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().g1();
            com.baidu.navisdk.ui.routeguide.control.x.b().q1();
            com.baidu.navisdk.ui.routeguide.control.x.b().B0();
            if (com.baidu.navisdk.poisearch.model.a.k().e() > -1) {
                BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
                BNMapController.getInstance().updateLayer(4);
                com.baidu.navisdk.poisearch.model.a.k().j();
            }
            this.P0 = true;
        }
    }

    private void m5() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.R0, false);
        this.P0 = false;
    }

    public static void n5() {
        if (Y0 != null) {
            synchronized (a.class) {
                try {
                    if (Y0 != null) {
                        Y0.y();
                        Y0 = null;
                    }
                } finally {
                }
            }
        }
    }

    public static a o5() {
        if (Y0 == null) {
            synchronized (a.class) {
                try {
                    if (Y0 == null) {
                        Y0 = new a();
                    }
                } finally {
                }
            }
        }
        return Y0;
    }

    private com.baidu.navisdk.framework.interfaces.pronavi.hd.c p5() {
        com.baidu.navisdk.apicenter.h a2;
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 == null || (a2 = s2.j().e("RGBucketGroupComponent").a(1004).a()) == null) {
            return null;
        }
        return (com.baidu.navisdk.framework.interfaces.pronavi.hd.c) a2.a("resultA", (String) null);
    }

    private com.baidu.navisdk.framework.interfaces.pronavi.hd.b q5() {
        com.baidu.navisdk.apicenter.h a2;
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 == null || (a2 = s2.j().e("RGNewMoreComponent").a(9003).a()) == null) {
            return null;
        }
        return (com.baidu.navisdk.framework.interfaces.pronavi.hd.b) a2.a("resultA", (String) null);
    }

    private com.baidu.navisdk.framework.interfaces.pronavi.hd.b r5() {
        com.baidu.navisdk.apicenter.h a2;
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 == null || (a2 = s2.j().e("RGNewQuitNaviComponent").a(7004).a()) == null) {
            return null;
        }
        return (com.baidu.navisdk.framework.interfaces.pronavi.hd.b) a2.a("resultA", (String) null);
    }

    private com.baidu.navisdk.framework.interfaces.pronavi.hd.c s5() {
        com.baidu.navisdk.apicenter.h a2;
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 == null || (a2 = s2.j().e("RGBucketGroupComponent").a(2004).a()) == null) {
            return null;
        }
        return (com.baidu.navisdk.framework.interfaces.pronavi.hd.c) a2.a("resultA", (String) null);
    }

    private View t5() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "getSimpleModeGuidePanel -> mRGGuidePanelManager = " + this.q);
        }
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    private View u5() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "getSimpleModeGuidePanel -> mRGGuidePanelManager = " + this.q);
        }
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            return cVar.e();
        }
        return null;
    }

    private View v5() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "getSimpleModeHighwayPanel -> mRGGuidePanelManager = " + this.q);
        }
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            return cVar.f();
        }
        return null;
    }

    private View w5() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            return cVar.h();
        }
        return null;
    }

    private void x5() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar;
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null && cVar.j() && (oVar = this.u) != null) {
            oVar.x0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.r rVar = this.Z;
        if (rVar != null) {
            rVar.y(true);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.d(0);
        }
    }

    private void y5() {
        j1 j1Var = this.J0;
        if (j1Var != null) {
            j1Var.c();
            this.J0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z5() {
        ViewGroup viewGroup = this.M0;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void A(int i2) {
        if (i2 == 2) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_rg_nav_voice_mode_switch_on_text));
        } else if (i2 == 3) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_rg_nav_voice_mode_switch_off_play_warning_text));
        }
    }

    public void A0() {
        e(0);
    }

    public void A1() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.p();
        }
    }

    public boolean A2() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null && cVar.y()) {
            return true;
        }
        return false;
    }

    public void A3() {
        com.baidu.navisdk.ui.routeguide.ace.a.m().g().removeObservers(com.baidu.navisdk.ui.routeguide.b.V().f());
        com.baidu.navisdk.ui.routeguide.ace.a.m().e().removeObservers(com.baidu.navisdk.ui.routeguide.b.V().f());
        com.baidu.navisdk.ui.routeguide.ace.a.m().c().removeObservers(com.baidu.navisdk.ui.routeguide.b.V().f());
    }

    public void A4() {
        ViewGroup H;
        if (!V1()) {
            LogUtil.e("RouteGuide", "showServiceAreaView->  not isCanShowServiceAreaView");
            return;
        }
        if (C2()) {
            LogUtil.e("RouteGuide", "showServiceAreaView->  is showing enlarge road map");
            return;
        }
        a(19, Boolean.TRUE);
        if (this.C == null && (H = H(this.f)) != null) {
            this.C = new com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.j(com.baidu.navisdk.ui.routeguide.b.V().c(), H);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.j jVar = this.C;
        if (jVar == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "showServiceAreaView: mHighwayServiceAreaView == null");
                return;
            }
            return;
        }
        if (jVar.a() && !this.C.q0()) {
            LogUtil.e("RouteGuide", "showServiceAreaView->  mHighwayServiceAreaView.isVisibility , return!");
        } else {
            this.C.y();
            a(37, Boolean.FALSE);
        }
    }

    public void B() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.o0();
        }
    }

    public void B0() {
        com.baidu.navisdk.ui.routeguide.control.s.T().q();
    }

    public void B1() {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.q0();
        }
    }

    public boolean B2() {
        return this.S0;
    }

    public void B3() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.A0();
        }
        com.baidu.navisdk.ui.routeguide.model.i.s().q();
    }

    public void B4() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.O();
        }
    }

    public void C(boolean z2) {
        LogUtil.e("RouteGuide", "peng showControlManualOperatePanel 1：" + this.u);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.D(true);
        }
        com.baidu.navisdk.ui.routeguide.model.g.h().a(RouteGuideParams.NavState.NAV_STATE_OPERATE);
        B(2);
        LogUtil.e("RouteGuide", "peng showControlManualOperatePanel 2");
        c();
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.v(2);
        }
        J1();
        M(false);
        if (z2) {
            LogUtil.e("RouteGuide", "RouteGuideFSM.getInstance().getTopState()=" + RouteGuideFSM.getInstance().getTopState());
            if ((RouteGuideFSM.getInstance().getTopState() != null && RGFSMTable.FsmState.SimpleGuide.equals(RouteGuideFSM.getInstance().getTopState())) || RouteGuideFSM.getInstance().isBrowseState() || RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState()) || RGFSMTable.FsmState.Colladamap.equals(RouteGuideFSM.getInstance().getTopState())) {
                a(0L);
            }
        }
    }

    public void C0() {
        com.baidu.navisdk.ui.routeguide.control.s.T().r();
    }

    public void C1() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.q();
        }
    }

    public boolean C2() {
        boolean z2;
        synchronized (this.F0) {
            z2 = this.f8649x0;
        }
        return z2;
    }

    public void C3() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().a(b(R.id.bnav_rg_content_panel_land));
        d1 d1Var = this.f8647a;
        if (d1Var != null) {
            d1Var.a();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.f0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.p0 p0Var = this.F;
        if (p0Var != null) {
            p0Var.f0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.iview.a aVar = this.U;
        if (aVar != null) {
            aVar.e();
        }
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.d();
        }
        RGBaseUiFrame t2 = com.baidu.navisdk.ui.routeguide.b.V().t();
        if (t2 != null) {
            t2.k();
        }
    }

    public void C4() {
        if (this.W == null) {
            this.W = new com.baidu.navisdk.module.newguide.settings.c();
        }
        this.W.a(this.b.getApplicationContext(), com.baidu.navisdk.ui.routeguide.b.V().s(), this.e, this.r);
    }

    public void D(int i2) {
        LogUtil.e("RouteGuide", "peng update MAOrBridge type = " + i2);
        this.w0 = i2;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.c0 c0Var = this.N;
        if (c0Var != null) {
            c0Var.v(i2);
        }
    }

    public void D0() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.v(0);
        }
    }

    public void D1() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.r();
        }
    }

    public boolean D2() {
        boolean z2;
        com.baidu.navisdk.framework.interfaces.pronavi.k k2;
        if (com.baidu.navisdk.ui.routeguide.model.x.A().f8982a) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "isShowFastRouteRecommendPanel: isViewCanShow");
                return true;
            }
            return true;
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c j2 = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j2 != null && (k2 = j2.k()) != null) {
            z2 = k2.a();
        } else {
            z2 = false;
        }
        if (z2) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RouteGuide", "isShowFastRouteRecommendPanel: true");
            }
        }
        return z2;
    }

    public void D3() {
        LogUtil.e("RouteGuide", "resetViewsLocationWithEnlargeView" + s2());
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.n0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.y(e0());
        }
        a(false, false);
    }

    public void D4() {
        LogUtil.e("RouteGuide", "showTopBaseBackgroundView()");
        b1 b1Var = this.b0;
        if (b1Var != null) {
            b1Var.y();
        }
    }

    public void E(int i2) {
        Drawable f2;
        int parseColor;
        String str;
        Log.e("Location", "updateSatelliteSignal, satelliteSignal = " + i2);
        if (i2 <= 0) {
            f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_ic_satellite_red);
            str = com.baidu.navisdk.module.newguide.a.e().b();
            parseColor = Color.parseColor("#f44335");
        } else if (i2 == 1) {
            f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_ic_satellite_yellow);
            parseColor = Color.parseColor("#fbe000");
            str = "中";
        } else if (com.baidu.navisdk.util.logic.j.r().k().getValue().booleanValue() && com.baidu.navisdk.module.cloudconfig.a.b().a("open_bei_dou_tag", true)) {
            f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_ic_satellite_beidou);
            parseColor = Color.parseColor("#ffffff");
            str = "北斗定位";
        } else {
            f2 = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_ic_satellite_green);
            parseColor = Color.parseColor("#62d336");
            str = "强";
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.a(f2, str, parseColor);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.a(f2, str, parseColor);
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.a(f2, str, parseColor);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.a(f2, str, parseColor);
        }
    }

    public void E0() {
        Activity activity;
        if (this.T != null && (activity = this.b) != null && !activity.isFinishing()) {
            try {
                this.T.dismiss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void E1() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            cVar.j();
        }
    }

    public boolean E2() {
        BNQuitNaviDialog bNQuitNaviDialog = this.f0;
        if (bNQuitNaviDialog != null && bNQuitNaviDialog.isShowing()) {
            return true;
        }
        return false;
    }

    public void E3() {
        this.i.post(new r());
    }

    public void E4() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            cVar.o();
        }
    }

    public void F(boolean z2) {
        LogUtil.e("RouteGuide", "showFirstYawingFailedView --> show = " + z2);
        if (z2) {
            if (!com.baidu.navisdk.ui.routeguide.control.s.T().b(117)) {
                LogUtil.e("RouteGuide", "showFirstYawingFailedView allowOperableNotificationShow return false!");
                return;
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.i0 a2 = com.baidu.navisdk.ui.routeguide.control.s.T().a(new l(this));
            if (a2 == null || a2.a()) {
                return;
            }
            a2.y();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.2", "1", null, null);
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().e(117);
    }

    public void F0() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.r;
        if (aVar != null) {
            aVar.a(2, 0, 1, Integer.valueOf(d0()));
        }
    }

    public void F1() {
        Activity activity;
        if (this.n0 != null && (activity = this.b) != null) {
            try {
                if (!activity.isFinishing() && this.n0.isShowing()) {
                    this.n0.dismiss();
                }
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("RouteGuide", e2);
                }
            }
            this.n0 = null;
        }
    }

    public boolean F2() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null && cVar.x()) {
            return true;
        }
        return false;
    }

    public void F3() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.J();
        }
    }

    public void F4() {
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing()) {
            try {
                BNImageTextDialog autoHideTime = new BNImageTextDialog(this.b).enableBackKey(true).setTopImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_tunnel_tips_dialog)).setBottomImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_image_text_btn_bottom_bg)).setTitleTextStyle(false).setTitleText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_tunnel_tips_dialog_text_title)).setSecondBtnText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_tunnel_tips_dialog_confirm)).setSecondBtnChecked().setAutoHideTime(10000);
                this.n0 = autoHideTime;
                autoHideTime.show();
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    e2.printStackTrace();
                    LogUtil.printException("RouteGuide", e2);
                }
            }
        }
    }

    public void G(int i2) {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.c(i2);
        }
    }

    public void G0() {
        com.baidu.navisdk.pronavi.data.vm.e eVar;
        com.baidu.navisdk.module.newguide.subviews.d dVar = this.K0;
        if (dVar != null) {
            dVar.c();
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null && (eVar = (com.baidu.navisdk.pronavi.data.vm.e) s2.c(com.baidu.navisdk.pronavi.data.vm.e.class)) != null) {
            eVar.a(8);
        }
    }

    public void G1() {
        d1 d1Var = this.f8647a;
        if (d1Var != null) {
            d1Var.e();
        }
    }

    public boolean G2() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.e eVar = this.c0;
        if (eVar != null && eVar.a()) {
            return true;
        }
        return false;
    }

    public void G3() {
        ViewGroup b2;
        if (s2() || (b2 = com.baidu.navisdk.ui.routeguide.control.x.b().b(R.id.bnav_rg_content_panel_land)) == null) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().a(true, !com.baidu.navisdk.ui.routeguide.utils.b.o().b(), b2);
    }

    public void G4() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar;
        if (com.baidu.navisdk.j.d() && (oVar = this.u) != null) {
            oVar.y0();
        }
    }

    public void H(boolean z2) {
        Activity activity;
        if (this.i0 != null && (activity = this.b) != null && !activity.isFinishing()) {
            this.i0.a(z2);
            this.i0.c();
        }
        this.h0 = true;
    }

    public void H0() {
        c();
        com.baidu.navisdk.ui.routeguide.model.g.h().a(RouteGuideParams.NavState.NAV_STATE_NAVING);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.D(false);
        }
        t0 t0Var = this.f8645I0;
        if (t0Var != null) {
            t0Var.o0();
        }
        M(true);
    }

    public void H1() {
        e1 e1Var = this.X;
        if (e1Var == null) {
            return;
        }
        e1Var.c();
        throw null;
    }

    public boolean H2() {
        h1 h1Var = this.z;
        if (h1Var != null && h1Var.p0()) {
            return true;
        }
        return false;
    }

    public void H3() {
        View findViewById;
        RGRootViewFrameLayout rGRootViewFrameLayout = this.e;
        if (rGRootViewFrameLayout == null || (findViewById = rGRootViewFrameLayout.findViewById(R.id.bnav_rg_notification_container)) == null) {
            return;
        }
        ViewGroup viewGroup = this.l;
        if (viewGroup != null && viewGroup.getVisibility() == 0 && this.k != 0) {
            findViewById.post(new h(findViewById));
        } else {
            findViewById.post(new i(this, findViewById));
        }
    }

    public void H4() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("XDVoice", "showXDVoiceView - isOrientationPortrait = " + s2() + ", isVoicePanelFuseStatus = " + R2() + "isInNormalScene" + com.baidu.navisdk.ui.routeguide.asr.c.n().e());
        }
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().e()) {
            g1 g1Var = this.A;
            if (g1Var != null && g1Var.n0()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "showXDVoiceView() xdAidView is Visible");
                }
                this.A.c();
            }
            y(false);
            if (this.z == null) {
                this.z = new h1(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r);
            }
            if (this.z != null) {
                if (s2() && !R2()) {
                    I4();
                }
                this.z.y();
                com.baidu.navisdk.framework.c.b().a(15, 16);
                return;
            }
            return;
        }
        h1 h1Var = this.z;
        if (h1Var != null && h1Var.p0()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "showXDVoiceView() xdVoiceView is Visible");
            }
            this.z.c();
        }
        if (this.A == null && (iVar = this.w) != null && iVar.o0() != null) {
            this.A = new g1(com.baidu.navisdk.ui.routeguide.b.V().c(), this.w.o0().b());
        }
        g1 g1Var2 = this.A;
        if (g1Var2 != null) {
            g1Var2.y();
            com.baidu.navisdk.framework.c.b().a(15, 16);
        }
        y(true);
    }

    public void I(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.E(z2);
        }
    }

    public void I0() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.c();
        }
        if (!com.baidu.navisdk.util.common.x.s()) {
            y5();
        }
    }

    public void I1() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.r0();
        }
    }

    public boolean I2() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            return cVar.z();
        }
        return false;
    }

    public void I3() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar;
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing() && (aVar = this.r) != null) {
            aVar.a(2, 1, 1, Integer.valueOf(d0()));
        }
    }

    public void I4() {
        View view;
        if (s2() && this.e != null) {
            LogUtil.e("XDVoice", "startFuseGuidePanelWithAnim, mRGGuidePanelManager = " + this.q);
            if (e2()) {
                e(w5());
                com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
                if (bVar != null) {
                    bVar.n0();
                    return;
                }
                return;
            }
            if (!com.baidu.navisdk.ui.routeguide.control.x.b().g2()) {
                e(w5());
                if (com.baidu.navisdk.ui.routeguide.model.m.y().u()) {
                    com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
                    if (dVar != null) {
                        dVar.n0();
                        return;
                    }
                    return;
                }
                if (c2()) {
                    com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
                    if (aVar != null) {
                        aVar.n0();
                        return;
                    }
                    return;
                }
                com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
                if (eVar != null) {
                    eVar.n0();
                    return;
                }
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.model.m.y().u()) {
                com.baidu.navisdk.module.newguide.abs.d dVar2 = this.y;
                if (dVar2 != null) {
                    dVar2.n0();
                }
                view = v5();
            } else if (c2()) {
                com.baidu.navisdk.module.newguide.abs.a aVar2 = this.G0;
                if (aVar2 != null) {
                    aVar2.n0();
                }
                view = t5();
            } else if (!f2() && !N2()) {
                com.baidu.navisdk.module.newguide.abs.e eVar2 = this.t;
                if (eVar2 != null) {
                    eVar2.n0();
                }
                view = u5();
            } else {
                com.baidu.navisdk.module.newguide.abs.b bVar2 = this.Y;
                if (bVar2 != null) {
                    bVar2.n0();
                    view = this.Y.p0();
                } else {
                    view = null;
                }
            }
            f(view);
        }
    }

    public void J(boolean z2) {
        LogUtil.e("RouteGuide", "showOfflineToOnlineView - " + z2);
        if (z2) {
            if (!com.baidu.navisdk.ui.routeguide.control.s.T().b(110)) {
                LogUtil.e("RouteGuide", "showOfflineToOnlineView allowOperableNotificationShow return false!");
                return;
            }
            int prefRoutPlanMode = BNCommSettingManager.getInstance().getPrefRoutPlanMode();
            if (prefRoutPlanMode == 1 || prefRoutPlanMode == 3) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.1", "1", null, null);
                com.baidu.navisdk.ui.routeguide.model.a0.B = true;
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i0 a2 = com.baidu.navisdk.ui.routeguide.control.s.T().a(new j(), new k());
                if (a2 == null || a2.a()) {
                    return;
                }
                a2.y();
                Y(false);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.1", "1", null, null);
                BNRouteGuider.getInstance().calcOtherRoute(3);
                if (LogUtil.LOGGABLE) {
                    TipTool.onCreateToastDialog(this.b.getApplicationContext(), "测试toast: 20s弹窗展示，开始自动请求在线算路!!!");
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().e(110);
    }

    public void J0() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.v(8);
            this.u.t0();
            com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
            if (iVar != null) {
                iVar.p0();
            }
            this.u.q0();
        }
        if (this.f8645I0 != null && s2()) {
            this.f8645I0.x(JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_nearby_search_filter_width) + JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left));
        }
    }

    public void J1() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.s0();
        }
    }

    public boolean J2() {
        ViewGroup b2 = b(R.id.bnav_rg_ugc_menu_panel);
        if (b2 == null || b2.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void J3() {
        com.baidu.navisdk.pronavi.data.vm.e eVar;
        com.baidu.navisdk.module.newguide.subviews.d dVar = this.K0;
        if (dVar != null) {
            dVar.y();
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null && (eVar = (com.baidu.navisdk.pronavi.data.vm.e) s2.c(com.baidu.navisdk.pronavi.data.vm.e.class)) != null) {
            eVar.a(0);
        }
    }

    public void J4() {
        if (!x2()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("scenic_broadcast", "stop ScenicBroadcast, but not playing");
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "stop ScenicBroadcast");
        }
        u0 u0Var = this.a0;
        if (u0Var != null) {
            u0Var.p0();
        } else {
            N5();
        }
    }

    public void K(boolean z2) {
        if (z2 && com.baidu.navisdk.ui.routeguide.model.a0.C) {
            if (this.D == null) {
                this.D = new com.baidu.navisdk.ui.routeguide.mapmode.subview.l0(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r);
            }
            this.D.a(this.e, d0());
            com.baidu.navisdk.ui.routeguide.mapmode.subview.l0 l0Var = this.D;
            if (l0Var != null) {
                l0Var.y();
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.l0 l0Var2 = this.D;
        if (l0Var2 != null) {
            l0Var2.c();
            this.D = null;
        }
    }

    public void K0() {
        LogUtil.e("RouteGuide", "hideCurRoadNameView()");
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void K1() {
        LogUtil.e("RouteGuide", "hideWaitCalLoading");
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            LogUtil.e("RouteGuide", "hideWaitCalLoading return isYawing");
            return;
        }
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.s();
        }
    }

    public boolean K2() {
        if (com.baidu.navisdk.j.c()) {
            return false;
        }
        return d1.r();
    }

    public void K3() {
        Activity activity;
        if (this.u == null && this.b != null && !com.baidu.navisdk.module.newguide.a.e().d()) {
            this.u = new com.baidu.navisdk.ui.routeguide.mapmode.subview.o(this.b.getApplicationContext(), this.e, this.r);
        }
        if (this.f8645I0 == null) {
            this.f8645I0 = new t0(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e);
        }
        if (this.u != null) {
            if (this.N == null && (activity = this.b) != null) {
                this.N = new com.baidu.navisdk.ui.routeguide.mapmode.subview.c0(activity.getApplicationContext(), this.e, this.r);
            }
            this.u.y();
        } else if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "showControlPanel mActivity = " + this.b);
        }
        L5();
    }

    public void K4() {
        if (com.baidu.navisdk.ui.routeguide.control.x.b().Q2()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("VdrModeGuide", "refreshGuidePanelMode:,isVdrMiddleLowInStart:" + com.baidu.navisdk.ui.routeguide.control.x.b().Q2());
            }
            J5();
            l1();
            N3();
            U0();
            Q0();
        } else if (com.baidu.navisdk.ui.routeguide.model.m.y().u()) {
            LogUtil.e("RouteGuide", "refreshGuidePanelMode RGHighwayModel.isExists()");
            U3();
            l1();
            k();
            R0();
            r(8);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("guide_info", "refreshGuidePanelMode highway isExists, NextDirectionIndicator -> GONE()");
            }
        } else if (com.baidu.navisdk.ui.routeguide.model.a0.I().A()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RouteGuide", "refreshGuidePanelMode switchGuidePanel:isShowExitMainRoadGuide ");
            }
            R0();
            U0();
            l1();
            Q3();
        } else {
            if (this.B0) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "refreshGuidePanelMode mIsFuzzyMode:" + this.B0);
                }
                J5();
                l1();
                M0();
            } else {
                LogUtil.e("RouteGuide", "refreshGuidePanelMode - showRGSimpleGuideView");
                R0();
                p4();
            }
            U0();
            k();
        }
        com.baidu.navisdk.logicframe.b h2 = com.baidu.navisdk.ui.routeguide.b.V().h();
        if (h2 != null) {
            h2.j().e("RGGuidePanelModelService").a(MsgField.MSG_NO_NETWORK_FOR_DOWNLOAD_RES).a(Integer.valueOf(!com.baidu.navisdk.ui.routeguide.utils.b.x() ? 1 : 0)).a();
        }
    }

    public void L(boolean z2) {
        if (z2 && com.baidu.navisdk.ui.routeguide.model.a0.D) {
            if (this.E == null) {
                this.E = new s0(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r);
            }
            this.E.a(this.e, d0());
            s0 s0Var = this.E;
            if (s0Var != null) {
                s0Var.y();
                return;
            }
            return;
        }
        s0 s0Var2 = this.E;
        if (s0Var2 != null) {
            s0Var2.c();
            this.E = null;
        }
    }

    public void L0() {
        Activity activity;
        if (this.U0 != null && (activity = this.b) != null) {
            try {
                try {
                    if (!activity.isFinishing() && this.U0.isShowing()) {
                        this.U0.dismiss();
                    }
                } catch (Exception e2) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("hideDayNightGuideDialog", e2);
                    }
                }
            } finally {
                this.U0 = null;
            }
        }
    }

    public void L1() {
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().e() && this.z != null) {
            LogUtil.e("XDVoice", "hideXDVoiceView");
            this.z.c();
        }
    }

    public boolean L2() {
        d1 d1Var = this.f8647a;
        if (d1Var != null && d1Var.h()) {
            return true;
        }
        return false;
    }

    public void L3() {
        LogUtil.e("RouteGuide", "showCurRoadNameView()");
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.y();
        }
    }

    public void L4() {
        R(false);
    }

    public void M(boolean z2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("scenic_broadcast", "showScenic:" + z2);
        }
        if (!com.baidu.navisdk.function.b.FUNC_SCENIC_SETTING.a()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("scenic_broadcast", "showScenic-> BNFunc.FUNC_SCENIC_SETTING.isEnable = false");
                return;
            }
            return;
        }
        if (z2 || this.a0 != null) {
            if (this.a0 == null && TextUtils.isEmpty(com.baidu.navisdk.ui.routeguide.model.y.c())) {
                return;
            }
            if (this.a0 == null && !com.baidu.navisdk.module.newguide.a.e().d()) {
                this.a0 = new u0(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e);
            }
            u0 u0Var = this.a0;
            if (u0Var == null) {
                return;
            }
            if (z2) {
                if (BNCommSettingManager.getInstance().isScenicBroadcastOpen() && !TextUtils.isEmpty(com.baidu.navisdk.ui.routeguide.model.y.c())) {
                    if (com.baidu.navisdk.ui.routeguide.asr.c.n().i()) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("scenic_broadcast", "showScenicBtn but xd roused");
                            return;
                        }
                        return;
                    }
                    if (RouteGuideFSM.getInstance().isBrowseState()) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("scenic_broadcast", "showScenicBtn but is operating");
                            return;
                        }
                        return;
                    }
                    if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("scenic_broadcast", "showScenicBtn but is yawing");
                            return;
                        }
                        return;
                    }
                    if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("scenic_broadcast", "showScenicBtn but is EnlargeRoadmap");
                            return;
                        }
                        return;
                    } else if (com.baidu.navisdk.module.pronavi.model.g.o().l()) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("scenic_broadcast", "showScenicBtn but isTopLeftThreeLine");
                            return;
                        }
                        return;
                    } else {
                        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e("scenic_broadcast", "showScenicBtn but is isIndoorParkState");
                                return;
                            }
                            return;
                        }
                        this.a0.y();
                        return;
                    }
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("scenic_broadcast", "showScenicBtn return! isScenicBroadcastOpen=" + BNCommSettingManager.getInstance().isScenicBroadcastOpen() + ", getContent=" + TextUtils.isEmpty(com.baidu.navisdk.ui.routeguide.model.y.c()));
                    return;
                }
                return;
            }
            u0Var.c();
        }
    }

    public void M0() {
        LogUtil.e("RouteGuide", "hideDeviceStateView()");
        com.baidu.navisdk.ui.routeguide.mapmode.subview.t tVar = this.Q;
        if (tVar != null) {
            tVar.c();
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.r0();
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.q0();
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.q0();
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.q0();
        }
    }

    public void M1() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.t();
        }
    }

    public boolean M2() {
        e1 e1Var = this.X;
        if (e1Var == null) {
            return false;
        }
        return e1Var.a();
    }

    public void M3() {
        Activity b2 = com.baidu.navisdk.ui.routeguide.b.V().b();
        if (b2 != null && !b2.isFinishing()) {
            d0 d0Var = new d0();
            BNImageCheckboxDialog bNImageCheckboxDialog = new BNImageCheckboxDialog(b2, false);
            this.U0 = bNImageCheckboxDialog;
            bNImageCheckboxDialog.setBottomBackground(R.drawable.bnav_shape_drawable_round_b_white);
            this.U0.setTopImageDrawable(R.drawable.nsdk_drawable_day_night_guide_top);
            this.U0.setTitle(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_day_night_guide_title));
            this.U0.setFirstItemMainText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_day_night_guide_day_mian_title));
            this.U0.setSecondItemMainText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_day_night_guide_auto_main_title));
            this.U0.setOnClickListener(d0Var);
            this.U0.setAutoHideTime(20000);
            this.U0.show();
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.13.1.1");
            F1();
        }
    }

    public void M4() {
        com.baidu.navisdk.util.common.d dVar = this.s;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void N(boolean z2) {
        if (z2 && com.baidu.navisdk.ui.routeguide.model.a0.E) {
            if (this.I == null) {
                c1 c1Var = new c1(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r);
                this.I = c1Var;
                c1Var.a(this.e, d0());
            }
            c1 c1Var2 = this.I;
            if (c1Var2 != null) {
                c1Var2.y();
                return;
            }
            return;
        }
        c1 c1Var3 = this.I;
        if (c1Var3 != null) {
            c1Var3.c();
            this.I = null;
        }
    }

    public void N0() {
        if (this.z != null) {
            LogUtil.e("XDVoice", "hideEnlargeMapFromXDVoice");
            this.z.n0();
        }
    }

    public void N1() {
        Activity activity;
        com.baidu.navisdk.ui.routeguide.model.l.d(false);
        if (this.i0 != null && (activity = this.b) != null && !activity.isFinishing()) {
            this.i0.c(com.baidu.navisdk.ui.routeguide.model.l.f().b(com.baidu.navisdk.ui.routeguide.model.a0.I().H()));
            this.i0.d();
        }
    }

    public boolean N2() {
        return com.baidu.navisdk.ui.routeguide.control.x.b().Q2();
    }

    public void N3() {
        LogUtil.e("RouteGuide", "showDeviceStateView()!");
        if (!com.baidu.navisdk.ui.routeguide.b.W()) {
            LogUtil.e("RouteGuide", "showDeviceStateView(), !isNaviBegin() return");
            return;
        }
        if (h2()) {
            LogUtil.e("RouteGuide", "showDeviceStateView(),isHighwayMiniPanelShowing() return");
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().i() && (!com.baidu.navisdk.ui.routeguide.utils.b.x() || !com.baidu.navisdk.module.newguide.a.e().d())) {
            LogUtil.e("RouteGuide", "showDeviceStateView(),getNextTurnVisible() return");
            return;
        }
        if (f2() && !N2()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "showDeviceStateView(),isFuzzyMode() return: " + com.baidu.navisdk.ui.routeguide.control.x.b().Q2());
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.t tVar = this.Q;
        if (tVar != null) {
            tVar.y();
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.u0();
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.s0();
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.t0();
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.t0();
        }
    }

    public void N4() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.t0();
        }
    }

    public Bitmap O() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar == null) {
            return null;
        }
        uVar.p0();
        return null;
    }

    public void O0() {
        if (this.x != null) {
            W2();
            h(false);
            this.x.c();
            b(true);
            x5();
            if (LogUtil.LOGGABLE) {
                LogUtil.e(RGLaneInfoModel.TAG, "lanelineenlarge hideEnlargeRoadMapAnimation");
            }
        }
    }

    public void O1() {
        B5();
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.y0();
        }
    }

    public boolean O2() {
        boolean z2;
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        if (gVar != null) {
            z2 = gVar.d();
        } else {
            z2 = false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "viewcontroller isVdrGuide: " + z2);
        }
        return z2;
    }

    public boolean O3() {
        B5();
        if (this.x != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(RGLaneInfoModel.TAG, "showEnlargeRoadMap()");
            }
            if (!this.x.y()) {
                return false;
            }
            b(false);
            X2();
            com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
            if (cVar != null) {
                cVar.b(8);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
            if (oVar != null) {
                oVar.a(true, false);
                this.u.e(true);
                this.u.t0();
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.r rVar = this.Z;
            if (rVar != null) {
                rVar.y(false);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
            if (iVar != null) {
                iVar.d(8);
            }
            return true;
        }
        com.baidu.navisdk.util.common.g.PRO_NAV.a("showEnlargeRoadMap fail view is null");
        if (LogUtil.LOGGABLE) {
            LogUtil.printException("showEnlargeRoadMap", new Throwable());
        }
        return false;
    }

    public void O4() {
        i5();
        t0 t0Var = this.f8645I0;
        if (t0Var != null) {
            t0Var.o0();
        }
        g5();
    }

    public void P(boolean z2) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new c0("showXDBtnIfNeeded", null, z2), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    public void P0() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.x0();
            h(false);
            D3();
            b(true);
            x5();
            if (LogUtil.LOGGABLE) {
                LogUtil.e(RGLaneInfoModel.TAG, "lanelineenlarge hideEnlargeRoadMapWithoutAnimation, mControlPanelView=" + this.u);
            }
        }
    }

    public void P1() {
        LogUtil.e("RouteGuide", "RGSimpleGuideModel===  initFirstRGInfo --> bundle = " + com.baidu.navisdk.ui.routeguide.model.a0.I().h().toString());
        Bundle k2 = com.baidu.navisdk.ui.routeguide.model.a0.I().k();
        int a2 = com.baidu.navisdk.util.common.h.a();
        com.baidu.navisdk.ui.routeguide.model.l.e = a2;
        int b2 = com.baidu.navisdk.util.common.h.b();
        if (k2 != null && k2.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist)) {
            a2 = k2.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist);
        }
        if (k2 != null && k2.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime)) {
            b2 = k2.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
        }
        if (a2 > 0) {
            com.baidu.navisdk.ui.routeguide.model.a0.I().c(a2, b2);
            com.baidu.navisdk.ui.routeguide.control.x.b().c5();
        }
        com.baidu.navisdk.model.modelfactory.f.y = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).k();
        Bundle h2 = com.baidu.navisdk.ui.routeguide.model.a0.I().h();
        if (h2.getInt("resid") > 0 && a2 > 0) {
            if (com.baidu.navisdk.ui.routeguide.model.a0.I().s()) {
                G(true);
            } else {
                LogUtil.e("RouteGuide", "initFirstRGInfo --> data = " + h2);
                G(false);
                com.baidu.navisdk.ui.routeguide.control.x.b().f(h2);
                com.baidu.navisdk.ui.routeguide.control.x.b().f(k2);
            }
            com.baidu.navisdk.ui.routeguide.holder.a.d().c();
            com.baidu.navisdk.util.statistic.q.a(0, "sdk_routeguide_refresh_firstinfo", System.currentTimeMillis());
        }
    }

    public boolean P2() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        boolean z2 = false;
        if (gVar != null && gVar.a() == 3) {
            z2 = true;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "viewcontroller isVdrLowPrecisionGuide: " + z2);
        }
        return z2;
    }

    public void P3() {
        View view;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "showEnterNavAnim->");
        }
        if (this.t == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "showEnterNavAnim-> return! mSimpleGuideView= " + this.t);
                return;
            }
            return;
        }
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            view = cVar.h();
        } else {
            view = null;
        }
        if (view != null && s2()) {
            AnimatorSet a2 = a(view);
            if (a2 == null) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RouteGuide", "showEnterNavAnim-> anim == null,return!");
                    return;
                }
                return;
            }
            a2.start();
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "showEnterNavAnim-> view == null,return! mRGGuidePanelManager= " + this.q);
        }
    }

    public void P4() {
        I().q();
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1010).a();
        }
    }

    public void Q(boolean z2) {
        j1 j1Var = this.J0;
        if (j1Var != null) {
            j1Var.y(z2);
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(2009).a();
        }
    }

    public void Q0() {
        com.baidu.navisdk.pronavi.data.vm.b bVar;
        if (this.G0 != null) {
            if (c2() && (bVar = (com.baidu.navisdk.pronavi.data.vm.b) a(com.baidu.navisdk.pronavi.data.vm.b.class)) != null) {
                bVar.a(false);
            }
            this.G0.c();
        }
    }

    public void Q1() {
        com.baidu.navisdk.ui.routeguide.ace.a.m().g().observe(com.baidu.navisdk.ui.routeguide.b.V().f(), new h0());
        com.baidu.navisdk.ui.routeguide.ace.a.m().c().observe(com.baidu.navisdk.ui.routeguide.b.V().f(), new i0());
    }

    public boolean Q2() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        boolean z2 = false;
        if (gVar != null && gVar.a() == 5) {
            z2 = true;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "viewcontroller isVdrMiddleLowInStart: " + z2);
        }
        return z2;
    }

    public void Q3() {
        if (this.G0 == null) {
            com.baidu.navisdk.module.newguide.subviews.guides.e eVar = new com.baidu.navisdk.module.newguide.subviews.guides.e(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r);
            this.G0 = eVar;
            eVar.a(new m());
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "showExitMainRoadGuideView mExitMainRoadView: " + this.G0.a());
        }
        com.baidu.navisdk.pronavi.data.vm.b bVar = (com.baidu.navisdk.pronavi.data.vm.b) a(com.baidu.navisdk.pronavi.data.vm.b.class);
        if (bVar != null) {
            bVar.a(true);
        }
        this.G0.y();
    }

    public void Q4() {
        com.baidu.navisdk.ui.routeguide.subview.hud.a aVar;
        if (this.h0 && (aVar = this.i0) != null) {
            aVar.b();
        }
    }

    public int R() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            return uVar.r0();
        }
        return com.baidu.navisdk.ui.routeguide.mapmode.subview.u.H0();
    }

    public void R0() {
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.c();
            this.Y = null;
        }
    }

    public boolean R1() {
        if (!BNCommSettingManager.getInstance().getPrefRealEnlargementNavi()) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow get enlarge show setting not show");
            return false;
        }
        if (this.D0) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow fail mIsForceSwitchPanelShow");
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.model.x.A().f8982a) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow routeRecommend is show ");
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().q2()) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow isMenuMoreVisible is show ");
            return false;
        }
        if (RouteGuideFSM.getInstance().isBrowseState()) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow fail BrowseMap");
            return false;
        }
        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow fail isRouteSearchMode");
            return false;
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c j2 = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j2 != null && j2.k().a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.e()) {
                gVar.g("RouteGuide", "isAllowEnlargeMapShow fail: isShowAvoidJamPanel");
            }
            return false;
        }
        if (j2 != null && j2.b().g()) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow fail isArriveViaCardShowing");
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.control.i.g().c(1004)) {
            LogUtil.e("RouteGuide", "isAllowEnlargeMapShow fail serviceArea arriveRemindCard isShowing");
            return false;
        }
        if (!com.baidu.navisdk.ui.routeguide.utils.b.o().c(s2())) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RouteGuide", "isAllowEnlargeMapShow: is not normal navi state");
            }
            return false;
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null && s2.I()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RouteGuide", "isAllowEnlargeMapShow: isShowChargeStationList");
            }
            return false;
        }
        if (s2 != null && s2.L()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RouteGuide", "isAllowEnlargeMapShow: isShowParkRecList");
            }
            return false;
        }
        return true;
    }

    public boolean R2() {
        h1 h1Var;
        if (!com.baidu.navisdk.ui.routeguide.asr.c.n().f() || (h1Var = this.z) == null) {
            return false;
        }
        return h1Var.o0();
    }

    public void R3() {
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing()) {
            try {
                this.g0 = new BNDialog(this.b).enableBackKey(true).setTitleText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_nav_title_tip)).setContentMessage(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_its_first_tip)).setFirstBtnText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_alert_iknown)).setOnFirstBtnClickListener(new n0()).setSecondBtnEnabled(false);
                if (BNSettingManager.isShowRemindDialog() && !this.g0.isShowing()) {
                    this.g0.show();
                }
            } catch (Exception e2) {
                this.g0 = null;
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("RouteGuide", e2);
                }
            }
        }
    }

    public void R4() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.x xVar = this.B;
        if (xVar != null) {
            xVar.n0();
        }
    }

    public boolean S() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            return b0Var.a();
        }
        return false;
    }

    public void S0() {
        Activity activity;
        if (this.i0 != null && (activity = this.b) != null && !activity.isFinishing()) {
            this.i0.a();
        }
        this.i0 = null;
        this.h0 = false;
    }

    public boolean S1() {
        d1 d1Var = this.f8647a;
        if (d1Var != null && d1Var.g()) {
            return true;
        }
        return false;
    }

    public boolean S2() {
        BNCommonProgressDialog bNCommonProgressDialog = this.t0;
        if (bNCommonProgressDialog != null && bNCommonProgressDialog.isShowing()) {
            return true;
        }
        return false;
    }

    public void S3() {
        BNDialog bNDialog;
        Activity activity;
        String string;
        try {
            if (this.j0 == null && (activity = this.b) != null && !activity.isFinishing()) {
                if (Build.VERSION.SDK_INT < 29 && com.baidu.navisdk.util.logic.c.k().c(this.b)) {
                    string = JarUtils.getResources().getString(R.string.nsdk_string_rg_high_gps_not_open_and_set);
                } else {
                    string = JarUtils.getResources().getString(R.string.nsdk_string_rg_gps_not_open_and_set);
                }
                this.j0 = new BNDialog(this.b).setTitleText(JarUtils.getResources().getString(R.string.nsdk_string_rg_nav_title_tip)).setContentMessage(string).setFirstBtnText(JarUtils.getResources().getString(R.string.nsdk_string_rg_alert_setting)).setFirstBtnTextColorHighLight().setOnFirstBtnClickListener(new d()).setSecondBtnText(JarUtils.getResources().getString(R.string.nsdk_string_rg_nav_dialog_cancel)).setOnSecondBtnClickListener(new c());
            }
            Activity activity2 = this.b;
            if (activity2 != null && !activity2.isFinishing() && (bNDialog = this.j0) != null && !bNDialog.isShowing()) {
                this.j0.show();
            }
        } catch (Exception unused) {
            this.j0 = null;
        }
    }

    public void S4() {
        com.baidu.navisdk.ui.routeguide.subview.hud.a aVar = this.i0;
        if (aVar != null) {
            aVar.e();
        }
    }

    public boolean T() {
        return this.h0;
    }

    public void T0() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.x xVar = this.B;
        if (xVar != null && xVar.a()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "hideHighwaySubscribeView ->");
            }
            this.B.c();
        }
    }

    public boolean T1() {
        com.baidu.navisdk.ui.routeguide.widget.volume.e eVar = this.T;
        if (eVar != null) {
            return eVar.isShowing();
        }
        return false;
    }

    public boolean T2() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            return cVar.A();
        }
        return true;
    }

    public void T3() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "showHighwaySubscribeView ->");
        }
        if (this.B == null) {
            try {
                this.B = new com.baidu.navisdk.ui.routeguide.mapmode.subview.x(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e);
            } catch (Throwable th) {
                if (!com.baidu.navisdk.j.d()) {
                    return;
                } else {
                    throw th;
                }
            }
        }
        if (!this.B.a()) {
            this.B.y();
        } else if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "showHighwaySubscribeView -> mHighwaySubscribeView.isVisibility()");
        }
    }

    public void T4() {
        LogUtil.e("RouteGuide", "updateMainAuxiliaryBridgeViewByLastType mMainAuxiliaryBridgeType = " + this.w0);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.c0 c0Var = this.N;
        if (c0Var != null) {
            c0Var.v(this.w0);
        }
    }

    public View U() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public void U0() {
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.c();
        }
    }

    public boolean U1() {
        return com.baidu.navisdk.ui.routeguide.control.i.g().c(1010);
    }

    public void U2() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.B();
        }
    }

    public void U3() {
        if (this.y == null) {
            this.y = com.baidu.navisdk.module.newguide.a.e().c(com.baidu.navisdk.module.newguide.a.e().d(), com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r);
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.y();
        }
    }

    public void U4() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.P();
        }
    }

    public int V() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            return cVar.b();
        }
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_land_left_panel_width_new);
            }
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_width);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_land_left_panel_width);
    }

    public void V0() {
        View findViewById;
        RGRootViewFrameLayout rGRootViewFrameLayout = this.e;
        if (rGRootViewFrameLayout == null || (findViewById = rGRootViewFrameLayout.findViewById(R.id.bnav_rg_notification_panel)) == null) {
            return;
        }
        findViewById.setFocusable(false);
        findViewById.setFocusableInTouchMode(false);
        findViewById.setClickable(false);
        findViewById.setLongClickable(false);
    }

    public boolean V1() {
        boolean isBrowseState;
        if (!BNCommSettingManager.getInstance().isShowHighSpeedPanel() || com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
            return false;
        }
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            if (!s2()) {
                return true;
            }
            isBrowseState = RouteGuideFSM.getInstance().isBrowseState();
        } else {
            isBrowseState = RouteGuideFSM.getInstance().isBrowseState();
        }
        return !isBrowseState;
    }

    public void V2() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "moveDownSimpleModePanel ->");
        }
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            int g2 = cVar.g();
            com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
            if (eVar != null) {
                eVar.v(g2);
            }
            com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
            if (dVar != null) {
                dVar.v(g2);
            }
            com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
            if (aVar != null) {
                aVar.v(g2);
            }
            com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
            if (bVar != null) {
                bVar.v(g2);
            }
        }
    }

    public void V3() {
        com.baidu.navisdk.ui.routeguide.subview.hud.a aVar = this.i0;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void V4() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.Q();
        }
    }

    public void W0() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            b0Var.c();
        }
    }

    public boolean W1() {
        return this.v0;
    }

    public void W2() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "moveLeftViewsWithEnlargeView, isOrientationPortrait() = " + s2());
        }
        if (this.u != null && !s2()) {
            this.u.u0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.w(e0());
        }
        a(false, true);
    }

    public void W3() {
        View findViewById;
        RGRootViewFrameLayout rGRootViewFrameLayout = this.e;
        if (rGRootViewFrameLayout == null || (findViewById = rGRootViewFrameLayout.findViewById(R.id.bnav_rg_notification_panel)) == null) {
            return;
        }
        findViewById.setFocusable(true);
        findViewById.setFocusableInTouchMode(true);
        findViewById.setClickable(true);
        findViewById.setLongClickable(true);
    }

    public void W4() {
        com.baidu.navisdk.ui.routeguide.control.s.T().S();
    }

    public int X() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            return b0Var.p0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var2 = this.L;
        if (b0Var2 != null) {
            return b0Var2.p0();
        }
        return 0;
    }

    public void X0() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.k();
        }
    }

    public boolean X1() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.n nVar = this.G;
        if (nVar != null) {
            return nVar.n0();
        }
        return false;
    }

    public void X2() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "moveRightViewsWithEnlargeView:" + s2());
        }
        if (this.u != null && !s2()) {
            this.u.w0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.x(e0());
        }
        a(true, true);
    }

    public void X3() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var;
        if (!f2() && !N2() && (b0Var = this.J) != null) {
            b0Var.y();
            com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.j jVar = this.C;
            if (jVar != null) {
                jVar.n0().a();
            }
        }
    }

    public void X4() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.S();
        }
    }

    public int Y() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            return b0Var.q0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var2 = this.L;
        if (b0Var2 != null) {
            return b0Var2.p0();
        }
        return 0;
    }

    public void Y0() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.c0 c0Var = this.N;
        if (c0Var != null) {
            c0Var.v(0);
        }
    }

    public boolean Y1() {
        BNImageCheckboxDialog bNImageCheckboxDialog = this.U0;
        if (bNImageCheckboxDialog != null && bNImageCheckboxDialog.isShowing()) {
            return true;
        }
        return false;
    }

    public void Y2() {
        boolean z2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "moveServiceAreaView->isOrientationPortrait = " + s2());
        }
        if (m0() != null && !s2()) {
            boolean y2 = com.baidu.navisdk.ui.routeguide.utils.b.y();
            if ((!y2 || (!com.baidu.navisdk.ui.routeguide.model.g.h().a() && I().j())) && y2) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().I().f(z2);
        }
    }

    public void Y3() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.K();
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.t0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.r rVar = this.Z;
        if (rVar != null) {
            rVar.y(false);
        }
    }

    public void Y4() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.e eVar = this.c0;
        if (eVar != null) {
            boolean G = eVar.G();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "updateRouteWeatherView result: " + G);
            }
        } else {
            M5();
        }
        a(18);
    }

    public boolean Z() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            return b0Var.r0();
        }
        return false;
    }

    public void Z0() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.l();
        }
    }

    public boolean Z1() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.t tVar = this.Q;
        if (tVar != null) {
            return tVar.a();
        }
        return false;
    }

    public void Z2() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "moveUpSimpleModePanel ->");
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.s0();
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.s0();
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.r0();
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.s0();
        }
    }

    public void Z3() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.L();
        }
    }

    public void Z4() {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.x0();
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.u0();
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.w0();
        }
    }

    public void a1() {
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        if (V != null && V.j() != null) {
            V.j().i().a(false);
        }
    }

    public boolean a2() {
        Object valueOf;
        if (2 == com.baidu.navisdk.module.pronavi.a.j) {
            return false;
        }
        com.baidu.navisdk.model.datastruct.g a2 = com.baidu.navisdk.util.logic.c.k().a(3, 3000);
        if (a2 != null && a2.k == 1) {
            if (a2.c <= 1.0f) {
                return true;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "isDialogCanShow-> return false! locData.speed=" + a2.c);
            }
            return false;
        }
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("isDialogCanShow-> return false! locData=");
            if (a2 == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(a2.k);
            }
            sb.append(valueOf);
            LogUtil.e("RouteGuide", sb.toString());
        }
        return false;
    }

    public void a3() {
        d1 d1Var = this.f8647a;
        if (d1Var != null) {
            d1Var.i();
        }
    }

    public void a4() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.M();
        }
        I(0);
    }

    public void a5() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.T();
        }
    }

    public ViewGroup b0() {
        RGRootViewFrameLayout rGRootViewFrameLayout = this.e;
        if (rGRootViewFrameLayout != null) {
            View findViewById = rGRootViewFrameLayout.findViewById(R.id.module_contains);
            if (findViewById instanceof ViewGroup) {
                return (ViewGroup) findViewById;
            }
            return null;
        }
        return null;
    }

    public void b1() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.h0 h0Var = this.H;
        if (h0Var != null) {
            h0Var.c();
        }
    }

    public boolean b2() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            return uVar.z0();
        }
        return false;
    }

    public void b3() {
        d1 d1Var = this.f8647a;
        if (d1Var != null && d1Var.g()) {
            this.f8647a.j();
            this.f8647a = null;
        }
    }

    public void b4() {
        C(false);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.t0();
            this.u.q0();
            this.u.A(false);
            this.u.B(false);
            this.u.C(false);
        }
    }

    public void b5() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.U();
        }
    }

    public View c0() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            return cVar.f();
        }
        return null;
    }

    public void c1() {
        LogUtil.e("RouteGuide", " hideOfflineToOnlineProgress->");
        m1();
        Y(true);
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null && com.baidu.navisdk.ui.routeguide.b.V().i().c().s() && this.C != null) {
            LogUtil.e("RouteGuide", " hideOfflineToOnlineProgress-> setServiceAreaPanelEnable(true)");
            this.C.y(true);
        }
    }

    public boolean c2() {
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public void c3() {
        if (com.baidu.navisdk.ui.routeguide.b.W()) {
            this.A0 = true;
            m4();
            com.baidu.navisdk.ugc.dialog.h.i();
            JNIGuidanceControl.getInstance().setGroundMode(1);
            com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
            if (cVar != null) {
                cVar.e(true);
            }
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            com.baidu.navisdk.ui.routeguide.control.i.g().c();
            com.baidu.navisdk.module.vmsr.c.f().onBackground();
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_enter_background"));
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(false);
            if (b2 != null) {
                b2.onBackground();
            }
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a a2 = com.baidu.navisdk.ui.routeguide.utils.b.a();
            if (a2 != null) {
                a2.onBackground();
            }
        }
    }

    public void c4() {
        if (!com.baidu.navisdk.function.b.FUNC_NEARBY_SEARCH.a()) {
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.d.l().e()) {
            l(false);
            LogUtil.e("RouteGuide", "修改终点状态，不显示筛选框");
            return;
        }
        LogUtil.e("RouteGuide", "onStart show nearby search view");
        if (TextUtils.isEmpty(com.baidu.navisdk.poisearch.model.a.k().b())) {
            l(false);
            return;
        }
        if (this.e == null) {
            l(false);
            return;
        }
        J0();
        if (!com.baidu.navisdk.poisearch.e.g(com.baidu.navisdk.poisearch.model.a.k().b())) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "should not show filter view, category is " + com.baidu.navisdk.poisearch.model.a.k().b());
            }
            l(false);
            return;
        }
        LogUtil.e("RouteGuide", "show nearby search view, category is " + com.baidu.navisdk.poisearch.model.a.k().b());
        com.baidu.navisdk.ui.routeguide.mapmode.subview.e0 e0Var = this.v;
        if (e0Var == null) {
            this.v = new com.baidu.navisdk.ui.routeguide.mapmode.subview.e0(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r, com.baidu.navisdk.poisearch.model.a.k().b());
        } else {
            e0Var.f(com.baidu.navisdk.poisearch.model.a.k().b());
        }
        this.v.y();
        LogUtil.e("RouteGuide", "nearby search view showed");
    }

    public void c5() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.V();
        }
        com.baidu.navisdk.ui.routeguide.subview.hud.a aVar = this.i0;
        if (aVar != null) {
            aVar.g();
        }
    }

    public int d0() {
        return e0();
    }

    public void d1() {
        Activity activity;
        if (this.q0 != null && (activity = this.b) != null) {
            try {
                if (!activity.isFinishing() && this.q0.isShowing()) {
                    this.q0.dismiss();
                }
            } catch (Exception unused) {
            }
            this.q0 = null;
        }
    }

    public boolean d2() {
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "出口面板为空");
                return false;
            }
            return false;
        }
        return aVar.p0();
    }

    public boolean d3() {
        if (this.L0 == null) {
            this.L0 = new BNARNaviEntrance();
        }
        this.L0.a(this.b, new j0(), com.baidu.navisdk.ui.routeguide.b.V().f());
        return true;
    }

    public void d4() {
        if (this.M != null) {
            if (com.baidu.navisdk.module.newguide.a.e().d() || s2()) {
                this.M.b(null);
            }
        }
    }

    public void d5() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.p(BNCommSettingManager.getInstance().isRoadCondOnOrOff());
        }
    }

    public int e0() {
        if (this.p.d() != -99) {
            return this.p.d();
        }
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        if (aVar.f() != 0) {
            return aVar.f();
        }
        Activity activity = this.b;
        if (activity != null) {
            return activity.getResources().getConfiguration().orientation;
        }
        return com.baidu.navisdk.module.pronavi.model.h.f7469a;
    }

    public void e1() {
        Activity activity;
        if (this.f8648o0 != null && (activity = this.b) != null) {
            try {
                if (!activity.isFinishing() && this.f8648o0.isShowing()) {
                    this.f8648o0.dismiss();
                }
            } catch (Exception unused) {
            }
            this.f8648o0 = null;
        }
    }

    public boolean e2() {
        if (this.Y != null && ((this.B0 || N2()) && this.Y.r0())) {
            return true;
        }
        return false;
    }

    public boolean e3() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j2;
        if (this.W0 == null && this.d != null && (j2 = com.baidu.navisdk.ui.routeguide.b.V().j()) != null) {
            this.W0 = j2.a(true);
        }
        com.baidu.navisdk.ui.routeguide.ar.a aVar = this.W0;
        if (aVar != null) {
            aVar.a(this.b, this.d, this.r);
            return true;
        }
        return false;
    }

    public void e4() {
        if (this.H == null) {
            this.H = new com.baidu.navisdk.ui.routeguide.mapmode.subview.h0(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r);
        }
        this.H.a(this.e, d0());
        this.H.y();
    }

    public void e5() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.B0();
        }
    }

    @Nullable
    public com.baidu.navisdk.ui.routeguide.mapmode.subview.i f0() {
        return this.w;
    }

    public void f1() {
        Activity activity;
        if (this.m0 != null && (activity = this.b) != null) {
            try {
                if (!activity.isFinishing() && this.m0.isShowing()) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RouteGuide", "hideOrientationChangedDialog->");
                    }
                    this.m0.dismiss();
                }
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("RouteGuide", e2);
                }
            }
            this.m0 = null;
        }
    }

    public boolean f2() {
        return this.B0;
    }

    public void f3() {
        if (BNavigatorLogic.z0) {
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_enter_foreground"));
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(false);
            if (b2 != null) {
                b2.onForeground();
            }
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a a2 = com.baidu.navisdk.ui.routeguide.utils.b.a();
            if (a2 != null) {
                a2.onForeground();
            }
        }
        if (com.baidu.navisdk.ui.routeguide.b.W() && !E2()) {
            if (!BNCommSettingManager.getInstance().isRGFloatOpenGuideHasShow() && this.A0 && com.baidu.navisdk.module.pronavi.model.g.o().c() <= 1 && !Y1() && !M2() && !r2() && !com.baidu.navisdk.module.dynamicui.a.f.a().d() && com.baidu.navisdk.function.b.FUNC_FLOAT_SETTING.a() && !com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
                com.baidu.navisdk.model.datastruct.g a3 = com.baidu.navisdk.util.logic.c.k().a(3, 3000);
                if (a3 != null && a3.k == 1) {
                    if (BNCommSettingManager.getInstance().getFloatMode() == 1) {
                        if (!BNCommSettingManager.getInstance().getPrefFloatSwitch()) {
                            l4();
                        }
                        BNCommSettingManager.getInstance().setRGFloatOpenGuideHasShow();
                    }
                } else {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RouteGuide", "showRGFloatOpenGuidDialog-> 丢星！");
                        return;
                    }
                    return;
                }
            }
            JNIGuidanceControl.getInstance().setGroundMode(2);
            com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
            if (cVar != null) {
                cVar.e(false);
            }
            com.baidu.navisdk.ui.routeguide.control.i.g().d();
            com.baidu.navisdk.module.vmsr.c.f().a();
        }
        j1();
        com.baidu.navisdk.framework.interfaces.locationshare.a j2 = com.baidu.navisdk.framework.interfaces.c.p().j();
        if (j2 != null) {
            j2.onForeground();
        }
    }

    public void f4() {
        a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_offline_to_online_text), new x());
    }

    public void f5() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.W();
        }
    }

    public Bitmap g0() {
        return com.baidu.navisdk.ui.routeguide.model.i.s().c();
    }

    public void g1() {
        com.baidu.navisdk.ui.routeguide.control.s.T().t();
    }

    public boolean g2() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            return cVar.k();
        }
        return false;
    }

    public void g3() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.F();
        }
    }

    public void g4() {
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing()) {
            BNDialog bNDialog = this.q0;
            if (bNDialog != null && bNDialog.isShowing()) {
                return;
            }
            Resources resources = JarUtils.getResources();
            BNDialog bNDialog2 = new BNDialog(com.baidu.navisdk.ui.routeguide.b.V().b());
            this.q0 = bNDialog2;
            bNDialog2.setContentMessage(resources.getString(R.string.setting_wechat_dialog_message)).setFirstBtnText(resources.getString(R.string.nsdk_string_rg_float_dialog_cancle)).setSecondBtnTextColorHighLight().setSecondBtnText(resources.getString(R.string.nsdk_string_rg_float_dialog_ok)).setOnSecondBtnClickListener(new q(this));
            try {
                Activity activity2 = this.b;
                if (activity2 != null && !activity2.isFinishing()) {
                    this.q0.show();
                }
            } catch (Exception unused) {
                LogUtil.e("RouteGuide", "dialog show failed because activity is NOT running!");
            }
        }
    }

    public void g5() {
        if (this.b == null) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.model.t.s().b(this.b.getApplicationContext());
    }

    public int h0() {
        return com.baidu.navisdk.ui.routeguide.model.i.s().g();
    }

    public void h1() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.k0 k0Var = this.P;
        if (k0Var == null) {
            return;
        }
        k0Var.c();
        throw null;
    }

    public boolean h2() {
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            return dVar.r0();
        }
        return false;
    }

    public void h3() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.k0();
        }
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.G();
        }
    }

    public void h4() {
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing()) {
            BNDialog bNDialog = this.f8648o0;
            if (bNDialog != null && bNDialog.isShowing()) {
                return;
            }
            Resources resources = JarUtils.getResources();
            BNDialog bNDialog2 = new BNDialog(this.b);
            this.f8648o0 = bNDialog2;
            bNDialog2.setContentMessage(resources.getString(R.string.nsdk_string_rg_float_dialog_description));
            this.f8648o0.setFirstBtnText(resources.getString(R.string.nsdk_string_rg_float_dialog_cancle));
            this.f8648o0.setSecondBtnTextColorHighLight();
            this.f8648o0.setSecondBtnText(resources.getString(R.string.nsdk_string_rg_float_dialog_ok));
            this.f8648o0.setOnSecondBtnClickListener(new s(this));
            try {
                Activity activity2 = this.b;
                if (activity2 != null && !activity2.isFinishing()) {
                    this.f8648o0.show();
                }
            } catch (Exception unused) {
                LogUtil.e("RouteGuide", "dialog show failed because activity is NOT running!");
            }
        }
    }

    public void h5() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.w0();
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1013).a();
        }
    }

    public String i0() {
        StringBuilder sb = new StringBuilder();
        com.baidu.navisdk.util.common.l0.a(com.baidu.navisdk.ui.routeguide.model.i.s().h(), l0.a.ZH, sb);
        return sb.toString();
    }

    public void i1() {
        Activity activity;
        if (this.l0 != null && (activity = this.b) != null) {
            try {
                if (!activity.isFinishing() && this.l0.isShowing()) {
                    this.l0.dismiss();
                }
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("RouteGuide", e2);
                }
            }
            this.l0 = null;
        }
    }

    public boolean i2() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.x xVar = this.B;
        if (xVar != null) {
            return xVar.a();
        }
        return false;
    }

    public void i3() {
        s();
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.m0();
        }
    }

    public void i4() {
        Activity activity;
        if ((com.baidu.navisdk.j.d() || com.baidu.navisdk.function.b.FUNC_FORCE_LANDSCAPE.a()) && (activity = this.b) != null && !activity.isFinishing()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "showOrientationChangDialog->");
            }
            try {
                BNImageTextDialog onFirstBtnClickListener = new BNImageTextDialog(this.b).enableBackKey(true).setTopImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_orientation_change_dialog)).setBottomImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_image_text_btn_bottom_bg)).setTitleText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_orientation_change_dialog_title)).setContentMessage(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_orientation_change_dialog_message)).setFirstBtnText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_orientation_change_dialog_text_no_use)).setSecondBtnText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_orientation_change_dialog_text_use)).setSecondBtnChecked().setAutoHideTime(20000).setOnSecondBtnClickListener(new b(this)).setOnFirstBtnClickListener(new C0445a(this));
                this.m0 = onFirstBtnClickListener;
                onFirstBtnClickListener.show();
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.11", "1", null, null);
                i1();
                F1();
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("RouteGuide", e2);
                }
            }
        }
    }

    public void i5() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.D0();
            return;
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(2006).a();
        }
    }

    public String j0() {
        return com.baidu.navisdk.ui.routeguide.model.i.s().f();
    }

    public void j1() {
        boolean z2;
        StringBuilder sb = new StringBuilder();
        sb.append("hideRGFloatView : ");
        if (this.S == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        sb.append(z2);
        LogUtil.e("RouteGuide", sb.toString());
        com.baidu.navisdk.ui.routeguide.mapmode.subview.n0 n0Var = this.S;
        if (n0Var != null && n0Var.b()) {
            this.S.a();
        }
    }

    public boolean j2() {
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            return dVar.a();
        }
        return false;
    }

    public boolean j3() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null && cVar.C()) {
            return true;
        }
        return false;
    }

    public void j4() {
        if (b2()) {
            LogUtil.e("RouteGuide", "showPickPointView --> isEnlargeOrColladaShow(): " + b2());
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().H();
    }

    public void j5() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.z(true);
            B();
        }
    }

    public ViewGroup k0() {
        return this.d;
    }

    public void k1() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            cVar.i();
        }
        com.baidu.navisdk.module.newguide.settings.c cVar2 = this.W;
        if (cVar2 != null) {
            cVar2.i();
        }
    }

    public boolean k2() {
        if (LogUtil.LOGGABLE && this.d0 != null) {
            LogUtil.e("RouteGuide", "isInterceptFakeYawingNotificationOnVdr isYawing: " + this.d0.c() + ", isOpenVdr:" + this.d0.d());
        }
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        if (gVar != null && gVar.d() && this.d0.c()) {
            return true;
        }
        return false;
    }

    public void k3() {
        j1();
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.onResume();
        }
        if (m0() != null) {
            m0().g();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.onResume();
        }
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.H();
        }
        com.baidu.navisdk.ui.routeguide.ar.a aVar = this.W0;
        if (aVar != null) {
            aVar.m();
        }
        if (!com.baidu.navisdk.framework.b.G()) {
            com.baidu.navisdk.framework.b.a((b.InterfaceC0197b) new g(this));
        }
    }

    public void k4() {
        Activity activity;
        boolean z2;
        if (this.b == null) {
            return;
        }
        try {
            BNQuitNaviDialog bNQuitNaviDialog = new BNQuitNaviDialog(this.b);
            this.f0 = bNQuitNaviDialog;
            bNQuitNaviDialog.setOnBtnClickListener(new k0());
            if (LogUtil.LOGGABLE) {
                Boolean valueOf = Boolean.valueOf(!this.f0.isShowing());
                if (this.b != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                LogUtil.e("RouteGuide", String.format("showQuitNaviDialog: %s, %s, %s", valueOf, Boolean.valueOf(z2), Boolean.valueOf(!this.b.isFinishing())));
            }
            if (!this.f0.isShowing() && (activity = this.b) != null && !activity.isFinishing()) {
                this.f0.show();
            }
            this.f0.setCanceledOnTouchOutside(false);
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                e2.printStackTrace();
                LogUtil.printException("RouteGuide", e2);
            }
        }
    }

    public void k5() {
        B5();
        boolean equals = RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState());
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.z(false);
            if (com.baidu.navisdk.ui.routeguide.control.x.b().R1() && equals) {
                RouteGuideFSM.getInstance().getState(RGFSMTable.FsmState.EnlargeRoadmap).excute();
            }
        }
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.iview.e l0() {
        return this.c0;
    }

    public void l1() {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.c();
        }
    }

    public boolean l2() {
        if (m2()) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                com.baidu.navisdk.util.common.g.ASR.e("RouteGuide", "isInterceptReCalcRoute OnVdr");
            }
            com.baidu.navisdk.ui.routeguide.control.s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_vdr_intercept_recal_route_tip), false);
            return true;
        }
        if (!com.baidu.navisdk.ui.routeguide.model.a0.I().w()) {
            return false;
        }
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
            com.baidu.navisdk.util.common.g.ASR.e("RouteGuide", "isInterceptReCalcRoute isPreYawing");
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_intercept_pre_yawing_route_tip), false);
        return true;
    }

    public void l3() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onSizeChanged: w:");
            com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
            sb.append(aVar.b());
            sb.append(" h:");
            sb.append(aVar.a());
            gVar.e("RouteGuide", sb.toString());
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            com.baidu.navisdk.pronavi.util.a aVar2 = com.baidu.navisdk.pronavi.util.a.h;
            s2.a(aVar2.a(), aVar2.b());
        }
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.I();
        }
        if (m0() != null) {
            m0().h();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.h();
        }
        com.baidu.navisdk.ui.routeguide.control.q.c().b();
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(false);
        if (b2 != null) {
            b2.h();
        }
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.a a2 = com.baidu.navisdk.ui.routeguide.utils.b.a();
        if (a2 != null) {
            a2.h();
        }
    }

    public void l4() {
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing()) {
            try {
                BNImageTextDialog onFirstBtnClickListener = new BNImageTextDialog(this.b).enableBackKey(true).setTopImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_float_guid_dialog)).setBottomImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_image_text_btn_bottom_bg)).setTitleText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_float_open_guide_title)).setContentMessage(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_float_open_guide_message)).setFirstBtnText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_float_open_guide_text_no_use)).setSecondBtnText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_float_open_guide_text_use)).setSecondBtnChecked().setOnSecondBtnClickListener(new p0()).setOnFirstBtnClickListener(new o0(this));
                this.l0 = onFirstBtnClickListener;
                onFirstBtnClickListener.show();
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.x.7", "1", null, null);
                F1();
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("RouteGuide", e2);
                }
            }
        }
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.presenter.f m0() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.j jVar = this.C;
        if (jVar == null) {
            return null;
        }
        return jVar.n0();
    }

    public void m1() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "hideReRoutePlanView: ");
        }
        com.baidu.navisdk.ui.routeguide.model.a0.I().d(false);
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.m();
        }
        com.baidu.navisdk.ui.routeguide.model.n c2 = com.baidu.navisdk.ui.routeguide.b.V().i().c();
        if (c2 != null && c2.s() && this.C != null) {
            if (gVar.d()) {
                gVar.e("RouteGuide", " hideReRoutePlanView-> setServiceAreaPanelEnable(true)");
            }
            this.C.y(true);
        }
    }

    public boolean m2() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        if (gVar == null) {
            return false;
        }
        return gVar.e();
    }

    public void m3() {
    }

    public void m4() {
        if (com.baidu.navisdk.ui.routeguide.utils.b.h() == 0 || !com.baidu.navisdk.ui.routeguide.b.W() || RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.ArriveDest) || com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
            return;
        }
        if (!com.baidu.navisdk.function.b.FUNC_FLOAT_SETTING.a() && com.baidu.navisdk.j.d()) {
            LogUtil.e("RouteGuide", "FUNC_FLOAT_SETTING = false!");
            return;
        }
        if (com.baidu.navisdk.module.pronavi.model.h.d || !com.baidu.navisdk.ui.routeguide.b.V().z()) {
            return;
        }
        if (!com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION") && com.baidu.navisdk.j.d()) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.x.6");
            LogUtil.e("RouteGuide", "showRGFloatView success has no permission");
            return;
        }
        LogUtil.e("RouteGuide", "showRGFloatView success has permission");
        if (!BNCommSettingManager.getInstance().getPrefFloatSwitch() && com.baidu.navisdk.j.d()) {
            return;
        }
        if (this.S == null) {
            this.S = new com.baidu.navisdk.ui.routeguide.mapmode.subview.n0();
        }
        this.S.c();
    }

    public int n0() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            return cVar.h();
        }
        return 0;
    }

    public void n1() {
        LogUtil.e("RouteGuide", " hideRefreshRoadProgess->");
        m1();
        Z(true);
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null && com.baidu.navisdk.ui.routeguide.b.V().i().c().s() && this.C != null) {
            LogUtil.e("RouteGuide", " hideRefreshRoadProgess-> setServiceAreaPanelEnable(true)");
            this.C.y(true);
        }
    }

    public boolean n2() {
        boolean z2;
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        if (gVar != null) {
            z2 = gVar.f();
        } else {
            z2 = false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "viewcontroller isInterceptToHUDModeOnVdr: " + z2);
        }
        return z2;
    }

    public void n3() {
        d1 d1Var = this.f8647a;
        if (d1Var != null) {
            d1Var.m();
        }
    }

    public void n4() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            cVar.n();
        }
    }

    public d1 o0() {
        if (this.f8647a == null) {
            this.f8647a = new d1();
        }
        return this.f8647a;
    }

    public void o1() {
        com.baidu.navisdk.ui.routeguide.control.s.T().u();
    }

    public boolean o2() {
        boolean z2;
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        if (gVar != null) {
            z2 = gVar.b();
        } else {
            z2 = false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "viewcontroller isInterceptToHighWayMiniOnVdr: " + z2);
        }
        return z2;
    }

    public void o3() {
        d1 d1Var = this.f8647a;
        if (d1Var != null && d1Var.h()) {
            this.f8647a.n();
            this.f8647a = null;
        }
    }

    public void o4() {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.w0();
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.t0();
        }
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.iview.g p0() {
        if (this.d0 == null) {
            synchronized (com.baidu.navisdk.ui.routeguide.mapmode.control.a.class) {
                try {
                    if (this.d0 == null) {
                        this.d0 = new com.baidu.navisdk.ui.routeguide.mapmode.control.a(com.baidu.navisdk.ui.routeguide.b.V().s());
                    }
                } finally {
                }
            }
        }
        return this.d0;
    }

    public void p1() {
        Activity activity;
        if (this.p0 != null && (activity = this.b) != null) {
            try {
                if (!activity.isFinishing() && this.p0.isShowing()) {
                    this.p0.dismiss();
                }
            } catch (Exception unused) {
            }
            this.p0 = null;
        }
    }

    public boolean p2() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            return b0Var.a();
        }
        return false;
    }

    public void p3() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        if (gVar != null) {
            gVar.onDestroy();
            this.d0 = null;
        }
    }

    public void p4() {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.y();
        }
    }

    public String q0() {
        String str;
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        if (gVar != null) {
            str = gVar.g();
        } else {
            str = null;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "viewcontroller getVdrMiddleLowRoadName: " + str);
        }
        return str;
    }

    public void q1() {
        com.baidu.navisdk.ui.routeguide.control.s.T().w();
    }

    public boolean q2() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null && cVar.u()) {
            return true;
        }
        return false;
    }

    public void q3() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.f("室内导航");
        }
    }

    public void q4() {
        String h2;
        Activity activity;
        if (this.b == null) {
            LogUtil.e("RouteGuide", "showReCalRouteQuitDialog mActivity == null");
            BNRoutePlaner.getInstance().p();
            BNRoutePlaner.getInstance().r();
            return;
        }
        try {
            BNDialog titleText = new BNDialog(this.b).enableBackKey(true).setTitleText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_nav_title_tip));
            if (com.baidu.navisdk.util.common.x.s()) {
                h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_nav_gps_demo_exit);
            } else {
                h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_nav_yaw_exit);
            }
            BNDialog onFirstBtnClickListener = titleText.setContentMessage(h2).setSecondBtnText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_exit_check)).setSecondBtnTextColorHighLight().setOnSecondBtnClickListener(new m0(this)).setFirstBtnText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_nav_dialog_cancel)).setOnFirstBtnClickListener(new l0(this));
            this.e0 = onFirstBtnClickListener;
            onFirstBtnClickListener.setCancelable(false);
            if (!this.e0.isShowing() && (activity = this.b) != null && !activity.isFinishing()) {
                this.e0.show();
            }
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("RouteGuide", e2);
            }
        }
    }

    public Drawable r0() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        if (gVar != null) {
            return gVar.i();
        }
        return null;
    }

    public void r1() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "hideRouteRecommendPanel: ");
        }
        if (com.baidu.navisdk.ui.routeguide.model.x.A().f8982a) {
            com.baidu.navisdk.ui.routeguide.control.s.T().a(true, -1);
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().k().b();
        }
    }

    public boolean r2() {
        BNImageTextDialog bNImageTextDialog = this.m0;
        if (bNImageTextDialog != null && bNImageTextDialog.isShowing()) {
            return true;
        }
        return false;
    }

    public void r3() {
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1005).a();
        }
    }

    public void r4() {
        b(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_refresh_loading_text), new w());
    }

    public ViewGroup s0() {
        return this.e;
    }

    public void s1() {
        if (this.W == null) {
            LogUtil.e("RouteGuide", "hideRouteSearchLoading return mRGToolboxView is null");
            return;
        }
        LogUtil.e("RouteGuide", "nearby search load complete");
        X(true);
        this.W.n();
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null && com.baidu.navisdk.ui.routeguide.b.V().i().c().s() && this.C != null) {
            LogUtil.e("RouteGuide", " hideRouteSearchLoading-> setServiceAreaPanelEnable(true)");
            this.C.y(true);
        }
    }

    public boolean s2() {
        if (e0() == 1) {
            return true;
        }
        return false;
    }

    public void s3() {
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k() && !com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().j()) {
            LogUtil.e("RouteGuide", "refreshGuidePanelMode is FsmState.IndoorPark not navi");
            l1();
            R0();
            U0();
            k();
            E1();
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
            LogUtil.e("RouteGuide", "refreshGuidePanelMode  isRoused");
            if (s2() && R2()) {
                LogUtil.e("RouteGuide", "refreshGuidePanelMode  FuseStatus - true");
                l1();
                R0();
                U0();
                Q0();
                M0();
                E1();
            } else {
                LogUtil.e("RouteGuide", "refreshGuidePanelMode FuseStatus - false");
                K4();
            }
            H4();
            return;
        }
        if (RGFSMTable.FsmState.ArriveDest.equals(RouteGuideFSM.getInstance().getTopState())) {
            LogUtil.e("RouteGuide", "refreshGuidePanelMode is FsmState.ArriveDest");
            l1();
            k();
            R0();
            U0();
            M0();
            E1();
            return;
        }
        LogUtil.e("RouteGuide", "refreshGuidePanelMode 普通诱导显示");
        L1();
        K4();
    }

    public void s4() {
        if (b2()) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().J(false);
        com.baidu.navisdk.ui.routeguide.control.s.T().J();
    }

    public com.baidu.navisdk.ui.routeguide.control.y t0() {
        return this.E0;
    }

    public void t1() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.p0 p0Var = this.F;
        if (p0Var != null) {
            com.baidu.navisdk.ui.routeguide.model.g.i = false;
            p0Var.c();
        }
    }

    public boolean t2() {
        BNImageTextDialog bNImageTextDialog = this.l0;
        if (bNImageTextDialog != null && bNImageTextDialog.isShowing()) {
            return true;
        }
        return false;
    }

    public void t3() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "refreshLeftBucketMarginTop: ");
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1018).a();
        }
    }

    public void t4() {
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing()) {
            BNDialog bNDialog = this.p0;
            if (bNDialog != null && bNDialog.isShowing()) {
                return;
            }
            Resources resources = JarUtils.getResources();
            BNDialog bNDialog2 = new BNDialog(this.b);
            this.p0 = bNDialog2;
            bNDialog2.setContentMessage(resources.getString(R.string.nsdk_string_power_save_mode_dialog_content));
            this.p0.setFirstBtnText(resources.getString(R.string.nsdk_string_power_save_mode_dialog_cancel));
            this.p0.setSecondBtnTextColorHighLight();
            this.p0.setSecondBtnText(resources.getString(R.string.nsdk_string_power_save_mode_dialog_ok));
            this.p0.setOnSecondBtnClickListener(new t());
            try {
                Activity activity2 = this.b;
                if (activity2 != null && !activity2.isFinishing()) {
                    this.p0.show();
                }
            } catch (Exception unused) {
                LogUtil.e("RouteGuide", "dialog show failed because activity is NOT running!");
            }
        }
    }

    public void u() {
        Activity activity;
        try {
            if (this.k0 != null && (activity = this.b) != null && !activity.isFinishing()) {
                if (this.k0.isShowing()) {
                    this.k0.dismiss();
                }
                this.k0 = null;
                return;
            }
            this.k0 = null;
        } catch (Exception unused) {
            this.k0 = null;
        }
    }

    public r0 u0() {
        return this.y0;
    }

    public void u1() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.a aVar = this.U;
        if (aVar != null) {
            aVar.g();
        }
    }

    public boolean u2() {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            return eVar.a();
        }
        return false;
    }

    public void u3() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "refreshRightBucketMarginTop: ");
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(2010).a();
        }
    }

    public void u4() {
        if (b2()) {
            LogUtil.e("RouteGuide", "showRouteAroundPickPointView --> isEnlargeOrColladaShow(): " + b2());
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().L();
    }

    public void v(int i2) {
        LogUtil.e("RouteGuide", "showAssistView - entry=" + i2);
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            LogUtil.e("RouteGuide", "showAssistView - isYawing return !");
            return;
        }
        if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.ArriveDest)) {
            LogUtil.e("RouteGuide", "showAssistView - ArriveDest return !");
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "showAssistView isIndoorParkState return ");
                return;
            }
            return;
        }
        if (i2 == 0) {
            H0();
            K3();
        } else if (i2 == 1) {
            H0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.A(i2);
        }
    }

    public void v0() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.r rVar = this.Z;
        if (rVar != null) {
            rVar.n0();
        }
    }

    public boolean v1() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.a aVar = this.U;
        if (aVar != null && aVar.i()) {
            return true;
        }
        return false;
    }

    public boolean v2() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.p0 p0Var = this.F;
        if (p0Var != null) {
            return p0Var.a();
        }
        return false;
    }

    public void v3() {
        m(10);
    }

    public void v4() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "showRouteSearchLoading: ");
        }
        if (this.W == null) {
            return;
        }
        if (gVar.d()) {
            gVar.e("RouteGuide", "nearby search is loading: ");
        }
        String h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_nearby_search_loading_route_poi);
        X(false);
        this.W.d(h2, new v());
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() != null && com.baidu.navisdk.ui.routeguide.b.V().i().c().s() && this.C != null) {
            LogUtil.e("RouteGuide", " showRouteSearchLoading-> setServiceAreaPanelEnable(false)");
            this.C.y(false);
        }
    }

    public void w() {
        com.baidu.navisdk.ui.routeguide.widget.volume.c cVar;
        try {
            Activity activity = this.b;
            if (activity == null || activity.isFinishing() || (cVar = this.R) == null || !cVar.isShowing()) {
                return;
            }
            this.R.dismiss();
        } catch (Exception unused) {
            this.R = null;
        }
    }

    public void w0() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.D();
        }
    }

    public void w1() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.e eVar = this.c0;
        if (eVar != null && eVar.a()) {
            this.c0.c();
        }
        a(18);
    }

    public boolean w2() {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.a aVar = this.U;
        if (aVar != null && aVar.h()) {
            return true;
        }
        return false;
    }

    public void w3() {
        m(1);
    }

    public void w4() {
        if (this.F == null) {
            this.F = new com.baidu.navisdk.ui.routeguide.mapmode.subview.p0(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, this.r);
        }
        if (this.F != null) {
            com.baidu.navisdk.ui.routeguide.model.g.i = true;
            if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().B();
            }
            this.F.y();
        }
    }

    public void x(boolean z2) {
        if (com.baidu.navisdk.j.c()) {
            return;
        }
        d1.a(z2);
    }

    public boolean x0() {
        BNDialog bNDialog = this.e0;
        if (bNDialog != null && bNDialog.isShowing()) {
            return true;
        }
        BNDialog bNDialog2 = this.g0;
        if (bNDialog2 != null && bNDialog2.isShowing()) {
            return true;
        }
        BNDialog bNDialog3 = this.j0;
        if (bNDialog3 != null && bNDialog3.isShowing()) {
            return true;
        }
        BNDialog bNDialog4 = this.k0;
        if (bNDialog4 != null && bNDialog4.isShowing()) {
            return true;
        }
        BNCommonProgressDialog bNCommonProgressDialog = this.r0;
        if (bNCommonProgressDialog != null && bNCommonProgressDialog.isShowing()) {
            return true;
        }
        BNCommonProgressDialog bNCommonProgressDialog2 = this.s0;
        if (bNCommonProgressDialog2 != null && bNCommonProgressDialog2.isShowing()) {
            return true;
        }
        BNImageTextDialog bNImageTextDialog = this.n0;
        if (bNImageTextDialog != null && bNImageTextDialog.isShowing()) {
            return true;
        }
        BNDialog bNDialog5 = this.q0;
        if (bNDialog5 != null && bNDialog5.isShowing()) {
            return true;
        }
        BNDialog bNDialog6 = this.f8648o0;
        if (bNDialog6 != null && bNDialog6.isShowing()) {
            return true;
        }
        BNDialog bNDialog7 = this.p0;
        if ((bNDialog7 != null && bNDialog7.isShowing()) || r2() || Y1() || E2() || t2() || T1()) {
            return true;
        }
        return false;
    }

    public void x1() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.o();
        }
    }

    public boolean x2() {
        synchronized (f8644X0) {
            try {
                u0 u0Var = this.a0;
                if (u0Var != null) {
                    return u0Var.n0();
                }
                return F5();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void x3() {
        try {
            F0();
            p();
            this.g0 = null;
            q();
            this.j0 = null;
            u();
            this.k0 = null;
            t();
            this.r0 = null;
            BNDialog bNDialog = this.e0;
            if (bNDialog != null && bNDialog.isShowing()) {
                this.e0.dismiss();
            }
            this.e0 = null;
            v();
            this.f0 = null;
            n();
            this.s0 = null;
            w();
            this.R = null;
            i1();
            this.l0 = null;
            F1();
            e1();
            this.f8648o0 = null;
            d1();
            this.q0 = null;
            x();
            this.t0 = null;
            p1();
            this.p0 = null;
            E0();
            this.T = null;
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("releaseAllDialogs", e2);
            }
        }
    }

    public void x4() {
        if (this.e != null) {
            com.baidu.navisdk.ui.routeguide.mapmode.iview.a a2 = com.baidu.navisdk.ui.routeguide.b.V().d().a(this.U);
            this.U = a2;
            a2.a(this.e);
        }
    }

    public void y() {
        synchronized (f8644X0) {
            try {
                if (com.baidu.navisdk.ui.routeguide.b.W()) {
                    LogUtil.e("RouteGuide", "reset return isNaviBegin");
                    return;
                }
                com.baidu.navisdk.ui.routeguide.b.V().e().removeMessages(10921);
                o5().x(false);
                H1();
                z0();
                com.baidu.navisdk.ui.routeguide.utils.c.D();
                O5();
                c();
                m5();
                x3();
                W(true);
                I5();
                this.g = null;
                this.m = null;
                this.j = null;
                this.h = 0;
                this.k = 0;
                this.o.clear();
                try {
                    j1();
                    this.S = null;
                } catch (Exception e2) {
                    LogUtil.e("RouteGuide", "reset hideRGFloatView e:" + e2.getMessage());
                }
                ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).a();
                com.baidu.navisdk.ui.routeguide.model.c.a().a(false);
                com.baidu.navisdk.ui.routeguide.model.c.a().b(false);
                com.baidu.navisdk.ui.routeguide.model.s.a().a(false);
                this.r = null;
                com.baidu.navisdk.ui.routeguide.control.s.T().a((com.baidu.navisdk.ui.routeguide.subview.a) null);
                M4();
                N4();
                RGRootViewFrameLayout rGRootViewFrameLayout = this.e;
                if (rGRootViewFrameLayout != null) {
                    rGRootViewFrameLayout.removeAllViews();
                    this.e = null;
                }
                this.b = null;
                com.baidu.navisdk.module.viewbound.a.e().d();
                com.baidu.navisdk.util.common.u.b(this);
                com.baidu.navisdk.framework.c.b().b(this.V0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void y0() {
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().d()) {
            if (this.A != null) {
                LogUtil.e("XDVoice", "hideAidVoiceView");
                this.A.c();
            }
            y(false);
        }
    }

    public void y1() {
        t0 t0Var = this.f8645I0;
        if (t0Var != null) {
            t0Var.n0();
        }
    }

    public boolean y2() {
        boolean z2;
        synchronized (f8644X0) {
            try {
                u0 u0Var = this.a0;
                if (u0Var != null) {
                    if (!u0Var.n0() && !this.a0.o0()) {
                        z2 = false;
                        return z2;
                    }
                    z2 = true;
                    return z2;
                }
                return G5();
            } finally {
            }
        }
    }

    public void y3() {
        this.p.a();
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.i();
            this.t = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.t tVar = this.Q;
        if (tVar != null) {
            tVar.i();
            this.Q = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.i();
            this.u = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.i();
            this.w = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.i();
            this.x = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.n nVar = this.G;
        if (nVar != null) {
            nVar.i();
            this.G = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.h0 h0Var = this.H;
        if (h0Var != null) {
            h0Var.i();
            this.H = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.c0 c0Var = this.N;
        if (c0Var != null) {
            c0Var.i();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            b0Var.i();
            this.J = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var2 = this.L;
        if (b0Var2 != null) {
            b0Var2.i();
            this.L = null;
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.i();
            this.Y = null;
        }
        u0 u0Var = this.a0;
        if (u0Var != null) {
            u0Var.i();
            this.a0 = null;
        }
        com.baidu.navisdk.module.newguide.subviews.d dVar = this.K0;
        if (dVar != null) {
            dVar.i();
            this.K0 = null;
        }
    }

    public void y4() {
        if (this.H0 == null) {
            this.H0 = new com.baidu.navisdk.pronavi.ui.other.a();
        }
        this.H0.b(this.e);
    }

    public void z(int i2) {
        if (com.baidu.navisdk.j.c()) {
            return;
        }
        if (this.f8647a == null) {
            this.f8647a = new d1();
        }
        this.f8647a.a(this.e, this.r, i2);
    }

    public void z0() {
        p();
        q();
        u();
        t();
        x();
        try {
            BNDialog bNDialog = this.e0;
            if (bNDialog != null && bNDialog.isShowing()) {
                this.e0.dismiss();
            }
        } catch (Exception e2) {
            this.e0 = null;
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("RouteGuide", e2);
            }
        }
        n();
        v();
        i1();
        F1();
        f1();
        d1();
        w();
        e1();
        p1();
        E0();
        com.baidu.navisdk.ugc.dialog.h.j();
        com.baidu.navisdk.ugc.dialog.g.e().c();
    }

    public void z1() {
        a(19, Boolean.FALSE);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.j jVar = this.C;
        if (jVar != null) {
            jVar.c();
        }
    }

    public boolean z2() {
        com.baidu.navisdk.pronavi.ui.other.a aVar = this.H0;
        if (aVar != null && aVar.a()) {
            return true;
        }
        return false;
    }

    public void z3() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            cVar.m();
        }
    }

    public void z4() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.N();
        }
    }

    public int P() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            return uVar.t0();
        }
        return com.baidu.navisdk.ui.routeguide.mapmode.subview.u.G0();
    }

    public void T(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.y(z2);
        }
    }

    public void e(int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "hideAllViews");
        }
        H0();
        I0();
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.E(false);
        }
        if (i2 == 0) {
            E0();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.v(i2);
        }
        J1();
        Z0();
        if (i2 != 1) {
            P0();
            t1();
            B(false);
        }
        u1();
        if (com.baidu.navisdk.ui.routeguide.control.x.b().L2()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().o3();
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().a1();
    }

    public boolean f() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            return cVar.b();
        }
        return false;
    }

    public void g() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.h0 h0Var = this.H;
        if (h0Var != null) {
            h0Var.n0();
        }
    }

    public boolean h(int i2) {
        d1 d1Var = this.f8647a;
        return d1Var != null && d1Var.b(i2);
    }

    public void i() {
        if (this.Q != null && !C2()) {
            N3();
        }
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.ui.routeguide.model.g.h().b(4);
        }
        K3();
        t0 t0Var = this.f8645I0;
        if (t0Var != null) {
            t0Var.o0();
        }
        Q4();
    }

    public void j() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.n0();
        }
    }

    public void k() {
        com.baidu.navisdk.pronavi.data.vm.b bVar;
        if (this.G0 != null) {
            if (c2() && (bVar = (com.baidu.navisdk.pronavi.data.vm.b) a(com.baidu.navisdk.pronavi.data.vm.b.class)) != null) {
                bVar.a(false);
            }
            this.G0.c();
            this.G0.i();
            this.G0 = null;
        }
    }

    public void l(int i2) {
        com.baidu.navisdk.util.common.d dVar = this.s;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void m(boolean z2) {
        if (this.i0 == null) {
            Activity activity = this.b;
            if (activity != null && !activity.isFinishing()) {
                this.i0 = new com.baidu.navisdk.ui.routeguide.subview.hud.a(this.b, null, z2);
                if (com.baidu.navisdk.ui.routeguide.model.l.f().d()) {
                    V3();
                    return;
                } else {
                    this.i0.f();
                    return;
                }
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "initHUDView return activity is null");
            }
        }
    }

    public void n() {
        BNCommonProgressDialog bNCommonProgressDialog;
        try {
            Activity activity = this.b;
            if (activity != null && !activity.isFinishing() && (bNCommonProgressDialog = this.s0) != null && bNCommonProgressDialog.isShowing()) {
                this.s0.dismiss();
            }
        } catch (Exception unused) {
            this.s0 = null;
        }
        this.s0 = null;
    }

    public void o(int i2) {
        if (com.baidu.navisdk.j.d()) {
            return;
        }
        int heightPixels = ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u);
        if (i2 != 0) {
            BNSettingManager.setCarIconOffsetForNavi(BNSettingManager.getCarIconOffsetForNavi()[0], (i2 + 100) - (heightPixels / 2));
        } else {
            BNSettingManager.setCarIconOffsetForNavi(0, 0);
        }
        for (int i3 = 0; i3 < this.o.size(); i3++) {
            if (this.o.get(i3) != null) {
                this.o.get(i3).a();
            }
        }
        this.n = i2;
        H3();
    }

    public void p(boolean z2) {
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c2;
        com.baidu.navisdk.framework.b.a(com.baidu.navisdk.ui.routeguide.b.V().b().getWindow(), z2);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.a(z2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.iview.a aVar = this.U;
        if (aVar != null) {
            aVar.b(z2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.p0 p0Var = this.F;
        if (p0Var != null) {
            p0Var.a(z2);
        }
        com.baidu.navisdk.ui.routeguide.widget.volume.c cVar = this.R;
        if (cVar != null) {
            cVar.a(z2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.c0 c0Var = this.N;
        if (c0Var != null) {
            c0Var.a(z2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.a(z2);
        }
        com.baidu.navisdk.module.newguide.settings.c cVar2 = this.W;
        if (cVar2 != null) {
            cVar2.g(z2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.a(z2);
        }
        com.baidu.navisdk.module.newguide.abs.c cVar3 = this.q;
        if (cVar3 != null) {
            cVar3.b(z2);
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.a(z2);
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.a(z2);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar2 = this.G0;
        if (aVar2 != null) {
            aVar2.a(z2);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar2 = this.Y;
        if (bVar2 != null) {
            bVar2.a(z2);
        }
        com.baidu.navisdk.module.newguide.interfaces.a aVar3 = this.M;
        if (aVar3 != null) {
            aVar3.a(z2);
        }
        h1 h1Var = this.z;
        if (h1Var != null) {
            h1Var.a(z2);
        }
        g1 g1Var = this.A;
        if (g1Var != null) {
            g1Var.a(z2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.e0 e0Var = this.v;
        if (e0Var != null) {
            e0Var.a(z2);
        }
        com.baidu.navisdk.module.business.b.d().a(z2, false);
        com.baidu.navisdk.ui.routeguide.control.i.g().a(z2);
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            BNInflaterFactory.getInstance().updateStyle(z2);
        }
        u0 u0Var = this.a0;
        if (u0Var != null) {
            u0Var.a(z2);
        }
        t0 t0Var = this.f8645I0;
        if (t0Var != null) {
            t0Var.a(z2);
        }
        j1 j1Var = this.J0;
        if (j1Var != null) {
            j1Var.a(z2);
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c j2 = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j2 == null || (c2 = j2.c(false)) == null) {
            return;
        }
        c2.a(z2);
    }

    public void q() {
        Activity activity;
        try {
            if (this.j0 != null && (activity = this.b) != null && !activity.isFinishing()) {
                if (this.j0.isShowing()) {
                    this.j0.dismiss();
                }
                this.j0 = null;
                return;
            }
            this.j0 = null;
        } catch (Exception unused) {
            this.j0 = null;
        }
    }

    public void r() {
        Activity activity;
        if (this.i0 != null && (activity = this.b) != null && !activity.isFinishing()) {
            this.i0.a();
        }
        this.i0 = null;
        this.h0 = false;
    }

    public void s(int i2) {
        if (com.baidu.navisdk.ui.routeguide.utils.b.y() && this.w != null) {
            if (f2() || N2()) {
                i2 = 8;
            }
            this.w.z(i2);
            if (!s2()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().I().f(this.w.j());
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "setRoadConditionBarVisible(), handleArrivalTimeViewCollision()");
        }
        v0();
    }

    public void t() {
        Activity activity;
        try {
            if (this.r0 == null || (activity = this.b) == null || activity.isFinishing()) {
                return;
            }
            this.r0.dismiss();
        } catch (Exception unused) {
            this.r0 = null;
        }
    }

    private void Z(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.z(z2);
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(2002).a(Boolean.valueOf(z2)).a();
        }
    }

    public void B(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.n nVar = this.G;
        if (nVar != null) {
            nVar.y(z2);
        }
    }

    public void G(boolean z2) {
        if (this.b == null || this.e == null) {
            return;
        }
        if (!z2 && !this.B0) {
            LogUtil.e("RouteGuide", "fuzzy : " + z2 + ", mIsFuzzyMode : " + this.B0);
            return;
        }
        LogUtil.e("RouteGuide", "fuzzy changed: " + z2);
        this.B0 = z2;
        s3();
        if (z2) {
            if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
                this.z.a(2, (Bundle) null);
            } else {
                com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
                if (bVar != null) {
                    bVar.d(null);
                }
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
            if (iVar != null) {
                iVar.b(true);
            }
        } else {
            com.baidu.navisdk.module.newguide.abs.b bVar2 = this.Y;
            if (bVar2 != null) {
                bVar2.u0();
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar2 = this.w;
            if (iVar2 != null) {
                iVar2.b(true);
                this.w.d();
            }
        }
        b((Bundle) null, false);
        i(false);
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.presenter.a I() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.d n02 = iVar != null ? iVar.n0() : null;
        return n02 == null ? com.baidu.navisdk.ui.routeguide.mapmode.presenter.a.f8696a : n02;
    }

    public void O(boolean z2) {
        if (this.b == null || this.e == null) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "showVdrMiddleLowInStartGuide: " + z2);
        }
        s3();
        if (z2) {
            if (com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
                this.z.a(-1, (Bundle) null);
            } else {
                com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
                if (bVar != null) {
                    bVar.d(null);
                }
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
            if (iVar != null) {
                iVar.b(true);
            }
        } else {
            com.baidu.navisdk.module.newguide.abs.b bVar2 = this.Y;
            if (bVar2 != null) {
                bVar2.u0();
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar2 = this.w;
            if (iVar2 != null) {
                iVar2.b(true);
                this.w.d();
            }
        }
        b((Bundle) null, false);
        i(false);
    }

    public void S(boolean z2) {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.f(z2);
        }
    }

    public void U(boolean z2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "updateLowVolumeView flag : " + z2 + ", mDeviceStateView=" + this.Q);
        }
        if (this.t == null) {
            return;
        }
        if (z2) {
            a0(true);
        } else {
            int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
            if (voiceMode != 2 && voiceMode != 3) {
                if (com.baidu.navisdk.util.common.d.d()) {
                    a0(true);
                } else {
                    a0(z2);
                }
            } else {
                a0(true);
            }
        }
        LogUtil.e("RouteGuide", "updateLowVolumeView end");
    }

    public ViewGroup b(int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "getViewContails -> id=" + i2 + ", mRootViewGroup = " + this.e);
        }
        RGRootViewFrameLayout rGRootViewFrameLayout = this.e;
        if (rGRootViewFrameLayout == null) {
            return null;
        }
        View findViewById = rGRootViewFrameLayout.findViewById(i2);
        if (findViewById != null && (findViewById instanceof ViewGroup)) {
            return (ViewGroup) findViewById;
        }
        if (!LogUtil.LOGGABLE) {
            return null;
        }
        LogUtil.e("RouteGuide", "getViewContails -> id=" + i2 + ", mRootViewGroup = " + this.e + ", v = " + findViewById);
        return null;
    }

    public void c() {
        LogUtil.e("RouteGuide", "cancleAutoHideControlPanel :");
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.Q0, false);
        if (!com.baidu.navisdk.poisearch.model.a.k().h() || this.P0) {
            m5();
        }
    }

    public void d() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.Q0, false);
    }

    public void h(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.n nVar = this.G;
        if (nVar != null) {
            nVar.b(com.baidu.navisdk.ui.routeguide.control.x.b().d0(), z2);
            if (LogUtil.LOGGABLE) {
                LogUtil.e(RGLaneInfoModel.TAG, "lanelineenlarge handleLaneEnlargeShow");
            }
        }
    }

    public void x(int i2) {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.y(i2);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.y(i2);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.y(i2);
        }
    }

    public void R(boolean z2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RouteGuide", "元素碰撞 - switchToSimpleGuideMode , is simpleGuideMode = " + com.baidu.navisdk.ui.routeguide.utils.b.x());
        }
        if (z2 || !(f2() || N2())) {
            s3();
            if (this.J != null) {
                if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                    this.J.t0();
                }
                h(false);
            }
            if (this.w != null) {
                if (com.baidu.navisdk.ui.routeguide.utils.b.y()) {
                    this.w.d();
                }
                this.w.r();
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
            if (b0Var != null) {
                b0Var.u0();
            }
            t3();
            if (m0() != null) {
                m0().j();
            }
        }
    }

    public void d(int i2, int i3, Intent intent) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onUgcReportActivityResult: " + i2 + "," + i3);
        }
        d1 d1Var = this.f8647a;
        if (d1Var != null) {
            d1Var.b(i2, i3, intent);
        }
    }

    public void f(Bundle bundle) {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.d(bundle);
            if (this.z != null && com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
                this.z.a(4, bundle);
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "updateSimpleGuideInfo! b --> " + bundle.toString());
            }
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.d(bundle);
        }
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.V();
        }
    }

    public boolean g(int i2) {
        d1 d1Var = this.f8647a;
        return d1Var != null && d1Var.a(i2);
    }

    public void j(boolean z2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(RGLaneInfoModel.TAG, "handlePortraitLargeLaneViewShow " + z2);
        }
        if (z2) {
            if (E5()) {
                t(true);
            }
            W0();
        } else {
            if (E5()) {
                X3();
            }
            t(false);
        }
    }

    public void l(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.e0 e0Var = this.v;
        if (e0Var != null) {
            e0Var.c();
        }
        D(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.e0 e0Var = this.v;
        if (e0Var == null) {
            return;
        }
        e0Var.y(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.y(z2);
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(2001).a(Boolean.valueOf(z2)).a();
        }
    }

    public void B(int i2) {
        t0 t0Var = this.f8645I0;
        if (t0Var != null) {
            t0Var.v(i2);
        }
    }

    public void D(boolean z2) {
        t0 t0Var;
        if (this.u != null) {
            if (z2 && !com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
                this.u.v(0);
            }
            this.u.x0();
            if (s2() && (t0Var = this.f8645I0) != null) {
                t0Var.x(0);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
            if (iVar != null) {
                iVar.s0();
            }
        }
    }

    public void a(r0 r0Var) {
        this.y0 = r0Var;
    }

    public void g(boolean z2) {
        if (E5()) {
            X3();
        }
        t(false);
        LogUtil.e(RGLaneInfoModel.TAG, "handleLandScapeLaneShow " + z2);
    }

    public void w(boolean z2) {
        synchronized (this.F0) {
            this.f8649x0 = z2;
        }
        if (!com.baidu.navisdk.j.d() && z2) {
            s(false);
        } else {
            s(true);
        }
    }

    public void z(boolean z2) {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.z(z2);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.z(z2);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.z(z2);
        }
    }

    private void I(int i2) {
        com.baidu.navisdk.pronavi.data.vm.e eVar;
        if (com.baidu.navisdk.module.newguide.a.e().d() && !com.baidu.navisdk.util.common.x.s()) {
            A5();
        }
        com.baidu.navisdk.module.newguide.subviews.d dVar = this.K0;
        if (dVar != null) {
            dVar.w(i2);
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 == null || (eVar = (com.baidu.navisdk.pronavi.data.vm.e) s2.c(com.baidu.navisdk.pronavi.data.vm.e.class)) == null) {
            return;
        }
        eVar.b(i2);
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.c[] H() {
        com.baidu.navisdk.framework.interfaces.pronavi.hd.c cVar;
        com.baidu.navisdk.module.newguide.settings.c cVar2 = this.W;
        com.baidu.navisdk.framework.interfaces.pronavi.hd.c cVar3 = null;
        com.baidu.navisdk.module.newguide.subviews.b e2 = cVar2 != null ? cVar2.e() : null;
        d1 d1Var = this.f8647a;
        if (d1Var != null) {
            cVar3 = d1Var.d();
            cVar = this.f8647a.c();
        } else {
            cVar = null;
        }
        return new com.baidu.navisdk.framework.interfaces.pronavi.hd.c[]{p5(), s5(), this.G, this.K, com.baidu.navisdk.ui.routeguide.control.i.g(), e2, this.v, this.F, this.q, cVar3, cVar, this.B};
    }

    public void a(Configuration configuration) {
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c2;
        this.f = configuration.orientation;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onOrientationChanged - " + this.f);
        }
        a((Context) this.b, true, configuration.orientation);
        if (com.baidu.navisdk.module.pronavi.model.j.b().b && com.baidu.navisdk.module.pronavi.model.j.b().a() && !com.baidu.navisdk.module.offscreen.a.h) {
            com.baidu.navisdk.module.offscreen.a.a("offScreen", "on orientation onStart");
            com.baidu.navisdk.module.pronavi.model.j.b().f7471a = true;
            com.baidu.navisdk.ui.routeguide.control.x.b().a(1, true);
        }
        com.baidu.navisdk.module.business.b.d().a((Context) com.baidu.navisdk.ui.routeguide.b.V().b(), true);
        com.baidu.navisdk.ui.routeguide.widget.volume.c cVar = this.R;
        if (cVar != null) {
            cVar.a(this.f, this.t.p0(), ScreenUtil.getInstance().getStatusBarHeight(this.b));
        }
        com.baidu.navisdk.ui.routeguide.ar.a aVar = this.W0;
        if (aVar != null) {
            aVar.a(this.d, this.f);
        }
        com.baidu.navisdk.ui.routeguide.utils.c.c(RouteGuideFSM.getInstance().getTopState());
        if (this.f != 1) {
            H1();
            com.baidu.navisdk.ui.routeguide.control.x.b().F1();
        }
        c(configuration);
        com.baidu.navisdk.pronavi.ui.other.a aVar2 = this.H0;
        if (aVar2 != null) {
            aVar2.a(this.e);
        }
        j1 j1Var = this.J0;
        if (j1Var != null) {
            j1Var.a(this.e, configuration.orientation);
        }
        com.baidu.navisdk.module.newguide.subviews.d dVar = this.K0;
        if (dVar != null) {
            dVar.a(this.e, configuration.orientation);
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c j2 = com.baidu.navisdk.ui.routeguide.b.V().j();
        if (j2 != null && (c2 = j2.c(false)) != null) {
            c2.a(this.e, configuration.orientation);
        }
        com.baidu.navisdk.pronavi.style.f.b.d();
        com.baidu.navisdk.pronavi.style.i.b g2 = com.baidu.navisdk.ui.routeguide.utils.b.g();
        if (g2 != null) {
            g2.a();
        }
    }

    public void t(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.L;
        if (b0Var != null) {
            if (z2) {
                if (d0() == 2) {
                    return;
                }
                this.L.y();
                return;
            }
            b0Var.c();
        }
    }

    public void A() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.n0();
        }
    }

    public void c(int i2, int i3, Intent intent) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onUgcDetailActivityResult: " + i2 + "," + i3);
        }
        d1 d1Var = this.f8647a;
        if (d1Var != null) {
            d1Var.a(i2, i3, intent);
        }
    }

    public void h() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void l() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.e eVar = this.V;
        if (eVar != null) {
            eVar.c();
            this.V.i();
            this.V = null;
        }
    }

    public void n(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            if (z2) {
                bVar.o0();
            } else {
                bVar.p0();
            }
        }
    }

    public void r(int i2) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("随后-setNextTurnVisibility! visible = ");
            sb.append(i2 == 0);
            LogUtil.e("RouteGuide", sb.toString());
        }
        if (i2 == 0) {
            if (!com.baidu.navisdk.ui.routeguide.model.a0.I().v() && !com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
                if (this.x != null && com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RouteGuide", "放大图随后是否显示:(放大图)" + com.baidu.navisdk.ui.routeguide.model.i.s().k());
                    }
                    this.x.v(0);
                }
                com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
                if (eVar != null) {
                    eVar.x(0);
                }
                com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
                if (aVar != null) {
                    aVar.x(0);
                }
                com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
                if (bVar != null) {
                    bVar.x(0);
                }
                d4();
                if (this.z != null && com.baidu.navisdk.ui.routeguide.asr.c.n().f() && this.z.o0()) {
                    this.z.v(0);
                    return;
                }
                return;
            }
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RouteGuide", "随后-current NaviReady || isYawing - setNextTurnVisibility return");
                return;
            }
            return;
        }
        if (this.x != null) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RouteGuide", "放大图随后gone掉(放大图)");
            }
            this.x.v(8);
            N3();
        }
        com.baidu.navisdk.module.newguide.interfaces.a aVar2 = this.M;
        if (aVar2 != null && aVar2.a()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RouteGuide", "隐藏经典诱导面板随后信息");
            }
            this.M.V();
        }
        com.baidu.navisdk.module.newguide.abs.e eVar2 = this.t;
        if (eVar2 != null) {
            eVar2.x(8);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar3 = this.G0;
        if (aVar3 != null) {
            aVar3.x(8);
        }
        if (this.z != null && com.baidu.navisdk.ui.routeguide.asr.c.n().f() && this.z.o0()) {
            this.z.v(8);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar2 = this.Y;
        if (bVar2 != null) {
            bVar2.x(8);
        }
    }

    public int Q() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            return uVar.u0();
        }
        return com.baidu.navisdk.ui.routeguide.mapmode.subview.u.G0();
    }

    public void V(boolean z2) {
        I().g(z2);
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(2003).a(Boolean.valueOf(z2)).a();
        }
    }

    public void d(Bundle bundle) {
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.d(null);
        }
        if (this.z == null || !com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
            return;
        }
        this.z.a(3, (Bundle) null);
    }

    public void u(int i2) {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.a(i2);
        }
        I(i2);
    }

    public void A(boolean z2) {
        if (z2) {
            com.baidu.navisdk.ui.routeguide.control.i.g().a(new com.baidu.navisdk.pronavi.ui.card.a(com.baidu.navisdk.ui.routeguide.b.V().c()));
        } else {
            com.baidu.navisdk.ui.routeguide.control.i.g().b(1010);
            o();
        }
    }

    public int a0() {
        return this.w0;
    }

    public void g(String str) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.g(str);
        }
    }

    public void h(String str) {
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.f(str);
        }
    }

    public void k(boolean z2) {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.c(z2);
        }
    }

    public void q(int i2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.v(i2);
        }
    }

    public void x() {
        BNCommonProgressDialog bNCommonProgressDialog;
        Activity activity = this.b;
        if (activity != null && !activity.isFinishing() && (bNCommonProgressDialog = this.t0) != null && bNCommonProgressDialog.isShowing()) {
            try {
                this.t0.dismiss();
            } catch (Exception e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("RouteGuide", e2);
                }
            }
        }
        this.t0 = null;
    }

    public int K() {
        int o02;
        if (com.baidu.navisdk.ui.routeguide.model.m.y().u()) {
            com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
            if (dVar != null) {
                o02 = dVar.p0();
            }
            o02 = 0;
        } else if (c2()) {
            com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
            if (aVar != null) {
                o02 = aVar.o0();
            }
            o02 = 0;
        } else {
            com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
            if (eVar != null) {
                o02 = eVar.o0();
            }
            o02 = 0;
        }
        if (o02 == 0) {
            o02 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_height);
        }
        return com.baidu.navisdk.ui.routeguide.b.V().r().g() ? o02 + ScreenUtil.getInstance().getStatusBarHeight(this.b) : o02;
    }

    public int L() {
        return this.k;
    }

    public void m() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.o0();
            this.u.A0();
        }
    }

    public void n(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "reloadLeftBucketItem: " + com.baidu.navisdk.ui.routeguide.utils.b.a(i2));
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1020).a(Integer.valueOf(i2)).a();
        }
    }

    public void t(int i2) {
        t0 t0Var = this.f8645I0;
        if (t0Var != null) {
            t0Var.x(i2);
        }
    }

    public void F() {
        LogUtil.e("RouteGuide", "foceHideNextTurnView");
        if (this.x != null && com.baidu.navisdk.ui.routeguide.model.i.s().k() && this.x.s0()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "强制隐藏随后逻辑(放大图)");
            }
            this.x.v(8);
        }
        com.baidu.navisdk.module.newguide.interfaces.a aVar = this.M;
        if (aVar != null && aVar.a()) {
            this.M.c();
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.w(8);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar2 = this.G0;
        if (aVar2 != null) {
            aVar2.w(8);
        }
        if (this.z != null && com.baidu.navisdk.ui.routeguide.asr.c.n().f() && this.z.o0()) {
            this.z.v(8);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.w(8);
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().N3();
    }

    public int N() {
        return this.n;
    }

    public void b(int i2, boolean z2) {
        if (b2()) {
            LogUtil.e("RouteGuide", "showAroundNeCsPointView --> isEnlargeOrColladaShow(): " + b2());
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().c(i2, z2);
    }

    public BNCommonProgressDialog c(String str) {
        Activity activity;
        if (this.b == null) {
            return null;
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().B()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
            if (gVar.d()) {
                gVar.e("showLoading but in pip, return");
            }
            return null;
        }
        try {
            if (this.r0 == null && this.b != null) {
                this.r0 = new BNCommonProgressDialog(this.b);
            }
            BNCommonProgressDialog bNCommonProgressDialog = this.r0;
            if (bNCommonProgressDialog != null) {
                bNCommonProgressDialog.setMessage(str);
                this.r0.setOnCancelListener(new n());
                if (!this.r0.isShowing() && (activity = this.b) != null && !activity.isFinishing()) {
                    this.r0.show();
                }
            }
        } catch (Exception unused) {
        }
        return this.r0;
    }

    public void i(boolean z2) {
        if (z2 && !f2() && !N2()) {
            boolean b2 = o5().b2();
            if (d0() == 2) {
                X3();
                t(false);
            } else if (b2) {
                t(true);
                W0();
            } else {
                X3();
                t(false);
            }
            LogUtil.e(RGLaneInfoModel.TAG, "handleLaneLineViewShow " + b2 + "," + d0());
            return;
        }
        W0();
        t(false);
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.subview.i0 k(int i2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i0 i0Var = new com.baidu.navisdk.ui.routeguide.mapmode.subview.i0(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, i2);
        com.baidu.navisdk.ui.routeguide.control.s.T().a(i0Var);
        return i0Var;
    }

    public void q(boolean z2) {
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1006).a(Boolean.valueOf(z2)).a();
        }
    }

    public void u(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.iview.g gVar = this.d0;
        if (gVar != null) {
            gVar.a(z2);
        }
    }

    public void z() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.r;
        if (aVar != null) {
            aVar.a(3, 0, 0, null);
        }
    }

    public void d(String str) {
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar == null || !eVar.a()) {
            return;
        }
        this.t.f(str);
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.subview.m j(int i2) {
        return a(i2, 0);
    }

    public void o() {
        Activity activity;
        BNMessageDialog bNMessageDialog = this.O;
        if (bNMessageDialog == null || !bNMessageDialog.isShowing() || (activity = this.b) == null || activity.isFinishing()) {
            return;
        }
        this.O.dismiss();
    }

    public void s() {
        com.baidu.navisdk.ugc.dialog.g.e().a();
    }

    public void w(int i2) {
        Activity activity = this.b;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.T == null) {
            this.T = new com.baidu.navisdk.ui.routeguide.widget.volume.e(com.baidu.navisdk.ui.routeguide.b.V().b());
        }
        this.T.a(i2);
    }

    public void D() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.r;
        if (aVar != null) {
            aVar.a(3, 0, 0, null);
        }
    }

    public void m(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "refreshLeftBucketItemVisible: " + com.baidu.navisdk.ui.routeguide.utils.b.a(i2));
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1017).a(Integer.valueOf(i2)).a();
        }
    }

    public void s(boolean z2) {
        ViewGroup viewGroup;
        if (this.g == null || (viewGroup = this.i) == null) {
            return;
        }
        if (z2) {
            viewGroup.setVisibility(0);
            o(this.k + this.h);
        } else {
            viewGroup.setVisibility(8);
            o(this.k);
        }
    }

    private ViewGroup H(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getServiceAreaParenView: " + i2);
        }
        if (com.baidu.navisdk.module.newguide.a.e().d() && i2 != 2) {
            com.baidu.navisdk.apicenter.h a2 = a(19);
            if (a2 != null) {
                ViewGroup viewGroup = (ViewGroup) a2.a("resultA");
                if (gVar.d()) {
                    gVar.e("RouteGuide", "getServiceAreaParenView: " + viewGroup);
                }
                return viewGroup;
            }
            if (!gVar.c()) {
                return null;
            }
            gVar.c("RouteGuide", "getServiceAreaParenView: new parentView is null");
            return null;
        }
        return (ViewGroup) this.e.findViewById(R.id.bnav_highway_service_area_container);
    }

    public void b(boolean z2, int i2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            b0Var.a(z2, i2);
        }
    }

    public void d(View view) {
        int i2;
        LogUtil.out("RouteGuide", "setNaviPageMarginBottom");
        if (view == null || com.baidu.navisdk.j.d()) {
            return;
        }
        if ((this.g == null && this.j == null) || this.f == 2) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int a2 = com.baidu.navisdk.module.newguide.a.e().a();
        ViewGroup viewGroup = this.i;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            i2 = this.k + this.h;
        } else {
            i2 = this.k;
        }
        int i3 = a2 + i2;
        marginLayoutParams.bottomMargin = i3;
        view.requestLayout();
        LogUtil.out("RouteGuide", "setNaviPageMargin: " + i3);
    }

    public boolean f(int i2) {
        return com.baidu.navisdk.ugc.dialog.g.e().a(i2);
    }

    public void v() {
        BNQuitNaviDialog bNQuitNaviDialog;
        try {
            Activity activity = this.b;
            if (activity == null || activity.isFinishing() || (bNQuitNaviDialog = this.f0) == null || !bNQuitNaviDialog.isShowing()) {
                return;
            }
            this.f0.dismiss();
        } catch (Exception unused) {
            this.f0 = null;
        }
    }

    private void f(View view) {
        if (view == null || R2()) {
            return;
        }
        LogUtil.e("XDVoice", "startFuseSimpleModeGuidePanelAnim");
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_width);
        float e2 = (com.baidu.navisdk.pronavi.util.a.h.e() * 1.0f) / dimensionPixelOffset;
        float dimensionPixelOffset2 = (JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_enlarge_guide_info_height) * 1.0f) / JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_simple_model_guide_panel_height);
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, e2, 1.0f, dimensionPixelOffset2, JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left), JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_top));
        scaleAnimation.setDuration(500L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
        alphaAnimation.setDuration(500L);
        animationSet.addAnimation(alphaAnimation);
        view.clearAnimation();
        animationSet.setAnimationListener(new z(this, view));
        view.startAnimation(animationSet);
    }

    public void o(boolean z2) {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.d(z2);
        }
    }

    public void b(ArrayList<Integer> arrayList) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            try {
                b0Var.a(arrayList);
            } catch (Exception e2) {
                LogUtil.e("RouteGuide", "Exception - updateLaneLineImage," + e2);
            }
        }
    }

    public void v(boolean z2) {
        this.S0 = z2;
    }

    public void C() {
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.o0();
        }
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.presenter.b J() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.e p02 = oVar != null ? oVar.p0() : null;
        return p02 == null ? com.baidu.navisdk.ui.routeguide.mapmode.presenter.b.f8697a : p02;
    }

    public void b(Bundle bundle, boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.n0 n0Var = this.S;
        if (n0Var == null || !n0Var.b()) {
            return;
        }
        this.S.a(bundle, z2);
    }

    public boolean e() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            return cVar.a();
        }
        return false;
    }

    public void C(int i2) {
        if (this.K == null) {
            com.baidu.navisdk.util.common.g.PRO_NAV.e("RouteGuide", "updateCurRoadLimitSpeed , view = null");
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.w(i2);
        }
    }

    public void E() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.n0();
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.y(false);
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.y(false);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.y(false);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar2 = this.Y;
        if (bVar2 != null) {
            bVar2.y(false);
        }
    }

    public void b() {
        RGRootViewFrameLayout rGRootViewFrameLayout;
        View findViewById;
        int V;
        if (d0() != 2 || (rGRootViewFrameLayout = this.e) == null || (findViewById = rGRootViewFrameLayout.findViewById(R.id.bnav_rg_notification_container)) == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
        if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
            V = com.baidu.navisdk.pronavi.util.a.h.d() / 2;
        } else {
            V = V();
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMEnlargeRoadMapView", "adjustNotificationPos" + marginLayoutParams.leftMargin + ", left:" + V);
        }
        if (marginLayoutParams.leftMargin != V) {
            marginLayoutParams.leftMargin = V;
            findViewById.requestLayout();
        }
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.b[] G() {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        return new com.baidu.navisdk.framework.interfaces.pronavi.hd.b[]{this.C, cVar != null ? cVar.g() : null, this.J};
    }

    public void e(Bundle bundle) {
        com.baidu.navisdk.ui.routeguide.subview.hud.a aVar = this.i0;
        if (aVar != null) {
            aVar.c(bundle);
        }
    }

    public void i(int i2) {
        t0 t0Var = this.f8645I0;
        if (t0Var != null) {
            t0Var.w(i2);
        }
    }

    public void c(int i2, boolean z2) {
        if (b2()) {
            LogUtil.e("RouteGuide", "showAroundServiceAreaPointView --> isEnlargeOrColladaShow(): " + b2());
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().b(i2, z2);
    }

    public void e(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "showReRoutePlanLoading: " + str);
        }
        com.baidu.navisdk.ui.routeguide.model.a0.I().d(true);
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar == null) {
            return;
        }
        cVar.b(str, new u(this));
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() == null || !com.baidu.navisdk.ui.routeguide.b.V().i().c().s() || this.C == null) {
            return;
        }
        LogUtil.e("RouteGuide", " showReRoutePlanLoading-> setServiceAreaPanelEnable(false)");
        this.C.y(false);
    }

    public void d(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "handleShowHideExitMainRoadView: " + i2 + ", last:" + com.baidu.navisdk.ui.routeguide.model.a0.I().A());
        }
        boolean z2 = i2 == 1;
        com.baidu.navisdk.ui.routeguide.holder.a.d().b(z2);
        if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "handleShowHideExitMainRoadView: is show enlarge road ");
            }
        } else if (z2) {
            if (c2()) {
                return;
            }
            s3();
        } else if (c2()) {
            s3();
        }
    }

    public void c(Configuration configuration) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ACE;
        if (gVar.d()) {
            gVar.e("RouteGuide", "orientationChange");
        }
        if (configuration.orientation == 2) {
            int a2 = com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a.k.a();
            if (a2 == 1) {
                com.baidu.navisdk.pronavi.data.vm.b bVar = (com.baidu.navisdk.pronavi.data.vm.b) a(com.baidu.navisdk.pronavi.data.vm.b.class);
                if (bVar != null) {
                    bVar.f();
                    return;
                }
                return;
            }
            if (a2 == 2) {
                com.baidu.navisdk.pronavi.data.vm.b bVar2 = (com.baidu.navisdk.pronavi.data.vm.b) a(com.baidu.navisdk.pronavi.data.vm.b.class);
                if (bVar2 != null) {
                    bVar2.g();
                }
                a(com.baidu.navisdk.ui.routeguide.ace.a.m().c().getValue(), true);
                return;
            }
            z5();
            return;
        }
        int a3 = com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a.k.a();
        if (a3 == 1) {
            com.baidu.navisdk.pronavi.data.vm.b bVar3 = (com.baidu.navisdk.pronavi.data.vm.b) a(com.baidu.navisdk.pronavi.data.vm.b.class);
            if (bVar3 != null) {
                bVar3.f();
            }
        } else if (a3 == 2) {
            com.baidu.navisdk.pronavi.data.vm.b bVar4 = (com.baidu.navisdk.pronavi.data.vm.b) a(com.baidu.navisdk.pronavi.data.vm.b.class);
            if (bVar4 != null) {
                bVar4.g();
            }
        } else {
            z5();
        }
        ViewGroup viewGroup = this.M0;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.M0 = null;
        }
    }

    public void F(int i2) {
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            return;
        }
        com.baidu.navisdk.pronavi.data.vm.devicestate.b bVar = (com.baidu.navisdk.pronavi.data.vm.devicestate.b) a(com.baidu.navisdk.pronavi.data.vm.devicestate.b.class);
        if (bVar != null) {
            bVar.a(i2);
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.z(i2);
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.w(i2);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.z(i2);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar2 = this.Y;
        if (bVar2 != null) {
            bVar2.z(i2);
        }
    }

    public void E(boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.r rVar = this.Z;
        if (rVar != null) {
            rVar.y(z2);
        }
    }

    public void b(String str, a.o oVar) {
        LogUtil.e("RouteGuide", " showRefreshRoadProgress->");
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar == null) {
            LogUtil.e("RouteGuide", "showRefreshRoadProgress return mRGToolboxView is null");
            return;
        }
        cVar.c(str, oVar);
        Z(false);
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() == null || !com.baidu.navisdk.ui.routeguide.b.V().i().c().s() || this.C == null) {
            return;
        }
        LogUtil.e("RouteGuide", " showRefreshRoadProgress-> setServiceAreaPanelEnable(false)");
        this.C.y(false);
    }

    private void e(View view) {
        if (view == null || R2()) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("XDVoice", "startFuseDefaultModeGuidePanelAnim");
        }
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.0f, (JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_enlarge_guide_info_height) * 1.0f) / com.baidu.navisdk.module.newguide.a.e().c(), 0.0f, JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_top));
        scaleAnimation.setDuration(500L);
        animationSet.addAnimation(scaleAnimation);
        view.clearAnimation();
        animationSet.setAnimationListener(new a0(this, view));
        view.startAnimation(animationSet);
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.c[] d(boolean z2) {
        com.baidu.navisdk.framework.interfaces.pronavi.hd.c cVar;
        com.baidu.navisdk.framework.interfaces.pronavi.hd.c cVar2;
        com.baidu.navisdk.module.newguide.settings.c cVar3 = this.W;
        com.baidu.navisdk.module.newguide.subviews.b e2 = (cVar3 == null || z2) ? null : cVar3.e();
        d1 d1Var = this.f8647a;
        if (d1Var != null) {
            cVar = d1Var.d();
            cVar2 = this.f8647a.c();
        } else {
            cVar = null;
            cVar2 = null;
        }
        return new com.baidu.navisdk.framework.interfaces.pronavi.hd.c[]{com.baidu.navisdk.module.cloudconfig.a.b().a("NAVI_SUPPORT_NEW_BTN", true) ? null : p5(), s5(), this.G, this.K, com.baidu.navisdk.ui.routeguide.control.i.g(), e2, this.v, this.F, this.q, cVar, cVar2, this.B};
    }

    public View M() {
        return this.m;
    }

    public void f(String str) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.f(str);
        }
    }

    public void a(Activity activity, ViewGroup viewGroup, View view, com.baidu.navisdk.ui.routeguide.subview.a aVar, int i2) {
        this.b = activity;
        this.c = viewGroup;
        this.d = (FrameLayout) viewGroup.findViewById(R.id.bnav_mapmode_container);
        this.r = aVar;
        this.s = new com.baidu.navisdk.util.common.d(activity);
        this.u0 = view;
        this.f = i2;
        H5();
        a(activity, i2);
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            C1();
        } else {
            C4();
        }
        D4();
        p4();
        C5();
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.c[] f(boolean z2) {
        com.baidu.navisdk.framework.interfaces.pronavi.hd.c cVar;
        com.baidu.navisdk.module.newguide.settings.c cVar2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getNormalHDSwitchUiAnimatorList: " + z2);
        }
        com.baidu.navisdk.framework.interfaces.pronavi.hd.c cVar3 = null;
        com.baidu.navisdk.module.newguide.subviews.b e2 = (z2 || (cVar2 = this.W) == null) ? null : cVar2.e();
        d1 d1Var = this.f8647a;
        if (d1Var != null) {
            cVar3 = d1Var.d();
            cVar = this.f8647a.c();
        } else {
            cVar = null;
        }
        return new com.baidu.navisdk.framework.interfaces.pronavi.hd.c[]{p5(), s5(), this.G, this.K, com.baidu.navisdk.ui.routeguide.control.i.g(), this.v, this.F, this.q, cVar3, cVar, this.B, e2, com.baidu.navisdk.ui.routeguide.control.s.T().e()};
    }

    public void y(int i2) {
        if (this.e == null) {
            com.baidu.navisdk.util.common.g.PRO_NAV.a("Common: ", "showMenuMoreView mRootViewGroup is null");
            return;
        }
        if (this.W == null) {
            this.W = new com.baidu.navisdk.module.newguide.settings.c();
        }
        this.W.a(com.baidu.navisdk.ui.routeguide.b.V().b(), com.baidu.navisdk.ui.routeguide.b.V().s(), this.e, this.r, i2);
    }

    public void b(String str) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.f(str);
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.y(true);
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.y(true);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar = this.G0;
        if (aVar != null) {
            aVar.y(true);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar2 = this.Y;
        if (bVar2 != null) {
            bVar2.y(true);
        }
    }

    public void c(View view) {
        this.m = view;
    }

    public void c(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "handleRecommendRouteRouteDisappear: " + i2);
        }
        if (com.baidu.navisdk.ui.routeguide.model.x.A().f8982a && (((int) Math.pow(2.0d, com.baidu.navisdk.ui.routeguide.model.x.A().k())) & i2) != 0) {
            com.baidu.navisdk.ui.routeguide.control.s.T().a(true, -1);
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().k().a(i2);
        }
    }

    public void r(boolean z2) {
        this.v0 = z2;
    }

    public void y(boolean z2) {
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1014).a(Boolean.valueOf(z2)).a();
        }
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.b[] e(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getNormalHDSwitchUi: " + z2);
        }
        if (z2) {
            return null;
        }
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        return new com.baidu.navisdk.framework.interfaces.pronavi.hd.b[]{this.C, cVar != null ? cVar.g() : null};
    }

    public void p() {
        Activity activity;
        try {
            if (this.g0 == null || (activity = this.b) == null || activity.isFinishing()) {
                return;
            }
            if (this.g0.isShowing()) {
                this.g0.dismiss();
            }
            this.g0 = null;
        } catch (Exception e2) {
            this.g0 = null;
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("RouteGuide", e2);
            }
        }
    }

    public Rect W() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            return b0Var.X();
        }
        return null;
    }

    public void b(boolean z2) {
        if (this.W == null || s2()) {
            return;
        }
        this.W.b(z2);
    }

    public void a(Fragment fragment) {
        FragmentTransaction beginTransaction = this.b.getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.bnav_fragment_container, fragment);
        beginTransaction.commit();
        com.baidu.navisdk.ui.routeguide.navicenter.b.b().a(fragment);
    }

    public void b(int i2, int i3, Intent intent) {
        com.baidu.navisdk.ugc.dialog.g.e().a(i2, i3, intent);
    }

    public void b(View view) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.r rVar = this.Z;
        if (rVar != null) {
            rVar.a(view);
        }
    }

    public void c(Bundle bundle) {
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        if (V == null || V.j() == null) {
            return;
        }
        V.j().g().c(bundle);
    }

    public void b(View view, int i2) {
        this.j = view;
        this.k = i2;
    }

    public void p(int i2) {
        I().b(i2);
        m(2);
    }

    private boolean a(Context context, boolean z2, int i2, int i3, boolean z3, int i4) {
        com.baidu.navisdk.module.newguide.settings.c cVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        gVar.a("RouteGuide", "preloadViews onStart");
        if (context == null) {
            return false;
        }
        com.baidu.navisdk.module.perform.b.d().c("preloadViews");
        com.baidu.navisdk.module.perform.b.h = 1;
        synchronized (f8644X0) {
            try {
                if (this.p == null) {
                    this.p = new com.baidu.navisdk.pronavi.data.a();
                }
                if (gVar.e()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("preloadViews-> mRootViewGroup: ");
                    sb.append(this.e);
                    sb.append(", mPreloadActivityHashcode = ");
                    sb.append(this.p.b() == context.hashCode());
                    sb.append(", mPreloadOrientation: ");
                    sb.append(this.p.d() == i4);
                    sb.append(",mPreloadVehicleType: ");
                    sb.append(this.p.e());
                    sb.append(",vehicleType: ");
                    sb.append(i2);
                    sb.append(", sceneType:");
                    sb.append(i3);
                    sb.append(", isNewGuide:");
                    sb.append(z3);
                    sb.append(",mPreloadNewGuideView: ");
                    sb.append(this.p.c());
                    gVar.g("RouteGuide", sb.toString());
                }
                if (this.e != null && Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    gVar.a("preloadViews return false in thread");
                    return false;
                }
                if (this.e != null && this.p.a(context.hashCode(), i4, i2, i3, z3 ? 1 : 0)) {
                    if (this.p.b() != -1 && this.t != null && this.Q != null && (this.w != null || com.baidu.navisdk.module.newguide.a.e().d())) {
                        if (!z2 && (cVar = this.W) != null) {
                            cVar.R();
                        }
                        if (gVar.e()) {
                            gVar.g("RouteGuide", "preloadViews has ok");
                        }
                        return true;
                    }
                    if (gVar.e()) {
                        gVar.g("RouteGuide", "preloadViews has err reload");
                    }
                }
                try {
                    if (a(context, z2, z3, i4)) {
                        this.p.a(context.hashCode());
                        this.p.e(i2);
                        this.p.d(i3);
                        this.p.b(z3 ? 1 : 0);
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("RouteGuide", "preloadViews end success");
                        }
                        return true;
                    }
                    this.p.a();
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RouteGuide", "preloadViews end false");
                    }
                    return false;
                } catch (Throwable th) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("preloadViews", th);
                    }
                    this.p.a();
                    return false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(Bundle bundle) {
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        if (V == null || V.j() == null) {
            return;
        }
        V.j().g().b(bundle);
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.hd.b[] c(boolean z2) {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        return new com.baidu.navisdk.framework.interfaces.pronavi.hd.b[]{this.C, (cVar == null || z2) ? null : cVar.g(), this.J, r5(), q5()};
    }

    public void b(Configuration configuration) {
        if (this.C != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "serviceAreaOrientationChange: " + configuration.orientation);
            }
            this.C.a(H(configuration.orientation), configuration.orientation);
        }
    }

    public void b(q0 q0Var) {
        if (q0Var != null) {
            this.o.remove(q0Var);
        }
    }

    private boolean a(Context context, boolean z2, boolean z3, int i2) {
        int i3;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "loadViews: " + z3 + "isWideScreen: " + com.baidu.navisdk.pronavi.util.a.h.i() + "," + i2);
        }
        if (context == null) {
            return false;
        }
        RGRootViewFrameLayout rGRootViewFrameLayout = this.e;
        if (rGRootViewFrameLayout != null) {
            rGRootViewFrameLayout.removeAllViews();
            this.e = null;
        }
        if (!z2) {
            W(true);
        }
        if (2 == i2) {
            if (z3) {
                i3 = R.layout.nsdk_layout_rg_mapmode_main_land_new_v2;
            } else {
                i3 = R.layout.nsdk_layout_rg_mapmode_main_land;
            }
        } else if (z3) {
            i3 = R.layout.nsdk_layout_rg_mapmode_main_new_v2;
        } else {
            i3 = R.layout.nsdk_layout_rg_mapmode_main;
        }
        RGRootViewFrameLayout rGRootViewFrameLayout2 = (RGRootViewFrameLayout) JarUtils.preloadInflate(context, i3, null, false);
        this.e = rGRootViewFrameLayout2;
        if (rGRootViewFrameLayout2 == null) {
            return false;
        }
        this.p.c(i2);
        if (z2) {
            a(z3, i2, context);
        } else {
            this.q = com.baidu.navisdk.module.newguide.a.e().a(z3, this.e);
            this.t = com.baidu.navisdk.module.newguide.a.e().e(z3, context, this.e, this.r);
            this.Q = com.baidu.navisdk.module.newguide.a.e().b(z3, context, this.e, this.r);
            if (1 == com.baidu.navisdk.ui.routeguide.control.x.b().d0()) {
                this.L = new com.baidu.navisdk.ui.routeguide.mapmode.subview.b0(context, this.e, this.r, 100);
            } else {
                this.L = null;
                if (this.Z == null && !z3) {
                    this.Z = new com.baidu.navisdk.ui.routeguide.mapmode.subview.r(context, this.e, this.r);
                }
            }
            if (!z3) {
                this.w = new com.baidu.navisdk.ui.routeguide.mapmode.subview.i(context, this.e, this.r);
            }
            this.G = new com.baidu.navisdk.ui.routeguide.mapmode.subview.n(context, this.e, this.r);
            this.J = new com.baidu.navisdk.ui.routeguide.mapmode.subview.b0(context, this.e, this.r, 101);
            this.K = new com.baidu.navisdk.ui.routeguide.mapmode.subview.b(context, this.e, this.r);
            this.M = com.baidu.navisdk.module.newguide.a.e().d(z3, context, this.e, this.r);
            this.b0 = new b1(context, this.e, this.r);
        }
        if (1 == com.baidu.navisdk.ui.routeguide.control.x.b().d0()) {
            if (this.g != null) {
                this.i = (ViewGroup) this.e.findViewById(R.id.bnav_sdk_above_bar_view);
                if (this.g.getParent() != null) {
                    ((ViewGroup) this.g.getParent()).removeAllViews();
                }
                this.i.addView(this.g);
                this.i.getLayoutParams().height = this.h;
                this.i.setVisibility(0);
                E3();
            }
            if (this.j != null) {
                ViewGroup viewGroup = (ViewGroup) this.e.findViewById(R.id.bnav_sdk_below_bar_view);
                this.l = viewGroup;
                if (viewGroup != null) {
                    if (this.j.getParent() != null) {
                        ((ViewGroup) this.j.getParent()).removeAllViews();
                    }
                    this.l.addView(this.j);
                    this.l.getLayoutParams().height = this.k;
                    this.l.setVisibility(0);
                }
            }
            o(this.k + this.h);
        }
        this.e.addOnGlobalLayoutListener(this.f8646O0);
        return true;
    }

    private void a(boolean z2, int i2, Context context) {
        d1 d1Var;
        if (this.q == null) {
            this.q = com.baidu.navisdk.module.newguide.a.e().a(z2, this.e);
        }
        this.q.a(this.e, i2);
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.t tVar = this.Q;
        if (tVar != null) {
            tVar.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.o oVar = this.u;
        if (oVar != null) {
            oVar.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b bVar = this.K;
        if (bVar != null) {
            bVar.a(this.e, i2);
        }
        com.baidu.navisdk.module.newguide.interfaces.a aVar = this.M;
        if (aVar != null) {
            aVar.a(this.e, i2);
        }
        if (1 == com.baidu.navisdk.ui.routeguide.control.x.b().d0()) {
            this.L = new com.baidu.navisdk.ui.routeguide.mapmode.subview.b0(context, this.e, this.r, 100);
        } else {
            this.L = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.i iVar = this.w;
        if (iVar != null) {
            iVar.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.n nVar = this.G;
        if (nVar != null) {
            nVar.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.h0 h0Var = this.H;
        if (h0Var != null) {
            h0Var.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.c0 c0Var = this.N;
        if (c0Var != null) {
            c0Var.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.J;
        if (b0Var != null) {
            b0Var.a((ViewGroup) this.e, i2, 101);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var2 = this.L;
        if (b0Var2 != null) {
            b0Var2.a((ViewGroup) this.e, i2, 100);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.r rVar = this.Z;
        if (rVar != null) {
            rVar.a(this.e, i2);
        } else if (i2 == 2 && !com.baidu.navisdk.module.newguide.a.e().d()) {
            this.Z = new com.baidu.navisdk.ui.routeguide.mapmode.subview.r(context, this.e, this.r);
        }
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.iview.a aVar2 = this.U;
        if (aVar2 != null) {
            aVar2.d();
            this.U = null;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.p0 p0Var = this.F;
        if (p0Var != null) {
            p0Var.i();
            this.F = null;
        }
        com.baidu.navisdk.module.newguide.abs.d dVar = this.y;
        if (dVar != null) {
            dVar.a(this.e, i2);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar3 = this.G0;
        if (aVar3 != null) {
            aVar3.a(this.e, i2);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar2 = this.Y;
        if (bVar2 != null) {
            bVar2.a(this.e, i2);
        }
        h1 h1Var = this.z;
        if (h1Var != null) {
            h1Var.a(this.e, i2);
        }
        g1 g1Var = this.A;
        if (g1Var != null) {
            g1Var.a(this.e, i2);
        }
        d1 d1Var2 = this.f8647a;
        if (d1Var2 != null) {
            d1Var2.b();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.k0 k0Var = this.P;
        if (k0Var != null) {
            k0Var.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.x xVar = this.B;
        if (xVar != null) {
            xVar.a(this.e, i2);
        }
        if (com.baidu.navisdk.ugc.external.d.n && (d1Var = this.f8647a) != null) {
            d1Var.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.e0 e0Var = this.v;
        if (e0Var != null) {
            e0Var.a(this.e, i2);
        }
        u0 u0Var = this.a0;
        if (u0Var != null) {
            u0Var.a(this.e, i2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.iview.e eVar2 = this.c0;
        if (eVar2 != null) {
            eVar2.a(this.e, i2);
        }
        b1 b1Var = this.b0;
        if (b1Var != null) {
            b1Var.a(this.e, i2);
        }
        if (this.V != null && i2 == 1) {
            this.V.a((ViewGroup) this.e.findViewById(R.id.bnav_rg_indoor_park_container));
        }
        t0 t0Var = this.f8645I0;
        if (t0Var != null) {
            t0Var.a(this.e, i2);
        }
    }

    private void a(Context context, int i2) {
        a(context, false, i2);
    }

    private void a(Context context, boolean z2, int i2) {
        View view;
        RGRootViewFrameLayout rGRootViewFrameLayout;
        try {
            FrameLayout frameLayout = this.d;
            if (frameLayout != null && (rGRootViewFrameLayout = this.e) != null) {
                frameLayout.removeView(rGRootViewFrameLayout);
            }
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("RouteGuide", e2);
            }
        }
        boolean d2 = com.baidu.navisdk.module.newguide.a.e().d();
        if (a(context, z2, com.baidu.navisdk.module.vehiclemanager.b.i().b(), com.baidu.navisdk.ui.routeguide.b.V().q(), d2, i2)) {
            P5();
        } else {
            a(context, z2, d2, i2);
        }
        if (context == null) {
            return;
        }
        com.baidu.navisdk.util.logic.j.r().a(com.baidu.navisdk.ui.routeguide.control.x.b().s0());
        if (this.e == null) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.q.c().b();
        if (!com.baidu.navisdk.j.d() && (view = this.u0) != null) {
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.u0);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            ViewGroup viewGroup = (ViewGroup) this.c.findViewById(R.id.bnav_rg_map_content);
            if (viewGroup != null) {
                viewGroup.addView(this.u0, 0, layoutParams);
                viewGroup.requestLayout();
            }
        }
        if (this.d != null && this.e != null) {
            try {
                this.d.addView(this.e, 4, new FrameLayout.LayoutParams(-1, -1));
            } catch (Exception e3) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("RouteGuide", e3);
                }
            }
            this.d.requestLayout();
            G3();
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().e() != null && com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.ui.routeguide.b.V().e().sendMessageDelayed(com.baidu.navisdk.ui.routeguide.b.V().e().obtainMessage(10921, 1, 0), 500L);
        }
        com.baidu.navisdk.ui.routeguide.utils.c.a(this.b, (ViewGroup) this.e, 1, 4, 2, 5, 6, 8, 9, 10, 11, 7);
        if (BNSettingManager.isShowNativeLog()) {
            com.baidu.navisdk.ui.routeguide.utils.c.E();
        }
    }

    public void a(View... viewArr) {
        a(true, true, viewArr);
    }

    public void a(boolean z2, boolean z3, View... viewArr) {
        if (viewArr != null) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().a(d0(), z2, z3, viewArr);
        }
    }

    public void a(long j2) {
        LogUtil.e("RouteGuide", "autoHideControlPanelView :" + j2);
        if (RouteGuideFSM.getInstance().getCurrentEvent() == null || !RouteGuideFSM.getInstance().getCurrentEvent().equals(RGFSMTable.FsmEvent.MSG_YAWING_START)) {
            if (j2 <= 0) {
                j2 = com.baidu.navisdk.ui.routeguide.utils.b.e();
            }
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.Q0, false);
            com.baidu.navisdk.util.worker.c.a().a(this.Q0, new com.baidu.navisdk.util.worker.e(2, 0), j2);
        }
    }

    public void a(String str, Bundle bundle, boolean z2) {
        if (this.f8647a == null) {
            this.f8647a = new d1();
        }
        this.f8647a.a(this.e, this.r, str, bundle, z2);
    }

    public void a(Message message) {
        if (this.f8647a == null) {
            this.f8647a = new d1();
        }
        this.f8647a.a(message);
    }

    public void a(Drawable drawable) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "updateNextTurnIcon: - Drawable=" + drawable);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.a(drawable);
        }
        com.baidu.navisdk.module.newguide.interfaces.a aVar = this.M;
        if (aVar != null) {
            aVar.a(drawable);
        }
        com.baidu.navisdk.module.newguide.abs.e eVar = this.t;
        if (eVar != null) {
            eVar.b(drawable);
        }
        h1 h1Var = this.z;
        if (h1Var != null) {
            h1Var.b(drawable);
        }
        com.baidu.navisdk.module.newguide.abs.a aVar2 = this.G0;
        if (aVar2 != null) {
            aVar2.b(drawable);
        }
        com.baidu.navisdk.module.newguide.abs.b bVar = this.Y;
        if (bVar != null) {
            bVar.b(drawable);
        }
    }

    public void a(Bundle bundle, boolean z2) {
        B5();
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            if (z2) {
                uVar.e(bundle);
            } else {
                uVar.d(bundle);
            }
        }
        if (this.z == null || !com.baidu.navisdk.ui.routeguide.asr.c.n().f()) {
            return;
        }
        this.z.a(1, bundle);
    }

    public void a(ArrayList<Integer> arrayList) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.b0 b0Var = this.L;
        if (b0Var != null) {
            try {
                b0Var.a(arrayList);
            } catch (Exception e2) {
                LogUtil.e("RouteGuide", "Exception - updateEnlargeLaneLineImage," + e2);
            }
        }
    }

    public void a(int i2, int i3, Intent intent) {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.a(i2, i3, intent);
        }
    }

    public boolean a(int i2, boolean z2) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.n nVar = this.G;
        if (nVar != null) {
            return nVar.c(i2, z2);
        }
        return false;
    }

    public boolean a(int i2, boolean z2, int i3) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.n nVar = this.G;
        if (nVar != null) {
            return nVar.a(i2, z2, i3);
        }
        return false;
    }

    public void a(BNBaseDialog.OnNaviClickListener onNaviClickListener, DialogInterface.OnDismissListener onDismissListener, boolean z2) {
        Activity activity;
        if (this.b == null) {
            return;
        }
        try {
            if (this.O == null) {
                this.O = new BNMessageDialog(this.b).setTitleText((String) null).setMessage(JarUtils.getResources().getString(R.string.alert_bt_osc_msg)).setFirstBtnText(JarUtils.getResources().getString(R.string.alert_cancel)).setSecondBtnText(JarUtils.getResources().getString(R.string.alert_bt_osc_open)).setOnFirstBtnClickListener((BNBaseDialog.OnNaviClickListener) new o()).setMessageGravity(GravityCompat.START);
            }
            if (onDismissListener != null) {
                this.O.setOnDismissListener(onDismissListener);
            }
            if (onNaviClickListener != null) {
                this.O.setOnSecondBtnClickListener((BNBaseDialog.OnNaviClickListener) new p(onNaviClickListener));
            }
            BNMessageDialog bNMessageDialog = this.O;
            if (bNMessageDialog == null || bNMessageDialog.isShowing() || (activity = this.b) == null || activity.isFinishing()) {
                return;
            }
            this.O.setFirstBtnTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_color_dialog_content_text));
            this.O.setSecondBtnTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_color_dialog_other_btn_text));
            this.O.updateStyle();
            this.O.setCanceledOnTouchOutside(z2);
            this.O.show();
        } catch (Exception unused) {
        }
    }

    public void a(int i2, int i3, int i4, int i5, boolean z2) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        if (this.b == null) {
            return;
        }
        LogUtil.e("RouteGuide", "Show BNVolumeDialog Loading");
        try {
            if (com.baidu.navisdk.bluetooth.b.i().f() && !T1() && !T()) {
                com.baidu.navisdk.ui.routeguide.widget.volume.c cVar = this.R;
                if (!(cVar instanceof com.baidu.navisdk.ui.routeguide.widget.volume.a)) {
                    if (cVar != null && cVar.isShowing() && (activity3 = this.b) != null && !activity3.isFinishing()) {
                        this.R.dismiss();
                    }
                    this.R = com.baidu.navisdk.ui.routeguide.widget.volume.d.a(this.b);
                }
            } else {
                com.baidu.navisdk.ui.routeguide.widget.volume.c cVar2 = this.R;
                if (!(cVar2 instanceof com.baidu.navisdk.ui.routeguide.widget.volume.b)) {
                    if (cVar2 != null && cVar2.isShowing() && (activity = this.b) != null && !activity.isFinishing()) {
                        this.R.dismiss();
                    }
                    this.R = com.baidu.navisdk.ui.routeguide.widget.volume.d.b(this.b);
                }
            }
            if (!this.R.isShowing() && (activity2 = this.b) != null && !activity2.isFinishing()) {
                this.R.show();
            }
            if (this.R.isShowing()) {
                this.R.a(i2, i3, i4, i5, z2, this.t.p0(), ScreenUtil.getInstance().getStatusBarHeight(this.b));
            }
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RouteGuide", "showVolume,error = " + e2);
            }
        }
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.subview.m a(int i2, int i3) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar = new com.baidu.navisdk.ui.routeguide.mapmode.subview.m(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, i2, i3);
        com.baidu.navisdk.ui.routeguide.control.s.T().a(mVar);
        return mVar;
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.subview.l a(com.baidu.navisdk.ui.routeguide.model.e eVar) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.l lVar = new com.baidu.navisdk.ui.routeguide.mapmode.subview.l(com.baidu.navisdk.ui.routeguide.b.V().c(), this.e, eVar);
        com.baidu.navisdk.ui.routeguide.control.s.T().a(lVar);
        return lVar;
    }

    public AnimatorSet a(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", -ScreenUtil.getInstance().dip2px(180), 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        animatorSet.play(ofFloat);
        return animatorSet;
    }

    public void a(boolean z2) {
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.a(z2);
        }
    }

    public void a(String str, a.o oVar) {
        LogUtil.e("RouteGuide", " showOfflineToOnlineProgress->");
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar == null) {
            LogUtil.e("RouteGuide", "showOfflineToOnlineProgress return mRGToolboxView is null");
            return;
        }
        cVar.a(str, oVar);
        Y(false);
        if (com.baidu.navisdk.ui.routeguide.b.V().i().c() == null || !com.baidu.navisdk.ui.routeguide.b.V().i().c().s() || this.C == null) {
            return;
        }
        LogUtil.e("RouteGuide", " showOfflineToOnlineProgress-> setServiceAreaPanelEnable(false)");
        this.C.y(false);
    }

    private void a(boolean z2, boolean z3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "enlargeViewVisibleChange: " + z3 + "," + z2);
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1025).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.navisdk.ui.routeguide.ace.d dVar, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "onACELightChange: " + dVar + "," + z2);
        }
        if (dVar == null) {
            z5();
            return;
        }
        com.baidu.navisdk.module.ace.c b2 = dVar.b();
        if (b2 != com.baidu.navisdk.module.ace.c.INVALID) {
            K5();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.w wVar = this.N0;
        if (wVar != null) {
            if (b2 == com.baidu.navisdk.module.ace.c.LIGHT_SHOW_REMAIN) {
                wVar.b(dVar.a(), false);
                return;
            }
            if (b2 == com.baidu.navisdk.module.ace.c.LIGHT_PASS) {
                wVar.b(dVar.a(), !z2);
                return;
            }
            if (b2 == com.baidu.navisdk.module.ace.c.LIGHT_SHOW_PASS_COUNT) {
                wVar.a(dVar.a(), false);
            } else if (b2 == com.baidu.navisdk.module.ace.c.LIGHT_SHOW_PASS_COUNT_LABEL) {
                wVar.a(dVar.a(), !z2);
            } else {
                z5();
            }
        }
    }

    public void a(View view, int i2) {
        this.g = view;
        this.h = i2;
    }

    public void a(String str) {
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().f().a();
        }
        a5();
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u uVar = this.x;
        if (uVar != null) {
            uVar.l0();
        }
        com.baidu.navisdk.module.newguide.settings.c cVar = this.W;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b a(com.baidu.navisdk.ui.routeguide.control.indoorpark.a aVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("indoorPark", "initIndoorParkView-> isOrientationPortrait" + s2() + "mActivity:" + this.b.getApplicationContext());
        }
        ViewGroup viewGroup = this.f == 1 ? (ViewGroup) this.e.findViewById(R.id.bnav_rg_indoor_park_container) : null;
        if (this.V == null) {
            this.V = new com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.e(com.baidu.navisdk.ui.routeguide.b.V().c(), viewGroup, aVar);
        }
        return this.V;
    }

    public void a(boolean z2, int i2) {
        com.baidu.navisdk.ui.routeguide.b.V().s().j().e("RGBucketGroupComponent").a(2017).a(Boolean.valueOf(z2)).b(Integer.valueOf(i2)).a();
    }

    public void a() {
        com.baidu.navisdk.module.newguide.abs.c cVar = this.q;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void a(Bundle bundle) {
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        if (V == null || V.j() == null) {
            return;
        }
        V.j().g().a(bundle);
    }

    public void a(int... iArr) {
        for (int i2 : iArr) {
            a(i2, (Object) null);
        }
    }

    public void a(int i2, Object obj) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "refreshRightBucketItemVisible: " + com.baidu.navisdk.ui.routeguide.utils.b.a(i2) + "," + obj);
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            s2.j().e("RGBucketGroupComponent").a(1017).a(Integer.valueOf(i2)).b(obj).a();
        }
    }

    public com.baidu.navisdk.apicenter.h a(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "refreshRightBucketItemVisible: " + com.baidu.navisdk.ui.routeguide.utils.b.a(i2));
        }
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            return s2.j().e("RGBucketGroupComponent").a(2011).a(Integer.valueOf(i2)).a();
        }
        return null;
    }

    @Nullable
    public <T extends com.baidu.navisdk.pageframe.store.data.c> T a(Class<T> cls) {
        com.baidu.navisdk.pronavi.ui.base.b s2 = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s2 != null) {
            return (T) s2.c(cls);
        }
        return null;
    }

    public void a(q0 q0Var) {
        if (q0Var != null) {
            this.o.add(q0Var);
        }
    }
}

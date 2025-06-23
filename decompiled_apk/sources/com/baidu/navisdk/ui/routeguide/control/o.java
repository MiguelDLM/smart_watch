package com.baidu.navisdk.ui.routeguide.control;

import OXOo.OOXIXo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class o implements com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b, com.baidu.navisdk.module.pronavi.abs.b {
    private int A;
    private int B;
    private int C;
    private int D;
    private MutableLiveData<Boolean> E;
    private int F;
    private boolean G;
    private com.baidu.navisdk.pronavi.hd.hdnavi.model.a H;
    protected com.baidu.navisdk.framework.interfaces.pronavi.hd.d c;
    private com.baidu.navisdk.framework.interfaces.pronavi.hd.e d;
    protected com.baidu.navisdk.pronavi.hd.hdnavi.e e;
    private com.baidu.navisdk.pronavi.hd.hdnavi.a f;
    private ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> g;
    private ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> h;
    private ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> i;
    private Bundle j;
    private boolean m;
    private com.baidu.navisdk.pronavi.hd.hdnavi.animator.a t;
    private boolean u;
    private com.baidu.navisdk.pronavi.hd.hdnavi.f y;
    private final com.baidu.navisdk.framework.interfaces.pronavi.hd.f z;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8568a = false;
    private boolean b = false;
    private int k = 0;
    private int l = 0;
    private AnimatorSet n = null;
    private int o = 0;
    private int p = 1;
    private long q = 0;
    private int r = 8;
    private int s = -1;
    private boolean v = false;
    private boolean w = false;
    private com.baidu.navisdk.pronavi.hd.hdnavi.b x = null;

    /* loaded from: classes8.dex */
    public class a implements g0.d {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.d
        public void a() {
            o.this.u = false;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements g0.d {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.d
        public void a() {
            o.this.u = false;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8571a;
        final /* synthetic */ boolean b;

        public c(o oVar, int i, boolean z) {
            this.f8571a = i;
            this.b = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "enterDoubleMap onAnimationCancel from: " + this.f8571a);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "enterDoubleMap onAnimationEnd from: " + this.f8571a);
            }
            if (this.f8571a == 0) {
                String currentState = RouteGuideFSM.getInstance().getCurrentState();
                if (gVar.d()) {
                    gVar.e("RGHDLaneNaviControllerV2", "enterDoubleMap onAnimationEnd: " + currentState);
                }
                if (RGFSMTable.FsmState.NearbySearch.equals(currentState)) {
                    r.i().h();
                }
            }
            if (!this.b && com.baidu.navisdk.ui.routeguide.mapmode.a.o5().S()) {
                x.b().t3();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "enterDoubleMap onAnimationStart from: " + this.f8571a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8572a;

        public d(o oVar, int i) {
            this.f8572a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "enterFullHD onAnimationCancel from: " + this.f8572a);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "enterFullHD onAnimationEnd from: " + this.f8572a);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "enterFullHD onAnimationStart from: " + this.f8572a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8573a;
        final /* synthetic */ boolean b;

        public e(int i, boolean z) {
            this.f8573a = i;
            this.b = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            if (this.b) {
                o.this.w();
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "enterNormal onAnimationCancel from: " + this.f8573a + ", " + this.b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.b) {
                o.this.w();
            }
            if (this.f8573a == 2) {
                String currentState = RouteGuideFSM.getInstance().getCurrentState();
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGHDLaneNaviControllerV2", "enterDoubleMap onAnimationEnd: " + currentState);
                }
                if (RGFSMTable.FsmState.NearbySearch.equals(currentState)) {
                    r.i().h();
                }
            }
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGHDLaneNaviControllerV2", "enterNormal onAnimationEnd from: " + this.f8573a + ", " + this.b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "enterNormal onAnimationStart from: " + this.f8573a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements com.baidu.navisdk.framework.interfaces.pronavi.hd.d {
        public f() {
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.d
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "onClickEnterFullHD: ");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.v.d", "1");
            o.this.a(3);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hd_full"));
            BNSettingManager.setHdScreenMode(2);
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.d
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "onClickEnterNormal: ");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.v.d", "2");
            o.this.e();
        }
    }

    /* loaded from: classes8.dex */
    public class g implements com.baidu.navisdk.framework.interfaces.pronavi.hd.e {
        public g() {
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.e
        public void a() {
            o.c(o.this);
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.e
        public void b() {
            o.this.m = true;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "onConfirmClick: overheat");
            }
            o.this.a(0);
        }

        @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.e
        public boolean c() {
            if (o.this.l < 1) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class h extends g0.f {
        public h(o oVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b(boolean z) {
            super.b(z);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements i0.f {
        public i() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            o.this.a(0);
            com.baidu.navisdk.util.statistic.userop.b.r().d("11.0.1.1318", "2");
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            BNCommSettingManager.getInstance().setHdNaviEnable(false);
            BNRouteGuider.getInstance().setHdLaneMapMode(false);
            o.this.a(0);
            com.baidu.navisdk.util.statistic.userop.b.r().d("11.0.1.1318", "1");
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            o oVar = o.this;
            oVar.D = oVar.C;
            o.this.a(0);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hd_close"));
            com.baidu.navisdk.util.statistic.userop.b.r().d("11.0.1.1318", "0");
        }
    }

    public o() {
        com.baidu.navisdk.pronavi.hd.hdnavi.c cVar = new com.baidu.navisdk.pronavi.hd.hdnavi.c();
        this.z = cVar;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = new MutableLiveData<>();
        this.F = Integer.MIN_VALUE;
        this.G = false;
        this.H = new com.baidu.navisdk.pronavi.hd.hdnavi.model.a(false);
        cVar.c = e(false);
        cVar.b = e(true);
        cVar.d = this.H.d();
        cVar.e = this.H.b();
    }

    public static int A() {
        if (com.baidu.navisdk.module.cloudconfig.f.c().I.e) {
            return FeatureCodes.VO;
        }
        return 0;
    }

    private String B() {
        return ";uiState:" + this.C + ", engineState:" + this.B + ",UserSwitchState: " + this.F;
    }

    private String C() {
        if (!K() && this.B != 1) {
            return "当前功能已关闭";
        }
        this.D = this.C;
        d(0, true);
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", "0", "7", "xiaodu");
        return "好的，已为您关闭智能车道指引模式";
    }

    private String D() {
        String str;
        boolean z;
        if (!BNCommSettingManager.getInstance().isHdNaviEnable()) {
            z = true;
            BNCommSettingManager.getInstance().setHdNaviEnable(true);
            str = "好的，已为您开启车道级导航开关";
        } else {
            str = null;
            z = false;
        }
        if (!BNRouteGuider.getInstance().isOpenHdLaneMapMode()) {
            com.baidu.navisdk.ui.routeguide.utils.b.B();
        }
        if (K()) {
            str = "当前功能已开启";
        } else if (L()) {
            I();
            o();
            str = "好的，即将为您启动智能车道引导模式";
        } else if (!z) {
            str = i(-1);
        }
        if (TextUtils.isEmpty(str)) {
            str = "抱歉，当前路段暂不支持车道指引模式";
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", "4", "7", "xiaodu");
        }
        t();
        return str;
    }

    private String E() {
        int i2 = this.C;
        String str = "已为您切换至全屏模式";
        if (i2 != 2) {
            if (i2 != 3) {
                if (L()) {
                    d(3, true);
                    if (this.C == 3) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", "3", "7", "xiaodu");
                    } else {
                        str = null;
                    }
                } else if (!BNCommSettingManager.getInstance().isHdNaviEnable()) {
                    BNCommSettingManager.getInstance().setHdNaviEnable(true);
                    com.baidu.navisdk.ui.routeguide.utils.b.B();
                    str = "好的，已为您开启车道级导航开关";
                } else {
                    if (!BNRouteGuider.getInstance().isOpenHdLaneMapMode()) {
                        com.baidu.navisdk.ui.routeguide.utils.b.B();
                    }
                    str = i(3);
                }
            } else {
                str = "当前已是全屏模式";
            }
        } else {
            d(3, true);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", "3", "7", "xiaodu");
        }
        if (TextUtils.isEmpty(str)) {
            str = "抱歉，当前路段暂不支持车道指引模式";
        }
        t();
        return str;
    }

    private String F() {
        String str;
        int i2 = this.C;
        if (i2 != 2) {
            str = "已为您切换至分屏模式";
            if (i2 != 3) {
                if (L()) {
                    d(2, true);
                    if (this.C == 2) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", "2", "7", "xiaodu");
                    } else {
                        str = null;
                    }
                } else if (!BNCommSettingManager.getInstance().isHdNaviEnable()) {
                    BNCommSettingManager.getInstance().setHdNaviEnable(true);
                    com.baidu.navisdk.ui.routeguide.utils.b.B();
                    str = "好的，已为您开启车道级导航开关";
                } else {
                    if (!BNRouteGuider.getInstance().isOpenHdLaneMapMode()) {
                        com.baidu.navisdk.ui.routeguide.utils.b.B();
                    }
                    str = i(2);
                }
            } else {
                d(2, true);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", "2", "7", "xiaodu");
            }
        } else {
            str = "当前已是分屏模式";
        }
        if (TextUtils.isEmpty(str)) {
            str = "抱歉，当前路段暂不支持车道指引模式";
        }
        t();
        return str;
    }

    private void G() {
        this.k++;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "handleUserCloseHdNavi: " + this.k + "," + com.baidu.navisdk.module.cloudconfig.f.c().I.f7140a);
        }
    }

    private void H() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "handlerEnterHdNavi: ");
        }
        if (!this.b) {
            P();
        }
        ProNaviStatItem.O().h(a0.I().l());
    }

    private void I() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "initData: ");
        }
        this.F = Integer.MIN_VALUE;
        this.w = false;
        this.G = false;
        h(0);
    }

    private boolean J() {
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null && animatorSet.isRunning()) {
            return true;
        }
        return false;
    }

    private boolean K() {
        int i2 = this.C;
        if (i2 != 2 && i2 != 3) {
            return false;
        }
        return true;
    }

    private boolean L() {
        if (this.B != 0) {
            return true;
        }
        return false;
    }

    private void M() {
        if (this.x == null) {
            this.x = new com.baidu.navisdk.pronavi.hd.hdnavi.b();
        }
        this.x.b();
    }

    private boolean N() {
        if (!BNCommSettingManager.getInstance().isNeedShowHDCloseConfirmPanel()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "showCloseSettingConfirmPanelIfNeed: showed");
            }
            return false;
        }
        if (s.T().l(136)) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGHDLaneNaviControllerV2", "showCloseSettingConfirmPanelIfNeed is showing");
            }
            return false;
        }
        if (!s.T().b(136)) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGHDLaneNaviControllerV2", "showCloseSettingConfirmPanelIfNeed false");
            }
            return false;
        }
        BNCommSettingManager.getInstance().setNeedShowHDCloseConfirmPanel(false);
        s.T().p();
        return x.b().k(136).D(100).v(15000).y(false).d(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_hd_close_setting_icon)).a("是否永久关闭高快速车道级导航？").b("设置-辅助功能中可再次开启或关闭").g("本次关闭").f("永久关闭").z(2).a(new i()).a(new h(this)).y();
    }

    private void O() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "showNotification: " + this.o);
        }
        if (this.o >= 2) {
            return;
        }
        if (x.b().L2()) {
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "showNotification: isUgcReportVisible");
            }
        } else {
            if (com.baidu.navisdk.util.logic.j.r().k().getValue().booleanValue() && com.baidu.navisdk.module.cloudconfig.a.b().a("open_bei_dou_tag", true)) {
                x.b().j(124).z(130).b(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_ic_hd_tip_beidou)).g(JarUtils.getResources().getString(R.string.bnav_rg_preload_hd_navi_bei_dou)).v(3000).a(new a()).y();
            } else {
                x.b().j(124).z(130).b(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_ic_hd_tip)).f(JarUtils.getResources().getString(R.string.bnav_rg_preload_hd_navi)).v(3000).a(new b()).y();
            }
            this.o++;
        }
    }

    private void P() {
        x.b().L4();
        BNMapController.getInstance().setSimpleModeGuide(!com.baidu.navisdk.ui.routeguide.utils.b.x());
    }

    public static /* synthetic */ int c(o oVar) {
        int i2 = oVar.l;
        oVar.l = i2 + 1;
        return i2;
    }

    private void f(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "handlerExitHDNaviByPolicy: " + B() + ", isNeedAnimator:" + z);
        }
        if (K()) {
            Bundle bundle = this.j;
            if (bundle != null) {
                bundle.putInt("screenState", 0);
            }
            a(0, false, z ? A() : 0);
        }
    }

    private void r() {
        if (this.t == null) {
            this.t = new com.baidu.navisdk.pronavi.hd.hdnavi.animator.a(com.baidu.navisdk.ui.routeguide.b.V().c(), x.b().s0());
        }
        a(this.t);
    }

    private void t() {
        if (this.k >= com.baidu.navisdk.module.cloudconfig.f.c().I.f7140a) {
            this.k = 0;
        }
    }

    private void u() {
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList = this.g;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList2 = this.h;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    private void v() {
        Bundle bundle = this.j;
        if (bundle != null) {
            bundle.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "disposeHdMap: " + this.e);
        }
        this.C = 0;
        this.z.f6817a = 0;
        if (this.e != null) {
            Bundle bundle = this.j;
            if (bundle != null && !bundle.isEmpty()) {
                this.j.putInt("screenState", 0);
            }
            f(-1);
            b(this.e);
            b(this.e);
            this.e.i();
            this.e = null;
        }
        this.t = null;
        v();
    }

    private void x() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "enterNaviModeBaseMap: ");
        }
        x.b().z();
        if (TextUtils.equals(RouteGuideFSM.getCurrentGlassState(), RGFSMTable.FsmState.Fullview)) {
            RouteGuideFSM.getInstance().setFullViewByUser(false);
            RouteGuideFSM.getInstance().run(RouteGuideFSM.getInstance().getLastestMap2DOr3DStateFromLocal());
        } else {
            RouteGuideFSM.getInstance().setFullViewByUser(false);
        }
    }

    private void y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "exitBrowserForHDMap: ");
        }
        com.baidu.navisdk.pronavi.hd.hdnavi.e eVar = this.e;
        if (eVar != null) {
            eVar.o0();
        }
    }

    private void z() {
        v();
        boolean J = J();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "handlePreloadExit: " + J);
        }
        if (!J) {
            w();
        }
        h(this.C);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public void e() {
        if (N()) {
            return;
        }
        this.D = this.C;
        d(0, false);
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hd_close"));
    }

    public void g(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "notifySwitchStateEngine: " + i2 + B());
        }
        if (!K() && q()) {
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "onGuideNotifySwitchState: isTempShieldHDNavi");
            }
            if (i2 == 0) {
                I();
                w();
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", "0", "5", com.kwad.sdk.m.e.TAG);
                return;
            }
            return;
        }
        if (i2 == 0) {
            I();
            v();
            if (!K()) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", "0", "6", com.kwad.sdk.m.e.TAG);
                boolean J = J();
                if (gVar.d()) {
                    gVar.e("RGHDLaneNaviControllerV2", "onGuideNotifySwitchState: " + J);
                }
                if (J) {
                    return;
                }
                w();
                return;
            }
        }
        if (this.F != Integer.MIN_VALUE) {
            if (K()) {
                f(i2);
                h(this.C);
            } else if (this.w || this.F != 0) {
                c(this.F, true);
                f(this.F);
            }
        } else {
            if (i2 != this.C) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", i2 + "", "1", com.kwad.sdk.m.e.TAG);
            }
            c(i2, true);
            f(i2);
        }
        this.w = false;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void h() {
        com.baidu.navisdk.pronavi.hd.hdnavi.e eVar = this.e;
        if (eVar != null) {
            eVar.h();
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void i() {
        s();
        this.C = 0;
        this.B = 0;
        this.z.f6817a = 0;
        this.D = 0;
        this.b = false;
        com.baidu.navisdk.pronavi.hd.hdnavi.f fVar = this.y;
        if (fVar != null) {
            fVar.a();
            this.y = null;
        }
        w();
        this.f8568a = false;
        this.k = 0;
        u();
        this.l = 0;
        com.baidu.navisdk.pronavi.hd.hdnavi.a aVar = this.f;
        if (aVar != null) {
            aVar.a();
            this.f = null;
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> arrayList = this.i;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.o = 0;
        com.baidu.navisdk.pronavi.hd.hdnavi.b bVar = this.x;
        if (bVar != null) {
            bVar.a();
            this.x = null;
        }
        this.v = false;
        I();
        v();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public int j() {
        return this.C;
    }

    public void m() {
        s.T().e(115);
    }

    public void n() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "handlePreload: ");
        }
        this.w = false;
        this.p = x.b().d0();
        if (gVar.c() && this.C != 0) {
            gVar.c("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate: PRELOAD failed");
            if (gVar.d()) {
                gVar.c();
            }
        }
        M();
        m();
        O();
        o();
        if (this.y == null) {
            this.y = new com.baidu.navisdk.pronavi.hd.hdnavi.f();
        }
        a(this.y);
        f(1);
        a(0, 1, x.b().s2());
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", "1", "1", com.kwad.sdk.m.e.TAG);
    }

    public void o() {
        if (this.e == null) {
            p();
            com.baidu.navisdk.pronavi.hd.hdnavi.e eVar = new com.baidu.navisdk.pronavi.hd.hdnavi.e(com.baidu.navisdk.ui.routeguide.b.V().c(), x.b().k0(), x.b().d0(), this.H);
            this.e = eVar;
            eVar.v(this.r);
            this.e.w(this.s);
            this.e.a(this.c);
            a(this.e);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void onBackground() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "onBackground: ");
        }
        this.v = true;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void onForeground() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "onForeground: ");
        }
        this.v = false;
    }

    public void p() {
        if (this.c == null) {
            this.c = new f();
        }
        if (this.d == null) {
            this.d = new g();
        }
    }

    public boolean q() {
        if (x.b().T()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "isTempShieldHDNavi: is hud show");
            }
            return true;
        }
        if (this.v) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGHDLaneNaviControllerV2", "isTempShieldHDNavi: isBackground");
            }
            return true;
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.v()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGHDLaneNaviControllerV2", "isTempShieldHDNavi: is Pop Mode");
            }
            return true;
        }
        com.baidu.navisdk.pronavi.ui.base.b s = com.baidu.navisdk.ui.routeguide.b.V().s();
        if (s != null && s.I()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RGHDLaneNaviControllerV2", "isTempShieldHDNavi FsmState.DynamicLayer isShowChargeStationList:");
            }
            return true;
        }
        if (s != null && s.L()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("RGHDLaneNaviControllerV2", "isTempShieldHDNavi FsmState.DynamicLayer isShowParkRecList:");
            }
            return true;
        }
        if (s != null && s.K()) {
            com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar6.d()) {
                gVar6.e("RGHDLaneNaviControllerV2", "isTempShieldHDNavi isShowParkPanelList:");
            }
            return true;
        }
        if (this.w) {
            com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar7.d()) {
                gVar7.e("RGHDLaneNaviControllerV2", "isTempShieldHDNavi: isPolicyExitHDNavi");
            }
            if (s.T().l(103)) {
                if (gVar7.d()) {
                    gVar7.e("RGHDLaneNaviControllerV2", "isTempShieldHDNavi: TYPE_ROUTE_RECOMMEND");
                }
                return true;
            }
            if (RouteGuideFSM.getInstance().isTopState(RGFSMTable.FsmState.NearbySearch)) {
                if (gVar7.d()) {
                    gVar7.e("RGHDLaneNaviControllerV2", "isTempShieldHDNavi FsmState.NearbySearch");
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public void s(Message message) {
        boolean z;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate:" + message + ",arg1:" + message.arg1 + ", " + message.arg2);
            gVar.e("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate engine mHDUiState: " + this.C + ",mUserSwitchState:" + this.F + ",mHDEngineState:" + this.B + ", isBackground:" + this.v);
        }
        if (!com.baidu.navisdk.ui.routeguide.b.W()) {
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate: is not navi begin");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.l.2", "2");
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.A() && !com.baidu.navisdk.ui.routeguide.utils.b.s()) {
            this.f8568a = gVar.d() && message.arg2 == -3456;
            Bundle bundle = new Bundle();
            try {
                z = BNRouteGuider.getInstance().getHdMapData(bundle);
            } catch (Throwable th) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.c()) {
                    gVar2.c("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate getHdMapData exception:" + th);
                }
                z = false;
            }
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate getHdMapData:" + z + ", " + bundle + ",isUiTest:" + this.f8568a);
            }
            if (this.f8568a) {
                z = true;
            }
            if (!z) {
                if (gVar3.c()) {
                    gVar3.c("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate: getHdMapData failed:" + message.arg1);
                    gVar3.d();
                }
                if (message.arg1 != 0) {
                    return;
                }
                bundle.clear();
                Bundle bundle2 = this.j;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                bundle.putInt("screenState", 0);
            }
            Bundle bundle3 = this.j;
            if (bundle3 == null) {
                this.j = new Bundle();
            } else {
                bundle3.clear();
            }
            int i2 = bundle.getInt("screenState", 0);
            if (i2 == 2 || i2 == 3) {
                if (gVar3.c()) {
                    gVar3.c("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate: loadedUserSettingMode = " + this.G);
                }
                if (!this.G) {
                    this.G = true;
                    this.A = BNSettingManager.getHdScreenMode();
                }
                if (gVar3.c()) {
                    gVar3.c("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate: userSettingScreenMode = " + this.A);
                }
                int i3 = this.A;
                if (i3 == 2) {
                    bundle.putInt("screenState", 3);
                } else if (i3 == 1) {
                    bundle.putInt("screenState", 2);
                }
            }
            this.j.putAll(bundle);
            int i4 = bundle.getInt("screenState", 0);
            if (gVar3.c()) {
                gVar3.c("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate: " + this.C + ":" + this.B + ",to:" + i4);
            }
            if (this.f8568a) {
                i4 = message.arg1;
            }
            this.B = i4;
            if (i4 == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.q > 3000) {
                    n();
                }
                this.q = currentTimeMillis;
                return;
            }
            if (this.e == null && i4 != 0) {
                if (gVar3.c() && gVar3.d()) {
                    gVar3.c("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate: mHdView == null");
                }
                if (this.F == Integer.MIN_VALUE) {
                    com.baidu.navisdk.util.statistic.userop.b.r().d("3.l.2", "1");
                    return;
                }
                return;
            }
            g(i4);
            return;
        }
        if (gVar.c()) {
            gVar.c("RGHDLaneNaviControllerV2", "onHdMapRouteUpdate: not isUserNewSetting");
            if (gVar.d()) {
                gVar.c();
            }
        }
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.l.2", "0");
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public void c(boolean z) {
        com.baidu.navisdk.pronavi.hd.hdnavi.e eVar = this.e;
        if (eVar != null) {
            eVar.y(z);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public void d() {
        s();
    }

    private void d(int i2, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "onUserSwitchState toState: " + i2 + B() + ", isVoice:" + z);
        }
        if (J()) {
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "onUserSwitchState: isAnimatorRunning");
                return;
            }
            return;
        }
        if (!z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", i2 + "", "2", "click");
        }
        this.F = i2;
        this.w = false;
        if (K()) {
            f(i2);
            c(i2, true);
            if (i2 == 0) {
                G();
                return;
            }
            return;
        }
        if (L()) {
            if (i2 == 0) {
                z();
                if (this.B == 1) {
                    G();
                    return;
                }
                return;
            }
            o();
            f(i2);
            c(i2, true);
        }
    }

    private void h(int i2) {
        boolean z = false;
        boolean z2 = i2 == 0 && L() && this.F == 0;
        boolean isHdNaviEnable = BNCommSettingManager.getInstance().isHdNaviEnable();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "changeShowMapBtnState: enable -> " + z2 + ", curUiState = " + i2 + ", mUserSwitchState = " + this.F + ", isHasHDData = " + L() + ", hdNaviEnable = " + isHdNaviEnable);
        }
        MutableLiveData<Boolean> mutableLiveData = this.E;
        if (isHdNaviEnable && z2) {
            z = true;
        }
        mutableLiveData.setValue(Boolean.valueOf(z));
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public void b(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "onDrivingRouteChange: " + B() + ", " + str);
        }
        this.B = 0;
        I();
        if (!K()) {
            w();
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", "0", "4", str);
        Bundle bundle = this.j;
        if (bundle != null) {
            bundle.putInt("screenState", 0);
        }
        c(0, true);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void a(int i2) {
        d(i2, false);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "enterNaviState: ");
        }
        com.baidu.navisdk.pronavi.hd.hdnavi.e eVar = this.e;
        if (eVar != null) {
            eVar.n0();
        }
    }

    private int e(boolean z) {
        return z ? this.H.f() : this.H.c();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public void a(int i2, String str, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "onPolicyCausesSwitchState toState: " + i2 + B() + "," + str + "," + z);
        }
        int i3 = this.C;
        if (i3 == 0 || i3 == i2) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.l.1", i2 + "", "3", str);
        if (i2 == 0) {
            this.w = true;
            f(z);
        } else {
            this.F = i2;
            c(i2, true);
            f(i2);
        }
    }

    private void c(int i2, boolean z) {
        a(i2, z, A());
    }

    public void f(int i2) {
        if (this.f8568a) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "notifyMapDataUpdate: is ui test");
                return;
            }
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGHDLaneNaviControllerV2", "notifyMapDataUpdate: " + i2);
        }
        if (i2 == 0) {
            return;
        }
        Bundle bundle = this.j;
        if (bundle != null && this.e != null) {
            int i3 = this.F;
            if (i3 != Integer.MIN_VALUE) {
                bundle.putInt("screenState", i3);
            }
            this.j.putInt(bn.f.V, this.p == 2 ? 1 : 0);
            if (gVar2.d()) {
                gVar2.e("RGHDLaneNaviControllerV2", "notifyMapDataUpdate: " + this.j);
            }
            boolean e2 = this.e.e(this.j);
            if (gVar2.d()) {
                gVar2.e("RGHDLaneNaviControllerV2", "notifyMapDataUpdate result:" + e2);
                return;
            }
            return;
        }
        if (gVar2.c()) {
            gVar2.c("RGHDLaneNaviControllerV2", "notifyMapDataUpdate: mHdGuideData == null");
        }
    }

    public void b(com.baidu.navisdk.framework.interfaces.pronavi.hd.c... cVarArr) {
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList;
        if (cVarArr == null || cVarArr.length == 0 || (arrayList = this.g) == null || arrayList.isEmpty()) {
            return;
        }
        for (com.baidu.navisdk.framework.interfaces.pronavi.hd.c cVar : cVarArr) {
            this.g.remove(cVar);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void a(ViewGroup viewGroup, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "orientationChange: " + this.p + "->" + i2);
        }
        this.p = i2;
        s();
        u();
        com.baidu.navisdk.pronavi.hd.hdnavi.e eVar = this.e;
        if (eVar != null) {
            eVar.a(viewGroup, i2);
            f(this.B);
        }
        com.baidu.navisdk.pronavi.hd.hdnavi.animator.a aVar = this.t;
        if (aVar != null) {
            aVar.a(viewGroup, i2);
        }
        if (this.C == 3) {
            a(i2 != 2, true);
        }
    }

    public void b(com.baidu.navisdk.framework.interfaces.pronavi.hd.a aVar) {
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> arrayList = this.i;
        if (arrayList == null || aVar == null) {
            return;
        }
        arrayList.remove(aVar);
    }

    private void b(int i2, boolean z) {
        List<Animator> d2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "enterFullHD  from: " + i2 + "," + z);
        }
        s();
        a(z, true);
        s.T().e(103);
        x();
        if (i2 == 2) {
            y();
        } else if (i2 == 0) {
            H();
        }
        com.baidu.navisdk.ui.routeguide.b.V().h().j().e("BNRoadConditionService").a(1).a();
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList = this.h;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> it = this.h.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.b next = it.next();
                if (next != null) {
                    next.b(i2, e(z), z, this.z);
                }
            }
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList2 = this.g;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> it2 = this.g.iterator();
        while (it2.hasNext()) {
            com.baidu.navisdk.framework.interfaces.pronavi.hd.c next2 = it2.next();
            if (next2 != null && (d2 = next2.d(i2, e(z), z, this.z)) != null && !d2.isEmpty()) {
                d2.removeAll(Collections.singleton(null));
                animatorSet.playTogether(d2);
            }
        }
        animatorSet.setDuration(A());
        animatorSet.addListener(new d(this, i2));
        this.n = animatorSet;
        animatorSet.start();
    }

    private void d(boolean z) {
        com.baidu.navisdk.framework.interfaces.pronavi.hd.b[] c2 = x.b().c(z);
        if (c2 != null && c2.length > 0) {
            a(c2);
        }
        if (com.baidu.navisdk.module.cloudconfig.f.c().I.d) {
            if (this.f == null) {
                com.baidu.navisdk.pronavi.hd.hdnavi.a aVar = new com.baidu.navisdk.pronavi.hd.hdnavi.a();
                this.f = aVar;
                aVar.a(this.d);
            }
            a(this.f);
        }
        a(x.b().d(z));
        a(this.e);
        r();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public int f() {
        return this.D;
    }

    private String i(int i2) {
        Bundle bundle = new Bundle();
        boolean hdLaneDataInfo = BNRouteGuider.getInstance().getHdLaneDataInfo(bundle);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "handleQueryEngineResult: " + hdLaneDataInfo + ", " + bundle + ",toState:" + i2);
        }
        int i3 = bundle.getInt("type", 0);
        String string = bundle.getString("roadName", null);
        if (i3 != 1) {
            return (i3 == 3 && !TextUtils.isEmpty(string)) ? String.format("抱歉，当前路段暂不支持，到达%s将启动车道指引模式", string) : "抱歉，当前路段暂不支持车道指引模式";
        }
        if (i2 != -1) {
            this.F = i2;
        }
        return "好的，前方将为您开启智能车道指引模式";
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void a(boolean z) {
        com.baidu.navisdk.pronavi.hd.hdnavi.e eVar = this.e;
        if (eVar != null) {
            eVar.a(z);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public boolean g() {
        return K();
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    public void a(com.baidu.navisdk.framework.interfaces.pronavi.hd.c... cVarArr) {
        if (cVarArr == null || cVarArr.length == 0) {
            return;
        }
        if (this.g == null) {
            this.g = new ArrayList<>(12);
        }
        for (com.baidu.navisdk.framework.interfaces.pronavi.hd.c cVar : cVarArr) {
            if (cVar != null && !this.g.contains(cVar)) {
                this.g.add(cVar);
            }
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public void d(int i2) {
        if (i2 < 0) {
            return;
        }
        this.s = i2;
        com.baidu.navisdk.pronavi.hd.hdnavi.e eVar = this.e;
        if (eVar != null) {
            eVar.w(i2);
        }
    }

    public void a(com.baidu.navisdk.framework.interfaces.pronavi.hd.b... bVarArr) {
        if (bVarArr == null || bVarArr.length == 0) {
            return;
        }
        if (this.h == null) {
            this.h = new ArrayList<>(8);
        }
        for (com.baidu.navisdk.framework.interfaces.pronavi.hd.b bVar : bVarArr) {
            if (bVar != null && !this.h.contains(bVar)) {
                this.h.add(bVar);
            }
        }
    }

    public void a(com.baidu.navisdk.framework.interfaces.pronavi.hd.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.i == null) {
            this.i = new ArrayList<>(8);
        }
        if (this.i.contains(aVar)) {
            return;
        }
        this.i.add(aVar);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public void b(int i2) {
        if (i2 < 0) {
            return;
        }
        this.r = i2;
        com.baidu.navisdk.pronavi.hd.hdnavi.e eVar = this.e;
        if (eVar != null) {
            eVar.v(i2);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.c
    @OOXIXo
    public com.baidu.navisdk.framework.interfaces.pronavi.hd.f a() {
        return this.z;
    }

    private void a(int i2, boolean z, int i3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "handleHDStateSwitch toState: " + i2 + B() + z + ",animatorTime: " + i3);
        }
        if (i2 == this.C) {
            return;
        }
        boolean s2 = x.b().s2();
        u();
        d(s2);
        if (i2 != 0 && !K()) {
            this.b = !com.baidu.navisdk.ui.routeguide.utils.b.x();
        }
        int i4 = this.C;
        this.C = i2;
        this.z.f6817a = i2;
        a(i4, i2, s2);
        x.b().r3();
        if (i2 == 0) {
            a(i4, s2, z, i3);
        } else if (i2 == 2) {
            a(i4, s2);
        } else if (i2 == 3) {
            b(i4, s2);
        }
        h(this.C);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public LiveData<Boolean> b() {
        return this.E;
    }

    private void s() {
        if (this.n != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHDLaneNaviControllerV2", "cancelAnimator: ");
            }
            if (this.n.isRunning()) {
                this.n.cancel();
            }
            this.n.removeAllListeners();
            Iterator<Animator> it = this.n.getChildAnimations().iterator();
            while (it.hasNext()) {
                Animator next = it.next();
                if (next != null) {
                    next.removeAllListeners();
                    if (next instanceof ValueAnimator) {
                        ((ValueAnimator) next).removeAllUpdateListeners();
                    }
                }
            }
            this.n = null;
        }
    }

    public void a(int i2, int i3, boolean z) {
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> arrayList = this.i;
        if (arrayList != null) {
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onHdStateSwitch(i2, i3, z);
            }
        }
    }

    private void a(int i2, boolean z) {
        List<Animator> a2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "enterDoubleMap from: " + i2 + "," + z);
        }
        if (i2 == 3) {
            x();
            y();
            a(z, false);
        } else if (i2 == 0) {
            H();
        }
        s();
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList = this.h;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> it = this.h.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.b next = it.next();
                if (next != null) {
                    next.e(i2, e(z), z, this.z);
                }
            }
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList2 = this.g;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> it2 = this.g.iterator();
        while (it2.hasNext()) {
            com.baidu.navisdk.framework.interfaces.pronavi.hd.c next2 = it2.next();
            if (next2 != null && (a2 = next2.a(i2, e(z), z, this.z)) != null && !a2.isEmpty()) {
                a2.removeAll(Collections.singleton(null));
                animatorSet.playTogether(a2);
            }
        }
        animatorSet.setDuration(A());
        animatorSet.addListener(new c(this, i2, z));
        this.n = animatorSet;
        animatorSet.start();
    }

    private void a(boolean z, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "handleLandLaneLineVisible: " + z + "," + z2);
        }
        if (z) {
            return;
        }
        if (z2) {
            x.b().W0();
        } else {
            x.b().g(false);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(7, true, 2);
        }
    }

    private void a(int i2, boolean z, boolean z2, int i3) {
        List<Animator> c2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "enterNormal from: " + i2 + "," + z + ", isNeedDisposeHdMap:" + z2 + ", " + i3);
        }
        if (i2 == 3) {
            x();
            a(z, false);
        }
        this.q = 0L;
        s();
        if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
            P();
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList = this.h;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> it = this.h.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.b next = it.next();
                if (next != null) {
                    next.f(i2, e(z), z, this.z);
                }
            }
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList2 = this.g;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            AnimatorSet animatorSet = new AnimatorSet();
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> it2 = this.g.iterator();
            while (it2.hasNext()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.c next2 = it2.next();
                if (next2 != null && (c2 = next2.c(i2, e(z), z, this.z)) != null && !c2.isEmpty()) {
                    c2.removeAll(Collections.singleton(null));
                    animatorSet.playTogether(c2);
                }
            }
            animatorSet.setDuration(i3);
            animatorSet.addListener(new e(i2, z2));
            this.n = animatorSet;
            animatorSet.start();
        }
        u();
        ProNaviStatItem.O().g(a0.I().l());
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b
    public String a(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHDLaneNaviControllerV2", "handleAsrAction: " + str + "," + B());
        }
        if (!com.baidu.navisdk.module.cloudconfig.f.c().I.c && !com.baidu.navisdk.util.common.x.s() && com.baidu.navisdk.ui.routeguide.utils.b.A()) {
            if (com.baidu.navisdk.ui.routeguide.utils.b.s()) {
                return "AR导航不支持车道级引导模式";
            }
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -89294738:
                    if (str.equals("all_scene")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -81917568:
                    if (str.equals("half_scene")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3417674:
                    if (str.equals("open")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 94756344:
                    if (str.equals("close")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return E();
                case 1:
                    return F();
                case 2:
                    return D();
                case 3:
                    return C();
                default:
                    return null;
            }
        }
        return "暂不支持该指令";
    }
}

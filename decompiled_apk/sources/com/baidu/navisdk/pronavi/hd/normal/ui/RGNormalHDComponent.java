package com.baidu.navisdk.pronavi.hd.normal.ui;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.pronavi.ui.base.RGUiComponent;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RGStateCar3D;
import com.baidu.navisdk.ui.routeguide.fsm.RGStateNorth2D;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.map.j;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.oX;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XoX;

/* loaded from: classes7.dex */
public final class RGNormalHDComponent extends RGUiComponent<com.baidu.navisdk.pronavi.ui.base.b> {
    private final com.baidu.navisdk.pronavi.hd.normal.i.a p;
    private ImageView q;
    private View r;
    private ViewGroup s;
    private AnimatorSet t;
    private ValueAnimator u;
    private boolean v;
    private ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> w;
    private ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> x;
    private com.baidu.navisdk.pronavi.hd.hdnavi.animator.a y;

    /* loaded from: classes7.dex */
    public static final class a<T> implements Observer<com.baidu.navisdk.pronavi.hd.normal.data.c> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(com.baidu.navisdk.pronavi.hd.normal.data.c it) {
            RGNormalHDComponent rGNormalHDComponent = RGNormalHDComponent.this;
            IIX0o.oO(it, "it");
            rGNormalHDComponent.a(it);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;

        public b(boolean z, boolean z2) {
            this.b = z;
            this.c = z2;
        }

        private final void a() {
            ViewGroup viewGroup = RGNormalHDComponent.this.s;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "getHideMapViewAnimation hideMapViewIfNeed mParentView gone");
            }
            if (this.c) {
                RGNormalHDComponent.this.E();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationCancel(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "getHideMapViewAnimation onAnimationCancel: ");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationEnd(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "getHideMapViewAnimation onAnimationEnd: ");
            }
            if (this.b) {
                a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationStart(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "getHideMapViewAnimation onAnimationStart: ");
            }
            if (!this.b) {
                a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            IIX0o.oO(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            if (animatedValue != null) {
                RGNormalHDComponent.this.a(((Integer) animatedValue).intValue(), -1);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ Pair b;

        public d(Pair pair) {
            this.b = pair;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            IIX0o.oO(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            if (animatedValue != null) {
                RGNormalHDComponent.this.a(((Integer) animatedValue).intValue(), (Pair<Integer, Integer>) this.b);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends AnimatorListenerAdapter {
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ long d;
        final /* synthetic */ int e;

        public e(boolean z, boolean z2, long j, int i) {
            this.b = z;
            this.c = z2;
            this.d = j;
            this.e = i;
        }

        private final void a() {
            if (!this.b) {
                ViewGroup viewGroup = RGNormalHDComponent.this.s;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(((Func) RGNormalHDComponent.this).g, "getShowMapViewAnimation showMapViewIfNeed mParentView visibility");
                }
            }
            RGNormalHDComponent.this.b(this.e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationCancel(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "getShowMapViewAnimation onAnimationCancel: ");
            }
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationEnd(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "getShowMapViewAnimation onAnimationEnd: ");
            }
            a();
            RGNormalHDComponent.this.p.a(this.b, 0, this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationStart(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "getShowMapViewAnimation onAnimationStart: ");
            }
            if (this.b) {
                ViewGroup viewGroup = RGNormalHDComponent.this.s;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                if (gVar.d()) {
                    gVar.e(((Func) RGNormalHDComponent.this).g, "getShowMapViewAnimation onAnimationStart mParentView visibility");
                }
                RGNormalHDComponent.this.p.a(true, 1, this.c);
            }
            RGNormalHDComponent.this.p.setShowRect(2, this.c);
            RGNormalHDComponent.this.p.a(2, (int) this.d, this.c);
        }
    }

    /* loaded from: classes7.dex */
    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int b;

        public f(int i) {
            this.b = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            IIX0o.oO(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                if (this.b == 2) {
                    RGNormalHDComponent.this.a(intValue, -1);
                    return;
                } else {
                    RGNormalHDComponent.this.a(-1, intValue);
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationCancel(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "handleEnterNormalHDUISwitch onAnimationCancel");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationEnd(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "handleEnterNormalHDUISwitch onAnimationEnd ");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationStart(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "handleEnterNormalHDUISwitch onAnimationStart");
            }
            RGNormalHDComponent.this.v = false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationCancel(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "handleExitNormalHDUISwitch onAnimationCancel");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationEnd(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "handleExitNormalHDUISwitch onAnimationEnd ");
            }
            RGNormalHDComponent.this.v = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@OOXIXo Animator animation) {
            IIX0o.x0xO0oo(animation, "animation");
            super.onAnimationStart(animation);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "handleExitNormalHDUISwitch onAnimationStart");
            }
            RGNormalHDComponent.this.v = true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!com.baidu.navisdk.ui.util.g.a()) {
                RGNormalHDComponent.this.G();
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "mCloseBtn: isFastDoubleClick");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGNormalHDComponent.this).g, "mParentView: click");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class k implements i0.f {
        public k() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            RGNormalHDComponent.this.p.a(0);
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1341", "2", "0", "4");
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
            bNCommSettingManager.setNormalHdNaviEnable(false);
            RGNormalHDComponent.this.p.a(0);
            BNRouteGuider.getInstance().setCommonRoadHDLaneMapMode(false);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hd_close"));
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1341", "2", "3");
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            RGNormalHDComponent.this.p.a(0);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hd_close"));
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1341", "2", "0");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNormalHDComponent(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        com.baidu.navisdk.pronavi.hd.normal.i.a c2 = com.baidu.navisdk.ui.routeguide.utils.b.c(true);
        IIX0o.oO(c2, "BNProNaviInnerUtil.getNormalHdFunc(true)");
        this.p = c2;
        c2.f().observe(this, new a());
    }

    private final void C() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "cancelSwitchAnimator: ");
        }
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            valueAnimator.removeAllListeners();
            valueAnimator.removeAllUpdateListeners();
            if (gVar.d()) {
                gVar.e(this.g, "cancelSwitchAnimator mMapAnimator: ");
            }
        }
        this.u = null;
        AnimatorSet animatorSet = this.t;
        if (animatorSet != null) {
            if (animatorSet.isRunning()) {
                animatorSet.cancel();
                if (gVar.d()) {
                    gVar.e(this.g, "cancelSwitchAnimator mAnimatorSet: ");
                }
            }
            animatorSet.removeAllListeners();
            Iterator<Animator> it = animatorSet.getChildAnimations().iterator();
            while (it.hasNext()) {
                Animator next = it.next();
                if (next != null) {
                    next.removeAllListeners();
                    if (next instanceof ValueAnimator) {
                        ((ValueAnimator) next).removeAllUpdateListeners();
                    }
                }
            }
        }
        this.t = null;
    }

    private final void D() {
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList = this.w;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList2 = this.x;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "destroyNormalHDMap: ");
        }
        x.b().b(true, 1);
        View view = this.r;
        if (view != null) {
            ViewGroup viewGroup = this.s;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            this.r = null;
        }
        this.p.onDestroy();
    }

    private final boolean F() {
        return com.baidu.navisdk.module.cloudconfig.f.c().U.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        if (!J()) {
            this.p.a(0);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hd_close"));
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1341", "1", "2");
    }

    private final void H() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onDisposeCutoutSafetyPadding: ");
        }
    }

    private final void I() {
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).c(RGFSMTable.FsmState.BrowseMap)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.g, "onEnterNormalNaviSetXYOffset: BrowseMap");
                return;
            }
            return;
        }
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).d(RGFSMTable.FsmState.Fullview)) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(this.g, "onEnterNormalNaviSetXYOffset: Fullview");
                return;
            }
            return;
        }
        BNMapController bNMapController = BNMapController.getInstance();
        IIX0o.oO(bNMapController, "BNMapController.getInstance()");
        com.baidu.nplatform.comapi.basestruct.b mapStatus = bNMapController.getMapStatus();
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        if (bNCommSettingManager.getMapMode() == 1) {
            RGStateCar3D.setXYOffset(mapStatus);
        } else {
            RGStateNorth2D.setXYOffset(mapStatus, false);
        }
        BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationArc, 1000, true);
    }

    private final boolean J() {
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        if (!bNCommSettingManager.isNormalHdNaviEnableVerifyPanel()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.g, "showCloseSettingConfirmPanelIfNeed: showed");
            }
            return false;
        }
        if (s.T().l(138)) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(this.g, "showCloseSettingConfirmPanelIfNeed is showing");
            }
            return false;
        }
        if (!s.T().b(138)) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e(this.g, "showCloseSettingConfirmPanelIfNeed false");
            }
            return false;
        }
        BNCommSettingManager bNCommSettingManager2 = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager2, "BNCommSettingManager.getInstance()");
        bNCommSettingManager2.setNormalHdNaviEnableVerifyPanel(false);
        s.T().p();
        return x.b().k(138).D(100).v(15000).y(false).d(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_hd_close_setting_icon)).a("是否永久关闭城市道路车道级导航？").b("设置-辅助功能中可再次开启或关闭").g("本次关闭").f("永久关闭").z(2).a(new k()).y();
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent
    public void A() {
        super.A();
        this.p.onStartYawing();
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    @oOoXoXO
    public View[] B() {
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        a(true, 0L);
        D();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
        super.i();
        this.p.onPause();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
        super.j();
        this.p.onResume();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGNormalHDComponent";
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    public boolean p() {
        return false;
    }

    @Override // com.baidu.navisdk.uiframe.UiModule
    @OOXIXo
    public String[] t() {
        return new String[]{PrerollVideoResponse.NORMAL};
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule
    public void x() {
        super.x();
        H();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void c(int r8) {
        /*
            r7 = this;
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r1 = r0.d()
            java.lang.String r2 = "initView: "
            if (r1 == 0) goto L28
            java.lang.String r1 = r7.g
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r8)
            java.lang.String r4 = ", "
            r3.append(r4)
            android.view.ViewGroup r4 = r7.s
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.e(r1, r3)
        L28:
            android.view.ViewGroup r1 = r7.s
            if (r1 != 0) goto Lbc
            C extends com.baidu.navisdk.context.business.a r1 = r7.i
            java.lang.String r3 = "mContext"
            kotlin.jvm.internal.IIX0o.oO(r1, r3)
            com.baidu.navisdk.pronavi.ui.base.b r1 = (com.baidu.navisdk.pronavi.ui.base.b) r1
            android.view.ViewGroup r1 = r1.G()
            if (r1 != 0) goto L49
            boolean r8 = r0.c()
            if (r8 == 0) goto L48
            java.lang.String r8 = r7.g
            java.lang.String r1 = "initView: rootView is null"
            r0.c(r8, r1)
        L48:
            return
        L49:
            int r0 = com.baidu.navisdk.embed.R.id.bnav_rg_normal_hd_map_stub
            android.view.View r0 = r1.findViewById(r0)
            boolean r3 = r0 instanceof android.view.ViewStub
            r4 = 0
            if (r3 != 0) goto L55
            r0 = r4
        L55:
            android.view.ViewStub r0 = (android.view.ViewStub) r0
            if (r0 == 0) goto L62
            android.view.View r0 = r0.inflate()     // Catch: java.lang.Exception -> L60
            if (r0 == 0) goto L62
            goto L6d
        L60:
            r0 = move-exception
            goto L75
        L62:
            int r0 = com.baidu.navisdk.embed.R.id.bnav_rg_normal_hd_map_anim_lay     // Catch: java.lang.Exception -> L60
            android.view.View r0 = r1.findViewById(r0)     // Catch: java.lang.Exception -> L60
            java.lang.String r3 = "rootView.findViewById(R.…g_normal_hd_map_anim_lay)"
            kotlin.jvm.internal.IIX0o.oO(r0, r3)     // Catch: java.lang.Exception -> L60
        L6d:
            boolean r3 = r0 instanceof android.view.ViewGroup     // Catch: java.lang.Exception -> L60
            if (r3 != 0) goto L72
            r0 = r4
        L72:
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch: java.lang.Exception -> L60
            goto L99
        L75:
            com.baidu.navisdk.util.common.g r3 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r5 = r3.c()
            if (r5 == 0) goto L91
            java.lang.String r5 = r7.g
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r3.c(r5, r0)
        L91:
            int r0 = com.baidu.navisdk.embed.R.id.bnav_rg_normal_hd_map_anim_lay
            android.view.View r0 = r1.findViewById(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        L99:
            r7.s = r0
            if (r0 == 0) goto La6
            int r1 = com.baidu.navisdk.embed.R.id.bn_normal_hd_close_bt
            android.view.View r0 = r0.findViewById(r1)
            r4 = r0
            android.widget.ImageView r4 = (android.widget.ImageView) r4
        La6:
            r7.q = r4
            if (r4 == 0) goto Lb2
            com.baidu.navisdk.pronavi.hd.normal.ui.RGNormalHDComponent$i r0 = new com.baidu.navisdk.pronavi.hd.normal.ui.RGNormalHDComponent$i
            r0.<init>()
            r4.setOnClickListener(r0)
        Lb2:
            boolean r0 = com.baidu.navisdk.ui.util.b.c()
            r7.d(r0)
            r7.H()
        Lbc:
            android.view.ViewGroup r0 = r7.s
            if (r0 == 0) goto Lc5
            r1 = 8
            r0.setVisibility(r1)
        Lc5:
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r1 = r0.d()
            if (r1 == 0) goto Ld4
            java.lang.String r1 = r7.g
            java.lang.String r2 = "initView: mParentView gone"
            r0.e(r1, r2)
        Ld4:
            android.view.ViewGroup r0 = r7.s
            if (r0 == 0) goto Le0
            com.baidu.navisdk.pronavi.hd.normal.ui.RGNormalHDComponent$j r1 = new com.baidu.navisdk.pronavi.hd.normal.ui.RGNormalHDComponent$j
            r1.<init>()
            r0.setOnClickListener(r1)
        Le0:
            r7.b(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.pronavi.hd.normal.ui.RGNormalHDComponent.c(int):void");
    }

    private final void d(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onEnterMultiSetXYOffset: " + i2);
        }
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).c(RGFSMTable.FsmState.BrowseMap)) {
            if (gVar.d()) {
                gVar.e(this.g, "onEnterMultiSetXYOffset: BrowseMap");
                return;
            }
            return;
        }
        if (((com.baidu.navisdk.pronavi.ui.base.b) this.i).d(RGFSMTable.FsmState.Fullview)) {
            if (gVar.d()) {
                gVar.e(this.g, "onEnterMultiSetXYOffset: Fullview");
                return;
            }
            return;
        }
        BNMapController bNMapController = BNMapController.getInstance();
        IIX0o.oO(bNMapController, "BNMapController.getInstance()");
        com.baidu.nplatform.comapi.basestruct.b mapStatus = bNMapController.getMapStatus();
        if (mapStatus != null) {
            com.baidu.navisdk.pronavi.carlogooffset.i.b f2 = com.baidu.navisdk.ui.routeguide.utils.b.f();
            Pair<Long, Long> pair = null;
            com.baidu.navisdk.pronavi.carlogooffset.i.a a2 = f2 != null ? f2.a(2) : null;
            Pair<Integer, Integer> f3 = this.p.f(i2);
            int intValue = (i2 == 2 ? f3.getFirst() : f3.getSecond()).intValue();
            if (a2 != null) {
                BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
                IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
                pair = a2.a(i2, bNCommSettingManager.getMapMode(), Integer.valueOf(intValue));
            }
            if (pair != null) {
                mapStatus.i = pair.getFirst().longValue();
                mapStatus.j = pair.getSecond().longValue();
                BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationArc, 1000, true);
            }
        }
    }

    private final void e(int i2) {
        if (i2 != 2) {
            return;
        }
        x.b().L4();
        BNMapController.getInstance().setSimpleModeGuide(!com.baidu.navisdk.ui.routeguide.utils.b.x());
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    @oOoXoXO
    public View b(int i2, @oOoXoXO View view) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onContentViewCreate: ");
        }
        return super.b(i2, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "changeParentViewLayout:" + i2 + TokenParser.SP);
        }
        ViewGroup viewGroup = this.s;
        if (viewGroup != null) {
            Pair<Integer, Integer> d2 = this.p.d(i2);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                if (layoutParams2.width != d2.getFirst().intValue() || layoutParams2.height != d2.getSecond().intValue()) {
                    layoutParams2.width = d2.getFirst().intValue();
                    layoutParams2.height = d2.getSecond().intValue();
                    if (i2 == 2) {
                        layoutParams2.gravity = 8388629;
                        layoutParams2.bottomMargin = 0;
                        layoutParams2.rightMargin = this.p.h();
                    } else {
                        layoutParams2.gravity = 8388691;
                        layoutParams2.rightMargin = 0;
                        layoutParams2.bottomMargin = this.p.d();
                    }
                    viewGroup.requestLayout();
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
        View view = this.r;
        if (view != null) {
            Pair<Integer, Integer> g2 = this.p.g(i2);
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            if (layoutParams3 != null) {
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                if (layoutParams4.width == g2.getFirst().intValue() && layoutParams4.height == g2.getSecond().intValue()) {
                    return;
                }
                layoutParams4.width = g2.getFirst().intValue();
                layoutParams4.height = g2.getSecond().intValue();
                view.requestLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(@oOoXoXO Configuration configuration) {
        com.baidu.navisdk.pronavi.hd.hdnavi.animator.a aVar;
        super.a(configuration);
        C();
        int i2 = configuration != null ? configuration.orientation : 1;
        b(i2);
        this.p.e(i2);
        if (i2 == 2 && (aVar = this.y) != null) {
            com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
            IIX0o.oO(b2, "RGViewController.getInstance()");
            aVar.a(b2.s0(), i2);
        }
        H();
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public com.baidu.navisdk.apicenter.h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "execute: " + api);
        }
        if (api.d() != 20001) {
            return super.a(api);
        }
        b(api);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.baidu.navisdk.pronavi.hd.normal.data.c cVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "handleUIStateSwitch: " + cVar + "，isExitAnimator = " + this.v);
        }
        cVar.a();
        if (cVar.b() == 0) {
            if (this.v) {
                return;
            }
            C();
            a(cVar.c(), cVar.a());
            return;
        }
        if (!this.p.c()) {
            if (gVar.d()) {
                gVar.e(this.g, "handleUIStateSwitch: not HasNormalHdData");
                return;
            }
            return;
        }
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(false);
        if (b2 != null) {
            b2.d();
        }
        C();
        C mContext = this.i;
        IIX0o.oO(mContext, "mContext");
        a(((com.baidu.navisdk.pronavi.ui.base.b) mContext).o(), cVar.a());
    }

    private final void d(boolean z) {
        ImageView imageView = this.q;
        if (imageView != null) {
            com.baidu.navisdk.ui.util.b.a((View) imageView, R.drawable.nsdk_rg_normal_hd_close_btn_bg);
            int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
            imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        }
    }

    private final void c(boolean z) {
        if (this.y == null) {
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            Context c2 = V.c();
            com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
            IIX0o.oO(b2, "RGViewController.getInstance()");
            this.y = new com.baidu.navisdk.pronavi.hd.hdnavi.animator.a(c2, b2.s0());
        }
        if (z) {
            return;
        }
        a(this.y);
    }

    private final void b(com.baidu.navisdk.apicenter.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "handleEnlargeMapVisibleChange: " + aVar);
        }
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule
    public void c(@oOoXoXO String str, @oOoXoXO String str2, @oOoXoXO Bundle bundle) {
        super.c(str, str2, bundle);
        this.p.a(str, str2, bundle);
    }

    private final void b(boolean z) {
        com.baidu.navisdk.framework.interfaces.pronavi.hd.b[] e2 = x.b().e(z);
        if (e2 != null && e2.length != 0) {
            a((com.baidu.navisdk.framework.interfaces.pronavi.hd.b[]) Arrays.copyOf(e2, e2.length));
        }
        com.baidu.navisdk.framework.interfaces.pronavi.hd.c[] uiAnimators = x.b().f(z);
        IIX0o.oO(uiAnimators, "uiAnimators");
        a((com.baidu.navisdk.framework.interfaces.pronavi.hd.c[]) Arrays.copyOf(uiAnimators, uiAnimators.length));
        c(z);
    }

    private final void a(int i2, long j2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "showNormalHdView: " + this.s);
        }
        c(i2);
        com.baidu.navisdk.pronavi.hd.normal.i.a aVar = this.p;
        C mContext = this.i;
        IIX0o.oO(mContext, "mContext");
        Activity e2 = ((com.baidu.navisdk.pronavi.ui.base.b) mContext).e();
        IIX0o.oO(e2, "mContext.activity");
        View a2 = aVar.a(e2, i2);
        this.r = a2;
        if (a2 != null) {
            if (a2.getParent() instanceof ViewGroup) {
                ViewParent parent = a2.getParent();
                if (parent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent).removeView(a2);
            }
            Pair<Integer, Integer> g2 = this.p.g(i2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2.getFirst().intValue(), g2.getSecond().intValue());
            ViewGroup viewGroup = this.s;
            if (viewGroup != null) {
                viewGroup.addView(a2, 0, layoutParams);
            }
            ViewGroup viewGroup2 = this.s;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            if (gVar.d()) {
                gVar.e(this.g, "showNormalHdView: mParentView visibility");
            }
            this.p.c(2);
            a(2, j2, i2, false);
        }
    }

    private final void a(boolean z, long j2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            String str = this.g;
            StringBuilder sb = new StringBuilder();
            sb.append("hideNormalHdView: ");
            sb.append(z);
            sb.append(", mParentView visible:");
            ViewGroup viewGroup = this.s;
            sb.append(viewGroup != null ? Integer.valueOf(viewGroup.getVisibility()) : null);
            sb.append(TokenParser.SP);
            gVar.e(str, sb.toString());
        }
        this.p.c(0);
        ViewGroup viewGroup2 = this.s;
        if (viewGroup2 != null && viewGroup2.getVisibility() == 0) {
            a(0, j2, this.o, z);
        } else if (z) {
            E();
        }
    }

    private final void a(int i2, long j2, int i3, boolean z) {
        int intValue;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "switchUpperUI: " + i2 + ", " + j2 + ", " + i3);
        }
        D();
        b(i3 != 2);
        boolean z2 = i3 != 2;
        Pair<Integer, Integer> f2 = this.p.f(i3);
        if (gVar.d()) {
            gVar.e(this.g, "switchUpperUI mapSize: " + f2 + ", " + i3);
        }
        if (z2) {
            intValue = f2.getSecond().intValue();
        } else {
            intValue = f2.getFirst().intValue();
        }
        e(i3);
        q.c().b();
        this.p.a(i2, z2);
        x.b().r3();
        if (i2 == 2) {
            a(j2, i3, intValue);
        } else {
            a(j2, i3, intValue, z);
        }
    }

    private final void a(long j2, int i2, int i3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "handleEnterNormalHDUISwitch:" + j2 + ", " + i2 + ',' + i3 + TokenParser.SP);
        }
        boolean z = i2 != 2;
        x.b().b(false, 1);
        d(i2);
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList = this.x;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList2 = this.x;
            IIX0o.ooOOo0oXI(arrayList2);
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.b next = it.next();
                if (next != null) {
                    next.e(0, i3, z, this.p.a());
                }
            }
        }
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList3 = this.w;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            this.t = new AnimatorSet();
            ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList4 = this.w;
            IIX0o.ooOOo0oXI(arrayList4);
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.c next2 = it2.next();
                List<Animator> a2 = next2 != null ? next2.a(0, i3, z, this.p.a()) : null;
                if (a2 != null && !a2.isEmpty()) {
                    Set XO2 = oX.XO(null);
                    if (a2 != null) {
                        XoX.oIX0oI(a2).removeAll(XO2);
                        AnimatorSet animatorSet = this.t;
                        IIX0o.ooOOo0oXI(animatorSet);
                        animatorSet.playTogether(a2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    }
                }
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e(this.g, "handleEnterNormalHDUISwitch: " + a2);
                }
            }
        }
        AnimatorSet animatorSet2 = this.t;
        IIX0o.ooOOo0oXI(animatorSet2);
        animatorSet2.playTogether(a(F(), j2, i2, this.p.d(i2)));
        AnimatorSet animatorSet3 = this.t;
        IIX0o.ooOOo0oXI(animatorSet3);
        animatorSet3.setDuration(j2);
        AnimatorSet animatorSet4 = this.t;
        IIX0o.ooOOo0oXI(animatorSet4);
        animatorSet4.addListener(new g());
        AnimatorSet animatorSet5 = this.t;
        IIX0o.ooOOo0oXI(animatorSet5);
        animatorSet5.start();
    }

    private final void a(long j2, int i2, int i3, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "handleExitNormalHDUISwitch:" + j2 + ", " + i2 + ", " + i3);
        }
        boolean z2 = i2 != 2;
        x.b().b(true, 1);
        I();
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList = this.x;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList2 = this.x;
            IIX0o.ooOOo0oXI(arrayList2);
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.b next = it.next();
                if (next != null) {
                    next.f(2, i3, z2, this.p.a());
                }
            }
        }
        this.t = new AnimatorSet();
        ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList3 = this.w;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList4 = this.w;
            IIX0o.ooOOo0oXI(arrayList4);
            Iterator<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                com.baidu.navisdk.framework.interfaces.pronavi.hd.c next2 = it2.next();
                List<Animator> c2 = next2 != null ? next2.c(2, i3, z2, this.p.a()) : null;
                if (c2 != null && !c2.isEmpty()) {
                    Set XO2 = oX.XO(null);
                    if (c2 != null) {
                        XoX.oIX0oI(c2).removeAll(XO2);
                        AnimatorSet animatorSet = this.t;
                        IIX0o.ooOOo0oXI(animatorSet);
                        animatorSet.playTogether(c2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    }
                }
            }
        }
        AnimatorSet animatorSet2 = this.t;
        IIX0o.ooOOo0oXI(animatorSet2);
        animatorSet2.playTogether(a(F(), j2, i2, this.p.d(i2), z));
        AnimatorSet animatorSet3 = this.t;
        IIX0o.ooOOo0oXI(animatorSet3);
        animatorSet3.setDuration(j2);
        AnimatorSet animatorSet4 = this.t;
        IIX0o.ooOOo0oXI(animatorSet4);
        animatorSet4.addListener(new h());
        AnimatorSet animatorSet5 = this.t;
        IIX0o.ooOOo0oXI(animatorSet5);
        animatorSet5.start();
    }

    private final Animator a(boolean z, long j2, int i2, Pair<Integer, Integer> pair) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "getShowMapViewAnimation: " + z + ", " + i2 + ", " + pair + ", " + j2);
        }
        boolean z2 = i2 != 2;
        this.u = ValueAnimator.ofInt(0, (!z2 ? pair.getFirst() : pair.getSecond()).intValue());
        if (z) {
            f fVar = new f(i2);
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null) {
                valueAnimator.addUpdateListener(fVar);
            }
        }
        ValueAnimator valueAnimator2 = this.u;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(j2);
        }
        ValueAnimator valueAnimator3 = this.u;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new e(z, z2, j2, i2));
        }
        return this.u;
    }

    private final Animator a(boolean z, long j2, int i2, Pair<Integer, Integer> pair, boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "getHideMapViewAnimation: " + j2 + ", " + pair + ", " + i2 + ", " + z);
        }
        if (i2 == 2) {
            this.u = ValueAnimator.ofInt(pair.getFirst().intValue(), 0);
            if (z) {
                c cVar = new c();
                ValueAnimator valueAnimator = this.u;
                if (valueAnimator != null) {
                    valueAnimator.addUpdateListener(cVar);
                }
            }
        } else {
            this.u = ValueAnimator.ofInt(100, 0);
            if (z) {
                d dVar = new d(pair);
                ValueAnimator valueAnimator2 = this.u;
                if (valueAnimator2 != null) {
                    valueAnimator2.addUpdateListener(dVar);
                }
            }
        }
        ValueAnimator valueAnimator3 = this.u;
        if (valueAnimator3 != null) {
            valueAnimator3.setDuration(j2);
        }
        ValueAnimator valueAnimator4 = this.u;
        if (valueAnimator4 != null) {
            valueAnimator4.addListener(new b(z, z2));
        }
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i2, int i3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "changeNormalHDMapViewHeight:" + i2 + ':' + i3 + ',');
        }
        ViewGroup viewGroup = this.s;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = i2;
                layoutParams2.height = i3;
                viewGroup.requestLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i2, Pair<Integer, Integer> pair) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "hideNormalHDMapForPortrait: " + i2);
        }
        ViewGroup viewGroup = this.s;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = (com.baidu.navisdk.pronavi.util.a.h.e() * i2) / 100;
                layoutParams2.height = (pair.getSecond().intValue() * i2) / 100;
                viewGroup.requestLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    private final void a(com.baidu.navisdk.framework.interfaces.pronavi.hd.c... cVarArr) {
        if (cVarArr == null || cVarArr.length == 0) {
            return;
        }
        if (this.w == null) {
            this.w = new ArrayList<>(12);
        }
        for (com.baidu.navisdk.framework.interfaces.pronavi.hd.c cVar : cVarArr) {
            if (cVar != null) {
                ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList = this.w;
                IIX0o.ooOOo0oXI(arrayList);
                if (!arrayList.contains(cVar)) {
                    ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.c> arrayList2 = this.w;
                    IIX0o.ooOOo0oXI(arrayList2);
                    arrayList2.add(cVar);
                }
            }
        }
    }

    private final void a(com.baidu.navisdk.framework.interfaces.pronavi.hd.b... bVarArr) {
        if (bVarArr == null || bVarArr.length == 0) {
            return;
        }
        if (this.x == null) {
            this.x = new ArrayList<>(8);
        }
        for (com.baidu.navisdk.framework.interfaces.pronavi.hd.b bVar : bVarArr) {
            if (bVar != null) {
                ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList = this.x;
                IIX0o.ooOOo0oXI(arrayList);
                if (!arrayList.contains(bVar)) {
                    ArrayList<com.baidu.navisdk.framework.interfaces.pronavi.hd.b> arrayList2 = this.x;
                    IIX0o.ooOOo0oXI(arrayList2);
                    arrayList2.add(bVar);
                }
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule
    public void a(boolean z) {
        super.a(z);
        com.baidu.navisdk.pronavi.hd.normal.i.a aVar = this.p;
        if (aVar != null) {
            aVar.a(!z);
        }
        d(z);
    }
}

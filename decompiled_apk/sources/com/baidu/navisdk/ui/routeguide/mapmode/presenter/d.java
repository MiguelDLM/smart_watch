package com.baidu.navisdk.ui.routeguide.mapmode.presenter;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.module.pronavi.model.g;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.ui.routeguide.subview.widget.CircleProgressImageView;
import com.baidu.navisdk.ui.util.h;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class d implements a {
    private Reference<com.baidu.navisdk.ui.routeguide.mapmode.iview.b> c;
    private k b = com.baidu.navisdk.framework.interfaces.c.p().k();
    private h d = new h();

    private int p() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_road_condition_bar_default_margin_top);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int t() {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.presenter.d.t():int");
    }

    public void a(com.baidu.navisdk.ui.routeguide.mapmode.iview.b bVar) {
        this.c = new WeakReference(bVar);
    }

    public void b() {
    }

    public int c() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuidePresenter", "getRoadConditionBarMarginTop->");
        }
        if (x.b().s2()) {
            return t();
        }
        return p();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void d() {
        if (this.c.get() != null) {
            this.c.get().d();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public boolean e() {
        if (this.c.get() != null) {
            this.c.get().e();
            return false;
        }
        return false;
    }

    public boolean f() {
        Rect W;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuidePresenter", "laneLineRoadConditionWhetherCollision: " + RGLaneInfoModel.getModel(false).mLineNumber);
        }
        if (RGLaneInfoModel.getModel(false).mLineNumber < 5) {
            return false;
        }
        Rect U = this.c.get() != null ? this.c.get().U() : null;
        if (U == null || U.left <= 0 || (W = x.b().W()) == null) {
            return false;
        }
        if (W.right + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp) >= U.left) {
            if (!gVar.d()) {
                return true;
            }
            gVar.e("RGMMAssistGuidePresenter", "laneLineRoadConditionWhetherCollision -> return true");
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void g() {
        if (this.c.get() != null) {
            this.c.get().g();
        }
    }

    public void h() {
        boolean z;
        h hVar = this.d;
        if (hVar != null && hVar.a()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMAssistGuidePresenter", "mFullViewModeBtn.onClick() -> fast click, return!!!");
                return;
            }
            return;
        }
        g gVar2 = g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGMMAssistGuidePresenter", "mFullViewModeBtn.onClick() -> getFullViewState = " + com.baidu.navisdk.ui.routeguide.model.g.h().a());
        }
        if (i.s().k()) {
            if (gVar2.d()) {
                gVar2.e("RGMMAssistGuidePresenter", "mFullViewModeBtn.onClick() -> isAnyEnlargeRoadMapShowing,return!");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.model.g.h().a()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.3.1", "1", null, null);
            if (this.c.get() != null) {
                this.c.get().Z();
                x.b().s(0);
                RouteGuideFSM.getInstance().setFullViewByUser(false);
                k kVar = this.b;
                if (kVar != null) {
                    kVar.i(false);
                }
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_fullview_exit"));
            }
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.3.1", "2", null, null);
            if (this.c.get() != null) {
                z = this.c.get().z();
            } else {
                z = false;
            }
            if (gVar2.d()) {
                gVar2.e("RGMMAssistGuidePresenter", "onFullViewBtnClicked: " + z);
            }
            if (z) {
                x.b().u(0);
                x.b().s(8);
                RouteGuideFSM.getInstance().setFullViewByUser(true);
                k kVar2 = this.b;
                if (kVar2 != null) {
                    kVar2.i(true);
                }
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_fullview"));
            }
        }
        this.c.get().s(com.baidu.navisdk.ui.routeguide.model.g.h().a());
    }

    public void i() {
        h hVar = this.d;
        if (hVar != null && hVar.a()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMAssistGuidePresenter", "mMapSwitchlayout.onClick() -> fast click, return!!!");
                return;
            }
            return;
        }
        g gVar2 = g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGMMAssistGuidePresenter", "mMapSwitchlayout onClick ==");
        }
        if (com.baidu.navisdk.ui.routeguide.model.g.h().a()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.3", "1", null, null);
            if (this.c.get() != null) {
                RouteGuideFSM.getInstance().setFullViewByUser(false);
                k kVar = this.b;
                if (kVar != null) {
                    kVar.e(false);
                }
                this.c.get().Z();
                return;
            }
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.3", "2", null, null);
        if (this.c.get() != null) {
            RouteGuideFSM.getInstance().setFullViewByUser(true);
            k kVar2 = this.b;
            if (kVar2 != null) {
                kVar2.e(true);
            }
            this.c.get().z();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public boolean j() {
        if (this.c.get() != null) {
            return this.c.get().j();
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void k() {
        if (this.c.get() != null) {
            this.c.get().k();
        }
    }

    public boolean l() {
        int i;
        if (x.b().G2()) {
            i = x.b().l0().X().left;
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMAssistGuidePresenter", "assistViewWhetherTheCollision -> isShowRouteWeatherView= true,, left= " + i);
            }
        } else if (x.b().m0() != null) {
            i = x.b().m0().c().left;
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGMMAssistGuidePresenter", "assistViewWhetherTheCollision -> getServiceAreaController != null,, left= " + i);
            }
        } else {
            i = 0;
        }
        Rect W = x.b().W();
        if (W != null && i > 0) {
            if (W.right + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp) >= i) {
                g gVar3 = g.PRO_NAV;
                if (gVar3.d()) {
                    gVar3.e("RGMMAssistGuidePresenter", "assistViewWhetherTheCollision -> return true");
                    return true;
                }
                return true;
            }
        }
        g gVar4 = g.PRO_NAV;
        if (gVar4.d()) {
            gVar4.e("RGMMAssistGuidePresenter", "assistViewWhetherTheCollision -> return false");
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void m() {
        if (this.c.get() != null) {
            this.c.get().m();
        }
    }

    public void n() {
        g.a aVar;
        int i;
        for (int i2 = 0; i2 < 3; i2++) {
            g.a a2 = com.baidu.navisdk.module.pronavi.model.g.o().a(i2);
            if (a2 != null) {
                aVar = a2.a();
            } else {
                aVar = null;
            }
            if (aVar != null && (2 == (i = aVar.f7468a) || 1 == i)) {
                aVar.f7468a = 1;
                if (this.c.get() != null) {
                    this.c.get().a(i2, aVar);
                }
            }
        }
        if (this.c.get() != null) {
            this.c.get().F();
            this.c.get().q();
            if (com.baidu.navisdk.module.pronavi.model.g.o().g()) {
                this.c.get().a(0, true);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void o() {
        if (this.c.get() != null) {
            this.c.get().o();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void q() {
        if (this.c.get() != null) {
            this.c.get().q();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void r() {
        if (this.c.get() != null) {
            this.c.get().r();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public View s() {
        if (this.c.get() != null) {
            return this.c.get().s();
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void u() {
        if (this.c.get() != null) {
            this.c.get().u();
        }
    }

    public void a(Context context) {
        if (t.s().j()) {
            t.s().f();
        } else {
            t.s().a(context);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void b(boolean z) {
        if (this.c.get() != null) {
            this.c.get().b(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void d(int i) {
        if (this.c.get() != null) {
            this.c.get().d(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void g(boolean z) {
        if (this.c.get() != null) {
            this.c.get().g(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void b(Bundle bundle) {
        if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getTopState()) || RGFSMTable.FsmState.Colladamap.equals(RouteGuideFSM.getInstance().getTopState())) {
            return;
        }
        int i = (bundle == null || !bundle.containsKey("key_assist_index")) ? -1 : bundle.getInt("key_assist_index");
        g.a a2 = com.baidu.navisdk.module.pronavi.model.g.o().a(i);
        if (this.c.get() != null) {
            this.c.get().a(i, a2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
    
        if (r3 != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008c, code lost:
    
        r12 = false;
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008a, code lost:
    
        r0 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0088, code lost:
    
        if (r3 != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(android.widget.RelativeLayout r11, android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.presenter.d.a(android.widget.RelativeLayout, android.content.Context):int");
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void c(boolean z) {
        if (this.c.get() != null) {
            this.c.get().c(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void b(int i) {
        if (this.c.get() != null) {
            this.c.get().b(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void b(int i, int i2) {
        com.baidu.navisdk.module.pronavi.model.g.o().b(i, i2);
        if (this.c.get() != null) {
            this.c.get().b(i, i2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void f(boolean z) {
        if (this.c.get() != null) {
            this.c.get().f(z);
        }
    }

    private View a(RelativeLayout relativeLayout) {
        if (relativeLayout == null) {
            return null;
        }
        if (relativeLayout.getChildCount() == 1) {
            return relativeLayout;
        }
        for (int i = 0; i < relativeLayout.getChildCount(); i++) {
            View childAt = relativeLayout.getChildAt(i);
            if (childAt.getVisibility() == 0 && childAt.getMeasuredWidth() > 0) {
                return childAt;
            }
        }
        return null;
    }

    private boolean a(View view, boolean z) {
        boolean z2;
        if (z) {
            z2 = RGLaneInfoModel.getModel(false).mLineNumber > 6;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMAssistGuidePresenter Collision", "isLaneViewCollision -> " + z2 + ", isSimpeModeGuidePanelShowing = " + z);
            }
        } else {
            if (view == null) {
                return false;
            }
            Rect a2 = a(view);
            Rect W = x.b().W();
            if (W == null || W.isEmpty()) {
                return false;
            }
            z2 = a2.right + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp) > W.left;
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGMMAssistGuidePresenter Collision", "isLaneViewCollision -> " + z2 + ", topLeftRect = " + a2.toString() + ", laneLineRect = " + W.toString());
            }
        }
        return z2;
    }

    public Rect a(View view) {
        Rect rect = new Rect();
        if (view != null) {
            view.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void a() {
        if (this.c.get() != null) {
            this.c.get().s(com.baidu.navisdk.ui.routeguide.model.g.h().a());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void a(int i, boolean z) {
        if (this.c.get() != null) {
            this.c.get().a(i, z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void a(Bundle bundle) {
        if (this.c.get() != null) {
            this.c.get().a(bundle);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void a(int i) {
        if (this.c.get() != null) {
            this.c.get().a(i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void a(int i, int i2) {
        com.baidu.navisdk.module.pronavi.model.g.o().b(i, i2);
        if (this.c.get() != null) {
            this.c.get().a(i, i2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
    public void a(CircleProgressImageView[] circleProgressImageViewArr) {
        if (this.c.get() != null) {
            this.c.get().a(circleProgressImageViewArr);
        }
    }
}

package com.baidu.navisdk.ui.routeguide.mapmode.presenter;

import android.content.Context;
import android.view.MotionEvent;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.pronavi.model.i;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.util.g;
import com.baidu.navisdk.util.common.y;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class e implements b {
    private Reference<com.baidu.navisdk.ui.routeguide.mapmode.iview.c> b;
    private boolean c;
    private boolean d;

    public void a(com.baidu.navisdk.ui.routeguide.mapmode.iview.c cVar) {
        this.b = new WeakReference(cVar);
    }

    public boolean b(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || g.a() || com.baidu.navisdk.module.international.a.a(com.baidu.navisdk.framework.a.c().a())) {
            return false;
        }
        if (i.f().b) {
            i.f().b = false;
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().k(true);
            BNMapController.getInstance().recoveryHighLightRoute();
        }
        if (BNCommSettingManager.getInstance().isRoadCondOnOrOff()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.2", null, "", "1");
            if (this.b.get() != null) {
                this.b.get().o(false);
            }
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.2", "", null, "1");
            if (y.d(com.baidu.navisdk.framework.a.c().a())) {
                if (this.b.get() != null) {
                    this.b.get().o(true);
                }
            } else {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_its_real_offline));
            }
        }
        if (this.b.get() != null) {
            this.b.get().p(BNCommSettingManager.getInstance().isRoadCondOnOrOff());
        }
        x.b().a(0L);
        return false;
    }

    public boolean c(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || g.a()) {
            return false;
        }
        if (this.b.get() != null) {
            this.b.get().c(2);
        }
        if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
            x.b().a(0L);
        }
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_reprot_ugc"));
        return false;
    }

    public void d() {
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.y.4");
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().A(true);
    }

    public void e() {
        if (x.b().l2()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMControlPanelPresenter", "刷新路线 isInterceptRecalRouteForVdrGuide: ");
                return;
            }
            return;
        }
        if (this.b.get() != null) {
            this.b.get().t();
        }
        x.b().d();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
    public void f() {
        if (this.b.get() != null) {
            this.b.get().f();
        }
    }

    public void g() {
        int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
        boolean judgeRouteInfoAllReady = JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(selectRouteIdx);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMControlPanelPresenter", "onToCommuteBtnClick,curRouteIdx：" + selectRouteIdx + "，isReady:" + judgeRouteInfoAllReady);
        }
        if (!judgeRouteInfoAllReady) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "模式切换失败，请稍后再试");
            return;
        }
        int naviSwitchingCalcRoute = BNRouteGuider.getInstance().naviSwitchingCalcRoute(2);
        if (gVar.d()) {
            gVar.e("RGMMControlPanelPresenter", "onToCommuteBtnClick,witchActionRet:" + naviSwitchingCalcRoute);
        }
        if (naviSwitchingCalcRoute > 0) {
            com.baidu.navisdk.ui.routeguide.b.V().b(4, false);
        } else {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "模式切换失败，请稍后再试");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
    public void h(boolean z) {
        if (this.b.get() != null) {
            this.b.get().h(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
    public void n() {
        if (this.b.get() != null) {
            this.b.get().n();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
    public void p() {
        if (this.b.get() != null) {
            this.b.get().p();
        }
    }

    public void a() {
        this.b.clear();
        this.b = null;
    }

    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.b.get() != null) {
                this.b.get().l();
            }
            if (BNCommSettingManager.getInstance().getPrefRoutPlanMode() == 2) {
                BNCommSettingManager.getInstance().setRPNetMode(false);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.3", null, "1", null);
        }
        x.b().a(0L);
        return false;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
    public void e(boolean z) {
        if (this.b.get() != null) {
            this.b.get().e(z);
        }
    }

    public final boolean c() {
        return this.d;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
    public void a(boolean z, boolean z2) {
        if (this.b.get() != null) {
            this.b.get().a(z, z2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
    public void a(boolean z) {
        this.d = z;
    }

    public void a(Context context) {
        if (g.a()) {
            return;
        }
        if (context == null) {
            context = com.baidu.navisdk.ui.routeguide.b.V().c();
        }
        if (com.baidu.navisdk.module.international.a.a(context)) {
            return;
        }
        com.baidu.navisdk.module.a.h().a(com.baidu.navisdk.ui.routeguide.b.V().b(), 0, true);
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_route_share"));
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
    public void b(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.c;
    }
}

package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a {

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    private final boolean b(com.baidu.navisdk.pronavi.ui.base.b bVar) {
        com.baidu.navisdk.framework.interfaces.k kVar;
        if (bVar != null) {
            kVar = bVar.u();
        } else {
            kVar = null;
        }
        if (kVar != null && kVar.U()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.a
    public boolean a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo View view, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(view, "view");
        if (com.baidu.navisdk.ui.util.f.a("rgOnClickFull")) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGFullBtnLogic", "mFullViewModeBtn.onClick() -> fast click, return!!!");
            }
            return false;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("mFullViewModeBtn.onClick() -> getFullViewState = ");
            com.baidu.navisdk.ui.routeguide.model.g h = com.baidu.navisdk.ui.routeguide.model.g.h();
            IIX0o.oO(h, "RGControlPanelModel.getInstance()");
            sb.append(h.a());
            gVar2.e("RGFullBtnLogic", sb.toString());
        }
        if (uiContext.c(RGFSMTable.FsmState.BrowseMap)) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
        }
        a();
        if (gVar2.d()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onClicked: ");
            com.baidu.navisdk.ui.routeguide.model.g h2 = com.baidu.navisdk.ui.routeguide.model.g.h();
            IIX0o.oO(h2, "RGControlPanelModel.getInstance()");
            sb2.append(h2.a());
            gVar2.e("RGFullBtnLogic", sb2.toString());
        }
        com.baidu.navisdk.ui.routeguide.subview.a w = uiContext.w();
        com.baidu.navisdk.ui.routeguide.model.g h3 = com.baidu.navisdk.ui.routeguide.model.g.h();
        IIX0o.oO(h3, "RGControlPanelModel.getInstance()");
        if (h3.a()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.3.1", "1", null, null);
            if (w != null) {
                w.a(3, 0, 0, null);
                RouteGuideFSM.getInstance().setFullViewByUser(false);
                if (uiContext.u() != null) {
                    com.baidu.navisdk.framework.interfaces.k u = uiContext.u();
                    IIX0o.ooOOo0oXI(u);
                    u.i(false);
                }
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_fullview_exit"));
            }
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.3.1", "2", null, null);
            boolean b = w != null ? w.b(true) : false;
            if (gVar2.d()) {
                gVar2.e("RGFullBtnLogic", "onFullViewBtnClicked: " + b);
            }
            if (b) {
                x.b().u(0);
                RouteGuideFSM.getInstance().setFullViewByUser(true);
                if (uiContext.u() != null) {
                    com.baidu.navisdk.framework.interfaces.k u2 = uiContext.u();
                    IIX0o.ooOOo0oXI(u2);
                    u2.i(true);
                }
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_fullview"));
            }
        }
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a
    public boolean f() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a
    public void g() {
        String str;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateFullBtnTitle: ");
            com.baidu.navisdk.ui.routeguide.model.g h = com.baidu.navisdk.ui.routeguide.model.g.h();
            IIX0o.oO(h, "RGControlPanelModel.getInstance()");
            sb.append(h.a());
            gVar.e("RGFullBtnLogic", sb.toString());
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = b();
        if (b != null) {
            com.baidu.navisdk.ui.routeguide.model.g h2 = com.baidu.navisdk.ui.routeguide.model.g.h();
            IIX0o.oO(h2, "RGControlPanelModel.getInstance()");
            if (h2.a()) {
                str = "退出全览";
            } else {
                str = "全览";
            }
            b.b(str);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b
    public boolean a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        if (bVar != null && bVar.C()) {
            return true;
        }
        if (x.b().D0) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGFullBtnLogic", "visibility: mIsForceSwitchPanelShow");
            }
            return false;
        }
        if (b(bVar)) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGFullBtnLogic", "visibility: isHideRoadConditionMiniMap");
            }
            return false;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
        IIX0o.oO(b, "RGViewController.getInstance()");
        if (b.f2()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGFullBtnLogic", "visibility:isFuzzyMode ");
            }
            return true;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
        IIX0o.oO(b2, "RGViewController.getInstance()");
        if (b2.N2()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RGFullBtnLogic", "visibility: isVdrFuzzyMode");
            }
            return true;
        }
        int p = bVar != null ? bVar.p() : 0;
        com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar5.d()) {
            gVar5.e("RGFullBtnLogic", "visibility hdNaviState: " + p);
        }
        if (p == 2) {
            if (gVar5.d()) {
                gVar5.e("RGFullBtnLogic", "visibility: is isHDDoubleMapNavi");
            }
            return true;
        }
        if (p == 3) {
            return false;
        }
        if (bVar != null && bVar.D()) {
            if (gVar5.d()) {
                gVar5.e("RGFullBtnLogic", "visibility: isNormalHDMapShowed");
            }
            return true;
        }
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        int isShowMapSwitch = bNCommSettingManager.getIsShowMapSwitch();
        if (gVar5.d()) {
            gVar5.e("RGFullBtnLogic", "visibility:mapSwitch " + isShowMapSwitch);
        }
        return isShowMapSwitch != 0;
    }
}

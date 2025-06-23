package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class f extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a {

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
        if (kVar != null && kVar.X()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.a
    public boolean a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo View view, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(view, "view");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGOfflineToOnBtnLogic", "onClicked: ");
        }
        if (com.baidu.navisdk.ui.util.f.a("rgOnClickOffline")) {
            if (gVar.d()) {
                gVar.e("RGOfflineToOnBtnLogic", "RGOfflineToOnBtnLogic.onClick() -> fast click, return!!!");
            }
            return false;
        }
        a();
        com.baidu.navisdk.ui.routeguide.subview.a w = uiContext.w();
        if (w != null) {
            w.l();
        }
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        if (bNCommSettingManager.getPrefRoutPlanMode() == 2) {
            BNCommSettingManager.getInstance().setRPNetMode(false);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.3", null, "1", null);
        x.b().a(0L);
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a
    public boolean d() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a
    public void g() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = b();
        if (b != null) {
            b.a(!s.T().k(110));
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b
    public boolean a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        if (b(bVar)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGOfflineToOnBtnLogic", "visibility: isHideControlPanelBtn");
            }
            return false;
        }
        if (!BNSettingManager.isRefreshButtonVisible()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGOfflineToOnBtnLogic", "visibility: not isRefreshButtonVisible");
            }
            return false;
        }
        BNRouteGuider bNRouteGuider = BNRouteGuider.getInstance();
        IIX0o.oO(bNRouteGuider, "BNRouteGuider.getInstance()");
        if (bNRouteGuider.isCurDriveRouteOnline()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGOfflineToOnBtnLogic", "visibility: isCurDriveRouteOnline");
            }
            return false;
        }
        if (bVar != null && bVar.C()) {
            return false;
        }
        BNRoutePlaner bNRoutePlaner = BNRoutePlaner.getInstance();
        IIX0o.oO(bNRoutePlaner, "BNRoutePlaner.getInstance()");
        if (!bNRoutePlaner.B()) {
            return false;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.3.3", "1", null, null);
        com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar4.d()) {
            gVar4.e("RGOfflineToOnBtnLogic", "visibility: isOfflineRoutePlan");
        }
        return true;
    }
}

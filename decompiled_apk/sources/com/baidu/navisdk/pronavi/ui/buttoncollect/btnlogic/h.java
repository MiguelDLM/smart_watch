package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.control.x;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class h extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a {

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
        com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
        IIX0o.oO(b, "RGViewController.getInstance()");
        if (b.l2()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRefreshBtnLogic", "刷新路线 isInterceptRecalRouteForVdrGuide: ");
            }
            return false;
        }
        if (com.baidu.navisdk.ui.util.f.a("rgOnClickRefresh")) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGRefreshBtnLogic", "RGRefreshBtnLogic.onClick() -> fast click, return!!!");
            }
            return false;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.l");
        a();
        com.baidu.navisdk.ui.routeguide.subview.a w = uiContext.w();
        if (w != null) {
            w.t();
        }
        x.b().d();
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a
    public boolean d() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b
    public boolean a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        if (b(bVar)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRefreshBtnLogic", "visibility: isHideControlPanelBtn");
            }
            return false;
        }
        if (!BNSettingManager.isRefreshButtonVisible()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGRefreshBtnLogic", "visibility: not isRefreshButtonVisible");
            }
            return false;
        }
        if (!com.baidu.navisdk.function.b.FUNC_REFRESH.a()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGRefreshBtnLogic", "visibility: not isEnable");
            }
            return false;
        }
        BNRoutePlaner bNRoutePlaner = BNRoutePlaner.getInstance();
        IIX0o.oO(bNRoutePlaner, "BNRoutePlaner.getInstance()");
        if (bNRoutePlaner.B()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RGRefreshBtnLogic", "visibility: isCurDriveRouteOnline");
            }
            return false;
        }
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        if (V.F()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("RGRefreshBtnLogic", "visibility: isTrajectoryRestoreGuide");
            }
            return false;
        }
        if (bVar != null && bVar.C()) {
            return false;
        }
        com.baidu.navisdk.module.pronavi.model.i f = com.baidu.navisdk.module.pronavi.model.i.f();
        IIX0o.oO(f, "RGMultiRouteModel.getInstance()");
        if (f.c()) {
            JNIGuidanceControl jNIGuidanceControl = JNIGuidanceControl.getInstance();
            IIX0o.oO(jNIGuidanceControl, "JNIGuidanceControl.getInstance()");
            if (jNIGuidanceControl.getViaCnt() == 0) {
                com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar6.d()) {
                    gVar6.e("RGRefreshBtnLogic", "visibility: visible");
                }
                return true;
            }
        }
        com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar7.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("visibility gone:");
            BNRouteGuider bNRouteGuider = BNRouteGuider.getInstance();
            IIX0o.oO(bNRouteGuider, "BNRouteGuider.getInstance()");
            sb.append(bNRouteGuider.isCurDriveRouteOnline());
            sb.append(", ");
            com.baidu.navisdk.module.pronavi.model.i f2 = com.baidu.navisdk.module.pronavi.model.i.f();
            IIX0o.oO(f2, "RGMultiRouteModel.getInstance()");
            sb.append(f2.c());
            gVar7.e("RGRefreshBtnLogic", sb.toString());
        }
        return false;
    }
}

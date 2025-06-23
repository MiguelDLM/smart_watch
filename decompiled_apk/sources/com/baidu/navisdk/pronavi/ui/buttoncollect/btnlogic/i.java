package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import android.view.View;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class i extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a {
    private com.baidu.navisdk.module.park.a b;

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

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.a
    public boolean a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo View view, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(view, "view");
        if (com.baidu.navisdk.ui.util.g.a()) {
            return false;
        }
        a();
        RouteGuideFSM routeGuideFSM = RouteGuideFSM.getInstance();
        IIX0o.oO(routeGuideFSM, "RouteGuideFSM.getInstance()");
        if (IIX0o.Oxx0IOOO(RGFSMTable.FsmState.BrowseMap, routeGuideFSM.getTopState())) {
            x.b().a(0L);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1474", null, null, null);
        uiContext.j().e("RGSaveParkComponent").a(10001).a(this.b).a();
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b
    public boolean a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        a0 I = a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        boolean z = false;
        if (!I.D()) {
            a0 I2 = a0.I();
            IIX0o.oO(I2, "RGSimpleGuideModel.getInstance()");
            if (!I2.r()) {
                if (bVar != null && bVar.C()) {
                    return false;
                }
                if (bVar != null && bVar.z()) {
                    return false;
                }
                if (TextUtils.isEmpty(com.baidu.navisdk.framework.b.e())) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGSaveParkBtnLogic", "return by no login");
                    }
                    return false;
                }
                com.baidu.navisdk.module.park.a aVar = this.b;
                if (aVar != null && aVar.n()) {
                    z = true;
                }
                if (z) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1477", null, null, null);
                }
            }
        }
        return z;
    }

    public final void a(@oOoXoXO com.baidu.navisdk.module.park.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSaveParkBtnLogic", "updateSaveParkData: " + aVar);
        }
        this.b = aVar;
    }
}

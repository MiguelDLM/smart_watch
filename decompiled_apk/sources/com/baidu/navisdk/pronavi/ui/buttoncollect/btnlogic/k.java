package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class k extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a {
    private boolean b;
    private boolean c = true;
    private final boolean d;

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

    public k(boolean z) {
        this.d = z;
    }

    public final void a(int i) {
    }

    public final boolean b(boolean z) {
        if (z != this.c) {
            this.c = z;
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a
    public boolean d() {
        return this.d;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.a
    public boolean a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo View view, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(view, "view");
        if (com.baidu.navisdk.ui.util.g.a()) {
            return false;
        }
        a();
        com.baidu.navisdk.ui.routeguide.subview.a w = uiContext.w();
        if (w != null) {
            w.c(2);
        }
        RouteGuideFSM routeGuideFSM = RouteGuideFSM.getInstance();
        IIX0o.oO(routeGuideFSM, "RouteGuideFSM.getInstance()");
        if (IIX0o.Oxx0IOOO(RGFSMTable.FsmState.BrowseMap, routeGuideFSM.getTopState())) {
            x.b().a(0L);
        }
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_reprot_ugc"));
        uiContext.j().e("RGSaveParkComponent").a(10002).a();
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b
    public boolean a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        if (!BNSettingManager.isUgcButtonEnable()) {
            return false;
        }
        if (!com.baidu.navisdk.function.b.FUNC_UGC_REPORT_BTN.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGUgcReportBtnLogic", "showUgcBtnLayout force hide , return!");
            }
            return false;
        }
        a0 I = a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
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
                boolean z = this.d;
                if (!z && !this.c) {
                    return false;
                }
                if (z) {
                    return true;
                }
                return this.b;
            }
        }
        return false;
    }

    public final boolean a(boolean z) {
        if (z == this.b) {
            return false;
        }
        this.b = z;
        return true;
    }
}

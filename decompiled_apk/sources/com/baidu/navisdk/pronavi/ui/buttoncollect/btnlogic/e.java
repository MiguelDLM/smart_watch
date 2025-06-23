package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class e extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a {
    private boolean b;

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
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNormalHDBtnLogic", "onClicked: not hasCalcRouteOk");
            }
            return false;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1340", "1", "2");
        com.baidu.navisdk.pronavi.hd.normal.i.a c = com.baidu.navisdk.ui.routeguide.utils.b.c(false);
        if (c == null) {
            return true;
        }
        c.a(2);
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b
    public boolean a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNormalHDBtnLogic", "visibility: not hasCalcRouteOk");
            }
            return false;
        }
        a0 I = a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (I.D()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGNormalHDBtnLogic", "visibility: isYawing");
            }
            return false;
        }
        if (bVar == null || !bVar.c(RGFSMTable.FsmState.BrowseMap)) {
            return this.b;
        }
        return false;
    }

    public final void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHDBtnLogic", "updateState: " + z);
        }
        this.b = z;
    }
}

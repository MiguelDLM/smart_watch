package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import android.view.View;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.y;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class j extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a {

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
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a
    public void g() {
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b
    public boolean a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        if (!com.baidu.navisdk.function.b.FUNC_SCENIC_SETTING.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGScenicBroadcastBtnLogic", "visibility: FUNC_SCENIC_SETTING not enable");
            }
            return false;
        }
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        if (!bNCommSettingManager.isScenicBroadcastOpen()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGScenicBroadcastBtnLogic", "visibility: not isScenicBroadcastOpen");
            }
            return false;
        }
        if (TextUtils.isEmpty(y.c())) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGScenicBroadcastBtnLogic", "visibility: no content");
            }
            return false;
        }
        com.baidu.navisdk.ui.routeguide.asr.c n = com.baidu.navisdk.ui.routeguide.asr.c.n();
        IIX0o.oO(n, "RGAsrProxy.getInstance()");
        if (n.i()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RGScenicBroadcastBtnLogic", "visibility: isWakeUp");
            }
            return false;
        }
        a0 I = a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (I.D()) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("RGScenicBroadcastBtnLogic", "visibility: isYawing");
            }
            return false;
        }
        if (bVar != null && bVar.c(RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.EnlargeRoadmap)) {
            return false;
        }
        if (bVar == null || !bVar.A()) {
            return bVar == null || !bVar.z();
        }
        com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar6.d()) {
            gVar6.e("RGScenicBroadcastBtnLogic", "visibility: isHDNavi");
        }
        return false;
    }
}

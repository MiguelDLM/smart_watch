package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public final class c implements com.baidu.navisdk.module.pronavi.abs.b, com.baidu.navisdk.framework.interfaces.e {
    private void b(boolean z) {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.k a2 = i.g().a(1006);
        if (z && (a2 instanceof com.baidu.navisdk.ui.routeguide.mapmode.subview.d)) {
            ((com.baidu.navisdk.ui.routeguide.mapmode.subview.d) a2).p();
        } else {
            i.g().b(1006);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.e
    public void a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RG3DCarLogoPanelControl", "onClickCancel: " + z);
        }
        b(z);
    }

    public void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RG3DCarLogoPanelControl", "onClickCarLogo: " + com.baidu.navisdk.module.cloudconfig.f.c().s.d);
        }
        if (com.baidu.navisdk.module.cloudconfig.f.c().s.d && com.baidu.navisdk.function.b.FUNC_CAR_LOGO_3D_SELECT.a()) {
            if (RouteGuideFSM.getInstance().getCurrentState().equals(RGFSMTable.FsmState.EnlargeRoadmap)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RG3DCarLogoPanelControl", "onClickCarLogo is RGFSMTable.FsmState.EnlargeRoadmap");
                    return;
                }
                return;
            }
            if (s.T().l(127)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RG3DCarLogoPanelControl", "showPanel: is show TYPE_3D_CAR_LOGO_RECOMMEND");
                    return;
                }
                return;
            }
            if (RouteGuideFSM.getInstance().getCurrentState().equals(RGFSMTable.FsmState.ArriveDest)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RG3DCarLogoPanelControl", "onClickCarLogo is RGFSMTable.FsmState.ArriveDest");
                }
            } else {
                if (com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RG3DCarLogoPanelControl", "onClickCarLogo isIndoorParkState");
                        return;
                    }
                    return;
                }
                com.baidu.navisdk.asr.d.B().a(1);
                com.baidu.navisdk.asr.d.B().c();
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().m();
                s.T().o();
                i.g().a(new com.baidu.navisdk.ui.routeguide.mapmode.subview.d(this));
                com.baidu.navisdk.util.statistic.userop.b.r().a("b.f.3", "0", null, null);
            }
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.e
    public boolean a(String str, String str2, String str3) {
        boolean z;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RG3DCarLogoPanelControl", "onClickChangeCarLogo(), filePath = " + str + " configName = " + str2 + " name = " + str3);
        }
        if (!com.baidu.navisdk.ui.routeguide.b.W()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RG3DCarLogoPanelControl", "onClickChangeCarLogo isNaviBegin: false ");
            }
            return false;
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
        com.baidu.navisdk.framework.interfaces.pronavi.h e = j != null ? j.e() : null;
        if (e != null) {
            z = e.a(str, str2);
        } else {
            z = BNMapController.getInstance().set3DCarLogoToMap(str, str2);
            if (z) {
                com.baidu.navisdk.module.pronavi.model.g.o().a(true);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().p(0);
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RG3DCarLogoPanelControl", "onClickChangeCarLogo result:" + z);
        }
        if (z) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.ui.routeguide.b.V().c(), JarUtils.getResources().getString(R.string.nsdk_3d_car_logo_used, str3));
        }
        return z;
    }

    @Override // com.baidu.navisdk.framework.interfaces.e
    public void b() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RG3DCarLogoPanelControl", "onClickMore: ");
        }
        b(false);
        com.baidu.navisdk.ui.routeguide.b.V().c(false);
        com.baidu.navisdk.ui.routeguide.b.V().k().e();
    }

    @Override // com.baidu.navisdk.framework.interfaces.e
    public boolean a() {
        return com.baidu.navisdk.ui.util.b.b();
    }
}

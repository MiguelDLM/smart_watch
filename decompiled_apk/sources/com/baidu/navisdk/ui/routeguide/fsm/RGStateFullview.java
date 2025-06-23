package com.baidu.navisdk.ui.routeguide.fsm;

import android.graphics.Rect;
import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.j;
import com.baidu.navisdk.module.pronavi.model.h;
import com.baidu.navisdk.pronavi.data.model.e;
import com.baidu.navisdk.ui.routeguide.b;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import com.baidu.nplatform.comapi.map.l;

/* loaded from: classes8.dex */
public class RGStateFullview extends RGGlassState {
    private static final String TAG = "RGStateFullview";

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void enter() {
        super.enter();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void excute(Bundle bundle) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "excute by reflection");
        }
        com.baidu.navisdk.ui.routeguide.model.g.h().c(true);
        super.excute(bundle);
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void exit() {
        super.exit();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionLayers() {
        BNRouteGuider.getInstance().setBrowseStatus(RouteGuideFSM.getInstance().isBrowseState());
        if (this.enterParams != null && b.V().D() && this.enterParams.getInt("key_type_show_views", 0) != 6) {
            BNMapController.getDynamicOverlay().hideAll(BNDynamicOverlay.Key.ROUTE_AROUND_NE_CS_BUBBLE);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionMapStatus() {
        e eVar;
        int V;
        int i;
        int dip2px;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        int dip2px2;
        int i5;
        int i6;
        if (!com.baidu.navisdk.ui.routeguide.model.g.h().e()) {
            BNRouteGuider.getInstance().SetFullViewState(true);
            a.a().d(new l(true));
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "onActionMapStatus SetFullViewState true");
            }
        }
        if (com.baidu.navisdk.ui.routeguide.model.g.h().a()) {
            com.baidu.navisdk.ui.routeguide.control.b.k().a(RouteGuideFSM.getInstance().isBrowseState());
            com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
            int d = aVar.d();
            if (1 == h.f7469a) {
                if (b.V().E()) {
                    d = aVar.d() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u);
                }
                if (!x.b().f2() && !x.b().N2()) {
                    if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                        i4 = com.baidu.navisdk.module.newguide.a.e().c();
                    } else {
                        i4 = ScreenUtil.getInstance().dip2px(52);
                    }
                } else {
                    i4 = com.baidu.navisdk.module.newguide.a.e().c();
                }
                if (b.V().E()) {
                    i4 -= ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u);
                }
                V = 10;
                i = aVar.e() - 10;
                if (com.baidu.navisdk.ui.routeguide.model.x.A().f8982a) {
                    dip2px2 = ScreenUtil.getInstance().dip2px(138);
                } else if (RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getTopState())) {
                    i4 += ScreenUtil.getInstance().dip2px(60);
                    dip2px2 = ScreenUtil.getInstance().dip2px(160);
                } else {
                    dip2px2 = ScreenUtil.getInstance().dip2px(72);
                }
                i2 = d - dip2px2;
                if (!j.d()) {
                    int[] professionalNaviRouteMargin = BNSettingManager.getProfessionalNaviRouteMargin();
                    g gVar2 = g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e("RGStateFullView", "left = " + professionalNaviRouteMargin[0] + ", top = " + professionalNaviRouteMargin[1] + ", right = " + professionalNaviRouteMargin[2] + ", bottom = " + professionalNaviRouteMargin[3]);
                    }
                    int i7 = professionalNaviRouteMargin[0];
                    if (i7 != 0 && (i5 = professionalNaviRouteMargin[1]) != 0 && professionalNaviRouteMargin[2] != 0 && professionalNaviRouteMargin[3] != 0) {
                        i = aVar.e() - professionalNaviRouteMargin[2];
                        if (com.baidu.navisdk.ui.routeguide.model.x.A().f8982a) {
                            i6 = professionalNaviRouteMargin[3] + ScreenUtil.getInstance().dip2px(60);
                        } else {
                            i6 = professionalNaviRouteMargin[3];
                        }
                        i2 = d - i6;
                        i3 = d;
                        V = i7;
                        i4 = i5;
                    }
                }
                i3 = d;
            } else {
                if (b.V().E()) {
                    d = aVar.d() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t);
                }
                V = x.b().V() - ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t);
                i = d - 10;
                int e = aVar.e();
                if (com.baidu.navisdk.ui.routeguide.model.x.A().f8982a) {
                    dip2px = ScreenUtil.getInstance().dip2px(138);
                } else if (RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getTopState())) {
                    dip2px = ScreenUtil.getInstance().dip2px(160);
                } else {
                    dip2px = ScreenUtil.getInstance().dip2px(72);
                }
                i2 = e - dip2px;
                i3 = d;
                i4 = 20;
            }
            Rect rect = new Rect(V, i4, i, i2);
            if (1 == h.f7469a) {
                z = true;
            } else {
                z = false;
            }
            if (!com.baidu.navisdk.poisearch.model.a.k().h() || com.baidu.navisdk.poisearch.model.a.k().g() > 0) {
                if (com.baidu.navisdk.ui.routeguide.model.g.h().b && !b.V().E()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                BNMapController.getInstance().zoomToFullView(rect, z, i3, aVar.e(), z2);
            }
        }
        com.baidu.navisdk.ui.routeguide.model.g.h().b = true;
        com.baidu.navisdk.pronavi.ui.base.b uiContext = getUiContext();
        if (uiContext != null && (eVar = (e) uiContext.b(e.class)) != null) {
            eVar.a().setValue(RGFSMTable.FsmState.Fullview);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionNaviEngine() {
        com.baidu.navisdk.ui.routeguide.control.l.l().b();
    }

    @Override // com.baidu.navisdk.ui.routeguide.fsm.RGGlassState, com.baidu.navisdk.ui.routeguide.fsm.RGState
    public void onActionUI() {
        ProNaviStatItem.O().F();
        com.baidu.navisdk.ui.routeguide.model.g.h().b(3);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().a();
        x.b().s(8);
        if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.SimpleGuide) && !x.b().O2()) {
            x.b().I().c(true);
        }
        x.b().c();
        x.b().I().m();
        com.baidu.navisdk.framework.interfaces.locationshare.a j = c.p().j();
        if (j != null) {
            j.h();
        }
    }
}
